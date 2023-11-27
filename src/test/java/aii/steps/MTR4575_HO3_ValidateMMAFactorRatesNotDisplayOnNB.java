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

public class MTR4575_HO3_ValidateMMAFactorRatesNotDisplayOnNB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <mtr4575>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr4575() {

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

	@When("User enters HO3 product selection information and current date as effective date <mtr4575>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr4575() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <mtr4575>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4575() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO3 dwelling screen <mtr4575>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4575() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		// sendText(dwellingChevron.txtRoofMaterialUpdate, "2020");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.rbSilverReserve);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User completes required information on dwelling chevron <mtr4575>")
	public void user_completes_required_information_on_dwelling_chevron_mtr4575() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
	}

	@And("User clicks Finalize button <mtr4575>")
	public void User_clicks_Finalize_button_mtr4575() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr4575>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr4575()
			throws Exception {
		wait(5);
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

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr4575>")
	public void user_searches_policy_for_mtr4575() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates MMA rate factors on NB level")
	public void user_validates_MMA_rate_factors_on_NB_level() throws Exception {
		expandAnyDiscountProperty(driver, "Rate Area - Water Non-Weather", "BasePremium0");
		Thread.sleep(500);
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Water Non-Weather", "BasePremium7",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Water Non-Weather", "BasePremium7",
				"1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - Fire or Lightning", "BasePremium27");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Fire or Lightning", "BasePremium34",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Fire or Lightning", "BasePremium34",
				"1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - Liability", "BasePremium54");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Liability", "BasePremium61",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Liability", "BasePremium61", "1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - Other", "BasePremium81");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Other", "BasePremium89",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Other", "BasePremium89", "1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - Weather", "BasePremium110");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Weather", "BasePremium118",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Weather", "BasePremium118", "1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - Theft", "BasePremium146");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Theft", "BasePremium153",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Theft", "BasePremium153", "1.000");
		Thread.sleep(1000);

		expandAnyDiscountProperty(driver, "Rate Area - CGCC", "BasePremium173");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - CGCC", "BasePremium180",
				"Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - CGCC", "BasePremium180", "1.000");

//		expandAnyDiscountProperty(driver, "Rate Area - Hurricane", "BasePremium200");
//		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Hurricane", "BasePremium206",
//				"Mediation-Artbitration Coverage");
//		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Hurricane", "BasePremium206", "1.000");
	}

	@And("User sets new effective date as current date and starts endorsement <mtr4575>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr4575() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr4575>")
	public void user_clicks_dwelling_chevron_mtr4575() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User sets MMA selection as Yes <mtr4575>")
	public void user_sets_MMA_selection_as_Yes_mtr4575() throws Exception {
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@And("User clicks Finalize button and Endorses Policy <mtr4575>")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr4575_() {
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();
		wait(12);
		closeUnnecessaryTabs();
	}
	@Then("User validates MMA rate factors on EN level and completes test")
	public void user_validates_MMA_rate_factors_on_EN_level_and_completes_test() throws Exception {
		expandAnyDiscountProperty(driver, "Rate Area - Water Non-Weather", "BasePremium0");
		Thread.sleep(500);
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Water Non-Weather", "BasePremium7", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Water Non-Weather", "BasePremium7", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - Fire or Lightning", "BasePremium27");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Fire or Lightning", "BasePremium34", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Fire or Lightning", "BasePremium34", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - Liability", "BasePremium54");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Liability", "BasePremium61", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Liability", "BasePremium61", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - Other", "BasePremium81");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Other", "BasePremium89", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Other", "BasePremium89", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - Weather", "BasePremium110");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Weather", "BasePremium118", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Weather", "BasePremium118", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - Theft", "BasePremium146");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Theft", "BasePremium153", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Theft", "BasePremium153", "0.750");
		Thread.sleep(1000);
		
		expandAnyDiscountProperty(driver, "Rate Area - CGCC", "BasePremium173");
		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - CGCC", "BasePremium180", "Mediation-Artbitration Coverage");
		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - CGCC", "BasePremium180", "0.750");
		
//		expandAnyDiscountProperty(driver, "Rate Area - Hurricane", "BasePremium200");
//		verifyResults_ForAnyCoverageDiscountPropertyDesc(driver, "Rate Area - Hurricane", "BasePremium206", "Mediation-Artbitration Coverage");
//		verifyResults_ForAnyCoverageDiscountPropertyRate(driver, "Rate Area - Hurricane", "BasePremium206", "1.000");
		Hooks.scenario.log("Test Case Completed!");
	}
}
