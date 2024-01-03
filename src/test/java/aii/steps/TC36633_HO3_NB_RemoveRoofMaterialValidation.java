package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TC36633_HO3_NB_RemoveRoofMaterialValidation extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static String policyNum;
	static String AppNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String AppForm;
	static String MMA_PreviewApp_Version1;
	static String MMA_PreviewApp_Version;
	static String PolicyNumberSuffix;
	static String MMA_PreviewApp_Data;
	static String AppForm2;
	static String MMA_ProcessApp_Version1;
	static String MMA_ProcessApp_Version;
	static String MMA_ProcessApp_Data;
	static String MMA_NBApp_Version1;
	static String application_Form;
	static String MMA_NBApp_Version;
	static String MMA_NBApp_Data;
	static String app_Tx_Policy_Claim_Num;
	static String QuoteNum;

	@When("User enters all required information on policy information screen <tc36633>")
	public void User_enters_all_required_information_on_policy_information_screen_tc36633() {

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

	@When("User enters all required information on HO3 quote screen <tc36633>")
	public void user_enters_all_required_information_on_ho3_quote_screen_mtr36633() {
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

	@When("User enters all required information on HO3 dwelling screen <tc36633>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc36633() {
		// Quote Dwelling information was filled here

		sendText(dwellingChevron.txtYearConstruction, "2005");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "Tar and Gravel");
		sendText(dwellingChevron.txtSquareFeet, "1500");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2010");
		selectDropdownText(dwellingChevron.ddMediationArbit, "Yes");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(3);
		click(dwellingChevron.btnSave);
		wait(4);
		sendText(dwellingChevron.txtCoverageA, "400000");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		click(dwellingChevron.btnSave);
		wait(4);
		click(policyChevron.btnNext);
		wait(1);
	}

	@When("User completes required information on dwelling chevron and validates MMA dropdown defaulted to Yes <tc36633>")
	public void user_completes_required_information_on_dwelling_chevron_tc36633() throws Exception {
		verifyAnyDropdownDefaultedValue(driver, "Building.MediationArbitrationInd", "Yes");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");

		click(dwellingChevron.btnSave);
		wait(2);
	}

	@When("User answers all underwriting questions for VOL HO3 <tc36633>")
	public void user_answers_all_underwriting_questions_for_ho3_tc36633() throws Exception {
		fillHO3_UWQuestions();
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		// Application Dwelling information was filled here

		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
	}

	@And("User enters all required fields on HO3 Dwelling Tab <tc36633>")
	public void User_enters_all_required_fields_on_HO3_Dwelling_Tab_tc36633() {
		wait(2);
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(2);
		selectDropdownText(dwellingChevron.ddNumberOfStories, "3");
		wait(2);
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2010");
		sendText(dwellingChevron.txtHvacYearUpdate, "2010");
		sendText(dwellingChevron.txtYearElectrical, "2010");

	}

	@And("User validates 'Risk is ineligible based on roof material and roof age' text is visible on ui")
	public void User_validates_Risk_is_ineligible_based_on_roof_material_and_roof_age_text_is_visible_on_ui()
			throws Exception {
		wait(1);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(2);
		verify_AnyText_IsVisible(driver, "Risk is ineligible based on roof material and roof age");

	}

	@And("User validates Quote Premium")
	public void User_validates_Quote_Premium() throws Exception {
		String expected = "$0.00";
		String actual = dashboard.premWithTaxesFeesAmt.getText();
		Assert.assertEquals("The value DOES NOT match!", expected, actual);
		wait(1);
	}

	@And("User gets Quote Number")
	public void User_gets_Quote_Number() {

		// taking note of the issued policy
		try {
			QuoteNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Quote Number: " + QuoteNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("User Searchs for Quote Number <tc36633>")
	public void User_Searchs_for_Quote_Number_tc36633() {

		sendText(dashboard.txtSearchBar, QuoteNum);
		click(dashboard.search);
		wait(3);

	}

	@And("User validates 'QuoteNum is owned by AG1730' text is visible on ui")
	public void User_validates_QuoteNum_is_owned_by_AG1730_text_is_visible_on_ui() throws Exception {

		verify_AnyLabel_IsVisible(driver, QuoteNum + " is owned by AG1730");

	}

	@And("User validates 'Quote in inquiry mode only' text is visible on ui")
	public void User_validates_Quote_in_inquiry_mode_only_text_is_visible_on_ui() throws Exception {

		verify_AnyLabel_IsVisible(driver, "Quote in inquiry mode only");

	}

	@And("User takes ownership")
	public void User_takes_ownership() {

		click(dashboard.ddMoreOptions);
		wait(1);
		click(dashboard.takeOwnership);
		wait(1);
		click(dashboard.dialogOK);
		wait(1);

	}

	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc36633>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc36633()
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

}
