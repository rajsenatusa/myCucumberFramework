package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR391_UMB_Validate_Direct_Bill_Full_Payment_Plan_policy_without_payment_effective_date_is_current_date_cancels_after_20_days extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String HO3policyNum;
	static String nextDate;
	static String currentDueDate;
	static String payPlan;
	static String nextDate2;
	static String currentDueDate2;
	static String payPlan2;
	
	@When("User changes system date to current date <mtr391>")
	public void user_changes_system_date_to_current_date_mtr391() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr391>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr391() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO3 quote screen <mtr391>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr391() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-342-4532");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr391>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr391() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr391>")
	public void user_completes_required_information_on_dwelling_chevron_mtr391() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr391>")
	public void User_clicks_Finalize_button_mtr391() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr391>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr391()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			HO3policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + HO3policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters all required information on UMB personal liability screen <mtr391>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_mtr391() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, "1,000,000");
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, "0");
		sendText(umbrellaChevron.txtNumberOfAuto, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(umbrellaChevron.ddLiabilityResidenceAtLeast500k, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User adds underlying policy in personal liability chevron <mtr391>")
	public void user_adds_underlying_policy_in_personal_liability_chevron_mtr391() {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Property and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, HO3policyNum);
		wait(2);
		clickTab(driver.findElement(By.id("UnderlyingExposureType")));
		selectDropdownText(umbrellaChevron.ddSelectPolicyWithAI, "Yes");
		wait(1);
		selectDropdownText(driver.findElement(By.id("UnderlyingExposureType")),"Primary Residence");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User validates that UMB policy has been created successfully and takes note of the policy number <mtr391>")
	public void user_validates_that_umb_policy_has_been_created_successfully_mtr391() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
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
	@When("User validates Due Date, next action date and payment plan values <mtr391>")
	public void user_validates_Due_Date_next_action_date_and_payment_plan_values_mtr391() throws Exception {
		nextDate = getNextActionDate(driver).toString();
		
		if(nextDate.equals(dtf.format(currentDate.plusDays(5)))) {
			Hooks.scenario.log("Next Action Date displayes as expected. Current Date +5 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Next Action Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		currentDueDate=getCurrentDueDate(driver).toString();
		
		if(currentDueDate.equals(dtf.format(currentDate))) {
			Hooks.scenario.log("Current Due Date displayes as expected. Current Date");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Current Due Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		payPlan=getPaymentPlan(driver).toString();
		
		if(payPlan.equalsIgnoreCase("Full Payment Plan")) {
			Hooks.scenario.log("Payment Plan displayes as expected. Full Payment Plan");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Payment Plan Shows wrong value.Test Fails");
			attachScreenShot(driver);
		}
	}
	@When("User run daily jobs forward policy <mtr391>")
	public void user_run_daily_jobs_forward_policy_and_mtr391() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate);
	}
	@When("User searches for Policy Number for <mtr391>")
	public void user_searches_for_policy_number_for_mtr391() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates Cancellation notice has been generated <mtr391>")
	public void user_validates_Cancellation_notice_has_been_generated_mtr391() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation Notice");
	}
	@When("User validates Due Date, next action date and payment plan values after cancellation notice generated <mtr391>")
	public void user_validates_Due_Date_next_action_date_and_payment_plan_values_after_cancellation_notice_generated_mtr391() throws Exception {
		nextDate2 = getNextActionDate(driver).toString();
		
		if(nextDate2.equals(dtf.format(currentDate.plusDays(20)))) {
			Hooks.scenario.log("Next Action Date displayes as expected. Current Date +20 days");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Next Action Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		currentDueDate2=getCurrentDueDate(driver).toString();
		
		if(currentDueDate2.equals(dtf.format(currentDate))) {
			Hooks.scenario.log("Current Due Date displayes as expected. Current Date");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Current Due Date Shows wrong date.Test Fails");
			attachScreenShot(driver);
		}
		
		payPlan2=getPaymentPlan(driver).toString();
		
		if(payPlan2.equalsIgnoreCase("Full Payment Plan")) {
			Hooks.scenario.log("Payment Plan displayes as expected. Full Payment Plan");
			attachScreenShot(driver);
		}else {
			Hooks.scenario.log("Payment Plan Shows wrong value.Test Fails");
			attachScreenShot(driver);
		}
	}
	@When("User run daily jobs to second next action date and forward policy <mtr391>")
	public void user_run_daily_jobs_to_second_next_action_date_and_forward_policy_mtr391() throws Exception {
		runDailyJobOnDate(driver, policyNum, nextDate2);
	}
	@Then("User validates Cancellation has been generated and completes test <mtr391>")
	public void user_validates_Cancellation_has_been_generated_and_completes_test_mtr391() throws Exception {
		verify_AnyText_IsVisible(driver, "Cancellation");
		Hooks.scenario.log("Test Case Completed!");
	}
}
