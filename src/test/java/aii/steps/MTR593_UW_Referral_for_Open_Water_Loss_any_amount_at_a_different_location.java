package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR593_UW_Referral_for_Open_Water_Loss_any_amount_at_a_different_location extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr593>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr593() {

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

	@When("User enters all required information on HO3 quote screen <mtr593>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr593() throws Exception {
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

	@When("User enters all required information on HO3 dwelling screen <mtr593>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr593() {
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

	@When("User completes required information on dwelling chevron <mtr593>")
	public void user_completes_required_information_on_dwelling_chevron_mtr593() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtYearElectrical, "2019");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2019");
		sendText(dwellingChevron.txtHvacYearUpdate, "2019");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User takes note of the application for <mtr593>")
	public void user_takes_note_of_the_application__number_for_mtr593() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr593>")
	public void user_searches_application_for_mtr593() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates losses have been displayed and attaches screenshot <mtr593>")
	public void user_validates_loss_have_been_displayed_attaches_screenshot_mtr593() throws Exception {
		click(dwellingChevron.btnSave);
		wait(4);
		click(driver.findElement(By.id("Wizard_LossHistory")));
		wait(3);
		attachScreenShot(driver);
	}

	@When("User clicks Dwelling Tab and updates construction year of the building <mtr593>")
	public void user_clicks_dwelling_tab_and_updateS_construction_year_of_the_building_mtr593() throws Exception {
		click(dwellingChevron.btnDwelling);
		sendText(dwellingChevron.txtYearConstruction, "2024");
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr593>")
	public void user_clicks_dwelling_chevron_mtr593() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User navigates loss history chevron and validates loss claim status labels are visible and attaches screenshot <mtr593>")
	public void user_navigates_loss_history_chevron_and_validates_loss_claim_status_labels_mtr593() throws Exception {
		click(dwellingChevron.btnNext);
		wait(1);
		verifyAnyLossCauseClaimStatus(driver, "Water Damage", "Open");
		attachScreenShot(driver);
	}

	@When("User clicks policy tab and validates 'Risks with open losses are ineligible for coverage' message is visible <mtr593>")
	public void user_clicks_policy_tab_and_validates_text_messages_are_visible_mtr593() throws Exception {
		click(policyChevron.btnTabPolicy);
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");
	}

	@And("User clicks Finalize button <mtr593>")
	public void User_clicks_Finalize_button_mtr593() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@When("User validates 'Risks with open losses are ineligible for coverage' text is visible <mtr593>")
	public void user__validates_text_message_is_visible_mtr593() throws Exception {
		verify_AnyText_IsVisible(driver, "Risks with open losses are ineligible for coverage");
	}

	@When("User scrolls to preview output field and attaches screenshot <mtr593>")
	public void user_scrolls_to_preview_output_field_and_attaches_screenshot_mtr593() throws Exception {
		scrollToAnyField(driver, "Preview Output");
		attachScreenShot(driver);
	}

	@When("User issues policy and take note of the policy number <mtr593>")
	public void user_issues_policy_mtr593() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(1);
		click(closeoutChevron.btnIssueNB);
		wait(8);
		closeUnnecessaryTabs();
		getPolicyNumber(driver).toString();
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
	@When("User searches for the policy <mtr593>")
	public void user_searches_policy_for_mtr593() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks New Quote button")
	public void user_clicks_New_Quote_button() {
		click(historyChevron.btnNewQuote);
	}
	@When("User enters Eff Date state and starts new quote <mtr593>")
	public void user_enters_Eff_Date_state_and_starts_new_quote_mtr593() {
		sendText(holder.txtEffectiveDate, dtf.format(currentDate));
		selectDropdownText(holder.ddStateSelection, "Florida");
		click(holder.btnStartQuote);
		wait(1);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	@When("User enters all required information on HO3 quote screen with different address <mtr593>")
	public void user_enters_all_required_information_on_ho3_quote_screen_with_different_address_mtr593() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		sendText(quote.txtAddressNumber, "1163 Oak Bluff Dr");
		sendText(quote.txtPostalCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(1);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen with new address <mtr593>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_withnewaddress_mtr593() {
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
}
