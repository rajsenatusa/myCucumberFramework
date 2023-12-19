package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16767_UMB_AgentAppUWQuestionsValidation extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
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
		click(driver.findElement(By.id("Wizard_UmbrellaLiability")));
		wait(2);
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
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
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
		verify_AnyLabel_IsVisible(driver, "Is animal liability excluded on any primary homeowner's policy?*");
		click(policyChevron.btnPolicyChevronLink);	
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
	@When("User answers UW Question 6 as Yes and validates error messages")
	public void user_answers_UW_Question_6_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion6, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion6, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 7 as Yes and validates error messages")
	public void user_answers_UW_Question_7_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion7, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion7, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 8 as Yes and validates error messages")
	public void user_answers_UW_Question_8_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion8, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion8, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 9 as Yes and validates error messages")
	public void user_answers_UW_Question_9_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion9, "Yes");
		verify_AnyLabel_IsVisible(driver, "Operator name*");
		verify_AnyLabel_IsVisible(driver, "Explanation of impairment*");
		sendText(driver.findElement(By.id("Question_MemberImpairment2")) , "testoperator");
		sendText(driver.findElement(By.id("Question_MemberImpairment3")) , "other");	
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion9, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 10 as Yes and validates error messages")
	public void user_answers_UW_Question_10_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion10, "Yes");
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Are all liability/litigation claims closed?*");
		verify_AnyLabel_IsVisible(driver, "Were any losses greater than $25,000?*");
		selectDropdownText(driver.findElement(By.id("Question_MemberLiability2")),"No");
		selectDropdownText(driver.findElement(By.id("Question_MemberLiability3")),"Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "3");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion10, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 11 as Yes and validates error messages")
	public void user_answers_UW_Question_11_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion11, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion11, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 12 as Yes and validates error messages")
	public void user_answers_UW_Question_12_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion12, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents.  ");
		verify_AnyLabel_IsVisible(driver, "Loss or at fault accident for Underlying Auto must be entered on Loss History Tab. Please submit for Underwriter Approval. ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion12, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 13 as Yes and validates error messages")
	public void user_answers_UW_Question_13_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion13, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion13, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 14 as Yes and validates error messages")
	public void user_answers_UW_Question_14_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion14, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion14, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 15 as Yes and validates error messages")
	public void user_answers_UW_Question_15_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion15, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion15, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 16 as Yes and validates error messages")
	public void user_answers_UW_Question_16_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion16, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion16, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 17 as Yes and validates error messages")
	public void user_answers_UW_Question_17_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion17, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion17, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers UW Question 18 as Yes and validates error messages")
	public void user_answers_UW_Question_18_as_Yes_and_validates_error_messages() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion18, "Yes");
		click(dwellingChevron.btnSave);
		wait(2);
		click(policyChevron.btnPolicyChevronLink);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles.  ");
		attachScreenShot(driver);
		driver.findElement(By.id("Wizard_Underwriting")).click();  //click underwriting chevron
		selectDropdownText(uwquestionsChevron.umbQuestion18, "No");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User answers all UW Questions as Yes and validates error messages")
	public void user_answers_all_UW_Question_as_Yes_and_validates_error_messages() throws Exception {
		selectDropdownText(uwquestionsChevron.umbQuestion1, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion2, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Question_MemberBite1")),"Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion3, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion4, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion5, "Yes");
		wait(1);
		sendText(driver.findElement(By.id("Question_MemberDecline2")) , "test");
		sendText(driver.findElement(By.id("Question_MemberDecline3")) , "testoperator");
		sendText(driver.findElement(By.id("Question_MemberDecline4")) , "123 test dr 33222");
		sendText(driver.findElement(By.id("Question_MemberDecline5")) , "other");
		selectDropdownText(uwquestionsChevron.umbQuestion6, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion7, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion8, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion9, "Yes");
		wait(1);
		sendText(driver.findElement(By.id("Question_MemberImpairment2")) , "testoperator");
		sendText(driver.findElement(By.id("Question_MemberImpairment3")), "other");
		selectDropdownText(uwquestionsChevron.umbQuestion10, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Question_MemberLiability2")) , "No");
		selectDropdownText(driver.findElement(By.id("Question_MemberLiability3")) , "Yes");	
		selectDropdownText(uwquestionsChevron.umbQuestion11, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion12, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion13, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion14, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion15, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion16, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion17, "Yes");
		selectDropdownText(uwquestionsChevron.umbQuestion18, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure.  ");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history.  ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.  ", "1");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed.  ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations.  ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession.  ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment.  ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.  ", "3");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents.  ");
		verify_AnyLabel_IsVisible(driver, "Loss or at fault accident for Underlying Auto must be entered on Loss History Tab. Please submit for Underwriter Approval. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure.  ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide.  ");
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance.  ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.  ", "2");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee.  ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles.  ");
		
		click(uwquestionsChevron.nextButtonUw);
	}
	@When("User validates UW error messages on issues tile")
	public void user_validates_UW_error_messages_on_issues_tile() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Loss or at fault accident for Underlying Auto must be entered on Loss History Tab. Please submit for Underwriter Approval. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions. ", "1");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "3");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents. ");			
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide. ");
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions. ", "2");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles. ");
	}
	@When("User sets payment type and takes note of the application for <tc16767>")
	public void user_sets_payment_type_takes_note_of_the_application__number_for_tc16767() throws Exception {
		
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(2);
		scrollToAnyField(driver, "Modify Application");
		attachScreenShot(driver);
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval button <tc16767>")
	public void user_clicks_submit_for_approval_button_tc16767() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		click(closeoutChevron.btnDialogOk);
		wait(3);
	}
	@When("User searches for the application <tc16767>")
	public void user_searches_application_for_tc16767() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates expected error messages on policy tile and submitter issues tile")
	public void user_validates_expected_error_messages_on_policy_tile_and_submitter_issues_tile_tc16767() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Loss or at fault accident for Underlying Auto must be entered on Loss History Tab. Please submit for Underwriter Approval. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions. ", "1");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "3");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents. ");			
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide. ");
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles. ");
		
		//Verify following messages under Submitter issues tile
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure.");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history.");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.", "1");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed.");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities.");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction.");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment.");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history.", "3");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows.");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide.");
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance.");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.", "2");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee.");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles.");

		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);		
	}
	@When("User clicks submit for approval as underwriter <tc16767>")
	public void user_clicks_submit_for_approval_as_underwriter_tc16767() throws Exception {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
		verify_AnyText_NotVisible(driver, "Submission Confirmation");
	}
	@When("User validates expected error messages on policy tile and submitter issues tile with UW manager role")
	public void user_validates_expected_error_messages_on_policy_tile_and_submitter_issues_tile_with_UW_manager() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Loss or at fault accident for Underlying Auto must be entered on Loss History Tab. Please submit for Underwriter Approval. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to bite history. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions. ", "1");
		verify_AnyLabel_IsVisible(driver, "Risk ineligible due to dog breed. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to business or farming activities. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior coverage was declined, cancelled or non-renewed. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to motor vehicle violations. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to conviction. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to physical/mental impairment. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "1");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "2");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to loss history. ", "3");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to prior motor vehicle violations/accidents. ");			
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure. ");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to unfenced swimming pool/diving board/water slide. ");
		verify_AnyLabel_IsVisible(driver, "Risk in in eligible due to unfenced trampoline/attractive nuisance. ");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions. ", "2");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee. ");
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to high performance vehicles. ");
		
		//Verify following messages under Submitter issues tile
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure.");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.", "1");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee.");

		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);
	}
	@When("User validates issue messages under submitter issues tile")
	public void user_validates_issue_messages_under_submitter_issues_tile() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Underwriting referral required due to aircraft exposure.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible due to profession.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligble for coverage due to vehicles/watercraft used for racing or shows.");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to rooming exposure.");
		verify_AnyText_IsVisibleMultipletimes(driver, "Underwriting referral required due to underlying policy sublimits/exclusions.", "1");
		verify_AnyLabel_IsVisible(driver, "Risk is ineligible for coverage due to vehicle used to transport people or products for a fee.");

		scrollToAnyField(driver, "Submitter Issues");
		attachScreenShot(driver);			
	}
	@Then("User issues policy and close unnecessary tabs and completes test <tc16767>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc16767() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("UMB NB policy has been created successfully");
		} else {
			System.out.println("UMB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
