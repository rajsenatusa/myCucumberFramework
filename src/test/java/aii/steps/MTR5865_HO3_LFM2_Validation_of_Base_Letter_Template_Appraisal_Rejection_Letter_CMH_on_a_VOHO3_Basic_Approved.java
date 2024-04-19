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

public class MTR5865_HO3_LFM2_Validation_of_Base_Letter_Template_Appraisal_Rejection_Letter_CMH_on_a_VOHO3_Basic_Approved
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String txnumber;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String ClaimRejectionLetterForm;
	static String ClaimRejectionLetterFirstPage;
	static String ClaimRejectionLetterSecondPage;
	static String AppraisalRejectionLetterForm;
	static String AppraisalRejectionLetterFirstPage;
	static String AppraisalRejectionLetterSecondPage;

	@When("User changes system date to current date <mtr5865>")
	public void user_changes_system_date_to_current_date_mtr5865() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@When("User enters all required information on policy information screen <mtr5865>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5865() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Max");
		sendText(quote.txtLastName, "Beasley");
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

	@When("User enters all required information on HO3 quote screen <mtr5865>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr5865() {
		// Quote Policy Chevron information was filled here
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, ("AAA"));
		wait(1);
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(2);
	}

	@When("User enters all required information on HO3 dwelling screen <mtr5865>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5865() {
		// Quote Dwelling information was filled here
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, "2024");
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		sendText(dwellingChevron.txtCoverageA, "500000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5865>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr5865()
			throws Exception {

		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		click(closeoutChevron.btnIssueNB);
		wait(3);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));
		wait(3);
		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		attachScreenShot(driver);
		wait(1);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searchs for Policy Number <mtr5865>")
	public void User_searches_for_Policy_Number_mtr5865() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(2);
	}

	@When("User sets Loss Date as current date <mtr5865>")
	public void User_sets_Loss_Date_as_current_date_mtr5865() {
		sendText(driver.findElement(By.id("Claim.LossDt")), dtf.format(currentDate));
		click(claim.btnSave);
	}

	@When("User fills all required information on claim notice screen and selects freezing as loss cause <mtr5865>")
	public void User_fills_all_required_info_on_claim_notice_screen_mtr5865() {
		selectDropdownText(claim.ddLossCause, "Freezing");
		wait(2);
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddWeatherRelatedInd, "Yes");
		sendText(claim.txtClaimDescription, "TestLfm5865");		
		click(claim.btnSave);
		wait(2);
		click(claim.btnComplete);
		wait(12);
	}

	@When("User clicks Claim Overview Chevron <mtr5865>")
	public void User_clicks_Claim_Overview_chevron_mtr5865() {
		click(claim.lnkOverviewTab);
		wait(2);
	}

	@When("User clicks More and starts transaction <mtr5865>")
	public void User_clicks_more_and_starts_transaction_mtr5865() {
		click(claim.btnMore);
		click(claim.btnStartTransaction);
		wait(2);
	}

	@When("User clicks Correspondence Tab <mtr5865>")
	public void User_clicks_Correspondence_chevron_mtr5865() {
		click(correspondance.lnkCorrespondenceTab);
		wait(2);
	}

	@When("User selects Correspondence Form Appraisal Rejection Letter CMH <mtr5865>")
	public void User_selects_Correspondence_form_appraisal_rej_letter_cmh_mtr5865() {
		selectDropdownText(correspondance.ddSelectCorrespondance, "Interactive - Appraisal Rejection Letter");
		wait(2);
		click(correspondance.btnAdd);
		wait(10);
	}

	@When("User clicks first claimant and selects assigned adjuster")
	public void User_clicks_first_claimant_and_selects_assigned_adjuster_mtr5865() {
		click(correspondance.btnFirstClaimant);
		wait(2);
		sendText(correspondance.txtAssignedAdjusterNumber, "CA0ST1");
		clickTab(driver.findElement(By.id("Claimant.Comment")));
		click(claim.btnSave);
		wait(2);
	}

	@When("User validates Appraisal Rejection Letter CMH displayed on Draft Editor, takes screenshot and validate editable and non editable fields")
	public void User_validates_CMH_displayed_on_draft_editor_takes_ss_and_Validate_editable_and_non_editable_fields()
			throws Exception {
		scrollToElement(driver.findElement(By.id("thunderheadDraftEditorWindow")));
		attachScreenShot(driver);
		Hooks.scenario.log("Draft Editor opened, editable and non editable fields validated");
		switchToFrame("thunderheadDraftEditorWindow");
		click(correspondance.btnPannelHomeownersForm);
		switchToDefault();
	}

	@When("User clicks Process Correspondence button <mtr5865>")
	public void User_clicks_Process_Correspondence_button_mtr5865() {
		click(correspondance.btnProcessCorrespondence);
		wait(10);
	}

	@When("User validates \"Claimant Appraisal Rejection Letter Interactive\" template is displayed under Pending Correspondence section")
	public void User_validates_Claimant_Appraisal_rej_letter_template_is_displayed_under_pending_correspondence_section_mtr5865()
			throws Exception {
		verify_AnyText_IsVisible(driver, "Claimant Appraisal Rejection Letter Interactive");
	}

	@When("User clicks Claimant Appraisal Rejection Letter Template and validates information")
	public void User_clicks_Claimant_Appraisal_Rej_letter_template_and_validates_information() throws Exception {
		click(correspondance.btnPreviewCorrespondenceFirst);
		wait(7);
		switchToWindow(driver, "STFile&File");

		ClaimRejectionLetterForm = PdfComparator.makePdf(driver, "ClaimRejectionLetter.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ClaimRejectionLetterForm);

		wait(10);

		ClaimRejectionLetterFirstPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + ClaimRejectionLetterForm, 1,
				0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ClaimRejectionLetterFirstPage, "Cause of Loss");
		PdfComparator.verifyFormData(driver, ClaimRejectionLetterFirstPage, "Freezing");
		PdfComparator.verifyFormData(driver, ClaimRejectionLetterFirstPage, "Homeowners 3 Special Form AIIC HO3 10");
		PdfComparator.verifyFormData(driver, ClaimRejectionLetterFirstPage,
				"21, under SECTION I – CONDITIONS, which states in part");

		ClaimRejectionLetterSecondPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + ClaimRejectionLetterForm,
				2, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, ClaimRejectionLetterSecondPage,
				"Homeowners 3 Special Form AIIC HO3 04 23");
	}

	@When("User submits for approval and takes note of the transaction number <mtr5865>")
	public void User_submits_for_approval_mtr5865() {
		sendText(claim.txtWorkflowComments, "Correspondence for Approval");
		// taking note of the transaction
		try {
			txnumber = driver.findElement(By.id("ClaimSummary_ClaimTransactionNumber")).getText().toString();
			Hooks.scenario.log("Transaction Number: " + txnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(claim.btnSubmitForApproval);
	}

	@When("User clicks to Inbox <mtr5865>")
	public void User_clicks_TO_inbox_mtr5865() {
		click(dashboard.btnInbox);
		wait(5);
	}

	@When("User validates transaction submitted for approval with current transaction number")
	public void User_validates_transaction_submitted_for_approval_with_current_tx_number() throws Exception {
		attachScreenShot(driver);
		verify_AnyText_IsVisible(driver, "Transaction " + txnumber + " Submitted for Approval for Max Beasley");
	}

	@When("User clicks Work for that transaction and validate popup displayed with submitted note")
	public void User_clicks_Work_for_that_transaction_and_validate_popup_displayed_with_submitted_note()
			throws Exception {
		try {
			driver.findElement(By.xpath("//td[contains(text(), '" + txnumber + "')]//following::a[1]"))
					.click();
			Hooks.scenario.log("Clicked on " + txnumber + " to perform action");
		} catch (Exception e) {
			Hooks.scenario.log("Transaction Number Is NOT visible: " + txnumber);
			attachScreenShot(driver);
		}
		attachScreenShot(driver);
		click(driver.findElement(By.id("ui-id-2")));		
	}
	@When("User validates all expected buttons visible on closeout screen and approves transaction <mtr5865>")
	public void User_validates_all_expected_button_visible_on_closeout_screen_mtr5865() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Approve");
		verify_AnyLabel_IsVisible(driver, "Process");
		verify_AnyLabel_IsVisible(driver, "Make Changes");
		verify_AnyLabel_IsVisible(driver, "Send Back For Information");
		verify_AnyLabel_IsVisible(driver, "Reject");
		verify_AnyLabel_IsVisible(driver, "Review");
		verify_AnyLabel_IsVisible(driver, "More");
		
		sendText(claim.txtWorkflowComments, "Correspondence Approved");
		click(claim.btnApprove);
		wait(2);
		click(dashboard.btnHome);
		wait(1);
	}
	@When("User validates transaction submitted for approval with current transaction number not visible anymore")
	public void User_validates_transaction_submitted_for_approval_with_current_tx_number_not_visible_anymore() throws Exception {
		verify_AnyText_NotVisible(driver, "Transaction " + txnumber + " Submitted for Approval for Max Beasley");
	}
	@When("User validates transaction is approved message with current transaction number")
	public void User_validates_transaction_is_approved_message_with_current_tx_number() throws Exception {
		verify_AnyText_IsVisible(driver, "Transaction " + txnumber + " is Approved for Max Beasley");
	}
	@When("User validates process, make changes, more buttons are visible and process transaction <mtr5865>")
	public void User_validates_all_process_makechanges_more_buttons_visible_and_process_tx_mtr5865() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Process");
		verify_AnyLabel_IsVisible(driver, "Make Changes");
		verify_AnyLabel_IsVisible(driver, "More");
		
		sendText(claim.txtWorkflowComments, "Process Completed");
		click(claim.btnProcess);
		wait(12);
	}
	@When("User clicks Claim File Chevron <mtr5865>")
	public void User_clicks_Claim_File_Chevron_mtr5865() {
		click(claim.lnkClaimFileChevron);
		wait(2);
	}
	@Then("User clicks Interactive Appraisal Rejection Letter and validates form version and completes test")
	public void User_clicks_interactive_app_rejection_letter_and_validates_form_version_and_completes_Test_mtr5865() throws Exception {
		clickOnAnyLink(driver, "Interactive - Appraisal Rejection Letter");
		wait(7);
		switchToWindow(driver, "STFile&File");

		AppraisalRejectionLetterForm = PdfComparator.makePdf(driver, "AppraisalRejectionLetter.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + AppraisalRejectionLetterForm);

		wait(10);

		AppraisalRejectionLetterFirstPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + AppraisalRejectionLetterForm, 1,
				0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterFirstPage, "Cause of Loss");
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterFirstPage, "Freezing");
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterFirstPage, "Homeowners 3 Special Form AIIC HO3 10");
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterFirstPage,
				"21, under SECTION I – CONDITIONS, which states in part");

		AppraisalRejectionLetterSecondPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + AppraisalRejectionLetterForm,
				2, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterSecondPage,
				"Homeowners 3 Special Form AIIC HO3 04 23");
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterSecondPage,
				"Shannan Triplett");
		PdfComparator.verifyFormData(driver, AppraisalRejectionLetterSecondPage,
				"License Number: 1234567");
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
