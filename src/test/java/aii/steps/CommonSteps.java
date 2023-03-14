package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends CommonMethods {

	@Given("I start transaction as a New Customer")
	public void i_start_transaction_as_a_new_customer_common() {
			   
		wait(1);
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(1);
		dashboard.btnNewQuote.click();
		WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
		selectDropdownText(element, "Individual");
		
	}
	
	@When("I select the product from Product Selection List as {string}")
	public void i_enter_prod_selection_information_common(String Product) {
		//product selection information
		switch (Product) {
		case "HO3":
			click(product.btnProductSelectionHo3); 
		case "GOC":	
			click(product.btnProductSelectionGoc);
		case "DP1":	
			click(product.btnProductSelectionDp1);	
		case "DP3":	
			click(product.btnProductSelectionDp3);				
			
		}
		
		}
	
	@And("I change date of system {string}")
	public void i_validate_change_Date(String date) throws Exception {
		 click(dashboard.btnAdmin);
		 click(dashboard.btnChangeDate);
		 sendText(dashboard.txtNewDate, date);
		 click(dashboard.btnChangeNewDate);
		 sendText(dashboard.txtNewBookDate, date);
		 click(dashboard.btnChangeBookDate);
	}
	
	@And("I enter Quote Information as effective date with {string} days difference and state {string} and {string} Insurance Carrier group")
	public void i_enter_quote_Information(String Days, String State, String CarrierGroup) throws Exception {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
		LocalDateTime currentDate = LocalDateTime.now();
		
		String effectiveDate = dtf.format(currentDate.plusDays(Integer.parseInt(Days)));	
		
		// Change system date to effective date
		 click(dashboard.btnAdmin);
		 click(dashboard.btnChangeDate);
		 sendText(dashboard.txtNewDate, effectiveDate);
		 click(dashboard.btnChangeNewDate);
		 sendText(dashboard.txtNewBookDate, effectiveDate);
		 click(dashboard.btnChangeBookDate);
		
		click(dashboard.lnkNewQuote);
		
		sendText(dashboard.txtEffectiveDate,effectiveDate);
		
		if (State.toUpperCase().contains("FL") || State.toUpperCase().contains("FLORIDA") ) {
			selectDropdown(dashboard.ddState, 1);
		}
		
		if (CarrierGroup.toUpperCase().contains("AI") || State.toUpperCase().contains("AMERICAN INTEGRITY INSURANCE GROUP") ) {
			selectDropdown(dashboard.ddCarrierGroup, 1);
		}
				
		wait(2);
		click(dashboard.btnNewQuoteStart);
		
	}
	
	@Given("I select the entiry as {string}")
	public void i_select_the_entiry_as(String entity) {
		
		selectDropdownText(policyChevron.ddEntity, entity);
	}
	
	@And("I enter all required information on Insured information section")
	public void i_enter_all_required_information_on_customer_information_screen() {
	   
		//quote level information was filled here
		sendText(policyChevron.txtInsuredFirstName, ConfigsReader.getProperty("firstname"));
		sendText(policyChevron.txtInsuredLastName, ConfigsReader.getProperty("lastname"));
		sendText(policyChevron.txtInsuredBirthDt, ConfigsReader.getProperty("birthdate"));
		click(policyChevron.btnResetName);
		wait(2);
		}
	
	@Given("I fill the address details of {string} and {string}")
	public void i_fill_the_address_details_of(String address, String zip) {
//		sendText(quote.txtAddress, ));
		sendText(policyChevron.txtStreet, address);
		sendText(policyChevron.txtPostalCode, zip);
		wait(2);
		click(policyChevron.btnVerifyAddress);
		wait(2);
		click(policyChevron.btnSave);
		wait(2);
	}
	
	@And("I select {string} package")
	public void i_select_coverage(String typackage) {
	
	switch(typackage.toUpperCase()) {
	case "BASIC":
		click(dwellingChevron.radioBasicPackage);
		Hooks.scenario.log("Basic Package selected");
		break;
	case "INTEGRITY SELECT":
		click(dwellingChevron.radioIntegritySelectPackage);
		Hooks.scenario.log("Integrity Package selected");
		break;
	}
	}
		
	@Given("I validate the default value of {string} as {string}")
	public void i_validate_the_default_value_of_as(String coverage, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		CommonMethods.verifyAnyDropdownDefaultValue(dwellingChevron.ddCovCLimit, coverage, expectedValue);
	}
	
	
	



}
