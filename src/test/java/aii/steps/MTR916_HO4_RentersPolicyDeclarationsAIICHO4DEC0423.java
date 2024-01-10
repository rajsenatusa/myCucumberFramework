package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR916_HO4_RentersPolicyDeclarationsAIICHO4DEC0423 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String app_Tx_Policy_Claim_Num;
	static String QuoteNum;
	static String RenewalDeclaration_Form;
	static String RNDec_Page;
	static String RNDec_Page2;
	static String RNDec_Page3;
	static String RNDec_Page4;
	static String RNDec_Page5;
	static String RNDec_PageSignature;
	static String RNDec_AdditionalInterest;
	static String RenewalDeclaration_Form2;
	static String NB_Page;
	static String NB_Page2;
	static String NB_Page3;
	static String NB_Page4;
	static String NB_Page5;
	static String NewBussines_Form;
	static String RNDec2_Page;
	static String RNDec2_Page2;
	static String RNDec2_Page3;
	static String RNDec2_Page4;
	static String RNDec2_Page5;

	@When("User enters all required information on policy information screen <mtr916>")
	public void User_enters_all_required_information_on_policy_information_screen_mtr916() {
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11256 SW 62nd Avenue");
		sendText(quote.txtZipCode, "34476");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO4 quote screen <mtr916>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr916() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO4 dwelling screen <mtr916>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr916() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}

	@When("User enters HO4 product selection information and effective date as 04.21.2023")
	public void user_enters_ho4_product_selection_information_and_effective_date_as_04212023() {
		// product selection information was filled here

		sendText(product.txtEffectiveDate, "04/21/2023");
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}

	@When("User clicks Policy File Chevron for <mtr916>")
	public void user_clicks_policy_file_chevron_for_mtr916() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks HO4 Decleration link")
	public void user_clicks_renewal_decleration_link() throws Exception {
		click(policyFileChevron.HO4DeclarationLink);
		wait(3);
	}

	@Then("User validates that HO4 policy has been created successfully and takes note of the policy number <mtr916>")
	public void user_validates_that_ho4_policy_has_been_created_successfully_and_akes_note_of_the_policy_number_mtr916()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO4 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		getInForcePremiumFees(driver);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User validates AIIC HO4 DEC 04 23 form version listed in the declaration package")
	public void User_validates_AIIC_HO4_DEC_04_23_form_version_listed_in_the_declaration_package() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RenewalDeclaration_Form = PdfComparator.makePdf(driver, "RenewalDeclaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RenewalDeclaration_Form);
		wait(10);

		// Declaration page Forms
		RNDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page, "AIIC HO4 DEC 04 23");
		RNDec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 2, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page2, "AIIC HO4 DEC 04 23");
		RNDec_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 3, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page3, "AIIC HO4 DEC 04 23");
		RNDec_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page4, "AIIC HO4 DEC 04 23");

	}

	@When("User clicks HO4 New Business package link")
	public void User_clicks_HO4_New_Business_package_link() throws Exception {
		click(policyFileChevron.HO4NewBussinessPackageLink);
		wait(3);
	}

	@When("User validates AIIC HO4 DEC 04 23 form version listed in the New Business package")
	public void User_validates_AIIC_HO4_DEC_04_23_form_version_listed_in_the_New_Business_package() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NewBussines_Form = PdfComparator.makePdf(driver, "NewBussines.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NewBussines_Form);
		wait(10);

		// Declaration page Forms
		NB_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussines_Form, 3, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NB_Page, "AIIC HO4 DEC 04 23");
		NB_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussines_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NB_Page2, "AIIC HO4 DEC 04 23");
		NB_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussines_Form, 5, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NB_Page3, "AIIC HO4 DEC 04 23");
		NB_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussines_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NB_Page4, "AIIC HO4 DEC 04 23");

	}

	@When("User clicks HO4 Renewal Decleration link")
	public void user_clicks_Renewal_decleration_link() throws Exception {
		click(policyFileChevron.HO4RenewalDeclarationLink);
		wait(3);
	}

	@When("User validates AIIC HO4 DEC 04 23 form version listed in the Renewal Decleration package")
	public void User_validates_AIIC_HO4_DEC_04_23_form_version_listed_in_the_Renewal_Decleration_package()
			throws Exception {

		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RenewalDeclaration_Form = PdfComparator.makePdf(driver, "RenewalDeclaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RenewalDeclaration_Form);
		wait(10);

		// Declaration page Forms
		RNDec2_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 3, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page, "AIIC HO4 DEC 04 23");
		RNDec2_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page2, "AIIC HO4 DEC 04 23");
		RNDec2_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 5, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page3, "AIIC HO4 DEC 04 23");
		RNDec2_Page4 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec2_Page4, "AIIC HO4 DEC 04 23");

		Hooks.scenario.log("Test Case Completed!");

	}

}
