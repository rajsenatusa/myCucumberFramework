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

public class TC33770_TOMHO_ModifyWindHailExclusionRulesAndEdits_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc33770>")
	public void user_enters_all_required_information_on_policy_information_screen_tc33770() {

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

	@When("User enters all required information on TOMHO quote screen <tc33770>")
	public void user_enters_all_required_information_on_tomho_quote_screen_tc33770() {
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

	@When("User enters all required information on TOMHO dwelling screen <tc33770>")
	public void user_enters_all_required_information_on_tomho_dwelling_screen_tc33770() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		// selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		sendText(dwellingChevron.txtCoverageA, "75000");
		click(dwellingChevron.rbWindHailExc);
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron <tc33770>")
	public void user_clicks_dwelling_chevron_tc33770() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User completes required information on dwelling screen <tc33770>")
	public void user_completes_required_information_tc33770() {

		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that TOMHO policy has been created successfully and takes note of the policy number <tc33770>")
	public void user_validates_that_tomho_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc33770()
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
	@When("User changes system date to current date minus 1 day <tc33770>")
	public void user_changes_system_date_To_current_date_minus_1_day_tc33770() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.minusDays(1)));
	}
	@When("User searches for the policy number <tc33770>")
	public void user_searches_policy_for_tc33770() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date and starts endorsement <tc33770>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_tc33770() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User validates Windhail Exclusion Selection is disabled")
	public void user_validates_Windhail_Exclusion_Selection_is_disabled() throws Exception {
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Building.WindHailExcludedInd");	
	}
	@When("User changes system date to current date <tc33770>")
	public void user_changes_system_date_To_current_date__tc33770() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User changes system date to current date plus 1 day <tc33770>")
	public void user_changes_system_date_To_current_date_plus_1_day_tc33770() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}
	@When("User clicks Policy Chevron <tc33770>")
	public void user_clicks_policy_chevron_tc33770() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}
	@When("User takes note of the application number for <tc33770>")
	public void user_takes_note_of_the_app_number_for_tc33770() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <tc33770>")
	public void user_searches_application_for_tc33770() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates Windhail Exclusion Selection is enabled")
	public void user_validates_Windhail_Exclusion_Selection_is_enabled() throws Exception {
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Building.WindHailExcludedInd");	
	}
	@When("User unchecks WindHail Exclusion")
	public void user_unchecks_WindHail_Exclusion() throws Exception {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates Hurricane Deductible defaulted to <%2>")
	public void user_validates_Hurricane_Deductible_defaulted_to_2_percent() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.HurricaneDeductible", "2%");
	}
	@Then("User finalizes transaction and endorses policy and completes test <tc33770>")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs_tc33770() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		click(closeoutChevron.btnEndorsePolicy);
		wait(15);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
