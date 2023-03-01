package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class SpecialOptionsPageElements extends CommonMethods {

	
	@FindBy(id= "Wizard_SpecialOptions")  
	public WebElement btnSpecialOptionsWiz;
	
	@FindBy(id= "TreatAsRenewal")  
	public WebElement btnTreatAsRenewal;
	
	@FindBy(id= "dialogOK")  
	public WebElement btnDialogOk;
	
	@FindBy(id= "Wizard_Risks")
	public WebElement btnDwellingWiz;
	
	public SpecialOptionsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
