package aii.steps;
import java.text.SimpleDateFormat;
//import java.sql.Time;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Date;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import org.junit.Assert;
//import Member.Pages.ActionsTile.ActionTile;
//import Member.Pages.Login.LoginPage;
//import Member.Pages.ProductSelection.ProductSelectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class HO3RateChange extends CommonMethods {
	
	
	@Given("User navigates to QA7")
	public void User_navigates_to_QA7() {		
		//	setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}		
	@When("User enters a valid username")
	public void User_enters_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}
	@And("User enters a valid password")
	public void User_enters_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}
	@And("User enters a valid user name {string}")
	public void User_enters_a_valid_user_name(String username) {
		sendText(login.username, username);			
	}
	@And("User enters a valid password {string}")
	public void User_enters_a_valid_user_password(String password) {
		sendText(login.password, password);		
	}
	@And("User clicks on the login button")
	public void User_clicks_on_the_login_button() {
		click(login.btnSignIn);
		wait(1);	
	}
	@And("User hovers over quote and policy")
	public void User_hovers_over_quote_and_policy() {	     
		wait(1);
		Actions action = new Actions(driver);	
		action.moveToElement(quote.quoteAndPolicy).perform();	
		wait(1);
	}
	@And("User clicks new custemer and quote")
	public void User_clicks_new_custemer_and_quote() {	     
		dashboard.btnNewQuote.click();		
	}
	@And("User clicks Entity Type")
	public void User_clicks_Entity_Type() {	     		
		selectDropdownText(dashboard.customerEntityType, "Individual");
		wait(1);
	}
	@And("User enters Customer Informations")
	public void User_enters_Customer_Informations() {	     		
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);	
		wait(1);
	}
	@And("User enters Dwelling Address")
	public void User_enters_Dwelling_Address() {	     
		sendText(quote.txtAddress, ConfigsReader.getProperty("address"));
		sendText(quote.txtZipCode, ConfigsReader.getProperty("zipcode"));
		wait(2);
		click(quote.btnVerifyAddress);
		wait(1);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(1);
	}
	@And("User enters New Product Version effective date {string}")
	public void User_enters_New_Product_Version_effective_date(String NewProductVersionEffectiveDate) {
		sendText(product.txtEffectiveDate, NewProductVersionEffectiveDate);
	}
	@And("User enters state")
	public void I_enters_state() {	    	   	
		selectDropdownText(product.ddStateSelection, "Florida");
		wait(1);	
		click(product.btnContinue);	
	}
	@And("User clicks VOL HO3 policy")
	public void User_clicks_VOL_HO3_policy() {	    	   				
		click(product.btnProductSelectionHo3);		
	}
	@And("User enters Producer Code")
	public void User_enters_Producer_Code() {	    	   				
		policyChevron.txtProducerCodeSel.sendKeys(ConfigsReader.getProperty("ProducerCode"));
		click(dwellingChevron.btnSave);	
		wait(1);
 	}
 	@And("User clicks Prior Carrier")
 	public void User_clicks_Prior_Carrier() {	    	   				
 		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
 		click(dwellingChevron.btnSave);
		wait(1);
	}
	@And("User enters Prior Policy Expiration Date")
	public void User_enters_Prior_Policy_Expiration_Date() {	    	   				
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy"); 		
		policyChevron.txtPreviousPolicyExpDate.sendKeys(dt.format(new Date()));
		wait(1);
	}
	@And("User enters Insurance Score")
	public void User_enters_Insurance_Score() {	    	   				
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Average (700-749)");
		wait(1);
	}
	@And("User enters Primary Phone")
	public void User_enters_Primary_Phone() {	 
		policyChevron.txtPhoneNumber.sendKeys(ConfigsReader.getProperty("phoneNumber")); 
		selectDropdownText(policyChevron.ddPhoneNumberType,"Mobile");			
	}
	@And("User enters Email")
	public void User_enters_Email() {	    	   				
		policyChevron.emailAddr.sendKeys(ConfigsReader.getProperty("EmailAddr")); 			
		wait(1);
	}	
	@And("User enters Construction Type {string}")
	public void User_enters_Construction_Type(String ConstructionType) {
		selectDropdownText(policyChevron.ddConstructionType, ConstructionType);		
	}					 	
	@And("User enters Occupancy {string}")
	public void User_enters_Occupancy(String Occupancy) {
		selectDropdownText(policyChevron.ddOccupancy, Occupancy);									
	}					
	@And("User enters Months Occupied {string}")
	public void User_enters_Months_Occupied(String MonthsOccupied) {
		selectDropdownText(policyChevron.ddMonthsOccupied, MonthsOccupied);					 				
	}
	@And("User enters Has Insured resided at the risk address")
	public void User_enters_Has_Insured_resided_at_the_risk_address() {	    	   				
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}
	@And("User enters Year of Construction {string}")
	public void User_enters_Year_of_Construction(String YearOfConstruction) {	    	   						
		sendText(dwellingChevron.txtYearConstruction, YearOfConstruction);
	}		
	@And("User enters Square Feet {string}")
	public void User_enters_Square_Feet(String SquareFeet) {	    	   						
		sendText(dwellingChevron.txtSquareFeet, SquareFeet);					 
	}		
	@And("User enters Building Code Effectiveness Grade {string}")
	public void User_enters_Building_Code_Effectiveness_Grade(String BuildingCodeEffectivenessGrade) {	    	   						
		selectDropdownText(dwellingChevron.bCEG, BuildingCodeEffectivenessGrade);		
	}			
	@And("User enters Number of stories {string}")
	public void User_enters_Number_of_stories(String NumberOfStories) {	    	   						
		selectDropdownText(dwellingChevron.numberOfStories, NumberOfStories);		
	}		
	@And("User enters Roof Material {string}")
	public void User_enters_Roof_Material(String RoofMaterial) {	    	   						
		selectDropdownText(dwellingChevron.ddRoofMetarial, RoofMaterial);											
	}		
	@And("User enters Fireplace {string}")
	public void User_enters_Fireplace(String Fireplace) {	    	   						
		selectDropdownText(dwellingChevron.firePlace, Fireplace);		
	}		
	@And("User enters Exterior Walls {string}")
	public void User_enters_Exterior_Walls(String ExteriorWalls) {	    	   						
		selectDropdownText(dwellingChevron.exteriorWalls, ExteriorWalls);	
	}
	@And("User clicks Reserve Package")
	public void User_clicks_Reserve_Package() {					
		click(dwellingChevron.silverReserve);		
	}
	@And("User enters Coverage A Dwelling")
	public void User_enters_Coverage_A_Dwelling() {	    	   				
		dwellingChevron.txtCoverageA.sendKeys("300000"); 	
		wait(1);
	}
	@And("User enters Animal Liability {string}")
	public void User_enters_Animal_Liability(String AnimalLiability) {	    	   						
		selectDropdownText(dwellingChevron.animalLiability, AnimalLiability);	
	}	
	@And("User enters Mandatory Mediation Arbitration")
	public void User_enters_Mandatory_Mediation_Arbitration() {	    	   				
		selectDropdownText(dwellingChevron.ddMediationArbit, "No"); 
	}
	@And("User enters Fire Alarm {string}")
	public void User_enters_Fire_Alarm(String FireAlarm) {	    	   						
		selectDropdownText(dwellingChevron.fireAlarm, FireAlarm);		
	}	
	@And("User enters Sprinkler System {string}")
	public void User_enters_Sprinkler_System(String SprinklerSystem) {	    	   						
		selectDropdownText(dwellingChevron.sprinklerSystem, SprinklerSystem);				
		wait(1);		
	}	
	@And("User enters Burglar Alarm {string}")
	public void User_enters_Burglar_Alarm(String BurglarAlarm) {	    	   						
		selectDropdownText(dwellingChevron.burglarAlarm, BurglarAlarm);	
	}	
	@And("User enters Secured Community and Bldg {string}")
	public void User_enters_Secured_Community_and_Bldg(String SecuredCommunityBldg) {	    	   						
		selectDropdownText(dwellingChevron.securedCommunity, SecuredCommunityBldg);	
	}	
	@And("User enters Military Discount {string}")
	public void User_enters_Military_Discount(String MilitaryDiscount) {	    	   						
		selectDropdownText(dwellingChevron.militaryDiscount, MilitaryDiscount);			
		wait(1);
	}	
	@And("User enters Roof Shape {string}")
	public void User_enters_Roof_Shape(String RoofShape) {	    	   						
		selectDropdownText(dwellingChevron.roofShape, RoofShape);			
	}	
	@And("User enters SWR {string}")
	public void User_enters_SWR(String SWR) {	    	   						
		selectDropdownText(dwellingChevron.secondaryWaterResistance, SWR);			
		 wait(1);		
	}	
	@And("User clicks Flood Coverage {string}")
	public void User_clicks_Flood_Coverage(String FloodCoverage) {	    	   						
		selectDropdownText(dwellingChevron.floodCoverage, FloodCoverage);	
		 wait(5);
	}	
	@And("User clicks Flood Coverage Flood Dwelling {string}")
	public void User_clicks_Flood_Coverage_Flood_Dwelling(String FloodDwelling) {	    	   						
		sendText(dwellingChevron.floodDwelling, FloodDwelling);	
	
	}	
	@And("User clicks Flood Flood Personal Property {string}")
	public void User_clicks_Flood_Flood_Personal_Property(String FloodPersonalProperty) {	    	   						
		sendText(dwellingChevron.floodPersonalProperty, FloodPersonalProperty);	
				
	}	
	@And("User selects Flood Coverage Deductible {string}")
	public void User_selects_Flood_Coverage_Deductible(String FloodCoverageDeductible) {	    	   						
		selectDropdownText(dwellingChevron.floodCovADed, FloodCoverageDeductible);	
	}	
	@And("User selects Flood Foundation Type {string}")
	public void User_selects_Flood_Foundation_Type(String FloodFoundationType) {	    	   						
		selectDropdownText(dwellingChevron.floodFoundationType, FloodFoundationType);		
	}	
	@And("User selects Flood Zone Override {string}")
	public void User_selects_Flood_Zone_Override(String FloodZoneOverride) {	    	   						
		selectDropdownText(dwellingChevron.floodZoneOverride, FloodZoneOverride);			
	}	
	@And ("User enters Base Flood Elevation Override") 
	public void User_enters_Base_Flood_Elevation_Override() {	    	   				
		dwellingChevron.baseFloodElevationOverride.sendKeys("1000"); 	
		wait(1);
	}			
		@And("User selects Preferred Risk Status {string}")
	public void User_selects_Preferred_Risk_Status(String PreferredRiskStatus) {	    	   						
		selectDropdownText(dwellingChevron.floodPreferredStatus, PreferredRiskStatus);	
	}	
	@And("User selects SFHA Override {string}")
	public void User_selects_SFHA_Override(String SFHAOverride) {	    	   						
		selectDropdownText(dwellingChevron.floodSFHAOverride, SFHAOverride);		
	}	
	@And("User selects Elevated Risk Discount {string}")
	public void User_selects_Elevated_Risk_Discount(String ElevatedRiskDiscount) {	    	   						
		selectDropdownText(dwellingChevron.elevatedRiskDiscount, ElevatedRiskDiscount);						
	}	
	@And("User clicks save and next page button")
	public void User_clicks_save_and_next_page_button () {	    	   						
		dwellingChevron.btnSave.click();
		dwellingChevron.btnNext.click();
		wait(1);
	}	
	@And("User enters Pay Plan Type")
	public void User_enters_Pay_Plan_Type() {	    	   						
		wait(2); 
		selectDropdownText(reviewChevron.ddPayPlan, "Direct Bill");			 
		reviewChevron.btnFullPaymentRadio.click();
		reviewChevron.btnCreateApplication.click();
		reviewChevron.btnInsuranceScoreBox.click();
		reviewChevron.btnInsuranceScoreOk.click();
	}	
	@And("User enters HO3 Underwritting Questions")
	public void User_enters_HO3_Underwritting_Questions () {
	click(dwellingChevron.btnNext);
	selectDropdownText(uwquestionsChevron.ho3Question1, "No");
	selectDropdownText(uwquestionsChevron.ho3Question2, "No");
	selectDropdownText(uwquestionsChevron.ho3Question3, "No");
	selectDropdownText(uwquestionsChevron.ho3Question4, "No");
	selectDropdownText(uwquestionsChevron.ho3Question5, "No");
	selectDropdownText(uwquestionsChevron.ho3Question6, "No");
	selectDropdownText(uwquestionsChevron.ho3Question7, "No");
	selectDropdownText(uwquestionsChevron.ho3Question8, "No");
	selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
	selectDropdownText(uwquestionsChevron.ho3Question10, "No");
	selectDropdownText(uwquestionsChevron.ho3Question11, "No");
	selectDropdownText(uwquestionsChevron.ho3Question12, "No");
	selectDropdownText(uwquestionsChevron.ho3Question13, "No");
	selectDropdownText(uwquestionsChevron.ho3Question14, "No");
	selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
	selectDropdownText(uwquestionsChevron.ho3Question16, "No");
	selectDropdownText(uwquestionsChevron.ho3Question17, "No");
	selectDropdownText(uwquestionsChevron.ho3Question18, "No");
	selectDropdownText(uwquestionsChevron.ho3Question19, "No");
	selectDropdownText(uwquestionsChevron.ho3Question20, "No");
	selectDropdownText(uwquestionsChevron.ho3Question21, "No");
	selectDropdownText(uwquestionsChevron.ho3Question22, "No");
	selectDropdownText(uwquestionsChevron.ho3Question23, "No");
	selectDropdownText(uwquestionsChevron.ho3Question24, "No");
	selectDropdownText(uwquestionsChevron.ho3Question25, "No");
	selectDropdownText(uwquestionsChevron.ho3Question26, "No");
	selectDropdownText(uwquestionsChevron.ho3Question27, "No");
	selectDropdownText(uwquestionsChevron.ho3Question28, "No");
	selectDropdownText(uwquestionsChevron.ho3Question29, "No");
	wait(1);
	click(uwquestionsChevron.nextButtonUw);
	}	
	@And("User enters Dwelling Type")
	public void User_enters_Dwelling_Type() {	    	   				
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family"); 
		wait(1);
	}	
	@And("User clicks Worksheets chevron")
	public void User_clicks_Worksheets_chevron() {	    	   						
		click(dwellingChevron.worksheets);		
	}
	@Then("User verifies Water NonWeather Base Rate")
    public void User_verifies_Water_NonWeather_Base_Rate() {
	String expected = "Initial Base Rate: 353.71<br> - Water Non-Weather Territory Code: 3<br> - Territory Factor: 1.630";
	String actual = worksheetsChevron.waterNonWeather.getText();				
	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
	}
	@Then("User verifies Fire or Lightning Base Rate")
	public void User_verifies_Fire_or_Lightning_Base_Rate() {
	String expected = "Initial Base Rate: 50.93<br> - Fire or Lightning Territory Code: 10<br> - Territory Factor: 0.860";
	String actual = worksheetsChevron.fireLightning.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
	}
	@Then("User verifies Other Base Rate")
	public void User_verifies_Other_Base_Rate() {
	String expected = "57.93";
	String actual = worksheetsChevron.other.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
	}
	@Then("User verifies Weather Base Rate")
	public void User_verifies_Weather_Base_Rate() {
	String expected = "Initial Base Rate: 276.18<br> - Weather Territory Code: 3<br> - Territory Factor: 1.540";
	String actual = worksheetsChevron.weatherBaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
	}
	@Then("User verifies Hurricane Base Rate")
	public void User_verifies_Hurricane_Base_Rate() {
	String expected = "Initial Base Rate: 2090.44<br> - Hurricane Territory Code: E4<br> - Territory Factor: 0.577";
	String actual = worksheetsChevron.hurricaneBaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Building Flood Rate Zone X and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_X_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);				
	}
	@Then("User verifies Personal Property Flood Rate Zone X and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Building Flood Rate Zone X and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_X_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);				
	}
	@Then("User verifies Personal Property Flood Rate Zone X and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone D and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_D_and_Foundation_Slab() {
	String expected = "0.65";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone D and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_D_and_Foundation_Slab() {
	String expected = "0.70";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Building Flood Rate Zone D and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_C_and_Foundation_Elevated() {
	String expected = "0.65";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone D and Foundation Basement")
	public void User_verifiess_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Elevated() {
	String expected = "0.70";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone B and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_B_and_Foundation_Elevated() {
	String expected = "0.15";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone B and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_B_and_Foundation_Elevated() {
	String expected = "0.15";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Building Flood Rate Zone C and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_C_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone C and Foundation Basement")
	public void User_verifiess_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Building Flood Rate Zone A and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_A_and_Foundation_Slab() {
	String expected = "2.64";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone A and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A_and_Foundation_Slab() {
	String expected = "1.59";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone AE and Foundation Basement")
	public void User_vverifies_Building_Flood_Rate_Zone_AE_and_Foundation_Basement() {
	String expected = "1.30";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone AE and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AE_and_Foundation_Basement() {
	String expected = "1.95";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone AH and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_AH_and_Foundation_Slab() {
	String expected = "0.52";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone AH and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AH_and_Foundation_Slab() {
	String expected = "0.39";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone AO and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_AO_and_Foundation_Basement() {
	String expected = "0.52";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone AO and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AO_and_Foundation_Basement() {
	String expected = "0.39";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone A99 and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_A99_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone A99 and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A99_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_AR_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AR_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone A15 and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_A15_and_Foundation_Elevated() {
	String expected = "1.30";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone A15 and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A15_and_Foundation_Elevated() {
	String expected = "1.95";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone A30 and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_A30_and_Foundation_Elevated() {
	String expected = "1.30";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone A30 and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A30_and_Foundation_Elevated() {
	String expected = "1.95";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}	
	@Then("User verifies Building Flood Rate Zone A1 and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_A1_and_Foundation_Basement() {
	String expected = "1.30";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies Personal Property Flood Rate Zone A1 and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A1_and_Foundation_Basement() {
	String expected = "1.95";
	String actual = worksheetsChevron.personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO3 NB Water NonWeather Base Rate")
	public void User_verifies_HO3_NB_Water_NonWeather_Base_Rate() {
		String expected = "Initial Base Rate: 353.71<br> - Water Non-Weather Territory Code: 3<br> - Territory Factor: 1.630";
		String actual = worksheetsChevron.HO3NBWaterNonWeather.getText();				
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO3 NB Fire or Lightning Base Rate")
	public void User_verifies_HO3_NB_Fire_or_Lightning_Base_Rate() {
	String expected = "Initial Base Rate: 50.93<br> - Fire or Lightning Territory Code: 10<br> - Territory Factor: 0.860";
	String actual = worksheetsChevron.HO3NBFireLightning.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO3 NB Hurricane Base Rate")
	public void User_verifies_HO3_NB_Hurricane_Base_Rate() {
	String expected = "Initial Base Rate: 2090.44<br> - Hurricane Territory Code: E4<br> - Territory Factor: 0.577";
	String actual = worksheetsChevron.HO3NBHurricaneBaseRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}		
	@And("User clicks Dwelling chevron")
	public void User_clicks_Dwelling_chevron() {	    	   						
		click(dwellingChevron.dwelling);		
	}
	@And("User clicks Finalize button")
	public void User_clicks_Finalize_button() {	    	   						
		dwellingChevron.btnSave.click();
		uwquestionsChevron.nextButtonUw.click();
		reviewChevron.btnFinalize.click();		
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(2);
		closeoutChevron.btnIssueNB.click();
		wait(20);
	}
	@And("User returns to main page")
	public void User_returns_to_main_page() {			
	driver.switchTo().window(driver.getWindowHandle());		
	wait(10);	
	}
	@And("User clicks Start Transaction")
	public void User_clicks_Start_Transaction() {	    	   						
		click(dashboard.btnStartTransaction);		
	}
	@And("User clicks Transaction Selection")
	public void User_clicks_Transaction_Selection() {	    	   						
		selectDropdownText(dashboard.ddSelectTransaction, "Renewal");	
		 wait(1);	
		 click(dashboard.btnSelect);	
		 click(dashboard.btnStart);
	}
	@And("User clicks Finalize")
	public void User_clicks_Finalize() {	    	   						
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnIssueNB.click();	 
	}	 

	
}
