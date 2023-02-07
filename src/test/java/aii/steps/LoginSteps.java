package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	//	LoginPageElements login;
	//	DashboardPageElements dashboard;
	//commented out because we have pageinitializer class

	@Given("I navigated to the spin website")
	public void i_navigated_to_the_spin_website() {
		// commented this out because we have Hooks.java
		//	setUp();
		//		login = new LoginPageElements();
		//		dashboard = new DashboardPageElements();
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the signin button")
	public void i_click_on_the_signin_button() {
		click(login.signInButton);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {

		String expected = "Home";
		String actual = dashboard.home.getText();

		if (actual.equals(expected)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

	}

	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
	// commented this out in lesson because we have Hooks.java
	//	tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(login.password, "123456");
	}

	@Then("I validate that Invalid Credentials is displayed")
	public void i_validate_that_invalid_credentials_is_displayed() {
		String expectedMsg = "Invalid user or password.";
		String actualMsg = login.passwordError.getText();

		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
	}

	

}
