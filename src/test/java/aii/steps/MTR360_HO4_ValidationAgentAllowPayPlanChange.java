package aii.steps;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MTR360_HO4_ValidationAgentAllowPayPlanChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String app_Tx_Policy_Claim_Num;
	static String policyNum;
	static String nextDate;
	static String nextDate2;
	static LocalDateTime newDate = currentDate.plusDays(35);
	static LocalDateTime newDate2 = currentDate.plusDays(15);
	static String currentDue;
	
	@When("User clicks Admin Tab")
	public void user_clicks_admin_tab() {

		click(dashboard.btnAdmin);
		wait(2);
	}

	@When("User clicks User Management Tab")
	public void user_clicks_user_management_tab() {

		click(dashboard.btnUserManagement);
		wait(2);
	}

	@When("User searches Agent <AG0376>")
	public void user_searches_agent_AG0376() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG0376");
		wait(1);
	}

	@When("User clicks Search button")
	public void user_clicks_search_button() {
		click(userLookup.btnUserSearch);
		wait(5);
	}

	@When("User scrolls to User Roles List")
	public void user_scrolls_to_user_roles_list() {
		scrollToElement(userLookup.txtUserRolesList);
		wait(2);
	}

	@When("User clicks Override Link on Policy Agent Standard")
	public void user_clicks_override_link_on_policy_agent_standard() {
		click(userLookup.lnkOverride);
		wait(3);
	}

	@When("User sets Number Days From Effective Date Allowed Pay Plan to <30> days")
	public void user_sets_number_days_from_effective_date_allowed_pay_plan_to() {
		sendText(userLookup.txtDaysAllowedPayPlan, "30");
		wait(1);
	}

	@When("User sets Number of Allowed Pay Plan to <3>")
	public void user_sets_number_of_allowed_pay_plan_to() {
		sendText(userLookup.txtNumberAllowedPayPlan, "3");
		wait(1);
	}

	@When("User verifies allow pay plan change from policy switched to Yes")
	public void user_verifies_allow_pay_plan_change_from_policy_switched_to_yes() {
		String textAllowPay = "Allow Pay Plan Change from Policy";
		String textAnswerAllowPay = "Yes";
		if (userLookup.txtAllowPayPlanChange.getText().equals(textAllowPay)
				&& userLookup.txtAllowPayPlanChangeAnswer.getText().equals(textAnswerAllowPay)) {
			System.out.println("User Role Setup is correct!");
		} else {
			System.out.println("Please fix User Setup Role!");
		}
	}

	@When("User clicks save")
	public void user_clicks_save() {
		click(userLookup.btnSave);
		waitImp(10);
	}

	@When("User enters HO4 product selection information and current day as effective date")
	public void user_enters_ho4_product_selection_information_and_current_day_as_effective_date() {
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}

	@When("User validates that HO4 policy has been created successfully and notes issued policy number")
	public void user_validates_that_ho4_policy_has_been_created_successfully_and_notes_issued_policy_number()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("HO4 NB Policy Creation has been failed!");
		}
		wait(2);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		wait(2);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches policy for <mtr360>")
	public void user_searches_policy_for_mtr360() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Billing Tab")
	public void user_clicks_billing_tab() {
		click(billingChevron.lnkBilling);
		wait(3);
	}

	@When("User gets next action date and changes system date to next action date")
	public void user_gets_next_action_date_and_changes_system_date_to_next_action_date() throws Exception {
		nextDate = getNextActionDate();
		wait(2);
		ChangeDate_Admin(driver, nextDate);
		wait(1);
	}

	@When("User gets next action date and changes system date to second next action date")
	public void user_gets_next_action_date_and_changes_system_date_to_second_next_action_date() throws Exception {
		nextDate2 = getNextActionDate();
		wait(2);
		ChangeDate_Admin(driver, nextDate2);
		wait(1);
	}

	@When("User changes Pay Plan to <8 Payment Plan>")
	public void user_changes_pay_plan_to_8() {
		click(billingChevron.lnkChangePayPlan);
		wait(4);
		click(reviewChevron.btn8PaymentPlan);
		wait(3);
		// user clicks process and do payment plan change
		click(reviewChevron.btnProcess);
		wait(4);
	}

	@When("User makes Credit Card payment")
	public void user_makes_credit_card_payment() {
		click(reviewChevron.btnMakePayment);
		wait(3);
		click(reviewChevron.btnSubmitPayment);
		wait(3);

		// user selects new credit card radio button
		click(closeoutChevron.rbNewCreditCard);
		wait(1);

		// user get current due as text and enter that amount into amount box
		currentDue = closeoutChevron.txtCurrentDue.getText().toString();
		sendText(closeoutChevron.txtEnterAmountBox, currentDue);
		wait(3);

		// user enters credit card details and complete payment
		makeCCPayment();
		closeUnnecessaryTabs();
	}

	@When("User selects endorsement date as second next action date")
	public void user_selects_endorsement_date_as_second_next_action_date() {

		sendText(dashboard.txtSelectDate, nextDate2);
		wait(2);
		click(dashboard.btnStart);
		dashboard.btnStart.click();
		wait(3);
	}

	@When("User sets payplan to Automated ACH")
	public void user_sets_payplan_to_automated_ach() {
		selectDropdownText(reviewChevron.ddPayPlan, "Automated ACH");
		wait(3);
	}

	@When("User selects ACH quarterly")
	public void user_selects_ach_quarterly() {
		click(driver.findElement(By.id("BasicPolicy.PayPlanCd_20")));
		wait(3);
	}

	@When("User enters required ACH information")
	public void user_enters_required_ach_information() {
		selectDropdownText(reviewChevron.ddBankAccountType, "Checking");
		wait(1);
		sendText(reviewChevron.txtRoutingNumber, "021000018");
		sendText(reviewChevron.txtAccountingNumber, "123456789");
		sendText(reviewChevron.txtPaymentDay, "1");
		sendText(reviewChevron.txtVerifyAccountNumber, "123456789");
		wait(2);
	}

	@When("User completes endorsement transaction")
	public void user_completes_endorsement_transaction() {
		closeoutChevron.btnEndorsePolicy.click();
		wait(3);
		click(reviewChevron.btnDialogOk);
		wait(5);
		closeUnnecessaryTabs();
	}

	@When("User changes system date <35> days forward from current date and changes system date to new date")
	public void user_changes_system_date_35_days_forward_from_current_date() throws Exception {
		wait(2);
		ChangeDate_Admin(driver, dtf.format(newDate));
		wait(2);
	}

	@When("User verifies Change Pay Plan Not Visible")
	public void user_verifies_change_pay_plan_not_visible() throws Exception {
		verifyChangePayPlanNotVisible(driver);
	}

	@When("User selects endorsement eff date as new date")
	public void user_selects_endorsement_eff_date_as_new_date() {
		String formattedNewDate = dtf.format(newDate);
		sendText(dashboard.txtSelectDate, formattedNewDate);
		wait(2);
		click(dashboard.btnStart);
		dashboard.btnStart.click();
		wait(3);
	}

	@When("User verifies pay plan type is disabled")
	public void user_verifies_pay_plan_type_is_disabled() throws Exception {
		verifyPayPlanTypeIsDisabled(driver);
	}

	@When("User changes system date <15> days forward from current date")
	public void user_changes_system_date_15_days_forward_from_current_date() throws Exception {

		wait(2);
		ChangeDate_Admin(driver, dtf.format(newDate2));
		wait(2);
	}

	@When("User clicks Change Pay Plan as Direct Bill and <4> Pay Plan")
	public void user_clicks_change_pay_plan() {
		click(billingChevron.lnkChangePayPlan);
		wait(4);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(3);
		click(reviewChevron.btn4PaymentPlan);
		wait(3);
		// user clicks process and do payment plan change
		click(reviewChevron.btnProcess);
		wait(4);
	}

	@When("User clicks process")
	public void user_clicks_process() throws Exception {
		click(reviewChevron.btnProcess);
		wait(2);
	}

	@When("User verifies Pay Plan is not visible before <30> days")
	public void user_verifies_pay_plan_is_not_visible_before_30_days() throws Exception {
		verifyChangePayPlanNotVisible(driver);
		System.out.println("Test Case Completed!");
	}
}
