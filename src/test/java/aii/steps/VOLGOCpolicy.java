package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLGOCpolicy extends CommonMethods {
	
	@When("User enters GOC product selection information and effective date")
	public void user_enters_goc_product_selection_information_and_effective_date() {
		
		//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionGoc);
	}
	@When("User enters all required information on GOC quote screen")
	public void user_enters_all_required_information_on_goc_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
				selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
				selectDropdown(policyChevron.ddInsuranceScoreDd,3);
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				selectDropdownText(policyChevron.ddInsuredReside, "No");
				wait(1);
				click(policyChevron.btnNext);
				wait(3);
				
	}
	@When("User enters all required information on GOC golfcart screen")
	public void user_enters_all_required_information_on_goc_golfcart_screen() {
		
		selectDropdownText(golfcartChevron.ddLiabilityCovType, ConfigsReader.getProperty("liabilitycoveragetypegoc"));
		wait(6);
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryperson"));
		wait(5);
		selectDropdownText(golfcartChevron.ddPropertyDamageLimit, ConfigsReader.getProperty("propertydamagelimit"));
		wait(3);
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, ConfigsReader.getProperty("medicalpaymentlimit"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		
	}
	

	@When("User enters driver information on driver screen")
	public void user_enters_driver_information_on_driver_screen() {
	    
		click(golfcartChevron.btnAddDriver);
	    selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
	    selectDropdownText(golfcartChevron.ddDriverLicenseInd, "No");
	    selectDropdownText(golfcartChevron.ddDriverGcExp, ConfigsReader.getProperty("driverexperience"));
	    selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
	    wait(3);
	    click(golfcartChevron.btnNextGocScreen);

	}
	@When("User enters vehicles information on vehicles screen")
	public void user_enters_vehicles_information_on_vehicles_screen() {
	   
		click(golfcartChevron.btnAddGolfcart);
	   	wait(2);
		sendText(golfcartChevron.txtModelYear, ConfigsReader.getProperty("golfcartmodelyear"));
		sendText(golfcartChevron.txtGcVinNumber, ConfigsReader.getProperty("gcvinnumber"));
		sendText(golfcartChevron.txtGcMake, ConfigsReader.getProperty("gcmake"));
		sendText(golfcartChevron.txtGcModel, ConfigsReader.getProperty("gcmodel"));
		selectDropdownText(golfcartChevron.ddGcPowerType, ConfigsReader.getProperty("gcpowertype"));
		wait(2);
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, ConfigsReader.getProperty("gcmaxspeed"));
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		sendText(golfcartChevron.txtGcMarketValue, ConfigsReader.getProperty("gcmarketvalue"));
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, ConfigsReader.getProperty("othercollisiondeductible"));
		selectDropdownText(golfcartChevron.ddCollisionDed, ConfigsReader.getProperty("collisiondeductible"));
		wait(2);
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		click(dwellingChevron.btnSave);
		wait(2);
		click(reviewChevron.btnReview);
		wait(3);
	}

	
	@When("User enters all required information on GOC review screen")
	public void user_enters_all_required_information_on_goc_review_screen() {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		
	}
	@When("User creates GOC application")
	public void user_creates_goc_application() {
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(3);
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);		
		click(dwellingChevron.btnNext);
	}
	
	@When("User answers all underwriting questions for GOC")
	public void user_answers_all_underwriting_questions_for_goc() throws Exception {
		fillGOC_UWQuestions();
		
		
	}
	@Then("User validates that GOC policy has been created successfully")
	public void user_validates_that_goc_policy_has_been_created_successfully() {
		
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, GolfCart NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}


	}
}
