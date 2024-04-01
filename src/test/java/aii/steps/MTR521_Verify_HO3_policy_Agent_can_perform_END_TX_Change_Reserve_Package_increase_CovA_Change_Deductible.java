package aii.steps;

import aii.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MTR521_Verify_HO3_policy_Agent_can_perform_END_TX_Change_Reserve_Package_increase_CovA_Change_Deductible extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String app_Tx_Policy_Claim_Num;
	static String policyNum;
	
	@When("User enters all required information on HO3 dwelling screen <mtr521>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_mtr521() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2021");
//		selectDropdownText(dwellingChevron.bCEG, "3");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}
	@When("User completes required information on dwelling chevron <mtr521>")
	public void user_completes_required_information_on_dwelling_chevron_mtr521() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(4);
        selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$5,000");
		wait(4);
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		wait(4);
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$5,000");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@When("User enters on HO3 dwelling screen and enters <Gold Reserve>")  
	public void User_enters_on_HO3_dwelling_screen_and_enters_Gold_Reserve_A_Dwelling_600000_Deductible_AOP_2000_Deductible_Hurricane() {

		click(dwellingChevron.rbGoldReserve);
		(dwellingChevron.txtCoverageA).clear();
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "500000");
		wait(7);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,000");
		wait(4);
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "4%");
		wait(4);
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$2,000");
		wait(7);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,000");
		click(dwellingChevron.btnSave);
	}
	@When("User clicks Delete hyperlink")  
	public void User_clicks_Delete_hyperlink() throws Exception {

		click(additionalinterest.linkDelete);
		wait(1);
		click(additionalinterest.dialogOK);
		wait(1);
		attachScreenShot(driver);
		
	}
	@Then("User validates Endorsement Changes <mtr521>")
	public void User_validates_Endorsement_Changes_mtr521() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Deductible Change: All Other Perils Changed From $5,000 to $2,000");
		verify_AnyfirstText_IsDisplayed(driver, "	Deductible Change: Wind/Hail Changed From $5,000 to $2,000");
		verify_AnyfirstText_IsDisplayed(driver,
				"Deductible Change: Hurricane Changed From 10% to 4%");
		verify_AnyfirstText_IsDisplayed(driver,
				"	Animal Liability Changed From None to Yes");
		attachScreenShot(driver);
		wait(2);
	}
	
	
	
	
	
}

	
	
	

