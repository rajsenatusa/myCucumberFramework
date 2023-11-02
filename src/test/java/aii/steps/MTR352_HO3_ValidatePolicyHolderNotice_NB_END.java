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

public class MTR352_HO3_ValidatePolicyHolderNotice_NB_END extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String PolicyHolderNotice_NBForm;
	static String PolicyHolderNotice_NB_Version1;
	static String PolicyHolderNotice_NB_Version;
	static String PolicyHolderNotice_NB_Data;
	static String application_Form;
	static String application_Form_Data;
	static String application_Form_FnE1;
	static String dec_Form;
	static String dec_Form_FnE1;
	static String package_Form;
	static String package_Form_FnE1;
	static String PolicyHolderNotice_NBpack_Version1;
	static String PolicyHolderNotice_NBpack_Version;
	static String PolicyHolderNotice_ENDForm;
	static String PolicyHolderNotice_END_Version1;
	static String PolicyHolderNotice_END_Version;
	static String PolicyHolderNotice_END_Data;
	static String EndPackage_Form;
	static String Endpackage_Form_FnE1;

	@When("User enters all required information on policy information screen <mtr352>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr352() {

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

	@When("User enters all required information on HO3 quote screen <mtr352>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr352() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
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

	@When("User enters all required information on HO3 dwelling screen <mtr352>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr352() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User validates MMA selection defaulted to No")
	public void user_validates_mma_selection_defaulted_to_no() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "No");
	}

	@When("User completes required information on dwelling chevron <mtr352>")
	public void user_completes_required_information_on_dwelling_chevron_mtr352() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User clicks Forms Chevron <mtr352>")
	public void user_clicks_forms_chevron_mtr352() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates 'AIIC HO3 PHN CSAU 11 21' form is visible")
	public void user_validates_11_21_form_is_visible() throws Exception {
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC HO3 PHN CSAU 11 21')]"));
			Hooks.scenario.log("Policy Holder Notice Form");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Holder Notice Form not visible");
			wait(5);
		}
		attachScreenShot(driver);
	}

	@And("User clicks Finalize button <mtr352>")
	public void User_clicks_Finalize_button_mtr352() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr352>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr352()
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

	@And("User clicks 'AIIC HO3 PHN CSAU 11 21' form and do validations")
	public void User_clicks_AIICHO3PHNCSAU1121_form_and_do_validations() throws Exception {
		clickonAnyButton(driver, "AIICHO3PHNCSAU_View");
		wait(5);
		switchToWindow(driver, "aiic-ho3-phn-csau-1121.pdf");
		PolicyHolderNotice_NBForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + PolicyHolderNotice_NBForm);

		wait(8);
		PolicyHolderNotice_NB_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + PolicyHolderNotice_NBForm,
				2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_NB_Version1, "AIIC HO3 PHN CSAU 11 21");
		PolicyHolderNotice_NB_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + PolicyHolderNotice_NBForm,
				1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_NB_Version, "AIIC HO3 PHN CSAU 11 21");

		PolicyHolderNotice_NB_Data = PdfComparator.getPDFData(FileLocation + PolicyHolderNotice_NBForm);
		PdfComparator.verifyPDFText(driver, PolicyHolderNotice_NB_Data, "AIIC HO3 PHN CSAU 11 21");
	}

	@When("User clicks Policy File Chevron <mtr352>")
	public void user_clicks_policy_file_chevron_mtr352() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Application Link and do validation of application form version")
	public void user_clicks_application_link_and_do_validation_of_application_form_version() throws Exception {
		clickOnAnyLink(driver, "Application");
		wait(7);
		switchToWindow(driver, "STFile&File");
		application_Form = PdfComparator.makePdf(driver, "Application.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + application_Form);
		wait(8);
		application_Form_Data = PdfComparator.getPDFData(FileLocation + application_Form);
		PdfComparator.verifyPDFText(driver, application_Form_Data, "AIIC HO3 PHN CSAU 11 21");
		application_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 2, 40, 280, 560,
				270);
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC HO3 PHN CSAU 11 21Policyholder Notice");
	}

	@When("User clicks Declaration Link and do validation of declaration form version")
	public void user_clicks_declaration_link_and_do_validation_of_declaration_form_version() throws Exception {
		clickOnAnyLink(driver, "Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");
		dec_Form = PdfComparator.makePdf(driver, "Declaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + dec_Form);
		wait(8);
		dec_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + dec_Form, 2, 40, 350, 530, 320);
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "AIIC HO3 PHN CSAU 11 21Policyholder Notice");
	}

	@When("User clicks New Business Package Link and do validation of NB form version")
	public void user_clicks_new_business_package_link_and_do_validation_of_nb_form_version() throws Exception {
		clickOnAnyLink(driver, "New Business Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		package_Form = PdfComparator.makePdf(driver, "NBPackage.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + package_Form);

		wait(8);
		package_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 10, 40, 350, 530, 320);
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC HO3 PHN CSAU 11 21Policyholder Notice");

		// Policy Holder notice verification
		PolicyHolderNotice_NBpack_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 3, 400,
				0, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_NBpack_Version1, "AIIC HO3 PHN CSAU 11 21");
		PolicyHolderNotice_NBpack_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 2, 70,
				740, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_NBpack_Version, "AIIC HO3 PHN CSAU 11 21");

		clickApplicationTab(driver);
		wait(1);
	}

	@When("User searches for the policy number <mtr352>")
	public void user_searches_policy_for_mtr352() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr352>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr352() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr352>")
	public void user_clicks_dwelling_chevron_mtr352() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates MMA defaulted to No")
	public void user_validates_mma_defaulted_to_no() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "No");
		wait(1);
		click(dwellingChevron.btnSave);
	}

	@And("User process and completes endorsement <mtr352>")
	public void User_process_and_completes_endorsement_mtr352() {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		closeUnnecessaryTabs();
	}

	@And("User clicks Policy Holder Notice Endorsement form and do validations")
	public void User_clicks_policy_holder_notice_endorsement_form_and_Do_validations() throws Exception {
		clickonAnyButton(driver, "AIICHO3PHNCSAU_View");
		wait(7);
		switchToWindow(driver, "aiic-ho3-phn-csau-1121.pdf");
		PolicyHolderNotice_ENDForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + PolicyHolderNotice_ENDForm);

		wait(8);
		PolicyHolderNotice_END_Version1 = SmartPDFComparator2
				.getPDFtextByArea(FileLocation + PolicyHolderNotice_ENDForm, 2, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_END_Version1, "AIIC HO3 PHN CSAU 11 21");
		PolicyHolderNotice_END_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + PolicyHolderNotice_ENDForm,
				1, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, PolicyHolderNotice_END_Version, "AIIC HO3 PHN CSAU 11 21");

		PolicyHolderNotice_END_Data = PdfComparator.getPDFData(FileLocation + PolicyHolderNotice_ENDForm);
		PdfComparator.verifyPDFText(driver, PolicyHolderNotice_END_Data, "AIIC HO3 PHN CSAU 11 21");
	}

	@And("User clicks Endorsement Package Link and do validation of END form version")
	public void User_clicks_endorsement_package_link_and_do_validation_END_form() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(8);

		Endpackage_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 2, 40, 350, 530,
				320);
		PdfComparator.verifyFormData(driver, Endpackage_Form_FnE1, "AIIC HO3 PHN CSAU 11 21Policyholder Notice");
		Hooks.scenario.log("Test Case Completed!");
	}
}
