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

public class TC16765_AIB_ValidateUWQuestionsTriggerApprovalwhenNeeded extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16765>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16765() {

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

	@When("User enters all required information on AIB quote screen for <tc16765>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc16765() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
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

	@When("User selects liability coverage on quote screen for <tc16765>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc16765() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$50,000/$100,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "$2,000");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		// selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "60 days");
		click(dwellingChevron.btnSave);
		wait(5);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User adds operator information on quote screen <tc16765>")
	public void user_adds_operator_information_on_quote_screen_tc16765() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "S120120952900");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters all required information on AIB boat dwelling screen for <tc16765>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc16765() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		sendText(aibChevron.txtBoatModel, "Boat Model");
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

	@And("User checks error messages when AIB Underwriting Questions answered as Yes and validates 'Response to Underwriting question requires Underwriting approval' message for all questions")
	public void user_checks_error_messages_when_aib_underwriting_questions_as_yes_and_validates_error_message()
			throws Exception {
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion15, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion16, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion20, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion22, "No");

		// Question 1
		wait(2);
		selectDropdownText(uwquestionsChevron.aibQuestion1, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #1 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion1, "No");
		click(dwellingChevron.btnSave);

		// Question 2
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #2");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);

		// Question 3
		selectDropdownText(uwquestionsChevron.gocQuestion3, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #3 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		click(dwellingChevron.btnSave);

		// Question 4
		selectDropdownText(uwquestionsChevron.gocQuestion4, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #4 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		click(dwellingChevron.btnSave);

		// Question 5
		selectDropdownText(uwquestionsChevron.aibQuestion5, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #5 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion5, "No");
		click(dwellingChevron.btnSave);

		// Question 6
		selectDropdownText(uwquestionsChevron.gocQuestion6, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #6");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		click(dwellingChevron.btnSave);

		// Question 7
		selectDropdownText(uwquestionsChevron.aibQuestion7, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #7 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion7, "No");
		click(dwellingChevron.btnSave);

		// Question 8
		selectDropdownText(uwquestionsChevron.gocQuestion7, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #8 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		click(dwellingChevron.btnSave);

		// Question 9
		selectDropdownText(uwquestionsChevron.gocQuestion8, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #9");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		click(dwellingChevron.btnSave);

		// Question 10
		selectDropdownText(uwquestionsChevron.aibQuestion10, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #10");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion10, "No");
		click(dwellingChevron.btnSave);

		// Question 11
		selectDropdownText(uwquestionsChevron.aibQuestion11, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #11");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion11, "No");
		click(dwellingChevron.btnSave);

		// Question 12
		selectDropdownText(uwquestionsChevron.aibQuestion12, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #12");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion12, "No");
		click(dwellingChevron.btnSave);

		// Question 13
		selectDropdownText(uwquestionsChevron.aibQuestion13, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #13");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion13, "No");
		click(dwellingChevron.btnSave);

		// Question 14
		selectDropdownText(uwquestionsChevron.aibQuestion14, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #14");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion14, "No");
		click(dwellingChevron.btnSave);

		// Question 15
		selectDropdownText(uwquestionsChevron.aibQuestion15, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #15");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion15, "No");
		click(dwellingChevron.btnSave);

		// Question 16
		selectDropdownText(uwquestionsChevron.aibQuestion16, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #16 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion16, "No");
		click(dwellingChevron.btnSave);

		// Question 17
		selectDropdownText(uwquestionsChevron.aibQuestion17, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #17 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion17, "No");
		click(dwellingChevron.btnSave);

		// Question 18
		selectDropdownText(uwquestionsChevron.aibQuestion18, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #18");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion18, "No");
		click(dwellingChevron.btnSave);

		// Question 19
		selectDropdownText(uwquestionsChevron.aibQuestion19, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Additional Insured of type Additional Owner must be added");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion19, "No");
		click(dwellingChevron.btnSave);

		// Question 20
		selectDropdownText(uwquestionsChevron.aibQuestion20, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #20");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion20, "No");
		click(dwellingChevron.btnSave);

		// Question 21
		selectDropdownText(uwquestionsChevron.aibQuestion21, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #21");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion21, "No");
		click(dwellingChevron.btnSave);

		// Question 22
		selectDropdownText(uwquestionsChevron.aibQuestion22, "Yes");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #22 requires Underwriting approval");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.aibQuestion22, "No");
		click(dwellingChevron.btnSave);

		wait(2);
	}

	@And("User sets all UW questions as Yes and validates all error messages displayed on policy chevron")
	public void user_sets_all_UW_questions_as_yes() throws Exception {

		selectDropdownText(uwquestionsChevron.aibQuestion1, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		selectDropdownText(uwquestionsChevron.gocQuestion3, "Yes");
		selectDropdownText(uwquestionsChevron.gocQuestion4, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion5, "Yes");
		selectDropdownText(uwquestionsChevron.gocQuestion6, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion7, "Yes");
		selectDropdownText(uwquestionsChevron.gocQuestion7, "Yes");
		selectDropdownText(uwquestionsChevron.gocQuestion8, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion10, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion11, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion12, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion13, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion14, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion15, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion16, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion17, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion18, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion19, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion20, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion21, "Yes");
		selectDropdownText(uwquestionsChevron.aibQuestion22, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(4);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(2);
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #1 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #2");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #3 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #4 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #5 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #6");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #7 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #8 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #9");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #10");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #11");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #12");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #13");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #14");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #15");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #16 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #17 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #18");
		verify_AnyText_IsVisible(driver, "Additional Insured of type Additional Owner must be added");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #20");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #21");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #22 requires Underwriting approval");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		waitImp(4);
	}

	@And("User validates error messages displayed on closeout Screen")
	public void user_validates_error_messages_displayed_on_closeout_Screen() throws Exception {

		verify_AnyText_IsVisible(driver, "Response to Underwriting question #1 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #2");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #3 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #4 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #5 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #6");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #7 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #8 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #9");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #10");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #11");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #12");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #13");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #14");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #15");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #16 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #17 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #18");
		verify_AnyText_IsVisible(driver, "Additional Insured of type Additional Owner must be added");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #20");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #21");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #22 requires Underwriting approval");
		scrollToAnyField(driver, "Quote/Policy");
		attachScreenShot(driver);
	}

	@When("User takes note of the application for <tc16765>")
	public void user_takes_note_of_the_application__number_for_tc16765() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc16765>")
	public void user_searches_application_for_tc16765() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User validates error messages displayed on closeout screen with underwriter")
	public void user_validates_error_messages_displayed_on_closeout_Screen_with_UW_tc16765() throws Exception {

		verify_AnyText_IsVisible(driver, "Response to Underwriting question #1 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #2");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #3 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #4 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #5 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #6");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #7 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #8 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #9");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #10");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #11");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #12");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #13");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #14");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #15");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #16 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #17 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #18");
		verify_AnyText_IsVisible(driver, "Additional Insured of type Additional Owner must be added");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #20");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #21");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #22 requires Underwriting approval");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}

	@When("User clicks submit for approval as underwriter")
	public void user_clicks_submit_for_approval_as_underwriter() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}

	@And("User validates error messages displayed on submitter issues tile")
	public void user_validates_error_messages_displayed_on_submitter_issues_tile() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #2");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #6");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #7 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #9");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #10");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #11");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #12");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #13");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #14");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #15");
		verify_AnyText_IsVisible(driver, "Response to Underwriting question #17 requires Underwriting approval");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #20");
		verify_AnyText_IsVisible(driver, "Risk not eligible due to response to Underwriting question #21");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}

	@Then("User issues policy and close unnecessary tabs and completes test <tc16765>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16765() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
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
		Hooks.scenario.log("Test Case Completed!");
	}
}
