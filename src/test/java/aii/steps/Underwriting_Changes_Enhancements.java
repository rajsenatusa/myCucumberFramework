package aii.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import aii.utils.CommonMethods;
import io.cucumber.java.en.And;

public class Underwriting_Changes_Enhancements extends CommonMethods {

	static String policyNum;

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
		wait(3);
		String expected = "Underwriting Clerk";
		String actual = quote.taskCurrentOwner.getText();
		Assert.assertEquals("Test failed!", expected, actual);

	}

	@And("User verifies Warning Message in Inbox")
	public void User_verifies_Warning_Message_in_Inbox() {
		wait(3);
		String expected = "Current Date: 10/08/2023";
		String actual = quote.dateFooterTile.getText();
		Assert.assertEquals("Test failed!", expected, actual);

	}

	@And("User clicks Changes Date")
	public void User_clicks_Changes_Date() {
		click(dashboard.btnChangeDate);
		wait(3);
		sendText(dashboard.txtNewDate, "10/08/2023");
		click(dashboard.btnChangeNewDate);
		wait(3);
		sendText(dashboard.txtNewBookDate, "10/08/2023");
		click(dashboard.btnChangeBookDate);
		wait(3);
	}

	@And("User clicks Home")
	public void User_clicks_Home() {
		click(dashboard.btnHome);
	}

	@And("User clicks Inbox")
	public void User_clicks_Inbox() {
		click(dashboard.btnInbox);
	}

	@And("User hovers over Admin")
	public void User_hovers_over_Admin() {
		wait(3);
		Actions action = new Actions(driver);
		action.moveToElement(dashboard.btnAdmin).perform();
		wait(2);
	}

	@And("User takes issued policy number")
	public void User_takes_issued_policy_number() {
		policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
		// Hooks.scenario.log("Policy Number: " + policyNum);
	}
//	@Then("User searches for DP3 policy number")
//	public void User_searches_for_DP3_policy_number() {	    	   							
//		sendText(dashboard.txtSearchBar, policyNum);
//		click(dashboard.search);
//		wait(3);

	@And("User clicks Ctrl+F")
	public void User_clicks_CtrlF() {
		Actions actions = new Actions(driver);

		// Perform Ctrl + F using the sendKeys method
		actions.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).perform();
		wait(1);
		// search word into CtrlF
		actions.sendKeys(policyNum).perform();
		wait(3);

	}

}
