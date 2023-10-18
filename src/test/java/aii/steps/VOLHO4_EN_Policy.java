package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLHO4_EN_Policy extends CommonMethods {

	@Then("User verifies EN HO4 policy has been created successfully")
	public void User_verifies_EN_HO4_policy_has_been_created_successfully() {
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}
}