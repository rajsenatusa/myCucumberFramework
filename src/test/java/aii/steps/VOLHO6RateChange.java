package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
//import Member.Pages.ActionsTile.ActionTile;
//import Member.Pages.Login.LoginPage;
//import Member.Pages.ProductSelection.ProductSelectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO6RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User enters Construction Type")
	public void User_enters_Construction_Type() {
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		wait(1);
	}

	@And("User enters Occupancy")
	public void User_enters_Occupancy() {
		selectDropdown(policyChevron.ddOccupancy, 1);
		wait(1);
	}

	@And("User enters Months Occupied")
	public void User_enters_Months_Occupied() {
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
	}

	@And("User enters Year of Construction")
	public void User_enters_Year_of_Construction() {
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(1);
	}

	@And("User enters Square Feet")
	public void User_enters_Square_Feet() {
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
	}

	@And("User enters Building Code Effectiveness Grade")
	public void User_enters_Building_Code_Effectiveness_Grade() {
		selectDropdownText(dwellingChevron.bCEG, "4");
		wait(1);
	}

	@And("User enters Number of stories")
	public void User_enters_Number_of_stories() {
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		wait(1);
	}

	@And("User enters Floor number of unit location")
	public void User_enters_Floor_number_of_unit_location() {
		selectDropdown(dwellingChevron.ddStoryUnit, 2);
		wait(1);
	}

	@And("User enters C Personal Property")
	public void User_enters_C_Personal_Property() {

		dwellingChevron.txtPersonalPropertyC.clear();
		dwellingChevron.txtPersonalPropertyC.sendKeys("$25,000");
	}

	@Then("User verifies HO6 Building Flood Rate Zone X and Foundation Basement")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_X_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User verifies HO6 Personal Property Flood Rate Zone X and Foundation Basement")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtHO6personalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 Building Flood Rate Zone D and Foundation Slab")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_D_and_Foundation_Slab() {
		String expected = "0.65";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User verifies HO6 Personal Property Flood Rate Zone D and Foundation Slab")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_D_and_Foundation_Slab() {
		String expected = "0.70";
		String actual = worksheetsChevron.txtHO6personalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 Building Flood Rate Zone C and Foundation Elevated")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_C_and_Foundation_Elevated() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User verifies HO6 Personal Property Flood Rate Zone C and Foundation Elevated")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Elevated() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtHO6personalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 Building Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_AR_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User verifies HO6 Personal Property Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_AR_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtHO6personalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 Elevation Certificate rate")
	public void User_verifies_HO6_Elevation_Certificate_rate() {
		String expected = "0.15";
		String actual = worksheetsChevron.HO6elevationRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO6 Coverage A increases by 10 percent")
	public void User_validates_HO6_Coverage_A_increases_by_10_percent() {

		String expected = "$190,000";
		String actual = dwellingChevron.HO63CovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates HO6 Coverage C increases by 10 percent")
	public void User_validates_HO6_Coverage_C_increases_by_10_percent() {

		String expected = "$6,000";
		String actual = dwellingChevron.HO63CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates HO6 Coverage D increases by 10 percent")
	public void User_validates_HO6_Coverage_D_increases_by_10_percent() {

		String expected = "$2,400";
		String actual = dwellingChevron.HO63CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates HO6 Ordinance or Law increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_HO6_Ordinance_or_Law_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$95,000";
		String actual = dwellingChevron.HO63OrdOrLaw.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates HO6 Coverage A on Coverages List")
	public void User_validates_HO6_Coverage_A_on_Coverages_List() {

		String expected = "190,000";
		String actual = dwellingChevron.HO6CoverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates HO6 Coverage C on Coverages List")
	public void User_validates_HO6_Coverage_C_on_Coverages_List() {

		String expected = "6,000";
		String actual = dwellingChevron.HO6CoverageListCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO6 Coverage D on Coverages List")
	public void User_validates_HO6_Coverage_D_on_Coverages_List() {

		String expected = "2,400";
		String actual = dwellingChevron.HO6CoverageListCovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO6 Ordinance or Law on Coverages List")
	public void User_validates_HO6_Ordinance_or_Law_on_Coverages_List() {

		String expected = "95,000";
		String actual = dwellingChevron.HO6CoverageListORD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO6 Coverage A is 10 percent under Inflation Guard")
	public void User_validates_HO6_Coverage_A_is_10_percent_under_Inflation_Guard() {

		String expected = "10%";
		String actual = dwellingChevron.HO6InflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO6 Coverage C is 10 percent under Inflation Guard")
	public void User_validates_HO6_Coverage_C_is_10_percent_under_Inflation_Guard() {

		String expected = "10%";
		String actual = dwellingChevron.HO6InflationGuardPct.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@When("User validates VOL HO6 10 percentage in RN Declaration Package")
	public void User_validates_VOL_HO6_10_percentage_in_RN_Declaration_Package() throws Exception {
		switchToWindow(driver, "STFile&File");
		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(20);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 10, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");
		wait(10);

	}
	@When("User validates VOL HO6 inflated values on OIR B1 1670 form")
	public void User_validates_VOL_HO6_inflated_values_on_OIR_B1_1670_form() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 61, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$190,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Not Applicable");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$6,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$500");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User validates VOL HO6 Ordinance or Law Coverage on Dec page")
	public void User_validates_VOL_HO6_Ordinance_or_Law_Coverage_on_Dec_page() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 7, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "Ordinance or Law: 50% of Coverage A");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$95,000");
		Hooks.scenario.log("Test Case Completed!");
	}
	
	 
}