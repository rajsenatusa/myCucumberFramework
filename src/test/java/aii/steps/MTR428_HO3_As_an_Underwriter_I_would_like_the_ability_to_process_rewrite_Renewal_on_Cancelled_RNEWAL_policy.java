package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR428_HO3_As_an_Underwriter_I_would_like_the_ability_to_process_rewrite_Renewal_on_Cancelled_RNEWAL_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User changes system date to current date <mtr428>")
	public void user_changes_system_date_to_current_date_mtr428() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr428>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr428() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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
	@When("User enters all required information on HO3 quote screen <mtr428>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr428() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr428>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr428() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2024");
//		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr428>")
	public void user_completes_required_information_on_dwelling_chevron_mtr428() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr428>")
	public void User_clicks_Finalize_button_mtr428() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr428>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr428()
			throws Exception {

		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User selects Coverage not needed as reason <mtr428>")
	public void User_selects_reason_mtr428() {
		selectDropdownText(historyChevron.ddReason, "Coverage not needed");
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User selects effective date as cancel date 'current date' <mtr428>")
	public void User_selects_effective_date_as_cancel_date_mtr428() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}
	@And("User process cancellation transaction <mtr428>")
	public void User_process_cancellation_mtr428() {		
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User completes cancellation transaction and validates policy transaction status as cancelled <mtr428>")
	public void User_completes_cancellation_transaction_mtr428() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Cancellation Completed!");
		attachScreenShot(driver);
	}
	@When("User searches for the policy number <mtr428>")
	public void user_searches_policy_for_mtr428() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User select Rewrite Renewal <mtr428>")
	public void User_selects_Rewrite_Renewal_mtr428() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-Renewal");
		wait(1);
		click(dashboard.btnSelect);
		click(dashboard.btnStart);
		wait(3);
	}
	@When("User clicks Dwelling Chevron <mtr428>")
	public void user_clicks_dwelling_chevron_mtr428() throws Exception {
		click(driver.findElement(By.id("Wizard_Risks")));
		wait(3);
	}
	@When("User clicks Policy File Chevron <mtr428>")
	public void user_clicks_policy_file_chevronmtr428() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User increases Coverage A by 10000 <mtr428>")
	public void User_increases_Coverage_A_By_10000_mtr428() {
		sendText(dwellingChevron.txtCoverageA, "410000");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction <mtr428>")
	public void User_clicks_Review_Chevron_and_select_full_payment_plan_and_finalize_rewrite_renewal_tx_mtr428() {
		click(reviewChevron.btnReview);
		wait(1);
		click(reviewChevron.btnFullPaymentRadioTO);
		wait(3);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User completes rewrite renewal transaction and validates policy transaction status <mtr428>")
	public void User_completes_rewriterenewal_transaction_mtr428() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Rewrite Renewal Transaction completed!");
		attachScreenShot(driver);
	}
	@When("User validates \"Renewal Declaration\" form is visible and completes test <mtr428>")
	public void user_validates_renewal_dec_form_is_visible_on_mtr428() throws Exception {
		verify_AnyLink_IsVisible(driver, "Renewal Declaration");
		Hooks.scenario.log("Test Case Completed!");
	}
}
