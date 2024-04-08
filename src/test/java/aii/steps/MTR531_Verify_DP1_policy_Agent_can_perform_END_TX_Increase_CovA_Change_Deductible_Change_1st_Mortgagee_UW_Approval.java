package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR531_Verify_DP1_policy_Agent_can_perform_END_TX_Increase_CovA_Change_Deductible_Change_1st_Mortgagee_UW_Approval extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr531>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr531() {

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
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr531>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr531() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <mtr531>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr531() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr531>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_mtr531()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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
	@When("User changes system date to current date <mtr531>")
	public void user_changes_system_date_to_current_date_mtr531() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User selects endorsement date as current date <mtr531>")
	public void user_selects_endorsement_date_as_current_date_mtr531() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User clicks Dwelling Chevron for <mtr531>")
	public void user_clicks_dwelling_chevron_mtr531() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User increases CovA, selects deductible all perils as 2500, select hurricane ded as 5 <mtr531>")
	public void user_increases_CovA_mtr531() throws Exception {
		sendText(dwellingChevron.CovALimit, "650000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "5%");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@And("User completes required information on add additional interests screen and add first mortgagee <mtr531>")
	public void User_completes_required_information_on_add_additional_interests_screen_mtr531() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10002");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(3);
		sendText(additionalinterest.txtLoanNumber, "123456");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "First Mortgagee");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@And("User checks application dwelling screen and finalizes transaction <mtr531>")
	public void user_checks_application_dwelling_and_finalizes_transaction_mtr531() {
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@And("User validates issue messages on buttons on closeout screen <mtr531>")
	public void user_validates_issue_messages_on_buttons_on_closeout_screen_mtr531() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "COV A change exceeding 10% Must be approved.");
		verify_AnyButton_IsVisible(driver, "Submit For Approval");
		verify_AnyButton_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application for <mtr531>")
	public void User_takes_note_of_the_application_for_mtr531() {
		click(reviewChevron.btnFinalize);
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval button for <mtr531>")
	public void user_clicks_submit_for_approval_button_for_mtr531() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		click(closeoutChevron.btnDialogOk);
		wait(3);
	}
	@When("User searches for the application <mtr531>")
	public void User_searches_for_the_application_mtr531() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates 'COV A change exceeding 10% Must be approved.' message displayed on issue tile <mtr531>")
	public void User_validates_COVA_change_exceeding_10_must_be_approved_message_displayed_on_issue_tile_mtr531() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "COV A change exceeding 10% Must be approved.");
	}
	@Then("User endorses policy and completes test <mtr531>")
	public void user_endorses_policy_and__completes_test_mtr531() {
		click(closeoutChevron.btnIssueNB);
		wait(9);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
