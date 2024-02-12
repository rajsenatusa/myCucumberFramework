package aii.steps;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class AgentProfileSetup extends CommonMethods {

	@Then("User creates Agent Profiles with passing information from excel {string} sheet")
	public void User_creates_Agent_Profiles_with_passing_information_from_excel_sheet(String Agent) throws Exception {

		// Reading Input from an Excel document
		FileInputStream fis = new FileInputStream(new File(
				"\\C:\\Users\\CYavas\\git\\AutomationCucumber2023\\src\\test\\resources\\testddata\\User Setup Template.xls"));

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

					HSSFCell addressLine1 = row.getCell(13);
					String addressLine1Str = addressLine1.getRichStringCellValue().getString();
					HSSFCell addressLine2 = row.getCell(14);
					String addressLine2Str = addressLine2.getRichStringCellValue().getString();

					driver.findElement(By.id("UserInfoWorkAddr.Addr1"))
							.sendKeys(addressLine1Str + " " + addressLine2Str);

					HSSFCell city = row.getCell(15);
					String cityStr = city.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.City")).sendKeys(cityStr);

					HSSFCell state = row.getCell(16);
					String stateStr = state.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.StateProvCd")).sendKeys(stateStr);

					HSSFCell zipCode = row.getCell(17);
					String zipStr = zipCode.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.PostalCode")).sendKeys(zipStr);

					driver.findElement(By.id("UserInfoPhoneOne.PhoneName")).sendKeys("Business");

					HSSFCell phoneNumber = row.getCell(20);
					String phoneNumberStr = phoneNumber.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoPhoneOne.PhoneNumber")).sendKeys(phoneNumberStr);

					HSSFCell email = row.getCell(20);
					String emailStr = email.getRichStringCellValue().getString();
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
					FileOutputStream fws = new FileOutputStream(
							new File("\\C:\\Users\\CYavas\\AI Automation\\UserIDResults.xls"));
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
//-----------------------------------------oooooooooooooo-----------------------------------------------------------------------

	private void editRNIfEmpty(String ProductLine) {
		List<String> renlExpDatesBeforeEdit = new ArrayList<>();

		// Store expiration dates before edit
		List<WebElement> renlExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
				+ "')]/following-sibling::td[contains(@id, 'RenewalExpirationDt')]"));
		for (WebElement RnexpirationDateElement : renlExpDateElements) {
			try {
				String expirationDate = RnexpirationDateElement.getText();
				renlExpDatesBeforeEdit.add(expirationDate);
			} catch (StaleElementReferenceException e) {
				renlExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
						+ "')]/following-sibling::td[contains(@id, 'RenewalExpirationDt')]"));
			}
		}

		// Edit RenewalExpirationDt if empty
		if (!renlExpDateElements.isEmpty()) {
			for (WebElement RnexpirationDateElement : renlExpDateElements) {
				try {
					String expirationDate = RnexpirationDateElement.getText();

					// Check if the expiration date is empty
					if (expirationDate == null || expirationDate.trim().isEmpty() || expirationDate.isBlank()) {
					
						// Navigate to the parent row
						WebElement parentRow = RnexpirationDateElement.findElement(By.xpath("./ancestor::tr"));

						// Find the edit link within that row based on the product line
						WebElement editLink = parentRow
								.findElement(By.xpath(".//a[contains(@id, 'Product_" + ProductLine + "_FL_Edit')]"));
						Actions actions = new Actions(driver);
						actions.moveToElement(editLink).click().build().perform();
						sendText(driver.findElement(By.id("LicensedProduct.RenewalExpirationDt")), "02/01/2024");
						click(driver.findElement(By.id("Save")));
						wait(1);
						continue;
					}
				} catch (StaleElementReferenceException e) {
					renlExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
							+ "')]/following-sibling::td[contains(@id, 'RenewalExpirationDt')]"));
				}
			}
		}
		// Check for changes after edit
		List<String> renlExpDatesAfterEdit = new ArrayList<>();
		for (WebElement RnexpirationDateElement : renlExpDateElements) {
			try {
				String expirationDate = RnexpirationDateElement.getText();
				renlExpDatesAfterEdit.add(expirationDate);
			} catch (StaleElementReferenceException e) {
				renlExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
						+ "')]/following-sibling::td[contains(@id, 'RenewalExpirationDt')]"));
			}
		}

		// Compare before and after for RenewalExpirationDt
		if (!renlExpDatesBeforeEdit.isEmpty() && renlExpDatesBeforeEdit.size() == renlExpDatesAfterEdit.size()) {
			for (int i = 0; i < renlExpDatesBeforeEdit.size(); i++) {
				String beforeEdit = renlExpDatesBeforeEdit.get(i);
				String afterEdit = renlExpDatesAfterEdit.get(i);

				if (!beforeEdit.equals(afterEdit)) {
					System.out.println("RenewalExpirationDt updated successfully.");
				}
			}
		} else {
			System.out.println("Lists for RenewalExpirationDt are empty or have different sizes. Unable to compare.");
		}
	}

	private void editNBIfEmpty(String ProductLine) {
		List<String> nbExpDatesBeforeEdit = new ArrayList<>();

		// Store expiration dates before edit
		List<WebElement> nbExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
				+ "')]/following-sibling::td[contains(@id, 'NewExpirationDt')]"));

		for (WebElement NbexpirationDateElement : nbExpDateElements) {
			try {
				String expirationDate = NbexpirationDateElement.getText();
				nbExpDatesBeforeEdit.add(expirationDate);
			} catch (StaleElementReferenceException e) {
				nbExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
						+ "')]/following-sibling::td[contains(@id, 'NewExpirationDt')]"));
			}
		}

		// Edit NewExpirationDt if empty
		if (!nbExpDateElements.isEmpty()) {
			for (WebElement NbexpirationDateElement : nbExpDateElements) {
				try {
					String expirationDate = NbexpirationDateElement.getText();

					// Check if the expiration date is empty
					if (expirationDate == null || expirationDate.trim().isEmpty() || expirationDate.isBlank()) {
				
						// Navigate to the parent row
						WebElement parentRow = NbexpirationDateElement.findElement(By.xpath("./ancestor::tr"));

						// Find the edit link within that row based on the product line
						WebElement editLink = parentRow
								.findElement(By.xpath(".//a[contains(@id, 'Product_" + ProductLine + "_FL_Edit')]"));

						Actions actions = new Actions(driver);
						actions.moveToElement(editLink).click().build().perform();
						sendText(driver.findElement(By.id("LicensedProduct.NewExpirationDt")), "02/01/2024");
						click(driver.findElement(By.id("Save")));
						wait(1);
						continue;
					}
				} catch (StaleElementReferenceException e) {
					nbExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
							+ "')]/following-sibling::td[contains(@id, 'NewExpirationDt')]"));
				}
			}
		}
		// Check for changes after edit
		List<String> nbExpDatesAfterEdit = new ArrayList<>();
		for (WebElement NbexpirationDateElement : nbExpDateElements) {
			try {
				String expirationDate = NbexpirationDateElement.getText();
				nbExpDatesAfterEdit.add(expirationDate);
			} catch (StaleElementReferenceException e) {
				nbExpDateElements = driver.findElements(By.xpath("//td[contains(text(),'" + ProductLine
						+ "')]/following-sibling::td[contains(@id, 'NewExpirationDt')]"));
			}
		}

		// Compare before and after
		if (!nbExpDatesBeforeEdit.isEmpty() && nbExpDatesBeforeEdit.size() == nbExpDatesAfterEdit.size()) {
			for (int i = 0; i < nbExpDatesBeforeEdit.size(); i++) {
				String beforeEdit = nbExpDatesBeforeEdit.get(i);
				String afterEdit = nbExpDatesAfterEdit.get(i);

				if (!beforeEdit.equals(afterEdit)) {
					System.out.println("NewExpirationDt updated successfully.");
				}
			}
		} else {
			System.out.println("Lists are empty or have different sizes. Unable to compare.");
		}
	}

	@Then("User edits Agent Commissions with passing information from excel {string} sheet")
	public void User_edits_Agent_Commisions_with_passing_information_from_excel_sheet(String ProducerCode)
			throws Exception {

		// Reading Input from an Excel document
		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Users.xlsx"));

		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet sheet1 = wb.getSheetAt(0);

			// Counting Number of Rows from Excel
			int rowcount = sheet1.getLastRowNum();
			System.out.println("Total number of Transactions to be Created : " + rowcount);

			// Processing each row of the Excel

			for (int j = 0 ; j <= rowcount; j++) {

				try {
					driver.findElement(By.id("Menu_Policy")).click();
					driver.findElement(By.id("Menu_Policy_UnderwritingMaintenance")).click();
					clickOnAnyLink(driver, "Producer");
					XSSFRow row = sheet1.getRow(j);

					selectDropdownText(driver.findElement(By.id("SearchBy")), "Producer Code");

					// retrieving user ID from excel
					XSSFCell UID = row.getCell(0);

					System.out.println("Creating User ID" + UID);

					String UID1 = UID.getRichStringCellValue().getString();

					// searching User ID
					driver.findElement(By.id("SearchText")).sendKeys(UID1);
					click(driver.findElement(By.id("Search")));
					click(driver.findElement(By.id("Link_" + UID1 + "")));
					moveToElement(driver.findElement(By.id("AddProduct")));

					// selecting Product line and updating

					// GOC
					// edit current rate expiration dates

					editNBIfEmpty("GOC");
					editRNIfEmpty("GOC");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "GOC");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "10");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AIB
					// edit current rate expiration dates
					editNBIfEmpty("AIB");
					editRNIfEmpty("AIB");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AIB");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "10");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGR
					// edit current rate expiration dates
					editNBIfEmpty("AGR");
					editRNIfEmpty("AGR");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGR");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGM
					// edit current rate expiration dates
					editNBIfEmpty("AGM");
					editRNIfEmpty("AGM");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGM");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGH
					// edit current rate expiration dates
					editNBIfEmpty("AGH");
					editRNIfEmpty("AGH");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGH");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGD3
					// edit current rate expiration dates
					editNBIfEmpty("AGD3");
					editRNIfEmpty("AGD3");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGD3");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGD1
					// edit current rate expiration dates
					editNBIfEmpty("AGD1");
					editRNIfEmpty("AGD1");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGD1");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					// AGC
					// edit current rate expiration dates
					editNBIfEmpty("AGC");
					editRNIfEmpty("AGC");

					// adding new commmission rates
					click(driver.findElement(By.id("AddProduct")));
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), "AGC");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					sendText(driver.findElement(By.id("LicensedProduct.EffectiveDt")), "02/01/2024");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionNewPct")), "12");
					sendText(driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")), "7");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					click(driver.findElement(By.id("Save")));
					wait(1);

					click(driver.findElement(By.id("Return")));
					wait(1);

					// Making outcome report
					FileOutputStream fws = new FileOutputStream(
							new File("C:\\Users\\mcemek\\git\\AutomationCucumber2023\\test-output\\UserResults.xlsx"));
					XSSFCell ProdCode = sheet1.getRow(j).createCell(0);
					XSSFCell resultcell = sheet1.getRow(j).createCell(1);
					XSSFCell timecell = sheet1.getRow(j).createCell(2);
					ProdCode.setCellValue(UID1);
					resultcell.setCellValue("Success");
					LocalDateTime timestamp = LocalDateTime.now();
					timecell.setCellValue(String.valueOf(timestamp));
					wb.write(fws);
					System.out.println(UID1 + " Agent Commissions Rates Updated Successfully");

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
