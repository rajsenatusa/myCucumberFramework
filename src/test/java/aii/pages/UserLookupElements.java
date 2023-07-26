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
	
	@FindBy (id= "SearchUser")
	public WebElement btnUserSearch;
	
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
	
	@FindBy (id= "LoginId")
	public WebElement txtUserId;
	
	@FindBy (id= "UserRolesList")
	public WebElement txtUserRolesList;
	
	@FindBy (id= "OverrideRole_0")
	public WebElement lnkOverride;
	
	@FindBy (id= "UserRoleAttrValue_2_1")
	public WebElement txtDaysAllowedPayPlan;
	
	@FindBy (id= "UserRoleAttrValue_2_2")
	public WebElement txtNumberAllowedPayPlan;
	
	@FindBy (id= "Save")
	public WebElement btnSave;
	
	@FindBy (xpath= "//td[@title='Allow Pay Plan Change from Policy without transaction']")
	public WebElement txtAllowPayPlanChange;
	
	@FindBy (xpath= "//tbody/tr[755]/td[2]")
	public WebElement txtAllowPayPlanChangeAnswer;
	
	public UserLookupElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
