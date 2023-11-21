package aii.steps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class TC35559_DP3_LossAccessmentNBBasicPolicy extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDate currentDate2 = LocalDate.now();
	static int currentY = currentDate2.getYear();			
	static String currentYear = String.valueOf(currentY);
	
	@When("User enters all required information on policy information screen <tc35559>")
	public void user_enters_all_required_information_on_policy_information_screen_tc35559() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Henry");
		sendText(quote.txtLastName, "Richard");
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "2525 US Highway 27 S");
		sendText(quote.txtZipCode, "33825");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on DP3 quote screen with current date as prior policy date <tc35559>")
	public void user_enters_all_current_date_as_prior_date_tc35559() throws Exception {
		// Quote Policy Chevron information was filled here

		selectDropdownText(policyChevron.ddPreviousCarrier, "AAA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
//		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
//		click(dwellingChevron.btnSave);
//		wait(3);
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

	@When("User enters all required information on DP3 dwelling screen <tc35559> adds coverages and validates loss assessment selections")
	public void user_enters_all_required_information_on_dp3_dwelling_screen_tc35559_and_adds_coverages_and_validates_loss_assessment_selections() throws Exception {

		sendText(dwellingChevron.txtYearConstruction, "2022");
		sendText(dwellingChevron.txtSquareFeet, "2500");
		selectDropdownText(dwellingChevron.bCEG, "3");
		selectDropdownText(dwellingChevron.ddDistanceToHydrant, "<= 1,000 Feet");
		selectDropdownText(dwellingChevron.ddProtectionClass, "03");
		selectDropdownText(dwellingChevron.ddRoofMetarial, "3 Tab Composition Shingle");
		selectDropdownText(dwellingChevron.ddMediationArbitDp1, "No");
		selectDropdownText(dwellingChevron.ddDwellingType, "Single Family");
		selectDropdownText(dwellingChevron.ddQualityGrade, "Economy");
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		wait(3);
		sendText(dwellingChevron.txtCoverageC, "10000");
		selectDropdownText(dwellingChevron.ddCovLLimit, "$100,000");
		sendText(dwellingChevron.txtRoofMaterialUpdate, currentYear);
		
		String[] lossAccessment = {"None","$2,000","$5,000","$10,000"};
		verifyAnyDropDownOptions(driver, lossAccessment, "Building.CovLACLimit");
		selectDropdownText(dwellingChevron.ddLossAssesment, "None");
		click(dwellingChevron.btnSave);
		wait(3);
		verify_AnyText_NotVisibleTwice(driver, "Loss Accessment");
		
		
	}
}
