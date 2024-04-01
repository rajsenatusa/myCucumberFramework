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

public class MTR4589_JA_145_HO3_Submit_for_approval_UW_Approve_Agent_Issue_1_referral extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on HO3 quote screen <mtr4589>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4589() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ("None"));
//		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(2);

	}

	@When("User enters all required information on HO3 dwelling screen <mtr4589>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4589() {
		// Quote Dwelling information was filled here
		wait(2);
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
		dwellingChevron.txtCoverageA.sendKeys("300000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}

	@Then("User takes note of the application number <mtr4589>")
	public void User_takes_note_of_the_application_number_mtr4589_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("User validates the Submit for Approval messages <mtr4589>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4589() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		wait(2);
		attachScreenShot(driver);
		wait(2);

	}

	@When("User Searchs for Application Number for <mtr4589>")
	public void User_searches_for_Application_Number_for_mtr4589() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}

	@Then("User validates the Submitter Issues <mtr4589>")
	public void User_validates_the_Submitter_Issues_mtr4589() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		attachScreenShot(driver);
		wait(2);

	}

	@Given("User clicks approve button <mtr4589>")
	public void User_clicks_approve_button_mtr4589() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		wait(2);
		attachScreenShot(driver);
		wait(2);

	}

	@Given("User clicks plus sign View Notes")
	public void User_clicks_plus_sign_View_Notes() throws Exception {

		switchToWindow(driver, "frmCMM");
		wait(2);
		click(closeoutChevron.btnIconExpand);

	}

	@Then("User validates View Notes")
	public void User_validates_View_Notes() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		attachScreenShot(driver);
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation#");

	}

	@Given("User click issues new business and verifies the NB policy <mtr4589>")
	public void User_click_issues_new_business_and_verifies_the_NB_policy_mtr4589() throws Exception {

		click(closeoutChevron.btnIssueNB);
		wait(1);
		selectDropdownText(closeoutChevron.ddPaymentType, ("None"));
		wait(1);
		click(closeoutChevron.btnIssueNB);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Policy has been created");
		wait(1);

	}

//	@When("User clicks Tasks chevron")
//	public void user_clicks_Tasks_chevron() throws Exception {
//		click(reviewChevron.Tasks);
//		wait(1);
//		attachScreenShot(driver);
//	}
	@Then("User validates System tasks for renewal")
	public void User_validates_System_tasks_for_renewal() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Manual Renewal Required for Policy");
		attachScreenShot(driver);
		wait(1);
		attachScreenShot(driver);

	}

	@Then("User verifies EN HO3 policy has been created successfully <mtr4589>")
	public void User_verifies_EN_HO3_policy_has_been_created_successfully_mtr4589() throws Exception {

		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "EN HO3 policy has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User validates View Notes <mtr4589>")
	public void User_validates_View_Notes_mtr4589() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		wait(2);
		attachScreenShot(driver);
		wait(5);
		driver.switchTo().defaultContent();

	}

	@Then("User verifies persisted referral note is displayed in Notes List <mtr4589>")
	public void User_verifies_persisted_referral_note_is_displayed_in_Notes_List_mtr4589() throws Exception {

		wait(1);
		click(closeoutChevron.btnIconExpandWorkflow);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);

	}

}
