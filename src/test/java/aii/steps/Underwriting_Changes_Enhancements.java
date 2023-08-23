package aii.steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Underwriting_Changes_Enhancements extends CommonMethods {

	@And("User clicks on More button")
		public void User_clicks_on_More_button() {	    	   						
		click(quote.btnMoreActionsDropdownButton);		
		}
	@And("User clicks on My Inbox Views")
	public void User_clicks_on_My_Inbox_Views() {	    	   						
	click(quote.myInboxViews);		
	}	
	@And("User clicks on Add Inbox View button")
	public void User_clicks_on_Add_Inbox_View_button() {	    	   						
	click(quote.btnAddInboxView);		
	}
	@And("User enters a Name to View")
	public void User_enters_a_Name_to_View() {	    	   						
		sendText(quote.inboxViewName, "Add Agency State - JLowe");			
	}
	@And("User clicks on Agency State in Available Columns")
	public void User_clicks_on_Agency_State_in_Available_Columns() {	    	   						
		click(quote.agencyState);			
	}
	@And("User clicks on the Arrow")
	public void User_clicks_on_the_Arrow() {	    	   						
		click(quote.addChosenArrow);			
	}
	@And("User selects the Work Date")
	public void User_selects_the_Work_Date() {	    	   						
		selectDropdownText(quote.inboxViewFilterWorkDate, "Through Today"); 
		wait(1);		
	}	
	@And("User clicks Return to Home button")
	public void User_clicks_Return_to_Home_button() {	    	   						
		click(quote.btnReturn);			
	}
	@And("User clicks on Current Open")
	public void User_clicks_on_Current_Open() {	    	   						
		click(quote.inboxSelectOptionCd);			
	}
	@And("User selects the Name in View")
	public void User_selects_the_Name_in_View() {	    	   						
		wait(1);
		selectDropdown(quote.inboxSelectOptionCd, 3); 
		wait(1);		
	}
	@And("User clicks on Refresh Inbox")
	public void User_clicks_on_Refresh_Inbox() {	    	   						
		click(quote.btnRefreshInbox);			
	}
	@And("User verifies Agency State can be selected and added")
	public void User_verifies_Agency_State_can_be_selected_and_added() {	    	   						
		String expected = "Agency State";
		String actual = quote.headerAgencyState.getText();
		Assert.assertEquals("Test failed!", expected, actual);			
	}
	@And("User verifies Warning Message in Description")
	public void User_verifies_Warning_Message_in_Description() {	    	   						
		String expected = "Underwriting Clerk";
		String actual = quote.taskCurrentOwner.getText();
		Assert.assertEquals("Test failed!", expected, actual);	
		
		
		
		
		
	}
	
	 
}
