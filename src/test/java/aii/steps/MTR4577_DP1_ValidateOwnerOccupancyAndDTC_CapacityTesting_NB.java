package aii.steps;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR4577_DP1_ValidateOwnerOccupancyAndDTC_CapacityTesting_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss"); 
	static Date date = new Date();
	static String policyNum;
	static String AppNum;

	@When("User searches Manatee County")
	public void user_searches_Manatee_County() {
		sendText(driver.findElement(By.id("SearchText")), "Manatee");
		selectDropdownText(driver.findElement(By.id("SearchFilter")), "Threshold");
		wait(1);
		selectDropdownText(driver.findElement(By.id("MaxHits")), "100");
		click(driver.findElement(By.id("Search")));
		wait(2);
	}

	@And("User checks Capacity Rule has been set to Capacity is of 10 mi to less than 15 mi is set for DP1 DP3 HO3 MHO3 and adds capacity in case it has not been set")
	public void user_checks_Capacity_Rule_has_been_set_to_Capacity_is_of_10_mi_toless_than_15_mi_is_set_for_dp1_dp3_ho3_mho3() throws Exception {
		String ProductLine = "DP1";

		try {
			if (driver.findElement(By.xpath("//*[contains(text(),'10 mi to less than 15 mi')]")).isDisplayed()) {
				Hooks.scenario.log("capacity is visible");
				String location = driver
						.findElement(
								By.xpath("//*[contains(text(),'10 mi to less than 15 mi')]//following-sibling::*[11]"))
						.getText().toString();
				if (location.equalsIgnoreCase("County - Manatee")) {
					Hooks.scenario.log("County - Manatee is visible");
					String product = driver
							.findElement(By.xpath(
									"//*[contains(text(),'10 mi to less than 15 mi')]//following-sibling::*[12]"))
							.getText().toString();
					switch (ProductLine) {

					case "DP1":
						if (product.contains("Voluntary Dwelling Property 1 (DP1)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for DP1 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for DP1 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							wait(3);
						} else {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is not set for DP1 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is not set for DP1 product");

							driver.findElement(By.xpath(
									"//*[contains(text(),'10 mi to less than 15 mi  ')]//ancestor::*[1]//*[@id='morataorium_Code']"))
									.click();
							wait(2);

							clickonAnyButton(driver, "MoratoriumProduct_AIIG-FL-DwellingBasic");

							click(driver.findElement(By.id("Save")));
							wait(3);
							click(driver.findElement(By.id("UserMenu"))); // signout
							wait(2);
						}
						break;

					case "DP3":
						if (product.contains("Voluntary Dwelling Property 3 (DP3)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for DP3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for DP3 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							wait(3);
						} else {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is not set for DP3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is not set for DP3 product");
						}
						break;

					case "HO3":
						if (product.contains("Voluntary Homeowners (HO3)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for HO3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for HO3 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							wait(2);
						} else {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is not set for HO3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is not set for HO3 product");
						}
						break;

					case "MHO3":
						if (product.contains("Voluntary Mobile Homeowners 3 (MHO3)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for MHO3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for MHO3 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							wait(2);
						} else {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is not set for MHO3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is not set for MHO3 product");
						}
						break;

					}
				}
			}

		} catch (Exception e) {
			System.out.println("Capacity is of 10 mi to less than 15 mi is not set for " + ProductLine + " product");
			Hooks.scenario.log("Capacity not set for DP1 product");
			
			click(driver.findElement(By.id("AddMoratorium")));
			wait(2);
			//Add the rest of the code to add capacity
			MoratoriumDetail_setMoratoriumCode(driver, "AutoDP1"+" "+dt.format(date));
			selectDropdownText(driver.findElement(By.id("Moratorium.SubTypeCd")) , "Threshold");
			click(driver.findElement(By.id("Save")));
			wait(3);
			
			clickonAnyButton(driver, "NewLocation");
			wait(1);
			
			selectDropdownText(driver.findElement(By.id("MoratoriumLocation.StateProvCd")) , "Florida");
			selectDropdownText(driver.findElement(By.id("MoratoriumLocation.TypeCd")) , "County");
			Thread.sleep(250);
			selectDropdownText(driver.findElement(By.id("LocationValues")) , "Manatee");
			click(driver.findElement(By.id("Save")));
			wait(3);
			
			clickonAnyButton(driver, "NewReferralThreshold");
			wait(1);
			selectDropdownText(driver.findElement(By.id("CapacityLimit.LimitTypeCd")) , "Distance to Coast");
			Thread.sleep(250);
			selectDropdownText(driver.findElement(By.id("CapacityLimit.Limit")) , "10 mi to less than 15 mi");
			click(driver.findElement(By.id("Save")));
			wait(3);
			
			clickonAnyButton(driver, "MoratoriumProduct_AIIG-FL-DwellingBasic");
			
			click(driver.findElement(By.id("MoreActionsDropdownButton")));
			wait(1);
			click(driver.findElement(By.id("Save")));
			wait(3);
			
			click(driver.findElement(By.id("UserMenu"))); // signout
			wait(2);
		}
	}
	@When("User enters all required information on policy information screen <mtr4577>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr4577() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11001 Bristol Bay");
		sendText(quote.txtZipCode, "34209");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
}
