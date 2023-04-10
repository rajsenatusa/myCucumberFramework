package aii.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PasswordReset extends CommonMethods {
	String FileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserList_ToRest.xlsx";
	
	@Then ("I given all test user list to reset the password to {string}")
	public void i_given_all_test_user_list_to_reset_the_password_to(String password) {
		String user="test user";
		Object[][] listofUsers;
		
		try {
		listofUsers = ExcelUtility.excelIntoArray(FileLocation, "Users");
		
		for (int j=0;j<=listofUsers.length-1;j++) {
			user = listofUsers[j][0].toString();
		click(dashboard.btnAdmin);
		wait(1);
		click(dashboard.btnUserManagement);
		wait(1);
		selectDropdownText(userLookup.ddSearchBy,"User Code");
		selectDropdownText(userLookup.ddStartWith,"Equals");
		sendText(userLookup.txtSearchText,listofUsers[j][0].toString());
		click(userLookup.btnSearch);
		wait(3);
		click(userLookup.lnkResetPassword);
		
//		System.out.println(listofUsers[j][0].toString());
//		System.out.println(listofUsers[j][1].toString());
		
		sendText(userLookup.txtPassword,listofUsers[j][1].toString());
		sendText(userLookup.txtConfirmPassword,listofUsers[j][1].toString());
		click(userLookup.chkPasswordChangeNextLogin);
//		click(userLookup.btnChangePassword);
		System.out.println("Password Changed Successfully for user -" + listofUsers[j][0].toString());
		}
		} catch (Exception  e) {
			System.out.println("Password Not Changed for user -" +user);
		}
}
}



