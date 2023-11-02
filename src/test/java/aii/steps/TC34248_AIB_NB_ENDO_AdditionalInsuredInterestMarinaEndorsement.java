package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC34248_AIB_NB_ENDO_AdditionalInsuredInterestMarinaEndorsement extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorsementDate = currentDate.plusDays(10);
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String interestType[] = { "Select...", "Additional Insured", "Additional Interest(s)",
			"Additional Insured - Additional Owner", "Additional Interest - Lienholder", "Additional Interest - Lessor",
			"Additional Insured - Marina" };
	static String marinaForm;
	static String marinaForm_Data;
	static String application_Form;
	static String application_Form_FnE1;
	static String Dec_Form;
	static String Dec_Form_FnE1;
	static String nb_Form;
	static String nb_Form_FnE1;
	static String Marina_Version;

	@When("User enters all required information on policy information screen <tc34248>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34248() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "5908 N Ola Ave");
		sendText(quote.txtZipCode, "33604");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on AIB quote screen for <tc34248>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc34248() throws Exception {

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		// selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		getInsuranceScore(driver, "Do Not Use (No Score Ordered)");
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

	@When("User selects liability coverage on quote screen for <tc34248>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc34248() {

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

	@When("User adds operator information on quote screen <tc34248>")
	public void user_adds_operator_information_on_quote_screen_tc34248() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "MN456BI");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters all required information on AIB boat dwelling screen for <tc34248>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc34248() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		sendText(aibChevron.txtBoatModel, "Boat Model");
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
		selectDropdownText(aibChevron.ddBoatHullSettle, "No Coverage (Liability Only)");
		// selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(driver.findElement(By.id("Vehicle.Engine1Model")), "Engine");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");

		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");

		selectDropdownText(aibChevron.ddBahamasCoverage, "Yes");
		selectDropdownText(aibChevron.ddBahamasNavigation, "Yes");
		wait(1);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User clicks Additional Interest Chevron <tc34248>")
	public void user_clicks_Additional_Interest_Chevron_tc34248() {
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(2);
	}

	@When("User clicks Add Additional Interest button <tc34248>")
	public void user_clicks_add_additional_interest_button_tc34248() {
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
	}

	@And("User completes required information on add additional interests screen and add first mortgagee <tc34248>")
	public void User_completes_required_information_on_add_first_mortgagee_tc34248() throws Exception {
		sendText(additionalinterest.txtMortgageeCode, "10002");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		verifyAnyDropDownOptions(driver, interestType, "AI.InterestTypeCd");
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Marina");
		wait(1);
		verifyAnyDropdownDefaultedValue(driver, "AI.InterestFormCd", "Additional Insured(s) - Marina - AIICSBMAI0821");
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_0")).click(); // click boat interest
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver,
				"A Boat with an Additional Interest - Marina has been removed from the policy");

		driver.findElement(By.id("Wizard_Vehicles")).click(); // click vehicles tab
		verify_AnyText_IsVisible(driver,
				"Additional Insured-Marina requires that the Storage Location to be listed as Marina");
	}

	@When("User does necessary validations with different selections and checks required messages displayed in additional interest screen")
	public void user_does_necessary_validations_with_different_selections_and_checks_required_messages_displayed_in_additional_interest_screen()
			throws Exception {
		// Click on fix and verify Boat chevron will be displayed
		clickOnAnyLink(driver, "fix...");
		wait(4);
		verify_AnyLabel_IsVisible(driver, "Add Boat");

		driver.findElement(By.id("Wizard_Vehicles")).click(); // click vehicles tab
		// Edit and add the Marina storage
		clickonAnyButton(driver, "EditLink_1");
		wait(1);
		selectDropdownText(driver.findElement(By.id("Vehicle.BoatStorageLocation")), "Marina");
		sendText(driver.findElement(By.id("VehicleGarageAddr.Addr1")), "5908 N Ola Ave");
		sendText(driver.findElement(By.id("VehicleGarageAddr.PostalCode")), "33604");
		driver.findElement(By.id("VehicleGarageAddr.addrVerifyImg")).click();
		wait(6);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Save")).click();
		wait(5);
		verify_AnyText_NotVisible(driver,
				"Additional Insured-Marina requires that the Storage Location to be listed as Marina");

		driver.findElement(By.id("Wizard_AdditionalInterests")).click(); // click additional interests chevron
		wait(1);
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
		driver.findElement(By.id("NextPage")).click();
		wait(8);
		verify_AnyText_NotVisible(driver,
				"A Boat with an Additional Interest - Marina has been removed from the policy");
	}

	@When("User clicks Forms Chevron <tc34248>")
	public void user_clicks_forms_chevron_tc34248() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}

	@When("User validates all expected forms is visible on forms screen <tc34248>")
	public void user_validates_all_expected_Forms_is_visible_on_forms_screen_tc34248() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC SB MAI 08 21");
		verify_AnyText_IsVisible(driver, "08/21");
		verify_AnyText_IsVisible(driver, "Additional Insured(s) - Marina");
		verify_AnyfirstText_IsDisplayed(driver, "Delete");
		attachScreenShot(driver);
	}

	@When("User clicks AIIC SB MAI 08 21 form and validates form version")
	public void user_clicks_AIIC_SB_MAI_08_21_form_and_validates_version_tc34248() throws Exception {
		clickonAnyButton(driver, "AIICSBMAI0821_ViewForm");
		Thread.sleep(7000);
		switchToWindow(driver, "aiic-sb-mai-0821");
		marinaForm = PdfComparator.getPdfName(driver);
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + marinaForm);
		wait(10);
		marinaForm_Data = PdfComparator.getPDFData(FileLocation + marinaForm);
		PdfComparator.verifyPDFText(driver, marinaForm_Data, "AIIC SB MAI 08 21");
		PdfComparator.verifyPDFText(driver, marinaForm_Data, "MARINA AS ADDITIONAL INSURED");
	}

	@Given("User issues policy and close unnecessary tabs and taking note of the policy number <tc34248>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc34248() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
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

	@When("User clicks Policy File Chevron <tc34248>")
	public void user_clicks_policy_file_chevron_tc34248() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User clicks Small Boat Application Link and validates form version")
	public void user_clicks_Small_Boat_application_Link_and_validates_form_version() throws Exception {
		clickOnAnyLink(driver, "Small Boat Application");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		application_Form = PdfComparator.makePdf(driver, "Application.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + application_Form);
		wait(10);

		application_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 2, 20, 290, 560,
				220);
		PdfComparator.verifyFormData(driver, application_Form_FnE1, "AIIC SB MAI 08 21");
	}

	@When("User clicks Small Boat Declaration Link and validates form version")
	public void user_clicks_Small_Boat_Declaration_Link_and_validates_form_version() throws Exception {
		clickOnAnyLink(driver, "Small Boat Declaration");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		Dec_Form = PdfComparator.makePdf(driver, "Declaration.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + Dec_Form);
		wait(10);

		Dec_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + Dec_Form, 2, 30, 370, 560, 270);
		PdfComparator.verifyFormData(driver, Dec_Form_FnE1, "AIIC SB MAI 08 21");
	}

	@When("User clicks New Business Package Link and validates form version and marina letter")
	public void user_clicks_New_Business_Package_Link_and_validates_form_version_and_marina_letter() throws Exception {
		clickOnAnyLink(driver, "New Business Package");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		nb_Form = PdfComparator.makePdf(driver, "NBPackage.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + nb_Form);
		wait(10);

		nb_Form_FnE1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + nb_Form, 4, 30, 370, 560, 270);
		PdfComparator.verifyFormData(driver, nb_Form_FnE1, "AIIC SB MAI 08 21");

		// Marina letter
		Marina_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + nb_Form, 17, 0, 0, 610, 790);
		PdfComparator.verifyFormData(driver, Marina_Version, "AIIC SB MAI 08 21");
		PdfComparator.verifyFormData(driver, Marina_Version, "MARINA AS ADDITIONAL INSURED");

		PdfComparator.verifyFormData(driver, Marina_Version, "360 Mortgage Group LLC ISAOA");
		PdfComparator.verifyFormData(driver, Marina_Version, "PO BOX 2987");
		PdfComparator.verifyFormData(driver, Marina_Version, "Everett, WA 98213-0987");
		PdfComparator.verifyFormData(driver, Marina_Version, dtf.format(currentDate));
		PdfComparator.verifyFormData(driver, Marina_Version, "Additional Insured-Marina");
	}

	@When("User searches for the policy <tc34248>")
	public void user_searches_policy_for_tc34248() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects endorsement date as current date plus 10 days <tc34248>")
	public void user_selects_endorsement_date_as_current_date_plus_10_days_tc34248() {
		sendText(dashboard.txtSelectDate, dtf.format(endorsementDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User clicks Vehicles Tab and adds another boat")
	public void user_clicks_Vehicles_Tab_and_adds_another_boat() throws InterruptedException {

		driver.findElement(By.id("Wizard_Vehicles")).click(); // click vehicles tab
		Thread.sleep(500);
		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		sendText(aibChevron.txtBoatModel, "New Boat");
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
		selectDropdownText(aibChevron.ddBoatHullSettle, "No Coverage (Liability Only)");
		// selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(driver.findElement(By.id("Vehicle.Engine1Model")), "Engine");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");

		selectDropdownText(driver.findElement(By.id("Vehicle.BoatStorageLocation")), "Marina");
		sendText(driver.findElement(By.id("VehicleGarageAddr.Addr1")), "5908 N Ola Ave");
		sendText(driver.findElement(By.id("VehicleGarageAddr.PostalCode")), "33604");
		driver.findElement(By.id("VehicleGarageAddr.addrVerifyImg")).click();
		wait(6);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Save")).click();
		wait(5);
	}

	@When("User clicks Add Additional Interest button and add Marina as Additional Insured <tc34248>")
	public void user_clicks_add_additional_interest_button_and_add_Marina_as_Additional_Insured_tc34248()
			throws Exception {
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
		click(additionalinterest.btnAdditionalInterest);
		wait(2);
		sendText(additionalinterest.txtMortgageeCode, "10003");
		wait(1);
		additionalinterest.txtMortgageeCode.sendKeys(Keys.TAB);
		wait(1);
		selectDropdownText(additionalinterest.ddInterestType, "Additional Insured - Marina");
		wait(3);
		verifyAnyDropdownDefaultedValue(driver, "AI.InterestFormCd", "Additional Insured(s) - Marina - AIICSBMAI0821");
		clickonAnyButton(driver, "ContainerInd");
		driver.findElement(By.name("LinkReferenceInclude_1")).click();
		driver.findElement(By.xpath("//span[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Save")).click();
		wait(5);
	}

	@When("User finalizes transaction and completes endorsement <tc34248>")
	public void user_finalizes_transaction_and_completes_endorsement_tc34248() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(15);
		closeUnnecessaryTabs();
		clickApplicationTab(driver);
		wait(1);
	}

	@When("User validates AIIC SB MAI 08 21 is visible")
	public void user_validates_AIIC_MAI_08_21_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "AIIC SB MAI 08 21");
	}

	@When("User validates 'Marina Endorsement Package' and 'Additional Insured - Marina - Batch - PO BOX 7089 Westlake Village, CA 91359-7089' labels are visible")
	public void user_validates_Marina_endorsement_package_Labels_are_visible() throws Exception {
		clickonAnyButton(driver, "imgItem0000000000");
		Thread.sleep(500);
		verify_AnyLabel_IsVisible(driver, "Marina Endorsement Package");
		verify_AnyLabel_IsVisible(driver,
				"Additional Insured - Marina - Batch - PO BOX 7089 Westlake Village, CA 91359-7089");
		clickApplicationTab(driver);
		wait(1);
	}

	@When("User selects endorsement date as previous endorsement date plus 10 days <tc34248>")
	public void user_selects_endorsement_date_as_previous_endorsement_date_plus_10_days_tc34248() {
		sendText(dashboard.txtSelectDate, dtf.format(endorsementDate.plusDays(10)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User deletes one boat")
	public void user_deletes_one_boat() throws Exception {
		driver.findElement(By.id("Wizard_Vehicles")).click(); // click vehicles tab
		Thread.sleep(500);
		clickonAnyButton(driver, "DeleteLink_2");
		Thread.sleep(1000);
		sendText(driver.findElement(By.id("Vehicle.StatusComments")), "Deleting New boat");
		clickonAnyButton(driver, "Delete");
	}

	@When("User validates 'A Boat with an Additional Interest - Marina has been removed from the policy' text is visible")
	public void user_validates_A_Boat_with_an_Additional_Interest_Marina_has_been_removed_text_is_visible()
			throws Exception {
		verify_AnyText_IsVisible(driver,
				"A Boat with an Additional Interest - Marina has been removed from the policy");
	}

	@When("User finalizes transaction and validates boat removed message has been displayed")
	public void user_finalizes_transaction_and_validates_boat_removed_message_has_been_displayed() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		verify_AnyText_IsVisible(driver,
				"A Boat with an Additional Interest - Marina has been removed from the policy");
	}

	@When("User clicks Modify Application")
	public void user_clicks_Modify_Application() throws Exception {
		driver.findElement(By.id("MakeChanges")).click();
		wait(1);
	}

	@When("User deletes related Additional Insured Marina")
	public void user_deletes_related_Additional_Insured_Marina() throws Exception {
		clickonAnyButton(driver, "AIList_2_Delete");
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
		verify_AnyText_NotVisible(driver,
				"A Boat with an Additional Interest - Marina has been removed from the policy");
	}

	@When("User validates 'Marina Endorsement Package' labels is not visible anymore")
	public void user_validates_Marina_EN_Package_is_NOT_visible() throws Exception {
		clickonAnyButton(driver, "imgItem0000000000");
		Thread.sleep(500);
		verify_AnyText_NotVisible(driver, "Marina Endorsement Package");
		attachScreenShot(driver);
	}

	@When("User selects endorsement date as previous endorsement date plus 15 days <tc34248>")
	public void user_selects_endorsement_date_as_previous_endorsement_date_plus_15_days_tc34248() {
		sendText(dashboard.txtSelectDate, dtf.format(endorsementDate.plusDays(15)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User validates 'Additional Interest - Marina does not have an active interest in one or more boats' message not visible")
	public void user_validates_Marina_does_notHave_Active_interest_in_boats_is_NOT_visible() throws Exception {
		clickonAnyButton(driver, "AIList_1_Change");
		Thread.sleep(1000);
		clickonAnyButton(driver, "LinkReferenceInclude_0");
		Thread.sleep(500);
		click(dwellingChevron.btnSave);
		wait(3);

		verify_AnyText_IsVisible(driver,
				"Additional Interest - Marina does not have an active interest in one or more boats");
		clickonAnyButton(driver, "AIList_1_Delete");
		driver.findElement(By.id("dialogOK")).click();
		wait(1);
		verify_AnyText_NotVisible(driver,
				"Additional Interest - Marina does not have an active interest in one or more boats");
	}

	@When("User finalizes transaction and validates marina does not have active interest message has been displayed")
	public void user_finalizes_transaction_and_validates_marina_Doesnot_have_active_interest_message_has_been_displayed()
			throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		verify_AnyText_NotVisible(driver,
				"Additional Interest - Marina does not have an active interest in one or more boats");
	}

	@Then("User process endorsement and completes test <tc34248>")
	public void user_process_endorsement_and_completes_test_tc34248() throws Exception {

		click(reviewChevron.btnProcess);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
