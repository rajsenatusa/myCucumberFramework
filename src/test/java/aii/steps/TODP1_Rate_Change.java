package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TODP1_Rate_Change extends CommonMethods {

	@And("User clicks EC Key Premium in Extended Coverage")
	public void User_clicks_EC_Key_Premium_in_Extended_Coverage() {
		wait(3);
		click(worksheetsChevron.TODP1ECKeyPremiumClick);
		wait(1);
	}

	@Then("User validates SeasonalBuilding TODP1 premium in Worksheets")
	public void User_validates_SeasonalBuilding_TODP1_premium_in_Worksheets() {
		String expected = "180.63";
		String actual = worksheetsChevron.TODP1SeasonalBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates WindExclusionCreditBuilding TODP1 rate in Worksheets")
	public void User_validates_WindExclusionCreditBuilding_TODP1_rate_in_Worksheets() {
		String expected = "50.39";
		String actual = worksheetsChevron.TODP1WindExclusionCreditBuilding.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}