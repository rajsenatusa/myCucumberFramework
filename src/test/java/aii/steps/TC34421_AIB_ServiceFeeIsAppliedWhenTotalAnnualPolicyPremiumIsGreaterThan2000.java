package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC34421_AIB_ServiceFeeIsAppliedWhenTotalAnnualPolicyPremiumIsGreaterThan2000 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static int currentYear_temp = LocalDateTime.now().getYear();
	static String currentYear = String.valueOf(currentYear_temp);

	@When("User enters all required information on policy information screen <tc34421>")
	public void user_enters_all_required_information_on_policy_information_screen_tc34421() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "5908 N Ola Ave");
		sendText(quote.txtZipCode, "33604");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on AIB quote screen for <tc34421>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc34421() throws Exception {

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		// selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		getInsuranceScore(driver, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User selects liability coverage on quote screen for <tc34421>")
	public void user_selects_liability_coverage_on_quote_screen_for_tc34421() {

		selectDropdownText(golfcartChevron.ddLiabilityCovType, "Split Limits");
		wait(6);
		selectDropdownText(aibChevron.ddStorageSlipRental, "No");
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, "$500,000/$500,000");
		selectDropdownText(aibChevron.ddMedicalPayments, "$10,000");
		selectDropdownText(aibChevron.ddUninsuredBoatCov, "Yes");
		wait(3);
		selectDropdownText(aibChevron.ddStorageSlipRental, "Yes");
		selectDropdownText(aibChevron.ddSupplementalLiabilityForBoats, "90 days");
		click(dwellingChevron.btnSave);
		wait(5);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User adds operator information on quote screen <tc34421>")
	public void user_adds_operator_information_on_quote_screen_tc34421() {
		click(aibChevron.btnAddOperator);
		wait(3);
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, "Single");
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, "Florida");
		sendText(aibChevron.txtLicenseNumber, "MN456BI");
		selectDropdownText(aibChevron.ddBoatExperience, "2");
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
		click(golfcartChevron.btnNextGocScreen);
	}

	@When("User enters all required information on AIB boat dwelling screen for <tc34421>")
	public void user_enters_all_required_information_on_aib_boat_dwelling_screen_for_tc34421() {

		click(aibChevron.btnAddBoat);
		wait(3);
		sendText(aibChevron.txtBoatYear, currentYear);
		sendText(aibChevron.txtBoatHinNumber, "1535KIUHO");
		selectDropdownText(aibChevron.ddBoatMake, "Lowe");
		sendText(aibChevron.txtBoatModel, "Boat Model");
		sendText(aibChevron.txtBoatPurchDate, dtf.format(currentDate));
		selectDropdownText(aibChevron.ddBoatFinanced, "Owned");
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, "60000");
		selectDropdownText(aibChevron.ddBoatHullType, "Cruiser");
		selectDropdownText(aibChevron.ddBoatHullMat, "Aluminum");
		selectDropdownText(aibChevron.ddHullLength, "26");
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, "Outboard");
		selectDropdownText(aibChevron.ddBoatMaxSpeed, "60 or less mph");
		selectDropdownText(aibChevron.ddBoatHullSettle, "Agreed Hull Value");
		selectDropdownText(aibChevron.ddHullDeductible, "1% (Minimum $250)");
		selectDropdownText(aibChevron.ddNumberOfEngines, "1");
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, "76 - 100");
		sendText(aibChevron.txtBoatEngine1Year, currentYear);
		sendText(aibChevron.txtBoatEngineMake, "Engine");
		sendText(driver.findElement(By.id("Vehicle.Engine1Model")), "Engine");
		sendText(aibChevron.txtEngineSerialNum, "456WSXD677G");
		sendText(aibChevron.txtBoatEngine1Hp, "85");
		selectDropdownText(aibChevron.ddTrailerCoverage, "None");
		selectDropdownText(aibChevron.ddBoatStorageType, "Rack");
		selectDropdownText(driver.findElement(By.id("Vehicle.MechanicalBreakdown")), "$250 deductible");
		selectDropdownText(driver.findElement(By.id("Vehicle.PersonalEffects")), "$10,000");
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");

		// click more with save
		driver.findElement(By.xpath("//span[text()='More']")).click();
		wait(2);
		driver.findElement(By.id("Save")).click();
		wait(3);
//		click(dwellingChevron.btnNext);
//		wait(3);
//		click(reviewChevron.btnReview);
//		wait(3);
	}

	@When("User adds second and third boat through copying links and clicks review Chevron")
	public void user_adds_Second_and_third_boat_through_copying_links_and_clicks_review_Chevron() throws Exception {
		// boat #2
		clickonAnyButton(driver, "CopyRisk");
		// click more with save
		driver.findElement(By.xpath("//span[text()='More']")).click();
		wait(2);
		driver.findElement(By.id("Save")).click();
		wait(3);

		// boat #3
		clickonAnyButton(driver, "CopyRisk");
		// click more with save
		driver.findElement(By.xpath("//span[text()='More']")).click();
		wait(2);
		driver.findElement(By.id("Save")).click();
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}

	@When("User clicks Review Chevron and selects 8 pay plan")
	public void user_clicks_Review_Chevron_and_selects_8_pay_plan() {
		driver.findElement(By.id("Tab_Policy")).click();
		driver.findElement(By.id("Wizard_Review")).click();
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");
		click(reviewChevron.btn8PaymentPlan);
	}

	@When("User enters all required information on AIB review screen <tc34421>")
	public void user_enters_all_required_information_on_aib_review_screen_tc34421() {

//		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
//		wait(4);
//		click(reviewChevron.btnFullPaymentRadio);
//		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(3);
	}

	@When("User validates service fee amounts")
	public void user_validates_service_fee_amounts() throws Exception {

		expectedReults_ExpectedValueFoundXpath(driver, "$16.00", "//*[@id=\"payplanlist\"]/table[2]/tbody/tr[3]/td[5]");
		expectedReults_ExpectedValueFoundXpath(driver, "$16.00", "//*[@id=\"payplanlist\"]/table[2]/tbody/tr[4]/td[5]");
		expectedReults_ExpectedValueFoundXpath(driver, "$32.00", "//*[@id=\"payplanlist\"]/table[2]/tbody/tr[5]/td[5]");
		expectedReults_ExpectedValueFoundXpath(driver, "-", "//*[@id=\"payplanlist\"]/table[2]/tbody/tr[6]/td[5]");
		expectedReults_ExpectedValueFoundXpath(driver, "$6.00", "//*[@id=\"payplanlist\"]/table[2]/tbody/tr[7]/td[5]");
		attachScreenShot(driver);
	}

	@Then("User issues policy and close unnecessary tabs and taking note of the policy number and completes test <tc34421>")
	public void user_issues_policy_and_close_unnecessary_tabs_tc34421() throws Exception {
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		wait(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("AIB NB policy has been created successfully");
		} else {
			System.out.println("AIB policy creation failed!");
		}
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
}
