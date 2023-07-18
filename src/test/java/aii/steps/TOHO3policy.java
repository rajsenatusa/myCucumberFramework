package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
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

}
