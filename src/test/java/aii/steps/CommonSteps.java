package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends CommonMethods {

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
	
	@When("I select the product from Product Selection List as {string}")
	public void i_enter_product_selection_information(String Product) {
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
	
		



}
