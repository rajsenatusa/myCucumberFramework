package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC16777_TODP1_ValidateUWApprovalNeededForIncreaingDwellingCoverageAndChangingDeductible_NB_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16777>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16777() {

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

	@When("User enters product selection information for TODP1 and effective date as current date <tc16777>")
	public void user_enters_product_selection_information_for_todp1_and_effective_date_as_current_date_tc16777() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);
	}

	@When("User enters all required information on TODP1 quote screen <tc16777>")
	public void user_enters_all_required_information_on_todp1_quote_screen_tc16777() {

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

	@When("User enters all required information on TODP1 dwelling screen <tc16777> and sets sinkhole loss ded <10% Ded of Cov A>")
	public void user_enter_all_required_information_on_todp1_dwelling_screen_tc16777() {
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
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks Dwelling Chevron for <tc16777>")
	public void user_clicks_dwelling_chevron_tc16777() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates that TODP1 policy has been created successfully and takes note of the policy number <tc16777>")
	public void user_validates_that_todp1_policy_has_been_created_successfully_and_takes_note_of_policy_number_tc16777()
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

	@When("User searches for the policy number <tc16777>")
	public void user_searches_policy_for_tc16777() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 30 days and starts endorsement <tc16777>")
	public void User_sets_new_effective_date_as_endorsement_date_and_starts_endorsement_tc16777() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User increases CovA Dwelling and add other coverages <tc16777>")
	public void user_increases_covADwelling_and_other_coverages_tc16777() throws Exception {

		sendText(driver.findElement(By.id("CovALimit")), "541000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "Not Applicable");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User clicks Finalize button, validates changes are visible on closeout screen <tc16777>")
	public void User_clicks_finalize_and_validates_changes_tc16777_() throws Exception {
		reviewChevron.btnFinalize.click();
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $5,000 Must be Approved");
		verify_AnyText_IsVisible(driver, "Removal of Sinkhole Deductible Must Be Approved");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible May Only be Changed at Renewal");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application for <tc16777>")
	public void user_takes_note_of_the_application__number_for_tc16777() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc16777>")
	public void user_searches_application_for_tc16777() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates expected following messages on issue tile <tc16777>")
	public void user_validates_expected_following_messages_on_issue_tile_tc16777() throws Exception {
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $100,000 Must be Approved");

		// Verify the following messages on submitter issue tile
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $5,000 Must be Approved");
		verify_AnyText_IsVisible(driver, "Removal of Sinkhole Deductible Must Be Approved");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible May Only be Changed at Renewal");
		attachScreenShot(driver);
	}

	@When("User validates 'Coverage A change cannot exceed $100,000 Must be Approved' message")
	public void user_validates_coverage_cannot_exceed_100000_must_be_approved_message_displayed_on_issue_tile_tc16777()
			throws Exception {
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $100,000 Must be Approved");
		attachScreenShot(driver);
	}

	@When("User process and completes endorsement and finishes test <tc16777>")
	public void user_process_and_completes_endorsement_and_finishes_test_tc16777() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
		closeUnnecessaryTabs();
		expandTransaction(driver, "1_2");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Deductible Change: All Other Perils Changed From $1,000 to $2,500");
		Hooks.scenario.log("Test Case Completed!");
	}
}
