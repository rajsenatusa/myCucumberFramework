package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC34595_TODP3_END_StandardAgent_AttributeOverride_AllowNumberofStoriesEndorsementEdit
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc34595>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34595() {

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

	@When("User enters product selection information for TODP3 and current date as effective date <tc34595>")
	public void user_enters_product_selection_information_for_todp3_and_current_date_as_effective_date_tc34595() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp3);
	}

	@When("User enters all required information on TODP3 quote screen <tc34595>")
	public void user_enters_all_required_information_on_todp3_quote_screen_tc34595() {
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

	@When("User enters all required information on TODP3 dwelling screen <tc34595>")
	public void user_enters_all_required_information_on_todp3_dwelling_screen_tc34595() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		sendText(dwellingChevron.txtSquareFeet, "2100");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "06");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddNumberofUnits, "2");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "41");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		click(dwellingChevron.btnSave);
		wait(1);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron and selects roof material <tc34595>")
	public void user_clicks_dwelling_chevron_and_selects_roof_material_tc34595() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		wait(2);
		click(dwellingChevron.btnSave);
	}

	@When("User validates that TODP3 policy has been created successfully and take note of policy number <tc34595>")
	public void user_validated_todp3_policy_has_been_created_successfully_and_takes_note_of_policy_number_tc34595()
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

	@When("User searches for the policy number <tc34595>")
	public void user_searches_policy_for_tc34595() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date plus 10 days and starts endorsement <tc34595>")
	public void User_sets_new_effective_date_as_current_date_plus_10_days_and_starts_endorsement_tc34595()
			throws Exception {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(10)));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
		click(dwellingChevron.btnDwelling);
		wait(2);
		attachScreenShot(driver);
	}

	@When("User clicks Dwelling Chevron <tc34595>")
	public void user_clicks_dwelling_chevron_tc34595() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@And("User clicks Finalize button <tc34595>")
	public void User_clicks_Finalize_button_tc34595() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@And("User process and completes endorsement <tc34595>")
	public void User_process_and_completes_endorsement_tc34595() {
		click(closeoutChevron.btnEndorsePolicy);
		wait(12);
		closeUnnecessaryTabs();
	}
}
