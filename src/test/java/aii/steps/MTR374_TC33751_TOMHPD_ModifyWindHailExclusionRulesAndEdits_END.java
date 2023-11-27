package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR374_TC33751_TOMHPD_ModifyWindHailExclusionRulesAndEdits_END extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr374>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr374() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "15330 Searobbin Drive");
		sendText(quote.txtZipCode, "34202");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters product selection information for TOMHPD and current date as effective date")
	public void user_enters_product_selection_information_for_tomhpd_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomhpd);
	}

	@When("User enters all required information on TOMHPD quote screen <mtr374>")
	public void user_enters_all_required_information_on_tomhpd_quote_screen_mtr374() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		sendText(policyChevron.txtPhoneNumber, "313-741-4532");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHPD dwelling screen <mtr374>")
	public void user_enters_all_required_information_on_tomhpd_dwelling_screen_mtr374() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		getWaitObject();
		scrollToElement(dwellingChevron.txtCoverageA);
		wait(2);
		waitForVisibility(dwellingChevron.txtCoverageA);
		clickTab(dwellingChevron.txtCoverageA);
		clearText(dwellingChevron.txtCoverageA);
		wait(2);
		driver.findElement(By.id("Building.CovALimit")).sendKeys("80000"); // did hard coding due to element is hidden
																			// inside dom
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks Dwelling Chevron and completes required information")
	public void user_clicks_dwelling_chevron_and_completes_required_information() {
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks review Chevron and selects 8 Pay payment plan")
	public void user_clicks_review_chevron_and_selects_8_pay_payment_plan() {

		click(reviewChevron.btnReview);
		wait(2);
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btn8PaymentPayPlanTO);
	}

	@When("User validates that TOMHPD policy has been created successfully and takes note of the policy number")
	public void user_validates_that_tomhpd_policy_has_been_created_successfully_and_takes_note_of_the_policy_number()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut MHPD policy has been created successfully");
		} else {
			System.out.println("TakeOut MHPD policy creation failed!");
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

	@When("User changes system date to current date minus 1 day")
	public void user_changes_system_date_to_current_date_minus_1_day() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.minusDays(1)));
	}

	@When("User searches for the policy number <mtr374>")
	public void user_searches_policy_for_mtr374() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr374>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr374() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <mtr374>")
	public void user_clicks_dwelling_chevron_mtr374() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates Wind Hail exclusion is disabled")
	public void user_validates_wind_hail_selection_is_disabled() throws Exception {
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Building.WindHailExcludedInd");
	}

	@When("User changes system date to current date <mtr374>")
	public void user_changes_system_date_to_current_date_mtr374() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User changes system date to current date plus 1 day <mtr374>")
	public void user_changes_system_date_to_current_date_plus_1_day_mtr374() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}

	@When("User validates 'The effective date must not be older than 0 days from today' text has been displayed")
	public void user_validates_error_msg_has_Been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
	}

	@When("User takes note of the application for <mtr374>")
	public void user_takes_note_of_the_application__number_for_mtr374() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr374>")
	public void user_searches_application_for_mtr374() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks more button and take ownership of the application")
	public void user_clicks_more_button_and_take_ownership_of_the_application() {
		click(dwellingChevron.btnMore);
		click(dwellingChevron.btnTakeOwnership);
		wait(3);
		click(reviewChevron.btnDialogOk);
		wait(4);
	}

	@When("User validates Wind Hail exclusion is enabled")
	public void user_validates_wind_hail_selection_is_enabled() throws Exception {
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Building.WindHailExcludedInd");
	}

	@When("User unchecks Wind Hail Exclusion radio button")
	public void user_unchecks_windhailexc() throws Exception {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates Building Hurricane deductible defaulted to <%2>")
	public void user_validates_hurricane_ded_defaulted_to_2() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.HurricaneDeductible", "2%");
	}

	@When("User finalizes transaction and validates 'Deductible Change: Hurricane Changed From Not Applicable to 2%' text has been displayed and process and completes test")
	public void user_finalizes_transaction_and_validates_ded_change_and_completes_test() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
