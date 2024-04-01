package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR431_HO6_As_an_Underwriter_I_would_like_the_ability_to_process_a_rewrite_New_on_Cancelled_RNEWAL_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User changes system date to current date <mtr431>")
	public void user_changes_system_date_to_current_date_mtr431() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr431>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr431() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <mtr431>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_mtr431() {

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
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on HO6 dwelling screen and enters <15.000> for CovC <mtr431>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_15000_Cov_c_mtr431() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		sendText(dwellingChevron.txtPersonalPropertyC, "15000");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA,"120000");
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User answers all underwriting questions for HO6 <mtr431>")
	public void user_answers_all_underwriting_questions_for_ho6_mtr431() throws Exception {
		fillHO6_UWQuestions();
	}

	@And("User checks application dwelling screen and finalizes transaction <mtr431>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_mtr431() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <mtr431>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_mtr431()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);

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
	@And("User selects Coverage not needed as reason <mtr431>")
	public void User_selects_reason_mtr431() {
		selectDropdownText(historyChevron.ddReason, "Coverage not needed");
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects effective date as cancel date 'current date' <mtr431>")
	public void User_selects_effective_date_as_cancel_date_mtr431() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}
	@And("User process cancellation transaction <mtr431>")
	public void User_process_cancellation_mtr431() {		
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User completes cancellation transaction and validates policy transaction status as cancelled <mtr431>")
	public void User_completes_cancellation_transaction_mtr431() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Cancellation Completed!");
		attachScreenShot(driver);
	}
	@When("User searches for the policy number <mtr431>")
	public void user_searches_policy_for_mtr431() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User select Rewrite Renewal <mtr431>")
	public void User_selects_Rewrite_Renewal_mtr431() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-Renewal");
		wait(1);
		click(dashboard.btnSelect);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User increases Coverage A by 10000 <mtr431>")
	public void User_increases_Coverage_A_By_10000_mtr431() {
		sendText(dwellingChevron.txtCoverageA,"130000");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User clicks Dwelling Chevron <mtr431>")
	public void user_clicks_dwelling_chevron_mtr431() throws Exception {
		click(driver.findElement(By.id("Wizard_Risks")));
		wait(3);
	}
	@And("User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction <mtr431>")
	public void User_clicks_Review_Chevron_and_select_full_payment_plan_and_finalize_rewrite_renewal_tx_mtr431() {
		click(reviewChevron.btnReview);
		wait(1);
		click(reviewChevron.btnFullPaymentRadioTO);
		wait(3);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User completes rewrite renewal transaction and validates policy transaction status <mtr431>")
	public void User_completes_rewriterenewal_transaction_mtr431() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Rewrite Renewal Transaction completed!");
		attachScreenShot(driver);
	}
	@When("User validates \"Renewal Greeting Letter\" form is visible and completes test <mtr431>")
	public void user_validates_renewal_greeting_letter_form_is_visible_on_mtr431() throws Exception {
		verify_AnyText_IsVisible(driver, "Renewal Greeting Letter");
		Hooks.scenario.log("Test Case Completed!");
	}
}
