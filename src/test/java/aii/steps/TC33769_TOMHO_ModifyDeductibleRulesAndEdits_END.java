package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC33769_TOMHO_ModifyDeductibleRulesAndEdits_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc33769>")
	public void user_enters_all_required_information_on_policy_information_screen_tc33769() {

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

	@When("User enters all required information on TOMHO quote screen <tc33769>")
	public void user_enters_all_required_information_on_tomho_quote_screen_tc33769() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHO dwelling screen <tc33769>")
	public void user_enters_all_required_information_on_tomho_dwelling_screen_tc33769() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		sendText(dwellingChevron.txtCoverageA, "75000");
		click(dwellingChevron.rbWindHailExc);
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron <tc33769>")
	public void user_clicks_dwelling_chevron_tc33769() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User completes required information on dwelling screen <tc33769>")
	public void user_completes_required_information_tc33769() {

		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that TOMHO policy has been created successfully and takes note of the policy number <tc33769>")
	public void user_validates_that_tomho_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc33769()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut MHO policy has been created successfully");
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

	@When("User changes system date to current date minus 1 day <tc33769>")
	public void user_changes_system_date_To_current_date_minus_1_day_tc33769() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.minusDays(1)));
	}

	@When("User searches for the policy number <tc33769>")
	public void user_searches_policy_for_tc33769() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <tc33769>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_tc33769() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User decrease deductibles <tc33769>")
	public void user_decrease_deductibles_tc33769() {
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "5%");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User finalizes transaction and validates ded changes are visible on closeout screen and completes endorsement <tc33769>")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs_tc33769() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");
		click(closeoutChevron.btnEndorsePolicy);
		wait(15);
		closeUnnecessaryTabs();
	}

	@When("User changes system date to current date <tc33769>")
	public void user_changes_system_date_To_current_date_tc33769() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User increases deductibles <tc33769>")
	public void user_increases_deductibles_tc33769() {
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User finalizes transaction and validates ded changes are visible on closeout screen and completes second endorsement <tc33769>")
	public void user_finalizes_transaction_and_validates_changes_on_second_endorseemnt_endorses_policy_and_close_tabs_tc33769()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $1,000 to $2,500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 5% to 10%");
		click(closeoutChevron.btnEndorsePolicy);
		wait(15);
		closeUnnecessaryTabs();
	}

	@When("User changes system date to current date plus 1 day <tc33769>")
	public void user_changes_system_date_To_current_date_plus_1_day_tc33769() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}

	@When("User clicks Policy Chevron <tc33769>")
	public void user_clicks_policy_chevron_tc33769() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}

	@When("User validates expected validation messages on policy chevron <tc33769>")
	public void user_validates_expected_validation_messages_on_policy_chevron_tc33769() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
	}

	@And("User finalizes transaction and validates expected messages on closeout screen <tc33769>")
	public void user_finalizes_transaction_and_validates_expected_messages_on_closeout_screen_tc33769()
			throws Exception {
		
		click(reviewChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");

		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application number for <tc33769>")
	public void user_takes_note_of_the_app_number_for_tc33769() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for application number <tc33769>")
	public void user_searches_for_application_number_tc33769() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User process and completes endorsement and finishes test <tc33769>")
	public void user_process_and_completes_endorsement_and_finishes_test_tc33769() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
