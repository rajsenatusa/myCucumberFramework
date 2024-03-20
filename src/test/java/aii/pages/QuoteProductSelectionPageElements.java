package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteProductSelectionPageElements extends CommonMethods{
	
	@FindBy (id= "BasicPolicy.EffectiveDt")
	public WebElement txtEffectiveDate;
	
	@FindBy (id= "NewDate")
	public WebElement txtNewDate;
	
	@FindBy (id= "NewBookDate")
	public WebElement txtNewBookDate;
	
	@FindBy (id= "TransactionEffectiveDt")
	public WebElement txtEndorsementEffectiveDate;
	
	@FindBy (id= "BasicPolicy.ControllingStateCd")
	public WebElement ddStateSelection;
	
	@FindBy (id= "BasicPolicy.CarrierGroupCd")
	public WebElement ddCarrierSelection;
	
	@FindBy (id= "Continue")
	public WebElement btnContinue; 
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Homeowners (HO3)']")
	public WebElement btnProductSelectionHo3;
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Renters (HO4)']")
	public WebElement btnProductSelectionHo4;
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Condominium Unit Owners (HO6)']")
	public WebElement btnProductSelectionHo6;
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Dwelling Property 1 (DP1)']")
	public WebElement btnProductSelectionDp1;
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Dwelling Property 3 (DP3)']")
	public WebElement btnProductSelectionDp3;
	
	@FindBy (xpath= "//a[normalize-space()='Voluntary Mobile Homeowners 3 (MHO3)']")
	public WebElement btnProductSelectionMho3;
	
	@FindBy (xpath= "//a[normalize-space()='Golf Cart (GOC)']")
	public WebElement btnProductSelectionGoc;
	
	@FindBy(xpath= "//a[normalize-space()='Voluntary Boat Owners (AIB)']")
	public WebElement btnProductSelectionAib;
	
	@FindBy(xpath= "//a[normalize-space()='Takeout Homeowners (HO3)']")
	public WebElement btnProductSelectionToho3;
	
	@FindBy(xpath= "//a[normalize-space()='Takeout Dwelling Property 1 (DP1)']")
	public WebElement btnProductSelectionTodp1;
	
	@FindBy(xpath= "//a[normalize-space()='Takeout Dwelling Property 3 (DP3)']")
	public WebElement btnProductSelectionTodp3;
	
	@FindBy(xpath= "//a[normalize-space()='Takeout Mobile Homeowners (MHO)']")
	public WebElement btnProductSelectionTomho;
	
	@FindBy(xpath= "//a[normalize-space()='Takeout Manufactured Physical Damage (MHPD)']")
	public WebElement btnProductSelectionTomhpd;
	
	@FindBy(xpath= "//a[normalize-space()='Voluntary Umbrella (UMB)']")
	public WebElement btnProductSelectionUmb;
	
	
	public QuoteProductSelectionPageElements() {
		PageFactory.initElements(driver, this);
	}

}
