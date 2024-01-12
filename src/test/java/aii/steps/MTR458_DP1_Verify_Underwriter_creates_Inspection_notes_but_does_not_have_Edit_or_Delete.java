package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
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
				System.out.println("NB MHO3 policy has been created successfully");
			} else {
				System.out.println("NB MHO3 policy creation failed!");
			}
			closeUnnecessaryTabs();
			getPolicyNumber(driver);
			getInForcePremium(driver);
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
			selectDropdownText(dashboard.ddNotePriority, "High");
			wait(1);
			sendText(dashboard.noteMemo, "Company Privileged Note that was entered by Underwriter");
			wait(1);
			click(dashboard.addNote);
			wait(1);
			
			Hooks.scenario.log("Company Privileged Note has been created successfully");
			attachScreenShot(driver);
			
		}
	
	
	
	
	
	
	
	
	
	
	
}
