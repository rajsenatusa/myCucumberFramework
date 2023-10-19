package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TODP3_Rate_Change extends CommonMethods {

	@And("User clicks EC Key Premium Adjusted in Extended Coverage Building")
	public void User_clicks_EC_Key_Premium_Adjusted_in_Extended_Coverage_Building() {
		wait(3);
		click(worksheetsChevron.TODP3ECKeyPremiumClick);
		wait(1);
	}

	@Then("User validates NonSeasonalBuilding TODP3 premium in Worksheets")
	public void User_validates_NonSeasonalBuilding_TODP3_premium_in_Worksheets() {
		String expected = "509.47";
		String actual = worksheetsChevron.TODP3NonSeasonalBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates WindExclusionCreditBuilding TODP3 rate in Worksheets")
	public void User_validates_WindExclusionCreditBuilding_TODP3_rate_in_Worksheets() {
		String expected = "368.150";
		String actual = worksheetsChevron.TODP3WindExclusionCreditBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}