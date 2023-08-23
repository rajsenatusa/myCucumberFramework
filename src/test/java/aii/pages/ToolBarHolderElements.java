package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class ToolBarHolderElements extends CommonMethods {

	@FindBy(id= "QuickAction_ReportLoss_Holder")
	public WebElement btnReportLoss;
	
	@FindBy(id= "QuickAction_Report")
	public WebElement btnReport;
	
	@FindBy(id= "QuickAction_NewQuote_Holder")
	public WebElement btnNewQuote;
	
	@FindBy(id= "QuickAction_EffectiveDt")
	public WebElement txtEffectiveDate;
	
	@FindBy(id= "QuickAction_StateCd")
	public WebElement ddStateSelection;
	
	@FindBy(id= "QuickAction_NewQuote")
	public WebElement btnStartQuote;
	
	public ToolBarHolderElements() {
		
		PageFactory.initElements(driver, this);
	}
}
