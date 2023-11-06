package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;

public class TC16742_AIB_ValidateErrorMessagesForQuoteCharaceristics extends CommonMethods{

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime expirationDate = currentDate.plusDays(40);
	static String policyNum;
	static String AppNum;
	
	@When("User enters all required information on policy information screen <tc16742>")
	public void user_enters_all_required_information_on_policy_information_screen_tc16742() {

		// quote level information was filled here
		sendText(quote.txtFirstName, "Austin");
		sendText(quote.txtLastName, "Ramsey");
		sendText(quote.txtBirthDate, dtf.format(currentDate.minusYears(20)));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, "770 Claughton Island Dr");
		sendText(quote.txtZipCode, "33131");
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
	}
	@When("User enters all required information on AIB quote screen for <tc16742>")
	public void user_enters_all_required_information_on_aib_quote_screen_for_tc16742() {

		selectDropdownText(policyChevron.ddPreviousCarrier, "Geico");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(expirationDate));
		sendText(policyChevron.txtProducerCodeSel, "AG1730A1");
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "Yes");
		selectDropdownText(policyChevron.ddInsuranceScoreDd, "Better (800-899)");
		sendText(policyChevron.txtPhoneNumber, "313-741-9632");
		selectDropdownText(policyChevron.ddPhoneNumberType, "Mobile");
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(dwellingChevron.btnSave);
		wait(5);
		//click(policyChevron.btnNext);
		//wait(3);
	}
	@When("User validates 'County is closed for new business' text is visible")
	public void user_validates_County_is_closed_for_new_business_text_is_visible() throws Exception {

		verify_AnyText_IsVisible(driver, "County is closed for new business");
	}
	@When("User changes ineligible address with eligible address")
	public void user_changes_ineligible_address_with_eligible_address() throws Exception {

		setAddress(driver, "1165", "Peperidge", "32504");
		click(quote.btnVerifyAddress);
		wait(2);
		selectDropdownText(policyChevron.ddPreviousCarrier, "AMICA");
		sendText(policyChevron.txtPreviousPolicyExpDate, dtf.format(currentDate));
		selectDropdownText(policyChevron.ddCoverage6MonthsInd, "No");
		selectDropdownText(policyChevron.ddGaraged6MonthsInd, "No");
		click(dwellingChevron.btnSave);
		wait(5);
		click(policyChevron.btnNext);
		wait(3);
		verify_AnyText_IsVisible(driver, "Coverage Type must be selected.");
	}
}
