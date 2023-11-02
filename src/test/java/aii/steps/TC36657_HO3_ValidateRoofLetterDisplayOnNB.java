package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC36657_HO3_ValidateRoofLetterDisplayOnNB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NBPackage_Form;
	static String NBDeductibleNoti_Version1;
	static String NBDeductibleNoti_Version;
	static String NBDeductibleNoti_Data;
	static String NBDeductibleNoti_Name;
	static String NBRoofLimitation_Version1;
	static String NBRoofLimitation_Version;
	static String NBRoofLimitation_Data;
	static String NBRoofLimitation_Name;

	@When("User enters all required information on policy information screen <tc36657>")
	public void user_enters_all_required_information_on_policy_information_screen_tc36657() {

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

	@When("User enters all required information on HO3 quote screen <tc36657>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc36657() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
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

	@When("User enters all required information on HO3 dwelling screen <tc36657>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc36657() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron <tc36657>")
	public void user_completes_required_information_on_dwelling_chevron_tc36657() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <tc36657>")
	public void User_clicks_Finalize_button_tc36657() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc36657>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc36657()
			throws Exception {

		waitImp(5);
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

	@When("User clicks Policy File Chevron <tc36657>")
	public void user_clicks_policy_file_chevron_tc36657() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks New Business Package Link and validates roof form versions and completes test")
	public void user_clicks_New_Business_Package_link_and_validates_roof_form_versions() throws Exception {
		clickOnAnyLink(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		NBPackage_Form = PdfComparator.makePdf(driver, "NBPackage.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);

		wait(9);
		// Deductible notification form
		NBDeductibleNoti_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 470, 35, 250,
				50);
		PdfComparator.verifyFormData(driver, NBDeductibleNoti_Version1, "AIIC HO3 DO 07 19");
		NBDeductibleNoti_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 5, 70, 740, 250,
				50);
		PdfComparator.verifyFormData(driver, NBDeductibleNoti_Version, "AIIC HO3 DO 07 19");

		NBDeductibleNoti_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDeductibleNoti_Data, "AIIC HO3 DO 07 19");
		NBDeductibleNoti_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBDeductibleNoti_Name, "DEDUCTIBLE NOTIFICATION OPTIONS");

		// Roof form
		NBRoofLimitation_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 470, 35, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version1, "AIIC RWT 01 19");
		NBRoofLimitation_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 7, 70, 750, 150,
				30);
		PdfComparator.verifyFormData(driver, NBRoofLimitation_Version, "AIIC RWT 01 19");

		NBRoofLimitation_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Data, "AIIC RWT 01 19");
		NBRoofLimitation_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBRoofLimitation_Name, "LIMITATIONS ON ROOF COVERAGE");
	}
}
