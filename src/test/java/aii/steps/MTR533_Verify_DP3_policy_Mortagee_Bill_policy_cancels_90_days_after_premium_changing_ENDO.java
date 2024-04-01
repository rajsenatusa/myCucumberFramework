package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR533_Verify_DP3_policy_Mortagee_Bill_policy_cancels_90_days_after_premium_changing_ENDO extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String endorsementDate =dtf.format(currentDate.plusDays(25));
	static String policyNum;
	static String nextDate;
	static String nextDate2;
	static String nextDate3;
	static String nextDate4;
	static String nextDate5;
	
	@When("User changes system date to current date <mtr533>")
	public void user_changes_system_date_to_current_date_mtr533() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr533>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr533() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
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

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr533>")
	public void user_enters_all_current_date_as_prior_date_mtr533() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP3 dwelling screen <mtr533>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr533() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
	}
	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr533>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs_mtr533()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);
		} else {
			System.out.println("DP3 policy creation has been failed!");
		}
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
	@And("User completes required information on add additional interests screen and add first mortgagee <mtr533>")
	public void User_completes_required_information_on_add_additional_interests_screen_mtr533() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10002");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "First Mortgagee");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User changes system date to current date plus 25 days <mtr533>")
	public void user_changes_system_date_to_current_date_plus25days_mtr533() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(25)));
	}
	@When("User searches for the policy number <mtr533>")
	public void user_searches_policy_for_mtr533() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User selects endorsement date as current date plus <25> days <mtr533>")
	public void user_selects_endorsement_date_as_current_date_plus_25_days_mtr533() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(25)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User clicks Dwelling Chevron for <mtr533>")
	public void user_clicks_dwelling_chevron_mtr533() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User increases CovA <mtr533>")
	public void user_increases_CovA_mtr533() throws Exception {
		sendText(dwellingChevron.txtCoverageA, "550000");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User endorses policy <mtr533>")
	public void user_endorses_policy_and__mtr533() {
		click(closeoutChevron.btnIssueNB);
		wait(9);
		closeUnnecessaryTabs();
	}
	@When("User takes note of next action date and run daily jobs <mtr533>")
	public void user_takes_note_of_the_next_action_date_and_run_daily_jobs_mtr533() throws Exception {

		nextDate = getNextActionDate(driver).toString();
		policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		runDailyJobOnDate(driver, policyNum, nextDate);
	}
	@When("User validates next action date as endorsement date plus 60 days and run daily jobs <mtr533>")
	public void user_validates_the_next_action_date_enddate_plus_60_days_and_run_daily_jobs_mtr533() throws Exception {

		nextDate2 = getNextActionDate(driver).toString();
		if(nextDate2.contains(dtf.format(currentDate.plusDays(85)))) {
			Hooks.scenario.log("Next Action Date is endorsement date plus 60 days as expected");
		}
		else {
			Hooks.scenario.log("Next Action Date is not matching with expected date. Test fails!!");
		}
		runDailyJobOnDate(driver, policyNum, nextDate2);
	}
	@When("User validates next action date as endorsement date plus 75 days and run daily jobs <mtr533>")
	public void user_validates_the_next_action_date_endorsement_date_plus_75_days_and_run_daily_jobs_mtr533() throws Exception {

		nextDate3 = getNextActionDate(driver).toString();
		if(nextDate3.contains(dtf.format(currentDate.plusDays(100)))) {
			Hooks.scenario.log("Next Action Date is endorsement date plus 75 days as expected");
		}
		else {
			Hooks.scenario.log("Next Action Date is not matching with expected date. Test fails!!");
		}
		runDailyJobOnDate(driver, policyNum, nextDate3);
	}
	@When("User validates next action date as endorsement date plus 90 days validates cancellation notice generated and run daily jobs <mtr533>")
	public void user_validates_the_next_action_date_endorsement_date_plus_90_days_and_run_daily_jobs_mtr533() throws Exception {

		nextDate4 = getNextActionDate(driver).toString();
		if(nextDate4.contains(dtf.format(currentDate.plusDays(115)))) {
			Hooks.scenario.log("Next Action Date is endorsement date plus 90 days as expected");
		}
		else {
			Hooks.scenario.log("Next Action Date is not matching with expected date. Test fails!!");
		}
		click(historyChevron.btnHistoryChevron);
		wait(1);
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
		runDailyJobOnDate(driver, policyNum, nextDate4);
	}
	@Then("User validates next action date as None and validates flat cancellation generated, completes test <mtr533>")
	public void user_validates_the_next_action_date_as_none_validateS_cancellation_generated_mtr533() throws Exception {

		nextDate5 = driver.findElement(By.id("Description_text")).getText().toString();
		attachScreenShot(driver);
		if(nextDate5.equalsIgnoreCase("None")) {
			Hooks.scenario.log("Next Action Date is displayed as None");
		}
		else {
			Hooks.scenario.log("Next Action Date is not matching with expected date. Test fails!!");
		}
		click(historyChevron.btnHistoryChevron);
		wait(1);
		verify_AnyText_IsVisible(driver, "Cancellation");
		Hooks.scenario.log("Test Case Completed!");
	}
	@And("User checks application dwelling screen, selects mortgagee bill and finalizes transaction <mtr533>")
	public void user_checks_application_dwelling_screen_select_mortageebill_and_finalizes_transaction() {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(1);
		selectDropdownText(reviewChevron.ddPayPlan, "Mortgagee Bill");
		click(reviewChevron.btnMortgageeFullPay);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
}
