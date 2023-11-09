package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC17316_GOC_Agent_NB_END_IncorrectGaragingLocationOnDecPage extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String NBPackage_Form;
	static String nb_DecPage;
	static String NBGOCEnd_Version;
	static String NBGOCEnd_Data;
	static String NBGOCEnd_Name;
	static String App_Form;
	static String Garage_lookup;
	static String EndPackage_Form;
	static String EndGarage_lookup;

	@When("User searches Agent AG1730")
	public void user_searches_agent_ag1730() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG1730");
		wait(1);
	}

	@When("User switches as yes for the attribute of 'Golf Cart - Allowed To Add Gold Endorsement'")
	public void user_switches_as_yes_for_the_attribute_of_allow_golf_cart_endorsement() {
		scrollToElement(userLookup.txtAllowedToAddGolfEndorsement);
		sendText(userLookup.txtAllowedToAddGolfEndorsement, "Yes");
	}

	@When("User enters GOC product selection information and current date as effective date")
	public void user_enters_goc_product_selection_information_and_currentdate_as_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionGoc);
	}

	@When("User enters all required information on GOC golfcart screen for <tc17316>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_tc17316() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$2,500");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$20,000/$40,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$500");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$500");
		wait(1);
		click(golfcartChevron.btnGoldReservePackage);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <tc17316>")
	public void user_enters_driver_information_on_driver_screen_tc17316() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <tc17316>")
	public void user_enters_vehicles_information_on_vehicles_screen_tc17316() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2020");
		sendText(golfcartChevron.txtGcVinNumber, "458TK8JJI77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "5350");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		sendText(golfcartChevron.txtGaragingAddress, "11256 SW 62nd Avenue RD Ocala");
		sendText(golfcartChevron.txtGaragingZipCode, "34476");
		click(golfcartChevron.btnVerifyAddress);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User enters all required information on policy information screen <tc17316>")
	public void user_enters_all_required_information_on_policy_information_screen_tc17316() {

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

	@When("User validates that GOC policy has been created successfully and takes note of the policy number")
	public void user_validates_that_goc_policy_has_been_created_successfully() throws Exception {

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

	@When("User clicks Policy File Chevron <tc17316>")
	public void user_clicks_policy_file_chevron_tc17316() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks New Business Package link and validates form versions in NB Package")
	public void user_clicks_nb_package_link_and_validates_forms() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		NBPackage_Form = PdfComparator.makePdf(driver, "NewBusinessPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + NBPackage_Form);
		wait(8);
	}

	@When("User validates form information in declaration page and golf gold endorsement page")
	public void user_validates_form_information_in_declaration_page() throws Exception {
		// Dec page
		nb_DecPage = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 6, 0, 0, 690, 710);
		PdfComparator.verifyFormData(driver, nb_DecPage, "AIIC GOC GOLD 09 20");

		// Golf Gold Endorsement form
		NBGOCEnd_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + NBPackage_Form, 25, 55, 755, 100, 30);
		PdfComparator.verifyFormData(driver, NBGOCEnd_Version, "AIIC GOC GOLD 09 20");

		NBGOCEnd_Data = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBGOCEnd_Data, "AIIC GOC GOLD 09 20");
		String NBGOCEnd_Name = PdfComparator.getPDFData(FileLocation + NBPackage_Form);
		PdfComparator.verifyPDFText(driver, NBGOCEnd_Name, "GOLF CART GOLD ENDORSEMENT");
	}

	@When("User clicks Application Link and validates form versions in Application Package")
	public void user_clicks_application_link_and_validates_form_versions_in_application_package() throws Exception {
		
		// Application form
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		wait(7);
		switchToWindow(driver, "STFile&File");

		App_Form = PdfComparator.makePdf(driver, "Application.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + App_Form);
		wait(7);
		// Garage Location lookup address
		Garage_lookup = SmartPDFComparator2.getPDFtextByArea(FileLocation + App_Form, 1, 50, 340, 400, 150);
		PdfComparator.verifyFormData(driver, Garage_lookup, "Garaging Location:");
		PdfComparator.verifyFormData(driver, Garage_lookup, "11256 SW 62nd Avenue Rd");
		PdfComparator.verifyFormData(driver, Garage_lookup, "Ocala, FL 34476-4750");

		PdfComparator.verifyFormData(driver, Garage_lookup, "Garaging Location:");
		PdfComparator.verifyFormData(driver, Garage_lookup, "11256 SW 62nd Avenue Rd");
		PdfComparator.verifyFormData(driver, Garage_lookup, "Ocala, FL 34476-4750");

	}

	@When("User clicks Vehicles Tab and remove vehicle garaging address information")
	public void user_clicks_vehicles_tab_and_remove_vehicle_garaging_address() throws Exception {
		click(driver.findElement(By.id("Wizard_Vehicles")));
		wait(3);
		click(driver.findElement(By.id("EditLink_1")));
		wait(1);

		sendText(golfcartChevron.txtGaragingAddress, "");
		sendText(golfcartChevron.txtGarageAddCity, "");
		sendText(golfcartChevron.txtGaragingZipCode, "");
		selectDropdownText(golfcartChevron.ddGarageAddCounty, "Select One");
		selectDropdownText(golfcartChevron.ddGarageAddState, "Select...");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and clicks process <tc17316>")
	public void user_finalizes_transaction_and_clicks_process_tc17316() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(4);
		click(closeoutChevron.btnEndorsePolicy);
		wait(7);
		closeUnnecessaryTabs();
		clickApplicationTab(driver);
		wait(2);
	}

	@Then("User clicks Endorsement Package link and validates form versions in Endorsement Package and completes test")
	public void user_clicks_endorsement_package_link_and_validates_forms() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");

		EndPackage_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPackage_Form);
		wait(8);

		// Garage Location lookup address
		EndGarage_lookup = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPackage_Form, 1, 50, 340, 400, 150);
		PdfComparator.verifyFormData(driver, EndGarage_lookup, "Garaging Location:");
		PdfComparator.verifyFormData(driver, EndGarage_lookup, "11216 SW Pembroke DR");
		PdfComparator.verifyFormData(driver, EndGarage_lookup, "Port Saint Lucie, FL 34987-1953");

		Hooks.scenario.log("Test Case Completed!");
	}

	@When("User searches for the policy number <tc17316>")
	public void user_searches_policy_for_tc17316() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
}
