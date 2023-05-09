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

public class VOLHO3_RN_Policy extends CommonMethods {

		@And("User returns to main page")
		public void User_returns_to_main_page() {			
		driver.switchTo().window(driver.getWindowHandle());		
		wait(5);	
		}
		@And("User clicks Start Transaction")
		public void User_clicks_Start_Transaction() {	    	   						
			click(dashboard.btnStartTransaction);		
		}
		@And("User clicks Transaction Selection")
		public void User_clicks_Transaction_Selection() {	    	   						
			selectDropdownText(dashboard.ddSelectTransaction, "Renewal");	
			 wait(1);	
			 click(dashboard.btnSelect);	
			 click(dashboard.btnStart);
		}
		@Then("User verifies RN HO3 policy has been created successfully")
		public void User_verifies_RN_HO3_policy_has_been_created_successfully() {	    	   						
			String expected = "Renewal";
			String actual = historyChevron.renewal.getText();
			Assert.assertEquals("Test failed!", expected, actual);
		}
		@Then("User verifies HO3 RN Water NonWeather Base Rate")
		public void User_verifies_HO3_RN_Water_NonWeather_Base_Rate() {
			String expected = "Initial Base Rate: 353.71<br> - Water Non-Weather Territory Code: 3<br> - Territory Factor: 1.630";
			String actual = worksheetsChevron.HO3NBWaterNonWeather.getText();				
			Assert.assertEquals("The value DOES NOT match!", expected, actual);
		}
		@Then("User verifies HO3 RN Fire or Lightning Base Rate")
		public void User_verifies_HO3_RN_Fire_or_Lightning_Base_Rate() {
		String expected = "Initial Base Rate: 50.93<br> - Fire or Lightning Territory Code: 10<br> - Territory Factor: 0.860";
		String actual = worksheetsChevron.HO3NBFireLightning.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		}
		@Then("User verifies HO3 RN Hurricane Base Rate")
		public void User_verifies_HO3_RN_Hurricane_Base_Rate() {
		String expected = "Initial Base Rate: 2090.44<br> - Hurricane Territory Code: E4<br> - Territory Factor: 0.577";
		String actual = worksheetsChevron.HO3NBHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		}
}
