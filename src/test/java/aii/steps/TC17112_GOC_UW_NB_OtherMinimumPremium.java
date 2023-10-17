package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class TC17112_GOC_UW_NB_OtherMinimumPremium extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters all required information on policy information screen <tc17112>")
	public void user_enters_all_required_information_on_policy_information_screen_tc17112() {

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
	@When("User enters all required information on GOC quote screen <tc17112>")
	public void user_enters_all_required_information_on_goc_quote_screen_tc17112() {
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
	@When("User enters all required information on GOC golfcart screen for <tc17112>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_tc17112() throws Exception {

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
	@When("User enters driver information on driver screen <tc17112>")
	public void user_enters_driver_information_on_driver_screen_tc17112() {

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
	@When("User enters vehicles information on vehicles screen <tc17112>")
	public void user_enters_vehicles_information_on_vehicles_screen_tc17112() {

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
	@When("User enters all required information on GOC review screen <tc17112>")
	public void user_enters_all_required_information_on_goc_review_screen_tc17112() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
	}
	@When("User validates 'Rate Area: Increase to Minimum Premium' is visible")
	public void user_validates_Rate_area_increase_to_minimum_premium_is_visible() throws Exception {
		driver.findElement(By.id("NextPage")).click();
		verify_AnyText_IsVisible(driver, "Rate Area: Increase to Minimum Premium");
		attachScreenShot(driver);
		verifyAnyDisabledFieldsValue(driver, "QuoteAppSummary_PremWithTaxesFeesAmt", "$100.00");
		scrollToAnyField(driver, "Quote Summary");
		attachScreenShot(driver);
	}
	@When("User creates GOC application <tc17112>")
	public void user_creates_goc_application_tc17112() {
		
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@When("User clicks Worksheets Chevron")
	public void user_clicks_Worksheets_Chevron() {
		
		click(worksheetsChevron.lnkWorksheetsChevron);
		wait(3);
	}
	@When("User validates 'Rate Area: Increase to Minimum Premium' is visible on application level")
	public void user_validates_Rate_area_increase_to_minimum_premium_is_visible_on_application_level() throws Exception {
		
		verify_AnyText_IsVisible(driver, "Rate Area: Increase to Minimum Premium");
		attachScreenShot(driver);
		scrollToAnyField(driver, "Application Summary");
		attachScreenShot(driver);
		verifyAnyDisabledFieldsValue(driver, "QuoteAppSummary_PremWithTaxesFeesAmt", "$100.00");	
	}
	@When("User validates that GOC policy has been created successfully and takes note of the policy number <tc17112>")
	public void user_validates_that_goc_policy_has_been_created_successfully_tc17112() throws Exception {

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

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User validates 'Rate Area: Increase to Minimum Premium' is visible on policy level")
	public void user_validates_Rate_area_increase_to_minimum_premium_is_visible_on_policy_level() throws Exception {
		
		verify_AnyText_IsVisible(driver, "Rate Area: Increase to Minimum Premium");
		attachScreenShot(driver);
		//scrollToAnyField(driver, "Application Summary");
		//attachScreenShot(driver);
		verifyAnyDisabledFieldsValue(driver, "Full_PolicySummary_Premium", "$75.00");
		verifyAnyDisabledFieldsValue(driver, "Full_PolicySummary_PremWithTaxesFeesAmt", "$100.00");
		Hooks.scenario.log("Test Case Completed!");
	}
}
