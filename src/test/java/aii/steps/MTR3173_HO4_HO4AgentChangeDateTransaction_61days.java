package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR3173_HO4_HO4AgentChangeDateTransaction_61days extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User takes note of the policy number for <mtr3173>")
	public void user_takes_note_of_the_policy_number_for_mtr3173() throws Exception {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters all required information on policy information screen <mtr3173>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr3173() {

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
	@When("User enters all required information on HO4 quote screen with current date as prior policy date <mtr3173>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr3173() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, "No");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen <mtr3173>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr3173() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User searches for Policy Number for <mtr3173>")
	public void user_searches_for_policy_number_for_mtr3173() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects current date plus 61 days as new effective date")
	public void User_selects_current_date_plus_61_days_as_new_effective_date() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(61)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@When("User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' label is visible")
	public void user_validates_maximum_change_date_allowed_is_60_days_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		attachScreenShot(driver);
	}

	@When("User clicks Cancel button")
	public void user_clicks_Cancel_button() throws Exception {
		driver.findElement(By.id("Cancel")).click();
		wait(1);
	}

	@And("User selects current date plus 60 days as new effective date")
	public void User_selects_current_date_plus_60_days_as_new_effective_date() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(60)));
		// driver.findElement(By.xpath("//*[@id=\"TransactionSelection\"]/table[3]/tbody/tr[1]/th[2]/label")).click();
		wait(5);
		click(historyChevron.btnStart);
		wait(6);
		click(historyChevron.btnStart);
		wait(6);
	}

	@When("User validates 'Requested effective date change requires underwriting review' text is visible and previous text not visible")
	public void user_validates_requested_effective_date_change_requires_underwriting_review_text_is_visible_and_previous_text_not_visible()
			throws Exception {
		verify_AnyText_NotVisible(driver,
				"Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		verify_AnyText_IsVisible(driver, "Requested effective date change requires underwriting review");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User takes note of the application number <mtr3173>")
	public void user_takes_note_of_the_application__number_mtr3173() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches application <mtr3173>")
	public void user_searches_application_mtr3173() throws Exception {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User clicks Submit for Approval as Underwriter")
	public void user_clicks_submit_for_approval_button_as_Underwriter() throws Exception {
		sendText(closeoutChevron.txtWorkflowComments, "testtesttesttes");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}

	@When("User process tx and validates expected messages and finishes test")
	public void user_process_tx_and_validates_expected_messages_finishes_test() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		verify_AnyText_IsVisible(driver, "Change Date");
		verify_AnyText_IsVisible(driver, "Change Effective Date from " + dtf.format(currentDate) + " to "
				+ dtf.format(currentDate.plusDays(60)));
		Hooks.scenario.log("Test Case Completed!");
	}
}
