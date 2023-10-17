package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR393_TODP3_ValidateOpenCompanyCancellationCompletionAppliestoRenewalTerm extends CommonMethods{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String AppNumber;
	static String policyNum;
	static String PolicyTerm02;
	
	@When("User enters product selection information for TODP3 and current date as effective date")
	public void user_enters_product_selection_information_for_todp3_and_current_date_as_effective_date() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp3);
	}
	@When("User validates that TODP3 policy has been created successfully and take note of policy number")
	public void user_validates_that_todp3_policy_has_been_created_successfully_and_takes_note_of_policy_number() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut DP3 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
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
	@When("User searches for the policy number <mtr393>")
	public void user_searches_policy_for_mtr393() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects effective date as cancel date 'current date plus 30 days' <mtr393>")
	public void User_selects_effective_date_as_cancel_date_mtr393_current_date_plus30days() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
	}
	@And("User selects pro rate as cancel type and process transaction <mtr393>")
	public void User_selects_pro_rate_393() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@When("User takes note of the application number <mtr393>")
	public void user_takes_note_of_the_application__number_mtr393() throws Exception {
		try {
			AppNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr393>")
	public void user_clicks_make_payment_and_selects_cc_393()  {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue=driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}
	@When("User makes payment with Credit Card for <mtr393>")
	public void user_makes_payment_with_credit_card_mtr393()  {
		makeCCPayment();
		wait(3);
		closeUnnecessaryTabs();
	}
	@When("User does auto renewal through batch jobs <mtr393>")
	public void user_does_auto_renewal_through_batch_jobs_mtr393() throws Exception {
		PolicyTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");	
		wait(1);
		clickApplicationTab(driver);
	}
	@When("User searches for the application <mtr393>")
	public void user_searches_application_for_mtr393() {
		sendText(dashboard.txtSearchBar, AppNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates expected text messages")
	public void user_validates_expected_text_messages() throws Exception {
		verify_AnyText_IsVisible(driver, "Another transaction on a future term of this policy ("+PolicyTerm02+") has been processed since this transaction was started");
		verify_AnyText_IsVisible(driver, "As a result, this transaction can no longer be continued as-is");
		verify_AnyText_IsVisible(driver, "If refreshed, this transaction will be out of sequence. Processing it will apply all changes to the renewal term(s)");	
	}
	@When("User clicks refresh button")
	public void user_clicks_refresh_button() {
		driver.findElement(By.id("RefreshApplication")).click();
		wait(2);
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
	}
	@When("User validates 'conflict with changes made to the policy since this application was started. Expand to review' message has been displayed")
	public void user_validates_expected_text_messages_mtr393() throws Exception {
		verify_AnyText_IsVisible(driver, "conflict with changes made to the policy since this application was started. Expand to review");	
	}
	@When("User finalizes transaction <mtr393>")
	public void user_finalizes_transaction_mtr393() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
	}
	@Then("User clicks cancelled policy and compare transaction status with expected value")
	public void user_clicks_cancelled_policy_do_validations() throws Exception {
		driver.findElement(By.id("History_1_2")).click();
		wait(1);
		driver.findElement(By.id("FullSummaryHolder")).click();
		wait(1);
		getTextOfElement(driver, "Full_PolicySummary_TransactionStatus");
		driver.findElement(By.id("FullSummaryHolder")).click();
		wait(1);
		Hooks.scenario.log("Test Case Completed!");
	}
	@And("User selects Substantial Change in risk as reason <mtr393>")
	public void User_selects_reason() {
		selectDropdownText(historyChevron.ddReason, "Substantial Change in Risk");
		wait(2);
	}
	
}
