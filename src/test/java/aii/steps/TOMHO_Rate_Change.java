package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TOMHO_Rate_Change extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";


	@Then("User validates TOMHO base rate in Worksheets")
	public void User_validates_TOMHO_base_rate_in_Worksheets() {
		String expected = "1981.00";
		String actual = worksheetsChevron.TOMHOBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOMHO wind exclusion base rate in Worksheets")
	public void User_validates_TOMHO_wind_exclusion_base_rate_in_Worksheets() {
		String expected = "798.00";
		String actual = worksheetsChevron.TOMHOWindExclusionBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOMHO Coverage A increases by 10 percent")
	public void User_validates_TOMHO_Coverage_A_increases_by_10_percent() {
		String expected = "$66,000";
		String actual = dwellingChevron.MHOCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage B increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOMHO_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$6,600";
		String actual = dwellingChevron.MHOCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage C increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOMHO_Coverage_C_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$33,000";
		String actual = dwellingChevron.MHOCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage D increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TOMHO_Coverage_D_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {
		String expected = "$6,600";
		String actual = dwellingChevron.MHOCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Hurricane Coverage A Deductible percentage")
	public void User_validates_TOMHO_Hurricane_Coverage_A_Deductible_percentage() {
		String expected = "2%";
		String actual = dwellingChevron.hurricaneDeductiblePercent.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage A on Coverages List")
	public void User_validates_TOMHO_Coverage_A_on_Coverages_List() {
		String expected = "66,000";
		String actual = dwellingChevron.HO6CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage B on Coverages List")
	public void User_validates_TOMHO_Coverage_B_on_Coverages_List() {
		String expected = "6,600";
		String actual = dwellingChevron.coverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage C on Coverages List")
	public void User_validates_TOMHO_Coverage_C_on_Coverages_List() {
		String expected = "33,000";
		String actual = dwellingChevron.coverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates TOMHO Coverage D on Coverages List")
	public void User_validates_TOMHO_Coverage_D_on_Coverages_List() {
		String expected = "6,600";
		String actual = dwellingChevron.coverageListCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates CovA TOMHO Inflation Guard is 10 percent")
	public void User_validates_CovA_TOMHO_Inflation_Guard_is_10_percent() {
		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@When("User validates TOMHO 10 percentage in RN Declaration Package")
	public void User_validates_TOMHO_10_percentage_in_RN_Declaration_Package() throws Exception {

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

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(12);

	}
	@When("User validates TOMHO inflated values on Dec page for first RN")
	public void User_validates_TOMHO_inflated_values_on_Dec_page_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 2, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$66,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$6,600");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$33,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$6,600");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "2% of Coverage A");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	@When("User validates TOMHO inflated values on OIR B1 1670 form for first RN")
	public void User_validates_TOMHO_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 45, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$66,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$6,600");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$33,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$1,320");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}
	@When("User validates TOMHO 10 percentage in EN Package")
	public void User_validates_TOMHO_10_percentage_in_EN_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(11);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 3, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

	}
}


 




 



















