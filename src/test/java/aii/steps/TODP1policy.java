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

public class TODP1policy extends CommonMethods {

	
	@When("User enters product selection information for TODP1 and effective date")
	public void user_enters_product_selection_information_for_todp1_and_effective_date() {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);
	}

	@When("User enters product selection information for TODP1 and {string}")
	public void user_enters_product_selection_information_for_todp1_and(String EffectiveDate) {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, EffectiveDate);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTodp1);
	}

	@When("User enters all required information on TODP1 quote screen")
	public void user_enters_all_required_information_on_todp1_quote_screen() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TODP1 dwelling screen")
	public void user_enter_all_required_information_on_todp1_dwelling_screen() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, ConfigsReader.getProperty("distancetohydrant"));
		selectDropdownText(dwellingChevron.ddProtectionClass, ConfigsReader.getProperty("protectionclass"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on TODP1 review screen")
	public void user_enters_all_required_information_on_todp1_review_screen() {
		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}

	@When("User creates TODP1 application")
	public void user_creates_todp1_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}

	@When("User clicks special options chevron")
	public void user_clicks_special_options_chevron() {
		// Special Options Chevron was filled here
		click(specialChevron.btnSpecialOptionsWiz);
		wait(3);
	}

	@When("User selects treat as renewal")
	public void user_selects_treat_as_renewal() {

		click(specialChevron.btnTreatAsRenewal);
		wait(3);
		click(specialChevron.btnDialogOk);
		wait(3);

	}

	@When("User clicks review Chevron and selects payment plan")
	public void user_clicks_review_chevron_and_selects_payment_plan() {

		click(reviewChevron.btnReview);
		wait(2);
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadioTO);

	}

	@When("User selects Distance to Hydrant {string}")
	public void user_selects_distance_to_hydrant(String DistanceHydrant) {
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, DistanceHydrant);
	}

	@When("User selects Protection Class {string}")
	public void user_selects_protection_class(String ProtectionClass) {
		selectDropdownText(dwellingChevron.ddProtectionClass, ProtectionClass);
	}

	@When("User selects Dwelling Type {string}")
	public void user_selects_dwelling_type(String DwellingType) {
		selectDropdownText(dwellingChevron.ddDwellingType, DwellingType);
	}

	@When("User selects Building Territory List {string}")
	public void user_selects_building_territory_list(String TerritoryList) {
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, TerritoryList);
		wait(3);
	}

	@When("User selects Quality Grade {string}")
	public void user_selects_quality_grade(String QualityGrade) {
		selectDropdownText(dwellingChevron.ddQualityGrade, QualityGrade);
	}

	@Then("User validates that TODP1 policy has been created successfully")
	public void user_validates_that_todp1_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut DP1 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Then("User creates TODP1 policy with passing information from excel {string} sheet")
	public void User_creates_todp1_policy_with_passing_information_from_excel_sheet(String todp1customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/TODP1.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, todp1customerInfo);

		for (Map<String, String> dataMap : excelList) {

			if (!dataMap.containsValue("")) {
				String firstName = dataMap.get("FirstName");
				String lastName = dataMap.get("LastName");
				String birthDate = dataMap.get("BirthDate");
				String address = dataMap.get("Address");
				String zipcode = dataMap.get("Zipcode");
				String effDate = dataMap.get("EffectiveDate");
				String state = dataMap.get("State");
				String phoneNumber = dataMap.get("Phone");
				String constructionType = dataMap.get("ConsType");
				String occupancy = dataMap.get("Occupancy");
				String monthsOccupied = dataMap.get("Months");
				String yearConstruction = dataMap.get("ConstYear");
				String qualityGrade = dataMap.get("Quality");

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
				click(product.btnProductSelectionTodp1);

				// Quote Policy Chevron information was filled here
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				wait(3);
				click(dwellingChevron.btnSave);
				wait(2);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				sendText(policyChevron.txtPhoneNumber, phoneNumber);
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, constructionType);
				selectDropdownText(policyChevron.ddOccupancy, occupancy);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsOccupied);
				wait(1);
				click(policyChevron.btnNext);

				// Quote Dwelling information was filled here
				sendText(dwellingChevron.txtYearConstruction, yearConstruction);
				sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
				selectDropdownText(dwellingChevron.ddDistanceToHydrant, ConfigsReader.getProperty("distancetohydrant"));
				selectDropdownText(dwellingChevron.ddProtectionClass, ConfigsReader.getProperty("protectionclass"));
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				selectDropdownText(dwellingChevron.ddBuildingTerritoryList,
						ConfigsReader.getProperty("buildingterritorylist"));
				wait(2);
				click(dwellingChevron.btnSave);
				wait(3);
				selectDropdownText(dwellingChevron.ddQualityGrade, qualityGrade);
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

				// Special Options Chevron was filled here
				click(specialChevron.btnSpecialOptionsWiz);
				wait(3);

				// User clicks treat as renewal button
				click(specialChevron.btnTreatAsRenewal);
				wait(3);
				click(specialChevron.btnDialogOk);
				wait(3);

				// User clicks review Chevron and selects payment plan

				click(reviewChevron.btnReview);
				wait(2);
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadioTO);

				// User finalizes transaction and issues takeout policy

				click(reviewChevron.btnFinalize);
				wait(2);

				// Closeout Chevron information was filled here

				click(closeoutChevron.btnIssueNB);
				wait(5);

				// Validation

				WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

				if (validate.getText().equalsIgnoreCase("Renewal")) {
					System.out.println("Test passed, TakeOut DP1 policy has been created successfully");
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

				sendText(login.username, ConfigsReader.getProperty("adminusername"));
				sendText(login.password, ConfigsReader.getProperty("adminpassword"));
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
