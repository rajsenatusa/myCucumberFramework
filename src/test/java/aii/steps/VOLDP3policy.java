//updated on 07/14/2023 by Can Yavas
package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLDP3policy extends CommonMethods {

	@When("User enters DP3 product selection information and effective date")
	public void user_enters_dp3_product_selection_information_and_effective_date() {
		//product selection information was filled here
		sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}
	@When("User enters all required information on DP3 quote screen")
	public void user_enters_all_required_information_on_dp3_quote_screen() {
		//Quote Policy Chevron information was filled here
		
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP3 dwelling screen")
	public void user_enters_all_required_information_on_dp3_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbitDp1,ConfigsReader.getProperty("mediation"));
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		
	}
	
	
	@When("User enters all required information on DP3 review screen")
	public void user_enters_all_required_information_on_dp3_review_screen() {
		
		click(dwellingChevron.btnNext);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(3);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
		
	}
	@When("User creates DP3 application")
	public void user_creates_dp3_application() {
		
		click(reviewChevron.btnCreateApplication);
		wait(4);
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
		click(dwellingChevron.btnNext);
		
	}
	
	@When("User answers all underwriting questions for DP3")
	public void user_answers_all_underwriting_questions_for_dp3() throws Exception {
		//Application Underwriting Questions Chevron was filled here
		fillDP3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		
		
	}
	@Then("User validates that DP3 policy has been created successfully")
	public void user_validates_that_dp3_policy_has_been_created_successfully() throws Exception {
			
		
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);
			
		}
		else {
			System.out.println("Test failed!");
					
	}

	}
	
	
	@Given("I select Tenent occupied and navigate to dwelling page")
	public void i_select_tenent_occupied_and_navigate_to_dwelling_page() {
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		wait(1);
		Hooks.scenario.log("Tenant occupied is selected");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		click(dwellingChevron.btnNext);
	    
	}
	
	@Given("I select Owner occupied and navigate to dwelling page")
	public void i_select_owner_occupied_and_navigate_to_dwelling_page() {
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		wait(1);
		Hooks.scenario.log("Owner occupied is selected");
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		click(dwellingChevron.btnNext);
	}

}
