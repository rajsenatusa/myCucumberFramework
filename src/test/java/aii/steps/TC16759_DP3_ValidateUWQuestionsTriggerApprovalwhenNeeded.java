package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16759_DP3_ValidateUWQuestionsTriggerApprovalwhenNeeded extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY - 2);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String DP3App_Form;

	@When("User enters all required information on policy information screen for <tc16759>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16759() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Chester");
		sendText(quote.txtLastName, "Milton");
		sendText(quote.txtBirthDate, "5/23/1990");
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

	@When("User enters all required information on DP3 quote screen for <tc16759>")
	public void User_enters_all_required_information_on_DP3_quote_screen_for_tc16759() {
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
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen for <tc16759>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_for_tc16759() {

		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		 
	}

	@When("User answers all UW questions as No and validates messages for <tc16759>")
	public void User_answers_all_UW_questions_as_No_and_validates_messages_for_tc16759() throws Exception {
		// DP3 Underwriting Questions Chevron was filled here as No

		selectDropdownText(uwquestionsChevron.ho3Question1, "No");// 1
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");// 2
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");// 3
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");// 4
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");// 5
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");// 6
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");// 7
		selectDropdownText(uwquestionsChevron.dp1Question8, "No");// 8
		selectDropdownText(uwquestionsChevron.ho3Question9, "No");// 9
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");// 10
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");// 11
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");// 12
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");// 13
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");// 14
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");// 15
		selectDropdownText(uwquestionsChevron.ho3Question16, "No");// 16
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");// 17
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");// 18
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");// 19
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");// 20
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");// 21
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");// 22
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");// 23
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");// 24
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");// 25
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");// 26
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");// 27
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");// 28
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");// 29

		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(uwquestionsChevron.nextButtonUw);

	}

	@When("User checks error messages when DP3 Underwriting Questions are answered one by one as Yes and validates particular error messages for all questions")
	public void User_checks_error_messages_when_DP3_Underwriting_Questions_are_answered_one_by_one_as_Yes_and_validates_particular_error_messages_for_all_questions()
			throws Exception {
		// DP3 Underwriting Questions Chevron was filled here one by one as Yes

		// Question 1
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");// 1
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 2
		selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");// 2
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver,
				"Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 3
		selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");// 3
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 4
		selectDropdownText(uwquestionsChevron.ho3Question4, "Yes");// 4
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 5
		selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");// 5
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 6
		selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");// 6
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 7
		selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");// 7
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 8
		selectDropdownText(uwquestionsChevron.dp1Question8, "Yes");// 8
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 9
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");// 9
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question9, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 10
		selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");// 10
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 11
		selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");// 11
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 12
		
		wait(2);
		selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");// 12
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 13
		selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");// 13
		selectDropdownText(uwquestionsChevron.questionMatchingLimits, "Yes");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 14
		selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");// 14
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 15
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");// 15
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 16
		selectDropdownText(uwquestionsChevron.ho3Question16, "Yes");// 16
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question16, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 17
		selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");// 17
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 18
		selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");// 18
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 19
		selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");// 19
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 20
		selectDropdownText(uwquestionsChevron.ho3Question20, "Yes");// 20
		selectDropdownText(uwquestionsChevron.questionUnfencedPool, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 21
		selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");// 21
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 22
		selectDropdownText(uwquestionsChevron.ho3Question22, "Yes");// 22
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 23
		selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");// 23
		selectDropdownText(uwquestionsChevron.questionLicensePolicy, "Yes");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver,
				"Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy. ");
				click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 24
		selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");// 24
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 25
		selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");// 25
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 26
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");// 26
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 27
		selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");// 27
		uwquestionsChevron.questionPriorAIICPolicyNumber.sendKeys("GOC0319720-01");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 28
		selectDropdownText(uwquestionsChevron.ho3Question28, "Yes");// 28
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

		// Question 29
		selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");// 29
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.policy);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to no prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		click(dwellingChevron.btnNext);

	}

	@When("User answers all UW questions as Yes and validates messages for <tc16759>")
	public void User_answers_all_UW_questions_as_Yes_and_validates_messages_for_tc16762() throws Exception {
		// DP3 Underwriting Questions Chevron was filled here as Yes

				selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");// 1
				selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");// 2
				selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");// 3
				selectDropdownText(uwquestionsChevron.ho3Question4, "Yes");// 4
				selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");// 5
				selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");// 6
				selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");// 7
				selectDropdownText(uwquestionsChevron.dp1Question8, "Yes");// 8
				selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");// 9
				selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");// 10
				selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");// 11
				selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");// 12
				selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");// 13
				selectDropdownText(uwquestionsChevron.questionMatchingLimits, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");// 14
				selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");// 15
				selectDropdownText(uwquestionsChevron.ho3Question16, "Yes");// 16
				selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");// 17
				selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");// 18
				selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");// 19
				selectDropdownText(uwquestionsChevron.ho3Question20, "Yes");// 20
				selectDropdownText(uwquestionsChevron.questionUnfencedPool, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");// 21
				selectDropdownText(uwquestionsChevron.ho3Question22, "Yes");// 22
				selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");// 23
				selectDropdownText(uwquestionsChevron.questionLicensePolicy, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");// 24
				selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");// 25
				selectDropdownText(uwquestionsChevron.ho3Question26, "Zone V");// 26
				selectDropdownText(uwquestionsChevron.questionFloodProof, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");// 27
				uwquestionsChevron.questionPriorAIICPolicyNumber.sendKeys("GOC0319720-01");
				selectDropdownText(uwquestionsChevron.questionFloodProof, "Yes");// 28
				selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");// 29
				wait(1);
				click(dwellingChevron.btnSave);
				click(dwellingChevron.policy);
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction. ");
				verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
				verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss. ");
				verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
				verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
				verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure. ");
				verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
				verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises. ");
				verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
				verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval. ");
				verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
				attachScreenShot(driver);
				click(uwquestionsChevron.nextButtonUw);
				click(dwellingChevron.btnSave);
				click(uwquestionsChevron.nextButtonUw);
		

	}
	@When("User takes note of the application for <tc16759>")
	public void User_takes_note_of_the_application_for_tc16759() {
		click(reviewChevron.btnFinalize);
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval button for <tc16759>")
	public void user_clicks_submit_for_approval_button_for_tc16759() {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(2);
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		click(closeoutChevron.btnDialogOk);
		wait(3);
	}
	@When("User searches for the application <tc16759>")
	public void User_searches_for_the_application_tc16759() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User verifies messages for <tc16759>")
	public void User_verifies_messages_for_tc16759 () throws Exception {
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises. ");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy. ");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval. ");
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age. ");
		attachScreenShot(driver);
	}
	@When("User verifies messages on Issues tile for <tc16759>")
	public void User_verifies_messages_on_issues_tile_for_tc16762() throws Exception {

		wait(1);
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy.");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy. ");
		wait(1);
		attachScreenShot(driver);
	}

	@When("User verifies messages on Submitter Issues tile for <tc16759>")
	public void User_verifies_messages_on_Submitter_Issues_tile_for_tc16762() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy.");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age.");
		attachScreenShot(driver);

	}
	@When("User verifies Underwriter Clerk messages on Issues tile for <tc16759>")
	public void User_verifies_Underwriter_Clerk_messages_on_Issues_tile_for_tc16759() throws Exception {

		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age.");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to prior indictment or conviction.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to lapse in prior insurance.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy.");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises.");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity.");
		verify_AnyText_IsVisible(driver,
				"Risk is ineligible for coverage due to occupancy.");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage.");
		 
		attachScreenShot(driver);

	}
	@When("User verifies Underwriter Clerk messages on Submitter Issues tile for <tc16759>")
	public void User_verifies_Underwriter_Clerk_messages_on_Submitter_Issues_tile_for_tc16759() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);

	}
	@When("User verifies Standard Agent messages on Submitter Issues tile for <tc16759>")
	public void User_verifies_Standard_Agent_messages_on_Submitter_Issues_tile_for_tc16759() throws Exception {

		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@Then("User issues policy and close unnecessary tabs and completes test <tc16759>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16759() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Test Case Completed!");
	}

}
