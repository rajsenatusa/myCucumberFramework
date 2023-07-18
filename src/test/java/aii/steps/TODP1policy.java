package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
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
}
