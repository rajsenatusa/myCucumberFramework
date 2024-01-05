package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR972_HO3_Verify_the_updated_Voluntary_HO3_Homeowners_Policy_Declarations_AIIC_DEC_04_23_Flood_Cov_No_Reserve_Package_Basic_LawandOrd_25 extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;
	static String DeclarationForm;
	static String DecPage;
	static String DecPage2;
	static String DecPage3;
	static String DecPage4;
	static String NewB_Form;
	static String NewB_Page;
	static String NewB_Page2;
	static String NewB_Page3;
	static String NewB_Page4;
	
	@When("User enters all required information on policy information screen <mtr972>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr972() {

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
	@When("User enters all required information on HO3 quote screen <mtr972>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr972() throws Exception {
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
	@When("User enters all required information on HO3 dwelling screen, sets law order as 25 percent <mtr972>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr972() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);

		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtCoverageA, "450000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddOrdinance, "25%");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr972>")
	public void user_completes_required_information_on_dwelling_chevron_mtr972() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2023");
		sendText(dwellingChevron.txtHvacYearUpdate, "2023");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2023");
		sendText(dwellingChevron.txtYearElectrical, "2023");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <mtr972>")
	public void User_clicks_Finalize_button_mtr972() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr972>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr972()
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
	@When("User searches for the policy number <mtr972>")
	public void user_searches_policy_for_mtr972() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Policy File Chevron <mtr972>")
	public void user_clicks_policy_file_chevron_mtr972() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User clicks Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr972>")
	public void user_clicks_declaration_Link_and_validates_AIIC_02_HO3_Dec_04_23_form_version_listed_in_the_package_mtr972()
			throws Exception {
		clickOnAnyLink(driver, "Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		DeclarationForm = PdfComparator.makePdf(driver, "DeclarationForm.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + DeclarationForm);
		wait(10);

		// Declaration page Forms
		DecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeclarationForm, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, DecPage, "AIIC DEC 04 23");
		DecPage2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeclarationForm, 2, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, DecPage2, "AIIC DEC 04 23");
		DecPage3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeclarationForm, 3, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, DecPage3, "AIIC DEC 04 23");
		DecPage4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DeclarationForm, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, DecPage4, "AIIC DEC 04 23");	
	}
	@Then("User clicks New Business Package Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr972>")
	public void user_clicks_new_business_package_Link_and_validates_AIIC_02_HO3_Dec_04_23_form_version_listed_in_the_package_mtr972()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NewB_Form = PdfComparator.makePdf(driver, "NewBPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NewB_Form);
		wait(10);

		// Declaration page Forms
		NewB_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewB_Form, 9, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewB_Page, "AIIC DEC 04 23");
		NewB_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewB_Form, 10, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewB_Page2, "AIIC DEC 04 23");
		NewB_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewB_Form, 11, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewB_Page3, "AIIC DEC 04 23");
		NewB_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewB_Form, 12, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewB_Page4, "AIIC DEC 04 23");	
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
