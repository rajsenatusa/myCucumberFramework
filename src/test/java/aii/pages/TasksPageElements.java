package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class TasksPageElements extends CommonMethods{

	@FindBy(id= "Tab_Tasks")
	public WebElement lnkTasksTab;
	
	
public TasksPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
