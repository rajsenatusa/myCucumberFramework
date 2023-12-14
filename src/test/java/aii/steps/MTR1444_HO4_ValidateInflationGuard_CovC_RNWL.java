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

public class MTR1444_HO4_ValidateInflationGuard_CovC_RNWL extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String totalDue;
	static String Cov_C_InfaltionValue;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String RwlDec_Form;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	
	@When("User enters all required information on policy information screen <mtr1444>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1444() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11256 SW 62nd Avenue");
		sendText(quote.txtZipCode, "34476");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO4 quote screen <mtr1444>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr1444() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		//sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information and sets Coverage C as '210000'on HO4 dwelling screen <mtr1444>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr1444() {

//		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
//		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "210000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@And("User checks application dwelling screen and finalizes transaction <mtr1444>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_mtr1444() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryOfUnit, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@And("User validates that HO4 policy has been created successfully and takes note of the policy number <mtr1444>")
	public void user_validates_that_ho4_policy_has_been_created_successfully_mtr1444() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO4 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Make Payment and selects credit card and enters due amount <mtr1444>")
	public void user_clicks_make_payment_and_selects_cc_mtr1444() {
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
	@When("User makes payment with Credit Card <mtr1444>")
	public void user_makes_payment_with_credit_card_mtr1444() {
		makeCCPayment();
		wait(5);
		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User does auto renewal through batch jobs <mtr1444>")
	public void user_does_auto_renewal_through_batch_jobs_mtr1444() throws Exception {
		runAutoRenewPolicy(driver, policyNum, "01", "02");
	}
	@When("User clicks Dwelling Chevron <mtr1444>")
	public void user_clicks_dwelling_chevron_mtr1444() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User validates Inflation Guard Label is visible and expected value <231.000> displayed")
	public void user_validates_Inflation_Guard_Label_is_visible_and_expected_value_231000_displayed() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Inflation Guard");
		Cov_C_InfaltionValue = getTextOfElement(driver, "Building.CovCLimit_text");
		expectedValue_foundValue(driver, "$231,000", Cov_C_InfaltionValue);	
	}
	@When("User clicks Policy File Chevron <mtr1444>")
	public void user_clicks_policy_file_chevron_mtr1444() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User clicks Renewal Declaration and validates form version and completes test <mtr1444>")
	public void user_clicks_Renewal_Declaration_and_validates_form_version_and_completes_test_mtr1444() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+RwlDec_Form);
		wait(15);
		
		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm, "Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm, "industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		
		//Checklist of Coverage form
		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 7, 0, 400, 600, 500);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_C_InfaltionValue);
		Hooks.scenario.log("Test Case Completed!");
	}
}
