package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC15207_HO3_Joint_ESignature_Policy extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters all required information on policy information screen as joints <tc15207>")
	public void user_enters_all_required_information_on_policy_information_screen_as_joints_tc15207() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Smith");
		sendText(quote.txtBirthDate, "5/23/1985");
		sendText(quote.txtJointFirstName, "Mary");
		sendText(quote.txtJointLastName, "Smith");
		sendText(quote.txtJointBirthday, "8/23/1978");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11216 SW PEMBROKE DR");
		sendText(quote.txtZipCode, "34987");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters HO3 product selection information and current date as effective date <tc15207>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_tc15207() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User starts transaction as a new customer as joint")
	public void user_starts_transaction_as_a_new_customer_as_joint() {

		wait(4);
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(4);
		dashboard.btnNewQuote.click();
		selectDropdownText(driver.findElement(By.id("Customer.EntityTypeCd")), "Joint");
	}

	@When("User enters all required information on HO3 quote screen <tc15207>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc15207() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		// click(dwellingChevron.btnSave);
		// waitImp(5);
		getInsuranceScore(driver, "Neutral");
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
	}

	@When("User enters all required information on HO3 dwelling screen <tc15207>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc15207() {

		sendText(dwellingChevron.txtSquareFeet, "1500");
		// selectDropdownText(dwellingChevron.bCEG, "4");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		// selectDropdownText(dwellingChevron.ddDistanceToCoast, "5 mi to less than 10
		// mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2022");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(4);
		selectDropdownText(dwellingChevron.ddDeductibleWindHail, "$15,000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		waitImp(3);
	}

	@When("User completes required information on dwelling chevron selects Dwelling Type <tc15207>")
	public void user_completes_required_information_on_dwelling_chevron_selects_dwelling_type_tc15207()
			throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <tc15207>")
	public void User_clicks_Finalize_button_tc15207() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@When("User sets Esignature and validates 3 signer fields have been enabled")
	public void user_sets_esignature_and_validates_3_signer_fields_have_Been_enabled() throws Exception {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
		selectDropdownText(closeoutChevron.ddEsignature, "Yes");
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_1_Include");
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_2_Include");
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Signer_3_Include");
		sendText(driver.findElement(By.id("Signer_1_EmailAddr")), "cyavas@aiiflorida.com");
		sendText(driver.findElement(By.id("Signer_2_EmailAddr")), "mcemek@aiiflorida.com");
		// click(closeoutChevron.btnIssueNB);
		// wait(12);
	}

	@When("User clicks issue new business button and validates 'Missing required information' text has been displayed")
	public void user_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed()
			throws Exception {

		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}

	@When("User inputs just Signer 1 First Name and clicks issue new business button and validates 'Missing required information' text has been displayed")
	public void user_inputs_just_signet1_first_name_and_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_GivenName")), "Harry");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}

	@When("User inputs Signer 1 Last Name and clicks issue new business button and validates 'Missing required information' text has been displayed")
	public void user_inputs_signer1_last_name_and_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_Surname")), "Crunch");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}

	@When("User inputs same email address which previously entered and clicks issue new business button and validates 'Email address must be different for each Signer. Please update email address' text has been displayed")
	public void user_inputs_same_email_address_which_previously_entered__and_clicks_issue_new_business_button_and_validates_email_address_must_be_different_for_each_signer_text_has_been_displayed()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_EmailAddr")), "cyavas@aiiflorida.com");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver,
				"Email address must be different for each Signer. Please update email address.");
	}

	@When("User inputs 3rd email address and clicks issue new business button and validates 'Missing required information' text has been displayed")
	public void user_inputs_3rd_email_address_and_clicks_issue_new_business_button_and_validates_missing_required_information_text_has_been_displayed()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_EmailAddr")), "aiicmodel@aiiflorida.com");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}

	@And("User inputs license number and clicks issue new business button and issues policy")
	public void user_inputs_license_number_and_clicks_issue_new_business_button_and_issues_policy() throws Exception {

		sendText(driver.findElement(By.id("Signer_3_LicenseNumber")), "AGENT007");
		click(closeoutChevron.btnIssueNB);
		wait(13);
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
	}
	@When("User clicks ESignature Tab and do validations for expected buttons, labels, texts")
	public void user_clicks_ESignature_Tab()
			throws Exception {
		clickonAnyButton(driver, "Tab_ESignature");
		wait(10);
		verify_AnyfirstText_IsDisplayed(driver, "Cancel");
		verify_AnyButton_IsVisible(driver, "Refresh");
		clickonAnyButton(driver, "Tab_ESignature");
		wait(5);
		verify_JointLabels_IsDisplayed(driver, "Refresh");
		verify_AnyfirstText_IsDisplayed(driver, "Sent");
		verify_JointLabels_IsDisplayed(driver, "Sent");
		verify_AnyText_IsVisibleMultipletimes(driver, "Sent", "4");
		
		verify_AnyText_IsVisible(driver, "cyavas@aiiflorida.com");
		verify_AnyText_IsVisible(driver, "mcemek@aiiflorida.com");
		verify_AnyText_IsVisible(driver, "aiicmodel@aiiflorida.com");
		
		driver.findElement(By.id("Tab_Documents")).click();
		wait(1);
		verify_AnyText_NotVisible(driver, "Application (e-signed)");
		Hooks.scenario.log("Test Case Completed!");
	}
}
