package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MTR371_TC33705_MHO_Validate_EndorsementIncreaseCovAChangeDeductible extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime endoDate = currentDate.plusDays(31);
	static String policyNum;
	static String txNum;

	@When("User enters all required information on MHO3 dwelling screen and sets covA as <75000>, ded.perils as <2500>, ded.hurricane as <%10>")
	public void user_enters_all_required_information_on_mho3_dwelling_screen_and_sets_coverage_a_as_75000() {

		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		wait(2);
		sendText(dwellingChevron.txtCoverageA, "75000");
		wait(2);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$2,500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "10%");
		click(dwellingChevron.btnSave);
		wait(2);
		click(reviewChevron.btnReview);
		wait(2);
	}
	@When("User enters all required information on policy information screen <mtr371>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr371() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "1163 Oak Bluff Dr");
		sendText(quote.txtZipCode, "33837");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on MHO3 quote screen with prior exp date as current date <mtr371>")
	public void user_enters_all_required_information_on_mho3_quote_screen_with_prior_exp_date_as_current_date_mtr371() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "Avatar");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		click(policyChevron.btnPropertyTypePri);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "12");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}
	@And("User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr371>")
	public void User_verifies_NB_MHO3_policy_has_been_created_successfully_for_mtr371() throws Exception {
		String expected = "New Business";
		String actual = historyChevron.txtNewBusiness.getText();
		Assert.assertEquals("NB MHO3 policy has been created successfully!", expected, actual);
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

	@When("User changes system date to current date plus 31 days")
	public void user_changes_system_date_to_currendate_plus_31days() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(endoDate));
		wait(1);
	}

	@When("User searches for the policy number <mtr371>")
	public void user_searches_for_the_policy_number_mtr371() throws Exception {
		setPolicyNumSearch(driver, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as currend date plus 31 days and starts endorsement")
	public void User_sets_new_effective_date_as_endorsement_date_and_starts_endorsement() {
		wait(2);
		sendText(historyChevron.txtEffectiveDate, dtf.format(endoDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks Policy Chevron")
	public void user_clicks_policy_chevron() throws Exception {
		click(policyChevron.btnPolicyChevronLink);
		wait(2);
	}

	@When("User changes entity type as joint and enters required information")
	public void user_changes_entity_type_as_joint_and_enters_required_information() throws Exception {
		selectDropdownText(policyChevron.ddEntity, "Joint");
		wait(2);
		sendText(policyChevron.txtJointFirstName, "Mary");
		sendText(policyChevron.txtJointLastName, "Smith");
		sendText(policyChevron.txtJointBirthDay, "01/01/1960");
		selectDropdownText(policyChevron.ddJointMaritalStatus, "Married");
		click(dwellingChevron.btnSave);
	}

	@When("User clicks Dwelling Chevron <mtr371>")
	public void user_clicks_dwelling_chevron_mtr371() throws Exception {
		click(dwellingChevron.btnDwelling);
		wait(3);
	}

	@When("User updates MHO3 dwelling screen and sets covA as <175000>, ded.perils as <500>, ded.hurricane as <500>")
	public void user_updates_on_mho3_dwelling_screen_and_sets_coverage_a_as_175000() {

		sendText(dwellingChevron.txtCoverageA, "175000");
		wait(2);
		scrollToElement(dwellingChevron.ddDeductibleAllPerils);
		selectDropdownText(dwellingChevron.ddDeductibleAllPerils, "$500");
		selectDropdownText(dwellingChevron.ddHurricaneDeductible, "$500");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User finalizes transaction and validates updated changes messages on closeout screen for <mtr371>")
	public void user_finalizes_transaction_and_validates_updated_changes_messages_on_closeout_screen_for_mtr371()
			throws Exception {
		click(dwellingChevron.btnFinalize);
		wait(2);
		attachScreenShot(driver);
		verify_AnyText_IsVisible(driver, "Change of Insured Name Must Be Approved ");
		verify_AnyText_IsVisible(driver, "Change to Coverage A Limit requires underwriting approval. ");
	}

	@When("User takes note of the application for <mtr371>")
	public void user_takes_note_of_the_application__number_for_mtr371() throws Exception {
		try {
			txNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + txNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the last application number")
	public void user_searches_for_the_last_application_number() throws Exception {
		setPolicyNumSearch(driver, txNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates 'Change of Insured Name Must Be Approved' and 'Change to Coverage A Limit requires underwriting approval.' texts have been displayed")
	public void user_validates_texts_have_been_displayed() throws Exception {
		verify_AnyText_IsVisible(driver,"Change of Insured Name Must Be Approved ");
		verify_AnyText_IsVisible(driver,"Change to Coverage A Limit requires underwriting approval. ");
		attachScreenShot(driver);
	}

	@When("User process and completes endorsement <mtr371>")
	public void user_process_and_completes_endorsement_mtr371() throws Exception {
		click(closeoutChevron.btnEndorsePolicy);
		wait(6);
		getPolicyNumber(driver);
		closeUnnecessaryTabs();
	}

	@When("User clicks Expand button and validates actual messages have been matched with expected and completes test")
	public void user_clicks_expand_and_completes_validations_and_completes_test() throws Exception {
		click(historyChevron.btnExpand);
		wait(1);
		verify_AnyLabel_IsVisible(driver, "Insured Name Change");
		verify_AnyLabel_IsVisible(driver, "Deductible Change: All Other Perils Changed From $2,500 to $500");
		verify_AnyLabel_IsVisible(driver, "Deductible Change: Hurricane Changed From 10% to $500");
		verify_AnyLabel_IsVisible(driver, "Coverage Modified: A - Dwelling Limit 1 Changed From $75,000 to $175,000");
		Hooks.scenario.log("Test Case Completed!");
	}
}
