package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR378_TC33702_TOMHO_UI_Rolled_Bitumen_RoofMaterial extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String[] roofmaterial2021 = { "Select...", "Composition Shingle", "Metal", "Rolled/Bitumen",
			"Tar and Gravel", "Other" };
	static String policyNum;
	static String TOMHO_renewalTerm1;
	static String renewal_effective;
	static String TOMHO_renewalTerm2;

	@When("User enters all required information on policy information screen <mtr378>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr378() {

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

	@When("User enters product selection information for TOMHO and current date as effective date")
	public void user_enters_product_selection_information_for_tomho_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomho);
	}

	@When("User enters all required information on TOMHO quote screen <mtr378>")
	public void user_enters_all_required_information_on_tomho_quote_screen_mtr378() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHO dwelling screen <mtr378>")
	public void user_enters_all_required_information_on_tomho_dwelling_screen_mtr378() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		// selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		sendText(dwellingChevron.txtCoverageA, "75000");
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "10%");
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron <mtr378>")
	public void user_clicks_dwelling_chevron_mtr378() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User completes required information on dwelling screen <mtr378>")
	public void user_completes_required_information_mtr378() {
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

	@When("User validates that TOMHO policy has been created successfully and takes note of the policy number")
	public void user_validates_that_tomho_policy_has_been_created_successfully_and_takes_note_of_the_policy_number()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut MHO policy has been created successfully");
		} else {
			System.out.println("Test failed!");
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

	@When("User searches for the policy number <mtr378>")
	public void user_searches_policy_for_mtr378() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr378>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr378() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User validates roof material dropdown options <mtr378>")
	public void user_validates_roof_material_dd_options_mtr378() throws Exception {
		verifyAnyDropDownOptions(driver, roofmaterial2021, "Building.RoofMaterial");
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr378>")
	public void user_clicks_make_payment_and_selects_cc_378() {
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

	@When("User makes payment with Credit Card for <mtr378>")
	public void user_makes_payment_with_credit_card_mtr378() {
		makeCCPayment();
		wait(1);
		closeUnnecessaryTabs();
	}

	@When("User does auto renewal through batch jobs <mtr378>")
	public void user_does_auto_renewal_through_batch_jobs_mtr378() throws Exception {
		TOMHO_renewalTerm1 = runAutoRenewPolicy(driver, policyNum, "01", "02");
	}

	@When("User searches for the renewed policy number <mtr378>")
	public void user_searches_renewed_policy_for_mtr378() {
		sendText(dashboard.txtSearchBar, TOMHO_renewalTerm1);
		click(dashboard.search);
		wait(3);
	}

	@When("User gets transaction effective date")
	public void user_gets_transaction_effective_date() throws Exception {
		clickApplicationTab(driver);
		wait(1);
		switchWindows(driver);
		wait(1);
		renewal_effective = getTransactionEffDate(driver).toString();
	}

	@When("User changes system date to renewal effective date <mtr378>")
	public void user_changes_system_date_to_renewal_eff_date_mtr378() throws Exception {
		ChangeAdminDate_NotInbox(driver, renewal_effective);
	}

	@And("User sets new effective date as renewal effective date and starts endorsement <mtr378>")
	public void User_sets_new_effective_date_as_renewaleffective_date_and_starts_endorsement_mtr378() {
		sendText(historyChevron.txtEffectiveDate, renewal_effective);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Make Payment second time and selects credit card and enters due amount for <mtr378>")
	public void user_clicks_make_payment_second_time_and_selects_credit_card_mtr_378() {
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

	@When("User makes payment with Credit Card for the second time <mtr378>")
	public void user_makes_payment_second_time_with_credit_card_mtr378() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does second auto renewal through batch jobs and completes test <mtr378>")
	public void user_does_second_auto_renewal_through_batch_jobs_and_completes_test_mtr378() throws Exception {

		TOMHO_renewalTerm2 = runAutoRenewPolicy(driver, TOMHO_renewalTerm1, "02", "03");
		sendText(dashboard.txtSearchBar, TOMHO_renewalTerm2);
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
