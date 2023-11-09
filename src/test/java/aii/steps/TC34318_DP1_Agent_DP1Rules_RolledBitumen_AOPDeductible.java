package aii.steps;

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

public class TC34318_DP1_Agent_DP1Rules_RolledBitumen_AOPDeductible extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static int currentY = currentDate.getYear();
	static String currentYear = String.valueOf(currentY);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String dpdoform;
	static String dpdoform_Data;
	static String package_Form;
	static String package_Form_FnE1;
	static String package_rwt;
	static String package_dpdo;

	@When("User enters all required information on policy information screen <tc34318>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34318() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1601 55th St N");
		sendText(quote.txtZipCode, "33710");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP1 quote screen <tc34318>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc34318() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen <tc34318>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc34318() throws Exception {

		try {
			clickOKDailogButton(driver);
			selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "Rolled/Bitumen");
			selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
			wait(1);
			click(dwellingChevron.btnSave);
			wait(3);
		} catch (Exception e) {
			selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "Rolled/Bitumen");
			selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
			wait(1);
			click(dwellingChevron.btnSave);
			wait(3);
		}

		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtCoverageC, "25000");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$300,000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}
	@When("User validates 'Risk is ineligible due to age of HVAC' and 'Risk is ineligible due to age of Electrical' messages are visible")
	public void user_validates_risk_is_ineligible_messages_are_visible_tv34318() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of HVAC");
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Electrical");
//		click(policyChevron.btnNext);
//		wait(3);
	}
	@When("User answers all underwriting questions for DP1 <tc34318>")
	public void user_answers_all_underwriting_questions_for_dp1_tc34318() throws Exception {
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
		fillDP1_UWQuestions();
		wait(1);
	}
	@When("User clicks Dwelling Chevron <tc34318>")
	public void user_clicks_Dwelling_Chevron_tc34318() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User updates Roof, HVAC, Electrical, Plumbing to current year")
	public void user_updates_Roof_HVAC_Electrical_Plumbing_to_current_year() throws Exception {
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		sendText(dwellingChevron.txtHvacYearUpdate, currentYear);
		sendText(dwellingChevron.txtYearElectrical, currentYear);
		sendText(dwellingChevron.txtPlumbingYearUpdate, currentYear);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates All Peril Deductible dropdown options are correct and visible")
	public void user_validates_All_Peril_Deductible_dd_options_are_correct_and_visible() throws Exception {
		String[] AOP1 = {"$500", "$1,000", "$2,500", "$5,000", "$10,000", "$15,000"};
		verifyAnyDropDownOptions(driver, AOP1, "Building.AllPerilDed");	
		attachScreenShot(driver);
	}
	@When("User changes CoverageA as <499.999> tc34318")
	public void user_changes_CoverageA_as_499999_tc34318() throws Exception {
		setDataToAnyTextboxField(driver, "CovALimit", "CovALimit", "499,999");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates All Peril Deductible dropdown options with new CoverageA amount are correct and visible")
	public void user_validates_All_Peril_Deductible_dd_options_with_new_CoverageA_amount_are_correct_and_visible() throws Exception {
		String[] AOP2 = {"$500", "$1,000", "$2,500", "$5,000", "$10,000", "$15,000"};
		verifyAnyDropDownOptions(driver, AOP2, "Building.AllPerilDed");	
		attachScreenShot(driver);
	}
	@When("User changes CoverageA as <500.000> tc34318")
	public void user_changes_CoverageA_as_500000_tc34318() throws Exception {
		setDataToAnyTextboxField(driver, "CovALimit", "CovALimit", "500,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User validates All Peril Deductible dropdown options with new CoverageA 500.000 amount are correct and visible")
	public void user_validates_All_Peril_Deductible_dd_options_with_new_CoverageA_500000_amount_are_correct_and_visible() throws Exception {
		String[] AOP3 = {"$500", "$1,000", "$2,500", "$5,000", "$10,000", "$15,000", "$25,000"};
		verifyAnyDropDownOptions(driver, AOP3, "Building.AllPerilDed");	
		attachScreenShot(driver);
	}
	@When("User selects All Other Perils Deductible as <$25.000> and validates 'Deductible for All Other Perils Cannot Exceed Deductible for Hurricane' message")
	public void user_selects_All_Other_Perils_Deductible_as_25000_and_validates_issue_message_34318() throws Exception {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$25,000");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Deductible for All Other Perils Cannot Exceed Deductible for Hurricane");	
	}
	@When("User selects Hurricane Deductible and validates same issue message not displayed")
	public void user_selects_Hurricane_Deductible_and_validates_same_issue_message_not_displayed_34318() throws Exception {
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "5%");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisible(driver, "Deductible for All Other Perils Cannot Exceed Deductible for Hurricane");	
	}
	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <tc34318>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_tc34318()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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
	@When("User clicks Forms Chevron <tc34318>")
	public void user_clicks_Forms_Chevron_34318() throws Exception {
		click(formsChevron.lnkForms);
		wait(3);
	}
	@When("User validates 'AIIC DP DO 06 23' and 'Deductible Notification Options' forms are visible in forms")
	public void user_validates_AIIC_DP_DO_0623_and_Deductible_notification_Options_forms_are_visible_in_forms() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC DP DO 06 23");
		verify_AnyText_IsVisible(driver, "Deductible Notification Options");	
	}
	@When("User clicks Deductible Notification Options and validates form version <tc34318>")
	public void user_clicks_Deductible_Notification_Options_and_validates_form_version_tc34318() throws Exception {
		clickonAnyButton(driver, "AIICDPDO_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-dp-do-0721");
		dpdoform = PdfComparator.getPdfName(driver);
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+dpdoform);	
		wait(12);		
		dpdoform_Data = PdfComparator.getPDFData(FileLocation+dpdoform);
		PdfComparator.verifyPDFText(driver, dpdoform_Data, "AIIC DP DO 07 21");
		PdfComparator.verifyPDFText(driver, dpdoform_Data, "DEDUCTIBLE NOTIFICATION OPTIONS");		
	}
	@When("User clicks Policy File Chevron <tc34318>")
	public void user_clicks_Policy_File_Chevron_34318() throws Exception {
		click(driver.findElement(By.id("Tab_Documents")));
		wait(3);
	}
	@Then("User clicks New Business Package Link and validates necessary form versions <tc34318>")
	public void user_clicks_New_Business_Package_Link_and_validates_necessary_form_versions_34318() throws Exception {
		clickOnAnyLink(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		
		package_Form = PdfComparator.makePdf(driver, "NBPackage.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+package_Form);
			
		wait(12);
		package_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation+package_Form, 9, 40, 290, 530, 250);
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC DP RWT 01 19Limitations on Roof Coverage");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC DP DO 06 23Deductible Notification Options");
		
		package_rwt = SmartPDFComparator2.getPDFtextByArea(FileLocation+package_Form, 5, 60, 80, 520, 700);
		PdfComparator.verifyFormData(driver, package_rwt, "LIMITATIONS ON ROOF COVERAGE");
		PdfComparator.verifyFormData(driver, package_rwt, "AIIC DP RWT 01 19");
		
		
		package_dpdo = SmartPDFComparator2.getPDFtextByArea(FileLocation+package_Form, 7, 60, 30, 495, 750);
		PdfComparator.verifyFormData(driver, package_dpdo, "DEDUCTIBLE NOTIFICATION OPTIONS");
		PdfComparator.verifyFormData(driver, package_dpdo, "AIIC DP DO 06 23");
		
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User creates DP1 application <tc34318>")
	public void user_creates_dp1_application_tc34318() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}
}
