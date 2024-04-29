package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5845_TH1303_DP1_NB_Validate_Agent_requires_UW_approval_required_If_lapse_in_coverage_greater_than_zero_day_for_Owner_occupancy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr5845>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5845() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
		
	}
	@When("User enters all required information on DP1 quote screen with current date minus 1 day as prior policy date <mtr5845>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_minus1day_as_prior_policy_date_mtr5845() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate.minusDays(1)));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen and validates error message related to lapse in policy <mtr5845>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr5845() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Length of lapse is ineligible for this policy form: application may be submitted for exception review through SPIN by finalizing the application and submitting for approval.  ");
		click(policyChevron.btnNext);
		wait(3);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "350000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User validates error message 'Length of lapse is ineligible for this policy form: application may be submitted for exception review through SPIN by finalizing the application and submitting for approval' has been displayed <mtr5845>")
	public void user_validates_error_message_mtr5845() throws Exception {
		wait(3);
		verify_AnyText_IsVisible(driver, "Length of lapse is ineligible for this policy form: application may be submitted for exception review through SPIN by finalizing the application and submitting for approval.  ");
	}
	@When("User validates issue new business not visible and submit for approval button and lapse error message visible on closeout screen <mtr5845>")
	public void user_validates_issuenewbusinessbutton_not_visible_submit_approval_button_visible_on_closeout_screen_mtr5845() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Length of lapse is ineligible for this policy form: application may be submitted for exception review through SPIN by finalizing the application and submitting for approval. ");
		verify_AnyLabel_IsNotVisible(driver, "Issue New Business");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
	}
	@When("User takes note of the application number <mtr5845>")
	public void user_takes_note_of_the_application__number_mtr5845() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for application number <mtr5845>")
	public void user_searches_for_application_number_mtr5845() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@Then("User issues policy and completes test <mtr5845>")
	public void user_issues_policy_and_completes_test_mtr5845() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
