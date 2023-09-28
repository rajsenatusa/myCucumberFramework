package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR3171_DP1_ValidateAgentCannotIssuePolicyWhenFloodCovAGreaterThanDwellingCovA_NB extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr3171>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr3171() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
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
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr3171>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr3171() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <mtr3171>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr3171() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "300000");
		click(dwellingChevron.btnSave);
		//click(dwellingChevron.btnNext);
	}
	@When("User enters Flood CovA larger than Dwelling CovA and validates error message")
	public void user_enters_flood_covA_larger_than_dwellingCovA_and_validates_error_message() throws Exception {
		selectDropdownText(dwellingChevron.ddFloodCoverage, "Yes");
		wait(8);
		dwellingChevron.txtFloodDwellingCovA.clear();
		setFloodCoverage_ADwelling(driver, "320,000");
		selectDropdownText(dwellingChevron.ddFloodFoundationType, "Slab");
		selectDropdownText(dwellingChevron.ddFloodZoneOverride, "X");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Flood Coverage A cannot be greater than Dwelling Coverage A");
	}
	@When("User enters Flood CovA smaller than Dwelling CovA and validates no error message displayed")
	public void user_enters_flood_covA_smaller_than_dwellingCovA_and_validates_no_error_message_displayed() throws Exception {
		dwellingChevron.txtFloodDwellingCovA.clear();
		setFloodCoverage_ADwelling(driver, "299,000");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Flood Coverage A cannot be greater than Dwelling Coverage A");
		click(dwellingChevron.btnNext);
	}
	@When("User enters Flood CovA larger than Dwelling CovA and validates error message displayed")
	public void user_enters_flood_covA_larger_than_dwellingCovA_and_validates__error_message_displayed() throws Exception {
		dwellingChevron.txtFloodDwellingCovA.clear();
		setFloodCoverage_ADwelling(driver, "320,000");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Flood Coverage A cannot be greater than Dwelling Coverage A");
	}
	@When("User validates error message displayed on closeout screen")
	public void user_validates_error_message_displayed_on_closeout_screen() throws Exception {
		
		verify_AnyText_IsVisible(driver, "Flood Coverage A cannot be greater than Dwelling Coverage A");

		verify_AnyText_NotVisible(driver, "Submit For Approval");
		verify_AnyText_NotVisible(driver, "Issue New Business");
	}
	@When("User takes note of the application number <mtr3171>")
	public void user_takes_note_of_the_application__number_mtr3171() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for application number <mtr3171>")
	public void user_searches_for_application_number_mtr3171() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates 'Flood Coverage A cannot be greater than Dwelling Coverage A' message displayed")
	public void user_validates_flood_cova_cannot_be_greater_than_dwellingCoverageA_message_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Flood Coverage A cannot be greater than Dwelling Coverage A");
	}
	@Then("User issues policy and completes test <mtr3171>")
	public void user_issues_policy_and_completes_test_mtr3171() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		waitImp(8);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User clicks Dwelling Chevron <mtr3171>")
	public void user_clicks_dwelling_chevron_mtr3171() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
}
