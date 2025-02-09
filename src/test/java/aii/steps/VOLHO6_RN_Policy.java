package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLHO6_RN_Policy extends CommonMethods {

	@Then("User verifies RN HO6 policy has been created successfully")
	public void User_verifies_RN_HO3_policy_has_been_created_successfully() throws Exception {
		String expected = "Renewal";
		String actual = historyChevron.txtRenewal.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		attachScreenShot(driver);
	}

	@Then("User verifies HO6 RN Water NonWeather Base Rate")
	public void User_verifies_HO6_RN_Water_NonWeather_Base_Rate() {
		String expected = "Initial Base Rate: 353.71<br> - Water Non-Weather Territory Code: 3<br> - Territory Factor: 1.630";
		String actual = worksheetsChevron.txtHO3NBWaterNonWeather.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 RN Fire or Lightning Base Rate")
	public void User_verifies_HO6_RN_Fire_or_Lightning_Base_Rate() {
		String expected = "Initial Base Rate: 50.93<br> - Fire or Lightning Territory Code: 10<br> - Territory Factor: 0.860";
		String actual = worksheetsChevron.txtHO3NBFireLightning.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO6 RN Hurricane Base Rate")
	public void User_verifies_HO6_RN_Hurricane_Base_Rate() {
		String expected = "Initial Base Rate: 2090.44<br> - Hurricane Territory Code: E4<br> - Territory Factor: 0.577";
		String actual = worksheetsChevron.txtHO3NBHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
}
