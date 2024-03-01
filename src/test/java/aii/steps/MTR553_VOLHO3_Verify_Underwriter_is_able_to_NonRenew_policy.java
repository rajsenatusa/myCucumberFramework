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

public class MTR553_VOLHO3_Verify_Underwriter_is_able_to_NonRenew_policy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NonRenewalNoticeForm;
	static String NonRenewalForm_Version;
	static String NonRenewalForm_Name;
	static String NonRenewalForm_Text1;
	static String NonRenewalForm_Text2;

	
	
	
	@When("User enters product selection information for VOLHO3 and sets effective date as current date")
	public void user_enters_product_selection_information_for_toho3_and_sets_effective_date_as_current_date() {

		// login with admin for issuing VOL policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	
	@When("User enters all required information on policy information screen <mtr553>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr553() {

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


	@When("User enters all required information on HO3 dwelling screen <mtr553>")
	public void user_enters_all_required_information_on_ho3_welling_screen_mtr553() {

		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);

	}
	@When("User enters all required information on HO3 quote screen <mtr553>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr553() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-342-4532");
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
	@When("User completes required information on dwelling chevron <mtr553>")
	public void user_completes_required_information_on_dwelling_chevron_mtr553() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtYearElectrical, "2023");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr553>")
	public void User_clicks_Finalize_button_mtr553() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr553>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr553()
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
	
//
//	@And("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr573>")
//	public void user_validates_that_toho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_mtr573()
//			throws Exception {
//		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));
//
//		if (validate.getText().equalsIgnoreCase("Renewal")) {
//			System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
//		} else {
//			System.out.println("Test failed!");
//		}
//		closeUnnecessaryTabs();
//		getPolicyNumber(driver);
//		getInForcePremium(driver);
//		getInForcePremiumFees(driver);
//
//		// taking note of the issued policy
//		try {
//			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
//			Hooks.scenario.log("Policy Number: " + policyNum);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@When("User searches for the policy number <mtr573>")
//	public void user_searches_policy_for_mtr573() {
//		sendText(dashboard.txtSearchBar, policyNum);
//		click(dashboard.search);
//		wait(3);
//	}
//
//	@And("User selects Material misrepresentation in obtaining the policy as Reason")
//	public void user_selects_Material_misrep_in_obtaining_policy_as_reason() {
//		selectDropdownText(historyChevron.ddReason, "Material misrepresentation in obtaining the policy.");
//		click(historyChevron.btnAdd);
//		wait(1);
//		click(historyChevron.btnStart);
//	}
//
//	@And("User completes non renewal transaction <mtr573>")
//	public void User_completes_nonrenewal_transaction_mtr573() throws Exception {
//		click(closeoutChevron.btnIssueNB);
//		wait(5);
//		Hooks.scenario.log("Policy Non Renewal Completed!");
//		attachScreenShot(driver);
//	}
//
//	@And("User validates Policy Status displayed as Non Renewed <mtr573>")
//	public void User_validates_Policy_Status_displayed_as_NonRenewed_mtr573() throws Exception {
//		click(historyChevron.btnHistoryChevron);
//		wait(2);
//
//		// Validate status as Non Renewed
//		clickSummary(driver);
//		String policyStatus = driver.findElement(By.id("Full_PolicySummary_TransactionStatus")).getText().toString();
//		if (policyStatus.equalsIgnoreCase("Non-Renewed")) {
//			Hooks.scenario.log("Policy Status displays Non-Renewed as expected.");
//		} else {
//			Hooks.scenario.log("Policy Status displays as Not Non-Renewed. Test fails!");
//		}
//	}
//
//	@When("User clicks Policy File Chevron <mtr573>")
//	public void user_clicks_policy_file_chevron_mtr573() throws Exception {
//		wait(2);
//		click(policyFileChevron.btnPolicyFilePage);
//		wait(5);
//	}
//
//	@Then("User validates Non Renewal Notice form listed and validates form <mtr573>")
//	public void user_validates_Non_Renewal_notice_form_listed_and_validates_form_mtr573() throws Exception {
//		clickOnAnyLink(driver, "Non-Renewal Notice");
//		wait(8);
//		switchToWindow(driver, "STFile&File");
//		NonRenewalNoticeForm = PdfComparator.makePdf(driver, "NonRenewalNoticeForm.pdf");
//		wait(4);
//
//		// Save the pdf in local driver
//		PdfComparator.SavePdfForm(driver, FileLocation + NonRenewalNoticeForm);
//		wait(10);
//		NonRenewalForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
//				800);
//		PdfComparator.verifyFormData(driver, NonRenewalForm_Version, "AIIC NRN 11 14");
//		NonRenewalForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
//				800);
//		PdfComparator.verifyFormData(driver, NonRenewalForm_Name, "NON-RENEWAL NOTICE");
//		NonRenewalForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
//				800);
//		PdfComparator.verifyFormData(driver, NonRenewalForm_Text1,
//				"Material misrepresentation in obtaining the policy.");
//		NonRenewalForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
//				800);
//		PdfComparator.verifyFormData(driver, NonRenewalForm_Text2, "Reason(s) for Cancellation:");
//		
//
//		Hooks.scenario.log("Test Case Completed!");
//	}
//	@When("User changes system date to current date plus 1 day <mtr573>")
//	public void user_changes_system_date_to_current_date_plus_1_day_mtr573() throws Exception {
//		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
//		wait(1);
//	}
	
}
