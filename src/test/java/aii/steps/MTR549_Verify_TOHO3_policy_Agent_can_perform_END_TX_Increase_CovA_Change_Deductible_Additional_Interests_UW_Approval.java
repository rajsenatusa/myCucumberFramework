package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR549_Verify_TOHO3_policy_Agent_can_perform_END_TX_Increase_CovA_Change_Deductible_Additional_Interests_UW_Approval extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;
	
	@When("User changes system date to current date <mtr549>")
	public void user_changes_system_date_to_current_date_mtr549() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr549>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr549() {

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
	@When("User enters all required information on TOHO3 quote screen <mtr549>")
	public void User_enters_all_required_information_on_toho3_quote_screen_mtr549() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOHO3 dwelling screen <mtr549>")
	public void user_enters_all_required_information_on_toho3_welling_screen_mtr549() {

		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddStructureRentedOthers, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "5%");
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@And("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr549>")
	public void user_validates_that_toho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_mtr549()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
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
	@When("User searches for the policy number <mtr549>")
	public void user_searches_policy_for_mtr549() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date plus 30 days and starts endorsement <mtr549>")
	public void User_sets_new_effective_date_as_current_date_plus30days_and_starts_endorsement_mtr549() {
		wait(2);
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User clicks Dwelling Chevron for <mtr549>")
	public void user_clicks_dwelling_chevron_mtr549() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User increases CovA dwellings <mtr549>")
	public void user_increases_cova_dwellings_mtr549() throws Exception {
		sendText(dwellingChevron.txtCoverageA, "541000");
		wait(1);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Other");
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$2,500");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "Not Applicable");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User adds additional interests for first mortgagee <mtr549>")
	public void user_adds_additional_interests_for_first_mortgagee_mtr549() {

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
	}
	@When("User finalizes transaction and verify changes are visible on closeout screen and clicks submit for approval <mtr549>")
	public void user_finalizes_transaction_and_clicks_submit_for_approval_validate_changes_and_mtr549() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Change in Sinkhole Deductible Must Be Approved");
		verify_AnyText_IsVisible(driver,
				"Underwriting approval is required - Risk is ineligible due to roof material  - Other");
		verify_AnyText_IsVisible(driver, "Change to Coverage A Limit requires underwriting approval");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");

		// store application number
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <mtr549>")
	public void user_searches_application_for_mtr549() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates approval request texts have been displayed <mtr549>")
	public void user_validates_approval_request_texts_have_Been_displayed_mtr549() throws Exception {
		verify_AnyText_IsVisible(driver, "Change in Sinkhole Deductible Must Be Approved");
		verify_AnyText_IsVisible(driver,
				"Underwriting approval is required - Risk is ineligible due to roof material  - Other");
		verify_AnyText_IsVisible(driver, "Change to Coverage A Limit requires underwriting approval");
	}
	@When("User clicks submit for approval button <mtr549>")
	public void user_clicks_submit_for_approval_button_mtr549() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}
	@When("User validates 'Endorse Policy' label is visible and process endorsement and finishes test <mtr549>")
	public void user_process_and_completes_endorsement_and_finishes_test_mtr549() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
