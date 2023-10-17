package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16667_GOC_ValidateUWQuestionsTriggerApprovalWhenNeeded extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16667>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16667() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Aaron");
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

	@When("User enters all required information on GOC quote screen <tc16667>")
	public void user_enters_all_required_information_on_goc_quote_screen_tc16667() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "DO NOT USE INSURANCE SCORE");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on GOC golfcart screen for <tc16667>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_tc16667() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$2,500");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$20,000/$40,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$100");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$100");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <tc16667>")
	public void user_enters_driver_information_on_driver_screen_tc16667() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <tc16667>")
	public void user_enters_vehicles_information_on_vehicles_screen_tc16667() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2019");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "4523");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		waitImp(4);
		click(reviewChevron.btnReview);
		waitImp(3);
	}

	@When("User checks error messages when Goc Underwriting Questions answered as Yes and validates particular error messages for all questions")
	public void user_checks_error_messages_when_GOC_UW_questions_answered_as_yes_and_validates_particular_error_messages() throws Exception {

		// GOC Underwriting Questions Chevron was filled here

		selectDropdownText(uwquestionsChevron.gocQuestion1, "No"); //1
		selectDropdownText(uwquestionsChevron.ho3Question1, "No"); //2
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No"); //3
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No"); //4
		selectDropdownText(uwquestionsChevron.gocQuestion5, "No"); //5
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No"); //6
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No"); //7
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No"); //8
		selectDropdownText(uwquestionsChevron.gocQuestion9, "No"); //9
		selectDropdownText(uwquestionsChevron.gocQuestion10, "No"); //10
		selectDropdownText(uwquestionsChevron.gocQuestion11, "No"); //11
		selectDropdownText(uwquestionsChevron.gocQuestion12, "No"); //12
		
		//Question 1
		selectDropdownText(uwquestionsChevron.gocQuestion1, "Yes");
		verify_AnyLabel_IsVisible(driver, "Policy type*");
		verify_AnyLabel_IsVisible(driver, "Operator name*");
		verify_AnyLabel_IsVisible(driver, "Reason for declination, cancellation or non-renewal*");
		sendText(driver.findElement(By.id("Question_InsuredDecline2")), "XYZ");
		sendText(driver.findElement(By.id("Question_InsuredDecline3")), "Operator");
		sendText(driver.findElement(By.id("Question_InsuredDecline4")), "Other");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to coverage history");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion1, "No");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Underwriting referral required due to coverage history");
		
		//Question 2
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 3
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion3, "Yes"); //3
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No"); //3
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Underwriting referral required");
		
		//Question 4
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion4, "Yes"); //4
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No"); //4
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Underwriting referral required");
		
		//Question 5
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion5, "Yes"); //5
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion5, "No"); //5
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 6
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion6, "Yes"); //6
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No"); //6
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 7
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion7, "Yes"); //7
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Operator name*");
		verify_AnyLabel_IsVisible(driver, "Explanation of impairment*");
		sendText(driver.findElement(By.id("Question_OperatorImpairment2")), "OperSeven");
		sendText(driver.findElement(By.id("Question_OperatorImpairment3")), "Impair");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No"); //7
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Underwriting referral required");
		
		//Question 8
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion8, "Yes"); //8
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No"); //8
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 9
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion9, "Yes"); //9
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion9, "No"); //9
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 10
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion10, "Yes"); //10
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion10, "No"); //10
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 11
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion11, "Yes"); //11
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion11, "No"); //11
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_NotVisible(driver, "Risk is ineligible");
		
		//Question 12
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.gocQuestion12, "No"); //12
	}
	
	@When("User answers as Yes all UW questions")
	public void user_answers_as_Yes_all_UW_questions() throws Exception {
		selectDropdownText(uwquestionsChevron.gocQuestion1, "Yes"); //1
		sendText(driver.findElement(By.id("Question_InsuredDecline2")), "XYZ");
		sendText(driver.findElement(By.id("Question_InsuredDecline3")), "Operator");
		sendText(driver.findElement(By.id("Question_InsuredDecline4")), "Other");
		click(dwellingChevron.btnSave);
		waitImp(3);
		
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes"); //2
		selectDropdownText(uwquestionsChevron.gocQuestion3, "Yes"); //3
		selectDropdownText(uwquestionsChevron.gocQuestion4, "Yes"); //4
		selectDropdownText(uwquestionsChevron.gocQuestion5, "Yes"); //5
		selectDropdownText(uwquestionsChevron.gocQuestion6, "Yes"); //6
		selectDropdownText(uwquestionsChevron.gocQuestion7, "Yes"); //7
		sendText(driver.findElement(By.id("Question_OperatorImpairment2")), "OperSeven");
		sendText(driver.findElement(By.id("Question_OperatorImpairment3")), "Impair");
		click(dwellingChevron.btnSave);
		waitImp(3);
		
		selectDropdownText(uwquestionsChevron.gocQuestion8, "Yes"); //8
		selectDropdownText(uwquestionsChevron.gocQuestion9, "Yes"); //9
		selectDropdownText(uwquestionsChevron.gocQuestion10, "Yes"); //10
		selectDropdownText(uwquestionsChevron.gocQuestion11, "Yes"); //11
		selectDropdownText(uwquestionsChevron.gocQuestion12, "Yes"); //12
		click(dwellingChevron.btnSave);
		waitImp(3);
		attachScreenShot(driver);
		click(policyChevron.btnPolicyChevronLink);
		waitImp(3);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to coverage history");
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
	}
	@When("User validates expected error messages displayed on closeout Screen")
	public void user_validates_expected_error_messages_displayed_on_closeout_Screen() throws Exception {
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to coverage history");
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
		scrollToAnyField(driver, "Quote/Policy");
		attachScreenShot(driver);
	
	}
	@When("User takes note of the application for <tc16667>")
	public void user_takes_note_of_the_application__number_for_tc16667() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <tc16667>")
	public void user_searches_application_for_tc16667() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates expected error messages displayed on Underwriter closeout screen")
	public void user_validates_expected_error_messages_displayed_on_Underwriter_closeout_screen() throws Exception {
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to coverage history");
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		verify_AnyText_IsVisible(driver, "Underwriting referral required");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@When("User validates 'Risk is ineligible' message on closeout Screen")
	public void user_validates_Risk_is_ineligible_message_on_closeout_Screen() throws Exception {
		verify_AnyText_IsVisible(driver, "Risk is ineligible");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@Then("User issues policy and close unnecessary tabs and completes test <tc16667>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16667() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("GOC NB policy has been created successfully");
		} else {
			System.out.println("GOC policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
	
}
