package aii.steps;

import org.junit.Assert;
import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VOLHO4_RateChange extends CommonMethods {

	@And("User clicks Rate Area Hurricane")
	public void User_clicks_Rate_Area_Hurricane() {
		wait(3);
		click(worksheetsChevron.linkRateAreaHurricane);
		wait(1);
	}

	@Then("User verifies VOL HO4 Hurricane Base Rate")
	public void User_verifies_VOL_HO4_Hurricane_Base_Rate() {
		String expected = "60.00";
		String actual = worksheetsChevron.HurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks NonHurricane Base Premium")
	public void User_clicks_NonHurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4NonHurricaneBasePremiumClick);
		wait(1);
	}

	@Then("User validates NonHurricane VOL HO4 base rate in Worksheets")
	public void User_validates_NonHurricane_VOL_HO4_base_rate_in_Worksheets() {
		String expected = "116.00";
		String actual = worksheetsChevron.HO4NonHurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks Hurricane Base Premium")
	public void User_clicks_Hurricane_Base_Premium() {
		wait(3);
		click(worksheetsChevron.HO4HurricaneBasePremiumClick);
		wait(1);
	}

	@Then("User validates Hurricane VOL HO4 base rate in Worksheets")
	public void User_validates_Hurricane_VOL_HO4_base_rate_in_Worksheets() {
		String expected = "60.00";
		String actual = worksheetsChevron.HO4HurricaneBasePremium.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C increases by 10 percentage")
	public void User_validates_HO4_Coverage_C_increases_by_10_percentage() {
		String expected = "$33,000";
		String actual = worksheetsChevron.HO4CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D increases by 10 percentage")
	public void User_validates_HO4_Coverage_D_increases_by_10_percentage() {
		String expected = "$6,600";
		String actual = worksheetsChevron.HO4CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C on Coverages List")
	public void User_validates_HO4_Coverage_C_on_Coverages_List() {
		String expected = "33,000";
		String actual = worksheetsChevron.HO4CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D on Coverages List")
	public void User_validates_HO4_Coverage_D_on_Coverages_List() {
		String expected = "6,600";
		String actual = worksheetsChevron.HO4CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates 10 percentage Inflation guard for Cov C")
	public void User_validates_10_percentage_Inflation_guard_for_Cov_C() {
		String expected = "10%";
		String actual = worksheetsChevron.HO4CovAInflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C increases by 10 percentage after second RN")
	public void User_validates_HO4_Coverage_C_increases_by_10_percentage_after_second_RN() {
		String expected = "$37,000";
		String actual = worksheetsChevron.HO4CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D increases by 10 percentage after second RN")
	public void User_validates_HO4_Coverage_D_increases_by_10_percentage_after_second_RN() {
		String expected = "$7,400";
		String actual = worksheetsChevron.HO4CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage C on Coverages List after second RN")
	public void User_validates_HO4_Coverage_C_on_Coverages_List_after_second_RN() {
		String expected = "37,000";
		String actual = worksheetsChevron.HO4CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO4 Coverage D on Coverages List after second RN")
	public void User_validates_HO4_Coverage_D_on_Coverages_List_after_second_RN() {
		String expected = "7,400";
		String actual = worksheetsChevron.HO4CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

}