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
	 click(login.signInButton);
	 wait(3);
		
	}
	@Given("I start transaction as a new customer")
	public void i_start_transaction_as_a_new_customer() {
		
	   
		wait(2);
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(1);
		dashboard.newQuote.click();
		WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
		selectDropdown(element, "Individual");
		
	}
	@When("I enter all required information")
	public void i_enter_all_required_information() {
	   
		//quote level information was filled here
		sendText(quote.firstName, ConfigsReader.getProperty("firstname"));
		sendText(quote.lastName, ConfigsReader.getProperty("lastname"));
		sendText(quote.birthDate, ConfigsReader.getProperty("birthdate"));
		click(quote.searchName);
		sendText(quote.address, ConfigsReader.getProperty("address"));
		sendText(quote.zipCode, ConfigsReader.getProperty("zipcode"));
		wait(2);
		click(quote.verifyAddress);
		wait(2);
		click(quote.copyToMailAddress);
		click(quote.copyToBillAddress);
		click(quote.saveAndQuote);
		wait(2);
		
		//product selection information was filled here
		sendText(product.effectiveDate,ConfigsReader.getProperty("effectivedate"));
		selectDropdown(product.stateDropdown, 1);
		selectDropdown(product.carrierDropdown, 1);
		wait(2);
		click(product.continueButton);
		click(product.productSelectionHo3);
		
		//Quote Policy Chevron information was filled here
		selectDropdownText(policyChevron.previousCarrier, ConfigsReader.getProperty("previouscarrier"));
		sendText(policyChevron.previousPolicyExpDate, ConfigsReader.getProperty("previouspolicyexpdate"));
		selectDropdown(policyChevron.insuranceScoreDd,3);
		sendText(policyChevron.phoneNumber, ConfigsReader.getProperty("phonenumber"));
		wait(2);
		click(policyChevron.noEmailRadio);
		selectDropdownText(policyChevron.constructionTypeDd, ConfigsReader.getProperty("constructiontype"));
		selectDropdownText(policyChevron.occupancyDd, ConfigsReader.getProperty("occupancytype"));
		selectDropdownText(policyChevron.monthsOccupied, ConfigsReader.getProperty("monthsoccupied"));
		selectDropdownText(policyChevron.insuredReside, "No");
		click(policyChevron.nextButton);
		
		//Quote Dwelling information was filled here
		
		
		
		
	}
	@Then("I validate the HO3 policy has been created successfully")
	public void i_validate_the_ho3_policy_has_been_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
