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

public class MTR583_SC_HO3_Verify_Underwriter_is_able_to_Non_Renew_policy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters all required information on SC policy information screen <mtr583>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr583() {

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

	@When("User enters SC HO3 product selection information and current date as effective date")
	public void user_enters_sc_ho3_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 2);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
	}

	@When("User enters all required information on SC HO3 quote screen <mtr583>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr583() {
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

	@When("User enters all required information on SC HO3 dwelling screen <mtr583>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr583() {
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

	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr583>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr583() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr583>")
	public void user_searches_policy_for_mtr583() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects Roof Disrepair as reason and starts non renewal")
	public void user_selects_Roof_Disrepair_as_reason_and_starts_non_renewal() {

		selectDropdownText(dashboard.ddreasonCd, "Roof Disrepair");
		selectDropdownText(historyChevron.ddSubReason, "Roof exceeds typical life expectancy");
		click(historyChevron.btnAdd);
		wait(2);
		click(historyChevron.btnStart);
		wait(5);
	}

	@Then("User process transaction and clicks plus sign and validates UW reason message has been displayed and completes test")
	public void User_process_transaction_and_validates_and_completes_test_mtr583() throws Exception {
		click(reviewChevron.btnProcess);
		wait(7);
		click(historyChevron.btnExpand);
		verify_AnyText_IsVisible(driver,
				"A roof in a state of disrepair or with existing damage is ineligible; roof exceeds typical life expectancy.");
		Hooks.scenario.log("Test Case Completed!");
	}

}
