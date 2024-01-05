package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.junit.Assert;
//import Member.Pages.ActionsTile.ActionTile;
//import Member.Pages.Login.LoginPage;
//import Member.Pages.ProductSelection.ProductSelectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLHO3_RateChange extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String Cov_A_InfaltionValue;
	static String RwlDec_Form;
	static String RwlDecCoveragesForm;
	static String RwlDecForm;
	static String RwlCheckList_Version;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";

	@And("User clicks Worksheets chevron")
	public void User_clicks_Worksheets_chevron() {
		click(dwellingChevron.btnWorksheets);
	}

	@And("User clicks Underwriting Questions chevron")
	public void User_clicks_Underwriting_Questions_chevron() {
		click(dwellingChevron.btnUnderwriting);
	}

	@Then("User verifies Water NonWeather Base Rate")
	public void User_verifies_Water_NonWeather_Base_Rate() {
		click(worksheetsChevron.HO3WNWBasePremium);

		String expected = "Initial Base Rate: 353.71<br> - Water Non-Weather Territory Code: 3<br> - Territory Factor: 1.630";
		String actual = worksheetsChevron.txtWaterNonWeather.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Fire or Lightning Base Rate")
	public void User_verifies_Fire_or_Lightning_Base_Rate() {
		String expected = "Initial Base Rate: 50.93<br> - Fire or Lightning Territory Code: 10<br> - Territory Factor: 0.860";
		String actual = worksheetsChevron.txtFireLightning.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@And("User clicks  Weather Base Premium")
	public void User_clicks_Weather_Base_Premium() {
		click(worksheetsChevron.weatherBasePremium);

		wait(3);

	}

	@And("User clicks Fire or Lightning Base Premium")
	public void User_clicks_Fire_or_Lightning_Base_Premium() {
		click(worksheetsChevron.fireLightningBasePremium);

		wait(3);

	}

	@And("User clicks VOL HO3 Hurricane Base Premium")
	public void User_clicks_VOL_HO3_Hurricane_Base_Premium() {
		click(worksheetsChevron.hurricaneBasePremium);

		wait(3);

	}

	@And("User verifies VOL HO3 Fire or Lightning Base Rate")
	public void User_verifies_VOL_HO3_Fire_or_Lightning_Base_Rate() {

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea01\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 58.57\r\n" + "- Census Block: 121050125042002\r\n"
				+ "- Census Tract: 12105012504\r\n" + "- Fire or Lightning Territory Code: 9")) {
			System.out.println("HO3 rate has been processed successfully");

		} else {
			System.out.println("HO3 rate has been failed!");
			wait(5);
		}

	}

	@And("User verifies VOL HO3 Weather Base Rate")
	public void User_verifies_VOL_HO3_Weather_Base_Rate() {

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea04\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 335.56\r\n" + "- Census Block: 121050125042002\r\n"
				+ "- Census Tract: 12105012504\r\n" + "- Weather Territory Code: 3")) {
			System.out.println("HO3 rare has been processed successfully");

		} else {
			System.out.println("HO3 rate has been failed!");
			wait(5);
		}

	}

	@And("User verifies VOL HO3 Hurricane Base Rate")
	public void User_verifies_VOL_HO3_Hurricane_Base_Rate() {

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea07\"]/tbody/tr/td/div/table/tbody/tr[3]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 3407.55\r\n" + "- Census Block: 121050125042002\r\n"
				+ "- Census Tract: 12105012504\r\n" + "- Hurricane Territory Code: E5")) {
			System.out.println("HO3 rare has been processed successfully");

		} else {
			System.out.println("HO3 rate has been failed!");
			wait(5);
		}

	}

	@Then("User verifies Fire or Lightning Base Rate 2")
	public void User_verifies_Fire_or_Lightning_Base_Rate_2() {

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea131\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 58.57\r\n"
				+ "- Fire or Lightning Territory Code: 9\r\n" + "- Territory Factor: 0.840")) {
			System.out.println("HO3 Endorsement has been processed successfully");

		} else {
			System.out.println("HO3 Endorsement has been failed!");
			wait(5);
		}

//		String expected = "Initial Base Rate: 58.57\r\n"
//				+ "- Fire or Lightning Territory Code: 9\r\n"
//				+ "- Territory Factor: 0.840";
//			
//				String actual = worksheetsChevron.txtFireLightning2.getText().toString();
//	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
	}

	@Then("User verifies Other Base Rate")
	public void User_verifies_Other_Base_Rate() {
		String expected = "57.93";
		String actual = worksheetsChevron.txtOtherBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Weather Base Rate")
	public void User_verifies_Weather_Base_Rate() {
		String expected = "Initial Base Rate: 276.18<br> - Weather Territory Code: 3<br> - Territory Factor: 1.540";
		String actual = worksheetsChevron.txtWeatherBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Weather Base Rate 2")
	public void User_verifies_Weather_Base_Rate_2() {
		wait(1);

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea131\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 58.57\r\n"
				+ "- Fire or Lightning Territory Code: 9\r\n" + "- Territory Factor: 0.840")) {
			System.out.println("HO3 Endorsement has been processed successfully");

		} else {
			System.out.println("HO3 Endorsement has been failed!");
			wait(5);
		}

//	String expected = "Initial Base Rate: 335.56\r\n"
//			+ "- Weather Territory Code: 3\r\n"
//			+ "- Territory Factor: 1.540";
//	String actual = worksheetsChevron.txtWeatherBaseRate2.getText();
//	Assert.assertEquals("The value DOES NOT match!", expected, actual);	
//	wait(1);
	}

	@Then("User verifies Hurricane Base Rate")
	public void User_verifies_Hurricane_Base_Rate() {
		String expected = "Initial Base Rate: 2090.44<br> - Hurricane Territory Code: E4<br> - Territory Factor: 0.577";
		String actual = worksheetsChevron.txtHurricaneBaseRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Hurricane Base Rate 2")
	public void User_verifies_Hurricane_Base_Rate_2() {

		wait(5);
		WebElement validate = driver
				.findElement(By.xpath("//*[@id=\"rowCovCovArea137\"]/tbody/tr/td/div/table/tbody/tr[2]/td[2]"));
		if (validate.getText().equalsIgnoreCase("Initial Base Rate: 3407.55\r\n" + "- Hurricane Territory Code: E5\r\n"
				+ "- Territory Factor: 0.611")) {
			System.out.println("HO3 Endorsement has been processed successfully");

		} else {
			System.out.println("HO3 Endorsement has been failed!");
			wait(5);

		}

//		String expected = "Initial Base Rate: 3407.55\r\n"
//			+ "- Hurricane Territory Code: E5\r\n"
//			+ "- Territory Factor: 0.611";
//	String actual = worksheetsChevron.txtHurricaneBaseRate2.getText();
//	Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone X and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_X_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone X and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone X and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_X_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone X and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_X_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone D and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_D_and_Foundation_Slab() {
		String expected = "0.65";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone D and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_D_and_Foundation_Slab() {
		String expected = "0.70";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone D and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_C_and_Foundation_Elevated() {
		String expected = "0.65";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone D and Foundation Basement")
	public void User_verifiess_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Elevated() {
		String expected = "0.70";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone B and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_B_and_Foundation_Elevated() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone B and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_B_and_Foundation_Elevated() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone C and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_C_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone C and Foundation Basement")
	public void User_verifiess_Personal_Property_Flood_Rate_Zone_C_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone A and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_A_and_Foundation_Slab() {
		String expected = "2.64";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone A and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A_and_Foundation_Slab() {
		String expected = "1.59";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone AE and Foundation Basement")
	public void User_vverifies_Building_Flood_Rate_Zone_AE_and_Foundation_Basement() {
		String expected = "1.30";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone AE and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AE_and_Foundation_Basement() {
		String expected = "1.95";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone AH and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_AH_and_Foundation_Slab() {
		String expected = "0.52";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone AH and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AH_and_Foundation_Slab() {
		String expected = "0.39";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone AO and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_AO_and_Foundation_Basement() {
		String expected = "0.52";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone AO and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AO_and_Foundation_Basement() {
		String expected = "0.39";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone A99 and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_A99_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone A99 and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A99_and_Foundation_Basement() {
		String expected = "0.17";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_Building_Flood_Rate_Zone_AR_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone AR and Foundation Slab")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_AR_and_Foundation_Slab() {
		String expected = "0.15";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone A15 and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_A15_and_Foundation_Elevated() {
		String expected = "1.30";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone A15 and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A15_and_Foundation_Elevated() {
		String expected = "1.95";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone A30 and Foundation Elevated")
	public void User_verifies_Building_Flood_Rate_Zone_A30_and_Foundation_Elevated() {
		String expected = "1.30";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone A30 and Foundation Elevated")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A30_and_Foundation_Elevated() {
		String expected = "1.95";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Building Flood Rate Zone A1 and Foundation Basement")
	public void User_verifies_Building_Flood_Rate_Zone_A1_and_Foundation_Basement() {
		String expected = "1.30";
		String actual = worksheetsChevron.txtBuildingFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies Personal Property Flood Rate Zone A1 and Foundation Basement")
	public void User_verifies_Personal_Property_Flood_Rate_Zone_A1_and_Foundation_Basement() {
		String expected = "1.95";
		String actual = worksheetsChevron.txtPersonalPropertyFloodRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User verifies HO3 Elevation Certificate rate")
	public void User_verifies_HO3_Elevation_Certificate_rate() {
		String expected = "0.52";
		String actual = worksheetsChevron.HO3elevationRate.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage A increases by 10 percentage")
	public void User_validates_HO3_Coverage_A_increases_by_10_percentage() {
		String expected = "$253,000";
		String actual = worksheetsChevron.HO6CovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage B increases by 10 percentage")
	public void User_validates_HO3_Coverage_B_increases_by_10_percentage() {
		String expected = "$25,300";
		String actual = worksheetsChevron.HO6CovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage C increases by 10 percentage")
	public void User_validates_HO3_Coverage_C_increases_by_10_percentage() {
		String expected = "$177,100";
		String actual = worksheetsChevron.HO6CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage D increases by 10 percentage")
	public void User_validates_HO3_Coverage_D_increases_by_10_percentage() {
		String expected = "$50,600";
		String actual = worksheetsChevron.HO6CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Hurricane Deductible 2 percentage")
	public void User_validates_HO3_Hurricane_Deductible_2_percentagee() {
		String expected = "2%";
		String actual = worksheetsChevron.HO3HurricaneDeductible.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Ordinance or Law increases by 10 percentage")
	public void User_validates_HO3_Ordinance_or_Law_increases_by_10_percentage() {
		String expected = "$63,250";
		String actual = worksheetsChevron.HO3OrdinanceLaw.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage A on Coverages List")
	public void User_validates_HO3_Coverage_A_on_Coverages_List() {
		String expected = "253,000";
		String actual = worksheetsChevron.HO3CovACoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage B on Coverages List")
	public void User_validates_HO3_Coverage_B_on_Coverages_List() {
		String expected = "25,300";
		String actual = worksheetsChevron.HO3CovBCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage C on Coverages List")
	public void User_validates_HO3_Coverage_C_on_Coverages_List() {
		String expected = "177,100";
		String actual = worksheetsChevron.HO3CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage D on Coverages List")
	public void User_validates_HO3_Coverage_D_on_Coverages_List() {
		String expected = "50,600";
		String actual = worksheetsChevron.HO3CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Ordinance or Law on Coverages List")
	public void User_validates_HO3_Ordinance_or_Law_on_Coverages_List() {
		String expected = "63,250";
		String actual = worksheetsChevron.HO3OrdinanceLawCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates 10 percentage Inflation guard for Cov A")
	public void User_validates_10_percentage_Inflation_guard_for_Cov_A() {
		String expected = "10%";
		String actual = worksheetsChevron.HO3CovAInflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage A increases by 10 percentage after second RN")
	public void User_validates_HO3_Coverage_A_increases_by_10_percentage_after_second_RN() {
		String expected = "$279,000";
		String actual = worksheetsChevron.HO6CovA.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage B increases by 10 percentage after second RN")
	public void User_validates_HO3_Coverage_B_increases_by_10_percentage_after_second_RN() {
		String expected = "$27,900";
		String actual = worksheetsChevron.HO6CovB.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage C increases by 10 percentage after second RN")
	public void User_validates_HO3_Coverage_C_increases_by_10_percentage_after_second_RN() {
		String expected = "$195,300";
		String actual = worksheetsChevron.HO6CovC.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage D increases by 10 percentage after second RN")
	public void User_validates_HO3_Coverage_D_increases_by_10_percentage_after_second_RN() {
		String expected = "$55,800";
		String actual = worksheetsChevron.HO6CovD.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Ordinance or Law increases by 10 percentage after second RN")
	public void User_validates_HO3_Ordinance_or_Law_increases_by_10_percentage_after_second_RN() {
		String expected = "$69,750";
		String actual = worksheetsChevron.HO3OrdinanceLaw.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage A on Coverages List after second RN")
	public void User_validates_HO3_Coverage_A_on_Coverages_List_after_second_RN() {
		String expected = "279,000";
		String actual = worksheetsChevron.HO3CovACoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage B on Coverages List after second RN")
	public void User_validates_HO3_Coverage_B_on_Coverages_List_after_second_RN() {
		String expected = "27,900";
		String actual = worksheetsChevron.HO3CovBCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage C on Coverages List after second RN")
	public void User_validates_HO3_Coverage_C_on_Coverages_List_after_second_RN() {
		String expected = "195,300";
		String actual = worksheetsChevron.HO3CovCCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Coverage D on Coverages List after second RN")
	public void User_validates_HO3_Coverage_D_on_Coverages_List_after_second_RN() {
		String expected = "55,800";
		String actual = worksheetsChevron.HO3CovDCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates HO3 Ordinance or Law on Coverages List after second RN")
	public void User_validates_HO3_Ordinance_or_Law_on_Coverages_List_after_second_RN() {
		String expected = "69,750";
		String actual = worksheetsChevron.HO3OrdinanceLawCoverageList.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@Then("User validates 10 percentage Inflation guard for Cov A after second RN")
	public void User_validates_10_percentage_Inflation_guard_for_Cov_A_after_second_RN() {
		String expected = "10%";
		String actual = worksheetsChevron.HO3CovAInflationGuard.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
	}

	@When("User validates VOL HO3 10 percentage in RN Declaration Package")
	public void User_validates_VOL_HO3_10_percentage_in_RN_Declaration_Package() throws Exception {

		wait(5);

		mainWindow = driver.getWindowHandle();
		WebDriver popup = null;
		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
		while (windowIterator.hasNext()) {
			String parent = windowIterator.next();
			popup = driver.switchTo().window(parent);
			popup.getCurrentUrl();
		}

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(15);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 13, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

		wait(10);
	}

	@When("User validates VOL HO3 10 percentage in RN Declaration Package for second RN")
	public void User_validates_VOL_HO3_10_percentage_in_RN_Declaration_Package_for_second_RN() throws Exception {

//	!!!!!!!!!	

//		wait(5);
//
//		mainWindow = driver.getWindowHandle();
//		WebDriver popup = null;
//		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
//		while (windowIterator.hasNext()) {
////			String parent = windowIterator.next();
//			popup = driver.switchTo().parentFrame();
//				
//			popup.getCurrentUrl();
//		}
//		switchToWindow(driver, "STFile&File");

		wait(6);
//		driver.switchTo().window(driver.getWindowHandle());
//		wait(6);
//		

//		driver.switchTo().window(Cov_A_InfaltionValue);

		wait(5);

		mainWindow = driver.getWindowHandle();
		WebDriver popup = null;
		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
		while (windowIterator.hasNext()) {
			String parent = windowIterator.next();
			popup = driver.switchTo().window(parent);
			popup.getCurrentUrl();
		}

		RwlDec_Form = PdfComparator.makePdf(driver, "Renewal_Declaration.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + RwlDec_Form);

		wait(15);

		RwlDecForm = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 13, 0, 0, 800, 800);
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"Property Coverage limits have increased at renewal due to an inflation factor of 10%, as determined by an");
		PdfComparator.verifyFormData(driver, RwlDecForm,
				"industry approved replacement cost estimator index to maintain insurance to an approximate replacement cost");
		PdfComparator.verifyFormData(driver, RwlDecForm, "of the home");

		wait(10);

	}

	@When("User validates VOL HO3 inflated values on OIR B1 1670 form for first RN")
	public void User_validates_VOL_HO3_inflated_values_on_OIR_B1_1670_form_for_first_RN() throws Exception {

		wait(5);
		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 68, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$253,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$25,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$177,100");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$5,060");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}

	@When("User validates VOL HO3 inflated values on OIR B1 1670 form for second RN")
	public void User_validates_VOL_HO3_inflated_values_on_OIR_B1_1670_form_for_second_RN() throws Exception {

		RwlCheckList_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + RwlDec_Form, 66, 0, 0, 800, 800);
//		PdfComparator.verifyFormData(driver, RwlCheckList_Version, Cov_A_InfaltionValue);
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$279,000");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$27,900");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$195,300");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "$5,580");
		PdfComparator.verifyFormData(driver, RwlCheckList_Version, "OIR-B1-1670");
		Hooks.scenario.log("Test Case Completed!");
		wait(5);
	}

}