package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC16767_UMB_AgentAppUWQuestionsValidation extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@And("User validates that HO4 policy has been created successfully and takes note of the policy number <tc16767>")
	public void user_validates_that_ho4_policy_has_been_created_successfully_tc16767() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("Policy Creation failed!");
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
	@When("User searches for the policy number <tc16767>")
	public void user_searches_policy_for_tc16767() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User answers previous policy written with AIIG questions <tc16767>")
	public void user_answers_previous_policy_written_with_aiig_questions_tc16767() throws Exception {
	
		clickTab(policyChevron.ddPolicyWrittenAiig);
		verify_AnyLabel_IsVisible(driver, "Expiration Date*");
		verify_AnyLabel_IsVisible(driver, "policy written with American Integrity?*");
		verify_AnyLabel_IsVisible(driver, "Does the agent maintain the underlying automobile policy?*");
		getAnyDropDownOptions(driver, "HOWithAIIGInd");
		getAnyDropDownOptions(driver, "AutoWithAgentInd");
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "No");
		click(policyChevron.btnNext);
		wait(2);
	}
	@When("User enters all required information on UMB personal liability screen <tc16767>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_tc16767() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, "1,000,000");
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, "1,000,000");
		sendText(umbrellaChevron.txtNumberOfAuto, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(umbrellaChevron.ddLiabilityResidenceAtLeast500k, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
//		click(reviewChevron.btnReview);
//		wait(3);
	}
	@When("User adds underlying policy in personal liability chevron <tc16767>")
	public void user_adds_underlying_policy_in_personal_liability_chevron_tc16767() {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Property and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, policyNum);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(umbrellaChevron.ddSelectPolicyWithAI, "Yes");
		wait(1);
		selectDropdownText(umbrellaChevron.ddSetExposureType, "Primary Residence");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User adds underlying auto policy in personal liability chevron <tc16767>")
	public void user_adds_underlying_auto_policy_in_personal_liability_chevron_tc16767() {
		driver.findElement(By.id("Return")).click();
		wait(2);
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Vehicle and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, "A123456789");
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(driver.findElement(By.id("Location.UnderlyingPolicyEffectiveDt")) , dtf.format(currentDate));
		sendText(driver.findElement(By.id("Location.UnderlyingPolicyExpirationDt")) , dtf.format(currentDate.plusYears(1)));
		sendText(driver.findElement(By.id("Location.UnderlyingCarrierName")),  "Test Company");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User adds exposure in personal liability chevron <tc16767>")
	public void user_adds_exposure_in_personal_liability_chevron_tc16767() throws Exception {
		driver.findElement(By.id("Return")).click();
		wait(2);
		clickOnAnyLink(driver, "Add Exposure");
		wait(2);
		selectDropdownText(driver.findElement(By.id("Risk.ExposureTypeCd")), "Automobile");
		wait(1);
		sendText(driver.findElement(By.id("GLClass.EYear")), "2019");
		sendText(driver.findElement(By.id("GLClass.EMake")) , "Honda");
		sendText(driver.findElement(By.id("GLClass.EModel")) , "Civic");
		sendText(driver.findElement(By.id("GLClass.EVehIdentificationNumber")) , "VIN123123123");
		sendText(driver.findElement(By.id("GLClass.ECC")) , "2500");
		sendText(driver.findElement(By.id("GLClass.UnderlyingCombinedSingleLimit")) , "500000");
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(driver.findElement(By.id("GLClass.UnderlyingUMUIMCSLOLimit")) , "500000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User adds driver and do UI validations")
	public void user_adds_driver_and_do_UI_validations() throws Exception {
		driver.findElement(By.id("Return")).click();
		wait(2);
		click(policyChevron.btnNext);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Driver List");
		verify_AnyfirstText_IsDisplayed(driver, "Non-Driver List");
		driver.findElement(By.name("AddDriver")).click();
		sendText(driver.findElement(By.id("DriverInfo.LicenseDt")), "05/06/2018");
		sendText(driver.findElement(By.id("DriverInfo.LicenseNumber")), "FLI5214");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Motor Vehicle Violations");
		verify_AnyLabel_IsVisible(driver, "Add Motor Vehicle Violations");
		driver.findElement(By.id("Return")).click();
		wait(2);
	}
	@When("User clicks add non-driver list")
	public void user_clicks_add_non_driver_list() throws Exception {
		driver.findElement(By.id("AddNon-Driver")).click();
		driver.findElement(By.id("Return")).click();
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnNext);
		wait(2);
		click(policyChevron.btnNext);
		wait(2);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User validates 'Application has been created, but has Errors' 'Underwriting Questions Required ' labels are visible")
	public void user_validates_Application_has_been_created_buthaserrors_uw_questions_required_labels_are_Visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Application has been created, but has Errors");
		verify_AnyLabel_IsVisible(driver, "Underwriting Questions Required ");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnNext);
		wait(2);
	}
	@When("User creates UMB application <tc16767>")
	public void user_creates_umb_application_tc16767() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}
	@When("User answers all underwriting questions as NO for UMB <tc16767>")
	public void user_answers_all_underwriting_questions_as_No_for_umb_tc16767() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion1, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion2, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion3, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion4, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion5, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion6, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion7, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion8, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion9, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion10, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion11, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion12, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion13, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion14, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion15, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion16, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion17, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion18, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		attachScreenShot(driver);
		//click(uwquestionsChevron.nextButtonUw);
	}
	@When("User answers UW Question 1 as Yes and validates error messages")
	public void user_answers_UW_Question_1_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion1, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion1, "No");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User answers UW Question 2 as Yes and validates error messages")
	public void user_answers_UW_Question_2_as_Yes_and_validates_error_messages() throws Exception {
		
		selectDropdownText(uwquestionsChevron.umbQuestion2, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Is animal liability excluded on any primary homeowner�s policy?*");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(driver.findElement(By.id("Question_MemberBite1")),"Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron	
		selectDropdownText(uwquestionsChevron.umbQuestion2, "No");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User answers UW Question 3 as Yes and validates error messages")
	public void user_answers_UW_Question_3_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion3, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion3, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 4 as Yes and validates error messages")
	public void user_answers_UW_Question_4_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion4, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion4, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 5 as Yes and validates error messages")
	public void user_answers_UW_Question_5_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion5, "Yes");
		verify_AnyLabel_IsVisible(driver, "Policy type*");
		verify_AnyLabel_IsVisible(driver, "Operator name*");
		verify_AnyLabel_IsVisible(driver, "Property address*");
		verify_AnyLabel_IsVisible(driver, "Reason for declanation, cancellation, or non-renewal*");
		sendText(driver.findElement(By.id("Question_MemberDecline2")) , "test");
		sendText(driver.findElement(By.id("Question_MemberDecline3")) , "testoperator");
		sendText(driver.findElement(By.id("Question_MemberDecline4")) , "123 test dr 33222");
		sendText(driver.findElement(By.id("Question_MemberDecline5")) , "other");		
		click(dwellingChevron.btnSave);
		wait(3);	
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion5, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
}
