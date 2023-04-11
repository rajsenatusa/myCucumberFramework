package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class UserLookupElements extends CommonMethods {
	
	@FindBy (id= "SearchBy")
	public WebElement ddSearchBy;
	
	@FindBy (id= "SearchText")
	public WebElement txtSearchText;
	
	@FindBy (id= "Search")
	public WebElement btnSearch;
	
	@FindBy (id= "MatchType")
	public WebElement ddStartWith;
	
	@FindBy (linkText= "Reset Password")
	public WebElement lnkResetPassword;
	
	@FindBy (id= "NewPassword")
	public WebElement txtPassword;
	
	@FindBy (id= "ConfirmNewPassword")
	public WebElement txtConfirmPassword;
	
	@FindBy (id= "UserInfo.PasswordMustChangeInd")
	public WebElement chkPasswordChangeNextLogin;
	
	@FindBy (id= "ResetPassword")
	public WebElement btnChangePassword;
	
	@FindBy (id= "Return")
	public WebElement btnReturn;
	
	public UserLookupElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
