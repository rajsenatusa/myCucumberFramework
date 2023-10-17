package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC16854_GOC_ValidateLossHistoryWith2orMoreLossesRequire_UWApproval_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	@When("User enters all required information on policy information screen <tc16854>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16854() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "MISTY P");
		sendText(quote.txtLastName, "TROMBLE JR");
		sendText(quote.txtBirthDate, "03/27/1950");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "4066 ARTESA DR");
		sendText(quote.txtZipCode, "33436");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on GOC quote screen <tc16854>")
	public void user_enters_all_required_information_on_goc_quote_screen_tc16854() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "DO NOT USE INSURANCE SCORE");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	
	@When("User enters all required information on GOC golfcart screen for <tc16854>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_tc16854() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$5,000");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$10,000/$20,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$500");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$500");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}
	@When("User enters driver information on driver screen <tc16854>")
	public void user_enters_driver_information_on_driver_screen_tc16854() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "T600421602600");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "5+");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	
	@When("User enters vehicles information on vehicles screen <tc16854>")
	public void user_enters_vehicles_information_on_vehicles_screen_tc16854() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2015");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Gas");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "10000");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User clicks Policy Chevron and validates 'Underwriting approval required prior to binding due to loss history' error message displayed")
	public void user_clicks_policy_chevron_and_validates_uw_approval_required_prior_to_binding_due_to_loss_history_error_message_displayed() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		waitImp(4);
		verify_AnyText_IsVisible(driver, "Driver received a No Hit on their MVR. This policy will require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		attachScreenShot(driver);
	}
	@When("User clicks Loss History Chevron and validates previous losses displayed and edit driver information on the losses")
	public void user_clicks_loss_history_chevron_and_validates_previous_losses_displayed_and_edit_driver_information_on_the_losses() throws Exception {
		click(driver.findElement(By.id("Wizard_LossHistory")));
		waitImp(3);
		verify_AnyLabel_IsVisible(driver, "Collision");
		getCountOfText(driver, "Collision");
		getCountOfText(driver, "CLUE");
		attachScreenShot(driver);
		
		clickonAnyButton(driver, "EditLink_4");
		waitImp(2);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		
		clickonAnyButton(driver, "EditLink_5");
		waitImp(2);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		
		clickonAnyButton(driver, "EditLink_6");
		waitImp(2);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		
		
		clickonAnyButton(driver, "EditLink_3");
		waitImp(2);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		attachScreenShot(driver);
		click(dwellingChevron.btnSave);
		
		clickonAnyButton(driver, "EditLink_2");
		waitImp(3);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		click(dwellingChevron.btnSave);
		
		clickonAnyButton(driver, "EditLink_1");
		waitImp(2);
		selectDropdownText(driver.findElement(By.id("LossHistory.DriverName")), "TROMBLE JR, MISTY P");
		click(dwellingChevron.btnSave);
	}
	@When("User clicks Policy Chevron and validates 'Underwriting approval required prior to binding due to loss history' and 'Underwriting referral required due to number of accidents' messages displayed")
	public void user_clicks_policy_chevron_and_validates_uw_approval_required_prior_to_binding_due_to_loss_history_error_and_uw_referral_required_messages_displayed() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		waitImp(4);
		verify_AnyText_IsVisible(driver, "Driver received a No Hit on their MVR. This policy will require Underwriting approval");
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to number of accidents");
		attachScreenShot(driver);
	}
	@And("User finalizes transaction and validates same error messages displayed on closeout screen")
	public void user_finalizes_transaction_and_validateS_same_error_messages_displayed_on_closeout_screen() throws Exception {
		
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to number of accidents");
		
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application number <tc16854>")
	public void user_takes_note_of_the_application__number_tc16854() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches application <tc16854>")
	public void user_searches_application_tc16854() throws Exception {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates 'Underwriting approval required prior to binding due to loss history' and 'Underwriting referral required due to number of accidents' messages displayed")
	public void user_validates_uw_approval_required_prior_to_binding_due_to_loss_history_error_and_uw_referral_required_messages_displayed() throws Exception {
		
		verify_AnyText_IsVisible(driver, "Underwriting approval required prior to binding due to loss history");
		verify_AnyText_IsVisible(driver, "Underwriting referral required due to number of accidents");
		attachScreenShot(driver);
	}
	@When("User process tx and finishes test tc16854")
	public void user_process_tx__finishes_test_tc16854() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		click(closeoutChevron.btnIssueNB);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
	
}
