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

public class TC16720_TOMHO3_ValidateNOCForm_NB_ENDWindEx_Claim_RWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime NBDate = currentDate.minusYears(1);
	static LocalDateTime endorseDate = NBDate.plusDays(30);
	static String policyNum;
	static String AppNum;
	static String lossNum;
	static String claimNum;
	static String totalDue;
	static String currentDueRenewal;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String WindHailForm;
	static String WindHail_Version1;
	static String WindHail_Version;
	static String WindHail_Data;
	static String WindHail_Name;
	static String EndPackage_Form;
	static String EndWindHail_Version1;
	static String EndWindHail_Version;
	static String EndWindHail_Data;
	static String EndWindHail_Name;
	static String TOMHO_renewalTerm1;
	static String AssignmentForm;
	static String Assignment_Version1;
	static String Assignment_Version;
	static String Assignment_Data;
	static String Assignment_Name;
	static String RwlDec_Form;
	static String RwlFormsEndSection;
	static String RwlAssignment_Version1;
	static String RwlAssignment_Version;
	static String RwlAssignment_Data;
	static String RwlAssignment_Name;
	static String RwlWindHail_Version1;
	static String RwlWindHail_Version;
	static String RwlWindHail_Data;
	static String RwlWindHail_Name;

	@When("User enters all required information on policy information screen <tc16720>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16720() {

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

	@When("User enters product selection information for TOMHO and current date minus 1 year as effective date <tc16720>")
	public void user_enters_product_selection_information_for_tomho_and_current_date_minus_1_year_as_effective_date_tc16720() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(NBDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomho);
	}

	@When("User enters all required information on TOMHO quote screen <tc16720>")
	public void user_enters_all_required_information_on_tomho_quote_screen_tc16720() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHO dwelling screen <tc16720>")
	public void user_enters_all_required_information_on_tomho_dwelling_screen_tc16720() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2019");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, "33");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		sendText(dwellingChevron.txtCoverageA, "75000");
		// click(dwellingChevron.rbWindHailExc);
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$1,000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User clicks dwelling chevron <tc16720>")
	public void user_clicks_dwelling_chevron_tc16720() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User completes required information on dwelling screen <tc16720>")
	public void user_completes_required_information_tc16720() {

		selectDropdownText(dwellingChevron.ddRoofMetarial, "Composition Shingle");
		selectDropdownText(dwellingChevron.ddBuildingMake, "Excel Homes");
		selectDropdownText(dwellingChevron.ddBuildingLength, "32 to 55");
		selectDropdownText(dwellingChevron.ddBuildingWidth, "12 to 23");
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, "123PJB174");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that TOMHO policy has been created successfully and takes note of the policy number <tc16720>")
	public void user_validates_that_tomho_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc16720()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut MHO policy has been created successfully");
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

	@When("User changes system date to policy effective date plus 30 days <tc16720>")
	public void user_changes_system_date_to_policy_effective_date_plus_30_days_tc16720() throws Exception {
		ChangeDate_Admin(driver, dtf.format(endorseDate));
	}

	@When("User searches for the policy number <tc16720>")
	public void user_searches_policy_for_tc16720() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as endorsement date and starts endorsement <tc16720>")
	public void User_sets_new_effective_date_as_endorsement_date_and_starts_endorsement_tc16720() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(endorseDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User checks Wind Hail exclusion")
	public void user_checks_Wind_Hail_exclusion_tc16720() {
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User finalizes transaction and completes endorsement <tc16720>")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs_tc16720() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		click(closeoutChevron.btnEndorsePolicy);
		wait(15);
		closeUnnecessaryTabs();
	}

	@When("User clicks Forms Chevron <tc16720>")
	public void user_clicks_forms_chevron_tc16720() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates 'HO 04 94 06 97' form is visible on forms chevron and validates form version")
	public void user_validates_HO04940697_form_is_visible_on_forms_chevron_and_validates_form_version_tc16720()
			throws Exception {
		verify_AnyText_IsVisible(driver, "HO 04 94 06 97");

		// WindHail covergae form
		clickonAnyButton(driver, "HO04940697_View");
		Thread.sleep(7000);
		switchToWindow(driver, "ho04940697.pdf");
		WindHailForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + WindHailForm);
		wait(15);

		WindHail_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + WindHailForm, 1, 475, 50, 100, 30);
		PdfComparator.verifyFormData(driver, WindHail_Version1, "HO 04 94 06 97");
		WindHail_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + WindHailForm, 1, 50, 755, 120, 30);
		PdfComparator.verifyFormData(driver, WindHail_Version, "HO 04 94 06 97");

		WindHail_Data = PdfComparator.getPDFData(FileLocation + WindHailForm);
		PdfComparator.verifyPDFText(driver, WindHail_Data, "HO 04 94 06 97");
		WindHail_Name = PdfComparator.getPDFData(FileLocation + WindHailForm);
		PdfComparator.verifyPDFText(driver, WindHail_Name, "WINDSTORM OR HAIL EXCLUSION");
	}

	@When("User clicks Policy File Chevron <tc16720>")
	public void user_clicks_policy_file_chevron_tc16720() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Endorsement Package and validate form version <tc16720>")
	public void user_clicks_Endorsement_Package_and_validate_form_version_tc16720() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(10);

		// Windhail exclusion form
		EndWindHail_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 5, 475, 50, 100,
				30);
		PdfComparator.verifyFormData(driver, EndWindHail_Version1, "HO 04 94 06 97");
		EndWindHail_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 5, 50, 755, 120, 30);
		PdfComparator.verifyFormData(driver, EndWindHail_Version, "HO 04 94 06 97");

		EndWindHail_Data = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndWindHail_Data, "HO 04 94 06 97");
		EndWindHail_Name = PdfComparator.getPDFData(FileLocation + EndPackage_Form);
		PdfComparator.verifyPDFText(driver, EndWindHail_Name, "WINDSTORM OR HAIL EXCLUSION");
	}

	@When("User sets loss date as endorse date <tc16720>")
	public void user_sets_loss_date_as_endorse_date_tc16720() {
		sendText(claim.txtLossDate, dtf.format(endorseDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as collapse and clicks Save <tc16720>")
	public void user_selects_loss_cause_as_collapse_and_clicks_save_tc16720() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collapse");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User completes all required information on claim chevron <tc16720>")
	public void user_completes_all_reqiured_information_on_claim_chevron_tc16720() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Forms verification");
	}

	@When("User clicks save and takes note of the loss number <tc16720>")
	public void user_clicks_save_and_takes_note_of_the_loss_number_tc16720() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Complete and takes note of the claim number <tc16720>")
	public void user_clicks_complete_takes_notes_tc16720() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Start Claim button")
	public void user_clicks_Start_Claim_button() {
		driver.findElement(By.id("MoreActionsDropdownButton")).click();
		wait(1);
		click(driver.findElement(By.id("Transaction")));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks Adjust Reserves")
	public void user_clicks_adjust_reserves_() throws Exception {
		clickAdjustReserves(driver);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
	}

	@And("User finalizes transaction and process transaction <tc16720>")
	public void user_finalizes_transaction_and_process_transaction_tc16720() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(3);
		clickProcess(driver);
		wait(15);
		//closeUnnecessaryTabs();
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <tc16720>")
	public void user_clicks_make_payment_and_selects_cc_tc16720() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <tc16720>")
	public void user_makes_payment_with_credit_card_tc16720() throws Exception {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User does Auto Renewal for the policy with batch jobs <tc16720>")
	public void user_does_auto_renewal_tc16720() throws Exception {

		TOMHO_renewalTerm1 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		driver.findElement(By.id("Tab_Policy")).click();
		wait(1);
	}

	@When("User searches for the renewed policy number <tc16720>")
	public void user_searches_renewed_policy_for_tc16720() {
		sendText(dashboard.txtSearchBar, TOMHO_renewalTerm1);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates 'HO 04 94 06 97' form is visible on forms chevron <tc16720>")
	public void user_validates_HO04940697_form_is_visible_on_forms_chevron_tc16720() throws Exception {
		verify_AnyText_IsVisible(driver, "HO 04 94 06 97");
	}

	@When("User validates 'HO 04 94 06 97' form is visible and Assignment Agreement Notice 01 19 form is not visible on forms chevron <tc16720>")
	public void user_validates_HO04940697_and_Assignment_Agreement_Notice_form_is_not_visible_on_forms_chevron_tc16720()
			throws Exception {
		verify_AnyText_IsVisible(driver, "HO 04 94 06 97");

		// AIIC AA 02 20 form validation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC AA 02 20')]"));
			Hooks.scenario.log("Assignment Agreement Notice Form");
		} catch (Exception e) {
			Hooks.scenario.log("Assignment Agreement Notice Form NOT displayed as expected");
			wait(5);
		}
	}
	@When("User validates 'HO 04 94 06 97' form and Assignment Agreement Notice 01 19 form is visible on forms chevron <tc16720>")
	public void user_validates_HO04940697_and_Assignment_Agreement_Notice_form_is_visible_on_forms_chevron_tc16720()
			throws Exception {
		verify_AnyText_IsVisible(driver, "HO 04 94 06 97");

		// AIIC AA 02 20 form validation
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'AIIC AA 02 20')]"));
			Hooks.scenario.log("Assignment Agreement Notice Form");
		} catch (Exception e) {
			Hooks.scenario.log("Assignment Agreement Notice Form NOT displayed");
			wait(5);
		}
	}
	@When("User clicks Assignment Agreement Notice form and validates form version <tc16720>")
	public void user_clicks_Assignment_Agreement_Notice_form_and_validates_form_version_tc16720() throws Exception {
		clickonAnyButton(driver, "AIICAA0220_View");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-aa-0220.pdf");
		AssignmentForm = PdfComparator.getPdfName(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + AssignmentForm);

		wait(10);
		Assignment_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + AssignmentForm, 1, 490, 35, 250, 50);
		PdfComparator.verifyFormData(driver, Assignment_Version1, "AIIC AA 02 20");
		Assignment_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + AssignmentForm, 1, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, Assignment_Version, "AIIC AA 02 20");

		Assignment_Data = PdfComparator.getPDFData(FileLocation + AssignmentForm);
		PdfComparator.verifyPDFText(driver, Assignment_Data, "AIIC AA 02 20");
		Assignment_Name = PdfComparator.getPDFData(FileLocation + AssignmentForm);
		PdfComparator.verifyPDFText(driver, Assignment_Name, "ASSIGNMENT AGREEMENT NOTICE");
	}

	@When("User clicks Renewal Declaration and validates form version <tc16720>")
	public void user_clicks_Renewal_Declaration_and_validates_form_version_tc16720() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);
		wait(10);

		// Declaration Forms and End section
		RwlFormsEndSection = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 3, 30, 320, 540, 200);
		PdfComparator.verifyFormData(driver, RwlFormsEndSection, "AIIC AA 02 20");
		PdfComparator.verifyFormData(driver, RwlFormsEndSection, "HO 04 94 06 97");

		// Assignment aggrement notice
		RwlAssignment_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 490, 35, 250, 50);
		PdfComparator.verifyFormData(driver, RwlAssignment_Version1, "AIIC AA 02 20");
		RwlAssignment_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 70, 740, 250, 50);
		PdfComparator.verifyFormData(driver, RwlAssignment_Version, "AIIC AA 02 20");

		RwlAssignment_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlAssignment_Data, "AIIC AA 02 20");
		RwlAssignment_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlAssignment_Name, "ASSIGNMENT AGREEMENT NOTICE");

		// Windhail exclusion form
		RwlWindHail_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 51, 475, 50, 100, 30);
		PdfComparator.verifyFormData(driver, RwlWindHail_Version1, "HO 04 94 06 97");
		RwlWindHail_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 51, 50, 755, 120, 30);
		PdfComparator.verifyFormData(driver, RwlWindHail_Version, "HO 04 94 06 97");

		RwlWindHail_Data = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlWindHail_Data, "HO 04 94 06 97");
		RwlWindHail_Name = PdfComparator.getPDFData(FileLocation + RwlDec_Form);
		PdfComparator.verifyPDFText(driver, RwlWindHail_Name, "WINDSTORM OR HAIL EXCLUSION");
	}

	@When("User clicks Make Payment and do renewal payment <tc16720>")
	public void user_clicks_make_payment_and_do_renewal_payment_tc16720() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_1"))); // pay with existing credit card
		wait(1);
		currentDueRenewal = driver.findElement(By.id("AccountSummary_CurrentDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, currentDueRenewal);
		wait(4);

		click(driver.findElement(By.id("SubmitPayment")));
		wait(1);
		click(driver.findElement(By.id("dialogOK")));
		wait(10);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User does second Auto Renewal for the policy with batch jobs <tc16720>")
	public void user_does_second_Auto_Renewal_for_the_policy_with_batch_jobs_tc16720() throws Exception {
		runAutoRenewPolicy(driver, TOMHO_renewalTerm1, "02", "03");
		driver.findElement(By.id("Tab_Policy")).click();
		wait(1);
	}
}
