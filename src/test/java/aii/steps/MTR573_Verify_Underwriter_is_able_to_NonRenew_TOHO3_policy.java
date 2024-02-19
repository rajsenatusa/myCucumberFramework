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

public class MTR573_Verify_Underwriter_is_able_to_NonRenew_TOHO3_policy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NonRenewalNoticeForm;
	static String NonRenewalForm_Version;
	static String NonRenewalForm_Name;
	static String NonRenewalForm_Text1;
	static String NonRenewalForm_Text2;

	@When("User enters all required information on policy information screen <mtr573>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr573() {

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

	@When("User enters all required information on TOHO3 quote screen <mtr573>")
	public void User_enters_all_required_information_on_toho3_quote_screen_mtr573() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOHO3 dwelling screen <mtr573>")
	public void user_enters_all_required_information_on_toho3_welling_screen_mtr573() {

		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddStructureRentedOthers, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(driver.findElement(By.id("Building.AllPerilDed")), "$1,000");
		selectDropdownText(driver.findElement(By.id("Building.HurricaneDeductible")), "5%");
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@And("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr573>")
	public void user_validates_that_toho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_mtr573()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
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

	@When("User searches for the policy number <mtr573>")
	public void user_searches_policy_for_mtr573() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Material misrepresentation in obtaining the policy as Reason")
	public void user_selects_Material_misrep_in_obtaining_policy_as_reason() {
		selectDropdownText(historyChevron.ddReason, "Material misrepresentation in obtaining the policy.");
		click(historyChevron.btnAdd);
		wait(1);
		click(historyChevron.btnStart);
	}

	@And("User completes non renewal transaction <mtr573>")
	public void User_completes_nonrenewal_transaction_mtr573() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		Hooks.scenario.log("Policy Non Renewal Completed!");
		attachScreenShot(driver);
	}

	@And("User validates Policy Status displayed as Non Renewed <mtr573>")
	public void User_validates_Policy_Status_displayed_as_NonRenewed_mtr573() throws Exception {
		click(historyChevron.btnHistoryChevron);
		wait(2);

		// Validate status as Non Renewed
		clickSummary(driver);
		String policyStatus = driver.findElement(By.id("Full_PolicySummary_TransactionStatus")).getText().toString();
		if (policyStatus.equalsIgnoreCase("Non-Renewed")) {
			Hooks.scenario.log("Policy Status displays Non-Renewed as expected.");
		} else {
			Hooks.scenario.log("Policy Status displays as Not Non-Renewed. Test fails!");
		}
	}

	@When("User clicks Policy File Chevron <mtr573>")
	public void user_clicks_policy_file_chevron_mtr573() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User validates Non Renewal Notice form listed and validates form <mtr573>")
	public void user_validates_Non_Renewal_notice_form_listed_and_validates_form_mtr573() throws Exception {
		clickOnAnyLink(driver, "Non-Renewal Notice");
		wait(8);
		switchToWindow(driver, "STFile&File");
		NonRenewalNoticeForm = PdfComparator.makePdf(driver, "NonRenewalNoticeForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NonRenewalNoticeForm);
		wait(10);
		NonRenewalForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, NonRenewalForm_Version, "AIIC NRN 11 14");
		NonRenewalForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, NonRenewalForm_Name, "NON-RENEWAL NOTICE");
		NonRenewalForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, NonRenewalForm_Text1,
				"Material misrepresentation in obtaining the policy.");
		NonRenewalForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NonRenewalNoticeForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, NonRenewalForm_Text2, "Reason(s) for Cancellation:");
		

		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User changes system date to current date plus 1 day <mtr573>")
	public void user_changes_system_date_to_current_date_plus_1_day_mtr573() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate.plusDays(1)));
		wait(1);
	}
}
