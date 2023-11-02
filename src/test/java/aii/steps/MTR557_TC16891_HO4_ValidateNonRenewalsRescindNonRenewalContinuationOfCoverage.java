package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR557_TC16891_HO4_ValidateNonRenewalsRescindNonRenewalContinuationOfCoverage extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime expDate = currentDate.plusYears(1);
	static LocalDateTime nonRenDate1 = expDate.minusDays(125);
	static LocalDateTime nonRenDate2 = expDate.minusDays(124);
	static String policyNum;
	String Con_Coverage_Form;
	String Con_Coverage_Form_Version;
	String Con_Coverage_Data;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters HO4 product selection information and effective date as current date")
	public void user_enters_ho4_product_selection_information_and_effective_date_as_current_date() {
		// product selection information was filled here

		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}

	@When("User enters all required information on HO4 quote screen with current date as prior policy date")
	public void user_enters_all_required_information_on_ho4_quote_screen() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypeho4"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User takes note of the policy number for <mtr557>")
	public void user_takes_note_of_the_policy_number_for_mtr557() throws Exception {
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Admin Tab and does change date transaction to exp.date minus <125> days")
	public void user_clicks_admin_tab_and_does_change_date_transaction_exp_date_minus_125_days() throws Exception {
		click(dashboard.btnAdmin);
		click(dashboard.btnChangeDate);
		wait(1);
		setNewDate(driver, dtf.format(nonRenDate1));
		click(dashboard.btnChangeNewDate);
		setBookDate(driver, dtf.format(nonRenDate1));
		click(dashboard.btnChangeBookDate);
	}

	@When("User searches for Policy Number for <mtr557>")
	public void user_searches_for_policy_number_for_mtr557() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User clicks Non-Renewal Transaction Selection")
	public void User_clicks_non_renewal_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Non-Renewal");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User selects 'Failure to comply with underwriting requirements' as reason")
	public void User_selects_reason() {
		selectDropdownText(historyChevron.ddReason, "Failure to comply with underwriting requirements");
		wait(1);
		selectDropdownText(historyChevron.ddSubReason,
				"Additional information required for underwriting review not provided");
		click(historyChevron.btnAdd);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User process transaction and clicks plus sign and validates UW reason message has been displayed")
	public void User_process_transaction_and_validates() throws Exception {
		click(reviewChevron.btnProcess);
		wait(5);
		click(historyChevron.btnExpand);
		verify_AnyText_IsVisible(driver,
				"Failure to comply with underwriting requirements;  additional information required for underwriting review not provided.");
	}

	@And("User clicks Non-Renewal Rescind Transaction Selection")
	public void User_clicks_non_renewal_rescind_Transaction_Selection() {
		selectDropdownText(dashboard.ddSelectTransaction, "Non-Renewal Rescind");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User validates 'Failure to comply with underwriting requirements;  additional information required for underwriting review not provided.' message has been displayed")
	public void User_validates_uw_reason_msg_displayed() throws Exception {
		verify_AnyText_IsVisible(driver,
				"Failure to comply with underwriting requirements;  additional information required for underwriting review not provided.");
	}

	@And("User clicks Start and process transaction")
	public void User_clicks_start_and_process_transaction() {
		click(historyChevron.btnStart);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(8);
		closeUnnecessaryTabs();
	}

	@And("User clicks Expand Button for Rescission of Non-Renewal Notice")
	public void User_clicks_expand_button_for_rescission_non_renewal() throws Exception {
		click(policyFileChevron.btnExpand);
		verifyInstallmentInvoiceForm(driver, "Rescission of Non-Renewal Notice");
		switchWindows(driver);
	}

	@And("User clicks 'Rescission of Non-Renewal Notice' form")
	public void User_clicks_rescission_of_rn_notice_form() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Rescission of Non-Renewal Notice");
		wait(7);
	}

	@And("User switches the form, saves form and does comparision with expected texts")
	public void User_switches_the_form_and_does_validations() throws Exception {
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Con_Coverage_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Con_Coverage");
		PdfComparator.SavePdfForm(driver, FileLocation + Con_Coverage_Form);
		Thread.sleep(500);
		Con_Coverage_Form_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Con_Coverage_Form, 1, 450, 720,
				100, 50);
		PdfComparator.verifyFormData(driver, Con_Coverage_Form_Version, "AIIC REC 11 14");

		Con_Coverage_Data = PdfComparator.getPDFData(FileLocation + Con_Coverage_Form);

		// Find the required text in a pdf
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "AIIC REC 11 14");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, dtf.format(expDate));
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data,
				"Your policy will continue without interruption of coverage since underwriting reason(s) met prior to the");

	}

	@When("User clicks Admin Tab and does change date transaction to exp.date minus <124> days")
	public void user_clicks_admin_tab_and_does_change_date_transaction_exp_date_minus_124_days() throws Exception {
		click(dashboard.btnAdmin);
		click(dashboard.btnChangeDate);
		wait(1);
		setNewDate(driver, dtf.format(nonRenDate2));
		click(dashboard.btnChangeNewDate);
		setBookDate(driver, dtf.format(nonRenDate2));
		click(dashboard.btnChangeBookDate);
	}

	@When("User validates 'Transaction must occur within the allowed Non-Renewal Request date range' label has been displayed")
	public void user_validates_label_has_been_displayed() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Transaction must occur within the allowed Non-Renewal Request date range");
	}

}
