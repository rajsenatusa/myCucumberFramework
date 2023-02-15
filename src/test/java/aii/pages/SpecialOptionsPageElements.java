package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class SpecialOptionsPageElements extends CommonMethods {

	
	@FindBy(id= "Wizard_SpecialOptions")  
	public WebElement specialOptionsWiz;
	
	@FindBy(id= "TreatAsRenewal")  
	public WebElement treatAsRenewal;
	
	@FindBy(id= "dialogOK")  
	public WebElement dialogOk;
	
	@FindBy(id= "Wizard_Risks")
	public WebElement dwellingWiz;
	
	public SpecialOptionsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
