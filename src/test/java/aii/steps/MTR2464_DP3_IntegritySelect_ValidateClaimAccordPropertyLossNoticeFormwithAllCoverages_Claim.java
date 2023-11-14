package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR2464_DP3_IntegritySelect_ValidateClaimAccordPropertyLossNoticeFormwithAllCoverages_Claim extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endorseDate = currentDate.plusDays(10);
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY);
	static String policyNum;
	static String lossNum;
	static String claimNum;
	
	@When("User enters all required information on policy information screen <mtr2464>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2464() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "2525 US Highway 27 S");
		sendText(quote.txtZipCode, "33825");
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
		} catch (Exception e) {
			acceptAlert();
			sendText(dwellingChevron.txtSquareFeet, "2500");
		}
	}
	@When("User enters all required information on DP3 dwelling screen and selects integrity package and adds optional coverages<mtr2464>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr2464() {

		sendText(dwellingChevron.txtYearConstruction, currentYear);
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
		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
		click(dwellingChevron.rbWaterDamageExcluded);
		wait(1);
		click(dwellingChevron.rbWaterDamageLimited);
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

		try {
			click(dwellingChevron.btnDwelling);
			click(dwellingChevron.btnSave);
			wait(3);
			sendText(dwellingChevron.txtHvacYearUpdate, currentYear);
		} catch (Exception e) {
			acceptAlert();
		}
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		sendText(dwellingChevron.txtPlumbingYearUpdate, currentYear);
		sendText(dwellingChevron.txtYearElectrical, currentYear);
		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
		click(dwellingChevron.btnSave);
		wait(3);
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
}
