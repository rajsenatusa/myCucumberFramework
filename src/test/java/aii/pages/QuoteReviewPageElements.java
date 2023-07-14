package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class QuoteReviewPageElements extends CommonMethods {
	
	@FindBy(id= "BasicPolicy.PayPlanFilterTypeCd")
	public WebElement ddPayPlan;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_7")
	public WebElement btnFullPaymentRadio;
	
	@FindBy(id= "BasicPolicy.PayPlanCd_8")
	public WebElement btnFullPaymentRadioTO;
	
	@FindBy(id= "Bind")
	public WebElement btnCreateApplication;
	
	@FindBy(id= "InsuranceScorePromptCheckBox")
	public WebElement btnInsuranceScoreBox;
	
	@FindBy(id= "InsuranceScorePromptOk")
	public WebElement btnInsuranceScoreOk;
	
	@FindBy(id= "Wizard_Review")
	public WebElement btnReview;
	
	@FindBy(id= "Closeout")
	public WebElement btnFinalize;
	
	@FindBy(id= "BasicPolicy.NCFDisclosureResponseInd")
	public WebElement ddOrderInsScore;
	
	@FindBy(id= "Process")
	public WebElement btnProcess;
	

	
	public QuoteReviewPageElements() {
		PageFactory.initElements(driver, this);
	}

}
