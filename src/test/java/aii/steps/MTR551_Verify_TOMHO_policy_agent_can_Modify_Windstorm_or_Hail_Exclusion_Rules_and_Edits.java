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

public class MTR551_Verify_TOMHO_policy_agent_can_Modify_Windstorm_or_Hail_Exclusion_Rules_and_Edits extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;
	
	@When("User enters all required information on policy information screen <mtr551>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr551() {

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
	@When("User changes system date to current date <mtr551>")
	public void user_changes_system_date_to_current_date_mtr551() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on TOMHO quote screen <mtr551>")
	public void user_enters_all_required_information_on_tomho_quote_screen_mtr551() {
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

	@When("User enters all required information on TOMHO dwelling screen <mtr551>")
	public void user_enters_all_required_information_on_tomho_dwelling_screen_mtr551() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		// selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		sendText(dwellingChevron.txtCoverageA, "75000");
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		click(dwellingChevron.rbWindHailExc);
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron <mtr551>")
	public void user_clicks_dwelling_chevron_mtr551() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User completes required information on dwelling screen <mtr551>")
	public void user_completes_required_information_mtr551() {
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

	@When("User validates that TOMHO policy has been created successfully and takes note of the policy number <mtr551>")
	public void user_validates_that_tomho_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr551()
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
	@When("User searches for the policy number <mtr551>")
	public void user_searches_policy_for_mtr551() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User changes system date to current date minus 1 day <mtr551>")
	public void user_changes_system_date_to_current_date_minus_1_day_mtr551() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.minusDays(1)));
	}
	@And("User sets new effective date as current date and starts endorsement <mtr551>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr551() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User validates wind hail exclusion radio button has been disabled")
	public void user_validates_wind_hail_exclusion_radio_button_has_been_disabled() throws Exception {
		verifyAnyElement_Disabled(driver, "Building.WindHailExcludedInd");
		attachScreenShot(driver);
	}
	@When("User deletes application <mtr551>")
	public void user_deletes_application_mtr551() throws Exception {
		click(dwellingChevron.btnDelete);
		clickOKDailogButton(driver);
	}
	@When("User changes system date to current date plus 1 day <mtr551>")
	public void user_changes_system_date_to_current_date_plus_1_day_mtr551() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}
	@And("User sets new effective date as current date plus 1 day and starts endorsement <mtr551>")
	public void User_sets_new_effective_date_as_current_date_plus1day_and_starts_endorsement_mtr551() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(1)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User clicks Policy Chevron <mtr551>")
	public void user_clicks_policy_chevron_mtr551() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}
	@When("User validates 'The effective date must not be older than 0 days from today. fix?' message <mtr551>")
	public void user_validates_issue_message_mtr551() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today. fix?");
	}
	@When("User takes note of the application number <mtr551>")
	public void user_takes_note_of_the_application__number_mtr551() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches previously created application <mtr551>")
	public void user_searches_previously_created_application_mtr551() throws Exception {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User unchecks wind hail exclusion button and validates hurricane defaulted %2")
	public void user_unchecks_wind_hail_exclusion_button_and_validates_hurricane_defaulted_2() throws Exception {
		click(dwellingChevron.rbWindHailExc);
		verifyAnyDropdownDefaultValue("Hurricane", "Building.HurricaneDeductible", "2%");
	}
	@Then("User finalizes transaction and endorses policy and completes test <mtr551>")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs_mtr551() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
