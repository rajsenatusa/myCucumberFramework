package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4724_IM425_SC_NB_Validate_UW_User_can_able_to_overide_address_on_SC_Policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	
	@When("User enters wrong address SC policy quote screen and validates error message and clicks ignore address validation <mtr4724>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr4724() throws Exception {

		sendText(policyChevron.txtProducerCodeSel, "AG1777A1");
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, "Amica");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddEntity,"Individual");
		wait(1);
		sendText(quote.txtGivenName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtSurname, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtPersonalBirthDt, ConfigsReader.getProperty("birthdate"));
		click(quote.btnReset);
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");
		sendText(quote.txtAddressNumber, "1779");
		sendText(quote.txtStreet, "Moonseed Dr, Longs");
		sendText(quote.txtCity, "Horry");
		sendText(quote.txtCounty, "Horry");
		sendText(quote.txtPostalCode, "29568");
		wait(2);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);	
		click(quote.btnVerifyAddress2);
		wait(1);
		attachScreenShot(driver);  //takes screenshot of error message
		clickOKDailogButton(driver);
		click(driver.findElement(By.id("BasicPolicy.ValidateAddrIgnoreInd"))); //user clicks ignore address validation
		click(dwellingChevron.btnSave);
		wait(2);
		clickNewCustomer(driver);
		click(policyChevron.btnNext);
	}
	@When("User clicks New Quote selects Product Line and Eff date as current date")
	public void user_clicks_New_Quote_selects_Product_Line_and_Eff_date_as_current_date() throws Exception {

		click(dashboard.lnkNewQuote);
		sendText(dashboard.txtEffectiveDate, dtf.format(currentDate));
		selectDropdownText(dashboard.ddState, "South Carolina");
		click(dashboard.btnNewQuoteStart);
		wait(1);
		clickOnAnyLink(driver,"Voluntary Homeowners (HO3)");
		wait(2);
	}
	@When("User enters all required information on SC HO3 dwelling screen <mtr4724>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr4724() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "2000");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3-tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddWoodBurningStone, "No");
		selectDropdownText(dwellingChevron.ddFireAlarm, "None");
		selectDropdownText(dwellingChevron.ddBurglarAlarm, "None");
		selectDropdownText(dwellingChevron.ddSecuredCommunity, "None");
		selectDropdownText(dwellingChevron.ddOpeningProtection, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	@Then("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr4724>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr4724() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		// Close unnecessary tabs
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
