package aii.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends CommonMethods {

	@Given("I signin Spin as Standard Agent")
	public void i_signin_spin_as_standard_agent_common() {

	 sendText(login.username, ConfigsReader.getProperty("username"));
	 sendText(login.password, ConfigsReader.getProperty("password"));
	 click(login.btnSignIn);
	 wait(3);		
	}
	
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



}
