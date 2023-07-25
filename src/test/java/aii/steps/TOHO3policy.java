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

public class TOHO3policy extends CommonMethods {

	@When("User enters product selection information for TOHO3 and effective date")
	public void user_enters_product_selection_information_for_toho3_and_effective_date() {

		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionToho3);
	}

	@When("User enters product selection information for TOHO3 and {string}")
	public void user_enters_product_selection_information_for_toho3_(String EffectiveDate) {
		// login with admin for issuing TO policy
		// product selection information was filled here
		sendText(product.txtEffectiveDate, EffectiveDate);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionToho3);
	}

	@When("User enters all required information on TOHO3 quote screen")
	public void User_enters_all_required_information_on_toho3_quote_screen() {

		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.btnNext);

	}

	@When("User enters all required information on TOHO3 dwelling screen")
	public void user_enters_all_required_information_on_toho3_welling_screen() {

		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
		selectDropdownText(dwellingChevron.ddStructureRentedOthers, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, ConfigsReader.getProperty("hurricanedeductible"));
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on TOHO3 review screen")
	public void user_enters_all_required_information_on_toho3_review_screen() {

		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}

	@When("User clicks dwelling chevron and selects dwelling type")
	public void user_clicks_dwelling_chevron_and_selects_dwelling_type() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
	}

	@When("User creates TOHO3 application")
	public void user_creates_toho3_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}

	@When("User selects Structure Rented to Others {string}")
	public void user_selects_structure_rented_to_others(String StructureRentedOthers) {
		selectDropdownText(dwellingChevron.ddStructureRentedOthers, StructureRentedOthers);
	}

	@When("User selects Hurricane Deductible {string}")
	public void user_selects_hurricane_deductible(String HurricaneDeductible) {
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, HurricaneDeductible);
		wait(3);
	}

	@Then("User validates that TOHO3 policy has been created successfully")
	public void user_validates_that_toho3_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Then("User creates TOHO3 policy with passing information from excel {string} sheet")
	public void User_creates_toho3_policy_with_passing_information_from_excel_sheet(String toho3customerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/TOHO3.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, toho3customerInfo);

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
				String roofmaterial = dataMap.get("Roof");

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
				click(product.btnProductSelectionToho3);

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
				selectDropdownText(dwellingChevron.ddBuildingTerritoryList,
						ConfigsReader.getProperty("buildingterritorylist"));
				selectDropdownText(dwellingChevron.ddStructureRentedOthers, "No");
				wait(2);
				click(dwellingChevron.btnSave);
				wait(3);
				selectDropdownText(dwellingChevron.ddQualityGrade, qualityGrade);
				click(dwellingChevron.btnCalculate);
				wait(4);
				click(dwellingChevron.btnSave);
				selectDropdownText(dwellingChevron.ddHurricaneDeductible,
						ConfigsReader.getProperty("hurricanedeductible"));
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

				// Special Options Chevron was filled here
				click(specialChevron.btnSpecialOptionsWiz);
				wait(3);

				// User clicks treat as renewal button
				click(specialChevron.btnTreatAsRenewal);
				wait(3);
				click(specialChevron.btnDialogOk);
				wait(3);

				// user clicks dwelling and selects roof material
				click(specialChevron.btnDwellingWiz);
				wait(2);
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				wait(2);
				click(specialChevron.btnDwellingWiz);
				wait(2);
				selectDropdownText(dwellingChevron.ddRoofMetarial, roofmaterial);
				wait(2);
				click(dwellingChevron.btnSave);

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
					System.out.println("Test passed, TakeOut HO3 policy has been created successfully");
				} else {
					System.out.println("Test failed!");
				}

				wait(5);
				// driver.switchTo().defaultContent();
				String policyNumber = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText();
				Hooks.scenario.log(policyNumber);

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
