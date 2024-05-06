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
	
	@FindBy(id="BasicPolicy.PayPlanFilterTypeCd")
	public WebElement PayPlanFilterType;
	
	@FindBy(id="BasicPolicy.PaymentDay")
	public WebElement PaymentDay;
	
	@FindBy(id="EnterCreditCardDetails")
	public WebElement btnCreditCardDetails;
	
	@FindBy(id="CreditCardPrompCheckBox")
	public WebElement CreditCardPrompCheckBox;
	
	@FindBy(id="CreditCardPromptDivOk")
	public WebElement CreditCardPromptDivOk;
	
	@FindBy(id="Process")
	public WebElement ProcessBtn;
	
	@FindBy(id="BasicPolicy.PayPlanFilterTypeCd")
	public WebElement PayPlanFilter;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public BillingChevronPageElements() {
		
		PageFactory.initElements(driver, this);
		
	}
}
