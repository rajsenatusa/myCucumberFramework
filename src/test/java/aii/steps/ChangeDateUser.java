package aii.steps;

import org.openqa.selenium.By;

import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class ChangeDateUser extends CommonMethods {

	@Then("User adds change date attribute for desired listed users")
	public void user_adds_change_date_attribute_for_desired_listed_users() throws Exception {

		Object[][] updatedUsers = { { "TBrean" }, { "GGahrman" }, { "BLoomis" }, { "LRallo" }, { "mkoziel" },
				{ "MNickerson" }, { "pmadigan" }, { "TCrenshaw" }, { "LRambach" }, { "LZimmer" }, { "DCrouch" },
				{ "KOrmsby" }, { "JLockwood" }, { "JFoster" }, { "TPeck" }, { "PKnowles" }, { "WDennis" },
				{ "GWasson" }, { "MHammond" }, { "CKriss" }, { "CCastillo" }, { "NClay" }, { "JRitchie" },
				{ "TWatson" }, { "TMcDonald" }, { "BDaley" },

				{ "CdeGourville" }, { "Rvanhorn" }, { "LZalansky" }, { "JLowe" }, { "TSimmons" }, { "DGaldiano" },
				{ "JHall" }, { "TBrydon" }, { "OB24USER10" }, { "aiops" }, { "iscsops" }, { "JBarnes" }, { "GWasson" },
				{ "SUnderwood" },

				{ "AG1730" }, { "AG1777" }, { "AG4483" }, { "AG8166" }, { "AG6247" }, { "AG8086" }, { "AG1578" },
				{ "AG0376" }, { "AG2584" }, { "AG2602" }, { "AG1529" }, { "AG7740" }, { "AG7742" }, { "AG1171" },
				{ "AG3391" }, { "AG3959" }, { "AG1777A49" }, { "AG6583" }, { "AG8289" }, { "AG8735" }, { "AG3959" },
				{ "AG3391" }, { "AG1521" }, { "AG8908" }, { "AG8908A1" }, { "AG1171" }, { "AG8892" }, { "AG1529A2" },
				{ "AGISA006955" }, { "AG8134" }, { "AG8135" }, { "AGISA002537" }, { "AG5959" }, { "aallen" },
				{ "adjuster1" }, { "adjuster2" }, { "underwriter1" }, { "csruw1" },

//	            //known terminated employees
				{ "LGrant" }, { "ABosma" }, { "JLEE" }, { "KSansome" }, { "CRosario" }, { "MLaing" }, { "NGraniela1" }

		};

		click(dashboard.btnAdmin);
		wait(2);
		click(dashboard.btnUserManagement);
		wait(1);

		for (Object[] user : updatedUsers) {
			String userId = (String) user[0];

			sendText(driver.findElement(By.id("SearchText")), userId);
			click(driver.findElement(By.id("Search")));
			wait(2);
			clickAgentSearchedFor(driver, userId);
			wait(2);
			sendText(driver.findElement(By.id("UserInfo.ConcurrentSessions")), "50");
			wait(3);

			// Override Site-Admin attribute to Yes
			click(driver.findElement(By.id("OverrideRole_0")));
			wait(2);
			try {

				String defValue = driver
						.findElement(By.xpath("(//*[contains(text(),'Site-Admin')]//following::*[3])[1]")).getText()
						.toString();
				if (defValue.contains("Yes")) {

					click(driver.findElement(By.id("Return"))); // return to user management
					Thread.sleep(1000);
				} else {
					anyUserAttributeOverride(driver, "Site-Admin", "Yes");
					click(driver.findElement(By.id("Save")));
					wait(3);
					click(driver.findElement(By.id("Return"))); // return to user management
					Thread.sleep(1000);

				}
			} catch (Exception e) {
				Hooks.scenario.log("Unable to override Site-Admin attribute");
				System.out.print("There is issue with the issue " + userId);
				attachScreenShot(driver);
			}

			click(driver.findElement(By.id("AddRole")));
			wait(1);
			selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Change Date");
			wait(2);
			click(driver.findElement(By.id("Save")));
			wait(3);
			click(driver.findElement(By.id("Return")));
			wait(3);
			System.out.println("User id---> " + userId);
			wait(2);
		}
	}
}
