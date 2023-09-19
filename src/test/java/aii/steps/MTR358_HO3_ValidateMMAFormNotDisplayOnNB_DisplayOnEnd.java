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

public class MTR358_HO3_ValidateMMAFormNotDisplayOnNB_DisplayOnEnd extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String MMA_EndForm;
	static String MMA_End_VersionMMA1;
	static String MMA_End_MMAData;
	static String EndPackage_Form;
	static String Endpackage_Form_FnE1;
	static String MMA_End1;
	
	@When("User enters all required information on policy information screen <mtr358>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr358() {

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
	@When("User enters all required information on HO3 quote screen <mtr358>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr358() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen <mtr358>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr358() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
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
	@When("User completes required information on dwelling chevron <mtr358>")
	public void user_completes_required_information_on_dwelling_chevron_mtr358() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User clicks Forms Chevron <mtr358>")
	public void user_clicks_forms_chevron_mtr358() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}
	@When("User validates 'AIIC HO3 CSAU 11 21' form is not visible")
	public void user_validates_csau_ho3_11_21_form_is_not_visible() throws Exception {
		verify_AnyText_NotVisible(driver, "AIIC HO3 CSAU 11 21");
		attachScreenShot(driver);
		wait(1);
	}
	@And("User clicks Finalize button <mtr358>")
	public void User_clicks_Finalize_button_mtr358() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr358>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr358()
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
	@And("User sets new effective date as current date and starts endorsement <mtr358>")
	public void User_sets_new_effective_date_as_current_date_days_and_starts_endorsement_mtr358()
			throws Exception {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
		click(dwellingChevron.btnDwelling);
		wait(2);
		attachScreenShot(driver);
	}
	@When("User clicks Dwelling Chevron <mtr358>")
	public void user_clicks_dwelling_chevron_mtr358() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User sets MMA as Yes and clicks Save")
	public void user_sets_MMA_AS_yes_and_clicks_save() throws Exception {
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User validates 'Mediation Arbitration Change requires Underwriting Approval' message is visible on closeout screen")
	public void user_validates_MMA_requires_uw_approval_message_is_visible_on_closeout_screen() throws Exception {
		verify_AnyText_IsVisible(driver, "Mediation Arbitration Change requires Underwriting Approval");
	}
	@When("User takes note of the application for <mtr358>")
	public void user_takes_note_of_the_application__number_for_mtr358() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <mtr358>")
	public void user_searches_application_for_mtr358() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User process and completes endorsement <mtr358>")
	public void user_process_and_completes_endorsement_mtr358() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		closeUnnecessaryTabs();
	}
	@When("User validates 'AIIC HO3 CSAU 04 23' form is visible")
	public void user_validates_csau_ho3_04_23_form_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC HO3 CSAU 04 23");
		attachScreenShot(driver);
		wait(1);
	}
	@When("User clicks form and do validations")
	public void user_clicks_form_and_do_validations() throws Exception {
		clickonAnyButton(driver, "AIICHO3CSAU_View");
		wait(7);
		switchToWindow(driver, "aiic-ho3-csau-1121.pdf");
		MMA_EndForm = PdfComparator.getPdfName(driver);
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+MMA_EndForm);
		wait(10);
	
		MMA_End_VersionMMA1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+MMA_EndForm, 1, 40, 700, 200, 150);
		PdfComparator.verifyFormData(driver, MMA_End_VersionMMA1, "AIIC HO3 CSAU 04 23");
		
		MMA_End_MMAData = PdfComparator.getPDFData(FileLocation+MMA_EndForm);
		PdfComparator.verifyPDFText(driver, MMA_End_MMAData, "AIIC HO3 CSAU 04 23");
	}
	@When("User clicks Policy File Chevron <mtr358>")
	public void user_clicks_policy_file_chevron_mtr358() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User clicks Endorsement Package Link and validates form version and completes test")
	public void user_clicks_endorsement_package_link_and_validates_form_version_and_completes_test() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(8);
		switchToWindow(driver, "STFile&File");
		
		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+EndPackage_Form);
		wait(10);
		
		Endpackage_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+EndPackage_Form, 2, 40, 350, 530, 320);
		PdfComparator.verifyFormData(driver, Endpackage_Form_FnE1, "AIIC HO3 CSAU 04 23Mandatory Mediation-Arbitration Endorsement");

		MMA_End1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+MMA_EndForm, 5, 40, 700, 200, 150);
		PdfComparator.verifyFormData(driver, MMA_End1, "AIIC HO3 CSAU 04 23");
	}
}
