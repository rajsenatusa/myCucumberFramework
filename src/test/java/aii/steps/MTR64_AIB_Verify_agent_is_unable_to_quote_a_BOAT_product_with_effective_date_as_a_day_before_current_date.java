package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR64_AIB_Verify_agent_is_unable_to_quote_a_BOAT_product_with_effective_date_as_a_day_before_current_date
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String quoteNumber;

	@When("User enters all required information on policy information screen <mtr64>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr64() {

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

	@When("User enters AIB product selection information and current date minus 1 day as effective date <mtr64>")
	public void user_enters_aib_product_selection_information_and_current_date_minus_1_day_as_effective_date_mtr64() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate.minusDays(1)));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);
	}

	@When("User enters all required information on AIB quote screen for <mtr64>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_mtr64() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate.minusDays(1)));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 5);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects liability coverage on quote screen for <mtr64>")
	public void user_selects_liability_coverage_on_quote_screen_for_mtr64() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$100,000/$300,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "No Coverage");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "Yes");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "60 days");
		click(dwellingChevron.btnSave);
		wait(5);
//		click(dwellingChevron.btnNext);
//		wait(3);
	}

	@When("User validates hardstop message 'Policies back dated greater than 0 days Must Be Approved' has been displayed")
	public void user_validates_hardstop_message_policies_back_dated_greater_than_0_days_must_be_approved_has_benn_displayed()
			throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		verify_AnyText_IsVisible(driver, "Policies back dated greater than 0 days Must Be Approved  ");
		wait(5);
	}

	@When("User clicks Review Chevron and validates basic premium equals zero")
	public void user_clicks_Review_Chevron_and_validates_basic_premium_equals_zero() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		String basicPremium = driver.findElement(By.id("BasicPolicyPremium")).getText().toString();
		try {
			if (basicPremium.equals("$0.00")) {
				Hooks.scenario.log("Basic Premium equals to Zero as expected");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Hooks.scenario.log("Basic Premium has a value different than zero. Test Failed");
		}
	}
	@When("User takes note of the quote number for <mtr64>")
	public void user_takes_note_of_the_quote__number_for_mtr64() throws Exception {
		try {
			quoteNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Quote Number: " + quoteNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("User clicks Home button and validates created quote listed there and completes test")
	public void user_clicks_Home_button_and_validates_created_quote_listed_there_and_completes_test() throws Exception {
		click(dashboard.btnHome);
		wait(2);
		click(driver.findElement(By.id("Tab_Recent")));
		wait(2);
		verify_AnyLabel_IsVisible(driver, quoteNumber);
		Hooks.scenario.log("Test Case Completed!");
	}
}
