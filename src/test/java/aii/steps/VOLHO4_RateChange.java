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

public class VOLHO4_RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks Rate Area Hurricane")
	public void User_clicks_Rate_Area_Hurricane() {
		wait(3);
		click(worksheetsChevron.linkRateAreaHurricane);
		wait(1);
	}

	@Then("User verifies VOL HO4 Hurricane Base Rate")
	public void User_verifies_VOL_HO4_Hurricane_Base_Rate() {
		String expected = "60.00";
		String actual = worksheetsChevron.HurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks NonHurricane Base Premium")
	public void User_clicks_NonHurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4NonHurricaneBasePremiumClick);
		wait(1);
	}

	@Then("User validates NonHurricane VOL HO4 base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_HO4_base_rate_in_Worksheets() {
		String expected = "116.00";
		String actual = worksheetsChevron.HO4NonHurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks Hurricane Base Premium")
	public void User_clicks_Hurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4HurricaneBasePremiumClick);
		wait(1);
	}

	@Then("User validates Hurricane VOL HO4 base rate in Worksheets")
	public void User_validates_Hurricane_VOL_HO4_base_rate_in_Worksheets() {
		String expected = "60.00";
		String actual = worksheetsChevron.HO4HurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C increases by 10 percentage")
	public void User_validates_HO4_Coverage_C_increases_by_10_percentage() {
		String expected = "$33,000";
		String actual = worksheetsChevron.HO4CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D increases by 10 percentage")
	public void User_validates_HO4_Coverage_D_increases_by_10_percentage() {
		String expected = "$6,600";
		String actual = worksheetsChevron.HO4CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C on Coverages List")
	public void User_validates_HO4_Coverage_C_on_Coverages_List() {
		String expected = "33,000";
		String actual = worksheetsChevron.HO4CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D on Coverages List")
	public void User_validates_HO4_Coverage_D_on_Coverages_List() {
		String expected = "6,600";
		String actual = worksheetsChevron.HO4CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates 10 percentage Inflation guard for Cov C")
	public void User_validates_10_percentage_Inflation_guard_for_Cov_C() {
		String expected = "10%";
		String actual = worksheetsChevron.HO4CovAInflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C increases by 10 percentage after second RN")
	public void User_validates_HO4_Coverage_C_increases_by_10_percentage_after_second_RN() {
		String expected = "$37,000";
		String actual = worksheetsChevron.HO4CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D increases by 10 percentage after second RN")
	public void User_validates_HO4_Coverage_D_increases_by_10_percentage_after_second_RN() {
		String expected = "$7,400";
		String actual = worksheetsChevron.HO4CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C on Coverages List after second RN")
	public void User_validates_HO4_Coverage_C_on_Coverages_List_after_second_RN() {
		String expected = "37,000";
		String actual = worksheetsChevron.HO4CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D on Coverages List after second RN")
	public void User_validates_HO4_Coverage_D_on_Coverages_List_after_second_RN() {
		String expected = "7,400";
		String actual = worksheetsChevron.HO4CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@When("User validates VOL HO4 10 percentage in RN Declaration Package")
	public void User_validates_VOL_HO4_10_percentage_in_RN_Declaration_Package() throws Exception {
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

		wait(15);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

	}

	@When("User validates VOL HO4 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_VOL_HO4_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$33,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL HO4 inflated values on OIR B1 1670 form for second RN")
	public void User_validates_VOL_HO4_inflated_values_on_OIR_B1_1670_form_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$37,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL HO4 10 percentage in EN Package")
	public void User_validates_VOL_HO4_10_percentage_in_EN_Package() throws Exception {
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

		wait(11);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

	}

}