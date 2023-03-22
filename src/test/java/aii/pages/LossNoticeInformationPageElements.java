package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class LossNoticeInformationPageElements extends CommonMethods {

	@FindBy(id= "Claim.LossDt")
	public WebElement txtlossDt;
	
	@FindBy(id= "Save")
	public WebElement btnContinue;
	
	
	
	public LossNoticeInformationPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
