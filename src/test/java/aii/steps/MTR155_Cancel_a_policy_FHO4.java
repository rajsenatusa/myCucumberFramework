package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR155_Cancel_a_policy_FHO4 extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancelConfirmForm;
	static String CanConForm_Version;
	static String CancelForm_Name;
	static String CancelForm_Text1;
	static String CancelForm_Text2;
	
	@When("User enters all required information on policy information screen <mtr155>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr155() {

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
	@When("User enters all required information on HO4 quote screen with current date as prior policy date <mtr155>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr155() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, "No");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen <mtr155>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr155() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User takes note of the policy number for <mtr155>")
	public void user_takes_note_of_the_policy_number_for_mtr155() throws Exception {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for Policy Number for <mtr155>")
	public void user_searches_for_policy_number_for_mtr155() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects Cancellation Type as Non-Pay <mtr155>")
	public void User_selects_cancellation_type_as_NonPay_mtr155() {
		selectDropdownText(historyChevron.ddCancellationType, "Non-Pay");
		wait(2);
	}
	@And("User selects Non-Payment of Premium as reason <mtr155>")
	public void User_selects_property_nonpayment_as_reason_mtr155() {
		selectDropdownText(historyChevron.ddReason, "Non-Payment of Premium");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User sets eff date current date minus 1 day and validates error message <mtr155>")
	public void User_sets_eff_date_current_date_minus_1_day_selects_pro_rate_mtr155() throws Exception {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")),dtf.format(currentDate.minusDays(1)));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Date must be within the policy term");
		click(driver.findElement(By.id("Cancel")));
		wait(2);
	}
	@And("User selects pro rate as cancel type and process transaction <mtr155>")
	public void User_selects_prorate_and_process_transaction_mtr155() {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")),dtf.format(currentDate.plusDays(30)));
		clickTab(driver.findElement(By.id("CancelTypeCd")));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User validates Policy Status displayed as Cancelled <mtr155>")
	public void User_validates_Policy_Status_displayed_as_Cancelled_mtr155() {
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
	@When("User clicks Policy File Chevron <mtr155>")
	public void user_clicks_policy_file_chevron_mtr155() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User validates Cancellation Confirmation form listed and validates form <mtr155>")
	public void user_validates_Cancellation_Confirmation_form_listed_and_validates_form_mtr155() throws Exception {
		clickOnAnyLink(driver, "Cancellation Confirmation");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancelConfirmForm = PdfComparator.makePdf(driver, "CancellationConfirmForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancelConfirmForm);
		wait(10);
		CanConForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanConForm_Version, "AIIC CX 11 14");
		CancelForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CancelForm_Name, "CANCELLATION CONFIRMATION");
		CancelForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CancelForm_Text1,
				"Non-Payment of Premium");
		CancelForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CancelForm_Text2,
				"Reason(s) for Cancellation:");
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
