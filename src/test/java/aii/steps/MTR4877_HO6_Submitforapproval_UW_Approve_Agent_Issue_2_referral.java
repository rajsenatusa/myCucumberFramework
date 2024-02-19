package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4877_HO6_Submitforapproval_UW_Approve_Agent_Issue_2_referral extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters HO6 product selection information and current date as effective date ")
	public void User_enters_HO6_product_selection_information_and_current_date_as_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}
	@When("User enters all required information on HO6 quote screen <mtr4877>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr4877() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "None");
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("0 to 3 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@Then("User takes note of the application number <mtr4877>")
	public void User_takes_note_of_the_application_number_mtr4877_() throws Exception {
	// taking note 
			try {
				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
				Hooks.scenario.log("App Number: " + AppNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@When("User Searchs for Application Number for <mtr4877>")
	public void User_searches_for_Application_Number_for_mtr4877() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@Given("User clicks View Workflow Comments")
	public void User_clicks_View_Workflow_Comments() {
		click(closeoutChevron.btnViewWorkflowComments);
		wait(2);
	}
	@Then("User validates a New Note has been created successfully in Notes List <mtr4877>")
	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List_mtr4877() throws Exception {
		wait(5);
		switchToWindow(driver, "frmCMM");
		wait(10);
		click(dashboard.btnExpandHO6);
		verify_AnyText_IsVisible(driver, "The following approvals are persisted:\r\n"
				+ "Risks with no prior insurance require underwriting approval.");
		wait(5);
		click(dashboard.btnExpandGeneralHO6);
		verify_AnyText_IsVisible(driver, "Underwriting approval required ");
		Hooks.scenario.log("New Note has been created successfully!");
		attachScreenShot(driver);
		wait(5);
		driver.close();
	}
	@Given("User issues policy <mtr4877>")
	public void user_issues_policy_mtr4877() {
		clickTab(driver.findElement(By.id("Process")));
		
		click(closeoutChevron.btnIssueNB);
		wait(5);
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
	}
	
	
//	@When("User enters all required information on HO3 quote screen <mtr4934>")
//	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4934() {
//		// Quote Policy Chevron information was filled here
//
//		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
//		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
//		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
//		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
//		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
//		wait(2);
//t		click(policyChevron.btnNoEmailRadio);
//		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
//		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
//		selectDropdownText(policyChevron.ddMonthsOccupied, "0 to 3 Months");
//		selectDropdownText(policyChevron.ddInsuredReside, "No");
//		wait(1);
//		click(policyChevron.btnNext);
//	
//	}
//	@When("User enters all required information on HO3 dwelling screen <mtr4934>")
//	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4934() {
//		// Quote Dwelling information was filled here
//		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
//		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
//		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
//		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
//		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
//		wait(2);
//		click(dwellingChevron.btnSave);
//		wait(3);
//		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
//		click(dwellingChevron.btnCalculate);
//		wait(4);
//		click(dwellingChevron.btnSave);
//		dwellingChevron.txtCoverageA.sendKeys("9000000");
//		wait(1);
//		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
//		wait(1);
//		click(dwellingChevron.btnSave);
//		click(dwellingChevron.btnNext);
//		wait(3);
//	}
//	@Then("User takes note of the application number <mtr4934>")
//	public void User_takes_note_of_the_application_number_mtr4934_() throws Exception {
//	// taking note 
//			try {
//				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
//				Hooks.scenario.log("App Number: " + AppNum);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	
//	}
//	@When("User Searchs for Application Number for <mtr4934>")
//	public void User_searches_for_Application_Number_for_mtr4934() {
//		wait(3);
//		sendText(dashboard.txtSearchBar, AppNum);
//		click(dashboard.search);
//		wait(3);
//	}
//	@Then("User validates the Submit for Approval messages")
//	public void User_validates_the_Submit_for_Approval_messages()
//			throws Exception {
//		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
//		verify_AnyfirstText_IsDisplayed(driver, "Coverage A is High Value Dwelling limit that will require underwriting review.");
//		wait(5);
//		attachScreenShot(driver);
//		wait(2);
//
//	}
//	@Then("User validates the Application is submitted for approval")
//	public void User_validates_the_Application_is_submitted_for_approval()
//			throws Exception {
//		verify_AnyfirstText_IsDisplayed(driver, "New Business AP-06937931 has been submitted for approval.");
//		wait(3);
//		attachScreenShot(driver);
//		wait(2);
//
//	}
//	@Then("User validates the Submitter Issues")
//	public void User_validates_the_Submitter_Issues()
//			throws Exception {
//		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
//		attachScreenShot(driver);
//		wait(2);
//		verify_AnyfirstText_IsDisplayed(driver, "Coverage A is High Value Dwelling limit that will require underwriting review.");
//		wait(3);
//		attachScreenShot(driver);
//		wait(2);
//
//	}
//	
//	
//	
//	
//	
////	
////	@And("User validates NB HO3 policy has been created successfully and takes note of the policy number for <mtr457>")
////	public void User_validates_NB_HO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr457()
////			throws Exception {
////
////		wait(5);
////		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));
////
////		if (validate.getText().equalsIgnoreCase("New Business")) {
////			System.out.println("NB HO3 policy has been created successfully");
////		} else {
////			System.out.println("NB HO3 policy creation failed!");
////		}
////		closeUnnecessaryTabs();
////		getPolicyNumber(driver);
////		getInForcePremiumFees(driver);
////		Hooks.scenario.log("New Business HO3 policy has been created successfully");
////		attachScreenShot(driver);
////		// taking note of the issued policy
////		try {
////			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
////			Hooks.scenario.log("Policy Number: " + policyNum);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////	}
////
////	@When("User Searchs for Policy Number for <mtr457>")
////	public void User_searches_for_Policy_Number_for_mtr457() {
////		wait(5);
////		sendText(dashboard.txtSearchBar, policyNum);
////		click(dashboard.search);
////		wait(3);
////	}
////	@When("User enters all required information on HO3 quote screen <mtr457>")
////	public void user_enters_all_required_information_on_ho3_quote_screen_mtr457() {
////		// Quote Policy Chevron information was filled here
////
////		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
////		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
////		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
////		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
////		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
////		wait(2);
////		click(policyChevron.btnNoEmailRadio);
////		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
////		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
////		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
////		selectDropdownText(policyChevron.ddInsuredReside, "No");
////		wait(1);
////		click(policyChevron.btnNext);
////	}
////
////	@When("User creates a New Note for <mtr457>")
////	public void User_creates_a_New_Note_for_mtr457() throws Exception {
////		selectDropdownText(dashboard.ddNoteTemplate, "Company Privileged Note");
////		wait(1);
////		selectDropdownText(dashboard.ddNotePriority, "High");
////		wait(1);
////		sendText(dashboard.noteMemo, "Company Privileged Note that was entered by Underwriter");
////		wait(1);
////		click(dashboard.addNote);
////		wait(1);
////
////		Hooks.scenario.log("Company Privileged Note has been created successfully");
////		attachScreenShot(driver);
////
////	}
////
////	@Then("User validates a New Note has been created successfully in Notes List <mtr457>")
////	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List_mtr457() throws Exception {
////		wait(7);
////		click(dashboard.btnExpand);
////		verify_AnyText_IsVisible(driver, "Company Privileged Note that was entered by Underwriter");
////		Hooks.scenario.log("New Note has been created successfully!");
////		Hooks.scenario.log("Company Privileged Note has been created successfully");
////		attachScreenShot(driver);
////	}
////
////	@Then("User verifies that Agent cannot see Company Privileged Note")
////	public void User_verifies_that_Agent_cannot_see_Company_Privileged_Note() throws Exception {
////		wait(3);
////		verify_AnyText_NotVisible(driver, "Company Privileged Note");
////		Hooks.scenario.log("Agent is not able to see Company Privileged Note");
////		Hooks.scenario.log("No Company Privileged Note");
////		attachScreenShot(driver);
////	}
////
////	@When("User creates a General Note")
////	public void User_creates_a_General_Note() throws Exception {
////
////		selectDropdownText(driver.findElement(By.id("Note.TemplateId")), "General Note");
////		wait(1);
////		selectDropdownText(driver.findElement(By.id("Note.PriorityCd")), "Low");
////		wait(1);
////		sendText(driver.findElement(By.id("Note.Memo")), "General Note that was entered by Underwriter");
////
////		wait(1);
//////		click(dashboard.addNote);
////		driver.findElement(By.id("AddNote")).click();
////		wait(1);
////		Hooks.scenario.log("General Note has been created successfully");
////		attachScreenShot(driver);
////
////	}
////
////	@Then("User validates a General Note has been created successfully in Notes List <mtr457>")
////	public void User_validates_a_General_Note_has_been_created_successfully_in_Notes_List_mtr457() throws Exception {
////		wait(7);
////		click(dashboard.btnExpandHO3);
////		verify_AnyText_IsVisible(driver, "General Note that was entered by Underwriter");
////		Hooks.scenario.log("New Note has been created successfully!");
////		Hooks.scenario.log("General Note has been created successfully");
////		attachScreenShot(driver);
////	}
////
////	@Then("User verifies that Agent can see General Note")
////	public void User_verifies_that_Agent_can_see_General_Note() throws Exception {
////		wait(7);
////		click(dashboard.btnExpandHO3);
////		verify_AnyText_IsVisible(driver, "General Note that was entered by Underwriter");
////		Hooks.scenario.log("New General Note displayed successfully!");
////		Hooks.scenario.log("General Note displayed by Agent");
////		attachScreenShot(driver);
////	}
////
////	@Then("User verifies that Edit or Delete links are displayed")
////	public void User_verifies_that_no_Edit_or_Delete_links_are_displayed() throws Exception {
////		wait(3);
////		verify_AnyText_IsVisible(driver, "Edit Delete");
////		Hooks.scenario.log("Underwriter Manager can see Edit or Delete links");
////		Hooks.scenario.log("Edit or Delete links display");
////		attachScreenShot(driver);
////	}
////
////	@Then("User verifies that Underwriter Manager can Edit and Save General Note")
////	public void User_verifies_that_Underwriter_Manager_can_Edit_and_Save_General_Note() throws Exception {
////		wait(1);
////		click(dashboard.editLink);
////		wait(1);
////		sendText(dashboard.noteMemo,
////				"General Note that was entered by Underwriter. AND General Note has been edited by Underwriter Manager.");
////		wait(1);
////		click(dashboard.saveNote);
////		wait(1);
////		click(dashboard.btnExpandHO3);
////		verify_AnyText_IsVisible(driver,
////				"General Note that was entered by Underwriter. AND General Note has been edited by Underwriter Manager.");
////		Hooks.scenario.log("Edited General Note displayed successfully!");
////		Hooks.scenario.log("General Note edited by Underwriter Manager");
////		attachScreenShot(driver);

	}

