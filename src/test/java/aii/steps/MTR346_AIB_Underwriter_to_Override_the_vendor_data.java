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

public class MTR346_AIB_Underwriter_to_Override_the_vendor_data extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <mtr346>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr346() {

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
	@And("User enters Producer <mtr346>")
	public void User_enters_Producer_mtr346() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@When("User enters all required information on AIB quote screen for <mtr346>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_mtr346() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 5);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User selects liability coverage on quote screen for <mtr346>")
	public void user_selects_liability_coverage_on_quote_screen_for_mtr346() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$100,000/$300,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "No Coverage");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "Yes");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "60 days");
		click(dwellingChevron.btnSave);
		wait(5);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@When("User adds operator information on quote screen <mtr346>")
	public void user_adds_operator_information_on_quote_screen_mtr346() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "Y123101952915");
		selectDropdownText(aibChevron.ddBoatExperience, "4");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters all required information on AIB boat dwelling screen for <mtr346>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_mtr346() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, "1548799652");
		selectDropdownText(aibChevron.ddBoatMake, "Bayliner");
		sendText(aibChevron.txtBoatModel, "Testing");
		sendText(aibChevron.txtBoatPurchDate, dtf.format(currentDate));
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, "42500");
		selectDropdownText(aibChevron.ddBoatHullType, "Cruiser");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "26");
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, "Outboard");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "60 or less mph");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User clicks Order Data Report and validates Dropdown Selections <mtr346>")
	public void user_clicks_Order_Data_Report_and_validates_Dd_Selections_mtr346() throws Exception {
 
		click(dataReportsChevron.btnOrderDataReport);
		wait(2);
		String [] ddReportTypes= {"Select...","CLUE Personal Auto","Insurance Score","LexisNexis MVR"};
		verifyAnyDropDownOptions(driver, ddReportTypes, "DataReportRequest.TemplateIdRef");
	}
	@When("User selects Insurance Score Report and click order <mtr346>")
	public void user_selects_InsuranceScore_Report_and_orders_mtr346() {
 
		selectDropdownText(dataReportsChevron.ddDataReportSel, "Insurance Score");
		wait(2);
		click(dataReportsChevron.btnSelect);
		wait(1);
		click(dataReportsChevron.btnOrder);
		wait(6);
	}
	@When("User validates A new report generated and added in Data Reports In Process Data Reports <mtr346>")
	public void user_validates_A_New_report_Generated_and_added_in_Data_reports_in_process_data_reports_mtr346() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Received");
		attachScreenShot(driver);
	}
	@When("User should be able to see the data received from Report on quote <mtr346>")
	public void user_should_be_able_to_see_the_data_received_from_report_on_quote_mtr346() throws Exception {
 
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
	@When("User validates application should be able to see the data received from Report. In Process Data Reports <mtr346>")
	public void user_validates_application_should_be_able_to_see_the_data_received_from_report_in_process_data_reports_mtr346() throws Exception {
 
		verify_AnyText_IsVisible(driver, "Insurance Score");
		verify_AnyText_IsVisible(driver, "Applied");
		attachScreenShot(driver);
	}
	@Then("User issues policy and close unnecessary tabs and completes test <mtr346>")
	public void user_issues_policy_and_close_unnecessary_tabs_mtr346() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("AIB NB policy has been created successfully");
		} else {
			System.out.println("AIB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		Hooks.scenario.log("Test Case Completed!");
	}
	@And("User answers all underwriting questions for AIB <mtr346>")
	public void user_answers_all_underwriting_questions_for_aib_mtr346() throws Exception {

		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
		fillBoat_UWQuestions();
		wait(2);
		click(uwquestionsChevron.nextButtonUw);
	}
}
