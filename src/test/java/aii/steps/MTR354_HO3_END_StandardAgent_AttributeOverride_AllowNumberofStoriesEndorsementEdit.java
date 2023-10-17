package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR354_HO3_END_StandardAgent_AttributeOverride_AllowNumberofStoriesEndorsementEdit extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr354>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr354() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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

	@When("User enters all required information on HO3 quote screen <mtr354>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr354() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-342-4532");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr354>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr354() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);

		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$15,000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron <mtr354>")
	public void user_completes_required_information_on_dwelling_chevron_mtr354() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtYearElectrical, "2023");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <mtr354>")
	public void User_clicks_Finalize_button_mtr354() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr354>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr354()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
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

	@When("User switches as no for the attribute of 'Allow Number of Stories Endorsement Edit'")
	public void user_switches_as_no_for_the_attribute_of_allow_number_stories_endorsement() throws Exception {
		scrollToElement(userLookup.txtAllowNumberStoriesEndorsementEdit);
		sendText(userLookup.txtAllowNumberStoriesEndorsementEdit, "No");
		attachScreenShot(driver);
	}

	@When("User searches for the policy number <mtr354>")
	public void user_searches_policy_for_mtr354() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 10 days and starts endorsement <mtr354>")
	public void User_sets_new_effective_date_as_current_date_plus_10_days_and_starts_endorsement_mtr354()
			throws Exception {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(10)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
		click(dwellingChevron.btnDwelling);
		wait(2);
		attachScreenShot(driver);
	}

	@And("User cancels transactions and delete application")
	public void User_cancels_transaction_and_delete_application() {
		;
		click(dashboard.btnDelete);
		click(closeoutChevron.btnDialogOk);
		wait(4);
	}

	@When("User switches as yes for the attribute of 'Allow Number of Stories Endorsement Edit'")
	public void user_switches_as_yes_for_the_attribute_of_allow_number_stories_endorsement() throws Exception {
		scrollToElement(userLookup.txtAllowNumberStoriesEndorsementEdit);
		sendText(userLookup.txtAllowNumberStoriesEndorsementEdit, "Yes");
		attachScreenShot(driver);
	}

	@When("User clicks Dwelling Chevron <mtr354>")
	public void user_clicks_dwelling_chevron_mtr354() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates Number of Stories dropdown is enabled")
	public void user_validates_number_of_stories_dd_is_enabled() throws Exception {
		verifyAnyElement_Enabled(driver, "Building.NumberOfStories");
	}

	@When("User gets all possible dd values for number of stories field and selects '4 or more' from selections and takes screenshot")
	public void user_gets_all_possible_dd_values_selects_4_or_more_and_attaches_ss() throws Exception {
		getAnyDropdownPopulatedValue(driver, "Building.NumberOfStories");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "4 or more");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User process and completes endorsement <mtr354>")
	public void User_process_and_completes_endorsement_mtr354() {
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		closeUnnecessaryTabs();
	}

	@And("User validates 'Number of Stories' field is disabled and completes test")
	public void User_validates_number_of_stories_field_is_disabled_and_completes_test() throws Exception {
		verifyAnyDisabledFieldsValue(driver, "Building.NumberOfStories_text", "4 or more");
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
