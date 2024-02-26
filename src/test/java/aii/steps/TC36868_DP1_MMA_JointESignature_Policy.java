package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC36868_DP1_MMA_JointESignature_Policy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen as joints <tc36868>")
	public void user_enters_all_required_information_on_policy_information_screen_as_joints_tc36868() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Smith");
		sendText(quote.txtBirthDate, "5/23/1985");
		sendText(quote.txtJointFirstName, "Mary");
		sendText(quote.txtJointLastName, "Smith");
		sendText(quote.txtJointBirthday, "8/23/1978");
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1114 E Patterson St");
		sendText(quote.txtZipCode, "33604");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on DP1 quote screen <tc36868>")
	public void user_enters_all_required_information_on_dp1_quote_screen_tc36868() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
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
	@When("User enters all required information on DP1 dwelling screen <tc36868>")
	public void user_enters_all_required_information_on_dp1_dwelling_screen_tc36868() throws Exception {
		
		String[] MMA = {"Select...", "Yes", "No"};
		verifyAnyDropDownOptions(driver, MMA, "BuildingExt.MMAInd");
		
		sendText(dwellingChevron.txtYearConstruction, "2022");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "Yes");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		verify_AnyText_IsVisible(driver, "Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days");
		click(dwellingChevron.btnNext);
	}
	@And("User sets Number of Stories as 3 and validates 'Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days' message visible")
	public void user_sets_Number_of_stories_as_3_and_validates_error_message_tc36868() throws Exception {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnDwelling);
		wait(2);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_IsVisible(driver, "Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days");
		click(reviewChevron.btnFinalize);
		wait(2);
	}
	@When("User sets Esignature and validates first 2 signer fields have been enabled and not editable, 3rd one enabled and editable <tc36868>")
	public void user_sets_esignature_and_validates_3_signer_fields_have_Been_enabled_tc36868() throws Exception {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(3);
		verify_AnyText_IsVisible(driver, "Premium amount includes Mandatory Mediation-Arbitration discount. Signed acknowledgement must be attached to policy in SPIN within 15 days");
		selectDropdownText(closeoutChevron.ddEsignature, "Yes");
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_1_Include");
		verifyAnyCoverageCheckbox_NotEnabledSelected(driver, "Signer_2_Include");
		verifyAnyCoverageCheckbox_EnabledSelected(driver, "Signer_3_Include");
		sendText(driver.findElement(By.id("Signer_1_EmailAddr")), "cyavas@aiiflorida.com");
		sendText(driver.findElement(By.id("Signer_2_EmailAddr")), "mcemek@aiiflorida.com");	
	}
	@When("User clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>")
	public void user_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed_tc36868()
			throws Exception {

		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}
	@When("User inputs just Signer 1 First Name and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>")
	public void user_inputs_just_signet1_first_name_and_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed_tc36868()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_GivenName")), "Harry");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}
	@When("User inputs Signer 1 Last Name and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>")
	public void user_inputs_signer1_last_name_and_clicks_issue_new_business_button_and_validates_Missing_required_information_text_has_been_displayed_tc36868()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_Surname")), "Crunch");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}
	@When("User inputs same email address which previously entered and clicks issue new business button and validates 'Email address must be different for each Signer. Please update email address' text has been displayed <tc36868>")
	public void user_inputs_same_email_address_which_previously_entered__and_clicks_issue_new_business_button_and_validates_email_address_must_be_different_for_each_signer_text_has_been_displayed_tc36868()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_EmailAddr")), "cyavas@aiiflorida.com");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver,
				"Email address must be different for each Signer. Please update email address.");
	}
	@When("User inputs 3rd email address and clicks issue new business button and validates 'Missing required information' text has been displayed <tc36868>")
	public void user_inputs_3rd_email_address_and_clicks_issue_new_business_button_and_validates_missing_required_information_text_has_been_displayed_tc36868()
			throws Exception {
		sendText(driver.findElement(By.id("Signer_3_EmailAddr")), "aiicmodel@aiiflorida.com");
		click(closeoutChevron.btnIssueNB);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Missing Required Information");
		scrollToAnyField(driver, "Cash With Application");
		attachScreenShot(driver);
	}
	@And("User inputs license number and clicks issue new business button and issues policy <tc36868>")
	public void user_inputs_license_number_and_clicks_issue_new_business_button_and_issues_policy_tc36868() throws Exception {

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
	@Then("User clicks ESignature Tab and do validations for expected buttons, labels, texts <tc36868>")
	public void user_clicks_ESignature_Tab_tc36868() throws Exception {
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
