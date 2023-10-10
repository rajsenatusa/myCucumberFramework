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

public class TC16404_HO3_ValidateSilverReserveWithAdditionalCoverageFormsOn_NB_ENDSROALCC_Claim_RWL
		extends CommonMethods {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime newBusinessDate = currentDate.plusDays(30);
	static LocalDateTime endorseDate = newBusinessDate.plusDays(30);
	static String policyNum;
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String QuoteForm;
	static String Quote_Version;
	static String Quote_Data;
	static String Reserve_Version;
	static String Reserve_Data;
	
	@When("User enters all required information on policy information screen <tc16404>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16404() {

		// quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
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
	@When("User enters HO3 product selection information and new business date as effective date <tc16404>")
	public void user_enters_ho3_product_selection_information_and_new_business_date_as_effective_date_tc16404() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(newBusinessDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3);
	}
	@When("User enters all required information on HO3 quote screen <tc16404>")
	public void user_enters_all_required_information_on_ho3_quote_screen_tc16404() {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "New Purchase");
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Neutral");
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
	
	@When("User enters all required information on HO3 dwelling screen and selects silver reserve and add additional coverages <tc16404>")
	public void user_enters_all_required_information_on_ho3_dwelling_screen_tc16404() {

		sendText(dwellingChevron.txtSquareFeet, "1500");
		selectDropdownText(dwellingChevron.bCEG, "4");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddDistanceToCoast, "10 mi to less than 15 mi");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		sendText(dwellingChevron.txtRoofMaterialUpdate, "2022");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		click(dwellingChevron.btnCalculate);
		wait(4);
		
		//Select Silver reserve package and additional coverages which not already included in the package
		click(dwellingChevron.rbSilverReserve);
		selectDropdownText(dwellingChevron.ddHomeCyberProtection, "$25,000");
		selectDropdownText(dwellingChevron.ddServiceLine, "$10,000");
		
		//Additional Options
		selectDropdownText(dwellingChevron.ddAnimalLiability, "$50,000");
		selectDropdownText(dwellingChevron.ddMediationArbit, "No");
		click(dwellingChevron.rbIncreasedDwellingReplacementCost);
		click(dwellingChevron.rbSpecialPersonalProperty);
		
		click(dwellingChevron.btnSave);
		wait(4);
	}
	
	@When("User clicks Print button on quote and validates quote form version")
	public void user_clicks_Print_button_on_quote_and_validates_quote_form_version() throws Exception {
		click(driver.findElement(By.id("PrintQuote")));
		wait(5);
		switchToWindow(driver, "UWQuote");
		QuoteForm = PdfComparator.makePdf(driver, "Ho3Quote.pdf");
		
		//Save the pdf in local driver
		PdfComparator.SavePdfForm(driver, FileLocation+QuoteForm);
			
		wait(10);
		Quote_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 1, 50, 750, 100, 30);
		PdfComparator.verifyFormData(driver, Quote_Version, "AIIC QT 07 19");
		
		Quote_Data = PdfComparator.getPDFData(FileLocation+QuoteForm);
		PdfComparator.verifyPDFText(driver, Quote_Data, "AIIC QT 07 19");
		
		//AIIC HO3 RB 07 18 form
		Reserve_Version = SmartPDFComparator2.getPDFtextByArea(FileLocation+QuoteForm, 3, 35, 740, 120, 40);
		PdfComparator.verifyFormData(driver, Reserve_Version, "AIIC HO3 RB 07 18");
		
		Reserve_Data = PdfComparator.getPDFData(FileLocation+QuoteForm);
		PdfComparator.verifyPDFText(driver, Reserve_Data, "AIIC HO3 RB 07 18");
	}
	@When("User completes required information on dwelling chevron and updates years updated sections <tc16404>")
	public void user_completes_required_information_on_dwelling_chevron_tc16404() throws Exception {
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		wait(1);
		sendText(dwellingChevron.txtHvacYearUpdate, "2022");
		sendText(dwellingChevron.txtYearElectrical, "2022");
		sendText(dwellingChevron.txtPlumbingYearUpdate, "2022");
		click(dwellingChevron.btnSave);
		wait(2);
	}
	@And("User clicks Finalize button <tc16404>")
	public void User_clicks_Finalize_button_tc16404() {	    	   						
		wait(1);
		click(reviewChevron.btnFinalize);
		wait(1);
	}
	
	@And("User validates that HO3 policy has been created successfully and takes note of the policy number <tc16404>")
	public void user_validates_that_ho3_policy_has_been_created_successfully_and_takes_note_of_the_policy_number_tc16404()
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
	
	@When("User clicks Forms Chevron <tc16404>")
	public void user_clicks_forms_chevron_tc16404() throws Exception {
		click(dwellingChevron.lnkForms);
		wait(5);
	}
}
