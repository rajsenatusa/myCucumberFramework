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
	
	@FindBy(id= "QuickAction_MakePayment_Holder")
	public WebElement btnMakePaymentHolder;
	
	@FindBy(id= "QuickAction_SubmitPayment")
	public WebElement btnSubmitPaymentHolder;
	
	@FindBy(id= "eSignatureInd")
	public WebElement ddEsignature;
	
	@FindBy(id= "MissingFieldError")
	public WebElement msgMissingFieldError;
	
	@FindBy(id= "Signer_3_GivenName")
	public WebElement txtAgentFirstName;
	
	@FindBy(id= "Signer_3_Surname")
	public WebElement txtAgentLastName;
	
	@FindBy(id= "Signer_1_EmailAddr")
	public WebElement txtInsuredEmail;
	
	@FindBy(id= "Signer_3_EmailAddr")
	public WebElement txtAgentEmail;
	
	@FindBy(id= "Signer_3_LicenseNumber")
	public WebElement txtAgentLicenseNumber;
	
	@FindBy(id= "SigningStatus_0_0")
	public WebElement txtInsuredStatus;
	
	@FindBy(id= "SigningStatus_0_1")
	public WebElement txtAgentStatus;
	
	@FindBy(id= "BasicPolicy.PayPlanFilterTypeCd")
	public WebElement ddPlayPlanType;
	
	@FindBy(id= "dialogOK")
	public WebElement btnDialogOk;
	
	@FindBy(id= "MakeChanges")
	public WebElement btnModifyApplication;
	
	@FindBy(id= "ViewWorkflowComments")
	public WebElement btnViewWorkflowComments;
	
	@FindBy(id= "Process")
	public WebElement btnProcess;
	
	@FindBy(xpath= "//*[@id=\"ViewNotes\"]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/i")
	public WebElement btnIconExpand; 
	
	@FindBy(xpath= "//*[@id=\"ViewNotes\"]/div[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[1]/i")
	public WebElement btnIconExpandSecond; 
	
	@FindBy(xpath= "//*[@id=\"PolicyNotesList\"]/div/table/tbody/tr[2]/td[1]/i")
	public WebElement btnIconExpandWorkflow; 
	
	@FindBy(xpath= "//*[@id=\"ViewNotes\"]/div[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[1]/i")
	public WebElement btnIconExpandThird; 
	 
	 
	
	public CloseOutChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
