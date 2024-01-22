package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR389_MHO3_Verify_MHO_NonPay_Cancellation_Reinstatements_Payment_Plan_Full_Pay_Plan_Reinstatement_on_Payment extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String nextDate;
	static String nextDate2;
	static String minAmountReinstate;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CC_Form;
	static String CC_Version;
	static String CC_Name;
	
	@When("User changes system date to current date <mtr389>")
	public void user_changes_system_date_to_current_date_mtr389() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen and enters mobile park address <mtr389>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_mtr389() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "36323 Arbor Oaks Dr");
		sendText(quote.txtZipCode, "33541");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type <mtr389>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_mtr389()
			throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnParkPropertyType);
		wait(1);
		clickMagnifierIcon(driver, "2");
		wait(2);
		switchToWindow(driver, "ParkSearchPage");
		wait(2);
		selectDropdownText(policyChevron.ddSearchPark, "Park Name");
		wait(1);
		sendText(policyChevron.txtParkName, "American Condominium Park");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "American Condominium Park");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "American Condominium Park");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on MHO3 dwelling screen and sets covA as <65000>, ded.perils as <2500>, ded.hurricane as <%10> <mtr389>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_65000_mtr389() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "65000");
		wait(2);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr389>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr389() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
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
	@When("User searches for Policy Number for <mtr389>")
	public void user_searches_for_policy_number_for_mtr389() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User gets next action date and forward policy to next action date <mtr389>")
	public void user_gets_next_action_date_and_forward_policy_to_next_action_date_mtr389() throws Exception {
		nextDate = getNextActionDate(driver).toString();
		attachScreenShot(driver);
		runDailyJobOnDate(driver, policyNum, nextDate);	
	}
	@When("User gets second next action date and forward policy to next action date <mtr389>")
	public void user_gets_second_next_action_date_and_forward_policy_to_next_action_date_mtr389() throws Exception {
		nextDate2 = getNextActionDate(driver).toString();
		attachScreenShot(driver);
		runDailyJobOnDate(driver, policyNum, nextDate2);	
	}
	@When("User validates Cancellation notice has been generated <mtr389>")
	public void user_validates_Cancellation_notice_has_been_generated_mtr389() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
	}
	
	@And("User validates Reinstatement has been generated <mtr389>")
	public void user_validates_Reinstatement_has_been_generated_mtr389() throws Exception {
		verify_AnyText_IsVisible(driver, "Reinstatement");
	}
	@And("User takes note of the minimum amount to reinstate")
	public void user_takes_note_of_the_minimum_amount_to_reinstate() throws Exception {
		minAmountReinstate=getMinimumAmountReinstate(driver);
	}
	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr389>")
	public void user_clicks_make_payment_and_selects_cc_mtr389() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		sendText(closeoutChevron.txtEnterAmountBox, minAmountReinstate);
		wait(4);
	}
	@When("User makes payment with Credit Card for <mtr389>")
	public void user_makes_payment_with_credit_card_mtr389() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User clicks Policy File Chevron <mtr389>")
	public void user_clicks_policy_file_chevron_mtr389() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User clicks Continuation of Coverage Link and validates form version and completes test <mtr389>")
	public void user_switches_that_forms_and_validates() throws Exception {

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
