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

public class MTR159_Cancel_a_takeout_policy_FHO3 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancelConfirmationForm;
	static String CancelConfirmForm_Version;
	static String CancellationForm_Name;
	static String CancellationForm_Text1;
	static String CancellationForm_Text2;

	@When("User enters all required information on policy information screen <mtr159>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr159() {

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

	@When("User enters all required information on TOHO3 quote screen <mtr159>")
	public void User_enters_all_required_information_on_toho3_quote_screen_mtr159() {

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

	@When("User enters all required information on TOHO3 dwelling screen <mtr159>")
	public void user_enters_all_required_information_on_toho3_welling_screen_mtr159() {

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

	@And("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr159>")
	public void user_validates_that_toho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_mtr159()
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

	@When("User searches for the policy number <mtr159>")
	public void user_searches_policy_for_mtr159() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation Type as Company <mtr159>")
	public void User_selects_cancellation_type_as_Company_mtr159() {
		selectDropdownText(historyChevron.ddCancellationType, "Company");
		wait(2);
	}

	@And("User selects Material misrepresentation in obtaining the policy as reason <mtr159>")
	public void User_selects_material_misrepresentation_as_reason_mtr159() {
		selectDropdownText(historyChevron.ddReason, "Material misrepresentation in obtaining the policy.");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User sets eff date current date minus 1 day and validates error message <mtr159>")
	public void User_sets_eff_date_current_date_minus_1_day_selects_pro_rate_mtr159() throws Exception {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.minusDays(1)));
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

	@And("User selects pro rate as cancel type and process transaction <mtr159>")
	public void User_selects_prorate_and_process_transaction_mtr159() {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		clickTab(driver.findElement(By.id("CancelTypeCd")));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
	}

	@And("User validates Policy Status displayed as Cancelled <mtr159>")
	public void User_validates_Policy_Status_displayed_as_Cancelled_mtr159() {
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

	@When("User clicks Policy File Chevron <mtr159>")
	public void user_clicks_policy_file_chevron_mtr159() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User validates Cancellation Confirmation form listed and validates form <mtr159>")
	public void user_validates_Cancellation_Confirmation_form_listed_and_validates_form_mtr159() throws Exception {
		clickOnAnyLink(driver, "Cancellation Confirmation");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancelConfirmationForm = PdfComparator.makePdf(driver, "CancellationConfirmationForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancelConfirmationForm);
		wait(10);
		CancelConfirmForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmationForm, 1, 0, 0,
				800, 800);
		PdfComparator.verifyFormData(driver, CancelConfirmForm_Version, "AIIC CX 11 14");
		CancellationForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmationForm, 1, 0, 0,
				800, 800);
		PdfComparator.verifyFormData(driver, CancellationForm_Name, "CANCELLATION CONFIRMATION");
		CancellationForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmationForm, 1, 0, 0,
				800, 800);
		PdfComparator.verifyFormData(driver, CancellationForm_Text1,
				"Material misrepresentation in obtaining the policy.");
		CancellationForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancelConfirmationForm, 1, 0, 0,
				800, 800);
		PdfComparator.verifyFormData(driver, CancellationForm_Text2, "Reason(s) for Cancellation:");

		Hooks.scenario.log("Test Case Completed!");
	}
}
