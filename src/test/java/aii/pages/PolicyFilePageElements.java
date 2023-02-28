package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class PolicyFilePageElements extends CommonMethods {
	
	@FindBy(id= "Tab_Documents")
	public WebElement policyFilePage;

	@FindBy(linkText= "Application")
	public WebElement applicationForm;
	
	@FindBy(linkText= "Endorsement Package")
	public WebElement endorsementPackageForm;
	

	public PolicyFilePageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
