package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR1010_TOHO3_Verify_Declaration_AIIC_02_HO3_DEC0423_is_updated_on_Renewal extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime issueDate = currentDate.minusYears(1);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;
	static String renewalTerm1;
	static String RenewalDeclaration_Form;
	static String RNDec_Page;
	static String RNDec_Page2;
	static String RNDec_Page3;
	static String RNDec_Page4;
	static String RNDec_Page5;
	static String RNDec_PageSignature;
	static String RNDec_AdditionalInterest;
	static String RenewalDeclaration_Form2;
	static String RNDec2_Page;
	static String RNDec2_Page2;
	static String RNDec2_Page3;
	static String RNDec2_Page4;
	static String RNDec2_Page5;

	@When("User enters all required information on policy information screen <mtr1010>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1010() {

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
	@When("User enters TOHO3 product selection information and effective date as current date minus 1 year")
	public void user_enters_toho3_product_selection_information_and_effective_date_as_current_date_minus_1_year() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(issueDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionToho3);
	}
	@When("User enters all required information on TOHO3 quote screen <mtr1010>")
	public void User_enters_all_required_information_on_toho3_quote_screen_mtr1010() {

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
	@When("User enters all required information on TOHO3 dwelling screen <mtr1010>")
	public void user_enters_all_required_information_on_toho3_welling_screen_mtr1010() {

		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2021");
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
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@And("User completes required information on add additional interests screen and add additional insured <mtr1010>")
	public void User_completes_required_information_on_add_additional_interests_screen_mtr1010() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10006");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Interest");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Additional Interest");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@And("User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr1010>")
	public void user_validates_that_toho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_mtr1010()
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
	@When("User searches for the policy number <mtr1010>")
	public void user_searches_policy_for_mtr1010() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User does manual renewal on the policy <mtr1010>")
	public void user_does_manual_renewal_on_the_polcy_mtr1010() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(5);
		click(reviewChevron.btnProcess);
		wait(15);
		closeUnnecessaryTabs();
		// taking note of the renewal issued policy
		try {
			renewalTerm1 = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + renewalTerm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Policy File Chevron <mtr1010>")
	public void user_clicks_policy_file_chevron_mtr1010() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User does second manual renewal on the policy <mtr1010>")
	public void user_does_second_manual_renewal_on_the_polcy_mtr1010() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(5);
		click(reviewChevron.btnProcess);
		wait(15);
		closeUnnecessaryTabs();
	}
	@When("User clicks Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package")
	public void user_clicks_renewal_declaration_Link_and_validates_AIIC_02_HO3_Dec_04_23_form_version_listed_in_the_package()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RenewalDeclaration_Form = PdfComparator.makePdf(driver, "RenewalDeclaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RenewalDeclaration_Form);
		wait(10);

		// Declaration page Forms
		RNDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page, "AIIC 02 HO3 DEC 04 23");
		RNDec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page2, "AIIC 02 HO3 DEC 04 23");
		RNDec_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 8, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page3, "AIIC 02 HO3 DEC 04 23");
		RNDec_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 9, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page4, "AIIC 02 HO3 DEC 04 23");
		RNDec_Page5 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 10, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page5, "AIIC 02 HO3 DEC 04 23");
	}
	@When("User validates Counter Signature has been added on Renewal Declaration Package")
	public void user_validates_Counter_Signature_has_Been_added_on_renewal_declaration_package()
			throws Exception {
		
		RNDec_PageSignature = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 8, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_PageSignature, "Authorized Countersignature");
		attachScreenShot(driver);
	}
	@When("User validates correct Additional Interest Information has been added on Renewal Declaration Package")
	public void user_validates_correct_Additional_Interest_information_has_Been_added_on_renewal_declaration_package()
			throws Exception {
		
		RNDec_AdditionalInterest = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 9, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "Additional Interest");
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "Amerihome Mortgage");
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "C/O Loan Care LLC");
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "PO Box 202049");
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "Florence, SC 29502");
		PdfComparator.verifyFormData(driver, RNDec_AdditionalInterest, "FLOOD INSURANCE: YOU SHOULD CONSIDER THE");
		attachScreenShot(driver);
	}
	@When("User searches for Renewed Policy Number for <mtr1010>")
	public void user_searches_for_renewed_policy_number_for_mtr1010() throws Exception {
		sendText(dashboard.txtSearchBar, renewalTerm1);
		click(dashboard.search);
		wait(3);
	}
	@Then("User clicks Second Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package and completes test")
	public void user_clicks_second_renewal_declaration_Link_and_validates_AIIC_02_HO3_Dec_04_23_form_version_listed_in_the_package_and_completes_test()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RenewalDeclaration_Form2 = PdfComparator.makePdf(driver, "RenewalDeclaration2.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RenewalDeclaration_Form2);
		wait(10);

		// Declaration page Forms
		RNDec2_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form2, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page, "AIIC 02 HO3 DEC 04 23");
		RNDec2_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form2, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page2, "AIIC 02 HO3 DEC 04 23");
		RNDec2_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form2, 8, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page3, "AIIC 02 HO3 DEC 04 23");
		RNDec2_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form2, 9, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page4, "AIIC 02 HO3 DEC 04 23");
		RNDec2_Page5 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form2, 10, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page5, "AIIC 02 HO3 DEC 04 23");
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
