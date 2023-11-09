package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16741_DP1_ValidateErrorMessagesonQuoteLeveUICharacteristics extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime expirationDate = currentDate.minusDays(50);
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen with closed county address <tc16741>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16741() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "6832 SW 21st St");
		sendText(quote.txtZipCode, "33023");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP1 quote screen with Owner Occupied occupancy type <tc16741>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_tc16741() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
//		click(policyChevron.btnNext);
//		wait(3);
	}

	@When("User validates 'County is closed for new business' text is visible <tc16741>")
	public void user_validates_County_is_closed_for_new_business_text_is_visible_tc16741() throws Exception {
		verify_AnyText_IsVisible(driver, "County is closed for new business");
		clickonAnyButton(driver, "Delete");
		clickOKDailogButton(driver);
	}

	@When("User creates new quote again <tc16741>")
	public void user_creates_new_quote_again_tc16741() {

		// quote level information was filled here

		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Smith");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1165 Peperidge");
		sendText(quote.txtZipCode, "32504");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP1 quote screen with Tenant Occupied occupancy type and monthly rented total 5 times and validates expected issue messages <tc16741>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_tenant_occupied_occupancy_type__tc16741()
			throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Monthly, rented a total of 5 times or less each year");
		selectDropdownText(policyChevron.ddPropertyManaged, "No");
		selectDropdownText(driver.findElement(By.id("OwnerLT100MilesAwayInd")), "No");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver,
				"Tenant occupied dwellings must be managed by a property management company if the owner lives more than 100 miles away from the property");
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver, "Monthly Lease Terms are subject to underwriting approval");
		attachScreenShot(driver);

//		click(policyChevron.btnNext);
//		wait(3);
	}

	@When("User changes property managed selection as yes and months occupied as montly rented total 6 times and validates expected issue messages")
	public void user_changes_property_managed_selection_as_yes_and_months_occupied_as_monthly_rented_total_6_times()
			throws Exception {
		selectDropdownText(policyChevron.ddMonthsOccupied, "Monthly, rented a total of 6 times or more each year");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver, "Short Term Rental Properties require Underwriting Approval");
		verify_AnyText_IsVisible(driver, "Monthly Lease Terms are subject to underwriting approval");
	}

	@When("User changes Lease Term as Annual and selects Short Term Rental as Yes and validates expected messages")
	public void user_changes_Lease_Term_as_Annual_and_selects_Short_Term_Renta_as_Yes_and_validates_expected_messages()
			throws Exception {
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver, "Short Term Rental Properties require Underwriting Approval");
	}

	@When("User sets prior carrier, expiration date as current date minus 50 days and validates expected issue messages")
	public void user_sets_prior_carrier_expiration_date_as_current_date_minus_50_days_validates_expected_messages()
			throws Exception {
		selectDropdownText(policyChevron.ddPreviousCarrier, "ASI");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(expirationDate));
		selectDropdownText(policyChevron.ddOccupancy, "Vacant");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver,
				"Acknowledgment of Consent to Rate must be provided within 30 days of issuance");
	}

	@When("User sets prior carrier as new purchase removes expiration date sets occupancy as owner occupied 0 to 3 months and validates issue messages")
	public void user_sets_prior_carrier_as_new_purchase_removes_expiration_date_sets_occupancy_as_owner_occupied_and_validates_expected_messages()
			throws Exception {
		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(expirationDate));
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "0 to 3 Months");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen and validates expected issue messages <tc16741>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc16741() throws Exception {

		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberofUnits, "8");
		selectDropdownText(dwellingChevron.ddDwellingType, "Row/Town House");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		clickOKDailogButton(driver);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		verify_AnyText_IsVisible(driver,
				"When the number of units within the fire walls is greater than 4 then the risk is not eligible for the program");
	}

	@When("User sets CoverageA as <1.700.000> and other deductibles and validates issue messages")
	public void user_sets_CoverageA_as_1700000_and_other_deductibles_and_validates_issue_messages() throws Exception {
		sendText(driver.findElement(By.id("CovALimit")), "1,700,000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$500");
		wait(1);
		sendText(dwellingChevron.txtCoverageC, "260000");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		verify_AnyText_IsVisible(driver,
				"When the number of units within the fire walls is greater than 4 then the risk is not eligible for the program");
		verify_AnyText_IsVisible(driver, "$500 Hurricane Deductible is not available");
		verify_AnyText_IsVisible(driver, "Deductible for All Other Perils Cannot Exceed Deductible for Hurricane");
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Coverage A Maximum which exceeds a maximum of $500,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver,
				"Coverage C - Personal Property Limits that exceed $250000 are ineligible for coverage");
		driver.findElement(By.id("Building.CovCLimit")).clear();
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User sets CoverageA as <10.000> and other deductibles and validates issue messages")
	public void user_sets_CoverageA_as_10000_and_other_deductibles_and_validates_issue_messages() throws Exception {
		sendText(driver.findElement(By.id("CovALimit")), "10000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "2%");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		verify_AnyText_IsVisible(driver,
				"When the number of units within the fire walls is greater than 4 then the risk is not eligible for the program");
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $100,000 requires underwriting review]");
		verify_AnyText_IsVisible(driver, "Deductible for All Other Perils Cannot Exceed Deductible for Hurricane");
		verify_AnyText_IsVisible(driver, "Hurricane Deductible must be a minimum of $500");
	}

	@When("User sets CoverageA as <232.000> and other deductibles and validates issue messages")
	public void user_sets_CoverageA_as_232000_and_other_deductibles_and_validates_issue_messages() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(driver.findElement(By.id("CovALimit")), "232000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "2%");
		sendText(driver.findElement(By.id("Building.CovBLimitIncrease")), "200000");
		driver.findElement(By.id("Building.CovBLimitIncrease")).sendKeys(Keys.TAB);

		try {
			if (ExpectedConditions.alertIsPresent() != null) {
				Alert alert = driver.switchTo().alert();
				String alerttext = alert.getText().toString();
				Hooks.scenario.log(alerttext);
				alert.accept();
			}
		} catch (Exception e) {
			Hooks.scenario.log("Alert is not present");
		}

		// Set Cov-C = $200,000
		clickOKDailogButton(driver);
		sendText(dwellingChevron.txtCoverageC, "200,000");
		driver.findElement(By.id("Building.CovCLimit")).sendKeys(Keys.TAB);
		try {
			if (ExpectedConditions.alertIsPresent() != null) {
				Alert alert = driver.switchTo().alert();
				String alerttext = alert.getText().toString();
				Hooks.scenario.log(alerttext);
				alert.accept();
			}
		} catch (Exception e) {
			
			Hooks.scenario.log("Alert is not present");
		}
	}
	@When("User sets Limited Cart Pool Cage Coverage and other deductibles and validates issue messages")
	public void user_sets_limited_cart_pool_cage_coverage_and_other_deductibles_and_validates_expected_messages()
			throws Exception {
		clickOKDailogButton(driver);
		sendText(driver.findElement(By.id("Building.CovBLimitIncrease")), "100000");
		sendText(dwellingChevron.txtCoverageC, "100000");
		selectDropdownText(driver.findElement(By.id("Building.CovLFMLimit")), "$50,000 Each Covered Loss/$50,000 Aggregate");
		sendText(driver.findElement(By.id("Building.CovLCARLimit")), "100000");   //limited carports pool cage coverage
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		verify_AnyText_IsVisible(driver, "Limited Carport(s), Pool Cage(s), and Screen Enclosure(s) limits less than $10,000 or greater than $50,000 are not available");
		verify_AnyText_IsVisible(driver, "A Limit increase for the Limited Fungi, Mold, Wet or Dry Rot or Bacteria Coverage Must be Approved");	
	}
	@When("User checks Wind Hail exclusion and validates issue messages")
	public void user_checks_Wind_Hail_exlusion_and_validates_issue_messages()
			throws Exception {
		driver.findElement(By.id("Building.WindHailExcludedInd")).click();
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "A lapse in coverage requires a signed no loss.");
		verify_AnyText_IsVisible(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP1 policy form");
		verify_AnyText_IsVisible(driver, "The signed Windstorm or Hail exclusion form must be submitted after binding");
		verify_AnyText_IsVisible(driver, "A Limit increase for the Limited Fungi, Mold, Wet or Dry Rot or Bacteria Coverage Must be Approved");
	}
	@Then("User enters all required information on DP1 review screen and completes test")
	public void user_enters_all_required_information_on_dp1_review_screen_and_completes_test() {

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		Hooks.scenario.log("Test Case Completed!");
	}
}
