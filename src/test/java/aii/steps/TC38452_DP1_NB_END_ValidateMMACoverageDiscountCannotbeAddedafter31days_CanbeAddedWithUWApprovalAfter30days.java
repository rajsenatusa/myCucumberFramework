package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC38452_DP1_NB_END_ValidateMMACoverageDiscountCannotbeAddedafter31days_CanbeAddedWithUWApprovalAfter30days extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;
	static String[] MMA = {"Yes", "No"};
	
	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy for <tc38452>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_tc38452()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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
	@And("User selects Endorsement")
	public void User_selects_Endorsement() {
		selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
		wait(1);
		click(dashboard.btnSelect);
	}
	@When("User selects endorsement date as current date plus <31> days")
	public void user_selects_endorsement_date_as_current_date_plus_31_days() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(31)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User clicks finalize transaction")
	public void user_clicks_finalize_transaction() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
	}
	@When("User clicks modify application")
	public void user_clicks_modify_application() throws Exception {
		click(closeoutChevron.btnModifyApplication);
		wait(2);
	}
	@When("User searches for the policy <tc38452>")
	public void user_searches_policy_for_tc38452() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User selects endorsement date as current date plus <30> days")
	public void user_selects_endorsement_date_as_current_date_plus_30_days() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(30)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User changes MMA as Yes")
	public void user_changes_mma_as_yes() {
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User validates 'Mediation Arbitration Change requires Underwriting Approval' message has been displayed")
	public void user_validates_mma_message_has_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Mediation Arbitration Change requires Underwriting Approval");
	}
	@When("User takes note of the application number for <tc38452>")
	public void user_takes_note_of_the_application__number_for_tc38452() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval button")
	public void user_clicks_submit_for_approval_button() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		click(closeoutChevron.btnDialogOk);
		wait(3);
	}
	@When("User searches for application number for <tc38452>")
	public void user_searches_for_application_number_for_tc38452() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks approve button")
	public void user_clicks_approve_button() {
		click(closeoutChevron.btnApprove);
		wait(5);
	}
	@When("User endorses policy and completes test case")
	public void user_endorses_policy_and_completes_test_case() {
		click(closeoutChevron.btnIssueNB);
		wait(7);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed");
	}
	@When("User clicks Dwelling Chevron for <tc38452>")
	public void user_clicks_dwelling_chevron_tc38452() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen and validates MMA dropdown includes Yes and No selections")
	public void user_enters_all_required_information_on_dp1_dwelling_screen() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		
		verifyAnyDropDownOptions(driver, MMA, "BuildingExt.MMAInd");
		
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
}
