package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TODP1policy extends CommonMethods {

	@When("I enter product selection information for TODP1 and effective date")
	public void i_enter_product_selection_information_for_todp1_and_effective_date() {
		//login with admin for issuing TO policy
		//product selection information was filled here
		sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.stateDropdown, 1);
		selectDropdown(product.carrierDropdown, 1);
		wait(2);
		click(product.continueButton);
		click(product.productSelectionTodp1);	
	}
	@When("I enter all required information on TODP1 quote screen")
	public void i_enter_all_required_information_on_todp1_quote_screen() {

		//Quote Policy Chevron information was filled here
		sendText(policyChevron.producerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(3);
		sendText(policyChevron.phoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.phoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.noEmailRadio);
		selectDropdownText(policyChevron.constructionTypeDd, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.occupancyDd, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.monthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		wait(1);
		click(policyChevron.nextButton);
		
	}
	@When("I enter all required information on TODP1 dwelling screen")
	public void i_enter_all_required_information_on_todp1_dwelling_screen() {

		//Quote Dwelling information was filled here
		sendText(dwellingChevron.yearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.squareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.distanceToHydrant, ConfigsReader.getProperty("distancetohydrant"));
		selectDropdownText(dwellingChevron.protectionClass, ConfigsReader.getProperty("protectionclass"));
		selectDropdownText(dwellingChevron.dwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.buildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
		wait(2);
		click(dwellingChevron.saveButton);
		wait(3);
		selectDropdownText(dwellingChevron.qualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.calculateButton);
		wait(4);
		click(dwellingChevron.saveButton);
		click(dwellingChevron.nextButton);
		wait(3);
		
	}
	@When("I enter all required information on TODP1 review screen")
	public void i_enter_all_required_information_on_todp1_review_screen() {
		//Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.fullPaymentRadioButton);
		wait(3);
		click(reviewChevron.createApplication);
		wait(4);
	}
	@When("I create TODP1 application")
	public void i_create_todp1_application() {
		//Special Options Chevron was filled here
		click(specialChevron.specialOptionsWiz);
		wait(3);	
		click(specialChevron.treatAsRenewal);
		wait(3);
		click(specialChevron.dialogOk);
		wait(3);
		click(reviewChevron.reviewButton);
		wait(2);
		selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.fullPaymentRadioTOButton);
		click(reviewChevron.finalizeButton);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		click(closeoutChevron.issueNBButton);
		wait(5);
	}
	@Then("I validate the TODP1 policy has been created successfully")
	public void i_validate_the_todp1_policy_has_been_created_successfully() {
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("Renewal")) {
			System.out.println("Test passed, TakeOut DP1 policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}

	}
}
