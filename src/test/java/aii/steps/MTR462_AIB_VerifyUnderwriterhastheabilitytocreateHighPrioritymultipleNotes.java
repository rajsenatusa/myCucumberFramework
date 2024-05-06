package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR462_AIB_VerifyUnderwriterhastheabilitytocreateHighPrioritymultipleNotes extends CommonMethods {
	static LocalDateTime currentDate = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static String policyNum;
	static String closeUnnecessaryTabs;
	static String getPolicyNumber;
	
	
	@And("User validates AIB policy has been created successfully and takes note of the policy number for <mtr462>")
	public void User_validates_AIB_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr462()
			throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("New Business AIB policy has been created successfully");
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number for <mtr462>")
	public void User_searches_for_Policy_Number_for_mtr462() {
		wait(3);
//		driver.findElement(By.id("ToolbarSearchText")).sendKeys(policyNum);		
		sendText(dashboard.txtSearchBar, policyNum);
//		driver.findElement(By.id("ToolbarSearch")).click();
		click(dashboard.search);
		wait(3);
	}

	@Then("User validates a General Note has been created successfully in Notes List <mtr462>")
	public void User_validates_a_General_Note_has_been_created_successfully_in_Notes_List_mtr462() throws Exception {
		wait(7);
		click(dashboard.btnExpandHO3);
		verify_AnyText_IsVisible(driver, "General Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("General Note has been created successfully");
		attachScreenShot(driver);
	}
	
	@When("User creates a New Priviliged Note for <mtr462>")
	public void User_creates_a_New_Priviliged_Note_for_mtr462() throws Exception {
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
	
	@Then("User validates a New Priviliged Note has been created successfully in Notes List <mtr462>")
	public void User_validates_a_New_Priviliged_Note_has_been_created_successfully_in_Notes_List_mtr462() throws Exception {
		wait(7);
		click(dashboard.btnExpand);
		verify_AnyText_IsVisible(driver, "Company Privileged Note that was entered by Underwriter");
		Hooks.scenario.log("New Note has been created successfully!");
		Hooks.scenario.log("Company Privileged Note has been created successfully");
		attachScreenShot(driver);
	}
	@When("User enters all required information on AIB quote screen for <mtr462>")
	public void user_enters_all_required_information_on_aib_quote_screen_formtr462() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
//		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		click(dwellingChevron.btnSave);
		wait(5);
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters AIB product selection information and current date as effective date for <mtr462>")
	public void user_enters_AIB_product_selection_information_and_current_date_as_effective_date_formtr462() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);
	}

}
