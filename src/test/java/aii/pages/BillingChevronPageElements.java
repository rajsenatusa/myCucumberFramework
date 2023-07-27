package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class BillingChevronPageElements extends CommonMethods{

	@FindBy(id="Tab_Billing")
	public WebElement lnkBilling;
	
	@FindBy(id="_ChangePayPlan")
	public WebElement lnkChangePayPlan;
	
public BillingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}
}
