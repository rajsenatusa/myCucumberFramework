package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4464_UMB_UMBAgentChangeDateTransaction extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String UMBpolicyNum;
	static String AppNum;

	@Then("User validates that HO4 policy has been created successfully and takes note of the policy number <tc16804>")
	public void user_validates_that_ho4_policy_has_been_created_successfully_tc16804() throws Exception {
		wait(3);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("Policy Creation failed!");
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

	@When("User searches for the policy number <tc16804>")
	public void user_searches_policy_for_tc16804() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User enters producer code and answers previous policy written with AIIG questions <tc16804>")
	public void user_answers_previous_policy_written_with_aiig_questions_tc16804() {
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(2);
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "No");
		click(policyChevron.btnNext);
		wait(2);
	}

	@When("User enters all required information on UMB personal liability screen <tc16804>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_tc16804() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, "1,000,000");
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, "0");
		sendText(umbrellaChevron.txtNumberOfAuto, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(umbrellaChevron.ddLiabilityResidenceAtLeast500k, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User adds underlying policy in personal liability chevron <tc16804>")
	public void user_adds_underlying_policy_in_personal_liability_chevron_tc16804() {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Property and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, policyNum);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(umbrellaChevron.ddSelectPolicyWithAI, "Yes");
		wait(1);
		selectDropdownText(umbrellaChevron.ddSetExposureType, "Primary Residence");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User validates that UMB policy has been created successfully and takes note of the policy number <tc16804>")
	public void user_validates_that_umb_policy_has_been_created_successfully_tc16804() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			UMBpolicyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + UMBpolicyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the umbrella policy number <tc16804>")
	public void user_searches_umbrella_policy_for_tc16804() {
		sendText(dashboard.txtSearchBar, UMBpolicyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects current date plus 61 days as new effective date <tc16804>")
	public void User_selects_current_date_plus_61_days_as_new_effective_date_tc16804() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(61)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@When("User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' label is visible <tc16804>")
	public void user_validates_maximum_change_date_allowed_is_60_days_label_is_visible_tc16804() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		attachScreenShot(driver);
	}

	@And("User selects current date plus 60 days as new effective date <tc16804>")
	public void User_selects_current_date_plus_60_days_as_new_effective_date_tc16804() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(60)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@Then("User process tx and validates expected messages and finishes test <tc16804>")
	public void user_process_tx_and_validates_expected_messages_finishes_test_tc16804() throws Exception {
		click(closeoutChevron.btnIssueNB);
		waitImp(10);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		verify_AnyText_IsVisible(driver, "Change Date");
		verify_AnyText_IsVisible(driver, "Change Effective Date from " + dtf.format(currentDate) + " to "
				+ dtf.format(currentDate.plusDays(60)));
		Hooks.scenario.log("Test Case Completed!");
	}
}
