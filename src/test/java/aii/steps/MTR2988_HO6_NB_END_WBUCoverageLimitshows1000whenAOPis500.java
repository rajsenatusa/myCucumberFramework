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
import io.cucumber.java.en.When;

public class MTR2988_HO6_NB_END_WBUCoverageLimitshows1000whenAOPis500 extends CommonMethods {

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
	static String AppNummm;

	@And("User enters Producer Code for <mtr2988>")
	public void User_enters_Producer_Code_for_mtr2988() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}

	@When("User enters all required information on policy information screen for <mtr2988>")
	public void user_enters_all_required_information_on_policy_information_screen_for_mtr2988() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		quote.txtBirthDate.sendKeys("5/23/1990");
		click(quote.txtSearchName);
		quote.txtAddress.sendKeys("11216 SW PEMBROKE DR");
		quote.txtZipCode.sendKeys("34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 dwelling screen for <mtr2988>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_for_mtr2988() {

		dwellingChevron.txtSquareFeet.clear();
		dwellingChevron.txtSquareFeet.sendKeys("2500");
		sendText(dwellingChevron.txtPersonalPropertyC, "35000");
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$2,500");
		selectDropdownText(dwellingChevron.ddWaterBackupLimit, "$5,000");
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);

	}

	@When("User validates Water Back Up and Sump Overflow as <$5,000> on Quote")
	public void User_validates_Water_Back_Up_and_Sump_Overflow_as_5000_on_Quote() throws Exception {

		String ActualLimit = dwellingChevron.coverageLimitWBU.getText();
		expectedValue_foundValue(driver, "5,000", ActualLimit);
		scrollToAnyField(driver, "Coverage Options");
		attachScreenShot(driver);

		click(dwellingChevron.btnNext);
	}

	@When("User validates Quote Made")
	public void User_validates_Quote_Made() throws Exception {

		verifyQuoteMade(driver);
		getQuotePremium(driver);
		getQuoteNumber(driver);
	}

	@When("User answers all underwriting questions for <mtr2988>")
	public void user_answers_all_underwriting_questions_for_mtr2988() throws Exception {

		fillHO6_UWQuestions();

		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryOfUnit, "1");
		wait(2);

	}

	@When("User validates Water Back Up and Sump Overflow as <$5,000> on Application")
	public void User_validates_Water_Back_Up_and_Sump_Overflow_as_5000_on_Application() throws Exception {

		String ActualLimit = dwellingChevron.coverageLimitWBU.getText();
		expectedValue_foundValue(driver, "5,000", ActualLimit);
		scrollToAnyField(driver, "Coverage Options");
		attachScreenShot(driver);
	}
	@When("User enters Endorsement Effective Date for <mtr2988>")
	public void User_enters_Endorsement_Effective_Date_for_mtr2988()  {
		sendText(dwellingChevron.transactionEffectiveDt, dtf.format(currentDate.plusDays(10)));
		click(dashboard.btnStart);
		dashboard.btnStart.click();

	}
	@And("User Modifies AOP for <mtr2988>")
	public void User_Modifies_AOP_for_mtr2988()  {
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$500");
		click(dwellingChevron.btnSave);
	}
	@And("User finishes test <mtr2988>")
	public void User_finishes_test_mtr2988()  {
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}

}


