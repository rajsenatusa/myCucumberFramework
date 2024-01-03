package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC35236_HO6_ValidateOpenCompanyCancellationCompletionAppliestoRenewalTerm extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorseDate = currentDate.plusDays(30);
	static String policyNum;
	static String AppNum;
	static String totalDue;
	static String PolicyTerm02;

	@When("User enters all required information on policy information screen <tc35236>")
	public void user_enters_all_required_information_on_policy_information_screen_tc35236() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc35236>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc35236() {

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
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <tc35236>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_25000_Cov_c_tc35236() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "294000");
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$1,000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@And("User checks application dwelling screen and finalizes transaction <tc35236>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_tc35236() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User answers all underwriting questions for HO6 <tc35236>")
	public void user_answers_all_underwriting_questions_for_ho6_tc35236() throws Exception {
		fillHO6_UWQuestions();
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <tc35236>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_tc35236()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <tc35236>")
	public void user_searches_policy_for_tc35236() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Failure to comply with underwriting requirements as reason <tc35236>")
	public void User_selects_reason_failure_toComply_with_Uw_requirements_tc35236() {
		selectDropdownText(historyChevron.ddReason, "Failure to comply with underwriting requirements");
		wait(2);
	}

	@And("User selects Additional information required for underwriting review not provided as subreason <tc35236>")
	public void User_selects_additional_info_required_as_subreason_tc35236() {
		selectDropdownText(historyChevron.ddSubReason,
				"Additional information required for underwriting review not provided");
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects effective date as cancel date 'current date plus 30 days' <tc35236>")
	public void User_sets_effective_date_as_cancel_date_tc35236() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <tc35236>")
	public void user_clicks_make_payment_and_selects_cc_tc35236() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card <tc35236>")
	public void user_makes_payment_with_credit_card_tc35236() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does Auto Renewal for the policy with batch jobs <tc35236>")
	public void user_does_auto_renewal_tc35236() throws Exception {
		PolicyTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");
	}

	@When("User takes note of the application number <tc35236>")
	public void user_takes_note_of_the_application__number_tc35236() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for application number <tc35236>")
	public void user_searches_for_application_number_tc35236() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates expected issue cancellation messages <tc35236>")
	public void user_validates_expected_issue_cancellation_messages_tc35236() throws Exception {
		verify_AnyText_IsVisible(driver, "Another transaction on a future term of this policy (" + PolicyTerm02
				+ ") has been processed since this transaction was started");
		verify_AnyText_IsVisible(driver, "As a result, this transaction can no longer be continued as-is");
		verify_AnyText_IsVisible(driver,
				"If refreshed, this transaction will be out of sequence. Processing it will apply all changes to the renewal term(s)");
	}

	@When("User clicks Refresh button and validates 'conflict with changes made to the policy since this application was started. Expand to review' message displayed")
	public void user_clicks_Refresh_button_and_validates_error_message() throws Exception {
		driver.findElement(By.id("RefreshApplication")).click();
		wait(3);
		clickOKDailogButton(driver);
		verify_AnyText_IsVisible(driver,
				"conflict with changes made to the policy since this application was started. Expand to review");
	}

	@And("User clicks Finalize button <tc35236>")
	public void User_clicks_Finalize_button_tc35236() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@And("User process and completes endorsement <tc35236>")
	public void User_process_and_completes_endorsement_tc35236() throws Exception {
		clickProcess(driver);
		wait(15);
		closeUnnecessaryTabs();
	}

	@Then("User opens Cancelled Policy Details and validates expected status and completes test")
	public void User_opens_Cancelled_Policy_Details_and_validates_expected_Status_and_completes_test()
			throws Exception {
		driver.findElement(By.id("History_1_2")).click();
		wait(2);
		Hooks.scenario.log("Opened Cancelled Policy");

		// click summary
		wait(1);
		driver.findElement(By.id("FullSummaryHolder")).click();
		wait(1);
		Hooks.scenario.log("Summary tab clicked ");

		String TransactionStatus = getTextOfElement(driver, "Full_PolicySummary_TransactionStatus");
		expectedValue_foundValue(driver, "Cancelled - Renewed", TransactionStatus);
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}

	@And("User selects pro rate as cancel type and process transaction <tc35236>")
	public void User_selects_pro_rate_tc35236() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
}
