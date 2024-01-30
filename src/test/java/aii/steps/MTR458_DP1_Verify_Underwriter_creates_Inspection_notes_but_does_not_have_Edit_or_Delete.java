package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR458_DP1_Verify_Underwriter_creates_Inspection_notes_but_does_not_have_Edit_or_Delete
		extends CommonMethods {

	static String policyNum;

	@And("User validates NB DP1 policy has been created successfully and takes note of the policy number for <mtr458>")
	public void User_validates_NB_DP1_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr458()
			throws Exception {

		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("NB DP1 policy has been created successfully");
		} else {
			System.out.println("NB DP13 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("New Business DP1 policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number for <mtr458>")
	public void User_searches_for_Policy_Number_for_mtr458() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User creates a New Note for <mtr458>")
	public void User_creates_a_New_Note_for_mtr458() throws Exception {
		selectDropdownText(dashboard.ddNoteTemplate, "Inspection Note");
		wait(1);
		selectDropdownText(dashboard.noteAction, "Agent Task");
		selectDropdownText(dashboard.ddNotePriority, "Urgent");
		wait(1);
		sendText(dashboard.noteMemo, "Inspection Note that was entered by Underwriter");
		wait(1);
		click(dashboard.addNote);
		wait(1);

		Hooks.scenario.log("Inspection Note has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User verifies that no Edit or Delete links are displayed")
	public void User_verifies_that_no_Edit_or_Delete_links_are_displayed() throws Exception {
		wait(3);
//		click(dashboard.btnExpandDP1);
		driver.findElement(By.xpath("//*[@id=\"NotesList\"]/div/table/tbody/tr[2]/td[1]/i")).click();
		verify_AnyText_NotVisible(driver, "Edit or Delete links");
		Hooks.scenario.log("Underwriter is not able to see Edit or Delete links");
		Hooks.scenario.log("No Edit or Delete links");
		attachScreenShot(driver);
	}

	@Then("User validates a New Note has been created successfully in Notes List <mtr458>")
	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List_mtr458() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_IsVisible(driver, "Inspection Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("Inspection Note has been created successfully");
		attachScreenShot(driver);
	}

}
