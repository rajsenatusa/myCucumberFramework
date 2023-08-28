package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class UmbrellaLiabilityPageElements extends CommonMethods {
	
	@FindBy(id= "Line.PersonalLiabilityLimit")
	public WebElement ddUmbLimitCov;

	@FindBy(id= "Line.ExcessUMUIMLimit")
	public WebElement ddUninsuredLimit;
	
	@FindBy(id= "Question_NumAutomobiles")
	public WebElement txtNumberOfAuto;
	
	@FindBy(id= "Question_LiabilityDiscountInd")
	public WebElement ddLiabilityResidenceAtLeast500k;
	
	@FindBy(id= "AddPolicy")
	public WebElement btnAddPolicy;
	
	@FindBy(id= "Location.UnderlyingPolicyTypeCd")
	public WebElement ddTypeOfPolicy;
	
	@FindBy(id= "Location.UnderlyingPolicyNumber")
	public WebElement txtUnderlyingPolicyNumber;
	
	@FindBy(id= "Location.UnderlyingPolicyInd")
	public WebElement ddSelectPolicyWithAI;
	
	@FindBy(id= "UnderlyingExposureType")
	public WebElement ddSetExposureType;

	@FindBy(id= "Line.ExcessUMUIMLimit")
	public WebElement ddExcessUninsuredLiabilityLimit;
	
	@FindBy(id= "Location.UnderlyingCarrierName")
	public WebElement txtUnderlyingCarrierName;
	
	@FindBy(id= "Location.UnderlyingPolicyEffectiveDt")
	public WebElement txtUnderlyingEffectiveDate;
	
	@FindBy(id= "Location.UnderlyingPolicyExpirationDt")
	public WebElement txtUnderlyingExpirationDate;
	
	@FindBy(id= "Risk.ExposureTypeCd")
	public WebElement ddRiskExposureType;
	
	public UmbrellaLiabilityPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
