package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
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
}
