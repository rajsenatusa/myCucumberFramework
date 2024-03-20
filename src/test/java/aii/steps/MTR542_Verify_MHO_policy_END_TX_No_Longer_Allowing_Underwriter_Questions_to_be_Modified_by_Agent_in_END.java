package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR542_Verify_MHO_policy_END_TX_No_Longer_Allowing_Underwriter_Questions_to_be_Modified_by_Agent_in_END extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User changes system date to current date <mtr542>")
	public void user_changes_system_date_to_current_date_mtr542() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}
	@When("User enters all required information on policy information screen <mtr542>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr542() {

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
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date <mtr542>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_mtr542() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on MHO3 dwelling screen <mtr542>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_mtr542() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "120000");
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("User answers underwriting questions 7,13,24,25 as Yes others NO for MHO3")
	public void user_answers_all_underwriting_questions_for_mho3_mtr542() throws Exception {
		// Application Underwriting Questions Chevron was filled here

		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question16, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question22, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question24, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question25, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");

		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);

		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarialmho3"));
		selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
		selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));
	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number <mtr542>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_mtr542() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
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
	@When("User selects endorsement date as current date <mtr542>")
	public void user_selects_endorsement_date_as_current_date_mtr542() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User validates that UW Questions is not editable <mtr542>")
	public void user_validates_that_uq_questions_is_not_editable_mtr542() throws Exception {
		verifyAnyElement_Disabled(driver, "Question_Conviction");
		wait(3);
		Hooks.scenario.log("UW Questions are not editable");
	}
	@When("User selects endorsement date as current date plus 10 days <mtr542>")
	public void user_selects_endorsement_date_as_current_date_plus10days_mtr542() {
		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(10)));
		wait(5);
		click(dashboard.btnStart);
		wait(5);
		click(dashboard.btnStart);
		wait(5);
	}
	@When("User searches previously created policy <mtr542>")
	public void user_searches_previously_created_policy_mtr542() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(1);
	}
	@When("User validates that UW Questions is editable <mtr542>")
	public void user_validates_that_uq_questions_is_editable_mtr542() throws Exception {
		verifyAnyElement_Enabled(driver, "Question_Conviction");
		wait(3);
		Hooks.scenario.log("UW Questions are editable");
	}
	@When("User changes answers for UW questions 12 and 17 as No <mtr542>")
	public void user_changes_answers_for_UW_questions_12_17_as_No_mtr542() throws Exception {
		selectDropdownText(uwquestionsChevron.mho3Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	@Then("User finalizes transaction and endorses policy and completes test <mtr542>")
	public void user_finalizes_transaction_and_endorses_policy_and_close_tabs_mtr542() throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		click(closeoutChevron.btnEndorsePolicy);
		wait(8);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
