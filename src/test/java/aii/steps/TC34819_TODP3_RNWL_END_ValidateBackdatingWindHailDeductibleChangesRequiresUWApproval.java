package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC34819_TODP3_RNWL_END_ValidateBackdatingWindHailDeductibleChangesRequiresUWApproval
		extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime effectiveDate = currentDate.minusYears(1);
	static LocalDateTime RnwlDate = effectiveDate.plusYears(1);
	static String AppNum;
	static String policyNum;
	static String PolicyTerm02;

	@When("User changes system date to effective date 'current date minus 1 year' <tc34819>")
	public void user_changes_system_date_to__eff_date_tc34819() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(effectiveDate));
	}

	@When("User enters all required information on policy information screen <tc34819>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34819() {

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

	@When("User enters product selection information for TODP3 and current date minus 1 year as effective date")
	public void user_enters_product_selection_information_for_todp3_and_current_date_minus_1_year_as_effective_date() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(effectiveDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp3);
	}

	@When("User enters all required information on TODP3 quote screen <tc34819>")
	public void user_enters_all_required_information_on_todp3_quote_screen_tc34819() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TODP3 dwelling screen <tc34819>")
	public void user_enters_all_required_information_on_todp3_dwelling_screen_tc34819() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2100");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "06");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddNumberofUnits, ConfigsReader.getProperty("numberofunits"));
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "41");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(1);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron and selects roof material <tc34819>")
	public void user_clicks_dwelling_chevron_and_selects_roof_material_tc34819() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		wait(2);
		click(dwellingChevron.btnSave);
	}

	@When("User validates that TODP3 policy has been created successfully and take note of policy number <tc34819>")
	public void user_validated_todp3_policy_has_been_created_successfully_and_takes_note_of_policy_number_tc34819()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut DP3 policy has been created successfully");
		} else {
			System.out.println("TakeOut DP3 policy creation failed!");
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

	@When("User clicks Make Payment and selects credit card and enters due amount for <tc34819>")
	public void user_clicks_make_payment_and_selects_tc34819() {
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

	@When("User makes payment with Credit Card for <tc34819>")
	public void user_makes_payment_with_credit_card_tc34819() {
		makeCCPayment();
		wait(1);
		closeUnnecessaryTabs();
	}

	@When("User does auto renewal through batch jobs <tc34819>")
	public void user_does_auto_renewal_through_batch_jobs_tc34819() throws Exception {
		PolicyTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");
		wait(1);
	}

	@When("User changes system date to renewal date minus 1 day <tc34819>")
	public void user_changes_system_date_to__renewal_date_minus_1_day_tc34819() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.minusDays(1)));
	}

	@When("User searches for the renewed policy number <tc34819>")
	public void user_searches_renewed_policy_for_tc34819() {
		sendText(dashboard.txtSearchBar, PolicyTerm02);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as renewal effective date and starts endorsement <tc34819>")
	public void User_sets_new_effective_date_as_renewaleffective_date_and_starts_endorsement_tc34819() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(RnwlDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks dwelling chevron <tc34819>")
	public void user_clicks_dwelling_chevron_tc34819() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User unchecks wind hail exclusion")
	public void user_unchecks_wind_hail_exclusion() {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(1);
	}

	@When("User finalizes transaction and validates expected text messages on closeout screen")
	public void user_finalizes_transaction_and_validates_expected_text_messages_on_closeout_Screen() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		verify_AnyText_IsVisible(driver, "Windstorm Or Hail Exclusion Changed From Yes to None");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User endorses policy and close tabs")
	public void user_endorses_policy_and_close_tabs_tc34819() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
	}

	@When("User changes system date to renewal date <tc34819>")
	public void user_changes_system_date_to__renewal_date_tc34819() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate));
	}

	@When("User checks wind hail exclusion")
	public void user_checks_wind_hail_exclusion() {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(1);
	}

	@When("User finalizes second transaction and validates expected text messages on closeout screen")
	public void user_finalizes_second_transaction_and_validates_expected_text_messages_on_closeout_Screen()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 2% to Not Applicable");
		verify_AnyText_IsVisible(driver, "Windstorm Or Hail Exclusion Changed From None to Yes");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User changes system date to renewal date plus 1 day <tc34819>")
	public void user_changes_system_date_to__renewal_date_plus_1_day_tc34819() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.plusDays(1)));
	}

	@When("User finalizes third transaction and validates expected text messages on closeout screen")
	public void user_finalizes_third_transaction_and_validates_expected_text_messages_on_closeout_Screen()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Wind/Hail Exclusion may only be added or deleted at Renewal");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		verify_AnyText_IsVisible(driver, "Windstorm Or Hail Exclusion Changed From Yes to None");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
	}

	@When("User takes note of the application number for <tc34819>")
	public void user_takes_note_of_the_app_number_for_tc34819() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc34819>")
	public void user_searches_application_for_tc34819() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User process transaction and completes test <tc34819>")
	public void user_process_transaction_and_comppletes_test_tc34819() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
