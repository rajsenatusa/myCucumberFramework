package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
	@Then("User validates 2024 FIGA VOL MHO3 rate in Worksheets")
	public void User_validates_2024_FIGA_VOL_MHO3_rate_in_Worksheets() {
	String expected = "0.0100";
	String actual = dashboard.fIGA2024MHO3Worksheets.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA VOL MHO3 rate in Premium Info")
	public void User_validates_2024_FIGA_VOL_MHO3_rate_in_Premium_Info() {
	String expected = "107.94";
	String actual = dashboard.fIGA2024MHO3PremiumInfo.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA VOL MHO3 rate in Review")
	public void User_validates_2024_FIGA_VOL_MHO3_rate_in_Review() {
	String expected = "$107.94";
	String actual = dashboard.fIGA2024MHO3Review.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	
		
}