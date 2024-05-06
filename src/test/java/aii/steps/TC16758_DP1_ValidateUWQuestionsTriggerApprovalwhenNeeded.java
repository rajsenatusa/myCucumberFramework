package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16758_DP1_ValidateUWQuestionsTriggerApprovalwhenNeeded extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <tc16758>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16758() {

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
	@When("User enters all required information on DP1 quote screen <tc16758>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc16758() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		//sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <tc16758>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc16758() throws Exception {

//		sendText(dwellingChevron.txtYearConstruction, "2023");
//		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "15000");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers all DP1 UW questions as no and validates 'Risk is ineligible for coverage due to occupancy' message")
	public void user_answers_all_dp1_uw_questions_as_no_and_validates_risk_is_ineligible_for_coverage_due_to_occupancy_message() throws Exception {
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");

		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		//click(uwquestionsChevron.nextButtonUw);
	}
	@When("User answers DP1 UW Question 1 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_1_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 2 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_2_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 3 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_3_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 4 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_4_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question4, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 5 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_5_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 6 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_6_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 7 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_7_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage", "2");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 8 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_8_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.dp1Question8, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 9 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_9_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question9, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 10 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_10_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 11 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_11_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 12 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_12_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 13 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_13_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");
		verify_AnyLabel_IsVisible(driver, "Currently have a policy with matching liability limits?*");
		selectDropdownText(driver.findElement(By.id("Question_MatchingLimits")), "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		selectDropdownText(driver.findElement(By.id("Question_MatchingLimits")), "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to recreational vehicles without matching liability limits");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		verify_AnyText_NotVisible(driver, "Currently have a policy with matching liability limits?*");
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 14 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_14_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 15 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_15_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 16 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_16_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 17 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_17_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 18 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_18_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 19 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_19_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question20, "Yes");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "If yes, is swimming pool, hot tub or spa completely enclosed?*");
		selectDropdownText(driver.findElement(By.name("Question_UnfencedPool")), "No");	
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);	
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(driver.findElement(By.name("Question_UnfencedPool")), "Yes");	
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 20 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_20_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 21 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_21_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question22, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 22 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_22_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Does the  applicant have an active Florida \"Family Child Care Home Certificate of License\" and a Commercial General Liability policy?*");
		selectDropdownText(driver.findElement(By.name("Question_LicensePolicy")),"No");		
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to home day care on premises");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(driver.findElement(By.name("Question_LicensePolicy")), "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises");
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_NotVisible(driver, "Does the  applicant have an active Florida \"Family Child Care Home Certificate of License\" and a Commercial General Liability policy?*");
	}
	@When("User answers DP1 UW Question 23 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_23_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to sinkhole activity");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 24 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_24_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 25 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_25_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question26, "Zone A");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Does the agency retain proof of an active flood policy, or a signed flood waiver?*");
		selectDropdownText(driver.findElement(By.name("Question_FloodProof")), "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Agency must retain a copy of an active flood policy or upload a copy of a signed flood waiver prior to binding");	
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(driver.findElement(By.name("Question_FloodProof")), "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		verify_AnyText_NotVisible(driver, "Does the agency retain proof of an active flood policy, or a signed flood waiver?*");
	}
	@When("User answers DP1 UW Question 26 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_26_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Prior AI Policy Number:*");
		sendText(driver.findElement(By.id("Question_PriorAIICPolicyNumber")), "GOC0319720-01");	
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_NotVisible(driver, "Prior AI Policy Number:*");
	}
	@When("User answers DP1 UW Question 27 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_27_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question28, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage", "2");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible for coverage.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");	
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers DP1 UW Question 28 as Yes and validates expected issue messages")
	public void user_answers_DP1_UW_Question_28_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User answers DP1 all UW Questions as Yes and validates expected issue messages")
	public void user_answers_DP1_all_UW_Questions_as_Yes_and_validates_expected_issue_messages() throws Exception {
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");
		wait(1);
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question4, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.dp1Question8, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Question_MatchingLimits")), "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.name("Question_UnfencedPool")), "Yes");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.name("Question_LicensePolicy")), "Yes");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "Zone V");
		wait(1);
		selectDropdownText(driver.findElement(By.name("Question_FloodProof")), "No");
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "Yes");
		wait(1);
		sendText(driver.findElement(By.id("Question_PriorAIICPolicyNumber")), "GOC0319720-01");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "Yes");
		
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "3");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisible(driver, "Agency must retain a copy of an active flood policy or upload a copy of a signed flood waiver prior to binding");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage.");
		attachScreenShot(driver);
		
		click(dwellingChevron.btnNext);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User sets roof material finalizes transactions and validates expected issue messages")
	public void user_sets_roof_material_finalizes_transactions_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises");
		click(reviewChevron.btnFinalize);
		wait(1);
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage.", "1");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to prior flood loss");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage.", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "3");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to animal exposure");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior property foreclosure");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to existing damage");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisible(driver, "Underwriting approval required due to business on premises");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisible(driver, "Agency must retain a copy of an active flood policy or upload a copy of a signed flood waiver prior to binding");
		verify_AnyText_IsVisible(driver, "Prior AI Policy requires Underwriting Approval.");
		scrollToAnyField(driver, "Quote/Policy");
		attachScreenShot(driver);
	}
	@When("User takes note of the application for <tc16758>")
	public void User_takes_note_of_the_application_for_tc16758() {
		click(reviewChevron.btnFinalize);
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval button for <tc16758>")
	public void user_clicks_submit_for_approval_button_for_tc16758() {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(2);
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		click(closeoutChevron.btnDialogOk);
		wait(3);
	}
	@When("User searches for the application <tc16758>")
	public void User_searches_for_the_application_tc16758() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User submits for approval as UW <tc16758>")
	public void user_clicks_submit_for_approval_button_as_UW_tc16758() {
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}
	@When("User validates all expected issue messages <tc16758>")
	public void User_validates_all_expected_issue_messages_tc16758() throws Exception {
		verify_AnyText_IsVisible(driver, "Personal Liability not available when child and/or adult day care on premises");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage.", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting approval required due to applicant(s) prior foreclosure / bankruptcy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting approval required due to prior flood loss", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "3");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to animal exposure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior property foreclosure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting approval required due to existing damage", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting approval required due to business on premises", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to sinkhole activity", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Agency must retain a copy of an active flood policy or upload a copy of a signed flood waiver prior to binding", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Prior AI Policy requires Underwriting Approval.", "1");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@Then("User issues policy and close unnecessary tabs and completes test <tc16758>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16758() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
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
		Hooks.scenario.log("Test Case Completed!");
	}
}
