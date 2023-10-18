package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TODP1_RN_Policy extends CommonMethods {

	@Then("User verifies RN TODP1 policy has been created successfully")
	public void User_verifies_RN_TODP1_policy_has_been_created_successfully() {
		String expected = "Renewal";
		String actual = historyChevron.txtRenewal.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

	@And("User clicks History chevron")
	public void User_clicks_History_chevron() {
		click(dwellingChevron.btnHistory);
	}
}
