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

public class MTR1441_UMB_Adjuster_LossLocationAddressDisplays_GaragingAddress extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime lossDate = currentDate.plusDays(10);
	static String GOC_Policy;
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AcknowledgementLetter_Form;
	static String AcknowledgementLetter_lookup;

	
	@When("User enters all required information on policy information screen <mtr1441>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1441() {

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

	@When("User enters GOC product selection information and current date as effective date <mtr1441>")
	public void user_enters_goc_product_selection_information_and_currentdate_as_effective_date_mtr1441() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionGoc);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr1441>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr1441() {

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

	@When("User enters driver information on driver screen <mtr1441>")
	public void user_enters_driver_information_on_driver_screen_mtr1441() {

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

	@When("User enters vehicles information on vehicles screen <mtr1441>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr1441() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2020");
		sendText(golfcartChevron.txtGcVinNumber, "458TK8JJI77");
		sendText(golfcartChevron.txtGcMake, "GOC Make");
		sendText(golfcartChevron.txtGcModel, "GOC Model");
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

	@When("User issues policy and makes payment <mtr1441>")
	public void user_issues_policy_and_do_payment_mtr1441() {

		// make cc payment
		selectDropdownText(closeoutChevron.ddPaymentType, "Credit Card");
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		// issue policy
		wait(5);
		click(closeoutChevron.btnIssueNB);
		wait(5);
	}

	@When("User validates that GOC policy has been created successfully and takes note of the policy number <mtr1441>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr1441() throws Exception {

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
			GOC_Policy = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + GOC_Policy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User enters all required information on UMB personal liability screen <mtr1441>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_mtr1441() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, "1,000,000");
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, "0");
		sendText(umbrellaChevron.txtNumberOfAuto, "1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(umbrellaChevron.ddLiabilityResidenceAtLeast500k, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User adds underlying policy in personal liability chevron <mtr1441>")
	public void user_adds_underlying_policy_in_personal_liability_chevron_mtr1441() {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Recreational Vehicle");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, GOC_Policy);
		wait(5);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(umbrellaChevron.ddSelectPolicyWithAI, "Yes");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User validates that UMB policy has been created successfully and takes note of the policy number <mtr1441>")
	public void user_validates_that_umb_policy_has_been_created_successfully_mtr1441() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
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

	@When("User changes system date to loss date 'current date plus 10 days'")
	public void user_changes_system_date_to_loss_date() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(lossDate));
	}

	@When("User searches for the umbrella policy number <mtr1441>")
	public void user_searches_umbrella_policy_for_mtr1441() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets loss date as loss date")
	public void user_sets_loss_date_as_current_date_plus_10_days() {
		sendText(claim.txtLossDate, dtf.format(lossDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User completes all required information on claim chevron <mtr1441>")
	public void user_completes_all_reqiured_information_on_claim_chevron_mtr1441() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Loss Address verification");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User scrolls Property Information Field and validates entered information on GOC policy has been displayed")
	public void user_scrolls_property_information_field_and_does_validations() throws Exception {
		click(claim.lnkNotice);
		wait(2);
		scrollToAnyField(driver, "Property Information");
		verifyAnyDropdownDefaultedValue(driver, "Claim.RiskIdRef",
				"1 - Recreational Vehicle - 2020 Golf Make Golf Model");
		verify_AnyLabel_IsVisible(driver, "11256 SW 62nd Avenue Rd");
		verifyAnyTextboxAttributeValue(driver, "LossLocationAddr.City", "Ocala");
		verifyAnyTextboxAttributeValue(driver, "LossLocationAddr.PostalCode", "34476");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks New Claimant And adds required information <mtr1441>")
	public void user_clicks_new_claimant_adds_information_mtr1441() throws Exception {
		click(claim.btnNewClaimant);
		wait(2);
		selectDropdownText(claim.ddClaimantType, "Third Party");
		wait(1);
		selectDropdownText(claim.ddClaimantSubType, "Employee");
		sendText(claim.txtClaimantFirstName, "Insured");
		sendText(claim.txtClaimantLastName, "Umbrella");
		click(claim.btnReset);
		driver.findElement(By.xpath("(//*[@id='Reset'])[2]")).click();
		sendText(claim.txtClaimantAddress, "11256 SW 62nd Avenue RD");
		sendText(claim.txtClaimantCity, "Ocala");
		selectDropdownText(claim.ddClaimantState, "Florida");
		sendText(claim.txtClaimantZipCode, "34476");
		click(claim.btnClaimantVerifyAddress);
		wait(1);
		selectDropdownText(claim.ddClaimantPhoneType, "Mobile");
		sendText(claim.txtClaimantPhoneNumber, "8131111111");
		click(dwellingChevron.btnSave);
		wait(2);
		click(claim.lnkNotice);
		wait(2);
		click(driver.findElement(By.id("Complete")));
		wait(7);
	}

	@When("User clicks Policy File Chevron <mtr1441>")
	public void user_clicks_policy_file_chevron_mtr1441() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User clicks 'Acknowledment Letter' and validates form version")
	public void user_clicks_acknowledment_letter_and_validates_form_version() throws Exception {
		// Verify form versions in Endorsement Package

		PdfComparator.switchWindows(driver);
		clickOnAnyPolicyFileTabForm(driver, "Acknowledgement Letter");
		wait(10);
		switchToWindow(driver, "STFile&File");

		AcknowledgementLetter_Form = PdfComparator.makePdf(driver, "Acknowledgement_Letter.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + AcknowledgementLetter_Form);
		wait(10);

		// Garage Location lookup address
		AcknowledgementLetter_lookup = SmartPDFComparator2.getPDFtextByArea(FileLocation + AcknowledgementLetter_Form,
				1, 0, 0, 450, 350);
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "Location of Loss:");
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "11256 SW 62nd Avenue Rd");
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "Ocala, FL 34476");
	}

	@When("User clicks Claim Tab")
	public void user_clicks_claim_tab() throws Exception {
		clickonAnyButton(driver, "Tab_Claim");
		switchToWindow(driver, "STFile&File");
	}

	@When("User clicks Financial Actions Button")
	public void user_clicks_financial_actions_button() throws Exception {
		click(claim.btnFinanctialActions2);
		wait(1);
	}

	@When("User clicks Deny")
	public void user_clicks_deny() throws Exception {
		click(claim.btnDeny2);
		wait(3);
	}

	@When("User checks Deny Personal Umbrella Liability selection and enters loss date")
	public void user_checks_deny_personal_umbrella_liability_selection_and_enters_loss_date() throws Exception {
		click(claim.rbReverseDenialUmbLiability);
		wait(1);
		sendText(claim.txtTransactionComment, "DenyDate_Feature_PUCov");
		sendText(claim.txtDenialDate, dtf.format(lossDate));
	}

	@When("User clicks Deny button and validates 'Open - Denied' label is visible")
	public void user_clicks_deny_button_and_validates_label_visible() throws Exception {
		click(claim.btnSave);
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Open - Denied");
	}

	@When("User finalizes transaction and process and complete test")
	public void user_finalizes_transaction_and_completes_test() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(3);
		Hooks.scenario.log("Test Case Completed!");
	}

}
