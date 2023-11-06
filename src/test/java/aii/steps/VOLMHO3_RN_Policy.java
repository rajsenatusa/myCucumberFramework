package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLMHO3_RN_Policy extends CommonMethods {

	@Then("User verifies RN MHO3 policy has been created successfully")
	public void User_verifies_RN_MHO3_policy_has_been_created_successfully() {
		String expected = "Renewal";
		String actual = historyChevron.txtRenewal.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

	@And("User clicks Property Type as Park")
	public void User_clicks_Property_Type_as_Park() {
		click(policyChevron.btnParkPropertyType);

	}

	@And("User clicks search for Park Name an Adult Park")
	public void User_clicks_search_for_Park_Name_an_Adult_Park() {

		policyChevron.parkNumber.sendKeys("11");
		click(policyChevron.btnSearchPark);
	}
	@And("User selects Other Structures")
	public void User_selects_Other_Structures() {

		selectDropdownText(dwellingChevron.ddCovBOtherStructures, "1%");
		wait(1);
		 
	}

}
