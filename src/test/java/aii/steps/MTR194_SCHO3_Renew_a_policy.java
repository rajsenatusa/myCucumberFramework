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

public class MTR194_SCHO3_Renew_a_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum1;
	
	@When("User enters all required information on SC policy information screen <mtr194>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr194() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "7743 Park Gate Dr, North Charleston");
		sendText(quote.txtZipCode, "29418");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on SC HO3 quote screen <mtr194>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr194() {
		// Quote Policy Chevron information was filled here

		sendText(policyChevron.txtProducerCodeSel, "AG1777A1");
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, "Amica");
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

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on SC HO3 dwelling screen <mtr194>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr194() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "2000");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3-tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
		selectDropdownText(dwellingChevron.ddFireAlarm, "None");
		selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr194>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr194() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("SC HO3 NB policy has been creation failed");
		}
		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum1 = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User process manual renewal on the policy <mtr194>")
	public void user_does_manual_renewal_on_the_polcy_mtr194() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(10);
		closeUnnecessaryTabs();	
	}
	@When("User searches for the policy number <mtr194>")
	public void user_searches_policy_for_mtr194() {
		sendText(dashboard.txtSearchBar, policyNum1);
		click(dashboard.search);
		wait(3);
	}
	@Then("User validates Renewal has been processed and validates Renewal tx on history chevron")
	public void user_validates_Renewal_has_Been_processed_and_validates_Renewal_tx_on_history_chevron() throws Exception {
		verify_AnyText_IsVisible(driver, "Renewal");
	}
	@And("User clicks Policy File Chevron <mtr194>")
	public void user_clicks_policy_file_chevron_mtr194() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User validates Renewal Declaration Form Link is visible and completes test <mtr194>")
	public void user_validateS_Renewal_Declaration_Form_Link_is_visible_and_completes_test_mtr194() throws Exception {
		verify_AnyLink_IsVisible(driver, "Renewal Declaration");
		Hooks.scenario.log("Test Case Completed!");
	}
}
