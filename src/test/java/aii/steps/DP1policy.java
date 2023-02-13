package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DP1policy extends CommonMethods {


@When("I enter DP1 product selection information and effective date")
public void i_enter_dp1_product_selection_information_and_effective_date() {
		//product selection information was filled here
			sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
			selectDropdown(product.stateDropdown, 1);
			selectDropdown(product.carrierDropdown, 1);
			wait(2);
			click(product.continueButton);
			click(product.productSelectionDp1);
	
}
@When("I enter all required information on DP1 quote screen")
public void i_enter_all_required_information_on_dp1_quote_screen() {
	//Quote Policy Chevron information was filled here
	
			selectDropdownText(policyChevron.previousCarrier, ConfigsReader.getProperty("previouscarrier"));
			sendText(policyChevron.previousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
			sendText(policyChevron.phoneNumber, ConfigsReader.getProperty("phonenumber"));
			selectDropdownText(policyChevron.phoneNumberType, ConfigsReader.getProperty("phonetype"));
			wait(2);
			click(policyChevron.noEmailRadio);
			selectDropdownText(policyChevron.constructionTypeDd, ConfigsReader.getProperty("constructiontype"));
			selectDropdownText(policyChevron.occupancyDd, ConfigsReader.getProperty("occupancytype"));
			selectDropdownText(policyChevron.monthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
			wait(1);
			click(policyChevron.nextButton);
			wait(3);
			
}
@When("I enter all required information on DP1 dwelling screen")
public void i_enter_all_required_information_on_dp1_dwelling_screen() {
			
			sendText(dwellingChevron.yearConstruction, ConfigsReader.getProperty("yearconstruction"));
			wait(2);
			sendText(dwellingChevron.squareFeet, ConfigsReader.getProperty("squarefeet"));
			selectDropdownText(dwellingChevron.roofMetarial, ConfigsReader.getProperty("roofmetarial"));
			selectDropdownText(dwellingChevron.mediationArbitDp1,ConfigsReader.getProperty("mediation"));
			selectDropdownText(dwellingChevron.dwellingType, ConfigsReader.getProperty("dwellingtype"));
			selectDropdownText(dwellingChevron.qualityGrade, ConfigsReader.getProperty("qualitygrade"));
			click(dwellingChevron.calculateButton);
			wait(4);
			click(dwellingChevron.saveButton);
			click(dwellingChevron.nextButton);
}
@When("I enter all required information on DP1 review screen")
public void i_enter_all_required_information_on_dp1_review_screen() {
	
			selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
			wait(2);
			click(reviewChevron.fullPaymentRadioButton);
			wait(3);
			click(reviewChevron.createApplication);
			wait(4);
			
}
@When("I create DP1 application")
public void i_create_dp1_application() {
    
	//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
	
	click(dwellingChevron.nextButton);
	
	//Application Underwriting Questions Chevron was filled here
	
	selectDropdownText(uwquestionsChevron.ho3Question1, "No");
	selectDropdownText(uwquestionsChevron.ho3Question2, "No");
	selectDropdownText(uwquestionsChevron.ho3Question3, "No");
	selectDropdownText(uwquestionsChevron.ho3Question4, "No");
	selectDropdownText(uwquestionsChevron.ho3Question5, "No");
	selectDropdownText(uwquestionsChevron.ho3Question6, "No");
	selectDropdownText(uwquestionsChevron.ho3Question7, "No");
	selectDropdownText(uwquestionsChevron.dp1Question8, "No");
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
	selectDropdownText(uwquestionsChevron.ho3Question20, "No");	
	selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
	selectDropdownText(uwquestionsChevron.ho3Question22, "No");	
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
	
	click(dwellingChevron.saveButton);
	click(reviewChevron.reviewButton);
	wait(2);
	click(reviewChevron.finalizeButton);
	wait(2);
	
	//Closeout Chevron information was filled here
	
	selectDropdownText(closeoutChevron.paymentType, ConfigsReader.getProperty("paymenttype"));
	wait(4);
	click(closeoutChevron.issueNBButton);
	
}
@Then("I validate the DP1 policy has been created successfully")
public void i_validate_the_dp1_policy_has_been_created_successfully() {
	
	WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
	
	if(validate.getText().equalsIgnoreCase("New Business")) {
		System.out.println("Test passed, DP1 NB policy has been created successfully");
	}
	else {
		System.out.println("Test failed!");
}


}

}
