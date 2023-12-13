//updated on 07/14/2023 by Can Yavas

package aii.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

 
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO6policy extends CommonMethods {

	@When("User enters HO6 product selection information and effective date")
	public void user_enters_ho6_product_selection_information_and_effective_date() {

		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}
	@When("User enters all required information on HO6 quote screen")
	public void user_enters_all_required_information_on_ho6_quote_screen() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen")
	public void user_enters_all_required_information_on_ho6_dwelling_screen() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}

	@When("User enters all required information on HO6 review screen")
	public void user_enter_all_required_information_on_ho6_review_screen() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(1);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(dwellingChevron.btnSave);
	}

	@When("User creates HO6 application")
	public void user_creates_ho6_application() {
		click(reviewChevron.btnCreateApplication);
		wait(1);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(1);
		click(dwellingChevron.btnNext);
	}

	@When("User answers all underwriting questions for HO6")
	public void user_answers_all_underwriting_questions_for_ho6() throws Exception {

		fillHO6_UWQuestions();

		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
		selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
		wait(2);

	}

	@Then("User validates that HO6 policy has been created successfully")
	public void user_validates_that_ho6_policy_has_been_created_successfully() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO6 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);
		
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@Then("User creates HO6 policy with passing information from excel {string} sheet")
	public void User_creates_ho6_policy_with_passing_information_from_excel_sheet(String ho6customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLHO6.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, ho6customerInfo);

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
				String quality = dataMap.get("Quality");
				String roof = dataMap.get("RoofMat");

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
				click(product.btnProductSelectionHo6);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, constructtype);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				selectDropdownText(policyChevron.ddInsuredReside, "No");
				wait(1);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				sendText(dwellingChevron.txtSquareFeet, "1600");
				wait(3);
				selectDropdownText(dwellingChevron.ddQualityGrade, quality);
				wait(3);
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
				click(reviewChevron.btnInsuranceScoreBox);
				click(reviewChevron.btnInsuranceScoreOk);
				wait(3);

				// Application Policy Chevron information was filled here(all information was
				// filled previously, just clicking next button)

				click(dwellingChevron.btnNext);

				// Application Underwriting Questions Chevron was filled here

				fillHO6_UWQuestions();
				wait(1);
				click(uwquestionsChevron.nextButtonUw);

				// Application Dwelling information was filled here
				selectDropdownText(dwellingChevron.ddRoofMetarial, roof);
				selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
				selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
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
				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, HO6 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);
				getPolicyNumber(driver);

				// Close unnecessary tabs
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				for (int i = tabs.size() - 1; i > 0; i--) {
					driver.switchTo().window(tabs.get(i));
					driver.close();
				}

				// Switch back to the main page
				driver.switchTo().window(tabs.get(0));

				click(dashboard.btnUserMenu);
				click(dashboard.btnSignOut);

				sendText(login.username, ConfigsReader.getProperty("username"));
				sendText(login.password, ConfigsReader.getProperty("password"));
				click(login.btnSignIn);
				wait(3);
				moveToElement(driver.findElement(By.id("Menu_Policy")));
				wait(1);
				dashboard.btnNewQuote.click();
				WebElement element = driver.findElement(By.id("Customer.EntityTypeCd"));
				selectDropdownText(element, "Individual");

			} else {
				break;
			}

		}

	}

}
