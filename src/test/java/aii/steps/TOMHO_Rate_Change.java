package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TOMHO_Rate_Change extends CommonMethods {

	@Then("User validates TOMHO base rate in Worksheets")
	public void User_validates_TOMHO_base_rate_in_Worksheets() {
		String expected = "1981.00";
		String actual = worksheetsChevron.TOMHOBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOMHO wind exclusion base rate in Worksheets")
	public void User_validates_TOMHO_wind_exclusion_base_rate_in_Worksheets() {
		String expected = "798.00";
		String actual = worksheetsChevron.TOMHOWindExclusionBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}