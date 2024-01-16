package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR392_TODP1_Validate_Direct_Bill_Policy_without_Payment_cancels_on_day_20 extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String nextDate;
	static String currentDueDate;
	static String payPlan;
	static String nextDate2;
	static String currentDueDate2;
	static String payPlan2;
	
	@When("User changes system date to current date <mtr392>")
	public void user_changes_system_date_to_current_date_mtr392() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr392>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr392() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters product selection information for TODP1 and effective date as current date minus 10 days <mtr392>")
	public void user_enters_product_selection_information_for_todp1_and_effective_date_as_current_date_minus_10_days_mtr392() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate.minusDays(10)));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);
	}
	@When("User enters all required information on TODP1 quote screen <mtr392>")
	public void user_enters_all_required_information_on_todp1_quote_screen_mtr392() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on TODP1 dwelling screen <mtr392> and sets all perils ded <$2500>, hurricane ded <%10>, fire ded <$2500>")
	public void user_enter_all_required_information_on_todp1_dwelling_screen_mtr392() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2100");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "06");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "41");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$2,500");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@When("User clicks Dwelling Chevron for <mtr392>")
	public void user_clicks_dwelling_chevron_mtr392() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User validates that TODP1 policy has been created successfully and takes note of the policy number <mtr392>")
	public void user_validates_that_todp1_policy_has_been_created_successfully_and_takes_note_of_policy_number_mtr392()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut DP1 policy has been created successfully");
		} else {
			System.out.println("TakeOut DP1 policy creation failed!");
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
	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr392>")
	public void user_clicks_make_payment_and_selects_cc_mtr392() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String currentDue = driver.findElement(By.id("AccountSummary_CurrentDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, currentDue);
		wait(4);
	}
	@When("User makes payment with Credit Card for <mtr392>")
	public void user_makes_payment_with_credit_card_mtr392() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User validates Due Date, next action date and payment plan values")
	public void user_validates_Due_Date_next_action_date_and_payment_plan_values() throws Exception {
		nextDate = getNextActionDate(driver).toString();
		
		if(nextDate.equals(dtf.format(currentDate.plusDays(20)))) {
			Hooks.scenario.log("Next Action Date displayes as expected. Current Date +20 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Next Action Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		currentDueDate=getCurrentDueDate(driver).toString();
		
		if(currentDueDate.equals(dtf.format(currentDate.plusDays(15)))) {
			Hooks.scenario.log("Current Due Date displayes as expected. Current Date +15 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Current Due Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		payPlan=getPaymentPlan(driver).toString();
		
		if(payPlan.equalsIgnoreCase("Full Payment Plan")) {
			Hooks.scenario.log("Payment Plan displayes as expected. Full Payment Plan");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Payment Plan Shows wrong value.Test Fails");
			attachScreenShot(driver);
		}
	}
	@When("User run daily jobs forward policy <mtr392>")
	public void user_run_daily_jobs_forward_policy_and_mtr392() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate);
	}
	@When("User validates Cancellation notice has been generated")
	public void user_validates_Cancellation_notice_has_been_generated() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
	}
	@When("User validates Due Date, next action date and payment plan values after cancellation notice generated")
	public void user_validates_Due_Date_next_action_date_and_payment_plan_values_after_cancellation_notice_generated() throws Exception {
		nextDate2 = getNextActionDate(driver).toString();
		
		if(nextDate2.equals(dtf.format(currentDate.plusDays(35)))) {
			Hooks.scenario.log("Next Action Date displayes as expected. Current Date +35 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Next Action Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		currentDueDate2=getCurrentDueDate(driver).toString();
		
		if(currentDueDate2.equals(dtf.format(currentDate.plusDays(15)))) {
			Hooks.scenario.log("Current Due Date displayes as expected. Current Date +15 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Current Due Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		payPlan2=getPaymentPlan(driver).toString();
		
		if(payPlan2.equalsIgnoreCase("Full Payment Plan")) {
			Hooks.scenario.log("Payment Plan displayes as expected. Full Payment Plan");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Payment Plan Shows wrong value.Test Fails");
			attachScreenShot(driver);
		}
	}
	@When("User run daily jobs to second next action date and forward policy <mtr392>")
	public void user_run_daily_jobs_to_second_next_action_date_and_forward_policy_mtr392() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate2);
	}
	@Then("User validates Cancellation has been generated and completes test")
	public void user_validates_Cancellation_has_been_generated_and_completes_test() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation");
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User searches for Policy Number for <mtr392>")
	public void user_searches_for_policy_number_for_mtr392() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
}
