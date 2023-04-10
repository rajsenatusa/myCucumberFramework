package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class UserLookup extends CommonMethods {
	
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
	
		
	public UserLookup() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
