package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.When;

public class MTR363_DP3_IntegritySelect_ValidateChecklistDisplaysACVWhenCovCGreaterAndPPRCNotChecked_NB_END_RNWL
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorseDate = currentDate.plusDays(10);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String cov_C = dwellingChevron.txtCoverageC.getText();
	static String policyNum;
	static String NBPackage_Form;
	static String NBCheckList_Version;
	static String NBCheckList_Name;
	static String PPRCdata;
	static String totalDue;
	static String Rwl2Dec_Form;
	static String RnwlCheckList_Version;
	static String RnwlCheckList_Name;
	static String RnwlPPRCdata;

	@When("User validates Personal Property Replacement Cost checkbox has been enabled and not selected")
	public void user_validates_coverage_c_defaults_to_25_on_integrity_select_package() throws Exception {
		verifyAnyCoverageCheckbox_EnabledAndNotSelected(driver, "PPReplacementCost");
	}

	@When("User checks dwelling chevron and validates Personal Property Replacement Cost checkbox has been enabled and not selected")
	public void user_checks_dwelling_chevron_and_validates_pprc() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(2);
		verifyAnyCoverageCheckbox_EnabledAndNotSelected(driver, "PPReplacementCost");
		click(dwellingChevron.btnSave);

	}

	@When("User takes note of the Coverage C")
	public void user_takes_note_of_the_coverage_c() throws Exception {
		String cov_C = dwellingChevron.txtCoverageC.getText();
		Hooks.scenario.log(cov_C);
	}

	@When("User finalizes transaction for <MTR363>")
	public void user_finalizes_transaction_for_mtr363() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User clicks Policy File Chevron")
	public void user_clicks_policy_file_chevron() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks New Business Package link")
	public void user_clicks_new_business_package_link() throws Exception {
		click(policyFileChevron.btnNewBusinessPackage);
		wait(3);
	}

	@When("User switches that forms and validates <OIR-B1-1670> has been attached and shows Actual Cash Value for Loss Settlement Basis for Coverage C")
	public void user_switches_that_forms_and_validates() throws Exception {

		switchToWindow(driver, "STFile&File");
		wait(3);
		NBPackage_Form = PdfComparator.makePdf(driver, "NewBusinessPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);
		wait(8);
		// Checklist form
		NBCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 67, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, NBCheckList_Version, "OIR-B1-1670");

		NBCheckList_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBCheckList_Name, "Checklist of Coverage");

		PPRCdata = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 67, 40, 550, 550, 100);
		PdfComparator.verifyFormData(driver, PPRCdata, cov_C);
		PdfComparator.verifyFormData(driver, PPRCdata, "Actual Cash Value");
	}

	@When("User navigates Policy chevron and starts endorsement transaction plus <10> days current date")
	public void user_navigates_policy_chevron_and_starts_endorsement() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		click(dwellingChevron.btnMore);
		click(dwellingChevron.btnStartTransaction);
		wait(3);
		selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
		wait(1);
		click(dashboard.btnSelect);
		sendText(dashboard.txtSelectDate, dtf.format(endorseDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User clicks Dwelling Chevron")
	public void user_clicks_dwelling_chevron() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User takes note of the policy number for <MTR363>")
	public void user_takes_note_of_the_policy_number_for_mtr363() throws Exception {
		try {
			policyNum = driver.findElement(By.id("QuoteAppSummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User changes package as Basic Package and validates Personal Property Replacement Cost checkbox has been enabled and not selected")
	public void user_changes_package_as_basic_and_validates_ppr() throws Exception {
		click(dwellingChevron.rbBasicPackage);
		Hooks.scenario.log("Basic Package selected");
		click(dwellingChevron.btnSave);
		wait(3);
		verifyAnyCoverageCheckbox_EnabledAndNotSelected(driver, "PPReplacementCost");
	}

	@When("User searches for Policy Number for <MTR363>")
	public void user_searches_for_policy_number_for_mtr363() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User makes payment with Credit Card")
	public void user_makes_payment_with_credit_card() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User clicks Make Payment and selects credit card and enters due amount")
	public void user_clicks_make_payment_and_selects_cc() {
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

	@When("User does Auto Renewal for the policy with batch jobs")
	public void user_does_auto_renewal() throws Exception {

		policyNum = closeoutChevron.txtAccountNumber.getText().toString();
		runAutoRenewPolicy(driver, policyNum, "01", "02");
	}

	@When("User clicks Renewal Decleration link")
	public void user_clicks_renewal_decleration_link() throws Exception {
		click(policyFileChevron.btnRenewalDeclaration);
		wait(3);
	}

	@When("User clicks Endorsement Package link")
	public void User_clicks_Endorsement_Package_link() throws Exception {
		click(policyFileChevron.btnEndorsementPackageForm);
		wait(3);
	}

	@When("User switches that forms and validates <OIR-B1-1670> has been attached and shows Actual Cash Value for Loss Settlement Basis for Coverage C on renewal package")
	public void user_validates_forms_on_renewal() throws Exception {
		switchToWindow(driver, "STFile&File");
		Rwl2Dec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration2.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Rwl2Dec_Form);
		wait(8);
		// Checklist form
		RnwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 49, 25, 750, 70, 30);
		PdfComparator.verifyFormData(driver, RnwlCheckList_Version, "OIR-B1-1670");

		RnwlCheckList_Name = PdfComparator.getPDFData(FileLocation + Rwl2Dec_Form);
		PdfComparator.verifyPDFText(driver, RnwlCheckList_Name, "Checklist of Coverage");

		RnwlPPRCdata = SmartPDFComparator2.getPDFtextByArea(FileLocation + Rwl2Dec_Form, 48, 40, 550, 550, 100);
		PdfComparator.verifyFormData(driver, RnwlPPRCdata, "Excluded");
		PdfComparator.verifyFormData(driver, RnwlPPRCdata, "Not Applicable");
	}

}
