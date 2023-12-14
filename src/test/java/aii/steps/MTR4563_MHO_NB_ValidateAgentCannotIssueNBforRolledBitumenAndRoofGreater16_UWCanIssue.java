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

public class MTR4563_MHO_NB_ValidateAgentCannotIssueNBforRolledBitumenAndRoofGreater16_UWCanIssue extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;
	static String appPremium;
	
	@When("User enters all required information on policy information screen and enters mobile park address <mtr4563>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_mtr4563() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "3509 Casey Jones Dr");
		sendText(quote.txtZipCode, "33594");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on MHO3 quote screen and selects park as property type <mtr4563>")
	public void user_enters_all_required_information_on_mho3_quote_screen_and_selects_park_mtr4563() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnParkPropertyType);
		wait(1);
		clickMagnifierIcon(driver, "2");
		wait(2);
		switchToWindow(driver, "ParkSearchPage");
		wait(2);
		selectDropdownText(policyChevron.ddSearchPark, "Park Name");
		wait(1);
		sendText(policyChevron.txtParkName, "Oak Hill Village");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "Oak Hill Village");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Oak Hill Village");
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
	@When("User enters all required information on MHO3 dwelling screen and sets covA as <65000> <mtr4563>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_65000_mtr4563() {

		sendText(dwellingChevron.txtYearConstruction, "2004");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "65000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User checks application dwelling screen, validates 'Risk is ineligible based upon roof material and roof age' message displayed and finalizes transaction <mtr4563>")
	public void user_checks_application_dwelling_screen_validates_risk_ineligible_message_displayed_and_finalizes_transaction_mtr4563()
			throws Exception {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Rolled/Bitumen");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "24 to 35");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "1257AWS678");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Risk is ineligible due to roof material and roof age");
		attachScreenShot(driver);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User takes note of the application number for <mtr4563>")
	public void user_takes_note_of_the_application__number_for_mtr4563() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User validates 'Issue New Business' and 'Submit For Approval' buttons are not visible and premium amount equals to zero on closeout screen <mtr4563>")
	public void user_validates_issue_new_business_and_submit_for_approval_buttons_are_not_visible_on_closeout_screen_mtr4563()
			throws Exception {
		verify_AnyText_NotVisible(driver, "Issue New Business");
		verify_AnyText_NotVisible(driver, "Submit For Approval");
		attachScreenShot(driver);
		driver.findElement(By.id("FullSummaryHolder")).click();
		Thread.sleep(1000);
		appPremium = driver.findElement(By.id("Full_QuoteAppSummary_PremWithTaxesFeesAmt")).getText().toString();
		expectedValue_foundValue(driver, "$0.00", appPremium);
	}
	@When("User searches previously created application for <mtr4563>")
	public void user_searches_previously_created_application_for_mtr4563() throws Exception {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@Then("User verifies NB MHO3 policy has been created successfully and comppletes test <mtr4563>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr4563() throws Exception {
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
		Hooks.scenario.log("Test Case Completed!");
	}
}
