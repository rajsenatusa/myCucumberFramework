package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "Menu_Workflow")
	public WebElement btnHome;

	@FindBy(id = "Menu_Policy")
	public WebElement btnQuotePolicy;

	@FindBy(id = "Menu_Claims")
	public WebElement btnClaims;

	@FindBy(id = "Menu_Cabinets")
	public WebElement btnCabinets;

	@FindBy(id = "Menu_Utility")
	public WebElement btnSupport;

	@FindBy(id = "Menu_Admin")
	public WebElement btnAdmin;
	
	@FindBy(id= "Menu_Policy_NewCustomerAndQuote")
	public WebElement btnNewQuote;
	
	@FindBy(id= "UserMenu")
	public WebElement btnUserMenu;
	
	@FindBy(id= "SignOutInMenu")
	public WebElement btnSignOut;
	
	@FindBy(id= "ToolbarSearchText")
	public WebElement txtSearchBar;
	
	@FindBy(id= "ToolbarSearch")
	public WebElement search;
	
	@FindBy(id= "MoreActionsDropdownButton")
	public WebElement ddMoreOptions;
	
	@FindBy(id= "Transaction")
	public WebElement btnStartTransaction;
	
	@FindBy(id= "TransactionCd")
	public WebElement ddSelectTransaction;
	
	@FindBy(id= "Select")
	public WebElement btnSelect;
		
	@FindBy(id= "TransactionEffectiveDt")
	public WebElement txtSelectDate;
	
	@FindBy(id= "Start")
	public WebElement btnStart;
	
	@FindBy(id="Menu_Admin_ChangeDate")
	public WebElement btnChangeDate;
	
	@FindBy(id="NewDate")
	public WebElement txtNewDate;
	
	@FindBy(id="NewBookDate")
	public WebElement txtNewBookDate;
	
	@FindBy(id="ChangeDate")
	public WebElement btnChangeNewDate;
	
	@FindBy(id="ChangeBookDate")
	public WebElement btnChangeBookDate;
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
}
