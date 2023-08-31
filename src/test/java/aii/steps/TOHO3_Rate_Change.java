package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class TOHO3_Rate_Change extends CommonMethods {
		
	@Then("User verifies TOHO3 Base Rate premium")
	public void User_verifies_TOHO3_Base_Rate_premium() {
	String expected = "7251.00";
	String actual = worksheetsChevron.tOHO3BaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	
	}	
}