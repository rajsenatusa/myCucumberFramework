package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLUMB_FIGA extends CommonMethods {

	@Then("User validates New FIGA UMB rate")
	public void User_validates_New_FIGA_DP1_rate() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates Previous FIGA UMB rate")
	public void User_validates_Previous_FIGA_UMB_rate() {
		String expected = "0.0070";
		String actual = dashboard.fIGADP1Old.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates New FIGA UMB rate after Endorsement")
	public void User_validates_New_FIGA_UMB_rate_after_Endorsement() {
		String expected = "0.0170";
		String actual = dashboard.fIGADP1New.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@Then("User validates 2024 FIGA UMB rate in Worksheets")
	public void User_validates_2024_FIGA_UMB_rate_in_Worksheets() {
		String expected = "0.0100";
		String actual = dashboard.fIGA2024UMBWorksheets.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}
	@And("User enters Producer Code for <mtr3646>")
	public void User_enters_Producer_Code_for_mtr3646() {
		policyChevron.txtProducerCodeSel.sendKeys("AG1730A1");
		click(dwellingChevron.btnSave);
		wait(1);
	}

}