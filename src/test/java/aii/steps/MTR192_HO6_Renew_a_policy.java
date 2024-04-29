package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR192_HO6_Renew_a_policy extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters HO6 product selection information and effective date <mtr192>")
	public void user_enters_ho6_product_selection_information_and_effective_date_mtr192() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
		try {
			policyNum = driver.findElement(By.id("QuoteAppSummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@When("User Searchs for Policy Number for <mtr192>")
	public void User_searches_for_Policy_Number_for_mtr192() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}
	@When("User enters all required information on HO6 quote screen <mtr192>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr192() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@Then("User validates that HO6 policy has been created successfully and takes note of the policy number <mtr192>")
	public void User_validates_that_HO6_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr192()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO6 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		getInForcePremiumFees(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@And("User changes insured information")
	public void User_changes_insured_information() {
		sendText(policyChevron.insuredMiddleName, "test");
		click(policyChevron.btnSave);
		click(policyChevron.btnFinalize);
		click(closeoutChevron.btnProcess);
	}
	
	
}