package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class MTR908_HO6_Verify_the_Updated_Voluntary_HO6_Homeowners_Policy_Declarations_AIIC_DEC_04_23 extends CommonMethods{
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();
	static LocalDateTime issueDate = currentDate.minusYears(1);
	static String FileLocation = System.getProperty("user.dir") + "\\target\\";
	static String policyNum;

	@When("User enters all required information on policy information screen <mtr908>")
	public void user_enters_all_required_information_on_policy_information_screen_mtr908() {

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
	@When("User enters HO6 product selection information and current date minus 1 year as effective date")
	public void user_enters_ho6_product_selection_information_and_effective_date_as_current_date_minus_1_year() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, dtf.format(issueDate));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo6);
	}
}
