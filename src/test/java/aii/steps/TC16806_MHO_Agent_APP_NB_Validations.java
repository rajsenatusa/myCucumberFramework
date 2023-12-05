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

public class TC16806_MHO_Agent_APP_NB_Validations extends CommonMethods {

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
	static String submitForApproval;
	
	

	@When("User enters all required information on policy information screen and enters mobile park address for <tc16806>")
	public void user_enters_all_required_information_on_policy_information_screen_and_enters_mobile_park_address_for_tc16806() {

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

	@When("User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16806>")
	public void User_enters_all_required_information_on_MHO3_quote_screen_with_prior_exp_date_as_current_date_and_selects_park_as_property_type_for_tc16806()
			throws Exception {
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
		sendText(policyChevron.txtParkName, "Greenbrier Village");
		click(policyChevron.btnSearch);
		wait(1);
		clickOnAnyText(driver, "Greenbrier Village");
		driver.switchTo().window(mainWindow);
		verify_AnyLabel_IsVisible(driver, "Greenbrier Village");
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

		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtYearConstruction, "1999");
		wait(1);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "1999");
		wait(1);
		sendText(dwellingChevron.txtCoverageA, "1,000,000");
		wait(1);
		click(dwellingChevron.btnSave);

	}

	@When("User verifies messages as Owner Occupied for <tc16806>")
	public void User_verifies_messages_as_Owner_Occupied_for_tc16806() throws Exception {
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);

		attachScreenShot(driver);
	}

	@When("User enters all required information on MobileHomeowners General Information for <tc16806>")
	public void User_enters_all_required_information_on_MobileHomeowners_General_Information_for_tc16806() {

		selectDropdownText(dwellingChevron.ddBuildingLength, "72 or more");
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		wait(2);
		selectDropdownText(dwellingChevron.ddNumberOfStories, "4 or more");
		wait(2);
		selectDropdownText(dwellingChevron.ddBuildingMake, "Titan Homes");
		wait(2);
		selectDropdownText(dwellingChevron.ddBuildingWidth, "48 or more");
		wait(2);
		selectDropdownText(dwellingChevron.ddBuildingAcreage, "More than 5 Acres");
		wait(2);
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "No");
		wait(2);
		sendText(dwellingChevron.txtBuildingSerialNumber, "345678");
		wait(1);
		click(dwellingChevron.btnSave);

	}

	@When("User verifies messages in Policy and Dwelling Chevron")
	public void User_verifies_messages_in_Policy_and_Dwelling_Chevron() throws Exception {

		click(dwellingChevron.policy);
		wait(1);
		verify_AnyText_IsVisible(driver, "Skirted, Tied Down, Hand Rails not present, risk is ineligible. ");
		wait(1);
		click(dwellingChevron.btnDwelling);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form.");
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting approval is required, risk is located on more than 5 acres ");

		attachScreenShot(driver);
		wait(1);
	}

	@When("User answers all underwriting questions for MHO3 <tc16746>")
	public void User_answers_all_underwriting_questions_for_MHO3_tc16746() throws Exception {

		// Application Underwriting Questions Chevron was filled here

		click(dwellingChevron.btnUnderwriting);
		wait(2);
		fillMHO_UWQuestions();
		wait(3);
	}

	@When("User checks application dwelling screen and finalizes transaction for <tc16806>")
	public void User_checks_application_dwelling_screen_and_finalizes_transaction_for_tc16806() {

		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(1);
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@When("User verifies messages in Issues for <tc16806>")
	public void User_verifies_messages_in_Issues_for_tc16806() throws Exception {

		wait(1);
		verify_AnyText_IsVisible(driver, "Risk is ineligible based upon roof material and roof age. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form. ");
		wait(2);
		verify_AnyText_IsVisible(driver, "Skirted, Tied Down, Hand Rails not present, risk is ineligible.");
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting approval is required, risk is located on more than 5 acres ");
		wait(2);

		attachScreenShot(driver);
		wait(1);

		scrollToAnyField(driver, "Modify Application");

	}

	@When("User updates Year Roof Material Completely Updated")
	public void User_updates_Year_Roof_Material_Completely_Updated() {
		click(reviewChevron.btnModifyApplication);
		wait(1);
		click(dwellingChevron.btnDwelling);
		wait(1);
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2015");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@When("User verifies messages for <tc16806>")
	public void User_verifies_messages_for_tc16806() throws Exception {

		wait(1);
		verify_AnyText_IsVisible(driver,
				"	Coverage A Limit greater than $350,000 requries underwriting approval for the Family program. ");
		wait(2);
		verify_AnyText_IsVisible(driver, "	Underwriting approval is required, risk is located on more than 5 acres ");
		wait(2);
		verify_AnyText_IsVisible(driver, "	Skirted, Tied Down, Hand Rails not present, risk is ineligible. ");
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Number of Months Occupied is ineligible for coverage under the MHO3 policy form.");
		wait(2);
		attachScreenShot(driver);
		wait(1);
		getApplicationNumber(driver);
		
		 
	}
}
 