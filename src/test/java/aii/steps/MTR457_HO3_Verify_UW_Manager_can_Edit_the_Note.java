package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR457_HO3_Verify_UW_Manager_can_Edit_the_Note extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User validates NB HO3 policy has been created successfully and takes note of the policy number for <mtr457>")
	public void User_validates_NB_HO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr457()
			throws Exception {

		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("NB HO3 policy has been created successfully");
		} else {
			System.out.println("NB HO3 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("New Business HO3 policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User Searchs for Policy Number for <mtr457>")
	public void User_searches_for_Policy_Number_for_mtr457() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User creates a New Note for <mtr457>")
	public void User_creates_a_New_Note_for_mtr457() throws Exception {
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

	@Then("User validates a New Note has been created successfully in Notes List <mtr457>")
	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List_mtr457() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_IsVisible(driver, "Memo: Company Privileged Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);
	}

	@Then("User verifies that Agent cannot see Company Privileged Note")
	public void User_verifies_that_Agent_cannot_see_Company_Privileged_Note() throws Exception {
		wait(3);
		verify_AnyText_NotVisible(driver, "Company Privileged Note");
		Hooks.scenario.log("Agent is not able to see Company Privileged Note");
		Hooks.scenario.log("No Company Privileged Note");
		attachScreenShot(driver);
	}

	@When("User creates a General Note")
	public void User_creates_a_General_Note() throws Exception {
		selectDropdownText(driver.findElement(By.id("Note.TemplateId")), "General Note");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Note.PriorityCd")), "Low");
		wait(1);
		sendText(driver.findElement(By.id("Note.Memo")), "General Note that was entered by Underwriter");
		wait(1);
		click(dashboard.addNote);
		wait(1);
		Hooks.scenario.log("General Note has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User validates a General Note has been created successfully in Notes List <mtr457>")
	public void User_validates_a_General_Note_has_been_created_successfully_in_Notes_List_mtr457() throws Exception {
		wait(7);
		click(dashboard.btnExpandHO3);
		verify_AnyText_IsVisible(driver, "Memo: General Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("General Note has been created successfully");
		attachScreenShot(driver);
	}

	@Then("User verifies that Agent can see General Note")
	public void User_verifies_that_Agent_can_see_General_Note() throws Exception {
		wait(7);
		click(dashboard.btnExpandHO3);
		verify_AnyText_IsVisible(driver, "Memo: General Note that was entered by Underwriter");
		Hooks.scenario.log("New General Note displayed successfully!");
		Hooks.scenario.log("General Note displayed by Agent");
		attachScreenShot(driver);
	}

	@Then("User verifies that Edit or Delete links are displayed")
	public void User_verifies_that_no_Edit_or_Delete_links_are_displayed() throws Exception {
		wait(3);
		verify_AnyText_IsVisible(driver, "Edit Delete");
		Hooks.scenario.log("Underwriter Manager can see Edit or Delete links");
		Hooks.scenario.log("Edit or Delete links display");
		attachScreenShot(driver);
	}

	@Then("User verifies that Underwriter Manager can Edit and Save General Note")
	public void User_verifies_that_Underwriter_Manager_can_Edit_and_Save_General_Note() throws Exception {
		wait(1);
		click(dashboard.editLink);
		wait(1);
		sendText(dashboard.noteMemo,
				"General Note that was entered by Underwriter. AND General Note has been edited by Underwriter Manager.");
		wait(1);
		click(dashboard.saveNote);
		wait(1);
		click(dashboard.btnExpandHO3);
		verify_AnyText_IsVisible(driver,
				"General Note that was entered by Underwriter. AND General Note has been edited by Underwriter Manager.");
		Hooks.scenario.log("Edited General Note displayed successfully!");
		Hooks.scenario.log("General Note edited by Underwriter Manager");
		attachScreenShot(driver);

	}
}
