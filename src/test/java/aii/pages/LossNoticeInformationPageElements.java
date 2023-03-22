package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class LossNoticeInformationPageElements extends CommonMethods {

	@FindBy(id= "Claim.LossDt")
	public WebElement txtlossDt;
	
	@FindBy(id= "Save")
	public WebElement btnContinue;
	
	@FindBy(id= "Claim.LossCauseCd")
	public WebElement lstLossCause;
	
	@FindBy(id= "Claim.CQHomeHabitable")
	public WebElement lstCQHomeHabitable;
	
	@FindBy(id= "Claim.AuthorityContacted")
	public WebElement lstAuthorityContacted;
	
	@FindBy(id= "Claim.AuthorityName")
	public WebElement lstAuthorityName;
	
	@FindBy(id= "Claim.CaseNumber")
	public WebElement lstCaseNumber;
	
	@FindBy(id= "Claim.CQFireRoomsAffected")
	public WebElement lstFireRoomsAffected;
	
	@FindBy(id= "Claim.CQFireFireOriginate")
	public WebElement lstFireOriginate;
	
	public LossNoticeInformationPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
