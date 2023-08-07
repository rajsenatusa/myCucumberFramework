package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class BatchJobsPageElements extends CommonMethods{
	
	@FindBy(id="Menu_Operations")
	public WebElement btnOperationsTab;
	
	@FindBy(id= "Menu_Operations_BatchJobs")
	public WebElement btnSelectBatch;
	
	@FindBy(id= "Daily Manual")
	public WebElement btnSelectDailyJob;
	
	@FindBy(id= "Question_PolicyNumber")
	public WebElement txtPolicyNumber;
	
	@FindBy(id= "Question_AccountNumber")
	public WebElement txtAccountNumber;
	
	@FindBy(id= "Skip_ActionACHExceptions")
	public WebElement btnProcessAchExceptions;
	
	@FindBy(id= "Skip_ActionAutomatedBatchReceiptPost")
	public WebElement btnAutomatedBatchReceiptsPost;
	
	@FindBy(id= "Skip_ActionScheduledAutomatedBatchReceiptPost")
	public WebElement btnScheduledAutomatedBatchReceiptPost;
	
	@FindBy(id= "Skip_ActionClaimScheduledPayment")
	public WebElement btnActionClaimScheduledPayment;
	
	@FindBy(id= "Skip_ActionAutomatedBatchPaymentsProcessACH")
	public WebElement btnReleaseAllTheStandardACHPAymentRequest_ClaimsPersonalACH;
	
	@FindBy(id= "Skip_ActionAutomatedBillingRefundsProcess")
	public WebElement btnReleaseAllTheStandardACHRefundRequest_AccountBill;
	
	@FindBy(id= "Skip_ActionPostingDate")
	public WebElement btnPostingDateRollForwardAction;
	
	@FindBy(id= "Skip_ActionDailyWrittenToReceivables")
	public WebElement btnDailyWrittenToReceivables;
	
	@FindBy(id= "Skip_ActionWrittenToReceivablesVerify")
	public WebElement btnDailyWrittenToReceivablesVerifyAction;
	
	@FindBy(id= "Skip_GLDailyGeneralLedger")
	public WebElement btnGLDailyGeneralLedger;
	
	@FindBy(id= "Skip_ActionIncrementalExport")
	public WebElement btnIncrementalDatamartExport;
	
	@FindBy(id= "Skip_ActionIncrementalRunDate")
	public WebElement btnUpdateIncrementalLastRunDate;
	
	@FindBy(id= "Skip_ActionIndemnityPaymentTask")
	public WebElement btnCompleteIndemnityPaymentReminderTask;
	
	@FindBy(id= "Skip_ActionInitiateStatsJob")
	public WebElement btnInitiateStatsJob;
	
	@FindBy(id= "Skip_ActionInitiateDailyTask")
	public WebElement btnInitiateDailyTaskAndBatchPrintJobs;
	
	@FindBy(id= "Skip_ActionDMIImport")
	public WebElement btnDMIFileImportAction;
	
	@FindBy(id= "Skip_ActionCapacityToolUpdate")
	public WebElement btnCapacityToolPolicyCountUpdate;
	
	@FindBy(id= "Skip_ActionBatchDailyBatchComplete")
	public WebElement btnDailyCycleCompleteionEmailNotifications;
	
	@FindBy(id= "Skip_ActionQuoteExpiration")
	public WebElement btnQuoteExpirationAction;
	
	@FindBy(id= "Skip_ActionMortgageeFIRSt266FileImport")
	public WebElement btnProcessPolicyMortgageeFIRST266FileImport;
	
	@FindBy(id= "Skip_ActionMortgageeInfoUpdateProcess")
	public WebElement btnProcessPolicyMortgageeInformationUpdate;
	
	@FindBy(id= "Skip_ActionBatchDailyBatchDailyJobErrorsNotify")
	public WebElement btnDailyEmailNotificationOfJobsWithErrors; 
	
	@FindBy(id= "StartJob")
	public WebElement btnStartJob;
	
	@FindBy(name= "RefreshInterval")
	public WebElement ddRefresh;
	
	
public BatchJobsPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	

}
