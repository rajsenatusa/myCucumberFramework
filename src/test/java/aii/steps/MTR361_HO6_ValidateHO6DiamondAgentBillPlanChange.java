package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR361_HO6_ValidateHO6DiamondAgentBillPlanChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	String preAutoDt;
	String RenewalTerm02;
	String PolicyNumberTerm02;
	String temp1;
	String autoRenewDt;
	String nextDate;
	String nextDate2;
	String nextDate3;
	String nextDate4;
	String nextDate5;
	String nextDate6;
	String nextDate7;
	String nextDate8;
	String nextDate9;
	String nextDate10;

	@When("User enters all required information on HO6 review screen and selects <8> payment plan")
	public void user_enter_all_required_information_on_ho6_review_screen_and_selects_8_payment_plan() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btn8PaymentPlan);
		wait(3);
	}
	@When("User enters all required information on policy information screen <tc16846>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16846() {

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
	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc16846>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc16846() {

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
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User adds additional interests for first mortgagee")
	public void user_adds_additional_interests_for_first_mortgagee() {

		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10002");
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(4);
		sendText(additionalinterest.txtLoanNumber, "1234");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and complete credit card payment and issues policy")
	public void user_finalizes_transaction_and_complete_credit_card_payment() {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
		selectDropdownText(closeoutChevron.ddPaymentType, "Credit Card");
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
		wait(10);

		// Close unnecessary tabs
		closeUnnecessaryTabs();

	}

	@When("User takes note of the policy number for <tc16846>")
	public void user_takes_note_of_the_policy_number_for_tc18646() throws Exception {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for Policy Number for <tc16846>")
	public void user_searches_for_policy_number_for_tc16846() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Billing Chevron")
	public void user_clicks_billing_chevron() throws Exception {
		click(driver.findElement(By.id("Tab_Billing")));
		wait(3);
		attachScreenShot(driver);
	}

	@When("User takes note of the next action date and run daily jobs")
	public void user_takes_note_of_the_next_action_date_and_run_daily_jobs() throws Exception {

		nextDate = getNextActionDate(driver).toString();
		policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		runDailyJobOnDate(driver, policyNum, nextDate);
	}

	@When("User takes note of the second next action date and changes system date to second next action date")
	public void user_takes_note_of_the__second_next_action_date_changes_system_date() throws Exception {

		nextDate2 = getNextActionDate(driver).toString();
		ChangeDate_Admin(driver, nextDate2);
		wait(3);
	}

	@When("User searches policy and changes payment plan as quarterly and clicks process")
	public void user_searches_policy_and_changes_payment_plan_as_quarterly() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
		click(driver.findElement(By.id("Tab_Billing")));
		wait(3);
		click(billingChevron.lnkChangePayPlan);
		wait(1);
		click(reviewChevron.btnQuarterlyPayPlan);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(2);
	}

	@When("User takes note of the third next action date")
	public void user_takes_note_of_the_third_next_action_date() throws Exception {
		nextDate3 = getNextActionDate(driver).toString();
		wait(3);
	}

	@When("User runs daily jobs on third next action date")
	public void user_runs_daily_jobs_on_third() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate3);
	}

	@When("User takes note of the fourth next action date")
	public void user_takes_note_of_the_fourth_next_action_date() throws Exception {
		nextDate4 = getNextActionDate(driver).toString();
		wait(3);
	}

	@When("User changes system date to fourth next action date")
	public void user_changes_system_date_fourth_next_action_date() throws Exception {
		ChangeDate_Admin(driver, nextDate4);
	}

	@When("User searches policy and changes payment plan as Mortgagee Bill and clicks process")
	public void user_searches_policy_and_changes_payment_plan_as_mortgagee() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
		click(driver.findElement(By.id("Tab_Billing")));
		wait(3);
		click(billingChevron.lnkChangePayPlan);
		wait(1);
		selectDropdownText(closeoutChevron.ddPlayPlanType, "Mortgagee Bill");
		wait(3);
		click(reviewChevron.btnMortgageeFullPay);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(2);
	}

	@When("User takes note of the fifth next action date and run daily jobs")
	public void user_takes_note_of_the_fifth_next_action_date_and_run_daily_jobs() throws Exception {

		nextDate5 = getNextActionDate(driver).toString();
		runDailyJobOnDate(driver, policyNum, nextDate5);
	}

	@When("User takes note of the sixth next action date")
	public void user_takes_note_of_the_sixth_next_action_date() throws Exception {
		nextDate6 = getNextActionDate(driver).toString();
		wait(3);
	}

	@When("User changes system date to sixth next action date")
	public void user_changes_system_date_sixth_next_action_date() throws Exception {
		ChangeDate_Admin(driver, nextDate6);
	}

	@When("User changes pay plan as automated credit card and clicks process")
	public void user_changes_pay_plan_as_automated_card() throws Exception {

		click(billingChevron.lnkChangePayPlan);
		wait(1);
		selectDropdownText(closeoutChevron.ddPlayPlanType, "Automated Credit Card");
		wait(3);
		click(reviewChevron.btn8ccPaymentPlan);
		wait(3);
		sendText(driver.findElement(By.id("BasicPolicy.PaymentDay")), "12");
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
		click(reviewChevron.btnProcess);
		wait(2);
	}

	@When("User takes note of the seventh next action date and run daily jobs")
	public void user_takes_note_of_the_seventh_next_action_date_and_run_daily_jobs() throws Exception {

		nextDate7 = getNextActionDate(driver).toString();
		runDailyJobOnDate(driver, policyNum, nextDate7);
	}

	@When("User takes note of the eigth next action date and run daily jobs")
	public void user_takes_note_of_the_eigth_next_action_date_and_run_daily_jobs() throws Exception {

		nextDate8 = getNextActionDate(driver).toString();
		runDailyJobOnDate(driver, policyNum, nextDate8);
	}

	@When("User takes note of the nineth next action date and run daily jobs")
	public void user_takes_note_of_the_nineth_next_action_date_and_run_daily_jobs() throws Exception {

		nextDate9 = getNextActionDate(driver).toString();
		runDailyJobOnDate(driver, policyNum, nextDate9);
	}

	@When("User takes note of the tenth next action date and changes system date to tenth next action date")
	public void user_takes_note_of_the_tenth_next_action_date_changes_system_date() throws Exception {

		nextDate10 = getNextActionDate(driver).toString();
		ChangeDate_Admin(driver, nextDate10);
		wait(3);
	}

	@When("User selects endorsement date as tenth next action date")
	public void user_selects_endorsement_date_as_tenth_next_action_date() {
		sendText(dashboard.txtSelectDate, nextDate10);
		wait(2);
		click(dashboard.btnStart);
		wait(2);
		click(dashboard.btnStart);
		wait(2);
	}

	@When("User clicks Review Chevron select Direct Full Payment and completes endorsement")
	public void user_clicks_review_chevron_select_full() {

		click(reviewChevron.btnReview);
		wait(2);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(3);
	}

	@When("User clicks Show All and checks show system task and take note preautorenew and autorenew dates")
	public void user_clicks_show_all_and_checks_show_system_task_and_take_note_dates() throws Exception {
		click(tasksChevron.btnShowAll);
		checkShowSysTask(driver);
		preAutoDt = getPreAutoRenewDate(driver).toString();
		autoRenewDt = getAutoRenewDate(driver).toString();
	}

	@When("User does auto renewal on policy")
	public void user_does_auto_renewal_on_policy() throws Exception {
		runAutoRenewalOnSinglePolicy(driver, policyNum, preAutoDt, autoRenewDt);
		temp1 = replaceMethod(policyNum, "-01", "");
		RenewalTerm02 = temp1 + "-02";
		Thread.sleep(12000);
		click(driver.findElement(By.id("Menu_Workflow")));
		PolicyNumberTerm02 = RenewalTerm02;
		Thread.sleep(12000);

		setPolicyNumSearch(driver, PolicyNumberTerm02);
		clickSearchBtn(driver);
		Thread.sleep(500);
	}

	@Then("User changes system date as autoRenew date and changes pay plan as <8 Pay Plan>")
	public void user_changes_system_date_as_autoRenew_date_and_changes_pay() throws Exception {
		ChangeDate_Admin(driver, autoRenewDt);
		wait(3);
		setPolicyNumSearch(driver, RenewalTerm02);
		wait(3);
		clickSearchBtn(driver);
		wait(2);
		click(driver.findElement(By.id("Tab_Billing")));
		wait(3);
		click(billingChevron.lnkChangePayPlan);
		wait(3);
		selectDropdownText(closeoutChevron.ddPlayPlanType, "Direct Bill");
		wait(1);
		click(driver.findElement(By.id("BasicPolicy.PayPlanCd_10")));
		wait(3);
		click(reviewChevron.btnProcess);
		wait(2);
		Hooks.scenario.log("Test Case Completed");
	}

	@When("User clicks Make Payment for <tc16846> and selects credit card and enters due amount")
	public void user_clicks_make_payment_for_tc16846() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_4")));
		wait(2);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
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
		click(driver.findElement(By.id("dialogOK")));
		wait(4);

		// Close unnecessary tabs
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
	}
}
