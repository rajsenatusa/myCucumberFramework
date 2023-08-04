package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;

public class MTR474_DP3_ValidateMMATaskInboxView_TaskDashboard_NB_END extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endDate = currentDate.plusDays(30);
	static String applicationNumber;
	static String policyNum;
	static String workdate;
	static String temp1;
	
	@When("User takes note of the policy number for <MTR474>")
	public void user_takes_note_of_the_policy_number_for_mtr474() {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches previously created policy for <MTR474>")
	public void user_searches_previously_created_policy_for_mtr474() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(1);
	}
	@When("User takes note of the application number for <MTR474>")
	public void user_takes_note_of_the_application__number_for_mtr474() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches previously created application for <MTR474>")
	public void user_searches_previously_created_application_for_mtr474() throws Exception {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Task Tab")
	public void user_clicks_task_tab() {
		click(tasksChevron.lnkTasksTab);
		wait(4);
	}
	@When("User validates expected messages <Mandatory Mediation-Arbitration discount applied on Policy> and notates work date")
	public void user_validates_expected_messages() throws Exception {
		String temp1 = replaceMethod(policyNum, "-01", "");
		verify_AnyLabel_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy "+temp1+". Please Review and follow up for signed acknowledgment if not received.");
		String refer = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer);
		String status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status);
		String workdate = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, dtf.format(currentDate.plusDays(30)), workdate);
	}
	@When("User clicks Policy Tab")
	public void user_clicks_policy_tab() throws Exception {
		click(quote.btnQuoteAndPolicy);
		wait(2);
	}
	@When("User changes system date to the work date")
	public void user_changes_system_date_to_the_work_date() throws Exception {
		// Get the workdate using the getTaskWorkDate method
	    workdate = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");

	    // Make sure the workdate is not null or empty
	    if (workdate != null && !workdate.isEmpty()) {
	        ChangeAdminDate_NotInbox(driver, workdate);
	    } else {
	        // Handle the case when workdate is not available
	        throw new Exception("Workdate not found or invalid.");
	    }
	}
	@When("User clicks Task Dashboard")
	public void user_clicks_task_dashboard() throws Exception {
		click(driver.findElement(By.id("Menu_Policy_TaskDashboard")));
		wait(3);
	}
	@When("User completes all required information on task dashboard lookup screen")
	public void user_completes_all_required_information_on_task_dashboard() throws Exception {
		setStartDt(driver, workdate);
		setEndDt(driver, workdate);
		selectTask(driver, "Group");
		wait(3);
		clickRunReportBtn(driver);
		wait(14);
	}
	@When("User validates <Mandatory Mediation-Arbitration discount applied on Policy_> label is displayed on reports and clicks label")
	public void user_validates_label_is_displayed() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy_");
		clickOnAnyLink(driver, "Mandatory Mediation-Arbitration discount applied on Policy_");
		wait(7);
	}
	@When("User validates <Mandatory Mediation-Arbitration discount applied on Policy \"Policy No\". Please Review and follow up for signed acknowledgment if not received.> label is visible")
	public void user_validates_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy "+temp1+". Please Review and follow up for signed acknowledgment if not received.");
	}
	@When("User starts suspend transaction")
	public void user_starts_suspend_transaction() throws Exception {
		selectMultiSelectDropDown(driver, temp1, "Suspend");
		clickArrowToWorkonMultiSelectTask(driver, temp1, "Suspend");
		wait(4);
		setSuspendDt(driver, dtf.format(currentDate.plusDays(40)));
		wait(1);
		setSuspendComments(driver, "Test Suspend comments");
		clickSuspend(driver);
	}
	@When("User valiates Task Tab Referring User Status displayed as Underwriting Clerk")
	public void user_validates_task_tab_referring_user() throws Exception {
		String refer1 = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer1);
	}
	@When("User validates Task Status as open")
	public void user_validates_task_status_as_open() throws Exception {
		String status1 = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status1);
	}
	@When("User validates task date")
	public void user_validates_task_date() throws Exception {
		String workdate1 = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, dtf.format(currentDate.plusDays(40)), workdate1);
	}
	@When("User clicks generated task edit link and validates suspend label is visible")
	public void user_clicks_generated_task_edit_link() throws Exception {
		clickGeneratedTaskEditLink(driver, "Mandatory Mediation-Arbitration discount");
		wait(6);
		verify_AnyLabel_IsVisible(driver, "Suspend");
	}
}
