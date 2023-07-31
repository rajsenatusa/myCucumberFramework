package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuotePolicyChevronPageElements extends CommonMethods {

	@FindBy(id= "BasicPolicy.PreviousCarrierCd")
	public WebElement ddPreviousCarrier;
	
	@FindBy(id= "BasicPolicy.PreviousExpirationDt")
	public WebElement txtPreviousPolicyExpDate;
	
	@FindBy (id= "Insured.EntityTypeCd")
	public WebElement ddEntity;
	
	@FindBy (id= "InsuredName.GivenName")
	public WebElement txtInsuredFirstName;
	
	@FindBy (id= "InsuredName.Surname")
	public WebElement txtInsuredLastName;
	
	@FindBy (id= "InsuredPersonal.BirthDt")
	public WebElement txtInsuredBirthDt;
	
	@FindBy(id= "Insured.InsuranceScoreEstimate")
	public WebElement ddInsuranceScoreDd;
	
	@FindBy(id= "InsuredPhonePrimary.PhoneNumber")
	public WebElement txtPhoneNumber;
	
	@FindBy(id= "InsuredPhonePrimary.PhoneName")
	public WebElement ddPhoneNumberType;
	
	@FindBy(id= "InsuredEmail.NoEmailInd")
	public WebElement btnNoEmailRadio;
	
	@FindBy(id= "ConstructionCd")
	public WebElement ddConstructionType;
	
	@FindBy(id= "OccupancyCd")
	public WebElement ddOccupancy;
	
	@FindBy(id="MonthsOccupied")
	public WebElement ddMonthsOccupied;
	
	@FindBy(id="PropertyManagedInd")
	public WebElement ddPropertyManaged;
	
	@FindBy(id= "Insured.PriorAddressInd")
	public WebElement ddInsuredReside;
	
	@FindBy(id= "NextPage")
	public WebElement btnNext;
	
	@FindBy(id= "BasicPolicy.MobileHomeInd")
	public WebElement ddMobileHomeInd;
	
	@FindBy(id= "ShortTermRental")
	public WebElement ddShortTermRental;
	
	@FindBy(id= "BasicPolicy.MHPropertyTypeCd_2")
	public WebElement btnPropertyTypePri;
	
	@FindBy(id= "BasicPolicy.Coverage6MonthsInd")
	public WebElement ddCoverage6MonthsInd;
	
	@FindBy(id= "BasicPolicy.Garaged6MonthsInd")
	public WebElement ddGaraged6MonthsInd;
	
	@FindBy(id= "Wizard_Policy")
	public WebElement btnPolicyChevronLink;
	
	@FindBy(id= "ProviderNumber")
	public WebElement txtProducerCodeSel;
	
	@FindBy(id= "BasicPolicy.HOWithAIIGInd")
	public WebElement ddPolicyWrittenAiig;
	
	@FindBy(id= "BasicPolicy.AutoWithAgentInd")
	public WebElement ddAutoPolicy;
	
	@FindBy (id= "InsuredResidentAddr.StreetName")
	public WebElement txtStreet;
	
	@FindBy (id= "InsuredResidentAddr.PostalCode")
	public WebElement txtPostalCode;
	
	@FindBy (id= "ResetCommercialName")
	public WebElement btnResetName;
	
	@FindBy (id= "InsuredResidentAddr.addrVerifyImg")
	public WebElement btnVerifyAddress;
	
	@FindBy(id= "Save")
	public WebElement btnSave;
	
	@FindBy (id= "CancelRequestedByCd")
	public WebElement ddCancellationType;
	
	@FindBy (id= "ReasonCd")
	public WebElement ddReasonType;
	
	@FindBy (id= "Add")
	public WebElement btnAdd;
	
	@FindBy (id= "InsuredEmail.EmailAddr")
	public WebElement emailAddr;
	
	@FindBy (id= "BasicPolicy.MobileHomeInd")
	public WebElement ddMobileHome;
	
	@FindBy (id= "BasicPolicy.NewPurchase")
	public WebElement ddNewPurchase;
	
	@FindBy (id= "InsuredPersonal.MaritalStatusCd")
	public WebElement ddMaritalStatus;
	
	@FindBy (id= "Insured.ResidentSmokersInd")
	public WebElement ddResidentSmokers;
	
	@FindBy (id= "Insured.NumberOfAdultResident")
	public WebElement ddNumberAdultResident;
	
	@FindBy (id= "Insured.NumberOfChildrenResident")
	public WebElement ddNumberChildrenResident;
	
	public QuotePolicyChevronPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
