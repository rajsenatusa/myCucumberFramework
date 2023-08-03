package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class FormsPageElements extends CommonMethods{
	
	@FindBy(id="AIICDP3OO_View")
	public WebElement btnAIICDP3OO0423;
	
	
	
public FormsPageElements() {
		
		PageFactory.initElements(driver, this);
	}
	
}
