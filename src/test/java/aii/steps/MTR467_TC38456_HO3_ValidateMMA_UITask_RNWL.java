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

public class MTR467_TC38456_HO3_ValidateMMA_UITask_RNWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime renewDate = currentDate.plusYears(1);
	static LocalDateTime taskDate = renewDate.plusDays(15);
	static String mmaTaskDate = String.valueOf(taskDate.format(dtf));
	static String policyNum;
	static String totalDue;
	static String PolicyNumberTerm02;
	static String renewal_effective;
	static String temp;
	static String refer;
	static String status;
	static String workdate;
	static String Completed_status;

	@When("User enters all required information on policy information screen <mtr467>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr467() {

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

	@When("User enters HO3 product selection information and current date as effective date <mtr467>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr467() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <mtr467>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr467() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		waitImp(5);
		getInsuranceScore(driver, "Neutral");
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

	@When("User enters all required information on HO3 dwelling screen <mtr467>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr467() {

		sendText(dwellingChevron.txtSquareFeet, "1500");
		// selectDropdownText(dwellingChevron.bCEG, "4");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2022");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		waitImp(3);
	}

	@When("User completes required information on dwelling chevron selects Dwelling Type <mtr467>")
	public void user_completes_required_information_on_dwelling_chevron_selects_dwelling_type_mtr467()
			throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <mtr467>")
	public void User_clicks_Finalize_button_mtr467() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr467>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr467()
			throws Exception {
		waitImp(5);
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

	@When("User clicks Make Payment and selects credit card and enters due amount <mtr467>")
	public void user_clicks_make_payment_and_selects_cc_mtr467() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card <mtr467>")
	public void user_makes_payment_with_credit_card_mtr467() {
		makeCCPayment();
		wait(3);
		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does auto renewal through batch jobs <mtr467>")
	public void user_does_auto_renewal_through_batch_jobs_mtr467() throws Exception {
		PolicyNumberTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		renewal_effective = getTransactionEffDate(driver).toString();
		temp = replaceMethod(policyNum, "-01", "");
	}

	@When("User changes system date to renewal effective date as current date plus 1 year <mtr467>")
	public void user_changes_system_date_To_renewal_effective_date_as_current_date_plus_1_year_mtr467()
			throws Exception {
		ChangeDate_Admin(driver, renewal_effective);
	}

	@When("User searches for renewed Policy Number for <mtr467>")
	public void user_searches_for_policy_number_for_mtr467() throws Exception {
		sendText(dashboard.txtSearchBar, PolicyNumberTerm02);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects endorsement date as renewal effective date <mtr467>")
	public void user_selects_endorsement_date_as_renewal_eff_date_mtr467() {
		sendText(dashboard.txtSelectDate, renewal_effective);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User clicks Dwelling Chevron <mtr467>")
	public void user_clicks_dwelling_chevron_mtr467() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates 'Mandatory Mediation-Arbitration Changed From No to Yes' label is visible <mtr467>")
	public void user_validates_MMA_Changed_from_No_to_yes_label_is_visible_mtr467() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Mediation Arbitration Changed From No to Yes");
	}

	@When("User validates 'Mandatory Mediation-Arbitration discount applied on Policy' displayed with policy number and do other necessary validation referred in test steps <mtr467>")
	public void user_validates_MMA_discount_applied_on_Policy_displayed_with_policy_number_mtr467() throws Exception {
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp
				+ ". Please Review and follow up for signed acknowledgment if not received.");
		refer = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer);
		status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status);
		workdate = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, mmaTaskDate, workdate);
	}

	@Then("User selects show all and validates 'Mandatory Mediation-Arbitration discount applied on Policy' text is visible and do other validations <mtr467>")
	public void user_selects_show_all_and_validates_MMA_discount_applied_on_policy_text_is_visible_and_do_other_validations_mtr467()
			throws Exception {
		selectShowAll(driver);
		checkShowSysTask(driver);
		Thread.sleep(500);
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp
				+ ". Please Review and follow up for signed acknowledgment if not received.");
		Completed_status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Completed", Completed_status);
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User sets MMA selection as Yes <mtr467>")
	public void user_sets_MMA_selection_as_Yes_mtr467() throws Exception {
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
	}
}
