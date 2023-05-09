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

public class VOLHO6RateChange extends CommonMethods {
		
	@And("User enters NB HO6 New Product Version effective date")
	public void User_enters_NB_HO6_New_Product_Version_effective_date() {	    	   		
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy"); 		
		product.txtEffectiveDate.sendKeys(ConfigsReader.getProperty("NBHO6NewProductVersioneffectivedate"));	
	}
	@And("User enters Construction Type")
	public void User_enters_Construction_Type() {	    	   				
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		wait(1);
	}
	@And("User enters Occupancy")
	public void User_enters_Occupancy() {	    	   				
		selectDropdown(policyChevron.ddOccupancy, 1); 
		wait(1);	
	}
	@And("User enters Months Occupied")
	public void User_enters_Months_Occupied() {	    	   				
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
	}
	@And("User enters Year of Construction")
	public void User_enters_Year_of_Construction() {	    	   						
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(1);
	}	
	@And("User enters Square Feet")
	public void User_enters_Square_Feet() {	    	   				
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
	}	
	@And("User enters Building Code Effectiveness Grade")
	public void User_enters_Building_Code_Effectiveness_Grade() {	    	   				
		selectDropdownText(dwellingChevron.bCEG, "4");
		wait(1);
	}
	@And("User enters Distance to Hydrant_Accredited Water Source")
	public void User_enters_Distance_to_Hydrant_Accredited_Water_Source() {	    	   				
		selectDropdown(dwellingChevron.ddDistanceToHydrant, 1);
		wait(1);			
	}
	@And("User enters Number of stories")
	public void User_enters_Number_of_stories() {	    	   				
		selectDropdownText(dwellingChevron.numberOfStories, "3");
		wait(1);
	}	
	@And("User enters Floor number of unit location")
	public void User_enters_Floor_number_of_unit_location() {	    	   				
		selectDropdown(dwellingChevron.storyUnit, 2);
		wait(1);	
	}
	@And("User enters C Personal Property")
	public void User_enters_C_Personal_Property() {	
		
		dwellingChevron.cPersonalProperty.clear();
		dwellingChevron.cPersonalProperty.sendKeys("$25,000");
	}
	@Then("User verifies HO6 Building Flood Rate Zone X and Foundation Basement")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_X_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	
	}
	@Then("User verifies HO6 Personal Property Flood Rate Zone X and Foundation Basement")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Basement() {
	String expected = "0.17";
	String actual = worksheetsChevron.hO6personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO6 Building Flood Rate Zone D and Foundation Slab")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_D_and_Foundation_Slab() {
	String expected = "0.65";
	String actual =  worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}		
	@Then("User verifies HO6 Personal Property Flood Rate Zone D and Foundation Slab")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_D_and_Foundation_Slab() {
	String expected = "0.70";
	String actual =  worksheetsChevron.hO6personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO6 Building Flood Rate Zone C and Foundation Elevated")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_C_and_Foundation_Elevated() {
	String expected = "0.15";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}		
	@Then("User verifies HO6 Personal Property Flood Rate Zone C and Foundation Elevated")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Elevated() {
	String expected = "0.15";
	String actual = worksheetsChevron.hO6personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}
	@Then("User verifies HO6 Building Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_HO6_Building_Flood_Rate_Zone_AR_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.buildingFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	wait(1);
	}		
	@Then("User verifies HO6 Personal Property Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_HO6_Personal_Property_Flood_Rate_Zone_AR_and_Foundation_Slab() {
	String expected = "0.15";
	String actual = worksheetsChevron.hO6personalPropertyFloodRate.getText();
	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}		
}	

