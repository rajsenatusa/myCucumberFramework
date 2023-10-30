package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class ClaimPageElements extends CommonMethods{

	@FindBy(id= "Claim.LossDt")
	public WebElement txtLossDate;
	
	@FindBy(id= "Claim.ReportedBy")
	public WebElement ddClaimReportedBy;
	
	@FindBy(id= "Claim.LossCauseCd")
	public WebElement ddLossCause;
	
	@FindBy(id= "Claim.ContractorName")
	public WebElement txtContractorName;
	
	@FindBy(id= "Claim.CQHomeHabitable")
	public WebElement ddHomeHabitable;
	
	@FindBy(id= "Claim.AuthorityContacted")
	public WebElement ddAuthorityContacted;
	
	@FindBy(id= "Claim.Description")
	public WebElement txtClaimDescription;
	
	@FindBy(id= "Complete")
	public WebElement btnComplete;
	
	@FindBy(id= "Process")
	public WebElement btnProcess;
	
	@FindBy(id= "Claim.AuthorityName")
	public WebElement txtAuthorityName;
	
	@FindBy(id= "Claim.CaseNumber")
	public WebElement txtCaseNumber;
	
	@FindBy(id= "Claim.RiskIdRef")
	public WebElement ddClaimBoatSelection;
	
	@FindBy(id= "Claim.PurposeOfUse")
	public WebElement ddClaimPurposeUse;
	
	@FindBy(id= "Claim.DriverIdRef")
	public WebElement ddClaimOperator;
	
	@FindBy(id= "Claim.Roadway")
	public WebElement txtClaimCurrentLocation;
	
	@FindBy(id= "Claim.LossLocationDesc")
	public WebElement txtClaimLossDesc;
	
	@FindBy(id= "LossLocationAddr.City")
	public WebElement txtClaimCity;
	
	@FindBy(id= "LossLocationAddr.StateProvCd")
	public WebElement ddClaimState;
	
	@FindBy(id= "LossLocationAddr.PostalCode")
	public WebElement txtClaimPostalCode;
	
	@FindBy(id= "Save")
	public WebElement btnSave;
	
	@FindBy(id= "NewClaimant")
	public WebElement btnNewClaimant;
	
	@FindBy(id= "Claimant.ClaimantTypeCd")
	public WebElement ddClaimantType;
	
	@FindBy(id= "Claimant.ClaimantSubTypeCd")
	public WebElement ddClaimantSubType;
	
	@FindBy(id= "ClaimantName.GivenName")
	public WebElement txtClaimantFirstName;
	
	@FindBy(id= "ClaimantName.Surname")
	public WebElement txtClaimantLastName;
	
	@FindBy(id= "Reset")
	public WebElement btnReset;
	
	@FindBy(id= "ClaimantMailingAddr.Addr1")
	public WebElement txtClaimantAddress;
	
	@FindBy(id= "ClaimantMailingAddr.City")
	public WebElement txtClaimantCity;
	
	@FindBy(id= "ClaimantMailingAddr.PostalCode")
	public WebElement txtClaimantZipCode;
	
	@FindBy(id= "ClaimantMailingAddr.StateProvCd")
	public WebElement ddClaimantState;
	
	@FindBy(id= "ClaimantMailingAddr.addrVerifyImg")
	public WebElement btnClaimantVerifyAddress;
	
	@FindBy(id= "ClaimantPhonePrimary.PhoneName")
	public WebElement ddClaimantPhoneType;
	
	@FindBy(id= "ClaimantPhonePrimary.PhoneNumber")
	public WebElement txtClaimantPhoneNumber;
	
	@FindBy(id= "Wizard_Notice")
	public WebElement lnkNotice;
	
	@FindBy(id= "MoreActionsDropdownButton")
	public WebElement btnMore;
	
	@FindBy(id= "Transaction")
	public WebElement btnStartTransaction;
	
	@FindBy(id= "ClaimantActionsMenu_2")
	public WebElement btnFinanctialActions2;
	
	@FindBy(id= "ClaimantActionsMenu_1")
	public WebElement btnFinancialActions;
	
	@FindBy(id= "AdjustReserve_2")
	public WebElement btnAdjustReserves2;
	
	@FindBy(id= "Reserve_PUCov_Indemnity")
	public WebElement txtIndemnityReserve;
	
	@FindBy(id= "DenyTransaction_2")
	public WebElement btnDeny2;
	
	@FindBy(id= "Deny_Feature_PUCov")
	public WebElement rbReverseDenialUmbLiability;
	
	@FindBy(id= "ClaimantTransaction.Comment")
	public WebElement txtTransactionComment;
	
	@FindBy(id= "DenyDate_Feature_PUCov")
	public WebElement txtDenialDate;
	
	@FindBy(id= "Closeout")
	public WebElement btnFinalize;
	
	@FindBy(id= "MakePayment_1")
	public WebElement btnMakePayment;
	
	@FindBy(id= "ClaimantTransaction.PaymentTypeCd")
	public WebElement ddPaymentType;
	
	@FindBy(id= "Claim.SubLossCauseCd")
	public WebElement ddSubLossCause;
	
	public ClaimPageElements() {
		PageFactory.initElements(driver, this);
	}	
}
