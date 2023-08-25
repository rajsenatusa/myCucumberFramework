package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;

public class MTR253_DP1_ValidateClaimCanbeReportedByInsuredContractor extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String claimNum;
	static String lossNum;

	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number()
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
	@When("User changes system date to current date plus <60> days")
	public void user_changes_system_date_current_date_plus_60_days() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate.plusDays(60)));
		wait(1);
	}
	@When("User searches for the policy <mtr253>")
	public void user_searches_policy_for_mtr253() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Report Loss")
	public void user_clicks_report_loss() {
		click(dashboard.btnReportLoss);
		click(dashboard.btnReport);
		wait(2);
	}
	@When("User sets loss date as current date plus <60> days")
	public void user_sets_loss_date_as_current_date_plus_60_days() {
		sendText(claim.txtLossDate, dtf.format(currentDate.plusDays(60)));
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User validates reported by dropdown options is visible")
	public void user_validates_reported_by_dd_options_visible() throws Exception {
		String[] reportedBy = {"Insured", "Insured/Contractor", "Agent", "Public Adjuster", "Attorney", "Other"};
		verifyAnyDropDownOptions(driver, reportedBy, "Claim.ReportedBy");
	}
	@When("User selects reported by as Insured Contractor")
	public void user_selects_reported_by_as_insured_contractor() throws Exception {
		selectDropdownText(claim.ddClaimReportedBy, "Insured/Contractor");
		wait(1);
	}
	@When("User validates Contractor Name Label is visible")
	public void user_validates_contractor_name_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Contractor Name*");
	}
	@When("User selects loss cause and clicks Save")
	public void user_selects_loss_cause_and_clicks_save() throws Exception {
		selectDropdownText(claim.ddLossCause, "Lightning");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User completes all required information on claim chevron")
	public void user_completes_all_reqiured_information_on_claim_chevron() throws Exception {
		sendText(claim.txtContractorName, "Mario Bros");
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Contractor Claim verification");
	}
	@When("User changes reported by as Agent and validates Contractor Name text is not visible anymore")
	public void user_changes_reported_by_as_agent_and() throws Exception {
		selectDropdownText(claim.ddClaimReportedBy, "Agent");
		wait(1);
		verify_AnyText_NotVisible(driver, "Contractor Name*");
	}
	@When("User selects Insured Contractor as reported by and validates Contractor Name label is visible")
	public void user_selects_insured_contractor_and_validates_contractor_name_label_is_visible() throws Exception {
		selectDropdownText(claim.ddClaimReportedBy, "Insured/Contractor");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Contractor Name*");
	}
	@When("User clicks Save and validates <Missing Required Information> message has been displayed")
	public void user_clicks_save_and_validates_error_message() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Missing Required Information");
	}
	@When("User changes reported by as Attorney and validates Contractor Name text is not visible anymore")
	public void user_changes_reported_by_as_attorney_and() throws Exception {
		selectDropdownText(claim.ddClaimReportedBy, "Attorney");
		wait(1);
		verify_AnyText_NotVisible(driver, "Contractor Name*");
	}
	@When("User clicks save and takes note of the loss number")
	public void user_clicks_save_and_takes_note_of_the_loss_number() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Complete and takes note of the claim number")
	public void user_clicks_complete_takes_notes() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User changes system date to current date plus <90> days")
	public void user_changes_system_date_current_date_plus_90_days() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate.plusDays(90)));
		wait(1);
	}
	@When("User searches claim number for <mtr253>")
	public void user_searches_for_claim_number_mtr253() {
		sendText(dashboard.txtSearchBar, claimNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks start transaction")
	public void user_clicks_start_transaction() throws Exception {
		startTransaction(driver);
		wait(4);
	}
	@When("User clicks Summary Chevron")
	public void user_clicks_summary_chevron() throws Exception {
		clickSummaryChevron(driver);
		wait(1);
	}
	@When("User sets contractor name and clicks save and finalizes transaction")
	public void user_sets_contractor_name_and_clicks_save_and_finalizes_transaction() throws Exception {
		sendText(claim.txtContractorName, "Mario Bros");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnFinalize);
		wait(2);
		click(claim.btnProcess);
		wait(3);
		Hooks.scenario.log("Test Case Completed!");
	}
}
