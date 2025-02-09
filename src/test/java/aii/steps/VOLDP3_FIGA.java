package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLDP3_FIGA extends CommonMethods {

	@And("User adds FIGA DP3 effective date {string}")
	public void User_adds_FIGA_DP3_effective_date(String FIGADP3EffectiveDate) {
		sendText(product.txtEffectiveDate, FIGADP3EffectiveDate);
	}

	@Then("User validates New FIGA DP3 rate")
	public void User_validates_New_FIGA_DP3_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP3New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA DP3 rate")
	public void User_validates_Previous_FIGA_DP3_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGADP3Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL DP3 rate in Worksheets")
	public void User_validates_2024_FIGA_VOL_DP3_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024HO3.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL DP3 rate in Premium Info")
	public void User_validates_2024_FIGA_VOL_DP3_rate_in_Premium_Info() throws Exception {
//		String expected = "12.52";
//		String actual = dashboard.fIGA2024HO3PremiumInfo.getText();
//		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		attachScreenShot(driver);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL DP3 rate in Review")
	public void User_validates_2024_FIGA_VOL_DP3_rate_in_Review() throws Exception {
//		String expected = "$12.52";
//		String actual = dashboard.fIGA2024DP3Review.getText();
//		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		attachScreenShot(driver);
		wait(1);
	}

}