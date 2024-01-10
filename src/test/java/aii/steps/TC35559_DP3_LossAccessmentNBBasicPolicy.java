package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC35559_DP3_LossAccessmentNBBasicPolicy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String QuoteForm;
	static String Quote_Version;
	static String policyNum;
	static String DP3App_Loss;
	static String DP3App_Version;

	@When("User enters all required information on policy information screen <tc35559>")
	public void user_enters_all_required_information_on_policy_information_screen_tc35559() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <tc35559>")
	public void user_enters_all_current_date_as_prior_date_tc35559() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
//		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
//		click(dwellingChevron.btnSave);
//		wait(3);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen <tc35559> adds coverages and validates loss assessment selections")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_tc35559_and_adds_coverages_and_validates_loss_assessment_selections()
			throws Exception {

		sendText(dwellingChevron.txtYearConstruction, currentYear);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtCoverageC, "10000");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$100,000");

		try {
			sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		} catch (Exception e) {
			clickOKDailogButton(driver);
			sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		}

		String[] lossAssessment = { "None", "$2,000", "$5,000", "$10,000" };
		verifyAnyDropDownOptions(driver, lossAssessment, "Building.CovLACLimit");
		selectDropdownText(dwellingChevron.ddLossAssesment, "None");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisibleTwice(driver, "Loss Assessment");
	}

	@When("User checks dwelling screen and updates HVAC, roof, plumbing, electrical year to current year and selects loss assessment as <10.000>")
	public void user_checks_dwelling_screen_and_updates_HVAC_roof_plumbing_electrical_and_selects_loss_assessment_as_10000() {
		click(dwellingChevron.btnDwelling);
		waitImp(3);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtCoverageC, "10000");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		sendText(dwellingChevron.txtHvacYearUpdate, currentYear);
		sendText(dwellingChevron.txtPlumbingYearUpdate, currentYear);
		sendText(dwellingChevron.txtYearElectrical, currentYear);
		selectDropdownText(dwellingChevron.ddLossAssesment, "$10,000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		click(policyChevron.btnNext);
		click(policyChevron.btnNext);
	}

	@When("User prints quote for loss assessment validation")
	public void user_prints_quote_for_loss_assessment_validation() throws Exception {
		driver.findElement(By.id("PrintQuote")).click();
		wait(3);
		switchToWindow(driver, "UWQuotePrint");
		QuoteForm = PdfComparator.makePdf(driver, "DP3Quote.pdf");
		// Save the Pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + QuoteForm);
		wait(10);

		Quote_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + QuoteForm, 1, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, Quote_Version, "Loss Assessment");
		PdfComparator.verifyFormData(driver, Quote_Version, "$10,000");
	}

	@When("User finalizes transaction for <tc35559>")
	public void user_finalizes_transaction_for_tc35559() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <tc35559>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_tc35559()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Policy File Chevron <tc35559>")
	public void user_clicks_policy_file_chevron_tc35559() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User validates loss assessment form version in Application")
	public void user_validates_loss_assessment_form_version_in_Application() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		DP3App_Loss = PdfComparator.makePdf(driver, "Application.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + DP3App_Loss);

		wait(10);
		DP3App_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Loss, 2, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, DP3App_Version, "Loss Assessment");
		PdfComparator.verifyFormData(driver, DP3App_Version, "$10,000");
	}

	@Then("User validates loss assessment form version in Declaration and completes test")
	public void user_validates_loss_assessment_form_version_in_Declaration_and_completes_test() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Declaration')])[3]")).click();
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		String DP3Dec_Loss = PdfComparator.makePdf(driver, "Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + DP3Dec_Loss);

		wait(10);
		String DP3Dec_LA = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3Dec_Loss, 2, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, DP3Dec_LA, "Loss Assessment");
		PdfComparator.verifyFormData(driver, DP3Dec_LA, "$10,000");

		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		wait(3);
		PdfComparator.switchWindows(driver);
		selectTaskTab(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
