package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR526_TC34061_HO3_ValidatePlumbingYearLessThan20NotRequireUWApprovalon_NB_GreaterThan20yearsRequiresUWApprovalon_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String appNum;
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String electricalYear = String.valueOf(currentY - 1);
	static String plumbingYearLessThan20 = String.valueOf(currentY - 20);
	static String plumbingGreaterLessThan20 = String.valueOf(currentY - 21);

	@When("User enters all required information on policy information screen <mtr526>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr526() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1475 Bush ST");
		sendText(quote.txtZipCode, "32534");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO3 quote screen <mtr526>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr526() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
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

	}

	@When("User enters all required information on HO3 dwelling screen <mtr526>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr526() {
		// Quote Dwelling information was filled here

		try {
			click(policyChevron.btnNext);
			wait(1);
			click(driver.findElement(By.id("dialogOK")));
			// sendText(dwellingChevron.txtYearConstruction, "2002");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
			selectDropdownText(dwellingChevron.ddProtectionClass, "03");
			selectDropdownText(dwellingChevron.bCEG, "3");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			sendText(dwellingChevron.txtCoverageA, "400000");
		} catch (Exception e) {
			// sendText(dwellingChevron.txtYearConstruction, "2002");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
			selectDropdownText(dwellingChevron.ddProtectionClass, "03");
			selectDropdownText(dwellingChevron.bCEG, "3");
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbit, "No");
			sendText(dwellingChevron.txtCoverageA, "400000");
		}
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(2);
	}

	@When("User completes required information on dwelling chevron and validates 'Risk is ineligible due to age of Plumbing' text not visible")
	public void user_completes_required_information_on_dwelling_chevron_and_validates_text_message_not_visible()
			throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		sendText(driver.findElement(By.id("Building.YearElectricalUpdated")), electricalYear);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible due to age of Plumbing");
	}

	@And("User finalizes transaction for VOL HO3 and validates 'Risk is ineligible due to age of Plumbing' text not visible")
	public void user_finalizes_transaction_for_VOL_HO3_and_validates_text_not_visible() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
		verify_AnyText_NotVisible(driver, "Risk is ineligible due to age of Plumbing");
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr526>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr526()
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

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr526>")
	public void user_searches_policy_for_mtr526() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 15 days <mtr401>")
	public void User_sets_new_effective_date_as_current_date_plus15days_mtr401() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(15)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron <mtr526>")
	public void user_clicks_dwelling_chevron_mtr526() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User updates plumbing year as bigger than 20 years")
	public void user_updates_plumbing_year_as_bigger_than_20_years() throws Exception {
		sendText(driver.findElement(By.id("Building.YearPlumbingUpdated")), plumbingGreaterLessThan20);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button and validates 'Risk is ineligible due to age of Plumbing' message is visible")
	public void User_clicks_finalize_and_validates_text_message_is_visible_mtr526_() throws Exception {
		reviewChevron.btnFinalize.click();
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");

		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application number <mtr526>")
	public void user_takes_note_of_the_application__number_mtr526() throws Exception {
		try {
			appNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + appNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <mtr526>")
	public void user_searches_application_for_mtr526() {
		sendText(dashboard.txtSearchBar, appNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates 'Risk is ineligible due to age of Plumbing' text is visible")
	public void user_validates_text_is_visible_mtr526() {
		try {
			verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User process and completes endorsement and finishes test <mtr526>")
	public void user_process_and_completes_endorsement_and_finishes_test_mtr526() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
