package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UMBpolicy extends CommonMethods {

	@When("I enter UMB product selection information and effective date")
	public void i_enter_umb_product_selection_information_and_effective_date() {
		//product selection information was filled here
				sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
				selectDropdown(product.ddStateSelection, 1);
				selectDropdown(product.ddCarrierSelection, 1);
				wait(2);
				click(product.btnContinue);
				click(product.btnProductSelectionUmb);
				
	}
	@When("I enter all required information on UMB quote screen")
	public void i_enter_all_required_information_on_umb_quote_screen() {
				//Quote Policy Chevron information was filled here
				sendText(policyChevron.txtProducerCodeSel, ConfigsReader.getProperty("producerselection"));
				wait(5);
				clickTab(policyChevron.ddPolicyWrittenAiig);
				selectDropdownText(policyChevron.ddPolicyWrittenAiig, "Yes");
				selectDropdownText(policyChevron.ddAutoPolicy, "Yes");
				sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
				selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
				wait(2);
				click(policyChevron.btnNoEmailRadio);
				click(policyChevron.btnNext);
	}
	@When("I enter all required information on UMB personal liability screen")
	public void i_enter_all_required_information_on_umb_personal_liability_screen() {
	    		
				selectDropdownText(umbrellaChevron.ddUmbLimitCov, ConfigsReader.getProperty("umbliabilitycoverage"));
				wait(2);
				selectDropdownText(umbrellaChevron.ddUninsuredLimit, ConfigsReader.getProperty("uninsuredlimit"));
				sendText(umbrellaChevron.txtNumberOfAuto, ConfigsReader.getProperty("numberofauto"));
				click(dwellingChevron.btnSave);
				wait(3);
				click(reviewChevron.btnReview);
				wait(3);
				
				
	}
	@When("I enter all required information on UMB review screen")
	public void i_enter_all_required_information_on_umb_review_screen() {
				//Quote Review Chevron information was filled here
				selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
				wait(2);
				click(reviewChevron.btnFullPaymentRadio);
				wait(3);
				click(reviewChevron.btnCreateApplication);
				wait(4);
	}
	@When("I create UMB application")
	public void i_create_umb_application() {
				//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
				click(dwellingChevron.btnNext);
				
				//Application Underwriting Questions Chevron was filled here
				
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
				click(reviewChevron.btnReview);
				wait(2);
				click(reviewChevron.btnFinalize);
				wait(2);
				
				//Closeout Chevron information was filled here
				
				selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
				wait(4);
				click(closeoutChevron.btnIssueNB);
	}
	@Then("I validate the UMB policy has been created successfully")
	public void i_validate_the_umb_policy_has_been_created_successfully() {
				WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
						
				if(validate.getText().equalsIgnoreCase("New Business")) {
					System.out.println("Test passed, UMB NB policy has been created successfully");
				}
				else {
					System.out.println("Test failed!");
				}
	}

}
