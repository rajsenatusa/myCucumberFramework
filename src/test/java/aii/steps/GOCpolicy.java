package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GOCpolicy extends CommonMethods {
	
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
	@And("User clicks GOC policy")
	public void User_clicks_GOC_policy() {
		click(product.btnProductSelectionGoc);	
	}
	@And("User selects Have you had 6 months of continuous Golf Cart Insurance Coverage")
	public void User_selects_Have_you_had_6_months_of_continuous_Golf_Cart_Insurance_Coverage () {
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
	}
	@And("User selects Are all golf carts garaged in Florida at least 6 months of the year")
	public void User_selects_Are_all_golf_carts_garaged_in_Florida_at_least_6_months_of_the_year () {
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
	}
	@And("User selects Insurance Scor")
	public void User_selects_Insurance_Scor() {
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
	}
	@And("User selects Liability Coverage Type")
	public void User_selects_Liability_Coverage_Type() {
		selectDropdownText(golfcartChevron.ddLiabilityCovType, ConfigsReader.getProperty("liabilitycoveragetypegoc"));
		wait(1);
	}
	@And("User selects Bodily Injury Per Person Per Accident")
	public void User_selects_Bodily_Injury_Per_Person_Per_Accident() {
		selectDropdownText(golfcartChevron.ddBodilyInjuryPerson, ConfigsReader.getProperty("bodilyinjuryperson"));
		wait(1);
	}
	@And("User selects Property Damage")
	public void User_selects_Property_Damage() {
		selectDropdownText(golfcartChevron.ddPropertyDamageLimit, ConfigsReader.getProperty("propertydamagelimit"));
		wait(1);
	}
	@And("User selects Medical Payments")
	public void User_selects_Medical_Payments() {
		selectDropdownText(golfcartChevron.ddMedicalPaymentLimit, ConfigsReader.getProperty("medicalpaymentlimit"));
		wait(1);
	}
	@And("User clicks Add Driver")
	public void User_clicks_Add_Driver() {
		click(golfcartChevron.btnAddDriver);
	}
	@And("User selects Marital Status")
	public void User_selects_Marital_Status() {
		selectDropdownText(golfcartChevron.ddDriverMaritalStatus, ConfigsReader.getProperty("drivermaritalstatus"));
		wait(1);
	}
	@And("User selects Does the Driver currently have a driver license")
	public void User_selects_Does_the_Driver_currently_have_a_driver_license() {
		selectDropdownText(golfcartChevron.ddDriverLicenseInd, "No");
		}
	@And("User selects How many years of Golf Cart Experience")
	public void User_selects_How_many_years_of_Golf_Cart_Experience() {
		selectDropdownText(golfcartChevron.ddDriverGcExp, ConfigsReader.getProperty("driverexperience"));
		}
	@And("User selects Golf Cart Safety Course")
	public void User_selects_Golf_Cart_Safety_Course() {
		selectDropdownText(golfcartChevron.ddDriverTrainingInd, "No");
		}
	@And("User clicks Add Golf Cart")
	public void User_clicks_Add_Golf_Cart() {
		click(golfcartChevron.btnAddGolfcart);
	   	wait(1);
		}
	@And("User enters Golf Cart Model Year")
	public void User_enters_Golf_Cart_Model_Year() {
		sendText(golfcartChevron.txtModelYear, ConfigsReader.getProperty("golfcartmodelyear"));
		}
	@And("User enters Golf Cart VIN Serial Number")
	public void User_enters_Golf_Cart_VIN_Serial_Number() {
		sendText(golfcartChevron.txtGcVinNumber, ConfigsReader.getProperty("gcvinnumber"));
		}
	@And("User enters Golf Cart Make")
	public void User_enters_Golf_Cart_Make() {
		sendText(golfcartChevron.txtGcMake, ConfigsReader.getProperty("gcmake"));
		}
	@And("User enters Golf Cart Model")
	public void User_enters_Golf_Cart_Model() {
		sendText(golfcartChevron.txtGcModel, ConfigsReader.getProperty("gcmodel"));
		}
	@And("User selects Golf Cart Power Type")
	public void User_selects_Golf_Cart_Power_Type() {
		selectDropdownText(golfcartChevron.ddGcPowerType, ConfigsReader.getProperty("gcpowertype"));
		wait(1);
		}
	@And("User selects Maximum Speed")
	public void User_selects_Maximum_Speed() {
		selectDropdownText(golfcartChevron.ddGcMaxSpeed, ConfigsReader.getProperty("gcmaxspeed"));
		}
	@And("User selects Seatbelts")
	public void User_selects_Seatbelts() {
		selectDropdownText(golfcartChevron.ddVehicleSeatbelts, "Yes");
		}
	@And("User enters Current Market Value")
	public void User_enters_Current_Market_Value() {
		sendText(golfcartChevron.txtGcMarketValue, ConfigsReader.getProperty("gcmarketvalue"));
		}
	@And("User selects Other Than Collision Deductible")
	public void User_selects_Other_Than_Collision_Deductible() {
		selectDropdownText(golfcartChevron.ddOtherCollisionDed, ConfigsReader.getProperty("othercollisiondeductible"));
		}
	@And("User selects Collision Deductible")
	public void User_selects_Collision_Deductible() {
		selectDropdownText(golfcartChevron.ddCollisionDed, ConfigsReader.getProperty("collisiondeductible"));
		wait(1);
		}
	@And("User selects Does golf cart have any existing damage")
	public void User_selects_Does_golf_cart_have_any_existing_damage() {
		selectDropdownText(golfcartChevron.ddGcExistingDamage, "No");
		}
	@And("User enters GOC Pay Plan Type")
	public void User_enters_GOC_Pay_Plan_Type() {
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");			 
		reviewChevron.btnFullPaymentRadio.click();
		selectDropdownText(reviewChevron.ddOrderInsScore, "No");
		wait(1);
		click(reviewChevron.btnCreateApplication);
		wait(1);
		click(policyChevron.btnPolicyChevronLink);
		wait(2);		
		click(dwellingChevron.btnNext);
		}
	
	
	
	
	
	
	
}
