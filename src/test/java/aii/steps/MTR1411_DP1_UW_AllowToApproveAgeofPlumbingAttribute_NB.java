package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR1411_DP1_UW_AllowToApproveAgeofPlumbingAttribute_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String applicationNumber;

	@When("User enters all required information on policy information screen with old address")
	public void user_enters_all_required_information_on_policy_information_screen_with_old_address() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1495 23rd Naples");
		sendText(quote.txtZipCode, "34117");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on DP1 quote screen with current date as prior policy date <mtr1411>")
	public void user_enters_all_required_information_on_dp1_quote_screen_with_current_date_as_prior_policy_date_mtr1411() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
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
	@When("User clicks OK for the message \"Roof Cover has been changed to FBC Equivalent.\"")
	public void user_clicks_ok_for_the_message() {
		click(reviewChevron.btnDialogOk);
	}

	@When("User enters all required information on DP1 dwelling screen for <mtr1411>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_for_mtr1411() {

		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(driver.findElement(By.id("CovALimit")), "400000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@And("User checks application dwelling screen, sets Electrical and HVAC Updated as <2008>")
	public void user_checks_application_dwelling_screen_and_sets_Hvac_electrical() {
		click(dwellingChevron.btnDwelling);
		wait(1);
		sendText(dwellingChevron.txtYearHVAC, "2008");
		sendText(dwellingChevron.txtYearElectrical, "2008");
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User validates 'Risk is ineligible due to age of Plumbing' message has been displayed")
	public void user_validates_error_message_displayed() throws Exception {
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");
	}

	@And("User finalizes transaction")
	public void user_finalizes_transaction() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
	}

	@And("User validates 'Risk is ineligible due to age of Plumbing' is visible on closeout screen")
	public void user_validates_risk_is_ineligible() throws Exception {
		verify_AnyText_IsVisible(driver, "Risk is ineligible due to age of Plumbing");
	}

	@And("User validates 'Submit For Approval' is visible on closeout screen")
	public void user_validates_submit_for_approval() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
	}

	@And("User validates 'Modify Application' is visible on closeout screen")
	public void user_validates_modify_application() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application number for <mtr1411>")
	public void user_takes_note_of_the_application__number_for_mtr1411() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User clicks Override Link on Underwriter Role <mtr1411>")
	public void user_clicks_override_link_on_uw_standard_MTR1411() {
		click(userLookup.lnkOverride1);
		wait(3);
	}
	@And("User clicks Submit for Approval button")
	public void user_clicks_submit_for_approval_button() throws Exception {
		sendText(closeoutChevron.txtWorkflowComments, "testtesttesttes");
		click(closeoutChevron.btnSubmitApproval);
		click(closeoutChevron.btnDialogOk);
		wait(2);
	}

	@When("User searches Underwriter")
	public void user_searches_underwriter() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "underwriter1");
		wait(1);
	}

	@When("User override Underwriters 'Allow to Approve Age of Plumbing' as no")
	public void user_override_uw_allow_to_approve_age_of_plumbing() {
		sendText(driver.findElement(By.id("UserRoleAttrValue_7_98")), "No");
		click(driver.findElement(By.id("Save")));
		wait(3);
	}

	@When("User searches for application number")
	public void user_searches_for_application_number() {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}

	@And("User validates 'Issue New Business' is not visible on closeout screen")
	public void user_validates_issue_new_business_is_not_visible() throws Exception {
		verify_AnyText_NotVisible(driver, "Issue New Business");
	}

	@And("User validates 'Approve' is not visible on closeout screen")
	public void user_validates_approve_is_not_visible_on_closeout_screen() throws Exception {
		verify_AnyText_NotVisible(driver, "Approve");
	}

	@And("User validates 'Submit for Approval' is visible on closeout screen")
	public void user_validates_submit_for_approval_is_visible_on_closeout() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		attachScreenShot(driver);
	}

	@And("User validates 'Pending Approval' is visible on closeout screen")
	public void user_validates_pending_approval_is_visible_on_closeout_screen() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Pending Approval");
	}

	@When("User override Underwriters 'Allow to Approve Age of Plumbing' as yes")
	public void user_override_uw_allow_to_approve_age_of_plumbing_as_yes() {
		sendText(driver.findElement(By.id("UserRoleAttrValue_7_97")), "Yes");
		click(driver.findElement(By.id("Save")));
		wait(3);
	}

	@And("User validates 'Issue New Business' is visible on closeout screen")
	public void user_validates_issue_new_business_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Issue New Business");
	}

	@And("User validates 'Approve' is visible on closeout screen")
	public void user_validates_approve_is_visible() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Approve");
	}

	@And("User validates 'Submit For Approval' is not visible on closeout screen")
	public void user_validates_submit_for_approval_is_not_visible() throws Exception {
		verify_AnyText_NotVisible(driver, "Submit For Approval");
	}

	@And("Underwriter User clicks Approve Button")
	public void uw_user_clicks_approve_button() throws Exception {
		click(closeoutChevron.btnApprove);
		wait(4);
	}

	@And("User selects payment type and issues policy")
	public void user_selects_payment_type_and_issues_policy() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		click(closeoutChevron.btnIssueNB);
		wait(5);
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		Hooks.scenario.log("TEST CASE COMPLETED");
	}

}
