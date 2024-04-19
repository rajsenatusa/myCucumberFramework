package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5207_HO3_Verify_base_rates_can_display_correctly extends CommonMethods {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String NewBusiness_Form;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NewBusinnForm;
	static String Renew_Form;
	static String RenewForm;

	@When("User enters HO3 product selection information and date as 03.20.2024")
	public void User_enters_HO3_product_selection_information_and_date_as_03202024() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, "03/20/2024");
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on policy information screen <mtr5207>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5207() {
		wait(2);
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "4013 Red Rock Ln");
		sendText(quote.txtZipCode, "34231");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO3 quote screen <mtr5207>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr5207() {
		// Quote Policy Chevron information was filled here
		wait(1);
		sendText(policyChevron.btnNoEmailRadio, "AG1730");
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);

	}

	@When("User enters all required information on HO3 dwelling screen <mtr5207>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr5207() {
		// Quote Dwelling information was filled here
		wait(5);
		sendText(dwellingChevron.txtYearConstruction, "2020");
//		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		wait(5);
		driver.findElement(By.id("Building.RoofMaterial")).sendKeys("Metal");
//		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		wait(5);
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5207>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr5207()
			throws Exception {

		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		click(closeoutChevron.btnIssueNB);
		wait(3);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));
		wait(3);
		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		attachScreenShot(driver);
		wait(1);
		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr5207>")
	public void user_searches_policy_for_mtr5207() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@Then("User validates Water Non-Weather Builders base rate in Worksheets")
	public void User_validates_Water_Non_Weather_Builders_base_rate_in_Worksheets() throws Exception {

		scrollToElement(worksheetsChevron.HO3WNWBasePremium);
		click(worksheetsChevron.HO3WNWBasePremium);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "180.76");
		Hooks.scenario.log("Water Non-Weather Builders base rate displays as 180.76 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Fire or Lightning Builders base rate in Worksheets")
	public void User_validates_Fire_or_Lightning_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3FireLightningBasePremium);
		click(worksheetsChevron.HO3FireLightningBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "42.38");
		Hooks.scenario.log("Fire or Lightning Builders base rate displays as 42.38 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Liability Builders base rate in Worksheets")
	public void User_validates_Liability_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3LiabilityBasePremium);
		click(worksheetsChevron.HO3LiabilityBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "10.24");
		Hooks.scenario.log("Liability Builders base rate displays as 10.24 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Other Builders base rate in Worksheets")
	public void User_validates_Other_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3OtherBasePremium);
		click(worksheetsChevron.HO3OtherBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "34.39");
		Hooks.scenario.log("Other Builders base rate displays as 34.39 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Weather Builders base rate in Worksheets")
	public void User_validates_Weather_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3WeatherBasePremium);
		click(worksheetsChevron.HO3WeatherBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "126.71");
		Hooks.scenario.log("Weather Builders base rate displays as 126.71 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Theft Builders base rate in Worksheets")
	public void User_validates_Theft_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3TheftBasePremium);
		click(worksheetsChevron.HO3TheftBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "5.05");
		Hooks.scenario.log("Theft Builders base rate displays as 5.05 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates CGCC Builders base rate in Worksheets")
	public void User_validates_CGCC_Builders_base_rate_in_Worksheets() throws Exception {
		wait(1);
		scrollToElement(worksheetsChevron.HO3CGCCBasePremium);
		wait(1);
		click(worksheetsChevron.HO3CGCCBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "11.17");
		Hooks.scenario.log("CGCC Builders base rate displays as 11.17 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates Hurricane Builders base rate in Worksheets")
	public void User_validates_Hurricane_Builders_base_rate_in_Worksheets() throws Exception {
		scrollToElement(worksheetsChevron.HO3HurricaneBasePremium);
		click(worksheetsChevron.HO3HurricaneBasePremium);
		wait(1);

		verify_AnyfirstText_IsDisplayed(driver, "2075.07");
		Hooks.scenario.log("Hurricane Builders base rate displays as 2075.07 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates County factor in Worksheets")
	public void User_validates_County_factor_in_Worksheets() throws Exception {

		click(worksheetsChevron.HO3WNWBasePremium);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "0.823");
		Hooks.scenario.log("County factor rate displays as 0.823 successfully!");
		attachScreenShot(driver);
		wait(1);
	}

	@When("User clicks Policy File Chevron <mtr5207>")
	public void user_clicks_policy_file_chevron_mtr5207() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(2);
	}

	@When("User clicks New Business Package link <mtr5207>")
	public void user_clicks_new_business_package_link_mtr5207() throws Exception {
		click(policyFileChevron.btnNewBusinessPackage);
		wait(2);

	}

	@When("User validates AIIC FL HO3 ACB 02 22 ACB form displays")
	public void User_validates_AIIC_FL_HO3_ACB_02_22_ACB_form_displays() throws Exception {
		wait(15);
		
		switchToWindow(driver, "STFile&File");

		wait(15);

		NewBusiness_Form = PdfComparator.makePdf(driver, "New_Businnes_Declaration.pdf");

		// Save the pdf in local driver
		wait(30);
		PdfComparator.SavePdfForm(driver, FileLocation + NewBusiness_Form);

		wait(30);

		NewBusinnForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + NewBusiness_Form, 42, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, NewBusinnForm, "ACCREDITED BUILDER PROGRAM ENDORSEMENT");
		attachScreenShot(driver);
		wait(15);
		driver.switchTo().defaultContent();
		
	}

	@And("User enters Coverage A Dwelling as 550000")
	public void User_enters_Coverage_A_Dwelling_as_550000() {

		dwellingChevron.txtCoverageA.clear();
		sendText(dwellingChevron.txtCoverageA, "550000");

	}

	@When("User validates AIIC FL HO3 ACB 02 22 ACB form displays <mtr5207>")
	public void User_validates_AIIC_FL_HO3_ACB_02_22_ACB_form_displays_mtr5207() throws Exception {

		switchToWindow(driver, "STFile&File");

		wait(20);

		Renew_Form = PdfComparator.makePdf(driver, "New_Businnes_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Renew_Form);

		wait(45);

		RenewForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + Renew_Form, 42, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RenewForm, "ACCREDITED BUILDER PROGRAM ENDORSEMENT");
		attachScreenShot(driver);
		wait(1);
		driver.switchTo().defaultContent();
		
		
		 

	}

	@When("User clicks Renewal Decleration link <mtr5207>")
	public void user_clicks_renewal_decleration_link_mtr5207() throws Exception {
		click(policyFileChevron.btnRenewalDeclaration);
		wait(3);
	}

}
