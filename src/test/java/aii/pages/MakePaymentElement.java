package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class MakePaymentElement extends CommonMethods {
	
	@FindBy(id= "cardNum")
	public WebElement txtCardNumber;
	
	@FindBy(id= "expiryDate")
	public WebElement txtExpiryDate;
	
	@FindBy(id= "cvv")
	public WebElement txtCVV;
	
	@FindBy(name= "firstName")
	public WebElement txtFirstName;	
	
	@FindBy(name= "lastName")
	public WebElement txtLastName;	

	@FindBy(name= "zip")
	public WebElement txtZip;
	
	@FindBy(name= "address")
	public WebElement txtAddress;
	
	@FindBy(name= "city")
	public WebElement txtCity;
	
	@FindBy(name= "state")
	public WebElement txtState;
	
	@FindBy(name= "phoneNumber")
	public WebElement txtPhoneNumber;
	
	@FindBy(id= "companyNameID")
	public WebElement txtCompanyNameID;
	
	@FindBy(id= "saveButton")
	public WebElement btnSaveButton;
	
	
	public MakePaymentElement() {
		
		PageFactory.initElements(driver, this);
		
	}

}
