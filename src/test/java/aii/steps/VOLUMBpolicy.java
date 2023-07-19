package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VOLUMBpolicy extends CommonMethods {

	@When("User enters UMB product selection information and effective date")
	public void user_enters_umb_product_selection_information_and_effective_date() {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
	}
	@When("User enters product selection information for UMB and {string}")
	public void user_enters_product_selection_information_for_umb_and_(String EffectiveDate) {
		// product selection information was filled here
		sendText(product.txtEffectiveDate, EffectiveDate);
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionUmb);
	}
	@When("User answers previous policy written with AIIG questions")
	public void user_answers_previous_policy_written_with_aiig_questions() {
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
	}
	@When("User enters all required information on UMB quote screen")
	public void user_enters_all_required_information_on_umb_quote_screen() {
		// Quote Policy Chevron information was filled here
		sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
		wait(5);
		click(dwellingChevron.btnSave);
		wait(3);
		clickTab(policyChevron.ddPolicyWrittenAiig);
		selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
		selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		click(policyChevron.btnNext);
	}

	@When("User enters all required information on UMB personal liability screen")
	public void user_enters_all_required_information_on_umb_personal_liability_screen() {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, ConfigsReader.getProperty("umbliabilitycoverage"));
		wait(2);
		selectDropdownText(umbrellaChevron.ddUninsuredLimit, ConfigsReader.getProperty("uninsuredlimit"));
		sendText(umbrellaChevron.txtNumberOfAuto, ConfigsReader.getProperty("numberofauto"));
		click(dwellingChevron.btnSave);
		wait(3);
		click(reviewChevron.btnReview);
		wait(3);
	}
	@When("User selects Umbrella Liability Coverage {string}")
	public void user_selects_umbrella_liability_coverage (String LiabilityCoverage) {

		selectDropdownText(umbrellaChevron.ddUmbLimitCov, LiabilityCoverage);
		wait(2);
	}
	@When("User selects Uninsured Limit {string}")
	public void user_selects_uninsured_limit (String UninsuredLimit) {

		selectDropdownText(umbrellaChevron.ddUninsuredLimit, UninsuredLimit);
	}
	@When("User enters Number of Auto {string}")
	public void user_enters_number_of_auto (String NumberOfAuto) {
		sendText(umbrellaChevron.txtNumberOfAuto, NumberOfAuto);
	}
	@When("User enters all required information on UMB review screen")
	public void user_enters_all_required_information_on_umb_review_screen() {
		// Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
	}

	@When("User answers all underwriting questions for UMB")
	public void user_answers_all_underwriting_questions_for_umb() {
		// Application Underwriting Questions Chevron was filled here
		selectDropdownText(uwquestionsChevron.umbQuestion1, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion2, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion3, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion4, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion5, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion6, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion7, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion8, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion9, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion10, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion11, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion12, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion13, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion14, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion15, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion16, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion17, "No");
		selectDropdownText(uwquestionsChevron.umbQuestion18, "No");
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
	}

	@When("User creates UMB application")
	public void user_creates_umb_application() {
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(dwellingChevron.btnNext);
	}

	@Then("User validates that UMB policy has been created successfully")
	public void user_validates_that_umb_policy_has_been_created_successfully() {
		WebElement validate = driver.findElement(By.id("History_1_1_TransactionCd"));

		if (validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, UMB NB policy has been created successfully");
		} else {
			System.out.println("Test failed!");
		}
	}

}
