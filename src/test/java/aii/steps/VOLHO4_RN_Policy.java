package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLHO4_RN_Policy extends CommonMethods {

	@Then("User verifies RN HO4 policy has been created successfully")
	public void User_verifies_RN_HO4_policy_has_been_created_successfully() {
		String expected = "Renewal";
		String actual = historyChevron.txtRenewal.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

}
