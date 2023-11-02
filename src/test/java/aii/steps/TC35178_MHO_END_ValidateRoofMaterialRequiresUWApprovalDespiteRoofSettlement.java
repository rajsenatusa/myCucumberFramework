package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC35178_MHO_END_ValidateRoofMaterialRequiresUWApprovalDespiteRoofSettlement extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY);
	static String policyNum;
	static String applicationNumber;

	@When("User enters all required information on policy information screen and enters mobile park address <tc35178>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_tc35178() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "2498 Snowy plover Dr, Lot 12033");
		sendText(quote.txtZipCode, "33810");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen and selects private as property type <tc35178>")
	public void user_enters_all_required_information_on_mho3_quote_screen_and_selects_private_tc35178()
			throws Exception {
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
		sendText(policyChevron.txtParkName, "Foxwood Village");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "Foxwood Village");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Foxwood Village");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		driver.findElement(By.id("BasicPolicy.MHPropertyTypeCd_2")).click(); // selects private property
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on MHO3 dwelling screen and sets covA as <275000> <tc35178>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_275000_tc35178() {

		sendText(dwellingChevron.txtYearConstruction, "2019");
		wait(2);
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "3 mi to less than 4 mi");
		sendText(dwellingChevron.txtCoverageA, "275000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User checks application dwelling screen and finalizes transaction <tc35178>")
	public void user_checks_application_dwelling_screen__and_finalizes_transaction_tc35178() throws Exception {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "24 to 35");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "1257AWS678");
		click(dwellingChevron.btnSave);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <tc35178>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_tc35178() throws Exception {
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

	@When("User searches for the policy <tc35178>")
	public void user_searches_policy_for_tc35178() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <tc35178>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_tc35178() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <tc35178>")
	public void user_clicks_dwelling_chevron_tc35178() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User sets roof material as Other and roof update year to current year")
	public void user_sets_roof_material_as_Other_and_roof_update_year_to_curren_year() throws Exception {
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Other");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
	}

	@When("User validates 'Requires underwriting approval due to roof material' 'Roof Material Changed From Composition Shingle to Other' messages are visible")
	public void user_validates_2_messages_are_visible_on_closeout_screen_tc35178() throws Exception {
		verify_AnyText_IsVisible(driver, "Requires underwriting approval due to roof material");
		verify_AnyText_IsVisible(driver, "Roof Material Changed From Composition Shingle to Other");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application number for <tc35178>")
	public void user_takes_note_of_the_application__number_for_tc35178() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc35178>")
	public void user_searches_application_for_tc35178() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
}
