package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR429_HO4_As_an_Underwriter_I_would_like_the_ability_to_process_a_rewrite_New_on_Cancelled_NB_policy
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;

	@When("User enters all required information on policy information screen <mtr429>")
	public void User_enters_all_required_information_on_policy_information_screen_mtr429() {
		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "11256 SW 62nd Avenue");
		sendText(quote.txtZipCode, "34476");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters product selection information for HO4 and current effective date <mtr429>")
	public void user_enters_product_selection_information_for_HO4_and_429() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo4);
	}

	@When("User enters all required information on HO4 quote screen <mtr429>")
	public void user_enters_all_required_information_on_ho4_quote_screen_mtr429() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		// sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddMobileHomeInd, ConfigsReader.getProperty("mobilehomeind"));
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Tenant Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		wait(1);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on HO4 dwelling screen <mtr429>")
	public void user_enters_all_required_information_on_ho4_dwelling_screen_mtr429() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		sendText(dwellingChevron.txtCoverageC, "30000");
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnNext);
	}

	@Then("User validates that HO4 policy has been created successfully and takes note of the policy number <mtr429>")
	public void user_validates_that_ho4_policy_has_been_created_successfully_and_akes_note_of_the_policy_number_mtr429()
			throws Exception {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO4 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

	}

	@When("User changes system date to current date <mtr429>")
	public void user_changes_system_date_to_current_date_mtr429() throws Exception {
		ChangeAdminDate_NotInbox(driver, dtf.format(currentDate));
	}

	@And("User sets the effective date as after 1 month from the current date and validates error message <mtr429>")
	public void User_sets_the_effective_date_as_after_1_month_from_the_current_date_and_validates_error_messages_mtr429()
			throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		wait(3);
		click(historyChevron.descriptionbox);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(3);
		click(historyChevron.btnStart);
		reviewChevron.btnProcess.click();
		wait(2);

	}

	@And("User selects Cancellation Type as Insured <mtr429>")
	public void User_selects_cancellation_type_as_Insured_mtr429() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User selects Property Sold as reason <mtr429>")
	public void User_selects_property_sold_as_reason_mtr429() {
		selectDropdownText(historyChevron.ddReason, "Property Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User selects Rewrite-New")
	public void User_selects_RewriteNew() {
		selectDropdownText(dashboard.ddSelectTransaction, "Rewrite-New");
		wait(1);
		click(dashboard.btnSelect);
	}

	@When("User enters all required information on HO4 review screen <mtr429>")
	public void user_enters_all_required_information_on_ho4_review_screen_mtr429() {
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
		selectDropdownText(reviewChevron.ddPaymentType, "None");
		reviewChevron.btnProcess.click();
	}

	@And("User validates Rewrite - New Business <mtr429>")
	public void User_validates_Rewrite_New_Business_mtr429() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_Description"));

		if (validate.getText().equalsIgnoreCase("Rewrite - New Business")) {
			System.out.println("Test passed, HO4 Rewrite - New Business has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(1);
		attachScreenShot(driver);

	}

	@And("User clicks Home Cyber Protection")
	public void User_clicks_Home_Cyber_Protection() {
		wait(1);
		click(dwellingChevron.ddHomeCyberProtectionDwelling);
		wait(1);
	}

	@When("User clicks Forms chevron")
	public void user_clicks_Forms_chevron() throws Exception {
		click(reviewChevron.Forms);
		wait(3);
		attachScreenShot(driver);
	}

	@When("User validates Greeting Letter form is generated")
	public void User_validates_Greeting_Letter_form_is_generated() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Greeting Letter");
		attachScreenShot(driver);
	}

	@When("User validates new coverage is added and displayed")
	public void User_validates_new_coverage_is_added_and_displayed() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Home Cyber Protection");
		attachScreenShot(driver);
	}

}
