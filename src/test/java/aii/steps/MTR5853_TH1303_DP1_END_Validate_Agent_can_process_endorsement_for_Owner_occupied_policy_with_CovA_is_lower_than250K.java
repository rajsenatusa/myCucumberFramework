package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5853_TH1303_DP1_END_Validate_Agent_can_process_endorsement_for_Owner_occupied_policy_with_CovA_is_lower_than250K extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr5853>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5853() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
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
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr5853>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr5853() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen and enters CoverageA is as 250k <mtr5853>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr5853() throws Exception {

//		sendText(dwellingChevron.txtYearConstruction, "2023");
//		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "250000");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr5853>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_mtr5853()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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
	@When("User selects endorsement date as current date <mtr5853>")
	public void user_selects_endorsement_date_as_current_date_mtr5853() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User clicks Dwelling Chevron for <mtr5853>")
	public void user_clicks_dwelling_chevron_mtr5853() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User decreases Coverage A below 250k and validate issue message did not display")
	public void user_decreases_Coverage_A_below_250k_and_validate_issue_message_did_not_display() throws Exception {
		setDataToAnyTextboxField(driver, "Cov-A", "CovALimit", "249000");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyfirstText_IsNOTDisplayed(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
	}
	@When("User validates issue message did not display on closeout screen either")
	public void user_validates_issue_message_did_not_display_on_closeout_screen_either() throws Exception {
		verify_AnyfirstText_IsNOTDisplayed(driver, "Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ");
	}
	@Then("User endorses policy and completes test case <mtr5853>")
	public void user_endorses_policy_and_completes_test_case_mtr5853() {
		click(closeoutChevron.btnIssueNB);
		wait(7);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed");
	}
}
