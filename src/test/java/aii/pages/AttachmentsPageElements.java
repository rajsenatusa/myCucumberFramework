package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class AttachmentsPageElements extends CommonMethods{

	@FindBy(id= "Tab_Attachments")
	public WebElement lnkAttachmentsTab;
	
	@FindBy(id= "AddFile")
	public WebElement btnAddAttachmentTemp;
	
	@FindBy(id= "Attachment.TemplateId")
	public WebElement ddAttachmentName;
	
	@FindBy(id= "Select")
	public WebElement btnSelect;
	
	@FindBy(id= "AddAttachment")
	public WebElement btnAddAttachment;
	
	@FindBy(id= "AddFiles")
	public WebElement btnAddFiles;
	
	public AttachmentsPageElements() {
		PageFactory.initElements(driver, this);
	}	
}
