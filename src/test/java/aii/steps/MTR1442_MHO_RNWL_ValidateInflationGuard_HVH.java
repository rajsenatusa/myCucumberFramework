package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR1442_MHO_RNWL_ValidateInflationGuard_HVH extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on MHO3 dwelling screen and sets coverage A as <500.000> and coverage B as <%10> and clicks WindHailExclusion")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_500000() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "500000");
		wait(2);
		selectDropdownText(dwellingChevron.ddCovBOtherStructures, "10%");
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.rbWindHailExc);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
	}

	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr1442>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr1442() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
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

	@When("User does auto renewal throught batch jobs")
	public void user_does_auto_renewal_() throws Exception {
		runAutoRenewPolicy(driver, policyNum, "01", "02");
	}
	@When("User clicks Dwelling Chevron for <mtr1442>")
	public void user_clicks_dwelling_chevron_mtr1442() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@When("User validates <Inflation Guard> label is visible")
	public void user_validates_inflation_label_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Inflation Guard");
	}
	@When("User gets text of CovA Inflation Value")
	public void user_gets_text_of_cova_inflation_value() throws Exception {
		Cov_A_InfaltionValue = getTextOfElement(driver, "Building.CovALimit_text");
	}
	@When("User compares CovA Inflation Value with expected value and validates disabled fields values")
	public void user_compares_cova_inflation_value_with_expected_value_and_validates_disabled_fields() throws Exception {
		expectedValue_foundValue(driver, "$625,000", Cov_A_InfaltionValue);
		verifyAnyDisabledFieldsValue(driver, "CovBLimit", "$62,500");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$312,500");
		verifyAnyDisabledFieldsValue(driver, "CovDLimit", "$125,000");
	}
	@When("User clicks Policy File Chevron for <mtr1442>")
	public void user_clicks_policy_file_chevron_mtr1442() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@When("User clicks Renewal Decleration link for <mtr1442>")
	public void user_clicks_renewal_decleration_link() throws Exception {
		click(policyFileChevron.btnRenewalDeclaration);
		wait(3);
	}
	@When("User switches that forms and validates form version on Renewal Declaration")
	public void user_switches_that_forms_and_validates_form_version_on_rn() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+RwlDec_Form);
		
		RwlDecCoveragesForm = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$625,000");
		PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$62,500");
		PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$312,500");
		PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$125,000");
		
		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm, "Property Coverage limits have increased at renewal due to an inflation factor of 25%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm, "industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
	}
	@When("User validates data on the coverage form with expected data and completes test")
	public void user_validates_data_on_the_coverage_form_with_expected_data_and_completes_test() throws Exception {
		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+RwlDec_Form, 60, 0, 400, 600, 500);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$62,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$312,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Not Included");
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User clicks Make Payment and selects credit card and enters due amount for <mtr1442>")
	public void user_clicks_make_payment_and_selects_cc_1442()  {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		String totalDue=driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}
	@When("User makes payment with Credit Card for <mtr1442>")
	public void user_makes_payment_with_credit_card_mtr1442()  {
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
