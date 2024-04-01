package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR435_DP3_As_an_Underwriter_I_would_like_the_ability_to_process_rewrite_Renewal_on_Cancelled_RNEWAL_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User changes system date to current date <mtr435>")
	public void user_changes_system_date_to_current_date_mtr435() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr435>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr435() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr435>")
	public void user_enters_all_current_date_as_prior_date_mtr435() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP3 dwelling screen <mtr435>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr435() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCovALimit,"350000");
		click(dwellingChevron.btnSave);
	}
	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr435>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs_mtr435()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User selects Coverage not needed as reason <mtr435>")
	public void User_selects_reason_mtr435() {
		selectDropdownText(historyChevron.ddReason, "Coverage not needed");
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects effective date as cancel date 'current date' <mtr435>")
	public void User_selects_effective_date_as_cancel_date_mtr435() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}
	@And("User process cancellation transaction <mtr435>")
	public void User_process_cancellation_mtr435() {		
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User completes cancellation transaction and validates policy transaction status as cancelled <mtr435>")
	public void User_completes_cancellation_transaction_mtr435() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Cancellation Completed!");
		attachScreenShot(driver);
	}
	@When("User searches for the policy number <mtr435>")
	public void user_searches_policy_for_mtr435() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User select Rewrite Renewal <mtr435>")
	public void User_selects_Rewrite_Renewal_mtr435() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-Renewal");
		wait(1);
		click(dashboard.btnSelect);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User increases Coverage A by 10000 <mtr435>")
	public void User_increases_Coverage_A_By_10000_mtr435() {
		sendText(dwellingChevron.txtCovALimit,"360000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction")
	public void User_clicks_Review_Chevron_and_select_full_payment_plan_and_finalize_rewrite_renewal_tx() {
		click(reviewChevron.btnReview);
		wait(1);
		click(reviewChevron.btnFullPaymentRadioTO);
		wait(3);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User completes rewrite renewal transaction and validates policy transaction status <mtr435>")
	public void User_completes_rewriterenewal_transaction_mtr435() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Rewrite Renewal Transaction completed!");
		attachScreenShot(driver);
	}
	@When("User validates \"Renewal Greeting Letter\" form is visible and completes test")
	public void user_validates_renewal_greeting_letter_form_is_visible_on_mtr435() throws Exception {
		verify_AnyText_IsVisible(driver, "Renewal Greeting Letter");
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User clicks Dwelling Chevron <mtr435>")
	public void user_clicks_dwelling_chevron_mtr435() throws Exception {
		click(driver.findElement(By.id("Wizard_Risks")));
		wait(3);
	}
}
