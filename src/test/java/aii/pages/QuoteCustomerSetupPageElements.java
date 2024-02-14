package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteCustomerSetupPageElements extends CommonMethods {
	
	@FindBy (id= "CustomerName.GivenName")
	public WebElement txtFirstName;
	
	@FindBy (id= "CustomerName.Surname")
	public WebElement txtLastName;
	
	@FindBy (id= "InsuredName.GivenName")
	public WebElement txtGivenName;
	
	@FindBy (id= "InsuredName.Surname")
	public WebElement txtSurname;
	
	@FindBy (id= "InsuredPersonal.BirthDt")
	public WebElement txtPersonalBirthDt;
	
	@FindBy (id= "CustomerPersonal.BirthDt")
	public WebElement txtBirthDate;
	
	@FindBy (id= "CustomerName.CommercialName")
	public WebElement txtSearchName;
	
	@FindBy (id= "ResetCommercialName")
	public WebElement btnReset;
	
	@FindBy (id= "CustomerLookupAddr.PrimaryNumber")
	public WebElement txtAddress;
	
	@FindBy (id= "InsuredResidentAddr.PrimaryNumber")
	public WebElement txtAddressNumber;
	
	@FindBy (id= "InsuredResidentAddr.StreetName")
	public WebElement txtStreet;
	
	@FindBy (id= "InsuredResidentAddr.City")
	public WebElement txtCity;
	
	@FindBy (id= "InsuredResidentAddrCountyFillIn")
	public WebElement txtCounty;
		
	@FindBy (id= "CustomerLookupAddr.PostalCode")
	public WebElement txtZipCode;
	
	@FindBy (id= "InsuredResidentAddr.PostalCode")
	public WebElement txtPostalCode;
	
	@FindBy (id= "CustomerLookupAddr.addrVerifyImg")
	public WebElement btnVerifyAddress;
	
	@FindBy (id= "InsuredResidentAddr.addrVerifyImg")
	public WebElement btnVerifyAddress2;
	
	@FindBy (id= "DefaultAddress")
	public WebElement btnCopyToMailAddress;
	
	@FindBy (id= "CopyAddress")
	public WebElement btnCopyToBillAddress;
	
	@FindBy (id= "SaveAndQuote")
	public WebElement btnSaveAndQuote;
	
	@FindBy(id = "Menu_Policy")
	public WebElement btnQuoteAndPolicy;
	
	@FindBy(id = "MoreActionsDropdownButton")
	public WebElement btnMoreActionsDropdownButton;
	
	@FindBy(id = "MyInboxViews")
	public WebElement myInboxViews;
	
	@FindBy(id = "AddInboxView")
	public WebElement btnAddInboxView;
	
	@FindBy(id = "InboxView.Name")
	public WebElement inboxViewName;
	
	@FindBy(xpath = "//option[@value='AgencyStateProvCd']")
	public WebElement agencyState;
	
	@FindBy(id = "AddChosen")
	public WebElement addChosenArrow;
	
	@FindBy(id = "Return")
	public WebElement btnReturn;
	
	@FindBy(id = "InboxView.FilterWorkDate")
	public WebElement inboxViewFilterWorkDate;
	
	@FindBy(id = "InboxSelectOptionCd")
	public WebElement inboxSelectOptionCd;
	
	@FindBy(id = "InboxSelectionSearch")
	public WebElement btnRefreshInbox;
	
	@FindBy(id = "headerAgencyStateProvCd")
	public WebElement headerAgencyState;
	
	@FindBy(xpath = "//*[@id=\"Task_OriginalOwner_2\"]")
	public WebElement taskCurrentOwner;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[4]/footer[1]/div[2]/span[4]")
	public WebElement dateFooterTile;
	
	@FindBy(id= "CustomerNameJoint.GivenName")
	public WebElement txtJointFirstName;
	
	@FindBy(id= "CustomerNameJoint.Surname")
	public WebElement txtJointLastName;
	
	@FindBy(id= "CustomerPersonalJoint.BirthDt")
	public WebElement txtJointBirthday;
	
	@FindBy(id= "CustomerPhonePrimary.PhoneName")
	public WebElement ddcustomerPhonePrimaryPhoneName;
	
	@FindBy(id= "CustomerLookupAddr.StreetName")
	public WebElement customerLookupAddrStreetName;
	
	@FindBy(id= "CustomerLookupAddr.PostalCode")
	public WebElement customerLookupAddrPostalCode;
	
	
	
	
	public QuoteCustomerSetupPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
