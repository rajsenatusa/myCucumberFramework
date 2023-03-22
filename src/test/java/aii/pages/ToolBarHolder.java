package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class ToolBarHolder extends CommonMethods {

	@FindBy(id= "QuickAction_ReportLoss_Holder")
	public WebElement btnReportLoss;
	
	@FindBy(id= "QuickAction_Report")
	public WebElement btnReport;
	
	
	
	public ToolBarHolder() {
		
		PageFactory.initElements(driver, this);
	}
}
