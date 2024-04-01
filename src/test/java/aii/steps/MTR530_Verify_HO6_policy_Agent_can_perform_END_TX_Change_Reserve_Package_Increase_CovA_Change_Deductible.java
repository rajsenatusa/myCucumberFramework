package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR530_Verify_HO6_policy_Agent_can_perform_END_TX_Change_Reserve_Package_Increase_CovA_Change_Deductible
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String nextDate;
	static String nextDate2;
	static String nextDate3;
	static String minAmountReinstate;
	static String CC_Form;
	static String CC_Version;
	static String CC_Name;

	@When("User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <mtr530>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_and_enters_25000_Cov_c_mtr530() {

		sendText(dwellingChevron.txtYearConstruction, "2024");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User validates that HO6 policy has been created successfully and takes note of the policy number <mtr530>")
	public void user_validates_that_ho6_policy_has_been_created_successfully_and_takes_note_of_thE_policy_number_mtr530()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO6 NB policy has been created successfully");
		} else {
			System.out.println("HO6 NB policy creation failed!");
		}
		wait(7);
		getPolicyNumber(driver);
		attachScreenShot(driver);
		wait(1);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for Policy Number for <mtr530>")
	public void user_searches_for_policy_number_for_mtr530() throws Exception {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User selects endorsement date as system date plus 30 days")
	public void User_selects_endorsement_date_as_system_date_plus_30_days() {
		wait(2);

		sendText(dashboard.txtSelectDate, dtf.format(currentDate.plusDays(30)));
		wait(3);
		click(dashboard.btnStart);
		click(dashboard.btnStart);

	}

	@When("User enters on HO6 dwelling screen and enters <Silver Reserve>")
	public void User_enters_on_HO6_dwelling_screen_and_enters_Silver_Reserve_ADwelling_101000_DeductibleAOP_2500_Deductible_Hurricane_2500_() {

		click(dwellingChevron.rbSilverReserve);
		(dwellingChevron.txtCoverageA).clear();
		sendText(dwellingChevron.txtCoverageA, "101000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$2,500");
		click(dwellingChevron.rbSilverReserve);
		click(dwellingChevron.btnSave);
	}

	@When("User validates messages in Issues")
	public void User_validates_messages_in_Issues() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Change in AOP Deductible may only be changed at Renewal.");
		verify_AnyfirstText_IsDisplayed(driver, "Change in Hurricane Deductible may only be changed at Renewal.");
		attachScreenShot(driver);

	}

	@When("User clicks Additional Interests chevron")
	public void User_clicks_Additional_Interests_chevron() throws Exception {
		click(additionalinterest.lnkAdditionalInterestChevron);
		wait(1);
		attachScreenShot(driver);

	}

//	@When("User clicks Add Additional Interest button")
//	public void User_clicks_Add_Additional_Interests_button() throws Exception {
//		click(additionalinterest.btnAdditionalInterest);
//		wait(1);
//
//	}

	@When("User enters Additional Interest Detail")
	public void User_enters_Additional_Interest_Detail() throws Exception {

		sendText(additionalinterest.txtMortgageeCode, "10002");
		selectDropdownText(additionalinterest.ddInterestType, "First Mortgagee");
		sendText(additionalinterest.txtLoanNumber, "1234");
		selectDropdownText(additionalinterest.ddEscrow, "Yes");
		sendText(additionalinterest.txtInterestName, "360 Mortgage Group LLC ISAOA");
		sendText(additionalinterest.txtIndexName, "360 Mortgage Group LLC ISAOA");
		sendText(additionalinterest.txtMailingAddr, "PO BOX 2987");
		sendText(additionalinterest.txtMailingAddrCity, "Jacksonville");
		selectDropdownText(additionalinterest.txtMailingAddrState, "Florida");
		sendText(additionalinterest.txtMailingAddrPostalCode, "32225");
		selectDropdownText(additionalinterest.txtMailingAddrRegion, "United States");
//		click(additionalinterest.addrVerify);
		
		wait(5);
		click(dwellingChevron.btnSave);
	}

	@When("User validates ChangeDeleteCopy hyperlinks display")
	public void User_validates_ChangeDeleteCopy_hyperlinks_display() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Change Delete Copy");
		attachScreenShot(driver);

	}

	@When("User clicks Save button")
	public void User_clicks_Save_button() throws Exception {
		click(additionalinterest.Save);
		wait(1);

	}

	@Then("User validates the Submitter Issues <mtr530>")
	public void User_validates_the_Submitter_Issues_mtr530() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Change in AOP Deductible may only be changed at Renewal.");
		verify_AnyfirstText_IsDisplayed(driver, "Change in Hurricane Deductible may only be changed at Renewal.");
		attachScreenShot(driver);
		wait(2);
	}

	@Given("User clicks approve button <mtr530>")
	public void User_clicks_approve_button_mtr530() throws Exception {
		wait(2);
		click(closeoutChevron.btnApprove);
		attachScreenShot(driver);
		wait(2);

	}

	@Then("User takes note of the application number <mtr530>")
	public void User_takes_note_of_the_application_number_mtr530_() throws Exception {
		// taking note
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("App Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Given("User Searchs for Application Number for <mtr530>")
	public void User_Searchs_for_Application_Number_for_mtr530() throws Exception {

		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);

	}

	@Given("User clicks plus button Next to Endorsement on the Transaction History")
	public void User_clicks_plus_button_Next_to_Endorsement_on_the_Transaction_History() throws Exception {
		click(historyChevron.btnExpand);
		wait(3);

	}

	@Then("User validates Endorsement Changes <mtr530>")
	public void User_validates_Endorsement_Changes_mtr530() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Deductible Change: All Other Perils Changed From $500 to $2,500");
		verify_AnyfirstText_IsDisplayed(driver, "Deductible Change: Hurricane Changed From $500 to $2,500");
		verify_AnyfirstText_IsDisplayed(driver,
				"Coverage Modified: A - Dwelling Limit 1 Changed From $106,000 to $101,000");
		verify_AnyfirstText_IsDisplayed(driver,
				"Coverage Modified: Ordinance or Law Limit 1 Changed From $26,500 to $25,250");
		attachScreenShot(driver);
		wait(2);
	}

}
