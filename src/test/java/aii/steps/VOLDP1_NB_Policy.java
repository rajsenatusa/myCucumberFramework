package aii.steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLDP1_NB_Policy extends CommonMethods {

	
	@And("User clicks VOL DP1 policy")
	public void User_clicks_VOL_DP1_policy() {	    	   				
		click(product.btnProductSelectionDp1);		
	}	
	@And("User enters DP1 Mandatory Mediation Arbitration")
	public void User_enters_DP1_Mandatory_Mediation_Arbitration() {	    	   				
		selectDropdownText(dwellingChevron.d1MediationArbit, "No"); 
	}
	@And("User calculates DP1 replacement cost")
	public void I_calculate_DP1_replacement_cost() {	    	   				
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		wait(1);
		click(dwellingChevron.btnCalculate);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}	
	@And("User enters DP1 Pay Plan Type")
	public void User_enters_Pay_Plan_Type() {	    	   						
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User enters DP1 Underwritting Questions")
	public void User_enters_dp1_Underwritting_Questions () {
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
	}
	@Then("User verifies NB DP1 policy has been created successfully")
	public void User_verifies_NB_DP1_policy_has_been_created_successfully() {	    	   						
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

}
