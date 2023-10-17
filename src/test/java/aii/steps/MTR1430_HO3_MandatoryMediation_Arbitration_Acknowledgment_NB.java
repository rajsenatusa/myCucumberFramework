package aii.steps;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR1430_HO3_MandatoryMediation_Arbitration_Acknowledgment_NB extends CommonMethods{

	static DateTimeFormatter effDate = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();		
	static int TdYear = Year.now().getValue();
	static String policyNum;
	static String refer;
	static String status;
	static String workdate;
	static String MMA_Acknowledment_Form;
	
	@When("User enters all required information on policy information screen <mtr1430>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1430() {

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
	@When("User enters all required information on HO3 quote screen <mtr1430>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr1430() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, effDate.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		sendText(policyChevron.txtPreviousPolicyExpDate, effDate.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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
	@When("User enters all required information on HO3 dwelling screen <mtr1430>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr1430() {
		// Quote Dwelling information was filled here
		// sendText(dwellingChevron.txtYearConstruction, "2002");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10 mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtRoofMaterialUpdate, Integer.toString(TdYear));
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	
	@When("User completes required information on dwelling chevron <mtr1430>")
	public void user_completes_required_information_on_dwelling_chevron_mtr1430() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User finalizes transaction for VOL HO3 <mtr1430>")
	public void user_finalizes_transaction_for_VOL_HO3_mtr1430() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr1430>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr1430()
			throws Exception {

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
	@When("User changes system date to current date <mtr1430>")
	public void user_changes_system_date_to_current_date_mtr1430() throws Exception {
		ChangeAdminDate_NotInbox(driver, effDate.format(currentDate));
	}
	@When("User searches for the policy number <mtr1430>")
	public void user_searches_policy_for_mtr401() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User sets new effective date as current date and starts endorsement <mtr1430>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr1430() {
		sendText(historyChevron.txtEffectiveDate, effDate.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User clicks Dwelling Chevron <mtr1430>")
	public void user_clicks_dwelling_chevron_mtr1430() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User validates MMA defaulted to Yes")
	public void user_validates_mma_defaulted_to_yes() throws Exception {
		verifyAnyDropdownDefaultedValue(driver,"Building.MediationArbitrationInd","Yes");
	}
	@When("User clicks Attachments Tab")
	public void user_clicks_attachments_tab() throws Exception {
		click(attachmentsChevron.lnkAttachmentsTab);
		wait(2);
	}
	@When("User clicks Add Attachment button")
	public void user_clicks_add_attachment_button() throws Exception {
		click(attachmentsChevron.btnAddAttachmentTemp);
		wait(2);
	}
	@When("User select MMA Acknowledgement form from the dropdown")
	public void user_select_MMA_Acknowledgement_form_from_the_dropdown() throws Exception {
		selectDropdownText(attachmentsChevron.ddAttachmentName, "Mandatory Mediation-Arbitration Acknowledgment");
		click(attachmentsChevron.btnSelect);
		wait(2);
	}
	@When("User clicks select files to upload and imports test data pdf file")
	public void user_clicks_select_files_to_upload_and_imports_test_data_pdf_file() throws Exception {
		click(attachmentsChevron.btnAddFiles);
		addSamplePDF(driver);
		wait(2);
	}
	@When("User validates 'View' 'Edit' 'Move' 'Copy' 'Detail' 'Delete' labels are visible")
	public void user_validates_labels_are_visible() throws Exception {
		verify_AnyLink_IsVisible(driver, "View");
		verify_AnyLink_IsVisible(driver, "Edit");	
		verify_AnyLink_IsVisible(driver, "Move");
		verify_AnyLink_IsVisible(driver, "Copy");
		verify_AnyLink_IsVisible(driver, "Detail");// Validating partial part of View Detail
		verify_AnyLink_IsVisible(driver, "Delete");
		wait(3);
	}
	@When("User clicks plus sign and validates testing.pdf is visible")
	public void user_clicks_plus_sign_and_validates_testingpdf_is_visible() throws Exception {
		clickonAnyExpandButton(driver, "Signed Mandatory Mediation");
		wait(1);
		verify_AnyLabel_IsVisible(driver, "TestingPDF.pdf");
	}
	@When("User validates links are clickable")
	public void user_validates_links_are_clickable() throws Exception {
		clickOnAnyLink(driver, "Edit");
		wait(3);
		clickonAnyButton(driver, "Cancel");
		
		clickOnAnyLink(driver, "Move");
		wait(3);
		clickonAnyButton(driver, "Cancel");
		
		clickOnAnyLink(driver, "Copy");
		wait(3);
		clickonAnyButton(driver, "Cancel");
		
		clickOnAnyLink(driver, "View Detail");
		wait(3);
	}
	@When("User clicks Policy File Chevron <mtr1430>")
	public void user_clicks_policy_file_chevron_mtr1430() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@And("User clicks Finalize button and Endorses Policy <mtr1430>")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr1430_() throws Exception {	  
		clickApplicationTab(driver);
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();	 
		wait(10);	
		closeUnnecessaryTabs();
	}
	@When("User gets task referring status, arbitration task status, arbitration task workdate and do validations")
	public void user_gets_task_referring_status_and_do_validations() throws Exception {
		refer = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration Acknowledgment");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer);
		status = getArbitrationTaskStatus(driver, "Mandatory Mediation-Arbitration Acknowledgment");
		expectedValue_foundValue(driver, "Open", status);
		workdate = getArbitrationTaskWorkDate(driver, "Mandatory Mediation-Arbitration Acknowledgment");
		expectedValue_foundValue(driver, effDate.format(currentDate), workdate);
	}
	@When("User validates 'Mandatory Mediation-Arbitration Acknowledgment' text is visible")
	public void user_validates_Mandatory_Mediation_Arbitration_Acknowledgment_text_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration Acknowledgment");
	}
	@When("User clicks 'Mandatory Mediation-Arbitration Acknowledgment' link and takes screenshot")
	public void user_clicks_Mandatory_Mediation_Arbitration_Acknowledgment_link_and_takes_screenshot() throws Exception {
		wait(6);
		switchToWindow(driver, "COAttachmentAnnotateFullPage");
		attachScreenShot(driver);
		driver.switchTo().window(mainWindow);
	}
	@When("User clicks Edit")
	public void user_clicks_edit() throws Exception {
		clickOnAnyLink(driver, "Edit");
	}
	@When("User edits description task")
	public void user_edits_description_task() throws Exception {
		editDescriptionTask(driver, "Mandatory Mediation-Arbitration Acknowledgment-Updated");
		clickonAnyButton(driver, "SaveAttachment");
		Thread.sleep(3000);
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration Acknowledgment-Updated");
	}
	@When("User clicks delete and validates 'Mandatory Mediation-Arbitration Acknowledgment-Updated' text is not visible and completes test")
	public void user_clicks_delete_and_validates_text_is_not_visible_and_completes_test() throws Exception {
		clickOnAnyLink(driver, "Delete");
		Thread.sleep(3000);
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
		verify_AnyText_NotVisible(driver, "Mandatory Mediation-Arbitration Acknowledgment-Updated");
		Hooks.scenario.log("Test Case Completed!");
	}
}
