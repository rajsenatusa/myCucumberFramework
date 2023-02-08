package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuotePageElements extends CommonMethods {
	
	@FindBy (id= "CustomerName.GivenName")
	public WebElement firstName;
	
	@FindBy (id= "CustomerName.Surname")
	public WebElement lastName;
	
	@FindBy (id= "CustomerPersonal.BirthDt")
	public WebElement birthDate;
	
	@FindBy (id= "CustomerName.CommercialName")
	public WebElement searchName;
	
	@FindBy (id= "CustomerLookupAddr.PrimaryNumber")
	public WebElement address;
	
	@FindBy (id= "CustomerLookupAddr.PostalCode")
	public WebElement zipCode;
	
	@FindBy (id= "CustomerLookupAddr.addrVerifyImg")
	public WebElement verifyAddress;
	
	@FindBy (id= "DefaultAddress")
	public WebElement copyToMailAddress;
	
	@FindBy (id= "CopyAddress")
	public WebElement copyToBillAddress;
	
	@FindBy (id= "SaveAndQuote")
	public WebElement saveAndQuote;
	
	
	public QuotePageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
