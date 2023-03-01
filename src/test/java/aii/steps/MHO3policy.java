package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHO3policy extends CommonMethods {
	
	@When("I enter MHO3 product selection information and effective date")
	public void i_enter_mho3_product_selection_information_and_effective_date() {
		//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionMho3);
				
	}
	@When("I enter all required information on MHO3 quote screen")
	public void i_enter_all_required_information_on_mho3_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
				sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
				click(policyChevron.btnPropertyTypePri);
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
				selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupiedmho3"));
				wait(1);
				click(policyChevron.btnNext);
				wait(3);
	}
	@When("I enter all required information on MHO3 dwelling screen")
	public void i_enter_all_required_information_on_mho3_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, ConfigsReader.getProperty("coveragea"));
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		
	}
	@When("I enter all required information on MHO3 review screen")
	public void i_enter_all_required_information_on_mho3_review_screen() {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(3);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		click(reviewChevron.btnCreateApplication);
		wait(4);
	}
	@When("I create MHO3 application")
	public void i_create_mho3_application() {
		
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
				click(dwellingChevron.btnNext);
				
				//Application Underwriting Questions Chevron was filled here
				
				selectDropdownText(uwquestionsChevron.ho3Question1, "No");
				selectDropdownText(uwquestionsChevron.ho3Question2, "No");
				selectDropdownText(uwquestionsChevron.ho3Question3, "No");
				selectDropdownText(uwquestionsChevron.ho3Question5, "No");
				selectDropdownText(uwquestionsChevron.ho3Question7, "No"); 
				selectDropdownText(uwquestionsChevron.ho6Question8, "No"); 
				selectDropdownText(uwquestionsChevron.ho3Question9, "Yes"); 
				selectDropdownText(uwquestionsChevron.ho3Question10, "No"); 
				selectDropdownText(uwquestionsChevron.ho3Question11, "No");  
				selectDropdownText(uwquestionsChevron.ho6Question12, "No"); 
				selectDropdownText(uwquestionsChevron.ho3Question13, "No"); 
				selectDropdownText(uwquestionsChevron.mho3Question12, "No"); 
				selectDropdownText(uwquestionsChevron.ho3Question15, "Yes"); 
				selectDropdownText(uwquestionsChevron.ho3Question17, "No"); 
				selectDropdownText(uwquestionsChevron.ho3Question18, "No"); 
				selectDropdownText(uwquestionsChevron.mho3Question16, "No");  
				selectDropdownText(uwquestionsChevron.ho3Question20, "No");  
				selectDropdownText(uwquestionsChevron.ho3Question21, "No");  
				selectDropdownText(uwquestionsChevron.ho3Question22, "No");	 
				selectDropdownText(uwquestionsChevron.ho3Question23, "No");	 
				selectDropdownText(uwquestionsChevron.ho3Question19, "No");	 
				selectDropdownText(uwquestionsChevron.mho3Question22, "No");	 
				selectDropdownText(uwquestionsChevron.ho3Question26, "No");	 
				selectDropdownText(uwquestionsChevron.mho3Question24, "Yes");	
				selectDropdownText(uwquestionsChevron.mho3Question25, "Yes");	 
				selectDropdownText(uwquestionsChevron.mho3Question26, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question27, "No");	 
				selectDropdownText(uwquestionsChevron.ho3Question6, "No");	
				selectDropdownText(uwquestionsChevron.ho3Question28, "No");	 
				selectDropdownText(uwquestionsChevron.ho3Question29, "No");


				wait(1);
				click(uwquestionsChevron.nextButtonUw);
				
				//Application Dwelling information was filled here
				selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
				selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarialmho3"));
				selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
				selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
				selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
				sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));
				
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
	@Then("I validate the MHO3 policy has been created successfully")
	public void i_validate_the_mho3_policy_has_been_created_successfully() {
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, MHO3 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}


	}

}
