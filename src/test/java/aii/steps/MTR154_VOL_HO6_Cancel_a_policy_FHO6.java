package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR154_VOL_HO6_Cancel_a_policy_FHO6 extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancellationConfirmForm;
	static String CanConForm_Version;
	static String CanConForm_Name;
	static String CanForm_Text1;
	static String CanForm_Text2;

	@When("User enters HO3 product selection information and current date as effective date <mtr154>")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date_mtr154() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}

	@When("User enters all required information on HO6 quote screen <mtr154>")
	public void user_enters_all_required_information_on_ho6_quote_screenmtr154() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		wait(3);
		click(policyChevron.btnSave);
		wait(2);
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		wait(3);
		click(policyChevron.btnNext);
		wait(3);
	}

	@And("User validates that HO6 policy has been created successfully and take note of the policy number <mtr154>")
	public void user_validates_that_sc_ho6_policy_has_been_created_successfully_mtr154() throws Exception {

		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO6 NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
		wait(5);
		getPolicyNumber(driver);

		getInForcePremium(driver);
		getInForcePremiumFees(driver);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
		Hooks.scenario.log("New Business HO6 policy has been created successfully");
		attachScreenShot(driver);

		// taking note of the issued policy
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the policy number <mtr154>")
	public void user_searches_policy_for_mtr154() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User selects Cancellation Type as Insured <mtr154>")
	public void User_selects_cancellation_type_as_Insured_mtr154() {
		selectDropdownText(historyChevron.ddCancellationType, "Insured");
		wait(2);
	}

	@And("User selects Property Sold as reason <mtr154>")
	public void User_selects_property_sold_as_reason_mtr154() {
		selectDropdownText(historyChevron.ddReason, "Property Sold");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}

	@And("User sets the effective date as before 1 day from the current date and validates error message <mtr154>")
	public void User_sets_the_effective_date_as_before_1_days_from_the_current_date_and_validates_error_messages_mtr154()
			throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.minusDays(1)));
		wait(3);
		click(historyChevron.descriptionbox);
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(3);
		click(historyChevron.btnStart);
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Date must be within the policy term");
		attachScreenShot(driver);
		wait(2);
		click(driver.findElement(By.id("Cancel")));
		wait(2);

	}

	@And("User sets the effective date as after 30 days from the current date and validates messages <mtr154>")
	public void User_sets_the_effective_date_after_30_days_from_the_current_date_and_validates_error_messages_mtr154()
			throws Exception {

		sendText(driver.findElement(By.id("TransactionEffectiveDt")), dtf.format(currentDate.plusDays(30)));
		clickTab(driver.findElement(By.id("CancelTypeCd")));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Closeout");
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Request");
		verify_AnyfirstText_IsDisplayed(driver, "Output Pending");
		verify_AnyfirstText_IsDisplayed(driver, "Process");
		verify_AnyfirstText_IsDisplayed(driver, "Preview Output");
		verify_AnyfirstText_IsDisplayed(driver, "Modify Application");
		wait(8);
		click(dashboard.btnProcess);

	}

	@And("User validates Policy Status displayed as Canceled <mtr154>")
	public void User_validates_Policy_Status_displayed_as_Canceled_mtr154() throws Exception {
		verify_AnyfirstText_IsDisplayed(driver, "Cancelled");
		Hooks.scenario.log("Policy Cancel Completed!");
		attachScreenShot(driver);
	}

	@When("User clicks Policy File Chevron <mtr154>")
	public void user_clicks_policy_file_chevron_mtr154() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User validates Cancellation Confirmation form listed and validates form <mtr154>")
	public void user_validates_Cancellation_Confirmation_form_listed_and_validates_form_mtr154() throws Exception {
		clickOnAnyLink(driver, "Cancellation Confirmation");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancellationConfirmForm = PdfComparator.makePdf(driver, "CancellationConfirmForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancellationConfirmForm);
		wait(10);
		CanConForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanConForm_Version, "AIIC CX 11 14");
		CanConForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanConForm_Name, "CANCELLATION CONFIRMATION");
		Hooks.scenario.log("Test Case Completed!");
	}

}
