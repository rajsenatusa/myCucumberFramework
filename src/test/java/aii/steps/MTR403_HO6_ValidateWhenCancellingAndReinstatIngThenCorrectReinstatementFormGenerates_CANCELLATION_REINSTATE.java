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
import io.cucumber.java.en.When;

public class MTR403_HO6_ValidateWhenCancellingAndReinstatIngThenCorrectReinstatementFormGenerates_CANCELLATION_REINSTATE extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime cancelDate = currentDate.plusDays(30);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String Con_Coverage_Form;
	static String Con_Coverage_Form_Version;
	static String Con_Coverage_Data;
	
	@When("User enters all required information on policy information screen <mtr403>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr403() {

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
	@When("User enters all required information on HO6 quote screen with current date as prior policy date <mtr403>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_mtr403() {
	   
		//Quote Policy Chevron information was filled here
		
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate,dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
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
	@When("User enters all required information on HO6 dwelling screen and enters <15.000> for CovC <mtr403>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_15000_Cov_c_mtr403() {
		
		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		sendText(dwellingChevron.txtPersonalPropertyC, "15000");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@And("User checks application dwelling screen and finalizes transaction <mtr403>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_mtr403() {
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
	@When("User answers all underwriting questions for HO6 <mtr403>")
	public void user_answers_all_underwriting_questions_for_ho6_mtr403() throws Exception {
		fillHO6_UWQuestions();
	}
	@When("User validates that HO6 policy has been created successfully and takes note of the policy number")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number() throws Exception {
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
	@And("User selects Roof Disrepair as reason")
	public void User_selects_roof_disrepair_reason() {
		selectDropdownText(historyChevron.ddReason, "Roof Disrepair");
		wait(2);
	}
	@And("User selects Roof exceeds typical life expectancy as subreason")
	public void User_selects_subreason_roof_exceeds_typical_life() {
		selectDropdownText(historyChevron.ddSubReason,"Roof exceeds typical life expectancy");
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User selects effective date as cancel date 'current date plus 30 days' <mtr403>")
	public void User_sets_effective_date_as_cancel_date_mtr403() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(cancelDate));
		wait(2);
	}
	@And("User verifies AIIC RI 11 14 generated on Forms chevron <mtr403>")
	public void User_verifies_rein_form_generated_mtr403() throws Exception {
		scrollToAnyField(driver, "REINNOTICE");
		verify_AnyText_IsVisible(driver, "REINNOTICE");
		verify_AnyText_IsVisible(driver, "Reinstatement Notice");
		attachScreenShot(driver);
	}
	@When("User clicks Policy File Chevron for <mtr403>")
	public void user_clicks_policy_file_chevron_for_mtr403() throws Exception {
		waitForVisibility(driver.findElement(By.id("Tab_Documents")));
		click(driver.findElement(By.id("Tab_Documents")));
		wait(5);
	}
	@And("User validates Continuation of Coverage form has been displayed <mtr403>")
	public void User_validates_continuation_generated_mtr403() throws Exception {
		verifyInstallmentInvoiceForm(driver, "Continuation of Coverage");
	}
	@And("User clicks Continuation of Coverage form, saves it to local and do comparisions and validations <mtr403>")
	public void User_clicks_form_and_does_validations_mtr403() throws Exception {
		click(policyFileChevron.btnContinuationOfCoverage);
		wait(6);
		switchToWindow(driver, "STFile&Filename");
		wait(1);
		Con_Coverage_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Con_Coverage");
		PdfComparator.SavePdfForm(driver, FileLocation+Con_Coverage_Form);
		wait(10);
		Con_Coverage_Form_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+Con_Coverage_Form, 1, 450, 720, 100, 50);
		PdfComparator.verifyFormData(driver, Con_Coverage_Form_Version, "AIIC RI 11 14");
		
		Con_Coverage_Data = PdfComparator.getPDFData(FileLocation+Con_Coverage_Form);
		
		//Find the required text in a pdf
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "AIIC RI 11 14");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, dtf.format(cancelDate));
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "underwriting reason(s) met.");
		Hooks.scenario.log("PDF form Data :  "+Con_Coverage_Data);
		
	}
	@And("User starts cancellation transaction")
	public void User_starts_cancellation_transaction() {
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}
}
