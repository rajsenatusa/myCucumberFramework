package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteReviewPageElements extends CommonMethods {
	
	@FindBy(id= "BasicPolicy.PayPlanFilterTypeCd")
	public WebElement payPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_7")
	public WebElement fullPaymentRadioButton;
	
	@FindBy(id= "Bind")
	public WebElement createApplication;
	
	@FindBy(id= "InsuranceScorePromptCheckBox")
	public WebElement insuranceScoreCheckBox;
	
	@FindBy(id= "InsuranceScorePromptOk")
	public WebElement insuranceScoreOkButton;
	
	@FindBy(id= "Wizard_Review")
	public WebElement reviewButton;
	
	@FindBy(id= "Closeout")
	public WebElement finalizeButton;
	
	@FindBy(id= "BasicPolicy.NCFDisclosureResponseInd")
	public WebElement orderInsScore;
	
	
	
	public QuoteReviewPageElements() {
		PageFactory.initElements(driver, this);
	}

}
