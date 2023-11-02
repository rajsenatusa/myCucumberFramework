package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC16773_HO6_ValidateUWApprovalNeededForBasicToSilverReserveAndIncreaingDwellingCoverage_NB_END
		extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorseDate = currentDate.plusDays(30);
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16773>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16773() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc16773>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc16773() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <tc16773>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_25000_Cov_c_tc16773() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "294000");
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$1,000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User answers all underwriting questions for HO6 <tc16773>")
	public void user_answers_all_underwriting_questions_for_ho6_tc16773() throws Exception {
		fillHO6_UWQuestions();
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <tc16773>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_tc16773()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);

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

	@And("User checks application dwelling screen and finalizes transaction <tc16773>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_tc16773() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User changes system date to current date plus 30 days <tc16773>")
	public void user_changes_system_date_to_current_date_plus_30_days_tc16773() throws Exception {
		ChangeDate_Admin(driver, dtf.format(endorseDate));
	}

	@When("User searches for the policy number <tc16773>")
	public void user_searches_policy_for_tc16773() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as endorsement date and starts endorsement <tc16773>")
	public void User_sets_new_effective_date_as_endorsement_date_and_starts_endorsement_tc16773() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(endorseDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <tc16773>")
	public void user_clicks_dwelling_chevron_tc16773() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User selects Silver Reserve Package, increase CovA Dwelling and add other coverages")
	public void user_selects_silver_reserve_package_increase_covADwelling_and_other_coverages() throws Exception {
		click(dwellingChevron.rbSilverReserve);
		sendText(dwellingChevron.txtCoverageA, "395000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$2,500");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyLabel_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
	}

	@And("User completes required information on add additional interests screen and add additional insured <tc16773>")
	public void User_completes_required_information_on_add_additional_interests_screen_tc16773() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10002");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(3);
		sendText(additionalinterest.txtLoanNumber, "1234");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
	}

	@And("User clicks Finalize button, validates changes are visible on closeout screen <tc16773>")
	public void User_clicks_finalize_and_validates_changes_tc16773_() throws Exception {
		reviewChevron.btnFinalize.click();
		verify_AnyLabel_IsVisible(driver,
				"Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $50,000 require Underwriting Approval");
		verify_AnyLabel_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyLabel_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
		verify_AnyLabel_IsVisible(driver, "Change in the reserve package requires underwriting approval");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application for <tc16773>")
	public void user_takes_note_of_the_application__number_for_tc16773() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc16773>")
	public void user_searches_application_for_tc16773() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User changes system date to endorsement date <tc16773>")
	public void user_changes_system_date_to_endorsement_date_tc16773() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(endorseDate));
	}

	@When("User validates expected following messages on issue tile")
	public void user_validates_expected_following_messages_on_issue_tile() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $100,000 require Underwriting Approval");

		verify_AnyLabel_IsVisible(driver,
				"Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $50,000 require Underwriting Approval");
		verify_AnyLabel_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyLabel_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
		verify_AnyLabel_IsVisible(driver, "Change in the reserve package requires underwriting approval");
		attachScreenShot(driver);
		wait(2);
	}

	@When("User clicks submit for approval button with underwriter")
	public void user_clicks_submit_for_approval_button_with_underwriter() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}

	@When("User validates 'Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $100,000 require Underwriting Approval' message")
	public void user_validates_message_displayed_on_issue_tile_tc16773() throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $100,000 require Underwriting Approval");
		attachScreenShot(driver);
	}

	@When("User process and completes endorsement and finishes test <tc16773>")
	public void user_process_and_completes_endorsement_and_finishes_test_tc16773() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}

}
