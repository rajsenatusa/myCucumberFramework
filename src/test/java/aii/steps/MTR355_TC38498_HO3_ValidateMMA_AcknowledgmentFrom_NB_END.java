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
import io.cucumber.java.en.When;

public class MTR355_TC38498_HO3_ValidateMMA_AcknowledgmentFrom_NB_END extends CommonMethods {

	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String application_Form;
	static String policyNum;
	static String MMA_NBApp_Version1;
	static String MMA_NBApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_NBApp_Data;

	@When("User enters all required information on HO3 dwelling screen with MMA selected as Yes")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_with_mma() {
		// Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, "2023");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Metal");
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		click(dwellingChevron.btnSave);
		wait(4);
		click(dwellingChevron.btnNext);
		wait(3);
	}

	@When("User answers all underwriting questions for VOL HO3")
	public void user_answers_all_underwriting_questions_for_vol_ho3() throws Exception {
		fillHO3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}

	@When("User validates MMA dropdown defaulted to yes and sets dwelling type")
	public void user_validates_MMA_is_available_and_sets_dwelling_type() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "Yes");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(2);
	}

	@And("User clicks on on the application and validate the MMA acknowledge form 'AIIC HO3 MMAA 03 22' attached in the application form")
	public void user_clicks_on_on_the_application_and_validate_the_mma_acknowledge_form_attached_in_the_application_form()
			throws Exception {

		click(policyFileChevron.btnApplicationForm);
		wait(2);
		switchToWindow(driver, "STFile&File");
		application_Form = PdfComparator.makePdf(driver, "Application.pdf");

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + application_Form);
		wait(8);

		MMA_NBApp_Version1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 10, 400, 0, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version1, "AIIC HO3 MMAA 04 23");
		MMA_NBApp_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 9, 70, 740, 200, 50);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Version, "AIIC HO3 MMAA 04 23");
		PolicyNumberSuffix = replaceMethod(policyNum, "-01", "");
		MMA_NBApp_Data = SmartPDFComparator2.getPDFtextByArea(FileLocation + application_Form, 10, 70, 300, 500, 500);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, PolicyNumberSuffix);
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "1163 Oak Bluff DR");
		PdfComparator.verifyFormData(driver, MMA_NBApp_Data, "Davenport, FL 33837-3688");
		clickApplicationTab(driver);
		wait(1);
	}

	@When("User searches for the policy number <mtr355>")
	public void user_searches_policy_for_mtr355() {
		sendText(dashboard.txtSearchBar, policyNum);
		click(dashboard.search);
		wait(3);
	}

	@And("User sets new effective date as current date and starts endorsement <mtr355>")
	public void User_sets_new_effective_date_as_current_date_and_starts_endorsement_mtr355() {
		sendText(historyChevron.txtEffectiveDate, dtf.format(currentDate));
		wait(2);
		click(historyChevron.btnStart);
		wait(4);
		click(historyChevron.btnStart);
		wait(4);
	}

	@When("User clicks dwelling chevron <mtr355>")
	public void user_clicks_dwelling_chevron_mtr355() {
		click(specialChevron.btnDwellingWiz);
		wait(2);
	}

	@When("User validates MMA defaulted to Yes <mtr355>")
	public void user_validates_MMA_defaulted_to_yes_mtr355() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "Yes");
	}

	@When("User enters all required information on policy information screen <mtr355>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr355() {

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

	@When("User enters HO3 product selection information and current date as effective date")
	public void user_enters_ho3_product_selection_information_and_current_date_as_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(currentDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}

	@When("User enters all required information on HO3 quote screen <mtr355>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr355() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdown(policyChevron.ddInsuranceScoreDd, 3);
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

	@And("User finalizes transaction for VOL HO3")
	public void user_finalizes_transaction_for_VOL_HO3() {
		// Application Dwelling information was filled here
		click(dwellingChevron.btnSave);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <mtr355>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_mtr355()
			throws Exception {

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

	@And("User clicks Finalize button and Endorses Policy <mtr355> and completes test")
	public void User_clicks_finalize_and_Endorse_Policy_button_mtr355_completes_test() {
		click(dwellingChevron.btnSave);
		wait(2);
		reviewChevron.btnFinalize.click();
		closeoutChevron.btnEndorsePolicy.click();
		wait(5);
		closeUnnecessaryTabs();
		Hooks.scenario.log("Test Case Completed!");
	}

}
