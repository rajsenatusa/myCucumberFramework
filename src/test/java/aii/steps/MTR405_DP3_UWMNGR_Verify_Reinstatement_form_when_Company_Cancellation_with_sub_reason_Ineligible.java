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

public class MTR405_DP3_UWMNGR_Verify_Reinstatement_form_when_Company_Cancellation_with_sub_reason_Ineligible
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String REINForm;
	static String ReinForm_Version;
	static String ReinForm_Name;
	static String Continue_Cov_Form;
	static String CC_Page;
	static String CC_Page2;
	static String CC_Page3;
	static String CC_Page4;

	@When("User enters all required information on policy information screen <mtr405>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr405() {

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

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr405>")
	public void user_enters_all_current_date_as_prior_date_mtr405() throws Exception {
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

	@When("User enters all required information on DP3 dwelling screen <mtr405>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr405() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
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

	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr405>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs_mtr405()
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

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User changes system date to current date <mtr405>")
	public void user_changes_system_date_to_current_date_mtr405() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User searches for the policy number <mtr405>")
	public void user_searches_policy_for_mtr405() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr405>")
	public void user_clicks_make_payment_and_selects_cc_mtr405() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr405>")
	public void user_makes_payment_with_credit_card_mtr405() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@And("User selects effective date as cancel date 'current date' <mtr405>")
	public void User_selects_effective_date_as_cancel_date_mtr405() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}

	@And("User selects Property Ineligible as reason <mtr405>")
	public void User_selects_reason_mtr405() {
		selectDropdownText(historyChevron.ddReason, "Property ineligible");
		wait(2);
	}

	@And("User selects Built on landfill or refuse as subreason <mtr405>")
	public void User_selects_subreason_mtr405() throws Exception {
		wait(2);
		setSubReason(driver, "Built on landfill or refuse");
		wait(1);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User process cancellation <mtr405>")
	public void User_process_cancellation_mtr405() {
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}

	@And("User completes cancellation transaction and validates policy transaction status as cancelled <mtr405>")
	public void User_completes_cancellation_transaction_mtr405() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Cancellation Completed!");
		verify_AnyText_IsVisible(driver, "Cancellation");
		attachScreenShot(driver);
	}

	@And("User completes and process reinstatement transaction <mtr405>")
	public void User_completes_and_process_reinstatement_transaction_mtr405() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		verify_AnyText_IsVisible(driver, "Reinstatement");
		Hooks.scenario.log("Policy Reinstatement Completed!");
		attachScreenShot(driver);
	}

	@When("User validates <AIIC RI 11 14> form is visible on <mtr405>")
	public void user_validates_AIIC_RI_11_14_form_is_visible_on_mtr405() throws Exception {
		verify_AnyText_IsVisible(driver, "REINNOTICE");
	}

	@And("User clicks Rein Notice Form and validates form details as expected <mtr405>")
	public void user_clicks_Rein_Notice_form_and_validates_form_details_as_expected_mtr405() throws Exception {
		click(formsChevron.btnReinNotice);
		wait(8);
		switchToWindow(driver, "STFile&File");
		REINForm = PdfComparator.makePdf(driver, "ReinstatementForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + REINForm);
		wait(10);
		ReinForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + REINForm, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ReinForm_Version, "AIIC RI 11 14");
		ReinForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + REINForm, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ReinForm_Name, "REINSTATEMENT NOTICE");
	}

	@Then("User clicks Continuation of Coverage link and validates AIIC RI 11 14 form version listed in the package <mtr405>")
	public void user_clicks_continuation_of_coverage_Link_and_validates_AIIC_RI_11_14_form_version_listed_in_the_package_mtr405()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Continuation of Coverage");
		wait(7);
		switchToWindow(driver, "STFile&File");

		Continue_Cov_Form = PdfComparator.makePdf(driver, "ContiCForm.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Continue_Cov_Form);
		wait(15);

		// Declaration page Forms
		CC_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page, "AIIC RI 11 14");
		CC_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page2, "REINSTATEMENT NOTICE");
		CC_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page3,
				"Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since");
		CC_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page4, "underwriting reason(s) met.");

		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User clicks Forms Chevron <mtr405>")
	public void user_clicks_forms_chevron_mtr405() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User clicks Policy File Chevron <mtr405>")
	public void user_clicks_policy_file_chevron_mtr405() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
}
