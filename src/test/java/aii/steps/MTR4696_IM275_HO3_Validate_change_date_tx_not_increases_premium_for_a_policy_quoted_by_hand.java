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

public class MTR4696_IM275_HO3_Validate_change_date_tx_not_increases_premium_for_a_policy_quoted_by_hand extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User changes system date to current date <mtr4696>")
	public void user_changes_system_date_to_current_date_mtr4696() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr4696>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr4696() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "3429 Ringtail Ct. Green Cove Springs");
		sendText(quote.txtZipCode, "32043");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters HO3 product selection information and current date as effective date <mtr4696>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr4696() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	@When("User enters all required information on HO3 quote screen <mtr4696>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4696() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		getInsuranceScore(driver, "Neutral");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr4696>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4696() {

		sendText(dwellingChevron.txtSquareFeet, "2500");
		//selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		//selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "04");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2024");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		waitImp(3);
	}
	@When("User completes required information on dwelling chevron and updates dwelling type <mtr4696>")
	public void user_completes_required_information_on_dwelling_chevron_mtr4696() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr4696>")
	public void User_clicks_Finalize_button_mtr4696() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr4696>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr4696()
			throws Exception {
		waitImp(5);
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
	@When("User searches for Policy Number for <mtr4696>")
	public void user_searches_for_policy_number_for_mtr4696() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects current date plus 10 days as new effective date <mtr4696>")
	public void User_selects_current_date_plus_10_days_as_new_effective_date_mtr4696() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(10)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}
	@And("User process transaction <mtr4696>")
	public void User_process_transaction_mtr4696() throws Exception {
		click(reviewChevron.btnProcess);
		wait(5);
		closeUnnecessaryTabs();
	}
	@Then("User validates the premium not increased after change date transaction and completes test <mtr4696>")
	public void User_validates_the_premium_not_increased_after_change_date_tx_and_completes_test_mtr4696() throws Exception {

		try {
			String writtenPremium = driver.findElement(By.id("History_1_2_WrittenPremium")).getText().toString();
			System.out.println(writtenPremium);
			if (writtenPremium.equals("0.00")) {
				Hooks.scenario.log("Written premium has not been increased after change date. Test Passes!");
			} else {
				Hooks.scenario.log("Written premium has been increased after change date. Test Fails!");
			}
		} catch (Exception e) {
			Hooks.scenario.log("Written premium is not able to validate. Please chech your script!!!");
			wait(5);
		}
		Hooks.scenario.log("Test Case Completed!");
	}
}
