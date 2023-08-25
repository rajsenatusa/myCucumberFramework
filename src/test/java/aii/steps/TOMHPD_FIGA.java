package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class TOMHPD_FIGA extends CommonMethods {
		
	@Then("User validates New FIGA TO MHPD rate")
	public void User_validates_New_FIGA_TO_MHPD_rate() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates Previous FIGA TO MHPD rate")
	public void User_validates_Previous_FIGA_TO_MHPD_rate() {
	String expected = "0.0070";
	String actual = dashboard.fIGADP1Old.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates New FIGA TO MHPD rate after Endorsement")
	public void User_validates_New_FIGA_TO_MHPD_rate_after_Endorsement() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
}