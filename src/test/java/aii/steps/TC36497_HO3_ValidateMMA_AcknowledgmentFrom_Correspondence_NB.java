package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC36497_HO3_ValidateMMA_AcknowledgmentFrom_Correspondence_NB extends CommonMethods{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	
	@When("User enters all required information on policy information screen <tc36497>")
	public void user_enters_all_required_information_on_policy_information_screen_tc36497() {

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
	@When("User enters all required information on HO3 quote screen <tc36497>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc36497() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen <tc36497>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc36497() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron and validates MMA dropdown defaulted to Yes <tc36497>")
	public void user_completes_required_information_on_dwelling_chevron_tc36497() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "Yes");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <tc36497>")
	public void User_clicks_Finalize_button_tc36497() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc36497>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc36497()
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
	@When("User selects 'Mandatory Mediation-Arbitration Acknowledgment' from dropdown <tc36497>")
	public void user_selects_mma_acknowledgement_from_dd_tc36497() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Mandatory Mediation-Arbitration Acknowledgment");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User validates 'Producer' and 'Local Printer' texts are visible on ui")
	public void user_validates_producer_and_localprinter_texts_are_visible_on_ui() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Producer");
		verify_AnyText_IsVisible(driver, "Local Printer");
	}
	@When("User validates form version on ui <tc36497>")
	public void user_validates_form_version_on_ui_tc36497() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		AppForm = PdfComparator.makePdf(driver, "HO3MMA_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm);
			
		wait(10);
		MMA_PreviewApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Version1, "AIIC HO3 MMAA 04 23");
		MMA_PreviewApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Version, "AIIC HO3 MMAA 04 23");
		
		PolicyNumberSuffix = replaceMethod(policyNum, "-01", "");
			
		MMA_PreviewApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, "Davenport, FL 33837-3688");
	}
	@When("User clicks new recipient and completes required information")
	public void user_clicks_new_recipient_and_completes_required_information() throws Exception {
		click(driver.findElement(By.id("NewRecipient")));
		getAnyDropDownOptions(driver, "Name");
		String[] recipient = {"Select...", "Insured - John Richards", "Producer - Members Insurance Center, LLC", "Producer Management - Danielle Moscinski", "Other"};
		verifyAnyDropDownOptions(driver, recipient, "Name");
		
		//select recipient name
		selectDropdownText(driver.findElement(By.id("Name")), "Insured - John Richards");
		wait(2);
		attachScreenShot(driver);
		clickonAnyButton(driver, "Cancel");
	}
	@When("User clicks Process Correspondance and validates quote and agent information in forms <tc36497>")
	public void user_clicks_process_correspondance_and_validates_quote_and_agent_information_in_forms_tc36497() throws Exception {
		clickonAnyButton(driver, "ProcessCorrespondence");
		wait(1);
		switchToWindow(driver, "STFile&Filename");
		AppForm2 = PdfComparator.makePdf(driver, "HO3MMA_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm2);
			
		wait(10);
		MMA_ProcessApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Version1, "AIIC HO3 MMAA 04 23");
		MMA_ProcessApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Version, "AIIC HO3 MMAA 04 23");
		
		MMA_ProcessApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, "Davenport, FL 33837-3688");
		
		clickApplicationTab(driver);
	}
	@When("User clicks Policy File Chevron <tc36497>")
	public void user_clicks_policy_file_chevron_tc36497() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User click MMA Acknowledgement and validates form version <tc36497>")
	public void user_click_mma_acknowledgement_and_validates_form_version_tc36497() throws Exception {
		clickOnAnyLink(driver, "Mandatory Mediation-Arbitration Acknowledgment");
		wait(7);
		switchToWindow(driver, "STFile&File");
		
		application_Form = PdfComparator.makePdf(driver, "MMA.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+application_Form);
			
		wait(10);
		
		MMA_NBApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version1, "AIIC HO3 MMAA 04 23");
		MMA_NBApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version, "AIIC HO3 MMAA 04 23");
		
		
		MMA_NBApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "Davenport, FL 33837-3688");
		Hooks.scenario.log("Test Case Completed!");
	}
}
