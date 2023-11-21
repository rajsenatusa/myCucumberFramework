package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLHO3_FIGA extends CommonMethods {

	@And("User adds FIGA HO3 effective date {string}")
	public void User_adds_FIGA_DP3_effective_date(String FIGAHO3EffectiveDate) {
		sendText(product.txtEffectiveDate, FIGAHO3EffectiveDate);
	}

	@Then("User validates New FIGA HO3 rate")
	public void User_validates_New_FIGA_HO3_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGAHO3New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA HO3 rate")
	public void User_validates_Previous_FIGA_HO3_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGAHO3Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL HO3 rate in Worksheets")
	public void User_validates_2024_FIGA_VOL_HO3_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024HO3Worksheets.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL HO3 rate in Premium Info")
	public void User_validates_2024_FIGA_VOL_HO3_rate_in_Premium_Info() {
		String expected = "18.39";
		String actual = dashboard.fIGA2024HO3PremiumInfo.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA VOL HO3 rate in Review")
	public void User_validates_2024_FIGA_VOL_HO3_rate_in_Review() {
		String expected = "$18.39";
		String actual = dashboard.fIGA2024HO3Review.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}