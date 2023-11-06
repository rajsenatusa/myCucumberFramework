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

public class MTR334_GOC_ValidateWhenCancellingAndReinstatIngThenCorrectReinstatementFormGenerates_CANCELLATION_REINSTATE
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String Con_Coverage_Form;
	static String Con_Coverage_Form_Version;
	static String Con_Coverage_Data;

	@When("User enters all required information on policy information screen <mtr334>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr334() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters GOC product selection information and current date minus <91> days as effective date")
	public void user_enters_goc_product_selection_information_and_currentdate_minus_91days_as_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate.minusDays(91)));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionGoc);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr334>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr334() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$100");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$100");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <mtr334>")
	public void user_enters_driver_information_on_driver_screen_mtr334() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <mtr334>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr334() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2019");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "GOC Make");
		sendText(golfcartChevron.txtGcModel, "GOC Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "4523");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User validates that GOC policy has been created successfully and takes note of the policy number <mtr334>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr334() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("GolfCart NB policy has been created successfully");
		} else {
			System.out.println("Golf Cart Policy Creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr334>")
	public void user_searches_policy_for_mtr334() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation")
	public void User_selects_cancellation() {
		selectDropdownText(dashboard.ddSelectTransaction, "Cancellation");
		wait(1);
		click(dashboard.btnSelect);
	}

	@And("User selects Substantial change in risk as reason")
	public void User_selects_reason() {
		selectDropdownText(historyChevron.ddReason, "Substantial change in risk");
		wait(2);
	}

	@And("User selects Loss meets policy limits as subreason")
	public void User_selects_subreason() throws Exception {
		wait(2);
		click(driver.findElement(By.xpath("//option[@value='Substantial change in risk; loss meets policy limits.']")));
		wait(1);
		setSubReason(driver, "Loss meets policy limits");
		wait(1);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects pro rate as cancel type and process transaction <mtr334>")
	public void User_selects_pro_rate_334() {
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
	}

	@And("User selects effective date as cancel date 'current date'")
	public void User_selects_effective_date_as_cancel_date() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
	}

	@When("User clicks Policy File Chevron <mtr334>")
	public void user_clicks_policy_file_chevron_mtr334() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User validates 'Continuation of Coverage' text has been displayed")
	public void user_validates_txt_has_been_displayed() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Continuation of Coverage");
	}

	@Then("User clicks 'Continuation of Coverage' link and validates form version 'AIIC GOC RI 12 16' and completes test")
	public void user_clicks_link_validates_form() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Continuation of Coverage");
		wait(7);
		switchToWindow(driver, "STFile&Filename");
		wait(2);
		Con_Coverage_Form = PdfComparator.getPolicyFileTabPdfName(driver, "Con_Coverage");
		PdfComparator.SavePdfForm(driver, FileLocation + Con_Coverage_Form);
		wait(8);
		Con_Coverage_Form_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + Con_Coverage_Form, 1, 470, 720,
				130, 50);
		PdfComparator.verifyFormData(driver, Con_Coverage_Form_Version, "AIIC GOC RI 12 16");

		Con_Coverage_Data = PdfComparator.getPDFData(FileLocation + Con_Coverage_Form);

		// Find the required text in a pdf
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "AIIC GOC RI 12 16");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, dtf.format(currentDate));
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data,
				"Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since");
		PdfComparator.verifyPDFText(driver, Con_Coverage_Data, "underwriting reason(s) met.");
		Hooks.scenario.log("PDF form Data :  " + Con_Coverage_Data);
		Hooks.scenario.log("Test Case Completed!");
	}

}
