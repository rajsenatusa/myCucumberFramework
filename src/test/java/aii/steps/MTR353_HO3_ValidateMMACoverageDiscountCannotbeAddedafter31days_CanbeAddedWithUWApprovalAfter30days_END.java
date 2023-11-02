package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR353_HO3_ValidateMMACoverageDiscountCannotbeAddedafter31days_CanbeAddedWithUWApprovalAfter30days_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr353>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr353() {

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

	@When("User enters all required information on HO3 quote screen <mtr353>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr353() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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

	@When("User enters all required information on HO3 dwelling screen <mtr353>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr353() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		click(dwellingChevron.rbBasicPackage);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron <mtr353>")
	public void user_completes_required_information_on_dwelling_chevron_mtr353() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		sendText(dwellingChevron.txtYearElectrical, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User finalizes transaction for VOL HO3 <mtr353>")
	public void user_finalizes_transaction_for_VOL_HO3_mtr353() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr353>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr353()
			throws Exception {

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

	@When("User searches for the policy number <mtr353>")
	public void user_searches_policy_for_mtr353() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 31 days and starts endorsement <mtr353>")
	public void User_sets_new_effective_date_as_current_date_plus_31_days_and_starts_endorsement_mtr353() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(31)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr353>")
	public void user_clicks_dwelling_chevron_mtr353() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates MMA Index is disabled")
	public void user_validates_MMA_index_is_disabled() throws Exception {
		verifyAnyTextbox_EnabledDisabled(driver, "Building.MediationArbitrationInd_text");
		scrollToAnyField(driver, "Mandatory Mediation Arbitration*");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User clicks Finalize button <mtr353>")
	public void User_clicks_Finalize_button_mtr353() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User clicks Modify Application and cancels transaction")
	public void User_clicks_modify_application_and_cancels_transaction() {
		click(closeoutChevron.btnModifyApplication);
		wait(2);
		click(dashboard.btnDelete);
		click(closeoutChevron.btnDialogOk);
		wait(4);
	}

	@And("User sets new effective date as current date plus 30 days and starts endorsement <mtr353>")
	public void User_sets_new_effective_date_as_current_date_plus_30_days_and_starts_endorsement_mtr353() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User sets Mediation Arbitration as Yes")
	public void User_sets_mediation_arbitration_as_yes() {
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User validates 'Mediation Arbitration Change requires Underwriting Approval' text is visible")
	public void User_validates_mma_requires_underwriting_approval_text_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Mediation Arbitration Change requires Underwriting Approval");
	}

	@When("User takes note of the application for <mtr353>")
	public void user_takes_note_of_the_application__number_for_mtr353() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr353>")
	public void user_searches_application_for_mtr353() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User process and completes endorsement and finishes test <mtr353>")
	public void user_process_and_completes_endorsement_and_finishes_test_mtr353() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
