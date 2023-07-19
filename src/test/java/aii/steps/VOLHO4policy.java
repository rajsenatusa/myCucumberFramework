package aii.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO4policy extends CommonMethods {

	@When("User enters HO4 product selection information and effective date")
	public void user_enters_ho4_product_selection_information_and_effective_date() {
		// product selection information was filled here

		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);

	}

	@When("User enters all required information on HO4 quote screen")
	public void user_enters_all_required_information_on_ho4_quote_screen() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypeho4"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO4 dwelling screen")
	public void user_enters_all_required_information_on_ho4_dwelling_screen() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		sendText(dwellingChevron.txtCoverageC, ConfigsReader.getProperty("coveragec"));
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);

	}

	@When("User enters all required information on HO4 review screen")
	public void user_enters_all_required_information_on_ho4_review_screen() {

		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}

	@When("User creates HO4 application")
	public void user_creates_ho4_application() {

		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(dwellingChevron.btnNext);

	}

	@When("User answers all underwriting questions for HO4")
	public void user_answers_all_underwriting_questions_for_ho4() throws Exception {

		fillHO4_UWQuestions();
		wait(2);
		click(dwellingChevron.btnNext);

		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
		selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
		wait(2);

	}

	@Then("User validates that HO4 policy has been created successfully")
	public void user_validates_that_ho4_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO4 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}

	}

	@Then("User creates HO4 policy with passing information from excel {string} sheet")
	public void User_creates_ho4_policy_with_passing_information_from_excel_sheet(String ho4customerInfo) throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/VOLHO4.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, ho4customerInfo);

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
				String coveragec=dataMap.get("CoverageC");

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
				click(product.btnProductSelectionHo4);

				// quote
				selectDropdownText(policyChevron.ddPreviousCarrier, previousCarr);
				sendText(policyChevron.txtPreviousPolicyExpDate, previousExp);
				selectDropdownText(policyChevron.ddMobileHomeInd, "No");
				sendText(policyChevron.txtPhoneNumber, phone);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, constructtype);
				selectDropdownText(policyChevron.ddOccupancy, occupancytype);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsoccp);
				wait(1);
				click(policyChevron.btnNext);

				// dwelling
				sendText(dwellingChevron.txtYearConstruction, yearcons);
				wait(2);
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				sendText(dwellingChevron.txtCoverageC, coveragec);
				wait(2);
				click(dwellingChevron.btnSave);
				wait(3);
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

				fillHO4_UWQuestions();
				wait(2);
				click(dwellingChevron.btnNext);

				// Application Dwelling information was filled here

				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				wait(2);
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
					System.out.println("Test passed, HO4 NB policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);
				// driver.switchTo().defaultContent();
				String policyNumber=driver.findElement(By.id("PolicySummary_PolicyNumber")).getText();
				Hooks.scenario.log(policyNumber);
				
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
	@And("User clicks VOL HO4 policy")
	public void User_clicks_VOL_HO4_policy() {

		click(product.btnProductSelectionHo4); 
	}
	@And("User selects Mobile Home")
	public void User_selects_Mobile_Home() {
		selectDropdownText(policyChevron.ddMobileHome, "No");
		wait(1);
	}
	
	@And("User enters Personal Property")
	public void User_enters_Personal_Property() {
		sendText(dwellingChevron.txtCoverageC, ConfigsReader.getProperty("coveragec"));
		wait(1);
	}
	@And("User enters Pay Plan Type for HO4")
	public void User_enters_Pay_Plan_Type_for_HO4() {
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");			 
		reviewChevron.btnFullPaymentRadio.click();
		reviewChevron.btnCreateApplication.click();
		click(dwellingChevron.btnNext);
	}
	
	
	
	
}
