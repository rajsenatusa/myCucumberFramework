package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLDP1_RateChange extends CommonMethods {

	@And("User clicks Extended Coverage Building Hurricane Premium")
	public void User_clicks_Extended_Coverage_Building_Hurricane_Premium() {
		click(worksheetsChevron.eCBHP);
		wait(1);
	}

	@Then("User verifies Extended Coverage Building Hurricane Base rate")
	public void User_verifies_Extended_Coverage_Building_Hurricane_Base_rate() {
		String expected = "253.340";
		String actual = worksheetsChevron.DP1ExtendedCoverageBuildingHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Wind or Hail Exclusion Credit rate")
	public void User_verifies_Wind_or_Hail_Exclusion_Credit_rate() {
		String expected = "228.010";
		String actual = worksheetsChevron.DP1WindHailExclusionCreditRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User selects Sinkhole Loss")
	public void User_selects_Sinkhole_Loss() {
		wait(1);
		selectDropdownText(dwellingChevron.ddSinkholeLossDed, "10% Ded of Cov A");

	}

	@Then("User validates Coverage A increases by 10 percentage")
	public void User_validates_Coverage_A_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage B increases off of Coverage A inflated limit amount of 10 percentage")
	public void User_validates_Coverage_B_increases_off_of_Coverage_A_inflated_limit_amount_of_10_percentage() {

		String expected = "$54,200";
		String actual = dwellingChevron.limitCovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage C increases by 10 percentage")
	public void User_validates_Coverage_C_increases_by_10_percentage() {

		String expected = "10%";
		String actual = dwellingChevron.inflationGuardCovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Sinkhole Loss")
	public void User_validates_Sinkhole_Loss() {

		String expected = "10% Ded of Cov A";
		String actual = dwellingChevron.sinkholeDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@Then("User validates Coverage A on Coverages List")
	public void User_validates_Coverage_A_on_Coverages_List() {

		String expected = "542,000";
		String actual = dwellingChevron.coverageListCovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);

	}

	@And("User enters Coverage C in Dwelling")
	public void User_enters_Coverage_C_in_Dwelling() {

		dwellingChevron.txtCoverageC.sendKeys("25000");
		wait(1);

	}

}