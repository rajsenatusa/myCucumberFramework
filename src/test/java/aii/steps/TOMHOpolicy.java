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

public class TOMHOpolicy extends CommonMethods {

	@When("User enters product selection information for TOMHO and effective date")
	public void user_enters_product_selection_information_for_tomho_and_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomho);
	}
	@When("User enters product selection information for TOMHO and {string}")
	public void user_enters_product_selection_information_for_tomho_and (String EffectiveDate) {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, EffectiveDate);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionTomho);
	}
	@When("User enters all required information on TOMHO quote screen")
	public void user_enters_all_required_information_on_tomho_quote_screen() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		wait(1);
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on TOMHO dwelling screen")
	public void user_enters_all_required_information_on_tomho_dwelling_screen() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		selectDropdownText(dwellingChevron.ddBuildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
		selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
		wait(2);
		sendText(dwellingChevron.txtCoverageA, ConfigsReader.getProperty("tocoverageA"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on TOMHO review screen")
	public void user_enters_all_required_information_on_tomho_review_screen() {
		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}

	@When("User creates TOMHO application")
	public void user_creates_tomho_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}
	@When("User selects Attached Structures {string}")
	public void user_selects_attached_structures (String AttachedStructures) {
		selectDropdownText(dwellingChevron.ddAttachedStructures, AttachedStructures);
		wait(2);
	}
	@When("User enters Coverage A value {string}")
	public void user_enters_coverage_a_value (String CoverageA) {
		sendText(dwellingChevron.txtCoverageA, CoverageA);
		wait(3);
	}
	@Then("User validates that TOMHO policy has been created successfully")
	public void user_validates_that_tomho_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut MHO policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}
	@Then("User creates TOMHO policy with passing information from excel {string} sheet")
	public void User_creates_tomho_policy_with_passing_information_from_excel_sheet(String tomhocustomerInfo)
			throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/TOMHO.xlsx";

		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, tomhocustomerInfo);

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
				String coverageA = dataMap.get("CoverageA");
				String occupancy = dataMap.get("Occupancy");
				String monthsOccupied = dataMap.get("Months");
				String yearConstruction = dataMap.get("ConstYear");

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
				click(product.btnProductSelectionTomho);

				// Quote Policy Chevron information was filled here
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				wait(3);
				click(dwellingChevron.btnSave);
				wait(2);
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				sendText(policyChevron.txtPhoneNumber, phoneNumber);
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddOccupancy, occupancy);
				selectDropdownText(policyChevron.ddMonthsOccupied, monthsOccupied);
				wait(1);
				click(policyChevron.btnNext);

				// Quote Dwelling information was filled here
				sendText(dwellingChevron.txtYearConstruction, yearConstruction);
				selectDropdownText(dwellingChevron.ddBuildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
				selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
				wait(2);
				sendText(dwellingChevron.txtCoverageA, coverageA);
				wait(3);
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
					System.out.println("Test passed, TakeOut MHO policy has been created successfully");
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
