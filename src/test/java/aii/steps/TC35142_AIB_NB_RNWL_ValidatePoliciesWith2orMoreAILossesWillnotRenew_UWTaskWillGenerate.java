package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC35142_AIB_NB_RNWL_ValidatePoliciesWith2orMoreAILossesWillnotRenew_UWTaskWillGenerate
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String claimNum;
	static String claimNum2;
	static String preAutoDt;
	static String user;

	@When("User enters all required information on AIB quote screen for <tc35142>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc35142() {

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
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

	@When("User selects liability coverage on quote screen for <tc35142>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc35142() {

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

	@When("User enters all required information on AIB boat dwelling screen for <tc35142>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc35142() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2019");
		sendText(aibChevron.txtBoatHinNumber, ConfigsReader.getProperty("boathinnumber"));
		selectDropdownText(aibChevron.ddBoatMake, ConfigsReader.getProperty("boatmake"));
		sendText(aibChevron.txtBoatModel, ConfigsReader.getProperty("boatmodel"));
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

	@Given("User issues policy and close unnecessary tabs and taking note of the policy number <tc35142>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc35142() throws Exception {
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

	@When("User searches for the policy <tc35142>")
	public void user_searches_policy_for_tc35142() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User sets loss date as current date")
	public void user_sets_loss_date_as_current_date() {
		sendText(claim.txtLossDate, dtf.format(currentDate));
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User sets loss date as current date second time")
	public void user_sets_loss_date_as_current_date_second_time() {
		sendText(claim.txtLossDate, dtf.format(currentDate));
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User selects collision as loss cause, police department as authority contacted and validates authority name and case number labels are visible")
	public void user_selects_collision_as_loss_cause() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collision");
		selectDropdownText(claim.ddAuthorityContacted, "Police Department");
		verify_AnyLabel_IsVisible(driver, "Authority Name*");
		verify_AnyLabel_IsVisible(driver, "Case Number*");
		sendText(claim.txtClaimDescription, "Claim Description TEST");
		sendText(claim.txtAuthorityName, "Detective");
		sendText(claim.txtCaseNumber, "CollisionCase101");
		wait(1);
	}

	@When("User selects all required information on loss notice creation screen")
	public void user_selects_all_required_information_on_loss_notice_creation_screen() {
		selectDropdownText(claim.ddClaimBoatSelection, "2019 Bayliner Testing - 1548799652");
		selectDropdownText(claim.ddClaimPurposeUse, "Business");
		selectDropdownText(claim.ddClaimOperator, "None");
		sendText(claim.txtClaimCurrentLocation, ConfigsReader.getProperty("address"));
		sendText(claim.txtClaimLossDesc, "Boat Loss Notice Verification");
		sendText(claim.txtClaimCity, "Davenport");
		selectDropdownText(claim.ddClaimState, "Florida");
		sendText(claim.txtClaimPostalCode, "33837");
		wait(1);
		click(claim.btnSave);
		wait(3);
	}

	@When("User clicks complete button and takes note of the claim number")
	public void user_clicks_complete_and_takes_note_of_claim_number() {
		click(claim.btnComplete);
		wait(2);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User selects cracking as loss cause, police department as authority contacted and validates authority name and case number labels are visible")
	public void user_selects_cracking_as_loss_cause() throws Exception {
		selectDropdownText(claim.ddLossCause, "Cracking");
		selectDropdownText(claim.ddAuthorityContacted, "Police Department");
		verify_AnyLabel_IsVisible(driver, "Authority Name*");
		verify_AnyLabel_IsVisible(driver, "Case Number*");
		sendText(claim.txtClaimDescription, "Claim Description TEST");
		sendText(claim.txtAuthorityName, "Detective");
		sendText(claim.txtCaseNumber, "CollisionCase102");
		wait(1);
	}

	@When("User clicks complete button and takes note of the second claim number")
	public void user_clicks_complete_and_takes_note_of_second_claim_number() {
		click(claim.btnComplete);
		wait(2);
		try {
			claimNum2 = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number 2: " + claimNum2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Make Payment for <tc35142> and selects credit card and enters due amount")
	public void user_clicks_make_payment_for_tc35142() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_2")));
		wait(2);
		String totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
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
		wait(2);
		click(driver.findElement(By.id("SubmitPayment")));
		click(driver.findElement(By.id("dialogOK")));
		wait(4);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User checks show system task and take note preautorenew date")
	public void user_checks_show_system_task_and_take_note_preautorenew_date() throws Exception {
		checkShowSysTask(driver);
		preAutoDt = getPreAutoRenewDate(driver).toString();
	}

	@When("User changes system date to preautorenewal date and run pre-automated batch job")
	public void user_changes_system_date_to_preautorenewal_date_and_run_batch() throws Exception {
		ChangeDate_Admin(driver, preAutoDt);
		wait(3);
		runBatchJobs(driver, policyNum);
		click(dashboard.btnHome);
		wait(2);
	}

	@Then("User validates UW task generated and completes the test")
	public void user_validates_uw_task_generated_and_completes_the_test() throws Exception {
		selectShowAll(driver);
		checkShowSysTask(driver);
		Thread.sleep(1000);
		verifyClaimsTaskStatus(driver, "Automated Renewal for Policy", "Cancelled");
		getScheduledTaskDescription(driver, "2 or more AI losses");
		user = getTaskReferrringUserStatus(driver, "2 or more AI losses");
		expectedValue_foundValue(driver, "GeneralUW", user);
		Hooks.scenario.log("Test Case Completed!");
	}
}
