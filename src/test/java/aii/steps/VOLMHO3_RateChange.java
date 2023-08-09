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

public class VOLMHO3_RateChange extends CommonMethods {
		

	@And("User enters VOL MHO3 Coverage A Dwelling")
	public void User_enters_VOL_MHO3_Coverage_A_Dwelling() {	    	   				
		wait(1);
		dwellingChevron.txtCoverageA.sendKeys("50000"); 	
		wait(1);
	}
	@Then("User verifies VOL MHO3 Private Property NonHurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_NonHurricane_rate() {
	String expected = "1302.00";
	String actual = worksheetsChevron.txtMHO3NonHurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies VOL MHO3 Private Property Hurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_Hurricane_rate() {
	String expected = "1337.00";
	String actual = worksheetsChevron.txtMHO3HurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	
}