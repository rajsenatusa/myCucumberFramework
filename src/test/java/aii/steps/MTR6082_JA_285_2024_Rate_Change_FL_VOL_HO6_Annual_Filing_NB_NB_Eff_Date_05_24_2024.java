package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR6082_JA_285_2024_Rate_Change_FL_VOL_HO6_Annual_Filing_NB_NB_Eff_Date_05_24_2024 extends CommonMethods {

//	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
//	static LocalDateTime currentDate = LocalDateTime.now();
	static String NewBussiness_Form;
	static String NewBussinessForm;
//	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
//	

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User Searchs Policy")
	public void User_searches_for_Policy_Number() {
		sendText(dashboard.txtSearchBar, "AGC0000155-01");
		click(dashboard.search);
		wait(3);
	}

	@When("User enters HO6 product selection information and '05.24.2024' as effective date")
	public void user_enters_ho6_product_selection_information_and_05_24_2024_as_current_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, "05/24/2024");
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(1);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}

	@When("User enters all required information on HO6 quote screen <mtr6082>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6082() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, ("05/24/2024"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@And("User enters HO6 Dwelling Address {string}")
	public void User_enters_HO6_Dwelling_Address(String DwellingAddress) {
		wait(2);
		sendText(quote.customerLookupAddrStreetName, DwellingAddress);

	}

	@And("User enters HO6 Dwelling Zip {string}")
	public void User_enters_HO6_Dwelling_Zip(String DwellingZip) {
		wait(2);
		sendText(quote.customerLookupAddrPostalCode, DwellingZip);
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on policy information screen <mtr6082>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr6082() {
		wait(2);
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		wait(2);

	}

	@When("User enters all required information on HO6 dwelling screen <mtr6082>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_mtr6082() {
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
//		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6082>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6082() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "180.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 180.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6082>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6082() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "327.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 327.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Water Damage Excluded Factor <mtr6082>")
	public void User_verifies_HO6_Water_Damage_Excluded_Factor_mtr6082() throws Exception {
		wait(3);

		click(worksheetsChevron.HO6WaterDamageExcludedClick);
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea10\"]/tbody/tr/td/div/table/tbody")));
		String expected = "0.540";
		String actual = worksheetsChevron.HO6WaterDamageExcluded.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Water Damage Excluded Factor is 0.540");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6083>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6083() throws Exception {
//		click(worksheetsChevron.HO6NHRBaseClick);
//		verify_AnyfirstText_IsDisplayed(driver, "152.00");
//		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 152.00");
//		attachScreenShot(driver);
//		wait(5);
//		
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "152.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 152.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6083>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6083() throws Exception {
//		wait(5);
//		click(worksheetsChevron.HO6HRBaseClick);
//		verify_AnyfirstText_IsDisplayed(driver, "773.00");
//		Hooks.scenario.log("HO6 Hurricane Base Rate is 773.00");
//		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[1]")));
//		attachScreenShot(driver);
//		wait(1);

		click(worksheetsChevron.HO6HRClick);
		String expected = "773.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 773.00");
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea00\"]/tbody/tr/td/div/table/tbody/tr[1]")));
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Water Damage Limited Factor <mtr6083>")
	public void User_verifies_HO6_Water_Damage_Limited_Factor_mtr6083() throws Exception {
		wait(3);
//		click(worksheetsChevron.HO6WaterDamageExcludedClick);
//		verify_AnyfirstText_IsDisplayed(driver, "1.296");
//		Hooks.scenario.log("HO6 Water Damage Limited Factor is 1.296");
//		wait(1);
//		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov1\"]/tbody/tr[2]/td/table/tbody")));
//		wait(1);
//		attachScreenShot(driver);
//		wait(1);
//		

//		click(worksheetsChevron.HO6WaterDamageExcludedClick);
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea10\"]/tbody/tr/td/div/table/tbody")));
		String expected = "1.296";
		String actual = worksheetsChevron.HO6WaterDamageLimited.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Water Damage Limited Factor is 1.296");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6084>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6084() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "180.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertNotEquals("The value DO match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate should be 180.00 BUT previous effective date has 189.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6084>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6084() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "327.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertNotEquals("The value DO match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate should be 327.00 BUT previous effective date has 343.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies Revised Base rate Premiums display in New Business Package <mtr6082>")
	public void User_verifies_Revised_Base_rate_Premiums_display_in_New_Business_Packagege_mtr6082() throws Exception {

		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NewBussiness_Form = PdfComparator.makePdf(driver, "New_Bussiness.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NewBussiness_Form);
		wait(15);

		// Declaration page Forms
		NewBussinessForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussiness_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewBussinessForm, "TOTAL ANNUAL POLICY PREMIUM");
		attachScreenShot(driver);
		wait(1);

	}

	@Then("User verifies HO6 Coverage Premiums in Coverage List <mtr6082>")
	public void User_verifies_HO6_Coverage_Premiums_in_Coverage_List_mtr6082() throws Exception {
		driver.switchTo().defaultContent();
		wait(1);
		scrollToElement(driver.findElement(By.id("CoverageListFilterBy")));
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User verifies HO6 Coverage Premiums in Rate Confirmation <mtr6082>")
	public void User_verifies_HO6_Coverage_Premiums_in_Rate_Confirmation_mtr6082() throws Exception {
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User verifies HO6 Coverage Premiums in Premium Information <mtr6082>")
	public void User_verifies_HO6_Coverage_Premiums_in_Premium_Information_mtr6082() throws Exception {
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@When("User clicks HO6 Policy File Chevron")
	public void user_clicks_HO6_policy_file_chevron() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@And("User enters state {string}")
	public void User_enters_effective_date(String State) {
		selectDropdownText(product.ddStateSelection, State);
		wait(1);
		click(product.btnContinue);
	}

	@And("User selects product on Product Selection List")
	public void User_selects_product_on_Product_Selection_List() {
		click(product.btnProductSelectionHo6);
		wait(1);

	}

	@And("User clicks Water Damage Exclusion")
	public void User_clicks_Water_Damage_Exclusion() {
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);

	}

	@And("User clicks Water Damage Limited")
	public void User_clicks_Water_Damage_Limited() {
		click(dwellingChevron.rbWaterDamageLimited);
		wait(1);

	}

	@When("User enters all required information on HO6 quote screen <mtr6083>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6083() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, ("06/26/2024"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO6 dwelling screen <mtr6083>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_mtr6083() {
		wait(1);
		click(dwellingChevron.dialogOK);
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
//		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);

	}

	@And("User closes the browser")
	public void User_closes_the_browser() {
		driver.close();
		wait(1);

	}

	@When("User enters all required information on HO6 dwelling screen <mtr6084>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_mtr6084() {
//		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
//		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User enters all required information on HO6 quote screen <mtr6084>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6084() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ("05/23/2024"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO6 review screen <mtr6084>")
	public void user_enter_all_required_information_on_ho6_review_screen_mtr6084() {

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(dwellingChevron.btnSave);
	}

	@When("User enters all required information on HO6 quote screen <mtr6085>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6085() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ("07/21/2023"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6085>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6085() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "252.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 252.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6085>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6085() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "354.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 354.00");
		attachScreenShot(driver);
		wait(5);
	}

	@Then("User verifies HO6 Water Damage Excluded Factor <mtr6085>")
	public void User_verifies_HO6_Water_Damage_Excluded_Factor_mtr6085() throws Exception {
		wait(3);

		click(worksheetsChevron.HO6WaterDamageExcludedClick);
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea10\"]/tbody/tr/td/div/table/tbody")));
		String expected = "0.540";
		String actual = worksheetsChevron.HO6WaterDamageExcluded.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Water Damage Excluded Factor is 0.540");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies Revised Base rate Premiums display in Renewal Declaration Package <mtr6085>")
	public void User_verifies_Revised_Base_rate_Premiums_display_in_Renewal_Declaration_Packagege_mtr6085()
			throws Exception {

		clickOnAnyPolicyFileTabForm(driver, "Renewal Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);
		wait(15);

		// Declaration page Forms
		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 6, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm, "TOTAL ANNUAL POLICY PREMIUM");
		attachScreenShot(driver);
		wait(1);

	}

	@When("User enters all required information on HO6 quote screen <mtr6086>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6086() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ("07/20/2023"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6086>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6086() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "173.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertNotEquals("The value DO match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate should be 173.00 BUT previous effective date has 187.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6086>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6086() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "634.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertNotEquals("The value DO match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate should be 634.00 BUT previous effective date has 687.00");
		attachScreenShot(driver);
		wait(5);

	}

	@When("User enters all required information on HO6 quote screen <mtr6087>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6087() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ("08/21/2023"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6087>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6087() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "153.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 153.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6087>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6087() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "316.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 316.00");
		attachScreenShot(driver);
		wait(5);
	}

	@Then("User verifies HO6 Water Damage Excluded Factor <mtr6087>")
	public void User_verifies_HO6_Water_Damage_Excluded_Factor_mtr6087() throws Exception {
		wait(3);

		click(worksheetsChevron.HO6WaterDamageExcludedClick);
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCovCovArea10\"]/tbody/tr/td/div/table/tbody")));
		String expected = "0.540";
		String actual = worksheetsChevron.HO6WaterDamageExcluded.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Water Damage Excluded Factor is 0.540");
		attachScreenShot(driver);
		wait(5);

	}

	@When("User enters all required information on HO6 review screen <mtr6087>")
	public void user_enter_all_required_information_on_ho6_review_screen_mtr6087() {

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(dwellingChevron.btnSave);
	}

	@And("User sets the effective date as 05.24.2024")
	public void User_sets_the_effective_date_as_05_24_2024() throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), "05/24/2024");
		clickTab(driver.findElement(By.id("CancelTypeCd")));
//		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnProcess);

	}

	@And("User validates Policy Status displayed as Cancelled <mtr6088>")
	public void User_validates_Policy_Status_displayed_as_Cancelled_mtr6088() {
		click(historyChevron.btnHistoryChevron);
		wait(2);

		// Validate status as cancelled
		String policyStatus = driver.findElement(By.id("PolicySummary_TransactionStatus")).getText().toString();
		if (policyStatus.equalsIgnoreCase("Cancelled")) {
			Hooks.scenario.log("Policy Status displays Cancelled as expected.");
		} else {
			Hooks.scenario.log("Policy Status displays as Not cancelled. Test fails!");
		}
	}

	@Given("User selects Reinstatement and validates <mtr6088>")
	public void User_selects_Reinstatement_and_validates_mtr6088() throws Exception {

//		startTransaction();
		selectDropdownText(dashboard.ddSelectTransaction, "Reinstatement");
		click(dashboard.btnSelect);
		attachScreenShot(driver);
		click(dashboard.btnStart);
		wait(5);
		click(closeoutChevron.btnProcess);
		wait(6);
		attachScreenShot(driver);
	}

	@When("User clicks Term-Seq Number")
	public void User_clicks_Term_Seq_Number() {

		click(historyChevron.history1_1);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6088>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6088() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "180.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 180.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6088>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6088() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "327.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 327.00");
		attachScreenShot(driver);
		wait(5);
	}

	@When("User enters all required information on HO6 quote screen <mtr6088>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr6088() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ("05/24/2024"));

		wait(2);
		sendText(policyChevron.txtProducerCodeSel, ("AG1730A1"));
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("9 to 12 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO6 dwelling screen <mtr6088>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_mtr6088() {
		wait(2);
		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
//		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User enters all required information on HO6 review screen <mtr6088>")
	public void user_enter_all_required_information_on_ho6_review_screen_mtr6088() {

		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(dwellingChevron.btnSave);
	}

	@And("User enters 05.24.2024 as new effective date <mtr6089>")
	public void User_enters_05_24_2024_as_new_effective_date_mtr6089() {
		sendText(historyChevron.txtNewEffectiveDate, "05/24/2024");
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}

	@Then("User verifies Changed Date <mtr6089>")
	public void User_verifies_Changed_Date_mtr6089() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_2_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Change Date")) {
			System.out.println("Test passed, HO6 Change Date polisy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		attachScreenShot(driver);
	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6089>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6089() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "189.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 189.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6089>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6089() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "452.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 452.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Non-Hurricane Base Rate <mtr6090>")
	public void User_verifies_HO6_Non_Hurricane_Bas_Rate_mtr6090() throws Exception {
		click(worksheetsChevron.HO6NHRBaseClick);
		String expected = "162.00";
		String actual = worksheetsChevron.HO6NHRBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Non-Hurricane Base Rate is 162.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies HO6 Hurricane Base Rate <mtr6090>")
	public void User_verifies_HO6_Hurricane_Bas_Rate_mtr6090() throws Exception {
		wait(5);

		click(worksheetsChevron.HO6HRClick);
		String expected = "215.00";
		scrollToElement(driver.findElement(By.xpath("//*[@id=\"rowCov0\"]/tbody/tr[4]/td/table/tbody")));
		wait(1);
		String actual = worksheetsChevron.HO6HR.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
		Hooks.scenario.log("HO6 Hurricane Base Rate is 215.00");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies Revised Base rate Premiums display in Endorsement Package <mtr6090>")
	public void User_verifies_Revised_Base_rate_Premiums_display_in_Endorsement_Packagege_mtr6090() throws Exception {

		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		NewBussiness_Form = PdfComparator.makePdf(driver, "New_Bussiness.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NewBussiness_Form);
		wait(15);

		// Declaration page Forms
		NewBussinessForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBussiness_Form, 1, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewBussinessForm, "TOTAL ANNUAL POLICY PREMIUM");
		attachScreenShot(driver);
		wait(1);

	}
	@And("User enters 05.23.2024 as new effective date <mtr6089>")
	public void User_enters_05_23_2024_as_new_effective_date_mtr6089() {
		sendText(historyChevron.txtNewEffectiveDate, "05/23/2024");
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}
	@Then("User verifies EN HO6 policy has been created successfully <mtr6082>")
	public void User_verifies_EN_HO6_policy_has_been_created_successfully_mtr6082() throws Exception {
		wait(1);
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement3.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);
	}
	
}