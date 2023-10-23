package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLDP3_RateChange extends CommonMethods {

	@And("User clicks Hurricane Building Coverage A Base Premium in Hurricane Building")
	public void User_clicks_Hurricane_Building_Coverage_A_Base_Premium_in_Hurricane_Building() {
		click(worksheetsChevron.VOLDP3HurricaneBuildingCoverageABasePremiumClick);
		wait(1);
	}

	@Then("User validates VOL DP3 Hurricane Coverage A Base Rate in Worksheets")
	public void User_validates_VOL_DP3_Hurricane_Coverage_A_Base_Rate_in_Worksheets() {
		String expected = "1415.0000";
		String actual = worksheetsChevron.VOLDP3HurricaneCoverageABaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

}