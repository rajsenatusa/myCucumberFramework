package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4607_JA_145_HO3_Submit_for_approval_UW_Submit_for_approval_UW_Manager_approves_Agent_modifies_no_additional_rules_triggered extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String AppNum;
	
	
	@When("User enters all required information on policy information screen <mtr4607>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr4607() {

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
	@When("User enters all required information on HO3 quote screen <mtr4607>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4607() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(2);
	
	}
	@When("User enters all required information on HO3 dwelling screen <mtr4607>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4607() {
		// Quote Dwelling information was filled here
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		dwellingChevron.txtCoverageA.clear();
		dwellingChevron.txtCoverageA.sendKeys("300000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}
	@And("User changes Coverage A Dwelling as 600000 <mtr4607>")
	public void User_changes_Coverage_A_Dwelling_as_600000_mtr4607() {
		dwellingChevron.txtCoverageA.clear();
		sendText(dwellingChevron.txtCoverageA,"600000");
		
		
	}
	@When("User clicks Flood Coverage as Yes and enters required fields <mtr4607>")
	public void User_clicks_Flood_Coverage_as_Yes_and_enters_required_fields_mtr4607() {
		selectDropdownText(dwellingChevron.ddFloodCoverage, "Yes");
		wait(5);
		dwellingChevron.txtFloodDwellingCovA.clear();
		wait(1);
		dwellingChevron.btnSave.click();
		wait(1);
		dwellingChevron.txtFloodDwellingCovA.sendKeys("310000");
		selectDropdownText(dwellingChevron.ddFloodFoundationType, "Slab");
		selectDropdownText(dwellingChevron.ddFloodZoneOverride, "X");
		selectDropdownText(dwellingChevron.ddFloodSFHAOverride, "Yes");
		dwellingChevron.btnSave.click();
		wait(3);

	}
	@Then("User takes note of the application number <mtr4607>")
	public void User_takes_note_of_the_application_number_mtr4607_() throws Exception {
	// taking note 
			try {
				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
				Hooks.scenario.log("App Number: " + AppNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@When("User Searchs for Application Number for <mtr4607>")
	public void User_searches_for_Application_Number_for_mtr4607() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}
	@Then("User validates the Submit for Approval messages <mtr4607>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4607()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Required Underwriting Approval");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A change cannot exceed $50,000 Must be Approved");
		verify_AnyfirstText_IsDisplayed(driver, "A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form");
		verify_AnyfirstText_IsDisplayed(driver, "Change in Hurricane Deductible may only be changed at renewal");
		wait(5);
		attachScreenShot(driver);
		wait(2);

	}
	@Then("User validates the Submitter Issues and Issues <mtr4607>")
	public void User_validates_the_Submitter_Issues_and_Issues_mtr4607()
			throws Exception {
		
		scrollToElement(driver.findElement(By.id("WorkflowComments")));
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Required Underwriting Approval");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A change cannot exceed $50,000 Must be Approved");
		verify_AnyfirstText_IsDisplayed(driver, "A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		verify_AnyfirstText_IsDisplayed(driver, "Change in Hurricane Deductible may only be changed at renewal");
		wait(3);
		scrollToElement(driver.findElement(By.id("SubmitForApproval")));
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A change cannot exceed $100,000 Must be Approved");
		wait(3);

	}
	@Given("User clicks approve button <mtr4607>")
	public void User_clicks_approve_button_mtr4607() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		attachScreenShot(driver);
		wait(2);
		
	}
	@Then("User validates the Application has been approved by UW manager <mtr4607>")
	public void User_validates_the_Application_has_been_approved_by_UW_manager_mtr4607()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Endorsement" +  AppNum  + "has been approved.");
		wait(2);

	}
	@Then("User validates View Notes <mtr4607>")
	public void User_validates_View_Notes_mtr4607() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A change cannot exceed $100,000 Must be Approved (Building.CovALimit=600000, TriggerRuleIf=AnyChange)");
		
		click(closeoutChevron.btnIconExpandSecond);
		verify_AnyfirstText_IsDisplayed(driver,
				"Structures Rented to Others Required Underwriting Approval");
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation#");

	}
	@And("User clicks Endorse Policy <mtr4607>")
	public void User_clicks_Endorse_Policy_mtr4607() throws Exception {
		closeoutChevron.btnProcess.click();
		wait(3);
		driver.switchTo().defaultContent();		
	}
	@Then("User verifies all referrals are displayed in Notes List <mtr4607>")
	public void User_verifies_all_referrals_are_displayed_in_Notes_List_mtr4607() throws Exception {
		
		wait(5);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver,
				"Coverage A change cannot exceed $100,000 Must be Approved (Building.CovALimit=600000, TriggerRuleIf=AnyChange)");
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Required Underwriting Approval\r\n"
				+ "Coverage A change cannot exceed $50,000 Must be Approved (Building.CovALimit=600000, TriggerRuleIf=AnyChange)\r\n"
				+ "A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.\r\n"
				+ "Change in Hurricane Deductible may only be changed at renewal (Building.HurricaneDeductible=2, TriggerRuleIf=AnyChange)");
		wait(5);
		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);
				
		}
	
}
