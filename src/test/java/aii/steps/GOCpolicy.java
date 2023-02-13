package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GOCpolicy extends CommonMethods {
	
	@When("I enter GOC product selection information and effective date")
	public void i_enter_goc_product_selection_information_and_effective_date() {
		
		//product selection information was filled here
				sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.stateDropdown, 1);
				selectDropdown(product.carrierDropdown, 1);
				wait(2);
				click(product.continueButton);
				click(product.productSelectionGoc);
	}
	@When("I enter all required information on GOC quote screen")
	public void i_enter_all_required_information_on_goc_quote_screen() {
		//Quote Policy Chevron information was filled here
		
				selectDropdownText(policyChevron.coverage6MonthsInd, "Yes");
				selectDropdownText(policyChevron.garaged6MonthsInd, "Yes");
				selectDropdown(policyChevron.insuranceScoreDd,3);
				sendText(policyChevron.phoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.phoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.noEmailRadio);
				selectDropdownText(policyChevron.insuredReside, "No");
				wait(1);
				click(policyChevron.nextButton);
				wait(3);
				
	}
	@When("I enter all required information on GOC golfcart screen")
	public void i_enter_all_required_information_on_goc_golfcart_screen() {
		
		selectDropdownText(golfcartChevron.liabilityCovType, ConfigsReader.getProperty("liabilitycoveragetypegoc"));
		wait(6);
		selectDropdownText(golfcartChevron.bodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryperson"));
		selectDropdownText(golfcartChevron.propertyDamageLimit, ConfigsReader.getProperty("propertydamagelimit"));
		wait(5);
		selectDropdownText(golfcartChevron.medicalPaymentLimit, ConfigsReader.getProperty("medicalpaymentlimit"));
		selectDropdownText(golfcartChevron.uninsuredInjury, ConfigsReader.getProperty("uninsuredinjury"));
		wait(2);
		click(dwellingChevron.saveButton);
		click(dwellingChevron.nextButton);
		
	}
	

	@When("I enter driver information on driver screen")
	public void i_enter_driver_information_on_driver_screen() {
	    
		click(golfcartChevron.addDriver);
	    selectDropdownText(golfcartChevron.driverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
	    selectDropdownText(golfcartChevron.driverLicenseInd, "No");
	    selectDropdownText(golfcartChevron.driverGcExp, ConfigsReader.getProperty("driverexperience"));
	    selectDropdownText(golfcartChevron.driverTrainingInd, "No");
	    wait(3);
	    click(golfcartChevron.nextGocScreen);

	}
	@When("I enter vehicles information on vehicles screen")
	public void i_enter_vehicles_information_on_vehicles_screen() {
	   
		click(golfcartChevron.addGolfcart);
	   	wait(2);
		sendText(golfcartChevron.modelYear, ConfigsReader.getProperty("golfcartmodelyear"));
		sendText(golfcartChevron.gcVinNumber, ConfigsReader.getProperty("gcvinnumber"));
		sendText(golfcartChevron.gcMake, ConfigsReader.getProperty("gcmake"));
		sendText(golfcartChevron.gcModel, ConfigsReader.getProperty("gcmodel"));
		selectDropdownText(golfcartChevron.gcPowerType, ConfigsReader.getProperty("gcpowertype"));
		wait(2);
		selectDropdownText(golfcartChevron.gcMaxSpeed, ConfigsReader.getProperty("gcmaxspeed"));
		selectDropdownText(golfcartChevron.vehicleSeatbelts, "Yes");
		sendText(golfcartChevron.gcMarketValue, ConfigsReader.getProperty("gcmarketvalue"));
		selectDropdownText(golfcartChevron.otherCollisionDed, ConfigsReader.getProperty("othercollisiondeductible"));
		selectDropdownText(golfcartChevron.collisionDed, ConfigsReader.getProperty("collisiondeductible"));
		wait(2);
		selectDropdownText(golfcartChevron.gcExistingDamage, "No");
		click(dwellingChevron.saveButton);
		wait(2);
		click(reviewChevron.reviewButton);
		wait(3);
	}

	
	@When("I enter all required information on GOC review screen")
	public void i_enter_all_required_information_on_goc_review_screen() {
		
		selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.fullPaymentRadioButton);
		wait(3);
		selectDropdownText(reviewChevron.orderInsScore, "No");
		wait(3);
		click(reviewChevron.createApplication);
		wait(4);
		
		
		
	}
	@When("I create GOC application")
	public void i_create_goc_application() {
	    
		click(policyChevron.policyChevronLink);
		wait(2);
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
		click(dwellingChevron.nextButton);
		
		//Application Underwriting Questions Chevron was filled here
		
		selectDropdownText(uwquestionsChevron.gocQuestion1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion5, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion9, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion10, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion11, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion12, "No");

		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		
		//Application Dwelling information was filled here
		
		click(dwellingChevron.saveButton);
		click(reviewChevron.reviewButton);
		wait(2);
		click(reviewChevron.finalizeButton);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		selectDropdownText(closeoutChevron.paymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.issueNBButton);
		
		
		
		
	}
	@Then("I validate the GOC policy has been created successfully")
	public void i_validate_the_goc_policy_has_been_created_successfully() {
		
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, GolfCart NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
	}


	}
}
