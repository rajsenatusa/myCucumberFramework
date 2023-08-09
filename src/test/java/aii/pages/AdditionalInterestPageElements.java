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
	
	
	public AdditionalInterestPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
