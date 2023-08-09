package aii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aii.utils.CommonMethods;

public class TasksPageElements extends CommonMethods{

	@FindBy(id= "Tab_Tasks")
	public WebElement lnkTasksTab;
	
	@FindBy(id= "AddTask")
	public WebElement btnAddTask;
	
	@FindBy(id= "Task_TemplateId")
	public WebElement ddTaskType;
	
	@FindBy(id= "ShowAll")
	public WebElement btnShowAll;
	
public TasksPageElements() {
		
		PageFactory.initElements(driver, this);
	}
}
