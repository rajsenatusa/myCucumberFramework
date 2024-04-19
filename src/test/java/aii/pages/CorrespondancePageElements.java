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
		
	@FindBy(id= "OutputItem_1_Description")
	public WebElement outputItem1Description;
	
	@FindBy(id= "Tab_Correspondence")
	public WebElement lnkCorrespondenceTab;
	
	@FindBy(id= "Navigate_ClaimantSync_1")
	public WebElement btnFirstClaimant;
	
	@FindBy(id= "AssignedAdjusterProviderNumber")
	public WebElement txtAssignedAdjusterNumber;
	
	@FindBy(id= "th-cmp-432")
	public WebElement btnPannelHomeownersForm;
	
	@FindBy(id= "PreviewCorrespondence_0")
	public WebElement btnPreviewCorrespondenceFirst;
	
	
	
	public CorrespondancePageElements() {
		PageFactory.initElements(driver, this);	
	}
	
}
