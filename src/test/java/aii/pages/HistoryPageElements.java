package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class HistoryPageElements extends CommonMethods {
	
	@FindBy(id= "FullSummaryHolder")
	public WebElement btnsummaryTab;
		
	@FindBy(id= "History_1_1_TransactionCd")
	public WebElement newBusiness;
	
	@FindBy(id= "History_2_1_Description")
	public WebElement renewal;
	
	public HistoryPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
