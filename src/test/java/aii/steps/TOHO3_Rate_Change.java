package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TOHO3_Rate_Change extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";


	@Then("User verifies TOHO3 Base Rate premium")
	public void User_verifies_TOHO3_Base_Rate_premium() {
		String expected = "7251.00";
		String actual = worksheetsChevron.tOHO3BaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@And("User clicks Key Wind Rate")
	public void User_clicks_Key_Wind_Rate() {
		wait(3);
		click(worksheetsChevron.TOHO3KeyWindRateClick);
		wait(1);
	}

	@Then("User validates TOHO3 base rate in Worksheets")
	public void User_validates_TOHO3_base_rate_in_Worksheets() {
		String expected = "7816.00";
		String actual = worksheetsChevron.TOHO3BaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOHO3 wind exclusion base rate in Worksheets")
	public void User_validates_TOHO3_wind_exclusion_base_rate_in_Worksheets() {
		String expected = "6339.00";
		String actual = worksheetsChevron.TOHO3WindExclusionBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
	@Then("User validates TOHO3 Coverage A increases by 10 percent")
	public void User_validates_TOHO3_Coverage_A_increases_by_10_percent() {
		String expected = "$539,000";
		String actual = dwellingChevron.TOHO3CovALimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage B increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOHO3_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$53,900";
		String actual = dwellingChevron.TOHO3CovBLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOHO3_Coverage_C_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$269,500";
		String actual = dwellingChevron.TOHO3CovCLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOHO3_Coverage_D_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$53,900";
		String actual = dwellingChevron.TOHO3CovDLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Hurricane Coverage A Deductible percentage")
	public void User_validates_TOHO3_Hurricane_Coverage_A_Deductible_percentaget() {
		String expected = "2%";
		String actual = dwellingChevron.TOHO3HurricaneDeductiblePercent.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Ordinance or Law Increases off of Coverage A inflated amount of 10 percent")
	public void User_validates_TOHO3_Ordinance_or_Law_Increases_off_of_Coverage_A_inflated_amount_of_10_percent() {
		String expected = "$134,750";
		String actual = dwellingChevron.TOHO3OrdOrLawLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Sinkhole Loss")
	public void User_validates_TOHO3_Sinkhole_Loss() {
		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.TOHO3SinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage A on Coverages List")
	public void User_validates_TOHO3_Coverage_A_on_Coverages_List() {
		String expected = "539,000";
		String actual = dwellingChevron.TOHO3CovACoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage B on Coverages List")
	public void User_validates_TOHO3_Coverage_B_on_Coverages_List() {
		String expected = "53,900";
		String actual = dwellingChevron.TOHO3CovBCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage C on Coverages List")
	public void User_validates_TOHO3_Coverage_C_on_Coverages_List() {
		String expected = "269,500";
		String actual = dwellingChevron.TOHO3CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage D on Coverages List")
	public void User_validates_TOHO3_Coverage_D_on_Coverages_List() {
		String expected = "53,900";
		String actual = dwellingChevron.TOHO3CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Inflated value of Ordinance or Law on Coverages List")
	public void User_validates_TOHO3_Inflated_value_of_Ordinance_or_Law_on_Coverages_List() {
		String expected = "134,750";
		String actual = dwellingChevron.TOHO3OrdOrLawLimitCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates CovA TOHO3 Inflation Guard is 10 percent")
	public void User_validates_CovA_TOHO3_Inflation_Guard_is_10_percent() {
		String expected = "10%";
		String actual = dwellingChevron.TOHO3InflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@When("User validates TOHO3 10 percentage in RN Declaration Package")
	public void User_validates_TOHO3_10_percentage_in_RN_Declaration_Package() throws Exception {

//		switchToWindow(driver, "STFile&File");
		wait(15);

		mainWindow = driver.getWindowHandle();
		WebDriver popup = null;
		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
		while (windowIterator.hasNext()) {
			String parent = windowIterator.next();
			popup = driver.switchTo().window(parent);
			popup.getCurrentUrl();
		}
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(18);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(12);

	}
	@When("User validates TOHO3 inflated values on Dec page for first RN")
	public void User_validates_TOHO3_inflated_values_on_Dec_page_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 6, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$269,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$134,750");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "2% of Coverage A");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "10% of Coverage A");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	@When("User validates TOHO3 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_TOHO3_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 35, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$269,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$10,780");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	@When("User validates TOHO3 10 percentage in EN Package")
	public void User_validates_TOHO3_10_percentage_in_EN_Package() throws Exception {
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

	}
	@Then("User validates TOHO3 Coverage A increases by 10 percent after second RN")
	public void User_validates_TOHO3_Coverage_A_increases_by_10_percent_after_second_RN() {
		String expected = "$593,000";
		String actual = dwellingChevron.TOHO3CovALimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage B increases off of Coverage A inflated limit amount of 10 percent after second RN")
	public void User_validates_TOHO3_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent_after_second_RN() {
		String expected = "$59,300";
		String actual = dwellingChevron.TOHO3CovBLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}@Then("User validates TOHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percent after second RN")
	public void User_validates_TOHO3_Coverage_C_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent_after_second_RN() {
		String expected = "$296,500";
		String actual = dwellingChevron.TOHO3CovCLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percent after second RN")
	public void User_validates_TOHO3_Coverage_D_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent_after_second_RN() {
		String expected = "$59,300";
		String actual = dwellingChevron.TOHO3CovDLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Hurricane Coverage A Deductible percentage after second RN")
	public void User_validates_TOHO3_Hurricane_Coverage_A_Deductible_percentaget_after_second_RN() {
		String expected = "2%";
		String actual = dwellingChevron.TOHO3HurricaneDeductiblePercent.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Ordinance or Law Increases off of Coverage A inflated amount of 10 percent after second RN")
	public void User_validates_TOHO3_Ordinance_or_Law_Increases_off_of_Coverage_A_inflated_amount_of_10_percent_after_second_RN() {
		String expected = "$148,250";
		String actual = dwellingChevron.TOHO3OrdOrLawLimit.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Sinkhole Loss after second RN")
	public void User_validates_TOHO3_Sinkhole_Loss_after_second_RN () {
		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.TOHO3SinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage A on Coverages List after second RN")
	public void User_validates_TOHO3_Coverage_A_on_Coverages_List_after_second_RN() {
		String expected = "593,000";
		String actual = dwellingChevron.TOHO3CovACoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage B on Coverages List after second RN")
	public void User_validates_TOHO3_Coverage_B_on_Coverages_List_after_second_RN() {
		String expected = "59,300";
		String actual = dwellingChevron.TOHO3CovBCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage C on Coverages List after second RN")
	public void User_validates_TOHO3_Coverage_C_on_Coverages_List_after_second_RN() {
		String expected = "296,500";
		String actual = dwellingChevron.TOHO3CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Coverage D on Coverages List after second RN")
	public void User_validates_TOHO3_Coverage_D_on_Coverages_List_after_second_RN() {
		String expected = "59,300";
		String actual = dwellingChevron.TOHO3CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates TOHO3 Inflated value of Ordinance or Law on Coverages List after second RN")
	public void User_validates_TOHO3_Inflated_value_of_Ordinance_or_Law_on_Coverages_List_after_second_RN() {
		String expected = "148,250";
		String actual = dwellingChevron.TOHO3OrdOrLawLimitCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates CovA TOHO3 Inflation Guard is 10 percent after second RN")
	public void User_validates_CovA_TOHO3_Inflation_Guard_is_10_percent_after_second_RN() {
		String expected = "10%";
		String actual = dwellingChevron.TOHO3InflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@When("User validates TOHO3 10 percentage in RN Declaration Package after second RN")
	public void User_validates_TOHO3_10_percentage_in_RN_Declaration_Package_after_second_RN() throws Exception {

//		switchToWindow(driver, "STFile&File");
		wait(15);

		mainWindow = driver.getWindowHandle();
		WebDriver popup = null;
		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
		while (windowIterator.hasNext()) {
			String parent = windowIterator.next();
			popup = driver.switchTo().window(parent);
			popup.getCurrentUrl();
		}
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
	@When("User validates TOHO3 inflated values on Dec page after second RN")
	public void User_validates_TODP3_inflated_values_on_Dec_page_after_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$593,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$59,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$296,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$59,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$148,250");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "2% of Coverage A");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "10% of Coverage A");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	@When("User validates TOHO3 inflated values on OIR B1 1670 form after second RN")
	public void User_validates_TOHO3_inflated_values_on_OIR_B1_1670_form_after_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 33, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$593,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$59,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$296,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$11,860");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	
}
   
