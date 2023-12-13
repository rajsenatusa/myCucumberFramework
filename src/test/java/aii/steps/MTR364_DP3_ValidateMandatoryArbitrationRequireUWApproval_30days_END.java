package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR364_DP3_ValidateMandatoryArbitrationRequireUWApproval_30days_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endDate = currentDate.plusDays(30);
	static String applicationNumber;

	@When("User enters all required information on policy information screen <mtr364>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr364() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr364>")
	public void user_enters_all_current_date_as_prior_date_mtr364() throws Exception {
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
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen <mtr364>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr364() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
	}

	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr364>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs_mtr364()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User selects endorsement date as current date plus <30>days <mtr364>")
	public void user_selects_endorsement_date_as_current_date_plus_30_days_mtr364() {
		sendText(dashboard.txtSelectDate, dtf.format(endDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}

	@When("User takes note of the application number <mtr364>")
	public void user_takes_note_of_the_application__number_mtr364() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches previously created application <mtr364>")
	public void user_searches_previously_created_application_mtr364() throws Exception {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates that Endorsement transaction has been completed successfully and completes test <mtr363>")
	public void user_validates_that_endorsement_transaction_has_been_completed_successfully_and_completes_Test_mtr363()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_2_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Endorsement")) {
			System.out.println("DP3 Endorsement has been processed successfully");

		} else {
			System.out.println("DP3 Endorsement has been failed!");

		}

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
