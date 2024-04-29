package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR347_GOC_Underwriter_to_Override_the_vendor_data_Golf_Cart extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr347>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr347() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "925 Grande Haven Dr");
		sendText(quote.txtZipCode, "32780");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on GOC quote screen <mtr347>")
	public void user_enters_all_required_information_on_goc_quote_screen_mtr347() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		click(dwellingChevron.btnSave);
		waitImp(4);
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on GOC golfcart screen for <mtr347>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr347() throws Exception {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "No Coverage");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "Reject");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "No Coverage");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "No Coverage");
		wait(1);
		clickonAnyButton(driver, "BasicPolicy.CoveragePackage_1");
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}
	@When("User enters driver information on driver screen <mtr347>")
	public void user_enters_driver_information_on_driver_screen_mtr347() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters vehicles information on vehicles screen <mtr347>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr347() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2019");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Test Make");
		sendText(golfcartChevron.txtGcModel, "Test Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "2000");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "No Coverage");
		selectDropdownText(golfcartChevron.ddCollisionDed, "No Coverage");
		click(dwellingChevron.btnSave);
		wait(4);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User enters all required information on GOC review screen <mtr347>")
	public void user_enters_all_required_information_on_goc_review_screen_mtr347() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
	}
	@When("User clicks Data Reports Chevron")
	public void user_clicks_Data_Reports_Chevron() {
 
		click(dataReportsChevron.lnkDataReportsChevron);
		wait(2);
	}
	@When("User clicks Order Data Report and validates Dropdown Selections")
	public void user_clicks_Order_Data_Report_and_validates_Dd_Selections() throws Exception {
 
		click(dataReportsChevron.btnOrderDataReport);
		wait(2);
		String [] ddReportTypes= {"Select...","CLUE Personal Auto","Insurance Score","LexisNexis MVR"};
		verifyAnyDropDownOptions(driver, ddReportTypes, "DataReportRequest.TemplateIdRef");
	}
	@When("User selects Insurance Score Data Report and orders")
	public void user_selects_Insurance_Score_Data_Report_and_orders() {
 
		selectDropdownText(dataReportsChevron.ddDataReportSel, "Insurance Score");
		wait(2);
		click(dataReportsChevron.btnSelect);
		wait(1);
		click(dataReportsChevron.btnOrder);
	}
	@When("User validates A new report generated and added in Data Reports In Process Data Reports")
	public void user_validates_A_New_report_Generated_and_added_in_Data_reports_in_process_data_reports() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Received");
		attachScreenShot(driver);
	}
	@When("User clicks Golf Cart Policy Chevron")
	public void user_clicks_Golf_Cart_Policy_Chevron() throws Exception {
 
		click(driver.findElement(By.id("Wizard_Policy")));
		wait(2);
	}
	@When("User should be able to see the data received from Report on quote")
	public void user_should_be_able_to_see_the_data_received_from_report_on_quote() throws Exception {
 
		WebElement genericError = driver.findElement(By.id("GenericBusinessError"));
		if (genericError.isDisplayed()) {
			Hooks.scenario.log("Insurance Score report applied to the policy");
			attachScreenShot(driver);
		}
		else {
			Hooks.scenario.log("Insurance Score Report did not apply to the policy, Test FAILS!");
			attachScreenShot(driver);
		}
	}
	@When("User creates GOC application <mtr347>")
	public void user_creates_goc_application_mtr347() {

		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}
	@When("User validates application should be able to see the data received from Report. In Process Data Reports")
	public void user_validates_application_should_be_able_to_see_the_data_received_from_report_in_process_data_reports() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Applied");
		attachScreenShot(driver);
	}
	@When("User answers all underwriting questions for GOC <mtr347>")
	public void user_answers_all_underwriting_questions_for_goc_mtr347() throws Exception {
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
		fillGOC_UWQuestions();
	}
	@Then("User validates that GOC policy has been created successfully and completes test <mtr347>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr347() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("GolfCart NB policy has been created successfully");
		} else {
			System.out.println("Golf Cart Policy Creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("Test Case Completed!");
	}
}
