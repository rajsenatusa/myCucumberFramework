package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;

public class MTR365_DP3_ValidateCovCOptionsDefaultChange_NB_END extends CommonMethods {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();

	@When("User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and Coverage C limit defaulted %25 and Cov C limit $75.000 is disabled")
	public void user_clicks_dwelling_tab_and_validates_c_personal_property_drop_down_contains_the_following_options_and_validates()
			throws Exception {
		
		click(dwellingChevron.btnDwelling);
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$75,000");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User clicks Policy General Chevron and changes Occupancy to Tenant")
	public void user_clicks_policy_general_chevron_and_changes_occupancy_to_tenant() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(3);
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		wait(2);
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		click(dwellingChevron.btnSave);
		wait(4);
	}

	@When("User clicks dwelling tab and verifies message <Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page>")
	public void user_clicks_dwelling_tab_and_verifies_written_message() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
		verify_AnyText_IsVisible(driver,
				"Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page");
	}

	@When("User sets Cov C personal Property amount as <17.000>")
	public void user_sets_cov_c_personal_property_amount_as_17000() throws Exception {
		sendText(dwellingChevron.txtCoverageC, "17000");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(4);
	}
}
