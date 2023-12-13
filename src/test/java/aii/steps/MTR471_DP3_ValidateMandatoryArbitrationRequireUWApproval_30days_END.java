package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR471_DP3_ValidateMandatoryArbitrationRequireUWApproval_30days_END extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endDate = currentDate.plusDays(30);
	static String applicationNumber;
	static String policyNum;

	@When("User selects endorsement date as current date plus <30>days")
	public void user_selects_endorsement_date_as_current_date_plus_30_days() {
		sendText(dashboard.txtSelectDate, dtf.format(endDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User enters all required information on policy information screen <mtr471>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr471() {

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
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr471>")
	public void user_enters_all_current_date_as_prior_date_mtr471() throws Exception {
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
	@When("User enters all required information on DP3 dwelling screen <mtr471>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr471() {

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
	@When("User clicks dwelling tab and validates MMA selected as No and switches MMA as Yes")
	public void user_clicks_dwelling_tab_and_validates_mma_selected_as_no_and_switches_mma_as_yes() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(4);
		verifyAnyDropdownDefaultedValue(driver, "BuildingExt.MMAInd", "No");
		attachScreenShot(driver);
		selectDropdownText(dwellingChevron.d1MediationArbit, "Yes");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(5);
	}

	@When("User validates <Mediation Arbitration Change requires Underwriting Approval> message has been displayed")
	public void user_validates_error_message_has_been_displayed() throws Exception {
		verify_AnyLabel_IsVisible(driver, "Mediation Arbitration Change requires Underwriting Approval");
		attachScreenShot(driver);
	}

	@When("User takes note of the application number")
	public void user_takes_note_of_the_application__number() throws Exception {
		try {
			applicationNumber = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + applicationNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User finalizes transaction and submits for approval")
	public void user_finalizes_transaction_and_submits_for_approval() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		sendText(closeoutChevron.txtWorkflowComments, "testtesttesttest");
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		wait(5);
		click(reviewChevron.btnDialogOk);
		wait(2);

//		// Close unnecessary tabs
//		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//		for (int i = tabs.size() - 1; i > 0; i--) {
//			driver.switchTo().window(tabs.get(i));
//			driver.close();
//		}
//
//		// Switch back to the main page
//		driver.switchTo().window(tabs.get(0));
	}
	@When("User searches previously created application")
	public void user_searches_previously_created_application() throws Exception {
		sendText(dashboard.txtSearchBar, applicationNumber);
		click(dashboard.search);
		wait(3);
	}

	@When("UW User approves application")
	public void user_approves_application() throws Exception {
		click(closeoutChevron.btnApprove);
		wait(5);
	}

	@When("User completes endorsement")
	public void user_completes_endorsement() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(5);
	}
}
