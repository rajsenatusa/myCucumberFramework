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

public class VOLDP3_RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks Hurricane Building Coverage A Base Premium in Hurricane Building")
	public void User_clicks_Hurricane_Building_Coverage_A_Base_Premium_in_Hurricane_Building() {
		click(worksheetsChevron.VOLDP3HurricaneBuildingCoverageABasePremiumClick);
		wait(1);
	}

	@Then("User validates VOL DP3 Hurricane Coverage A Base Rate in Worksheets")
	public void User_validates_VOL_DP3_Hurricane_Coverage_A_Base_Rate_in_Worksheets() {
		String expected = "1415.0000";
		String actual = worksheetsChevron.VOLDP3HurricaneCoverageABaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks Integrity Select in Dwelling Detail")
	public void User_clicks_Integrity_Select_in_Dwelling_Detail() {
		click(dwellingChevron.rbIntegritySelectPackage);
		wait(1);
	}

	@And("User selects Hurricane Deductible as 10 percent")
	public void User_selects_Hurricane_Deductible_as_10_percent() {
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		wait(1);

	}

	@And("User selects Hurricane Deductible as $500")
	public void User_selects_Hurricane_Deductible_as_500() {
		wait(1);
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$500");
		wait(3);

	}

	@Then("User validates DP3 Coverage A increases by 10 percentage")
	public void User_validates_DP3_Coverage_A_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.DP3InflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage B increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_DP3_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "2%";
		String actual = dwellingChevron.DP3limitCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage C increases by 10 percentage")
	public void User_validates_DP3_Coverage_C_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.DP3InflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage E increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_DP3_Coverage_E_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.DP3CovE.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Hurricane Coverage A Deductible percentage")
	public void User_validates_DP3_Hurricane_Coverage_A_Deductible_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.DP3HurricaneDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage A on Coverages List")
	public void User_validates_DP3_Coverage_A_on_Coverages_List() {

		String expected = "539,000";
		String actual = dwellingChevron.DP3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage B on Coverages List")
	public void User_validates_DP3_Coverage_B_on_Coverages_List() {

		String expected = "10,780";
		String actual = dwellingChevron.DP3CoverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage C on Coverages List")
	public void User_validates_DP3_Coverage_C_on_Coverages_List() {

		String expected = "134,750";
		String actual = dwellingChevron.DP3CoverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage E on Coverages List")
	public void User_validates_DP3_Coverage_E_on_Coverages_List() {

		String expected = "53,900";
		String actual = dwellingChevron.DP3CoverageListCovE.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 A Dwelling Flood on Coverages List")
	public void User_validates_DP3_A_Dwelling_Flood_on_Coverages_List() {

		String expected = "110,000";
		String actual = dwellingChevron.DP3CoverageListFloodCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage A after second RN on Coverages List")
	public void User_validates_DP3_Coverage_A_after_second_RN_on_Coverages_List() {

		String expected = "593,000";
		String actual = dwellingChevron.DP3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage B after second RN on Coverages List")
	public void User_validates_DP3_Coverage_B_after_second_RN_on_Coverages_List() {

		String expected = "11,860";
		String actual = dwellingChevron.DP3CoverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage C after second RN on Coverages List")
	public void User_validates_DP3_Coverage_C_after_second_RN_on_Coverages_List() {

		String expected = "148,250";
		String actual = dwellingChevron.DP3CoverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 Coverage E after second RN on Coverages List")
	public void User_validates_DP3_Coverage_E_after_second_RN_on_Coverages_List() {

		String expected = "59,300";
		String actual = dwellingChevron.DP3CoverageListCovE.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates DP3 A Dwelling Flood after second RN on Coverages List")
	public void User_validates_DP3_A_Dwelling_Flood_after_second_RN_on_Coverages_List() {

		String expected = "121,000";
		String actual = dwellingChevron.DP3CoverageListFloodCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@When("User validates VOL DP3 10 percentage in RN Declaration Package")
	public void User_validates_VOL_DP3_10_percentage_in_RN_Declaration_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(20);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 13, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(10);

	}

	@When("User validates VOL DP3 10 percentage in RN Declaration Package for second RN")
	public void User_validates_VOL_DP3_10_percentage_in_RN_Declaration_Package_for_second_RN() throws Exception {

		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);
		
		wait(20);
		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 13, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

		wait(5);

	}

	@When("User validates VOL DP3 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_VOL_DP3_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 97, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$10,780");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$134,750");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL DP3 inflated values on OIR B1 1670 form for second RN")
	public void User_validates_VOL_DP3_inflated_values_on_OIR_B1_1670_form_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 94, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$593,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$11,860");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$148,250");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$$59,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL DP3 10 percentage in EN Package")
	public void User_validates_10_VOL_DP3_percentage_in_EN_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(11);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 5, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		
		wait(5);
	}
}
