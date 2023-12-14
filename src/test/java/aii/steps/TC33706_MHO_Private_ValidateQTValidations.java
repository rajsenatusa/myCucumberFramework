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

public class TC33706_MHO_Private_ValidateQTValidations extends CommonMethods {

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

	@When("User enters all required information on policy information screen and enters mobile park address for <tc33706>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_for_tc33706() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "122 South Dr");
		sendText(quote.txtZipCode, "33166");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc33706>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_for_tc33706()
			throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		wait(1);

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

	@When("User validates error messages and delete quote for <tc33706>")
	public void User_validates_error_messages_and_delete_quote_for_tc33706() throws Exception {
		verify_AnyText_IsVisible(driver, "County is closed for new business. ");
		attachScreenShot(driver);
		clickonAnyButton(driver, "Delete");
		wait(1);
		click(dwellingChevron.dialogOK);
		wait(1);
	}

	@When("User enters all required information on policy information screen and enters mobile park address again for <tc33706> second quote")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_again_for_tc33706_second_quote() {

		// quote level information was filled here again
		sendText(quote.txtFirstName, "Jim");
		sendText(quote.txtLastName, "Corbi");
		sendText(quote.txtBirthDate, "02/27/1981");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1165 Peperidge Dr");
		sendText(quote.txtZipCode, "32504");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		wait(2);
		selectDropdownText(quote.ddcustomerPhonePrimaryPhoneName, "Mobile");
		wait(2);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type again for <tc33706> second quote")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_as_property_type_again_for_tc33706_second_quote()
			throws Exception {
		// Quote Policy Chevron information was filled here again

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		wait(1);
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));

		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
//		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupiedmho3"));
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User validates error messages and delete for <tc33706> third quote")
	public void User_validates_error_messages_and_delete_for_tc33706_third_quote() throws Exception {
		verify_AnyText_IsVisible(driver, "Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		attachScreenShot(driver);

	}

	@When("User enters all required information on policy information screen and enters mobile park address again for <tc33706> third quote")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_again_for_tc33706_third_quote() {

		// quote level information was filled here again
		sendText(quote.txtFirstName, "Mike");
		sendText(quote.txtLastName, "Summer");
		sendText(quote.txtBirthDate, "11/11/1971");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "10830 Charmwood Dr");
		sendText(quote.txtZipCode, "33569");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		wait(2);
		selectDropdownText(quote.ddcustomerPhonePrimaryPhoneName, "Mobile");
		wait(2);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type again for <tc33706> third quote")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_as_property_type_again_for_tc33706_third_quote()
			throws Exception {
		// Quote Policy Chevron information was filled here again

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		wait(1);
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));

		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "5");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User validates error messages and delete for <tc33706> second quote")
	public void User_validates_error_messages_and_delete_for_tc33706_second_quote() throws Exception {
		verify_AnyText_IsVisible(driver,
				"Postal Code is closed for new business. ");
		verify_AnyText_IsVisible(driver,
				"Tenant Occupied homes are not eligible. ");
		attachScreenShot(driver);

		clickonAnyButton(driver, "Delete");
		wait(1);
		click(dwellingChevron.dialogOK);
		wait(1);

	}

	@When("User updates General Informations and Dwelling Details for <tc33706>")
	public void User_updates_General_Informations_and_Dwelling_Details_for_tc33706() {

		sendText(dwellingChevron.txtYearConstruction, "1989");
		wait(2);
		selectDropdownText(dwellingChevron.ddbuildingLocatedPC10, "Yes");
		wait(1);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "1990");
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "10000");
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);

	}

	@When("User validates error messages in Policy and Dwelling Cheveron for <tc33706>")
	public void User_validates_error_messages_in_Policy_and_Dwelling_Cheveron_for_tc33706() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		verify_AnyText_IsVisible(driver, "MH on Private Property and in PC 10 is ineligible. ");
		attachScreenShot(driver);
		wait(1);
		click(dwellingChevron.btnDwelling);
		wait(1);
		verify_AnyText_IsVisible(driver,
				"Manufactured/mobile homes built prior to 1994 are not eligible for coverage. ");
		verify_AnyText_IsVisible(driver, "Coverage A must be a minimum of $15,000 for the Private Property.");

		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding.");

		attachScreenShot(driver);
		wait(1);
	}

	@When("User updates Coverage A as <1000000>")
	public void User_updates_Coverage_A_as_1000000() throws Exception {
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "1000000");
		wait(1);
		click(dwellingChevron.btnSave);

	}

	@When("User validates error messages for <tc33706>")
	public void User_validates_error_messages_for_tc33706() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		verify_AnyText_IsVisible(driver, "MH on Private Property and in PC 10 is ineligible. ");
		attachScreenShot(driver);
		wait(1);
		click(dwellingChevron.btnDwelling);
		wait(1);
		verify_AnyText_IsVisible(driver,
				"Manufactured/mobile homes built prior to 1994 are not eligible for coverage. ");
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Private program. ");
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding.");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User updates Year of Manufacture as <2000> and Limited Fungi as <50000>")
	public void User_updates_Year_of_Manufacture_as_2000_and_Limited_Fungi_as_50000() {
		wait(1);
		sendText(dwellingChevron.txtYearConstruction, "2000");
		wait(1);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "");
		wait(1);
		selectDropdownText(dwellingChevron.ddBuildingCovLFMLimit, "$50,000 Each Covered Loss/$50,000 Aggregate");
		wait(1);
		click(dwellingChevron.btnSave);

	}

	@When("User validates error messages")
	public void User_validates_error_messages() throws Exception {

		click(policyChevron.btnPolicyChevronLink);
		wait(1);
		verify_AnyText_IsVisible(driver, "MH on Private Property and in PC 10 is ineligible. ");
		attachScreenShot(driver);
		wait(1);
		click(dwellingChevron.btnDwelling);
		wait(1);
		verify_AnyText_IsVisible(driver,
				"The Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Limit Must be Approved. ");
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Private program. ");
		verify_AnyText_IsVisible(driver,
				"The signed Windstorm or Hail exclusion form must be submitted after binding.");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User updates Attached Structures")
	public void User_updates_Attached_Structures() throws Exception {
		wait(1);
		click(dwellingChevron.coverageListASAdd);

		clickonAnyButton(driver, "CoverageList_AS_Add");
		driver.switchTo().frame("IFrameCoverageAction"); // Now you are in the popup window, perform necessary actions
															// here
		wait(1);
		selectDropdownText(dwellingChevron.ddClassCdValue, "Garage");
		wait(1);
		sendText(dwellingChevron.year, "1999");
		wait(1);
		sendText(dwellingChevron.length, "99");
		wait(1);
		sendText(dwellingChevron.width, "99");
		wait(1);
		sendText(dwellingChevron.itemLimit1Value, "1,000,000");
		wait(1);
		click(dwellingChevron.addCoverageItem);
		wait(1);

	}

	@Given("User validates that MHO3 Quote has been created successfully and takes note of the Quote number for <tc33706>")
	public void User_validates_that_MHO3_Quote_has_been_created_successfully_and_takes_note_of_the_Quote_number_for_tc33706()
			throws Exception {
		
		click(dwellingChevron.btnNext);
		wait(1);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(2);

		click(dwellingChevron.btnNext);

		String expected = "If you would like to create a new iteration, use the Copy Quote action and select New Linked Quote.";
		String actual = dwellingChevron.priceCompare.getText();
		Assert.assertEquals("Test failed!", expected, actual);

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


