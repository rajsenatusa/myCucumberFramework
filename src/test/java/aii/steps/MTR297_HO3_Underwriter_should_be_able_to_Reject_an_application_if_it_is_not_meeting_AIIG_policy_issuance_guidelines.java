package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR297_HO3_Underwriter_should_be_able_to_Reject_an_application_if_it_is_not_meeting_AIIG_policy_issuance_guidelines extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr297>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr297() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Emily");
		sendText(quote.txtLastName, "Watson");
		sendText(quote.txtBirthDate, "10/09/1989");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "18584 Tampa Rd");
		sendText(quote.txtZipCode, "33967");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO3 quote screen <mtr297>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr297() throws Exception {
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

	}

	@When("User enters all required information on HO3 dwelling screen <mtr297>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr297() {
		// Quote Dwelling information was filled here

		try {
			click(policyChevron.btnNext);
			wait(1);
			click(reviewChevron.btnDialogOk);
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			click(dwellingChevron.btnSave);
			wait(4);
		} catch (Exception e) {
			wait(1);
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			wait(1);
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			click(dwellingChevron.btnSave);
			wait(4);
		}
		sendText(dwellingChevron.txtCoverageA, "400,000");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr297>")
	public void user_completes_required_information_on_dwelling_chevron_mtr297() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtYearElectrical, "2012");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2012");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User takes note of the application for <mtr297>")
	public void user_takes_note_of_the_application__number_for_mtr297() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wait(2);
	}
	@When("User searches for the application <mtr297>")
	public void user_searches_application_for_mtr297() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates loss claim status labels are visible and attaches screenshot <mtr297>")
	public void user_validates_loss_claim_status_labels_are_visible_and_attaches_screenshot_mtr297() throws Exception {
		click(dwellingChevron.btnSave);
		wait(4);
		click(driver.findElement(By.id("Wizard_LossHistory")));
		wait(3);
		verifyAnyLossCauseClaimStatus(driver, "Smoke", "Open");
		verifyAnyLossCauseClaimStatus(driver, "Medical Payments", "Open");
		verifyAnyLossCauseClaimStatus(driver, "Theft", "Closed");
		attachScreenShot(driver);
	}
	@When("User clicks Dwelling Tab and updates construction year of the building <mtr297>")
	public void user_clicks_dwelling_tab_and_updateS_construction_year_of_the_building_mtr297() throws Exception {
		click(dwellingChevron.btnDwelling);
		sendText(dwellingChevron.txtYearConstruction, "2024");
		click(dwellingChevron.btnSave);
		wait(4);
	}
	@When("User clicks Policy Tab and validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible <mtr297>")
	public void user_clicks_policy_tab_and_validates_text_messages_are_visible_mtr297() throws Exception {
		click(policyChevron.btnTabPolicy);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(5);
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");
	}
	@And("User clicks Finalize button <mtr297>")
	public void User_clicks_Finalize_button_mtr297() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@When("User validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible <mtr297>")
	public void user__validates_text_messages_are_visible_mtr297() throws Exception {
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");
	}
	@Then("User validates 'Issue New Business' is not visible on closeout screen and completes test <mtr297>")
	public void user_validates_issue_new_business_is_not_visible_mtr297() throws Exception {
		verify_AnyText_NotVisible(driver, "Issue New Business");
		Hooks.scenario.log("Test Case Completed!");
	}
}
