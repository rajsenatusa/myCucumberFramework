package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR3172_HO4_HO4AgentChangeDateTransaction30DAYS extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User takes note of the policy number for <mtr3172>")
	public void user_takes_note_of_the_policy_number_for_mtr3172() throws Exception {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters all required information on policy information screen <mtr3172>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr3172() {

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
	@When("User enters all required information on HO4 quote screen with current date as prior policy date <mtr3172>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr3172() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, "No");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen <mtr3172>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr3172() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User searches for Policy Number for <mtr3172>")
	public void user_searches_for_policy_number_for_mtr3172() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User clicks Change Date Transaction Selection")
	public void User_clicks_Change_Date_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Change Date");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User selects current date plus 31 days as new effective date")
	public void User_selects_current_date_plus_31_days_as_new_effective_date() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(31)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@And("User validates 'Requested effective date change requires underwriting review' text is visible")
	public void User_validates_requested_effective_date_change_requires_underwriting_review_text_visible()
			throws Exception {
		verify_AnyText_IsVisible(driver, "Requested effective date change requires underwriting review");
	}

	@And("User selects current date plus 30 days as new effective date")
	public void User_selects_current_date_plus_30_days_as_new_effective_date() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@And("User process transaction and clicks plus sign and completes test")
	public void User_process_transaction_and_clicks_plus_sign_and_completes_test() throws Exception {
		click(reviewChevron.btnProcess);
		wait(5);
		click(historyChevron.btnExpand);
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
