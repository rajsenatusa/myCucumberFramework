package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR369_MHO_END_ValidateBackdatingCoverageChanges extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;
	
	@When("User enters all required information on policy information screen and enters mobile park address for <mtr369>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_for_mtr369() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "2308 Gold Finch PI");
		sendText(quote.txtZipCode, "32084");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <mtr369>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_for_mtr369()
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
		sendText(policyChevron.txtParkName, "Sanctuary Cove");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "Sanctuary Cove");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Sanctuary Cove");
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
	@When("User enters all required information on MHO3 dwelling screen and sets covA as <65000>, personal liability <500000>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_65000_personal_liability_500000() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "65000");
		wait(2);
		selectDropdownText(dwellingChevron.ddCovELimit, "$500,000");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr369>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr369() throws Exception {
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
	@When("User searches for the policy <mtr369>")
	public void user_searches_policy_for_mtr369() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Dwelling Chevron for <mtr369>")
	public void user_clicks_dwelling_chevron_mtr369() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User updates personal liability as <300000>")
	public void user_updates_personal_liability_as_300000() throws Exception {
		selectDropdownText(dwellingChevron.ddCovELimit, "$300,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User finalizes transaction and validates updated changes messages on closeout screen for <mtr369>")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen_for_mtr369() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Coverage Modified: E - Personal Liability Limit 1 Changed From $500,000 to $300,000");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User updates personal property rate as <%55>")
	public void user_updates_personal_property_rate_as_55() throws Exception {
		selectDropdownText(dwellingChevron.ddCovCLimit, "55%");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User finalizes transaction and validates second updated changes messages on closeout screen <mtr369>")
	public void user_finalizes_transaction_and_validates_second_updated_changes_messages_on_closeout_screen_for_mtr369() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Coverage Modified: C - Personal Property Limit 1 Changed From $32,500 to $35,750");
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		verify_AnyLabel_IsVisible(driver, "Preview Output");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User updates personal liability as <500000> and completes test")
	public void user_updates_personal_liability_as_500000_and_completes_test() throws Exception {
		selectDropdownText(dwellingChevron.ddCovELimit, "$500,000");
		click(dwellingChevron.btnSave);
		wait(3);
		Hooks.scenario.log("Test Case Completed!");
	}
}
