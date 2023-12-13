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

public class MTR404_DP1_ValidateWhenCancellingAndReinstatIngThenCorrectReinstatementFormGenerates_CANCELLATION_REINSTATE
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime cancelDate = currentDate.plusDays(30);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String Con_Coverage_Form;
	static String Con_Coverage_Form_Version;
	static String Con_Coverage_Data;
	static String policyNum;

	
	@When("User enters DP1 product selection information and current date as effective date")
	public void user_enters_dp1_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp1);
	}
	@When("User enters all required information on policy information screen <mtr404>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr404() {

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
	@And("User enters Producer Code <mtr404>")
	public void User_enters_Producer_Code_mtr404() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr404>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr404() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <mtr404>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr404() {

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
		click(dwellingChevron.btnNext);
	}
	@When("User validates that DP1 policy has been created successfully and close tabs")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs() throws Exception {

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
	}

	@And("User clicks Cancellation Transaction Selection")
	public void User_clicks_cancellation_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Cancellation");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User selects Cancellation Type as Company")
	public void User_selects_cancellation_type() {
		selectDropdownText(historyChevron.ddCancellationType, "Company");
		wait(2);
	}

	@And("User selects Property ineligible as reason")
	public void User_selects_reason() {
		selectDropdownText(historyChevron.ddReason, "Property ineligible");
		wait(2);
	}

	@And("User selects Constructed over water as subreason")
	public void User_selects_subreason() {
		selectDropdownText(historyChevron.ddSubReason, "Constructed over water");
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects effective date as cancel date 'current date plus 30 days'")
	public void User_sets_effective_date_as_cancel_date() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(cancelDate));
		wait(2);
	}

	@And("User selects pro rate as cancel type and process transaction")
	public void User_selects_pro_rate() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
	}

	@And("User completes cancellation transaction and validates policy transaction status as cancelled")
	public void User_completes_cancellation_transaction() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Cancellation Completed!");
		attachScreenShot(driver);
	}

	@And("User clicks Reinstatement Transaction Selection")
	public void User_clicks_reinstatement_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
		wait(1);
		click(dashboard.btnSelect);
		wait(2);
	}

	@And("User clicks Start button and process transaction")
	public void User_clicks_start_button_and_process_transaction() throws Exception {
		click(historyChevron.btnStart);
		wait(3);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		closeUnnecessaryTabs();
		attachScreenShot(driver);
	}

	@And("User verifies AIIC RI 11 14 generated on Forms chevron")
	public void User_verifies_rein_form_generated() throws Exception {
		scrollToAnyField(driver, "REINNOTICE");
		verify_AnyText_IsVisible(driver, "REINNOTICE");
		verify_AnyText_IsVisible(driver, "Reinstatement Notice");
		scrollToAnyField(driver, "REINNOTICE");
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for Policy Number for <MTR404>")
	public void user_searches_for_policy_number_for_mtr404() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Policy File Chevron for <MTR404>")
	public void user_clicks_policy_file_chevron_for_mtr404() throws Exception {
		waitForVisibility(driver.findElement(By.id("Tab_Documents")));
		click(driver.findElement(By.id("Tab_Documents")));
		wait(5);
	}

	@And("User validates Continuation of Coverage form has been displayed")
	public void User_validates_continuation_generated() throws Exception {
		verifyInstallmentInvoiceForm(driver, "Continuation of Coverage");
	}

	@Then("User clicks Continuation of Coverage form, saves it to local and do comparisions and validations")
	public void User_clicks_form_and_does_validations() throws Exception {
		click(policyFileChevron.btnContinuationOfCoverage);
		wait(6);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Con_Coverage_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Con_Coverage");
		PdfComparator.SavePdfForm(driver, FileLocation + Con_Coverage_Form);
		wait(10);
		Con_Coverage_Form_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Con_Coverage_Form, 1, 450, 720,
				100, 50);
		PdfComparator.verifyFormData(driver, Con_Coverage_Form_Version, "AIIC RI 11 14");

		Con_Coverage_Data = PdfComparator.getPDFData(FileLocation + Con_Coverage_Form);

		// Find the required text in a pdf
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "AIIC RI 11 14");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, dtf.format(cancelDate));
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data,
				"Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "underwriting reason(s) met.");
		Hooks.scenario.log("PDF form Data :  " + Con_Coverage_Data);
		
		Hooks.scenario.log("Test Case Completed!");	}
}
