package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR367_DP3_OwnerOccupiedEndForm_EndorsetoIntegritySelect_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String OOCov_Data;
	static String OwnerOccupiedForm;
	static String OOCov_Name;
	static String EndPackage_Form;
	static String EndDec_Page;
	static String Declaration_Version;

	@When("User clicks Forms Chevron")
	public void user_clicks_forms_chevron() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}
	@When("User enters all required information on policy information screen <mtr367>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr367() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
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
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr367>")
	public void user_enters_all_current_date_as_prior_date_mtr367() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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
	@When("User enters all required information on DP3 dwelling screen <mtr367>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr367() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
	}
	@When("User validates <AIIC DP3 OO 04 23> form is not visible on basic policy")
	public void user_validates_desired_form_is_not_visible_on_basic_policy() throws Exception {
		verify_AnyText_NotVisible(driver, "AIIC DP3 OO 04 23");
	}

	@When("User finalizes transaction and issues policy")
	public void user_finalizes_transaction_and_issues_policy() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(4);
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
	}

	@When("User navigates dwelling tab and selects integrity select package")
	public void user_navigates_dwelling_tab_and_selects_integrity_select_package() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(4);
		click(dwellingChevron.rbIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates <AIIC DP3 OO 04 23> form is visible on integrity policy")
	public void user_validates_form_is_visible_on_integrity_policy() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP3 OO 04 23");
	}

	@When("User clicks Sample Form and validates form details as expected")
	public void user_clicks_sample_form_and_validates_form_details_as_expected() throws Exception {
		click(formsChevron.btnAIICDP3OO0423);
		wait(8);
		switchToWindow(driver, "aiic-dp3-oo-0423.pdf");
		OwnerOccupiedForm = PdfComparator.getPdfName(driver);
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + OwnerOccupiedForm);
		wait(10);
		OOCov_Data = PdfComparator.getPDFData(FileLocation + OwnerOccupiedForm);
		PdfComparator.verifyPDFText(driver, OOCov_Data, "AIIC DP3 OO 04 23");
		OOCov_Name = PdfComparator.getPDFData(FileLocation + OwnerOccupiedForm);
		PdfComparator.verifyPDFText(driver, OOCov_Name, "OWNER OCCUPIED ENDORSEMENT");
	}

	@When("User clicks Policy File Tab")
	public void user_clicks_policy_file_tab() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User validates form details on endorsement package")
	public void user_validates_form_details_on_endorsement_package() throws Exception {
		click(policyFileChevron.btnEndorsementPackageForm);
		wait(7);
		switchToWindow(driver, "STFile&File");
		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(12);
		// Declaration page Forms and endorsement section
		EndDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 2, 30, 450, 560, 350);
		PdfComparator.verifyFormData(driver, EndDec_Page, "AIIC DP3 OO 04 23");

		// Declaration Page
		Declaration_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 17, 70, 740,
				100, 50);
		PdfComparator.verifyFormData(driver, Declaration_Version, "AIIC DP3 OO 04 23");

		Hooks.scenario.log("MTR-367 Test Case completed successfully, test passed!");
	}

}
