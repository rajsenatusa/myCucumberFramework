package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC38507_DP1_NB_RoofMaterial_RoofAgeis25 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String roofYear = String.valueOf(currentY - 25);
	static String plumbingYear = String.valueOf(currentY - 5);
	static String policyNum;

	@When("User enters all required information on policy information screen <tc38507>")
	public void user_enters_all_required_information_on_policy_information_screen_tc38507() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "2615 W Rochester Rd, Avon Park, FL");
		sendText(quote.txtZipCode, "33825");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP1 quote screen <tc38507>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc38507() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		// sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "Annual");
		selectDropdownText(policyChevron.ddPropertyManaged, "Yes");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP1 dwelling screen <tc38507>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc38507() {

		sendText(dwellingChevron.txtYearConstruction, roofYear);
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtRoofMaterialUpdate, roofYear);
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Tile/Metal");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(dwellingChevron.btnNext);
	}

	@And("User checks application dwelling screen, select number of stories, plumbing, electrical and hvac updated dates and finalizes transaction")
	public void user_checks_application_dwelling_screen_selects_number_of_stories_plumbing_electrical_hvac_updated_dates_and_finalizes_transaction() {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnDwelling);
		wait(3);
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		sendText(dwellingChevron.txtPlumbingYearUpdate, plumbingYear);
		sendText(dwellingChevron.txtYearElectrical, plumbingYear);
		sendText(dwellingChevron.txtHvacYearUpdate, plumbingYear);
		click(dwellingChevron.btnSave);
		waitImp(3);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@Then("User validates that DP1 policy has been created successfully and close tabs and completes test <tc38507>")
	public void user_validates_that_dp1_policy_has_been_created_successfully_and_close_tabs_and_completestest_tc38507()
			throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP1 NB policy has been created successfully");
		} else {
			System.out.println("DP1 policy creation failed!");
		}
		closeUnnecessaryTabs();
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Hooks.scenario.log("Test Case Completed!");
	}
}
