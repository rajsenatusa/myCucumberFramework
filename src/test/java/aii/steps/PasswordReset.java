package aii.steps;

import aii.utils.CommonMethods;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.And;




//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;



public class PasswordReset extends CommonMethods {
	String FileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserList_ToRest.xlsx";
	
	
	@And ("I given all test user list to reset the password")
	public void i_given_all_test_user_list_to_reset_the_password_to() {
		String user="test user";
		Object[][] listofUsers;
		
		try {
		listofUsers = ExcelUtility.excelIntoArray(FileLocation, "Users");
		click(dashboard.btnAdmin);
		wait(1);
		click(dashboard.btnUserManagement);
		wait(1);

		
		for (int j=0;j<=listofUsers.length-1;j++) {
			user = listofUsers[j][0].toString();
		
		
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
		click(userLookup.btnChangePassword);
		if (IsVisible(userLookup.btnReturn)) {
			click(userLookup.btnReturn);
		}
		
		System.out.println("Password Changed Successfully for user - " + listofUsers[j][0].toString());
		}
		} catch (Exception  e) {
			System.out.println("Password Not Changed for user - " +user);
		}
}
}



