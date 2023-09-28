package aii.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.Select;

import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class AgentProfileSetup extends CommonMethods {

	@Then("User creates Agent Profiles with passing information from excel {string} sheet")
	public void User_creates_Agent_Profiles_with_passing_information_from_excel_sheet(String Agent) throws Exception {

		// Reading Input from an Excel document
		FileInputStream fis = new FileInputStream(new File(
				"\\C:\\Users\\CYavas\\Desktop\\User Setup Template.xls"));
		try (HSSFWorkbook wb = new HSSFWorkbook(fis)) {
			HSSFSheet sheet1 = wb.getSheetAt(0);

			// Counting Number of Rows from Excel
			int rowcount = sheet1.getLastRowNum();
			System.out.println("Total number of Transactions to be Created : " + rowcount);

			// Processing each row of the Excel

			for (int j = 1; j <= rowcount; j++) {

				try {
					driver.findElement(By.id("Menu_Admin")).click();
					driver.findElement(By.id("Menu_Admin_UserManagement")).click();
					driver.findElement(By.id("AddUser")).click();
					HSSFRow row = sheet1.getRow(j);
					// int i=0;

					HSSFCell UID = row.getCell(6);

					System.out.println("Creating User ID" + UID);

					String UID1 = UID.getRichStringCellValue().getString();

					driver.findElement(By.id("UserInfo.LoginId")).sendKeys(UID1);
					selectDropdownText(driver.findElement(By.id("UserInfo.TypeCd")), "Producer");
					driver.findElement(By.id("UserInfo.ConcurrentSessions")).sendKeys("50");
					selectDropdownText(driver.findElement(By.id("UserInfo.StatusCd")), "Active");
					selectDropdownText(driver.findElement(By.id("UserInfo.DefaultLanguageCd")),
							"English - United States");

					HSSFCell Fname = row.getCell(11);
					String Fname1 = Fname.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.FirstName")).sendKeys(Fname1);

					HSSFCell Lname = row.getCell(12);
					String Lname1 = Lname.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.LastName")).sendKeys(Lname1);

					HSSFCell addressLine1=row.getCell(13);
					String addressLine1Str=addressLine1.getRichStringCellValue().getString();
					HSSFCell addressLine2=row.getCell(14);
					String addressLine2Str=addressLine2.getRichStringCellValue().getString();
					
					driver.findElement(By.id("UserInfoWorkAddr.Addr1")).sendKeys(addressLine1Str +" "+addressLine2Str);
					
					HSSFCell city=row.getCell(15);
					String cityStr=city.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.City")).sendKeys(cityStr);
					
					HSSFCell state=row.getCell(16);
					String stateStr=state.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.StateProvCd")).sendKeys(stateStr);
					
					HSSFCell zipCode=row.getCell(17);
					String zipStr=zipCode.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.PostalCode")).sendKeys(zipStr);
					
					
					driver.findElement(By.id("UserInfoPhoneOne.PhoneName")).sendKeys("Business");
					
					HSSFCell phoneNumber=row.getCell(20);
					String phoneNumberStr=phoneNumber.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoPhoneOne.PhoneNumber")).sendKeys(phoneNumberStr);
					
					HSSFCell email=row.getCell(20);
					String emailStr=email.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.EmailAddr")).clear();
					driver.findElement(By.id("UserInfo.EmailAddr")).sendKeys(emailStr);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.id("UserInfoWorkAddr.addrVerifyImg")).click();
					Thread.sleep(2000);
					// driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElement(By.id("ChangePassword")).sendKeys("!pass1234");
					driver.findElement(By.id("ConfirmPassword")).sendKeys("!pass1234");
					
					HSSFCell UCode = row.getCell(23);
					String UCode1 = UCode.getRichStringCellValue().getString();
					driver.findElement(By.id("ProviderNumber")).clear();
					driver.findElement(By.id("ProviderNumber")).sendKeys(UCode1);
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();

					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					Thread.sleep(2000);

					driver.findElement(By.id("AddProviderSecurity")).click();

					driver.findElement(By.id("ProviderSecurity.ProviderSecurityCd")).sendKeys(UCode1);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();

					driver.findElement(By.id("AddProviderSecurity")).click();
					driver.findElement(By.id("ProviderSecurity.ProviderSecurityCd")).sendKeys("AG9034");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();

					driver.findElement(By.id("AddRole")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					driver.findElement(By.id("UserRole.AuthorityRoleIdRef")).sendKeys("PolicyAgentStandard");
					driver.findElement(By.id("UserRole.StartDt")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserRole.EndDt")).sendKeys("12/31/9999");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					// over riding features
					driver.findElement(By.id("OverrideRole_0")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					driver.findElement(By.id("UserRoleAttrValue_5_8")).sendKeys("No");
					driver.findElement(By.id("UserRoleAttrStartDt_5_8")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserRoleAttrEndDt_5_8")).sendKeys("12/31/9999");

					driver.findElement(By.id("UserRoleAttrValue_8_4")).sendKeys("Always");
					driver.findElement(By.id("UserRoleAttrStartDt_8_4")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserRoleAttrEndDt_8_4")).sendKeys("12/31/9999");

					driver.findElement(By.id("UserRoleAttrValue_8_42")).sendKeys("Always");
					driver.findElement(By.id("UserRoleAttrStartDt_8_42")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserRoleAttrEndDt_8_42")).sendKeys("12/31/9999");

					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();

					// AddTaskGroup
					driver.findElement(By.id("AddTaskGroup")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					System.out.println("Creating Producer ID " + UCode1);
					new Select(driver.findElement(By.id("UserTaskGroup.TaskGroupCd"))).selectByValue(UCode1);
					// driver.findElement(By.id("UserTaskGroup.TaskGroupCd")).sendKeys("Producer :
					// USAA Insurance Agency, Inc");
					driver.findElement(By.id("UserTaskGroup.StartDt")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserTaskGroup.EndDt")).sendKeys("12/31/9999");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					// String ConfirmMessage= driver.switchTo().alert().getText();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					FileOutputStream fws = new FileOutputStream(new File(
							"\\C:\\Users\\CYavas\\AI Automation\\UserIDResults.xls"));
					HSSFCell loginid = sheet1.getRow(j).createCell(0);
					HSSFCell pwd = sheet1.getRow(j).createCell(1);
					HSSFCell resultcell = sheet1.getRow(j).createCell(2);
					HSSFCell timecell = sheet1.getRow(j).createCell(3);
					loginid.setCellValue(UID1);
					resultcell.setCellValue("Success");
					pwd.setCellValue("password");
					LocalDateTime timestamp = LocalDateTime.now();
					timecell.setCellValue(String.valueOf(timestamp));
					wb.write(fws);
					System.out.println(UID1 + " Agent Onboarded Successfully");

					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				} catch (FileNotFoundException e) {
					System.out.println(" File not available");
					// String result1="Excel file not available";
					continue;

				} catch (IOException e) {
					System.out.println("Pending Transaction");
					// String result1="Pending Transaction";
					continue;

				} catch (NoSuchElementException exception) {
					System.out.println("Element not found exception");
					// String result1="Pending Transaction";
					continue;
				} catch (UnhandledAlertException e) {
					System.out.println("unhandled alert");
					Alert alert = driver.switchTo().alert();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					alert.accept();
					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					alert.accept();
					continue;
				}

			}
		}

	}
}
