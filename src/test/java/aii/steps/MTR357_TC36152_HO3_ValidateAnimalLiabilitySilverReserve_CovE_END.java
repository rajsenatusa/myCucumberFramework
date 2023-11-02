package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR357_TC36152_HO3_ValidateAnimalLiabilitySilverReserve_CovE_END extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String EndPackage_Form;
	static String Endpackage_Form_FnE1;

	@And("User changes system date to current date <mtr357>")
	public void User_changes_system_date_to_current_date_mtr357() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate));
	}

	@When("User enters all required information on policy information screen <mtr357>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr357() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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

	@When("User enters all required information on HO3 quote screen <mtr357>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr357() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-342-4532");
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

	@When("User enters all required information on HO3 dwelling screen <mtr357>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr357() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);

		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtCoverageA, "450000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		click(dwellingChevron.rbSilverReserve);
		selectDropdownText(dwellingChevron.ddCovELimit, "$500,000");
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$300,000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron <mtr357>")
	public void user_completes_required_information_on_dwelling_chevron_mtr357() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtYearElectrical, "2023");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <mtr357>")
	public void User_clicks_Finalize_button_mtr357() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr357>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr357()
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

	@When("User searches for the policy number <mtr357>")
	public void user_searches_policy_for_mtr357() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr357>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr357() throws Exception {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr357>")
	public void user_clicks_dwelling_chevron_mtr357() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User selects COV E personal liability as <300.000$>")
	public void user_selects_covE_personal_liability_as_300000() throws Exception {
		selectDropdownText(dwellingChevron.ddCovELimit, "$300,000");
		attachScreenShot(driver);
	}

	@When("User validates Animal Liability defaulted to <300.000$> and validates all possible dropdown options are visible")
	public void user_validates_animal_liability_defaulted_to_300000_and_validates_all_possible_dd_options_are_visible()
			throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.AnimalLiability", "$300,000");
		String AnimalLiabilities[] = { "None", "$50,000", "$100,000", "$200,000", "$300,000" };
		verifyAnyDropDownOptions(driver, AnimalLiabilities, "Building.AnimalLiability");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User validates Animal Liability Coverage is displayed on UI")
	public void user_validates_animal_liability_coverage_is_displayed_on_UI() throws Exception {
		try {
			driver.findElement(By.id("CoverageList_ANI_Description")).isDisplayed();
			Hooks.scenario.log("Animal Liability Coverage found");
		} catch (Exception e) {
			Hooks.scenario.log("Animal Liability Coverage not found");
			wait(5);
		}
		verify_AnyText_IsVisible(driver, "Animal Liability");
	}

	@And("User process and completes endorsement <mtr357>")
	public void User_process_and_completes_endorsement_mtr357() {
		click(closeoutChevron.btnEndorsePolicy);
		wait(10);
		closeUnnecessaryTabs();
	}

	@When("User clicks Policy File Chevron <mtr357>")
	public void user_clicks_policy_file_chevron_mtr357() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Endorsement Package link and validate form version <mtr357> and completes test")
	public void user_clicks_endorsement_package_link_and_validate_form_version_mtr357_and_completes_test()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&Filename");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(8);

		Endpackage_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 2, 40, 350, 530,
				320);
		PdfComparator.verifyFormData(driver, Endpackage_Form_FnE1, "AIIC HO AL 02 22Animal Liability Coverage");
		Hooks.scenario.log("Test Case Completed!");
	}
}
