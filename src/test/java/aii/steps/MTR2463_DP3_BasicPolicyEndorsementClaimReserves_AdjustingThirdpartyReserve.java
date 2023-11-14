package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR2463_DP3_BasicPolicyEndorsementClaimReserves_AdjustingThirdpartyReserve extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime lossDate = currentDate.plusDays(10);
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String roofYear = String.valueOf(currentY - 1);
	static String policyNum;
	static String lossNum;
	static String claimNum;
	static String PL_reserve;
	static String MP_reserve;

	@When("User enters all required information on policy information screen <mtr2463>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2463() {

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

	@When("User enters DP3 product selection information and effective date as current date <mtr2463>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_mtr2463() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr2463>")
	public void user_enters_all_current_date_as_prior_date_mtr2463() throws Exception {
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

	@When("User enters all required information on DP3 dwelling screen <mtr2463>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr2463() {

		// selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10
		// mi");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtPersonalPropertyC, "$300,000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User answers all underwriting questions for DP3 <mtr2463>")
	public void user_answers_all_underwriting_questions_for_dp3_mtr2463() throws Exception {
		// Application Underwriting Questions Chevron was filled here
		fillDP3_UWQuestions();
		wait(1);
	}

	@And("User updates plumbing,electrical,hvac years as current year minus 1 year and sets CovC as <100.000>, CovL as <300.000>")
	public void User_updates_plumbing_electrical_hvac_years_as_current_year_minus_1_year_and_sets_CovC_as_100_CovL_as_300() {

		try {
			click(dwellingChevron.btnDwelling);
			click(dwellingChevron.btnSave);
			wait(3);
			sendText(dwellingChevron.txtHvacYearUpdate, roofYear);
		} catch (Exception e) {
			acceptAlert();
		}
		sendText(dwellingChevron.txtPlumbingYearUpdate, roofYear);
		sendText(dwellingChevron.txtYearElectrical, roofYear);
		sendText(dwellingChevron.txtPersonalPropertyC, "$100,000");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$300,000");

		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction for <mtr2463>")
	public void user_finalizes_transaction_for_mtr2463() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <mtr2463>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_mtr2463()
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

	@When("User changes system date to current date plus <10> days <mtr2463>")
	public void user_changes_system_date_current_date_plus_10_days_mtr2463() throws Exception {
		ChangeDate_Admin(driver, dtf.format(lossDate));
		wait(1);
	}

	@When("User searches for the policy <mtr2463>")
	public void user_searches_policy_for_mtr2463() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets loss date as current date plus <10> days <mtr2463>")
	public void user_sets_loss_date_as_current_date_plus_10_days_mtr2463() {
		sendText(claim.txtLossDate, dtf.format(lossDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects loss cause as Liability BI Non Pollution and validate the following fields")
	public void user_selects_loss_cause_as_Liability_BI_Non_Pollution_and_validate_following_fields() throws Exception {
		selectDropdownText(claim.ddLossCause, "Liability BI - Non-Pollution");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User selects sub loss cause as All Other Non-Pollution and selects examiner clicks notice and validates 'This loss notice is incomplete until you click the Complete action followed by the Submit button' message")
	public void user_selects_sub_loss_cause_as_All_Other_Non_Pollution_and_selects_Examiner_clicks_notice_and_validates_error_message()
			throws Exception {
		selectDropdownText(claim.ddSubLossCause, "All Other Non-Pollution");
		sendText(claim.txtClaimDescription, "Claim MTR 2463");
		sendText(claim.txtExaminerNumber, "FA0TB");
		selectDropdownText(claim.ddAuthorityContacted, "None");
		click(dwellingChevron.btnSave);
		wait(3);
		clickOnAnyLink(driver, "Notice");
		verify_AnyText_IsVisible(driver,
				"This loss notice is incomplete until you click the Complete action followed by the Submit button ");
	}

	@When("User clicks Complete and takes note of the claim number <mtr2463>")
	public void user_clicks_complete_takes_notes_mtr2463() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Claimants Tab")
	public void user_clicks_Claimants_Tab() throws Exception {
		click(claim.lnkClaimants);
		wait(3);
	}

	@When("User Adds New Claimant as Third Party Employee")
	public void user_Adds_New_Claimant_as_Third_Party_Employee() throws Exception {
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
		driver.findElement(By.id("Closeout")).click(); // finalize transaction
		clickProcess(driver);
	}

	@When("User starts Transaction and clicks Detail Chevron")
	public void user_starts_Transaction_and_clicks_Detail_Chevron() throws Exception {
		startTransaction(driver);
		wait(2);
		driver.findElement(By.id("Wizard_Detail")).click();
		wait(2);
	}

	@When("User adjust reserves and do UI validations <mtr2463>")
	public void user_adjust_reserves_and_do_UI_validations_mtr2463() throws Exception {
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

		PL_reserve = getTextOfElement(driver, "FeatureLimit_CovL_COVLSUB_1");
		expectedValue_foundValue(driver, "300,000", PL_reserve);
		MP_reserve = getTextOfElement(driver, "FeatureLimit_CovM_1");
		expectedValue_foundValue(driver, "5,000", MP_reserve);
	}

	@When("User sets Personal Liability Reserves as <5000> Medical Payment to Others as <1000> and finalize and process transaction")
	public void user_sets_Personal_Liability_Reserves_as_5000_Medical_Payment_to_Others_as_1000() throws Exception {
		sendText(driver.findElement(By.id("Reserve_CovL_COVLSUB_Indemnity")), "5000");
		sendText(driver.findElement(By.id("Reserve_CovM_Indemnity")), "1000");
		click(dwellingChevron.btnSave);
		wait(2);
		attachScreenShot(driver);
		driver.findElement(By.id("Closeout")).click();
		clickProcess(driver);
	}

	@Then("User adjust recoveries and do UI validations and completes test<mtr2463>")
	public void user_adjust_recoveries_and_do_UI_validations_mtr2463() throws Exception {
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
		clickonAnyButton(driver, "ShowAvailableInd");
		wait(1);
		clickonAnyButton(driver, "img1000");
		wait(1);
		verify_AnyText_IsVisible(driver, "L-PersonalLiability");
		verify_AnyText_IsVisible(driver, "M-Medical Payments to Others");
		driver.findElement(By.id("Return")).click();
		wait(2);
		
		driver.findElement(By.id("Save")).click();
		driver.findElement(By.id("Closeout")).click();
		clickProcess(driver);
		wait(3);
		Hooks.scenario.log("Test Case Completed!");
	}
}
