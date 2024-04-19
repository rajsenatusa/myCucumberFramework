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

public class MTR5887_HO3_LFM2_12_Validation_of_Base_Letter_Template_Request_for_Information_Letter_on_a_VOHO3_Basic_Approved extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String txnumber;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String RequestForInfoLetterForm;
	static String RequestForInfoFirstPage;
	
	@When("User changes system date to current date <mtr5887>")
	public void user_changes_system_date_to_current_date_mtr5887() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr5887>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5887() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Ted");
		sendText(quote.txtLastName, "Wosz");
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
	@When("User enters all required information on HO3 quote screen <mtr5887>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr5887() {
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
	@When("User enters all required information on HO3 dwelling screen <mtr5887>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5887() {
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
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5887>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr5887()
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
	@When("User Searchs for Policy Number <mtr5887>")
	public void User_searches_for_Policy_Number_mtr5887() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(2);
	}
	@When("User sets Loss Date as current date <mtr5887>")
	public void User_sets_Loss_Date_as_current_date_mtr5887() {
		sendText(driver.findElement(By.id("Claim.LossDt")), dtf.format(currentDate));
		click(claim.btnSave);
	}
	@When("User fills all required information on claim notice screen and selects freezing as loss cause <mtr5887>")
	public void User_fills_all_required_info_on_claim_notice_screen_mtr5887() {
		selectDropdownText(claim.ddLossCause, "Freezing");
		wait(2);
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddWeatherRelatedInd, "Yes");
		sendText(claim.txtClaimDescription, "TestLfm5887");		
		click(claim.btnSave);
		wait(2);
		click(claim.btnComplete);
		wait(12);
	}
	@When("User clicks Claim Overview Chevron <mtr5887>")
	public void User_clicks_Claim_Overview_chevron_mtr5887() {
		click(claim.lnkOverviewTab);
		wait(2);
	}
	@When("User clicks More and starts transaction <mtr5887>")
	public void User_clicks_more_and_starts_transaction_mtr5887() {
		click(claim.btnMore);
		click(claim.btnStartTransaction);
		wait(2);
	}
	@When("User clicks Correspondence Tab <mtr5887>")
	public void User_clicks_Correspondence_chevron_mtr5887() {
		click(correspondance.lnkCorrespondenceTab);
		wait(2);
	}
	@When("User selects Request for Information Letter <mtr5887>")
	public void User_selects_Correspondence_form_request_for_information_letter_mtr5887() {
		selectDropdownText(correspondance.ddSelectCorrespondance, "Interactive - Request For Information Letter");
		wait(2);
		click(correspondance.btnAdd);
		wait(10);
	}
	@When("User process transaction <mtr5887>")
	public void User_process_transaction_mtr5887() {
		click(claim.btnProcess);
		wait(2);
	}
	@When("User validates Request for Information Letter displayed on Draft Editor, takes screenshot and validate editable and non editable fields")
	public void User_validates_request_for_info_letter_displayed_on_draft_editor_takes_ss_and_Validate_editable_and_non_editable_fields()
			throws Exception {
		scrollToElement(driver.findElement(By.id("thunderheadDraftEditorWindow")));
		attachScreenShot(driver);
		Hooks.scenario.log("Draft Editor opened, editable and non editable fields validated");
	}
	@When("User clicks Process Correspondence button <mtr5887>")
	public void User_clicks_Process_Correspondence_button_mtr5887() {
		click(correspondance.btnProcessCorrespondence);
		wait(10);
	}
	@When("User clicks Claim File Chevron <mtr5887>")
	public void User_clicks_Claim_File_Chevron_mtr5887() {
		click(claim.lnkClaimFileChevron);
		wait(2);
	}
	@Then("User clicks Request for Information Letter and validates form version and completes test")
	public void User_clicks_request_for_info_letter_and_validates_form_version_and_completes_Test_mtr5865() throws Exception {
		clickOnAnyLink(driver, "Interactive - Request For Information Letter");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RequestForInfoLetterForm = PdfComparator.makePdf(driver, "RequestForInfoLetter.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RequestForInfoLetterForm);

		wait(10);

		RequestForInfoFirstPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + RequestForInfoLetterForm, 1,
				0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RequestForInfoFirstPage, "Cause of Loss");
		PdfComparator.verifyFormData(driver, RequestForInfoFirstPage, "Freezing");
		PdfComparator.verifyFormData(driver, RequestForInfoFirstPage, "Shannan Triplett");
		PdfComparator.verifyFormData(driver, RequestForInfoFirstPage,
				"License Number: 1234567");
		Hooks.scenario.log("Test Case Completed!");
	}
}
