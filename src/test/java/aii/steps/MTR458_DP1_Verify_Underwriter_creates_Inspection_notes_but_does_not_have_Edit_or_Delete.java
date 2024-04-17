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
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
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
	@When("User enters all required information on DP1 quote screen <mtr458>")
	public void user_enters_all_required_information_on_dp1_quote_screen_mtr458() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypedp1"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupieddp1"));
		selectDropdownText(policyChevron.ddPropertyManaged, ConfigsReader.getProperty("propertymanaged"));
		//selectDropdownText(policyChevron.ddShortTermRental, ConfigsReader.getProperty("shorttermrental"));
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on policy information screen <mtr458>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr458() {
		wait(2);
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters DP1 product selection information and current date as effective date <mtr458>")
	public void user_enters_dp1_product_selection_information_and_current_date_as_effective_date_mtr458() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp1);
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
