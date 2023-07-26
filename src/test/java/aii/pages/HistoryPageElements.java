package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class HistoryPageElements extends CommonMethods {
	
	@FindBy(id= "FullSummaryHolder")
	public WebElement btnsummaryTab;
		
	@FindBy(id= "History_1_1_TransactionCd")
	public WebElement txtNewBusiness;
	
	@FindBy(id= "History_2_1_Description")
	public WebElement txtRenewal;
	
	@FindBy(id= "History_1_2_Description")
	public WebElement txtEndorsement;
	
	@FindBy(id= "PolicySummary_PolicyNumber")
	public WebElement txtPolicyNo;
	
	public HistoryPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
