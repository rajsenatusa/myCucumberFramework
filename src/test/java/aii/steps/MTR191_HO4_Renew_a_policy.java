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

public class MTR191_HO4_Renew_a_policy extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr191>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr191() {

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
	@When("User enters all required information on HO4 quote screen with current date as prior policy date <mtr191>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr191() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, "No");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen <mtr191>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr191() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User validates that HO4 policy has been created successfully and note policy number <mtr191>")
	public void user_validates_that_ho4_policy_has_been_created_successfully() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("HO4 NB policy has been creation failed!");
		}
		wait(5);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
 
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the policy number <mtr191>")
	public void user_searches_policy_for_mtr191() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User process manual renewal on the policy <mtr191>")
	public void user_does_manual_renewal_on_the_polcy_mtr191() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(10);
		closeUnnecessaryTabs();	
	}
	@Then("User validates Renewal has been processed and validates Renewal tx on history chevron <mtr191>")
	public void user_validates_Renewal_has_Been_processed_and_validates_Renewal_tx_on_history_chevron_mtr191() throws Exception {
		verify_AnyText_IsVisible(driver, "Renewal");
	}
	@And("User clicks Policy File Chevron <mtr191>")
	public void user_clicks_policy_file_chevron_mtr191() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User validates Renewal Declaration Form Link is visible and completes test <mtr191>")
	public void user_validateS_Renewal_Declaration_Form_Link_is_visible_and_completes_test_mtr191() throws Exception {
		verify_AnyLink_IsVisible(driver, "Renewal Declaration");
		Hooks.scenario.log("Test Case Completed!");
	}
}
