package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC16800_AIB_AIBAgentChangeDateTransaction extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String ApplicationNum;

	@When("User enters all required information on policy information screen <tc16800>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16800() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
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

	@When("User enters all required information on AIB quote screen for <tc16800>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc16800() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects liability coverage on quote screen for <tc16800>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc16800() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$100,000/$300,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "No Coverage");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "Yes");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "60 days");
		click(dwellingChevron.btnSave);
		wait(5);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User adds operator information on quote screen <tc16800>")
	public void user_adds_operator_information_on_quote_screen_tc16800() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "S120120952900");
		selectDropdownText(aibChevron.ddBoatExperience, "5+");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters all required information on AIB boat dwelling screen for <tc16800>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc16800() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, ConfigsReader.getProperty("boathinnumber"));
		selectDropdownText(aibChevron.ddBoatMake, ConfigsReader.getProperty("boatmake"));
		sendText(aibChevron.txtBoatModel, ConfigsReader.getProperty("boatmodel"));
		sendText(aibChevron.txtBoatPurchDate, dtf.format(currentDate));
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, "42500");
		selectDropdownText(aibChevron.ddBoatHullType, "Cruiser");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "26");
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, "Outboard");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "60 or less mph");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User takes note of the application for <tc16800>")
	public void user_takes_note_of_the_application__number_for_tc16800() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc16800>")
	public void user_searches_application_for_tc16800() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User issues policy and close unnecessary tabs and taking note of the policy number <tc16800>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16800() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("AIB NB policy has been created successfully");
		} else {
			System.out.println("AIB policy creation failed!");
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

	@When("User searches for Policy Number for <tc16800>")
	public void user_searches_for_policy_number_for_tc16800() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects current date plus 61 days as new effective date <tc16800>")
	public void User_selects_current_date_plus_61_days_as_new_effective_date_tc16800() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(61)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@And("User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' error message visible")
	public void User_validates_maximum_change_date_allowed_is_60_days_you_will_need_to_rewrite_this_policy_error_message_visible()
			throws Exception {
		verify_AnyLabel_IsVisible(driver,
				"Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		attachScreenShot(driver);
	}

	@And("User selects current date plus 60 days as new effective date <tc16800>")
	public void User_selects_current_date_plus_60_days_as_new_effective_date_tc16800() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(60)));
		wait(5);
		click(historyChevron.btnStart);
		wait(6);
		click(historyChevron.btnStart);
		wait(6);
	}

	@When("User validates 'Requested effective date change requires underwriting review' text is visible <tc16800>")
	public void user_validates_requested_effective_date_change_requires_underwriting_review_text_is_visible_tc16800()
			throws Exception {
		verify_AnyLabel_IsVisible(driver, "Requested effective date change requires Underwriting review");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User takes note of the second application number <tc16800>")
	public void user_takes_note_of_the_second_application__number_tc16800() throws Exception {
		try {
			ApplicationNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + ApplicationNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the latest application <tc16800>")
	public void user_searches_for_the_latest_application_tc16800() throws Exception {
		sendText(dashboard.txtSearchBar, ApplicationNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User process tx and validates expected messages and finishes test <tc16800>")
	public void user_process_tx_and_validates_expected_messages_finishes_test_tc16800() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		verify_AnyText_IsVisible(driver, "Change Date");
		verify_AnyLabel_IsVisible(driver, "Change Effective Date from " + dtf.format(currentDate) + " to "
				+ dtf.format(currentDate.plusDays(60)));
		Hooks.scenario.log("Test Case Completed!");
	}
}
