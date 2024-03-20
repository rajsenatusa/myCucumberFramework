package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR366_DP3_ValidateCovCOptionsDisplayWhenCoverageIsIntegritySelect_NotDisplayForBasic_NB_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();

	@When("User enters all required information on DP3 dwelling screen and selects integrity select package")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_and_selects_integrity_select_package() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.rbIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
	}
	@When("User enters all required information on policy information screen <mtr366>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr366() {

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
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr366>")
	public void user_enters_all_current_date_as_prior_date_mtr366() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on policy information screen <mtr363>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr363() {

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
	@And("User enters Producer Code <mtr363>")
	public void User_enters_Producer_Code_mtr363() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr363>")
	public void user_enters_all_current_date_as_prior_date_mtr363() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User validates Coverage C defaults to %25 on integrity select package")
	public void user_validates_coverage_c_defaults_to_25_on_integrity_select_package() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		wait(3);
	}

	@When("User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70%")
	public void user_validates_cov_c_drop_down_contains_the_following_options() throws Exception {
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User changes Coverage A to <300.000> and validates text box for Cov C should display the value amount that equates to the percentage selected of Cov-A and should be disabled")
	public void user_changes_coverage_a_to_300000_and_validates_text_box_for_covc() throws Exception {
		sendText(dwellingChevron.txtCoverageA, "300000");
		click(dwellingChevron.btnSave);
		wait(2);
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$75,000");
		wait(2);
		attachScreenShot(driver);
	}

	@When("User selects C-Personal Property <70%> and validates text box for C-Personal Property should display the value amount that equates to the <70%> percentage selected of Cov-A and should be disabled")
	public void user_selects_c_personal_property_70_and_clicks_save() throws Exception {
		selectDropdownText(dwellingChevron.ddCovCLimit, "70%");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		wait(2);
	}

	@When("User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled")
	public void user_clicks_dwelling_tab_and_validates_c_personal_property_drop_down_contains_the_following()
			throws Exception {
		click(dwellingChevron.btnDwelling);
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "70%");
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User clicks dwelling chevron and validates C-Personal Property defaults to <70%> and should display the value amount that equates to the <70%> percentage selected of Cov-A")
	public void user_clicks_dwelling_chevron_and_validates_c_personal_property_defaults_to_70_and_should_display()
			throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
		verifyAnyDisabledFieldsValue(driver, "Building.CovCLimitIncluded_text", "70%");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
	}

	@When("User clicks more button and starts transaction")
	public void user_clicks_more_button_and_starts_transaction() throws Exception {
		click(dwellingChevron.btnMore);
		click(dwellingChevron.btnStartTransaction);
		wait(3);
	}

	@When("User clicks Dwelling tab on endorsement level and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled")
	public void user_clicks_dwelling_tab_on_endorsement_level_and_validates_c_personal_property_drop_down_contains_the_following()
			throws Exception {

		click(dwellingChevron.btnDwelling);
		wait(4);
		String[] covC = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "70%");
		verifyAnyDropDownOptions(driver, covC, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		wait(3);
	}

	@When("User endorses policy to basic policy")
	public void user_endorses_policy_to_basic_policy() throws Exception {
		click(dwellingChevron.rbBasicPackage);
		Hooks.scenario.log("Basic Package selected");
		wait(2);
	}

	@When("User enters <170.000> for Coverage C value")
	public void user_enters_170000_for_coverage_c_value() throws Exception {
		sendText(dwellingChevron.txtPersonalPropertyC, "170000");
		click(dwellingChevron.btnSave);
	}

	@When("User finalizes transaction and completes endorsement")
	public void user_finalizes_transaction_and_completes_endorsement() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(10);
	}

	@Then("User validates that Endorsement transaction has been completed successfully and completes test <mtr366>")
	public void user_validates_that_endorsement_transaction_has_been_completed_successfully_and_completes_test_mtr366() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_2_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Endorsement")) {
			System.out.println("DP3 Endorsement has been processed successfully");

		} else {
			System.out.println("DP3 Endorsement has been failed!");

		}

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
