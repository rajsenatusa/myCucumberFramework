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

public class MTR4698_IM275_SC_HO3_Validate_change_date_tx_not_increases_premium_for_a_policy_quoted_by_hand
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User changes system date to current date <mtr4698>")
	public void user_changes_system_date_to_current_date_mtr4698() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User enters all required information on SC policy information screen <mtr4698>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr4698() {

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

	@When("User enters all required information on SC HO3 quote screen <mtr4698>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr4698() {
		// Quote Policy Chevron information was filled here

//		sendText(policyChevron.txtProducerCodeSel, "AG1777A1");
//		wait(3);
//		click(dwellingChevron.btnSave);
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

	@When("User enters all required information on SC HO3 dwelling screen <mtr4698>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr4698() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2024");
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

	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr4698>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr4698() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		attachScreenShot(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeUnnecessaryTabs();
	}

	@When("User searches for Policy Number for <mtr4698>")
	public void user_searches_for_policy_number_for_mtr4698() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects current date plus 10 days as new effective date <mtr4698>")
	public void User_selects_current_date_plus_10_days_as_new_effective_date_mtr4698() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(10)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@And("User process transaction <mtr4698>")
	public void User_process_transaction_mtr4698() throws Exception {
		click(reviewChevron.btnProcess);
		wait(5);
		closeUnnecessaryTabs();
	}

	@Then("User validates the premium not increased after change date transaction and completes test")
	public void User_validates_the_premium_not_increased_after_change_date_tx_and_completes_test() throws Exception {

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
