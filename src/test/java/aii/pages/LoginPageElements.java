package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "j_username")
	public WebElement username;
	
	@FindBy(id = "j_password")
	public WebElement password;

	@FindBy(id = "SignIn")
	public WebElement signInButton;

	@FindBy(xpath = "//div[@class='error_content_right']")
	public WebElement passwordError;

	

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

	// We can create methods that are related to this page
	public void signIn() {
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(signInButton);
	}

}
