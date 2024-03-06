package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4877_HO6_Submitforapproval_UW_Approve_Agent_Issue_2_referral extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String SecAppNum;

	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters HO6 product selection information and current date as effective date ")
	public void User_enters_HO6_product_selection_information_and_current_date_as_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}

	@When("User enters all required information on HO6 quote screen <mtr4877>")
	public void user_enters_all_required_information_on_ho6_quote_screen_mtr4877() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "None");
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ("0 to 3 Months"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@Then("User takes note of the application number <mtr4877>")
	public void User_takes_note_of_the_application_number_mtr4877_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("User takes note of the second application number <mtr4877>")
	public void User_takes_note_of_the_second_application_number_mtr4877_() throws Exception {
		// taking note
		try {
			SecAppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + SecAppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User Searchs for Application Number for <mtr4877>")
	public void User_searches_for_Application_Number_for_mtr4877() {

//		sendText(dashboard.txtSearchBar, "AGC0590474-01");
//		click(dashboard.search);
//				wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User Searchs for Second Application Number for <mtr4877>")
	public void User_searches_for_Second_Application_Number_for_mtr4877() {
		sendText(dashboard.txtSearchBar, SecAppNum);
		click(dashboard.search);
		wait(3);
	}

	@Given("User clicks View Workflow Comments")
	public void User_clicks_View_Workflow_Comments() {
		click(closeoutChevron.btnViewWorkflowComments);
		wait(2);
	}

	@Then("User validates a New Note has been created successfully in Notes List <mtr4877>")
	public void User_validates_a_New_Note_has_been_created_successfully_in_Notes_List_mtr4877() throws Exception {
		wait(5);
		switchToWindow(driver, "frmCMM");
		wait(10);
		click(dashboard.btnExpandHO6);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Risks with no prior insurance require underwriting approval.");
		wait(5);
		click(dashboard.btnExpandGeneralHO6);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for" + AppNum);
		Hooks.scenario.log("New Note has been created successfully!");
		attachScreenShot(driver);
		wait(5);
		switchToWindow(driver, "innovation#");

	}

	@Given("User issues policy <mtr4877>")
	public void user_issues_policy_mtr4877() {
		click(closeoutChevron.btnIssueNB);
		wait(5);
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
	}

	@Given("User enters EN Effective Date <mtr4877>")
	public void User_enters_EN_Effective_Date_mtr4877() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(3)));
		click(dashboard.btnStart);
		click(dashboard.btnStart);
	}

	@And("User clicks View Notes")
	public void User_clicks_View_Notes() {
		click(historyChevron.btnViewAll);
		wait(1);
	}

	@Then("User verifies persisted referral notes are displayed <mtr457>")
	public void User_verifies_persisted_referral_notes_are_displayed_mtr457() throws Exception {
		wait(5);

		click(dashboard.btnExpandHO6);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Risks with no prior insurance require underwriting approval.");
		wait(5);
		click(dashboard.btnExpandGeneralHO6);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for" + AppNum);
		Hooks.scenario.log("New Note has been created successfully!");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies the Change in Sinkhole Deductible <mtr4877>")
	public void User_verifies_the_Change_in_Sinkhole_Deductible_mtr4877() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Change in Sinkhole Deductible Must Be Approved");
		attachScreenShot(driver);
		wait(2);
	}

	@Then("User verifies EN HO6 policy has been created successfully <mtr4877>")
	public void User_verifies_EN_HO6_policy_has_been_created_successfully_mtr4877() throws Exception {
		wait(1);
		wait(10);
		driver.switchTo().defaultContent();
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);

	}

	@Then("User verifies persisted referral notes are displayed in Notes List")
	public void User_verifies_persisted_referral_notes_are_displayed_in_Notes_List() throws Exception {
		wait(5);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Risks with no prior insurance require underwriting approval.");
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for" + AppNum);
		Hooks.scenario.log("New Note has been created successfully!");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies third persisted referral notes are displayed in Notes List")
	public void User_verifies_third_persisted_referral_notes_are_displayed_in_Notes_List() throws Exception {
		wait(5);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver,
				"The following approvals are persisted:\r\n" + "Change in Sinkhole Deductible Must Be Approved");
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required");
		wait(5);
		click(dashboard.btnExpandHO6WC3);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.\r\n"
				+ "A Lapse in Coverage Greater than 0 Days Must be Approved (BasicPolicy.PreviousExpirationDt=02/01/2024, TriggerRuleIf=AnyChange)\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO6 policy form.");

		Hooks.scenario.log("New Note has been created successfully!");
		attachScreenShot(driver);
		wait(5);
	}
	@When("User answers all underwriting questions for HO6 <mtr4877>")
	public void user_answers_all_underwriting_questions_for_ho6_mtr4877() throws Exception {

		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");

		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);

		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
		selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
		wait(2);

	}

}
