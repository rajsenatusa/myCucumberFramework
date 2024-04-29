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

public class MTR343_VOLDP1_Underwriter_to_Override_the_vendor_data extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr343>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr343() {

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
	@And("User enters Producer Code <mtr343>")
	public void User_enters_Producer_Code_mtr343() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr343>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr343() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <mtr343>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr343() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Order Data Report and validates Dropdown Selections <mtr343>")
	public void user_clicks_Order_Data_Report_and_validates_Dd_Selections_mtr343() throws Exception {
 
		click(dataReportsChevron.btnOrderDataReport);
		wait(2);
		String [] ddReportTypes= {"Select...","APLUS Property","BuildFax","CLUE Property","Insurance Score","Insurance Score/Current Carrier","ISO Location"};
		verifyAnyDropDownOptions(driver, ddReportTypes, "DataReportRequest.TemplateIdRef");
	}
	@When("User selects Insurance Score Report and click order <mtr343>")
	public void user_selects_InsuranceScore_Report_and_orders_mtr343() {
 
		selectDropdownText(dataReportsChevron.ddDataReportSel, "Insurance Score");
		wait(2);
		click(dataReportsChevron.btnSelect);
		wait(1);
		click(dataReportsChevron.btnOrder);
		wait(6);
	}
	@When("User validates A new report generated and added in Data Reports In Process Data Reports <mtr343>")
	public void user_validates_A_New_report_Generated_and_added_in_Data_reports_in_process_data_reports_mtr343() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Received");
		attachScreenShot(driver);
	}
	@When("User should be able to see the data received from Report on quote <mtr343>")
	public void user_should_be_able_to_see_the_data_received_from_report_on_quote_mtr343() throws Exception {
 
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
	@When("User validates application should be able to see the data received from Report. In Process Data Reports <mtr343>")
	public void user_validates_application_should_be_able_to_see_the_data_received_from_report_in_process_data_reports_mtr343() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Applied");
		attachScreenShot(driver);
	}
	@When("User answers all underwriting questions for DP1 <mtr343>")
	public void user_answers_all_underwriting_questions_for_dp1_mtr343() throws Exception {
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
		fillDP1_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}
	@When("User creates DP1 application <mtr343>")
	public void user_creates_dp1_application_mtr343() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}

	@Then("User validates that DP1 policy has been created successfully and completes test <mtr343>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_mtr343() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
	}
}
