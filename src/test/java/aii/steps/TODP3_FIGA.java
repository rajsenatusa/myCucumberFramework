package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class TODP3_FIGA extends CommonMethods {

	@Then("User validates New FIGA TO DP3 rate")
	public void User_validates_New_FIGA_DP3_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP3New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates New FIGA TO DP3 rate after Endorsement")
	public void User_validates_New_FIGA_TO_DP3_rate_after_Endorsement() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP3New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA TO DP3 rate")
	public void User_validates_Previous_FIGA_DP3_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGADP3Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP3  rate in Worksheets")
	public void User_validates_2024_FIGA_TODP3_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024TODP3Worksheets.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP3  rate in Premium Info")
	public void User_validates_2024_FIGA_TODP3_rate_in_Premium_Info() {
		String expected = "110.00";
		String actual = dashboard.fIGA2024PremiumInfo.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA TODP3  rate in Review")
	public void User_validates_2024_FIGA_TODP3_rate_in_Review() {
		String expected = "$110.00";
		String actual = dashboard.fIGA2024TODP3Review.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}