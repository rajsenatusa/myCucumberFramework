package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TODP3_Rate_Change extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks EC Key Premium Adjusted in Extended Coverage Building")
	public void User_clicks_EC_Key_Premium_Adjusted_in_Extended_Coverage_Building() {
		wait(3);
		click(worksheetsChevron.TODP3ECKeyPremiumClick);
		wait(1);
	}

	@Then("User validates NonSeasonalBuilding TODP3 premium in Worksheets")
	public void User_validates_NonSeasonalBuilding_TODP3_premium_in_Worksheets() {
		String expected = "509.47";
		String actual = worksheetsChevron.TODP3NonSeasonalBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates WindExclusionCreditBuilding TODP3 rate in Worksheets")
	public void User_validates_WindExclusionCreditBuilding_TODP3_rate_in_Worksheets() {
		String expected = "368.150";
		String actual = worksheetsChevron.TODP3WindExclusionCreditBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TODP3 Coverage A increases by 10 percent")
	public void User_validates_TODP3_Coverage_A_increases_by_10_percent() {

		String expected = "$539,000";
		String actual = dwellingChevron.TODP3CovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Coverage B increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TODP3_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {

		String expected = "$53,900";
		String actual = dwellingChevron.TODP3CovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Coverage D increases by 10 percent")
	public void User_validates_TODP3_Coverage_D_increases_by_10_percent() {

		String expected = "$53,900";
		String actual = dwellingChevron.TODP3CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Hurricane Coverage A Deductible percentage")
	public void User_validates_TODP3_Hurricane_Coverage_A_Deductible_percentage() {

		String expected = "2%";
		String actual = dwellingChevron.hurricaneDeductiblePercent.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Sinkhole Loss")
	public void User_validates_TODP3_Sinkhole_Loss() {

		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.sinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Coverage A on Coverages List")
	public void User_validates_TODP3_Coverage_A_on_Coverages_List() {

		String expected = "539,000";
		String actual = dwellingChevron.coverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Coverage B on Coverages List")
	public void User_validates_TODP3_Coverage_B_on_Coverages_List() {

		String expected = "53,900";
		String actual = dwellingChevron.coverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP3 Coverage D on Coverages List")
	public void User_validates_TODP3_Coverage_D_on_Coverages_List() {

		String expected = "53,900";
		String actual = dwellingChevron.coverageListCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates CovA TODP3 Inflation Guard is 10 percent")
	public void User_validates_CovA_TODP3_Inflation_Guard_is_10_percent() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates CovC TODP3 Inflation Guard is 10 percent")
	public void User_validates_CovC_TODP3_Inflation_Guard_is_10_percent() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@When("User validates TODP3 10 percentage in RN Declaration Package")
	public void User_validates_TODP3_10_percentage_in_RN_Declaration_Package() throws Exception {

		wait(8);

		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(18);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 8, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(12);

	}

	@When("User validates TODP3 inflated values on Dec page for first RN")
	public void User_validates_TODP3_inflated_values_on_Dec_page_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "2% of Coverage A");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "10% of Coverage A");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates TODP3 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_TODP3_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Excluded");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$10,780");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@Then("User validates TODP3 Coverage A is 10 percente under Inflation Guard")
	public void User_validates_TODP3_Coverage_A_is_10_percente_under_Inflation_Guard() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@When("User validates TODP3 10 percentage in EN Declaration Package")
	public void User_validates_TODP3_10_percentage_in_EN_Declaration_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(10);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(2);

	}

	@Then("User validates TODP3 Coverage A increases by 10 percentage after next term RN")
	public void User_validates_TODP3_Coverage_A_increases_by_10_percentage_after_next_term_RN() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

}
