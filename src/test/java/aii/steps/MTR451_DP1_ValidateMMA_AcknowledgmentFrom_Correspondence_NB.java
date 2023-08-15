package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.When;

public class MTR451_DP1_ValidateMMA_AcknowledgmentFrom_Correspondence_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String MMA_PreviewApp_Data;
	static String PolicyNumberSuffix;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String application_Form;
	static String MMA_NBApp_Version1;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on DP1 dwelling screen and select MMA as yes and validates 'Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days' message")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_and_select_mma_as_yes() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "Yes");
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days");
		click(dwellingChevron.btnNext);
	}

	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr451>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_mtr451()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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

	@When("User clicks correspondance tab")
	public void user_clicks_correspondance_tab() {
		click(dashboard.btnCorrespondence);
		wait(1);
	}
	@When("User selects 'Mandatory Mediation-Arbitration Acknowledgment' from dropdown")
	public void user_selects_mma_from_dd() {
		selectDropdownText(correspondance.ddSelectCorrespondance,"Mandatory Mediation-Arbitration Acknowledgment");
		click(correspondance.btnAdd);
		wait(2);
	}
	@When("User validates <Producer> and <Local Printer> texts are visible on ui")
	public void user_validates_texts_are_visible() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Producer");
		verify_AnyText_IsVisible(driver, "Local Printer");
	}
	@When("User clicks preview correspondance button")
	public void user_clicks_preview_correspondance_button() throws Exception {
		click(correspondance.btnPreviewCorrespondance);
		wait(2);
	}
	@When("User validates information in the form")
	public void user_validates_information_in_the_form() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		AppForm = PdfComparator.makePdf(driver, "DP1MMA_PreviewCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm);
		wait(1);
		MMA_PreviewApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Version1, "AIIC DP1 MMAA 04 23");
		MMA_PreviewApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Version, "AIIC DP1 MMAA 04 23");
		
		PolicyNumberSuffix = replaceMethod(policyNum, "-01", "");
		
		
		MMA_PreviewApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_PreviewApp_Data, "Davenport, FL 33837-3688");	
	}
	@When("User clicks new recipient button")
	public void user_clicks_new_recipient_button() throws Exception {
		click(correspondance.btnNewRecipient);
		wait(2);
	}
	@When("User gets any dropdown options and validates")
	public void user_gets_any_dropdown_options_and_validates() throws Exception {
		getAnyDropDownOptions(driver, "Name");
		String[] recipient = {"Select...", "Insured - John Smith", "Producer - Members Insurance Center, LLC", "Producer Management - Danielle Moscinski", "Other"};
		verifyAnyDropDownOptions(driver, recipient, "Name");	
	}
	@When("User selects recipient name")
	public void user_selects_recipient_name() {
		selectDropdownText(correspondance.ddName, "Insured - John Smith");
		wait(2);
	}
	@When("User clicks cancel button")
	public void user_clicks_cancel_button() {
		click(correspondance.btnCancel);
		wait(2);
	}
	@When("User clicks Policy File Tab for <mtr451>")
	public void user_clicks_policy_file_tab_for_mtr451() {
		click(policyFileChevron.btnPolicyFilePage);
		wait(2);
	}
	@When("User clicks process correspondance button and validates quote and agent information")
	public void user_clicks_process_correspondance_button_and_validates_quote_agent_information() throws Exception {
		click(correspondance.btnProcessCorrespondence);
		wait(3);
		
		switchToWindow(driver, "STFile&Filename");
		AppForm2 = PdfComparator.makePdf(driver, "DP1MMA_ProcessCorrespondence.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+AppForm2);
			
		Thread.sleep(500);
		MMA_ProcessApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Version1, "AIIC DP1 MMAA 04 23");
		MMA_ProcessApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Version, "AIIC DP1 MMAA 04 23");
		
		MMA_ProcessApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+AppForm2, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_ProcessApp_Data, "Davenport, FL 33837-3688");
	}
	@When("User clicks 'Mandatory Mediation-Arbitration Acknowledgment' form and validates form version of application")
	public void user_clicks_MMA_form_and_validates() throws Exception {
		clickOnAnyLink(driver, "Mandatory Mediation-Arbitration Acknowledgment");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		
		application_Form = PdfComparator.makePdf(driver, "MMA.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+application_Form);
			
		Thread.sleep(500);
		
		MMA_NBApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version1, "AIIC DP1 MMAA 04 23");
		MMA_NBApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version, "AIIC DP1 MMAA 04 23");
		
		
		MMA_NBApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation+application_Form, 2, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "Davenport, FL 33837-3688");
		Hooks.scenario.log("Test Case Completed!");
	}
}
