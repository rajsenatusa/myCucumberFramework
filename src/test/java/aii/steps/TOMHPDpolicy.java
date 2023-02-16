package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TOMHPDpolicy extends CommonMethods {


@When("I enter product selection information for TOMHPD and effective date")
public void i_enter_product_selection_information_for_tomhpd_and_effective_date() {
	//product selection information was filled here
			sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
			selectDropdown(product.stateDropdown, 1);
			selectDropdown(product.carrierDropdown, 1);
			wait(2);
			click(product.continueButton);
			click(product.productSelectionTomhpd);
	
}
@When("I enter all required information on TOMHPD quote screen")
public void i_enter_all_required_information_on_tomhpd_quote_screen() {
	//Quote Policy Chevron information was filled here
			sendText(policyChevron.producerCodeSel, ConfigsReader.getProperty("producerselection"));
			wait(3);
			sendText(policyChevron.phoneNumber, ConfigsReader.getProperty("phonenumber"));
			selectDropdownText(policyChevron.phoneNumberType, ConfigsReader.getProperty("phonetype"));
			wait(2);
			click(policyChevron.noEmailRadio);
			selectDropdownText(policyChevron.occupancyDd, ConfigsReader.getProperty("occupancytype"));
			wait(1);
			selectDropdownText(policyChevron.monthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
			wait(1);
			click(policyChevron.nextButton);
}
@When("I enter all required information on TOMHPD dwelling screen")
public void i_enter_all_required_information_on_tomhpd_dwelling_screen() {
	//Quote Dwelling information was filled here
			sendText(dwellingChevron.yearConstruction, ConfigsReader.getProperty("yearconstruction"));
			selectDropdownText(dwellingChevron.buildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
			getWaitObject();
			scrollToElement(dwellingChevron.coverageA);
			wait(2);
			waitForVisibility(dwellingChevron.coverageA);
			clickTab(dwellingChevron.coverageA);
			clearText(dwellingChevron.coverageA);
			wait(2);
			driver.findElement(By.id("Building.CovALimit")).sendKeys("120000");  //did hard coding due to element is hidden inside dom
			selectDropdownText(dwellingChevron.attachedStructures, "No");
			wait(2);
			click(dwellingChevron.saveButton);
			wait(3);
			click(dwellingChevron.nextButton);
			wait(3);
}
@When("I enter all required information on TOMHPD review screen")
public void i_enter_all_required_information_on_tomhpd_review_screen() {
	//Quote Review Chevron information was filled here
			selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.fullPaymentRadioButton);
			wait(3);
			click(reviewChevron.createApplication);
			wait(4);
}
@When("I create TOMHPD application")
public void i_create_tomhpd_application() {
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
@Then("I validate the TOMHPD policy has been created successfully")
public void i_validate_the_tomhpd_policy_has_been_created_successfully() {
			WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
			
			if(validate.getText().equalsIgnoreCase("Renewal")) {
				System.out.println("Test passed, TakeOut MHPD policy has been created successfully");
			}
			else {
				System.out.println("Test failed!");
}

}

}
