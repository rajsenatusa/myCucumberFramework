package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR2464_DP3_IntegritySelect_ValidateClaimAccordPropertyLossNoticeFormwithAllCoverages_Claim
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorseDate = currentDate.plusDays(10);
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;
	static String lossNum;
	static String claimNum;
	static String WBU_reserve;
	static String CovC_reserve;
	static String AL_reserve;
	static String CovL_reserve;
	static String PI_reserve;
	static String LNForm;
	static String LN_Content;

	@When("User enters all required information on policy information screen <mtr2464>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2464() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "438 Riggs Cir.");
		sendText(quote.txtZipCode, "33897");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters DP3 product selection information and effective date as current date <mtr2464>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_mtr2464() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr2464>")
	public void user_enters_all_current_date_as_prior_date_mtr2464() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			click(policyChevron.btnNext);
			wait(3);
			sendText(dwellingChevron.txtSquareFeet, "2500");
			sendText(dwellingChevron.txtYearConstruction, currentYear);
		} catch (Exception e) {
			acceptAlert();
			sendText(dwellingChevron.txtSquareFeet, "2500");
			sendText(dwellingChevron.txtYearConstruction, currentYear);
		}
	}

	@When("User enters all required information on DP3 dwelling screen and selects integrity package and adds optional coverages<mtr2464>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr2464() {

		
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "3 mi to less than 4 mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.rbIntegritySelectPackage);
		wait(1);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$300,000");
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$100,000");
		click(dwellingChevron.rbPersonalInjury);
		
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.rbWaterDamageLimited);
		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User answers all underwriting questions for DP3 <mtr2464>")
	public void user_answers_all_underwriting_questions_for_dp3_mtr2464() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		fillDP3_UWQuestions();
		wait(1);
	}

	@And("User updates plumbing,electrical,hvac,roof years as current year <mtr2464>")
	public void User_updates_plumbing_electrical_hvac_years_as_current_year_mtr2464() {

		click(dwellingChevron.btnDwelling);
		wait(2);
		sendText(dwellingChevron.txtHvacYearUpdate, currentYear);
		sendText(dwellingChevron.txtYearElectrical, currentYear);
		sendText(dwellingChevron.txtPlumbingYearUpdate, currentYear);
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		click(dwellingChevron.btnSave);
		wait(3);
		dismissAlert();
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");

		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
	}

	@When("User finalizes transaction for <mtr2464>")
	public void user_finalizes_transaction_for_mtr2464() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <mtr2464>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_mtr2464()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User changes system date to current date plus <10> days <mtr2464>")
	public void user_changes_system_date_current_date_plus_10_days_mtr2464() throws Exception {
		ChangeDate_Admin(driver, dtf.format(endorseDate));
		wait(1);
	}

	@When("User searches for the policy <mtr2464>")
	public void user_searches_policy_for_mtr2464() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets loss date as current date plus <10> days <mtr2464>")
	public void user_sets_loss_date_as_current_date_plus_10_days_mtr2464() {
		sendText(claim.txtLossDate, dtf.format(endorseDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as Water Damage <mtr2464>")
	public void user_selects_loss_cause_as_Water_Damage_mtr2464() throws Exception {
		selectDropdownText(claim.ddLossCause, "Water Damage");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User selects sub loss cause as Sewer Back Up and completes required information <mtr2464>")
	public void user_selects_sub_loss_cause_as_Sewer_Back_Up_and_completes_required_information_mtr2464()
			throws Exception {
		selectDropdownText(claim.ddSubLossCause, "Sewer Back Up");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		selectDropdownText(claim.ddSourceOfWaterIdentified, "No");
		selectDropdownText(claim.ddWasSourceStopped, "Unknown");
		selectDropdownText(claim.ddStandingWaterInHome, "Unknown");
		selectDropdownText(claim.ddMoldIsPresent, "Unknown");
		selectDropdownText(claim.ddEstimatedAmountOfDamage, "Less than 25%");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		wait(1);
		sendText(claim.txtClaimDescription, "Test");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User clicks Complete and takes note of the claim number <mtr2464>")
	public void user_clicks_complete_takes_notes_mtr2464() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User starts Transaction on Claims Chevron")
	public void user_starts_transaction_on_claims_chevron() throws Exception {
		startTransaction(driver);
		wait(2);
	}

	@When("User adjust reserves and do UI validations <mtr2464>")
	public void user_adjust_reserves_and_do_UI_validations_mtr2464() throws Exception {
		// Click Claims Icon1
		try {
			Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(driver.findElement(By.id("ClaimantActionsMenu_1"))).click().build().perform();
			Hooks.scenario.log("Claims Action Menu Icon 1 clicked");
		} catch (Exception e) {
			Hooks.scenario.log("Claims Action Menu Icon 1 NOT clicked");
			wait(5);
		}

		// click Adjust Reserves
		waitForClickability(driver.findElement(By.id("AdjustReserve_1")));
		moveToElement(driver.findElement(By.id("AdjustReserve_1")));
		click(driver.findElement(By.id("AdjustReserve_1")));
		wait(2);
		clickonAnyButton(driver, "ShowAvailableInd");

		WBU_reserve = getTextOfElement(driver, "FeatureLimit_CovA_WBU_1");
		expectedValue_foundValue(driver, "5,000", WBU_reserve);
		CovC_reserve = getTextOfElement(driver, "FeatureLimit_CovC_1");
		expectedValue_foundValue(driver, "100,000", CovC_reserve);
	}

	@When("User sets CovA Scheduled Limit as <200> CovC Personal Property Scheduled Item as <3000> and finalize and process transaction")
	public void user_sets_CovA_Scheduled_Limit_as_200_CovC_Personal_Property_Scheduled_Item_as_3000_And_finalize_and_process_transaction()
			throws Exception {
		sendText(claim.txtCovAWBUScheduledItemLimit, "200");
		sendText(claim.txtCovCPersonalPropertyScheduledItemLimit, "3000");
		click(dwellingChevron.btnSave);
		wait(3);
		attachScreenShot(driver);
		driver.findElement(By.id("Closeout")).click();
		clickProcess(driver);
	}

	@When("User adjust recoveries and do UI validations <mtr2464>")
	public void user_adjust_recoveries_and_do_UI_validations_mtr2464() throws Exception {
		// Click Claims Icon1
		try {
			Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(driver.findElement(By.id("ClaimantActionsMenu_1"))).click().build().perform();
			Hooks.scenario.log("Claims Action Menu Icon 1 clicked");
		} catch (Exception e) {
			Hooks.scenario.log("Claims Action Menu Icon 1 NOT clicked");
			wait(5);
		}

		// click Adjust Recoveries
		waitForClickability(driver.findElement(By.id("AdjustRecovery_1")));
		moveToElement(driver.findElement(By.id("AdjustRecovery_1")));
		click(driver.findElement(By.id("AdjustRecovery_1")));
		wait(2);
		clickonAnyButton(driver, "img1000");
		wait(1);
		clickonAnyButton(driver, "img1012");
		wait(1);
		verify_AnyText_IsVisible(driver, "Water Back Up and Sump Overflow");
		verify_AnyText_IsVisible(driver, "C-Personal Property");

		driver.findElement(By.id("Return")).click();
		wait(2);
	}

	@When("User Adds New Claimant as Third Party Employee <mtr2464>")
	public void user_Adds_New_Claimant_as_Third_Party_Employee_mtr2464() throws Exception {
		clickOnAnyLink(driver, "Add Claimant");
		click(claim.btnNewClaimant);
		wait(1);
		selectDropdownText(claim.ddClaimantType, "Third Party");
		wait(2);
		selectDropdownText(claim.ddClaimantSubType, "Employee");
		sendText(claim.txtClaimantFirstName, "Insured");
		sendText(claim.txtClaimantLastName, "Dwelling");
		driver.findElement(By.name("Reset")).click();
		driver.findElement(By.xpath("(//*[@id='Reset'])[2]")).click();
		sendText(claim.txtClaimantAddress, "11256 SW 62nd Avenue RD");
		sendText(claim.txtClaimantCity, "Ocala");
		selectDropdownText(claim.ddClaimantState, "Florida");
		sendText(claim.txtClaimantZipCode, "34476");
		wait(1);
		selectDropdownText(claim.ddClaimantPhoneType, "Mobile");
		sendText(claim.txtClaimantPhoneNumber, "7418529635");
		click(dwellingChevron.btnSave);
		wait(2);
		attachScreenShot(driver);
		driver.findElement(By.id("Return")).click();
		wait(2);
		// driver.findElement(By.id("Closeout")).click(); // finalize transaction
		// clickProcess(driver);
	}

	@When("User adjust reserves 2 and do UI validations <mtr2464>")
	public void user_adjust_reserves_2_and_do_UI_validations_mtr2464() throws Exception {

		// Click Claims Icon2
		try {
			Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(driver.findElement(By.id("ClaimantActionsMenu_2"))).click().build().perform();
			Hooks.scenario.log("Claims Action Menu Icon 2 clicked");
		} catch (Exception e) {
			Hooks.scenario.log("Claims Action Menu Icon 2 NOT clicked");
			wait(5);
		}

		// click Adjust Reserves
		waitForClickability(driver.findElement(By.id("AdjustReserve_2")));
		moveToElement(driver.findElement(By.id("AdjustReserve_2")));
		click(driver.findElement(By.id("AdjustReserve_2")));
		wait(2);

		AL_reserve = getTextOfElement(driver, "FeatureLimit_CovL_ANL_1");
		expectedValue_foundValue(driver, "100,000", AL_reserve);
		CovL_reserve = getTextOfElement(driver, "FeatureLimit_CovL_COVLSUB_1");
		expectedValue_foundValue(driver, "300,000", CovL_reserve);
		PI_reserve = getTextOfElement(driver, "FeatureLimit_CovL_PNJ_1");
		expectedValue_foundValue(driver, "300,000", PI_reserve);
	}

	@When("User sets CovL Animal Liability Scheduled Item Limit as <3000> CovL Personal Injury Scheduled Item Limit as <2000> and finalize and process transaction")
	public void user_sets_CovL_Animal_Scheduled_Liability_Limit_as_3000_CovL_Personal_Injury_Scheduled_Item_Limit_as_2000()
			throws Exception {
		sendText(driver.findElement(By.id("Reserve_CovL_ANL_Indemnity")), "3000");
		sendText(driver.findElement(By.id("Reserve_CovL_PNJ_Indemnity")), "2000");
		click(dwellingChevron.btnSave);
		wait(2);
		attachScreenShot(driver);
		driver.findElement(By.id("Closeout")).click();
		clickProcess(driver);
	}

	@When("User adjust recoveries 2 and do UI validations <mtr2464>")
	public void user_adjust_recoveries_2_and_do_UI_validations_mtr2464() throws Exception {
		// Click Claims Icon2
		try {
			Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(driver.findElement(By.id("ClaimantActionsMenu_2"))).click().build().perform();
			Hooks.scenario.log("Claims Action Menu Icon 2 clicked");
		} catch (Exception e) {
			Hooks.scenario.log("Claims Action Menu Icon 2 NOT clicked");
			wait(5);
		}

		// click Adjust Recoveries
		waitForClickability(driver.findElement(By.id("AdjustRecovery_2")));
		moveToElement(driver.findElement(By.id("AdjustRecovery_2")));
		click(driver.findElement(By.id("AdjustRecovery_2")));
		wait(2);
		// clickonAnyButton(driver, "ShowAvailableInd");
		// wait(1);
		clickonAnyButton(driver, "img1000");
		wait(1);
		verify_AnyText_IsVisible(driver, "AnimalLiability");
		verify_AnyText_IsVisible(driver, "PersonalInjury");
		driver.findElement(By.id("Return")).click();
		wait(2);

		driver.findElement(By.id("Save")).click();
		driver.findElement(By.id("Closeout")).click();
		clickProcess(driver);
		wait(3);
	}

	@When("User clicks Claim File Tab")
	public void user_clicks_Claim_File_Tab() throws Exception {
		driver.findElement(By.id("Tab_Documents")).click();
		wait(2);
	}

	@When("User clicks Property Loss Notice form and validates form version and completes test")
	public void user_clicks_Property_Loss_Notice_form_and_validates_form_version_and_completes_test() throws Exception {
		clickOnAnyPolicyFileTabForm(driver, "Property Loss Notice");
		Thread.sleep(7000);
		switchToWindow(driver, "STFile&File");
		LNForm = PdfComparator.makePdf(driver, "AccordLNForm.pdf");
		attachScreenShot(driver);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + LNForm);

		wait(12);
		LN_Content = SmartPDFComparator2.getPDFtextByArea(FileLocation + LNForm, 1, 0, 0, 600, 750);
		PdfComparator.verifyFormData(driver, LN_Content, "SECTION I COVERAGE LIMITS");
		PdfComparator.verifyFormData(driver, LN_Content, "Personal Property");
		PdfComparator.verifyFormData(driver, LN_Content, "100,000");
		PdfComparator.verifyFormData(driver, LN_Content, "SECTION II COVERAGE LIMITS");
		PdfComparator.verifyFormData(driver, LN_Content, "Personal Liability");
		PdfComparator.verifyFormData(driver, LN_Content, "300,000");

		Hooks.scenario.log("Test Case Completed!");
	}
}
