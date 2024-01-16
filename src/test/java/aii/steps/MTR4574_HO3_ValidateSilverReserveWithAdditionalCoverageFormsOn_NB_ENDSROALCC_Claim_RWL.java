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
import io.cucumber.java.en.When;

public class MTR4574_HO3_ValidateSilverReserveWithAdditionalCoverageFormsOn_NB_ENDSROALCC_Claim_RWL
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime newBusinessDate = currentDate.plusDays(30);
	static LocalDateTime endorseDate = newBusinessDate.plusDays(30);
	static String policyNum;
	static String lossNum;
	static String claimNum;
	static String totalDueRenewal;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String QuoteForm;
	static String Quote_Version;
	static String Quote_Data;
	static String Reserve_Version;
	static String Reserve_Data;
	static String GreetingForm;
	static String Greeting_Version;
	static String Greeting_Data;
	static String PrivacyForm;
	static String Privacy_Version1;
	static String Privacy_Version;
	static String Privacy_Data;
	static String DeductibleNotiForm;
	static String DeductibleNoti_Version1;
	static String DeductibleNoti_Version;
	static String DeductibleNoti_Data;
	static String RoofLimitationForm;
	static String RoofLimitation_Version1;
	static String RoofLimitation_Version;
	static String RoofLimitation_Data;
	static String PolJacketForm;
	static String PolJacket_Version1;
	static String PolJacket_Version;
	static String PolJacket_Data;
	static String HomeOwners_Form;
	static String HomeOwners_Version1;
	static String HomeOwners_Version;
	static String HomeOwners_Data;
	static String HCP_Form;
	static String HCP_Version1;
	static String HCP_Version;
	static String HCP_Data;
	static String PPD_Form;
	static String PPD_Version1;
	static String PPD_Version;
	static String PPD_Data;
	static String SerLine_Form;
	static String SerLine_Version1;
	static String SerLine_Version;
	static String SerLine_Data;
	static String Silver_Form;
	static String Silver_Version1;
	static String Silver_Version;
	static String Silver_Data;
	static String Outline_Form;
	static String Outline_Version1;
	static String Outline_Version;
	static String Outline_Data;
	static String CheckList_Form;
	static String CheckList_Version;
	static String CheckList_Data;
	static String HurMitigation_Form;
	static String HurMitigation_Version;
	static String HurMitigation_Data;
	static String ConsReport_Form;
	static String ConsReport_Version;
	static String ConsReport_Data;
	static String HO3App_Form;
	static String HO3App_Version;
	static String HO3App_Name;
	static String NBPackage_Form;
	static String NBDecPage;
	static String NBGreeting_Version;
	static String NBGreeting_Data;
	static String NBPrivacy_VersionTop;
	static String NBPrivacy_VersionBottom;
	static String NBPrivacy_Data;
	static String NBPrivacy_Name;
	static String NBDeductibleNoti_Version1;
	static String NBDeductibleNoti_Version;
	static String NBDeductibleNoti_Data;
	static String NBDeductibleNoti_Name;
	static String NBRoofLimitation_Version1;
	static String NBRoofLimitation_Version;
	static String NBRoofLimitation_Data;
	static String NBRoofLimitation_Name;
	static String NBPolJacket_Version1;
	static String NBPolJacket_Version;
	static String NBPolJacket_Data;
	static String NBPolJacket_Name;
	static String NBHomeOwners_Version1;
	static String NBHomeOwners_Version;
	static String NBHomeOwners_Data;
	static String NBHomeOwners_Name;
	static String NBPPD_Version1;
	static String NBPPD_Version;
	static String NBPPD_Data;
	static String NBPPD_Name;
	static String NBSerLine_Version1;
	static String NBSerLine_Version;
	static String NBSerLine_Data;
	static String NBSerLine_Name;
	static String NBSilver_Version1;
	static String NBSilver_Version;
	static String NBSilver_Data;
	static String NBSilver_Name;
	static String NBOutline_Version1;
	static String NBOutline_Version;
	static String NBOutline_Data;
	static String NBOutline_Name;
	static String NBCheckList_Version;
	static String NBCheckList_Data;
	static String NBCheckList_Name;
	static String NBHurMitigation_Version;
	static String NBHurMitigation_Data;
	static String NBHurMitigation_Name;
	static String NBConsReport_Version;
	static String NBConsReport_Data;
	static String NBConsReport_Name;
	static String AsstLivingForm;
	static String AsstLiving_Version1;
	static String AsstLiving_Version;
	static String AsstLiving_Data;
	static String AsstLiving_Name;
	static String SROForm;
	static String SRO_Version1;
	static String SRO_Version;
	static String SRO_Data;
	static String SRO_Name;
	static String EndPackage_Form;
	static String EndDecPage;
	static String EndDecPage2;
	static String ENDAsstLiving_Version1;
	static String ENDAsstLiving_Version;
	static String ENDAsstLiving_Data;
	static String ENDAsstLiving_Name;
	static String ENDSRO_Version1;
	static String ENDSRO_Version;
	static String ENDSRO_Data;
	static String ENDSRO_Name;
	static String totalDue;
	static String PolicyNumberTerm02;
	static String RwlDec_Form;
	static String RwlDecPage;
	static String RwlDecPage2;
	static String RwlGreeting_Version;
	static String RwlGreeting_Data;
	static String RwlPrivacy_VersionTop;
	static String RwlPrivacy_VersioRwlottom;
	static String RwlPrivacy_Name;
	static String RwlDeductibleNoti_Version1;
	static String RwlDeductibleNoti_Version;
	static String RwlDeductibleNoti_Name;
	static String RwlRoofLimitation_Version1;
	static String RwlRoofLimitation_Version;
	static String RwlRoofLimitation_Data;
	static String RwlRoofLimitation_Name;
	static String RwlPolJacket_Version1;
	static String RwlPolJacket_Version;
	static String RwlPolJacket_Data;
	static String RwlPolJacket_Name;
	static String RwlHomeOwners_Version1;
	static String RwlHomeOwners_Version;
	static String RwlHomeOwners_Data;
	static String RwlHomeOwners_Name;
	static String RwlPPD_Version1;
	static String RwlPPD_Version;
	static String RwlPPD_Data;
	static String RwlPPD_Name;
	static String RwlSerLine_Version1;
	static String RwlSerLine_Version;
	static String RwlSerLine_Data;
	static String RwlSerLine_Name;
	static String RwlSilver_Version1;
	static String RwlSilver_Version;
	static String RwlSilver_Data;
	static String RwlSilver_Name;
	static String RwlOutline_Version1;
	static String RwlOutline_Version;
	static String RwlOutline_Data;
	static String RwlOutline_Name;
	static String RwlCheckList_Version;
	static String RwlCheckList_Data;
	static String RwlCheckList_Name;
	static String RwlHurMitigation_Version;
	static String RwlHurMitigation_Data;
	static String RwlHurMitigation_Name;
	static String RwlConsReport_Version;
	static String RwlConsReport_Data;
	static String RwlConsReport_Name;
	static String RwlAsstLiving_Version1;
	static String RwlAsstLiving_Version;
	static String RwlAsstLiving_Data;
	static String RwlAsstLiving_Name;
	static String RwlSRO_Version1;
	static String RwlSRO_Version;
	static String RwlSRO_Data;
	static String RwlSRO_Name;
	static String RwlDec2_Form;
	static String Rwl2DecPage;
	static String Rwl2DecPage2;
	static String Rwl2Greeting_Version;
	static String Rwl2Greeting_Data;
	static String Rwl2Privacy_VersionTop;
	static String Rwl2Privacy_VersioRwl2ottom;
	static String Rwl2Privacy_Name;
	static String Rwl2DeductibleNoti_Version1;
	static String Rwl2DeductibleNoti_Version;
	static String Rwl2DeductibleNoti_Name;
	static String Rwl2RoofLimitation_Version1;
	static String Rwl2RoofLimitation_Version;
	static String Rwl2RoofLimitation_Data;
	static String Rwl2RoofLimitation_Name;
	static String Rwl2PolJacket_Version1;
	static String Rwl2PolJacket_Version;
	static String Rwl2PolJacket_Data;
	static String Rwl2PolJacket_Name;
	static String Rwl2HomeOwners_Version1;
	static String Rwl2HomeOwners_Version;
	static String Rwl2HomeOwners_Data;
	static String Rwl2HomeOwners_Name;
	static String Rwl2PPD_Version1;
	static String Rwl2PPD_Version;
	static String Rwl2PPD_Data;
	static String Rwl2PPD_Name;
	static String Rwl2SerLine_Version1;
	static String Rwl2SerLine_Version;
	static String Rwl2SerLine_Data;
	static String Rwl2SerLine_Name;
	static String Rwl2Silver_Version1;
	static String Rwl2Silver_Version;
	static String Rwl2Silver_Data;
	static String Rwl2Silver_Name;
	static String Rwl2Outline_Version1;
	static String Rwl2Outline_Version;
	static String Rwl2Outline_Data;
	static String Rwl2Outline_Name;
	static String Rwl2CheckList_Version;
	static String Rwl2CheckList_Data;
	static String Rwl2CheckList_Name;
	static String Rwl2HurMitigation_Version;
	static String Rwl2HurMitigation_Data;
	static String Rwl2HurMitigation_Name;
	static String Rwl2ConsReport_Version;
	static String Rwl2ConsReport_Data;
	static String Rwl2ConsReport_Name;
	static String Rwl2AsstLiving_Version1;
	static String Rwl2AsstLiving_Version;
	static String Rwl2AsstLiving_Data;
	static String Rwl2AsstLiving_Name;
	static String Rwl2SRO_Version1;
	static String Rwl2SRO_Version;
	static String Rwl2SRO_Data;
	static String Rwl2SRO_Name;

	@When("User enters all required information on policy information screen <tc16404>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16404() {

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

	@When("User enters HO3 product selection information and new business date as effective date <tc16404>")
	public void user_enters_ho3_product_selection_information_and_new_business_date_as_effective_date_tc16404() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(newBusinessDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <tc16404>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc16404() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		waitImp(5);
		getInsuranceScore(driver, "Neutral");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO3 dwelling screen and selects silver reserve and add additional coverages <tc16404>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc16404() {

		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.bCEG, "4");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "10 mi to less than 15 mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2022");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);

		// Select Silver reserve package and additional coverages which not already
		// included in the package
		click(dwellingChevron.rbSilverReserve);
		selectDropdownText(dwellingChevron.ddHomeCyberProtection, "$25,000");
		selectDropdownText(dwellingChevron.ddServiceLine, "$10,000");

		// Additional Options
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$50,000");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.rbIncreasedDwellingReplacementCost);
		click(dwellingChevron.rbSpecialPersonalProperty);

		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		waitImp(3);
	}

	@When("User clicks Print button on quote and validates quote form version")
	public void user_clicks_Print_button_on_quote_and_validates_quote_form_version() throws Exception {
		click(driver.findElement(By.id("PrintQuote")));
		wait(5);
		switchToWindow(driver, "UWQuote");
		QuoteForm = PdfComparator.makePdf(driver, "Ho3Quote.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + QuoteForm);

		wait(10);
		Quote_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + QuoteForm, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version, "AIIC QT 07 19");

		Quote_Data = PdfComparator.getPDFData(FileLocation + QuoteForm);
		PdfComparator.verifyPDFText(driver, Quote_Data, "AIIC QT 07 19");

		// AIIC HO3 RB 07 18 form
		Reserve_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + QuoteForm, 3, 35, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Reserve_Version, "AIIC HO3 RB 07 18");

		Reserve_Data = PdfComparator.getPDFData(FileLocation + QuoteForm);
		PdfComparator.verifyPDFText(driver, Reserve_Data, "AIIC HO3 RB 07 18");
	}

	@When("User completes required information on dwelling chevron and updates years updated sections <tc16404>")
	public void user_completes_required_information_on_dwelling_chevron_tc16404() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		sendText(dwellingChevron.txtHvacYearUpdate, "2022");
		sendText(dwellingChevron.txtYearElectrical, "2022");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2022");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <tc16404>")
	public void User_clicks_Finalize_button_tc16404() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc16404>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc16404()
			throws Exception {
		wait(5);
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

	@When("User clicks Forms Chevron <tc16404>")
	public void user_clicks_forms_chevron_tc16404() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates all expected forms to be listed")
	public void user_validates_all_expected_forms_to_be_listed() throws Exception {

		// greeting letter
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC GL 08 19')]"));
			Hooks.scenario.log("Form: Greeting Letter displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Greeting Letter NOT displayed");
			wait(5);
		}

		// privacy statement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form NOT displayed");
			wait(5);
		}

		// deductible notification
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 DO 07 19')]"));
			Hooks.scenario.log("Form: Deductible Notification Options displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options NOT displayed");
			wait(5);
		}

		// limitations roof coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage NOT displayed");
			wait(5);
		}

		// policy jacket
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 07 15')]"));
			Hooks.scenario.log("Form: Policy Jacket displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Policy Jacket NOT displayed");
			wait(5);
		}

		// owner special form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 04 23')]"));
			Hooks.scenario.log("Homeowners 3 Special Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Homeowners 3 Special Form NOT displayed");
			wait(5);
		}

		// animal liability
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO AL 02 22')]"));
			Hooks.scenario.log("Form: Animal Liability Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Animal Liability Coverage NOT displayed");
			wait(5);
		}

		// dwelling replacement cost coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DRC 11 14')]"));
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form NOT displayed");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC HCP 08 17");

		// premises protective
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PPD 11 14')]"));
			Hooks.scenario.log("Premises Protective Devices Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Premises Protective Devices Form NOT displayed");
			wait(5);
		}

		// special personal property
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 00 15 04 91')]"));
			Hooks.scenario.log("Special Personal Property Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Special Personal Property Coverage Form NOT displayed");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC SL 11 14");
		verify_AnyText_IsVisible(driver, "AIIC HO3 SR 09 19");

		// outline of your homeowners policy
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 OC 07 18')]"));
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form NOT displayed");
			wait(5);
		}

		// checklist of coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form NOT displayed");
			wait(5);
		}

		// hurricane loss mitigation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655 02 10')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form NOT displayed");
			wait(5);
		}

		// notice of consumer reports ordered
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log(
					"Notice of Consumer Reports Ordered and Information Used in Premium Determination Form NOT displayed");
			wait(5);
		}
	}

	@And("User clicks greeting letter form and validates form version")
	public void User_clicks_greeting_letter_form_and_validates_form_version() throws Exception {
		wait(4);
		clickonAnyButton(driver, "AIICGL0819_View");
		wait(3);
		switchToWindow(driver, "aiic-gl-0819.pdf");
		GreetingForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + GreetingForm);

		Thread.sleep(9000);
		Greeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + GreetingForm, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, Greeting_Version, "AIIC NB GL 08 19");

		Greeting_Data = PdfComparator.getPDFData(FileLocation + GreetingForm);
		PdfComparator.verifyPDFText(driver, Greeting_Data, "AIIC NB GL 08 19");
	}

	@And("User clicks privacy statement form and validates form version")
	public void User_clicks_privacy_statement_form_and_validates_form_version() throws Exception {
		Thread.sleep(6000);
		clickonAnyButton(driver, "AIICPS0519_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ps-0519.pdf");
		PrivacyForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + PrivacyForm);

		wait(9);

		Privacy_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + PrivacyForm, 1, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, Privacy_Version1, "AIIC PS 05 19");
		Privacy_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + PrivacyForm, 1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, Privacy_Version, "AIIC PS 05 19");

		Privacy_Data = PdfComparator.getPDFData(FileLocation + PrivacyForm);
		PdfComparator.verifyPDFText(driver, Privacy_Data, "AIIC PS 05 19");
	}

	@And("User clicks deductible notification form and validates form version")
	public void User_clicks_deductible_notification_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICDO0719_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ho3-do-0719.pdf");
		DeductibleNotiForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + DeductibleNotiForm);

		wait(9);
		DeductibleNoti_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeductibleNotiForm, 1, 470, 35,
				250, 50);
		PdfComparator.verifyFormData(driver, DeductibleNoti_Version1, "AIIC HO3 DO 07 19");
		DeductibleNoti_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeductibleNotiForm, 1, 70, 740,
				250, 50);
		PdfComparator.verifyFormData(driver, DeductibleNoti_Version, "AIIC HO3 DO 07 19");

		DeductibleNoti_Data = PdfComparator.getPDFData(FileLocation + DeductibleNotiForm);
		PdfComparator.verifyPDFText(driver, DeductibleNoti_Data, "AIIC HO3 DO 07 19");
	}

	@And("User clicks limitation on roof form and validates form version")
	public void User_clicks_limitations_on_roof_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICRWT_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-rwt-0119.pdf");
		RoofLimitationForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RoofLimitationForm);

		wait(9);
		RoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RoofLimitationForm, 1, 470, 35,
				150, 30);
		PdfComparator.verifyFormData(driver, RoofLimitation_Version1, "AIIC RWT 01 19");
		RoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RoofLimitationForm, 1, 70, 750,
				150, 30);
		PdfComparator.verifyFormData(driver, RoofLimitation_Version, "AIIC RWT 01 19");

		RoofLimitation_Data = PdfComparator.getPDFData(FileLocation + RoofLimitationForm);
		PdfComparator.verifyPDFText(driver, RoofLimitation_Data, "AIIC RWT 01 19");
	}

	@And("User clicks Policy Jacket form and validates form version")
	public void User_clicks_policy_jacket_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICPJ0715_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-pj-0715.pdf");
		PolJacketForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + PolJacketForm);

		wait(9);
		PolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + PolJacketForm, 1, 470, 35, 250, 50);
		PdfComparator.verifyFormData(driver, PolJacket_Version1, "AIIC PJ 07 15");
		PolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + PolJacketForm, 1, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, PolJacket_Version, "AIIC PJ 07 15");

		PolJacket_Data = PdfComparator.getPDFData(FileLocation + PolJacketForm);
		PdfComparator.verifyPDFText(driver, PolJacket_Data, "AIIC PJ 07 15");
	}

	@And("User clicks Home Owner Special form and validates form version")
	public void User_clicks_Home_owner_special_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICHO3_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ho3-0423.pdf");
		HomeOwners_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + HomeOwners_Form);

		wait(9);
		HomeOwners_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + HomeOwners_Form, 2, 490, 30, 150, 50);
		PdfComparator.verifyFormData(driver, HomeOwners_Version1, "AIIC HO3 04 23");
		HomeOwners_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + HomeOwners_Form, 1, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, HomeOwners_Version, "AIIC HO3 04 23");

		HomeOwners_Data = PdfComparator.getPDFData(FileLocation + HomeOwners_Form);
		PdfComparator.verifyPDFText(driver, HomeOwners_Data, "AIIC HO3 04 23");
	}

	@And("User clicks Home Cyber Protection form and validates form version")
	public void User_clicks_home_cyber_protection_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICHCP_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-hcp-0817.pdf");
		HCP_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + HCP_Form);

		wait(9);
		HCP_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + HCP_Form, 1, 425, 30, 120, 30);
		PdfComparator.verifyFormData(driver, HCP_Version1, "AIIC HCP 08 17");
		HCP_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + HCP_Form, 1, 65, 740, 120, 30);
		PdfComparator.verifyFormData(driver, HCP_Version, "AIIC HCP 08 17");

		HCP_Data = PdfComparator.getPDFData(FileLocation + HCP_Form);
		PdfComparator.verifyPDFText(driver, HCP_Data, "AIIC HCP 08 17");
	}

	@And("User clicks premise protective devices form and validates form version")
	public void User_clicks_premise_protective_devices_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICPPD1114_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ppd-1114.pdf");
		PPD_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + PPD_Form);

		wait(9);
		PPD_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + PPD_Form, 1, 460, 30, 150, 30);
		PdfComparator.verifyFormData(driver, PPD_Version1, "AIIC PPD 11 14");
		PPD_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + PPD_Form, 1, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, PPD_Version, "AIIC PPD 11 14");

		PPD_Data = PdfComparator.getPDFData(FileLocation + PPD_Form);
		PdfComparator.verifyPDFText(driver, PPD_Data, "AIIC PPD 11 14");
	}

	@And("User clicks Service Line coverage form and validates form version")
	public void User_clicks_service_line_coverage_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICSL1114_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-sl-1114.pdf");
		SerLine_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + SerLine_Form);

		wait(9);
		SerLine_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + SerLine_Form, 1, 480, 35, 85, 25);
		PdfComparator.verifyFormData(driver, SerLine_Version1, "AIIC SL 11 14");
		SerLine_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + SerLine_Form, 1, 70, 740, 80, 30);
		PdfComparator.verifyFormData(driver, SerLine_Version, "AIIC SL 11 14");

		SerLine_Data = PdfComparator.getPDFData(FileLocation + SerLine_Form);
		PdfComparator.verifyPDFText(driver, SerLine_Data, "AIIC SL 11 14");
	}

	@And("User clicks Silver Coverage form and validates form version")
	public void User_clicks_silver_coverage_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICHO3SR0919_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ho3-sr-0919.pdf");
		Silver_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Silver_Form);

		wait(9);
		Silver_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Silver_Form, 1, 465, 30, 90, 30);
		PdfComparator.verifyFormData(driver, Silver_Version1, "AIIC HO3 SR 09 19");
		Silver_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Silver_Form, 1, 70, 745, 90, 15);
		PdfComparator.verifyFormData(driver, Silver_Version, "AIIC HO3 SR 09 19");

		Silver_Data = PdfComparator.getPDFData(FileLocation + Silver_Form);
		PdfComparator.verifyPDFText(driver, Silver_Data, "AIIC HO3 SR 09 19");
	}

	@And("User clicks Outline of Your Homeowners Policy form and validates form version")
	public void User_clicks_outline_of_your_homeowners_policy_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICHO3OC0718_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ho3-oc-0718.pdf");
		Outline_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Outline_Form);

		wait(9);
		Outline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Outline_Form, 1, 450, 30, 150, 50);
		PdfComparator.verifyFormData(driver, Outline_Version1, "AIIC HO3 OC 07 18");
		Outline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Outline_Form, 1, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, Outline_Version, "AIIC HO3 OC 07 18");

		Outline_Data = PdfComparator.getPDFData(FileLocation + Outline_Form);
		PdfComparator.verifyPDFText(driver, Outline_Data, "AIIC HO3 OC 07 18");
	}

	@And("User clicks Checklist of Coverage form and validates form version")
	public void User_clicks_checklist_of_coverage_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "OIRB11670_View");
		Thread.sleep(7000);
		switchToWindow(driver, "oir-b1-1670-1106.pdf");
		CheckList_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CheckList_Form);

		wait(9);
		CheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CheckList_Form, 1, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, CheckList_Version, "OIR-B1-1670");

		CheckList_Data = PdfComparator.getPDFData(FileLocation + CheckList_Form);
		PdfComparator.verifyPDFText(driver, CheckList_Data, "OIR-B1-1670");
	}

	@And("User clicks Hurricane Loss Mitigation form and validates form version")
	public void User_clicks_hurricane_loss_mitigation_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "OIRB11655_View");
		Thread.sleep(7000);
		switchToWindow(driver, "oir-b1-1655-0210.pdf");
		HurMitigation_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + HurMitigation_Form);

		wait(9);
		HurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + HurMitigation_Form, 1, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, HurMitigation_Version, "OIR-B1-1655");

		HurMitigation_Data = PdfComparator.getPDFData(FileLocation + HurMitigation_Form);
		PdfComparator.verifyPDFText(driver, HurMitigation_Data, "OIR-B1-1655");
	}

	@And("User clicks Notice of Consumer Reports form and validates form version")
	public void User_clicks_notice_of_consumer_reports_form_and_validates_form_version() throws Exception {
		Thread.sleep(4000);
		clickonAnyButton(driver, "AIICNCR0819_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-ncr-0819.pdf");
		ConsReport_Form = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ConsReport_Form);

		wait(9);
		ConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + ConsReport_Form, 1, 30, 710, 100, 30);
		PdfComparator.verifyFormData(driver, ConsReport_Version, "AIIC NCR 08 19");

		ConsReport_Data = PdfComparator.getPDFData(FileLocation + ConsReport_Form);
		PdfComparator.verifyPDFText(driver, ConsReport_Data, "AIIC NCR 08 19");
	}

	@When("User clicks Policy File Chevron <tc16404>")
	public void user_clicks_policy_file_chevron_tc16404() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clics Application form and validates form version")
	public void user_clicks_Application_form_and_validates_form_version() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		HO3App_Form = PdfComparator.makePdf(driver, "App.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + HO3App_Form);

		wait(9);
		HO3App_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + HO3App_Form, 1, 30, 750, 120, 30);
		PdfComparator.verifyFormData(driver, HO3App_Version, "AIIC HO3 APP 04 22");
		HO3App_Name = PdfComparator.getPDFData(FileLocation + HO3App_Form);
		PdfComparator.verifyPDFText(driver, HO3App_Name, "HOMEOWNERS APPLICATION");
	}

	@When("User clicks New Business Package form and validates form version")
	public void user_clicks_New_Business_Package_form_and_validates_form_version() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		NBPackage_Form = PdfComparator.makePdf(driver, "NewBusinessPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);
		wait(9);

		// Dec page
		NBDecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 10, 30, 480, 540, 250);
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC NB GL 08 19");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC PS 05 19");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HO3 DO 07 19");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC RWT 01 19");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HO3 04 23");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HO AL 02 22");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC DRC 11 14");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HCP 08 17");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC PPD 11 14");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC SL 11 14");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HO3 SR 09 19");
		PdfComparator.verifyFormData(driver, NBDecPage, "HO 00 15 04 91");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC HO3 OC 07 18");
		PdfComparator.verifyFormData(driver, NBDecPage, "OIR B1 1670");
		PdfComparator.verifyFormData(driver, NBDecPage, "OIR B1 1655 02 10");
		PdfComparator.verifyFormData(driver, NBDecPage, "AIIC NCR 08 19");

//		

		// Greeting letter
		NBGreeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, NBGreeting_Version, "AIIC NB GL 08 19");

		NBGreeting_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBGreeting_Data, "AIIC NB GL 08 19");

		// Privacy statement
		NBPrivacy_VersionTop = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 480, 30, 150, 50);
		PdfComparator.verifyFormData(driver, NBPrivacy_VersionTop, "AIIC PS 05 19");
		NBPrivacy_VersionBottom = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 4, 70, 740, 200,
				50);
		PdfComparator.verifyFormData(driver, NBPrivacy_VersionBottom, "AIIC PS 05 19");

		NBPrivacy_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Data, "AIIC PS 05 19");
		NBPrivacy_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPrivacy_Name, "PRIVACY STATEMENT");

		// Deductible notification form
		NBDeductibleNoti_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBDeductibleNoti_Version1, "AIIC HO3 DO 07 19");
		NBDeductibleNoti_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, NBDeductibleNoti_Version, "AIIC HO3 DO 07 19");

		NBDeductibleNoti_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDeductibleNoti_Data, "AIIC HO3 DO 07 19");
		NBDeductibleNoti_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDeductibleNoti_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Roof form
		NBRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 470, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version1, "AIIC RWT 01 19");
		NBRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 70, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version, "AIIC RWT 01 19");

		NBRoofLimitation_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Data, "AIIC RWT 01 19");
		NBRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Policy jacket form
		NBPolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version1, "AIIC PJ 07 15");
		NBPolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, NBPolJacket_Version, "AIIC PJ 07 15");

		NBPolJacket_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPolJacket_Data, "AIIC PJ 07 15");
		NBPolJacket_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPolJacket_Name, "Policy Jacket");

		// Homeowner special form
		NBHomeOwners_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 17, 490, 30, 150,
				50);
		PdfComparator.verifyFormData(driver, NBHomeOwners_Version1, "AIIC HO3 04 23");
		NBHomeOwners_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 16, 25, 740, 150,
				50);
		PdfComparator.verifyFormData(driver, NBHomeOwners_Version, "AIIC HO3 04 23");

		NBHomeOwners_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHomeOwners_Data, "AIIC HO3 04 23");
		NBHomeOwners_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHomeOwners_Name, "HOMEOWNERS 3 SPECIAL FORM");

		// Premise devices form
		NBPPD_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 52, 460, 30, 150, 30);
		PdfComparator.verifyFormData(driver, NBPPD_Version1, "AIIC PPD 11 14");
		NBPPD_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 52, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, NBPPD_Version, "AIIC PPD 11 14");

		NBPPD_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPPD_Data, "AIIC PPD 11 14");
		NBPPD_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBPPD_Name, "PREMISES PROTECTIVE DEVICES");

		// Service line coverage
		NBSerLine_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 54, 480, 35, 85, 25);
		PdfComparator.verifyFormData(driver, NBSerLine_Version1, "AIIC SL 11 14");
		NBSerLine_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 54, 70, 740, 80, 30);
		PdfComparator.verifyFormData(driver, NBSerLine_Version, "AIIC SL 11 14");

		NBSerLine_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBSerLine_Data, "AIIC SL 11 14");
		NBSerLine_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBSerLine_Name, "SERVICE LINE COVERAGE");

		// Silver coverage
		NBSilver_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 57, 465, 30, 90, 30);
		PdfComparator.verifyFormData(driver, NBSilver_Version1, "AIIC HO3 SR 09 19");
		NBSilver_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 57, 70, 745, 90, 15);
		PdfComparator.verifyFormData(driver, NBSilver_Version, "AIIC HO3 SR 09 19");

		NBSilver_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBSilver_Data, "AIIC HO3 SR 09 19");
		NBSilver_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBSilver_Name, "SILVER RESERVE COVERAGE");

		// Home owners policy
		NBOutline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 68, 450, 30, 150, 50);
		PdfComparator.verifyFormData(driver, NBOutline_Version1, "AIIC HO3 OC 07 18");
		NBOutline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 68, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, NBOutline_Version, "AIIC HO3 OC 07 18");

		NBOutline_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBOutline_Data, "AIIC HO3 OC 07 18");
		NBOutline_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBOutline_Name, "OUTLINE OF YOUR HOMEOWNERS POLICY");

		// Checklist form
		NBCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 71, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, NBCheckList_Version, "OIR-B1-1670");

		NBCheckList_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBCheckList_Data, "OIR-B1-1670");
		NBCheckList_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBCheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		NBHurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 74, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, NBHurMitigation_Version, "OIR-B1-1655");

		NBHurMitigation_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHurMitigation_Data, "OIR-B1-1655");
		NBHurMitigation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBHurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		NBConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 75, 30, 710, 100,
				30);
		PdfComparator.verifyFormData(driver, NBConsReport_Version, "AIIC NCR 08 19");

		NBConsReport_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBConsReport_Data, "AIIC NCR 08 19");
		NBConsReport_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBConsReport_Name, "AIIC NCR 08 19");

		clickApplicationTab(driver);
	}

	@When("User searches for the policy number <tc16404>")
	public void user_searches_policy_for_tc16404() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as endorse date and starts endorsement <tc16404>")
	public void User_sets_new_effective_date_as_endorse_date_and_starts_endorsement_tc16404() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(endorseDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <tc16404>")
	public void user_clicks_dwelling_chevron_tc16404() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User adds Assisting Living Care")
	public void user_adds_Assisting_Living_Care() throws Exception {

		try {
			driver.findElement(By.id("CoverageList_ALC_Add")).click();
			driver.switchTo().frame("IFrameCoverageAction");
			Hooks.scenario.log("clickAddAssistedLivingCare clicked successfully");
		} catch (Exception e) {
			Hooks.scenario.log("clickAddAssistedLivingCare failed");
			wait(5);
		}

		sendText(driver.findElement(By.id("Coverage.FacilityName")), "Live Care");
		sendText(driver.findElement(By.id("FacilityAddr.Addr1")), "11216 SW Pembroke DR");
		sendText(driver.findElement(By.id("FacilityAddr.City")), "Port Saint Lucie");
		selectDropdownText(driver.findElement(By.id("FacilityAddr.StateProvCd")), "Florida");
		sendText(driver.findElement(By.id("FacilityAddr.PostalCode")), "34987");
		Thread.sleep(500);

		try {
			driver.findElement(By.id("UpdateCoverage")).click();
			Hooks.scenario.log("SaveAsstLivingCare was clicked");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Hooks.scenario.log("SaveAsstLivingCare: failed");
			wait(5);
		}

		Thread.sleep(500);

		// add assisted care item
		try {
			clickonAnyButton(driver, "CoverageList_ALC_AddItem");
			driver.switchTo().frame("IFrameCoverageAction");

			Hooks.scenario.log("AddAssistedLivingCareItem: PASSED");
		} catch (Exception e) {
			Hooks.scenario.log("AddAssistedLivingCareItem: FAILED");
			wait(5);
		}
		wait(1);
		sendText(driver.findElement(By.id("ItemDesc")), "Testing SilverForms");
		selectDropdownText(driver.findElement(By.id("SubCategoryCd.Value")), "Wife");

		// click save attached structure
		try {
			clickonAnyButton(driver, "AddCoverageItem");
			driver.switchTo().defaultContent();
			Hooks.scenario.log("AttStructureSavebtn: Passed");
		} catch (Exception e) {
			Hooks.scenario.log("AttStructureSavebtn: FAILED");
			wait(5);
		}

		click(dwellingChevron.btnSave);
	}

	@When("User adds Structure Rented to Others")
	public void user_adds_Structure_Rented_to_Others() throws Exception {

		try {
			driver.findElement(By.id("CoverageList_SRROP_Add")).click();
			Hooks.scenario.log("Add Structures Rented to Others was checked");
			driver.switchTo().frame("IFrameCoverageAction");
		} catch (Exception e) {
			Hooks.scenario.log("Add Structures Rented to Others was not checked");
			wait(5);
		}

		wait(1);
		selectDropdownText(driver.findElement(By.id("ItemDesc")), "Guest House");

		// click save attached structure
		try {
			clickonAnyButton(driver, "AddCoverageItem");
			driver.switchTo().defaultContent();
			Hooks.scenario.log("AttStructureSavebtn: clicked");
		} catch (Exception e) {
			Hooks.scenario.log("AttStructureSavebtn: NOT CLICKED");
			wait(5);
		}
		Thread.sleep(500);
	}

	@And("User clicks Finalize button and Endorses Policy <tc16404>")
	public void User_clicks_finalize_and_Endorse_Policy_button_tc16404_() {
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();
		wait(10);
		closeUnnecessaryTabs();
	}

	@When("User validates all expected forms to be listed with new added endorsements")
	public void user_validates_all_expected_forms_to_be_listed_with_new_added_endorsements() throws Exception {

		// greeting letter
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC GL 08 19')]"));
			Hooks.scenario.log("Form: Greeting Letter displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Greeting Letter NOT displayed");
			wait(5);
		}

		// privacy statement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form NOT displayed");
			wait(5);
		}

		// deductible notification
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 DO 07 19')]"));
			Hooks.scenario.log("Form: Deductible Notification Options displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options NOT displayed");
			wait(5);
		}

		// limitations roof coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage NOT displayed");
			wait(5);
		}

		// policy jacket
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 07 15')]"));
			Hooks.scenario.log("Form: Policy Jacket displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Policy Jacket NOT displayed");
			wait(5);
		}

		// owner special form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 04 23')]"));
			Hooks.scenario.log("Homeowners 3 Special Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Homeowners 3 Special Form NOT displayed");
			wait(5);
		}

		// animal liability
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO AL 02 22')]"));
			Hooks.scenario.log("Form: Animal Liability Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Animal Liability Coverage NOT displayed");
			wait(5);
		}

		// assisted living care coverage form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 04 59 05 11')]"));
			Hooks.scenario.log("Assisted Living Care Coverage Form OBSERVED");
		} catch (Exception e) {
			Hooks.scenario.log("Assisted Living Care Coverage Form NOT OBSERVED");
			wait(5);
		}

		// dwelling replacement cost coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DRC 11 14')]"));
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form NOT displayed");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC HCP 08 17");

		// premises protective
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PPD 11 14')]"));
			Hooks.scenario.log("Premises Protective Devices Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Premises Protective Devices Form NOT displayed");
			wait(5);
		}

		// special personal property
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 00 15 04 91')]"));
			Hooks.scenario.log("Special Personal Property Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Special Personal Property Coverage Form NOT displayed");
			wait(5);
		}
		// structures rented to others
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC SRO 07 18')]"));
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form NOT DISPLAYED");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC SL 11 14");
		verify_AnyText_IsVisible(driver, "AIIC HO3 SR 09 19");

		// outline of your homeowners policy
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 OC 07 18')]"));
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form NOT displayed");
			wait(5);
		}

		// checklist of coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form NOT displayed");
			wait(5);
		}

		// hurricane loss mitigation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655 02 10')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form NOT displayed");
			wait(5);
		}

		// notice of consumer reports ordered
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log(
					"Notice of Consumer Reports Ordered and Information Used in Premium Determination Form NOT displayed");
			wait(5);
		}
	}

	@And("User clicks Assisted Living Care form and validates form version")
	public void User_clicks_Assisted_Living_Care_form_and_validates_form_version() throws Exception {
		clickonAnyButton(driver, "HO04590511_View");
		Thread.sleep(7000);
		switchToWindow(driver, "ho04590511.pdf");
		AsstLivingForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + AsstLivingForm);

		wait(9);
		AsstLiving_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + AsstLivingForm, 1, 480, 30, 100, 35);
		PdfComparator.verifyFormData(driver, AsstLiving_Version1, "HO 04 59 05 11");
		AsstLiving_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + AsstLivingForm, 1, 50, 735, 100, 30);
		PdfComparator.verifyFormData(driver, AsstLiving_Version, "HO 04 59 05 11");

		AsstLiving_Data = PdfComparator.getPDFData(FileLocation + AsstLivingForm);
		PdfComparator.verifyPDFText(driver, AsstLiving_Data, "HO 04 59 05 11");
		AsstLiving_Name = PdfComparator.getPDFData(FileLocation + AsstLivingForm);
		PdfComparator.verifyPDFText(driver, AsstLiving_Name, "ASSISTED LIVING CARE COVERAGE");
	}

	@And("User clicks Structures Rented to Others form and validates form version")
	public void User_clicks_Structures_Rented_to_Others_form_and_validates_form_version() throws Exception {
		clickonAnyButton(driver, "AIICSRO0718_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiicsro0718.pdf");
		SROForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + SROForm);

		wait(9);
		SRO_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + SROForm, 1, 475, 4, 100, 35);
		PdfComparator.verifyFormData(driver, SRO_Version1, "AIIC SRO 07 18");
		SRO_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + SROForm, 1, 50, 755, 100, 30);
		PdfComparator.verifyFormData(driver, SRO_Version, "AIIC SRO 07 18");

		SRO_Data = PdfComparator.getPDFData(FileLocation + SROForm);
		PdfComparator.verifyPDFText(driver, SRO_Data, "AIIC SRO 07 18");
		SRO_Name = PdfComparator.getPDFData(FileLocation + SROForm);
		PdfComparator.verifyPDFText(driver, SRO_Name, "STRUCTURES RENTED TO OTHERS");
	}

	@And("User clicks Endorsement Package and validates form versions")
	public void User_clicks_Endorsement_Package_and_validates_form_versions() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(9);

		// Endorsement Dec page
		EndDecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 2, 30, 500, 540, 240);
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC NB GL 08 19");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC PS 05 19");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC HO3 DO 07 19");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC RWT 01 19");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC HO3 04 23");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC HO AL 02 22");
		PdfComparator.verifyFormData(driver, EndDecPage, "HO 04 59 05 11");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC DRC 11 14");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC HCP 08 17");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC PPD 11 14");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC SL 11 14");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC HO3 SR 09 19");
		PdfComparator.verifyFormData(driver, EndDecPage, "HO 00 15 04 91");
		PdfComparator.verifyFormData(driver, EndDecPage, "AIIC SRO 07 18");

		EndDecPage2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 3, 30, 80, 540, 80);
		PdfComparator.verifyFormData(driver, EndDecPage2, "AIIC HO3 OC 07 18");
		PdfComparator.verifyFormData(driver, EndDecPage2, "OIR B1 1670");
		PdfComparator.verifyFormData(driver, EndDecPage2, "OIR B1 1655 02 10");
		PdfComparator.verifyFormData(driver, EndDecPage2, "AIIC NCR 08 19");

		// Assisting living care
		ENDAsstLiving_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 6, 480, 30, 100,
				35);
		PdfComparator.verifyFormData(driver, ENDAsstLiving_Version1, "HO 04 59 05 11");
		ENDAsstLiving_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 6, 50, 735, 100,
				30);
		PdfComparator.verifyFormData(driver, ENDAsstLiving_Version, "HO 04 59 05 11");

		ENDAsstLiving_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, ENDAsstLiving_Data, "HO 04 59 05 11");
		ENDAsstLiving_Name = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, ENDAsstLiving_Name, "ASSISTED LIVING CARE COVERAGE");

		// SRO form
		ENDSRO_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 8, 475, 4, 100, 35);
		PdfComparator.verifyFormData(driver, ENDSRO_Version1, "AIIC SRO 07 18");
		ENDSRO_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 8, 50, 755, 100, 30);
		PdfComparator.verifyFormData(driver, ENDSRO_Version, "AIIC SRO 07 18");

		ENDSRO_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, ENDSRO_Data, "AIIC SRO 07 18");
		ENDSRO_Name = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, ENDSRO_Name, "STRUCTURES RENTED TO OTHERS");
	}

	@When("User changes system date to endorsement date")
	public void user_changes_system_date_to_endorsement_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(endorseDate));
	}

	@When("User sets loss date as endorse date <tc16404>")
	public void user_sets_loss_date_as_endorse_date_tc16404() {
		sendText(claim.txtLossDate, dtf.format(endorseDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as Collapse and clicks Save <tc16404>")
	public void user_selects_loss_cause_as_collapse_and_clicks_save_tc16404() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collapse");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User completes all required information on claim chevron <tc16404>")
	public void user_completes_all_reqiured_information_on_claim_chevron_tc16404() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Forms verification");
	}

	@When("User clicks save and takes note of the loss number <tc16404>")
	public void user_clicks_save_and_takes_note_of_the_loss_number_tc16404() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Complete and takes note of the claim number <tc16404>")
	public void user_clicks_complete_takes_notes_tc16404() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User validates all expected forms to be listed with new added claim")
	public void user_validates_all_expected_forms_to_be_listed_with_new_added_claim() throws Exception {

		// greeting letter
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC GL 08 19')]"));
			Hooks.scenario.log("Form: Greeting Letter displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Greeting Letter NOT displayed");
			wait(5);
		}

		// privacy statement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form NOT displayed");
			wait(5);
		}

		// deductible notification
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 DO 07 19')]"));
			Hooks.scenario.log("Form: Deductible Notification Options displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options NOT displayed");
			wait(5);
		}

		// limitations roof coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage NOT displayed");
			wait(5);
		}

		// policy jacket
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 07 15')]"));
			Hooks.scenario.log("Form: Policy Jacket displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Policy Jacket NOT displayed");
			wait(5);
		}

		// owner special form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 04 23')]"));
			Hooks.scenario.log("Homeowners 3 Special Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Homeowners 3 Special Form NOT displayed");
			wait(5);
		}

		// animal liability
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO AL 02 22')]"));
			Hooks.scenario.log("Form: Animal Liability Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Animal Liability Coverage NOT displayed");
			wait(5);
		}

		// assisted living care coverage form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 04 59 05 11')]"));
			Hooks.scenario.log("Assisted Living Care Coverage Form OBSERVED");
		} catch (Exception e) {
			Hooks.scenario.log("Assisted Living Care Coverage Form NOT OBSERVED");
			wait(5);
		}

		// dwelling replacement cost coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DRC 11 14')]"));
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form NOT displayed");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC HCP 08 17");

		// premises protective
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PPD 11 14')]"));
			Hooks.scenario.log("Premises Protective Devices Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Premises Protective Devices Form NOT displayed");
			wait(5);
		}

		// special personal property
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 00 15 04 91')]"));
			Hooks.scenario.log("Special Personal Property Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Special Personal Property Coverage Form NOT displayed");
			wait(5);
		}
		// structures rented to others
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC SRO 07 18')]"));
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form NOT DISPLAYED");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC SL 11 14");
		verify_AnyText_IsVisible(driver, "AIIC HO3 SR 09 19");

		// outline of your homeowners policy
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 OC 07 18')]"));
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form NOT displayed");
			wait(5);
		}

		// checklist of coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form NOT displayed");
			wait(5);
		}

		// hurricane loss mitigation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655 02 10')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form NOT displayed");
			wait(5);
		}

		// notice of consumer reports ordered
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log(
					"Notice of Consumer Reports Ordered and Information Used in Premium Determination Form NOT displayed");
			wait(5);
		}
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <tc16404>")
	public void user_clicks_make_payment_and_selects_cc_tc16404() {
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

	@When("User makes payment with Credit Card for <tc16404>")
	public void user_makes_payment_with_credit_card_tc16404() throws Exception {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does Auto Renewal for the policy with batch jobs <tc16404>")
	public void user_does_auto_renewal_tc16404() throws Exception {

		PolicyNumberTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		driver.findElement(By.id("Tab_Policy")).click();
		wait(1);
	}

	@When("User validates all expected forms to be listed with renewal")
	public void user_validates_all_expected_forms_to_be_listed_with_renewal() throws Exception {

		// greeting letter
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC GL 08 19')]"));
			Hooks.scenario.log("Form: Greeting Letter displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Greeting Letter NOT displayed");
			wait(5);
		}

		// privacy statement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PS 05 19')]"));
			Hooks.scenario.log("Privacy Statement Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Form NOT displayed");
			wait(5);
		}

		// deductible notification
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 DO 07 19')]"));
			Hooks.scenario.log("Form: Deductible Notification Options displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Deductible Notification Options NOT displayed");
			wait(5);
		}

		// limitations roof coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC RWT 01 19')]"));
			Hooks.scenario.log("Form: Limitations on Roof Coverage displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Limitations on Roof Coverage NOT displayed");
			wait(5);
		}

		// policy jacket
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ 07 15')]"));
			Hooks.scenario.log("Form: Policy Jacket displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Policy Jacket NOT displayed");
			wait(5);
		}

		// owner special form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 04 23')]"));
			Hooks.scenario.log("Homeowners 3 Special Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Homeowners 3 Special Form NOT displayed");
			wait(5);
		}

		// animal liability
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO AL 02 22')]"));
			Hooks.scenario.log("Form: Animal Liability Coverage");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Animal Liability Coverage NOT displayed");
			wait(5);
		}

		// assisted living care coverage form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 04 59 05 11')]"));
			Hooks.scenario.log("Assisted Living Care Coverage Form OBSERVED");
		} catch (Exception e) {
			Hooks.scenario.log("Assisted Living Care Coverage Form NOT OBSERVED");
			wait(5);
		}

		// dwelling replacement cost coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC DRC 11 14')]"));
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Dwelling Replacement Cost Coverage Increased Limits Form NOT displayed");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC HCP 08 17");

		// premises protective
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PPD 11 14')]"));
			Hooks.scenario.log("Premises Protective Devices Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Premises Protective Devices Form NOT displayed");
			wait(5);
		}

		// special personal property
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'HO 00 15 04 91')]"));
			Hooks.scenario.log("Special Personal Property Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Special Personal Property Coverage Form NOT displayed");
			wait(5);
		}
		// structures rented to others
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC SRO 07 18')]"));
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Structures Rented to Others Residence Premises Form NOT DISPLAYED");
			wait(5);
		}

		verify_AnyText_IsVisible(driver, "AIIC SL 11 14");
		verify_AnyText_IsVisible(driver, "AIIC HO3 SR 09 19");

		// outline of your homeowners policy
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 OC 07 18')]"));
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Outline of Your Homeowners Policy Form NOT displayed");
			wait(5);
		}

		// checklist of coverage
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1670')]"));
			Hooks.scenario.log("Checklist of Coverage Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Checklist of Coverage Form NOT displayed");
			wait(5);
		}

		// hurricane loss mitigation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'OIR B1 1655 02 10')]"));
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigatione Form displayed");
		} catch (Exception e) {
			Hooks.scenario.log("Notice of Premium Discounts for Hurricane Loss Mitigation Form NOT displayed");
			wait(5);
		}

		// notice of consumer reports ordered
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC NCR 08 19')]"));
			Hooks.scenario.log("Notice of Consumer Reports Ordered and Information Used in Premium Determination Form");
		} catch (Exception e) {
			Hooks.scenario.log(
					"Notice of Consumer Reports Ordered and Information Used in Premium Determination Form NOT displayed");
			wait(5);
		}
	}

	@And("User clicks Renewal Declaration form and validates form versions")
	public void User_clicks_Renewal_Declaration_form_and_validates_form_versions_tc16404() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);
		wait(9);

		// Renewal Dec page
		RwlDecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 30, 500, 540, 240);
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC RN GL 08 19");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC PS 05 19");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC HO3 DO 07 19");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC RWT 01 19");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC HO3 04 23");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC HO AL 02 22");
		PdfComparator.verifyFormData(driver, RwlDecPage, "HO 04 59 05 11");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC DRC 11 14");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC HCP 08 17");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC PPD 11 14");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC SL 11 14");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC HO3 SR 09 19");
		PdfComparator.verifyFormData(driver, RwlDecPage, "HO 00 15 04 91");
		PdfComparator.verifyFormData(driver, RwlDecPage, "AIIC SRO 07 18");

		RwlDecPage2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 11, 30, 80, 540, 80);
		PdfComparator.verifyFormData(driver, RwlDecPage2, "AIIC HO3 OC 07 18");
		PdfComparator.verifyFormData(driver, RwlDecPage2, "OIR B1 1670");
		PdfComparator.verifyFormData(driver, RwlDecPage2, "OIR B1 1655 02 10");
		PdfComparator.verifyFormData(driver, RwlDecPage2, "AIIC NCR 08 19");

		// Greeting letter
		RwlGreeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, RwlGreeting_Version, "AIIC RN GL 08 19");

		RwlGreeting_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlGreeting_Data, "AIIC RN GL 08 19");

		// Privacy statement
		RwlPrivacy_VersionTop = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 470, 35, 250, 50);
		PdfComparator.verifyFormData(driver, RwlPrivacy_VersionTop, "AIIC PS 05 19");
		RwlPrivacy_VersioRwlottom = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, RwlPrivacy_VersioRwlottom, "AIIC PS 05 19");

		RwlPrivacy_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPrivacy_Name, "PRIVACY STATEMENT");

		// Deductible notification form
		RwlDeductibleNoti_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, RwlDeductibleNoti_Version1, "AIIC HO3 DO 07 19");
		RwlDeductibleNoti_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, RwlDeductibleNoti_Version, "AIIC HO3 DO 07 19");
		RwlDeductibleNoti_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlDeductibleNoti_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Roof form
		RwlRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 470, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, RwlRoofLimitation_Version1, "AIIC RWT 01 19");
		RwlRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 70, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, RwlRoofLimitation_Version, "AIIC RWT 01 19");

		RwlRoofLimitation_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlRoofLimitation_Data, "AIIC RWT 01 19");
		RwlRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Policy jacket form
		RwlPolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 14, 470, 35, 250, 50);
		PdfComparator.verifyFormData(driver, RwlPolJacket_Version1, "AIIC PJ 07 15");
		RwlPolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, RwlPolJacket_Version, "AIIC PJ 07 15");

		RwlPolJacket_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPolJacket_Data, "AIIC PJ 07 15");
		RwlPolJacket_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPolJacket_Name, "Policy Jacket");

		// Homeowner special form
		RwlHomeOwners_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 17, 490, 30, 150, 50);
		PdfComparator.verifyFormData(driver, RwlHomeOwners_Version1, "AIIC HO3 04 23");
		RwlHomeOwners_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 18, 25, 740, 150, 50);
		PdfComparator.verifyFormData(driver, RwlHomeOwners_Version, "AIIC HO3 04 23");

		RwlHomeOwners_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHomeOwners_Data, "AIIC HO3 04 23");
		RwlHomeOwners_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHomeOwners_Name, "HOMEOWNERS 3 SPECIAL FORM");

		// Premise devices form
		RwlPPD_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 55, 460, 30, 150, 30);
		PdfComparator.verifyFormData(driver, RwlPPD_Version1, "AIIC PPD 11 14");
		RwlPPD_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 55, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, RwlPPD_Version, "AIIC PPD 11 14");

		RwlPPD_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPPD_Data, "AIIC PPD 11 14");
		RwlPPD_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlPPD_Name, "PREMISES PROTECTIVE DEVICES");

		// Service line coverage
		RwlSerLine_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 57, 480, 35, 85, 25);
		PdfComparator.verifyFormData(driver, RwlSerLine_Version1, "AIIC SL 11 14");
		RwlSerLine_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 57, 70, 740, 80, 30);
		PdfComparator.verifyFormData(driver, RwlSerLine_Version, "AIIC SL 11 14");

		RwlSerLine_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSerLine_Data, "AIIC SL 11 14");
		RwlSerLine_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSerLine_Name, "SERVICE LINE COVERAGE");

		// Silver coverage
		RwlSilver_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 60, 465, 30, 90, 30);
		PdfComparator.verifyFormData(driver, RwlSilver_Version1, "AIIC HO3 SR 09 19");
		RwlSilver_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 60, 70, 745, 90, 15);
		PdfComparator.verifyFormData(driver, RwlSilver_Version, "AIIC HO3 SR 09 19");

		RwlSilver_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSilver_Data, "AIIC HO3 SR 09 19");
		RwlSilver_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSilver_Name, "SILVER RESERVE COVERAGE");

		// Home owners policy
		RwlOutline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 72, 450, 30, 150, 50);
		PdfComparator.verifyFormData(driver, RwlOutline_Version1, "AIIC HO3 OC 07 18");
		RwlOutline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 72, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, RwlOutline_Version, "AIIC HO3 OC 07 18");

		RwlOutline_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlOutline_Data, "AIIC HO3 OC 07 18");
		RwlOutline_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlOutline_Name, "OUTLINE OF YOUR HOMEOWNERS POLICY");

		// Checklist form
		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 75, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");

		RwlCheckList_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlCheckList_Data, "OIR-B1-1670");
		RwlCheckList_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlCheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		RwlHurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 78, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, RwlHurMitigation_Version, "OIR-B1-1655");

		RwlHurMitigation_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHurMitigation_Data, "OIR-B1-1655");
		RwlHurMitigation_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlHurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		RwlConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 79, 30, 710, 100, 30);
		PdfComparator.verifyFormData(driver, RwlConsReport_Version, "AIIC NCR 08 19");

		RwlConsReport_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlConsReport_Data, "AIIC NCR 08 19");
		RwlConsReport_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlConsReport_Name, "AIIC NCR 08 19");

		// Assisting living care
		RwlAsstLiving_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 44, 480, 30, 100, 35);
		PdfComparator.verifyFormData(driver, RwlAsstLiving_Version1, "HO 04 59 05 11");
		RwlAsstLiving_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 44, 50, 735, 100, 30);
		PdfComparator.verifyFormData(driver, RwlAsstLiving_Version, "HO 04 59 05 11");

		RwlAsstLiving_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlAsstLiving_Data, "HO 04 59 05 11");
		RwlAsstLiving_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlAsstLiving_Name, "ASSISTED LIVING CARE COVERAGE");

		// SRO form
		RwlSRO_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 70, 475, 4, 100, 35);
		PdfComparator.verifyFormData(driver, RwlSRO_Version1, "AIIC SRO 07 18");
		RwlSRO_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 70, 50, 755, 100, 30);
		PdfComparator.verifyFormData(driver, RwlSRO_Version, "AIIC SRO 07 18");

		RwlSRO_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSRO_Data, "AIIC SRO 07 18");
		RwlSRO_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlSRO_Name, "STRUCTURES RENTED TO OTHERS");

	}

	@When("User clicks Make Payment and do renewal payment")
	public void user_clicks_make_payment_and_do_renewal_payment_tc16404() {
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

	@When("User does second Auto Renewal for the policy with batch jobs")
	public void user_does_second_Auto_Renewal_for_the_policy_with_batch_jobs() throws Exception {
		runAutoRenewPolicy(driver, PolicyNumberTerm02, "02", "03");
		driver.findElement(By.id("Tab_Policy")).click();
		wait(1);
	}
	@When("User clicks the last renewal declaration form and validates all form versions and completes test")
	public void user_clicks_the_last_renewal_declaration_form_and_validates_all_form_versions_and_completes_test()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		RwlDec2_Form = PdfComparator.makePdf(driver, "Renewal_Declaration2.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec2_Form);
		wait(9);

		// Renewal Dec page
		Rwl2DecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 10, 30, 500, 540, 240);
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC RN GL 08 19");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC PS 05 19");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC HO3 DO 07 19");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC RWT 01 19");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC HO3 04 23");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC HO AL 02 22");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "HO 04 59 05 11");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC DRC 11 14");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC HCP 08 17");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC PPD 11 14");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC SL 11 14");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC HO3 SR 09 19");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "HO 00 15 04 91");
		PdfComparator.verifyFormData(driver, Rwl2DecPage, "AIIC SRO 07 18");

		Rwl2DecPage2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 11, 30, 80, 540, 80);
		PdfComparator.verifyFormData(driver, Rwl2DecPage2, "AIIC HO3 OC 07 18");
		PdfComparator.verifyFormData(driver, Rwl2DecPage2, "OIR B1 1670");
		PdfComparator.verifyFormData(driver, Rwl2DecPage2, "OIR B1 1655 02 10");
		PdfComparator.verifyFormData(driver, Rwl2DecPage2, "AIIC NCR 08 19");

		// Greeting letter
		Rwl2Greeting_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 1, 430, 700, 100, 50);
		PdfComparator.verifyFormData(driver, Rwl2Greeting_Version, "AIIC RN GL 08 19");

		Rwl2Greeting_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Greeting_Data, "AIIC RN GL 08 19");

		// Privacy statement
		Rwl2Privacy_VersionTop = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 4, 470, 35, 250, 50);
		PdfComparator.verifyFormData(driver, Rwl2Privacy_VersionTop, "AIIC PS 05 19");
		Rwl2Privacy_VersioRwl2ottom = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 4, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, Rwl2Privacy_VersioRwl2ottom, "AIIC PS 05 19");

		Rwl2Privacy_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Privacy_Name, "PRIVACY STATEMENT");

		// Deductible notification form
		Rwl2DeductibleNoti_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 5, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, Rwl2DeductibleNoti_Version1, "AIIC HO3 DO 07 19");
		Rwl2DeductibleNoti_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 5, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, Rwl2DeductibleNoti_Version, "AIIC HO3 DO 07 19");
		Rwl2DeductibleNoti_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2DeductibleNoti_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Roof form
		Rwl2RoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 7, 470, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, Rwl2RoofLimitation_Version1, "AIIC RWT 01 19");
		Rwl2RoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 7, 70, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, Rwl2RoofLimitation_Version, "AIIC RWT 01 19");

		Rwl2RoofLimitation_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2RoofLimitation_Data, "AIIC RWT 01 19");
		Rwl2RoofLimitation_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2RoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");

		// Policy jacket form
		Rwl2PolJacket_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 14, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, Rwl2PolJacket_Version1, "AIIC PJ 07 15");
		Rwl2PolJacket_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 14, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, Rwl2PolJacket_Version, "AIIC PJ 07 15");

		Rwl2PolJacket_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2PolJacket_Data, "AIIC PJ 07 15");
		Rwl2PolJacket_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2PolJacket_Name, "Policy Jacket");

		// Homeowner special form
		Rwl2HomeOwners_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 17, 490, 30, 150,
				50);
		PdfComparator.verifyFormData(driver, Rwl2HomeOwners_Version1, "AIIC HO3 04 23");
		Rwl2HomeOwners_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 16, 25, 740, 150,
				50);
		PdfComparator.verifyFormData(driver, Rwl2HomeOwners_Version, "AIIC HO3 04 23");

		Rwl2HomeOwners_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HomeOwners_Data, "AIIC HO3 04 23");
		Rwl2HomeOwners_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HomeOwners_Name, "HOMEOWNERS 3 SPECIAL FORM");

		// Premise devices form
		Rwl2PPD_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 55, 460, 30, 150, 30);
		PdfComparator.verifyFormData(driver, Rwl2PPD_Version1, "AIIC PPD 11 14");
		Rwl2PPD_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 55, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, Rwl2PPD_Version, "AIIC PPD 11 14");

		Rwl2PPD_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2PPD_Data, "AIIC PPD 11 14");
		Rwl2PPD_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2PPD_Name, "PREMISES PROTECTIVE DEVICES");

		// Service line coverage
		Rwl2SerLine_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 57, 480, 35, 85, 25);
		PdfComparator.verifyFormData(driver, Rwl2SerLine_Version1, "AIIC SL 11 14");
		Rwl2SerLine_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 57, 70, 740, 80, 30);
		PdfComparator.verifyFormData(driver, Rwl2SerLine_Version, "AIIC SL 11 14");

		Rwl2SerLine_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SerLine_Data, "AIIC SL 11 14");
		Rwl2SerLine_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SerLine_Name, "SERVICE LINE COVERAGE");

		// Silver coverage
		Rwl2Silver_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 60, 465, 30, 90, 30);
		PdfComparator.verifyFormData(driver, Rwl2Silver_Version1, "AIIC HO3 SR 09 19");
		Rwl2Silver_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 60, 70, 745, 90, 15);
		PdfComparator.verifyFormData(driver, Rwl2Silver_Version, "AIIC HO3 SR 09 19");

		Rwl2Silver_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Silver_Data, "AIIC HO3 SR 09 19");
		Rwl2Silver_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Silver_Name, "SILVER RESERVE COVERAGE");

		// Home owners policy
		Rwl2Outline_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 72, 450, 30, 150, 50);
		PdfComparator.verifyFormData(driver, Rwl2Outline_Version1, "AIIC HO3 OC 07 18");
		Rwl2Outline_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 72, 70, 735, 100, 30);
		PdfComparator.verifyFormData(driver, Rwl2Outline_Version, "AIIC HO3 OC 07 18");

		Rwl2Outline_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Outline_Data, "AIIC HO3 OC 07 18");
		Rwl2Outline_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2Outline_Name, "OUTLINE OF YOUR HOMEOWNERS POLICY");

		// Checklist form
		Rwl2CheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 75, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, Rwl2CheckList_Version, "OIR-B1-1670");

		Rwl2CheckList_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2CheckList_Data, "OIR-B1-1670");
		Rwl2CheckList_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2CheckList_Name, "Checklist of Coverage");

		// Notice Hurricane mitigation
		Rwl2HurMitigation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 78, 30, 750, 90,
				30);
		PdfComparator.verifyFormData(driver, Rwl2HurMitigation_Version, "OIR-B1-1655");

		Rwl2HurMitigation_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HurMitigation_Data, "OIR-B1-1655");
		Rwl2HurMitigation_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2HurMitigation_Name,
				"Notice of Premium Discounts for Hurricane Loss Mitigation");

		// Consumer reports form
		Rwl2ConsReport_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 79, 30, 710, 100,
				30);
		PdfComparator.verifyFormData(driver, Rwl2ConsReport_Version, "AIIC NCR 08 19");

		Rwl2ConsReport_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2ConsReport_Data, "AIIC NCR 08 19");
		Rwl2ConsReport_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2ConsReport_Name, "AIIC NCR 08 19");

		// Assisting living care
		Rwl2AsstLiving_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 44, 480, 30, 100,
				35);
		PdfComparator.verifyFormData(driver, Rwl2AsstLiving_Version1, "HO 04 59 05 11");
		Rwl2AsstLiving_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 44, 50, 735, 100,
				30);
		PdfComparator.verifyFormData(driver, Rwl2AsstLiving_Version, "HO 04 59 05 11");

		Rwl2AsstLiving_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2AsstLiving_Data, "HO 04 59 05 11");
		Rwl2AsstLiving_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2AsstLiving_Name, "ASSISTED LIVING CARE COVERAGE");

		// SRO form
		Rwl2SRO_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 70, 475, 4, 100, 35);
		PdfComparator.verifyFormData(driver, Rwl2SRO_Version1, "AIIC SRO 07 18");
		Rwl2SRO_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec2_Form, 70, 50, 755, 100, 30);
		PdfComparator.verifyFormData(driver, Rwl2SRO_Version, "AIIC SRO 07 18");

		Rwl2SRO_Data = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SRO_Data, "AIIC SRO 07 18");
		Rwl2SRO_Name = PdfComparator.getPDFData(FileLocation + RwlDec2_Form);
		PdfComparator.verifyPDFText(driver, Rwl2SRO_Name, "STRUCTURES RENTED TO OTHERS");
	}
}
