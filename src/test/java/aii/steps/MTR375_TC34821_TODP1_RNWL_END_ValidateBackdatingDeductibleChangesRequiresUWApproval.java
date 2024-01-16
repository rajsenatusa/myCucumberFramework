package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR375_TC34821_TODP1_RNWL_END_ValidateBackdatingDeductibleChangesRequiresUWApproval extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime effectiveDate = currentDate.minusYears(1);
	static LocalDateTime RnwlDate = effectiveDate.plusYears(1);
	static String policyNum;
	static String PolicyTerm02;
	static String AppNum;

	@When("User changes system date to current date minus 1 year")
	public void user_changes_system_date_to_current_date_minus_1_year() throws Exception {
		ChangeDate_Admin(driver, dtf.format(effectiveDate));
	}

	@When("User enters all required information on policy information screen <mtr375>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr375() {

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

	@When("User enters product selection information for TODP1 and effective date as current date minus 1 year")
	public void user_enters_product_selection_information_for_todp1_and_effective_date_as_current_date_minus_1_year() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(effectiveDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);
	}

	@When("User enters all required information on TODP1 quote screen <mtr375>")
	public void user_enters_all_required_information_on_todp1_quote_screen_mtr375() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TODP1 dwelling screen <mtr375> and sets all perils ded <$2500>, hurricane ded <%10>, fire ded <$2500>")
	public void user_enter_all_required_information_on_todp1_dwelling_screen_mtr375() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2100");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "06");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "41");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$2,500");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks Dwelling Chevron for <mtr375>")
	public void user_clicks_dwelling_chevron_mtr375() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User sets roof material as <3 Tab Composition Shingle>")
	public void user_sets_roof_material_as_3tabcompositionshingle() throws Exception {
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that TODP1 policy has been created successfully and takes note of the policy number <mtr375>")
	public void user_validates_that_todp1_policy_has_been_created_successfully_and_takes_note_of_policy_number_mtr375()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut DP1 policy has been created successfully");
		} else {
			System.out.println("TakeOut DP1 policy creation failed!");
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

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr375>")
	public void user_clicks_make_payment_and_selects_cc_375() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String currentDue = driver.findElement(By.id("AccountSummary_CurrentDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, currentDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr375>")
	public void user_makes_payment_with_credit_card_mtr375() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does auto renewal through batch jobs")
	public void user_does_auto_renewal_through_batch_jobs() throws Exception {
		PolicyTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");
		wait(1);
	}

	@When("User changes system date to renewal date minus 1 day")
	public void user_changes_system_date_to_renewal_days_minus_1_day() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.minusDays(1)));
	}

	@When("User searches for the renewal term policy number <mtr375>")
	public void user_searches_for_renewal_policy_for_mtr1414() {
		sendText(dashboard.txtSearchBar, PolicyTerm02);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as renewal effective date and starts endorsement <mtr375>")
	public void User_sets_new_effective_date_as_renewaleffective_date_and_starts_endorsement_mtr375() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(RnwlDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User decrease deductibles")
	public void user_decrease_deductibles() {
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "5%");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$1,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and verify changes are visible on closeout screen and endorses policy and close tabs")
	public void user_finalizes_transaction_and_endorses_policy_validate_changes_and_close_tabs() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $2,500 to $1,000");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");

		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
	}

	@When("User changes system date to renewal date <mtr375>")
	public void user_changes_system_date_to_renewal_date_mtr375() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate));
		wait(1);
	}

	@When("User increase deductibles")
	public void user_increase_deductibles() {
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$2,500");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and verify second changes are visible on closeout screen and endorses policy and close tabs")
	public void user_finalizes_transaction_and_endorses_policy_validate_second_changes_and_close_tabs()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $1,000 to $2,500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 5% to 10%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $1,000 to $2,500");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");

		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
	}

	@When("User validates 'The effective date must not be older than 0 days from today' text message has been displayed")
	public void user_validates_text_message_has_been_displayed_mtr375() throws Exception {
		click(dwellingChevron.btnSave);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
	}

	@When("User finalizes transaction and verify changes are visible on closeout screen and clicks submit for approval and takes note of app number")
	public void user_finalizes_transaction_and_clicks_submit_for_approval_validate_changes_and_take_note_app_number()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible May Only be Changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Fire Deductible May Only be Changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible May Only be Changed at Renewal");

		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $2,500 to $1,000");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		// takes note of the application number
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr375>")
	public void user_searches_application_for_mtr375() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User process transaction and completes test")
	public void user_process_transaction_and_comppletes_test() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
