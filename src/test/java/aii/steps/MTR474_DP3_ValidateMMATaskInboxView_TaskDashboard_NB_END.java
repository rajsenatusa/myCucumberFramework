package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR474_DP3_ValidateMMATaskInboxView_TaskDashboard_NB_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endDate = currentDate.plusDays(30);
	static String applicationNumber;
	static String policyNum;
	static String workdate;
	static String temp1;
	static String refer;
	static String status;
	static String refer1;
	static String status1;
	static String workdate1;

	@When("User takes note of the policy number for <MTR474>")
	public void user_takes_note_of_the_policy_number_for_mtr474() {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters all required information on policy information screen <mtr474>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr474() {

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
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr474>")
	public void user_enters_all_current_date_as_prior_date_mtr474() throws Exception {
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
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP3 dwelling screen <mtr474>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr474() {

		//sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCovALimit, "400000");
		sendText(dwellingChevron.txtPersonalPropertyC, "12000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User completes endorsement <mtr474>")
	public void user_completes_endorsement_mtr474() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
	}
	@When("User selects endorsement date as current date <mtr474>")
	public void user_selects_endorsement_date_as_current_date_mtr474() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
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
		temp1 = replaceMethod(policyNum, "-01", "");
		verify_AnyLabel_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp1
				+ ". Please Review and follow up for signed acknowledgment if not received.");
		refer = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer);
		status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status);
		workdate = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, dtf.format(currentDate.plusDays(15)), workdate);
	}

	@When("User clicks Policy Tab")
	public void user_clicks_policy_tab() throws Exception {
		click(quote.btnQuoteAndPolicy);
		wait(2);
	}

	@When("User changes system date to the work date")
	public void user_changes_system_date_to_the_work_date() throws Exception {

		ChangeAdminDate_NotInbox(driver, workdate);
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
		verify_AnyLabel_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp1
				+ ". Please Review and follow up for signed acknowledgment if not received.");
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
		refer1 = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer1);
	}

	@When("User validates Task Status as open")
	public void user_validates_task_status_as_open() throws Exception {
		status1 = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status1);
	}

	@When("User validates task date")
	public void user_validates_task_date() throws Exception {
		workdate1 = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, dtf.format(currentDate.plusDays(40)), workdate1);
	}

	@When("User clicks generated task edit link and validates suspend label is visible")
	public void user_clicks_generated_task_edit_link() throws Exception {
		clickGeneratedTaskEditLink(driver, "Mandatory Mediation-Arbitration discount");
		wait(6);
		verify_AnyLabel_IsVisible(driver, "Suspend");
	}
}
