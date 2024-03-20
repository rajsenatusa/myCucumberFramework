package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4934_HO3_RulethathasauthorityamountpopulatedinthetextoftheruleMultireferral2 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	
	@When("User enters all required information on HO3 quote screen <mtr4934>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4934() {
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
		selectDropdownText(policyChevron.ddMonthsOccupied, "0 to 3 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	
	}
	@When("User enters all required information on HO3 dwelling screen <mtr4934>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4934() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		selectDropdownText(dwellingChevron.ddMediationArbit, ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		dwellingChevron.txtCoverageA.sendKeys("3000000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}
	
	@Then("User takes note of the application number <mtr4934>")
	public void User_takes_note_of_the_application_number_mtr4934_() throws Exception {
	// taking note 
			try {
				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
				Hooks.scenario.log("App Number: " + AppNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@When("User Searchs for Application Number for <mtr4934>")
	public void User_searches_for_Application_Number_for_mtr4934() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@Then("User validates the Submit for Approval messages")
	public void User_validates_the_Submit_for_Approval_messages()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		wait(5);
		attachScreenShot(driver);
		wait(2);

	}
	@Then("User validates the Submit for Approval messages <mtr4934>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4934()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A is High Value Dwelling limit that will require underwriting review.");
		wait(5);
		attachScreenShot(driver);
		wait(2);

	}
	@Given("User clicks approve button <mtr4934>")
	public void User_clicks_approve_button_mtr4934() throws Exception {
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		attachScreenShot(driver);
		wait(2);
		
	}
	@Given("User clicks approve button as UW manager <mtr4934>")
	public void User_clicks_approve_button_as_UW_managermtr4934() throws Exception {
		click(closeoutChevron.btnApprove);
		attachScreenShot(driver);
		click(dashboard.btnUserMenu);
		wait(1);
		click(dashboard.btnSignOut);
		wait(2);
		Hooks.scenario.log("Sign out was clicked");
		
	}
	@Then("User validates the Application is submitted for approval")
	public void User_validates_the_Application_is_submitted_for_approval()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "The application has been submitted for approval.");
		wait(3);
		attachScreenShot(driver);
		wait(2);

	}
	@Then("User validates the Submitter Issues")
	public void User_validates_the_Submitter_Issues()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		attachScreenShot(driver);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		wait(3);
		attachScreenShot(driver);
		wait(2);

	}
	@Then("User validates the Submitter Issues <mtr4934>")
	public void User_validates_the_Submitter_Issues_mtr4934()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		attachScreenShot(driver);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A is High Value Dwelling limit that will require underwriting review.");
		wait(3);
		attachScreenShot(driver);
		wait(2);

	}
	@And("User click issues new business and verifies the NB policy")
	public void User_click_issues_new_business_and_verifies_the_NB_policy() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, ("None"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Policy has been created");
		wait(3);
		attachScreenShot(driver);
		wait(2);
		
	}
	@Given("User enters EN Effective Date <mtr4934>")
	public void User_enters_EN_Effective_Date_mtr4934() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate.plusDays(3)));
		click(dashboard.btnStart);
		click(dashboard.btnStart);
	}
	@Then("User validates a New Notes have been created successfully in View Notes <mtr4877>")
	public void User_validates_a_New_Notes_have_been_created_successfully_in_View_Notes_mtr4877() throws Exception {
		wait(5);
		switchToWindow(driver, "frmCMM");
		wait(10);
		click(dashboard.btnExpandHO3VN);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Coverage A is High Value Dwelling limit that will require underwriting review.");
		wait(5);
		click(dashboard.btnExpandHO3VN2);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		wait(5);
		click(dashboard.btnExpandHO3VN3);
		verify_AnyfirstText_IsDisplayed(driver, "test");
		attachScreenShot(driver);
		wait(5);
		switchToWindow(driver, "innovation#");

	}
	@Then("User verifies third persisted referral notes are displayed in Notes List <mtr4877>")
	public void User_verifies_third_persisted_referral_notes_are_displayed_in_Notes_List_mtr4877() throws Exception {
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver,
				"The following approvals are persisted:\r\n"
				+ "Coverage A is High Value Dwelling limit that will require underwriting review.");
		wait(5);
		click(dashboard.btnExpandHO6WC3);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		wait(5);
		click(dashboard.btnExpandHO3VN4);
		verify_AnyfirstText_IsDisplayed(driver, " test");

		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);
	}
	@Then("User verifies EN HO3 policy has been created successfully <mtr4934>")
	public void User_verifies_EN_HO3_policy_has_been_created_successfully_mtr4934() throws Exception {
		wait(10);
		driver.switchTo().defaultContent();
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);
	
	}
}
