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
	
	@FindBy(id="History_1_2_TransactionCd")
	public WebElement txtEndorsement2;
	
	@FindBy(id= "img0")
	public WebElement btnExpand;
	
	@FindBy(id= "ReasonCd")
	public WebElement ddReason;
	
	@FindBy(id= "SubReasonCd")
	public WebElement ddSubReason;
	
	@FindBy(id= "Add")
	public WebElement btnAdd;
	
	@FindBy(id= "Start")
	public WebElement btnStart;
	
	@FindBy(id= "CancelRequestedByCd")
	public WebElement ddCancellationType;
	
	@FindBy(id= "TransactionEffectiveDt")
	public WebElement txtEffectiveDate;
	
	@FindBy(id= "CancelTypeCd")
	public WebElement ddCancelType;
	
	@FindBy(id= "NewPolicyEffectiveDt")
	public WebElement txtNewEffectiveDate;
	
	@FindBy(id= "Tab_History")
	public WebElement btnHistoryChevron;
	
	@FindBy(id= "TransactionLongDescription")
	public WebElement descriptionbox;
	
	@FindBy(id= "ViewAll")
	public WebElement btnViewAll;
	
	
	
	
	
	
	public HistoryPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}

}
