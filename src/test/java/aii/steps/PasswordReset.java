package aii.steps;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import aii.utils.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PasswordReset extends CommonMethods {
	String FileLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserList_ToRest.xlsx";

	@And("User processes all test user list to reset the password")
	public void user_processes_all_test_user_list_to_reset_the_password_to() {
		String user = "test user";
		Object[][] listofUsers;

		try {
			listofUsers = ExcelUtility.excelIntoArray(FileLocation, "Users");
			click(dashboard.btnAdmin);
			wait(1);
			click(dashboard.btnUserManagement);
			wait(1);

			for (int j = 0; j <= listofUsers.length - 1; j++) {
				user = listofUsers[j][0].toString();

				selectDropdownText(userLookup.ddSearchBy, "User Code");
				selectDropdownText(userLookup.ddStartWith, "Equals");
				sendText(userLookup.txtSearchText, listofUsers[j][0].toString());
				click(userLookup.btnSearch);
				wait(3);
				click(userLookup.lnkResetPassword);

//		System.out.println(listofUsers[j][0].toString());
//		System.out.println(listofUsers[j][1].toString());

				sendText(userLookup.txtPassword, listofUsers[j][1].toString());
				sendText(userLookup.txtConfirmPassword, listofUsers[j][1].toString());
				click(userLookup.chkPasswordChangeNextLogin);
				click(userLookup.btnChangePassword);
				if (IsVisible(userLookup.btnReturn)) {
					click(userLookup.btnReturn);
				}

				System.out.println("Password Changed Successfully for user - " + listofUsers[j][0].toString());
			}
		} catch (Exception e) {
			System.out.println("Password Not Changed for user - " + user);
		}
	}

	@Then("User processes all test users password changes with desired")
	public void user_processes_all_test_users_password_changes_with_desired() throws Exception {
		String passToSet = "Dec@2023!";

		Object[][] updatedUsers = { { "zglover" },

				{ "TBrean" }, { "GGahrman" }, { "BLoomis" }, { "LRallo" }, { "mkoziel" }, { "MNickerson" },
				{ "pmadigan" }, { "TCrenshaw" }, { "LRambach" }, { "LZimmer" }, { "DCrouch" }, { "KOrmsby" },
				{ "JLockwood" }, { "JFoster" }, { "TPeck" }, { "PKnowles" }, { "WDennis" }, { "GWasson" },
				{ "MHammond" }, { "CKriss" }, { "CCastillo" }, { "NClay" }, { "JRitchie" }, { "TWatson" },
				{ "TMcDonald" }, { "BDaley" },

				{ "CdeGourville" }, { "Rvanhorn" }, { "LZalansky" }, { "JLowe" }, { "TSimmons" }, { "DGaldiano" },
				{ "JHall" }, { "TBrydon" }, { "OB24USER10" }, { "aiops" }, { "iscsops" }, { "JBarnes" }, { "GWasson" },
				{ "SUnderwood" },

				{ "AG1730" }, { "AG1777" }, { "AG4483" }, { "AG8166" }, { "AG6247" }, { "AG8086" }, { "AG1578" },
				{ "AG0376" }, { "AG2584" }, { "AG2602" }, { "AG1529" }, { "AG7740" }, { "AG7742" }, { "AG1171" },
				{ "AG3391" }, { "AG3959" }, { "AG1777A49" }, { "AG6583" }, { "AG8289" }, { "AG8735" }, { "AG3959" },
				{ "AG3391" }, { "AG1521" }, { "AG8908" }, { "AG8908A1" }, { "AG1171" }, { "AG8892" }, { "AG1529A2" },
				{ "AGISA006955" }, { "AG8134" }, { "AG8135" }, { "AGISA002537" }, { "AG5959" }, { "aallen" },
				{ "wdennis" },{ "adjuster1" },{ "adjuster2" },{ "underwriter1" },{ "csruw1" },

//		         //known terminated employees
				{ "LGrant" }, { "ABosma" }, { "JLEE" }, { "KSansome" }, { "CRosario" }, { "MLaing" }, { "NGraniela1" }

		};

		click(dashboard.btnAdmin);
		wait(2);
		click(dashboard.btnUserManagement);
		wait(1);

		for (Object[] user : updatedUsers) {
			String userId = (String) user[0];

			sendText(driver.findElement(By.id("SearchText")), userId);
			selectDropdownText(driver.findElement(By.id("MatchType")), "Equals");
			click(driver.findElement(By.id("Search")));
			wait(2);
			clickOnAnyLink(driver, "Reset Password");
			sendText(driver.findElement(By.id("NewPassword")), passToSet);
			sendText(driver.findElement(By.id("ConfirmNewPassword")), passToSet);
			wait(2);
			clickonAnyButton(driver, "UserInfo.PasswordMustChangeInd");
			wait(2);
			clickonAnyButton(driver, "ResetPassword");
			System.out.println("User id---> " + userId);
			wait(2);
		}
	}
}
