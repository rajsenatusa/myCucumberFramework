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

	@Then("User validates Coverage A increases by 10 percentage")
	public void User_validates_Coverage_A_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage B increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$54,200";
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

		String expected = "542,000";
		String actual = dwellingChevron.coverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@And("User enters Coverage C in Dwelling")
	public void User_enters_Coverage_C_in_Dwelling() {

		dwellingChevron.txtCoverageC.sendKeys("25000");
		wait(1);
	}
	
	
	
		@When("111User switches that forms and validates form version on Renewal Declaration")
		public void user_switches_that_forms_and_validates_form_version_on_rn() throws Exception {
			switchToWindow(driver, "STFile&File");
			RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

			// Save the pdf in local driver
			PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

			wait(10);
			
			RwlDecCoveragesForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 4, 0, 0, 800, 800);
			PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$597,000");
			PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$59,700");
			PdfComparator.verifyFormData(driver, RwlDecCoveragesForm, "$28,000");
			

			RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
			PdfComparator.verifyFormData(driver, RwlDecForm,
					"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
			PdfComparator.verifyFormData(driver, RwlDecForm,
					"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
			PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
			
			
			
			
			
		}

		@When("111User validates data on the coverage form with expected data and completes test")
		public void user_validates_data_on_the_coverage_form_with_expected_data_and_completes_test() throws Exception {
			RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 60, 0, 400, 600, 500);
			PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
			PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$62,500");
			PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$312,500");
			PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Not Included");
			Hooks.scenario.log("Test Case Completed!");
		}

}