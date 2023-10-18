package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC17113_GOC_UW_NB_Validations_GoldEndorsement extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Helmet_text;
	static String PersonalProperty_text;
	static String DeductibleWaiver_text;
	static String DiminishingDed_text;
	static String PermissiveInd_text;

	@When("User enters all required information on policy information screen <tc17113>")
	public void user_enters_all_required_information_on_policy_information_screen_tc17113() {

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

	@When("User enters all required information on GOC quote screen <tc17113>")
	public void user_enters_all_required_information_on_goc_quote_screen_tc17113() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		click(dwellingChevron.btnSave);
		waitImp(4);
		getInsuranceScore(driver, "DO NOT USE INSURANCE SCORE");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on GOC golfcart screen for <tc17113> and validates golf cart coverages dd defaulted values")
	public void user_enters_all_required_information_on_goc_golfcart_screen_tc17113() throws Exception {

		scrollToAnyField(driver, "Golf Cart Coverages");
		attachScreenShot(driver);

		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.Helmet", "$1,500");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PersonalProperty", "None");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DeductibleWaiver", "No");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DiminishingDed", "Not Applicable");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PermissiveInd", "No");

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$25,000/$50,000");
		selectDropdownText(golfcartChevron.ddPropertyDamageLimit, "$25,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "No Coverage");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "Reject");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$200");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$200");

		wait(1);
		clickonAnyButton(driver, "BasicPolicy.CoveragePackage_2");
		click(dwellingChevron.btnSave);
		wait(4);

		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.Helmet", "$2,500");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PersonalProperty", "$2,000");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DeductibleWaiver", "Yes");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DiminishingDed", "100% deductible applies");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PermissiveInd", "Yes");

		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "No Coverage");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Liability coverage required for Gold Endorsement");

		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$25,000/$50,000");
		wait(1);
		selectDropdownText(golfcartChevron.ddPropertyDamageLimit, "$25,000");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Liability coverage required for Gold Endorsement");

		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "No Coverage");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$200");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "No Coverage");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$200");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <tc17113>")
	public void user_enters_driver_information_on_driver_screen_tc17113() {

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

	@When("User enters vehicles information on vehicles screen <tc17113> and do validations with different deductibles")
	public void user_enters_vehicles_information_on_vehicles_screen_tc17113() throws Exception {

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
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "20000");
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "No Coverage");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Collision Coverage not allowed without Other than Collision Coverage.");

		driver.findElement(By.id("Wizard_GolfCart")).click();
		verify_AnyText_IsVisible(driver, "Collision and Other than Collision required for Gold Endorsement");
		clickonAnyButton(driver, "Navigate_VehicleList_1");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$200");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Collision Coverage not allowed without Other than Collision Coverage.");
		driver.findElement(By.id("Wizard_GolfCart")).click();
		verify_AnyText_NotVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		clickonAnyButton(driver, "Navigate_VehicleList_1");
		selectDropdownText(golfcartChevron.ddCollisionDed, "No Coverage");
		click(dwellingChevron.btnSave);
		wait(3);
		driver.findElement(By.id("Wizard_GolfCart")).click();
		verify_AnyText_IsVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		clickonAnyButton(driver, "Navigate_VehicleList_1");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$200");
		click(dwellingChevron.btnSave);
		wait(3);
		driver.findElement(By.id("Wizard_GolfCart")).click();
		verify_AnyText_NotVisible(driver, "Collision and Other than Collision required for Gold Endorsement");

		clickonAnyButton(driver, "Navigate_VehicleList_1");

		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User enters all required information on GOC review screen <tc17113>")
	public void user_enters_all_required_information_on_goc_review_screen_tc17113() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
	}

	@When("User creates GOC application <tc17113>")
	public void user_creates_goc_application_tc17113() {

		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@When("User validates expected dropdown values defaulted and expected elements disabled")
	public void user_validates_expected_dropdown_values_defaulted_and_expected_elements_disabled() throws Exception {

		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.Helmet", "$2,500");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PersonalProperty", "$2,000");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DeductibleWaiver", "Yes");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.DiminishingDed", "100% deductible applies");
		verifyAnyDropdownDefaultedValue(driver, "BasicPolicy.PermissiveInd", "Yes");
		verifyAnyElement_Disabled(driver, "BasicPolicy.Helmet");
		verifyAnyElement_Disabled(driver, "BasicPolicy.PersonalProperty");
		verifyAnyElement_Disabled(driver, "BasicPolicy.DeductibleWaiver");
		verifyAnyElement_Disabled(driver, "BasicPolicy.DiminishingDed");
		verifyAnyElement_Disabled(driver, "BasicPolicy.PermissiveInd");
	}

	@When("User validates that GOC policy has been created successfully and takes note of the policy number <tc17113>")
	public void user_validates_that_goc_policy_has_been_created_successfully_tc17113() throws Exception {

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

	@Then("User clicks Golf Cart Tab and validates all expected deductible and values and completes test")
	public void user_clicks_Golf_Cart_Tab_and_validates_all_expected_deductible_and_values_and_completes_test()
			throws Exception {

		driver.findElement(By.id("Wizard_GolfCart")).click();
		waitImp(3);
		
		try {

			WebElement GolfCartGoldCoverage = driver.findElement(By.id("BasicPolicy.CoveragePackage_2"));

			if (!(GolfCartGoldCoverage.isEnabled()) && (GolfCartGoldCoverage.isSelected())) {
				Hooks.scenario.log("Gold Endorsement Coverage is not Editable and selected");

			} else {
				Hooks.scenario.log("Gold Endorsement Coverage is not able to validate");
			}

		} catch (Exception e) {
			Hooks.scenario.log("Gold Endorsement Coverage not able to validate");
			wait(4);
		}
		
		Helmet_text = getTextOfElement(driver, "BasicPolicy.Helmet_text");
		expectedValue_foundValue(driver, "$2,500", Helmet_text);
		PersonalProperty_text = getTextOfElement(driver, "BasicPolicy.PersonalProperty_text");
		expectedValue_foundValue(driver, "$2,000", PersonalProperty_text);
		DeductibleWaiver_text = getTextOfElement(driver, "BasicPolicy.DeductibleWaiver_text");
		expectedValue_foundValue(driver, "Yes", DeductibleWaiver_text);
		DiminishingDed_text = getTextOfElement(driver, "BasicPolicy.DiminishingDed_text");
		expectedValue_foundValue(driver, "100% deductible applies", DiminishingDed_text);
		PermissiveInd_text = getTextOfElement(driver, "BasicPolicy.PermissiveInd_text");
		expectedValue_foundValue(driver, "Yes", PermissiveInd_text);
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
