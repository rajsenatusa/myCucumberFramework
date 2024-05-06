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

public class MTR400_HO3_Verify_cancel_and_reinstatement_using_batch extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String nextDate;
	static String nextDate2;
	static String nextDate3;
	static String minAmountReinstate;
	static String CC_Form;
	static String CC_Version;
	static String CC_Name;
	
	@When("User enters all required information on policy information screen <mtr400>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr400() {

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
	@When("User changes system date to current date <mtr400>")
	public void user_changes_system_date_to_current_date_mtr400() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on HO3 quote screen <mtr400>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr400() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen <mtr400>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr400() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2024");
//		selectDropdownText(dwellingChevron.bCEG, "3");
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
	@When("User completes required information on dwelling chevron <mtr400>")
	public void user_completes_required_information_on_dwelling_chevron_mtr400() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr400>")
	public void User_clicks_Finalize_button_mtr400() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr400>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr400()
			throws Exception {

		wait(5);
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
	@When("User searches for the policy number <mtr400>")
	public void user_searches_policy_for_mtr400() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User takes note of the next action date and run daily jobs <mtr400>")
	public void user_takes_note_of_the_next_action_date_and_run_daily_jobs_mtr400() throws Exception {

		nextDate = getNextActionDate(driver).toString();
		policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		runDailyJobOnDate(driver, policyNum, nextDate);
	}

	@When("User takes note of the second next action date and changes system date to second next action date and run daily jobs <mtr400>")
	public void user_takes_note_of_the__second_next_action_date_changes_system_date_and_run_daily_jobs_mtr400()
			throws Exception {

		nextDate2 = getNextActionDate(driver).toString();
		runDailyJobOnDate(driver, policyNum, nextDate2);
		wait(3);
	}

	@When("User validates Cancellation notice has been generated <mtr400>")
	public void user_validates_Cancellation_notice_has_been_generated_mtr400() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
	}

	@When("User validates Cancellation has been generated <mtr400>")
	public void user_validates_Cancellation__has_been_generated_mtr400() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation");
	}

	@And("User takes note of the minimum amount to reinstate <mtr400>")
	public void user_takes_note_of_the_minimum_amount_to_reinstate_mtr400() throws Exception {
		minAmountReinstate = getMinimumAmountReinstate(driver);
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr400>")
	public void user_clicks_make_payment_and_selects_cc_mtr400() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		sendText(closeoutChevron.txtEnterAmountBox, minAmountReinstate);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr400>")
	public void user_makes_payment_with_credit_card_mtr400() {
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
		click(driver.findElement(By.id("SubmitPayment")));
		wait(1);
		acceptAlert();
		click(driver.findElement(By.id("dialogOK")));
		wait(1);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User forward policy to second next action date <mtr400>")
	public void user_forward_policy_to_second_next_action_date_mtr400() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate2);
	}

	@And("User validates Reinstatement has been generated <mtr400>")
	public void user_validates_Reinstatement_has_been_generated_mtr400() throws Exception {
		verify_AnyText_IsVisible(driver, "Reinstatement");
	}

	@When("User clicks Policy File Chevron <mtr400>")
	public void user_clicks_policy_file_chevron_mtr400() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User clicks Continuation of Coverage Link and validates form version and completes test <mtr400>")
	public void user_switches_that_forms_and_validates_mtr400() throws Exception {

		clickOnAnyLink(driver, "Continuation of Coverage");
		wait(3);
		switchToWindow(driver, "STFile&File");
		wait(3);
		CC_Form = PdfComparator.makePdf(driver, "ContinuationOfCoverage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CC_Form);
		wait(12);

		CC_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CC_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Version, "AIIC RI 11 14");
		CC_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CC_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CC_Name, "REINSTATEMENT NOTICE");

		Hooks.scenario.log("Test Case Completed!");
	}
}