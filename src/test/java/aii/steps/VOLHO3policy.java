package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO3policy extends CommonMethods {

	@When("User enters HO3 product selection information and effective date")
	public void user_enters_ho3_product_selection_information_and_effective_date() {
		//product selection information was filled here
		sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3); 
		}
		
	@When("User enters all required information on HO3 quote screen")
	public void user_enters_all_required_information_on_ho3_quote_screen() {
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
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}
		
	@When("User enters all required information on HO3 dwelling screen")
	public void user_enters_all_required_information_on_ho3_dwelling_screen() {
		//Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbit,ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	
	@When("User enters all required information on HO3 review screen")
	public void user_enters_all_required_information_on_ho3_review_screen() {
		//Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
	}
	
	@When("User creates HO3 application")
	public void user_creates_ho3_application() {
		
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(3);
		click(dwellingChevron.btnNext);
	
	}
	
	@When("User answers all underwriting questions for HO3")
	public void user_answers_all_underwriting_questions_for_ho3() throws Exception {
		fillHO3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		//Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
		
	}
	@Then("User validates that HO3 policy has been created successfully")
	public void user_validates_that_ho3_policy_has_been_created_successfully() {
	
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO3 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
		}
		
		
	}



}
