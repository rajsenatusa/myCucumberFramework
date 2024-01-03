package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16766_HO4_ValidateUWQuestionsTriggerApprovalwhenNeeded extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <tc16766>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16766() {

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
	@When("User enters all required information on HO4 quote screen <tc16766>")
	public void user_enters_all_required_information_on_ho4_quote_screen_tc16766() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		//sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, "No");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen <tc16766>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_tc16766() {

//		sendText(dwellingChevron.txtYearConstruction, "2023");
//		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "75000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User answers all underwriting questions as NO except Question 9")
	public void user_answers_all_underwriting_questions_as_No_except_question_9() throws Exception {

		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question14, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
//		// Application Dwelling information was filled here
//
//		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
//		selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
//		selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
//		wait(2);
	}
	@When("User answers HO4 UW Question 1 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_1_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 2 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_2_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 3 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_3_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 4 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_4_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 5 as Yes and validates 'Underwriting referral required due to prior carrier cancellation' NOT visible")
	public void user_answers_HO4_UW_Question_5_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 6 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_6_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		selectDropdownText(uwquestionsChevron.ho3Question12, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to exotic animals");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 7 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_7_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyLabel_IsVisible(driver, "7. Does the applicant(s)/occupant(s) have separate liability coverage with the same limit as provided on this policy*");
		selectDropdownText(driver.findElement(By.name("Question_LiabilityCoverage")),"No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver,"Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(driver.findElement(By.name("Question_LiabilityCoverage")), "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver,"Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_NotVisible(driver, "7. Does the applicant(s)/occupant(s) have separate liability coverage with the same limit as provided on this policy*");
	}
	@When("User answers HO4 UW Question 8 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_8_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 9 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_9_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 10 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_10_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to existing damage");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 11 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_11_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 12 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_12_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho4Question12, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to Business Activity");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 13 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_13_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho4Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible due to Business Activity");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho4Question12, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to Business Activity");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers HO4 UW Question 14 as Yes and validates expected issue messages")
	public void user_answers_HO4_UW_Question_14_as_Yes_and_validates_expected_issue_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		selectDropdownText(uwquestionsChevron.ho4Question14, "Yes");
		selectDropdownText(uwquestionsChevron.ho4Question12, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyLabel_IsVisible(driver, "Prior AI Policy Number:*");
		sendText(driver.findElement(By.id("Question_PriorAIICPolicyNumber")), "A123456789");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible due to Business Activity");
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(uwquestionsChevron.ho4Question14, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible due to Business Activity");
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User answers all HO4 Questions as Yes except Question 9 and validates expected issue messages")
	public void user_answers_all_HO4_UW_Questions_as_Yes_except_Question_9_and_validates_expected_issue_messages() throws Exception {
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question12, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.name("Question_LiabilityCoverage")),"No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question12, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question14, "Yes");
		wait(1);
		sendText(driver.findElement(By.id("Question_PriorAIICPolicyNumber")), "A123456789");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to prior indictment or conviction");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to prior carrier cancellation");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to exotic animals");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to existing damage");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure");
		verify_AnyText_IsVisible(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to occupancy");
		verify_AnyText_IsVisible(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits");
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to Business Activity");
		attachScreenShot(driver);
		click(dwellingChevron.btnNext);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		selectDropdownText(dwellingChevron.ddStoryOfUnit, "2");
		wait(2);
	}
	@When("User finalizes transaction and validates expected issue messages on closeout screen")
	public void user_finalizes_transaction_and_validates_expected_issue_messages_on_closeout_screen() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
		//Verify the following UW messages will trigger
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "2");
		scrollToAnyField(driver, "Quote/Policy");
	}
	@When("User takes note of the application number <tc16766>")
	public void user_takes_note_of_the_application__number_tc16766() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User clicks Submit for Approval button <tc16766>")
	public void user_clicks_submit_for_approval_button_tc16766() throws Exception {
		sendText(closeoutChevron.txtWorkflowComments, "testtesttesttes");
		click(closeoutChevron.btnSubmitApproval);
		click(closeoutChevron.btnDialogOk);
		wait(2);
	}
	@When("User searches application <tc16766>")
	public void user_searches_application_tc16766() throws Exception {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates expected messages on submitter issues tile <tc16766>")
	public void user_validates_expected_messages_on_submitter_issues_tile_tc16766() throws Exception {
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "2");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@Then("User sets payment type and validates expected messages")
	public void user_sets_payment_type_and_validates_expected_messages_on_() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(1);
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to prior indictment or conviction", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior applicant(s) foreclosure/bankruptcy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to prior carrier cancellation", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to loss history", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to exotic animals", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to existing damage", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to excessive/unusual liability exposure", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required: Proof of active daycare license and commercial liability policy is required prior to binding policy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to occupancy", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible for coverage due to recreational vehicles on premises without a policy with matching liability limits", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Risk is ineligible due to Business Activity", "2");
		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@And("User process tx and validates expected messages and finishes test <tc16766>")
	public void user_process_tx_and_validates_expected_messages_finishes_test_tc16766() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
