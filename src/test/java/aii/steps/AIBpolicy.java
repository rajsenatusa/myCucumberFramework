package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AIBpolicy extends CommonMethods {

	
	@When("I enter AIB product selection information and effective date")
	public void i_enter_aib_product_selection_information_and_effective_date() {
		
		//product selection information was filled here
		sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.stateDropdown, 1);
		selectDropdown(product.carrierDropdown, 1);
		wait(2);
		click(product.continueButton);
		click(product.productSelectionAib);
		
	}
	
	@When("I enter all required information on AIB quote screen")
	public void i_enter_all_required_information_on_aib_quote_screen() {
	   
		selectDropdownText(policyChevron.previousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.previousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		sendText(policyChevron.producerCodeSel, ConfigsReader.getProperty("producerselection"));
		click(dwellingChevron.saveButton);
		wait(5);
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

	@When("I select liability coverage on quote screen")
	public void i_select_liability_coverage_on_quote_screen() {
	  
		selectDropdownText(golfcartChevron.liabilityCovType, ConfigsReader.getProperty("boatingliability"));
		wait(6);
		selectDropdownText(golfcartChevron.bodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryboat"));
		wait(3);
		click(dwellingChevron.saveButton);
		wait(4);
		click(dwellingChevron.saveButton);
		wait(3);
		click(dwellingChevron.nextButton);
		
	}
	@When("I added operator information on quote screen")
	public void i_added_operator_information_on_quote_screen() {
	    click(aibChevron.addOperator);
	    wait(3);
	    selectDropdownText(golfcartChevron.driverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
	    selectDropdownText(golfcartChevron.driverLicenseInd, "Yes");
		selectDropdownText(aibChevron.licenseState, ConfigsReader.getProperty("licensestate"));
		sendText(aibChevron.licenseNumber, ConfigsReader.getProperty("licensenumber"));
		selectDropdownText(aibChevron.boatExperience, ConfigsReader.getProperty("boatexperience"));
		selectDropdownText(golfcartChevron.driverTrainingInd, "No");
		wait(3);
	    click(golfcartChevron.nextGocScreen);
		
		
	}
	@When("I enter all required information on AIB boat dwelling screen")
	public void i_enter_all_required_information_on_aib_boat_dwelling_screen() {
	    
		click(aibChevron.addBoat);
	    wait(3);
	    sendText(aibChevron.boatYear, ConfigsReader.getProperty("boatyear"));
	    sendText(aibChevron.boatHinNumber, ConfigsReader.getProperty("boathinnumber"));
	    selectDropdownText(aibChevron.boatMake, ConfigsReader.getProperty("boatmake"));
	    sendText(aibChevron.boatModel, ConfigsReader.getProperty("boatmodel"));
	    sendText(aibChevron.boatPurchDate, ConfigsReader.getProperty("boatpurchasedate"));
		selectDropdownText(aibChevron.boatFinanced, ConfigsReader.getProperty("boatfinanced"));
		wait(3);
		sendText(aibChevron.boatPurchPrice, ConfigsReader.getProperty("boatpurchaseprice"));
		selectDropdownText(aibChevron.boatHullType, ConfigsReader.getProperty("boathulltype"));
		selectDropdownText(aibChevron.boatHullMat, ConfigsReader.getProperty("boathullmat"));
		selectDropdownText(aibChevron.hullLength, ConfigsReader.getProperty("hulllength"));
		wait(3);
		selectDropdownText(aibChevron.boatDriveSystem, ConfigsReader.getProperty("boatdrivesystem"));
		selectDropdownText(aibChevron.boatMaxSpeed, ConfigsReader.getProperty("boatmaxspeed"));
		selectDropdownText(aibChevron.boatHullSettle, ConfigsReader.getProperty("boathullsettle"));
		selectDropdownText(aibChevron.numberOfEngines, ConfigsReader.getProperty("numberofengines"));
		wait(2);
		selectDropdownText(aibChevron.boatHp, ConfigsReader.getProperty("boathp"));
		sendText(aibChevron.boatEngine1Year, ConfigsReader.getProperty("boatengine1year"));
		sendText(aibChevron.boatEngineMake, ConfigsReader.getProperty("boatenginemake"));
		sendText(aibChevron.boatEngine1Hp, ConfigsReader.getProperty("boatengine1hp"));
		selectDropdownText(aibChevron.trailerCoverage, ConfigsReader.getProperty("trailercoverage"));
		selectDropdownText(aibChevron.boatStorageType, ConfigsReader.getProperty("boatstoragetype"));
		
		selectDropdownText(aibChevron.boatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.nextButton);
		wait(3);
		click(reviewChevron.reviewButton);
		wait(3);
		
	}
	@When("I enter all required information on AIB review screen")
	public void i_enter_all_required_information_on_aib_review_screen() {
	    
		selectDropdownText(reviewChevron.payPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.fullPaymentRadioButton);
		wait(3);
		selectDropdownText(reviewChevron.orderInsScore, "No");
		wait(3);
		click(reviewChevron.createApplication);
		wait(4);
		
	}
	@When("I create AIB application")
	public void i_create_aib_application() {
	    
		click(policyChevron.policyChevronLink);
		wait(2);
		
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
		click(dwellingChevron.nextButton);
		
		//Application Underwriting Questions Chevron was filled here
		
		selectDropdownText(uwquestionsChevron.aibQuestion1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion5, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion7, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion10, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion11, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion12, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion13, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion14, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion15, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion16, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion17, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion18, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion19, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion20, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion21, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion22, "No");


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
	

	@Then("I validate the AIB policy has been created successfully")
	public void i_validate_the_aib_policy_has_been_created_successfully() {
	   
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, AIB NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
		}
	}



}
