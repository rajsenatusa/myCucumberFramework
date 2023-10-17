package aii.steps;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class TC17036_HO6_UW_ValidateUWCanCreateManualTaskonPolicy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	String policyNum;
	String correspndenceTask;
	String genReminderTask;
	String genTask;
	String latePayment;
	String manualAction;
	String pendingApply;
	String pendingRenewal;
	
	@When("User enters HO6 product selection information and current date as effective date")
	public void user_enters_ho6_product_selection_information_and_effective_date_as_current_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}
	@When("User enters all required information on HO6 quote screen with current date as prior policy date")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date() {
	   
		//Quote Policy Chevron information was filled here
		
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate,dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on HO6 dwelling screen and enters <35.000> for CovC")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_Cov_c() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User adds 'Correspondence from Insured' Task")
	public void user_adds_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "Correspondence from Insured");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		correspndenceTask = getScheduledTaskDescription(driver,"New correspondence").toString();
		getTaskReferrringUserStatus(driver,"New correspondence").toString();
		Hooks.scenario.log(correspndenceTask);
	}
	@When("User adds 'General Reminder' Task")
	public void user_adds_general_reminder() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "General Reminder");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		genReminderTask = getScheduledTaskDescription(driver,"General Reminder").toString();
		getTaskReferrringUserStatus(driver,"General Reminder").toString();
		Hooks.scenario.log(genReminderTask);
	}
	@When("User adds 'General' Task")
	public void user_adds_general_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "General Task");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		genTask = getScheduledTaskDescription(driver,"General Task").toString();
		getTaskReferrringUserStatus(driver,"General Task").toString();	
		Hooks.scenario.log(genTask);
	}
	@When("User adds 'Late Payment Received on Cancelled Policy' Task")
	public void user_adds_late_payment_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "Late Payment Received on Cancelled Policy");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		latePayment = getScheduledTaskDescription(driver,"Late Payment Received on Cancelled Policy").toString();
		getTaskReferrringUserStatus(driver,"Late Payment Received on Cancelled Policy").toString();	
		Hooks.scenario.log(latePayment);
	}
	@When("User adds 'Manual Action Required' Task")
	public void user_adds_manual_action_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "Manual Action Required");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		manualAction = getScheduledTaskDescription(driver,"Automated task failed").toString();
		getTaskReferrringUserStatus(driver,"Automated task failed").toString();
		Hooks.scenario.log(manualAction);
	}
	@When("User adds 'Pending Reapply Notification' Task")
	public void user_adds_pending_notification_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "Pending Reapply Notification");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		pendingApply = getScheduledTaskDescription(driver,"Pending Reapply Notification").toString();
		getTaskReferrringUserStatus(driver,"Pending Reapply Notification").toString();
		Hooks.scenario.log(pendingApply);
	}
	@When("User adds 'Pending Renewal Apply Notification' Task")
	public void user_adds_pending_renewal_task() throws Exception {
		
		click(tasksChevron.btnAddTask);
		wait(3);
		selectDropdownText(tasksChevron.ddTaskType, "Pending Renewal Apply Notification");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		pendingRenewal = getScheduledTaskDescription(driver,"Pending Renewal Apply Notification").toString();
		getTaskReferrringUserStatus(driver,"Pending Renewal Apply Notification").toString();	
		Hooks.scenario.log(pendingRenewal);
	}
	@When("User navigates to Home Tab and Inbox")
	public void user_navigates_to_home_tab_and_inbox() {
		click(dashboard.btnHome);
		wait(3);
		click(dashboard.btnInbox);
		wait(3);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(355));
	}
	@When("User validates 'Correspondence from Insured' Task and 'Manual Action Required' Task and 'Pending Reapply Notification' Task and 'Pending Renewal Apply Notification' Task is visible on Tasks Tab")
	public void user_validates_tasks_are_visible_for_senior_underwriter() throws Exception {
		wait(5);
		click(driver.findElement(By.id("InboxSelectionSearch")));
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, correspndenceTask, "1");
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, manualAction, "1");
		wait(5);
		click(driver.findElement(By.id("InboxSelectionSearch")));
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, pendingApply, "1");
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, pendingRenewal, "1");
		wait(5);
	}
	@When("User login to Spin as Billing Underwriter Role")
	public void user_login_to_spin_as_billing_underwriter() {
		sendText(login.username, ConfigsReader.getProperty("billinguw"));
		sendText(login.password, ConfigsReader.getProperty("billinguwpassword"));
		click(login.btnSignIn);
		wait(3);
	}
	@When("User validates 'Late Payment Received on Cancelled Policy' Task is visible on Inbox")
	public void user_validates_late_payment_task_is_visible() throws Exception {
		wait(5);
		click(driver.findElement(By.id("InboxSelectionSearch")));
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, latePayment, "1");
		wait(5);
	}
	@When("User validates 'General Reminder' Task and 'General' Task is visible on Inbox")
	public void user_validates_general_tasks_are_visible() throws Exception {
		wait(5);
		click(driver.findElement(By.id("InboxSelectionSearch")));
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, genReminderTask, "1");
		wait(5);
		verify_AnyText_IsVisibleMultipletimes(driver, genTask, "1");
	}
}
