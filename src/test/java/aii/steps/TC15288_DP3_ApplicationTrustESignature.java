package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC15288_DP3_ApplicationTrustESignature extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY);
	static String policyNum;

	@When("User enters all required information on policy information screen <tc15288>")
	public void user_enters_all_required_information_on_policy_information_screen_tc15288() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "9155 Seafail Ln");
		sendText(quote.txtZipCode, "32317");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters DP3 product selection information and effective date as current date <tc15288>")
	public void user_enters_dp3_product_selection_information_and_effective_date_as_current_date_tc15288() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionDp3);
	}

	@When("User enters all required information on DP3 quote screen <tc15288>")
	public void user_enters_all_information_onQuote_screen_tc15288() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		// sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		// click(dwellingChevron.btnSave);
		// wait(3);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		sendText(policyChevron.emailAddr, "mcemek@aiiflorida.com");
		//click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Masonry Veneer");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		click(dwellingChevron.btnSave);
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen <tc15288>")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_tc15288() {

		// selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10
		// mi");
		sendText(dwellingChevron.txtSquareFeet, "3000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Concrete/Clay Tile");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtPersonalPropertyC, "12000");
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@And("User updates plumbing,electrical,hvac years as current year and validates roof material <tc15288>")
	public void User_updates_plumbing_electrical_hvac_years_as_current_year_tc15288() throws Exception {

		click(dwellingChevron.btnDwelling);
		click(dwellingChevron.btnSave);
		wait(3);
		verifyAnyDropdownDefaultedValue(driver, "Building.RoofMaterial", "Concrete/Clay Tile");
		sendText(dwellingChevron.txtHvacYearUpdate, currentYear);
		sendText(dwellingChevron.txtPlumbingYearUpdate, currentYear);
		sendText(dwellingChevron.txtYearElectrical, currentYear);
		click(dwellingChevron.btnSave);
		wait(3);
	}
	@When("User finalizes transaction for <tc15288>")
	public void user_finalizes_transaction_for_tc15288() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User sets payment type and sets E-signature and do validations <tc15288>")
	public void user_sets_payment_type_and_sets_e_signature_and_do_validations_tc15288() throws Exception {
		verify_AnyText_IsVisible(driver, "eSignature?*");
		verifyAnyDropdownDefaultedValue(driver, "eSignatureInd", "No");	
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		selectDropdownText(closeoutChevron.ddEsignature, "Yes");
		wait(1);
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_1_Include");
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Signer_3_Include");
	}
	@When("User enters Agent Details for E-signature")
	public void user_enters_Agent_Details_for_ESignature() throws Exception {
		sendText(closeoutChevron.txtAgentFirstName, "Gregg");
		sendText(closeoutChevron.txtAgentLastName, "Loomis");
		sendText(closeoutChevron.txtAgentEmail, "cyavas@aiiflorida.com");
		sendText(closeoutChevron.txtAgentLicenseNumber, "Agent098");
	}
	@When("User validates that DP3 policy has been created successfully and takes note of policy number <tc15288>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_tc15288()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("DP3 NB policy has been created successfully");
			getPolicyNumber(driver);
			getInForcePremium(driver);
			getInForcePremiumFees(driver);

		} else {
			System.out.println("DP3 policy creation has been failed!");

		}
		getPolicyNumber(driver);
		getInForcePremium(driver);
		getInForcePremiumFees(driver);
		closeUnnecessaryTabs();

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User validates Cancel label and Refresh and Sent button is visible")
	public void user_validates_cancel_label_and_refresh_And_sent_button_visible_tc15288() throws Exception {
		click(driver.findElement(By.id("Tab_ESignature")));
		wait(3);
		verify_AnyLabel_IsVisible(driver, "Cancel");
		verify_AnyfirstText_IsDisplayed(driver, "Refresh");
		verify_AnyfirstText_IsDisplayed(driver, "Sent");
		verify_JointLabels_IsDisplayed(driver, "Sent");
		click(driver.findElement(By.id("Tab_ESignature")));
		wait(3);
		click(policyFileChevron.btnPolicyFilePage);
		wait(3);
		verify_AnyText_NotVisible(driver, "Application (e-signed)");	
		Hooks.scenario.log("Test Case Completed!");
	}
}
