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
	
	public ClaimPageElements() {
		PageFactory.initElements(driver, this);
	}	
}
