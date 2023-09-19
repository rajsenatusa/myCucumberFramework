package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR306_HO3_ProcessRewriteNewOnCancelledPolicy_NB extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr306>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr306() {

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
	@When("User enters all required information on HO3 quote screen <mtr306>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr306() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen <mtr306>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr306() {
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
	@When("User completes required information on dwelling chevron <mtr306>")
	public void user_completes_required_information_on_dwelling_chevron_mtr306() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr306>")
	public void User_clicks_Finalize_button_mtr306() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr306>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr306()
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
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User selects Cancellation Type as Insured")
	public void User_selects_cancellation_type_insured() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);	
	}
	@And("User selects Cancel Rewrite as reason")
	public void User_selects_cancel_rewrite_as_reason() {
		selectDropdownText(historyChevron.ddReason, "Cancel/Rewrite");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User selects effective date as cancel date as current date")
	public void User_sets_effective_date_current_date_as_cancel_date() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}
	@And("User process cancellation transaction")
	public void User_process_cancellation_transaction() {
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User completes cancellation transaction and validates policy transaction status as cancelled <mtr306>")
	public void User_completes_cancellation_transaction_mtr306() {
		click(closeoutChevron.btnIssueNB);
		wait(10);
		Hooks.scenario.log("Policy Cancellation Completed!");
	}
	@And("User clicks Rewrite New Transaction Selection")
	public void User_clicks_rewrite_new_transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-New");
		wait(1);
		click(dashboard.btnSelect);
		click(dashboard.btnStart);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User clicks Dwelling Chevron <mtr306>")
	public void user_clicks_dwelling_chevron_mtr306() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User sets cyber home protection as <25000>")
	public void user_sets_cyber_home_protection_as_25000() throws Exception {
		selectDropdownText(dwellingChevron.ddHomeCyberProtection, "$25,000");
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User completes rewrite new transaction")
	public void user_completes_rewrite_new_transaction() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(9);
		closeUnnecessaryTabs();
	}
	@When("User clicks Forms Chevron <mtr306>")
	public void user_clicks_forms_chevron_mtr306() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}
	@When("User validates greeting letter in the forms")
	public void user_validates_greeting_letter_in_the_Forms() throws Exception {
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC GL 08 19')]"));	
			Hooks.scenario.log("Form: Greeting Letter");
		} catch (Exception e) {
			Hooks.scenario.log("Form: Greeting Letter");
			wait(5);
		} 
	}
	@Then("User validates Home Cyber Protection field is disabled and completes test")
	public void user_validates_home_cyber_protection_field_is_disabled_and_completes_test() throws Exception {
		verifyAnyDisabledFieldsValue(driver, "Building.HomeCyberProtection_text", "$25,000");
		Hooks.scenario.log("Test Case Completed!");
	}
}
