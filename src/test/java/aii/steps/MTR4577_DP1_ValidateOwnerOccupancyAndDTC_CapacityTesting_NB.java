package aii.steps;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
	@When("User clicks Quote Policy Tab <mtr4577>")
	public void user_clicks_Quote_Policy_Tab_mtr4577() {
		driver.findElement(By.id("Menu_Policy")).click();
		wait(2);
	}
	@When("User clicks Capacity Maintenance <mtr4577>")
	public void user_clicks_Capacity_Maintenance_mtr4577() throws Exception {
		clickonAnyButton(driver, "Menu_Policy_CapacityMaintenance");
		wait(2);
	}

	@And("User checks Capacity Rule has been set to Capacity is of 10 mi to less than 15 mi is set for DP1 DP3 HO3 MHO3 and adds capacity in case it has not been set")
	public void user_checks_Capacity_Rule_has_been_set_to_Capacity_is_of_10_mi_toless_than_15_mi_is_set_for_dp1_dp3_ho3_mho3() throws Exception {
		String ProductLine = "DP1";
		wait(3);
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
							click(driver.findElement(By.id("SignOutInMenu")));
							wait(5);
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
							click(driver.findElement(By.id("SignOutInMenu")));
							wait(2);
						}
						break;

					case "DP3":
						if (product.contains("Voluntary Dwelling Property 3 (DP3)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for DP3 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for DP3 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							click(driver.findElement(By.id("SignOutInMenu")));
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
							click(driver.findElement(By.id("SignOutInMenu")));
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
							click(driver.findElement(By.id("SignOutInMenu")));
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
			click(driver.findElement(By.id("SignOutInMenu")));
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
	@When("User enters all required information on DP1 quote screen <mtr4577>")
	public void user_enters_all_required_information_on_dp1_quote_screen_mtr4577() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		//selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@When("User enters all required information on DP1 dwelling screen <mtr4577>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_mtr4577() throws Exception {

		try {
			clickOKDailogButton(driver);
			Thread.sleep(500);
			sendText(dwellingChevron.txtYearConstruction, "2020");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
			wait(1);
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			click(dwellingChevron.btnCalculate);
			wait(4);
			click(dwellingChevron.btnSave);
			wait(2);
			sendText(driver.findElement(By.id("CovALimit")), "200000");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
			click(dwellingChevron.btnSave);
		} catch (InterruptedException e) {
			sendText(dwellingChevron.txtYearConstruction, "2020");
			sendText(dwellingChevron.txtSquareFeet, "1500");
			selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
			wait(1);
			selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
			click(dwellingChevron.btnCalculate);
			wait(4);
			click(dwellingChevron.btnSave);
			wait(2);
			sendText(driver.findElement(By.id("CovALimit")), "200000");
			selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
			selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
			click(dwellingChevron.btnSave);
		}
	}
	@When("User validates 'Cannot issue due to limited catastrophic capacity Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review' message is visible")
	public void user_validates_cannot_issue_due_to_limited_catastrophic_capacity_message_is_visible_4577() throws Exception {
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review] ");
		wait(1);
		click(dwellingChevron.btnNext);
		wait(2);
	}
	@When("User clicks Dwelling Chevron <mtr4577>")
	public void user_clicks_dwelling_chevron_mtr4577() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}
	@And("User checks application dwelling screen validates error message and finalizes transaction <mtr4577>")
	public void user_checks_application_dwelling_screen_validates_error_messageand_finalizes_transaction_mtr4577() throws Exception {
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "1");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review] ");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnNext);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@And("User validates error message displayed on closeout screen <mtr4577>")
	public void user_validates_error_message_displayed_on_closeout_screen_mtr4577() throws Exception {
		attachScreenShot(driver);
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review] ");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}
	@When("User takes note of the application number <mtr4577>")
	public void user_takes_note_of_the_application__number_mtr4577() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User searches for application number <mtr4577>")
	public void user_searches_for_application_number_mtr4577() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}
	@When("User validates 'App is owned by AG1730' 'Application in inquiry mode only' labels are visible")
	public void user_validates_App_is_owned_by_AG1730_Application_in_inquiry_mode_only_labels_are_visible_mtr4577() throws Exception {
		verify_AnyLabel_IsVisible(driver, AppNum+" is owned by AG1730");
		verify_AnyLabel_IsVisible(driver, "Application in inquiry mode only");
	}
	@And("User validates error message displayed on dwelling screen <mtr4577>")
	public void user_validates_error_message_displayed_on_dwelling_screen_mtr4577() throws Exception {
		attachScreenShot(driver);
		verify_AnyText_IsVisible(driver, "Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review] ");
	}
	@Then("User issues policy and completes test <mtr4577>")
	public void user_issues_policy_and_completes_test_mtr4577() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(3);
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}
}
