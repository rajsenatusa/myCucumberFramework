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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MTR373_AIB_ValidateUpdatedMailingAddressDisplaysonDecPage_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String applicationNumber;
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String application_Form;
	static String application_Form_FnE1;
	static String Dec_Form;
	static String Dec_Form_FnE1;
	static String nb_Form;
	static String nb_Form_FnE1;
	static String EndPack_Form;
	static String EndPack_Form_FnE1;
	static String EndPack2_Form;
	static String EndPack2_Form_FnE1;

	
	@When("User enters AIB product selection information and current date as effective date")
	public void user_enters_aib_product_selection_information_and_current_date_as_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);
	}
	@When("User enters all required information on policy information screen <tc37260>")
	public void user_enters_all_required_information_on_policy_information_screen_tc37260() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User adds operator information on quote screen <tc37260>")
	public void user_adds_operator_information_on_quote_screen_tc37260() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "Y123101952915");
		selectDropdownText(aibChevron.ddBoatExperience, "4");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);

	}
	@When("User enters all required information on AIB quote screen for <tc37260>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc37260() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 5);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects liability coverage on quote screen for <tc37260>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc37260() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$100,000/$300,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "No Coverage");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "Yes");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "60 days");
		click(dwellingChevron.btnSave);
		wait(5);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on AIB boat dwelling screen for <tc37260>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc37260() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, "1548799652");
		selectDropdownText(aibChevron.ddBoatMake, "Bayliner");
		sendText(aibChevron.txtBoatModel, "Testing");
		sendText(aibChevron.txtBoatPurchDate, dtf.format(currentDate));
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, "42500");
		selectDropdownText(aibChevron.ddBoatHullType, "Cruiser");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "26");
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, "Outboard");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "60 or less mph");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User takes note of the application for <tc37260>")
	public void user_takes_note_of_the_application__number_for_tc37260() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc37260>")
	public void user_searches_application_for_tc37260() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}

	@Given("User issues policy and close unnecessary tabs and taking note of the policy number")
	public void user_issues_policy_and_close_unnecessary_tabs() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("AIB NB policy has been created successfully");
		} else {
			System.out.println("AIB policy creation failed!");
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

	@When("User clicks Policy File Chevron <tc37260>")
	public void user_clicks_policy_file_chevron_tc37260() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Small Boat Application link and validates form version of Application")
	public void user_clicks_small_boat_application_link_and_validates_form_version_of_application() throws Exception {
		clickOnAnyLink(driver, "Small Boat Application");
		wait(7);
		switchToWindow(driver, "STFile&File");
		application_Form = PdfComparator.makePdf(driver, "Application.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + application_Form);
		wait(10);

		application_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 1, 20, 200, 280,
				120);
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "Davenport, FL 33837-3688");
	}

	@When("User clicks Small Boat Declaration link and validates form version of Declaration")
	public void user_clicks_small_boat_declaration_link_and_validates_form_version_of_declaration() throws Exception {
		// Verify Form version of Declaration
		clickOnAnyLink(driver, "Small Boat Declaration");
		wait(7);
		switchToWindow(driver, "STFile&File");
		Dec_Form = PdfComparator.makePdf(driver, "Declaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Dec_Form);
		wait(10);

		Dec_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Dec_Form, 1, 20, 200, 280, 120);
		PdfComparator.verifyFormData(driver, Dec_Form_FnE1, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, Dec_Form_FnE1, "Davenport, FL 33837-3688");
	}

	@When("User clicks New Business Package link and validates form version of NB")
	public void user_clicks_new_business_package_link_and_validates_form_version_of_NB() throws Exception {
		clickOnAnyLink(driver, "New Business Package");
		wait(7);
		switchToWindow(driver, "STFile&File");
		nb_Form = PdfComparator.makePdf(driver, "NBPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + nb_Form);
		wait(10);

		nb_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + nb_Form, 3, 20, 200, 280, 120);
		PdfComparator.verifyFormData(driver, nb_Form_FnE1, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, nb_Form_FnE1, "Davenport, FL 33837-3688");
	}

	@And("User clicks more button and starts endorsement and selects current date plus <5> days as eff date and starts")
	public void User_clicks_endorse_button() {
		click(dwellingChevron.btnMore);
		click(dwellingChevron.btnStartTransaction);
		wait(3);
		selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
		wait(1);
		click(dashboard.btnSelect);
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(5)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@And("User changes mailing address and finalizes endorsement")
	public void User_changes_mailing_address_and_finalizes_endorsement() {
		sendText(policyChevron.txtMailingAddress, "11256 SW 62nd Avenue RD");
		sendText(policyChevron.txtMailingAddPostalCode, "34476");
		click(policyChevron.btnMailingAddressVerifyAddress);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(5);
		click(reviewChevron.btnFinalize);
		wait(5);
		click(closeoutChevron.btnEndorsePolicy);
		wait(7);
		closeUnnecessaryTabs();
	}

	@When("User clicks Endorsement Package link and validates form version of Endorsement")
	public void user_clicks_endorsement_link_and_validates_form_version_of_endorsement() throws Exception {
		clickOnAnyLink(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");
		EndPack_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPack_Form);
		wait(10);

		EndPack_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPack_Form, 1, 20, 200, 280, 120);
		PdfComparator.verifyFormData(driver, EndPack_Form_FnE1, "11256 SW 62nd Avenue Rd");
		PdfComparator.verifyFormData(driver, EndPack_Form_FnE1, "Ocala, FL 34476-4750");
	}

	@And("User changes mailing address second time and finalizes endorsement")
	public void User_changes_mailing_address_second_time_and_finalizes_endorsement() {
		sendText(policyChevron.txtMailingAddress, "6356 SW 103rd Street Rd");
		sendText(policyChevron.txtMailingAddPostalCode, "34476");
		click(policyChevron.btnMailingAddressVerifyAddress);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(5);
		click(reviewChevron.btnFinalize);
		wait(5);
		click(closeoutChevron.btnEndorsePolicy);
		wait(7);
		closeUnnecessaryTabs();
	}

	@When("User clicks Endorsement Package link and validates form version of Endorsement with new address and completes test")
	public void user_clicks_endorsement_link_and_validates_form_version_of_endorsement_and_completes_test()
			throws Exception {
		clickOnAnyLink(driver, "Endorsement Package");
		wait(7);
		switchToWindow(driver, "STFile&File");
		EndPack2_Form = PdfComparator.makePdf(driver, "EndorsementPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + EndPack2_Form);
		wait(10);

		EndPack2_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + EndPack2_Form, 1, 20, 200, 280, 120);
		PdfComparator.verifyFormData(driver, EndPack2_Form_FnE1, "6356 SW 103rd Street Rd");
		PdfComparator.verifyFormData(driver, EndPack2_Form_FnE1, "Ocala, FL 34476-9254");

		Hooks.scenario.log("Test Case Completed!");
	}
}
