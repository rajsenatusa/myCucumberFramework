package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLDP1_RateChange extends CommonMethods {

	@And("User clicks Extended Coverage Building Hurricane Premium")
	public void User_clicks_Extended_Coverage_Building_Hurricane_Premium() {
		click(worksheetsChevron.eCBHP);
		wait(1);
	}

	@Then("User verifies Extended Coverage Building Hurricane Base rate")
	public void User_verifies_Extended_Coverage_Building_Hurricane_Base_rate() {
		String expected = "253.340";
		String actual = worksheetsChevron.DP1ExtendedCoverageBuildingHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Wind or Hail Exclusion Credit rate")
	public void User_verifies_Wind_or_Hail_Exclusion_Credit_rate() {
		String expected = "228.010";
		String actual = worksheetsChevron.DP1WindHailExclusionCreditRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
}