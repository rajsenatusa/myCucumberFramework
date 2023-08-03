package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR366_DP3_ValidateCovCOptionsDisplayWhenCoverageIsIntegritySelect_NotDisplayForBasic_NB_END
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();

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
		wait(3);
	}

	@When("User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70%")
	public void user_validates_cov_c_drop_down_contains_the_following_options() throws Exception {
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User changes Coverage A to <300.000> and validates text box for Cov C should display the value amount that equates to the percentage selected of Cov-A and should be disabled")
	public void user_changes_coverage_a_to_300000_and_validates_text_box_for_covc() throws Exception {
		sendText(dwellingChevron.txtCoverageA, "300000");
		wait(2);
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$75,000");
		wait(2);
	}

	@When("User selects C-Personal Property <70%> and validates text box for C-Personal Property should display the value amount that equates to the <70%> percentage selected of Cov-A and should be disabled")
	public void user_selects_c_personal_property_70_and_clicks_save() throws Exception {
		selectDropdownText(dwellingChevron.ddCovCLimit, "70%");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		wait(2);
	}

	@When("User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled")
	public void user_clicks_dwelling_tab_and_validates_c_personal_property_drop_down_contains_the_following()
			throws Exception {
		click(dwellingChevron.btnDwelling);
		String[] cov_C = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "70%");
		verifyAnyDropDownOptions(driver, cov_C, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User validates that DP3 policy has been created successfully and closes unnecessary tabs")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_closes_unnecessary_Tabs() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}

	     // Close unnecessary tabs
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       for (int i = tabs.size() - 1; i > 0; i--) {
           driver.switchTo().window(tabs.get(i));
           driver.close();
       }

       // Switch back to the main page
       driver.switchTo().window(tabs.get(0));
	}
	@When("User clicks dwelling chevron and validates C-Personal Property defaults to <70%> and should display the value amount that equates to the <70%> percentage selected of Cov-A")
	public void user_clicks_dwelling_chevron_and_validates_c_personal_property_defaults_to_70_and_should_display() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
		verifyAnyDisabledFieldsValue(driver, "Building.CovCLimitIncluded_text", "70%");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
	}
	@When("User clicks more button and starts transaction")
	public void user_clicks_more_button_and_starts_transaction() throws Exception {
		click(dwellingChevron.btnMore);
		click(dwellingChevron.btnStartTransaction);
		wait(3);
	}
	@When("User clicks Dwelling tab on endorsement level and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled")
	public void user_clicks_dwelling_tab_on_endorsement_level_and_validates_c_personal_property_drop_down_contains_the_following()
			throws Exception {
		
		click(dwellingChevron.btnDwelling);
		wait(4);
		String[] covC = { "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%" };
		verifyAnyDropdownDefaultedValue(driver, "Building.CovCLimitIncluded", "70%");
		verifyAnyDropDownOptions(driver, covC, "Building.CovCLimitIncluded");
		verifyAnyDisabledFieldsValue(driver, "CovCLimit", "$210,000");
		wait(3);
	}
	@When("User endorses policy to basic policy")
	public void user_endorses_policy_to_basic_policy() throws Exception {
		click(dwellingChevron.rbBasicPackage);
		Hooks.scenario.log("Basic Package selected");
		wait(2);
	}
	@When("User enters <170.000> for Coverage C value")
	public void user_enters_170000_for_coverage_c_value() throws Exception {
		sendText(dwellingChevron.txtPersonalPropertyC, "170000");
		click(dwellingChevron.btnSave);
	}
	@When("User finalizes transaction and completes endorsement")
	public void user_finalizes_transaction_and_completes_endorsement() throws Exception {
		click(reviewChevron.btnFinalize);
		wait(3);
		click(reviewChevron.btnProcess);
		wait(3);
	}
	@When("User validates that Endorsement transaction has been completed successfully")
	public void user_validates_that_endorsement_transaction_has_been_completed_successfully() throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_2_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("Endorsement")) {
			System.out.println("DP3 Endorsement has been processed successfully");

		} else {
			System.out.println("DP3 Endorsement has been failed!");

		}

	     // Close unnecessary tabs
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       for (int i = tabs.size() - 1; i > 0; i--) {
           driver.switchTo().window(tabs.get(i));
           driver.close();
       }

       // Switch back to the main page
       driver.switchTo().window(tabs.get(0));
	}
}
