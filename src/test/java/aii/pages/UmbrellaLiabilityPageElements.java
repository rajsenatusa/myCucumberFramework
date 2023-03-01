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
	

	public UmbrellaLiabilityPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
