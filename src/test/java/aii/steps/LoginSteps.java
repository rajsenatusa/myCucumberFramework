package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	@Then("User validates that logged in successfully")
	public void user_validates_that_logged_in_successfully() {

		String expected = "Home";
		String actual = dashboard.btnHome.getText();

		if (actual.equals(expected)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}
	@When("User enters an invalid password")
	public void user_enters_an_invalid_password() {
		sendText(login.password, "123456");
	}
	@Then("User validates that Invalid Credentials is displayed")
	public void user_validates_that_invalid_credentials_is_displayed() {
		String expectedMsg = "Invalid user or password.";
		String actualMsg = login.passwordError.getText();

		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
	}	
}
