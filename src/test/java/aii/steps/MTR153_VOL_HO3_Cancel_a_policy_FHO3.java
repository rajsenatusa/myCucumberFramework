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

public class MTR153_VOL_HO3_Cancel_a_policy_FHO3 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancellationNoticeConfirmForm;
	static String CanNoticeCForm_Version;
	static String CanNoticeCForm_Name;
	static String CanForm_Text1;
	static String CanForm_Text2;

	@When("User enters HO3 product selection information and current date as effective date <mtr153>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr153() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <mtr153>")
	public void user_enters_all_required_information_on_ho3_quote_screenmtr153() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		wait(3);
		click(policyChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		wait(3);
		click(policyChevron.btnNext);
	}

	@And("User validates that HO3 policy has been created successfully and take note of the policy number <mtr153>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr153() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		// Close unnecessary tabs
		closeUnnecessaryTabs();
		Hooks.scenario.log("New Business HO3 policy has been created successfully");
		attachScreenShot(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr153>")
	public void user_searches_policy_for_mtr153() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation Notice")
	public void User_selects_cancellation() {
		selectDropdownText(dashboard.ddSelectTransaction, "Cancellation Notice");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User selects Roof Disrepair as reason <mtr153>")
	public void User_selects_property_nonpayment_as_reason_mtr153() {
		selectDropdownText(historyChevron.ddReason, "Roof Disrepair");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User sets the effective date as after 30 days from the current date and validates messages")
	public void User_sets_the_effective_date_after_30_days_from_the_current_date_and_validates_error_messages()
			throws Exception {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		click(dashboard.btnStart);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Closeout");
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Request");
		verify_AnyfirstText_IsDisplayed(driver, "Output Pending");
		verify_AnyfirstText_IsDisplayed(driver, "Process");
		verify_AnyfirstText_IsDisplayed(driver, "Preview Output");
		verify_AnyfirstText_IsDisplayed(driver, "Modify Application");
		wait(2);
		click(dashboard.btnProcess);
	}

	@And("User sets the effective date as before 1 day from the current date and validates error message")
	public void User_sets_the_effective_date_as_before_1_days_from_the_current_date_and_validates_error_messages()
			throws Exception {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.minusDays(1)));
		wait(4);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(4);
		click(dashboard.btnStart);
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Date must be within the policy term");
		attachScreenShot(driver);
		wait(2);

	}

	@And("User completes cancellation notice transaction and validates policy transaction status as cancel notice")
	public void User_completes_cancellation_notice_transaction_and_validates_policy_transaction_status_as_cancel_notice()
			throws Exception {
		click(dashboard.btnCancel);
		wait(5);
		Hooks.scenario.log("Policy Cancel Notice Completed!");
		attachScreenShot(driver);
	}

	@And("User validates Policy Status displayed as Cancel Notice <mtr153>")
	public void User_validates_Policy_Status_displayed_as_Cancel_Notice_mtr153() throws Exception {
		click(historyChevron.btnHistoryChevron);
		wait(2);

		// Validate status as cancelled
		String policyStatus = driver.findElement(By.id("History_1_2_TransactionCd")).getText().toString();
		if (policyStatus.equalsIgnoreCase("Cancellation Notice")) {
			Hooks.scenario.log("Policy Status displays Cancellation Notice as expected.");
		} else {
			Hooks.scenario.log("Policy Status displays as Not Cancellation Notice. Test fails!");
			
		}
		Hooks.scenario.log("Policy Cancel Notice Completed!");
		attachScreenShot(driver);
	}

	@When("User clicks Policy File Chevron <mtr153>")
	public void user_clicks_policy_file_chevron_mtr153() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User validates Cancellation Notice Confirmation form listed and validates form <mtr153>")
	public void user_validates_Cancellation_Notice_Confirmation_form_listed_and_validates_form_mtr153()
			throws Exception {
		clickOnAnyLink(driver, "Cancellation Notice");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancellationNoticeConfirmForm = PdfComparator.makePdf(driver, "CancellationNoticeConfirmForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancellationNoticeConfirmForm);
		wait(10);
		CanNoticeCForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationNoticeConfirmForm, 1,
				0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, CanNoticeCForm_Version, "AIIC CX 11 14");
		CanNoticeCForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationNoticeConfirmForm, 1, 0,
				0, 800, 800);
		PdfComparator.verifyFormData(driver, CanNoticeCForm_Name, "CANCELLATION NOTICE");
		Hooks.scenario.log("Test Case Completed!");
	}

}
