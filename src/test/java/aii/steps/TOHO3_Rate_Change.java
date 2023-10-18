package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TOHO3_Rate_Change extends CommonMethods {

	@Then("User verifies TOHO3 Base Rate premium")
	public void User_verifies_TOHO3_Base_Rate_premium() {
		String expected = "7251.00";
		String actual = worksheetsChevron.tOHO3BaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@And("User clicks Key Wind Rate")
	public void User_clicks_Key_Wind_Rate() {
		wait(3);
		click(worksheetsChevron.TOHO3KeyWindRateClick);
		wait(1);
	}

	@Then("User validates TOHO3 base rate in Worksheets")
	public void User_validates_TOHO3_base_rate_in_Worksheets() {
		String expected = "7816.00";
		String actual = worksheetsChevron.TOHO3BaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOHO3 wind exclusion base rate in Worksheets")
	public void User_validates_TOHO3_wind_exclusion_base_rate_in_Worksheets() {
		String expected = "6339.00";
		String actual = worksheetsChevron.TOHO3WindExclusionBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}