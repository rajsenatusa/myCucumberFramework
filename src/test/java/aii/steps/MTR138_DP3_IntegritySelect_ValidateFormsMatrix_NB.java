package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR138_DP3_IntegritySelect_ValidateFormsMatrix_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NBPackage_Form;
	static String NBDec_Page;
	static String NBDec2_Page;
	static String NBGreeting_Version;
	static String NBGreeting_Data;
	static String NBPrivacy_Version1;
	static String NBPrivacy_Version;
	static String NBPrivacy_Data;
	static String NBPrivacy_Name;
	static String NBRoofLimitation_Version1;
	static String NBRoofLimitation_Version;
	static String NBRoofLimitation_Name;
	static String NBDed_Version1;
	static String NBDed_Version;
	static String NBDed_Name;
	static String NBAssignment_Version1;
	static String NBAssignment_Version;
	static String NBAssignment_Name;
	static String NBPolJacket_Version1;
	static String NBPolJacket_Version;
	static String NBPolJacket_Name;
	static String NBIDX_Version;
	static String NBIDX_Version1;
	static String NBIDX_Name;
	static String DP3Special_Version;
	static String PLiab_Version;
	static String PLiab_Name;
	static String SPProvision_Version;
	static String SPProvision_Version1;
	static String HurDed_Version;
	static String HurDed_Version1;
	static String HurDed_Name;
	static String Cyber_Version;
	static String Cyber_Name;
	static String HSPSL_Version;
	static String HSPSL_Version1;
	static String HSPSL_Name;
	static String NBIR_Version;
	static String NBIR_Name;
	static String Carpool_Version;
	static String Carpool_Version1;
	static String Carpool_Name;
	static String Theft_Version;
	static String Theft_Name;
	static String LimitedWater_Version;
	static String LimitedWater_Version1;
	static String LimitedWater_Name;
	static String Fungi_Version;
	static String Fungi_Version1;
	static String Loss_Version;
	static String Loss_Version1;
	static String Loss_Name;
	static String Ordinance_Version;
	static String Ordinance_Version1;
	static String Ordinance_Name;
	static String RCC_Version1;
	static String RCC_Name;
	static String Sinkhole_Version;
	static String Sinkhole_Version1;
	static String Sinkhole_Name;
	static String WDX_Version;
	static String WDX_Version1;
	static String WDX_Name;
	static String WBU_Version;
	static String WBU_Name;
	static String Outline_Version;
	static String Outline_Version1;
	static String Outline_Name;
	static String NBCheckList_Version;
	static String NBCheckList_Name;
	static String NBHurMitigation_Version;
	static String NBHurMitigation_Name;
	static String NBConsReport_Version;
	static String NBConsReport_Name;

	@When("User enters all required information on policy information screen <mtr138>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr138() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr138>")
	public void user_enters_all_current_date_as_prior_date_mtr138() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
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

	@When("User enters all required information on DP3 dwelling screen <mtr138> and selects integrity select and adds coverages")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr138_and_selects_integrity_select_and_adds_coverages() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.rbIntegritySelectPackage);
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddCovCLimit, "25%");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$300,000");
		selectDropdownText(dwellingChevron.ddHomeComputerLimit, "$7,000");
		selectDropdownText(dwellingChevron.ddLossAssesment, "$10,000");
		click(dwellingChevron.rbRefrigatedPersonalProperty);
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$50,000");
		click(dwellingChevron.rbPersonalInjury);
		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks Additional Interest Chevron")
	public void user_clicks_Additional_Interest_Chevron() {
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
	}

	@When("User clicks Add Additional Interest button")
	public void user_clicks_add_additional_interest_button() {
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
	}

	@And("User completes required information on add additional interests screen and add additional insured <mtr138>")
	public void User_completes_required_information_on_add_additional_interests_screen_mtr138() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10006");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Additional Interest");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User adds another Additional Interest")
	public void user_adds_another_additional_interest() throws Exception {
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10009");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Interest");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Additional Interest");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction for <mtr138>")
	public void user_finalizes_transaction_for_mtr138() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <mtr138>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_mtr138()
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
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Forms Chevron <mtr138>")
	public void user_clicks_forms_chevron_mtr138() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates all expected forms is visible on forms screen")
	public void user_validates_all_expected_forms_is_visible_on_forms_screen() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC NB GL 08 19");

		// AIIC PS 05 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form");
			wait(5);
		}

		// AIIC DP RWT 01 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage");
			wait(5);
		}

		// AIIC DP DO 06 23
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP DO 06 23')]"));
			Hooks.scenario.log("Form: Deductible Notification Options");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options");
			wait(5);
		}

		// AIIC AA 02 20
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC AA 02 20')]"));
			Hooks.scenario.log("Assignment Agreement Notice Form");
		} catch (Exception e) {
			Hooks.scenario.log("Assignment Agreement Notice Form");
			wait(5);
		}

		// AIIC PJ 05 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 05 19')]"));
			Hooks.scenario.log("Policy Jacket Form");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Jacket Form");
			wait(5);
		}

		// AIIC DP3 IDX 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP3 IDX 07 15')]"));
			Hooks.scenario.log("Dwelling Property 3 Special Form Index");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Property 3 Special Form Index");
			wait(5);
		}

		// DP 00 03 07 88
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'DP 00 03 07 88')]"));
			Hooks.scenario.log("Dwelling Property 3 - Basic Form");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Property 3 - Basic Form");
			wait(5);
		}

		// AIIC 01 DP3 SP 04 23
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC 01 DP3 SP 04 23')]"));
			Hooks.scenario.log("Special Provisions for Florida - DP 00 03 - Special Form Form");
		} catch (Exception e) {
			Hooks.scenario.log("Special Provisions for Florida - DP 00 03 - Special Form Form");
			wait(5);
		}

		// AIIC DP HD 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP HD 07 15')]"));
			Hooks.scenario.log("Calendar Year Hurricane Deductible Requirement");
		} catch (Exception e) {
			Hooks.scenario.log("Calendar Year Hurricane Deductible Requirement");
			wait(5);
		}

		// AIIC DP 04 75 11 20
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP 04 75 11 20')]"));
			Hooks.scenario.log("Actual Cash Value Loss Settlement - Windstorm or Hail Losses to Roof Surfacing Form");
		} catch (Exception e) {
			Hooks.scenario.log("Actual Cash Value Loss Settlement - Windstorm or Hail Losses to Roof Surfacing Form");
			wait(5);
		}

		// AIIC DP INSD 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP INSD 07 15')]"));
			Hooks.scenario.log("Additional Insured (Described Locations) Form");
		} catch (Exception e) {
			Hooks.scenario.log("Additional Insured (Described Locations) Form");
			wait(5);
		}

		// AIIC INST 11 14
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC INST 11 14')]"));
			Hooks.scenario.log("Additional Interest(s) Form");
		} catch (Exception e) {
			Hooks.scenario.log("Additional Interest(s) Form");
			wait(5);
		}

		// AIIC DP INSL 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP INSL 07 15')]"));
			Hooks.scenario.log("Additional Insured (Personal Liability) Form");
		} catch (Exception e) {
			Hooks.scenario.log("Additional Insured (Personal Liability) Form");
			wait(5);
		}

		// AIIC DP AL 11 21
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP AL 11 21')]"));
			Hooks.scenario.log("Animal Liability Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Animal Liability Coverage Form");
			wait(5);
		}

		// AIIC DP3 HC 09 21
		verify_AnyText_IsVisible(driver, "AIIC DP3 HC 09 21");

		// AIIC DP LFC 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP LFC 07 15')]"));
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC DP LA 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP OL 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP3 OO 04 23");
		verify_AnyText_IsVisible(driver, "AIIC DP3 PNJ 09 21");
		verify_AnyText_IsVisible(driver, "AIIC DP3 RP 09 21");
		verify_AnyText_IsVisible(driver, "AIIC DP3 WBU 09 21");

		// AIIC DP3 OC 12 18
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP3 OC 12 18')]"));
			Hooks.scenario.log("Outline of your Basic Dwelling Policy");
		} catch (Exception e) {
			Hooks.scenario.log("Outline of your Basic Dwelling Policy");
			wait(5);
		}

		// OIR B1 1670
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form");
			wait(5);
		}

		// OIR B1 1655
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form");
			wait(5);
		}

		// AIIC NCR 08 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
			wait(5);
		}
	}

	@When("User clicks Policy File Chevron <mtr138>")
	public void user_clicks_policy_file_chevron_mtr138() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks New Business Package Link and validates all expected forms listed in the package")
	public void user_clicks_new_business_package_link_and_validates_all_expected_forms_listed_in_the_package()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NBPackage_Form = PdfComparator.makePdf(driver, "NewBusinessPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);
		wait(10);

		// Declaration page Forms and endorsement section
		NBDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 10, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC NB GL 08 19Greeting Letter");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP PHN CSAU 06 22");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC AA 02 20Assignment Agreement Notice");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, NBDec_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP DPL 07 23"); // changed
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC 01 DP3 SP 04 23");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP HD 07 15");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP 04 75 11 20");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC INST 11 14");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP INSD 07 15");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP INSL 07 15");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP AL 11 21");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 HC 09 21");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 OO 04 23");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 PNJ 09 21");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 RP 09 21");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 WBU 09 21");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");

		NBDec2_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 11, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, NBDec2_Page, "OIR B1 1670Checklist of Coverage");
		PdfComparator.verifyFormData(driver, NBDec2_Page,
				"OIR B1 1655Notice of Premium Discounts for Hurricane Loss Mitigation");
		PdfComparator.verifyFormData(driver, NBDec2_Page, "AIIC NCR 08 19");
	}

	@When("User validates greeting letter form version as expected")
	public void user_validates_greeting_letter_form_version() throws Exception {
		NBGreeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, NBGreeting_Version, "AIIC NB GL 08 19");

		NBGreeting_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBGreeting_Data, "AIIC NB GL 08 19");
	}

	@When("User validates privacy statement form version")
	public void user_validates_privacy_statement_form_version() throws Exception {
		// Privacy statement
		NBPrivacy_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, NBPrivacy_Version1, "AIIC PS 05 19");
		NBPrivacy_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, NBPrivacy_Version, "AIIC PS 05 19");

		NBPrivacy_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Data, "AIIC PS 05 19");
		NBPrivacy_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Name, "PRIVACY STATEMENT");
	}

	@When("User validates roof limitation form version")
	public void user_validates_roof_limitation_form_version() throws Exception {
		NBRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 445, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version1, "AIIC DP RWT 01 19");
		NBRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 55, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version, "AIIC DP RWT 01 19");

		NBRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");
	}

	@When("User validates deductible notification form version")
	public void user_validates_deductible_notification_form_version() throws Exception {
		NBDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 450, 10, 250, 30);
		PdfComparator.verifyFormData(driver, NBDed_Version1, "AIIC DP DO 06 23");
		NBDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, NBDed_Version, "AIIC DP DO 06 23");

		NBDed_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDed_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");
	}

	@When("User validates assignment form version")
	public void user_validates_assignment_form_version() throws Exception {
		NBAssignment_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 490, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBAssignment_Version1, "AIIC AA 02 20");
		NBAssignment_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, NBAssignment_Version, "AIIC AA 02 20");

		NBAssignment_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBAssignment_Name, "ASSIGNMENT AGREEMENT NOTICE");
	}

	@When("User validates policy jacket form version")
	public void user_validates_policy_jacket_form_version() throws Exception {
		NBPolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 15, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version1, "AIIC PJ 05 19");
		NBPolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 15, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version, "AIIC PJ 05 19");

		NBPolJacket_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPolJacket_Name, "Policy Jacket");
	}

	@When("User validates AIIC DP3 IDX 07 15 form version")
	public void user_validates_AIICDP3IDX0715_form_version() throws Exception {
		NBIDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 16, 470, 35, 150, 50);
		PdfComparator.verifyFormData(driver, NBIDX_Version, "AIIC DP3 IDX 07 15");
		NBIDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 16, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, NBIDX_Version1, "AIIC DP3 IDX 07 15");

		NBIDX_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
	}

	@When("User validates DP 00 03 07 88 form version")
	public void user_validates_DP00030788_form_version() throws Exception {
		DP3Special_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 17, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, DP3Special_Version, "DP 00 03 07 88");
	}

	@When("User validates AIIC DP DPL 07 23 form version")
	public void user_validates_AIICDPDPL0715_form_version() throws Exception {
		PLiab_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 27, 440, 20, 120, 30);
		PdfComparator.verifyFormData(driver, PLiab_Version, "AIIC DP DPL 07 23");

		PLiab_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
	}

	@When("User validates AIIC 01 DP3 SP 04 23 form version")
	public void user_validates_AIIC01DP3SP0423_form_version() throws Exception {
		SPProvision_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 35, 440, 20, 120, 30);
		PdfComparator.verifyFormData(driver, SPProvision_Version, "AIIC 01 DP3 SP 04 23");
		SPProvision_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 36, 30, 760, 120,
				25);
		PdfComparator.verifyFormData(driver, SPProvision_Version1, "AIIC 01 DP3 SP 04 23");
	}

	@When("User validates AIIC DP HD 07 15 form version")
	public void user_validates_AIICDPHD0715_form_version() throws Exception {
		HurDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 50, 470, 25, 100, 40);
		PdfComparator.verifyFormData(driver, HurDed_Version, "AIIC DP HD 07 15");
		HurDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 50, 60, 740, 100, 40);
		PdfComparator.verifyFormData(driver, HurDed_Version1, "AIIC DP HD 07 15");

		HurDed_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, HurDed_Name, "CALENDAR YEAR HURRICANE DEDUCTIBLE");
	}

	@When("User validates actual cash value loss settlement form version")
	public void user_validates_actual_cash_value_loss_settlement_form_version() throws Exception {
		Cyber_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 52, 430, 25, 150, 100);
		PdfComparator.verifyFormData(driver, Cyber_Version, "AIIC DP 04 75 11 20");

		Cyber_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Cyber_Name, "ACTUAL CASH VALUE LOSS SETTLEMENT");
	}

	@When("User validates additional insured form version")
	public void user_validates_additional_insured_form_version() throws Exception {
		HSPSL_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 55, 440, 25, 120, 40);
		PdfComparator.verifyFormData(driver, HSPSL_Version, "AIIC DP INSD 07 15");
		HSPSL_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 55, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, HSPSL_Version1, "AIIC DP INSD 07 15");

		HSPSL_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, HSPSL_Name, "ADDITIONAL INSURED");
	}

	@When("User validates AIIC INST 11 14 form version")
	public void user_validates_AIICINST1114_form_version() throws Exception {
		NBIR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 56, 440, 30, 120, 40);
		PdfComparator.verifyFormData(driver, NBIR_Version, "AIIC INST 11 14");

		NBIR_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBIR_Name, "ADDITIONAL INTEREST(S)");
	}

	@When("User validates Limited Carport, Pool Cage and Screen Enclosure Coverage form version")
	public void user_validates_limited_carport_pool_screen_form_version() throws Exception {
		Carpool_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 57, 450, 25, 150, 40);
		PdfComparator.verifyFormData(driver, Carpool_Version, "AIIC DP INSL 07 15");
		Carpool_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 57, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Carpool_Version1, "AIIC DP INSL 07 15");

		Carpool_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Carpool_Name, "ADDITIONAL INSURED");
	}

	@When("User validates Animal Liability Coverage form version")
	public void user_validates_animal_liability_form_version() throws Exception {
		Theft_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 58, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Theft_Version, "AIIC DP AL 11 21");

		Theft_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Theft_Name, "ANIMAL LIABILITY COVERAGE");
	}

	@When("User validates Home Computer Coverage form version")
	public void user_validates_home_computer_form_version() throws Exception {
		LimitedWater_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 59, 455, 30, 120,
				40);
		PdfComparator.verifyFormData(driver, LimitedWater_Version, "AIIC DP3 HC 09 21");
		LimitedWater_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 59, 40, 735, 150,
				30);
		PdfComparator.verifyFormData(driver, LimitedWater_Version1, "AIIC DP3 HC 09 21");

		LimitedWater_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, LimitedWater_Name, "HOME COMPUTER COVERAGE");
	}

	@When("User validates AIIC DP LFC 07 15 form version")
	public void user_validates_AIICDPLFC0715_form_version() throws Exception {
		Fungi_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 61, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Fungi_Version, "AIIC DP LFC 07 15");
		Fungi_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 61, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Fungi_Version1, "AIIC DP LFC 07 15");
	}

	@When("User validates loss assessment form version")
	public void user_validates_loss_assessment_form_version() throws Exception {
		Loss_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 62, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Loss_Version, "AIIC DP LA 07 15");
		Loss_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 62, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Loss_Version1, "AIIC DP LA 07 15");

		Loss_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Loss_Name, "LOSS ASSESSMENT PROPERTY COVERAGE");
	}

	@When("User validates ordinance or law coverage form version")
	public void user_validates_ordinance_or_law_coverage_form_version() throws Exception {
		Ordinance_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 63, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Ordinance_Version, "AIIC DP OL 07 15");
		Ordinance_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 63, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Ordinance_Version1, "AIIC DP OL 07 15");

		Ordinance_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Ordinance_Name, "ORDINANCE OR LAW COVERAGE");
	}

	@When("User validates owner occupied endorsement form version")
	public void user_validates_owner_occupied_endorsement_form_version() throws Exception {
		RCC_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 64, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RCC_Version1, "AIIC DP3 OO 04 23");

		RCC_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, RCC_Name, "OWNER OCCUPIED ENDORSEMENT");
	}

	@When("User validates personal injury coverage form version")
	public void user_validates_personal_injury_coverage_form_version() throws Exception {
		Sinkhole_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 70, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Sinkhole_Version, "AIIC DP3 PNJ 09 21");
		Sinkhole_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 70, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Sinkhole_Version1, "AIIC DP3 PNJ 09 21");

		Sinkhole_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Sinkhole_Name, "PERSONAL INJURY COVERAGE");
	}

	@When("User validates refrigerated property coverage form version")
	public void user_validates_refrigerated_property_coverage_form_version() throws Exception {
		WDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 71, 450, 40, 120, 40);
		PdfComparator.verifyFormData(driver, WDX_Version, "AIIC DP3 RP 09 21");
		WDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 71, 40, 740, 150, 40);
		PdfComparator.verifyFormData(driver, WDX_Version1, "AIIC DP3 RP 09 21");

		WDX_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, WDX_Name, "REFRIGERATED PROPERTY COVERAGE");
	}

	@When("User validates water backup and sump discharge form version")
	public void user_validates_water_backup_and_sump_form_version() throws Exception {
		WBU_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 72, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, WBU_Version, "AIIC DP3 WBU 09 21");

		WBU_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, WBU_Name, "WATER BACK UP AND SUMP DISCHARGE OR OVERFLOW COVERAGE");
	}

	@When("User validates outline of your dwelling policy form version")
	public void user_validates_outline_of_your_dwelling_policy_form_version() throws Exception {
		Outline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 73, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Outline_Version, "AIIC DP3 OC 12 18");
		Outline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 73, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Outline_Version1, "AIIC DP3 OC 12 18");

		Outline_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Outline_Name, "OUTLINE OF YOUR DWELLING POLICY");
	}

	@When("User validates checklist form version")
	public void user_validates_checklist_form_version() throws Exception {
		NBCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 76, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, NBCheckList_Version, "OIR-B1-1670");

		NBCheckList_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBCheckList_Name, "Checklist of Coverage");
	}

	@When("User validates Notice Hurricane mitigation form version")
	public void user_validates_notice_hurricane_mitigation_form_version() throws Exception {
		NBHurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 79, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, NBHurMitigation_Version, "OIR-B1-1655");

		NBHurMitigation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");
	}

	@Then("User validates Consumer reports form version and completes test")
	public void user_validates_consumer_reports_form_version() throws Exception {
		NBConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 81, 30, 710, 100,
				30);
		PdfComparator.verifyFormData(driver, NBConsReport_Version, "AIIC NCR 08 19");

		NBConsReport_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBConsReport_Name, "Notice of Consumer Reports Ordered and Information");
		Hooks.scenario.log("Test Case Completed!");
	}

}
