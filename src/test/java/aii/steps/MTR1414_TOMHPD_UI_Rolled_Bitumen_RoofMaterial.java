package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR1414_TOMHPD_UI_Rolled_Bitumen_RoofMaterial extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String[] roofmaterial2021 = { "Select...", "Composition Shingle", "Metal", "Rolled/Bitumen",
			"Tar and Gravel", "Other" };
	static String TOMHPD_renewalTerm1;
	static String renewal_effective;
	static String TOMHPD_renewalTerm2;

	@When("User enters all required information on policy information screen <mtr1414>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1414() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "15330 Searobbin Drive");
		sendText(quote.txtZipCode, "34202");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on TOMHPD quote screen <mtr1414>")
	public void user_enters_all_required_information_on_tomhpd_quote_screen_mtr1414() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHPD dwelling screen <mtr1414>")
	public void user_enters_all_required_information_on_tomhpd_dwelling_screen_mtr1414() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		getWaitObject();
		scrollToElement(dwellingChevron.txtCoverageA);
		wait(2);
		waitForVisibility(dwellingChevron.txtCoverageA);
		clickTab(dwellingChevron.txtCoverageA);
		clearText(dwellingChevron.txtCoverageA);
		wait(2);
		driver.findElement(By.id("Building.CovALimit")).sendKeys("80000"); // did hard coding due to element is hidden
																			// inside dom
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks Dwelling Chevron and completes required information <mtr1414>")
	public void user_clicks_dwelling_chevron_and_completes_required_information_mtr1414() {
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that TOMHPD policy has been created successfully and takes note of the policy number <mtr1414>")
	public void user_validates_that_tomhpd_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr1414()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("TakeOut MHPD policy has been created successfully");
		} else {
			System.out.println("TakeOut MHPD policy creation failed!");
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

	@When("User searches for the policy number <mtr1414>")
	public void user_searches_policy_for_mtr1414() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr1414>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr1414() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Dwelling Chevron for <mtr1414>")
	public void user_clicks_dwelling_chevron_mtr1414() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates roof material dropdown options")
	public void user_validates_roof_material_dd_options() throws Exception {
		verifyAnyDropDownOptions(driver, roofmaterial2021, "Building.RoofMaterial");
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr1414>")
	public void user_clicks_make_payment_and_selects_cc_1414() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String currentDue = driver.findElement(By.id("AccountSummary_CurrentDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, currentDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr1414>")
	public void user_makes_payment_with_credit_card_mtr1414() {
		makeCCPayment();

		// Close unnecessary tabs
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
	}

	@When("User does auto renewal through batch jobs and takes note of the renewed effective date")
	public void user_does_auto_renewal_through_batch_jobs_and_takes_note_of_the_renewed_eff_date() throws Exception {

		TOMHPD_renewalTerm1 = runAutoRenewPolicy(driver, policyNum, "01", "02");
		sendText(dashboard.txtSearchBar, TOMHPD_renewalTerm1);
		click(dashboard.search);
		wait(3);
		clickApplicationTab(driver);
		wait(1);
		switchWindows(driver);
		wait(1);

		// taking note of the renewal effective date
		driver.findElement(By.id("FullSummaryHolder")).click();
		wait(1);
		driver.findElement(By.id("Full_PolicySummary_TransactionEffectiveDt")).getText().toString();
		renewal_effective = driver.findElement(By.id("Full_PolicySummary_TransactionEffectiveDt")).getText().toString();
	}

	@When("User changes system date to renewal effective date")
	public void user_changes_system_date_to_renewal_eff_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, renewal_effective);
	}

	@When("User searches for the renewal term policy number <mtr1414>")
	public void user_searches_for_renewal_policy_for_mtr1414() {
		sendText(dashboard.txtSearchBar, TOMHPD_renewalTerm1);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as renewal effective date and starts endorsement <mtr1414>")
	public void User_sets_new_effective_date_as_renewaleffective_date_and_starts_endorsement_mtr1414() {
		sendText(historyChevron.txtEffectiveDate, renewal_effective);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User sets roof update as <2022>")
	public void user_sets_roof_update_as_2022() throws Exception {
		sendText(driver.findElement(By.id("Building.YearRoofMaterialUpdated")), "2022");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User finalizes transaction and endorses policy and close tabs")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
	}

	@When("User clicks Make Payment second time and selects credit card and enters due amount for <mtr1414>")
	public void user_clicks_make_payment_secondtime_and_selects_cc_1414() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_3")));
		wait(1);
		String currentDue2 = driver.findElement(By.id("AccountSummary_CurrentDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, currentDue2);
		wait(4);
	}

	@When("User does second auto renewal through batch jobs and completes test")
	public void user_does_second_auto_renewal_through_batch_jobs_and_completes_test() throws Exception {

		TOMHPD_renewalTerm2 = runAutoRenewPolicy(driver, TOMHPD_renewalTerm1, "02", "03");
		sendText(dashboard.txtSearchBar, TOMHPD_renewalTerm2);
		click(dashboard.search);
		wait(3);
		clickApplicationTab(driver);
		wait(1);
		switchWindows(driver);
		wait(1);
		Hooks.scenario.log("Test Case Completed!");
		;
	}
}
