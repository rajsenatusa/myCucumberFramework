package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "Menu_Workflow")
	public WebElement home;

	@FindBy(id = "Menu_Policy")
	public WebElement quotePolicyButton;

	@FindBy(id = "Menu_Claims")
	public WebElement claimsButton;

	@FindBy(id = "Menu_Cabinets")
	public WebElement cabinetsButton;

	@FindBy(id = "Menu_Utility")
	public WebElement supportButton;

	@FindBy(id = "Menu_Admin")
	public WebElement adminButton;
	
	@FindBy(id= "Menu_Policy_NewCustomerAndQuote")
	public WebElement newQuote;
	
	@FindBy(id= "UserMenu")
	public WebElement userMenu;
	
	@FindBy(id= "SignOutInMenu")
	public WebElement signOut;
	
	@FindBy(id= "ToolbarSearchText")
	public WebElement searchBar;
	
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
}
