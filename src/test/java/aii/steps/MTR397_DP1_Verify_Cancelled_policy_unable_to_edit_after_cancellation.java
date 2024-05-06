package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR397_DP1_Verify_Cancelled_policy_unable_to_edit_after_cancellation extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String ManualRenewDt;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancellationConfirmationForm;
	static String CCForm_Version;
	static String CCForm_Name;
	static String CCForm_Text1;
	static String CCForm_Text2;

	@When("User enters all required information on policy information screen <mtr397>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr397() {

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

	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr397>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr397() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen <mtr397>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr397() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr397>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_mtr397()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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

	@When("User takes note of the renewal effective date from to tasks tab")
	public void user_takes_note_of_the_renewal_effective_date_from_to_the_tasks_tab_and_() throws Exception {
		selectTaskTab(driver);
		selectShowAll(driver);
		checkShowSysTask(driver);
		ManualRenewDt = getManualRenewDate(driver).toString();
	}

	@When("User changes system date to renewal date <mtr397>")
	public void user_changes_system_date_to_renewal_date_mtr397() throws Exception {
		ChangeAdminDate_NotInbox(driver, ManualRenewDt);
	}

	@When("User searches for the policy number <mtr397>")
	public void user_searches_policy_for_mtr397() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation Type as Insured <mtr397>")
	public void User_selects_cancellation_type_as_insured_mtr397() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User selects Property Sold in risk as reason <mtr397>")
	public void User_selects_property_sold_as_reason_mtr397() {
		selectDropdownText(historyChevron.ddReason, "Property Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects pro rate as cancel type and process transaction <mtr397>")
	public void User_selects_pro_rate_mtr397() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
	}
	@When("User clicks Policy File Chevron <mtr397>")
	public void user_clicks_policy_file_chevron_mtr397() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User validates Policy Status displayed as Cancelled")
	public void User_validates_Policy_Status_displayed_as_Cancelled() {
		click(historyChevron.btnHistoryChevron);
		wait(2);

		// Validate status as cancelled
		String policyStatus = driver.findElement(By.id("PolicySummary_TransactionStatus")).getText().toString();
		if (policyStatus.equalsIgnoreCase("Cancelled")) {
			Hooks.scenario.log("Policy Status displays Cancelled as expected.");
		} else {
			Hooks.scenario.log("Policy Status displays as Not cancelled. Test fails!");
		}
	}

	@And("User validates Cancellation Confirmation form listed and validates form")
	public void user_validates_Cancellation_Confirmation_form_listed_and_validates_form() throws Exception {
		clickOnAnyLink(driver, "Cancellation Confirmation");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancellationConfirmationForm = PdfComparator.makePdf(driver, "CancellationConfirmForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancellationConfirmationForm);
		wait(10);
		CCForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmationForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CCForm_Version, "AIIC CX 11 14");
		CCForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmationForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CCForm_Name, "CANCELLATION CONFIRMATION");
		CCForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmationForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CCForm_Text1,
				"In accordance with Florida Administrative Code 69O-167.001, return premium, if any, will be refunded to the");
		CCForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmationForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CCForm_Text2,
				"policyholder within 15 working days after the date this cancellation takes effect.");
	}

	@When("User changes system date to current date <mtr397>")
	public void user_changes_system_date_to_current_date_mtr397() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User selects endorsement date as current date <mtr397>")
	public void user_selects_endorsement_date_as_current_date_mtr397() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}

	@Then("User validates 'The current transaction is out of sequence. Processing it will unapply the prior transaction.' message displayed and completes test")
	public void user_validates_the_current_transaction_out_of_sequence_message_displayed_mtr397() throws Exception {
		verify_AnyText_IsVisible(driver,
				"The current transaction is out of sequence. Processing it will unapply the prior transaction.");
		Hooks.scenario.log("Test Case Completed!");
	}
}
