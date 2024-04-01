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

public class MTR432_DP1_As_an_Underwriter_I_would_like_the_ability_to_process_a_rewrite_New_on_Cancelled_NB_policy
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@Then("User validates NB DP1 policy has been created successfully and takes note of the policy number for <mtr432>")
	public void user_validates_that_DP1_policy_has_been_created_successfully_and_akes_note_of_the_policy_number_mtr432()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, DP1 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

	}

	@When("User enters all required information on DP1 quote screen <mtr432>")
	public void user_enters_all_required_information_on_dp1_quote_screen_mtr432() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("ProducerCode"));
		wait(1);
		(policyChevron.txtPreviousPolicyExpDate).click();
		wait(1);
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypedp1"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupieddp1"));
		selectDropdownText(policyChevron.ddPropertyManaged, ConfigsReader.getProperty("propertymanaged"));
		// selectDropdownText(policyChevron.ddShortTermRental,
		// ConfigsReader.getProperty("shorttermrental"));
		wait(1);
		click(policyChevron.btnNext);
		wait(3);

	}

	@And("User selects Cancellation Type as Insured <mtr432>")
	public void User_selects_cancellation_type_as_Insured_mtr432() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User selects Property Sold as reason <mtr432>")
	public void User_selects_property_sold_as_reason_mtr432() {
		selectDropdownText(historyChevron.ddReason, "Property Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User sets the effective date as after 1 month from the current date and validates error message <mtr432>")
	public void User_sets_the_effective_date_as_after_1_month_from_the_current_date_and_validates_error_messages_mtr432()
			throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		wait(3);
		click(historyChevron.descriptionbox);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(3);
		click(historyChevron.btnStart);
		reviewChevron.btnProcess.click();
		attachScreenShot(driver);
		wait(2);
	}

	@And("User enters Coverage A Dwelling as 350000")
	public void User_enters_Coverage_A_Dwelling_as_350000() {
		scrollToElement(driver.findElement(By.id("CovALimit")));
		wait(4);
		dwellingChevron.CovALimit.clear();
		wait(3);
		sendText(dwellingChevron.CovALimit, "350000");

	}

	@When("User enters all required information on HO4 review screen <mtr432>")
	public void user_enters_all_required_information_on_ho4_review_screen_mtr432() {
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		selectDropdownText(reviewChevron.ddPaymentType, "None");
		reviewChevron.btnProcess.click();
	}

	@And("User validates Rewrite - New Business <mtr432>")
	public void User_validates_Rewrite_New_Business_mtr432() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_Description"));

		if (validate.getText().equalsIgnoreCase("Rewrite - New Business")) {
			System.out.println("Test passed, DP1 Rewrite - New Business has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(1);
		attachScreenShot(driver);

	}

	@When("User validates Coverage A Dwelling is 350000")
	public void User_validates_Coverage_A_Dwelling_is_350000() throws Exception {
		wait(2);
		scrollToElement(driver.findElement(By.id("CovALimit_text")));
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A- Dwelling $350000");
		attachScreenShot(driver);
	}

}
