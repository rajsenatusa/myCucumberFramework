package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class AdditionalInterestPageElements extends CommonMethods{
	
	@FindBy(id= "Wizard_AdditionalInterests")
	public WebElement lnkAdditionalInterestChevron; 

	@FindBy(id= "AddAdditionalInterest")
	public WebElement btnAdditionalInterest;
	
	@FindBy(id= "AI.InterestCd")
	public WebElement txtMortgageeCode;
	
	@FindBy(id= "AI.InterestTypeCd")
	public WebElement ddInterestType;
	
	@FindBy(id= "AI.AccountNumber")
	public WebElement txtLoanNumber;
	
	@FindBy(id= "AI.EscrowInd")
	public WebElement ddEscrow;
	
	@FindBy(id= "Save")
	public WebElement Save;
	
	@FindBy(id= "AI.InterestName")
	public WebElement txtInterestName;
	
	@FindBy(id= "AIName.IndexName")
	public WebElement txtIndexName;
	
	@FindBy(id= "AIMailingAddr.Addr1")
	public WebElement txtMailingAddr;
	
	@FindBy(id= "AIMailingAddr.City")
	public WebElement txtMailingAddrCity;
	
	@FindBy(id= "AIMailingAddr.StateProvCd")
	public WebElement txtMailingAddrState;
	
	@FindBy(id= "AIMailingAddr.PostalCode")
	public WebElement txtMailingAddrPostalCode;
	
	@FindBy(id= "AIMailingAddr.RegionCd")
	public WebElement txtMailingAddrRegion;
	
	@FindBy(id= "AIMailingAddr.addrVerifyImg")
	public WebElement addrVerify;
	
	@FindBy(id= "AIList_1_Delete")
	public WebElement linkDelete;
	
	@FindBy(id= "dialogOK")
	public WebElement dialogOK;
	
	
	
	
	
	
	
	
	public AdditionalInterestPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
