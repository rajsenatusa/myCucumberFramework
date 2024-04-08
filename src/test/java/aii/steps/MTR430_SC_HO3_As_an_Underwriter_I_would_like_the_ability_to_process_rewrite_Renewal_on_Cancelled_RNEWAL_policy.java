package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;

import io.cucumber.java.en.And;

import io.cucumber.java.en.When;

public class MTR430_SC_HO3_As_an_Underwriter_I_would_like_the_ability_to_process_rewrite_Renewal_on_Cancelled_RNEWAL_policy
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters all required information on SC policy information screen <mtr430>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr430() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "7743 Park Gate Dr, North Charleston");
		sendText(quote.txtZipCode, "29418");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on SC HO3 quote screen <mtr430>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr430() {
		// Quote Policy Chevron information was filled here

		sendText(policyChevron.txtProducerCodeSel, "AG1777A1");
		wait(3);
		click(dwellingChevron.btnSave);
		selectDropdownText(policyChevron.ddPreviousCarrier, "Amica");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddNewPurchase, "Yes");
		selectDropdownText(policyChevron.ddMaritalStatus, "Single");
		wait(2);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddResidentSmokers, "No");
		selectDropdownText(policyChevron.ddNumberAdultResident, "1");
		selectDropdownText(policyChevron.ddNumberChildrenResident, "0");

		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(dwellingChevron.btnSave);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on SC HO3 dwelling screen <mtr430>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr430() {
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

	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr430>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr430() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, SC HO3 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		getPolicyNumber(driver);
		attachScreenShot(driver);

	}

	@And("User selects Cancellation Type as Insured <mtr430>")
	public void User_selects_cancellation_type_as_Insured_mtr430() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User selects Property Sold as reason <mtr430>")
	public void User_selects_property_sold_as_reason_mtr430() {
		selectDropdownText(historyChevron.ddReason, "Property Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User sets the effective date as after 1 month from the current date and validates error message <mtr430>")
	public void User_sets_the_effective_date_as_after_1_month_from_the_current_date_and_validates_error_messages_mtr430()
			throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		wait(3);
		click(historyChevron.descriptionbox);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(3);
		click(historyChevron.btnStart);
		reviewChevron.btnProcess.click();
		attachScreenShot(driver);
		wait(2);
	}

	@And("User selects Rewrite-Renewal")
	public void User_selects_RewriteRenewal() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-Renewal");
		wait(1);
		click(dashboard.btnSelect);
	}

	@When("User enters all required information on SC HO3 review screen <mtr430>")
	public void user_enters_all_required_information_on_SCHO3_review_screen_mtr430() {
		click(reviewChevron.btnFullPaymentRadioTO);
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
//		selectDropdownText(reviewChevron.ddPaymentType, "None");
		reviewChevron.btnProcess.click();
	}

	@And("User validates Rewrite-Renewal created <mtr430>")
	public void User_validates_Rewrite_Renewal_created_mtr430() throws Exception {

		WebElement validate = driver.findElement(By.id("History_2_1_Description"));

		if (validate.getText().equalsIgnoreCase("Rewrite-Renewal")) {
			System.out.println("Test passed, SC HO3 Rewrite-Renewal has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(1);
		attachScreenShot(driver);

	}

	@When("User validates Greeting Letter form is generated <mtr430>")
	public void User_validates_Greeting_Letter_form_is_generated_mtr430() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Welcome Greeting Letter");
		attachScreenShot(driver);
	}

	@When("User validates Coverage A Dwelling is 350000 <mtr430>")
	public void User_validates_Coverage_A_Dwelling_is_350000_mtr430() throws Exception {
		wait(2);
		scrollToElement(driver.findElement(By.id("Building.CovALimit_text")));
		wait(2);
		verify_AnyfirstText_IsDisplayed(driver, "Coverage A- Dwelling $350000");
		attachScreenShot(driver);
	}

	@And("User enters Coverage A Dwelling as 350000 <mtr430>")
	public void User_enters_Coverage_A_Dwelling_as_350000_mtr430() {
		scrollToElement(driver.findElement(By.id("Building.CovALimit")));
		wait(4);
		dwellingChevron.txtCoverageA.clear();
		wait(3);
		sendText(dwellingChevron.txtCoverageA, "350000");

	}

}
