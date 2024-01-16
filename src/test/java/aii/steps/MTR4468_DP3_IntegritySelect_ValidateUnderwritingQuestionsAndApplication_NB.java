package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.PdfComparator;
import capgemini.smartPDFcomparator.SmartPDFComparator2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MTR4468_DP3_IntegritySelect_ValidateUnderwritingQuestionsAndApplication_NB extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();
	static String currentYear = String.valueOf(currentY - 2);
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String DP3App_Form;
	static String DP3App_Question6;
	static String DP3App_Question16;
	static String DP3App_Question19;
	static String DP3App_Question25;
	static String DP3App_Question29;
	static String DP3App_selection_Page6;
	static String DP3App_selection_Page6_1;
	static String DP3App_selection_Page7;

	@When("User enters all required information on policy information screen <tc38492>")
	public void user_enters_all_required_information_on_policy_information_screen_tc38492() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "19415 Oakleaf St, Orlando");
		sendText(quote.txtZipCode, "32833");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}

	@When("User enters all required information on DP3 quote screen with current date as prior policy date <tc38492>")
	public void user_enters_all_current_date_as_prior_date_tc38492() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Do Not Use (No Score Ordered)");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, "Frame");
		selectDropdownText(policyChevron.ddOccupancy, "Owner Occupied");
		selectDropdownText(policyChevron.ddMonthsOccupied, "9 to 12 Months");
		selectDropdownText(policyChevron.ddShortTermRental, "No");
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
		wait(3);
	}

	@When("User enters all required information on DP3 dwelling screen <tc38492> and selects integrity select")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_tc38492_and_selects_integrity_select() {

		sendText(dwellingChevron.txtYearConstruction, "2023");
		wait(2);
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.rbIntegritySelectPackage);
		click(dwellingChevron.btnSave);
		wait(3);
	}

	@When("User answers all underwriting questions for DP3 sets vacant unoccupied and known sinkhole loss as yes")
	public void user_answers_all_underwriting_questions_for_dp3_sets_vacant_unoccupied_and_known_sinkhole_as_yes()
			throws Exception {

		verify_AnyLabel_IsVisible(driver,
				"Has the applicant(s) had more than 1 non-weather related losses within the past 3 years?*");
		verify_AnyLabel_IsVisible(driver,
				"Has the applicant(s) or insured location had 1 or more non-weather related water losses within the past 3 years?*");
		verify_AnyLabel_IsVisible(driver,
				"To the best of your knowledge at the time of purchase and/or building this home, were there any disclosures on the residence and/or property to be insured concerning sinkhole activity and/or cracking, movement, raveling, listing, leaning or buckling of a foundation, floor or wall?*");
		verify_AnyLabel_IsVisible(driver,
				"To the best of your knowledge has the insured location been vacant or unoccupied 30 or more days prior to the date purchased by the insured?");

		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question16, "No");
		selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		selectDropdownText(uwquestionsChevron.ho3Question24, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question25, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");

		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}

	@When("User finalizes transaction for <tc38492>")
	public void user_finalizes_transaction_for_tc38492() throws Exception {
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
	}

	@When("User selects Payment Type <tc38492>")
	public void user_issues_policy_tc38492() {

		selectDropdownText(closeoutChevron.ddPaymentType, "None");
		wait(4);
	}

	@When("User takes note of the application for <tc38492>")
	public void user_takes_note_of_the_application__number_for_tc38492() throws Exception {
		try {
			AppNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Application Number: " + AppNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User searches for the application <tc38492>")
	public void user_searches_application_for_tc38492() {
		sendText(dashboard.txtSearchBar, AppNum);
		click(dashboard.search);
		wait(3);
	}

	@When("User validates that DP3 policy has been created successfully and takes note of policy number <tc38492>")
	public void user_validates_that_dp3_policy_has_been_created_successfully_and_takes_note_policy_number_tc38492()
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

	@When("User clicks Policy File Chevron <tc38492>")
	public void user_clicks_policy_file_chevron_tc38492() throws Exception {
		click(policyFileChevron.btnPolicyFilePage);
		wait(5);
	}

	@Then("User clicks Application Form and saves it to the local and do validations UW question answers are matching with actual")
	public void user_clicks_application_form_and_saves_it_to_the_local() throws Exception {
		driver.findElement(By.xpath("(//*[contains(text(), 'Application')])[5]")).click();
		wait(7);
		switchToWindow(driver, "STFile&File");

		DP3App_Form = PdfComparator.makePdf(driver, "35978.pdf");
		Thread.sleep(5000);

		// Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation + DP3App_Form);
		wait(10);

		DP3App_Question6 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 160, 600, 30);
		PdfComparator.verifyFormData(driver, DP3App_Question6,
				"6. Has the applicant(s) had more than 1 non-weather related losses within the past 3 years? NO");

		DP3App_Question16 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 420, 600, 40);
		PdfComparator.verifyFormData(driver, DP3App_Question16, "16");

		DP3App_Question16 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 50, 420, 600, 40);
		PdfComparator.verifyFormData(driver, DP3App_Question16,
				"Has the applicant(s) or insured location had 1 or more non-weather related water losses within the past 3");
		PdfComparator.verifyFormData(driver, DP3App_Question16, "years? NO");

		DP3App_Question19 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 480, 600, 40);
		PdfComparator.verifyFormData(driver, DP3App_Question19,
				"19. To the best of your knowledge at the time of purchase and/or building this home, were there any disclosures on");

		DP3App_Question19 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 470, 600, 40);

		PdfComparator.verifyFormData(driver, DP3App_Question19,
				"the residence and/or property to be insured concerning sinkhole activity and/or cracking, movement, raveling,");
		PdfComparator.verifyFormData(driver, DP3App_Question19,
				"listing, leaning or buckling of a foundation, floor or wall? NO");

		DP3App_Question25 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 600, 600, 70);
		PdfComparator.verifyFormData(driver, DP3App_Question25,
				"25. To the best of your knowledge has the insured location been vacant or unoccupied 30 or more days prior to");
		PdfComparator.verifyFormData(driver, DP3App_Question25, "the date purchased by the insured?");
		PdfComparator.verifyFormData(driver, DP3App_Question25,
				"Unoccupied means that the dwelling is not being inhabited as a residence. YES");

		// To validate if 29 questions are there
		DP3App_Question29 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 4, 30, 670, 600, 40);
		PdfComparator.verifyFormData(driver, DP3App_Question29, "29");

		DP3App_selection_Page6 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 6, 30, 270, 600, 20);
		PdfComparator.verifyFormData(driver, DP3App_selection_Page6, "Sinkhole Selection");

		DP3App_selection_Page6_1 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 6, 30, 350, 600,
				20);
		PdfComparator.verifyFormData(driver, DP3App_selection_Page6_1, "Sinkhole Selection");

		DP3App_selection_Page7 = SmartPDFComparator2.getPDFtextByArea(FileLocation + DP3App_Form, 7, 30, 300, 650, 30);
		PdfComparator.verifyFormData(driver, DP3App_selection_Page7,
				"I declare that all of the information contained on this application is true, complete and correct to the best of my knowledge");
	}

	@When("User clicks submit for approval button without popup")
	public void user_clicks_submit_for_approval_button_without_popup() {
		sendText(closeoutChevron.txtWorkflowComments, "testtestesttest");
		click(closeoutChevron.btnSubmitApproval);
		wait(2);
	}
}
