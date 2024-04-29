package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR344_VOLMHO3_Underwriter_to_Override_the_vendor_data_Voluntary_Mobile_HomeOwners_product extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr344>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr344() {

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
	@And("User enters Producer Code <mtr344>")
	public void User_enters_Producer_Code_mtr344() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date <mtr344>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_mtr344() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
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
	@When("User enters all required information on MHO3 dwelling screen <mtr344>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_mtr344() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "200000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Order Data Report and validates Dropdown Selections <mtr344>")
	public void user_clicks_Order_Data_Report_and_validates_Dd_Selections_mtr344() throws Exception {
 
		click(dataReportsChevron.btnOrderDataReport);
		wait(2);
		String [] ddReportTypes= {"Select...","APLUS Property","BuildFax","CLUE Property", "Insurance Score", "Insurance Score/Current Carrier", "ISO Location"};
		verifyAnyDropDownOptions(driver, ddReportTypes, "DataReportRequest.TemplateIdRef");
	}
	@When("User selects CLUE Property Report and click order")
	public void user_selects_Clue_Property_Data_Report_and_orders() {
 
		selectDropdownText(dataReportsChevron.ddDataReportSel, "CLUE Property");
		wait(2);
		click(dataReportsChevron.btnSelect);
		wait(1);
		click(dataReportsChevron.btnOrder);
		wait(6);
	}
	@When("User validates A new report generated and added in Data Reports In Process Data Reports <mtr344>")
	public void user_validates_A_New_report_Generated_and_added_in_Data_reports_in_process_data_reports_mtr344() throws Exception {
 
		verify_AnyText_IsVisible(driver, "CLUE Property");
		verify_AnyText_IsVisible(driver, "Received");
		attachScreenShot(driver);
	}
	@When("User should be able to see the data received from Report on quote <mtr344>")
	public void user_should_be_able_to_see_the_data_received_from_report_on_quote_mtr344() throws Exception {
 
		WebElement genericError = driver.findElement(By.id("GenericBusinessError"));
		if (genericError.isDisplayed()) {
			Hooks.scenario.log("CLUE Property Data Report applied to the policy");
			attachScreenShot(driver);
		}
		else {
			Hooks.scenario.log("CLUE Property Data Report did not apply to the policy, Test FAILS!");
			attachScreenShot(driver);
		}
	}
	@When("User validates application should be able to see the data received from Report. In Process Data Reports <mtr344>")
	public void user_validates_application_should_be_able_to_see_the_data_received_from_report_in_process_data_reports_mtr344() throws Exception {
 
		verify_AnyText_IsVisible(driver, "CLUE Property");
		verify_AnyText_IsVisible(driver, "Applied");
		attachScreenShot(driver);
	}
	@When("User answers all underwriting questions for MHO3 <mtr344>")
	public void user_answers_all_underwriting_questions_for_mho3_mtr344() throws Exception {
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(1);
		fillMHO_UWQuestions();

		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarialmho3"));
		selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
		selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));
	}
	@Then("User verifies NB MHO3 policy has been created successfully and completes test <mtr344>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr344() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("Test Case Completed!");
	}
}
