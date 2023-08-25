package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLH06_FIGA extends CommonMethods {
		
	@Then("User validates New FIGA VOL HO6 rate")
	public void User_validates_New_FIGA_VOL_H06_rate() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates Previous FIGA VOL H06 rate")
	public void User_validates_Previous_FIGA_VOL_H06_rate() {
	String expected = "0.0070";
	String actual = dashboard.fIGADP1Old.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates New FIGA VOL HO6 rate after Endorsement")
	public void user_validates_new_figa_vol_ho6_rate_after_endorsement() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP1New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
}



