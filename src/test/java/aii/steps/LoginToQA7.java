package aii.steps;

import org.junit.Assert;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToQA7 extends CommonMethods {

	@Given("User navigates to QA7")
	public void User_navigates_to_QA7() {		
		//	setUp();
//		login = new LoginPageElements();
//		dashboard = new DashboardPageElements();
	}		
	@When("User enters a valid username")
	public void User_enters_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}
	@And("User enters a valid password")
	public void User_enters_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
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
}
