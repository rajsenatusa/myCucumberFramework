package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class PolicyFilePageElements extends CommonMethods {
	
	@FindBy(id= "Tab_Documents")
	public WebElement btnPolicyFilePage;

	@FindBy(linkText= "Application")
	public WebElement btnApplicationForm;
	
	@FindBy(linkText= "Endorsement Package")
	public WebElement btnEndorsementPackageForm;
	

	public PolicyFilePageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
