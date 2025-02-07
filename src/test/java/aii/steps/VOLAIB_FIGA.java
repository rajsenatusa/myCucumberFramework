package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLAIB_FIGA extends CommonMethods {

	@Then("User validates New FIGA AIB rate")
	public void User_validates_New_FIGA_DP1_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA AIB rate")
	public void User_validates_Previous_FIGA_TO_DP1_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGADP1Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates New FIGA AIB rate after Endorsement")
	public void User_validates_New_FIGA_TO_DP1_rate_after_Endorsement() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA AIB rate in Worksheets")
	public void User_validates_2024_FIGA_AIB_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024AIBWorksheets.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA AIB rate in Premium Info")
	public void User_validates_2024_FIGA_AIB_rate_in_Premium_Info() {
		String expected = "1.00";
		String actual = dashboard.fIGA2024PremiumInfo.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA AIB rate in Review")
	public void User_validates_2024_FIGA_AIB_rate_in_Review() {
		String expected = "$1.00";
		String actual = dashboard.fIGA2024AIBReview.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
	@And("User enters Producer Code for <mtr3625>")
	public void User_enters_Producer_Code_for_mtr3625() {
		policyChevron.txtProducerCodeSel.sendKeys("AG0098A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}
	
}