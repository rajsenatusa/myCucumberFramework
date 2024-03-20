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

public class MTR412_GOC_Verify_Non_Renewal_Rescind_transaction extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String renewalTerm1;

	@When("User enters all required information on policy information screen <mtr412>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr412() {

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

	@When("User enters GOC product selection information and current date minus 1 year as effective date <mtr412>")
	public void user_enters_goc_product_selection_information_and_currentdate_minus_1year_as_effective_date_mtr412() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate.minusYears(1)));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionGoc);
	}

	@When("User enters all required information on GOC quote screen <mtr412>")
	public void user_enters_all_required_information_on_goc_quote_screen_mtr412() {
		// Quote Policy Chevron information was filled here
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr412>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr412() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$100");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$100");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <mtr412>")
	public void user_enters_driver_information_on_driver_screen_mtr412() {

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

	@When("User enters vehicles information on vehicles screen <mtr412>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr412() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2019");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "GOC Make");
		sendText(golfcartChevron.txtGcModel, "GOC Model");
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

	@When("User validates that GOC policy has been created successfully and takes note of the policy number <mtr412>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr412() throws Exception {

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

	@When("User searches for the policy number <mtr412>")
	public void user_searches_policy_for_mtr412() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Renewal <mtr412>")
	public void User_selects_Endorsement_mtr412() {
		selectDropdownText(dashboard.ddSelectTransaction, "Renewal");
		wait(1);
		click(dashboard.btnSelect);
	}

	@When("User does manual renewal on the policy <mtr412>")
	public void user_does_manual_renewal_on_the_polcy_mtr412() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(10);
		closeUnnecessaryTabs();
		// taking note of the renewal issued policy
		try {
			renewalTerm1 = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + renewalTerm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User searches renewed policy <mtr412>")
	public void User_searches_renewed_policy_mtr412() {
		sendText(dashboard.txtSearchBar, renewalTerm1);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr412>")
	public void user_clicks_make_payment_and_selects_cc_mtr412() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr412>")
	public void user_makes_payment_with_credit_card_mtr412() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@And("User sets new effective date as current date and starts endorsement <mtr412>")
	public void User_sets_new_effective_date_as_current_date_plus_and_starts_endorsement_mtr412() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User clicks Golf Cart Chevron and changes changes golf cart coverage from basic to gold")
	public void User_clicks_Golf_Chevron_and_changes_golf_cart_coverage_from_basic_to_gold() {
		click(golfcartChevron.lnkGolfCartChevron);
		click(golfcartChevron.btnGoldReservePackage);
	}

	@When("User finalizes transaction and completes endorsement and close unnecessary tabs <mtr412>")
	public void user_finalizes_transaction_and_completes_endorsement_mtr412() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}

	@And("User selects 'Failure to comply with underwriting requirements' as reason and 'Signed application was not provided' as a sub reason <mtr412>")
	public void User_selects_reason_and_subreason_mtr412() {
		selectDropdownText(historyChevron.ddReason, "Failure to comply with underwriting requirements");
		wait(1);
		selectDropdownText(historyChevron.ddSubReason, "Signed application not provided.");
		click(historyChevron.btnAdd);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User validates Non_Renewal transaction for GOC policy has been created successfully <mtr412>")
	public void User_validates_Non_Renewal_transaction_for_GOC_policy_has_been_created_successfully_for_mtr412()
			throws Exception {

		verify_AnyText_IsVisible(driver, "Non-Renewal");
	}

	@And("User clicks Start button and process non renewal rescind transaction")
	public void User_clicks_Start_button_and_process_non_renewal_rescind_tx() throws Exception {
		click(historyChevron.btnStart);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}

	@Then("User validates Non_Renewal Rescind transaction for GOC policy has been created successfully <mtr412>")
	public void User_validates_Non_Renewal_Rescind_transaction_for_GOC_policy_has_been_created_successfully_for_mtr412()
			throws Exception {

		verify_AnyText_IsVisible(driver, "Non-Renewal Rescind");
		Hooks.scenario.log("Test Case Completed!");
	}
}
