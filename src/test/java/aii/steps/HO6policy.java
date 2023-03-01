package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HO6policy extends CommonMethods {
	
	@When("I enter HO6 product selection information and effective date")
	public void i_enter_ho6_product_selection_information_and_effective_date() {
		
		//product selection information was filled here
		sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6); 
		
	}
	@When("I enter all required information on HO6 quote screen")
	public void i_enter_all_required_information_on_ho6_quote_screen() {
	   
		//Quote Policy Chevron information was filled here
		
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
		
	}
	@When("I enter all required information on HO6 dwelling screen")
	public void i_enter_all_required_information_on_ho6_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
	}
	@When("I enter all required information on HO6 review screen")
	public void i_enter_all_required_information_on_ho6_review_screen() {
	    
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(3);
	}
	@When("I create HO6 application")
	public void i_create_ho6_application() {
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
				click(dwellingChevron.btnNext);
				
				//Application Underwriting Questions Chevron was filled here
				
				selectDropdownText(uwquestionsChevron.ho3Question1, "No");
				selectDropdownText(uwquestionsChevron.ho3Question2, "No");
				selectDropdownText(uwquestionsChevron.ho3Question3, "No");
				selectDropdownText(uwquestionsChevron.ho6Question4, "No");
				selectDropdownText(uwquestionsChevron.ho3Question5, "No");
				selectDropdownText(uwquestionsChevron.ho3Question6, "No");
				selectDropdownText(uwquestionsChevron.ho3Question7, "No");
				selectDropdownText(uwquestionsChevron.ho6Question8, "No");
				selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question10, "No");
				selectDropdownText(uwquestionsChevron.ho3Question11, "No");
				selectDropdownText(uwquestionsChevron.ho6Question12, "No");
				selectDropdownText(uwquestionsChevron.ho3Question13, "No");
				selectDropdownText(uwquestionsChevron.ho3Question14, "No");
				selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
				selectDropdownText(uwquestionsChevron.ho3Question17, "No");
				selectDropdownText(uwquestionsChevron.ho3Question18, "No");  
				selectDropdownText(uwquestionsChevron.ho3Question19, "No"); 
				selectDropdownText(uwquestionsChevron.ho6Question19, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
				selectDropdownText(uwquestionsChevron.ho6Question21, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question23, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question24, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question25, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question26, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question27, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question28, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question29, "No");	
			
				wait(1);
				click(uwquestionsChevron.nextButtonUw);
				
				//Application Dwelling information was filled here
				
				selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
				selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
				selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
				wait(2);
				click(dwellingChevron.btnSave);
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);
				
				//Closeout Chevron information was filled here
				
				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);
				
	}
	@Then("I validate the HO6 policy has been created successfully")
	public void i_validate_the_ho6_policy_has_been_created_successfully() {
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO6 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}

	}




}
