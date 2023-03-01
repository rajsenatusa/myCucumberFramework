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
			sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
			selectDropdown(product.ddStateSelection, 1);
			selectDropdown(product.ddCarrierSelection, 1);
			wait(2);
			click(product.btnContinue);
			click(product.btnProductSelectionTomhpd);
	
}
@When("I enter all required information on TOMHPD quote screen")
public void i_enter_all_required_information_on_tomhpd_quote_screen() {
	//Quote Policy Chevron information was filled here
			sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
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
@When("I enter all required information on TOMHPD dwelling screen")
public void i_enter_all_required_information_on_tomhpd_dwelling_screen() {
	//Quote Dwelling information was filled here
			sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
			selectDropdownText(dwellingChevron.ddBuildingTerritoryList, ConfigsReader.getProperty("buildingterritorylist"));
			getWaitObject();
			scrollToElement(dwellingChevron.txtCoverageA);
			wait(2);
			waitForVisibility(dwellingChevron.txtCoverageA);
			clickTab(dwellingChevron.txtCoverageA);
			clearText(dwellingChevron.txtCoverageA);
			wait(2);
			driver.findElement(By.id("Building.CovALimit")).sendKeys("120000");  //did hard coding due to element is hidden inside dom
			selectDropdownText(dwellingChevron.ddAttachedStructures, "No");
			wait(2);
			click(dwellingChevron.btnSave);
			wait(3);
			click(dwellingChevron.btnNext);
			wait(3);
}
@When("I enter all required information on TOMHPD review screen")
public void i_enter_all_required_information_on_tomhpd_review_screen() {
	//Quote Review Chevron information was filled here
			selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.btnFullPaymentRadio);
			wait(3);
			click(reviewChevron.btnCreateApplication);
			wait(4);
}
@When("I create TOMHPD application")
public void i_create_tomhpd_application() {
	//Special Options Chevron was filled here
			click(specialChevron.btnSpecialOptionsWiz);
			wait(3);	
			click(specialChevron.btnTreatAsRenewal);
			wait(3);
			click(specialChevron.btnDialogOk);
			wait(3);
			click(reviewChevron.btnReview);
			wait(2);
			selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.btnFullPaymentRadioTO);
			click(reviewChevron.btnFinalize);
			wait(2);
			
			//Closeout Chevron information was filled here
			
			click(closeoutChevron.btnIssueNB);
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
