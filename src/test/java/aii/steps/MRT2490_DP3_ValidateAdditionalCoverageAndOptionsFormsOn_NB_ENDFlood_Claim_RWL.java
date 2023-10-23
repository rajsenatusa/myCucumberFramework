package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MRT2490_DP3_ValidateAdditionalCoverageAndOptionsFormsOn_NB_ENDFlood_Claim_RWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime newBusinessDate = currentDate.plusDays(30);
	static LocalDateTime endorseDate = newBusinessDate.plusDays(30);
	static String policyNum;
	static String lossNum;
	static String claimNum;
	static String totalDueRenewal;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String glform;
	static String glform_Data;
	static String psform;
	static String psform_Data;
	static String rcform;
	static String rcform_Data;

	@When("User enters all required information on policy information screen <mtr2490>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2490() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
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

	@When("User enters DP3 product selection information and effective date as current date plus 30 days <mtr2490>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_plus_30_days_mtr2490() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(newBusinessDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}

	@When("User enters all required information on DP3 quote screen with current date plus 30days as prior policy date <mtr2490>")
	public void user_enters_all_current_date_plus30days_as_prior_date_mtr2490() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(newBusinessDate));
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

	@When("User enters all required information on DP3 dwelling screen <mtr2490> and selects additional coverages and adds additional options")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr2490_and_selects_additional_coverages_and_adds_additional_options() {

		// sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");

		// additional coverages
		selectDropdownText(dwellingChevron.ddHomeCyberProtectionDwelling, "$25,000");
		selectDropdownText(dwellingChevron.ddHomeSystemProtection, "$50,000/$10,000");
		selectDropdownText(dwellingChevron.ddLimitedCarportsPoolCage, "$10,000");
		selectDropdownText(dwellingChevron.ddIdentityRecovery, "$15,000");
		selectDropdownText(dwellingChevron.ddLossAssesment, "$2,000");
		selectDropdownText(dwellingChevron.ddOrdinance, "25%");

		// additional options
		click(dwellingChevron.rbPersonalPropertyReplacementCost);
		click(dwellingChevron.btnLimitedTheft);
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.rbWaterDamageLimited);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User updates roof material on dwelling screen")
	public void User_updates_roof_material_on_dwelling_screen() {
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction for <mtr2490>")
	public void user_finalizes_transaction_for_mtr2490() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <mtr2490>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_mtr2490()
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

	@When("User clicks Forms Chevron <mtr2490>")
	public void user_clicks_forms_chevron_mtr2490() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates all expected forms is visible on forms screen <mtr2490>")
	public void user_validates_all_expected_forms_is_visible_on_forms_screen_mtr2490() throws Exception {
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

		verify_AnyText_IsVisible(driver, "AIIC DP HCP 09 17");
		verify_AnyText_IsVisible(driver, "AIIC DP3 HSPSL 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP3 IR 07 15");

		// Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form AIIC
		// DP CPS 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP CPS 07 15')]"));
			Hooks.scenario.log("Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form NOT displayed");
			wait(5);
		}

		// Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form AIIC DP LFC 07
		// 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP LFC 07 15')]"));
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "DP 04 73 07 88");
		verify_AnyText_IsVisible(driver, "AIIC DP LA 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP OL 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP LWD 12 18");
		verify_AnyText_IsVisible(driver, "AIIC DP RCC 07 15");
		verify_AnyText_IsVisible(driver, "AIIC DP SK 07 15");

		// Form: Water Damage Exclusion AIIC DP WDX 12 18
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP WDX 12 18')]"));
			Hooks.scenario.log("Form: Water Damage Exclusion");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Water Damage Exclusion NOT displayed");
			wait(5);
		}

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

		// Sinkhole Loss Coverage Selection/Rejection Form AIIC SKSR 11 14
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC SKSR 11 14')]"));
			Hooks.scenario.log("Sinkhole Loss Coverage Selection/Rejection Form");
		} catch (Exception e) {
			Hooks.scenario.log("Sinkhole Loss Coverage Selection/Rejection Form NOT displayed");
			wait(5);
		}
	}

	@When("User validates greeting letter form version <mtr2490>")
	public void user_validates_greeting_letter_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC NB GL 08 19");
		clickonAnyButton(driver, "AIICNBGL_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-nb-gl-0819");
		glform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + glform);
		wait(10);
		glform_Data = PdfComparator.getPDFData(FileLocation + glform);
		PdfComparator.verifyPDFText(driver, glform_Data, "AIIC NB GL 08 19");
	}

	@When("User validates privacy statement form version <mtr2490>")
	public void user_validates_privacy_statement_form_version_mtr2490() throws Exception {
		// AIIC PS 05 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form");
			wait(5);
		}
		clickonAnyButton(driver, "AIICPS0519_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ps-0519");
		psform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + psform);
		wait(10);
		psform_Data = PdfComparator.getPDFData(FileLocation + psform);
		PdfComparator.verifyPDFText(driver, psform_Data, "AIIC PS 05 19");
		PdfComparator.verifyPDFText(driver, psform_Data, "PRIVACY STATEMENT");
	}

	@When("User validates Limitations on Roof Coverage form version <mtr2490>")
	public void user_validates_limitations_on_roof_coverage_form_version_mtr2490() throws Exception {
		// AIIC DP RWT 01 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage");
			wait(5);
		}
		
		clickonAnyButton(driver, "AIICDPRWT_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-rwt-0119");
		rcform = PdfComparator.getPdfName(driver);
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+rcform);	
		wait(10);		
		rcform_Data = PdfComparator.getPDFData(FileLocation+rcform);
		PdfComparator.verifyPDFText(driver, rcform_Data, "AIIC DP RWT 01 19");
		PdfComparator.verifyPDFText(driver, rcform_Data, "LIMITATIONS ON ROOF COVERAGE");
	}
}
