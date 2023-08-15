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
	
	
	public ClaimPageElements() {
		PageFactory.initElements(driver, this);
	}	
}
