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

public class TODP1_Rate_Change extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks EC Key Premium in Extended Coverage")
	public void User_clicks_EC_Key_Premium_in_Extended_Coverage() {
		wait(3);
		click(worksheetsChevron.TODP1ECKeyPremiumClick);
		wait(1);
	}

	@Then("User validates SeasonalBuilding TODP1 premium in Worksheets")
	public void User_validates_SeasonalBuilding_TODP1_premium_in_Worksheets() {
		String expected = "180.63";
		String actual = worksheetsChevron.TODP1SeasonalBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates WindExclusionCreditBuilding TODP1 rate in Worksheets")
	public void User_validates_WindExclusionCreditBuilding_TODP1_rate_in_Worksheets() {
		String expected = "50.39";
		String actual = worksheetsChevron.TODP1WindExclusionCreditBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@And("User selects Hurricane Deductible as 5 percent")
	public void User_selects_Hurricane_Deductible_as_5_percent() {
		wait(1);
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "5%");
		wait(2);

	}

	@And("User enters Personal Property limit")
	public void User_enters_Personal_Property_limit() {
		dwellingChevron.txtPersonalPropertyC.sendKeys("15000");
		wait(1);

	}

	@And("User selects Personal Liability limit")
	public void User_selects_Personal_Liability_limit() {
		selectDropdownText(dwellingChevron.ddCovLLimit, "$100,000");
		wait(1);

	}

	@Then("User validates TODP1 Coverage A increases by 10 percent")
	public void User_validates_TODP1_Coverage_A_increases_by_10_percent() {

		String expected = "$541,000";
		String actual = dwellingChevron.TODP1CovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Coverage B increases off of Coverage A inflated limit amount of 10 percent")
	public void User_validates_TODP1_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percent() {

		String expected = "$54,100";
		String actual = dwellingChevron.TODP1CovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Coverage C increases by 10 percentage")
	public void User_validates_TODP1_Coverage_C_increases_by_10_percentage() {

		String expected = "$17,000";
		String actual = dwellingChevron.TODP1CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Hurricane Coverage A Deductible percentage")
	public void User_validates_TODP1_Hurricane_Coverage_A_Deductible_percentage() {

		String expected = "5%";
		String actual = dwellingChevron.hurricaneDeductiblePercent.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Sinkhole Loss")
	public void User_validates_TODP1_Sinkhole_Loss() {

		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.sinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Coverage A on Coverages List")
	public void User_validates_TODP1_Coverage_A_on_Coverages_List() {

		String expected = "541,000";
		String actual = dwellingChevron.coverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Coverage B on Coverages List")
	public void User_validates_TODP1_Coverage_B_on_Coverages_List() {

		String expected = "54,100";
		String actual = dwellingChevron.coverageListCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates TODP1 Coverage C on Coverages List")
	public void User_validates_TODP1_Coverage_C_on_Coverages_List() {

		String expected = "17,000";
		String actual = dwellingChevron.coverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates CovA TODP1 Inflation Guard is 10 percent")
	public void User_validates_CovA_TODP1_Inflation_Guard_is_10_percent() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates CovC TODP1 Inflation Guard is 10 percent")
	public void User_validates_CovC_TODP1_Inflation_Guard_is_10_percent() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@And("User clicks Renewal Decleration plus icon")
	public void User_clicks_Renewal_Decleration_plus_icon() {
		click(policyFileChevron.btnExpand);
		wait(3);

	}

	@And("User clicks Insured Renewal Declaration")
	public void User_clicks_Insured_Renewal_Declaration() {
		click(policyFileChevron.insuredRenewalDeclaration);
		wait(3);

	}

	@When("User validates TODP1 10 percentage in RN Declaration Package")
	public void User_validates_TODP1_10_percentage_in_RN_Declaration_Package() throws Exception {

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

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(5);

	}

	@When("User validates TODP1 inflated values on Dec page for first RN")
	public void User_validates_TODP1_inflated_values_on_Dec_page_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$17,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "5% of Coverage A");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "10% of Coverage A");
		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User validates TODP1 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_TODP1_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$539,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$53,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$17,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$26,950");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}
	@Then("User validates TODP1 Coverage A is 10 percente under Inflation Guard")
	public void User_validates_TODP1_Coverage_A_is_10_percente_under_Inflation_Guard() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}
}
