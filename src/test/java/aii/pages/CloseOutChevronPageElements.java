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
	public WebElement txtApplicationNumber;	

	@FindBy(id= "EnterCreditCardDetails")
	public WebElement btnEnterCCDetails;
	
	@FindBy(id= "CreditCardPrompCheckBox")
	public WebElement rbCCPrompt;
	
	@FindBy(id= "CreditCardPromptDivOk")
	public WebElement btnPromptOK;
	
	@FindBy(id= "ClaimSummary_ClaimTransactionNumber")
	public WebElement txtTransactionNumber;
	
	@FindBy(id= "Approve")
	public WebElement btnApprove;	
	
	@FindBy(xpath= "//span[normalize-space()='Endorse Policy']")
	public WebElement btnEndorsePolicy;
	
	@FindBy(id= "AccountSummary_CurrentDue")
	public WebElement txtCurrentDue;
	
	@FindBy(id= "PaymentTypeCd_2")
	public WebElement rbNewCreditCard;
	
	@FindBy(id= "ReceiptAmt")
	public WebElement txtEnterAmountBox;
	
	@FindBy(id= "ARSummary_PolicyNumber")
	public WebElement txtAccountNumber;
	
	public CloseOutChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
