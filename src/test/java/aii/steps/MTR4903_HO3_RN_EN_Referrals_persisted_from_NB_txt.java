package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4903_HO3_RN_EN_Referrals_persisted_from_NB_txt extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@Then("User verifies EN HO6 policy has been created successfully <mtr4903>")
	public void User_verifies_EN_HO3_policy_has_been_created_successfully_mtr4903() throws Exception {
		wait(10);
		driver.switchTo().defaultContent();
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);

	}

	@And("User changes Coverage A Dwelling as 600000 <mtr4903>")
	public void User_changes_Coverage_A_Dwelling_as_600000_mtr4903() {
		sendText(dwellingChevron.txtCoverageA, "600000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$5,000");

	}

	@When("User takes note of the policy number for <mtr4903>")
	public void user_takes_note_of_the_policy_number_for_mtr4903() {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User Searchs for Policy Number for <mtr4903>")
	public void User_searches_for_Policy_Number_for_mtr4903() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User clicks Finalize for <mtr4903>")
	public void User_clicks_Finaliz_for_mtr4903() {
		reviewChevron.btnFinalize.click();
		reviewChevron.btnProcess.click();
		wait(2);
	}

	@Given("User enters EN Effective Date <mtr4903>")
	public void User_enters_EN_Effective_Date_mtr4903() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusMonths(13)));
		click(dashboard.btnStart);
		click(dashboard.btnStart);
	}

	@Then("User takes note of the application number <mtr4903>")
	public void User_takes_note_of_the_application_number_mtr4903_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User Searchs for Application Number for <mtr4903>")
	public void User_searches_for_Application_Number_for_mtr4903() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks More button then Take Ownership")
	public void User_clicks_More_button_then_Take_Ownership() {
		click(dashboard.ddMoreOptions);
		click(dashboard.takeOwnership);
		click(dashboard.dialogOK);
		wait(1);
	}
	@Given("User signs out for <mtr4903>")
	public void user_signs_out_for_mtr4903() {
		wait(2);
//		driver.findElement(By.id("UserMenu")).click();
		click(dashboard.btnUserMenu);
		wait(1);
//		driver.findElement(By.id("SignOutInMenu")).click();
		click(dashboard.btnSignOut);
		wait(2);
		Hooks.scenario.log("Sign out was clicked");
	}
	@Then("User validates the Submitter Issues <mtr4903>")
	public void User_validates_the_Submitter_Issues_mtr4903()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		attachScreenShot(driver);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased ");
		wait(3);
		attachScreenShot(driver);
		wait(2);

	}
	@Then("User verifies third persisted referral notes are displayed in Notes List <mtr4903>")
	public void User_verifies_third_persisted_referral_notes_are_displayed_in_Notes_List_mtr4903() throws Exception {
		
		wait(5);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver,
				"The following approvals are persisted:\r\n"
				+ "Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $50,000 require Underwriting Approval. (Building.CovALimit=600000, Building.CovCLimit=35000, TriggerRuleIf=AnyChange)");
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, " The following approvals are persisted:\r\n"
				+ "Change in Hurricane Deductible may only be changed at Renewal. (Building.HurricaneDeductible=5000, TriggerRuleIf=AnyChange)\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO6 policy form.");
		wait(5);
		click(dashboard.btnExpandHO6WC3);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for " + AppNum);

		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);
				
		}
	
}
