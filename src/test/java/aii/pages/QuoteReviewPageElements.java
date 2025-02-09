package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteReviewPageElements extends CommonMethods {
	
	@FindBy(id= "BasicPolicy.PayPlanFilterTypeCd")
	public WebElement ddPayPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_7")
	public WebElement btnFullPaymentRadio;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_8")
	public WebElement btnFullPaymentRadioTO;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_9")
	public WebElement btn8PaymentPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_3")
	public WebElement btnQuarterlyPayPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_11")
	public WebElement btnMortgageeFullPay;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_30")
	public WebElement btn8ccPaymentPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_1")
	public WebElement btn4PaymentPlan;
	
	@FindBy(id= "Bind")
	public WebElement btnCreateApplication;
	
	@FindBy(id= "InsuranceScorePromptCheckBox")
	public WebElement btnInsuranceScoreBox;
	
	@FindBy(id= "InsuranceScorePromptOk")
	public WebElement btnInsuranceScoreOk;
	
	@FindBy(id= "Wizard_Review")
	public WebElement btnReview;
	
	@FindBy(id= "Tab_History")
	public WebElement btnHistory;
	
	@FindBy(id= "Wizard_PremiumInfo")
	public WebElement btnPremiumInfo;
	
	@FindBy(id= "Closeout")
	public WebElement btnFinalize; 
	
	@FindBy(id= "BasicPolicy.NCFDisclosureResponseInd")
	public WebElement ddOrderInsScore;
	
	@FindBy(id= "Process")
	public WebElement btnProcess;
	
	@FindBy(id= "Save")
	public WebElement btnSave;
	
	@FindBy(id= "TransactionInfo.PaymentTypeCd")
	public WebElement ddPaymentType;
	
	@FindBy(id= "QuickAction_MakePayment_Holder")
	public WebElement btnMakePayment;
	
	@FindBy(id= "QuickAction_SubmitPayment")
	public WebElement btnSubmitPayment;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_22")
	public WebElement rbQuarterlyPayPlan;
	
	@FindBy(id= "InstallmentSource.ACHBankAccountTypeCd")
	public WebElement ddBankAccountType;
	
	@FindBy(id= "InstallmentSource.ACHRoutingNumber")
	public WebElement txtRoutingNumber;
	
	@FindBy(id= "InstallmentSource.ACHBankAccountNumber")
	public WebElement txtAccountingNumber;
	
	@FindBy(id= "BasicPolicy.PaymentDay")
	public WebElement txtPaymentDay;
	
	@FindBy(id= "InstallmentSource.VerifyBankAccountNumber")
	public WebElement txtVerifyAccountNumber;
	
	@FindBy(id= "dialogOK")
	public WebElement btnDialogOk;
	
	@FindBy(id= "Wizard_Underwriting")
	public WebElement btnUnderwriting;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_10")
	public WebElement btn8PaymentPayPlanTO;
	
	@FindBy(id= "MakeChanges")
	public WebElement btnModifyApplication;
	
	@FindBy(id= "Tab_Notes")
	public WebElement btnNotes;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_18")
	public WebElement btnPayPlan4;
	
	@FindBy(id= "QuickEndorsement")
	public WebElement btnEndorse;
	
	@FindBy(id= "Wizard_Forms")
	public WebElement Forms;
	
	@FindBy(id= "Tab_Tasks")
	public WebElement Tasks;
	
	
	
	
	
	
	public QuoteReviewPageElements() {
		PageFactory.initElements(driver, this);
	}

}
