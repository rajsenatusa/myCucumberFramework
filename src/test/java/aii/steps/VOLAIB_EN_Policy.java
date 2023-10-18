package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLAIB_EN_Policy extends CommonMethods {

	@Then("User verifies EN AIB policy has been created successfully")
	public void User_verifies_EN_AIB_policy_has_been_created_successfully() {
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}
}