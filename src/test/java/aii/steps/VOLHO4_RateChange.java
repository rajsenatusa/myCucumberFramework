package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLHO4_RateChange extends CommonMethods {
		
	@And("User clicks Rate Area Hurricane")
	public void User_clicks_Rate_Area_Hurricane() {
		wait(3);
		click(worksheetsChevron.linkRateAreaHurricane);
		wait(1);
	}
 	@Then("User verifies VOL HO4 Hurricane Base Rate")
	public void User_verifies_VOL_HO4_Hurricane_Base_Rate() {
	String expected = "60.00";
	String actual = worksheetsChevron.HurricaneBaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
 	@And("User clicks NonHurricane Base Premium")
	public void User_clicks_NonHurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4NonHurricaneBasePremiumClick);
		wait(1);
	}
 	@Then("User validates NonHurricane VOL HO4 base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_HO4_base_rate_in_Worksheets() {
	String expected = "116.00";
	String actual = worksheetsChevron.HO4NonHurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks Hurricane Base Premium")
	public void User_clicks_Hurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4HurricaneBasePremiumClick);
		wait(1);
	}
 	@Then("User validates Hurricane VOL HO4 base rate in Worksheets")
	public void User_validates_Hurricane_VOL_HO4_base_rate_in_Worksheets() {
	String expected = "60.00";
	String actual = worksheetsChevron.HO4HurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
 	
 	
} 