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

public class MTR167_Cancel_a_policy_SHO3 extends CommonMethods{

	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String CancellationConfirmForm;
	static String CanCForm_Version;
	static String CanForm_Name;
	static String CanForm_Text1;
	static String CanForm_Text2;
	
	@When("User enters all required information on SC policy information screen <mtr167>")
	public void user_enters_all_required_information_on_sc_policy_information_screen_mtr167() {

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

	@When("User enters SC HO3 product selection information and current date as effective date <mtr167>")
	public void user_enters_sc_ho3_product_selection_information_and_current_date_as_effective_date_mtr167() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 2);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
	}

	@When("User enters all required information on SC HO3 quote screen <mtr167>")
	public void user_enters_all_required_information_on_sc_ho3_quote_screen_mtr167() {
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

	@When("User enters all required information on SC HO3 dwelling screen <mtr167>")
	public void user_enters_all_required_information_on_sc_ho3_dwelling_screen_mtr167() {
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

	@And("User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr167>")
	public void user_validates_that_sc_ho3_policy_has_been_created_successfully_mtr167() throws Exception {

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

	@When("User searches for the policy number <mtr167>")
	public void user_searches_policy_for_mtr167() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}
	@And("User selects Cancellation Type as Non-Pay <mtr167>")
	public void User_selects_cancellation_type_as_NonPay_mtr167() {
		selectDropdownText(historyChevron.ddCancellationType, "Non-Pay");
		wait(2);
	}
	@And("User selects Non-Payment of Premium due to NSF as reason <mtr167>")
	public void User_selects_property_nonpayment_as_reason_mtr167() {
		selectDropdownText(historyChevron.ddReason, "Non-Payment of Premium due to NSF");
		wait(2);
		click(historyChevron.btnAdd);
		wait(2);
	}
	@And("User sets eff date current date minus 1 day and validates error message <mtr167>")
	public void User_sets_eff_date_current_date_minus_1_day_selects_pro_rate_mtr167() throws Exception {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")),dtf.format(currentDate.minusDays(1)));
		selectDropdownText(historyChevron.ddCancelType, "Pro-Rate");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
		click(dashboard.btnStart);
		wait(3);
		verify_AnyfirstText_IsDisplayed(driver, "Transaction Date must be within the policy term");
		click(driver.findElement(By.id("Cancel")));
		wait(2);
	}
	@And("User selects flat as cancel type and process transaction <mtr167>")
	public void User_selects_flat_and_process_transaction_mtr167() {
		sendText(driver.findElement(By.id("TransactionEffectiveDt")),dtf.format(currentDate));
		clickTab(driver.findElement(By.id("CancelTypeCd")));
		selectDropdownText(historyChevron.ddCancelType, "Flat");
		wait(2);
		click(dashboard.btnStart);
		wait(3);
	}
	@And("User validates Policy Status displayed as Cancelled <mtr167>")
	public void User_validates_Policy_Status_displayed_as_Cancelled_mtr167() {
		click(historyChevron.btnHistoryChevron);
		wait(2);

		// Validate status as cancelled
		String policyStatus = driver.findElement(By.id("PolicySummary_TransactionStatus")).getText().toString();
		if (policyStatus.equalsIgnoreCase("Cancelled")) {
			Hooks.scenario.log("Policy Status displays Cancelled as expected.");
		} else {
			Hooks.scenario.log("Policy Status displays as Not cancelled. Test fails!");
		}
	}
	@When("User clicks Policy File Chevron <mtr167>")
	public void user_clicks_policy_file_chevron_mtr167() throws Exception {
		wait(2);
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}
	@Then("User validates Cancellation Confirmation form listed and validates form <mtr167>")
	public void user_validates_Cancellation_Confirmation_form_listed_and_validates_form_mtr167() throws Exception {
		clickOnAnyLink(driver, "Cancellation Confirmation");
		wait(8);
		switchToWindow(driver, "STFile&File");
		CancellationConfirmForm = PdfComparator.makePdf(driver, "CancellationConfirmForm.pdf");
		wait(4);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + CancellationConfirmForm);
		wait(10);
		CanCForm_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanCForm_Version, "AIIC SC CX 06 21");
		CanForm_Name = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanForm_Name, "CANCELLATION CONFIRMATION");
		CanForm_Text1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanForm_Text1,
				"Non-Payment of Premium due to NSF");
		CanForm_Text2 = SmartPDFComparator2.getPDFtextByArea(FileLocation + CancellationConfirmForm, 1, 0, 0, 800,
				800);
		PdfComparator.verifyFormData(driver, CanForm_Text2,
				"Reason(s) for Cancellation:");
		
		Hooks.scenario.log("Test Case Completed!");
	}
}
