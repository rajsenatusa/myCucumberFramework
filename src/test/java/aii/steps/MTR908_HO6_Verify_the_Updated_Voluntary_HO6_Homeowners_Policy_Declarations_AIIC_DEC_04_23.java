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

public class MTR908_HO6_Verify_the_Updated_Voluntary_HO6_Homeowners_Policy_Declarations_AIIC_DEC_04_23
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime issueDate = currentDate.minusYears(1);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;
	static String RenewalDeclaration_FormHO6;
	static String RNDec_Page;
	static String RNDec_Page2;
	static String RNDec_Page3;
	

	@When("User enters all required information on policy information screen <mtr908>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr908() {

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

	@When("User enters HO6 product selection information and current date minus 1 year as effective date")
	public void user_enters_ho6_product_selection_information_and_effective_date_as_current_date_minus_1_year() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(issueDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <mtr908>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_mtr908() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen and enters <35.000> for CovC <mtr908>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_35000_Cov_c_mtr908() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User answers all underwriting questions for HO6 <mtr908>")
	public void user_answers_all_underwriting_questions_for_ho6_mtr908() throws Exception {
		fillHO6_UWQuestions();
	}

	@And("User checks application dwelling screen and finalizes transaction <mtr908>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_mtr908() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <mtr908>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_mtr908()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the policy number <mtr908>")
	public void user_searches_policy_for_mtr908() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User does manual renewal on the policy <mtr908>")
	public void user_does_manual_renewal_on_the_polcy_mtr908() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(5);
		click(reviewChevron.btnProcess);
		wait(15);
		closeUnnecessaryTabs();
	}
	@When("User clicks Policy File Chevron <mtr908>")
	public void user_clicks_policy_file_chevron_mtr908() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User clicks Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr908> and completes test")
	public void user_clicks_renewal_declaration_Link_and_validates_AIIC_02_HO3_Dec_04_23_form_version_listed_in_the_package_mtr908()
			throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RenewalDeclaration_FormHO6 = PdfComparator.makePdf(driver, "RNewalDeclaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RenewalDeclaration_FormHO6);
		wait(10);

		// Declaration page Forms
		RNDec_Page = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_FormHO6, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page, "AIIC DEC 04 23");
		RNDec_Page2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_FormHO6, 8, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page2, "AIIC DEC 04 23");
		RNDec_Page3 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RenewalDeclaration_FormHO6, 9, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RNDec_Page3, "AIIC DEC 04 23");

		Hooks.scenario.log("Test Case Completed!");
	}
}
