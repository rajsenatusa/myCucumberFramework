package aii.steps;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		
	   
		
		moveToElement(driver.findElement(By.id("Menu_Policy")));
		wait(1);
		dashboard.newQuote.click();
		WebElement element= driver.findElement(By.id("Customer.EntityTypeCd"));
		selectDropdown(element, "Individual");
		
	}
	@When("I enter all required information")
	public void i_enter_all_required_information() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I validate the HO3 policy has been created successfully")
	public void i_validate_the_ho3_policy_has_been_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
