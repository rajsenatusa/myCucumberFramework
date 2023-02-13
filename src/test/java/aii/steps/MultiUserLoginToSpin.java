package aii.steps;

import aii.utils.CommonMethods;
import io.cucumber.java.en.When;

public class MultiUserLoginToSpin extends CommonMethods {

	@When("Login with valid {string} and {string}")
	public void login_with_valid_and(String string, String string2) {
	    
		sendText(login.username, string);
		sendText(login.password, string2);
		
	}
}
