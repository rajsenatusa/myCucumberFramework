package aii.cat;



import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import aii.utils.CommonMethods;
import aii.utils.ConfigsReader;

public class prnClaimsProcessing extends CommonMethods {
			public static void main(String[] args) throws Exception {

				//Once we extend Common Methods it automatically setting up driver below codes commented out
//				// Setup Chrome Driver Path
//				System.setProperty("webdriver.chrome.driver",
//						"C:\\Users\\SRajendran\\git\\spin-rpa\\Driver\\chromedriver.exe");
//
//				// Initialize chrome driver
//				WebDriver driver = new ChromeDriver();
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// 1- Login in to Prod/Model Environment
				 sendText(login.username, ConfigsReader.getProperty("username"));
				 sendText(login.password, ConfigsReader.getProperty("password"));
				 click(login.btnSignIn);
				 wait(3);
//				Login(driver);

				// 2-Read claims from Excel
				String ExcelPath = "C:\\Users\\SRajendran\\git\\spin-rpa\\ClaimProcess_Data\\PRN_FNOL_Inputs.xls";
				FileInputStream fis = new FileInputStream(new File(ExcelPath));
				@SuppressWarnings("resource")
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				HSSFSheet sheet = wb.getSheetAt(0);

				int allClaims = sheet.getLastRowNum();
				System.out.println("Total number of claims: " + allClaims);

				// Processing each row of the Excel
				for (int i = 1; i <= allClaims; i++) {

					try {
						HSSFRow row = sheet.getRow(i);
						HSSFCell cellOne = row.getCell(0);
						String claim = cellOne.getRichStringCellValue().getString();
						System.out.println(i + "-Processing Claim: " + claim);

						// 3-Search for claim
						searchClaim(driver, claim);

						// 4-Navigate to claim summary and capture claim description
						String claimDescription = captureClaimDescription(driver, claim);
						if(claimDescription.equalsIgnoreCase("numbers not matching")){
							break;
						}
						
						// 5-Navigate to Data Reports tab and order report
						navigateAndOrderReport(driver, claimDescription);

						// 6-Verify status/result and write to excel
						getWaitObject(); //doing the same thing with below command
						//	WebDriverWait wait = new WebDriverWait(driver, 90);
						waitForVisibility(driver.findElement(By.id("DataReport_0_StatusCd")));
						
						String status = driver.findElement(By.id("DataReport_0_StatusCd")).getText();
						String result = driver.findElement(By.id("DataReport_0_ResultCd")).getText();

						FileOutputStream fws = new FileOutputStream(
								new File(ExcelPath));
						sheet.getRow(i).createCell(1).setCellValue(status);
						sheet.getRow(i).createCell(2).setCellValue(result);
						sheet.getRow(i).createCell(3).setCellValue(claim+"-completed");
						wb.write(fws);
						//wb.close();
						//fws.close();
						System.out.println(claim + " Claim Processed Successfully");
						System.out.println("Remaining FNOL's To be processed :" + (allClaims - i));
						wait(30);

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
						wait(30);
						alert.accept();
						driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
						wait(30);
						alert.accept();
						continue;
					}
				}
				System.out.println("All Claims are processed Succesfully");
				driver.close();
			}

//			public static void Login(WebDriver driver) {
//				driver.get("https://ai.iscs.com/innovation");
//				//driver.get("https://model-ai.iscs.com/innovation");
//
//				driver.findElement(By.id("j_username")).sendKeys("gallopadmin");
//				driver.findElement(By.id("j_password")).sendKeys("AiiG@2070");
//
//				driver.findElement(By.id("SignIn")).click();
//				getWaitObject();
//				
//			//	WebDriverWait wait = new WebDriverWait(driver, 60);
//				waitForVisibility(driver.findElement(By.id("//div[@class='m_top']")));
//				
//			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='m_top']")));
//			}

			public static void searchClaim(WebDriver driver, String claim) {
				
				getWaitObject();
			//	WebDriverWait wait = new WebDriverWait(driver, 90);
				waitForVisibility(driver.findElement(By.id("ToolbarSearchText")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ToolbarSearchText")));
				driver.findElement(By.id("ToolbarSearchText")).clear();
				
				sendText(driver.findElement(By.id("ToolbarSearchText")),claim);
			//	driver.findElement(By.id("ToolbarSearchText")).sendKeys(claim);
				click(driver.findElement(By.id("ToolbarSearch")));
				
			//	driver.findElement(By.id("ToolbarSearch")).click();
			}
			
			public static String captureClaimDescription(WebDriver driver, String claim){
				
				getWaitObject();
			//	WebDriverWait wait = new WebDriverWait(driver, 90);
				waitForVisibility(driver.findElement(By.id("\"Wizard_Summary\"")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Wizard_Summary")));
				click(driver.findElement(By.id("Wizard_Summary")));
			//	driver.findElement(By.id("Wizard_Summary")).click();
				String ClaimDescriptionXpath = "//textarea[@name='Claim.Description']";
				waitForVisibility(driver.findElement(By.xpath(ClaimDescriptionXpath)));
			
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClaimDescriptionXpath)));
				String ClaimNumberInClaimSummaryXpath = "//td[@id='ClaimSummary_ClaimNumber']";
				
				
				WebElement ClaimNumberInClaimSummary = driver.findElement(By.xpath(ClaimNumberInClaimSummaryXpath));
				waitForVisibility(driver.findElement(By.xpath(ClaimNumberInClaimSummaryXpath)));
			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClaimNumberInClaimSummaryXpath)));
				if (!ClaimNumberInClaimSummary.getText().equalsIgnoreCase(claim)) {
					System.out.println("Claim from Excel and claim searched are not the same");
					return "numbers not matching";
				}else{
					// Get claim description
					String ClaimDescription = driver.findElement(By.xpath(ClaimDescriptionXpath)).getText();
					return ClaimDescription;
				}
			}
			
			public static void navigateAndOrderReport(WebDriver driver, String claimDescription){
				getWaitObject();
			//	WebDriverWait wait = new WebDriverWait(driver, 90);
				
				//Navigate to data reports tab
				String DataReportsTab = "//li/a[@id='Tab_DataReports']";
				
				click(driver.findElement(By.xpath(DataReportsTab)));
			//	driver.findElement(By.xpath(DataReportsTab)).click();

				String OrderDataReport = "//div/a[@id='OrderDataReport']";
				waitForVisibility(driver.findElement(By.xpath(OrderDataReport)));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OrderDataReport)));
				click(driver.findElement(By.xpath(OrderDataReport)));
			
			//	driver.findElement(By.xpath(OrderDataReport)).click();
				
				String SelectDataReport = "//tr/td/select[@name='DataReportRequest.TemplateIdRef']";
				waitForVisibility(driver.findElement(By.xpath(SelectDataReport)));
				
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectDataReport)));
				click(driver.findElement(By.xpath(SelectDataReport)));
				
			//	driver.findElement(By.xpath(SelectDataReport)).click();
				
				String DataReportDropdownValue = "//select/option[@value='XactAnalysisEstimateReport']";
				waitForVisibility(driver.findElement(By.xpath(DataReportDropdownValue)));
				
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DataReportDropdownValue)));
				click(driver.findElement(By.xpath(DataReportDropdownValue)));
				
			//	driver.findElement(By.xpath(DataReportDropdownValue)).click();
				
				String SelectButton = "//a[@id='Select']";
				waitForVisibility(driver.findElement(By.xpath(SelectButton)));
			
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectButton)));
				click(driver.findElement(By.xpath(SelectButton)));
			
			//	driver.findElement(By.xpath(SelectButton)).click();
				
				waitForVisibility(driver.findElement(By.xpath("//select/option[@value='Emergency']")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select/option[@value='Emergency']")));
				click(driver.findElement(By.xpath("//select/option[@value='Emergency']")));

			//	driver.findElement(By.xpath("//select/option[@value='Emergency']")).click();
				
				waitForVisibility(driver.findElement(By.xpath("//select/option[@value='2']")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select/option[@value='2']")));
				click(driver.findElement(By.xpath("//select/option[@value='2']")));
			//	driver.findElement(By.xpath("//select/option[@value='2']")).click();
				
				waitForVisibility(driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.InvolvedParty']/option[2]")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='XACTAnalysisReqCriteria.InvolvedParty']/option[2]")));
				click(driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.InvolvedParty']/option[2]")));
				
			//	driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.InvolvedParty']/option[2]")).click();

				waitForVisibility(driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.Location']/option[2]")));
			
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='XACTAnalysisReqCriteria.Location']/option[2]")));
				if(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='XACTAnalysisReqCriteria.Location']/option[2]"))!=null){
				 
					click(driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.Location']/option[2]")));
				    
			//	driver.findElement(By.xpath("//*[@id='XACTAnalysisReqCriteria.Location']/option[2]")).click();
			    }
				
				//preferredRepairNetwork is changed to Hancock Claims Consultants Investors, LLC
				waitForVisibility(driver.findElement(By.xpath("//select[@id='XACTAnalysisReqCriteria.DataSet']/option[@value='49502']")));
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='XACTAnalysisReqCriteria.DataSet']/option[@value='49502']")));
				click(driver.findElement(By.xpath("//select[@id='XACTAnalysisReqCriteria.DataSet']/option[@value='49502']")));
			
			//	driver.findElement(By.xpath("//select[@id='XACTAnalysisReqCriteria.DataSet']/option[@value='49502']")).click();
				
				sendText(driver.findElement(By.xpath("//textarea[@name='XACTAnalysisReqCriteria.Instructions']")),claimDescription);
				
			//	driver.findElement(By.xpath("//textarea[@name='XACTAnalysisReqCriteria.Instructions']")).clear();
			//	driver.findElement(By.xpath("//textarea[@name='XACTAnalysisReqCriteria.Instructions']")).sendKeys(claimDescription);
				
				waitForVisibility(driver.findElement(By.id("Order")));
			
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Order")));
			
				click(driver.findElement(By.id("Order")));
			
			//	driver.findElement(By.id("Order")).click();
			}
}


