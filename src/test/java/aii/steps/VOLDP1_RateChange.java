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

public class VOLDP1_RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks Extended Coverage Building Hurricane Premium")
	public void User_clicks_Extended_Coverage_Building_Hurricane_Premium() {
		click(worksheetsChevron.eCBHP);
		wait(1);
	}

	@Then("User verifies Extended Coverage Building Hurricane Base rate")
	public void User_verifies_Extended_Coverage_Building_Hurricane_Base_rate() {
		String expected = "253.340";
		String actual = worksheetsChevron.DP1ExtendedCoverageBuildingHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Wind or Hail Exclusion Credit rate")
	public void User_verifies_Wind_or_Hail_Exclusion_Credit_rate() {
		String expected = "228.010";
		String actual = worksheetsChevron.DP1WindHailExclusionCreditRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User selects Sinkhole Loss")
	public void User_selects_Sinkhole_Loss() {
		wait(1);
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");

	}

	@Then("User validates Coverage A increases by 10 percent")
	public void User_validates_Coverage_A_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage B increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$54,100";
		String actual = dwellingChevron.limitCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage C increases by 10 percentage")
	public void User_validates_Coverage_C_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Sinkhole Loss")
	public void User_validates_Sinkhole_Loss() {

		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.sinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage A on Coverages List")
	public void User_validates_Coverage_A_on_Coverages_List() {

		String expected = "541,000";
		String actual = dwellingChevron.coverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@And("User enters Coverage C in Dwelling")
	public void User_enters_Coverage_C_in_Dwelling() {

		dwellingChevron.txtCoverageC.sendKeys("25000");
		wait(1);
	}

	@When("User validates 10 percentage in RN Declaration Package")
	public void User_validates_10_percentage_in_RN_Declaration_Package() throws Exception {
//		switchToWindow(driver, "STFile&File");

		wait(5);

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

		wait(11);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 11, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

	}

	@When("User validates 10 percentage in RN Declaration Package for second RN")
	public void User_validates_10_percentage_in_RN_Declaration_Package_for_second_RN() throws Exception {

//		switchToWindow(driver, "STFile&File");

		wait(5);

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

		wait(15);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 11, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

		wait(10);
	}

	@When("User validates inflated values on OIR B1 1670 form for first RN")
	public void User_validates_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 50, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Excluded");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates inflated values on OIR B1 1670 form for second RN")
	public void User_validates_inflated_values_on_OIR_B1_1670_form_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 48, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$593,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$59,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$28,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates 10 percentage in EN Package")
	public void User_validates_10_percentage_in_EN_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(11);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

	}

}