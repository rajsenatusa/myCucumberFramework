package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC16746_MHO_FamilyPark_ValidationQTUICharacteristics extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String app_Tx_Policy_Claim_Num;
	static String QuoteNum;
	static String switchToWindow;

	@When("User enters all required information on policy information screen and enters mobile park address for <tc16746>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_for_tc16746() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1165 Peperidge Dr");
		sendText(quote.txtZipCode, "32504");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16746>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_for_tc16746()
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
		sendText(policyChevron.txtParkName, "Cypress Lakes");
		click(policyChevron.btnSearch);
		wait(2);
		clickOnAnyText(driver, "Cypress Lakes");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Cypress Lakes");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);

	}

	@When("User selects Occupancy as Tenant Occupied for <tc16746>")
	public void User_selects_Occupancy_as_Tenant_Occupied_for_tc16746() {

		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User verifies error message as Tenant Occupied homes are not eligible")
	public void User_verifies_error_message_as_Tenant_Occupied_homes_are_not_eligible() throws Exception {

		verify_AnyText_IsVisible(driver, "Tenant Occupied homes are not eligible. ");

	}

	@When("User selects Occupancy as Owner Occupied for <tc16746>")
	public void User_selects_Occupancy_as_Owner_Occupied_for_tc16746() {

		sendText(dwellingChevron.txtYearConstruction, "1999");
		wait(2);
		wait(1);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);

		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(2);
		selectDropdownText(policyChevron.ddMonthsOccupied, "10");
		wait(1);

		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User updates Dwelling Chevron")
	public void User_pdates_Dwelling_Chevron() {

		sendText(dwellingChevron.txtYearConstruction, "1999");
		wait(2);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "1999");
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "1,000,000");
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User verifies error messages in Issues")
	public void User_verifies_error_messages_in_Issues() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $500,000 requries underwriting approval for the Adult Park Program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding. ");
		wait(2);
	}

	@When("User updates Coverage A and Windstorm or Hail Exclusion")
	public void User_updates_Coverage_A_and_Windstorm_or_Hail_Exclusion() {

		sendText(dwellingChevron.txtCoverageA, "10,000");
		wait(3);
		click(dwellingChevron.rbWindHailExc);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User updates Coverage A as <100,000> and Windstorm or Hail Exclusion")
	public void User_updates_Coverage_A_as_100000_and_Windstorm_or_Hail_Exclusion() {
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "100,000");
		wait(3);
		click(dwellingChevron.rbWindHailExc);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User verifies Windstorm or Hail exclusion message")
	public void User_verifies_Windstorm_or_Hail_exclusion_message() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding. ");
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16746> second quote")
	public void User_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_for_tc16746_second_quote()
			throws Exception {
		// Quote Policy Chevron information was filled here

		click(policyChevron.btnPolicyChevronLink);
		selectDropdownText(policyChevron.ddPreviousCarrier, "American Modern");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnParkPropertyType);
		wait(1);
		clickMagnifierIcon(driver, "2");
		wait(1);
		switchToWindow(driver, "ParkSearchPage");
		wait(1);
		selectDropdownText(policyChevron.ddSearchPark, "Park Name");
		wait(1);
		sendText(policyChevron.txtParkName, "Highland Fairways");
		click(policyChevron.btnSearch);
		wait(1);
		clickOnAnyText(driver, "Highland Fairways");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Highland Fairways");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(1);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(2);
		selectDropdownText(policyChevron.ddMonthsOccupied, "3");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(1);
		click(policyChevron.btnNext);
		click(policyChevron.btnNoEmailRadio);
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User verifies messages in Issues")
	public void User_verifies_messages_in_Issues() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver, "Mobile Home Park is closed for new business. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding. ");
		wait(2);
	}

	@When("User updates Coverage A as <1,000,000>")
	public void User_updates_Coverage_A_as_1000000() {
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "1,000,000");
		wait(3);
		click(dwellingChevron.rbWindHailExc);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User verifies messages")
	public void User_verifies_messages() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver, "Mobile Home Park is closed for new business. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);
		attachScreenShot(driver);
		wait(2);
	}

	@When("User updates Coverage A as <10,000>")
	public void User_updates_Coverage_A_as_10000() {
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "10,000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User verifies messages for Coverage A")
	public void User_verifies_messages_for_Coverage_A() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver, "Mobile Home Park is closed for new business. ");
		wait(2);
		verify_AnyText_IsVisible(driver, "Coverage A must be a minimum of $15,000 for the Family Park. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);
		
	}

	@When("User updates Coverage A as <500,000>")
	public void User_updates_Coverage_A_as_500000() {
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "500,000");
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@Given("User validates that MHO3 Quote has been created successfully and takes note of the Quote number for <tc16746>")
	public void User_validates_that_MHO3_Quote_has_been_created_successfully_and_takes_note_of_the_Quote_number_for_tc16746()
			throws Exception {

		click(dwellingChevron.btnNext);
		wait(1);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnDwelling);
		wait(2);
		verify_AnyText_IsVisible(driver, "Mobile Home Park is closed for new business. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding. ");
		wait(2);

		closeUnnecessaryTabs();
		getQuoteNumber(driver);
		getQuotePremium(driver);
		// taking note of the issued policy
		try {
			QuoteNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Quote Number: " + QuoteNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
