package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class CloseOutChevronPageElements extends CommonMethods {
	
	@FindBy(id= "TransactionInfo.PaymentTypeCd")
	public WebElement paymentType;
	
	@FindBy(id= "Process")
	public WebElement issueNBButton;
		
	
	
	public CloseOutChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
