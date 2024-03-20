package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR411_HO3_Verify_Reinstate_of_Non_Renewal_policy_using_Rescind_transaction extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String ResNonRenewal_Form;
	static String ResNonRenewal_Form_Version;
	static String ResNonRenewal_Form_Name;
	
	@When("User enters all required information on policy information screen <mtr411>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr411() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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
	@When("User changes system date to current date <mtr411>")
	public void user_changes_system_date_to_current_date_mtr411() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on HO3 quote screen <mtr411>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr411() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User enters all required information on HO3 dwelling screen <mtr411>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr411() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2024");
//		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr411>")
	public void user_completes_required_information_on_dwelling_chevron_mtr411() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr411>")
	public void User_clicks_Finalize_button_mtr411() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr411>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr411()
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
	@When("User searches for the policy number <mtr411>")
	public void user_searches_policy_for_mtr411() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr411>")
	public void user_clicks_make_payment_and_selects_cc_mtr411() {
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

	@When("User makes payment with Credit Card for <mtr411>")
	public void user_makes_payment_with_credit_card_mtr411() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@And("User sets new effective date as current date and starts endorsement <mtr411>")
	public void User_sets_new_effective_date_as_current_date_plus_and_starts_endorsement_mtr411() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User clicks Dwelling Chevron and change reserve package from basic to silver <mtr411>")
	public void user_clicks_Dwelling_Chevron_and_change_reserve_package_from_basic_to_silver_mtr411() {
		click(dwellingChevron.btnDwelling);
		wait(1);
		click(dwellingChevron.rbSilverReserve);
	}
	@When("User finalizes transaction and completes endorsement and close unnecessary tabs <mtr411>")
	public void user_finalizes_transaction_and_completes_endorsement_mtr411() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}
	@And("User selects 'Failure to comply with underwriting requirements' as reason and 'An acceptable 4 point inspection was not provided' as a sub reason <mtr411>")
	public void User_selects_reason_and_subreason_mtr411() {
		selectDropdownText(historyChevron.ddReason, "Failure to comply with underwriting requirements");
		wait(1);
		selectDropdownText(historyChevron.ddSubReason, "An acceptable 4 point inspection was not provided");
		click(historyChevron.btnAdd);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
	}
	@And("User validates Non_Renewal transaction for HO3 policy has been created successfully <mtr411>")
	public void User_validates_Non_Renewal_transaction_for_ho3_policy_has_been_created_successfully_for_mtr411()
			throws Exception {

		verify_AnyText_IsVisible(driver, "Non-Renewal");
	}
	@And("User clicks Start button and process non renewal rescind transaction <mtr411>")
	public void User_clicks_Start_button_and_process_non_renewal_rescind_tx_mtr411() throws Exception {
		click(historyChevron.btnStart);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}

	@Then("User validates Non_Renewal Rescind transaction for HO3 policy has been created successfully <mtr411>")
	public void User_validates_Non_Renewal_Rescind_transaction_for_ho3_policy_has_been_created_successfully_for_mtr411()
			throws Exception {

		verify_AnyText_IsVisible(driver, "Non-Renewal Rescind");
	}
	@Then("User clicks Policy File Chevron <mtr411>")
	public void user_clicks_policy_file_chevron_mtr411() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User clicks Rescission of Non-Renewal Notice Link and validates form version and completes test <mtr411>")
	public void user_switches_that_forms_and_validates_mtr411() throws Exception {

		clickOnAnyLink(driver, "Rescission of Non-Renewal Notice");
		wait(3);
		switchToWindow(driver, "STFile&File");
		wait(3);
		ResNonRenewal_Form = PdfComparator.makePdf(driver, "RescissionofNonRenewalNotice.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ResNonRenewal_Form);
		wait(12);

		ResNonRenewal_Form_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + ResNonRenewal_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ResNonRenewal_Form_Version, "AIIC REC 11 14");
		ResNonRenewal_Form_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + ResNonRenewal_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ResNonRenewal_Form_Name, "CONTINUATION OF COVERAGE NOTICE");

		Hooks.scenario.log("Test Case Completed!");
	}
}
