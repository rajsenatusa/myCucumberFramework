package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR459_MHO3_Verify_as_an_Underwriter_has_the_ability_to_create_High_Priority_General_notes
		extends CommonMethods {

	static String policyNum;

	@And("User validates NB MHO3 policy has been created successfully and takes note of the policy number for <mtr459>")
	public void User_validates_NB_MHO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr459()
			throws Exception {

//		wait(1);
//		switchToWindow(driver, "ai.iscs.com/innovation");
//		wait(1);

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("NB MHO3 policy has been created successfully");
		} else {
			System.out.println("NB MHO3 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("New Business MHO3 policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number")
	public void User_searches_for_Policy_Number() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks New Note button and enters New Policy Notes <mtr459>")
	public void User_clicks_New_Note_button_and_enters_New_Policy_Notes_mtr459() throws Exception {
		wait(1);
		click(dashboard.btnNewNote);
	}

	@When("User clicks Notes Chevron")
	public void User_clicks_Notes_Chevron() {
		click(reviewChevron.btnNotes);
		wait(1);
	}

	@When("User clicks Add Note button")
	public void User_clicks_Add_Note_button() {		
		driver.findElement(By.id("AddNote")).click();
//		click(dashboard.addNote);
		wait(1);
	}

	@When("User creates a New Note")
	public void User_creates_a_New_Note() throws Exception {
		selectDropdownText(dashboard.ddNoteTemplate, "Company Privileged Note");
		wait(1);
		selectDropdownText(dashboard.ddNotePriority, "High");
		wait(1);
		sendText(dashboard.noteMemo, "Company Privileged Note that was entered by Underwriter");
		wait(1);
		click(dashboard.addNote);
		wait(1);
		
		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);
		
	}
	@Then("User validates a New Note has been created successfully in Notes List")
	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_IsVisible(driver, "Memo: Company Privileged Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);
	}
	@Then("User validates Agent is not able to see Company Privileged Note that was created by Underwriter")
	public void User_validates_Agent_is_not_able_to_see_Company_Privileged_Note_that_was_created_by_Underwriter() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_NotVisible(driver, "Memo: Company Privileged Note that was entered by Underwriter");
		Hooks.scenario.log("Agent is not able to see Company Privileged Note that was created by Underwriter");
	}
	@And("User enters Months Occupied for MHO3")
	public void User_enters_Months_Occupied_for_MHO3() {
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		wait(1);
	}
	
	
	
	
}