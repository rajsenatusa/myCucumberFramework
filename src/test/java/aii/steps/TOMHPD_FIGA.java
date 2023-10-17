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
	@Then("User validates 2024 FIGA TOMHPD rate in Worksheets")
	public void User_validates_2024_FIGA_TOMHPD_rate_in_Worksheets() {
	String expected = "0.0100";
	String actual = dashboard.fIGA2024TOMHPDWorksheets.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA TOMHPD rate in Premium Info")
	public void User_validates_2024_FIGA_TOMHPD_rate_in_Premium_Info() {
	String expected = "99.69";
	String actual = dashboard.fIGA2024PremiumInfo.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
	@Then("User validates 2024 FIGA TOMHPD rate in Review")
	public void User_validates_2024_FIGA_TOMHPD_rate_in_Review() {
	String expected = "$99.69";
	String actual = dashboard.fIGA2024TOMHPDReview.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}
}