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

public class VOLHO6_NB_Policy extends CommonMethods {

	@And("User enters HO6 New Product Version effective date")
	public void User_enters_NB_HO6_New_Product_Version_effective_date() {	    	   		
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy"); 		
		product.txtEffectiveDate.sendKeys(ConfigsReader.getProperty("NBHO6NewProductVersioneffectivedate"));	
	}	
	@And("User clicks VOL HO6 policy")
	public void User_clicks_VOL_HO3_policy() {	    	   				
		click(product.btnProductSelectionHo6);		
	}
	@And("User enters HO6 Underwritting Questions")
	public void User_enters_HO6_Underwritting_Questions () {
	click(dwellingChevron.btnNext);
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
	}
	@And("User calculates replacement cost")
	public void I_calculate_replacement_cost() {	    	   				
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		wait(1);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(1);
	}	
	@And("User enters Floor number of unit location {string}")
	public void User_enters_Floor_number_of_unit_location(String FloorNumber) {	    	   						
		selectDropdownText(dwellingChevron.ddStoryOfUnit, FloorNumber);	
		 wait(5);
	}
	@Then("User verifies NB HO6 policy has been created successfully")
	public void User_verifies_NB_HO3_policy_has_been_created_successfully() {	    	   						
		wait(1);
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
	}
}
