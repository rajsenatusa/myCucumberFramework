package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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

		wait(1);
		switchToWindow(driver, "ai.iscs.com/innovation");
		wait(1);

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("NB MHO3 policy has been created successfully");
		} else {
			System.out.println("NB MHO3 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("New Business MHO3 policy has been created successfully");

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
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks New Note button and enters New Policy Notes <mtr459>")
	public void User_clicks_New_Note_button_and_enters_New_Policy_Notes_mtr459() throws Exception {
		wait(1);
		click(dashboard.btnNewNote);
//		clickonAnyButton(driver, "New_Note_Clicked");
//	driver.switchTo().frame(getAlertText()); // Now you are in the popup window, perform necessary actions here
//	wait(1);
		wait(2);
		selectDropdown(dashboard.ddNoteTemplate, 2);
		wait(2);
		selectDropdown(dashboard.ddNotePriority, 2);
		wait(2);
		sendText(dashboard.noteMemo, "Note that was entered by the User");
		wait(2);
		click(dashboard.addNote);
		wait(2);
		
		
		
		
	}
	@When("User enters New Policy Notes <mtr459>")
	public void User_enters_New_Policy_Notes_mtr459() throws Exception {
		
		wait(1);
		

		clickonAnyButton(driver, "New_Policy_Note");
		driver.switchTo().frame("IFrameCoverageAction"); // Now you are in the popup window, perform necessary actions
		// here
		wait(1);
		selectDropdownText(dashboard.ddNoteTemplate, "General Note");
		wait(1);
		selectDropdownText(dashboard.ddNotePriority, "High");
		wait(1);
		sendText(dashboard.noteMemo, "Note that was entered by the User");
		wait(1);
		click(dashboard.addNote);
		wait(1);
		
		
//		clickonAnyButton(driver, "CoverageList_AS_Add");
//		driver.switchTo().frame("IFrameCoverageAction"); // Now you are in the popup window, perform necessary actions
//															// here
//		wait(1);
//		selectDropdownText(dwellingChevron.ddClassCdValue, "Garage");
//		wait(1);
//		sendText(dwellingChevron.year, "1999");
//		wait(1);
//		sendText(dwellingChevron.length, "99");
//		wait(1);
//		sendText(dwellingChevron.width, "99");
//		wait(1);
//		sendText(dwellingChevron.itemLimit1Value, "1,000,000");
//		wait(1);
//		click(dwellingChevron.addCoverageItem);
//		wait(1);
//	
//	
	
	
	}
	
	@When("User selects Note Type")
	public void User_selects_Note_Type() {
		selectDropdownText(dashboard.ddNoteTemplate, "General Note");
		wait(1);
	}
	@When("User selects Note Priority")
	public void User_selects_Note_Priority() {
		selectDropdownText(dashboard.ddNotePriority, "High");
		wait(1);
	}
	@When("User enters a Note")
	public void User_enters_a_Note() {
		sendText(dashboard.noteMemo, "Note that was entered by the User");
		wait(1);
	}
	@When("User clicks Add Note button")
	public void User_clicks_Add_Note_button() {
		click(dashboard.addNote);
		wait(1);
	}
	
	 
	
	

}