package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class VOLHO6_EN_Policy extends CommonMethods {

	@Then("User verifies EN HO6 policy has been created successfully")
	public void User_verifies_EN_HO6_policy_has_been_created_successfully() throws Exception {
		wait(1);
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
		wait(1);
		attachScreenShot(driver);
	}
}