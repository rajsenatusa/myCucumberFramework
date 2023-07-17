package aii.steps;

import org.junit.Assert;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsTestEnvironments extends CommonMethods {

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

	@Given("User navigates to QA7")
	public void User_navigates_to_QA7() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}

	@And("User clicks on the login button")
	public void User_clicks_on_the_login_button() {
		click(login.btnSignIn);
		wait(1);
	}

	@Then("User verifies that User logged in")
	public void User_verifies_that_User_logged_in() {
		String expected = "Home";
		String actual = dashboard.btnHome.getText();
		Assert.assertEquals("Test failed!", expected, actual);
	}

	@Then("User will quit the browser")
	public void User_will_quit_the_browser() {
//	tearDown();
	}
	
	@And("User enters a valid user name {string}")
	public void User_enters_a_valid_user_name(String username) {
		sendText(login.username, username);			
	}
	@And("User enters a valid password {string}")
	public void User_enters_a_valid_user_password(String password) {
		sendText(login.password, password);		
		wait(1);	
	}
	
	@When("User logins with valid {string} and {string}")
	public void user_logins_with_valid_and(String string, String string2) {
	    
		sendText(login.username, string);
		sendText(login.password, string2);
		
	}
	@Given("User navigates to QA6")
	public void User_navigates_to_QA6() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to QA5")
	public void User_navigates_to_QA5() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to QA4")
	public void User_navigates_to_QA4() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to QA3")
	public void User_navigates_to_QA3() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to QA2")
	public void User_navigates_to_QA2() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to QA1")
	public void User_navigates_to_QA1() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to Model")
	public void User_navigates_to_model() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
	@Given("User navigates to Model2")
	public void User_navigates_to_model2() {
		// setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}
}
