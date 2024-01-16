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

public class MTR460_TOMHO_VerifyUnderwritercreatesHighPriorityGeneralnotes extends CommonMethods {

	static String policyNum;
	static String closeUnnecessaryTabs;
	static String getPolicyNumber;

	@And("User validates TOMHO policy has been created successfully and takes note of the policy number for <mtr460>")
	public void User_validates_TOMHO_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr460()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut MHO policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}

		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("New Business TakeOut MHO policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number for <mtr460>")
	public void User_searches_for_Policy_Number_for_mtr460() {
		wait(5);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User creates a New Note for <mtr460>")
	public void User_creates_a_New_Note_for_mtr460() throws Exception {
		selectDropdownText(dashboard.ddNoteTemplate, "Company Privileged Note");
		wait(1);
		selectDropdownText(dashboard.ddNotePriority, "Low");
		wait(1);
		sendText(dashboard.noteMemo, "Company Privileged Note that was entered by Underwriter");
		wait(1);
		click(dashboard.addNote);
		wait(1);

		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);

	}

}
