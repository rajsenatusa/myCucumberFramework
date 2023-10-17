package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR1412_GOC_ValidateNoHitRequireUWApproval_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String applicationNumber;

	@When("User enters all required information on policy information screen <mtr1412>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr1412() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1899 Montana Ave NE");
		sendText(quote.txtZipCode, "33703");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on GOC golfcart screen for <mtr1412>")
	public void user_enters_all_required_information_on_goc_golfcart_screen_mtr1412() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Combined Single Limit");
		wait(2);
		selectDropdownText(golfcartChevron.ddCombinedSingleLimit, "$300,000");
		selectDropdownText(golfcartChevron.ddVehicleDefaultOtherThanCol, "$100");
		selectDropdownText(golfcartChevron.ddVehicleDefaultCol, "$100");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@When("User enters driver information on driver screen <mtr1412>")
	public void user_enters_driver_information_on_driver_screen_mtr1412() {

		click(golfcartChevron.btnAddDriver);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(golfcartChevron.ddLicenseState, "Florida");
		sendText(golfcartChevron.txtLicenseNumber, "C425712345720");
		selectDropdownText(golfcartChevron.ddDriverGcExp, "5+");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters vehicles information on vehicles screen <mtr1412>")
	public void user_enters_vehicles_information_on_vehicles_screen_mtr1412() {

		click(golfcartChevron.btnAddGolfcart);
		wait(3);
		sendText(golfcartChevron.txtModelYear, "2015");
		sendText(golfcartChevron.txtGcVinNumber, "452PJ8GGH77");
		sendText(golfcartChevron.txtGcMake, "Test Make");
		sendText(golfcartChevron.txtGcModel, "Test Model");
		selectDropdownText(golfcartChevron.ddGcPowerType, "Gas");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, "<30 mph");
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		selectDropdownText(golfcartChevron.ddPurchasedLeasedSel, "Owned");
		sendText(golfcartChevron.txtGcMarketValue, "10000");
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(4);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User validates 'Driver received a No Hit on their MVR. This policy will require Underwriting approval' message has been displayed and 'Submit For Approval' 'Modify Application' labels are visible")
	public void user_validates_error_message_and_labels() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Submit For Approval");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application number <mtr1412>")
	public void user_takes_note_of_the_application__number() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for the application <mtr1412>")
	public void user_searches_for_the_application_mtr1412() throws Exception {
		setPolicyNumSearch(driver, applicationNumber);
		click(dashboard.search);
		wait(3);
	}
	@When("UW User validates 'Driver received a No Hit on their MVR. This policy will require Underwriting approval' message has been displayed and approves transaction")
	public void uwuser_approves_transaction() throws Exception {
		verify_AnyText_IsVisible(driver, "Driver received a No Hit on their MVR. This policy will require Underwriting approval");
		click(closeoutChevron.btnApprove);
		wait(3);
	}
	@When("User validates that GOC policy has been created successfully and complete test")
	public void user_validates_that_goc_policy_has_been_created_successfully() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("GolfCart NB policy has been created successfully");
		} else {
			System.out.println("Golf Cart Policy Creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
	
}
