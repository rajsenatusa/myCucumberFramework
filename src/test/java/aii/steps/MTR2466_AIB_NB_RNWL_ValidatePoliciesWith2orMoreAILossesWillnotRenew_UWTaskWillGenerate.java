package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR2466_AIB_NB_RNWL_ValidatePoliciesWith2orMoreAILossesWillnotRenew_UWTaskWillGenerate extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String claimNum;
	static String totalDue;
	static String preAutoDt;
	
	@When("User enters all required information on policy information screen <mtr2466>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr2466() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
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
	@When("User enters all required information on AIB quote screen for <mtr2466>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_mtr2466() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
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
	@When("User selects liability coverage on quote screen for <mtr2466>")
	public void user_selects_liability_coverage_on_quote_screen_for_mtr2466() {

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
	@When("User adds operator information on quote screen <mtr2466>")
	public void user_adds_operator_information_on_quote_screen_mtr2466() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "M240019412710");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters all required information on AIB boat dwelling screen for <mtr2466>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_mtr2466() {

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
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, "2019");
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(aibChevron.txtEngineSerialNum, "456WSXD677G");
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
	@When("User validates that AIB policy has been created successfully and takes note of the policy number <mtr2466>")
	public void user_validates_that_aib_policy_has_been_created_successfully_mtr2466() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("AIB NB policy has been created successfully");
		} else {
			System.out.println("AIB Policy Creation failed!");
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
	@When("User searches for Policy Number for <mtr2466>")
	public void user_searches_for_policy_number_for_mtr2466() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User sets loss date as current date <mtr2466>")
	public void user_sets_loss_date_as_current_date_mtr2466() {
		sendText(claim.txtLossDate, dtf.format(currentDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User selects loss cause as Collision and clicks Save")
	public void user_selects_loss_cause_as_Collision_and_clicks_save() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collision");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User selects vehicle, purpose of use and all required information on claim screen <mtr2466>")
	public void user_selects_vehicle_purpose_of_use_and_all_req_infoo_on_claim_screen_mtr2466() throws Exception {
		selectDropdownText(claim.ddAuthorityContacted, "Police Department");
		verify_AnyLabel_IsVisible(driver, "Authority Name*");
		verify_AnyLabel_IsVisible(driver, "Case Number*");
		sendText(claim.txtAuthorityName, "Detective");
		sendText(claim.txtCaseNumber, "CollisionCase108");
		wait(1);
		sendText(claim.txtClaimDescription, "LN UI verification");
		
		selectDropdownText(claim.ddClaimBoatSelection, "2019 Lowe Boat Model - 1535KIUHO"); // boat selection
		selectDropdownText(claim.ddClaimPurposeUse, "Business");
		wait(1);
		selectDropdownText(claim.ddClaimOperator, "None");
		sendText(claim.txtClaimLossDesc, "Boat Loss Notice verification");
		selectDropdownText(claim.txtClaimCurrentLocation, "On");
		click(driver.findElement(By.id("InsuredLocation")));
		sendText(driver.findElement(By.id("Claim.Roadway")),"Business");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User clicks Complete and takes note of the claim number <mtr2466>")
	public void user_clicks_complete_takes_notes_mtr2466() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User selects loss cause as Cracking and clicks Save")
	public void user_selects_loss_cause_as_Cracking_and_clicks_save() throws Exception {
		click(driver.findElement(By.id("Save")));
		wait(3);
		selectDropdownText(claim.ddLossCause, "Cracking");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User selects vehicle, purpose of use and all required information on claim screen on second claim <mtr2466>")
	public void user_selects_vehicle_purpose_of_use_and_all_req_infoo_on_claim_screen_on_second_claim_mtr2466() throws Exception {
		selectDropdownText(claim.ddAuthorityContacted, "Police Department");
		verify_AnyLabel_IsVisible(driver, "Authority Name*");
		verify_AnyLabel_IsVisible(driver, "Case Number*");
		sendText(claim.txtAuthorityName, "Detective");
		sendText(claim.txtCaseNumber, "CollisionCase108");
		wait(1);
		sendText(claim.txtClaimDescription, "LN UI verification");
		
		selectDropdownText(claim.ddClaimBoatSelection, "2019 Lowe Boat Model - 1535KIUHO"); // boat selection
		selectDropdownText(claim.ddClaimPurposeUse, "Business");
		wait(1);
		selectDropdownText(claim.ddClaimOperator, "None");
		sendText(claim.txtClaimLossDesc, "Boat Loss Notice verification");
		selectDropdownText(claim.txtClaimCurrentLocation, "On");
		click(driver.findElement(By.id("InsuredLocation")));
		sendText(driver.findElement(By.id("Claim.Roadway")),"Business");
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User clicks Make Payment and selects credit card and enters due amount <mtr2466>")
	public void user_clicks_make_payment_and_selects_cc_mtr2466() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <mtr2466>")
	public void user_makes_payment_with_credit_card_mtr2466() throws Exception {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User clicks Task Tab and checks Show System Task and takes note of the preAutoDate")
	public void user_clicks_Task_Tab_and_checks_Show_System_Task_and_takes_note_of_the_preautodate_mtr2466() throws Exception {
		selectTaskTab(driver);
		checkShowSysTask(driver);
		preAutoDt = getPreAutoRenewDate(driver).toString();	
	}
	@When("User changes system date to pre auto date")
	public void user_changes_system_date_to_pre_auto_date_mtr2466() throws Exception {
		ChangeDate_Admin(driver, preAutoDt);
		wait(2);
	}
	@When("User renew policy through daily jobs manual <mtr2466>")
	public void user_renew_policy_through_daily_jobs_manual_mtr2466() throws Exception {
		runBatchJobs(driver, policyNum);
		wait(5);
		driver.findElement(By.id("Menu_Workflow")).click();
		wait(2);
	}
	@When("User validates UW task will generate and completes test")
	public void user_validates_UW_task_will_generate_and_completes_test_mtr2466() throws Exception {
		selectTaskTab(driver);
		Thread.sleep(500);
		selectShowAll(driver);
		checkShowSysTask(driver);
		Thread.sleep(1000);
		verifyClaimsTaskStatus(driver, "Automated Renewal for Policy", "Cancelled");
		getScheduledTaskDescription(driver, "2 or more AI losses");
		String user = getTaskReferrringUserStatus(driver, "2 or more AI losses");
		expectedValue_foundValue(driver, "GeneralUW", user);
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
}
