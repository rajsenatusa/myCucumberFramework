package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO4policy extends CommonMethods {

	@When("User enters HO4 product selection information and effective date")
	public void user_enters_ho4_product_selection_information_and_effective_date() {
		//product selection information was filled here
		
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionHo4); 
		
		
	}
	@When("User enters all required information on HO4 quote screen")
	public void user_enters_all_required_information_on_ho4_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
				sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
				selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
				selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytypeho4"));
				selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
				wait(1);
				click(policyChevron.btnNext);
	}
	@When("User enters all required information on HO4 dwelling screen")
	public void user_enters_all_required_information_on_ho4_dwelling_screen() {
		
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		sendText(dwellingChevron.txtCoverageC, ConfigsReader.getProperty("coveragec"));
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		
	}
	
	@When("User enters all required information on HO4 review screen")
	public void user_enters_all_required_information_on_ho4_review_screen() {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);	
	}

	
	@When("User creates HO4 application")
	public void user_creates_ho4_application() {

		click(reviewChevron.btnCreateApplication);
		wait(2);
		click(dwellingChevron.btnNext);
		
		
	}
	
	@When("User answers all underwriting questions for HO4")
	public void user_answers_all_underwriting_questions_for_ho4() throws Exception {
		
		fillHO4_UWQuestions();
		wait(2);
		click(dwellingChevron.btnNext);
		
		//Application Dwelling information was filled here
		
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		selectDropdownText(dwellingChevron.ddNumberOfStories, ConfigsReader.getProperty("numberofstories"));
		selectDropdownText(dwellingChevron.ddStoryOfUnit, ConfigsReader.getProperty("storyofunit"));
		wait(2);	

	}
	@Then("User validates that HO4 policy has been created successfully")
	public void user_validates_that_ho4_policy_has_been_created_successfully() {
	WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO4 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}

	}
	@And("User clicks VOL HO4 policy")
	public void User_clicks_VOL_HO4_policy() {

		click(product.btnProductSelectionHo4); 
	}
	@And("User selects Mobile Home")
	public void User_selects_Mobile_Home() {
		selectDropdownText(policyChevron.ddMobileHome, "No");
		wait(1);
	}
	
	@And("User enters Personal Property")
	public void User_enters_Personal_Property() {
		sendText(dwellingChevron.txtCoverageC, ConfigsReader.getProperty("coveragec"));
		wait(1);
	}
	@And("User enters Pay Plan Type for HO4")
	public void User_enters_Pay_Plan_Type_for_HO4() {
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");			 
		reviewChevron.btnFullPaymentRadio.click();
		reviewChevron.btnCreateApplication.click();
		click(dwellingChevron.btnNext);
	}
	
	
	
	
}
