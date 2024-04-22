package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR5332_IM_614_AIB_END_Validate_mailing_address_can_be_updated_through_copy_to_mailing_address_link extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User changes system date to current date <mtr5332>")
	public void user_changes_system_date_to_current_date_mtr5332() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr5332>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr5332() {

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
	@When("User enters all required information on AIB quote screen for <mtr5332>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_mtr5332() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		wait(2);
		
//		selectDropdownText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(2);
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
	@When("User selects liability coverage on quote screen for <mtr5332>")
	public void user_selects_liability_coverage_on_quote_screen_for_mtr5332() {

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
	@When("User adds operator information on quote screen <mtr5332>")
	public void user_adds_operator_information_on_quote_screen_mtr5332() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "Y123101952915");
		selectDropdownText(aibChevron.ddBoatExperience, "4");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}
	@When("User enters all required information on AIB boat dwelling screen for <mtr5332>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_mtr5332() {

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
	@When("User enters all required information on AIB review screen <mtr5332>")
	public void user_enters_all_required_information_on_aib_review_screen_mtr5332() {
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "Yes");
		wait(3);
	}
	@Then("User takes note of the application number <mtr5332>")
	public void User_takes_note_of_the_application_number_mtr5332_() throws Exception {
	// taking note 
			try {
				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
				Hooks.scenario.log("App Number: " + AppNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@When("User Searchs for Application Number for <mtr5332>")
	public void User_searches_for_Application_Number_for_mtr5332() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}
	@Given("User clicks approve button <mtr5332>")
	public void User_clicks_approve_button_mtr5332() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		attachScreenShot(driver);
		wait(2);
		
	}
}