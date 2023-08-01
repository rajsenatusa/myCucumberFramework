package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR366_DP3_ValidateCovCOptionsDisplayWhenCoverageIsIntegritySelect_NotDisplayForBasic_NB_END extends CommonMethods{

	@When("User enters all required information on DP3 dwelling screen and selects integrity select package")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_and_selects_integrity_select_package() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, ConfigsReader.getProperty("mediation"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.rbIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
		
	}
	
	@When("User validates Coverage C defaults to %25 on integrity select package")
	public void user_validates_coverage_c_defaults_to_25_on_integrity_select_package() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "25%");
		
	}
	@When("User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70%")
	public void user_validates_cov_c_drop_down_contains_the_following_options() throws Exception {
		String[] cov_C = {"10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%"};
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		click(dwellingChevron.btnSave);
	}
}
