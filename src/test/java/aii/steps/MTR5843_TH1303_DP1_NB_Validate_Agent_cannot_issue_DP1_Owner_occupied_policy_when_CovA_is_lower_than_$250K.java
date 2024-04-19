package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5843_TH1303_DP1_NB_Validate_Agent_cannot_issue_DP1_Owner_occupied_policy_when_CovA_is_lower_than_$250K extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr5843>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5843() {

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
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr5843>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr5843() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen and enters CoverageA is lower than 250k <mtr5843>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr5843() throws Exception {

//		sendText(dwellingChevron.txtYearConstruction, "2023");
//		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "249000");
		click(dwellingChevron.btnSave);
		// click(dwellingChevron.btnNext);
	}
	@When("User validates error message 'Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ' has been displayed <mtr5843>")
	public void user_enters_flood_covA_larger_than_dwellingCovA_and_validates_error_message() throws Exception {
		wait(3);
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Dwelling Chevron <mtr5843>")
	public void user_clicks_dwelling_chevron_mtr5843() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User takes note of the application number <mtr5843>")
	public void user_takes_note_of_the_application__number_mtr5843() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User validates issue new business and submit for approval buttons not visible on closeout screen <mtr5843>")
	public void user_validates_buttons_not_visible_on_closeout_screen_mtr5843() throws Exception {
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
		verify_AnyLabel_IsNotVisible(driver, "Issue New Business");
		verify_AnyLabel_IsNotVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User searches for application number <mtr5843>")
	public void user_searches_for_application_number_mtr5843() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates error message is visible and issue new business button is visible <mtr5843>")
	public void user_validates_error_message_is_visible_and_issue_nb_button_is_visible_mtr5843() throws Exception {
		wait(1);
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
		verify_AnyLabel_IsVisible(driver, "Issue New Business");
	}
	@Then("User issues policy and completes test <mtr5843>")
	public void user_issues_policy_and_completes_test_mtr5843() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
