package aii.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import io.cucumber.java.en.When;

public class AutomationUserRolesCheckSetupBeforeRegression extends CommonMethods{

	
	@When("User clicks Add Role")
	public void user_clicks_add_role() {
		click(driver.findElement(By.id("AddRole")));
		wait(3);
	}
	@When("User selects Change Date from role dropdown")
	public void user_selects_change_date_from_role_dropdown() {
		selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Change Date");
		wait(1);
	}
	@When("User switches Site Admin Selection from No to Yes")
	public void user_switches_site_admin_selection_from_no_to_yes() {
		scrollToElement(driver.findElement(By.id("UserRoleAttrValue_5_116")));
		sendText(driver.findElement(By.id("UserRoleAttrValue_5_116")), "Yes");
	}
	@When("User searches Agent AG0376")
	public void user_searches_agent_ag0376() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG0376");
		wait(1);
	}
	@When("User clicks Return button")
	public void user_clicks_Return_button() {
		click(driver.findElement(By.id("Return")));
		waitImp(10);
	}
	@When("User changes password for AG0376")
	public void user_changes_password_for_ag0376() throws Exception {
		scrollToElement(driver.findElement(By.id("ChangePassword")));
		sendText(driver.findElement(By.id("ChangePassword")), ConfigsReader.getProperty("automationtestpassword"));
		sendText(driver.findElement(By.id("ConfirmPassword")), ConfigsReader.getProperty("automationtestpassword"));
		wait(1);
		click(driver.findElement(By.id("UserInfo.PasswordMustChangeInd")));
		wait(1);
		attachScreenShot(driver);
		click(userLookup.btnSave);
		waitImp(10);
	}
	@When("User searches Agent AG8166")
	public void user_searches_agent_ag8166() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG8166");
		wait(1);
	}
	@When("User changes password for AG8166")
	public void user_changes_password_for_ag8166() throws Exception {
		scrollToElement(driver.findElement(By.id("ChangePassword")));
		sendText(driver.findElement(By.id("ChangePassword")), ConfigsReader.getProperty("standardagent2password"));
		sendText(driver.findElement(By.id("ConfirmPassword")), ConfigsReader.getProperty("standardagent2password"));
		wait(1);
		click(driver.findElement(By.id("UserInfo.PasswordMustChangeInd")));
		wait(1);
		attachScreenShot(driver);
		click(userLookup.btnSave);
		waitImp(10);
	}
	@When("User searches Agent AG1529A2")
	public void user_searches_agent_ag1529a2() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "AG1529A2");
		wait(1);
	}
	@When("User changes password for AG1529A2")
	public void user_changes_password_for_AG1529A2() throws Exception {
		scrollToElement(driver.findElement(By.id("ChangePassword")));
		sendText(driver.findElement(By.id("ChangePassword")), ConfigsReader.getProperty("diamond2password"));
		sendText(driver.findElement(By.id("ConfirmPassword")), ConfigsReader.getProperty("diamond2password"));
		wait(1);
		click(driver.findElement(By.id("UserInfo.PasswordMustChangeInd")));
		wait(1);
		attachScreenShot(driver);
		click(userLookup.btnSave);
		waitImp(10);
	}
	@When("User searches Agent Adjuster 2")
	public void user_searches_agent_adjuster2() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "adjuster2");
		wait(1);
	}
	@When("User selects Adjuster 2 Role from roles dropdown")
	public void user_selects_adjuster2_role_from_roles_dropdown() {
		selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Adjuster II");
		wait(1);
	}
	@When("User searches Agent Adjuster1")
	public void user_searches_agent_adjuster1() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "Adjuster1");
		wait(1);
	}
	@When("User clicks Add User")
	public void user_clicks_add_user() {
		click(driver.findElement(By.id("AddUser")));
		wait(3);
	}
	@When("User enters all required information for claim manager role and creates user")
	public void user_enters_all_required_information_for_claim_manager_and_creates_user() {
		WebElement toClear = driver.findElement(By.id("UserInfo.LoginId"));
		toClear.click();
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		sendText(driver.findElement(By.id("UserInfo.LoginId")), "Claimmgr1");
		wait(1);
		selectDropdownText(driver.findElement(By.id("UserInfo.TypeCd")), "Company");
		selectDropdownText(driver.findElement(By.id("UserInfo.DefaultLanguageCd")), "English - United States");
		sendText(driver.findElement(By.id("UserInfo.FirstName")), "Claim");
		sendText(driver.findElement(By.id("UserInfo.LastName")), "Manager");
		sendText(driver.findElement(By.id("UserInfoWorkAddr.Addr1")), "5426 Bay Center Dr Ste 600");
		sendText(driver.findElement(By.id("UserInfoWorkAddr.City")), "Tampa");
		selectDropdownText(driver.findElement(By.id("UserInfoWorkAddr.StateProvCd")), "Florida");
		click(driver.findElement(By.id("UserInfoWorkAddr.addrVerifyImg")));
		wait(1);
		selectDropdownText(driver.findElement(By.id("UserInfoPhoneOne.PhoneName")), "Business");
		sendText(driver.findElement(By.id("UserInfoPhoneOne.PhoneNumber")), "(813) 880-7000");
		sendText(driver.findElement(By.id("UserInfo.EmailAddr")), "claimmgr1@aiiflorida.com");
		sendText(driver.findElement(By.id("ChangePassword")), ConfigsReader.getProperty("claimmgrpassword"));
		sendText(driver.findElement(By.id("ConfirmPassword")), ConfigsReader.getProperty("claimmgrpassword"));
		wait(1);
		click(driver.findElement(By.id("UserInfo.PasswordMustChangeInd")));
		wait(1);
		selectDropdownText(driver.findElement(By.id("UserInfo.BranchCd")), "Home Office");
		click(userLookup.btnSave);
		waitImp(10);
		click(driver.findElement(By.id("AddRole")));
		wait(3);
		selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Claim Manager");
		wait(1);
		click(userLookup.btnSave);
		wait(3);
		click(driver.findElement(By.id("AddTaskGroup")));
		wait(3);
		selectDropdownText(driver.findElement(By.id("UserTaskGroup.TaskGroupCd")), "ClaimsMgr");
		click(userLookup.btnSave);
		wait(3);
	}
	@When("User searches Agent Underwriter1")
	public void user_searches_agent_underwriter1() {
		wait(5);
		sendText(driver.findElement(By.id("LoginId")), "Underwriter1");
		wait(1);
	}
	@When("User selects Underwriter Role from role dropdown")
	public void user_selects_underwriter_role_from_role_dropdown() {
		selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Underwriter");
		wait(1);
	}
	@When("User deletes underwriter manager role from dropdown")
	public void user_deletes_underwriter_manager_role_from_role_dropdown() {
		click(driver.findElement(By.id("DeleteRole_0")));
		click(driver.findElement(By.id("dialogOK")));
		wait(2);
		click(userLookup.btnSave);
		wait(4);
	}
}
