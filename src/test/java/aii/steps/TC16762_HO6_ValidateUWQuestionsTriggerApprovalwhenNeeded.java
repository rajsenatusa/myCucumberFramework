package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC16762_HO6_ValidateUWQuestionsTriggerApprovalwhenNeeded extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String app_Tx_Policy_Claim_Num;
	static String QuoteNum;
	static String switchToWindow;
	static String submitForApproval;
	static String AppNummm;

	@When("User enters all required information on policy information screen <tc16762>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16762() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Queen");
		sendText(quote.txtLastName, "Setty");
		sendText(quote.txtBirthDate, "5/23/1932");
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

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc16762>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc16762() {

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

	@When("User enters all required information on HO6 dwelling screen for <tc16762>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_for_tc16762() {

		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User validates Quote Made for <tc16762>")
	public void User_validates_Quote_Made_for_tc16762() throws Exception {

		wait(2);
		verifyQuoteMade(driver);
		getQuotePremium(driver);
		getQuoteNumber(driver);
		wait(2);
	}

	@When("User checks error messages when HO6 Underwriting Questions are answered one by one as Yes and validates particular error messages for all questions")
	public void User_checks_error_messages_when_HO6_Underwriting_Questions_are_answered_one_by_one_as_Yes_and_validates_particular_error_messages_for_all_questions()
			throws Exception {

		// HO6 Underwriting Questions Chevron was filled here

		selectDropdownText(uwquestionsChevron.ho3Question1, "No");// 1
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");// 2
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");// 3
		selectDropdownText(uwquestionsChevron.ho6Question4, "No");// 4
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");// 5
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");// 6
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");// 7
		selectDropdownText(uwquestionsChevron.ho6Question8, "No");// 8
		selectDropdownText(uwquestionsChevron.ho3Question9, "No");// 9
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");// 10
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");// 11
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");// 12
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");// 13
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");// 14
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");// 15
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");// 16
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");// 17
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");// 18
		selectDropdownText(uwquestionsChevron.ho6Question19, "No");// 19
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");// 20
		selectDropdownText(uwquestionsChevron.ho6Question21, "No");// 21
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");// 22
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");// 23
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");// 24
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");// 25
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");// 26
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");// 27
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");// 28

		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);

		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 1
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");// 1
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 2
		selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");// 2
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver,
				"Underwriting approval required due to applicant(s) prior foreclosure/bankruptcy. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 3
		selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");// 3
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 4
		selectDropdownText(uwquestionsChevron.ho6Question4, "Yes");// 4
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question4, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 5
		selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");// 5
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior carrier cancellation. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 6
		selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");// 6
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 7
		selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");// 7
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 8
		selectDropdownText(uwquestionsChevron.ho6Question8, "Yes");// 8
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question8, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 9
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");// 9
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question9, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 10
		selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");// 10
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Lapse in prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 11
		selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");// 11

		verify_AnyText_IsVisible(driver,
				"Own or care for a Pit Bull, Pit Bull Terrier, Staffordshire Terrier, Wolf, Wolf Hybrid, or any mix of these breeds?*");
		verify_AnyText_IsVisible(driver, "Own or care for any animal with a bite history?* ");
		selectDropdownText(uwquestionsChevron.questionBreed1, "Yes");
		selectDropdownText(uwquestionsChevron.questionBiteHistory, "Yes");
		selectDropdownText(uwquestionsChevron.questionExoticAnimals, "Yes");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 12
		selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");// 12
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 13
		selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");// 13

		verify_AnyText_IsVisible(driver, "Currently have a policy with matching liability limits?*");
		selectDropdownText(uwquestionsChevron.questionMatchingLimits, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to recreational vehicles without matching liability limits ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 14
		selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");// 14
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 15
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");// 15
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 16
		selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");// 16
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 17
		selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");// 17
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 18
		selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");// 18
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 19
		selectDropdownText(uwquestionsChevron.ho6Question19, "Yes");// 19
		verify_AnyText_IsVisible(driver, "If yes, is swimming pool, hot tub or spa completely enclosed?* ");
		selectDropdownText(uwquestionsChevron.questionUnfencedPool, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question19, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 20
		selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");// 20
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 21
		selectDropdownText(uwquestionsChevron.ho6Question21, "Yes");// 21
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question21, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 22
		selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");// 22
		verify_AnyText_IsVisible(driver,
				"Does the  applicant have an active Florida \"Family Child Care Home Certificate of License\" and a Commercial General Liability policy?* ");
		selectDropdownText(uwquestionsChevron.questionFloodProof, "Yes");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 23
		selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");// 23
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 24
		selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");// 24
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 25
		selectDropdownText(uwquestionsChevron.ho3Question26, "Zone A");// 25
		verify_AnyText_IsVisible(driver,
				"Does the agency retain proof of an active flood policy, or a signed flood waiver?* ");
		selectDropdownText(uwquestionsChevron.questionFloodProof, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver,
				"Agency must retain a copy of an active flood policy or upload a copy of a signed flood waiver prior to binding. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 26
		selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");// 26
		verify_AnyText_IsVisible(driver, "Prior AI Policy Number:* ");
		uwquestionsChevron.questionPriorAIICPolicyNumber.sendKeys("GOC0319720-01");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 27
		selectDropdownText(uwquestionsChevron.ho3Question28, "Yes");// 27
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);

		// Question 28
		selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");// 28
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "No prior insurance is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(uwquestionsChevron.nextButtonUw);
		
		
		}
		@When("User answers as Yes all UW questions for <tc16762>")
		public void User_answers_as_Yes_all_UW_questions_for_tc16762() throws Exception {

					
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");// 1
		selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");// 2
		selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");// 3
		selectDropdownText(uwquestionsChevron.ho6Question4, "Yes");// 4
		selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");// 5
		selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");// 6
		selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");// 7
		selectDropdownText(uwquestionsChevron.ho6Question8, "Yes");// 8
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");// 9
		selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");// 10
		selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");// 11
		selectDropdownText(uwquestionsChevron.questionBreed1, "Yes");
		selectDropdownText(uwquestionsChevron.questionBiteHistory, "Yes");
		selectDropdownText(uwquestionsChevron.questionExoticAnimals, "Yes");
		selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");// 12
		selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");// 13
		selectDropdownText(uwquestionsChevron.questionMatchingLimits, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");// 14
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");// 15
		selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");// 16
		selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");// 17
		selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");// 18
		selectDropdownText(uwquestionsChevron.ho6Question19, "Yes");// 19
		selectDropdownText(uwquestionsChevron.questionUnfencedPool, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");// 20
		selectDropdownText(uwquestionsChevron.ho6Question21, "Yes");// 21
		selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");// 22
		selectDropdownText(uwquestionsChevron.questionFloodProof, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");// 23
		selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");// 24
		selectDropdownText(uwquestionsChevron.ho3Question26, "Zone A");// 25
		selectDropdownText(uwquestionsChevron.questionFloodProof, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");// 26
		uwquestionsChevron.questionPriorAIICPolicyNumber.sendKeys("GOC0319720-01");
		selectDropdownText(uwquestionsChevron.ho3Question28, "Yes");// 27
		selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");// 28
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		
		}

		@When("User validates error messages in Policy chevron for <tc16762>")
		public void User_validates_error_messages_in_Policy_chevron_for_tc16762() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure/bankruptcy.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior carrier cancellation.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Lapse in prior insurance is ineligible for coverage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy.");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		
		}

		@When("User checks application dwelling screen and finalizes transaction for <tc16762>")
		public void User_checks_application_dwelling_screen_and_finalizes_transaction_for_tc16762() throws Exception {

			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddStoryOfUnit, "2");
			wait(1);
			click(dwellingChevron.btnSave);
			click(reviewChevron.btnReview);
			wait(2);
			click(reviewChevron.btnFinalize);
			wait(2);

}
}