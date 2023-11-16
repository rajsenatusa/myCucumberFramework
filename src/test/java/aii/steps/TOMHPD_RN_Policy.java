package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TOMHPD_RN_Policy extends CommonMethods {

	@Then("User verifies RN TOMHPD policy has been created successfully")
	public void User_verifies_RN_TOMHPD_policy_has_been_created_successfully() {
		String expected = "Renewal";
		String actual = historyChevron.txtRenewal.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}
	@And("User enters Lease Term {string}")
	public void User_enters_Lease_Term(String LeaseTerm) {
		wait(1);
		selectDropdownText(policyChevron.ddLeaseTerm, LeaseTerm);
	}
	@And("User clicks Seasonal Property")
	public void User_clicks_Seasonal_Property() {
		wait(1);
		click(dwellingChevron.seasonalProperty);
		wait(2);
	}
	@And("User clicks Original Systems Surcharge")
	public void User_clicks_Original_Systems_Surcharge() {
		wait(1);
		click(dwellingChevron.originalSystems);
		wait(2);
	}

}
 