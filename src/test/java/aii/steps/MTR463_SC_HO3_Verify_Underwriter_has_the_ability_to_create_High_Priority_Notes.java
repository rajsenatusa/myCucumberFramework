package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR463_SC_HO3_Verify_Underwriter_has_the_ability_to_create_High_Priority_Notes extends CommonMethods {
	static LocalDateTime currentDate = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static String policyNum;
	static String closeUnnecessaryTabs;
	static String getPolicyNumber;
	
	
	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr463>")
	public void User_validates_SC_HO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr463()
			throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("New Business SC HO3 policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters SC HO3 product selection information and current date as effective date for <mtr463>")
	public void user_enters_SC_HO3_product_selection_information_and_current_date_as_effective_date_for_mtr463() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 2);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);		
	}
	
	@When("User enters all required information on SC HO3 quote screen <mtr463>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr463() {
		// Quote Policy Chevron information was filled here

		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("scproducerselection"));
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("scpreviouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");

		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}
	@When("User creates an Inspection Note for <mtr463>")
	public void User_creates_an_Inspection_Note_for_mtr463() throws Exception {
//		selectDropdownText(dashboard.ddNoteTemplate, "Inspection Note");
		driver.findElement(By.id("Note.TemplateId")).sendKeys("Inspection Note");
		wait(1);
//		selectDropdownText(dashboard.noteAction, "Agent Task");
		driver.findElement(By.id("Note.Action")).sendKeys("Agent Task");
		wait(1);
//		selectDropdownText(dashboard.ddNotePriority, "High");
		driver.findElement(By.id("Note.PriorityCd")).sendKeys("Urgent");
		wait(1);
//		sendText(dashboard.noteMemo, "Urgent Priority Inspection Note that was entered by Underwriter");
		driver.findElement(By.id("Note.Memo")).sendKeys("Urgent Priority Inspection Note that was entered by Underwriter");
		wait(1);
//		click(dashboard.addNote);
		driver.findElement(By.id("AddNote")).click();
		wait(1);

		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);

	}
	@Then("User validates a New Inspection Note has been created successfully in Notes List <mtr463>")
	public void User_validates_a_New_Inspection_Note_has_been_created_successfully_in_Notes_List_mtr463() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_IsVisible(driver, "Urgent Priority Inspection Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("Urgent Priority Inspection Note has been created successfully");
		attachScreenShot(driver);

}	@When("User creates a New Priviliged Note for <mtr463>")
	public void User_creates_a_New_Priviliged_Note_for_mtr463() throws Exception {
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
	@Then("User validates a New Priviliged Note has been created successfully in Notes List <mtr463>")
	public void User_validates_a_New_Priviliged_Note_has_been_created_successfully_in_Notes_List_mtr463() throws Exception {
	wait(7);
	click(dashboard.btnExpand);
	verify_AnyText_IsVisible(driver, "Company Privileged Note that was entered by Underwriter");
	Hooks.scenario.log("New Note has been created successfully!");
	Hooks.scenario.log("Company Privileged Note has been created successfully");
	attachScreenShot(driver);
}	
	@When("User Searchs for Policy Number for <mtr463>")
	public void User_searches_for_Policy_Number_for_mtr463() {
		wait(3);
//		driver.findElement(By.id("ToolbarSearchText")).sendKeys(policyNum);		
		sendText(dashboard.txtSearchBar, policyNum);
//		driver.findElement(By.id("ToolbarSearch")).click();
		click(dashboard.search);
		wait(3);
	}
	@Then("User verifies that Underwriter Manager can Edit and Save Inspection Note for <mtr463>")
	public void User_verifies_that_Underwriter_Manager_can_Edit_and_Save_Inspection_Note_formtr463() throws Exception {
		wait(1);
		click(dashboard.editLink);
		wait(1);
		sendText(dashboard.noteMemo,
				"Urgent Priority Inspection Note that was entered by Underwriter. AND Inspection Note has been edited by Underwriter Manager.");
		wait(1);
		click(dashboard.saveNote);
		wait(1);
		click(dashboard.btnExpandHO3);
		verify_AnyText_IsVisible(driver,
				"Urgent Priority Inspection Note that was entered by Underwriter. AND Inspection Note has been edited by Underwriter Manager.");
		Hooks.scenario.log("Edited Inspection Note displayed successfully!");
		Hooks.scenario.log("Inspection Note edited by Underwriter Manager");
		attachScreenShot(driver);

	}
	@Given("User login to Spin as SC Standard Agent")
	public void user_login_to_spin_as_standard_agent() throws Throwable {
		sendText(login.username, ConfigsReader.getProperty("scusername"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.btnSignIn);
		wait(1);
	}
}
















