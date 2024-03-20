package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR219_Reinstate_a_policy_Takeout_FMHPD extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters product selection information for TOMHPD and current effective date <219>")
	public void user_enters_product_selection_information_for_tomhpd_and_() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomhpd);
	}

	@Then("User validates that TOMHPD policy has been created successfully and takes note of the policy number for <mtr219>")
	public void user_validates_that_tomhpd_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr219()
			throws Exception {

		verify_AnyfirstText_IsDisplayed(driver, "\r\n" + "Renewal has been processed for" + policyNum);
		attachScreenShot(driver);
		wait(2);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number for <mtr219>")
	public void User_searches_for_Policy_Number_for_mtr219() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation Type as Insured <mtr219>")
	public void User_selects_cancellation_type_as_Insured_mtr219() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User sets the effective date as after 2 months from the current date")
	public void User_sets_the_effective_date_as_after_2_months_from_the_current_date() throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusMonths(2)));
		wait(3);
		click(historyChevron.descriptionbox);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(3);
		click(historyChevron.btnStart);
		wait(2);

	}

	@Then("User validates that TOMHPD policy has been canceled successfully")
	public void user_validates_that_tomhpd_policy_has_been_canceled_successfully() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "\r\n" + "Cancellation has been processed for" + policyNum);
		attachScreenShot(driver);
		wait(2);
	}

	@And("User clicks Start Transaction <mtr219>")
	public void User_clicks_Start_Transaction_mtr219() {
		wait(4);

		click(driver.findElement(By.id("Transaction")));

//		click(dashboard.btnStartTransaction);
		wait(1);

	}

	@And("User clicks Process <mtr219>")
	public void User_clicks_Process_mtr219() {

		wait(1);
		click(closeoutChevron.btnProcess);
	}

	@Given("User selects Reinstatement <mtr219>")
	public void User_selects_Reinstatement_mtr219() throws Exception {

//		startTransaction();
		selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
		click(dashboard.btnSelect);
		attachScreenShot(driver);
		click(dashboard.btnStart);
		wait(5);
		click(closeoutChevron.btnProcess);
		wait(6);
		attachScreenShot(driver);
	}

}
