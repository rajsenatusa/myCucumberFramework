package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR1445_GOC_GOCAgentChangeDateTransaction extends CommonMethods{
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <mtr1445>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1445() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Aaron");
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
	
	@When("User enters all required information on GOC golfcart screen for <mtr1445>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr1445() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, "$2,500");
		selectDropdownText(golfcartChevron.ddUninsuredInjury, "$20,000/$40,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$500");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$500");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}
	@When("User enters driver information on driver screen <mtr1445>")
	public void user_enters_driver_information_on_driver_screen_mtr1445() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "4566LJJJ");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters vehicles information on vehicles screen <mtr1445>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr1445() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2020");
		sendText(golfcartChevron.txtGcVinNumber, "458TK8JJI77");
		sendText(golfcartChevron.txtGcMake, "Golf Make");
		sendText(golfcartChevron.txtGcModel, "Golf Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Electric");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "5350");
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, "$100");
		selectDropdownText(golfcartChevron.ddCollisionDed, "$100");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		sendText(golfcartChevron.txtGaragingAddress, "11256 SW 62nd Avenue RD Ocala");
		sendText(golfcartChevron.txtGaragingZipCode, "34476");
		click(golfcartChevron.btnVerifyAddress);
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User validates that GOC policy has been created successfully and takes note of the policy number <mtr1445>")
	public void user_validates_that_goc_policy_has_been_created_successfully_mtr1445() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("GolfCart NB policy has been created successfully");
		} else {
			System.out.println("Golf Cart Policy Creation failed!");
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
	@When("User searches for Policy Number for <mtr1445>")
	public void user_searches_for_policy_number_for_mtr1445() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects current date plus 61 days as new effective date mtr1445")
	public void User_selects_current_date_plus_61_days_as_new_effective_date_mtr1445() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(61)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}
	@And("User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' text is visible mtr1445")
	public void User_validates_maximum_changedate_allowed_60_days_text_visible_mtr1445() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		attachScreenShot(driver);
	}
	@And("User selects current date plus 60 days as new effective date mtr1445")
	public void User_selects_current_date_plus_60_days_as_new_effective_date_mtr1445() {
		sendText(historyChevron.txtNewEffectiveDate, dtf.format(currentDate.plusDays(60)));
		wait(6);
		click(historyChevron.btnStart);
		wait(5);
		click(historyChevron.btnStart);
		wait(1);
	}
	@When("User validates 'Requested effective date change requires underwriting review' text is visible and previous text not visible mtr1445")
	public void user_validates_requested_effective_date_change_requires_underwriting_review_text_is_visible_and_previous_text_not_visible_mtr1445() throws Exception {
		verify_AnyText_NotVisible(driver, "Maximum change date allowed is +/- 60 days. You will need to rewrite this policy.");
		verify_AnyText_IsVisible(driver, "Requested effective date change requires underwriting review");
		attachScreenShot(driver);
		wait(1);
	}
	@When("User takes note of the application number <mtr1445>")
	public void user_takes_note_of_the_application__number_mtr1445() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches application <mtr1445>")
	public void user_searches_application_mtr1445() throws Exception {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User validates 'Requested effective date change requires underwriting review' text is visible mtr1445")
	public void User_validates_requested_effective_date_change_requires_underwriting_review_text_visible_mtr1445() throws Exception {
		verify_AnyText_IsVisible(driver, "Requested effective date change requires underwriting review");
		attachScreenShot(driver);
	}
	@When("User process tx and validates expected messages and finishes test mtr1445")
	public void user_process_tx_and_validates_expected_messages_finishes_test_mtr1445() throws Exception {
		click(closeoutChevron.btnIssueNB);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		verify_AnyText_IsVisible(driver, "Change Date");
		verify_AnyText_IsVisible(driver, "Change Effective Date from " + dtf.format(currentDate) + " to " + dtf.format(currentDate.plusDays(60)));
		Hooks.scenario.log("Test Case Completed!");
	}
}
