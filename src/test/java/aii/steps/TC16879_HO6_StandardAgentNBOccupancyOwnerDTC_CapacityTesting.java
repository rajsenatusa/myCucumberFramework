package aii.steps;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16879_HO6_StandardAgentNBOccupancyOwnerDTC_CapacityTesting extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
	static Date date = new Date();
	static String policyNum;
	static String AppNum;

	@When("User clicks Quote Policy Tab <tc16879>")
	public void user_clicks_Quote_Policy_Tab_tc16879() {
		driver.findElement(By.id("Menu_Policy")).click();
		wait(2);
	}

	@When("User clicks Capacity Maintenance <tc16879>")
	public void user_clicks_Capacity_Maintenance_tc16879() throws Exception {
		clickonAnyButton(driver, "Menu_Policy_CapacityMaintenance");
		wait(2);
	}

	@And("User checks Capacity Rule has been set to Capacity is of 10 mi to less than 15 mi is set for HO6 and adds capacity in case it has not been set")
	public void user_checks_Capacity_Rule_has_been_set_to_Capacity_is_of_10_mi_toless_than_15_mi_is_set_for_ho6()
			throws Exception {

		String ProductLine = "HO6";

		try {
			if (driver.findElement(By.xpath("//*[contains(text(),'10 mi to less than 15 mi')]"))
					.isDisplayed() == true) {
				Hooks.scenario.log("Capacity is visible");
				System.out.println("Capacity is visible");
				String location = driver
						.findElement(
								By.xpath("y//*[contains(text(),'10 mi to less than 15 mi')]//following-sibling::*[11]"))
						.getText().toString();
				if (location.equalsIgnoreCase("County - Manatee")) {
					Hooks.scenario.log("County - Manatee is visible");
					String product = driver
							.findElement(By.xpath(
									"//*[contains(text(),'10 mi to less than 15 mi')]//following-sibling::*[12]"))
							.getText().toString();
					switch (ProductLine) {

					case "HO6":
						if (product.contains("Voluntary Condominium Unit Owners (HO6)")) {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is set for HO6 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is set for HO6 product");
							click(driver.findElement(By.id("UserMenu"))); // signout
							click(driver.findElement(By.id("SignOutInMenu")));
							wait(3);
						} else {
							Hooks.scenario.log("Capacity is of 10 mi to less than 15 mi is not set for HO6 product");
							System.out.println("Capacity is of 10 mi to less than 15 mi is not set for HO6 product");

							driver.findElement(By.xpath(
									"//*[contains(text(),'10 mi to less than 15 mi')]//ancestor::*[1]//*[@id='morataorium_Code']"))
									.click();
							wait(2);

							clickonAnyButton(driver, "MoratoriumProduct_AIIG-FL-Condominium");

							click(driver.findElement(By.id("Save")));
							wait(3);

							click(driver.findElement(By.id("UserMenu"))); // signout
							click(driver.findElement(By.id("SignOutInMenu")));
							wait(2);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Capacity is of 10 mi to less than 15 mi is not set for " + ProductLine + " product");
			Hooks.scenario.log("Capacity not set for HO6 product");

			click(driver.findElement(By.id("AddMoratorium")));
			wait(2);

			// Add the rest of the code to add capacity
			MoratoriumDetail_setMoratoriumCode(driver, "AutoHO6" + " " + dt.format(date));
			selectDropdownText(driver.findElement(By.id("Moratorium.SubTypeCd")), "Threshold");
			click(driver.findElement(By.id("Save")));
			wait(3);

			clickonAnyButton(driver, "NewLocation");
			wait(1);
			selectDropdownText(driver.findElement(By.id("MoratoriumLocation.StateProvCd")), "Florida");
			selectDropdownText(driver.findElement(By.id("MoratoriumLocation.TypeCd")), "County");
			Thread.sleep(250);
			selectDropdownText(driver.findElement(By.id("LocationValues")), "Manatee");
			click(driver.findElement(By.id("Save")));
			wait(3);

			clickonAnyButton(driver, "NewReferralThreshold");
			wait(1);
			selectDropdownText(driver.findElement(By.id("CapacityLimit.LimitTypeCd")), "Distance to Coast");
			Thread.sleep(250);
			selectDropdownText(driver.findElement(By.id("CapacityLimit.Limit")), "10 mi to less than 15 mi");
			// save with more
			click(driver.findElement(By.id("MoreActionsDropdownButton")));
			wait(1);
			click(driver.findElement(By.id("Save")));
			wait(3);

			clickonAnyButton(driver, "MoratoriumProduct_AIIG-FL-Condominium");

//			click(driver.findElement(By.id("MoreActionsDropdownButton")));
			click(driver.findElement(By.id("Save")));
			wait(3);

			click(driver.findElement(By.id("UserMenu"))); // signout
			click(driver.findElement(By.id("SignOutInMenu")));
			wait(2);
		}
	}

	@When("User enters all required information on policy information screen <tc16879>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16879() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "7814 Hidden Creek Loop");
		sendText(quote.txtZipCode, "34202");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on HO6 quote screen with current date as prior policy date <tc16879>")
	public void user_enters_all_required_information_on_ho6_quote_screen_with_current_date_as_prior_policy_date_tc16879() {

		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on HO6 dwelling screen <tc16879>")
	public void user_enters_all_required_information_on_ho6_dwelling_screen_tc16879() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
//		sendText(dwellingChevron.txtCoverageA, "294000");
//		sendText(dwellingChevron.txtPersonalPropertyC, "25000");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$5,000");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]");
		attachScreenShot(driver);
		click(dwellingChevron.btnNext);
	}

	@When("User creates HO6 application and validates expected issue messages")
	public void user_creates_ho6_application_and_validates_expected_issue_messages() throws Exception {
		click(reviewChevron.btnCreateApplication);
		wait(1);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
		click(dwellingChevron.btnDwelling);
		wait(3);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_GenericMessage_IsVisible(driver, "Actual insurance score results differs from the selected estimate");
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]");
		click(driver.findElement(By.id("Wizard_Underwriting")));
		wait(2);
	}

	@When("User answers all underwriting questions for HO6 and validates expected issue messages <tc16879>")
	public void user_answers_all_underwriting_questions_for_ho6_and_validates_expected_issue_messages_tc16879()
			throws Exception {
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");

		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
		click(uwquestionsChevron.nextButtonUw);
	}

	@And("User checks application dwelling screen and finalizes transaction and validates expected issue messages <tc16879>")
	public void user_checks_application_dwelling_screen_and_finalizes_transaction_and_validates_expected_issue_messages_tc16879()
			throws Exception {
		// Application Dwelling information was filled here
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		selectDropdownText(dwellingChevron.ddStoryUnit, "1");
		click(dwellingChevron.btnSave);
		wait(2);
		verify_GenericMessage_IsVisible(driver, "Actual insurance score results differs from the selected estimate");
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]");
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@And("User sets payment type and validates expected issue messages <tc16879>")
	public void user_sets_payment_type_and_validates_expected_issue_messages_tc16879() throws Exception {

//		selectDropdownText(closeoutChevron.ddPaymentType, "None");
//		wait(4);
		verify_AnyText_IsVisible(driver,
				"Cannot issue due to limited catastrophic capacity [Distance to Coast which exceeds a minimum of 10 mi to less than 15 mi requires underwriting review]");
		verify_AnyLabel_IsVisible(driver, "Modify Application");
	}

	@When("User takes note of the application number <tc16879>")
	public void user_takes_note_of_the_application__number_tc16879() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("User signs out <tc16879>")
	public void user_signs_out_tc16879() {

		click(dashboard.btnUserMenu);
		wait(1);
		click(dashboard.btnSignOut);
		wait(2);
		Hooks.scenario.log("Sign out was clicked");
	}

	@When("User searches for application number <tc16879>")
	public void user_searches_for_application_number_tc16879() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User clicks Dwelling Chevron <tc16879>")
	public void user_clicks_dwelling_chevron_tc16879() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@Then("User issues policy and completes test <tc16879>")
	public void user_issues_policy_and_completes_test_tc16879() throws Exception {
		attachScreenShot(driver);
		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(3);
		click(closeoutChevron.btnIssueNB);
		wait(10);
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
	@When("User validates 'App is owned by AG1730' 'Application in inquiry mode only' labels are visible <tc16879>")
	public void user_validates_App_is_owned_by_AG1730_Application_in_inquiry_mode_only_labels_are_visible_tc16879() throws Exception {
		verify_AnyLabel_IsVisible(driver, AppNum+" is owned by AG1730");
		verify_AnyLabel_IsVisible(driver, "Application in inquiry mode only");
	}
}
