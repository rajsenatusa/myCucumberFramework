package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR368_MHO_END_ValidateBackdatingDeductibleChangesRequiresUWmngrApproval extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;

	@When("User enters all required information on policy information screen and enters mobile park address")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "36323 Arbor Oaks Dr");
		sendText(quote.txtZipCode, "33541");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park()
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
		sendText(policyChevron.txtParkName, "American Condominium Park");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "American Condominium Park");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "American Condominium Park");
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

	@When("User enters all required information on MHO3 dwelling screen and sets covA as <65000>, ded.perils as <2500>, ded.hurricane as <%10>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_65000() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "65000");
		wait(2);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr368>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr368() throws Exception {
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
	@When("User changes system date to current date minus <1> day")
	public void user_changes_system_date_to_current_date_minus_1_day() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.minusDays(1)));
	}
	@When("User searches for the policy <mtr368>")
	public void user_searches_policy_for_mtr368() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date and starts endorsement")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User clicks Dwelling Chevron for <mtr368>")
	public void user_clicks_dwelling_chevron_mtr368() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User updates deductible perils as <1500> and ded hurricane as <%2>")
	public void user_updates_ded_perils_as_1500_and_ded_hurricane_as_2() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "2%");
		click(dwellingChevron.btnSave);
		wait(4);
	}
	@When("User finalizes transaction and validates updated changes messages on closeout screen")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $1,500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to 2%");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User changes system date to current date")
	public void user_changes_system_date_to_current_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User updates deductible perils as <2000> and ded hurricane as <%5>")
	public void user_updates_ded_perils_as_2000_and_ded_hurricane_as_5() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "5%");
		click(dwellingChevron.btnSave);
		wait(4);
	}
	@When("User finalizes transaction and validates updated changes messages on closeout screen <2000> and <%5>")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen_2000_and_5() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $1,500 to $2,000");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 2% to 5%");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User changes system date to current date plus <1> day")
	public void user_changes_system_date_to_current_date_plus_1_day() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
	}
	@When("User validates 'The effective date must not be older than 0 days from today' message has been displayed")
	public void user_validates_error_message_has_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
	}
	@When("User clicks Policy Chevron and validates error messages")
	public void user_clicks_policy_chevron_and_validates_error_messages() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");	
	}
	@When("User finalizes transaction and validates updated changes messages on closeout screen for third endorsement")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen_for_third_endorsement() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		
		verify_AnyText_IsVisible(driver, "The effective date must not be older than 0 days from today");
		verify_AnyText_IsVisible(driver, "Change in AOP Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible may only be changed at Renewal");
		verify_AnyText_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,000 to $1,500");
		verify_AnyText_IsVisible(driver, "Deductible Change: Hurricane Changed From 5% to 2%");
		verify_AnyText_NotVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");	
	}
	@When("User takes note of the application for <mtr368>")
	public void user_takes_note_of_the_application__number_for_mtr368() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <mtr368>")
	public void user_searches_application_for_mtr368() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("User approves application")
	public void user_approves_application() {
		click(closeoutChevron.btnApprove);
		wait(3);
	}
	@When("User process and completes endorsement and finishes test")
	public void user_process_and_completes_endorsement_and_finishes_test() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
