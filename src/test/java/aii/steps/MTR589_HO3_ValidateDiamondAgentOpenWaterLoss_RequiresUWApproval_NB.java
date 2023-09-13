package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR589_HO3_ValidateDiamondAgentOpenWaterLoss_RequiresUWApproval_NB extends CommonMethods{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr589>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr589() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Michelle");
		sendText(quote.txtLastName, "Saunders");
		sendText(quote.txtBirthDate, "10/05/1984");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "506 Shepard Ave");
		sendText(quote.txtZipCode, "33838");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO3 quote screen <mtr589>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr589() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen <mtr589>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr589() {
		// Quote Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2019");
		
		try {
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			click(reviewChevron.btnDialogOk);
			
		} catch (Exception e) {
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		}
		sendText(dwellingChevron.txtCoverageA, "400,000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr589>")
	public void user_completes_required_information_on_dwelling_chevron_mtr589() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtYearElectrical, "2019");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2019");
		sendText(dwellingChevron.txtHvacYearUpdate, "2019");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User clicks policy tab and validates 'Risks with open losses are ineligible for coverage' message is visible")
	public void user_clicks_policy_tab_and_validates_text_messages_are_visible_mtr598() throws Exception {
		click(policyChevron.btnTabPolicy);
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");
	}
	@When("User clicks Dwelling Chevron <mtr589>")
	public void user_clicks_dwelling_chevron_mtr589() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User navigates loss history chevron and validates loss claim status labels are visible and attaches screenshot")
	public void user_navigates_loss_history_chevron_and_validates_loss_claim_status_labels() throws Exception {
		click(dwellingChevron.btnNext);
		wait(1);
		verifyAnyLossCauseClaimStatus(driver, "Water Damage", "Open");
		attachScreenShot(driver);
	}
	@When("User takes note of the application for <mtr589>")
	public void user_takes_note_of_the_application__number_for_mtr589() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User clicks Finalize button <mtr589>")
	public void User_clicks_Finalize_button_mtr589() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@When("User validates 'Risks with open losses are ineligible for coverage' text is visible")
	public void user__validates_text_message_is_visible_mtr589() throws Exception {
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");	
	}
	@When("User searches for the application <mtr589>")
	public void user_searches_application_for_mtr589() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User scrolls to preview output field and attaches screenshot <mtr589>")
	public void user_scrolls_to_preview_output_field_and_attaches_screenshot_mtr589() throws Exception {
		scrollToAnyField(driver, "Preview Output");
		attachScreenShot(driver);
	}
	@When("User issues policy and completes test <mtr589>")
	public void user_issues_policy_and_completes_test_mtr589() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(1);
		click(closeoutChevron.btnIssueNB);
		wait(8);
		closeUnnecessaryTabs();
		getPolicyNumber(driver).toString();
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
