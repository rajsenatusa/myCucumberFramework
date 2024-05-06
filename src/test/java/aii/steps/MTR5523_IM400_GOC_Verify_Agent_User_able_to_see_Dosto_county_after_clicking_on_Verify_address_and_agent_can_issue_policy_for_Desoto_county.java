package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5523_IM400_GOC_Verify_Agent_User_able_to_see_Dosto_county_after_clicking_on_Verify_address_and_agent_can_issue_policy_for_Desoto_county
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen and validates Desoto County displayed on county tab <mtr5523>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5523() throws Exception {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Max");
		sendText(quote.txtLastName, "Jordan");
		sendText(quote.txtBirthDate, "03/27/1980");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "4970 Coleman Rd");
		sendText(quote.txtZipCode, "38654");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(3);

		WebElement county = driver.findElement(By.id("CustomerLookupAddr.County"));

		if (county.isDisplayed()) {
			Hooks.scenario.log("Desoto County is visible on county field");
			attachScreenShot(driver);
		}
		else {
			Hooks.scenario.log("Desoto County is NOT visible on county field");
			attachScreenShot(driver);
		}

		// CustomerLookupAddr.County
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on GOC quote screen <mtr5523>")
	public void user_enters_all_required_information_on_goc_quote_screen_mtr5523() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "DO NOT USE INSURANCE SCORE");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr5523>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr5523() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$5,000");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$10,000/$20,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$500");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$500");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <mtr5523>")
	public void user_enters_driver_information_on_driver_screen_mtr5523() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "T600421602600");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "5+");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <mtr5523>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr5523() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2015");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Gas");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "10000");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@Then("User validates that GOC policy has been created successfully and completes test <mtr5523>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr5523() throws Exception {

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
	@When("User takes note of the application number <mtr5523>")
	public void user_takes_note_of_the_application__number_mtr5523() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches application <mtr5523>")
	public void user_searches_application_mtr5523() throws Exception {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
}
