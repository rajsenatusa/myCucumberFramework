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

public class VOLHO4_RateChange extends CommonMethods {
		
	@And("User clicks Hurricane Base Premium")
	public void User_clicks_Hurricane_Base_Premium() {
		wait(1);
		
		
		jsClick(driver.findElement(By.xpath("//*[@id=\"imgCovStepSteps-Step-RateArea-1180561273-742792986-HurricaneBasePremium29\"]")));
		
		wait(1);
	}
	@And("User clicks Rate Area Hurricane")
	public void User_clicks_Rate_Area_Hurricane() {
		wait(3);
		click(worksheetsChevron.linkRateAreaHurricane);
		wait(1);
	}
 	@Then("User verifies VOL HO4 Hurricane Base Rate")
	public void User_verifies_VOL_HO4_Hurricane_Base_Rate() {
	String expected = "60.00";
	String actual = worksheetsChevron.HurricaneBaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
 	
} 