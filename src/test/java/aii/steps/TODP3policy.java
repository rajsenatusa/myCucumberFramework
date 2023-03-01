package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TODP3policy extends CommonMethods {

	@When("I enter product selection information for TODP3 and effective date")
	public void i_enter_product_selection_information_for_todp3_and_effective_date() {
			//login with admin for issuing TO policy
			//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionTodp3);	
	}
	@When("I enter all required information on TODP3 quote screen")
	public void i_enter_all_required_information_on_todp3_quote_screen() {
			//Quote Policy Chevron information was filled here
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				wait(3);
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
	@When("I enter all required information on TODP3 dwelling screen")
	public void i_enter_all_required_information_on_todp3_dwelling_screen() {
			//Quote Dwelling information was filled here
				sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
				sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
				selectDropdownText(dwellingChevron.ddDistanceToHydrant, ConfigsReader.getProperty("distancetohydrant"));
				selectDropdownText(dwellingChevron.ddProtectionClass, ConfigsReader.getProperty("protectionclass"));
				selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
				selectDropdownText(dwellingChevron.ddNumberofUnits, ConfigsReader.getProperty("numberofunits"));
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
	@When("I enter all required information on TODP3 review screen")
	public void i_enter_all_required_information_on_todp3_review_screen() {
			//Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);
	}
	@When("I create TODP3 application")
	public void i_create_todp3_application() {
			//Special Options Chevron was filled here
				click(specialChevron.btnSpecialOptionsWiz);
				wait(3);	
				click(specialChevron.btnTreatAsRenewal);
				wait(3);
				click(specialChevron.btnDialogOk);
				wait(3);
				click(specialChevron.btnDwellingWiz);
				wait(2);
				selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
				wait(2);
				click(dwellingChevron.btnSave);
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
	@Then("I validate the TODP3 policy has been created successfully")
	public void i_validate_the_todp3_policy_has_been_created_successfully() {
				WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
				
				if(validate.getText().equalsIgnoreCase("Renewal")) {
					System.out.println("Test passed, TakeOut DP3 policy has been created successfully");
				}
				else {
					System.out.println("Test failed!");
			}


	}
}
