package aii.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLDP1policy extends CommonMethods {

	@When("User enters DP1 product selection information and effective date")
	public void user_enters_dp1_product_selection_information_and_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp1);

	}

	@When("User enters all required information on DP1 quote screen")
	public void user_enters_all_required_information_on_dp1_quote_screen() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypedp1"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupieddp1"));
		selectDropdownText(policyChevron.ddPropertyManaged, ConfigsReader.getProperty("propertymanaged"));
		selectDropdownText(policyChevron.ddShortTermRental, ConfigsReader.getProperty("shorttermrental"));
		wait(1);
		click(policyChevron.btnNext);
		wait(3);

	}

	@When("User enters all required information on DP1 dwelling screen")
	public void user_enters_all_required_information_on_dp1_dwelling_screen() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User enters all required information on DP1 review screen")
	public void user_enters_all_required_information_on_dp1_review_screen() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);

	}

	@When("User creates DP1 application")
	public void user_creates_dp1_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);

		click(dwellingChevron.btnNext);

	}

	@When("User answers all underwriting questions for DP1")
	public void user_answers_all_underwriting_questions_for_dp1() throws Exception {

		fillDP1_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);

	}

	@Then("User validates that DP1 policy has been created successfully")
	public void user_validates_that_dp1_policy_has_been_created_successfully() {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, DP1 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Then("User creates DP1 policy with passing information from excel {string} sheet")
	public void User_creates_dp1_policy_with_passing_information_from_excel_sheet(String dp1customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLDP1.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, dp1customerInfo);

		for (Map<String, String> dataMap : excelList) {

			if (!dataMap.containsValue("")) {
				String firstName = dataMap.get("FirstName");
				String lastName = dataMap.get("LastName");
				String birthDate = dataMap.get("BirthDate");
				String address = dataMap.get("Address");
				String zipcode = dataMap.get("Zipcode");
				String effDate = dataMap.get("EffectiveDate");
				String state = dataMap.get("State");
				String previousCarr = dataMap.get("PreviousCarrier");
				String previousExp = dataMap.get("PreviousExpDate");
				String phone = dataMap.get("Phone");
				String constructtype = dataMap.get("ConsType");
				String occupancytype = dataMap.get("Occupancy");
				String monthsoccp = dataMap.get("Months");
				String yearcons = dataMap.get("ConstYear");
				String roof = dataMap.get("RoofMat");
				String quality = dataMap.get("Quality");
				String producerCode= dataMap.get("Producer");

				sendText(quote.txtFirstName, firstName);
				sendText(quote.txtLastName, lastName);
				wait(2);
				sendText(quote.txtBirthDate, birthDate);
				wait(2);
				click(quote.txtSearchName);
				sendText(quote.txtAddress, address);
				sendText(quote.txtZipCode, zipcode);
				wait(2);
				click(quote.btnVerifyAddress);
				wait(2);
				click(quote.btnCopyToMailAddress);
				click(quote.btnCopyToBillAddress);
				click(quote.btnSaveAndQuote);
				wait(2);

				// productSelection
				sendText(product.txtEffectiveDate, effDate);
				selectDropdownText(product.ddStateSelection, state);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionDp1);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				sendText(policyChevron.txtProducerCodeSel, producerCode);
				wait(2);
				click(dwellingChevron.btnSave);
				wait(3);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, constructtype);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
				selectDropdownText(policyChevron.ddShortTermRental, "No");
				wait(1);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				sendText(dwellingChevron.txtSquareFeet, "1600");
				wait(3);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				wait(2);
				selectDropdownText(dwellingChevron.ddQualityGrade, quality);
				click(dwellingChevron.btnCalculate);
				wait(4);
				click(dwellingChevron.btnSave);
				click(dwellingChevron.btnNext);
				wait(3);

				// Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);

				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here

				fillDP1_UWQuestions();
				wait(1);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here
				click(dwellingChevron.btnDwelling);
				wait(2);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				wait(2);
				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);

				// Closeout Chevron information was filled here

				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);
				wait(6);
				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, DP1 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);
				getPolicyNumber(driver);

				// Close unnecessary tabs
				closeUnnecessaryTabs();

				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.btnSignIn);
				wait(5);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(4);
				dashboard.btnNewQuote.click();
				WebElement element = driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");

			} else {
				break;
			}

		}

	}

	@Then("User creates DP1 application with passing information from excel {string} sheet")
	public void User_creates_dp1_application_with_passing_information_from_excel_sheet(String dp1customerInfo)
			throws Exception {
		String AppNum = null;
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLDP1.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, dp1customerInfo);

		for (Map<String, String> dataMap : excelList) {

			if (!dataMap.containsValue("")) {
				String firstName = dataMap.get("FirstName");
				String lastName = dataMap.get("LastName");
				String birthDate = dataMap.get("BirthDate");
				String address = dataMap.get("Address");
				String zipcode = dataMap.get("Zipcode");
				String effDate = dataMap.get("EffectiveDate");
				String state = dataMap.get("State");
				String previousCarr = dataMap.get("PreviousCarrier");
				String previousExp = dataMap.get("PreviousExpDate");
				String phone = dataMap.get("Phone");
				String constructtype = dataMap.get("ConsType");
				String occupancytype = dataMap.get("Occupancy");
				String monthsoccp = dataMap.get("Months");
				String yearcons = dataMap.get("ConstYear");
				String roof = dataMap.get("RoofMat");
				String quality = dataMap.get("Quality");

				sendText(quote.txtFirstName, firstName);
				sendText(quote.txtLastName, lastName);
				wait(2);
				sendText(quote.txtBirthDate, birthDate);
				wait(2);
				click(quote.txtSearchName);
				sendText(quote.txtAddress, address);
				sendText(quote.txtZipCode, zipcode);
				wait(2);
				click(quote.btnVerifyAddress);
				wait(2);
				click(quote.btnCopyToMailAddress);
				click(quote.btnCopyToBillAddress);
				click(quote.btnSaveAndQuote);
				wait(2);

				// productSelection
				sendText(product.txtEffectiveDate, effDate);
				selectDropdownText(product.ddStateSelection, state);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionDp1);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				//sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
				//click(dwellingChevron.btnSave);
				//wait(3);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, constructtype);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
				selectDropdownText(policyChevron.ddShortTermRental, "No");
				wait(1);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				sendText(dwellingChevron.txtSquareFeet, "1600");
				wait(3);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				wait(2);
				selectDropdownText(dwellingChevron.ddQualityGrade, quality);
				click(dwellingChevron.btnCalculate);
				wait(4);
				click(dwellingChevron.btnSave);
				click(dwellingChevron.btnNext);
				wait(3);

				// Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);

				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here

				fillDP1_UWQuestions();
				wait(1);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here
				click(dwellingChevron.btnDwelling);
				wait(2);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				wait(2);
				wait(2);
				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);

				// taking note of the application number and logs to the console

				try {
					AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
					Hooks.scenario.log("Application Number: " + AppNum);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Hooks.scenario.log(AppNum);

				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.btnSignIn);
				wait(5);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(4);
				dashboard.btnNewQuote.click();
				WebElement element = driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");

			} else {
				break;
			}

		}

	}
}
