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

public class VOLHO3RateChange extends CommonMethods {
		
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
}
