package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HO3policy extends CommonMethods {

	@Given("I signin Spin as Standard Agent")
	public void i_signin_spin_as_standard_agent() {
		
	 sendText(login.username, ConfigsReader.getProperty("username"));
	 sendText(login.password, ConfigsReader.getProperty("password"));
	 click(login.btnSignIn);
	 wait(3);
		
	}
	@Given("I start transaction as a new customer")
	public void i_start_transaction_as_a_new_customer() {
		
	   
		wait(1);
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(1);
		dashboard.btnNewQuote.click();
		WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
		selectDropdownText(element, "Individual");
		
	}
	@When("I enter all required information on customer information screen")
	public void i_enter_all_required_information_on_customer_information_screen() {
	   
		//quote level information was filled here
		sendText(quote.txtFirstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.txtLastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.txtBirthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.txtSearchName);
		sendText(quote.txtAddress, ConfigsReader.getProperty("address"));
		sendText(quote.txtZipCode, ConfigsReader.getProperty("zipcode"));
		wait(2);
		click(quote.btnVerifyAddress);
		wait(2);
		click(quote.btnCopyToMailAddress);
		click(quote.btnCopyToBillAddress);
		click(quote.btnSaveAndQuote);
		wait(2);
		}
	@When("I enter product selection information and effective date")
	public void i_enter_product_selection_information_and_effective_date() {
		//product selection information was filled here
		sendText(product.txtEffectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.ddStateSelection, 1);
		selectDropdown(product.ddCarrierSelection, 1);
		wait(2);
		click(product.btnContinue);
		click(product.btnProductSelectionHo3); 
		}
		
	@When("I enter all required information on quote screen")
	public void i_enter_all_required_information_on_quote_screen() {
		//Quote Policy Chevron information was filled here
		
		selectDropdownText(policyChevron.ddPreviousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.txtPreviousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.ddInsuranceScoreDd,3);
		sendText(policyChevron.txtPhoneNumber, ConfigsReader.getProperty("phonenumber"));
		selectDropdownText(policyChevron.ddPhoneNumberType, ConfigsReader.getProperty("phonetype"));
		wait(2);
		click(policyChevron.btnNoEmailRadio);
		selectDropdownText(policyChevron.ddConstructionType, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.ddOccupancy, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.ddMonthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.ddInsuredReside, "No");
		wait(1);
		click(policyChevron.btnNext);
	}
		
	@When("I enter all required information on dwelling screen")
	public void i_enter_all_required_information_on_dwelling_screen() {
		//Quote Dwelling information was filled here
		sendText(dwellingChevron.txtYearConstruction, ConfigsReader.getProperty("yearconstruction"));
		sendText(dwellingChevron.txtSquareFeet, ConfigsReader.getProperty("squarefeet"));
		selectDropdownText(dwellingChevron.ddRoofMetarial, ConfigsReader.getProperty("roofmetarial"));
		selectDropdownText(dwellingChevron.ddMediationArbit,ConfigsReader.getProperty("mediation"));
		wait(2);
		click(dwellingChevron.btnSave);
		wait(3);
		selectDropdownText(dwellingChevron.ddQualityGrade, ConfigsReader.getProperty("qualitygrade"));
		click(dwellingChevron.btnCalculate);
		wait(4);
		click(dwellingChevron.btnSave);
		click(dwellingChevron.btnNext);
		wait(3);
	}
	
	@When("I enter all required information on review screen")
	public void i_enter_all_required_information_on_review_screen() {
		//Quote Review Chevron information was filled here
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(3);
		click(reviewChevron.btnCreateApplication);
		wait(4);
		click(reviewChevron.btnInsuranceScoreBox);
		click(reviewChevron.btnInsuranceScoreOk);
		wait(3);
	}
	
	@When("I create HO3 application")
	public void i_create_ho3_application() {
		//Application Policy Chevron information was filled here(all information was filled previously, just clicking next button)
		
		click(dwellingChevron.btnNext);
		
		//Application Underwriting Questions Chevron was filled here
		
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		selectDropdownText(uwquestionsChevron.ho3Question8, "No");
		selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		selectDropdownText(uwquestionsChevron.ho3Question12, "No");
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
		selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		selectDropdownText(uwquestionsChevron.ho3Question29, "No");
		wait(1);
		click(uwquestionsChevron.nextButtonUw);
		
		//Application Dwelling information was filled here
		
		selectDropdownText(dwellingChevron.ddDwellingType, ConfigsReader.getProperty("dwellingtype"));
		wait(2);
		click(dwellingChevron.btnSave);
		click(reviewChevron.btnReview);
		wait(2);
		click(reviewChevron.btnFinalize);
		wait(2);
		
		//Closeout Chevron information was filled here
		
		selectDropdownText(closeoutChevron.ddPaymentType, ConfigsReader.getProperty("paymenttype"));
		wait(4);
		click(closeoutChevron.btnIssueNB);
		
	}
	@Then("I validate the HO3 policy has been created successfully")
	public void i_validate_the_ho3_policy_has_been_created_successfully() {
	
		WebElement validate= driver.findElement(By.id("History_1_1_TransactionCd"));
		
		if(validate.getText().equalsIgnoreCase("New Business")) {
			System.out.println("Test passed, HO3 NB policy has been created successfully");
		}
		else {
			System.out.println("Test failed!");
		}
		
		
	}



}
