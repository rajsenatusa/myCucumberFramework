package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR370_MHO_NB_RNWL_END_ValidateBackdatingWindHailDeductibleChangesRequiresUWApproval
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime RnwlDate = currentDate.plusYears(1);
	static String policyNum;
	static String PolicyTerm02;
	static String applicationNumber;

	@When("User enters all required information on policy information screen and enters mobile park address for <mtr370>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_for_mtr370() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "8403 Millinockett Ln");
		sendText(quote.txtZipCode, "32825");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <mtr370>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_for_mtr370()
			throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnParkPropertyType);
		wait(1);
		clickMagnifierIcon(driver, "2");
		wait(2);
		switchToWindow(driver, "ParkSearchPage");
		wait(2);
		selectDropdownText(policyChevron.ddSearchPark, "Park Name");
		wait(1);
		sendText(policyChevron.txtParkName, "Shadow Hills Mobile Home Community");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "Shadow Hills Mobile Home Community");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Shadow Hills Mobile Home Community");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupiedmho3"));
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on MHO3 dwelling screen and sets covA as <65000>, checks wind exlusion button")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_65000_checks_wind_exclusion() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "65000");
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr370>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr370() throws Exception {
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

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr370>")
	public void user_clicks_make_payment_and_selects_cc_370() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr370>")
	public void user_makes_payment_with_credit_card_mtr370() {
		makeCCPayment();

		// Close unnecessary tabs
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
	}

	@When("User does auto renewal throught batch jobs <mtr370>")
	public void user_does_auto_renewal_mtr370() throws Exception {
		PolicyTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");
	}

	@When("User changes system date to prior renewal date")
	public void user_changes_system_date_to_prior_renewal_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.minusDays(1)));
		wait(1);
	}

	@When("User searches for the policy <mtr370>")
	public void user_searches_policy_for_mtr370() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as renewal date and starts endorsement")
	public void User_sets_new_effective_date_as_renewal_date_and_starts_endorsement() {
		wait(2);
		sendText(historyChevron.txtEffectiveDate, dtf.format(RnwlDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <mtr370>")
	public void user_clicks_dwelling_chevron_mtr370() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User unchecks wind exclusion")
	public void user_unchecks_wind_exclusion() throws Exception {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User finalizes transaction and validates updated changes messages on closeout screen for <mtr370>")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen_for_mtr370()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		verify_AnyText_IsVisible(driver, "Windstorm or Hail Exclusion Changed From Yes to None");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User changes system date to renewal date")
	public void user_changes_system_date_to_renewal_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate));
		wait(1);
	}

	@When("User search for the renewed policy term")
	public void user_searches_for_the_renewed_policy_term() throws Exception {
		setPolicyNumSearch(driver, PolicyTerm02);
		wait(1);
		click(dashboard.search);
		wait(2);
	}

	@When("User checks wind exclusion")
	public void user_checks_wind_exclusion() throws Exception {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User finalizes transaction and validates second updated changes messages on closeout screen for <mtr370>")
	public void user_finalizes_transaction_and_validates_second_updated_changes_messages_on_closeout_screen_for_mtr370()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 2% to Not Applicable");
		verify_AnyText_IsVisible(driver, "Windstorm or Hail Exclusion Changed From None to Yes");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User changes system date to after renewal date")
	public void user_changes_system_date_to_after_renewal_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.plusDays(1)));
		wait(1);
	}

	@When("User valites 'The effective date must not be older than 0 days from today' message has been displayed")
	public void user_validates_error_message_has_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		wait(1);
	}

	@When("User finalizes transaction and validates third updated changes messages on closeout screen for <mtr370>")
	public void user_finalizes_transaction_and_validates_third_updated_changes_messages_on_closeout_screen_for_mtr370()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Wind/Hail Exclusion may only be added or deleted at Renewal");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From Not Applicable to 2%");
		verify_AnyText_IsVisible(driver, "Windstorm or Hail Exclusion Changed From Yes to None");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
	}

	@When("User takes note of the application for <mtr370>")
	public void user_takes_note_of_the_application__number_for_mtr370() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr370>")
	public void user_searches_application_for_mtr370() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}

	@When("User process and completes endorsement and finishes test <mtr370>")
	public void user_process_and_completes_endorsement_and_finishes_test_mtr370() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User changes system date to renewal date plus 1 day")
	public void user_changes_system_date_to_renewal_date_plus_1_day() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(RnwlDate.plusDays(1)));
		wait(1);
	}
}
