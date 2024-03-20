package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4875_User_Management_Requests_Roles_and_Attributes_Adding_Builder_user_role_manually_to_A2_agent extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String totalDue;
	static String preAutoDt;
	static String autoRenewDt;
	static String temp;
	static String DP1_renewalTerm1;
	static String renewal_effective;

	@When("User searches Agent AG8134")
	public void user_searches_agent_ag8134() {
		wait(1);
		sendText(driver.findElement(By.id("SearchText")), "AG8134");
		click(userLookup.btnSearch);
		wait(3);
	}
	@When("User clicks user code as AG8134A2 and validates agent code will display")
	public void User_clicks_user_code_as_AG8134A2_and_validates_agent_code_will_display() throws Exception {
		wait(1);
		verify_AnyfirstText_IsDisplayed(driver, "AG8134A2");
		Hooks.scenario.log("User code displays successfully!");
		attachScreenShot(driver);
		wait(1);
		click(driver.findElement(By.linkText("AG8134A2")));
		wait(1);
		
	}
	@When("User clicks Override Link on Policy Agent Standard and validates Override Link")
	public void user_clicks_override_link_on_policy_agent_standard_validates_Override_Link() throws Exception {
		Hooks.scenario.log("User code displays successfully!");
		attachScreenShot(driver);
		wait(1);
		click(userLookup.lnkOverride);
		wait(3);
	}
	@When("User validates for the attribute of 'Can the User Approve Assisted Living Care Coverage' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Can_the_User_Approve_Assisted_Living_Care_Coverage_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtApproveAssistedLivingCareCoverage);
		wait(1);
		userLookup.boxUserRoleAttr74.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners, Can the user approve an Structure rented to others change?' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Homeowners_Can_the_user_approve_an_Structure_rented_to_others_change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtCanUserApproveStructureRented);
		wait(1);
		userLookup.boxUserRoleAttr72.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Can the user approve an Ordiance or Law change?' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Can_the_user_approve_an_Ordiance_or_Law_change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtOrdianceLawChange);
		wait(1);
		userLookup.boxUserRoleAttr75.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Allowed To Approve No Insurance Score' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allowed_To_Approve_No_Insurance_Score_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtApproveNoInsuranceScore);
		wait(1);
		userLookup.boxUserRoleAttr711.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Dwelling - Allowed To Approve Address Change' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Dwelling_Allowed_To_Approve_Address_Change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowedApproveAddressChange);
		wait(1);
		userLookup.boxUserRoleAttr713.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Dwelling - Allowed To Approve Name Change' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Dwelling_Allowed_To_Approve_Name_Change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowedApproveNameChange);
		wait(1);
		userLookup.boxUserRoleAttr717.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Dwelling - Allowed To Approve New Business' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Dwelling_Allowed_To_Approve_New_Business_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowedApproveNewBusiness);
		wait(1);
		userLookup.boxUserRoleAttr718.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Dwelling - Maximum Coverage A Change Allowed'")
	public void user_validates_as_for_the_attribute_of_Dwelling_Maximum_Coverage_A_Change_Allowed_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMaximumCoverageAChangeAllowed);
		wait(1);
		userLookup.boxUserRoleAttr719.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners - Allowed To Approve Address Change' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Homeowners_Allowed_To_Approve_Address_Change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowedApproveAddressChange720);
		wait(1);
		userLookup.boxUserRoleAttr720.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners - Allowed To Approve Name Change' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Homeowners_Allowed_To_Approve_Name_Change_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtHomeownersAllowedApproveNameChange);
		wait(1);
		userLookup.boxUserRoleAttr725.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners - Maximum Coverage A Change Allowed'")
	public void user_validates_as_for_the_attribute_of_Homeowners_Maximum_Coverage_A_Change_Allowed_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtHomeownersMaximumCoverageAChangeAllowed);
		wait(1);
		userLookup.boxUserRoleAttr728.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'ISO Location Return Override' selected as Yes")
	public void user_validates_as_for_the_attribute_of_ISO_Location_Return_Override_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtISOLocationReturnOverride);
		wait(1);
		userLookup.boxUserRoleAttr753.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners - Allow acreage greater than 5' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Homeowners_Allow_acreage_greater_than_5_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtHomeownersAllowAcreageGreater);
		wait(1);
		userLookup.boxUserRoleAttr756.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Homeowners - Approve Delete Sinkhole' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Homeowners_Approve_Delete_Sinkhole_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtHomeownersApproveDeleteSinkhole);
		wait(1);
		userLookup.boxUserRoleAttr777.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'The maximum number of days a user can back date an insured request cancellation without approval'")
	public void user_validates_as_for_the_attribute_of_The_maximum_umber_days_a_user_can_back_date_an_insured_request_cancellation_without_approval_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMaximumNumberofDays);
		wait(1);
		userLookup.boxUserRoleAttr778.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Allow Approve Capacity - minimum Coverage A' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Approve_Capacity_minimum_Coverage_A_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApproveCapacityminimumCoverageA);
		wait(1);
		userLookup.boxUserRoleAttr781.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Allow approve Capacity - loss causes' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_approve_Capacity_loss_causes_selected_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApproveCapacityLossCauses);
		wait(1);
		userLookup.boxUserRoleAttr787.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'ApproveHVACUpdate' selected as Yes")
	public void user_validates_as_for_the_attribute_of_ApproveHVACUpdate_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtApproveHVACUpdate);
		wait(1);
		userLookup.boxUserRoleAttr797.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Allow to Approve Age of Plumbing' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_to_Approve_Age_of_Plumbing_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApproveAgePlumbing);
		wait(1);
		userLookup.boxUserRoleAttr798.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'ApproveElectricalUpdate' selected as Yes")
	public void user_validates_as_for_the_attribute_of_ApproveElectricalUpdate_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtApproveElectricalUpdate);
		wait(1);
		userLookup.boxUserRoleAttr799.click();
		wait(2);
		attachScreenShot(driver);
	}
	
	@When("User validates for the attribute of 'Condo - Maximum Coverage A + C changed'")
	public void user_validates_as_for_the_attribute_of_Condo_Maximum_Coverage_A_C_changed_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtCondoMaximumCoverageACchanged);
		wait(1);
		userLookup.boxUserRoleAttr7106.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Condo - Approve selected wind exclusion' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Condo_Approve_selected_wind_exclusion_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtCondoApproveselectedwindexclusion);
		wait(1);
		userLookup.boxUserRoleAttr7117.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Condo - Allowed to Approve Age of Systems' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Condo_Allowed_Approve_Age_of_Systems_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtCondoAllowedApproveAgeSystems);
		wait(1);
		userLookup.boxUserRoleAttr7119.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Dwelling - Allowed to Approve Short Term Rental?' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Dwelling_Allowed_Approve_Short_Term_Rental_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtDwellingAllowedApproveShortTermRental);
		wait(1);
		userLookup.boxUserRoleAttr7127.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Dwelling - Maximum Condo Unit Owner Limit Change Allowed'")
	public void user_validates_as_for_the_attribute_of_Dwelling_Maximum_Condo_Unit_Owner_Limit_Change_Allowed_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtDwellingMaximumCondoUnitOwner);
		wait(1);
		userLookup.boxUserRoleAttr7130.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow to Approve Lease Term' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Approve_Lease_Term_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApproveLeaseTerm);
		wait(1);
		userLookup.boxUserRoleAttr7132.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Dwelling DP1 - Approve selected wind exclusion' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Dwelling_DP1_Approve_selected_wind_exclusion_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtDwellingDP1Approveselectedwindexclusion);
		wait(1);
		userLookup.boxUserRoleAttr7143.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow to Approve Change to Vandalism and Malicious Mischief' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Approve_Change_Vandalism_Malicious_Mischiefn_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApproveChangeVandalism);
		wait(1);
		userLookup.boxUserRoleAttr7145.click();
		wait(2);
		attachScreenShot(driver);
	} 
	
	@When("User validates for the attribute of 'Dwelling - Maximum Coverage A Change DP1'")
	public void user_validates_as_for_the_attribute_of_Dwelling_Maximum_Coverage_A_Change_DP1_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtDwellingMaximumCoverageAChangeDP1);
		wait(1);
		userLookup.boxUserRoleAttr7148.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Mobile Home - Maximum Coverage A Change'")
	public void user_validates_as_for_the_attribute_of_Mobile_Home_Maximum_Coverage_A_Change_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMobileHomeMaximumCoverageAChange);
		wait(1);
		userLookup.boxUserRoleAttr7160.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Personal Umbrella - Allowed to Approve New Business' selected as No")
	public void user_validates_as_for_the_attribute_of_Personal_Umbrella_Allowed_Approve_New_Business_as_no()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtPersonalUmbrellaAllowedApproveNewBusiness);
		wait(1);
		userLookup.boxUserRoleAttr7171.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'FloodZoneOverride' selected as Yes")
	public void user_validates_as_for_the_attribute_of_FloodZoneOverride_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtFloodZoneOverride);
		wait(1);
		userLookup.boxUserRoleAttr7308.click();
		wait(2);
		attachScreenShot(driver);
	}
	@When("User validates for the attribute of 'Allow Plumbing Year Approval' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Plumbing_Year_Approval_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowPlumbingYearApproval);
		wait(1);
		userLookup.boxUserRoleAttr7315.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Condo - Allowed to Approve Monthly Rental' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Condo_Allowed_Approve_Monthly_Rental_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtCondoAllowedApproveMonthlyRental);
		wait(1);
		userLookup.boxUserRoleAttr7498.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Application Take Ownership' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Application_Take_Ownership_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowApplicationTakeOwnership);
		wait(1);
		userLookup.boxUserRoleAttr84.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Override Lat Long Edit' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Override_Lat_Long_Edit_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowOverrideLatLongEdit);
		wait(1);
		userLookup.boxUserRoleAttr827.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Quote Take Ownership' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Quote_Take_Ownership_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowQuoteTakeOwnership);
		wait(1);
		userLookup.boxUserRoleAttr842.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Rewrite New' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Rewrite_New_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowRewriteNew);
		wait(1);
		userLookup.boxUserRoleAttr859.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Protection Class Override' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Protection_Class_Override_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowProtectionClassOverride);
		wait(1);
		userLookup.boxUserRoleAttr892.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow BCEG Override' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_BCEG_Override_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowBCEGOverride);
		wait(1);
		userLookup.boxUserRoleAttr895.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Edit ISO Location Fields' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Edit_ISO_Location_Fields_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowEditISOLocationFields);
		wait(1);
		userLookup.boxUserRoleAttr896.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Edit Year Built' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Edit_Year_Built_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowEditYearBuilt);
		wait(1);
		userLookup.boxUserRoleAttr8101.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'TOApproveYOCChg' selected as Yes")
	public void user_validates_as_for_the_attribute_of_TOApproveYOCChg_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtTOApproveYOCChg);
		wait(1);
		userLookup.boxUserRoleAttr8110.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Maximum Forward Date Change'")
	public void user_validates_as_for_the_attribute_of_Maximum_Forward_Date_Change_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMaximumForwardDateChange);
		wait(1);
		userLookup.boxUserRoleAttr8123.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Edit Dwelling Address' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Edit_Dwelling_Address_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMAllowEditDwellingAddress);
		wait(1);
		userLookup.boxUserRoleAttr8124.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Ordinance Or Law Change' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Ordinance_Or_Law_Change_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtMAllowEditDwellingAddress);
		wait(1);
		userLookup.boxUserRoleAttr8124.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow View Loss History Hidden Details' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_View_Loss_History_Hidden_Details_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowViewLossHistoryHiddenDetails);
		wait(1);
		userLookup.boxUserRoleAttr8128.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow to View and Edit Book Transfer field' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_View_Edit_Book_Transfer_field_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowViewEditBookTransferfield);
		wait(1);
		userLookup.boxUserRoleAttr8132.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'HO6 ByPass Insurance Score Apply' selected as Yes")
	public void user_validates_as_for_the_attribute_of_HO6_ByPass_Insurance_Score_Apply_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtHO6ByPassInsuranceScoreApply);
		wait(1);
		userLookup.boxUserRoleAttr8150.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Allow Coastal Zone Edit' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Allow_Coastal_Zone_Edit_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtAllowCoastalZoneEdit);
		wait(1);
		userLookup.boxUserRoleAttr8167.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User validates for the attribute of 'Roles Able to Approve Capacity - All UW, Admin and Gold or Diamond Agents' selected as Yes")
	public void user_validates_as_for_the_attribute_of_Roles_Able_Approve_Capacity_All_UW_Admin_Gold_Diamond_Agents_as_yes()
			throws Exception {
		wait(1);
		scrollToElement(userLookup.txtRolesAbleApproveCapacit);
		wait(1);
		userLookup.boxUserRoleAttr186.click();
		wait(2);
		attachScreenShot(driver);
	} 
	@When("User clicks return button and validates User Maintenance screen displays")
	public void User_clicks_return_button_and_validates_User_Maintenance_screen_displays() throws Exception {
		click(userLookup.btnReturn);
		waitImp(10);
		attachScreenShot(driver);
		waitImp(10);
	}
	
	
	
	
	
	
	
	
	
}
