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

public class VOLDP3_EN_Policy extends CommonMethods {

		@And("User clicks EN Transaction Selection")
		public void User_clicks_EN_Transaction_Selection() {	    	   						
			selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");	
			 wait(1);	
			 click(dashboard.btnSelect);	
		}		
		@And("User enters EN Effective Date {string}")
		public void User_enters_EN_Effective_Date(String EndorsementEffectiveDate) {	    	   						
			sendText(dashboard.txtSelectDate, EndorsementEffectiveDate);
			wait(2);
			click(dashboard.btnStart);
			dashboard.btnStart.click();
		}
		@And("User clicks Endorse Policy button")
		public void User_clicks_Endorse_Policy_button() {	    	   						
			reviewChevron.btnFinalize.click();
			closeoutChevron.btnEndorsePolicy.click();	 
			wait(20);	
		}
		@Then("User verifies EN DP3 policy has been created successfully")
		public void User_verifies_EN_DP3_policy_has_been_created_successfully() {	    	   						
			String expected = "Endorsement";
			String actual = historyChevron.endorsemt.getText();
			Assert.assertEquals("Test failed!", expected, actual);
		}
}