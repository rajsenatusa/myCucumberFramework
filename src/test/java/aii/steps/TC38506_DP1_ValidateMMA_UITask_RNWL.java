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

public class TC38506_DP1_ValidateMMA_UITask_RNWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime renewDate = currentDate.plusYears(1);
	static LocalDateTime taskDate = renewDate.plusDays(15);
	static String policyNum;
	static String mmaTaskDate = String.valueOf(taskDate.format(dtf));
	static String totalDue;
	static String PolicyNumberTerm02;
	static String renewal_effective;
	static String temp;
	static String refer;
	static String status;
	static String workdate;
	static String Completed_status;

	@When("User enters all required information on policy information screen <tc38506>")
	public void user_enters_all_required_information_on_policy_information_screen_tc38506() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
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

	@When("User enters all required information on DP1 quote screen <tc38506>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc38506() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen <tc38506>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc38506() {

		sendText(dwellingChevron.txtYearConstruction, "2019");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(dwellingChevron.btnNext);
	}

	@And("User checks application dwelling screen, select number of stories and finalizes transaction")
	public void user_checks_application_dwelling_screen_selects_number_of_stories_and_finalizes_transaction() {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnDwelling);
		wait(3);
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User validates that DP1 policy has been created successfully and close tabs and takes note of the policy for <tc38506>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_takes_note_of_the_policy_number_tc38506()
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

	@When("User makes payment with Credit Card <tc38506>")
	public void user_makes_payment_with_credit_card_tc38506() {
		makeCCPayment();
		wait(3);
		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <tc38506>")
	public void user_clicks_make_payment_and_selects_cc_tc38506() {
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

	@When("User does auto renewal through batch jobs <tc38506>")
	public void user_does_auto_renewal_through_batch_jobs_tc38506() throws Exception {
		PolicyNumberTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		renewal_effective = getTransactionEffDate(driver).toString();
		temp = replaceMethod(policyNum, "-01", "");
	}

	@When("User changes system date to renewal effective date as current date plus 1 year")
	public void user_changes_system_date_To_renewal_effective_date_as_current_date_plus_1_year() throws Exception {
		ChangeDate_Admin(driver, renewal_effective);
	}

	@When("User searches for renewed Policy Number for <tc38506>")
	public void user_searches_for_policy_number_for_tc38506() throws Exception {
		sendText(dashboard.txtSearchBar, PolicyNumberTerm02);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects endorsement date as renewal effective date <tc38506>")
	public void user_selects_endorsement_date_as_renewal_eff_date_tc38506() {
		sendText(dashboard.txtSelectDate, renewal_effective);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User clicks Dwelling Chevron <tc38506>")
	public void user_clicks_dwelling_chevron_tc38506() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User validates MMA selection defaulted as No")
	public void user_validates_MMA_selection_defaulted_as_No() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "BuildingExt.MMAInd", "No");
	}

	@When("User sets MMA selection as Yes")
	public void user_sets_MMA_selection_as_Yes() throws Exception {
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "Yes");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User validates 'Mandatory Mediation-Arbitration Changed From No to Yes' text is visible")
	public void user_validates_MMA_Changed_from_No_to_yes_message_is_visible() throws Exception {
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration Changed From No to Yes");
	}

	@When("User validates 'Mandatory Mediation-Arbitration discount applied on Policy' displayed with policy number and do other necessary validation referred in test steps")
	public void user_validates_MMA_discount_applied_on_Policy_displayed_with_policy_number() throws Exception {
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp
				+ ". Please Review and follow up for signed acknowledgment if not received.");
		refer = getTaskReferrringUserStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Underwriting Clerk", refer);
		status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Open", status);
		workdate = getTaskWorkDate(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, mmaTaskDate, workdate);
	}

	@When("User clicks Attachment Tab")
	public void user_clicks_Attachment_Tab() throws Exception {
		driver.findElement(By.id("Tab_Attachments")).click();
		wait(1);
	}

	@When("User adds Inspection Attachment")
	public void user_adds_Inspection_Attachment_Tab() throws Exception {
		driver.findElement(By.id("AddFile")).click();
		wait(1);
		selectDropdownText(driver.findElement(By.id("Attachment.TemplateId")),
				"Mandatory Mediation-Arbitration Acknowledgment");
		driver.findElement(By.id("Select")).click();
		wait(2);
		attachScreenShot(driver);
		driver.findElement(By.id("AddFiles")).click();
		addSampleFile(driver);
	}

	@Then("User selects show all and validates 'Mandatory Mediation-Arbitration discount applied on Policy' text is visible and do other validations")
	public void user_selects_show_all_and_validates_MMA_discount_applied_on_policy_text_is_visible_and_do_other_validations()
			throws Exception {
		selectShowAll(driver);
		checkShowSysTask(driver);
		Thread.sleep(500);
		verify_AnyText_IsVisible(driver, "Mandatory Mediation-Arbitration discount applied on Policy " + temp
				+ ". Please Review and follow up for signed acknowledgment if not received.");
		Completed_status = getTaskStatus(driver, "Mandatory Mediation-Arbitration discount");
		expectedValue_foundValue(driver, "Completed", Completed_status);
		Hooks.scenario.log("Test Case Completed!");
	}
}
