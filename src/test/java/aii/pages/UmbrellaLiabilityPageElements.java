package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class UmbrellaLiabilityPageElements extends CommonMethods {
	
	@FindBy(id= "Line.PersonalLiabilityLimit")
	public WebElement umbLimitCov;

	@FindBy(id= "Line.ExcessUMUIMLimit")
	public WebElement uninsuredLimit;
	
	@FindBy(id= "Question_NumAutomobiles")
	public WebElement numberOfAuto;
	

	public UmbrellaLiabilityPageElements() {
		PageFactory.initElements(driver, this);
		
	}
}
