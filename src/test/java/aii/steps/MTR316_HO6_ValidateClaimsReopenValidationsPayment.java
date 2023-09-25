package aii.steps;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR316_HO6_ValidateClaimsReopenValidationsPayment extends CommonMethods {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String lossNum;
	static String claimNum;
	static String txNum;

	@When("User enters all required information on policy information screen <mtr316>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr316() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <mtr316>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_mtr316() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen and enters <35.000> for CovC <mtr316>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_35000_Cov_c_mtr316() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User answers all underwriting questions for HO6 <mtr316>")
	public void user_answers_all_underwriting_questions_for_ho6_mtr316() throws Exception {
		fillHO6_UWQuestions();
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <mtr316>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_mtr316()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User checks application dwelling screen and finalizes transaction <mtr316>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_mtr316() {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User searches for the policy number <mtr316>")
	public void user_searches_policy_for_mtr316() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects loss cause as <Collapse> and clicks Save")
	public void user_selects_loss_cause_as_collapse_and_clicks_save() throws Exception {
		selectDropdownText(claim.ddLossCause, "Collapse");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User completes all required information on claim chevron <mtr316>")
	public void user_completes_all_reqiured_information_on_claim_chevron_mtr316() throws Exception {
		selectDropdownText(claim.ddHomeHabitable, "Yes");
		wait(1);
		sendText(claim.txtClaimDescription, "Claim verification-MTR316");
	}

	@When("User selects Examiner")
	public void user_selects_examiner() throws Exception {
		clickAnyMagnifierIcon(driver, "ExaminerProviderNumber");
		switchToWindow(driver, "COProviderSearchPage");
		wait(1);
		selectDropdownText(userLookup.ddFilterType, "Contains");
		sendText(userLookup.txtSearchName, "Bennett");
		clickOnAnyLink(driver, "Search");
		wait(4);
		attachScreenShot(driver);
		clickOnAnyLink(driver, "Sarah Bennett");
		wait(2);
		driver.switchTo().window(mainWindow);
		Hooks.scenario.log("Switched to Main window");

		attachScreenShot(driver);
	}

	@When("User clicks save and takes note of the loss number <mtr316>")
	public void user_clicks_save_and_takes_note_of_the_loss_number_mtr316() throws Exception {
		click(dwellingChevron.btnSave);
		wait(3);
		try {
			lossNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Loss Number: " + lossNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Complete and takes note of the claim number <mtr316>")
	public void user_clicks_complete_takes_notes_mtr316() throws Exception {
		click(claim.btnComplete);
		wait(5);
		try {
			claimNum = driver.findElement(By.id("ClaimSummary_ClaimNumber")).getText().toString();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Claim Information Link and validates expected information is visible")
	public void user_clicks_claim_information_link_and_validates_expected_information_is_visible() throws Exception {
		clickOnAnyLink(driver, "Claim Information");
		verify_AnyLabel_IsVisible(driver, "Branch");
		verify_AnyLabel_IsVisible(driver, "Examiner Phone Number");
		verify_AnyLabel_IsVisible(driver, "Examiner E-Mail");
		verify_AnyLabel_IsVisible(driver, "Severity Score:");
		verify_AnyLabel_IsVisible(driver, "Severity Level:");
		verify_AnyLabel_IsVisible(driver, "Severity Flag:");
	}

	@When("User clicks Financial Actions Tab")
	public void user_clicks_financial_actions_tab() throws Exception {
		click(driver.findElement(By.id("Wizard_Detail")));
		wait(1);
	}

	@When("User clicks Financial Actions Link")
	public void user_clicks_financial_actions_link() throws Exception {
		clickOnAnyLink(driver, "Financial Actions");
		wait(1);
	}

	@When("User adjusts reserves and sets indemnity Dwelling A as <3000> and Indemnity Cov C as <3000>")
	public void user_adjusts_reserves_mtr316() throws Exception {
		clickAdjustReserves(driver);
		wait(1);
		clickonAnyButton(driver, "ShowAvailableInd");
		sendText(driver.findElement(By.id("Reserve_CovA_COVASUB_Indemnity")), "3000");
		sendText(driver.findElement(By.id("Reserve_CovC_COVCSUB_Indemnity")), "3000");
		click(dwellingChevron.btnSave);
		wait(1);
		verify_AnyText_IsVisible(driver, "Maximum Reserve for Indemnity exceeded limit of $5,000.00");
		attachScreenShot(driver);
		// ignore warning
		click(driver.findElement(By.id("SaveIgnoreWarnings")));
		wait(1);
	}

	@When("User clicks Finalize Transaction")
	public void user_clicks_finalize_Transaction_mtr316() throws Exception {
		reviewChevron.btnFinalize.click();
	}

	@When("User validates 'Maximum Reserve for Indemnity exceeded limit of $5,000.00' text is visible")
	public void user_validates_maximum_reserve_for_indemnity_exceeded_limit_of_5000_text_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Maximum Reserve for Indemnity exceeded limit of $5,000.00");
	}

	@When("User takes note of the transaction number")
	public void user_takes_note_of_the_transaction_number() throws Exception {
		txNum = driver.findElement(By.id("ClaimSummary_ClaimTransactionNumber")).getText().toString();
		Hooks.scenario.log(txNum);
		wait(1);
	}

	@When("User clicks Submit For Approval button")
	public void user_clicks_Submit_For_Approval_button() throws Exception {
		driver.findElement(By.id("SubmitForApproval")).click();
		wait(1);
		Hooks.scenario.log("Submit For Approval button was clicked");
	}

	@When("User searches Claim Number")
	public void user_searches_Claim_Number() throws Exception {
		setClaimNumSearch(driver, txNum);
	}

	@When("User approves Claim Transaction")
	public void user_approves_claim_transaction() throws Exception {
		driver.findElement(By.id("Approve")).click();
	}

	@When("User clicks Process button")
	public void user_clicks_Process_button() throws Exception {
		driver.findElement(By.id("Process")).click();
		wait(1);
		attachScreenShot(driver);
	}

	@When("User clicks Claims Icon")
	public void user_clicks_Claims_Icon() throws Exception {
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(driver.findElement(By.id("ClaimantActionsMenu_1"))).click().build().perform();
		Hooks.scenario.log("Claims Action Menu Icon clicked");
	}

	@When("User closes Reserves")
	public void user_closes_Reserves_() throws Exception {
		clickAdjustReserves(driver);
		wait(1);
		driver.findElement(By.id("Img_Reserve_CovA_COVASUB_Indemnity")).click();
		Hooks.scenario.log("CloseReserves CovA btn selected");
		driver.findElement(By.id("Img_Reserve_CovC_COVCSUB_Indemnity")).click();
		Hooks.scenario.log("CloseReserves CovC btn selected");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(1);
		attachScreenShot(driver);
	}

	@When("User clicks Adjust Reserves and sets Indemnity Dwelling A Item Limit")
	public void user_clicks_adjust_reserves_and_sets_indemnity_dwelling_a_itemlimit() throws Exception {
		clickAdjustReserves(driver);
		wait(1);
		driver.findElement(By.name("ShowClosedInd")).click();
		wait(1);
		sendText(driver.findElement(By.id("Reserve_CovA_COVASUB_Indemnity")), "3000");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(1);
		verifyClaimReopenStatus_CovA(driver);
	}

	@When("User validates 'Reopen Reason is required for this transaction. Please select a reopen reason in order to process this transaction.' text is visible")
	public void user_validates_reopen_reason_requited_for_this_transaction_message_displayed() throws Exception {
		verify_AnyText_IsVisible(driver,
				"Reopen Reason is required for this transaction. Please select a reopen reason in order to process this transaction.");
	}

	@When("User selects Reopen Reason as Other")
	public void user_selects_reopen_reason_as_other() throws Exception {
		selectDropdownText(driver.findElement(By.id("Claim.ReopenReason")), "Other");
	}

	@When("User makes Claim Payment")
	public void user_makes_claim_payment() throws Exception {
		WebElement userManagement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.id("MakePayment_1")));
		new Actions(driver).moveToElement(userManagement).perform();
		userManagement.click();
		
		//selects payment type
		selectDropdownText(driver.findElement(By.id("ClaimantTransaction.PaymentTypeCd")), "Indemnity");
		wait(1);
		//selects payment method
		selectDropdownText(driver.findElement(By.id("ClaimantTransaction.PaymentMethodCd")), "Check - Batch");
		wait(1);
		//sets amount
		sendText(driver.findElement(By.id("ClaimantTransaction.PaidAmt")), "3000");
		wait(1);
		//clicks Payee Select Claimant
		driver.findElement(By.name("ClaimantTransaction.PayToClaimantInd")).click();
		Hooks.scenario.log("PayToClaimantInd selected");
		//selects memo text as none
		selectDropdownText(driver.findElement(By.id("ClaimantTransaction.MemoCd")), "None");
		//sets indemnity dwellingA open item paid amount
		sendText(driver.findElement(By.id("Reserve_PaidAmt_CovA_COVASUB_Indemnity")), "3000");
		wait(1);
		//click make payment button
		driver.findElement(By.name("Save")).click();
		Hooks.scenario.log("Make payment btn selected");
	}
}
