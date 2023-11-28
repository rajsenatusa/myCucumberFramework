package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC33726_TOMHPD_ModifyDeductibleRulesAndEdits_END extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <tc33726>")
	public void user_enters_all_required_information_on_policy_information_screen_tc33726() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "15330 Searobbin Drive");
		sendText(quote.txtZipCode, "34202");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on TOMHPD quote screen <tc33726>")
	public void user_enters_all_required_information_on_tomhpd_quote_screen_tc33726() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information and sets deductibles on TOMHPD dwelling screen <tc33726>")
	public void user_enters_all_required_information_and_sets_deductibles_on_tomhpd_dwelling_screen_tc33726() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		getWaitObject();
		scrollToElement(dwellingChevron.txtCoverageA);
		wait(2);
		waitForVisibility(dwellingChevron.txtCoverageA);
		clickTab(dwellingChevron.txtCoverageA);
		clearText(dwellingChevron.txtCoverageA);
		wait(2);
		driver.findElement(By.id("Building.CovALimit")).sendKeys("80000"); // did hard coding due to element is hidden
																			// inside dom
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(1);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$2,500");
		driver.findElement(By.id("Building.Vandalism")).click();
		wait(1);
		selectDropdownText(driver.findElement(By.id("Building.VMMDed")), "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@When("User clicks Dwelling Chevron and completes required information <tc33726>")
	public void user_clicks_dwelling_chevron_and_completes_required_information_tc33726() {
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates that TOMHPD policy has been created successfully and takes note of the policy number <tc33726>")
	public void user_validates_that_tomhpd_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc33726()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut MHPD policy has been created successfully");
		} else {
			System.out.println("TakeOut MHPD policy creation failed!");
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
	@When("User searches for the policy number <tc33726>")
	public void user_searches_policy_for_tc33726() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date and starts endorsement <tc33726>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_tc33726() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <tc33726>")
	public void user_clicks_dwelling_chevron_tc33726() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User decrease deductibles <tc33726>")
	public void user_decrease_deductibles_tc33726() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.VMMDed")), "$1,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "5%");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User finalizes transaction and validates deductible change messages has been displayed and process transaction <tc33726>")
	public void user_finalizes_transaction_and_validates_ded_change_messages_has_been_displayed_and_process_transaction_tc33726() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From 2500 to 1000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Vandalism and Malicious Mischief Changed From $2,500 to $1,000");
		attachScreenShot(driver);
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
		closeUnnecessaryTabs();
	}
	@When("User changes system date to current date <tc33726>")
	public void user_changes_system_date_to_current_date_tc33726() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User increase deductibles <tc33726>")
	public void user_increase_deductibles_tc33726() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.FireDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.VMMDed")), "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User finalizes transaction and validates increased deductible change messages has been displayed and process transaction <tc33726>")
	public void user_finalizes_transaction_and_validates_increased_ded_change_messages_has_been_displayed_and_process_transaction_tc33726() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From 1000 to 2500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 5% to 10%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $1,000 to $2,500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Vandalism and Malicious Mischief Changed From $1,000 to $2,500");
		attachScreenShot(driver);
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);	
		closeUnnecessaryTabs();
	}
	@When("User changes system date to current date plus 1 day <tc33726>")
	public void user_changes_system_date_to_current_date_plus_1_day_tc33726() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}
	@When("User validates expected issue messages <tc33726>")
	public void user_validates_expected_issue_messages_tc33726() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Fire Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in VM&M Deductible may only be changed at Renewal");
		attachScreenShot(driver);
	}
	@When("User finalizes transaction and validates second time increased deductible change messages has been displayed and takes note of the application number <tc33726>")
	public void user_finalizes_transaction_and_validates_second_timeincreased_ded_change_messages_has_been_displayed_and_takes_note_applicationnumber_tc33726() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		attachScreenShot(driver);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Fire Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in VM&M Deductible may only be changed at Renewal");
		
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From 2500 to 1000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 5%");
		verify_AnyText_IsVisible(driver, "Deductible Change: Fire Changed From $2,500 to $1,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Vandalism and Malicious Mischief Changed From $2,500 to $1,000");
		
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
		
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks submit for approval with popup <tc33726>")
	public void user_clicks_submit_for_approval_with_popup_tc33726() throws Exception {
		sendText(closeoutChevron.txtWorkflowComments, "testtesttesttes");
		click(closeoutChevron.btnSubmitApproval);
		click(closeoutChevron.btnDialogOk);
		wait(2);
	}
	@When("User searches for the application <tc33726>")
	public void user_searches_application_for_tc33726() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User process and completes endorsement and finishes test <tc33726>")
	public void user_process_and_completes_endorsement_and_finishes_test_tc33726() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
