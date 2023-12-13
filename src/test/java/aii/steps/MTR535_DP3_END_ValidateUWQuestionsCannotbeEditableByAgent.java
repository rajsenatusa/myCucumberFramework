package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR535_DP3_END_ValidateUWQuestionsCannotbeEditableByAgent extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters DP3 product selection information and effective date as current date")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}

	@When("User clicks Underwriting Questions Chevron")
	public void user_clicks_underwriting_questions_chevron() {
		wait(1);
		click(uwquestionsChevron.lnkUwQuestionsTab);
		wait(4);
	}
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <mtr535>")
	public void user_enters_all_current_date_as_prior_date_mtr535() throws Exception {
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
	@When("User enters all required information on DP3 dwelling screen <mtr535>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr535() {

		//sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Architectural Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCovALimit, "400000");
		sendText(dwellingChevron.txtPersonalPropertyC, "12000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User enters all required information on policy information screen <mtr535>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr535() {

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
	@When("User validates that UW Questions is not editable")
	public void user_validates_that_uq_questions_is_not_editable() throws Exception {
		verifyAnyElement_Disabled(driver, "Question_Conviction");
		wait(3);
		System.out.println("UW Questions are not editable");
	}

	@When("User takes note of the policy number")
	public void user_takes_note_of_the_policy_number() {
		try {
			policyNum = driver.findElement(By.id("QuoteAppSummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User cancels transaction")
	public void user_cancels_transaction() {
		click(dashboard.btnDelete);
		wait(3);
		click(reviewChevron.btnDialogOk);
		wait(5);
	}

	@When("User searches previously created policy")
	public void user_searches_previously_created_policy() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(1);
	}

	@When("User validates that UW Questions is editable")
	public void user_validates_that_uq_questions_is_editable() throws Exception {
		verifyAnyElement_Enabled(driver, "Question_Conviction");
		wait(3);
		System.out.println("UW Questions are editable");
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date")
	public void user_enters_all_current_date_as_prior_date() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects endorsement date as current date")
	public void user_selects_endorsement_date_as_current_date() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
}
