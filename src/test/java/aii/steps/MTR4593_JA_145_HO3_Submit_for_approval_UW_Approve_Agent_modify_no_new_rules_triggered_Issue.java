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

public class MTR4593_JA_145_HO3_Submit_for_approval_UW_Approve_Agent_modify_no_new_rules_triggered_Issue
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on HO3 quote screen <mtr4593>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4593() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ("AAA"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
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

	@When("User enters all required information on HO3 dwelling screen <mtr4593>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4593() {
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
//		dwellingChevron.txtCoverageA.sendKeys("300000");
		wait(1);
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		wait(1);
		scrollToElement(driver.findElement(By.id("CoverageList_SRROP_Add")));
		click(dwellingChevron.CoverageListAdd);
		wait(2);
//		switchToWindow(driver, "IFrameCoverageAction");

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"IFrameCoverageAction\"]")));

		wait(2);
		selectDropdownText(dwellingChevron.itemDesc, ("Guest House"));
		wait(2);
//		(dwellingChevron.itemLimit1Value).clear();
//		wait(2);
//		sendText(dwellingChevron.itemLimit1Value, ("$10,000"));
//		wait(2);
		click(dwellingChevron.addCoverageItem);
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation");
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}

	@Then("User takes note of the application number <mtr4593>")
	public void User_takes_note_of_the_application_number_mtr4593_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("User validates the Submit for Approval messages <mtr4593>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4593() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		wait(2);
		attachScreenShot(driver);
		wait(2);

	}

	@When("User Searchs for Application Number for <mtr4593>")
	public void User_searches_for_Application_Number_for_mtr4593() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}

	@Then("User validates the Submitter Issues <mtr4593>")
	public void User_validates_the_Submitter_Issues_mtr4593() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		scrollToElement(driver.findElement(By.id("WorkflowComments")));
		attachScreenShot(driver);
		wait(2);

	}

	@Given("User clicks approve button <mtr4593>")
	public void User_clicks_approve_button_mtr4593() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		wait(2);
		attachScreenShot(driver);
		wait(2);

	}

	@Given("User click issues new business and verifies the NB policy <mtr4593>")
	public void User_click_issues_new_business_and_verifies_the_NB_policy_mtr4593() throws Exception {

		click(closeoutChevron.btnIssueNB);
		wait(1);
		selectDropdownText(closeoutChevron.ddPaymentType, ("None"));
		wait(1);
		click(closeoutChevron.btnIssueNB);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Policy has been created");
		wait(1);

	}

	@Then("User verifies persisted referral note is displayed in Notes List <mtr4593>")
	public void User_verifies_persisted_referral_note_is_displayed_in_Notes_List_mtr4593() throws Exception {

		wait(1);
		click(closeoutChevron.btnIconExpandWorkflow);
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);

	}

	@Then("User verifies EN HO3 policy has been created successfully <mtr4593>")
	public void User_verifies_EN_HO3_policy_has_been_created_successfully_mtr4593() throws Exception {

		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "EN HO3 policy has been created successfully");
		attachScreenShot(driver);

	}

	@Then("User validates View Notes <mtr4593>")
	public void User_validates_View_Notes_mtr4593() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		attachScreenShot(driver);
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation#");

	}

	@And("User checks Modify Application button")
	public void User_checks_Modify_Application_button() throws Exception {
		wait(2);
		closeoutChevron.btnModifyApplication.click();
		closeoutChevron.btnDialogOk.click();
		wait(2);

	}

	@And("User enters a new DOB in Insured Information")
	public void User_enters_a_new_DOB_in_Insured_Information() {
		sendText(policyChevron.txtInsuredBirthDt, ("12/12/1950"));
		click(policyChevron.btnSave);
		wait(2);
	}

	@And("User validates 'Structures Rented to Others Requires Underwriting Approval' is not visible on closeout screen")
	public void User_validates_Structures_Rented_to_Others_Requires_Underwriting_Approval_is_not_visible_on_closeout_screen()
			throws Exception {
		verify_AnyText_NotVisible(driver, "Structures Rented to Others Requires Underwriting Approval");
		attachScreenShot(driver);
	}

}
