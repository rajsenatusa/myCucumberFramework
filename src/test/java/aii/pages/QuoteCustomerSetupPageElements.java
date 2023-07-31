package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteCustomerSetupPageElements extends CommonMethods {
	
	@FindBy (id= "CustomerName.GivenName")
	public WebElement txtFirstName;
	
	@FindBy (id= "CustomerName.Surname")
	public WebElement txtLastName;
	
	@FindBy (id= "CustomerPersonal.BirthDt")
	public WebElement txtBirthDate;
	
	@FindBy (id= "CustomerName.CommercialName")
	public WebElement txtSearchName;
	
	@FindBy (id= "CustomerLookupAddr.PrimaryNumber")
	public WebElement txtAddress;
		
	@FindBy (id= "CustomerLookupAddr.PostalCode")
	public WebElement txtZipCode;
	
	@FindBy (id= "CustomerLookupAddr.addrVerifyImg")
	public WebElement btnVerifyAddress;
	
	@FindBy (id= "DefaultAddress")
	public WebElement btnCopyToMailAddress;
	
	@FindBy (id= "CopyAddress")
	public WebElement btnCopyToBillAddress;
	
	@FindBy (id= "SaveAndQuote")
	public WebElement btnSaveAndQuote;
	
	@FindBy(id = "Menu_Policy")
	public WebElement quoteAndPolicy;
	
	@FindBy(id = "MoreActionsDropdownButton")
	public WebElement btnMoreActionsDropdownButton;
	
	@FindBy(id = "MyInboxViews")
	public WebElement myInboxViews;
	
	@FindBy(id = "AddInboxView")
	public WebElement btnAddInboxView;
	
	@FindBy(id = "InboxView.Name")
	public WebElement inboxViewName;
	
	@FindBy(xpath = "//option[@value='AgencyStateProvCd']")
	public WebElement agencyState;
	
	@FindBy(id = "AddChosen")
	public WebElement addChosenArrow;
	
	@FindBy(id = "Return")
	public WebElement btnReturn;
	
	@FindBy(id = "InboxView.FilterWorkDate")
	public WebElement inboxViewFilterWorkDate;
	
	@FindBy(id = "InboxSelectOptionCd")
	public WebElement inboxSelectOptionCd;
	
	@FindBy(id = "InboxSelectionSearch")
	public WebElement btnRefreshInbox;
	
	@FindBy(id = "headerAgencyStateProvCd")
	public WebElement headerAgencyState;
	
	
	public QuoteCustomerSetupPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
