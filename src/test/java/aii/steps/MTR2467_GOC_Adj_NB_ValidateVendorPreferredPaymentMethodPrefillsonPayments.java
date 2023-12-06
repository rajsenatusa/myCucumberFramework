package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR2467_GOC_Adj_NB_ValidateVendorPreferredPaymentMethodPrefillsonPayments extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String claimNum;

	@When("User enters all required information on policy information screen <mtr2467>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2467() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Aaron");
		sendText(quote.txtLastName, "Ramsey");
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

	@When("User enters all required information on GOC quote screen <mtr2467>")
	public void user_enters_all_required_information_on_goc_quote_screen_mtr2467() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "DO NOT USE INSURANCE SCORE");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		click(dwellingChevron.btnSave);
		waitImp(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr2467>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr2467() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$2,500");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$20,000/$40,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$500");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$500");
		wait(1);
		click(golfcartChevron.btnGoldReservePackage);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <mtr2467>")
	public void user_enters_driver_information_on_driver_screen_mtr2467() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <mtr2467>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr2467() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2019");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "4523");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User validates that GOC policy has been created successfully and takes note of the policy number <mtr2467>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr2467() throws Exception {

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

	@When("User searches for Policy Number for <mtr2467>")
	public void user_searches_for_policy_number_for_mtr2467() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User changes system date to current date plus 10 days")
	public void user_changes_system_date_to_currentdate_plus_10_days() throws Exception {
		ChangeDate_Admin(driver, dtf.format(currentDate.plusDays(10)));
	}

	@When("User sets loss date as current date plus <10> days")
	public void user_sets_loss_date_as_current_date_plus_10_days() {
		sendText(claim.txtLossDate, dtf.format(currentDate.plusDays(10)));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as Collapse and clicks Save")
	public void user_selects_loss_cause_as_collapse_and_clicks_save() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collapse");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User selects vehicle, purpose of use and all required information on claim screen")
	public void user_selects_vehicle_purpose_of_use_and_all_req_infoo_on_claim_screen() throws Exception {
		selectDropdownText(claim.ddClaimBoatSelection, "2019 Golf Make Golf Model - 452PJ8GGH77"); // golfcart selection
		selectDropdownText(claim.ddClaimPurposeUse, "Personal");
		wait(1);
		selectDropdownText(claim.ddClaimOperator, "Ramsey, Aaron ");
		sendText(claim.txtClaimDescription, "Golf claim payment verification");
		selectDropdownText(claim.txtClaimCurrentLocation, "On");
		click(driver.findElement(By.id("InsuredLocation")));
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks Complete and takes note of the claim number <mtr2467>")
	public void user_clicks_complete_takes_notes_mtr2467() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User starts transaction")
	public void user_starts_transaction() throws Exception {
		startTransaction(driver);
		wait(1);
	}

	@When("User clicks Financial Actions button and clicks Adjust Reserves")
	public void user_clicks_Financial_Actions_button_and_clicks_Adjust_reserves() throws Exception {
		click(claim.btnFinancialActions);
		clickAdjustReserves(driver);
		wait(1);
	}

	@When("User fills Indemnity and Adjust text boxes")
	public void user_fills_Indemnity_and_Adjust_text_boxes() throws Exception {
		sendText(driver.findElement(By.id("Reserve_COLL_COLLSUB_Indemnity")), "1000");
		sendText(driver.findElement(By.id("Reserve_COLL_COLLSUB_Adjustment")), "600");
		click(claim.btnSave);
		wait(1);
		attachScreenShot(driver);
	}

	@When("User finalizes adjust transaction and process")
	public void user_finalizes_adjust_transaction_and_process() throws Exception {
		click(claim.btnFinalize);
		wait(3);
		click(claim.btnProcess);
		wait(2);
	}

	@When("User clicks Financial Actions button and clicks Make Payment")
	public void user_clicks_Financial_Actions_button_and_clicks_Make_Payment() throws Exception {
		click(claim.btnFinancialActions);
		click(claim.btnMakePayment);
		wait(2);
	}

	@When("User selects Indemnity payment and do necessary validations")
	public void user_selects_indemnity_payment_and_do_necessary_validations() throws Exception {
		selectDropdownText(claim.ddPaymentType, "Indemnity");
		wait(1);
		sendText(driver.findElement(By.id("VendorProviderNumber")), "CA0DM");
		wait(1);
		click(driver.findElement(By.id("ClaimantTransaction.PayToProviderInd")));
		wait(1);
		verifyAnyDropdownDefaultedValue(driver, "ClaimantTransaction.PaymentMethodCd", "Check - Batch");
		attachScreenShot(driver);
		verifyAnyElement_Disabled(driver, "ClaimantTransaction.PaymentMethodCd");
		click(driver.findElement(By.id("ClaimantTransaction.PayToClaimantInd")));
		wait(1);
		verifyAnyDropdownDefaultedValue(driver, "ClaimantTransaction.PaymentMethodCd", "Check - Batch");
		attachScreenShot(driver);
		verifyAnyElement_Disabled(driver, "ClaimantTransaction.PaymentMethodCd");
		attachScreenShot(driver);
	}

	@When("User selects Adjustment payment and do necessary validations")
	public void user_selects_adjustment_payment_and_do_necessary_validations() throws Exception {
		selectDropdownText(claim.ddPaymentType, "Adjustment");
		wait(1);
		sendText(driver.findElement(By.id("VendorProviderNumber")), "CA0DM");
		wait(1);
		click(driver.findElement(By.id("ClaimantTransaction.PayToProviderInd")));
		wait(1);
		//verifyAnyDropdownDefaultedValue(driver, "ClaimantTransaction.PaymentMethodCd", "Check - Batch");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");

		click(driver.findElement(By.id("ClaimantTransaction.PayToClaimantInd")));
		wait(1);
		//verifyAnyDropdownDefaultedValue(driver, "ClaimantTransaction.PaymentMethodCd", "Check - Batch");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");
		attachScreenShot(driver);

		click(driver.findElement(By.id("ClaimantTransaction.PayToInterestInd")));
		wait(1);
		//verifyAnyDropdownDefaultedValue(driver, "ClaimantTransaction.PaymentMethodCd", "Check - Batch");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");
	}

	@When("User selects Return Indemnity payment and do necessary validations")
	public void user_selects__return_indemnity_payment_and_do_necessary_validations() throws Exception {
		selectDropdownText(claim.ddPaymentType, "Return Indemnity");
		wait(1);
		VerifyAnyDropdownIsNotSelected(driver, "ClaimantTransaction.PaymentMethodCd");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");
	}

	@When("User selects Return Recovery payment and do necessary validations")
	public void user_selects__return_recovery_payment_and_do_necessary_validations() throws Exception {
		selectDropdownText(claim.ddPaymentType, "Return Recovery");
		wait(1);
		VerifyAnyDropdownIsNotSelected(driver, "ClaimantTransaction.PaymentMethodCd");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");
	}

	@Then("User selects Return Adjustment payment and do necessary validations")
	public void user_selects__return_adjustment_payment_and_do_necessary_validations() throws Exception {
		selectDropdownText(claim.ddPaymentType, "Return Adjustment");
		wait(1);
		VerifyAnyDropdownIsNotSelected(driver, "ClaimantTransaction.PaymentMethodCd");
		attachScreenShot(driver);
		verifyAnyElement_Enabled(driver, "ClaimantTransaction.PaymentMethodCd");
		Hooks.scenario.log("Test Case Completed!");
	}

}
