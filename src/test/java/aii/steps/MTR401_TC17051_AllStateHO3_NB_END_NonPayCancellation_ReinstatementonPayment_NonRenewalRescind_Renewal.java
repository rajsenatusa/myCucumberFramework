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

public class MTR401_TC17051_AllStateHO3_NB_END_NonPayCancellation_ReinstatementonPayment_NonRenewalRescind_Renewal extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AgentName = "TED TODD INSURANCE";
	static String AgentStreetAddress = "23190 Fashion Dr # P216";
	static String AgentCityStateZip = "Estero, FL 33928-2561";
	static String AgentPhone = "(239) 948-1234";
	static String AgentProducerCode = "AG8908A10";
	static String nextDate;
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
	
	@And("User searches Agent <AGISA002537>")
	public void user_searches_agent_AGISA002537() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AGISA002537");
		wait(1);
	}
	@And("User sets Yes for 'Allow user to view Consent to Rate Fields' and 'Allow user to edit Consent to Rate Fields' fields")
	public void user_sets_yes_for_consent_related_fields() {
		sendText(userLookup.txtAllowUserViewConsentRateFields, "Yes");
		sendText(userLookup.txtAllowUserEditConsentRateFields, "Yes");
	}
	@When("User enters all required information on policy information screen <mtr401>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr401() {

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
	@When("User enters HO3 product selection information and current date as effective date <mtr401>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr401() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	@When("User enters all required information on HO3 quote screen <mtr401>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr401() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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
	@When("User enters all required information on HO3 dwelling screen <mtr401>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr401() {
		// Quote Dwelling information was filled here
		// sendText(dwellingChevron.txtYearConstruction, "2002");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
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
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$15,000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@And("User clicks consent to rate")
	public void user_clicks_consent_to_rate() {
		driver.findElement(By.id("Building.ConsentToRate")).click();
		wait(1);
	}
	@And("User sets consent to rate value as '$100.000'")
	public void user_sets_consent_to_rate_value_as_100000() throws Exception {
		setDataToAnyTextboxField(driver, "ConsentToRate value", "Building.ConsentToRateValue", "$100,000");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User selects 'Insurance Quote' from dropdown")
	public void user_selects_insurance_quote_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Insurance Quote");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User validates 'Agent Name' label is visible")
	public void user_validates_agent_name_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, AgentName);
	}
	@When("User validates form version on quote ui")
	public void user_validates_form_version_quote_ui() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		QuoteForm = PdfComparator.makePdf(driver, "HO3Quote_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+QuoteForm);
			
		wait(8);
		Quote_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version, "AIIC QT 07 19");
		
		Agency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, Agency_Data, AgentName );
		PdfComparator.verifyPDFText(driver, Agency_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, Agency_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, Agency_Data, AgentPhone);
	}
	@When("User clicks process correspondance button and validates form version")
	public void user_clicks_process_correspondance_btn_and_valides_form_version() throws Exception {
		click(correspondance.btnProcessCorrespondence);
		wait(3);
		switchToWindow(driver, "STFile&Filename");
		QuoteForm2 = PdfComparator.makePdf(driver, "HO3Quote_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+QuoteForm2);
			
		wait(8);
		Quote_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm2, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version2, "AIIC QT 07 19");
		
		Agency_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, Agency_Data2, AgentName);
		PdfComparator.verifyPDFText(driver, Agency_Data2, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, Agency_Data2, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, Agency_Data2, AgentPhone);
	}
	@When("User clicks Policy File Chevron <mtr401>")
	public void user_clicks_policy_file_chevron_mtr401() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User clicks Insurance Quote Link and validates form version")
	public void user_clicks_insurance_quote_link_and_validates_form_version() throws Exception {
		click(policyFileChevron.btnInsuranceQuote);
		wait(5);
		switchToWindow(driver, "STFile&Filename");
		PolicyQuote = PdfComparator.makePdf(driver, "InsuranceQuote.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+PolicyQuote);
			
		Thread.sleep(500);
		PolicyQuote_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyQuote, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, PolicyQuote_Version2, "AIIC QT 07 19");
		
		PolicyQuote_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyQuote, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, AgentName);
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, PolicyQuote_Data, AgentPhone);

		clickApplicationTab(driver);
	}
	@When("User sets dwelling type, sets roof update and roof material")
	public void user_sets_dwelling_type_sets_roof_update_and_roof_material() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2017");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User selects 'Application' from dropdown")
	public void user_selects_application_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Application");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User validates form version on application ui")
	public void user_validates_form_version_on_application_ui() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		AppForm = PdfComparator.makePdf(driver, "HO3App_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm);
			
		wait(8);
		App_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, App_Version, "AIIC HO3 APP 04 22");
		
		AgencyApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, AgentName);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, AgentPhone);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data, AgentProducerCode);
	}
	@When("User clicks Process Correspondance and validates quote and agent information in forms")
	public void user_clicks_process_correspondance_and_validates_quote_and_agent_information_in_forms() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		AppForm2 = PdfComparator.makePdf(driver, "HO3App_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm2);
			
		wait(8);
		App_Version2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, App_Version2, "AIIC HO3 APP 04 22");
		
		AgencyApp_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, AgentName );
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, AgentPhone);
		PdfComparator.verifyPDFText(driver, AgencyApp_Data2, AgentProducerCode);
		
		clickApplicationTab(driver);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr401>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr401()
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
	@When("User clicks Application Link and validates application form version")
	public void user_clicks_application_link_and_validates_application_form_version() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		PolicyAppForm = PdfComparator.makePdf(driver, "HO3App_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+PolicyAppForm);
			
		Thread.sleep(500);
		PolicyApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 1, 50, 750, 120, 40);
		PdfComparator.verifyFormData(driver, PolicyApp_Version, "AIIC HO3 APP 04 22");
		
		PolicyAppAgency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 1, 0, 0, 620, 400);
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, AgentName );
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, AgentPhone);
		PdfComparator.verifyPDFText(driver, PolicyAppAgency_Data, AgentProducerCode);
		
		//Consent to rate form
		Consent_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 9, 30, 740, 100, 30);
		PdfComparator.verifyFormData(driver, Consent_Version, "AIIC ACR 07 18");
		
		ConsentAgency_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+PolicyAppForm, 9, 0, 0, 620, 400);
		
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, ConsentAgency_Data, AgentPhone);
	}
	@When("User clicks New Business Invoice Link and validates information in form")
	public void user_clicks_new_business_invoice_link_and_validates_information_in_forms() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Invoice");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		DINST_Form = PdfComparator.makePdf(driver, "HO3_DINST.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+DINST_Form);
		wait(8);
		
		DINST_Data = PdfComparator.getPDFData(FileLocation+DINST_Form);
		PdfComparator.verifyPDFText(driver, DINST_Data, "AIIC DINST 11 14");
		PdfComparator.verifyPDFText(driver, DINST_Data, AgentName);
		PdfComparator.verifyPDFText(driver, DINST_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, DINST_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, DINST_Data, AgentPhone);
	}
	@When("User clicks Declaration Link and validates information in the form")
	public void user_clicks_declaration_link_and_validates_information_in_the_form() throws Exception {
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

		PdfComparator.verifyPDFText(driver, Declaration_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, Declaration_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, Declaration_Data, AgentPhone);
		
		clickApplicationTab(driver);
		wait(1);;
	}
	@And("User sets new effective date as current date and starts endorsement <mtr401>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr401() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@And("User clicks Finalize button and Endorses Policy <mtr401>")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr401_() {	    
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();	 
		wait(5);	
		closeUnnecessaryTabs();
	}
	@And("User clicks Endorsement Package Link and validates information in the form")
	public void User_clicks_endorsement_package_link_and_validateS_information_in_the_form() throws Exception {	    
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
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, EndDeclaration_Data, AgentPhone);
	}
	@When("User selects 'Statement of No Loss' from dropdown")
	public void user_selects_statement_of_no_loss_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Statement of No Loss");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User clicks Process Correspondance")
	public void user_clicks_process_correspondance() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(3);
		closeUnnecessaryTabs();
	}
	@When("User clicks Statement of No Loss Link and validates information in the form")
	public void user_clicks_statement_of_no_loss_link_and_validates_information_in_the_form() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Statement of No Loss");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		
		StatementLoss_Form = PdfComparator.makePdf(driver, "StatementOfNoLoss.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+StatementLoss_Form);
		Thread.sleep(500);
		
		SNL_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+StatementLoss_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, SNL_Data, "AIIC SNL 11 14");
		PdfComparator.verifyPDFText(driver, SNL_Data, AgentName);
		PdfComparator.verifyPDFText(driver, SNL_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, SNL_Data, AgentCityStateZip);
		PdfComparator.verifyPDFText(driver, SNL_Data, AgentPhone);
	}
	@When("User searches for the policy number <mtr401>")
	public void user_searches_policy_for_mtr401() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User selects 'Agent Letter' from dropdown")
	public void user_selects_agent_letter_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Agent Letter");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User sets data for text box")
	public void user_sets_data_for_text_box() throws Exception {
		setDataToAnyTextboxField(driver, "LetterText", "Question_LetterText", "Sample");
		wait(1);
	}
	@When("User clicks Process Correspondance and validates information in the form")
	public void user_clicks_process_correspondance_validates_information_in_the_form() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		AgentLetter_Form = PdfComparator.makePdf(driver, "AgentLetter.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AgentLetter_Form);
		wait(8);
		
		AgentLetter_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AgentLetter_Form, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, "AIIC AL 11 14");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, AgentName);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data, AgentCityStateZip);
	}
	@When("User selects 'Sinkhole Denial' from dropdown")
	public void user_selects_sinkhole_denial_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Sinkhole Denial");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User clicks Process Correspondance and validates information in the sinkhole loss form")
	public void user_clicks_process_correspondance_validates_information_in_sinkhole_loss_form() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		SinkholeDenial_Form = PdfComparator.makePdf(driver, "SinkholeDenial.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+SinkholeDenial_Form);
		wait(8);
		
		SinkholeDenial_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+SinkholeDenial_Form, 1, 0, 0, 620, 790);
		
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, AgentName);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data, AgentCityStateZip);
	}
	@When("User clicks Agent Letter Link and validates information in the form")
	public void user_clicks_agent_letter_link_and_validates_information_in_the_Form() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Agent Letter");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		AgentLetter_Form2 = PdfComparator.makePdf(driver, "AgentLetter.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AgentLetter_Form2);
		wait(8);
		
		AgentLetter_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AgentLetter_Form2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, "AIIC AL 11 14");
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, AgentName);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, AgentLetter_Data2, AgentCityStateZip);
	}
	@When("User clicks Sinkhole Denial Link and validates information in the form")
	public void user_clicks_sinkhole_denial_link_and_validates_info() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Sinkhole Denial");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		SinkholeDenial_Form2 = PdfComparator.makePdf(driver, "SinkholeDenial.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+SinkholeDenial_Form2);
		wait(8);
		
		SinkholeDenial_Data2 = SmartPDFComparator2.getPDFtextByArea(FileLocation+SinkholeDenial_Form2, 1, 0, 0, 620, 790);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, AgentName);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, AgentStreetAddress);
		PdfComparator.verifyPDFText(driver, SinkholeDenial_Data2, AgentCityStateZip);
	}
	@When("User clicks Billing Tab <mtr401>")
	public void user_clicks_billing_tab_mtr401() {
		click(billingChevron.lnkBilling);
		wait(3);
	}
	@When("User gets next action date and changes system date to next action date <mtr401>")
	public void user_gets_next_action_date_and_changes_system_date_to_next_action_date_mtr401() throws Exception {
		nextDate=getNextActionDate();
		wait(2);
		ChangeDate_Admin(driver, nextDate);
		wait(1);
	}
	@When("User forward policy through batch jobs")
	public void user_forwards_policy_through_batch_jobs() throws Exception {
		runBatchJobs(driver, policyNum);
		wait(7);
	}
	@When("User validates 'Cancellation Notice' label is visible")
	public void user_validates_cancellation_notice_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Cancellation Notice");
	}
	@When("User gets second next action date and changes system date to second next action date <mtr401>")
	public void user_gets_second_next_action_date_and_changes_system_date_to_second_next_action_date_mtr401() throws Exception {
		String NextActionDate2 = getNextAction_Text(driver);
			
		ChangeDate_Admin(driver, NextActionDate2);
		wait(1);
	}
}
