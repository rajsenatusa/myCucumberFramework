package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR359_TC16763_HO3_ValidateUWApprovalNeededForBasicToGoldReserveAndIncreaingDwellingCoverage_NB_END extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	
	@When("User enters all required information on policy information screen <mtr359>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr359() {

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
	
	@When("User enters all required information on HO3 quote screen <mtr359>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr359() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
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
	@When("User enters all required information on HO3 dwelling screen <mtr359>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr359() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
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
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$5,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$5,000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr359>")
	public void user_completes_required_information_on_dwelling_chevron_mtr359() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User adds additional interests for first mortgagee <mtr359>")
	public void user_adds_additional_interests_for_first_mortgagee_mtr359() throws Exception {

		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10002");
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(4);
		sendText(additionalinterest.txtLoanNumber, "1234");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
	}
	@And("User clicks Finalize button <mtr359>")
	public void User_clicks_Finalize_button_mtr359() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr359>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr359()
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
	@And("User sets new effective date as current date plus 5 days and starts endorsement <mtr359>")
	public void User_sets_new_effective_date_as_current_date_plus_5_days_and_starts_endorsement_mtr359()
			throws Exception {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(5)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
		click(dwellingChevron.btnDwelling);
		wait(2);
		attachScreenShot(driver);
	}
	@When("User clicks Dwelling Chevron <mtr359>")
	public void user_clicks_dwelling_chevron_mtr359() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User selects Gold Reserve and increases CovA Dwelling")
	public void user_selects_gold_reserve_and_increases_covA_dwelling() throws Exception {
		clickonAnyButton(driver, "Building.PackageCoverageInd_3");
		sendText(dwellingChevron.txtCoverageA, "470000");
		click(dwellingChevron.btnSave);
		wait(4);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "4%");
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$2,000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User adds another additional interests for first mortgagee <mtr359>")
	public void user_adds_another_additional_interests_for_first_mortgagee_mtr359() throws Exception {

		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
		clickonAnyButton(driver, "AIList_1_Delete");
		click(reviewChevron.btnDialogOk);
		wait(1);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10003");
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		wait(4);
		sendText(additionalinterest.txtLoanNumber, "1234");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
	}
	@When("User validates expected messages have been generated")
	public void user_validates_expected_messages_have_been_generated() throws Exception {
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $50,000 Must be Approved ");
		verify_AnyText_IsVisible(driver, "Change in the reserve package requires underwriting approval ");
		verify_AnyText_IsVisible(driver, "Change in Wind/Hail Deductible may only be changed at renewal ");
		verify_AnyText_IsVisible(driver, "Change in All Other Perils Deductible may only be changed at renewal ");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible  may only be changed at renewal ");
		
		verify_AnyLabel_IsVisible(driver, "Pending Output  - Endorsement Package");
		verify_AnyLabel_IsVisible(driver, "Include");
		verify_AnyLabel_IsVisible(driver, "Modified");
		verify_AnyLabel_IsVisible(driver, "Document");
		verify_AnyLabel_IsVisible(driver, "Recipient");
		verify_AnyLabel_IsVisible(driver, "Name");
		verify_AnyLabel_IsVisible(driver, "Forms");
		verify_AnyLabel_IsVisible(driver, "Delivery Method");
		verify_AnyLabel_IsVisible(driver, "Destination");
	
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application for <mtr359>")
	public void user_takes_note_of_the_application__number_for_mtr359() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for application number <mtr359>")
	public void user_searches_for_application_number_mtr359() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates expected messages on issue tile")
	public void user_validates_expected_messages_on_issue_tile() throws Exception {
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $50,000 Must be Approved");
		verify_AnyText_IsVisible(driver, "Change in the reserve package requires underwriting approval");
		verify_AnyText_IsVisible(driver, "Change in Wind/Hail Deductible may only be changed at renewal");
		verify_AnyText_IsVisible(driver, "Change in All Other Perils Deductible may only be changed at renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible  may only be changed at renewal");
	}
	@When("User process and completes endorsement and finishes test <mtr359>")
	public void user_process_and_completes_endorsement_and_finishes_test_mtr359() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
