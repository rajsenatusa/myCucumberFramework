package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class HistoryPageElements extends CommonMethods {
	
	@FindBy(id= "FullSummaryHolder")
	public WebElement btnsummaryTab;
		
	
	public HistoryPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
