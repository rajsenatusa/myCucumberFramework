package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC34438_DP1_NB_RNL_END_AgentCanEditandModifyNumberofStories extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String totalDue;
	static String preAutoDt;
	static String autoRenewDt;
	static String temp;
	static String DP1_renewalTerm1;
	static String renewal_effective;

	@When("User confirms for the attribute of 'Allow Number of Stories Endorsement Edit' selected as Yes")
	public void user_confirms_as_for_the_attribute_of_allow_number_stories_endorsement_selected_as_yes()
			throws Exception {
		scrollToElement(userLookup.txtAllowNumberStoriesEndorsementEdit);
		sendText(userLookup.txtAllowNumberStoriesEndorsementEdit, "Yes");
		attachScreenShot(driver);
	}

	@When("User enters all required information on policy information screen <tc34438>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34438() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1114 E Patterson St");
		sendText(quote.txtZipCode, "33604");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP1 quote screen <tc34438>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc34438() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen and validates Number of Stories field is enabled and gets all values <tc34438>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc34438() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, "2022");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		wait(1);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		verifyAnyElement_Enabled(driver, "Building.NumberOfStories");
		getAnyDropdownPopulatedValue(driver, "Building.NumberOfStories");
		click(dwellingChevron.btnNext);
	}
	@And("User sets number of stories as 3 confirm value through RCE , validates number of stories defaulted as 3 and finalizes transaction <tc34438>")
	public void user_sets_number_of_stories_as_3_and_finalizes_transaction_tc34438() throws Exception {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnDwelling);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		click(dwellingChevron.btnSave);
		wait(3);
		
		clickonAnyButton(driver, "LaunchRCE");
		wait(5);
		switchToWindow(driver, "acceptance.360-value");
		Thread.sleep(5000);
		clickonAnyButton(driver, "iv360-valuationReportsLink-icon");
		Thread.sleep(5000);
		scrollToAnyField(driver, "Owner Information");
		attachScreenShot(driver);
		wait(2);
		driver.switchTo().window(mainWindow);
		Thread.sleep(250);
		
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		
		verifyAnyDropdownDefaultedValue(driver, "Building.NumberOfStories", "3");
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <tc34438>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_tc34438()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
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
	@When("User searches for the policy <tc34438>")
	public void user_searches_policy_for_tc34438() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User clicks Make Payment and selects credit card and enters due amount <tc34438>")
	public void user_clicks_make_payment_and_selects_cc_tc34438() {
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
	@When("User does Auto Renewal for the policy with batch jobs <tc34438>")
	public void user_does_auto_renewal_tc34438() throws Exception {
		runAutoRenewPolicy(driver, policyNum, "01", "02");
	}
	@When("User takes note of the pre auto renew date and auto renew date")
	public void user_takes_note_of_the_pre_auto_renew_date_and_auto_renew_date_tc34438() throws Exception {
		selectShowAll(driver);
		checkShowSysTask(driver);
		preAutoDt = getPreAutoRenewDate(driver).toString();
		autoRenewDt = getAutoRenewDate(driver).toString();	
	}
	@When("User completes Auto Renewal through batch jobs <tc34438>")
	public void user_completes_auto_renewal_through_batch_tc34438() throws Exception {
		runAutoRenewalOnSinglePolicy(driver, policyNum, preAutoDt, autoRenewDt);
		temp = replaceMethod(policyNum, "-01", "");
		DP1_renewalTerm1 = temp + "-02";
		wait(3);
	}
	@When("User searches for renewed policy <tc34438>")
	public void user_searches_for_renewed_policy_for_tc34438() {
		sendText(dashboard.txtSearchBar, DP1_renewalTerm1);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates Number of Stories Field is disabled")
	public void user_validates_Number_of_stories_field_is_disabled_tc34438() throws Exception {
		verifyAnyDisabledFieldsValue(driver, "Building.NumberOfStories_text", "3");
		attachScreenShot(driver);	
	}
	@When("User takes note of the renewal effective date <tc34438>")
	public void user_takes_note_of_the_renewal_effective_date_tc34438() throws Exception {
		clickApplicationTab(driver);
		wait(2);
		renewal_effective = getTransactionEffDate(driver).toString();			
	}
	@When("User changes system date to renewal effective date <tc34438>")
	public void user_changes_system_date_To_renewal_effective_date_tc34438() throws Exception {
		ChangeAdminDate_NotInbox(driver, renewal_effective);			
	}
	@And("User sets new effective date as renewal effective date and starts endorsement <tc34438>")
	public void User_sets_new_effective_date_as_renewal_effective_date_and_starts_endorsement_tc34438()
			throws Exception {
		sendText(historyChevron.txtEffectiveDate, renewal_effective);
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}
	@When("User validates Building Number of Stories field is enabled and gets all populated values and select 4 or more")
	public void user_validates_building_number_of_stories_field_is_enabled_and_selects_4_or_more_tc34438() throws Exception {
		verifyAnyElement_Enabled(driver, "Building.NumberOfStories");
		getAnyDropdownPopulatedValue(driver, "Building.NumberOfStories");	
		selectDropdownText(dwellingChevron.ddNumberOfStories, "4 or more");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@And("User clicks Finalize button <tc34438>")
	public void User_clicks_Finalize_button_tc34438() throws Exception {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		attachScreenShot(driver);
		wait(1);
	}

	@And("User process and completes endorsement <tc34438>")
	public void User_process_and_completes_endorsement_tc34438() {
		click(closeoutChevron.btnEndorsePolicy);
		wait(15);
		closeUnnecessaryTabs();
	}
	@Then("User validates Building Number of Stories field is disabled and completes test")
	public void User_validates_Building_NumberofStories_field_is_disabled_and_completes_test_tc34438() throws Exception {
		verifyAnyDisabledFieldsValue(driver, "Building.NumberOfStories_text", "4 or more");
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User makes payment with Credit Card <tc34438>")
	public void user_makes_payment_with_credit_card_tc34438() {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}
	@When("User clicks Dwelling Chevron <tc34438>")
	public void user_clicks_dwelling_chevron_tc34438() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@And("User clicks Start Transaction <tc34438>")
	public void User_clicks_Start_Transaction_tc34438() {
		click(dashboard.btnStartTransaction);
	}

	@And("User clicks EN Transaction Selection <tc34438>")
	public void User_clicks_EN_Transaction_Selection_tc34438() {
		selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
		wait(1);
		click(dashboard.btnSelect);
	}
}
