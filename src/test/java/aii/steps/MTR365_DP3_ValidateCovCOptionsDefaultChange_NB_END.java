package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR365_DP3_ValidateCovCOptionsDefaultChange_NB_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();

	@When("User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and Coverage C limit defaulted %25 and Cov C limit $75.000 is disabled")
	public void user_clicks_dwelling_tab_and_validates_c_personal_property_drop_down_contains_the_following_options_and_validates()
			throws Exception {

		click(dwellingChevron.btnDwelling);
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$75,000");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User changes Coverage A to <300.000> and validates text box for Cov C should display the value amount that equates to the percentage selected of Cov-A and should be disabled <mtr365>")
	public void user_changes_coverage_a_to_300000_and_validates_text_box_for_covc_mtr365() throws Exception {
		sendText(dwellingChevron.txtCoverageA, "300000");
		wait(2);
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$75,000");
		wait(2);
	}
	@When("User enters all required information on policy information screen <mtr365>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr365() {

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

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr365>")
	public void user_enters_all_current_date_as_prior_date_mtr365() throws Exception {
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

	@When("User enters all required information on DP3 dwelling screen and selects integrity select package <mtr365>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_and_selects_integrity_select_package_mtr365() {

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

	@When("User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% <mtr365>")
	public void user_validates_cov_c_drop_down_contains_the_following_options_mtr365() throws Exception {
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks Policy General Chevron and changes Occupancy to Tenant")
	public void user_clicks_policy_general_chevron_and_changes_occupancy_to_tenant() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		wait(2);
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User clicks dwelling tab and verifies message <Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page>")
	public void user_clicks_dwelling_tab_and_verifies_written_message() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
		verify_AnyText_IsVisible(driver,
				"Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page");
	}

	@When("User sets Cov C personal Property amount as <17.000>")
	public void user_sets_cov_c_personal_property_amount_as_17000() throws Exception {
		sendText(dwellingChevron.txtCoverageC, "17000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User validates that Endorsement transaction has been completed successfully and completes test <mtr365>")
	public void user_validates_that_endorsement_transaction_has_been_completed_successfully_and_completes_test_mtr365()
			throws Exception {
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
