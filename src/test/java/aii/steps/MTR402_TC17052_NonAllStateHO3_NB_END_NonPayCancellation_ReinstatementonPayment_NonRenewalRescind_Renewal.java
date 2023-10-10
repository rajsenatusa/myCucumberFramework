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

public class MTR402_TC17052_NonAllStateHO3_NB_END_NonPayCancellation_ReinstatementonPayment_NonRenewalRescind_Renewal extends CommonMethods{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String QuoteForm;
	static String Quote_Version;
	static String Agency_Data;
	static String QuoteForm2;
	static String Quote_Version2;
	static String Agency_Data2;
	static String PolicyQuote;
	static String PolicyQuote_Version2;
	static String PolicyQuote_Data;
	static String AppForm;
	static String App_Version;
	static String AgencyApp_Data;
	static String AppForm2;
	static String App_Version2;
	static String AgencyApp_Data2;
	static String PolicyAppForm;
	static String PolicyApp_Version;
	static String PolicyAppAgency_Data;
	static String Consent_Version;
	static String ConsentAgency_Data;
	static String DINST_Form;
	static String DINST_Data;
	static String Declaration_Form;
	static String Declaration_Version;
	static String Declaration_Data;
	static String EndPackage_Form;
	static String EndDeclaration_Version;
	static String EndDeclaration_Data;
	static String StatementLoss_Form;
	static String SNL_Data;
	static String AgentLetter_Form;
	static String AgentLetter_Data;
	static String SinkholeDenial_Form;
	static String SinkholeDenial_Data;
	static String AgentLetter_Form2;
	static String AgentLetter_Data2;
	static String SinkholeDenial_Form2;
	static String SinkholeDenial_Data2;
	static String NextActionDate;
	static String NextActionDate2;
	static String CancellationNotice_Form;
	static String CancellationNotice_Data;
	static String CancellationConfirmation_Form;
	static String CancellationConfirmation_Data;
	static String MinAmountForReinstatements;
	static String PaymentConfirmation_Form;
	static String PaymentConfirmation_Data;
	static String Con_Coverage_Form;
	static String Reinstatement_Data;
	static String NonRenewalNotice_Form;
	static String NonRenewalNotice_Data;
	static String NonRenewalRescind_Form;
	static String NonRenewalRescind_Data;
	static String RwlDec_Form;
	static String RwlDeclaration_Version;
	static String RwlDeclaration_Data;
	static String RwlDINST_Form;
	static String RwlDINST_Data;
	
	@And("User searches Agent <AG1529A2>")
	public void user_searches_agent_AG1529A2() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG1529A2");
		wait(1);
	}
	@When("User enters all required information on policy information screen <mtr402>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr402() {

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
	@When("User enters HO3 product selection information and current date as effective date <mtr402>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr402() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	@When("User enters all required information on HO3 quote screen <mtr402>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr402() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
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
	@When("User enters all required information on HO3 dwelling screen <mtr402>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr402() {
		// Quote Dwelling information was filled here
		//sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "1500");
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
		click(dwellingChevron.btnSave);
		wait(4);
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$15,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User clicks review Chevron and selects 8 Pay payment plan <mtr402>")
	public void user_clicks_review_chevron_and_selects_8_pay_payment_plan_mtr402() {

		click(reviewChevron.btnReview);
		wait(2);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(2);
		click(driver.findElement(By.id("BasicPolicy.PayPlanCd_9")));  //8 pay plan
	}
	@When("User sets dwelling type, sets roof update and roof material <mtr402>")
	public void user_sets_dwelling_type_sets_roof_update_and_roof_material_mtr402() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2017");  //Change due to $15K wind/hail
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User validates 'KILLINGSWORTH INSURANCE AGENCY-SPRING HILL' label is visible")
	public void user_validates_agent_name_label_is_visible_mtr402() throws Exception {
		verify_AnyLabel_IsVisible(driver, "KILLINGSWORTH INSURANCE AGENCY-SPRING HILL");
	}
	@When("User validates form version on quote ui <mtr402>")
	public void user_validates_form_version_on_quote_ui_mtr402() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		QuoteForm = PdfComparator.makePdf(driver, "HO3Quote_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+QuoteForm);
			
		wait(10);
		Quote_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version, "AIIC QT 07 19");
		
		Agency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, Agency_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, Agency_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, Agency_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, Agency_Data, "(352) 796-1451");
	}
	@When("User clicks process correspondance button and validates form version <mtr402>")
	public void user_clicks_process_correspondance_btn_and_valides_form_version_mtr402() throws Exception {
		click(correspondance.btnProcessCorrespondence);
		wait(3);
		switchToWindow(driver, "STFile&Filename");
		QuoteForm2 = PdfComparator.makePdf(driver, "HO3Quote_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+QuoteForm2);
			
		wait(10);
		Quote_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm2, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version2, "AIIC QT 07 19");
		
		Agency_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, Agency_Data2, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, Agency_Data2, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, Agency_Data2, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, Agency_Data2, "(352) 796-1451");
	}
	@When("User clicks Policy File Chevron <mtr402>")
	public void user_clicks_policy_file_chevron_mtr402() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User clicks Insurance Quote Link and validates form version <mtr402>")
	public void user_clicks_insurance_quote_link_and_validates_form_version_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Insurance Quote");
		wait(5);
		switchToWindow(driver, "STFile&Filename");
		PolicyQuote = PdfComparator.makePdf(driver, "InsuranceQuote.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+PolicyQuote);
			
		wait(10);
		PolicyQuote_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyQuote, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, PolicyQuote_Version2, "AIIC QT 07 19");
		
		PolicyQuote_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyQuote, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, "(352) 796-1451");

		clickApplicationTab(driver);
	}
	@When("User validates form version on application ui <mtr402>")
	public void user_validates_form_version_on_application_ui_mtr402() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		AppForm = PdfComparator.makePdf(driver, "HO3App_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm);
			
		wait(10);
		App_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, App_Version, "AIIC HO3 APP 04 22");
		
		AgencyApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, "(352) 796-1451");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, "AG1529");
	}
	@When("User clicks Process Correspondance and validates quote and agent information in forms <mtr402>")
	public void user_clicks_process_correspondance_and_validates_quote_and_agent_information_in_forms_mtr402() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		AppForm2 = PdfComparator.makePdf(driver, "HO3App_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm2);
			
		wait(10);
		App_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, App_Version2, "AIIC HO3 APP 04 22");
		
		AgencyApp_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, "(352) 796-1451");
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, "AG1529");
		
		clickApplicationTab(driver);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr402>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr402()
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
	@When("User clicks Application Link and validates application form version <mtr402>")
	public void user_clicks_application_link_and_validates_application_form_version_mtr402() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		PolicyAppForm = PdfComparator.makePdf(driver, "HO3App_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+PolicyAppForm);
			
		wait(10);
		PolicyApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, PolicyApp_Version, "AIIC HO3 APP 04 22");
		
		PolicyAppAgency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, "(352) 796-1451");
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, "AG1529");
		
		//Consent to rate form
		Consent_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 9, 30, 740, 100, 30);
		PdfComparator.verifyFormData(driver, Consent_Version, "AIIC ACR 07 18");
		
		ConsentAgency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 9, 0, 0, 620, 400);
		
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, "(352) 796-1451");
	}
	@When("User clicks New Business Invoice Link and validates information in form <mtr402>")
	public void user_clicks_new_business_invoice_link_and_validates_information_in_forms_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Invoice");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		DINST_Form = PdfComparator.makePdf(driver, "HO3_DINST.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+DINST_Form);
		wait(10);
		
		DINST_Data = PdfComparator.getPDFData(FileLocation+DINST_Form);
		PdfComparator.verifyPDFText(driver, DINST_Data, "AIIC DINST 11 14");
		PdfComparator.verifyPDFText(driver, DINST_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, DINST_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, DINST_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, DINST_Data, "(352) 796-1451");
	}
	@When("User clicks Declaration Link and validates information in the form <mtr402>")
	public void user_clicks_declaration_link_and_validates_information_in_the_form_mtr402() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Declaration')])[3]")).click();
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		Declaration_Form = PdfComparator.makePdf(driver, "HO3_DecForm.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+Declaration_Form);
		wait(8);
		
		Declaration_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+Declaration_Form, 1, 70, 740, 100, 50);
		PdfComparator.verifyFormData(driver, Declaration_Version, "AIIC DEC 04 23");
		
		Declaration_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+Declaration_Form, 1, 0, 0, 620, 400);

		PdfComparator.verifyPDFText(driver, Declaration_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, Declaration_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, Declaration_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, Declaration_Data, "(352) 796-1451");
		
		clickApplicationTab(driver);
		wait(1);;
	}
	@When("User searches for the policy number <mtr402>")
	public void user_searches_policy_for_mtr402() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date and starts endorsement <mtr402>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr402() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@And("User clicks Finalize button and Endorses Policy <mtr402>")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr402_() {	    
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();	 
		wait(10);	
		closeUnnecessaryTabs();
	}
	@And("User clicks Endorsement Package Link and validates information in the form <mtr402>")
	public void User_clicks_endorsement_package_link_and_validateS_information_in_the_form_mtr402() throws Exception {	    
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+EndPackage_Form);		
		wait(8);
		
		//Declaration Page
		EndDeclaration_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+EndPackage_Form, 1, 70, 740, 100, 50);
		PdfComparator.verifyFormData(driver, EndDeclaration_Version, "AIIC DEC 04 23");
		EndDeclaration_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+EndPackage_Form, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, "(352) 796-1451");
	}
	@When("User clicks Statement of No Loss Link and validates information in the form <mtr402>")
	public void user_clicks_statement_of_no_loss_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Statement of No Loss");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		
		StatementLoss_Form = PdfComparator.makePdf(driver, "StatementOfNoLoss.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+StatementLoss_Form);
		wait(10);
		
		SNL_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+StatementLoss_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, SNL_Data, "AIIC SNL 11 14");
		PdfComparator.verifyPDFText(driver, SNL_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, SNL_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, SNL_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, SNL_Data, "(352) 796-1451");
	}
	@When("User clicks Process Correspondance and validates information in the form <mtr402>")
	public void user_clicks_process_correspondance_validates_information_in_the_form_mtr402() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		AgentLetter_Form = PdfComparator.makePdf(driver, "AgentLetter.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AgentLetter_Form);
		wait(8);
		
		AgentLetter_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AgentLetter_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, "AIIC AL 11 14");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, "Brooksville, FL 34601-3003");
	}
	@When("User clicks Process Correspondance and validates information in the sinkhole loss form <mtr402>")
	public void user_clicks_process_correspondance_validates_information_in_sinkhole_loss_form_mtr402() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		SinkholeDenial_Form = PdfComparator.makePdf(driver, "SinkholeDenial.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+SinkholeDenial_Form);
		wait(10);
		
		SinkholeDenial_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+SinkholeDenial_Form, 1, 0, 0, 620, 790);
		
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, "Brooksville, FL 34601-3003");
	}
	@When("User clicks Agent Letter Link and validates information in the form <mtr402>")
	public void user_clicks_agent_letter_link_and_validates_information_in_the_Form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Agent Letter");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		AgentLetter_Form2 = PdfComparator.makePdf(driver, "AgentLetter.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AgentLetter_Form2);
		wait(8);
		
		AgentLetter_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AgentLetter_Form2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, "AIIC AL 11 14");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, "Brooksville, FL 34601-3003");
	}
	@When("User clicks Sinkhole Denial Link and validates information in the form <mtr402>")
	public void user_clicks_sinkhole_denial_link_and_validates_info_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Sinkhole Denial");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		SinkholeDenial_Form2 = PdfComparator.makePdf(driver, "SinkholeDenial.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+SinkholeDenial_Form2);
		wait(8);
		
		SinkholeDenial_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+SinkholeDenial_Form2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, "Brooksville, FL 34601-3003");
	}
	@When("User clicks Billing Tab <mtr402>")
	public void user_clicks_billing_tab_mtr402() {
		click(billingChevron.lnkBilling);
		wait(3);
	}
	@When("User gets next action date and changes system date to next action date <mtr402>")
	public void user_gets_next_action_date_and_changes_system_date_to_next_action_date_mtr402() throws Exception {
		NextActionDate=getNextAction_Text(driver);
		attachScreenShot(driver);
		wait(2);
		ChangeDate_Admin(driver, NextActionDate);
		wait(1);
	}
	@When("User forward policy through batch jobs <mtr402>")
	public void user_forwards_policy_through_batch_jobs_mtr402() throws Exception {
		runBatchJobs(driver, policyNum);
		wait(7);
	}
	@When("User validates 'Cancellation Notice' text and 'Cancel Notice' label is visible")
	public void user_validates_cancellation_notice_text_and_cancel_notice_label_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
		verify_AnyLabel_IsVisible(driver, "Cancel Notice");
		attachScreenShot(driver);
	}
	@When("User gets second next action date and changes system date to second next action date <mtr402>")
	public void user_gets_second_next_action_date_and_changes_system_date_to_second_next_action_date_mtr402() throws Exception {
		NextActionDate2 = getNextAction_Text(driver);
		attachScreenShot(driver);	
		ChangeDate_Admin(driver, NextActionDate2);
		wait(1);
	}
	@When("User validates 'Cancellation Notice' text is visible")
	public void user_validates_cancellation_notice_text_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
		verify_AnyLabel_IsVisible(driver, "Cancel Notice");
	}
	@When("User clicks Cancellation Notice Link and validates information in the form <mtr402>")
	public void user_clicks_cancellation_notice_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Cancellation Notice");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		CancellationNotice_Form = PdfComparator.makePdf(driver, "CancellationNotice.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+CancellationNotice_Form);
		wait(8);
		
		CancellationNotice_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+CancellationNotice_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, CancellationNotice_Data, "AIIC NPC 09 15");
		PdfComparator.verifyPDFText(driver, CancellationNotice_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, CancellationNotice_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, CancellationNotice_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, CancellationNotice_Data, "(352) 796-1451");
		clickApplicationTab(driver);
	}
	@When("User clicks Cancellation Confirmation Link and validates information in the form <mtr402>")
	public void user_clicks_cancellation_confirmation_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Cancellation Confirmation");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		CancellationConfirmation_Form = PdfComparator.makePdf(driver, "CancellationConfirmation.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+CancellationConfirmation_Form);
		wait(8);
		
		CancellationConfirmation_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+CancellationConfirmation_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, CancellationConfirmation_Data, "AIIC CX 11 14");
		PdfComparator.verifyPDFText(driver, CancellationConfirmation_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, CancellationConfirmation_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, CancellationConfirmation_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, CancellationConfirmation_Data, "(352) 796-1451");
	}
	@When("User gets minimum amount for reinstatements <mtr402>")
	public void user_gets_minimum_amount_for_reinstatements_mtr402() throws Exception {
		MinAmountForReinstatements=driver.findElement(By.id("MinAmountToReinstate_text")).getText().toString();
		System.out.println(MinAmountForReinstatements);
	}
	@When("User clicks Make Payment and selects credit card and enters minimum amount for reinstatements <mtr402>")
	public void user_clicks_make_payment_and_selects_cc_402() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
	}
	@When("User makes payment with Credit Card for <mtr402>")
	public void user_makes_payment_with_credit_card_mtr402() throws Exception {
		makePaymentCCPayment_Amount(driver, MinAmountForReinstatements);
		wait(1);
	}
	@When("User validates Payment Confirmation form <mtr402>")
	public void user_validates_payment_confirmation_form_mtr402() throws Exception {
		switchToWindow(driver, "STFile&File");
		
		PaymentConfirmation_Form = PdfComparator.makePdf(driver, "PaymentConfirmation.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+PaymentConfirmation_Form);
		wait(8);
		
		PaymentConfirmation_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PaymentConfirmation_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, PaymentConfirmation_Data, "AIIC PMT 02 18");
		PdfComparator.verifyPDFText(driver, PaymentConfirmation_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, PaymentConfirmation_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, PaymentConfirmation_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, PaymentConfirmation_Data, "(352) 796-1451");
	}
	@When("User validates 'Active' 'Reinstatement' 'Reinstated' 'Cancellation' 'Cancellation Notice' texts are visible")
	public void user_validates_all_expected_texts_are_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Active");
		verify_AnyText_IsVisible(driver, "Reinstatement");
		verify_AnyText_IsVisible(driver, "Reinstated");
		verify_AnyText_IsVisible(driver, "Cancellation");
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
		attachScreenShot(driver);
	}
	@When("User clicks Continuation of Coverage Link and validates information in the form <mtr402>")
	public void user_clicks_Continuation_of_Coverage_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Continuation of Coverage");
		wait(7);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Con_Coverage_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Con_Coverage");
		PdfComparator.SavePdfForm(driver, FileLocation+Con_Coverage_Form);
		wait(8);
		
		Reinstatement_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+Con_Coverage_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, Reinstatement_Data, "AIIC RI 11 14");
		PdfComparator.verifyPDFText(driver, Reinstatement_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, Reinstatement_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, Reinstatement_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, Reinstatement_Data, "(352) 796-1451");
					
		clickApplicationTab(driver);
		wait(1);
	}
	@And("User selects 'Failure to comply with underwriting requirements' as reason <mtr402>")
	public void User_selects_reason_mtr402() throws Exception {	    	   						
		setReason(driver, "Failure to comply with underwriting requirements");
		wait(1);
	}
	@And("User clicks add button and starts and process transaction <mtr402>")
	public void User_clicks_add_button_and_starts_and_processes_transaction_mtr402() throws Exception {	    	   						
		click(historyChevron.btnAdd);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(5);
		attachScreenShot(driver);
	}
	@When("User clicks Non-Renewal Notice Link and validates information in the form <mtr402>")
	public void user_clicks_Non_Renewal_Notice_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Non-Renewal Notice");
		wait(7);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		NonRenewalNotice_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Non-Renewal_Notice");
		PdfComparator.SavePdfForm(driver, FileLocation+NonRenewalNotice_Form);
		wait(8);
		
		NonRenewalNotice_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+NonRenewalNotice_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, NonRenewalNotice_Data, "AIIC NRN 11 14");
		PdfComparator.verifyPDFText(driver, NonRenewalNotice_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, NonRenewalNotice_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, NonRenewalNotice_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, NonRenewalNotice_Data, "(352) 796-1451");
		
		clickApplicationTab(driver);
	}
	@When("User clicks Rescission of Non-Renewal Notice Link and validates information in the form <mtr402>")
	public void user_clicks_Rescission_of_NonRenewal_Notice_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Rescission of Non-Renewal Notice");
		wait(7);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		NonRenewalRescind_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Non-Renewal_Rescission");
		PdfComparator.SavePdfForm(driver, FileLocation+NonRenewalRescind_Form);
		wait(8);
		
		NonRenewalRescind_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+NonRenewalRescind_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, NonRenewalRescind_Data, "AIIC REC 11 14");
		PdfComparator.verifyPDFText(driver, NonRenewalRescind_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, NonRenewalRescind_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, NonRenewalRescind_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, NonRenewalRescind_Data, "(352) 796-1451");
		Thread.sleep(2000);
		
		clickApplicationTab(driver);
	}
	@And("User completes required information on add additional interests screen <mtr402>")
	public void User_completes_required_information_on_add_additional_interests_screen_mtr402() throws Exception {	    	   						
		sendText(additionalinterest.txtMortgageeCode, "10006");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "First Mortgagee");
		click(dwellingChevron.btnSave);
		wait(3);	
	}

	@When("User clicks Finalize button and completes renewal <mtr402>")
	public void user_clicks_finalize_button_and_completes_renewal_mtr402() {
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(9);
		closeUnnecessaryTabs();
	}
	@When("User clicks Renewal Declaration Link and validates information in the form <mtr402>")
	public void user_clicks_Renewal_Declaration_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+RwlDec_Form);
		wait(8);
		
		RwlDeclaration_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 9, 70, 740, 100, 50);
		PdfComparator.verifyFormData(driver, RwlDeclaration_Version, "AIIC DEC 04 23");
		RwlDeclaration_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 9, 0, 0, 600, 290);
		PdfComparator.verifyPDFText(driver, RwlDeclaration_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, RwlDeclaration_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, RwlDeclaration_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, RwlDeclaration_Data, "(352) 796-1451");
	}
	@Then("User clicks Renewal Invoice Link and validates information in the form and completes test <mtr402>")
	public void user_clicks_Renewal_Invoice_link_and_validates_information_in_the_form_mtr402() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Invoice");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		RwlDINST_Form = PdfComparator.makePdf(driver, "HO3_DINST.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+RwlDINST_Form);
		wait(8);
		
		RwlDINST_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDINST_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, RwlDINST_Data, "AIIC DINST 08 22");
		PdfComparator.verifyPDFText(driver, RwlDINST_Data, "Killingsworth Agency, Inc");
		PdfComparator.verifyPDFText(driver, RwlDINST_Data, "19259 Cortez Blvd");
		PdfComparator.verifyPDFText(driver, RwlDINST_Data, "Brooksville, FL 34601-3003");
		PdfComparator.verifyPDFText(driver, RwlDINST_Data, "(352) 796-1451");
		Hooks.scenario.log("Test Case Completed!");
	}
}
