package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class TODP1_FIGA extends CommonMethods {

	@Then("User validates New FIGA TO DP1 rate")
	public void User_validates_New_FIGA_DP1_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA TO DP1 rate")
	public void User_validates_Previous_FIGA_TO_DP1_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGADP1Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates New FIGA TO DP1 rate after Endorsement")
	public void User_validates_New_FIGA_TO_DP1_rate_after_Endorsement() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP1 rate in Worksheets")
	public void User_validates_2024_FIGA_TODP1_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024TODP1Worksheets.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP1 rate in Premium Info")
	public void User_validates_2024_FIGA_TODP1_rate_in_Premium_Info() {
		String expected = "91.56";
		String actual = dashboard.fIGA2024PremiumInfo.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP1 rate in Review")
	public void User_validates_2024_FIGA_TODP1_rate_in_Review() {
		String expected = "$91.56";
		String actual = dashboard.fIGA2024TODP1Review.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

}