package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLAIB_NBpolicy extends CommonMethods {

	
	@When("I enter AIB product selection information and effective date")
	public void i_enter_aib_product_selection_information_and_effective_date() {
		
		//product selection information was filled here
		sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionAib);
		
	}
	
	@When("I enter all required information on AIB quote screen")
	public void i_enter_all_required_information_on_aib_quote_screen() {
	   
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("priorcarrieraib"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		click(dwellingChevron.btnSave);
		wait(5);
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

	@When("I select liability coverage on quote screen")
	public void i_select_liability_coverage_on_quote_screen() {
	  
		selectDropdownText(golfcartChevron.ddLiabilityCovType, ConfigsReader.getProperty("boatingliability"));
		wait(6);
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryboat"));
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
		
	}
	@When("I added operator information on quote screen")
	public void i_added_operator_information_on_quote_screen() {
	    click(aibChevron.btnAddOperator);
	    wait(3);
	    selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
	    selectDropdownText(golfcartChevron.ddDriverLicenseInd, "Yes");
		selectDropdownText(aibChevron.ddLicenseState, ConfigsReader.getProperty("licensestate"));
		sendText(aibChevron.txtLicenseNumber, ConfigsReader.getProperty("licensenumber"));
		selectDropdownText(aibChevron.ddBoatExperience, ConfigsReader.getProperty("boatexperience"));
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		wait(3);
	    click(golfcartChevron.btnNextGocScreen);
		
		
	}
	@When("I enter all required information on AIB boat dwelling screen")
	public void i_enter_all_required_information_on_aib_boat_dwelling_screen() {
	    
		click(aibChevron.btnAddBoat);
	    wait(3);
	    sendText(aibChevron.txtBoatYear, ConfigsReader.getProperty("boatyear"));
	    sendText(aibChevron.txtBoatHinNumber, ConfigsReader.getProperty("boathinnumber"));
	    selectDropdownText(aibChevron.ddBoatMake, ConfigsReader.getProperty("boatmake"));
	    sendText(aibChevron.txtBoatModel, ConfigsReader.getProperty("boatmodel"));
	    sendText(aibChevron.txtBoatPurchDate, ConfigsReader.getProperty("boatpurchasedate"));
		selectDropdownText(aibChevron.ddBoatFinanced, ConfigsReader.getProperty("boatfinanced"));
		wait(3);
		sendText(aibChevron.txtBoatPurchPrice, ConfigsReader.getProperty("boatpurchaseprice"));
		selectDropdownText(aibChevron.ddBoatHullType, ConfigsReader.getProperty("boathulltype"));
		selectDropdownText(aibChevron.ddBoatHullMat, ConfigsReader.getProperty("boathullmat"));
		selectDropdownText(aibChevron.ddHullLength, ConfigsReader.getProperty("hulllength"));
		wait(3);
		selectDropdownText(aibChevron.ddBoatDriveSystem, ConfigsReader.getProperty("boatdrivesystem"));
		selectDropdownText(aibChevron.ddBoatMaxSpeed, ConfigsReader.getProperty("boatmaxspeed"));
		selectDropdownText(aibChevron.ddBoatHullSettle, ConfigsReader.getProperty("boathullsettle"));
		selectDropdownText(aibChevron.ddNumberOfEngines, ConfigsReader.getProperty("numberofengines"));
		wait(2);
		selectDropdownText(aibChevron.ddBoatHp, ConfigsReader.getProperty("boathp"));
		sendText(aibChevron.txtBoatEngine1Year, ConfigsReader.getProperty("boatengine1year"));
		sendText(aibChevron.txtBoatEngineMake, ConfigsReader.getProperty("boatenginemake"));
		sendText(aibChevron.txtBoatEngine1Hp, ConfigsReader.getProperty("boatengine1hp"));
		selectDropdownText(aibChevron.ddTrailerCoverage, ConfigsReader.getProperty("trailercoverage"));
		selectDropdownText(aibChevron.ddBoatStorageType, ConfigsReader.getProperty("boatstoragetype"));
		
		selectDropdownText(aibChevron.ddBoatExistingDamage, "No");
		wait(3);
		click(dwellingChevron.btnNext);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
		
	}
	@When("I enter all required information on AIB review screen")
	public void i_enter_all_required_information_on_aib_review_screen() {
	    
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(4);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(3);
		click(reviewChevron.btnCreateApplication);
		wait(4);
		
	}
	@When("I create AIB application")
	public void i_create_aib_application() {
	    
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
		
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
		click(dwellingChevron.btnNext);
		
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
		
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
	
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
