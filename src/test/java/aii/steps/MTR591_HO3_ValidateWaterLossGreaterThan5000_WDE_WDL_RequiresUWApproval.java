package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR591_HO3_ValidateWaterLossGreaterThan5000_WDE_WDL_RequiresUWApproval extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr591>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr591() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "8802 Minnow Creek Dr");
		sendText(quote.txtZipCode, "32312");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO3 quote screen <mtr591>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr591() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
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

	@When("User enters all required information on HO3 dwelling screen <mtr591>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr591() {
		// Quote Dwelling information was filled here

		try {
			click(reviewChevron.btnDialogOk);
			selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			click(dwellingChevron.btnCalculate);
			wait(2);
			click(dwellingChevron.btnSave);
			wait(4);
		} catch (Exception e) {
			click(reviewChevron.btnDialogOk);
			selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			click(dwellingChevron.btnCalculate);
			wait(2);
			click(dwellingChevron.btnSave);
			wait(4);
		}
		sendText(dwellingChevron.txtCoverageA, "450,000");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "04");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(1);
	}

	@And("User validates 'Risk is ineligible due to age of HVAC' message has been displayed")
	public void user_validates_risk_ineligible_message_displayed() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of HVAC");
		attachScreenShot(driver);
	}

	@When("User completes required information on dwelling chevron <mtr591>")
	public void user_completes_required_information_on_dwelling_chevron_mtr591() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		sendText(dwellingChevron.txtYearElectrical, "2012");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2012");
		sendText(dwellingChevron.txtHvacYearUpdate, "2012");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User validates 'Due to loss history, water damage exclusion must be applied' message has been displayed")
	public void user_validates_water_damage_exclusion_message_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Due to loss history, water damage exclusion must be applied");
		attachScreenShot(driver);
	}

	@When("User clicks Dwelling Chevron <mtr591>")
	public void user_clicks_dwelling_chevron_mtr591() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User clicks check water damage exclusion and water damage limited")
	public void user_clicks_check_water_damage_exclusion_and_water_damage_limited() throws Exception {
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.rbWaterDamageLimited);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' message has been displayed")
	public void user_validates_due_to_loss_history_limited_water_message_displayed() throws Exception {
		verify_AnyText_IsVisible(driver,
				"Due to Loss History, Selection of Limited Water Requires Underwriting Approval");
	}

	@When("User deselects water damage exclusion and water damage limited")
	public void user_deselects_water_damage_exclusion_and_water_damage_limited() throws Exception {
		wait(2);
		scrollToElement(dwellingChevron.rbWaterDamageExcluded);
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User clicks Finalize button <mtr591>")
	public void User_clicks_Finalize_button_mtr591() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates 'Submit For Approval' button is not visible")
	public void User_validateS_submit_for_approval_button_is_not_visible() throws Exception {
		verify_AnyText_NotVisible(driver, "Submit For Approval");
	}

	@And("User clicks modify application and clicks check water damage exclusion and water damage limited")
	public void User_clicks_modify_application_and_clicks_check_water_damage_exclusion_and_water_damage_limited()
			throws Exception {
		click(closeoutChevron.btnModifyApplication);
		wait(3);
		click(dwellingChevron.btnDwelling);
		wait(2);
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.rbWaterDamageLimited);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User clicks Loss History Chevron and validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' text has been displayed")
	public void User_clicks_loss_history_chevron_and_validates_message() throws Exception {
		click(driver.findElement(By.id("Wizard_LossHistory")));
		wait(1);
		verify_AnyText_IsVisible(driver,
				"Due to Loss History, Selection of Limited Water Requires Underwriting Approval");
		attachScreenShot(driver);
	}

	@When("User takes note of the application for <mtr591>")
	public void user_takes_note_of_the_application__number_for_mtr591() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User validates labels on closeout screen with expected ones")
	public void User_validates_labels_on_closeout_screen_with_expected_ones() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Due to Loss History, Selection of Limited Water Requires Underwriting Approval");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyText_NotVisible(driver, "Issue New Business");
	}

	@When("User searches for the application <mtr591>")
	public void user_searches_application_for_mtr591() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' label is visible")
	public void user_validates_due_to_loss_history_limited_water_label_displayed() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Due to Loss History, Selection of Limited Water Requires Underwriting Approval");
		scrollToAnyField(driver, "Preview Output");
		attachScreenShot(driver);
	}
	@When("User issues policy and completes test")
	public void user_issues_policy_and_completes_test() throws Exception {
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
