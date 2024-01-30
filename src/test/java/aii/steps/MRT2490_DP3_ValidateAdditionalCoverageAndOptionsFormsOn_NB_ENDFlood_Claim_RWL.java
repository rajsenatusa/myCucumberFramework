package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MRT2490_DP3_ValidateAdditionalCoverageAndOptionsFormsOn_NB_ENDFlood_Claim_RWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static int currentYear_temp = LocalDateTime.now().getYear();
	static String currentYear = String.valueOf(currentYear_temp);
	static String newBusinessDate = dtf.format(currentDate);
	static String endorseDate = dtf.format(currentDate.plusDays(30));
	static String policyNum;
	static String lossNum;
	static String claimNum;
	static String totalDue;
	static String totalDueRenewal;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String glform;
	static String glform_Data;
	static String psform;
	static String psform_Data;
	static String rcform;
	static String rcform_Data;
	static String dpdoform;
	static String dpdoform_Data;
	static String pjform;
	static String pjform_Data;
	static String idxform;
	static String idxform_Data;
	static String basicform;
	static String basicform_Data;
	static String spform;
	static String spform_Data;
	static String hdform;
	static String hdform_Data;
	static String hcpform;
	static String hcpform_Data;
	static String hspslform;
	static String hspslform_Data;
	static String irform;
	static String irform_Data;
	static String cpsform;
	static String cpsform_Data;
	static String lfcform;
	static String lfcform_Data;
	static String ltcform;
	static String ltcform_Data;
	static String laform;
	static String laform_Data;
	static String olform;
	static String olform_Data;
	static String lwdform;
	static String lwdform_Data;
	static String rccform;
	static String rccform_Data;
	static String skform;
	static String skform_Data;
	static String wdxform;
	static String wdxform_Data;
	static String ocform;
	static String ocform_Data;
	static String oir1670form;
	static String oir1670form_Data;
	static String oir1655form;
	static String oir1655form_Data;
	static String ncrform;
	static String ncrform_Data;
	static String sksrform;
	static String sksrform_Data;
	static String NBApp_Form;
	static String NBApp_Page;
	static String NBApp_Page2;
	static String NBPackage_Form;
	static String NBDec_Page;
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
	static String NBPolJacket_Version1;
	static String NBPolJacket_Version;
	static String NBPolJacket_Name;
	static String NBIDX_Version;
	static String NBIDX_Version1;
	static String DP3Special_Version;
	static String SPProvision_Version;
	static String SPProvision_Version1;
	static String SPProvision_Name;
	static String HurDed_Version;
	static String HurDed_Version1;
	static String HurDed_Name;
	static String Cyber_Version;
	static String Cyber_Version1;
	static String Cyber_Name;
	static String HSPSL_Version;
	static String HSPSL_Version1;
	static String HSPSL_Name;
	static String NBIR_Version;
	static String NBIR_Version1;
	static String NBIR_Name;
	static String Carpool_Version;
	static String Carpool_Version1;
	static String Carpool_Name;
	static String Fungi_Version;
	static String Fungi_Version1;
	static String Fungi_Name;
	static String Theft_Version;
	static String Theft_Version1;
	static String Theft_Name;
	static String Loss_Version;
	static String Loss_Version1;
	static String Loss_Name;
	static String Ordinance_Version;
	static String Ordinance_Version1;
	static String Ordinance_Name;
	static String LimitedWater_Version;
	static String LimitedWater_Version1;
	static String LimitedWater_Name;
	static String RCC_Version;
	static String RCC_Version1;
	static String RCC_Name;
	static String Sinkhole_Version;
	static String Sinkhole_Version1;
	static String Sinkhole_Name;
	static String WDX_Version;
	static String WDX_Version1;
	static String WDX_Name;
	static String Outline_Version;
	static String Outline_Version1;
	static String Outline_Name;
	static String NBCheckList_Version;
	static String NBCheckList_Name;
	static String NBHurMitigation_Version;
	static String NBHurMitigation_Name;
	static String NBConsReport_Version;
	static String NBConsReport_Name;
	static String FloodInfoForm;
	static String FloodInfo_Data;
	static String FloodCovForm;
	static String FloodCov_Data;
	static String FloodCov_Name;
	static String EndPackage_Form;
	static String EndDec_Page;
	static String EndDec_Page2;
	static String Declaration_Version;
	static String Declaration_Data;
	static String EndFloodInfo_Version1;
	static String EndFloodInfo_Version;
	static String EndFloodInfo_Data;
	static String EndFloodInfo_Name;
	static String EndFloodCov_Version;
	static String EndFloodCov_Data;
	static String EndFloodCov_Name;
	static String PolicyNumberTerm02;
	static String RwlDec_Form;
	static String RwlDec_Page;
	static String RwlDec_Page2;
	static String RwlGreeting_Version;
	static String RwlGreeting_Data;
	static String RwlPrivacy_Version1;
	static String RwlPrivacy_Version;
	static String RwlPrivacy_Data;
	static String RwlPrivacy_Name;
	static String RwlRoofLimitation_Version1;
	static String RwlRoofLimitation_Version;
	static String RwlRoofLimitation_Name;
	static String RwlDed_Version1;
	static String RwlDed_Version;
	static String RwlDed_Name;
	static String RwlPolJacket_Version1;
	static String RwlPolJacket_Version;
	static String RwlPolJacket_Name;
	static String RwlIDX_Version;
	static String RwlIDX_Version1;
	static String RwlDP3Special_Version;
	static String RwlSPProvision_Version;
	static String RwlSPProvision_Version1;
	static String RwlSPProvision_Name;
	static String RwlFloodInfo_Version1;
	static String RwlFloodInfo_Version;
	static String RwlFloodInfo_Data;
	static String RwlFloodInfo_Name;
	static String RwlHurDed_Version;
	static String RwlHurDed_Version1;
	static String RwlHurDed_Name;
	static String RwlCyber_Version;
	static String RwlCyber_Version1;
	static String RwlCyber_Name;
	static String RwlFloodCov_Version;
	static String RwlFloodCov_Data;
	static String RwlFloodCov_Name;
	static String RwlHSPSL_Version;
	static String RwlHSPSL_Version1;
	static String RwlHSPSL_Name;
	static String RwlIR_Version;
	static String RwlIR_Version1;
	static String RwlIR_Name;
	static String RwlCarpool_Version;
	static String RwlCarpool_Version1;
	static String RwlCarpool_Name;
	static String RwlFungi_Version;
	static String RwlFungi_Version1;
	static String RwlFungi_Name;
	static String RwlTheft_Version;
	static String RwlTheft_Version1;
	static String RwlTheft_Name;
	static String RwlLoss_Version;
	static String RwlLoss_Version1;
	static String RwlLoss_Name;
	static String RwlOrdinance_Version;
	static String RwlOrdinance_Version1;
	static String RwlOrdinance_Name;
	static String RwlLimitedWater_Version;
	static String RwlLimitedWater_Version1;
	static String RwlLimitedWater_Name;
	static String RwlRCC_Version;
	static String RwlRCC_Version1;
	static String RwlRCC_Name;
	static String RwlSinkhole_Version;
	static String RwlSinkhole_Version1;
	static String RwlSinkhole_Name;
	static String RwlWDX_Version;
	static String RwlWDX_Version1;
	static String RwlWDX_Name;
	static String RwlOutline_Version;
	static String RwlOutline_Version1;
	static String RwlOutline_Name;
	static String RwlCheckList_Version;
	static String RwlCheckList_Name;
	static String RwlHurMitigation_Version;
	static String RwlHurMitigation_Name;
	static String RwlConsReport_Version;
	static String RwlConsReport_Name;
	static String RwlSKSR_Version;
	static String RwlSKSR_Version1;
	static String RwlSKSR_Name;
	static String temp2;
	static String PolicyNumberTerm03;
	static String Rwl2Dec_Form;
	static String Rwl2Dec_Page;
	static String Rwl2Dec_Page2;
	static String Rwl2Greeting_Version;
	static String Rwl2Greeting_Data;
	static String Rwl2Privacy_Version1;
	static String Rwl2Privacy_Version;
	static String Rwl2Privacy_Data;
	static String Rwl2Privacy_Name;
	static String Rwl2RoofLimitation_Version1;
	static String Rwl2RoofLimitation_Version;
	static String Rwl2RoofLimitation_Name;
	static String Rwl2Ded_Version1;
	static String Rwl2Ded_Version;
	static String Rwl2Ded_Name;
	static String Rwl2PolJacket_Version1;
	static String Rwl2PolJacket_Version;
	static String Rwl2PolJacket_Name;
	static String Rwl2IDX_Version;
	static String Rwl2IDX_Version1;
	static String Rwl2DP3Special_Version;
	static String Rwl2SPProvision_Version;
	static String Rwl2SPProvision_Version1;
	static String Rwl2SPProvision_Name;
	static String Rwl2FloodInfo_Version1;
	static String Rwl2FloodInfo_Version;
	static String Rwl2FloodInfo_Data;
	static String Rwl2FloodInfo_Name;
	static String Rwl2HurDed_Version;
	static String Rwl2HurDed_Version1;
	static String Rwl2HurDed_Name;
	static String Rwl2Cyber_Version;
	static String Rwl2Cyber_Version1;
	static String Rwl2Cyber_Name;
	static String Rwl2FloodCov_Version;
	static String Rwl2FloodCov_Data;
	static String Rwl2FloodCov_Name;
	static String Rwl2HSPSL_Version;
	static String Rwl2HSPSL_Version1;
	static String Rwl2HSPSL_Name;
	static String Rwl2IR_Version;
	static String Rwl2IR_Version1;
	static String Rwl2IR_Name;
	static String Rwl2Carpool_Version;
	static String Rwl2Carpool_Version1;
	static String Rwl2Carpool_Name;
	static String Rwl2Fungi_Version;
	static String Rwl2Fungi_Version1;
	static String Rwl2Fungi_Name;
	static String Rwl2Theft_Version;
	static String Rwl2Theft_Version1;
	static String Rwl2Theft_Name;
	static String Rwl2Loss_Version;
	static String Rwl2Loss_Version1;
	static String Rwl2Loss_Name;
	static String Rwl2Ordinance_Version;
	static String Rwl2Ordinance_Version1;
	static String Rwl2Ordinance_Name;
	static String Rwl2LimitedWater_Version;
	static String Rwl2LimitedWater_Version1;
	static String Rwl2LimitedWater_Name;
	static String Rwl2RCC_Version;
	static String Rwl2RCC_Version1;
	static String Rwl2RCC_Name;
	static String Rwl2Sinkhole_Version;
	static String Rwl2Sinkhole_Version1;
	static String Rwl2Sinkhole_Name;
	static String Rwl2WDX_Version;
	static String Rwl2WDX_Version1;
	static String Rwl2WDX_Name;
	static String Rwl2Outline_Version;
	static String Rwl2Outline_Version1;
	static String Rwl2Outline_Name;
	static String Rwl2CheckList_Version;
	static String Rwl2CheckList_Name;
	static String Rwl2HurMitigation_Version;
	static String Rwl2HurMitigation_Name;
	static String Rwl2ConsReport_Version;
	static String Rwl2ConsReport_Name;
	static String Rwl2SKSR_Version;
	static String Rwl2SKSR_Version1;
	static String Rwl2SKSR_Name;

	@When("User enters all required information on policy information screen <mtr2490>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2490() {

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

	@When("User enters DP3 product selection information and effective date as current date plus 30 days <mtr2490>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_plus_30_days_mtr2490() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, newBusinessDate);
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
		sendText(policyChevron.txtPreviousPolicyExpDate, newBusinessDate);
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

		sendText(dwellingChevron.txtYearConstruction, currentYear);
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		//selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");

		// additional coverages
		selectDropdownText(dwellingChevron.ddHomeCyberProtectionDwelling, "$25,000");
		selectDropdownText(dwellingChevron.ddHomeSystemProtection, "$50,000/$10,000");
		sendText(driver.findElement(By.id("Building.CovLCARLimit")), "$10,000");
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
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
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
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + rcform);
		wait(10);
		rcform_Data = PdfComparator.getPDFData(FileLocation + rcform);
		PdfComparator.verifyPDFText(driver, rcform_Data, "AIIC DP RWT 01 19");
		PdfComparator.verifyPDFText(driver, rcform_Data, "LIMITATIONS ON ROOF COVERAGE");
	}

	@When("User validates Deductible Notification Options form version <mtr2490>")
	public void user_validates_deductible_notification_options_form_version_mtr2490() throws Exception {
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP DO 06 23')]"));
			Hooks.scenario.log("Form: Deductible Notification Options");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDPDO_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-do-0623");
		dpdoform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + dpdoform);
		wait(10);
		dpdoform_Data = PdfComparator.getPDFData(FileLocation + dpdoform);
		PdfComparator.verifyPDFText(driver, dpdoform_Data, "AIIC DP DO 06 23");
		PdfComparator.verifyPDFText(driver, dpdoform_Data, "DEDUCTIBLE NOTIFICATION OPTIONS");
	}

	@When("User validates Policy Jacket form version <mtr2490>")
	public void user_validates_Policy_Jacket_form_version_mtr2490() throws Exception {
		// AIIC PJ 05 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 05 19')]"));
			Hooks.scenario.log("Policy Jacket Form");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Jacket Form");
			wait(5);
		}
		clickonAnyButton(driver, "AIICPJ0519_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-pj-0519");
		pjform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + pjform);
		wait(10);
		pjform_Data = PdfComparator.getPDFData(FileLocation + pjform);
		PdfComparator.verifyPDFText(driver, pjform_Data, "AIIC PJ 05 19");
		PdfComparator.verifyPDFText(driver, pjform_Data, "Policy Jacket");
	}

	@When("User validates Dwelling Property 3 Special form version <mtr2490>")
	public void user_validates_Dwelling_Property_3_special_form_version_mtr2490() throws Exception {
		// AIIC DP3 IDX 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP3 IDX 07 15')]"));
			Hooks.scenario.log("Dwelling Property 3 Special Form Index");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Property 3 Special Form Index");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDP3IDX_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp3-idx-0715");
		idxform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + idxform);
		wait(10);
		idxform_Data = PdfComparator.getPDFData(FileLocation + idxform);
		PdfComparator.verifyPDFText(driver, idxform_Data, "AIIC DP3 IDX 07 15");
	}

	@When("User validates Dwelling Property 3 Basic form version <mtr2490>")
	public void user_validates_Dwelling_Property_3_basic_form_version_mtr2490() throws Exception {
		// DP 00 03 07 88
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'DP 00 03 07 88')]"));
			Hooks.scenario.log("Dwelling Property 3 - Basic Form");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Property 3 - Basic Form");
			wait(5);
		}
		clickonAnyButton(driver, "DP0003_View");
		Thread.sleep(7000);
		switchToWindow(driver, "dp00030788");
		basicform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + basicform);
		wait(10);
		basicform_Data = PdfComparator.getPDFData(FileLocation + basicform);
		PdfComparator.verifyPDFText(driver, basicform_Data, "DP 00 03 07 88");
		PdfComparator.verifyPDFText(driver, basicform_Data, "Dwelling Property 3");
		PdfComparator.verifyPDFText(driver, basicform_Data, "Special Form");
	}

	@When("User validates Special Provisions for Florida form version <mtr2490>")
	public void user_validates_Special_Provisions_for_Florida_form_version_mtr2490() throws Exception {
		// AIIC 01 DP3 SP 04 23
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC 01 DP3 SP 04 23')]"));
			Hooks.scenario.log("Special Provisions for Florida - DP 00 03 - Special Form Form");
		} catch (Exception e) {
			Hooks.scenario.log("Special Provisions for Florida - DP 00 03 - Special Form Form");
			wait(5);
		}
		clickonAnyButton(driver, "AIIC01DP3SP0423_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-01-dp3-sp-0423");
		spform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + spform);
		wait(10);
		spform_Data = PdfComparator.getPDFData(FileLocation + spform);
		PdfComparator.verifyPDFText(driver, spform_Data, "AIIC 01 DP3 SP 04 23");
		PdfComparator.verifyPDFText(driver, spform_Data, "SPECIAL PROVISIONS FOR FLORIDA");
	}

	@When("User validates Calendar Year Hurricane Deductible Requirement form version <mtr2490>")
	public void user_validates_calendar_year_hurricane_deductible_requirement_form_version_mtr2490() throws Exception {
		// AIIC DP HD 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP HD 07 15')]"));
			Hooks.scenario.log("Calendar Year Hurricane Deductible Requirement");
		} catch (Exception e) {
			Hooks.scenario.log("Calendar Year Hurricane Deductible Requirement");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDPHD_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-hd-0715");
		hdform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + hdform);
		wait(10);
		hdform_Data = PdfComparator.getPDFData(FileLocation + hdform);
		PdfComparator.verifyPDFText(driver, hdform_Data, "AIIC DP HD 07 15");
		PdfComparator.verifyPDFText(driver, hdform_Data, "CALENDAR YEAR HURRICANE DEDUCTIBLE");
	}

	@When("User validates Home Cyber Protection Coverage form version <mtr2490>")
	public void user_validates_home_cyber_protection_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP HCP 09 17");
		clickonAnyButton(driver, "AIICDPHCP0917_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-hcp-0917");
		hcpform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + hcpform);
		wait(10);
		hcpform_Data = PdfComparator.getPDFData(FileLocation + hcpform);
		PdfComparator.verifyPDFText(driver, hcpform_Data, "AIIC DP HCP 09 17");
		PdfComparator.verifyPDFText(driver, hcpform_Data, "HOME CYBER PROTECTION COVERAGE");
		PdfComparator.verifyPDFText(driver, hcpform_Data, "Cyber Attack, Cyber Extortion, and Online Fraud");
	}

	@When("User validates Home Systems Protection Service Line Coverage form version <mtr2490>")
	public void user_validates_home_systems_protection_service_line_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP3 HSPSL 07 15");
		clickonAnyButton(driver, "AIICDP3HSPSL_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp3-hspsl-0715");
		hspslform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + hspslform);
		wait(10);
		hspslform_Data = PdfComparator.getPDFData(FileLocation + hspslform);
		PdfComparator.verifyPDFText(driver, hspslform_Data, "AIIC DP3 HSPSL 07 15");
		PdfComparator.verifyPDFText(driver, hspslform_Data, "HOME SYSTEMS PROTECTION & SERVICE LINE COVERAGE");
	}

	@When("User validates Identity Recovery Coverage form version <mtr2490>")
	public void user_validates_identity_recovery_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP3 IR 07 15");
		clickonAnyButton(driver, "AIICDP3IR_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp3-ir-0715");
		irform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + irform);
		wait(10);
		irform_Data = PdfComparator.getPDFData(FileLocation + irform);
		PdfComparator.verifyPDFText(driver, irform_Data, "AIIC DP3 IR 07 15");
		PdfComparator.verifyPDFText(driver, irform_Data, "IDENTITY RECOVERY COVERAGE");
	}

	@When("User validates Limited Carport, Pool Cage and Screen Enclosure Coverage form version <mtr2490>")
	public void user_validates_limited_carport_poolcage_and_screen_enclosure_coverage_form_version_mtr2490()
			throws Exception {
		// Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form AIIC
		// DP CPS 07 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP CPS 07 15')]"));
			Hooks.scenario.log("Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage Form NOT displayed");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDPCPS_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-cps-0715");
		cpsform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + cpsform);
		wait(10);
		cpsform_Data = PdfComparator.getPDFData(FileLocation + cpsform);
		PdfComparator.verifyPDFText(driver, cpsform_Data, "AIIC DP CPS 07 15");
		PdfComparator.verifyPDFText(driver, cpsform_Data, "LIMITED CARPORT(S), POOL CAGE(S) AND SCREEN");
		PdfComparator.verifyPDFText(driver, cpsform_Data, "ENCLOSURE(S) COVERAGE");
	}

	@When("User validates Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage form version <mtr2490>")
	public void user_validates_limited_fungi_mold_wet_dry_rot_or_bacteria_coverage_form_version_mtr2490()
			throws Exception {
		// Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form AIIC DP LFC 07
		// 15
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP LFC 07 15')]"));
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Form");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDPLFC_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-lfc-0715");
		lfcform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + lfcform);
		wait(10);
		lfcform_Data = PdfComparator.getPDFData(FileLocation + lfcform);
		PdfComparator.verifyPDFText(driver, lfcform_Data, "AIIC DP LFC 07 15");
		PdfComparator.verifyPDFText(driver, lfcform_Data, "WET OR DRY ROT, OR BACTERIA");
	}

	@When("User validates Limited Theft Coverage form version <mtr2490>")
	public void user_validates_limited_theft_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "DP 04 73 07 88");
		clickonAnyButton(driver, "DP0473_View");
		Thread.sleep(7000);
		switchToWindow(driver, "dp04730788");
		ltcform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ltcform);
		wait(10);
		ltcform_Data = PdfComparator.getPDFData(FileLocation + ltcform);
		PdfComparator.verifyPDFText(driver, ltcform_Data, "DP 04 73 07 88");
		PdfComparator.verifyPDFText(driver, ltcform_Data, "LIMITED THEFT COVERAGE");
	}

	@When("User validates Loss Assessment Property Coverage form version <mtr2490>")
	public void user_validates_loss_assessment_property_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP LA 07 15");
		clickonAnyButton(driver, "AIICDPLA_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-la-0715");
		laform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + laform);
		wait(10);
		laform_Data = PdfComparator.getPDFData(FileLocation + laform);
		PdfComparator.verifyPDFText(driver, laform_Data, "AIIC DP LA 07 15");
		PdfComparator.verifyPDFText(driver, laform_Data, "LOSS ASSESSMENT PROPERTY COVERAGE");
	}

	@When("User validates Ordinance or Law Coverage form version <mtr2490>")
	public void user_validates_ordinance_or_law_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP OL 07 15");
		clickonAnyButton(driver, "AIICDPOL_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-ol-0715");
		olform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + olform);
		wait(10);
		olform_Data = PdfComparator.getPDFData(FileLocation + olform);
		PdfComparator.verifyPDFText(driver, olform_Data, "AIIC DP OL 07 15");
		PdfComparator.verifyPDFText(driver, olform_Data, "ORDINANCE OR LAW COVERAGE");
	}

	@When("User validates Limited Water Damages form version <mtr2490>")
	public void user_validates_limited_water_damages_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP LWD 12 18");
		clickonAnyButton(driver, "AIICLWD_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiicdplwd1218");
		lwdform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + lwdform);
		wait(10);
		lwdform_Data = PdfComparator.getPDFData(FileLocation + lwdform);
		PdfComparator.verifyPDFText(driver, lwdform_Data, "AIIC DP LWD 12 18");
		PdfComparator.verifyPDFText(driver, lwdform_Data, "LIMITED WATER DAMAGE COVERAGE");
	}

	@When("User validates Personal Property Replacement Cost Coverage form version <mtr2490>")
	public void user_validates_personal_property_replacement_cost_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP RCC 07 15");
		clickonAnyButton(driver, "AIICDPRCC_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-rcc-0715");
		rccform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + rccform);
		wait(10);
		rccform_Data = PdfComparator.getPDFData(FileLocation + rccform);
		PdfComparator.verifyPDFText(driver, rccform_Data, "AIIC DP RCC 07 15");
		PdfComparator.verifyPDFText(driver, rccform_Data, "PERSONAL PROPERTY REPLACEMENT COST COVERAGE");
	}

	@When("User validates Sinkhole Loss Coverage form version <mtr2490>")
	public void user_validates_sinkhole_loss_coverage_form_version_mtr2490() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP SK 07 15");
		clickonAnyButton(driver, "AIICDPSK_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-sk-0715");
		skform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + skform);
		wait(10);
		skform_Data = PdfComparator.getPDFData(FileLocation + skform);
		PdfComparator.verifyPDFText(driver, skform_Data, "AIIC DP SK 07 15");
		PdfComparator.verifyPDFText(driver, skform_Data, "SINKHOLE LOSS COVERAGE");
	}

	@When("User validates Water Damage Exclusion form version <mtr2490>")
	public void user_validates_water_damage_exclusion_form_version_mtr2490() throws Exception {
		// Form: Water Damage Exclusion AIIC DP WDX 12 18
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP WDX 12 18')]"));
			Hooks.scenario.log("Form: Water Damage Exclusion");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Water Damage Exclusion NOT displayed");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDPWDX_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiicdpwdx1218");
		wdxform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + wdxform);
		wait(10);
		wdxform_Data = PdfComparator.getPDFData(FileLocation + wdxform);
		PdfComparator.verifyPDFText(driver, wdxform_Data, "AIIC DP WDX 12 18");
		PdfComparator.verifyPDFText(driver, wdxform_Data, "WATER DAMAGE EXCLUSION");
	}

	@When("User validates Outline of your Dwelling Policy form version <mtr2490>")
	public void user_validates_outline_of_your_dwelling_policy_form_version_mtr2490() throws Exception {
		// AIIC DP3 OC 12 18
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DP3 OC 12 18')]"));
			Hooks.scenario.log("Outline of your Basic Dwelling Policy");
		} catch (Exception e) {
			Hooks.scenario.log("Outline of your Basic Dwelling Policy");
			wait(5);
		}
		clickonAnyButton(driver, "AIICDP3OC0917_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp3-oc-1218");
		ocform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ocform);
		wait(10);
		ocform_Data = PdfComparator.getPDFData(FileLocation + ocform);
		PdfComparator.verifyPDFText(driver, ocform_Data, "AIIC DP3 OC 12 18");
		PdfComparator.verifyPDFText(driver, ocform_Data, "OUTLINE OF YOUR DWELLING POLICY");
	}

	@When("User validates Checklist of Coverage form version <mtr2490>")
	public void user_validates_checklist_of_coverage_form_version_mtr2490() throws Exception {
		// OIR B1 1670
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form");
			wait(5);
		}
		clickonAnyButton(driver, "OIRB11670_View");
		Thread.sleep(7000);
		switchToWindow(driver, "oir-b1-1670-1106");
		oir1670form = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + oir1670form);
		wait(10);
		oir1670form_Data = PdfComparator.getPDFData(FileLocation + oir1670form);
		PdfComparator.verifyPDFText(driver, oir1670form_Data, "OIR-B1-1670");
		PdfComparator.verifyPDFText(driver, oir1670form_Data, "Checklist of Coverage");
	}

	@When("User validates Notice of Premium Discounts for Hurricane Loss Mitigation form version <mtr2490>")
	public void user_validates_notice_of_premium_discounts_for_hurricane_loss_mitigation_form_version_mtr2490()
			throws Exception {
		// OIR B1 1655
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form");
			wait(5);
		}
		clickonAnyButton(driver, "OIRB11655_View");
		Thread.sleep(7000);
		switchToWindow(driver, "oir-b1-1655-0210");
		oir1655form = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + oir1655form);
		wait(10);
		oir1655form_Data = PdfComparator.getPDFData(FileLocation + oir1655form);
		PdfComparator.verifyPDFText(driver, oir1655form_Data, "OIR-B1-1655");
		PdfComparator.verifyPDFText(driver, oir1655form_Data,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

	}

	@When("User validates Notice of Consumer Reports Ordered and Information Used in Premium Determiniation form version <mtr2490>")
	public void user_validates_notice_of_consumer_reports_ordered_and_information_used_in_premium_determination_form_version_mtr2490()
			throws Exception {
		// AIIC NCR 08 19
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
			wait(5);
		}
		clickonAnyButton(driver, "AIICNCR0819_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ncr-0819");
		ncrform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ncrform);
		wait(10);
		ncrform_Data = PdfComparator.getPDFData(FileLocation + ncrform);
		PdfComparator.verifyPDFText(driver, ncrform_Data, "AIIC NCR 08 19");
		PdfComparator.verifyPDFText(driver, ncrform_Data, "Notice of Consumer Reports Ordered and Information Used in");
		PdfComparator.verifyPDFText(driver, ncrform_Data, "Premium Determination");
	}

	@When("User validates Sinkhole Loss Coverage Selection Rejection Form form version <mtr2490>")
	public void user_validates_sinkhole_loss_coverage_selection_rejection_form_version_mtr2490() throws Exception {
		// Sinkhole Loss Coverage Selection/Rejection Form AIIC SKSR 11 14
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC SKSR 11 14')]"));
			Hooks.scenario.log("Sinkhole Loss Coverage Selection/Rejection Form");
		} catch (Exception e) {
			Hooks.scenario.log("Sinkhole Loss Coverage Selection/Rejection Form NOT displayed");
			wait(5);
		}
		clickonAnyButton(driver, "AIICSKSR_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-sksr-1114");
		sksrform = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + sksrform);
		wait(10);
		sksrform_Data = PdfComparator.getPDFData(FileLocation + sksrform);
		PdfComparator.verifyPDFText(driver, sksrform_Data, "AIIC SKSR 11 14");
		PdfComparator.verifyPDFText(driver, sksrform_Data, "Sinkhole Loss Coverage Selection/Rejection Form");
	}

	@When("User clicks Policy File Chevron <mtr2490>")
	public void user_clicks_policy_file_chevron_mtr2490() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Application Link and validates form versions <mtr2490>")
	public void user_clicks_Application_Link_and_validates_form_versions_mtr2490() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		NBApp_Form = PdfComparator.makePdf(driver, "Application.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBApp_Form);
		wait(10);

		// Declaration page Forms and endorsement section
		NBApp_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBApp_Form, 2, 30, 360, 560, 350);
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC NB GL 08 19Greeting Letter");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, NBApp_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");

		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC 01 DP3 SP 04 23Special Provisions for Florida - DP 00 03 - Special Form");
		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC DP HD 07 15Calendar Year Hurricane Deductible Requirement");

		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP HCP 09 17Home Cyber Protection Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC DP3 HSPSL 07 15Home Systems Protection and Service Line Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP3 IR 07 15Identity Recovery Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC DP CPS 07 15Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "DP 04 73 07 88Limited Theft Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP LWD 12 18Limited Water Damages");
		PdfComparator.verifyFormData(driver, NBApp_Page,
				"AIIC DP RCC 07 15Personal Property Replacement Cost Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP SK 07 15Sinkhole Loss Coverage");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP WDX 12 18Water Damage Exclusion ");
		PdfComparator.verifyFormData(driver, NBApp_Page, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");
		PdfComparator.verifyFormData(driver, NBApp_Page, "OIR B1 1670Checklist of Coverage");
		

		NBApp_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBApp_Form, 3, 0, 0, 690, 720);
		PdfComparator.verifyFormData(driver, NBApp_Page2, "AIIC NCR 08 19Notice of Consumer Reports Ordered and");
		PdfComparator.verifyFormData(driver, NBApp_Page2, "AIIC SKSR 11 14");
		PdfComparator.verifyFormData(driver, NBApp_Page2, "OIR B1 1655");
	}

	@When("User clicks New Business Package Link and validates form versions <mtr2490>")
	public void user_clicks_New_Business_Package_Link_and_validates_form_versions_mtr2490() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		NBPackage_Form = PdfComparator.makePdf(driver, "NewBusinessPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);
		wait(10);

		// Declaration page Forms and endorsement section
		NBDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 10, 30, 350, 560, 400);
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC NB GL 08 19Greeting Letter");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP PHN CSAU 06 22");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, NBDec_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC 01 DP3 SP 04 23Special Provisions for Florida - DP 00 03 - Special Form");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP HD 07 15Calendar Year Hurricane Deductible Requirement");

		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP HCP 09 17Home Cyber Protection Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP3 HSPSL 07 15Home Systems Protection and Service Line Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 IR 07 15Identity Recovery Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP CPS 07 15Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "DP 04 73 07 88Limited Theft Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP LWD 12 18Limited Water Damages");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"AIIC DP RCC 07 15Personal Property Replacement Cost Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP SK 07 15Sinkhole Loss Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP WDX 12 18Water Damage Exclusion ");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");
		PdfComparator.verifyFormData(driver, NBDec_Page, "OIR B1 1670Checklist of Coverage");
		PdfComparator.verifyFormData(driver, NBDec_Page,
				"OIR B1 1655Notice of Premium Discounts for Hurricane Loss Mitigation");
		PdfComparator.verifyFormData(driver, NBDec_Page, "AIIC NCR 08 19");

		// Greeting letter
		NBGreeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, NBGreeting_Version, "AIIC NB GL 08 19");

		NBGreeting_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBGreeting_Data, "AIIC NB GL 08 19");

		// Privacy statement
		NBPrivacy_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, NBPrivacy_Version1, "AIIC PS 05 19");
		NBPrivacy_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, NBPrivacy_Version, "AIIC PS 05 19");

		NBPrivacy_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Data, "AIIC PS 05 19");
		NBPrivacy_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Name, "PRIVACY STATEMENT");

		// Roof form
		NBRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 445, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version1, "AIIC DP RWT 01 19");
		NBRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 55, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version, "AIIC DP RWT 01 19");

		NBRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Deductible notification form
		NBDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 450, 10, 250, 30);
		PdfComparator.verifyFormData(driver, NBDed_Version1, "AIIC DP DO 06 23");
		NBDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, NBDed_Version, "AIIC DP DO 06 23");

		NBDed_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDed_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Policy jacket form
		NBPolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version1, "AIIC PJ 05 19");
		NBPolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version, "AIIC PJ 05 19");

		NBPolJacket_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPolJacket_Name, "Policy Jacket");

		// AIIC DP3 IDX 07 15 form
		NBIDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 15, 470, 35, 150, 50);
		PdfComparator.verifyFormData(driver, NBIDX_Version, "AIIC DP3 IDX 07 15");
		NBIDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 15, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, NBIDX_Version1, "AIIC DP3 IDX 07 15");

		// DP 00 03 07 88 form
		DP3Special_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 16, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, DP3Special_Version, "DP 00 03 07 88");

		// AIIC 01 DP3 SP 04 23 form
		SPProvision_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 26, 440, 20, 120, 30);
		PdfComparator.verifyFormData(driver, SPProvision_Version, "AIIC 01 DP3 SP 04 23");
		SPProvision_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 27, 30, 760, 120,
				25);
		PdfComparator.verifyFormData(driver, SPProvision_Version1, "AIIC 01 DP3 SP 04 23");

		SPProvision_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, SPProvision_Name, "SPECIAL PROVISIONS FOR FLORIDA");

		// AIIC DP HD 07 15 form
		HurDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 41, 470, 25, 100, 40);
		PdfComparator.verifyFormData(driver, HurDed_Version, "AIIC DP HD 07 15");
		HurDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 41, 60, 740, 100, 40);
		PdfComparator.verifyFormData(driver, HurDed_Version1, "AIIC DP HD 07 15");

		HurDed_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, HurDed_Name, "CALENDAR YEAR HURRICANE DEDUCTIBLE");

		// Home Cyber Protection Coverage form
		Cyber_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 46, 450, 25, 120, 40);
		PdfComparator.verifyFormData(driver, Cyber_Version, "AIIC DP HCP 09 17");
		Cyber_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 46, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Cyber_Version1, "AIIC DP HCP 09 17");

		Cyber_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Cyber_Name, "HOME CYBER PROTECTION COVERAGE");

		// Home Systems Protection & Service Line Coverage
		HSPSL_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 53, 440, 25, 120, 40);
		PdfComparator.verifyFormData(driver, HSPSL_Version, "AIIC DP3 HSPSL 07 15");
		HSPSL_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 53, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, HSPSL_Version1, "AIIC DP3 HSPSL 07 15");

		HSPSL_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, HSPSL_Name, "HOME SYSTEMS PROTECTION & SERVICE LINE COVERAGE");

		// Identity Recovery Coverage form
		NBIR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 58, 440, 30, 120, 40);
		PdfComparator.verifyFormData(driver, NBIR_Version, "AIIC DP3 IR 07 15");
		NBIR_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 58, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, NBIR_Version1, "AIIC DP3 IR 07 15");

		NBIR_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBIR_Name, "IDENTITY RECOVERY COVERAGE");

		// Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage form
		Carpool_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 60, 470, 25, 120, 40);
		PdfComparator.verifyFormData(driver, Carpool_Version, "AIIC DP CPS 07 15");
		Carpool_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 60, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Carpool_Version1, "AIIC DP CPS 07 15");

		Carpool_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Carpool_Name, "LIMITED CARPORT(S), POOL CAGE(S) AND SCREEN");

		// AIIC DP LFC 07 15 form
		Fungi_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 61, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Fungi_Version, "AIIC DP LFC 07 15");
		Fungi_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 61, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Fungi_Version1, "AIIC DP LFC 07 15");

		Fungi_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Fungi_Name, "WET OR DRY ROT, OR BACTERIA");

		// Limited Theft Coverage form
		Theft_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 62, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Theft_Version, "DP 04 73 07 88");
		Theft_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 62, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, Theft_Version1, "DP 04 73 07 88");

		Theft_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Theft_Name, "LIMITED THEFT COVERAGE");

		// Loss Assessment form
		Loss_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 64, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Loss_Version, "AIIC DP LA 07 15");
		Loss_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 64, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Loss_Version1, "AIIC DP LA 07 15");

		Loss_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Loss_Name, "LOSS ASSESSMENT PROPERTY COVERAGE");

		// Ordinance or Law Coverage form
		Ordinance_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 65, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Ordinance_Version, "AIIC DP OL 07 15");
		Ordinance_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 65, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Ordinance_Version1, "AIIC DP OL 07 15");

		Ordinance_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Ordinance_Name, "ORDINANCE OR LAW COVERAGE");

		// LIMITED WATER DAMAGE COVERAGE form
		LimitedWater_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 66, 455, 30, 120,
				40);
		PdfComparator.verifyFormData(driver, LimitedWater_Version, "AIIC DP LWD 12 18");
		LimitedWater_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 66, 60, 735, 120,
				30);
		PdfComparator.verifyFormData(driver, LimitedWater_Version1, "AIIC DP LWD 12 18");

		LimitedWater_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, LimitedWater_Name, "LIMITED WATER DAMAGE COVERAGE");

		// Personal Property Replacement Cost Coverage form
		RCC_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 67, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RCC_Version, "AIIC DP RCC 07 15");
		RCC_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 67, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RCC_Version1, "AIIC DP RCC 07 15");

		RCC_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, RCC_Name, "PERSONAL PROPERTY REPLACEMENT COST COVERAGE");

		// SINKHOLE LOSS COVERAGE form
		Sinkhole_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 68, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Sinkhole_Version, "AIIC DP SK 07 15");
		Sinkhole_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 68, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Sinkhole_Version1, "AIIC DP SK 07 15");

		Sinkhole_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Sinkhole_Name, "SINKHOLE LOSS COVERAGE");

		// AIIC DP WDX 12 18 form
		WDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 72, 450, 40, 120, 40);
		PdfComparator.verifyFormData(driver, WDX_Version, "AIIC DP WDX 12 18");
		WDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 72, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, WDX_Version1, "AIIC DP WDX 12 18");

		WDX_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, WDX_Name, "WATER DAMAGE EXCLUSION");

		// OUTLINE OF YOUR DWELLING POLICY form
		Outline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 73, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Outline_Version, "AIIC DP3 OC 12 18");
		Outline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 73, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Outline_Version1, "AIIC DP3 OC 12 18");

		Outline_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, Outline_Name, "OUTLINE OF YOUR DWELLING POLICY");

		// Checklist form
		NBCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 77, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, NBCheckList_Version, "OIR-B1-1670");

		NBCheckList_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBCheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		NBHurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 80, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, NBHurMitigation_Version, "OIR-B1-1655");

		NBHurMitigation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		NBConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 81, 30, 710, 100,
				30);
		PdfComparator.verifyFormData(driver, NBConsReport_Version, "AIIC NCR 08 19");

		NBConsReport_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBConsReport_Name, "Notice of Consumer Reports Ordered and Information");

		clickApplicationTab(driver);
		wait(3);
	}

	@When("User searches for the policy number <mtr2490>")
	public void user_searches_policy_for_mtr2490() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as endorse date and starts endorsement <mtr2490>")
	public void User_sets_new_effective_date_as_endorse_date_and_starts_endorsement_mtr2490() {
		sendText(historyChevron.txtEffectiveDate, endorseDate);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr2490>")
	public void user_clicks_dwelling_chevron_mtr2490() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User adds flood coverage")
	public void user_adds_flood_coverage() throws Exception {
		selectDropdownText(driver.findElement(By.id("Building.FloodCoverage")), "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Building.FloodFoundationType")), "Slab");
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(driver.findElement(By.id("Building.FloodProgramDateOverride")), "04/15/1980");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User clicks Finalize button and Endorses Policy <mtr2490>")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr2490_() {
		reviewChevron.btnFinalize.click();
		wait(3);
		closeoutChevron.btnEndorsePolicy.click();
		wait(10);
		closeUnnecessaryTabs();
	}

	@When("User validates all expected forms is visible on forms screen endorsement level<mtr2490>")
	public void user_validates_all_expected_forms_is_visible_on_forms_screen_endorsement_level_mtr2490()
			throws Exception {
		wait(2);
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

		// Flood Information Form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC FLI 07 17')]"));
			Hooks.scenario.log("Flood Information Form");
		} catch (Exception e) {
			Hooks.scenario.log("Flood Information Form");
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
		verify_AnyText_IsVisible(driver, "AIIC DP PFL 03 17");
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

	@And("User clicks Flood Information form and validates form version")
	public void User_clicks_Flood_Information_form_and_validates_form_version_mtr2490_() throws Exception {
		clickonAnyButton(driver, "AIICFLI0717_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-fli-0717.pdf");
		FloodInfoForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + FloodInfoForm);

		wait(10);
		FloodInfo_Data = PdfComparator.getPDFData(FileLocation + FloodInfoForm);
		PdfComparator.verifyPDFText(driver, FloodInfo_Data, "AIIC FLI 07 17");
		PdfComparator.verifyPDFText(driver, FloodInfo_Data, "FLOOD INFORMATION FORM");
	}

	@And("User clicks Flood Coverage Endorsement Form and validates form version")
	public void User_clicks_Flood_Coverage_Endorsement_form_and_validates_form_version_mtr2490_() throws Exception {
		clickonAnyButton(driver, "AIICDPPFL0317_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-pfl-0317.pdf");
		FloodCovForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + FloodCovForm);

		wait(10);
		FloodCov_Data = PdfComparator.getPDFData(FileLocation + FloodCovForm);
		PdfComparator.verifyPDFText(driver, FloodCov_Data, "AIIC DP PFL 03 17");
		FloodCov_Name = PdfComparator.getPDFData(FileLocation + FloodCovForm);
		PdfComparator.verifyPDFText(driver, FloodCov_Name, "FLOOD COVERAGE ENDORSEMENT");
	}

	@And("User clicks Endorsement Package and validates form version <mtr2490>")
	public void User_clicks_Endorsement_Package_form_and_validates_form_version_mtr2490_() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(10);
		// Declaration page Forms and endorsement section
		EndDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 2, 30, 450, 560, 350);
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC NB GL 08 19");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, EndDec_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC FLI 07 17");
		PdfComparator.verifyFormData(driver, EndDec_Page,
				"AIIC 01 DP3 SP 04 23Special Provisions for Florida - DP 00 03 - Special Form");
		PdfComparator.verifyFormData(driver, EndDec_Page,
				"AIIC DP HD 07 15Calendar Year Hurricane Deductible Requirement");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP PFL 03 17");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP HCP 09 17Home Cyber Protection Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page,
				"AIIC DP3 HSPSL 07 15Home Systems Protection and Service Line Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP3 IR 07 15Identity Recovery Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page,
				"AIIC DP CPS 07 15Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page, "DP 04 73 07 88Limited Theft Coverage");
		

		EndDec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 3, 30, 80, 560, 190);
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP LWD 12 18Limited Water Damages");
		PdfComparator.verifyFormData(driver, EndDec_Page2,
				"AIIC DP RCC 07 15Personal Property Replacement Cost Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP SK 07 15Sinkhole Loss Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP WDX 12 18Water Damage Exclusion ");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "OIR B1 1670Checklist of Coverage");
		PdfComparator.verifyFormData(driver, EndDec_Page2,
				"OIR B1 1655Notice of Premium Discounts for Hurricane Loss Mitigation");
		PdfComparator.verifyFormData(driver, EndDec_Page2, "AIIC NCR 08 19");

		// Declaration Page
		Declaration_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 1, 70, 740, 100, 50);
		PdfComparator.verifyFormData(driver, Declaration_Version, "AIIC DP DEC 04 23");

		Declaration_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, Declaration_Data, "AIIC DP DEC 04 23");

		// Flood information
		EndFloodInfo_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 6, 460, 35, 100,
				35);
		PdfComparator.verifyFormData(driver, EndFloodInfo_Version1, "AIIC FLI 07 17");
		EndFloodInfo_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 6, 70, 730, 100,
				30);
		PdfComparator.verifyFormData(driver, EndFloodInfo_Version, "AIIC FLI 07 17");

		EndFloodInfo_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndFloodInfo_Data, "AIIC FLI 07 17");
		EndFloodInfo_Name = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndFloodInfo_Name, "FLOOD INFORMATION FORM");

		// Flood coverage
		EndFloodCov_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 7, 65, 710, 100, 30);
		PdfComparator.verifyFormData(driver, EndFloodCov_Version, "AIIC DP PFL 03 17");

		EndFloodCov_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndFloodCov_Data, "AIIC DP PFL 03 17");
		EndFloodCov_Name = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndFloodCov_Name, "FLOOD COVERAGE ENDORSEMENT");
	}

	@And("User changes system date to endorsement date <mtr2490>")
	public void User_changes_system_date_to_endorsement_date_mtr2490_() throws Exception {
		ChangeDate_Admin(driver, endorseDate);
	}

	@When("User sets loss date as endorse date <mtr2490>")
	public void user_sets_loss_date_as_endorse_date_mtr2490() {
		sendText(claim.txtLossDate, endorseDate);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as Collapse and clicks Save <mtr2490>")
	public void user_selects_loss_cause_as_collapse_and_clicks_save_mtr2490() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collapse");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User completes all required information on claim chevron <mtr2490>")
	public void user_completes_all_reqiured_information_on_claim_chevron_mtr2490() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Forms verification");
	}

	@When("User clicks save and takes note of the loss number <mtr2490>")
	public void user_clicks_save_and_takes_note_of_the_loss_number_mtr2490() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Complete and takes note of the claim number <mtr2490>")
	public void user_clicks_complete_takes_notes_mtr2490() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <mtr2490>")
	public void user_clicks_make_payment_and_selects_cc_mtr2490() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr2490>")
	public void user_makes_payment_with_credit_card_mtr2490() throws Exception {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does Auto Renewal for the policy with batch jobs <mtr2490>")
	public void user_does_auto_renewal_mtr2490() throws Exception {

		PolicyNumberTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		driver.findElement(By.id("Tab_Policy")).click();
		wait(1);
	}

	@When("User clicks Renewal Declaration Form and validates form version <mtr2490>")
	public void user_clicks_Renewal_Declaration_Form_and_validates_form_version_mtr2490() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);
		wait(10);
		// Declaration page Forms and endorsement section
		RwlDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 30, 450, 560, 350);
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC RN GL 08 19");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP PHN CSAU 06 22");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC FLI 07 17");
		PdfComparator.verifyFormData(driver, RwlDec_Page,
				"AIIC 01 DP3 SP 04 23Special Provisions for Florida - DP 00 03 - Special Form");
		PdfComparator.verifyFormData(driver, RwlDec_Page,
				"AIIC DP HD 07 15Calendar Year Hurricane Deductible Requirement");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP PFL 03 17");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP HCP 09 17Home Cyber Protection Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page,
				"AIIC DP3 HSPSL 07 15Home Systems Protection and Service Line Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "AIIC DP3 IR 07 15Identity Recovery Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page,
				"AIIC DP CPS 07 15Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page, "DP 04 73 07 88Limited Theft Coverage");
		

		RwlDec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 11, 30, 80, 590, 170);
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP LWD 12 18Limited Water Damages");
		PdfComparator.verifyFormData(driver, RwlDec_Page2,
				"AIIC DP RCC 07 15Personal Property Replacement Cost Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP SK 07 15Sinkhole Loss Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP WDX 12 18Water Damage Exclusion ");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "OIR B1 1670Checklist of Coverage");
		PdfComparator.verifyFormData(driver, RwlDec_Page2,
				"OIR B1 1655Notice of Premium Discounts for Hurricane Loss Mitigation");
		PdfComparator.verifyFormData(driver, RwlDec_Page2, "AIIC NCR 08 19Notice of Consumer Reports Ordered and");

		// Greeting letter
		RwlGreeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, RwlGreeting_Version, "AIIC RN GL 08 19");

		RwlGreeting_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlGreeting_Data, "AIIC RN GL 08 19");

		// Privacy statement
		RwlPrivacy_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, RwlPrivacy_Version1, "AIIC PS 05 19");
		RwlPrivacy_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, RwlPrivacy_Version, "AIIC PS 05 19");

		RwlPrivacy_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPrivacy_Data, "AIIC PS 05 19");
		RwlPrivacy_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPrivacy_Name, "PRIVACY STATEMENT");

		// Roof form
		RwlRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 445, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, RwlRoofLimitation_Version1, "AIIC DP RWT 01 19");
		RwlRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 55, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, RwlRoofLimitation_Version, "AIIC DP RWT 01 19");

		RwlRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Deductible notification form
		RwlDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 450, 10, 250, 30);
		PdfComparator.verifyFormData(driver, RwlDed_Version1, "AIIC DP DO 06 23");
		RwlDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, RwlDed_Version, "AIIC DP DO 06 23");

		RwlDed_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlDed_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Policy jacket form
		RwlPolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 14, 470, 35, 250, 50);
		PdfComparator.verifyFormData(driver, RwlPolJacket_Version1, "AIIC PJ 05 19");
		RwlPolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, RwlPolJacket_Version, "AIIC PJ 05 19");

		RwlPolJacket_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPolJacket_Name, "Policy Jacket");

		// AIIC DP3 IDX 07 15 form
		RwlIDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 15, 470, 35, 150, 50);
		PdfComparator.verifyFormData(driver, RwlIDX_Version, "AIIC DP3 IDX 07 15");
		RwlIDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 15, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, RwlIDX_Version1, "AIIC DP3 IDX 07 15");

		// DP 00 03 07 88 form
		RwlDP3Special_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 16, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, RwlDP3Special_Version, "DP 00 03 07 88");

		// AIIC 01 DP3 SP 04 23 form
		RwlSPProvision_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 27, 440, 20, 120, 30);
		PdfComparator.verifyFormData(driver, RwlSPProvision_Version, "AIIC 01 DP3 SP 04 23");
		RwlSPProvision_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 28, 30, 760, 120,
				25);
		PdfComparator.verifyFormData(driver, RwlSPProvision_Version1, "AIIC 01 DP3 SP 04 23");

		RwlSPProvision_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSPProvision_Name, "SPECIAL PROVISIONS FOR FLORIDA");

		// Flood information
		RwlFloodInfo_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 25, 460, 35, 100, 35);
		PdfComparator.verifyFormData(driver, RwlFloodInfo_Version1, "AIIC FLI 07 17");
		RwlFloodInfo_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 25, 70, 730, 100, 30);
		PdfComparator.verifyFormData(driver, RwlFloodInfo_Version, "AIIC FLI 07 17");

		RwlFloodInfo_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlFloodInfo_Data, "AIIC FLI 07 17");
		RwlFloodInfo_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlFloodInfo_Name, "FLOOD INFORMATION FORM");

		// AIIC DP HD 07 15 form
		RwlHurDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 42, 470, 25, 100, 40);
		PdfComparator.verifyFormData(driver, RwlHurDed_Version, "AIIC DP HD 07 15");
		RwlHurDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 42, 60, 740, 100, 40);
		PdfComparator.verifyFormData(driver, RwlHurDed_Version1, "AIIC DP HD 07 15");

		RwlHurDed_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHurDed_Name, "CALENDAR YEAR HURRICANE DEDUCTIBLE");

		// Home Cyber Protection Coverage form
		RwlCyber_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 68, 450, 25, 120, 40);
		PdfComparator.verifyFormData(driver, RwlCyber_Version, "AIIC DP HCP 09 17");
		RwlCyber_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 68, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlCyber_Version1, "AIIC DP HCP 09 17");

		RwlCyber_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlCyber_Name, "HOME CYBER PROTECTION COVERAGE");

		// Flood coverage
		RwlFloodCov_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 47, 65, 710, 100, 30);
		PdfComparator.verifyFormData(driver, RwlFloodCov_Version, "AIIC DP PFL 03 17");

		RwlFloodCov_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlFloodCov_Data, "AIIC DP PFL 03 17");
		RwlFloodCov_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlFloodCov_Name, "FLOOD COVERAGE ENDORSEMENT");

		// Home Systems Protection & Service Line Coverage
		RwlHSPSL_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 75, 440, 25, 120, 40);
		PdfComparator.verifyFormData(driver, RwlHSPSL_Version, "AIIC DP3 HSPSL 07 15");
		RwlHSPSL_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 75, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlHSPSL_Version1, "AIIC DP3 HSPSL 07 15");

		RwlHSPSL_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHSPSL_Name, "HOME SYSTEMS PROTECTION & SERVICE LINE COVERAGE");

		// Identity Recovery Coverage form
		RwlIR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 80, 440, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlIR_Version, "AIIC DP3 IR 07 15");
		RwlIR_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 80, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlIR_Version1, "AIIC DP3 IR 07 15");

		RwlIR_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlIR_Name, "IDENTITY RECOVERY COVERAGE");

		// Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage form
		RwlCarpool_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 82, 470, 25, 120, 40);
		PdfComparator.verifyFormData(driver, RwlCarpool_Version, "AIIC DP CPS 07 15");
		RwlCarpool_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 82, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlCarpool_Version1, "AIIC DP CPS 07 15");

		RwlCarpool_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlCarpool_Name, "LIMITED CARPORT(S), POOL CAGE(S) AND SCREEN");

		// AIIC DP LFC 07 15 form
		RwlFungi_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 83, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlFungi_Version, "AIIC DP LFC 07 15");
		RwlFungi_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 83, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlFungi_Version1, "AIIC DP LFC 07 15");

		RwlFungi_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlFungi_Name, "MOLD, WET OR DRY ROT, OR BACTERIA");

		// Limited Theft Coverage form
		RwlTheft_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 84, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlTheft_Version, "DP 04 73 07 88");
		RwlTheft_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 84, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, RwlTheft_Version1, "DP 04 73 07 88");

		RwlTheft_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlTheft_Name, "LIMITED THEFT COVERAGE");

		// Loss Assessment form
		RwlLoss_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 86, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlLoss_Version, "AIIC DP LA 07 15");
		RwlLoss_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 86, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RwlLoss_Version1, "AIIC DP LA 07 15");

		RwlLoss_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlLoss_Name, "LOSS ASSESSMENT PROPERTY COVERAGE");

		// Ordinance or Law Coverage form
		RwlOrdinance_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 87, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlOrdinance_Version, "AIIC DP OL 07 15");
		RwlOrdinance_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 87, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RwlOrdinance_Version1, "AIIC DP OL 07 15");

		RwlOrdinance_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlOrdinance_Name, "ORDINANCE OR LAW COVERAGE");

		// LIMITED WATER DAMAGE COVERAGE form
		RwlLimitedWater_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 88, 455, 30, 120,
				40);
		PdfComparator.verifyFormData(driver, RwlLimitedWater_Version, "AIIC DP LWD 12 18");
		RwlLimitedWater_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 88, 60, 735, 120,
				30);
		PdfComparator.verifyFormData(driver, RwlLimitedWater_Version1, "AIIC DP LWD 12 18");

		RwlLimitedWater_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlLimitedWater_Name, "LIMITED WATER DAMAGE COVERAGE");

		// Personal Property Replacement Cost Coverage form
		RwlRCC_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 89, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlRCC_Version, "AIIC DP RCC 07 15");
		RwlRCC_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 89, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RwlRCC_Version1, "AIIC DP RCC 07 15");

		RwlRCC_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlRCC_Name, "PERSONAL PROPERTY REPLACEMENT COST COVERAGE");

		// SINKHOLE LOSS COVERAGE form
		RwlSinkhole_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 91, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlSinkhole_Version, "AIIC DP SK 07 15");
		RwlSinkhole_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 91, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, RwlSinkhole_Version1, "AIIC DP SK 07 15");

		RwlSinkhole_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSinkhole_Name, "SINKHOLE LOSS COVERAGE");

		// AIIC DP WDX 12 18 form
		RwlWDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 94, 450, 40, 120, 40);
		PdfComparator.verifyFormData(driver, RwlWDX_Version, "AIIC DP WDX 12 18");
		RwlWDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 94, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlWDX_Version1, "AIIC DP WDX 12 18");

		RwlWDX_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlWDX_Name, "WATER DAMAGE EXCLUSION");

		// OUTLINE OF YOUR DWELLING POLICY form
		RwlOutline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 95, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlOutline_Version, "AIIC DP3 OC 12 18");
		RwlOutline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 95, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlOutline_Version1, "AIIC DP3 OC 12 18");

		RwlOutline_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlOutline_Name, "OUTLINE OF YOUR DWELLING POLICY");

		// Checklist form
		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 99, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");

		RwlCheckList_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlCheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		RwlHurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 102, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, RwlHurMitigation_Version, "OIR-B1-1655");

		RwlHurMitigation_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		RwlConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 103, 30, 710, 100, 30);
		PdfComparator.verifyFormData(driver, RwlConsReport_Version, "AIIC NCR 08 19");

		RwlConsReport_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlConsReport_Name, "Notice of Consumer Reports Ordered and Information");

		// Sinkhole Loss Coverage Selection/Rejection Form form
		RwlSKSR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 104, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, RwlSKSR_Version, "AIIC SKSR 11 14");
		RwlSKSR_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 104, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, RwlSKSR_Version1, "AIIC SKSR 11 14");

		RwlSKSR_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSKSR_Name, "Sinkhole Loss Coverage Selection/Rejection Form");
	}

	@When("User clicks Make Payment and do renewal payment <mtr2490>")
	public void user_clicks_make_payment_and_do_renewal_payment_mtr2490() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_1"))); // pay with existing credit card
		wait(1);
		totalDueRenewal = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDueRenewal);
		wait(4);

		click(driver.findElement(By.id("SubmitPayment")));
		wait(1);
		click(driver.findElement(By.id("dialogOK")));
		wait(10);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User clicks Finalize button and completes renewal <mtr2490>")
	public void user_clicks_finalize_button_and_completes_renewal_mtr2490() {
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(12);
		closeUnnecessaryTabs();
	}

	@When("User searches for renewed second term the policy number <mtr2490>")
	public void user_searches_renewed_second_term_policy_for_mtr2490() {
		sendText(dashboard.txtSearchBar, PolicyNumberTerm02);
		click(dashboard.search);
		wait(3);
	}

	@When("User searches third term manually renewed policy")
	public void user_searches_third_term_manually_renewed_policy() throws InterruptedException {
		temp2 = replaceMethod(PolicyNumberTerm02, "-02", "");
		PolicyNumberTerm03 = temp2 + "-03";
		Thread.sleep(15000);
		sendText(dashboard.txtSearchBar, PolicyNumberTerm03);
		click(dashboard.search);
		wait(3);
	}

	@Then("User clicks Second Renewal Declaration and validate form version <mtr2490> and completes test")
	public void user_clicks_Second_Renewal_Declaration_and_validate_form_Version_mtr2490() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		Rwl2Dec_Form = PdfComparator.makePdf(driver, "Renewal2_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Rwl2Dec_Form);
		wait(10);

		// Declaration page Forms and endorsement section
		Rwl2Dec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 10, 30, 450, 560, 350);
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC RN GL 08 19");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP PHN CSAU 06 22");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC PS 05 19Privacy Statement");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP DO 06 23Deductible Notification Options");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC PJ 05 19Policy Jacket");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP3 IDX 07 15Dwelling Property 3 Special Form Index");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "DP 00 03 07 88Dwelling Property 3 Special Form");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC FLI 07 17");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page,
				"AIIC 01 DP3 SP 04 23Special Provisions for Florida - DP 00 03 - Special Form");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page,
				"AIIC DP HD 07 15Calendar Year Hurricane Deductible Requirement");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP PFL 03 17");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP HCP 09 17Home Cyber Protection Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page,
				"AIIC DP3 HSPSL 07 15Home Systems Protection and Service Line Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "AIIC DP3 IR 07 15Identity Recovery Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page,
				"AIIC DP CPS 07 15Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page,
				"AIIC DP LFC 07 15Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page, "DP 04 73 07 88Limited Theft Coverage");
		

		Rwl2Dec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 11, 30, 80, 590, 170);
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP LA 07 15Loss Assessment Property Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP OL 07 15Ordinance or Law Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP LWD 12 18Limited Water Damages");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2,
				"AIIC DP RCC 07 15Personal Property Replacement Cost Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP SK 07 15Sinkhole Loss Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP WDX 12 18Water Damage Exclusion ");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC DP3 OC 12 18Outline of your Dwelling Policy");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "OIR B1 1670Checklist of Coverage");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2,
				"OIR B1 1655Notice of Premium Discounts for Hurricane Loss Mitigation");
		PdfComparator.verifyFormData(driver, Rwl2Dec_Page2, "AIIC NCR 08 19Notice of Consumer Reports Ordered and");

		// Greeting letter
		Rwl2Greeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, Rwl2Greeting_Version, "AIIC RN GL 08 19");

		Rwl2Greeting_Data = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Greeting_Data, "AIIC RN GL 08 19");

		// Privacy statement
		Rwl2Privacy_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 4, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, Rwl2Privacy_Version1, "AIIC PS 05 19");
		Rwl2Privacy_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 4, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, Rwl2Privacy_Version, "AIIC PS 05 19");

		Rwl2Privacy_Data = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Privacy_Data, "AIIC PS 05 19");
		Rwl2Privacy_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Privacy_Name, "PRIVACY STATEMENT");

		// Roof form
		Rwl2RoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 5, 445, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, Rwl2RoofLimitation_Version1, "AIIC DP RWT 01 19");
		Rwl2RoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 5, 55, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, Rwl2RoofLimitation_Version, "AIIC DP RWT 01 19");

		Rwl2RoofLimitation_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2RoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Deductible notification form
		Rwl2Ded_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 7, 450, 10, 250, 30);
		PdfComparator.verifyFormData(driver, Rwl2Ded_Version1, "AIIC DP DO 06 23");
		Rwl2Ded_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 7, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, Rwl2Ded_Version, "AIIC DP DO 06 23");

		Rwl2Ded_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Ded_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Policy jacket form
		Rwl2PolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 14, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, Rwl2PolJacket_Version1, "AIIC PJ 05 19");
		Rwl2PolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, Rwl2PolJacket_Version, "AIIC PJ 05 19");

		Rwl2PolJacket_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2PolJacket_Name, "Policy Jacket");

		// AIIC DP3 IDX 07 15 form
		Rwl2IDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 15, 470, 35, 150, 50);
		PdfComparator.verifyFormData(driver, Rwl2IDX_Version, "AIIC DP3 IDX 07 15");
		Rwl2IDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 15, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, Rwl2IDX_Version1, "AIIC DP3 IDX 07 15");

		// DP 00 03 07 88 form
		Rwl2DP3Special_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 16, 40, 750, 120,
				30);
		PdfComparator.verifyFormData(driver, Rwl2DP3Special_Version, "DP 00 03 07 88");

		// AIIC 01 DP3 SP 04 23 form
		Rwl2SPProvision_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 27, 440, 20, 120,
				30);
		PdfComparator.verifyFormData(driver, Rwl2SPProvision_Version, "AIIC 01 DP3 SP 04 23");
		Rwl2SPProvision_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 28, 30, 760, 120,
				25);
		PdfComparator.verifyFormData(driver, Rwl2SPProvision_Version1, "AIIC 01 DP3 SP 04 23");

		Rwl2SPProvision_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SPProvision_Name, "SPECIAL PROVISIONS FOR FLORIDA");

		// Flood information
		Rwl2FloodInfo_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 25, 460, 35, 100,
				35);
		PdfComparator.verifyFormData(driver, Rwl2FloodInfo_Version1, "AIIC FLI 07 17");
		Rwl2FloodInfo_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 25, 70, 730, 100, 30);
		PdfComparator.verifyFormData(driver, Rwl2FloodInfo_Version, "AIIC FLI 07 17");

		Rwl2FloodInfo_Data = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2FloodInfo_Data, "AIIC FLI 07 17");
		Rwl2FloodInfo_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2FloodInfo_Name, "FLOOD INFORMATION FORM");

		// AIIC DP HD 07 15 form
		Rwl2HurDed_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 42, 470, 25, 100, 40);
		PdfComparator.verifyFormData(driver, Rwl2HurDed_Version, "AIIC DP HD 07 15");
		Rwl2HurDed_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 42, 60, 740, 100, 40);
		PdfComparator.verifyFormData(driver, Rwl2HurDed_Version1, "AIIC DP HD 07 15");

		Rwl2HurDed_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HurDed_Name, "CALENDAR YEAR HURRICANE DEDUCTIBLE");

		// Home Cyber Protection Coverage form
		Rwl2Cyber_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 68, 450, 25, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Cyber_Version, "AIIC DP HCP 09 17");
		Rwl2Cyber_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 68, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Cyber_Version1, "AIIC DP HCP 09 17");

		Rwl2Cyber_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Cyber_Name, "HOME CYBER PROTECTION COVERAGE");

		// Flood coverage
		Rwl2FloodCov_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 47, 65, 710, 100, 30);
		PdfComparator.verifyFormData(driver, Rwl2FloodCov_Version, "AIIC DP PFL 03 17");

		Rwl2FloodCov_Data = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2FloodCov_Data, "AIIC DP PFL 03 17");
		Rwl2FloodCov_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2FloodCov_Name, "FLOOD COVERAGE ENDORSEMENT");

		// Home Systems Protection & Service Line Coverage
		Rwl2HSPSL_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 75, 440, 25, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2HSPSL_Version, "AIIC DP3 HSPSL 07 15");
		Rwl2HSPSL_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 75, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2HSPSL_Version1, "AIIC DP3 HSPSL 07 15");

		Rwl2HSPSL_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HSPSL_Name, "HOME SYSTEMS PROTECTION & SERVICE LINE COVERAGE");

		// Identity Recovery Coverage form
		Rwl2IR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 80, 440, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2IR_Version, "AIIC DP3 IR 07 15");
		Rwl2IR_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 80, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2IR_Version1, "AIIC DP3 IR 07 15");

		Rwl2IR_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2IR_Name, "IDENTITY RECOVERY COVERAGE");

		// Limited Carport(s), Pool Cage(s) and Screen Enclosure(s) Coverage form
		Rwl2Carpool_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 82, 470, 25, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Carpool_Version, "AIIC DP CPS 07 15");
		Rwl2Carpool_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 82, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Carpool_Version1, "AIIC DP CPS 07 15");

		Rwl2Carpool_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Carpool_Name, "LIMITED CARPORT(S), POOL CAGE(S) AND SCREEN");

		// AIIC DP LFC 07 15 form
		Rwl2Fungi_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 83, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Fungi_Version, "AIIC DP LFC 07 15");
		Rwl2Fungi_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 83, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Fungi_Version1, "AIIC DP LFC 07 15");

		Rwl2Fungi_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Fungi_Name, "MOLD, WET OR DRY ROT, OR BACTERIA");

		// Limited Theft Coverage form
		Rwl2Theft_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 84, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Theft_Version, "DP 04 73 07 88");
		Rwl2Theft_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 84, 40, 750, 120, 30);
		PdfComparator.verifyFormData(driver, Rwl2Theft_Version1, "DP 04 73 07 88");

		Rwl2Theft_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Theft_Name, "LIMITED THEFT COVERAGE");

		// Loss Assessment form
		Rwl2Loss_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 86, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Loss_Version, "AIIC DP LA 07 15");
		Rwl2Loss_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 86, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Rwl2Loss_Version1, "AIIC DP LA 07 15");

		Rwl2Loss_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Loss_Name, "LOSS ASSESSMENT PROPERTY COVERAGE");

		// Ordinance or Law Coverage form
		Rwl2Ordinance_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 87, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Ordinance_Version, "AIIC DP OL 07 15");
		Rwl2Ordinance_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 87, 60, 740, 120,
				30);
		PdfComparator.verifyFormData(driver, Rwl2Ordinance_Version1, "AIIC DP OL 07 15");

		Rwl2Ordinance_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Ordinance_Name, "ORDINANCE OR LAW COVERAGE");

		// LIMITED WATER DAMAGE COVERAGE form
		Rwl2LimitedWater_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 88, 455, 30, 120,
				40);
		PdfComparator.verifyFormData(driver, Rwl2LimitedWater_Version, "AIIC DP LWD 12 18");
		Rwl2LimitedWater_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 88, 60, 735, 120,
				30);
		PdfComparator.verifyFormData(driver, Rwl2LimitedWater_Version1, "AIIC DP LWD 12 18");

		Rwl2LimitedWater_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2LimitedWater_Name, "LIMITED WATER DAMAGE COVERAGE");

		// Personal Property Replacement Cost Coverage form
		Rwl2RCC_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 89, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2RCC_Version, "AIIC DP RCC 07 15");
		Rwl2RCC_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 89, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Rwl2RCC_Version1, "AIIC DP RCC 07 15");

		Rwl2RCC_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2RCC_Name, "PERSONAL PROPERTY REPLACEMENT COST COVERAGE");

		// SINKHOLE LOSS COVERAGE form
		Rwl2Sinkhole_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 91, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Sinkhole_Version, "AIIC DP SK 07 15");
		Rwl2Sinkhole_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 91, 60, 740, 120, 30);
		PdfComparator.verifyFormData(driver, Rwl2Sinkhole_Version1, "AIIC DP SK 07 15");

		Rwl2Sinkhole_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Sinkhole_Name, "SINKHOLE LOSS COVERAGE");

		// AIIC DP WDX 12 18 form
		Rwl2WDX_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 94, 450, 40, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2WDX_Version, "AIIC DP WDX 12 18");
		Rwl2WDX_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 94, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2WDX_Version1, "AIIC DP WDX 12 18");

		Rwl2WDX_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2WDX_Name, "WATER DAMAGE EXCLUSION");

		// OUTLINE OF YOUR DWELLING POLICY form
		Rwl2Outline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 95, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Outline_Version, "AIIC DP3 OC 12 18");
		Rwl2Outline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 95, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2Outline_Version1, "AIIC DP3 OC 12 18");

		Rwl2Outline_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Outline_Name, "OUTLINE OF YOUR DWELLING POLICY");

		// Checklist form
		Rwl2CheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 99, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, Rwl2CheckList_Version, "OIR-B1-1670");

		Rwl2CheckList_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2CheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		Rwl2HurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 102, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, Rwl2HurMitigation_Version, "OIR-B1-1655");

		Rwl2HurMitigation_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		Rwl2ConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 103, 30, 710, 100,
				30);
		PdfComparator.verifyFormData(driver, Rwl2ConsReport_Version, "AIIC NCR 08 19");

		Rwl2ConsReport_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2ConsReport_Name, "Notice of Consumer Reports Ordered and Information");

		// Sinkhole Loss Coverage Selection/Rejection Form form
		Rwl2SKSR_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 104, 460, 30, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2SKSR_Version, "AIIC SKSR 11 14");
		Rwl2SKSR_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 104, 60, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Rwl2SKSR_Version1, "AIIC SKSR 11 14");

		Rwl2SKSR_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SKSR_Name, "Sinkhole Loss Coverage Selection/Rejection Form");
		Hooks.scenario.log("Test Case Completed!");
	}
}
