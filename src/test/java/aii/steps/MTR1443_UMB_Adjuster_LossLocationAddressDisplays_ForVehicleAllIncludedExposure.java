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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR1443_UMB_Adjuster_LossLocationAddressDisplays_ForVehicleAllIncludedExposure extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime lossDate = currentDate.plusDays(10);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;
	static String AcknowledgementLetter_Form;
	static String AcknowledgementLetter_lookup;

	@When("User enters all required information on policy information screen <mtr1443>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1443() {

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

	@When("User enters UMB product selection information and current date as effective date")
	public void user_enters_umb_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
	}

	@When("User enters producer code and answers previous policy written with AIIG questions <mtr1443>")
	public void user_answers_previous_policy_written_with_aiig_questions_mtr1443() {
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(2);
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "No");
		selectDropdownText(policyChevron.ddAutoPolicy, "No");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		sendText(policyChevron.txtPhoneNumber, "8131111111");
		click(policyChevron.btnNoEmailRadio);
		wait(1);
		click(policyChevron.btnNext);
		wait(2);
	}

	@When("User enters all required information on UMB personal liability screen <mtr1443>")
	public void user_enters_all_required_information_on_umb_personal_liability_screen_mtr1443() {

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

	@When("User adds underlying policy in personal liability chevron <mtr1443>")
	public void user_adds_underlying_policy_in_personal_liability_chevron_mtr1443() throws InterruptedException {
		click(umbrellaChevron.btnAddPolicy);
		wait(2);
		selectDropdownText(umbrellaChevron.ddTypeOfPolicy, "Vehicle and all included exposures");
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingPolicyNumber, "AUTO3452145");
		sendText(umbrellaChevron.txtUnderlyingCarrierName, "Test Company");
		wait(3);
		driver.findElement(By.id("Location.UnderlyingCarrierName")).sendKeys(Keys.TAB); // added to avoid stale error on
																						// effective date object
		wait(3);
		sendText(umbrellaChevron.txtUnderlyingEffectiveDate, dtf.format(currentDate));
		wait(4);
		sendText(umbrellaChevron.txtUnderlyingExpirationDate, dtf.format(currentDate.plusDays(365)));
		wait(1);
		sendText(umbrellaChevron.txtUnderlyingCarrierName, "Test Company");
		click(dwellingChevron.btnSave);
		wait(3);

	}

	@When("User adds exposure to underlying auto policy")
	public void user_adds_exposure_to_underlying_auto_policy() throws Exception {
		clickOnAnyLink(driver, "Add Exposure");
		wait(1);
		selectDropdownText(umbrellaChevron.ddRiskExposureType, "Automobile");
		sendText(driver.findElement(By.id("GLClass.EYear")), "2019");
		sendText(driver.findElement(By.id("GLClass.EMake")), "Honda");
		sendText(driver.findElement(By.id("GLClass.EModel")), "Civic");
		sendText(driver.findElement(By.id("GLClass.EVehIdentificationNumber")), "VIN123123123");
		sendText(driver.findElement(By.id("GLClass.ECC")), "2500");
		sendText(driver.findElement(By.id("GLClass.UnderlyingCombinedSingleLimit")), "500000");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User clicks Next button and add driver information")
	public void user_clicks_next_button_and_add_driver_information() throws Exception {
		click(dwellingChevron.btnNext);
		wait(2);
		click(golfcartChevron.btnAddDriver);
		wait(2);
		sendText(driver.findElement(By.id("DriverInfo.LicenseDt")), "05/06/2019");
		sendText(golfcartChevron.txtLicenseNumber, "FLI5214");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates that UMB policy has been created successfully and takes note of the policy number <mtr1443>")
	public void user_validates_that_umb_policy_has_been_created_successfully_mtr1443() throws Exception {
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

	@When("User changes system date to loss date 'current date plus 10 days' <mtr1443>")
	public void user_changes_system_date_to_loss_date_mtr1443() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(lossDate));
	}

	@When("User searches for the umbrella policy number <mtr1443>")
	public void user_searches_umbrella_policy_for_mtr1443() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets loss date as loss date <mtr1443>")
	public void user_sets_loss_date_as_current_date_plus_10_days_mtr1443() {
		sendText(claim.txtLossDate, dtf.format(lossDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User completes all required information on claim chevron <mtr1443>")
	public void user_completes_all_reqiured_information_on_claim_chevron_mtr1443() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Loss Address verification");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User scrolls Property Information Field and validates entered information on UMB policy has been displayed")
	public void user_scrolls_property_information_field_and_does_validations() throws Exception {
		click(claim.lnkNotice);
		wait(2);
		scrollToAnyField(driver, "Property Information");
		verifyAnyDropdownDefaultedValue(driver, "Claim.RiskIdRef",
				"1 - Vehicle and all included exposures - 2019 Honda Civic");
		verify_AnyLabel_IsVisible(driver, "11216 SW Pembroke DR");
		verifyAnyTextboxAttributeValue(driver, "LossLocationAddr.City", "Port Saint Lucie");
		verifyAnyTextboxAttributeValue(driver, "LossLocationAddr.PostalCode", "34987");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks New Claimant And adds required information <mtr1443>")
	public void user_clicks_new_claimant_adds_information_mtr1443() throws Exception {
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
		sendText(claim.txtClaimantPhoneNumber, "7418529635");
		click(dwellingChevron.btnSave);
		wait(2);
		click(claim.lnkNotice);
		wait(2);
		click(driver.findElement(By.id("Complete")));
		wait(7);
	}

	@When("User clicks newly added claimant and adjusts reserves <mtr1443>")
	public void user_clicks_added_claimant_and_adjusts_reserves_mtr1443() throws Exception {
		click(claim.btnFinanctialActions2);
		click(claim.btnAdjustReserves2);
		wait(2);
		sendText(claim.txtIndemnityReserve, "3000");
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User clicks Policy File Chevron <mtr1443>")
	public void user_clicks_policy_file_chevron_mtr1443() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User clicks 'Acknowledment Letter' and validates form version <mtr1443>")
	public void user_clicks_acknowledment_letter_and_validates_form_version_mtr1443() throws Exception {
		PdfComparator.switchWindows(driver);
		clickOnAnyPolicyFileTabForm(driver, "Acknowledgement Letter");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");

		AcknowledgementLetter_Form = PdfComparator.makePdf(driver, "Acknowledgement_Letter.pdf");
		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + AcknowledgementLetter_Form);
		wait(8);

		// Garage Location lookup address
		AcknowledgementLetter_lookup = SmartPDFComparator2.getPDFtextByArea(FileLocation + AcknowledgementLetter_Form,
				1, 0, 0, 450, 350);
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "Location of Loss:");
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "11216 SW Pembroke DR");
		PdfComparator.verifyFormData(driver, AcknowledgementLetter_lookup, "Port Saint Lucie, FL 34987");
	}
	@When("User checks Deny Personal Umbrella Liability selection and enters loss date <mtr1443>")
	public void user_checks_deny_personal_umbrella_liability_selection_and_enters_loss_date_mtr1443() throws Exception {
		click(claim.rbReverseDenialUmbLiability);
		wait(1);
		sendText(claim.txtTransactionComment, "DenyDate_Feature_PUCov");
		sendText(claim.txtDenialDate, dtf.format(lossDate));
	}
}
