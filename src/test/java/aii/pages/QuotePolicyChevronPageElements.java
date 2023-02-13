package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuotePolicyChevronPageElements extends CommonMethods {

	@FindBy(id= "BasicPolicy.PreviousCarrierCd")
	public WebElement previousCarrier;
	
	@FindBy(id= "BasicPolicy.PreviousExpirationDt")
	public WebElement previousPolicyExpDate;
	
	@FindBy(id= "Insured.InsuranceScoreEstimate")
	public WebElement insuranceScoreDd;
	
	@FindBy(id= "InsuredPhonePrimary.PhoneNumber")
	public WebElement phoneNumber;
	
	@FindBy(id= "InsuredPhonePrimary.PhoneName")
	public WebElement phoneNumberType;
	
	@FindBy(id= "InsuredEmail.NoEmailInd")
	public WebElement noEmailRadio;
	
	@FindBy(id= "ConstructionCd")
	public WebElement constructionTypeDd;
	
	@FindBy(id= "OccupancyCd")
	public WebElement occupancyDd;
	
	@FindBy(id="MonthsOccupied")
	public WebElement monthsOccupied;
	
	@FindBy(id= "Insured.PriorAddressInd")
	public WebElement insuredReside;
	
	@FindBy(id= "NextPage")
	public WebElement nextButton;
	
	@FindBy(id= "BasicPolicy.MobileHomeInd")
	public WebElement mobileHomeInd;
	
	@FindBy(id= "ShortTermRental")
	public WebElement shortTermRental;
	
	
	
	
	public QuotePolicyChevronPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
