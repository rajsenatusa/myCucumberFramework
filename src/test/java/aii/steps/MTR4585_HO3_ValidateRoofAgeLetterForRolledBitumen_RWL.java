package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4585_HO3_ValidateRoofAgeLetterForRolledBitumen_RWL extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime currentDate2 = LocalDateTime.now();
	static int cYear = currentDate2.getYear();
	static int rYear = cYear - 9;
	static String roofYear = String.valueOf(rYear);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String totalDue;
	static String PolicyNumberTerm02;
	static String roofage_Form;
	static String roofage_Form_data;
	static String totalDueRenewal;

	@When("User enters all required information on policy information screen <tc36681>")
	public void user_enters_all_required_information_on_policy_information_screen_tc36681() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "John");
		sendText(quote.txtLastName, "Richards");
		sendText(quote.txtBirthDate, "10/05/1984");
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

	@When("User enters all required information on HO3 quote screen <tc36681>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc36681() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		wait(1);
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		wait(1);
		click(dwellingChevron.btnSave);
		waitImp(4);
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
		sendText(policyChevron.txtPhoneNumber, "555-444-5555");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User enters all required information on HO3 dwelling screen and select bitumen roof and  basic reserve package <tc36681>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc36681() {
		// Quote Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Rolled/Bitumen");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.rbBasicPackage);
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron <tc36681>")
	public void user_completes_required_information_on_dwelling_chevron_tc36681() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Rolled/Bitumen");
		selectDropdownText(dwellingChevron.ddNumberOfStories, "2");
		click(dwellingChevron.rbWindHailExc);
		sendText(dwellingChevron.txtRoofMaterialUpdate, roofYear);
		click(dwellingChevron.btnSave);
		wait(2);
	}

	@And("User clicks Finalize button <tc36681>")
	public void User_clicks_Finalize_button_tc36681() {
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc36681>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc36681()
			throws Exception {

		waitImp(5);
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("HO3 NB policy has been created successfully");
		} else {
			System.out.println("HO3 NB policy creation failed!");
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
	}

	@When("User clicks Make Payment and selects credit card and enters due amount <tc36681>")
	public void user_clicks_make_payment_and_selects_cc_tc36681() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(closeoutChevron.rbNewCreditCard);
		wait(1);
		totalDue = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDue);
		wait(4);
	}

	@When("User makes payment with Credit Card for <tc36681>")
	public void user_makes_payment_with_credit_card_tc36681() throws Exception {
		makeCCPayment();

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User renew policy to the next term through batch jobs")
	public void user_renew_policy_to_the_next_term_through_batch_jobs() throws Exception {
		PolicyNumberTerm02 = runAutoRenewPolicy(driver, policyNum, "01", "02");

		click(policyChevron.btnPolicyChevronLink);
		wait(4);
	}

	@When("User clicks Policy File Chevron <tc36681>")
	public void user_clicks_policy_file_chevron_tc36681() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@When("User validates Roof Age Renewal Letter is visible and validates form version")
	public void user_validates_Roof_Age_Renewal_letter_is_visible_and_validates_form_version() throws Exception {
		verifyLetterForm(driver, "Roof Age Renewal Letter");

		attachScreenShot(driver);

		clickOnAnyPolicyFileTabForm(driver, "Roof Age Renewal Letter");
		wait(7);
		switchToWindow(driver, "STFile&File");

		roofage_Form = PdfComparator.makePdf(driver, "RoofAgeRenewalLetter.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + roofage_Form);

		wait(10);
		// Dec page
		roofage_Form_data = SmartPDFComparator2.getPDFtextByArea(FileLocation + roofage_Form, 1, 0, 0, 690, 720);
		PdfComparator.verifyFormData(driver, roofage_Form_data, "According to our records, your roof will reach the");
		PdfComparator.verifyFormData(driver, roofage_Form_data, "year mark next year. Roofs of this age, especially");
		PdfComparator.verifyFormData(driver, roofage_Form_data,
				"Roof condition is an important factor that we take into consideration as part of the underwriting process");

	}

	@When("User clicks Make Payment and do renewal payment <tc36681>")
	public void user_clicks_make_payment_and_do_renewal_payment_tc36681() {
		click(closeoutChevron.btnMakePaymentHolder);
		wait(3);
		click(closeoutChevron.btnSubmitPaymentHolder);
		wait(3);
		click(driver.findElement(By.id("PaymentTypeCd_1"))); // pay with existing credit card
		wait(1);
		totalDueRenewal = driver.findElement(By.id("ARSummary_TotalDue")).getText().toString();
		wait(2);
		sendText(closeoutChevron.txtEnterAmountBox, totalDueRenewal);
		wait(4);

		click(driver.findElement(By.id("SubmitPayment")));
		wait(1);
		click(driver.findElement(By.id("dialogOK")));
		wait(10);

		// Close unnecessary tabs
		closeUnnecessaryTabs();
	}

	@When("User renew policy to the third term through batch jobs")
	public void user_renew_policy_to_the_third_term_through_batch_jobs() throws Exception {
		runAutoRenewPolicy(driver, PolicyNumberTerm02, "02", "03");
	}

	@Then("User validates Roof Letter is visible and completes test")
	public void user_validates_roof_letter_is_visible_and_completes_test() throws Exception {
		verifyInstallmentInvoiceForm(driver, "Roof Age Renewal Letter");
		attachScreenShot(driver);
		Hooks.scenario.log("Test Case Completed!");
	}
	
}
