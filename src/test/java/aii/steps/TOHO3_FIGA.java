package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class TOHO3_FIGA extends CommonMethods {
		
	@Then("User validates New FIGA TO HO3 rate")
	public void User_validates_New_FIGA_HO3_rate() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP3New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates New FIGA TO HO3 rate after Endorsement")
	public void User_validates_New_FIGA_TO_HO3_rate_after_Endorsement() {
	String expected = "0.0170";
	String actual = dashboard.fIGADP3New.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates Previous FIGA TO HO3 rate")
	public void User_validates_Previous_FIGA_DP3_rate() {
	String expected = "0.0070";
	String actual = dashboard.fIGADP3Old.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA TOHO3 rate in Worksheets")
	public void User_validates_2024_FIGA_TOHO3_rate_in_Worksheets() {
	String expected = "0.0100";
	String actual = dashboard.fIGA2024TOHO3Worksheets.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA TOHO3 rate in Premium Info")
	public void User_validates_2024_FIGA_TOHO3_rate_in_Premium_Info() {
	String expected = "275.61";
	String actual = dashboard.fIGA2024HO3PremiumInfo.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA TOHO3 rate in Review")
	public void User_validates_2024_FIGA_TOHO3_rate_in_Review() {
	String expected = "$275.61";
	String actual = dashboard.fIGA2024TOHO3Review.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
}