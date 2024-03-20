package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR537_DP3_IntegritySelect_ValidateOwnerOccupiedEndorsementTextBuilder_NB_END extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on DP3 dwelling screen and validates New Line Item Displays Package Basic Policy and Integrity Select with Radio buttons display on the Dwelling Detail tile")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_and_validates_new_line_item_displays_package()
			throws Exception {

		//sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		verifyAnyElement_Enabled(driver, "Building.PackageCoverageInd_2");
		click(dwellingChevron.rbIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");

	}
	@When("User enters all required information on policy information screen <mtr537>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr537() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
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
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr537>")
	public void user_enters_all_current_date_as_prior_date_mtr537() throws Exception {
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
	@When("User selects Integrity Select Package")
	public void user_selects_integrity_select_package() throws Exception {

		click(dwellingChevron.rbIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
		wait(3);
		click(dwellingChevron.btnSave);
	}

	@When("User sets CoverageA <400.000> and validates Cov-C defaults to <25%> Home Computer defaults to <$2,500> L-Personal Liability defaults to <$100,000>")
	public void user_sets_coveragea_400000_and_validates_covc_defaults_to_25_homecomputer() throws Exception {

		sendText(dwellingChevron.txtCovALimit, "400000");
		click(dwellingChevron.btnSave);
		wait(3);
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		verifyAnyDropdownDefaultedValue(driver, "Building.CovLLimit", "$100,000");
		verifyAnyDropdownDefaultedValue(driver, "Building.CovHCCLimit", "$2,500");
		wait(2);
	}

	@When("User navigates back to Policy General and changes the occupancy to Tenant")
	public void user_navigates_back_to_policy_general_and_changes_the_occupancy_to_tenant() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		wait(3);
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
//		selectDropdownText(policyChevron.ddShortTermRental, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User validates <Occupancy has been updated which would impact the prior coverages selected> is displayed")
	public void user_validates_text_message_is_displayed() throws Exception {
		verify_AnyText_IsVisible(driver,
				"Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page");

	}

	@When("User validates Cov C will be updated to <$0> where the user will need to update, Home Computer defaults to <None>, L-Personal Liability defaults to <$0>")
	public void user_validates_cov_c_will_be_updated_to_0_where_the_user_will_need_to() throws Exception {
		verifyAnyElement_Disabled(driver, "Building.PackageCoverageInd_2");
		verifyAnyTextboxAttributeValue(driver, "Building.CovCLimit", "$0");
		verifyAnyDropdownDefaultedValue(driver, "Building.CovLLimit", "$0");
		verifyAnyDropdownDefaultedValue(driver, "Building.CovHCCLimit", "None");
	}

	@When("User navigates back to Policy General and changes the occupancy to Owner")
	public void user_navigates_back_to_policy_general_and_changes_the_occupancy_to_owner() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(3);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User finalizes transaction and issues policy for DP3")
	public void user_finalizes_transaction_and_issues_policy_for_dp3() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(4);
		selectDropdownText(reviewChevron.ddPaymentType, "None");
		click(reviewChevron.btnProcess);
		wait(4);
	}

	@When("User clicks Dwelling Chevron and Coverage added: Animal Liability, Coverage Modified: C - Personal Property Limit Changed From $200,000 to $100,000, Coverage Modified: L - Personal Liability Limit Changed From $100,000 to $300,000, Coverage Modified: Home Computer Limit Changed From $2,500 to $7,000")
	public void user_clicks_dwelling_chevron_and_coverage_added_Animal() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(5);
		selectDropdownText(dwellingChevron.ddCovCLimit, "20%");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$300,000");
		selectDropdownText(dwellingChevron.ddHomeComputerLimit, "$7,000");
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$50,000");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(5);
	}

	@When("User finalizes transaction and verifies added coverage texts have been displayed on closeout screen")
	public void user_finalizes_transaction_and_verifies_added_coverage_texts_have_been_displayed_on_closeout()
			throws Exception {
		click(reviewChevron.btnFinalize);
		wait(5);
		verify_AnyText_IsVisible(driver, "Coverage added: Animal Liability");
		verify_AnyText_IsVisible(driver,
				"Coverage Modified: C - Personal Property Limit 1 Changed From $100,000 to $80,000");
		verify_AnyText_IsVisible(driver,
				"Coverage Modified: L - Personal Liability Limit 1 Changed From $100,000 to $300,000");
		verify_AnyText_IsVisible(driver, "Coverage Modified: Home Computer Limit 1 Changed From $2,500 to $7,000");
	}

	@When("User endorses policy")
	public void user_endorses_policy() throws Exception {
		click(reviewChevron.btnProcess);
		wait(12);

		closeUnnecessaryTabs();
	}
	@When("User expands  endorsement on transaction history tab and verifies changes made")
	public void user_expands_endorsement_on_transaction_history_Tab() throws Exception {
		click(historyChevron.btnExpand);
		wait(4);
		verify_AnyLabel_IsVisible(driver, "Coverage added: Animal Liability");
		verify_AnyLabel_IsVisible(driver,
				"Coverage Modified: C - Personal Property Limit 1 Changed From $100,000 to $80,000");
		verify_AnyLabel_IsVisible(driver,
				"Coverage Modified: L - Personal Liability Limit 1 Changed From $100,000 to $300,000");
		verify_AnyLabel_IsVisible(driver, "Coverage Modified: Home Computer Limit 1 Changed From $2,500 to $7,000");
		Hooks.scenario.log("Test Case Completed!");
	}
}
