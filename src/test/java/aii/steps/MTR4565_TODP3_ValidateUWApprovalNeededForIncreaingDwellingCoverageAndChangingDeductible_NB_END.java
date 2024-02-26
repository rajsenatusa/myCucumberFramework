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

public class MTR4565_TODP3_ValidateUWApprovalNeededForIncreaingDwellingCoverageAndChangingDeductible_NB_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16781>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16781() {

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

	@When("User enters product selection information for TODP3 and current date as effective date <tc16781>")
	public void user_enters_product_selection_information_for_todp3_and_current_date_as_effective_date_tc16781() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp3);
	}

	@When("User enters all required information on TODP3 quote screen <tc16781>")
	public void user_enters_all_required_information_on_todp3_quote_screen_tc16781() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TODP3 dwelling screen <tc16781>")
	public void user_enters_all_required_information_on_todp3_dwelling_screen_tc16781() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2100");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "06");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		//selectDropdownText(dwellingChevron.ddNumberofUnits, ConfigsReader.getProperty("numberofunits"));
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "41");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(1);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron and selects roof material <tc16781>")
	public void user_clicks_dwelling_chevron_and_selects_roof_material_tc16781() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		wait(2);
		click(dwellingChevron.btnSave);
	}

	@When("User validates that TODP3 policy has been created successfully and take note of policy number <tc16781>")
	public void user_validated_todp3_policy_has_been_created_successfully_and_takes_note_of_policy_number_tc16781()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut DP3 policy has been created successfully");
		} else {
			System.out.println("TakeOut DP3 policy creation failed!");
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

	@When("User searches for the policy number <tc16781>")
	public void user_searches_policy_for_tc16781() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 30 days and starts endorsement <tc16781>")
	public void User_sets_new_effective_date_as_endorsement_date_and_starts_endorsement_tc16781() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(30)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <tc16781>")
	public void user_clicks_dwelling_chevron_tc16781() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User increases CovA Dwelling and add other coverages <tc16781>")
	public void user_increases_covADwelling_and_other_coverages_tc16781() throws Exception {

		sendText(dwellingChevron.txtCoverageA, "291,000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User clicks Finalize button, validates changes are visible on closeout screen <tc16781>")
	public void User_clicks_finalize_and_validates_changes_tc16781_() throws Exception {
		reviewChevron.btnFinalize.click();
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $5,000 Must be Approved");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible May Only be Changed at Renewal");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application for <tc16781>")
	public void user_takes_note_of_the_application__number_for_tc16781() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc16781>")
	public void user_searches_application_for_tc16781() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates expected following messages on issue tile <tc16781>")
	public void user_validates_expected_following_messages_on_issue_tile_tc16781() throws Exception {
		verify_AnyText_IsVisible(driver, "Coverage A change cannot exceed $5,000 Must be Approved");
		verify_AnyText_IsVisible(driver, "Change in Hurricane Deductible May Only be Changed at Renewal");
		attachScreenShot(driver);
	}

	@Then("User process and completes endorsement and finishes test <tc16781>")
	public void user_process_and_completes_endorsement_and_finishes_test_tc16781() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Endorse Policy");
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
		closeUnnecessaryTabs();
		expandTransaction(driver, "1_2");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Deductible Change: Hurricane Changed From 2% to 10%");
		Hooks.scenario.log("Test Case Completed!");
	}
}
