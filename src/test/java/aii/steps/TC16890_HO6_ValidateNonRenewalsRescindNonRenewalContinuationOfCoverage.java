package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16890_HO6_ValidateNonRenewalsRescindNonRenewalContinuationOfCoverage extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String app_Tx_Policy_Claim_Num;
	static String QuoteNum;
	static String switchToWindow;
	static String submitForApproval;
	static String PolicyNumber;
	static LocalDateTime endorseDate = currentDate.plusDays(30);
	static LocalDateTime expDate = currentDate.plusYears(1);
	static LocalDateTime nonRenDate1 = expDate.minusDays(125);
	static LocalDateTime nonRenDate2 = expDate.minusDays(124);

	@When("User enters all required information on policy information screen <tc16890>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16890() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "George");
		sendText(quote.txtLastName, "Walter");
		sendText(quote.txtBirthDate, "5/23/1990");
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

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc16890>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc16890() {

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
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen for <tc16890>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_for_tc16890() {

		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User validates Quote Made for <tc16890>")
	public void User_validates_Quote_Made_for_tc16890() throws Exception {

		wait(2);
		verifyQuoteMade(driver);
		getQuotePremium(driver);
		getQuoteNumber(driver);
		wait(2);
	}

	@When("User answers all underwriting questions for <tc16890>")
	public void user_answers_all_underwriting_questions_for_mtr2988() throws Exception {

		fillHO6_UWQuestions();

		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryOfUnit, "1");
		wait(2);

	}

	@When("User takes note of the Policy Number for <tc16890>")
	public void User_takes_note_of_the_Policy_Number_for_tc16890() {

		try {
			PolicyNumber = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + PolicyNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for Policy Number for <tc16890>")
	public void User_searches_for_Policy_Number_for_tc16890() {
		sendText(dashboard.txtSearchBar, PolicyNumber);
		click(dashboard.search);
		wait(3);
	}

	@When("User changes date transaction to exp.date minus <125> days for <tc16890>")
	public void user_changes_date_transaction_to_exp_date_minus_125_days_for_tc16890() throws Exception {

		 
		
		click(dashboard.btnAdmin);
		click(dashboard.btnChangeDate);
		wait(5);
		setNewDate(driver, dtf.format(nonRenDate1));
		wait(10);
		click(dashboard.btnChangeNewDate);
		wait(5);
		setBookDate(driver, dtf.format(nonRenDate1));
		wait(10);
		click(dashboard.btnChangeBookDate);

	}

	@When("User changes date transaction to exp.date minus <124> days for <tc16890>")
	public void user_changes_date_transaction_to_exp_date_minus_124_days_for_tc16890() throws Exception {

		click(dashboard.btnAdmin);
		click(dashboard.btnChangeDate);
		wait(5);
		setNewDate(driver, dtf.format(nonRenDate2));
		wait(10);
		click(dashboard.btnChangeNewDate);
		wait(5);
		setBookDate(driver, dtf.format(nonRenDate2));
		wait(10);
		click(dashboard.btnChangeBookDate);

	}

}