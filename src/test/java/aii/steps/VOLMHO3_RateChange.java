package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLMHO3_RateChange extends CommonMethods {
		

	@And("User enters VOL MHO3 Coverage A Dwelling")
	public void User_enters_VOL_MHO3_Coverage_A_Dwelling() {	    	   				
		wait(1);
		dwellingChevron.txtCoverageA.sendKeys("50000"); 	
		wait(1);
	}
	@Then("User verifies VOL MHO3 Private Property NonHurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_NonHurricane_rate() {
	String expected = "1302.00";
	String actual = worksheetsChevron.txtMHO3NonHurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies VOL MHO3 Private Property Hurricane rate")
	public void User_verifies_VOL_MHO3_Private_Property_Hurricane_rate() {
	String expected = "1337.00";
	String actual = worksheetsChevron.txtMHO3HurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates NonHurricane VOL MHO3 base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_MHO3_base_rate_in_Worksheets() {
	String expected = "1302.0000";
	String actual = worksheetsChevron.MHO3NonHurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates Hurricane VOL MHO3 base rate in Worksheets")
	public void User_validates_Hurricane_VOL_MHO3_base_rate_in_Worksheets() {
	String expected = "1969.00";
	String actual = worksheetsChevron.MHO3HurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@And("User enters Coverage A Dwelling as 51000")
	public void User_enters_Coverage_A_Dwelling_as_51000() {	    	   				
		
		dwellingChevron.txtCoverageA.clear();
		dwellingChevron.txtCoverageA.sendKeys("51000"); 	
		wait(1);
	}
	@Then("User validates NonHurricane VOL MHO3 additional premium base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_MHO3_additional_premiumbase_rate_in_Worksheets() {
	String expected = "1317.0000";
	String actual = worksheetsChevron.MHO3NonHurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User validates Hurricane VOL MHO3 additional premium base rate in Worksheets")
	public void User_validates_Hurricane_VOL_MHO3_additional_premiumbase_rate_in_Worksheets() {
	String expected = "1994.00";
	String actual = worksheetsChevron.MHO3HurricaneBasePremium.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	
	 
}