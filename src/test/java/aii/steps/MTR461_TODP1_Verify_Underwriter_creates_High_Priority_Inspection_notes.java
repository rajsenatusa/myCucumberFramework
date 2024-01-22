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

public class MTR461_TODP1_Verify_Underwriter_creates_High_Priority_Inspection_notes extends CommonMethods {
	static LocalDateTime currentDate = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static String policyNum;
	static String closeUnnecessaryTabs;
	static String getPolicyNumber;

	@And("User validates TODP1 policy has been created successfully and takes note of the policy number for <mtr461>")
	public void User_validates_TODP1_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr461()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut DP1 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}

		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("New Business TakeOut DP1 policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number for <mtr461>")
	public void User_searches_for_Policy_Number_for_mtr461() {
		wait(3);
		driver.findElement(By.id("ToolbarSearchText")).sendKeys(policyNum);		
//		sendText(dashboard.txtSearchBar, policyNum);
		driver.findElement(By.id("ToolbarSearch")).click();
//		click(dashboard.search);
		wait(3);
	}

	@When("User creates an Inspection Note")
	public void User_creates_an_Inspection_Note() throws Exception {
		selectDropdownText(dashboard.ddNoteTemplate, "Inspection Note");
		wait(1);
		selectDropdownText(dashboard.noteAction, "Agent Task");
		wait(1);
		selectDropdownText(dashboard.ddNotePriority, "High");
		wait(1);
		sendText(dashboard.noteMemo, "High Priority Inspection Note that was entered by Underwriter");
		wait(1);
		click(dashboard.addNote);
		wait(1);

		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User validates Inspection and General Notes have been created successfully in Notes List")
	public void User_validates_Inspection_and_General_Notes_have_been_created_successfully_in_Notes_List()
			throws Exception {
		wait(3);
		click(dashboard.btnExpandDP1);
		verify_AnyText_IsVisible(driver, "Memo: A High Priority Inspection Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("A High Priority Inspection Note has been created successfully");
		attachScreenShot(driver);
		wait(3);
		click(dashboard.btnExpandGeneralNote);
		verify_AnyText_IsVisible(driver, "Memo: General Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("General Note has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User verifies that Agent can see Inspection and General Notes")
	public void User_verifies_that_Agent_can_see_General_Note() throws Exception {
		wait(5);
		click(dashboard.btnExpandDP1);
		verify_AnyText_IsVisible(driver, "Memo: A High Priority Inspection Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("A High Priority Inspection Note has been created successfully");
		attachScreenShot(driver);
		wait(5);
		click(dashboard.btnExpandGeneralNote);
		verify_AnyText_IsVisible(driver, "Memo: General Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("General Note has been created successfully");
		attachScreenShot(driver);
	}

	@When("User enters all required information on policy information screen for <mtr461>")
	public void user_enters_all_required_information_on_policy_information_screen_for_mtr461() {
		wait(2);
		// quote level information was filled here

		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, ConfigsReader.getProperty("address"));
		sendText(quote.txtZipCode, ConfigsReader.getProperty("zipcode"));
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnSaveAndQuote);
		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("scproducerselection"));
		wait(3);
	}

	@When("User enters product selection information for TODP1 and current date for <mtr461>")
	public void User_enters_product_selection_information_for_TODP1_and_current_date_for_mtr461() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		wait(1);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);

	}

	@Then("User verifies that Underwriter Manager can Delete and Save General Note")
	public void User_verifies_that_Underwriter_Manager_can_Delete_and_Save_General_Note() throws Exception {
		wait(1);
		click(dashboard.deleteLink);
		click(dashboard.dialogOK);
		wait(3);
		verify_AnyText_NotVisible(driver, "General Note");
		Hooks.scenario.log("User is not able to see General Note");
		Hooks.scenario.log("No General Note");
		attachScreenShot(driver);

	}
}
