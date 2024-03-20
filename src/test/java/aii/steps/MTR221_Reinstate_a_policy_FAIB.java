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

public class MTR221_Reinstate_a_policy_FAIB extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters product selection information for AIB and current effective date <221>")
	public void user_enters_product_selection_information_for_AIB_and_() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);
	}

	@Then("User validates that AIB policy has been created successfully and takes note of the policy number for <mtr221>")
	public void user_validates_that_AIB_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_for_mtr221()
			throws Exception {

		verify_AnyfirstText_IsDisplayed(driver, "\r\n" + "New Business has been processed for" + policyNum);
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

	@Then("User validates that AIB policy has been canceled successfully")
	public void user_validates_that_AIB_policy_has_been_canceled_successfully() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "\r\n" + "Cancellation has been processed for" + policyNum);
		attachScreenShot(driver);
		wait(2);
	}

	@When("User Searchs for Policy Number for <mtr221>")
	public void User_searches_for_Policy_Number_for_mtr221() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects Boat Sold as reason <mtr221>")
	public void User_selects_boat_sold_as_reason_mtr221() {
		selectDropdownText(historyChevron.ddReason, "Boat Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

}
