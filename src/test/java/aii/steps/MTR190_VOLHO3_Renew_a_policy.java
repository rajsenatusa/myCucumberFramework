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

public class MTR190_VOLHO3_Renew_a_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr190>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr190() {

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
	@When("User enters all required information on HO3 quote screen <mtr190>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr190() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr190>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr190() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
//		selectDropdownText(dwellingChevron.bCEG, "98");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		click(dwellingChevron.rbBasicPackage);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr190>")
	public void user_completes_required_information_on_dwelling_chevron_mtr190() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		sendText(dwellingChevron.txtYearElectrical, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User finalizes transaction for VOL HO3 <mtr190>")
	public void user_finalizes_transaction_for_VOL_HO3_mtr190() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr190>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr190()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the policy number <mtr190>")
	public void user_searches_policy_for_mtr190() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User process manual renewal on the policy <mtr190>")
	public void user_does_manual_renewal_on_the_polcy_mtr190() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(10);
		closeUnnecessaryTabs();	
	}
	@Then("User validates Renewal has been processed and validates Renewal tx on history chevron <mtr190>")
	public void user_validates_Renewal_has_Been_processed_and_validates_Renewal_tx_on_history_chevron_mtr190() throws Exception {
		verify_AnyText_IsVisible(driver, "Renewal");
	}
	@And("User clicks Policy File Chevron <mtr190>")
	public void user_clicks_policy_file_chevron_mtr190() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User validates Renewal Declaration Form Link is visible and completes test <mtr190>")
	public void user_validateS_Renewal_Declaration_Form_Link_is_visible_and_completes_test_mtr190() throws Exception {
		verify_AnyLink_IsVisible(driver, "Renewal Declaration");
		Hooks.scenario.log("Test Case Completed!");
	}
}
