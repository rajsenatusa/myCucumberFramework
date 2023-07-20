//updated on 07/14/2023 by Can Yavas

package aii.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLMHO3policy extends CommonMethods {
	
	@When("User enters MHO3 product selection information and effective date")
	public void user_enters_mho3_product_selection_information_and_effective_date() {
		//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionMho3);
				
	}
	@When("User enters all required information on MHO3 quote screen")
	public void user_enters_all_required_information_on_mho3_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarriermho3"));
				sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
				click(policyChevron.btnPropertyTypePri);
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
				selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupiedmho3"));
				wait(1);
				click(policyChevron.btnNext);
				wait(3);
	}
	@When("User enters all required information on MHO3 dwelling screen")
	public void user_enters_all_required_information_on_mho3_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, ConfigsReader.getProperty("coveragea"));
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		
	}
	@When("User enters all required information on MHO3 review screen")
	public void user_enters_all_required_information_on_mho3_review_screen() {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(3);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
	}
	@When("User creates MHO3 application")
	public void user_creates_mho3_application() {
		
				click(reviewChevron.btnCreateApplication);
				wait(4);
				click(dwellingChevron.btnNext);
			
	}
	@When("User answers all underwriting questions for MHO3")
	public void user_answers_all_underwriting_questions_for_mho3() throws Exception {
		//Application Underwriting Questions Chevron was filled here

		fillMHO_UWQuestions();
		
		//Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddBuildingLength, ConfigsReader.getProperty("buildinglength"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarialmho3"));
		selectDropdownText(dwellingChevron.ddBuildingMake, ConfigsReader.getProperty("buildingmake"));
		selectDropdownText(dwellingChevron.ddBuildingWidth, ConfigsReader.getProperty("buildingwidth"));
		selectDropdownText(dwellingChevron.ddBuildingSkirtedRails, "Yes");
		sendText(dwellingChevron.txtBuildingSerialNumber, ConfigsReader.getProperty("buildingserialnumber"));
	}
	@Then("User validates that MHO3 policy has been created successfully")
	public void user_validates_that_mho3_policy_has_been_created_successfully() {
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, MHO3 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}
	}
	@And("User clicks VOL MHO3 policy")
	public void User_clicks_VOL_MHO3_policy() {
		click(product.btnProductSelectionMho3);
	}
	@And("User clicks Property Type as Private Property")
	public void User_clicks_Property_Type_as_Private_Property () {
		click(policyChevron.btnPropertyTypePri);
	}
	@And("User enters MHO3 Pay Plan Type")
	public void User_enters_MHO3_Pay_Plan_Type () {
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(dwellingChevron.btnNext);
	}
	@And("User verifies NB MHO3 policy has been created successfully")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully() {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}
	@And("User clicks MHO3 Prior Carrier")
	public void User_clicks_MHO3_Prior_Carrier() {
		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
 		click(dwellingChevron.btnSave);
		wait(1);
	}	  
	
}

