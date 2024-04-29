package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR342_VOLHO3_Underwriter_to_Override_the_vendor_data extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr342>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr342() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on HO3 quote screen <mtr342>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr342() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr342>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr342() {
		// Quote Dwelling information was filled here
		// sendText(dwellingChevron.txtYearConstruction, "2002");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2024");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User clicks Order Data Report and validates Dropdown Selections <mtr342>")
	public void user_clicks_Order_Data_Report_and_validates_Dd_Selections_mtr342() throws Exception {
 
		click(dataReportsChevron.btnOrderDataReport);
		wait(2);
		String [] ddReportTypes= {"Select...","APLUS Property","BuildFax","CLUE Property","Insurance Score","Insurance Score/Current Carrier","ISO Location"};
		verifyAnyDropDownOptions(driver, ddReportTypes, "DataReportRequest.TemplateIdRef");
	}
	@When("User selects Insurance Score Report and click order <mtr342>")
	public void user_selects_InsuranceScore_Report_and_orders_mtr342() {
 
		selectDropdownText(dataReportsChevron.ddDataReportSel, "Insurance Score");
		wait(2);
		click(dataReportsChevron.btnSelect);
		wait(1);
		click(dataReportsChevron.btnOrder);
		wait(6);	
	}
	@When("User creates HO3 application <mtr342>")
	public void user_creates_ho3_application_mtr342() {

		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(3);
	}
	@When("User validates A new report generated and added in Data Reports In Process Data Reports <mtr342>")
	public void user_validates_A_New_report_Generated_and_added_in_Data_reports_in_process_data_reports_mtr342() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Received");
		attachScreenShot(driver);
	}
	@When("User should be able to see the data received from Report on quote <mtr342>")
	public void user_should_be_able_to_see_the_data_received_from_report_on_quote_mtr342() throws Exception {
 
		WebElement genericError = driver.findElement(By.id("GenericBusinessError"));
		if (genericError.isDisplayed()) {
			Hooks.scenario.log("Insurance Score Data Report applied to the policy");
			attachScreenShot(driver);
		}
		else {
			Hooks.scenario.log("Insurance Score Data Report did not apply to the policy, Test FAILS!");
			attachScreenShot(driver);
		}
	}
	@When("User validates application should be able to see the data received from Report. In Process Data Reports <mtr342>")
	public void user_validates_application_should_be_able_to_see_the_data_received_from_report_in_process_data_reports_mtr342() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Applied");
		attachScreenShot(driver);
	}
	@When("User answers all underwriting questions for VOL HO3 <mtr342>")
	public void user_answers_all_underwriting_questions_for_vol_ho3_mtr342() throws Exception {
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
		fillHO3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}
	@When("User completes required information on dwelling chevron <mtr342>")
	public void user_completes_required_information_on_dwelling_chevron_mtr342() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User finalizes transaction for VOL HO3 <mtr342>")
	public void user_finalizes_transaction_for_VOL_HO3_mtr342() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@Then("User validates that HO3 policy has been created successfully and completes test <mtr342>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_completes_test_mtr342()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
	}
}
