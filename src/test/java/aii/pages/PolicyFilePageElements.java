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
	
	@FindBy(linkText= "New Business Package")
	public WebElement btnNewBusinessPackage;
	
	@FindBy(linkText= "Renewal Declaration")
	public WebElement btnRenewalDeclaration;
	
	@FindBy(linkText= "Insured Renewal Declaration")
	public WebElement insuredRenewalDeclaration;
		
	@FindBy(id= "imgItem0000000000")
	public WebElement btnExpand;
	
	@FindBy(id= "Output_00000_7_Link")
	public WebElement btnContinuationOfCoverage;
	
	@FindBy(id= "Output_00001_1_Link")
	public WebElement btnInsuranceQuote;
	
	@FindBy(xpath= "//*[@id=\"Draggable_00000_00002\"]/table/tbody/tr[1]")
	public WebElement HO4DeclarationLink;
	
	@FindBy(xpath= "//*[@id=\"Draggable_00000_00000\"]/table/tbody/tr[1]")
	public WebElement HO4NewBussinessPackageLink;
	
	
	public PolicyFilePageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
