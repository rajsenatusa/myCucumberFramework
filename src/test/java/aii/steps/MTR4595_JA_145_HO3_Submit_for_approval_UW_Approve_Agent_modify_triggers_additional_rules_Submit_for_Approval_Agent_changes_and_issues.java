package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4595_JA_145_HO3_Submit_for_approval_UW_Approve_Agent_modify_triggers_additional_rules_Submit_for_Approval_Agent_changes_and_issues
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;

	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@When("User enters all required information on HO3 quote screen <mtr4595>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr4595() {
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
		selectDropdownText(policyChevron.ddMonthsOccupied, "0 to 3 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(2);

	}

	@When("User enters all required information on HO3 dwelling screen <mtr4595>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr4595() {
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

	@Then("User takes note of the application number <mtr4595>")
	public void User_takes_note_of_the_application_number_mtr4595_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("User validates the Submit for Approval messages <mtr4595>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4595() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		wait(1);
		
	}

	@When("User enters all required information on policy information screen <mtr4595>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr4595() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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

	@When("User Searchs for Application Number for <mtr4595>")
	public void User_searches_for_Application_Number_for_mtr4595() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}

	@Then("User validates the Submitter Issues <mtr4595>")
	public void User_validates_the_Submitter_Issues_mtr4595() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		scrollToElement(driver.findElement(By.id("WorkflowComments")));
		attachScreenShot(driver);
		wait(2);

	}

	@Given("User clicks approve button <mtr4595>")
	public void User_clicks_approve_button_mtr4595() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		wait(2);
		attachScreenShot(driver);
		wait(2);

	}

	@Then("User validates View Notes <mtr4595>")
	public void User_validates_View_Notes_mtr4595() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation#");

	}

	@Given("User clicks Structures Rented to Others link")
	public void User_clicks_Structures_Rented_to_Others_link() throws Exception {

		scrollToElement(driver.findElement(By.id("CoverageList_SRROP_Add")));
		click(dwellingChevron.CoverageListAdd);
		wait(2);
//		switchToWindow(driver, "IFrameCoverageAction");

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"IFrameCoverageAction\"]")));

		wait(2);
		selectDropdownText(dwellingChevron.itemDesc, ("Guest House"));
		wait(2);
		click(dwellingChevron.addCoverageItem);
		wait(3);
		switchToWindow(driver, "model-ai.iscs.com/innovation");

	}

	@And("User selects Limited Fungi, Mold, Wet or Dry Rot, or Bacteria")
	public void User_selects_Limited_Fungi_Mold_Wet_or_Dry_Rot_or_Bacteria() {
		wait(1);
		scrollToElement(driver.findElement(By.id("Building.CovLFMLimit")));
		wait(3);
		selectDropdownText(dwellingChevron.ddBuildingCovLFMLimit, ("$50,000 Each Covered Loss/$50,000 Aggregate"));
		wait(1);

	}

	@Then("User verifies four triggered referrals")
	public void User_verifies_four_triggered_referrals() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		verify_AnyfirstText_IsDisplayed(driver,
				"A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		wait(3);
		scrollToElement(driver.findElement(By.id("WorkflowComments")));
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "	Risks with no prior insurance require underwriting approval.");
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");

	}

	@Then("User validates the second Submitter Issues <mtr4595>")
	public void User_validates_the_second_Submitter_Issues_mtr4595() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Structures Rented to Others Requires Underwriting Approval");
		verify_AnyfirstText_IsDisplayed(driver,
				"A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		scrollToElement(driver.findElement(By.id("WorkflowComments")));
		attachScreenShot(driver);
		wait(2);

	}

	@Then("User validates second View Notes <mtr4595>")
	public void User_validates_second_View_Notes_mtr4595() throws Exception {
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver,
				"Structures Rented to Others Requires Underwriting Approval (Coverage-SRROP-1-ItemDesc=Guest House, TriggerRuleIf=AnyChange)");
		verify_AnyfirstText_IsDisplayed(driver,
				"A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		click(closeoutChevron.btnIconExpandThird);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		switchToWindow(driver, "model-ai.iscs.com/innovation#");

	}

	@Given("User click issues new business and verifies the NB policy <mtr4595>")
	public void User_click_issues_new_business_and_verifies_the_NB_policy_mtr4595() throws Exception {

		click(closeoutChevron.btnIssueNB);
		wait(1);
		selectDropdownText(closeoutChevron.ddPaymentType, ("None"));
		wait(1);
		click(closeoutChevron.btnIssueNB);
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "Policy has been created");
		wait(1);

	}

	@Given("User clicks plus signs and validates Notes in View Notes")
	public void User_clicks_plus_signs_and_validates_Notes_in_View_Notes() throws Exception {

		switchToWindow(driver, "frmCMM");
		wait(2);
		click(closeoutChevron.btnIconExpand);
		wait(2);
		click(closeoutChevron.btnIconExpandSecond);
		wait(2);
		click(closeoutChevron.btnIconExpandThird);
		attachScreenShot(driver);
		wait(2);
		switchToWindow(driver, "model-ai.iscs.com/innovation#");
	}

	@Then("User verifies all referral notes are displayed in Notes List <mtr4595>")
	public void User_verifies_all_referral_notes_are_displayed_in_Notes_List_mtr4595() throws Exception {

		wait(3);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver,
				"Structures Rented to Others Requires Underwriting Approval (Coverage-SRROP-1-ItemDesc=Guest House, TriggerRuleIf=AnyChange)");
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver,
				"A Limit Increase for the Limited Fungi, Mold, Wet or Dry Rot, or Bacteria Coverage Must be Approved");
		wait(3);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for");
		wait(3);
		click(dashboard.btnExpandHO6WC3);
		verify_AnyfirstText_IsDisplayed(driver, "Risks with no prior insurance require underwriting approval.");
		verify_AnyfirstText_IsDisplayed(driver,
				"Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the HO3 policy form.");
		Hooks.scenario.log("New Notes have been created successfully!");
		wait(5);

	}
	@And("User clicks Endorse Policy button <mtr4595>")
	public void User_clicks_Endorse_Policy_button_mtr4595() throws Exception {
		wait(2);
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();
		wait(10);
		attachScreenShot(driver);
		wait(7);
		driver.switchTo().defaultContent();
		wait(2);
	}

}
