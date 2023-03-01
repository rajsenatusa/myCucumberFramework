package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class CloseOutChevronPageElements extends CommonMethods {
	
	@FindBy(id= "TransactionInfo.PaymentTypeCd")
	public WebElement ddPaymentType;
	
	@FindBy(id= "Process")
	public WebElement btnIssueNB;
	
	@FindBy(id= "SubmitForApproval")
	public WebElement btnSubmitApproval;
	
	@FindBy(id= "WorkflowComments")
	public WebElement txtWorkflowComments;	
	
	@FindBy(id= "QuoteAppSummary_QuoteAppNumber")
	public WebElement applicationNumber;
	
	
	public CloseOutChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
