package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TOMHPD_Rate_Change extends CommonMethods {

	@And("User clicks EC Flat Premium in Extended Coverage Building")
	public void User_clicks_EC_Flat_Premium_in_Extended_Coverage_Building() {
		wait(3);
		click(worksheetsChevron.TOMHPDECFlatPremiumClick);
		wait(1);
	}

	@Then("User validates TOMHPD EC Key Premium in Worksheets")
	public void User_validates_TOMHPD_EC_Key_Premium_in_Worksheets() {
		String expected = "85.96";
		String actual = worksheetsChevron.TOMHPDECKeyPremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates TOMHPD EC Flat Premium in Worksheets")
	public void User_validates_TOMHPD_EC_Flat_Premium_in_Worksheets() {
		String expected = "171.83";
		String actual = worksheetsChevron.TOMHPDECFlatPremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
}