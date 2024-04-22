package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5846_TH1303_DP1_NB_Validate_Agent_cannot_issue_DP1_Owner_occupied_policy_with_prior_water_losses_with_more_than_3_years extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr5846>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5846() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Maria");
		sendText(quote.txtLastName, "Yates");
		sendText(quote.txtBirthDate, "09/16/1952");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "3230 WILLOW OAK DR");
		sendText(quote.txtZipCode, "32141");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr5846>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr5846() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "4 to 8 Months");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen and enters CoverageA is higher than 1million and validate issue message <mtr5846>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr5846() throws Exception {

		clickOKDailogButton(driver);
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "1000001");
		click(dwellingChevron.btnSave);
		wait(4);
		verify_AnyfirstText_IsDisplayed(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Maximum which exceeds a maximum of $1,000,000 requires underwriting review] ");
		attachScreenShot(driver);
	}
	@When("User changes CoverageA to lower than 250k and validate issue message")
	public void user_changes_coverageA_to_lower_than_250k_and_validate_issue_message_mtr5846() throws Exception {

		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "249000");
		click(dwellingChevron.btnSave);
		wait(4);
		verify_AnyfirstText_IsDisplayed(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Dwelling Chevron <mtr5846>")
	public void user_clicks_dwelling_chevron_mtr5846() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User changes CoverageA larger than 250k and validates previous error message disappeared")
	public void user_changes_coverageA_to_larger_than_250k_and_validate_previousissue_message_disappeared_mtr5846() throws Exception {

		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "251000");
		click(dwellingChevron.btnSave);
		wait(4);
		verify_AnyfirstText_IsNOTDisplayed(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Loss History Chevron and validates prior losses displayed")
	public void user_clicks_Loss_History_chevron_and_validates_prior_losses_displayed() throws Exception {
		click(driver.findElement(By.id("Wizard_LossHistory")));
		wait(3);
		
		try {
			if (driver.findElement(By.id("Navigate_LossHistoryList_1")).isDisplayed()) {
				Hooks.scenario.log("Is visible:  Falling Objects - 11/09/2019");
			}
		} catch (Exception e) {
			Hooks.scenario.log("Is NOT visible:  Falling Objects - 11/09/2019");
			wait(5);
		}
		
		try {
			if (driver.findElement(By.id("Navigate_LossHistoryList_2")).isDisplayed()) {
				Hooks.scenario.log("Is visible: Sinkhole - 01/25/2020");
			}
		} catch (Exception e) {
			Hooks.scenario.log("Is NOT visible: Sinkhole - 01/25/2020");
			wait(5);
		}
		
		try {
			if (driver.findElement(By.id("Navigate_LossHistoryList_3")).isDisplayed()) {
				Hooks.scenario.log("Is visible:  Water Damage - 03/05/2020");
			}
		} catch (Exception e) {
			Hooks.scenario.log("Is NOT visible:  Water Damage - 03/05/2020");
			wait(5);
		}
		
		attachScreenShot(driver);
	}
	@When("User validates issue new business button Not visible, submit for approval button and loss history error message visible on closeout screen <mtr5846>")
	public void user_validates_loss_history_error_message_visible_on_closeout_screen_mtr5846() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required prior to binding due to loss history ");
		verify_AnyLabel_IsNotVisible(driver, "Issue New Business");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application number <mtr5846>")
	public void user_takes_note_of_the_application__number_mtr5846() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for application number <mtr5846>")
	public void user_searches_for_application_number_mtr5846() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@Then("User issues policy and completes test <mtr5846>")
	public void user_issues_policy_and_completes_test_mtr5846() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
