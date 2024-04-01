package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR592_HO3_Verify_that_an_UW_and_above_can_approve_the_referal_so_the_agent_can_issue_the_policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String appNum;
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String electricalYear = String.valueOf(currentY - 1);
	static String plumbingYearLessThan20 = String.valueOf(currentY - 20);
	static String plumbingGreaterThan20 = String.valueOf(currentY - 21);
	
	@When("User enters all required information on policy information screen <mtr592>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr592() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1475 Bush ST");
		sendText(quote.txtZipCode, "32534");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO3 quote screen <mtr592>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr592() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr592>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr592() {
		// Quote Dwelling information was filled here

		try {
			click(policyChevron.btnNext);
			wait(1);
			click(driver.findElement(By.id("dialogOK")));
			// sendText(dwellingChevron.txtYearConstruction, "2002");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
			selectDropdownText(dwellingChevron.ddProtectionClass, "03");
			selectDropdownText(dwellingChevron.bCEG, "3");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			sendText(dwellingChevron.txtCoverageA, "400000");
		} catch (Exception e) {
			// sendText(dwellingChevron.txtYearConstruction, "2002");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
			selectDropdownText(dwellingChevron.ddProtectionClass, "03");
			selectDropdownText(dwellingChevron.bCEG, "3");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			sendText(dwellingChevron.txtCoverageA, "400000");
		}
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User completes required information on dwelling chevron and validates 'Risk is ineligible due to age of Plumbing' text is visible <mtr592>")
	public void user_completes_required_information_on_dwelling_chevron_and_validates_text_message_is_visible_mtr592()
			throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		sendText(driver.findElement(By.id("Building.YearElectricalUpdated")), electricalYear);
		sendText(driver.findElement(By.id("Building.YearPlumbingUpdated")), plumbingGreaterThan20);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");
	}
	@And("User finalizes transaction for VOL HO3 and validates 'Risk is ineligible due to age of Plumbing' text is visible <mtr592>")
	public void user_finalizes_transaction_for_VOL_HO3_and_validates_text_is_visible_mtr592() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");
	}
	@When("User takes note of the application number <mtr592>")
	public void user_takes_note_of_the_application__number_mtr592() throws Exception {
		try {
			appNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + appNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Override Link on Underwriter Role <mtr592>")
	public void user_clicks_override_link_on_uw_standard_mtr592() {
		click(userLookup.lnkOverride);
		wait(3);
	}
	@When("User searches for application number <mtr592>")
	public void user_searches_for_application_number_mtr592() {
		sendText(dashboard.txtSearchBar, appNum);
		click(dashboard.search);
		wait(3);
	}
	@And("Underwriter User clicks Approve Button <mtr592>")
	public void uw_user_clicks_approve_button_mtr592() throws Exception {
		click(closeoutChevron.btnApprove);
		wait(4);
	}
	@And("User selects payment type and issues policy <mtr592>")
	public void user_selects_payment_type_and_issues_policy_mtr592() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		click(closeoutChevron.btnIssueNB);
		wait(5);
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("TEST CASE COMPLETED");
	}
}
