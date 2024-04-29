package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class DataReportsChevronPageElements extends CommonMethods{
	
	@FindBy (id= "Tab_DataReports")
	public WebElement lnkDataReportsChevron;
	
	@FindBy (id= "OrderDataReport")
	public WebElement btnOrderDataReport;
	
	@FindBy (id= "DataReportRequest.TemplateIdRef")
	public WebElement ddDataReportSel;
	
	@FindBy (id= "Select")
	public WebElement btnSelect;
	
	@FindBy (id= "Order")
	public WebElement btnOrder;
	
	
	
	

	public DataReportsChevronPageElements() {
		PageFactory.initElements(driver, this);
	}

}
