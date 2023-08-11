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

public class VOLMHO3_FIGA extends CommonMethods {
		
	@And("User adds FIGA VOL MHO3 effective date {string}")
	public void User_adds_FIGA_VOL_MHO3_effective_date(String FIGADP1EffectiveDate) {
		sendText(product.txtEffectiveDate, FIGADP1EffectiveDate);
	 	
	} 	
	
	@Then("User validates New FIGA VOL MHO3 rate")
	public void User_validates_New_FIGA_VOL_MHO3_rate() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
	@Then("User validates Previous FIGA VOL MHO3 rate")
	public void User_validates_Previous_FIGA_VOL_MHO3_rate() {
	String expected = "0.0070";
	String actual = dashboard.fIGADP1Old.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates New FIGA VOL MHO3 rate after Endorsement")
	public void User_validates_New_FIGA_VOL_MHO3_rate_after_Endorsement() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
	
	
	
		
}