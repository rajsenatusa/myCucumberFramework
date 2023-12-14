package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR1413_MHO_MHOAgentChangeDateTransaction30DAYS extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters MHO3 product selection information and effective date as current date")
	public void user_enters_mho3_product_selection_information_and_effective_date_as_current_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionMho3);
	}
	@When("User enters all required information on policy information screen <mtr1413>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1413() {

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
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date <mtr1413>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_mtr1413() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on MHO3 dwelling screen <mtr1413>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_mtr1413() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "120000");
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);

	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
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

	@And("User selects Change Date Transaction")
	public void User_selects_change_date_transaction() {
		selectDropdownText(dashboard.ddSelectTransaction, "Change Date");
		wait(1);
		click(dashboard.btnSelect);
		wait(2);
	}

	@And("User sets new effective date as current date plus <31> days")
	public void User_sets_new_effective_date_as_current_date_plus_31_days() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(31)));
		driver.findElement(By.xpath("//*[@id=\"TransactionSelection\"]/table[3]/tbody/tr[1]/th[2]/label")).click();
		wait(1);
	}

	@And("User clicks Start")
	public void User_clicks_start() {
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User validates 'Requested effective date change requires underwriting review' message has been displayed")
	public void User_validates_error_message_has_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Requested effective date change requires underwriting review");
	}

	@When("User searches for the policy <mtr1413>")
	public void user_searches_policy_for_mtr1413() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus <30> days")
	public void User_sets_new_effective_date_as_current_date_plus_30_days() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(30)));
		driver.findElement(By.xpath("//*[@id=\"TransactionSelection\"]/table[3]/tbody/tr[1]/th[2]/label")).click();
		wait(1);
	}

	@When("User clicks process and close unnecessary tabs")
	public void user_clicks_process_and_close_unnecessary_tabs() throws Exception {
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}

	@Then("User validates Change Date text with select dates have been displayed")
	public void user_validates_change_date_text_with_select_dates_have_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Change Date");
		verify_AnyText_IsVisible(driver, "Change Effective Date from " + dtf.format(currentDate) + " to "
				+ dtf.format(currentDate.plusDays(30)));
		click(historyChevron.btnExpand);
		Hooks.scenario.log("Test case completed!");
	}

}
