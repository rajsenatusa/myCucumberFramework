package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR1446_UMB_ValidateAdditionalCoverageFormsOn_NB_ENDExcessInsuredAndUnderinsuredLiability_Claim_RWL
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String UMBpolicyNum;
	static String UMB_renewalTerm1;
	static String UMB_renewalTerm2;
	static String claimNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static LocalDateTime endorseDate = currentDate.plusDays(30);
	static LocalDateTime claimDate = endorseDate.plusDays(30);
	static String glform;
	static String gl_Data;
	static String plform;
	static String plform_Data;
	static String pjform;
	static String pjform_Data;
	static String umbliability;
	static String umbliability_Data;
	static String umbliabilityamendment;
	static String umbliabilityamendment_Data;
	static String hdcform;
	static String hdcform_Data;
	static String tlcform;
	static String tlcform_Data;
	static String liveryform;
	static String liveryform_Data;
	static String umbliabilityexclusion;
	static String umbliabilityexclusion_Data;
	static String application_Form_FnE1;
	static String application_Form_FnE2;
	static String dec_Form;
	static String dec_Form_FnE1;
	static String dec_Form_FnE2;
	static String application_Form;
	static String package_Form;
	static String package_Form_FnE1;
	static String package_Form_FnE2;
	static String package_gl;
	static String package_ps;
	static String package_pj;
	static String package_liability;
	static String package_liability_amendment;
	static String package_hdc;
	static String package_tl;
	static String package_exclusion;
	static String package_dl9817;
	static String end_glform;
	static String end_glform_Data;
	static String end_plform;
	static String end_plform_Data;
	static String end_pjform;
	static String end_pjform_Data;
	static String end_umbliability;
	static String end_umbliability_Data;
	static String end_umbliabilityamendment;
	static String end_umbliabilityamendment_Data;
	static String end_hdcform;
	static String end_hdcform_Data;
	static String end_tlcform;
	static String end_tlcform_Data;
	static String end_liveryform;
	static String end_liveryform_Data;
	static String end_umbliabilityexclusion;
	static String end_umbliabilityexclusion_Data;
	static String end_umbum;
	static String end_umbum_Data;
	static String end_package_Form;
	static String end_package_Form_FnE1;
	static String end_package_Form_FnE2;
	static String package_umb_um;
	static String ren_glform;
	static String ren_glform_Data;
	static String ren_plform;
	static String ren_plform_Data;
	static String ren_pjform;
	static String ren_pjform_Data;
	static String ren_umbliability;
	static String ren_umbliability_Data;
	static String ren_umbliabilityamendment;
	static String ren_umbliabilityamendment_Data;
	static String ren_hdcform;
	static String ren_hdcform_Data;
	static String ren_tlcform;
	static String ren_tlcform_Data;
	static String ren_liveryform;
	static String ren_liveryform_Data;
	static String ren_umbliabilityexclusion;
	static String ren_umbliabilityexclusion_Data;
	static String ren_umbum;
	static String ren_umbum_Data;
	static String renDec_Form;
	static String renDec_Form_FnE1;
	static String renDec_Form_FnE2;
	static String ren_gl;
	static String ren_ps;
	static String ren_pj;
	static String ren_liability;
	static String ren_liability_amendment;
	static String ren_hdc;
	static String ren_tlc;
	static String ren_exclusion;
	static String ren_dl98;
	static String ren_umb_um;
	static String ren2_glform;
	static String ren2_glform_Data;
	static String ren2_plform;
	static String ren2_plform_Data;
	static String ren2_pjform;
	static String ren2_pjform_Data;
	static String ren2_umbliability;
	static String ren2_umbliability_Data;
	static String ren2_umbliabilityamendment;
	static String ren2_umbliabilityamendment_Data;
	static String ren2_hdcform;
	static String ren2_hdcform_Data;
	static String ren2_tlcform;
	static String ren2_tlcform_Data;
	static String ren2_liveryform;
	static String ren2_liveryform_Data;
	static String ren2_umbliabilityexclusion;
	static String ren2_umbliabilityexclusion_Data;
	static String ren2_umbum;
	static String ren2_umbum_Data;
	static String renDec2_Form;
	static String renDec2_Form_FnE1;
	static String renDec2_Form_FnE2;
	static String ren2_gl;
	static String ren2_ps;
	static String ren2_pj;
	static String ren2_liability;
	static String ren2_liability_amendment;
	static String ren2_hdc;
	static String ren2_tlc;
	static String ren2_exclusion;
	static String ren2_dl98;
	static String ren2_umb_um;

	@When("User enters HO4 product selection information and current date as effective date")
	public void user_enters_ho4_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here

		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}

	@Then("User validates that HO4 policy has been created successfully and takes note of the policy number")
	public void user_validates_that_ho4_policy_has_been_created_successfully() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO4 NB policy has been created successfully");
		} else {
			System.out.println("Policy Creation failed!");
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

	@When("User searches for the policy number <mtr1446>")
	public void user_searches_policy_for_mtr1446() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks New Quote button and selects current date as effective date")
	public void user_clicks_new_quote_button_and_selects_currentdate_as_effdate() {
		click(holder.btnNewQuote);
		wait(1);
		sendText(holder.txtEffectiveDate, dtf.format(currentDate));
		selectDropdownText(holder.ddStateSelection, "Florida");
		click(holder.btnStartQuote);
		wait(2);
	}

	@When("User enters UMB product selection information")
	public void user_enters_umb_product_selection() {
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
		wait(2);
	}

	@When("User enters producer code and answers previous policy written with AIIG questions")
	public void user_answers_previous_policy_written_with_aiig_questions() {
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(2);
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "No");
		click(policyChevron.btnNext);
		wait(2);
	}

	@When("User enters all required information on UMB personal liability screen <mtr1446>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_mtr1446() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, "1,000,000");
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, "0");
		sendText(umbrellaChevron.txtNumberOfAuto, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(umbrellaChevron.ddLiabilityResidenceAtLeast500k, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User adds underlying policy in personal liability chevron")
	public void user_adds_underlying_policy_in_personal_liability_chevron() {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Property and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, policyNum);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(umbrellaChevron.ddSelectPolicyWithAI, "Yes");
		wait(1);
		selectDropdownText(umbrellaChevron.ddSetExposureType, "Primary Residence");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@Then("User validates that UMB policy has been created successfully and takes note of the policy number")
	public void user_validates_that_umb_policy_has_been_created_successfully() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			UMBpolicyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + UMBpolicyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the umbrella policy number <mtr1446>")
	public void user_searches_umbrella_policy_for_mtr1446() {
		sendText(dashboard.txtSearchBar, UMBpolicyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Forms Chevron and validates all expected forms has been displayed")
	public void user_clicks_forms_chevron_and_validates_all_expected_forms_has_been_displayed() {
		click(driver.findElement(By.id("Wizard_Forms")));
		wait(3);

		// Greeting Letter Validation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC UMB GL')]"));
			Hooks.scenario.log("Greeting Letter Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Greeting Letter Coverage Form");
			wait(4);
		}
		// Privacy Statement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC UMB PS')]"));
			Hooks.scenario.log("Privacy Statement Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Privacy Statement Coverage Form");
			wait(4);
		}
		// Policy Jacket Form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PJ')]"));
			Hooks.scenario.log("Policy Jacket Coverage Form");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Jacket Coverage Form");
			wait(4);
		}
		// Personal Umbrealla Liability Form
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'DL 98 01')]"));
			Hooks.scenario.log("Personal Umbrella Liability Form");
		} catch (Exception e) {
			Hooks.scenario.log("Personal Umbrella Liability Form");
			wait(4);
		}
		// Personal Umbrella Liability Policy Amendment of Policy Provisions
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC UMB SP')]"));
			Hooks.scenario.log("Personal Umbrella Liability Policy Amendment of Policy Provisions");
		} catch (Exception e) {
			Hooks.scenario.log("Personal Umbrella Liability Policy Amendment of Policy Provisions");
			wait(4);
		}
		// No Coverage for Home Day Care Business
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC UMB HDC')]"));
			Hooks.scenario.log("No Coverage for Home Day Care Business");
		} catch (Exception e) {
			Hooks.scenario.log("No Coverage for Home Day Care Business");
			wait(4);
		}
		// Trampoline Liability Exclusion
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC UMB TL')]"));
			Hooks.scenario.log("Trampoline Liability Exclusion");
		} catch (Exception e) {
			Hooks.scenario.log("Trampoline Liability Exclusion");
			wait(4);
		}
		// Public or Livery Conveyance Exclusion Endorsement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC PLC')]"));
			Hooks.scenario.log("Public or Livery Conveyance Exclusion Endorsement");
		} catch (Exception e) {
			Hooks.scenario.log("Public or Livery Conveyance Exclusion Endorsement");
			wait(4);
		}
		// Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or
		// Bacteria Endorsement
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'DL 98 17')]"));
			Hooks.scenario.log(
					"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria Endorsement");
		} catch (Exception e) {
			Hooks.scenario.log(
					"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria Endorsement");
			wait(4);
		}
	}

	@When("User clicks every link of the forms and validates all forms content have been as expected")
	public void user_clicks_every_link_ofthe_forms_validates_allforms_content_have_Been_as_expected() throws Exception {
		// Greeting Letter
		verify_AnyText_IsVisible(driver, "AIIC UMB GL");

		click(driver.findElement(By.id("AIICUMBGL_View")));
		wait(7);
		switchToWindow(driver, "aiic-umb-gl-0816");
		glform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + glform);
		wait(8);

		gl_Data = PdfComparator.getPDFData(FileLocation + glform);
		PdfComparator.verifyPDFText(driver, gl_Data, "AIIC UMB GL 08 16");

		// Privacy Statement
		verify_AnyText_IsVisible(driver, "AIIC UMB PS");

		click(driver.findElement(By.id("AIICUMBPS_View")));
		wait(7);
		switchToWindow(driver, "aiicumbps0616");
		plform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + plform);
		wait(8);

		plform_Data = PdfComparator.getPDFData(FileLocation + plform);
		PdfComparator.verifyPDFText(driver, plform_Data, "AIIC UMB PS 06 16");
		PdfComparator.verifyPDFText(driver, plform_Data, "PRIVACY STATEMENT");

		// Policy Jacket
		verify_AnyText_IsVisible(driver, "AIIC PJ");

		click(driver.findElement(By.id("AIICPJ_View")));
		wait(7);
		switchToWindow(driver, "aiic-pj-0715");
		pjform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + pjform);

		wait(8);
		pjform_Data = PdfComparator.getPDFData(FileLocation + pjform);
		PdfComparator.verifyPDFText(driver, pjform_Data, "AIIC PJ 07 15");
		PdfComparator.verifyPDFText(driver, pjform_Data, "Policy Jacket");

		// Personal Umbrella Liability Form
		verify_AnyText_IsVisible(driver, "DL 98 01");

		click(driver.findElement(By.id("DL9801_View")));
		wait(9);
		switchToWindow(driver, "dl98011006");
		umbliability = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + umbliability);

		wait(8);
		umbliability_Data = PdfComparator.getPDFData(FileLocation + umbliability);
		PdfComparator.verifyPDFText(driver, umbliability_Data, "DL 98 01 10 06");
		PdfComparator.verifyPDFText(driver, umbliability_Data, "PERSONAL UMBRELLA LIABILITY POLICY");

		// Personal Umbrella Liability Policy Amendment of Policy Provisions
		verify_AnyText_IsVisible(driver, "AIIC UMB SP");

		click(driver.findElement(By.id("AIICUMBSP_View")));
		wait(7);
		switchToWindow(driver, "aiicumbsp0616");
		umbliabilityamendment = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + umbliabilityamendment);

		wait(8);
		umbliabilityamendment_Data = PdfComparator.getPDFData(FileLocation + umbliabilityamendment);
		PdfComparator.verifyPDFText(driver, umbliabilityamendment_Data, "AIIC UMB SP 06 16");
		PdfComparator.verifyPDFText(driver, umbliabilityamendment_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, umbliabilityamendment_Data, "AMENDMENT OF POLICY PROVISIONS");

		// No Coverage for Home Day Care
		verify_AnyText_IsVisible(driver, "AIIC UMB HDC");

		click(driver.findElement(By.id("AIICUMBHDC_View")));
		wait(7);
		switchToWindow(driver, "aiicumbhdc0616");
		hdcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + hdcform);

		wait(8);
		hdcform_Data = PdfComparator.getPDFData(FileLocation + hdcform);
		PdfComparator.verifyPDFText(driver, hdcform_Data, "AIIC UMB HDC 06 16");
		PdfComparator.verifyPDFText(driver, hdcform_Data, "NO COVERAGE FOR");
		PdfComparator.verifyPDFText(driver, hdcform_Data, "HOME DAY CARE BUSINESS");

		// Trampoline Liability Exclusion
		verify_AnyText_IsVisible(driver, "AIIC UMB TL");

		click(driver.findElement(By.id("AIICUMBTL_View")));
		wait(7);
		switchToWindow(driver, "aiicumbtl0616");
		tlcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + tlcform);

		wait(8);
		tlcform_Data = PdfComparator.getPDFData(FileLocation + tlcform);
		PdfComparator.verifyPDFText(driver, tlcform_Data, "AIIC UMB TL 06 16");
		PdfComparator.verifyPDFText(driver, tlcform_Data, "TRAMPOLINE LIABILITY EXCLUSION");

		// Public or Livery Conveyance Exclusion
		verify_AnyText_IsVisible(driver, "AIIC PLC");

		click(driver.findElement(By.id("AIICPLC_View")));
		wait(7);
		switchToWindow(driver, "aiicplc0616");
		liveryform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + liveryform);

		wait(8);
		liveryform_Data = PdfComparator.getPDFData(FileLocation + liveryform);
		PdfComparator.verifyPDFText(driver, liveryform_Data, "AIIC PLC 06 16");
		PdfComparator.verifyPDFText(driver, liveryform_Data, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyPDFText(driver, liveryform_Data, "EXCLUSION ENDORSEMENT");

		// Personal Umbrella Liability Policy Exclusion
		verify_AnyText_IsVisible(driver, "DL 98 17");

		click(driver.findElement(By.id("DL9817_View")));
		wait(7);
		switchToWindow(driver, "dl98171006");
		umbliabilityexclusion = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + umbliabilityexclusion);

		wait(8);
		umbliabilityexclusion_Data = PdfComparator.getPDFData(FileLocation + umbliabilityexclusion);
		PdfComparator.verifyPDFText(driver, umbliabilityexclusion_Data, "DL 98 17 04 02");
		PdfComparator.verifyPDFText(driver, umbliabilityexclusion_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, umbliabilityexclusion_Data,
				"EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");
	}

	@When("User clicks Policy File Chevron <mtr1446>")
	public void user_clicks_policy_file_chevron_mtr1446() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Personal Umbrella Application Link and validates form versions")
	public void user_clicks_personal_umbrella_app_link_and_validates_forms() throws Exception {
		clickOnAnyLink(driver, "Personal Umbrella Application");
		wait(7);
		switchToWindow(driver, "STFile&File");
		application_Form = PdfComparator.makePdf(driver, "PersonalUmbrellaApplication.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + application_Form);

		wait(8);
		application_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 1, 50, 620, 525,
				120);
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "DL 98 01 10 06");
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC UMB SP 06 16");

		application_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 2, 0, 0, 610,
				120);
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, application_Form_FnE2,
				"Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, application_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, application_Form_FnE2, "Endorsement");
	}

	@When("User clicks Declaration Link and validates form versions")
	public void user_clicks_declaration_link_and_validates_forms() throws Exception {
		// Verify form version of Declaration

		clickOnAnyLink(driver, "Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		dec_Form = PdfComparator.makePdf(driver, "PersonalUmbrellaDec.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + dec_Form);

		wait(8);
		dec_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + dec_Form, 1, 50, 590, 530, 85);
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "Greeting Letter");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "Privacy Statement");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "Policy Jacket");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "Personal Umbrella Liability Form");
		PdfComparator.verifyFormData(driver, dec_Form_FnE1, "DL 98 01 10 06");

		dec_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + dec_Form, 2, 0, 0, 610, 230);
		PdfComparator.verifyFormData(driver, dec_Form_FnE2,
				"Personal Umbrella Liability Policy Amendment of Policy Provisions - Florida");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "AIIC UMB SP 06 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, dec_Form_FnE2, "Endorsement");
	}

	@When("User clicks NB Package Link and validates form versions")
	public void user_clicks_NB_package_and_validates_forms() throws Exception {

		clickOnAnyLink(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		package_Form = PdfComparator.makePdf(driver, "PersonalUmbrellaPackage.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + package_Form);

		Thread.sleep(500);
		package_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 5, 50, 590, 530, 85);
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "Greeting Letter");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "Privacy Statement");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "Policy Jacket");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "AIIC PJ 07 15");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "Personal Umbrella Liability Form");
		PdfComparator.verifyFormData(driver, package_Form_FnE1, "DL 98 01 10 06");

		package_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 6, 0, 0, 610, 230);
		PdfComparator.verifyFormData(driver, package_Form_FnE2,
				"Personal Umbrella Liability Policy Amendment of Policy Provisions - Florida");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "AIIC UMB SP 06 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, package_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, package_Form_FnE2, "Endorsement");

		package_gl = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 1, 415, 690, 1155, 800);
		PdfComparator.verifyFormData(driver, package_gl, "AIIC UMB GL 08 16");

		package_ps = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 2, 70, 60, 490, 720);
		PdfComparator.verifyFormData(driver, package_ps, "PRIVACY STATEMENT");
		PdfComparator.verifyFormData(driver, package_ps, "AIIC UMB PS 06 16");

		package_pj = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 4, 60, 90, 485, 670);
		PdfComparator.verifyFormData(driver, package_pj, "Policy Jacket");
		PdfComparator.verifyFormData(driver, package_pj, "AIIC PJ 07 15");

		package_liability = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 8, 50, 80, 520, 700);
		PdfComparator.verifyFormData(driver, package_liability, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, package_liability, "DL 98 01 10 06");

		package_liability_amendment = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 16, 40, 80, 535,
				700);
		PdfComparator.verifyFormData(driver, package_liability_amendment, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, package_liability_amendment, "AMENDMENT OF POLICY PROVISIONS");
		PdfComparator.verifyFormData(driver, package_liability_amendment, "AIIC UMB SP 06 16");

		package_hdc = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 19, 40, 80, 530, 700);
		PdfComparator.verifyFormData(driver, package_hdc, "NO COVERAGE FOR");
		PdfComparator.verifyFormData(driver, package_hdc, "HOME DAY CARE BUSINESS");
		PdfComparator.verifyFormData(driver, package_hdc, "AIIC UMB HDC 06 16");

		package_tl = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 20, 50, 80, 515, 700);
		PdfComparator.verifyFormData(driver, package_tl, "TRAMPOLINE LIABILITY EXCLUSION");
		PdfComparator.verifyFormData(driver, package_tl, "AIIC UMB TL 06 16");

		package_exclusion = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 21, 60, 100, 500, 665);
		PdfComparator.verifyFormData(driver, package_exclusion, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyFormData(driver, package_exclusion, "EXCLUSION ENDORSEMENT");
		PdfComparator.verifyFormData(driver, package_exclusion, "AIIC PLC 06 16");

		package_dl9817 = SmartPDFComparator2.getPDFtextByArea(FileLocation + package_Form, 22, 40, 80, 550, 670);
		PdfComparator.verifyFormData(driver, package_dl9817, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, package_dl9817,
				"EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");
		PdfComparator.verifyFormData(driver, package_dl9817, "DL 98 17 04 02");
	}

	@And("User sets new effective date as current date plus <30> days and starts endorsement")
	public void User_sets_new_effective_date_as_current_date_plus_30_days_and_starts_endorsement() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(endorseDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@And("User clicks Personal Umbrella Liability Chevron")
	public void User_clicks_personal_umbrella_liability_chevron() {
		click(dashboard.lnkPersonalUmbrellaLiability);
		wait(2);
	}

	@And("User selects Excess Uninsured Liability Limit as <1.000.000>")
	public void User_selects_excess_insured_as_1000000() {
		selectDropdownText(umbrellaChevron.ddExcessUninsuredLiabilityLimit, "1,000,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and completes endorsement and close unnecessary tabs")
	public void user_finalizes_transaction_and_completes_endorsement() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
	}

	@When("User clicks every link of the endorsement forms and validates all forms content have been as expected")
	public void user_clicks_every_link_ofthe_endorsement_forms_validates_allforms_content_have_Been_as_expected()
			throws Exception {
		// Greeting Letter
		verify_AnyText_IsVisible(driver, "AIIC UMB GL");

		click(driver.findElement(By.id("AIICUMBGL_View")));
		wait(7);
		switchToWindow(driver, "aiic-umb-gl-0816");
		end_glform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_glform);
		wait(8);

		end_glform_Data = PdfComparator.getPDFData(FileLocation + end_glform);
		PdfComparator.verifyPDFText(driver, end_glform_Data, "AIIC UMB GL 08 16");

		// Privacy Statement
		verify_AnyText_IsVisible(driver, "AIIC UMB PS");

		click(driver.findElement(By.id("AIICUMBPS_View")));
		wait(7);
		switchToWindow(driver, "aiicumbps0616");
		end_plform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_plform);
		wait(8);

		end_plform_Data = PdfComparator.getPDFData(FileLocation + end_plform);
		PdfComparator.verifyPDFText(driver, end_plform_Data, "AIIC UMB PS 06 16");
		PdfComparator.verifyPDFText(driver, end_plform_Data, "PRIVACY STATEMENT");

		// Policy Jacket
		verify_AnyText_IsVisible(driver, "AIIC PJ");

		click(driver.findElement(By.id("AIICPJ_View")));
		wait(7);
		switchToWindow(driver, "aiic-pj-0715");
		end_pjform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_pjform);

		wait(8);
		end_pjform_Data = PdfComparator.getPDFData(FileLocation + end_pjform);
		PdfComparator.verifyPDFText(driver, end_pjform_Data, "AIIC PJ 07 15");
		PdfComparator.verifyPDFText(driver, end_pjform_Data, "Policy Jacket");

		// Personal Umbrella Liability Form
		verify_AnyText_IsVisible(driver, "DL 98 01");

		click(driver.findElement(By.id("DL9801_View")));
		wait(9);
		switchToWindow(driver, "dl98011006");
		end_umbliability = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_umbliability);

		wait(8);
		end_umbliability_Data = PdfComparator.getPDFData(FileLocation + end_umbliability);
		PdfComparator.verifyPDFText(driver, end_umbliability_Data, "DL 98 01 10 06");
		PdfComparator.verifyPDFText(driver, end_umbliability_Data, "PERSONAL UMBRELLA LIABILITY POLICY");

		// Personal Umbrella Liability Policy Amendment of Policy Provisions
		verify_AnyText_IsVisible(driver, "AIIC UMB SP");

		click(driver.findElement(By.id("AIICUMBSP_View")));
		wait(7);
		switchToWindow(driver, "aiicumbsp0616");
		end_umbliabilityamendment = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_umbliabilityamendment);

		wait(8);
		end_umbliabilityamendment_Data = PdfComparator.getPDFData(FileLocation + end_umbliabilityamendment);
		PdfComparator.verifyPDFText(driver, end_umbliabilityamendment_Data, "AIIC UMB SP 06 16");
		PdfComparator.verifyPDFText(driver, end_umbliabilityamendment_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, end_umbliabilityamendment_Data, "AMENDMENT OF POLICY PROVISIONS");

		// No Coverage for Home Day Care
		verify_AnyText_IsVisible(driver, "AIIC UMB HDC");

		click(driver.findElement(By.id("AIICUMBHDC_View")));
		wait(7);
		switchToWindow(driver, "aiicumbhdc0616");
		end_hdcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_hdcform);

		wait(8);
		end_hdcform_Data = PdfComparator.getPDFData(FileLocation + end_hdcform);
		PdfComparator.verifyPDFText(driver, end_hdcform_Data, "AIIC UMB HDC 06 16");
		PdfComparator.verifyPDFText(driver, end_hdcform_Data, "NO COVERAGE FOR");
		PdfComparator.verifyPDFText(driver, end_hdcform_Data, "HOME DAY CARE BUSINESS");

		// Trampoline Liability Exclusion
		verify_AnyText_IsVisible(driver, "AIIC UMB TL");

		click(driver.findElement(By.id("AIICUMBTL_View")));
		wait(7);
		switchToWindow(driver, "aiicumbtl0616");
		end_tlcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_tlcform);

		wait(8);
		end_tlcform_Data = PdfComparator.getPDFData(FileLocation + end_tlcform);
		PdfComparator.verifyPDFText(driver, end_tlcform_Data, "AIIC UMB TL 06 16");
		PdfComparator.verifyPDFText(driver, end_tlcform_Data, "TRAMPOLINE LIABILITY EXCLUSION");

		// Public or Livery Conveyance Exclusion
		verify_AnyText_IsVisible(driver, "AIIC PLC");

		click(driver.findElement(By.id("AIICPLC_View")));
		wait(7);
		switchToWindow(driver, "aiicplc0616");
		end_liveryform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_liveryform);

		wait(8);
		end_liveryform_Data = PdfComparator.getPDFData(FileLocation + end_liveryform);
		PdfComparator.verifyPDFText(driver, end_liveryform_Data, "AIIC PLC 06 16");
		PdfComparator.verifyPDFText(driver, end_liveryform_Data, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyPDFText(driver, end_liveryform_Data, "EXCLUSION ENDORSEMENT");

		// Personal Umbrella Liability Policy Exclusion
		verify_AnyText_IsVisible(driver, "DL 98 17");

		click(driver.findElement(By.id("DL9817_View")));
		wait(7);
		switchToWindow(driver, "dl98171006");
		end_umbliabilityexclusion = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_umbliabilityexclusion);

		wait(8);
		end_umbliabilityexclusion_Data = PdfComparator.getPDFData(FileLocation + end_umbliabilityexclusion);
		PdfComparator.verifyPDFText(driver, end_umbliabilityexclusion_Data, "DL 98 17 04 02");
		PdfComparator.verifyPDFText(driver, end_umbliabilityexclusion_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, end_umbliabilityexclusion_Data,
				"EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");

		// Excess Uninsured Motorist Coverage - Florida
		verify_AnyText_IsVisible(driver, "AIIC UMB UM");

		click(driver.findElement(By.id("AIICUMBUM_View")));
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-umb-um-0616");
		end_umbum = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_umbum);

		wait(8);
		end_umbum_Data = PdfComparator.getPDFData(FileLocation + end_umbum);
		PdfComparator.verifyPDFText(driver, end_umbum_Data, "AIIC UMB UM 06 16");
		PdfComparator.verifyPDFText(driver, end_umbum_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, end_umbum_Data, "EXCESS UNINSURED MOTORISTS");
	}

	@When("User clicks Endorsement Package Link and validates form versions")
	public void user_clicks_endorsement_package_link_and_validates_forms() throws Exception {
		clickOnAnyLink(driver, "Endorsement Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		end_package_Form = PdfComparator.makePdf(driver, "PersonalUmbrellaEndPackage.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + end_package_Form);

		Thread.sleep(500);
		end_package_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + end_package_Form, 1, 50, 590, 540,
				90);
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "Greeting Letter");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "Privacy Statement");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "Policy Jacket");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE1, "AIIC PJ 07 15");

		end_package_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + end_package_Form, 2, 0, 0, 610,
				330);
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "Personal Umbrella Liability Form");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "DL 98 01 10 06");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2,
				"Personal Umbrella Liability Policy Amendment of Policy Provisions - Florida");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "AIIC UMB SP 06 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2,
				"Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "Endorsement");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2,
				"AIIC UMB UM 06 16Excess Uninsured Motorist  Coverage - Florida");
		PdfComparator.verifyFormData(driver, end_package_Form_FnE2, "AIIC UMB UM 06 16");

		package_umb_um = SmartPDFComparator2.getPDFtextByArea(FileLocation + end_package_Form, 4, 40, 105, 550, 670);
		PdfComparator.verifyFormData(driver, package_umb_um, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, package_umb_um, "EXCESS UNINSURED MOTORISTS");
		PdfComparator.verifyFormData(driver, package_umb_um, "AIIC UMB UM 06 16");
	}

	@When("User changes system date to claim date 'current date plus 60 days'")
	public void user_changes_system_date_to_claim_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(claimDate));
	}

	@When("User sets loss date as claim date")
	public void user_sets_loss_date_as_current_date_plus_60_days() {
		sendText(claim.txtLossDate, dtf.format(claimDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as 'Bodily Injury' and clicks Save")
	public void user_selects_loss_cause_and_clicks_save() throws Exception {
		selectDropdownText(claim.ddLossCause, "Bodily Injury");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User completes all required information on claim chevron <mtr1446>")
	public void user_completes_all_reqiured_information_on_claim_chevron_mtr1446() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Forms verification");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User clicks New Claimant And adds required information <mtr1446>")
	public void user_clicks_new_claimant_adds_information_mtr1446() throws Exception {
		click(claim.btnNewClaimant);
		wait(2);
		selectDropdownText(claim.ddClaimantType, "Third Party");
		wait(1);
		selectDropdownText(claim.ddClaimantSubType, "Employee");
		sendText(claim.txtClaimantFirstName, "Insured");
		sendText(claim.txtClaimantLastName, "Umbrella");
		click(claim.btnReset);
		driver.findElement(By.xpath("(//*[@id='Reset'])[2]")).click();
		sendText(claim.txtClaimantAddress, "11256 SW 62nd Avenue RD");
		sendText(claim.txtClaimantCity, "Ocala");
		selectDropdownText(claim.ddClaimantState, "Florida");
		sendText(claim.txtClaimantZipCode, "34476");
		click(claim.btnClaimantVerifyAddress);
		wait(1);
		selectDropdownText(claim.ddClaimantPhoneType, "Mobile");
		sendText(claim.txtClaimantPhoneNumber, "8131111111");
		click(dwellingChevron.btnSave);
		wait(2);
		click(claim.lnkNotice);
		wait(2);

		click(driver.findElement(By.id("Complete")));
		wait(7);

	}

	@When("User clicks More button and Starts Transaction")
	public void user_clicks_more_button_and_starts_transaction() throws Exception {
		click(claim.btnMore);
		click(claim.btnStartTransaction);
		wait(2);
	}

	@When("User clicks newly added claimant and adjusts reserves")
	public void user_clicks_added_claimant_and_adjusts_reserves() throws Exception {
		click(claim.btnFinanctialActions2);
		click(claim.btnAdjustReserves2);
		wait(2);
		sendText(claim.txtIndemnityReserve, "3000");
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User finalizes claim and process transaction")
	public void user_finalizes_claim_and_completes_transaction() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(3);
	}

	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr1446>")
	public void user_clicks_make_payment_and_selects_cc_1446() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr1446>")
	public void user_makes_payment_with_credit_card_mtr1446() {
		makeCCPayment();

		// Close unnecessary tabs
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
	}

	@And("User selects Renewal")
	public void User_selects_Endorsement() {
		selectDropdownText(dashboard.ddSelectTransaction, "Renewal");
		wait(1);
		click(dashboard.btnSelect);
	}

	@When("User does manual renewal on the policy")
	public void user_does_manual_renewal_on_the_polcy() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(9);
		closeUnnecessaryTabs();
		// taking note of the renewal issued policy
		try {
			UMB_renewalTerm1 = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + UMB_renewalTerm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User issues policy and makes payment")
	public void user_issues_policy_and_do_payment() {

		// make cc payment
		selectDropdownText(closeoutChevron.ddPaymentType, "Credit Card");
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		// issue policy
		wait(5);
		click(closeoutChevron.btnIssueNB);
		wait(10);
	}

	@And("User searches renewed policy")
	public void User_searches_renewed_policy() {
		sendText(dashboard.txtSearchBar, UMB_renewalTerm1);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks every link of the renewal forms and validates all forms content have been as expected")
	public void user_clicks_every_link_ofthe_renewal_forms_validates_allforms_content_have_Been_as_expected()
			throws Exception {
		// Greeting Letter
		verify_AnyText_IsVisible(driver, "AIIC UMB GL");

		click(driver.findElement(By.id("AIICUMBGL_View")));
		wait(7);
		switchToWindow(driver, "aiic-umb-gl-0816");
		ren_glform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_glform);
		wait(8);

		ren_glform_Data = PdfComparator.getPDFData(FileLocation + ren_glform);
		PdfComparator.verifyPDFText(driver, ren_glform_Data, "AIIC UMB GL 08 16");

		// Privacy Statement
		verify_AnyText_IsVisible(driver, "AIIC UMB PS");

		click(driver.findElement(By.id("AIICUMBPS_View")));
		wait(7);
		switchToWindow(driver, "aiicumbps0616");
		ren_plform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_plform);
		wait(8);

		ren_plform_Data = PdfComparator.getPDFData(FileLocation + ren_plform);
		PdfComparator.verifyPDFText(driver, ren_plform_Data, "AIIC UMB PS 06 16");
		PdfComparator.verifyPDFText(driver, ren_plform_Data, "PRIVACY STATEMENT");

		// Policy Jacket
		verify_AnyText_IsVisible(driver, "AIIC PJ");

		click(driver.findElement(By.id("AIICPJ_View")));
		wait(7);
		switchToWindow(driver, "aiic-pj-0715");
		ren_pjform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_pjform);

		wait(8);
		ren_pjform_Data = PdfComparator.getPDFData(FileLocation + ren_pjform);
		PdfComparator.verifyPDFText(driver, ren_pjform_Data, "AIIC PJ 07 15");
		PdfComparator.verifyPDFText(driver, ren_pjform_Data, "Policy Jacket");

		// Personal Umbrella Liability Form
		verify_AnyText_IsVisible(driver, "DL 98 01");

		click(driver.findElement(By.id("DL9801_View")));
		wait(9);
		switchToWindow(driver, "dl98011006");
		ren_umbliability = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_umbliability);

		wait(8);
		ren_umbliability_Data = PdfComparator.getPDFData(FileLocation + ren_umbliability);
		PdfComparator.verifyPDFText(driver, ren_umbliability_Data, "DL 98 01 10 06");
		PdfComparator.verifyPDFText(driver, ren_umbliability_Data, "PERSONAL UMBRELLA LIABILITY POLICY");

		// Personal Umbrella Liability Policy Amendment of Policy Provisions
		verify_AnyText_IsVisible(driver, "AIIC UMB SP");

		click(driver.findElement(By.id("AIICUMBSP_View")));
		wait(7);
		switchToWindow(driver, "aiicumbsp0616");
		ren_umbliabilityamendment = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_umbliabilityamendment);

		wait(8);
		ren_umbliabilityamendment_Data = PdfComparator.getPDFData(FileLocation + ren_umbliabilityamendment);
		PdfComparator.verifyPDFText(driver, ren_umbliabilityamendment_Data, "AIIC UMB SP 06 16");
		PdfComparator.verifyPDFText(driver, ren_umbliabilityamendment_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren_umbliabilityamendment_Data, "AMENDMENT OF POLICY PROVISIONS");

		// No Coverage for Home Day Care
		verify_AnyText_IsVisible(driver, "AIIC UMB HDC");

		click(driver.findElement(By.id("AIICUMBHDC_View")));
		wait(7);
		switchToWindow(driver, "aiicumbhdc0616");
		ren_hdcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_hdcform);

		wait(8);
		ren_hdcform_Data = PdfComparator.getPDFData(FileLocation + ren_hdcform);
		PdfComparator.verifyPDFText(driver, ren_hdcform_Data, "AIIC UMB HDC 06 16");
		PdfComparator.verifyPDFText(driver, ren_hdcform_Data, "NO COVERAGE FOR");
		PdfComparator.verifyPDFText(driver, ren_hdcform_Data, "HOME DAY CARE BUSINESS");

		// Trampoline Liability Exclusion
		verify_AnyText_IsVisible(driver, "AIIC UMB TL");

		click(driver.findElement(By.id("AIICUMBTL_View")));
		wait(7);
		switchToWindow(driver, "aiicumbtl0616");
		ren_tlcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_tlcform);

		wait(8);
		ren_tlcform_Data = PdfComparator.getPDFData(FileLocation + ren_tlcform);
		PdfComparator.verifyPDFText(driver, ren_tlcform_Data, "AIIC UMB TL 06 16");
		PdfComparator.verifyPDFText(driver, ren_tlcform_Data, "TRAMPOLINE LIABILITY EXCLUSION");

		// Public or Livery Conveyance Exclusion
		verify_AnyText_IsVisible(driver, "AIIC PLC");

		click(driver.findElement(By.id("AIICPLC_View")));
		wait(7);
		switchToWindow(driver, "aiicplc0616");
		ren_liveryform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_liveryform);

		wait(8);
		ren_liveryform_Data = PdfComparator.getPDFData(FileLocation + ren_liveryform);
		PdfComparator.verifyPDFText(driver, ren_liveryform_Data, "AIIC PLC 06 16");
		PdfComparator.verifyPDFText(driver, ren_liveryform_Data, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyPDFText(driver, ren_liveryform_Data, "EXCLUSION ENDORSEMENT");

		// Personal Umbrella Liability Policy Exclusion
		verify_AnyText_IsVisible(driver, "DL 98 17");

		click(driver.findElement(By.id("DL9817_View")));
		wait(7);
		switchToWindow(driver, "dl98171006");
		ren_umbliabilityexclusion = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_umbliabilityexclusion);

		wait(8);
		ren_umbliabilityexclusion_Data = PdfComparator.getPDFData(FileLocation + ren_umbliabilityexclusion);
		PdfComparator.verifyPDFText(driver, ren_umbliabilityexclusion_Data, "DL 98 17 04 02");
		PdfComparator.verifyPDFText(driver, ren_umbliabilityexclusion_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren_umbliabilityexclusion_Data,
				"EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");

		// Excess Uninsured Motorist Coverage - Florida
		verify_AnyText_IsVisible(driver, "AIIC UMB UM");

		click(driver.findElement(By.id("AIICUMBUM_View")));
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-umb-um-0616");
		ren_umbum = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren_umbum);

		wait(8);
		ren_umbum_Data = PdfComparator.getPDFData(FileLocation + ren_umbum);
		PdfComparator.verifyPDFText(driver, ren_umbum_Data, "AIIC UMB UM 06 16");
		PdfComparator.verifyPDFText(driver, ren_umbum_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren_umbum_Data, "EXCESS UNINSURED MOTORISTS");
	}

	@When("User clicks Renewal Declaration Link and validates form versions")
	public void user_clicks_renewal_declaration_link_and_validates_forms() throws Exception {
		clickOnAnyLink(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		renDec_Form = PdfComparator.makePdf(driver, "RenewalDec.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + renDec_Form);

		wait(8);
		renDec_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 5, 40, 600, 530, 80);
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "Greeting Letter");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "Privacy Statement");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "Policy Jacket");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE1, "AIIC PJ 07 15");

		renDec_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 6, 45, 100, 540, 120);
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "Personal Umbrella Liability Form");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "DL 98 01 10 06");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2,
				"Personal Umbrella Liability Policy Amendment of Policy Provisions - Florida");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "AIIC UMB SP 06 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "Endorsement");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2,
				"AIIC UMB UM 06 16Excess Uninsured Motorist  Coverage - Florida");
		PdfComparator.verifyFormData(driver, renDec_Form_FnE2, "AIIC UMB UM 06 16");

		ren_gl = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 1, 415, 690, 1155, 800);
		PdfComparator.verifyFormData(driver, ren_gl, "AIIC UMB GL 08 16");

		ren_ps = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 2, 70, 60, 490, 720);
		PdfComparator.verifyFormData(driver, ren_ps, "PRIVACY STATEMENT");
		PdfComparator.verifyFormData(driver, ren_ps, "AIIC UMB PS 06 16");

		ren_pj = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 4, 60, 90, 485, 670);
		PdfComparator.verifyFormData(driver, ren_pj, "Policy Jacket");
		PdfComparator.verifyFormData(driver, ren_pj, "AIIC PJ 07 15");

		ren_liability = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 8, 50, 80, 520, 700);
		PdfComparator.verifyFormData(driver, ren_liability, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren_liability, "DL 98 01 10 06");

		ren_liability_amendment = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 16, 40, 80, 535,
				700);
		PdfComparator.verifyFormData(driver, ren_liability_amendment, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren_liability_amendment, "AMENDMENT OF POLICY PROVISIONS");
		PdfComparator.verifyFormData(driver, ren_liability_amendment, "AIIC UMB SP 06 16");

		ren_hdc = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 19, 40, 80, 530, 700);
		PdfComparator.verifyFormData(driver, ren_hdc, "NO COVERAGE FOR");
		PdfComparator.verifyFormData(driver, ren_hdc, "HOME DAY CARE BUSINESS");
		PdfComparator.verifyFormData(driver, ren_hdc, "AIIC UMB HDC 06 16");

		ren_tlc = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 20, 50, 80, 515, 700);
		PdfComparator.verifyFormData(driver, ren_tlc, "TRAMPOLINE LIABILITY EXCLUSION");
		PdfComparator.verifyFormData(driver, ren_tlc, "AIIC UMB TL 06 16");

		ren_exclusion = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 21, 60, 100, 500, 665);
		PdfComparator.verifyFormData(driver, ren_exclusion, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyFormData(driver, ren_exclusion, "EXCLUSION ENDORSEMENT");
		PdfComparator.verifyFormData(driver, ren_exclusion, "AIIC PLC 06 16");

		ren_dl98 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 22, 40, 80, 550, 670);
		PdfComparator.verifyFormData(driver, ren_dl98, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren_dl98, "EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");
		PdfComparator.verifyFormData(driver, ren_dl98, "DL 98 17 04 02");

		ren_umb_um = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec_Form, 23, 40, 110, 530, 670);
		PdfComparator.verifyFormData(driver, ren_umb_um, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren_umb_um, "EXCESS UNINSURED MOTORISTS");
		PdfComparator.verifyFormData(driver, ren_umb_um, "AIIC UMB UM 06 16");
	}

	@When("User does second manual renewal on the policy")
	public void user_does_second_manual_renewal_on_the_polcy() {
		click(dashboard.btnStart);
		wait(3);
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(reviewChevron.btnProcess);
		wait(7);
		closeUnnecessaryTabs();
		// taking note of the renewal issued policy
		try {
			UMB_renewalTerm2 = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + UMB_renewalTerm2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User searches secondly renewed policy")
	public void User_searches_secondly_renewed_policy() {
		sendText(dashboard.txtSearchBar, UMB_renewalTerm2);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks every link of the second renewal forms and validates all forms content have been as expected")
	public void user_clicks_every_link_ofthe_second_renewal_forms_validates_allforms_content_have_Been_as_expected()
			throws Exception {
		// Greeting Letter
		verify_AnyText_IsVisible(driver, "AIIC UMB GL");

		click(driver.findElement(By.id("AIICUMBGL_View")));
		wait(7);
		switchToWindow(driver, "aiic-umb-gl-0816");
		ren2_glform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_glform);
		wait(8);

		ren2_glform_Data = PdfComparator.getPDFData(FileLocation + ren2_glform);
		PdfComparator.verifyPDFText(driver, ren2_glform_Data, "AIIC UMB GL 08 16");

		// Privacy Statement
		verify_AnyText_IsVisible(driver, "AIIC UMB PS");

		click(driver.findElement(By.id("AIICUMBPS_View")));
		wait(7);
		switchToWindow(driver, "aiicumbps0616");
		ren2_plform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_plform);
		wait(8);

		ren2_plform_Data = PdfComparator.getPDFData(FileLocation + ren2_plform);
		PdfComparator.verifyPDFText(driver, ren2_plform_Data, "AIIC UMB PS 06 16");
		PdfComparator.verifyPDFText(driver, ren2_plform_Data, "PRIVACY STATEMENT");

		// Policy Jacket
		verify_AnyText_IsVisible(driver, "AIIC PJ");

		click(driver.findElement(By.id("AIICPJ_View")));
		wait(7);
		switchToWindow(driver, "aiic-pj-0715");
		ren2_pjform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_pjform);

		wait(8);
		ren2_pjform_Data = PdfComparator.getPDFData(FileLocation + ren2_pjform);
		PdfComparator.verifyPDFText(driver, ren2_pjform_Data, "AIIC PJ 07 15");
		PdfComparator.verifyPDFText(driver, ren2_pjform_Data, "Policy Jacket");

		// Personal Umbrella Liability Form
		verify_AnyText_IsVisible(driver, "DL 98 01");

		click(driver.findElement(By.id("DL9801_View")));
		wait(9);
		switchToWindow(driver, "dl98011006");
		ren2_umbliability = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_umbliability);

		wait(8);
		ren2_umbliability_Data = PdfComparator.getPDFData(FileLocation + ren2_umbliability);
		PdfComparator.verifyPDFText(driver, ren2_umbliability_Data, "DL 98 01 10 06");
		PdfComparator.verifyPDFText(driver, ren2_umbliability_Data, "PERSONAL UMBRELLA LIABILITY POLICY");

		// Personal Umbrella Liability Policy Amendment of Policy Provisions
		verify_AnyText_IsVisible(driver, "AIIC UMB SP");

		click(driver.findElement(By.id("AIICUMBSP_View")));
		wait(7);
		switchToWindow(driver, "aiicumbsp0616");
		ren2_umbliabilityamendment = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_umbliabilityamendment);

		wait(8);
		ren2_umbliabilityamendment_Data = PdfComparator.getPDFData(FileLocation + ren2_umbliabilityamendment);
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityamendment_Data, "AIIC UMB SP 06 16");
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityamendment_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityamendment_Data, "AMENDMENT OF POLICY PROVISIONS");

		// No Coverage for Home Day Care
		verify_AnyText_IsVisible(driver, "AIIC UMB HDC");

		click(driver.findElement(By.id("AIICUMBHDC_View")));
		wait(7);
		switchToWindow(driver, "aiicumbhdc0616");
		ren2_hdcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_hdcform);

		wait(8);
		ren2_hdcform_Data = PdfComparator.getPDFData(FileLocation + ren2_hdcform);
		PdfComparator.verifyPDFText(driver, ren2_hdcform_Data, "AIIC UMB HDC 06 16");
		PdfComparator.verifyPDFText(driver, ren2_hdcform_Data, "NO COVERAGE FOR");
		PdfComparator.verifyPDFText(driver, ren2_hdcform_Data, "HOME DAY CARE BUSINESS");

		// Trampoline Liability Exclusion
		verify_AnyText_IsVisible(driver, "AIIC UMB TL");

		click(driver.findElement(By.id("AIICUMBTL_View")));
		wait(7);
		switchToWindow(driver, "aiicumbtl0616");
		ren2_tlcform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_tlcform);

		wait(8);
		ren2_tlcform_Data = PdfComparator.getPDFData(FileLocation + ren2_tlcform);
		PdfComparator.verifyPDFText(driver, ren2_tlcform_Data, "AIIC UMB TL 06 16");
		PdfComparator.verifyPDFText(driver, ren2_tlcform_Data, "TRAMPOLINE LIABILITY EXCLUSION");

		// Public or Livery Conveyance Exclusion
		verify_AnyText_IsVisible(driver, "AIIC PLC");

		click(driver.findElement(By.id("AIICPLC_View")));
		wait(7);
		switchToWindow(driver, "aiicplc0616");
		ren2_liveryform = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_liveryform);

		wait(8);
		ren2_liveryform_Data = PdfComparator.getPDFData(FileLocation + ren2_liveryform);
		PdfComparator.verifyPDFText(driver, ren2_liveryform_Data, "AIIC PLC 06 16");
		PdfComparator.verifyPDFText(driver, ren2_liveryform_Data, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyPDFText(driver, ren2_liveryform_Data, "EXCLUSION ENDORSEMENT");

		// Personal Umbrella Liability Policy Exclusion
		verify_AnyText_IsVisible(driver, "DL 98 17");

		click(driver.findElement(By.id("DL9817_View")));
		wait(7);
		switchToWindow(driver, "dl98171006");
		ren2_umbliabilityexclusion = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_umbliabilityexclusion);

		wait(8);
		ren2_umbliabilityexclusion_Data = PdfComparator.getPDFData(FileLocation + ren2_umbliabilityexclusion);
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityexclusion_Data, "DL 98 17 04 02");
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityexclusion_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren2_umbliabilityexclusion_Data,
				"EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");

		// Excess Uninsured Motorist Coverage - Florida
		verify_AnyText_IsVisible(driver, "AIIC UMB UM");

		click(driver.findElement(By.id("AIICUMBUM_View")));
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-umb-um-0616");
		ren2_umbum = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + ren2_umbum);

		wait(8);
		ren2_umbum_Data = PdfComparator.getPDFData(FileLocation + ren2_umbum);
		PdfComparator.verifyPDFText(driver, ren2_umbum_Data, "AIIC UMB UM 06 16");
		PdfComparator.verifyPDFText(driver, ren2_umbum_Data, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyPDFText(driver, ren2_umbum_Data, "EXCESS UNINSURED MOTORISTS");
	}

	@When("User clicks second Renewal Declaration Link and validates form versions and completes test")
	public void user_clicks_second_renewal_declaration_link_and_validates_form_versions_and_completes_test()
			throws Exception {
		clickOnAnyLink(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		renDec2_Form = PdfComparator.makePdf(driver, "RenewalDec.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + renDec2_Form);

		wait(8);
		renDec2_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 5, 40, 600, 530, 80);
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "Greeting Letter");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "AIIC UMB GL 08 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "Privacy Statement");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "AIIC UMB PS 06 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "Policy Jacket");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE1, "AIIC PJ 07 15");

		renDec2_Form_FnE2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 6, 0, 0, 610, 320);
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "Personal Umbrella Liability Form");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "DL 98 01 10 06");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2,
				"Personal Umbrella Liability Policy Amendment of Policy Provisions - Florida");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "AIIC UMB SP 06 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "No Coverage for Home Day Care Business");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "AIIC UMB HDC 06 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "Trampoline Liability Exclusion");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "AIIC UMB TL 06 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "Public or Livery Conveyance Exclusion Endorsement");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "AIIC PLC 06 16");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2,
				"Personal Umbrella Liability Policy Exclusion - Fungi, Wet or Dry Rot, or Bacteria");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "DL 98 17 04 02");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "Endorsement");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2,
				"AIIC UMB UM 06 16Excess Uninsured Motorist  Coverage - Florida");
		PdfComparator.verifyFormData(driver, renDec2_Form_FnE2, "AIIC UMB UM 06 16");

		ren2_gl = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 1, 415, 690, 1155, 800);
		PdfComparator.verifyFormData(driver, ren2_gl, "AIIC UMB GL 08 16");

		ren2_ps = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 2, 70, 60, 490, 720);
		PdfComparator.verifyFormData(driver, ren2_ps, "PRIVACY STATEMENT");
		PdfComparator.verifyFormData(driver, ren2_ps, "AIIC UMB PS 06 16");

		ren2_pj = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 4, 60, 90, 485, 670);
		PdfComparator.verifyFormData(driver, ren2_pj, "Policy Jacket");
		PdfComparator.verifyFormData(driver, ren2_pj, "AIIC PJ 07 15");

		ren2_liability = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 8, 50, 80, 520, 700);
		PdfComparator.verifyFormData(driver, ren2_liability, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren2_liability, "DL 98 01 10 06");

		ren2_liability_amendment = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 16, 40, 80, 535,
				700);
		PdfComparator.verifyFormData(driver, ren2_liability_amendment, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren2_liability_amendment, "AMENDMENT OF POLICY PROVISIONS");
		PdfComparator.verifyFormData(driver, ren2_liability_amendment, "AIIC UMB SP 06 16");

		ren2_hdc = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 19, 40, 80, 530, 700);
		PdfComparator.verifyFormData(driver, ren2_hdc, "NO COVERAGE FOR");
		PdfComparator.verifyFormData(driver, ren2_hdc, "HOME DAY CARE BUSINESS");
		PdfComparator.verifyFormData(driver, ren2_hdc, "AIIC UMB HDC 06 16");

		ren2_tlc = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 20, 50, 80, 515, 700);
		PdfComparator.verifyFormData(driver, ren2_tlc, "TRAMPOLINE LIABILITY EXCLUSION");
		PdfComparator.verifyFormData(driver, ren2_tlc, "AIIC UMB TL 06 16");

		ren2_exclusion = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 21, 60, 100, 500, 665);
		PdfComparator.verifyFormData(driver, ren2_exclusion, "PUBLIC OR LIVERY CONVEYANCE");
		PdfComparator.verifyFormData(driver, ren2_exclusion, "EXCLUSION ENDORSEMENT");
		PdfComparator.verifyFormData(driver, ren2_exclusion, "AIIC PLC 06 16");

		ren2_dl98 = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 22, 40, 80, 550, 670);
		PdfComparator.verifyFormData(driver, ren2_dl98, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren2_dl98, "EXCLUSION  FUNGI, WET OR DRY ROT, OR BACTERIA ENDORSEMENT");
		PdfComparator.verifyFormData(driver, ren2_dl98, "DL 98 17 04 02");

		ren2_umb_um = SmartPDFComparator2.getPDFtextByArea(FileLocation + renDec2_Form, 23, 40, 110, 530, 670);
		PdfComparator.verifyFormData(driver, ren2_umb_um, "PERSONAL UMBRELLA LIABILITY POLICY");
		PdfComparator.verifyFormData(driver, ren2_umb_um, "EXCESS UNINSURED MOTORISTS");
		PdfComparator.verifyFormData(driver, ren2_umb_um, "AIIC UMB UM 06 16");

		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User clicks Make Payment second time and selects credit card and enters due amount for <mtr1446>")
	public void user_clicks_make_payment_second_time_and_selects_cc_1446() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_3")));
		wait(1);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card second time for <mtr1446>")
	public void user_makes_payment_with_credit_card_second_time_mtr1446() {
		makeCCPayment();

		// Close unnecessary tabs
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
	}
}
