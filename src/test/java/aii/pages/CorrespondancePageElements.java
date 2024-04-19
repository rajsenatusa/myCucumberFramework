package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class CorrespondancePageElements extends CommonMethods{
	
	@FindBy(id="OutputTemplateIdRef")
	public WebElement ddSelectCorrespondance;
	
	@FindBy(id="SelectForm")
	public WebElement btnAdd;
	
	@FindBy(id= "PreviewCorrespondence")
	public WebElement btnPreviewCorrespondance;
	
	@FindBy(id="NewRecipient")
	public WebElement btnNewRecipient;
	
	@FindBy(id= "Name")
	public WebElement ddName;
	
	@FindBy(id= "Cancel")
	public WebElement btnCancel;
	
	@FindBy(id= "ProcessCorrespondence")
	public WebElement btnProcessCorrespondence;
	
	@FindBy(id= "Tab_Correspondence")
	public WebElement correspondence;
	
	@FindBy(id= "OutputItem_1_Description")
	public WebElement outputItem1Description;
	
	
	
	
	
	
	
	
	
	
	
	public CorrespondancePageElements() {
		PageFactory.initElements(driver, this);	
	}
	
}
