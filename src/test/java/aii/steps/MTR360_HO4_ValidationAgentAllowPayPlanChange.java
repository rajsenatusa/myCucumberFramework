package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MTR360_HO4_ValidationAgentAllowPayPlanChange extends CommonMethods {

	@When("User clicks Admin Tab")
	public void user_clicks_admin_tab() {
		
		click(dashboard.btnAdmin);
		wait(2);
		click(dashboard.btnUserManagement);
		wait(2);
	}
	@When("User clicks User Management Tab")
	public void user_clicks_user_management_tab() {
	
		click(dashboard.btnUserManagement);
		wait(2);
	}
	@When("User searches Agent {string}")
	public void user_searches_agent(String Agent) {
		sendText(userLookup.txtUserId, Agent);
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
		String textAllowPay= "Allow Pay Plan Change from Policy";
		String textAnswerAllowPay= "Yes";
		if(userLookup.txtAllowPayPlanChange.getText().equals(textAllowPay) 
				&& userLookup.txtAllowPayPlanChangeAnswer.getText().equals(textAnswerAllowPay)) {
			System.out.println("User Role Setup is correct!");
		} else {
			System.out.println("Please fix User Setup Role!");
		}
	}
	@When("User clicks save")
	public void user_clicks_save() {
		click(userLookup.btnSave);
		wait(1);
	}
	@When("User enters HO4 product selection information and current day as effective date")
	public void user_enters_ho4_product_selection_information_and_current_day_as_effective_date() {
		// product selection information was filled here
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
		LocalDateTime currentDate = LocalDateTime.now();
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}
	@When("User validates that HO4 policy has been created successfully and notes issued policy number and searches policy")
	public void user_validates_that_ho4_policy_has_been_created_successfully_and_notes_issued_policy_number_and_searches_policy() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("HO4 NB Policy Creation has been failed!");
		}
		String policyNum=historyChevron.txtPolicyNo.toString();
		Hooks.scenario.log(policyNum);
		PdfComparator.switchWindows(driver);
		
		//searching policy
		wait(1);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(1);
	}
	@When("User clicks Billing Tab")
	public void user_clicks_billing_tab() {
		click(billingChevron.lnkBilling);
		wait(3);
	}
	@When("User gets next action date and changes system date to next action date")
	public void user_gets_next_action_date_and_changes_system_date_to_next_action_date() throws Exception {
		String nextDate=getNextActionDate();
		wait(5);
		changeDateToDesiredEffDate(nextDate);
		wait(3);
	}
	@When("User searches policy")
	public void user_searches_policy() {
		String policyNum=historyChevron.txtPolicyNo.toString();
		Hooks.scenario.log(policyNum);
	}
	
}
