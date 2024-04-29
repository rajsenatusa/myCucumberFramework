package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR193_TOHO3_Renew_a_takeout_policy_FHO3 extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters TOHO3 product selection information and effective date <mtr193>")
	public void user_enters_TOHO3_product_selection_information_and_effective_date_mtr193() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionToho3);
		
	}

	@When("User Searchs for Policy Number for <mtr193>")
	public void User_searches_for_Policy_Number_for_mtr193() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}

	@When("User enters all required information on TOHO3 quote screen <mtr193>")
	public void user_enters_all_required_information_on_TOHO3_quote_screen_mtr193() {
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
		
	}

	@Then("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr193>")
	public void User_validates_that_TOHO3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr193()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
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
}