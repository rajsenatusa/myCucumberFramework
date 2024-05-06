package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5331_IM614_AIB_Validate_policy_cannot_be_issued_wo_filling_UW_questions extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User changes system date to current date <mtr5331>")
	public void user_changes_system_date_to_current_date_mtr5331() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr5331>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5331() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
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
	@When("User enters all required information on AIB quote screen for <mtr5331>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_mtr5331() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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
	@When("User selects liability coverage on quote screen for <mtr5331>")
	public void user_selects_liability_coverage_on_quote_screen_for_mtr5331() {

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
	@When("User adds operator information on quote screen <mtr5331>")
	public void user_adds_operator_information_on_quote_screen_mtr5331() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Alabama");
		sendText(aibChevron.txtLicenseNumber, "t120100849500");
		selectDropdownText(aibChevron.ddBoatExperience, "4");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters all required information on AIB boat dwelling screen for <mtr5331>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_mtr5331() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, "2021");
		sendText(aibChevron.txtBoatHinNumber, "1548799652");
		selectDropdownText(aibChevron.ddBoatMake, "Bayliner");
		sendText(aibChevron.txtBoatModel, "Testing");
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
		sendText(aibChevron.txtBoatEngine1Year, "2021");
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
	@When("User clicks Policy Chevron <mtr5331>")
	public void user_clicks_policy_chevron_mtr5331() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}
	@When("User modify address and copies to mailing and billing address fields")
	public void user_modify_address_mtr5331() throws Exception {
		sendText(quote.txtAddressNumber,"12 Needle Cast Ln");
		sendText(quote.txtPostalCode, "32461");
		click(quote.btnVerifyAddress2);
		wait(2);
		click(driver.findElement(By.linkText("Copy to Mailing Address")));
		driver.findElement(By.linkText("Copy to Billing Address"));
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User finalizes transaction and validates 'Complete all required Underwriting Questions with an asterisk. fix...' message <mtr5331>")
	public void user_finalizes_transaction_and_validates_issue_message_mtr5331() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Complete all required Underwriting Questions with an asterisk (*). ");
	}
	@When("User enters all required information on AIB review screen <mtr5331>")
	public void user_enters_all_required_information_on_aib_review_screen_mtr5331() {
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(3);
	}
	@Then("User issues policy and close unnecessary tabs and completes test <mtr5331>")
	public void user_issues_policy_and_close_unnecessary_tabs_completes_test_mtr5331() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
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
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
