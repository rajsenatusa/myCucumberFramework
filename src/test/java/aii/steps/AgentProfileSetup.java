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

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import aii.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class AgentProfileSetup extends CommonMethods {

	@Then("User creates Agent Profiles with passing information from excel {string} sheet")
	public void User_creates_Agent_Profiles_with_passing_information_from_excel_sheet(String UserManagement) throws Exception {

		// Reading Input from an Excel document
		FileInputStream fis = new FileInputStream(new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserOnboarding.xlsx"));

		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet sheet1 = wb.getSheetAt(1);

			// Counting Number of Rows from Excel
			int rowcount = sheet1.getLastRowNum();
			System.out.println("Total number of Transactions to be Created : " + rowcount);

			// Processing each row of the Excel

			for (int j = 1; j <= rowcount; j++) {

				try {
					driver.findElement(By.id("Menu_Admin")).click();
					driver.findElement(By.id("Menu_Admin_UserManagement")).click();
					driver.findElement(By.id("AddUser")).click();
					XSSFRow row = sheet1.getRow(j);
					// int i=0;

					XSSFCell UID = row.getCell(5);

					System.out.println("Creating User ID " + UID);

					String UID1 = new DataFormatter().formatCellValue(UID);

					driver.findElement(By.id("UserInfo.LoginId")).sendKeys(UID1);
					selectDropdownText(driver.findElement(By.id("UserInfo.TypeCd")), "Producer");
					
					XSSFCell concSession=row.getCell(7);
					String concurrentSession=new DataFormatter().formatCellValue(concSession);
					sendText(driver.findElement(By.id("UserInfo.ConcurrentSessions")), concurrentSession);
					selectDropdownText(driver.findElement(By.id("UserInfo.StatusCd")), "Active");
					selectDropdownText(driver.findElement(By.id("UserInfo.DefaultLanguageCd")),
							"English - United States");

					XSSFCell Fname = row.getCell(10);
					String Fname1 = Fname.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.FirstName")).sendKeys(Fname1);

					XSSFCell Lname = row.getCell(11);
					String Lname1 = Lname.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.LastName")).sendKeys(Lname1);

					XSSFCell addressLine1 = row.getCell(12);
					String addressLine1Str = addressLine1.getRichStringCellValue().getString();
					XSSFCell addressLine2 = row.getCell(13);
					String addressLine2Str = addressLine2.getRichStringCellValue().getString();

					driver.findElement(By.id("UserInfoWorkAddr.Addr1"))
							.sendKeys(addressLine1Str + " " + addressLine2Str);

					XSSFCell city = row.getCell(14);
					String cityStr = city.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoWorkAddr.City")).sendKeys(cityStr);

//					XSSFCell state = row.getCell(16);
//					String stateStr = state.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("UserInfoWorkAddr.StateProvCd")), "Florida");

					XSSFCell zipCode = row.getCell(16);
					String zipStr = new DataFormatter().formatCellValue(zipCode);
					driver.findElement(By.id("UserInfoWorkAddr.PostalCode")).sendKeys(zipStr);

					selectDropdownText(driver.findElement(By.id("UserInfoPhoneOne.PhoneName")), "Business");

					XSSFCell phoneNumber = row.getCell(19);
					String phoneNumberStr = phoneNumber.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfoPhoneOne.PhoneNumber")).sendKeys(phoneNumberStr);

					selectDropdownText(driver.findElement(By.id("UserInfo.ToolbarSearchMode")), "Insured");					
					XSSFCell email = row.getCell(21);
					String emailStr = email.getRichStringCellValue().getString();
					driver.findElement(By.id("UserInfo.EmailAddr")).clear();
					driver.findElement(By.id("UserInfo.EmailAddr")).sendKeys(emailStr);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.id("UserInfoWorkAddr.addrVerifyImg")).click();
					Thread.sleep(2000);
					// driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					driver.findElement(By.id("ChangePassword")).sendKeys("!Pass1234");
					driver.findElement(By.id("ConfirmPassword")).sendKeys("!Pass1234");

					XSSFCell UCode = row.getCell(24);
					String UCode1 = UCode.getRichStringCellValue().getString();
					driver.findElement(By.id("ProviderNumber")).clear();
					driver.findElement(By.id("ProviderNumber")).sendKeys(UCode1);
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
//
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					Thread.sleep(2000);

//					driver.findElement(By.id("AddProviderSecurity")).click();
//
//					driver.findElement(By.id("ProviderSecurity.ProviderSecurityCd")).sendKeys(UCode1);
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();

//					driver.findElement(By.id("AddProviderSecurity")).click();
//					driver.findElement(By.id("ProviderSecurity.ProviderSecurityCd")).sendKeys("AG9034");
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();

					driver.findElement(By.id("AddRole")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					selectDropdownText(driver.findElement(By.id("UserRole.AuthorityRoleIdRef")), "Policy Agent Limited");
					driver.findElement(By.id("UserRole.StartDt")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserRole.EndDt")).sendKeys("12/31/9999");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//					// over riding features
//					driver.findElement(By.id("OverrideRole_0")).click();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//					driver.findElement(By.id("UserRoleAttrValue_5_8")).sendKeys("No");
//					driver.findElement(By.id("UserRoleAttrStartDt_5_8")).sendKeys("1/1/1901");
//					driver.findElement(By.id("UserRoleAttrEndDt_5_8")).sendKeys("12/31/9999");
//
//					driver.findElement(By.id("UserRoleAttrValue_8_4")).sendKeys("Always");
//					driver.findElement(By.id("UserRoleAttrStartDt_8_4")).sendKeys("1/1/1901");
//					driver.findElement(By.id("UserRoleAttrEndDt_8_4")).sendKeys("12/31/9999");
//
//					driver.findElement(By.id("UserRoleAttrValue_8_42")).sendKeys("Always");
//					driver.findElement(By.id("UserRoleAttrStartDt_8_42")).sendKeys("1/1/1901");
//					driver.findElement(By.id("UserRoleAttrEndDt_8_42")).sendKeys("12/31/9999");
//
//					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();

					// AddTaskGroup
					driver.findElement(By.id("AddTaskGroup")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					XSSFCell taskGrID = row.getCell(36);
					String taskGroupID = taskGrID.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("UserTaskGroup.TaskGroupCd")), taskGroupID);
				
					driver.findElement(By.id("UserTaskGroup.StartDt")).sendKeys("1/1/1901");
					driver.findElement(By.id("UserTaskGroup.EndDt")).sendKeys("12/31/9999");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					// String ConfirmMessage= driver.switchTo().alert().getText();
//					Alert alert = driver.switchTo().alert();
//					alert.accept();
					FileOutputStream fws = new FileOutputStream(
							new File("\\C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\UserProfileSetupResults.xlsx"));
					XSSFCell loginid = sheet1.getRow(j).createCell(0);
					XSSFCell pwd = sheet1.getRow(j).createCell(1);
					XSSFCell resultcell = sheet1.getRow(j).createCell(2);
					XSSFCell timecell = sheet1.getRow(j).createCell(3);
					loginid.setCellValue(UID1);
					resultcell.setCellValue("Success");
					pwd.setCellValue("!Pass1234");
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

			for (int j = 0; j <= rowcount; j++) {

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
							new File("C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\UserResults.xlsx"));
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

	// -----------------------------------------oooooooooooooo-----------------------------------------------------------------------

	@Then("User adds Agent Onboarding details with passing information from excel {string} sheet")
	public void User_adds_Agent_Onboarding_details_with_passing_information_from_excel_sheet(String UnderwritingMaintenance)
			throws Exception {

		// Navigating to User Onboarding Page
		driver.findElement(By.id("Menu_Policy")).click();
		driver.findElement(By.xpath("//*[@id=\"Menu_Policy_UnderwritingMaintenance\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"UnderwritingMaintenance\"]/table/tbody/tr[1]/td[1]/a")).click();

		// Reading Input from an Excel document
		FileInputStream fis = new FileInputStream(new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\UserOnboarding.xlsx"));
		try (XSSFWorkbook wbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet1 = wbook.getSheetAt(0);

			// Counting Number of Rows from Excel
			int rowcount = sheet1.getLastRowNum();
			System.out.println("Total number of Transactions to be Created : " + rowcount);

			// Processing each row of the Excel
			for (int j = 1; j <= rowcount; j++) {
				XSSFRow row = sheet1.getRow(j);
				// Skip if the row is null
			    if (row == null) {
			        System.out.println("Skipping null row at index: " + j);
			        continue;
			    }
//				try {
					driver.findElement(By.id("NewProducer")).click();
					
					int i = 5;

					XSSFCell PCode = row.getCell(i);
					System.out.println("Onboarding Producer code" + PCode);
					String Producercode = PCode.getRichStringCellValue().getString();
					driver.findElement(By.id("Provider.ProviderNumber")).sendKeys(Producercode);
					
					XSSFCell PType = row.getCell(i+1);
					String ProducerType=PType.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("ProducerTypeCd")), ProducerType);

					XSSFCell PAgency = row.getCell(i+2);
					if (PAgency == null || PAgency.getCellType() == CellType.BLANK) {
			            System.out.println("Skipping product part for row " + j + " as product information is blank");
//			            String ProducerAgency = PAgency.getRichStringCellValue().getString();
						
//						sendText(driver.findElement(By.id("ProducerAgency")),ProducerAgency);
						selectDropdownText(driver.findElement(By.id("AgentLevel")), "Take Out");
						selectDropdownText(driver.findElement(By.id("Provider.StatusCd")), "Active");

						driver.findElement(By.id("Provider.StatusDt")).sendKeys("3/1/2024");
						driver.findElement(By.id("AppointedDt")).sendKeys("3/1/2024");
						driver.findElement(By.id("AgencyPartnerProducerCd")).sendKeys("");

						XSSFCell BType = row.getCell(i+9);
						String BusinessType = BType.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("ProviderTaxInfo.LegalEntityCd")), BusinessType);

						XSSFCell BName = row.getCell(i+10);
						String BusinessName = BName.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderName.CommercialName")),BusinessName);
						
						XSSFCell PrinName = row.getCell(i+11);
						String PrincipalName = PrinName.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderName.GivenName")), PrincipalName);
						
						XSSFCell DBA = row.getCell(i+12);
						String DBAName = DBA.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderName.DBAName")),DBAName);

						// Street address section
						XSSFCell SAdd1=row.getCell(i+16);
						String SAddress1 = SAdd1.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderStreetAddr.Addr1")),SAddress1);
						
						XSSFCell SAdd2=row.getCell(i+17);
						String SAddress2 = SAdd2.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderStreetAddr.Addr2")),SAddress2);

						XSSFCell Scity=row.getCell(i+18);
						String Scity1 = Scity.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderStreetAddr.City")),Scity1);

						// HSSFCell Sstate=row.getCell(i+20);
						// String SState1 = Sstate.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("ProviderStreetAddr.StateProvCd")), "Florida");

						// System.out.println("entering address"+SState1);

						XSSFCell Szip=row.getCell(i+21);
						String Szip1 = new DataFormatter().formatCellValue(Szip);
						
						System.out.println("entering address"+Szip1);
	
						driver.findElement(By.id("ProviderStreetAddr.PostalCode")).sendKeys(Szip1);
//						sendText(driver.findElement(By.id("ProviderStreetAddr.PostalCode")), Szip1);
						

						// HSSFCell Scountry=row.getCell(i+22);
						// String Scounty1 = Scountry.getRichStringCellValue().getString();
						// driver.findElement(By.id("ProviderStreetAddr.RegionCd")).sendKeys("United
						// States");
						// Country is automatically detected by SPIN

						driver.findElement(By.id("ProviderStreetAddr.addrVerifyImg")).click();
						wait(1);
						System.out.println("Add1 Address Updated");
						Thread.sleep(2000);
//						driver.findElement(By.id("ProviderBillingAddr.Addr1")).sendKeys("2200 1st Ave S.");
//						driver.findElement(By.id("ProviderBillingAddr.Addr2")).sendKeys("Suite 300");
//						driver.findElement(By.id("ProviderBillingAddr.City")).sendKeys("Seattle");
//						selectDropdownText(driver.findElement(By.id("ProviderBillingAddr.StateProvCd")), "Washington");
//						driver.findElement(By.id("ProviderBillingAddr.PostalCode")).sendKeys("98134");
						
						// Copy Billing Address
						driver.findElement(By.id("CopyAddress")).click();

						XSSFCell EMail = row.getCell(i+35);
						String EmailAdd = EMail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderEmail.EmailAddr")),EmailAdd);
						System.out.println("Email Address Updated");
						wait(1);

						// Contact Section
						selectDropdownText(driver.findElement(By.id("ProviderPrimaryPhone.PhoneName")), "Business");
						XSSFCell Phone = row.getCell(i+33);
						String PhoneNumber = Phone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ProviderPrimaryPhone.PhoneNumber")),PhoneNumber);
						
						XSSFCell FaxNr = row.getCell(i+34);
						String FaxNumber = new DataFormatter().formatCellValue(FaxNr);
						sendText(driver.findElement(By.id("ProviderFax.PhoneNumber")), FaxNumber);
					
						selectDropdownText(driver.findElement(By.id("Provider.PreferredDeliveryMethod")), "Email");
						selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					
						XSSFCell SalesMan = row.getCell(i+38);
						String SalesManager = SalesMan.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("TerritorySalesManager")),SalesManager);
						selectDropdownText(driver.findElement(By.id("DirectPortalInd")), "No");

						// Accounting Information
						XSSFCell AccEnName = row.getCell(i+41);
						String AccoEntityName = AccEnName.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("AcctName.CommercialName")), AccoEntityName);
						
						XSSFCell AccEnName2 = row.getCell(i+45);
						String AccoEntityName2 = AccEnName2.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("AcctName.CommercialName2")), AccoEntityName2);
							
						selectDropdownText(driver.findElement(By.id("PayToCd")), "Agency");
						selectDropdownText(driver.findElement(By.id("Provider.CombinePaymentInd")), "Yes");
						selectDropdownText(driver.findElement(By.id("Provider.PaymentPreferenceCd")), "Check");

						// driver.findElement(By.id("CopyBillingAddress")).click();

						XSSFCell AcctMailingAddress1 = row.getCell(i+48);
						String AcctAddress1 = AcctMailingAddress1.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("AcctMailingAddr.Addr1")), AcctAddress1);
						
						XSSFCell AcctMailingAddress2 = row.getCell(i+49);
						String AcctAddress2 = AcctMailingAddress2.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("AcctMailingAddr.Addr2")), AcctAddress2);
						
						
						XSSFCell AcctMailingCity = row.getCell(i+50);
						String AcctCity = new DataFormatter().formatCellValue(AcctMailingCity);
						sendText(driver.findElement(By.id("AcctMailingAddr.City")), AcctCity);
			
						selectDropdownText(driver.findElement(By.id("AcctMailingAddr.StateProvCd")), "Florida");
						
						
						XSSFCell AcctMailingZip = row.getCell(i+53);
						String AcctZip = new DataFormatter().formatCellValue(AcctMailingZip);
						sendText(driver.findElement(By.id("AcctMailingAddr.PostalCode")), AcctZip);

						driver.findElement(By.id("AcctMailingAddr.addrVerifyImg")).click();
						wait(1);
						System.out.println("Mailing address Updated Address Updated");
						Thread.sleep(2000);

						// Tax Information
						selectDropdownText(driver.findElement(By.id("AcctTaxInfo.Required1099Ind")), "Yes");
						selectDropdownText(driver.findElement(By.id("AcctTaxInfo.TaxIdTypeCd")), "FEIN");
						
						XSSFCell AcctMailingTaxID = row.getCell(i+58);
						String TaxID = new DataFormatter().formatCellValue(AcctMailingTaxID);
						sendText(driver.findElement(By.id("TaxId")), TaxID);
						selectDropdownText(driver.findElement(By.id("AcctTaxInfo.ReceivedW9Ind")), "Yes");
						selectDropdownText(driver.findElement(By.id("AcctTaxInfo.WithholdingExemptInd")), "Yes");
						
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);

						// Contact List

						driver.findElement(By.id("AddContact")).click();
						XSSFCell CCname = row.getCell(i + 64);
						String CCname1 = CCname.getRichStringCellValue().getString();
						driver.findElement(By.id("ContactName.CommercialName")).sendKeys(CCname1);
						selectDropdownText(driver.findElement(By.id("Contact.ContactTypeCd")), "Sales");
						driver.findElement(By.id("ContactPerson.PositionTitle")).sendKeys("Producer");
						
						XSSFCell ContMailingAddress1 = row.getCell(i+67);
						String ContAddress1 = ContMailingAddress1.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ContactAddr.Addr1")), ContAddress1);
						
						XSSFCell ContMailingAddress2 = row.getCell(i+68);
						String ContAddress2 = ContMailingAddress2.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ContactAddr.Addr2")), ContAddress2);
						
						XSSFCell ContMailingCity = row.getCell(i+69);
						String ContCity = ContMailingCity.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ContactAddr.City")), ContCity);
						
						selectDropdownText(driver.findElement(By.id("ContactAddr.StateProvCd")), "Florida");
						
						XSSFCell ContMailingZip = row.getCell(i+71);
						String ContZip = new DataFormatter().formatCellValue(ContMailingZip);
						sendText(driver.findElement(By.id("ContactAddr.PostalCode")), ContZip);
						
						selectDropdownText(driver.findElement(By.id("ContactPhonePrimary.PhoneName")), "Business");
						XSSFCell ContPhone = row.getCell(i+73);
						String ContPhoneNr = ContPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("ContactPhonePrimary.PhoneNumber")), ContPhoneNr);
						
						XSSFCell ContFax = row.getCell(i+74);
						String ContFaxNr = new DataFormatter().formatCellValue(ContFax);
						sendText(driver.findElement(By.id("ContactFax.PhoneNumber")), ContFaxNr);
						
						XSSFCell Cemail = row.getCell(i + 75);
						String Cemail1 = Cemail.getRichStringCellValue().getString();
						driver.findElement(By.id("ContactEmail.EmailAddr")).sendKeys(Cemail1);
						selectDropdownText(driver.findElement(By.id("Contact.PreferredDeliveryMethod")), "Email");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);

						// AddState
						driver.findElement(By.id("AddState")).click();
						selectDropdownText(driver.findElement(By.id("StateInfo.StateCd")), "Florida");
						driver.findElement(By.id("StateInfo.AppointedDt")).sendKeys("3/15/2024");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);

						// Licensed Product Class List

						// Addproduct1 (AIH)
						
						XSSFCell stprod = row.getCell(i + 85);
						if (stprod == null || stprod.getCellType() == CellType.BLANK) {
				            System.out.println("Skipping product part for row " + j + " as product information is blank");
				        	
							//Service Portal Feature Overrides
							click(driver.findElement(By.id("OverrideFeatures")));
							wait(1);
							XSSFCell BillingPhone = row.getCell(i+139);
							String BillingPhoneNr = BillingPhone.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_0")), BillingPhoneNr);
							
							XSSFCell BillingEmail = row.getCell(i+140);
							String BillingEmailValue = BillingEmail.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_1")), BillingEmailValue);
							
							XSSFCell ClaimsPhone = row.getCell(i+142);
							String ClaimsPhoneNr = ClaimsPhone.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_2")), ClaimsPhoneNr);
							
							XSSFCell ClaimsEmail = row.getCell(i+143);
							String ClaimsEmailValue = ClaimsEmail.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_3")), ClaimsEmailValue);
							
							XSSFCell CoveragePhone = row.getCell(i+145);
							String CoveragePhoneNr = CoveragePhone.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_4")), CoveragePhoneNr);
							
							XSSFCell CoverageEmail = row.getCell(i+146);
							String CoverageEmailValue = CoverageEmail.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_5")), CoverageEmailValue);
							
							XSSFCell AddressPhone = row.getCell(i+148);
							String AddressPhoneNr = AddressPhone.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_6")), AddressPhoneNr);
							
							XSSFCell AddressEmail = row.getCell(i+149);
							String AddressEmailValue = AddressEmail.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_7")), AddressEmailValue);
							
							XSSFCell ContactPhone = row.getCell(i+151);
							String ContactPhoneNr = ContactPhone.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_8")), ContactPhoneNr);
							
							XSSFCell ContactEmail = row.getCell(i+152);
							String ContactEmailValue = ContactEmail.getRichStringCellValue().getString();
							sendText(driver.findElement(By.id("OverriddenContact_9")), ContactEmailValue);
							
							driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
							wait(1);
							
							FileOutputStream fws = new FileOutputStream(new File(
									"C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\AgentOnboardingResults.xlsx"));
							
							XSSFCell resultcell=sheet1.getRow(j).createCell(0); 
							XSSFCell timecell=sheet1.getRow(j).createCell(1);
						    resultcell.setCellValue("Success");
						    LocalDateTime timestamp = LocalDateTime.now();
						    timecell.setCellValue(String.valueOf(timestamp));
							wbook.write(fws);
							System.out.println("Agent Onboarded Successfully");

//							driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
//							wait(1);

				        }
						else {
						//Add product 1 (
						driver.findElement(By.id("AddProduct")).click();
						String stprod1 = stprod.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), stprod1);
						selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
						driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
						driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
						driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
						selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
						
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						}
						// Addproduct2 (ADF3)
						
						XSSFCell snprod = row.getCell(i + 96);
						if (snprod == null || snprod.getCellType() == CellType.BLANK) {
				            System.out.println("Skipping product part for row " + j + " as product information is blank");
				            
				        }
						else {
						driver.findElement(By.id("AddProduct")).click();
						String snprod1 = snprod.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), snprod1);
						selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
						driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
						driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
						driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
						selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						}
						// Addproduct3(ADF1)
						
						XSSFCell thprod = row.getCell(i + 107);
						if (thprod == null || thprod.getCellType() == CellType.BLANK) {
				            System.out.println("Skipping product part for row " + j + " as product information is blank");
				           
				        }
						else {
						driver.findElement(By.id("AddProduct")).click();
						String thprod1 = thprod.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), thprod1);
						selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
						driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
						driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
						driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
						selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						}
						// Addproduct4(AIM)
						
						XSSFCell fthprod = row.getCell(i + 118);
						if (fthprod == null || fthprod.getCellType() == CellType.BLANK) {
				            System.out.println("Skipping product part for row " + j + " as product information is blank");
				           
				        }
						else {
						driver.findElement(By.id("AddProduct")).click();
						String fthprod1 = fthprod.getRichStringCellValue().getString();
						selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), fthprod1);
						selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
						driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
						driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
						driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
						selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
						selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						}
						// Return to Main screen
						
						//Service Portal Feature Overrides
						click(driver.findElement(By.id("OverrideFeatures")));
						wait(1);
						XSSFCell BillingPhone = row.getCell(i+139);
						String BillingPhoneNr = BillingPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_0")), BillingPhoneNr);
						
						XSSFCell BillingEmail = row.getCell(i+140);
						String BillingEmailValue = BillingEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_1")), BillingEmailValue);
						
						XSSFCell ClaimsPhone = row.getCell(i+142);
						String ClaimsPhoneNr = ClaimsPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_2")), ClaimsPhoneNr);
						
						XSSFCell ClaimsEmail = row.getCell(i+143);
						String ClaimsEmailValue = ClaimsEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_3")), ClaimsEmailValue);
						
						XSSFCell CoveragePhone = row.getCell(i+145);
						String CoveragePhoneNr = CoveragePhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_4")), CoveragePhoneNr);
						
						XSSFCell CoverageEmail = row.getCell(i+146);
						String CoverageEmailValue = CoverageEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_5")), CoverageEmailValue);
						
						XSSFCell AddressPhone = row.getCell(i+148);
						String AddressPhoneNr = AddressPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_6")), AddressPhoneNr);
						
						XSSFCell AddressEmail = row.getCell(i+149);
						String AddressEmailValue = AddressEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_7")), AddressEmailValue);
						
						XSSFCell ContactPhone = row.getCell(i+151);
						String ContactPhoneNr = ContactPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_8")), ContactPhoneNr);
						
						XSSFCell ContactEmail = row.getCell(i+152);
						String ContactEmailValue = ContactEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_9")), ContactEmailValue);
						
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						
						FileOutputStream fws = new FileOutputStream(new File(
								"C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\AgentOnboardingResults.xlsx"));
						
						XSSFCell resultcell=sheet1.getRow(j).createCell(0); 
						XSSFCell timecell=sheet1.getRow(j).createCell(1);
					    resultcell.setCellValue("Success");
					    LocalDateTime timestamp = LocalDateTime.now();
					    timecell.setCellValue(String.valueOf(timestamp));
						wbook.write(fws);
						System.out.println("Agent Onboarded Successfully");

						driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
						wait(1);

			        }
					
					else {
					String ProducerAgency = PAgency.getRichStringCellValue().getString();
					
					sendText(driver.findElement(By.id("ProducerAgency")),ProducerAgency);
					selectDropdownText(driver.findElement(By.id("AgentLevel")), "Take Out");
					selectDropdownText(driver.findElement(By.id("Provider.StatusCd")), "Active");

					driver.findElement(By.id("Provider.StatusDt")).sendKeys("3/1/2024");
					driver.findElement(By.id("AppointedDt")).sendKeys("3/1/2024");
					driver.findElement(By.id("AgencyPartnerProducerCd")).sendKeys("");

					XSSFCell BType = row.getCell(i+9);
					String BusinessType = BType.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("ProviderTaxInfo.LegalEntityCd")), BusinessType);

					XSSFCell BName = row.getCell(i+10);
					String BusinessName = BName.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderName.CommercialName")),BusinessName);
					
					XSSFCell PrinName = row.getCell(i+11);
					String PrincipalName = PrinName.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderName.GivenName")), PrincipalName);
					
					XSSFCell DBA = row.getCell(i+12);
					String DBAName = DBA.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderName.DBAName")),DBAName);

					// Street address section
					XSSFCell SAdd1=row.getCell(i+16);
					String SAddress1 = SAdd1.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderStreetAddr.Addr1")),SAddress1);
					
					XSSFCell SAdd2=row.getCell(i+17);
					String SAddress2 = SAdd2.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderStreetAddr.Addr2")),SAddress2);

					XSSFCell Scity=row.getCell(i+18);
					String Scity1 = Scity.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderStreetAddr.City")),Scity1);

					// HSSFCell Sstate=row.getCell(i+20);
					// String SState1 = Sstate.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("ProviderStreetAddr.StateProvCd")), "Florida");

					// System.out.println("entering address"+SState1);

					XSSFCell Szip=row.getCell(i+21);
					String Szip1 = new DataFormatter().formatCellValue(Szip);
					System.out.println("entering address"+Szip1);
					sendText(driver.findElement(By.id("ProviderStreetAddr.PostalCode")), Szip1);
					

					// HSSFCell Scountry=row.getCell(i+22);
					// String Scounty1 = Scountry.getRichStringCellValue().getString();
					// driver.findElement(By.id("ProviderStreetAddr.RegionCd")).sendKeys("United
					// States");
					// Country is automatically detected by SPIN

					driver.findElement(By.id("ProviderStreetAddr.addrVerifyImg")).click();
					wait(1);
					System.out.println("Add1 Address Updated");
					Thread.sleep(2000);
//					driver.findElement(By.id("ProviderBillingAddr.Addr1")).sendKeys("2200 1st Ave S.");
//					driver.findElement(By.id("ProviderBillingAddr.Addr2")).sendKeys("Suite 300");
//					driver.findElement(By.id("ProviderBillingAddr.City")).sendKeys("Seattle");
//					selectDropdownText(driver.findElement(By.id("ProviderBillingAddr.StateProvCd")), "Washington");
//					driver.findElement(By.id("ProviderBillingAddr.PostalCode")).sendKeys("98134");
					
					// Copy Billing Address
					driver.findElement(By.id("CopyAddress")).click();

					XSSFCell EMail = row.getCell(i+35);
					String EmailAdd = EMail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderEmail.EmailAddr")),EmailAdd);
					System.out.println("Email Address Updated");
					wait(1);

					// Contact Section
					selectDropdownText(driver.findElement(By.id("ProviderPrimaryPhone.PhoneName")), "Business");
					XSSFCell Phone = row.getCell(i+33);
					String PhoneNumber = Phone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ProviderPrimaryPhone.PhoneNumber")),PhoneNumber);
				
					selectDropdownText(driver.findElement(By.id("Provider.PreferredDeliveryMethod")), "Email");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
				
					XSSFCell SalesMan = row.getCell(i+38);
					String SalesManager = SalesMan.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("TerritorySalesManager")),SalesManager);
					selectDropdownText(driver.findElement(By.id("DirectPortalInd")), "No");

					// Accounting Information
					XSSFCell AccEnName = row.getCell(i+41);
					String AccoEntityName = AccEnName.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("AcctName.CommercialName")), AccoEntityName);
					
					XSSFCell AccEnName2 = row.getCell(i+45);
					String AccoEntityName2 = AccEnName2.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("AcctName.CommercialName2")), AccoEntityName2);
						
					selectDropdownText(driver.findElement(By.id("PayToCd")), "Agency");
					selectDropdownText(driver.findElement(By.id("Provider.CombinePaymentInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("Provider.PaymentPreferenceCd")), "Check");

					// driver.findElement(By.id("CopyBillingAddress")).click();

					XSSFCell AcctMailingAddress1 = row.getCell(i+48);
					String AcctAddress1 = AcctMailingAddress1.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("AcctMailingAddr.Addr1")), AcctAddress1);
					
					XSSFCell AcctMailingAddress2 = row.getCell(i+49);
					String AcctAddress2 = AcctMailingAddress2.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("AcctMailingAddr.Addr2")), AcctAddress2);
					
					XSSFCell AcctMailingCity = row.getCell(i+50);
					String AcctCity = AcctMailingCity.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("AcctMailingAddr.City")), AcctCity);
		
					selectDropdownText(driver.findElement(By.id("AcctMailingAddr.StateProvCd")), "Florida");
					
		
					XSSFCell AcctMailingZip = row.getCell(i+53);
					String AcctZip = new DataFormatter().formatCellValue(AcctMailingZip);
					sendText(driver.findElement(By.id("AcctMailingAddr.PostalCode")), AcctZip);

					driver.findElement(By.id("AcctMailingAddr.addrVerifyImg")).click();
					wait(1);
					System.out.println("Mailing address Updated Address Updated");
					Thread.sleep(2000);

					// Tax Information
					selectDropdownText(driver.findElement(By.id("AcctTaxInfo.Required1099Ind")), "Yes");
					selectDropdownText(driver.findElement(By.id("AcctTaxInfo.TaxIdTypeCd")), "FEIN");
					
					XSSFCell AcctMailingTaxID = row.getCell(i+58);
					String TaxID = new DataFormatter().formatCellValue(AcctMailingTaxID);
					sendText(driver.findElement(By.id("TaxId")), TaxID);
					selectDropdownText(driver.findElement(By.id("AcctTaxInfo.ReceivedW9Ind")), "Yes");
					selectDropdownText(driver.findElement(By.id("AcctTaxInfo.WithholdingExemptInd")), "Yes");
					
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);

					// Contact List

					driver.findElement(By.id("AddContact")).click();
					XSSFCell CCname = row.getCell(i + 64);
					String CCname1 = CCname.getRichStringCellValue().getString();
					driver.findElement(By.id("ContactName.CommercialName")).sendKeys(CCname1);
					selectDropdownText(driver.findElement(By.id("Contact.ContactTypeCd")), "Sales");
					driver.findElement(By.id("ContactPerson.PositionTitle")).sendKeys("Producer");
					
					XSSFCell ContMailingAddress1 = row.getCell(i+67);
					String ContAddress1 = ContMailingAddress1.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ContactAddr.Addr1")), ContAddress1);
					
					XSSFCell ContMailingAddress2 = row.getCell(i+68);
					String ContAddress2 = ContMailingAddress2.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ContactAddr.Addr2")), ContAddress2);
					
					XSSFCell ContMailingCity = row.getCell(i+69);
					String ContCity = ContMailingCity.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ContactAddr.City")), ContCity);
					
					selectDropdownText(driver.findElement(By.id("ContactAddr.StateProvCd")), "Florida");
					
					
					XSSFCell ContMailingZip = row.getCell(i+71);
					String ContZip = new DataFormatter().formatCellValue(ContMailingZip);
					sendText(driver.findElement(By.id("ContactAddr.PostalCode")), ContZip);
					
					selectDropdownText(driver.findElement(By.id("ContactPhonePrimary.PhoneName")), "Business");
					XSSFCell ContPhone = row.getCell(i+73);
					String ContPhoneNr = ContPhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ContactPhonePrimary.PhoneNumber")), ContPhoneNr);
					
					XSSFCell ContFax = row.getCell(i+74);
					String ContFaxNr = ContFax.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("ContactFax.PhoneNumber")), ContFaxNr);
					
					XSSFCell Cemail = row.getCell(i + 75);
					String Cemail1 = Cemail.getRichStringCellValue().getString();
					driver.findElement(By.id("ContactEmail.EmailAddr")).sendKeys(Cemail1);
					selectDropdownText(driver.findElement(By.id("Contact.PreferredDeliveryMethod")), "Email");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);

					// AddState
					driver.findElement(By.id("AddState")).click();
					selectDropdownText(driver.findElement(By.id("StateInfo.StateCd")), "Florida");
					driver.findElement(By.id("StateInfo.AppointedDt")).sendKeys("3/15/2024");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);

					// Licensed Product Class List

					// Addproduct1 (AIH)
					
					XSSFCell stprod = row.getCell(i + 85);
					if (stprod == null || stprod.getCellType() == CellType.BLANK) {
			            System.out.println("Skipping product part for row " + j + " as product information is blank");
			        	
						//Service Portal Feature Overrides
			            click(driver.findElement(By.id("Return")));
						click(driver.findElement(By.id("OverrideFeatures")));
						wait(1);
						XSSFCell BillingPhone = row.getCell(i+139);
						String BillingPhoneNr = BillingPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_0")), BillingPhoneNr);
						
						XSSFCell BillingEmail = row.getCell(i+140);
						String BillingEmailValue = BillingEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_1")), BillingEmailValue);
						
						XSSFCell ClaimsPhone = row.getCell(i+142);
						String ClaimsPhoneNr = ClaimsPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_2")), ClaimsPhoneNr);
						
						XSSFCell ClaimsEmail = row.getCell(i+143);
						String ClaimsEmailValue = ClaimsEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_3")), ClaimsEmailValue);
						
						XSSFCell CoveragePhone = row.getCell(i+145);
						String CoveragePhoneNr = CoveragePhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_4")), CoveragePhoneNr);
						
						XSSFCell CoverageEmail = row.getCell(i+146);
						String CoverageEmailValue = CoverageEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_5")), CoverageEmailValue);
						
						XSSFCell AddressPhone = row.getCell(i+148);
						String AddressPhoneNr = AddressPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_6")), AddressPhoneNr);
						
						XSSFCell AddressEmail = row.getCell(i+149);
						String AddressEmailValue = AddressEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_7")), AddressEmailValue);
						
						XSSFCell ContactPhone = row.getCell(i+151);
						String ContactPhoneNr = ContactPhone.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_8")), ContactPhoneNr);
						
						XSSFCell ContactEmail = row.getCell(i+152);
						String ContactEmailValue = ContactEmail.getRichStringCellValue().getString();
						sendText(driver.findElement(By.id("OverriddenContact_9")), ContactEmailValue);
						
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						wait(1);
						
						FileOutputStream fws = new FileOutputStream(new File(
								"C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\AgentOnboardingResults.xlsx"));
						
						XSSFCell resultcell=sheet1.getRow(j).createCell(0); 
						XSSFCell timecell=sheet1.getRow(j).createCell(1);
					    resultcell.setCellValue("Success");
					    LocalDateTime timestamp = LocalDateTime.now();
					    timecell.setCellValue(String.valueOf(timestamp));
						wbook.write(fws);
						System.out.println("Agent Onboarded Successfully");

						driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
						wait(1);
//
//						driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
//						wait(1);

			        }
					else {
					driver.findElement(By.id("AddProduct")).click();
					String stprod1 = stprod.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), stprod1);
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
					driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
					driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
					
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);
					}
					// Addproduct2 (ADF3)
					
					XSSFCell snprod = row.getCell(i + 96);
					if (snprod == null || snprod.getCellType() == CellType.BLANK) {
			            System.out.println("Skipping product part for row " + j + " as product information is blank");
			            
			        }
					else {
					driver.findElement(By.id("AddProduct")).click();
					String snprod1 = snprod.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), snprod1);
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
					driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
					driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);
					}
					// Addproduct3(ADF1)
					
					XSSFCell thprod = row.getCell(i + 107);
					if (thprod == null || thprod.getCellType() == CellType.BLANK) {
			            System.out.println("Skipping product part for row " + j + " as product information is blank");
			            
			        }
					else {
					driver.findElement(By.id("AddProduct")).click();
					String thprod1 = thprod.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), thprod1);
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
					driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
					driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);
					}
					// Addproduct4(AIM)
					
					XSSFCell fthprod = row.getCell(i + 118);
					if (fthprod == null || fthprod.getCellType() == CellType.BLANK) {
			            System.out.println("Skipping product part for row " + j + " as product information is blank");
			            
			        }
					else {
					driver.findElement(By.id("AddProduct")).click();
					String fthprod1 = fthprod.getRichStringCellValue().getString();
					selectDropdownText(driver.findElement(By.id("LicensedProduct.LicenseClassCd")), fthprod1);
					selectDropdownText(driver.findElement(By.id("LicensedProduct.StateProvCd")), "Florida");
					driver.findElement(By.id("LicensedProduct.EffectiveDt")).sendKeys("3/15/2024");
					driver.findElement(By.id("LicensedProduct.CommissionNewPct")).sendKeys("8.00%");
					driver.findElement(By.id("LicensedProduct.CommissionRenewalPct")).sendKeys("8.00%");
					selectDropdownText(driver.findElement(By.id("TaskGroup")), "Underwriting");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayInd")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CommissionPayRule")), "Written");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAccreditedBuilder")), "No");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtInsuranceScore")), "Not Applicable");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtPriorCarrierLosses")), "Yes");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtFireAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtBurglarAlarmDefault")), "None");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtReservePackageDefault")), "Basic");
					selectDropdownText(driver.findElement(By.id("LicensedProduct.CtAgentOutput")), "No");
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);
					}
					// Return to Main screen
					
					//Service Portal Feature Overrides
					click(driver.findElement(By.id("OverrideFeatures")));
					wait(1);
					XSSFCell BillingPhone = row.getCell(i+139);
					String BillingPhoneNr = BillingPhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_0")), BillingPhoneNr);
					
					XSSFCell BillingEmail = row.getCell(i+140);
					String BillingEmailValue = BillingEmail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_1")), BillingEmailValue);
					
					XSSFCell ClaimsPhone = row.getCell(i+142);
					String ClaimsPhoneNr = ClaimsPhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_2")), ClaimsPhoneNr);
					
					XSSFCell ClaimsEmail = row.getCell(i+143);
					String ClaimsEmailValue = ClaimsEmail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_3")), ClaimsEmailValue);
					
					XSSFCell CoveragePhone = row.getCell(i+145);
					String CoveragePhoneNr = CoveragePhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_4")), CoveragePhoneNr);
					
					XSSFCell CoverageEmail = row.getCell(i+146);
					String CoverageEmailValue = CoverageEmail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_5")), CoverageEmailValue);
					
					XSSFCell AddressPhone = row.getCell(i+148);
					String AddressPhoneNr = AddressPhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_6")), AddressPhoneNr);
					
					XSSFCell AddressEmail = row.getCell(i+149);
					String AddressEmailValue = AddressEmail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_7")), AddressEmailValue);
					
					XSSFCell ContactPhone = row.getCell(i+151);
					String ContactPhoneNr = ContactPhone.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_8")), ContactPhoneNr);
					
					XSSFCell ContactEmail = row.getCell(i+152);
					String ContactEmailValue = ContactEmail.getRichStringCellValue().getString();
					sendText(driver.findElement(By.id("OverriddenContact_9")), ContactEmailValue);
					
					driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
					wait(1);
					
					FileOutputStream fws = new FileOutputStream(new File(
							"C:\\Users\\CYavas\\git\\AutomationCucumber2023\\test-output\\AgentOnboardingResults.xlsx"));
					
					XSSFCell resultcell=sheet1.getRow(j).createCell(0); 
					XSSFCell timecell=sheet1.getRow(j).createCell(1);
				    resultcell.setCellValue("Success");
				    LocalDateTime timestamp = LocalDateTime.now();
				    timecell.setCellValue(String.valueOf(timestamp));
					wbook.write(fws);
					System.out.println("Agent Onboarded Successfully");

					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					wait(1);

			}  //else
					
//				catch (FileNotFoundException e) {
//					System.out.println(" File not available");
//					// String result1="Excel file not available";
//					continue;

//				} catch (IOException e) {
//					System.out.println("Pending Transaction");
//					// String result1="Pending Transaction";
//					continue;
//
//				} catch (NoSuchElementException exception) {
//					System.out.println("Element not found exception");
//					// String result1="Pending Transaction";
//					continue;
//				} catch (UnhandledAlertException e) {
//					System.out.println("unhandled alert");
//					Alert alert = driver.switchTo().alert();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					alert.accept();
//					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
//					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//					alert.accept();
//					continue;
//				}
			}
		}

	}
}
