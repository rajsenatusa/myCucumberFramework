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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR398_SC_HO3_Verify_the_SC_HO3_NB_Policy_is_cancelled_Transaction_and_reinstate_after_cancellation extends CommonMethods{

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
	static String CC_Page5;
	
	@When("User enters all required information on SC policy information screen <mtr398>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr398() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "7743 Park Gate Dr, North Charleston");
		sendText(quote.txtZipCode, "29418");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on SC HO3 quote screen <mtr398>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr398() {
		// Quote Policy Chevron information was filled here

		sendText(policyChevron.txtProducerCodeSel, "AG1777A1");
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, "Amica");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on SC HO3 dwelling screen <mtr398>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr398() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "2000");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3-tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
		selectDropdownText(dwellingChevron.ddFireAlarm, "None");
		selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@Given("User issues policy and makes payment with credit card")
	public void user_issues_policy_and_makes_payment_with_credit_card() {

		selectDropdownText(closeoutChevron.ddPaymentType, "Credit Card");
		wait(2);
		
		//makeCCPayment();
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		wait(2);
		
		click(closeoutChevron.btnIssueNB);
		wait(15);
	}
	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr398>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr398() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
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
	@When("User searches for the policy number <mtr398>")
	public void user_searches_policy_for_mtr398() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects Other in risk as reason <mtr398>")
	public void User_selects_other_as_reason_mtr398() {
		selectDropdownText(historyChevron.ddReason, "Other");
		wait(2);
		sendText(driver.findElement(By.id("TransactionLongDescription")), "testcommenttest");
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User selects effective date as cancel date 'current date plus 30 days' <mtr398>")
	public void User_selects_effective_date_as_cancel_date_current_date_plus_30_days_mtr398() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
	}
	@And("User selects pro rate as cancel type and process transaction <mtr398>")
	public void User_selects_pro_rate_mtr398() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User selects Reinstatement")
	public void User_selects_Reinstatement() {
		selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
		wait(1);
		click(dashboard.btnSelect);
		wait(2);
		click(dashboard.btnStart);
	}
	@When("User clicks Policy File Chevron <mtr398>")
	public void user_clicks_policy_file_chevron_mtr398() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User completes and process reinstatement transaction")
	public void User_completes_and_process_reinstatement_transaction() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Policy Reinstatement Completed!");
		attachScreenShot(driver);
	}
	@When("User validates <AIIC RI 11 14> form is visible on <mtr398>")
	public void user_validates_AIIC_RI_11_14_form_is_visible_on_mtr398() throws Exception {
		verify_AnyText_IsVisible(driver, "REINNOTICE");
	}
	@And("User clicks Rein Notice Form and validates form details as expected")
	public void user_clicks_Rein_Notice_form_and_validates_form_details_as_expected() throws Exception {
		click(formsChevron.btnReinNotice);
		wait(8);
		switchToWindow(driver, "STFile&File");
		REINForm = PdfComparator.makePdf(driver, "ReinForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + REINForm);
		wait(10);
		ReinForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + REINForm, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ReinForm_Version, "AIIC RI 11 14");
		ReinForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + REINForm, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ReinForm_Name, "REINSTATEMENT NOTICE");
	}
	@Then("User clicks Continuation of Coverage link and validates AIIC RI 11 14 form version listed in the package <mtr398>")
	public void user_clicks_continuation_of_coverage_Link_and_validates_AIIC_RI_11_14_form_version_listed_in_the_package_mtr398()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Continuation of Coverage");
		wait(7);
		switchToWindow(driver, "STFile&File");

		Continue_Cov_Form = PdfComparator.makePdf(driver, "CCForm.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Continue_Cov_Form);
		wait(10);

		// Declaration page Forms
		CC_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page, "AIIC RI 11 14");
		CC_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page2, "REINSTATEMENT NOTICE");
		CC_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page3, "7743 Park Gate DR, North Charleston, SC 29418-3807");
		CC_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page4, "Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since");
		CC_Page5 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Continue_Cov_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Page5, "underwriting reason(s) met.");
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
