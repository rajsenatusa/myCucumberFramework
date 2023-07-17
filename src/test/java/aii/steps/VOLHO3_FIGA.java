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

public class VOLHO3_FIGA extends CommonMethods {
		
	@And("User adds FIGA HO3 effective date {string}")
	public void User_adds_FIGA_DP3_effective_date(String FIGAHO3EffectiveDate) {
		sendText(product.txtEffectiveDate, FIGAHO3EffectiveDate);
	 	
	} 	
	
	@Then("User validates New FIGA HO3 rate")
	public void User_validates_New_FIGA_HO3_rate() {
	String expected = "0.0170";
	String actual = dashboard.fIGAHO3New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
	@Then("User validates Previous FIGA HO3 rate")
	public void User_validates_Previous_FIGA_HO3_rate() {
	String expected = "0.0070";
	String actual = dashboard.fIGAHO3Old.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
	
	
	
	
		
}