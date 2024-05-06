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

public class MTR4932_DP3_RulethathasauthorityamountpopulatedinthetextoftheruleMultireferral extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	
	@When("User enters DP3 product selection information and current date as effective date")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}
	@When("User enters all required information on DP3 quote screen <mtr4932>")
	public void user_enters_all_required_information_on_dp3_quote_screen_mtr4932() {
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
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}
	@When("User enters all required information on DP3 dwelling screen <mtr4932>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_mtr4932() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1700");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
//		selectDropdownText(dwellingChevron.ddQualityGrade, "Premium");
		
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(1);
		dwellingChevron.txtCoverageA.clear();
		dwellingChevron.txtCoverageA.sendKeys("1500000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(2);
//		click(dwellingChevron.btnCalculate);
//		wait(4);
//		click(dwellingChevron.btnSave);
//		wait(4);
//		dwellingChevron.txtCoverageC.sendKeys("300000");
//		wait(4);
////		dwellingChevron.txtCoverageA.sendKeys("3000000");
//		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
	}
	@Then("User takes note of the policy number <mtr4932>")
	public void User_takes_note_of_the_policy_number_mtr4932_() throws Exception {
	// taking note 
			try {
				policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
				Hooks.scenario.log("Policy Number: " + policyNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@Then("User validates the Submit for Approval messages <mtr4932>")
	public void User_validates_the_Submit_for_Approval_messages_mtr4932()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP3 policy form.");
		verify_AnyfirstText_IsDisplayed(driver, "Coverage C change cannot exceed $100,000 Must be Approved");
		wait(5);
		attachScreenShot(driver);
		wait(2);

	}
	@When("User Searchs for Policy Number for <mtr4932>")
	public void User_searches_for_Application_Number_for_mtr4932() {
		wait(3);
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@Then("User validates the Submitter Issues <mtr4932>")
	public void User_validates_the_Submitter_Issues_mtr4932()
			throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP3 policy form.");
		attachScreenShot(driver);
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage C change cannot exceed $100,000 Must be Approved");
		wait(3);
		attachScreenShot(driver);
		wait(2);
		
	}
	@Given("User clicks approve button <mtr4932>")
	public void User_clicks_approve_button_mtr4932() throws Exception {
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		attachScreenShot(driver);
		wait(2);
		
	}
	@And("User changes Months Occupied as 0 to 3 Months")
	public void User_changes_Months_Occupied_as_0_to_3_Months() {
		selectDropdownText(policyChevron.ddMonthsOccupied, "0 to 3 Months");
		
	}
	@And("User changes Coverage C Personal Property as 200000")
	public void User_changes_Coverage_C_Personal_Property_as_70_percentage() {
		sendText(dwellingChevron.txtPersonalPropertyC, "200000");
		 
	}

	
	@Then("User takes note of the application number <mtr4932>")
	public void User_takes_note_of_the_application_number_mtr4934_() throws Exception {
	// taking note 
			try {
				AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
				Hooks.scenario.log("App Number: " + AppNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	@When("User Searchs for Application Number for <mtr4932>")
	public void User_searches_for_Application_Number_for_mtr4934() {
		wait(3);
		sendText(dashboard.txtSearchBar, AppNum);
		wait(3);
		click(dashboard.search);
		wait(3);
	}
	@And("User clicks Endorse Policy button <mtr4932>")
	public void User_clicks_Endorse_Policy_button_mtr4932() throws Exception {
		wait(2);
		click(closeoutChevron.btnIssueNB);
		verify_AnyfirstText_IsDisplayed(driver, "Policy has been endorsed");
		wait(3);
		attachScreenShot(driver);
		wait(2);
		
	}
	@Then("User verifies EN DP3 policy has been created successfully <mtr4932>")
	public void User_verifies_EN_HO3_policy_has_been_created_successfully_mtr4934() throws Exception {
		wait(10);
		driver.switchTo().defaultContent();
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);
	
	}
	@Then("User verifies third persisted referral notes are displayed in Notes List <mtr4932>")
	public void User_verifies_third_persisted_referral_notes_are_displayed_in_Notes_List_mtr4932() throws Exception {
		wait(5);
		click(dashboard.btnExpandHO6WC);
		verify_AnyfirstText_IsDisplayed(driver,
				"The following approvals are persisted:\r\n"
				+ "Coverage C change cannot exceed $100,000 Must be Approved (Building.CovCLimit=200000, TriggerRuleIf=AnyChange)");
		wait(5);
		click(dashboard.btnExpandHO6WC2);
		verify_AnyfirstText_IsDisplayed(driver, "The following approvals are persisted:\r\n"
				+ "Owner Occupied risks that are occupied 0 to 3 months per year are ineligible for coverage under the DP3 policy form.");
		wait(5);
		click(dashboard.btnExpandHO6WC3);
		verify_AnyfirstText_IsDisplayed(driver, "Underwriting approval required for " + AppNum);

		Hooks.scenario.log("New Notes have been created successfully!");
		attachScreenShot(driver);
		wait(5);
	}
	@Given("User issues policy <mtr4934>")
	public void user_issues_policy_mtr4934() {

		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(15);
	}
	 
}	
	
	