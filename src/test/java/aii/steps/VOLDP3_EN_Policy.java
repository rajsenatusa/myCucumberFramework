package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLDP3_EN_Policy extends CommonMethods {

	@And("User clicks EN Transaction Selection")
	public void User_clicks_EN_Transaction_Selection() {
				
		selectDropdownText(dashboard.ddSelectTransaction, "Endorsement");
		wait(3);
		click(dashboard.btnSelect);
		wait(5);
	}

	@And("User enters EN Effective Date {string}")
	public void User_enters_EN_Effective_Date(String EndorsementEffectiveDate) {
		wait(3);
		sendText(dashboard.txtSelectDate, EndorsementEffectiveDate);
		wait(3);
		click(dashboard.btnStart);
		dashboard.btnStart.click();
	}

	@And("User enters Second EN Effective Date {string}")
	public void User_enters_Second_EN_Effective_Date(String SecondEndorsementEffectiveDate) {
		wait(2);
		sendText(dashboard.txtSelectDate, SecondEndorsementEffectiveDate);
		wait(2);
		click(dashboard.btnStart);
		dashboard.btnStart.click();
	}

	@And("User enters Third EN Effective Date {string}")
	public void User_enters_Third_EN_Effective_Date(String ThirdEndorsementEffectiveDate) {
		wait(2);
		sendText(dashboard.txtSelectDate, ThirdEndorsementEffectiveDate);
		wait(2);
		click(dashboard.btnStart);
		dashboard.btnStart.click();
	}

	@And("User clicks Endorse Policy button")
	public void User_clicks_Endorse_Policy_button() {
		wait(2);
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();
		wait(2);
	}

	@Then("User verifies EN DP3 policy has been created successfully")
	public void User_verifies_EN_DP3_policy_has_been_created_successfully() {
		String expected = "Endorsement";
		String actual = historyChevron.txtEndorsement.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}
}