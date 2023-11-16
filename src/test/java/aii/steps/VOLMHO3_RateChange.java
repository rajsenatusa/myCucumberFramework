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

public class VOLMHO3_RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User enters VOL MHO3 Coverage A Dwelling")
	public void User_enters_VOL_MHO3_Coverage_A_Dwelling() {
		wait(1);
		dwellingChevron.txtCoverageA.sendKeys("50000");
		wait(1);
	}

	@Then("User verifies VOL MHO3 Private Property NonHurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_NonHurricane_rate() {
		String expected = "1302.00";
		String actual = worksheetsChevron.txtMHO3NonHurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies VOL MHO3 Private Property Hurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_Hurricane_rate() {
		String expected = "1337.00";
		String actual = worksheetsChevron.txtMHO3HurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates NonHurricane VOL MHO3 base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_MHO3_base_rate_in_Worksheets() {
		String expected = "1302.0000";
		String actual = worksheetsChevron.MHO3NonHurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates Hurricane VOL MHO3 base rate in Worksheets")
	public void User_validates_Hurricane_VOL_MHO3_base_rate_in_Worksheets() {
		String expected = "1969.00";
		String actual = worksheetsChevron.MHO3HurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User enters Coverage A Dwelling as 51000")
	public void User_enters_Coverage_A_Dwelling_as_51000() {

		dwellingChevron.txtCoverageA.clear();
		dwellingChevron.txtCoverageA.sendKeys("51000");
		wait(1);
	}

	@Then("User validates NonHurricane VOL MHO3 additional premium base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_MHO3_additional_premiumbase_rate_in_Worksheets() {
		String expected = "1317.0000";
		String actual = worksheetsChevron.MHO3NonHurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates Hurricane VOL MHO3 additional premium base rate in Worksheets")
	public void User_validates_Hurricane_VOL_MHO3_additional_premiumbase_rate_in_Worksheets() {
		String expected = "1994.00";
		String actual = worksheetsChevron.MHO3HurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates MHO3 Coverage A increases by 10 percentage")
	public void User_validates_MHO3_Coverage_A_increases_by_10_percentage() {

		String expected = "$330,000";
		String actual = dwellingChevron.MHOCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage B increases off of Coverage A percentage")
	public void User_validates_MHO3_Coverage_B_increases_off_of_Coverage_A_percentage() {

		String expected = "$3,300";
		String actual = dwellingChevron.MHOCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percente")
	public void User_validates_MHO3_Coverage_C_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$165,000";
		String actual = dwellingChevron.MHOCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percente")
	public void User_validates_MHO3_Coverage_D_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$66,000";
		String actual = dwellingChevron.MHOCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage A on Coverages List")
	public void User_validates_DP3_Coverage_A_on_Coverages_List() {

		String expected = "330,000";
		String actual = dwellingChevron.MHO3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage B on Coverages List")
	public void User_validates_DP3_Coverage_B_on_Coverages_List() {

		String expected = "330,000";
		String actual = dwellingChevron.MHO3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage C on Coverages List")
	public void User_validates_DP3_Coverage_C_on_Coverages_List() {

		String expected = "330,000";
		String actual = dwellingChevron.MHO3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage D on Coverages List")
	public void User_validates_DP3_Coverage_D_on_Coverages_List() {

		String expected = "66,000";
		String actual = dwellingChevron.MHO3CoverageListCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage A is 10 percente under Inflation Guard")
	public void User_validates_MHO3_Coverage_A_is_10_percente_under_Inflation_Guard() {

		String expected = "10%";
		String actual = dwellingChevron.MHOInflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@When("User validates VOL MHO3 10 percentage in RN Declaration Package")
	public void User_validates_VOL_MHO3_10_percentage_in_RN_Declaration_Package() throws Exception {

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

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

		wait(10);

	}

	@When("User validates VOL MHO3 10 percentage in RN Declaration Package for second RN")
	public void User_validates_VOL_MHO3_10_percentage_in_RN_Declaration_Package_for_second_RN() throws Exception {

//		wait(5);
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

		wait(15);
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(20);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(10);

	}

	@When("User validates VOL MHO3 inflated values on Dec page for first RN")
	public void User_validates_VOL_MHO3_inflated_values_on_Dec_page_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$330,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$3,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$165,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$66,000");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL MHO3 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_VOL_MHO3_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 63, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$330,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$3,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$165,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$66,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

	@Then("User validates MHO3 Coverage A increases by 10 percentage after second RN")
	public void User_validates_MHO3_Coverage_A_increases_by_10_percentage_after_second_RN() {

		String expected = "$363,000";
		String actual = dwellingChevron.MHOCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage B increases off of Coverage A percentage after second RN")
	public void User_validates_MHO3_Coverage_B_increases_off_of_Coverage_A_percentage_after_second_RN() {

		String expected = "$3,630";
		String actual = dwellingChevron.MHOCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage C increases off of Coverage A inflated limit amount of 10 percente after second RN")
	public void User_validates_MHO3_Coverage_C_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percente_after_second_RN() {

		String expected = "$181,500";
		String actual = dwellingChevron.MHOCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage D increases off of Coverage A inflated limit amount of 10 percente after second RN")
	public void User_validates_MHO3_Coverage_D_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percente_after_second_RN() {

		String expected = "$72,600";
		String actual = dwellingChevron.MHOCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage A on Coverages List after second RN")
	public void User_validates_MHO3_Coverage_A_on_Coverages_List_after_second_RN() {

		String expected = "363,000";
		String actual = dwellingChevron.MHO3CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage B on Coverages List after second RN")
	public void User_validates_MHO3_Coverage_B_on_Coverages_List_after_second_RN() {

		String expected = "3,630";
		String actual = dwellingChevron.MHO3CoverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage C on Coverages List after second RN")
	public void User_validates_MHO3_Coverage_C_on_Coverages_List_after_second_RN() {

		String expected = "181,500";
		String actual = dwellingChevron.MHO3CoverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates MHO3 Coverage D on Coverages List after second RN")
	public void User_validates_MHO3_Coverage_D_on_Coverages_List_after_second_RN() {

		String expected = "72,600";
		String actual = dwellingChevron.MHO3CoverageListCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@When("User validates VOL MHO3 inflated values on Dec page for second RN")
	public void User_validates_VOL_MHO3_inflated_values_on_Dec_page_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$363,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$3,630");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$181,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$72,600");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates VOL MHO3 inflated values on OIR B1 1670 form for second RN")
	public void User_validates_VOL_MHO3_inflated_values_on_OIR_B1_1670_form_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 62, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$363,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$3,630");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$181,500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$7,260");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}

}
