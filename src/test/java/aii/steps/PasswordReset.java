package aii.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordReset2 {

	public static void main(String[] args) throws IOException, Exception {
		//Setup Chrome Driver Path
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SRajendran\\git\\spin-rpa1\\Driver\\chromedriver.exe");
				
				//Create Chrome Browser Driver
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
				LocalDateTime Starttime = LocalDateTime.now();
				System.out.println(Starttime);
				//Login in to Prod Environment
				driver.get("https://model2-aiig.in.guidewire.net/innovation?saml=off");
				driver.findElement(By.id("j_username")).sendKeys("GallopAdmin");
				driver.findElement(By.id("j_password")).sendKeys("Password@1143");
				driver.findElement(By.id("SignIn")).click();
				System.out.println("Chrome Browser Instantiated..");
				
				//driver.findElement(By.id("Menu_Admin")).click();
				//driver.findElement(By.id("Menu_Admin_UserManagement")).click();

				//Reading Input from an Excel document
				FileInputStream fis=new FileInputStream(new File("C:\\Users\\SRajendran\\git\\spin-rpa1\\ClaimProcess_Data\\UserID_List.xls"));
				@SuppressWarnings("resource")
				HSSFWorkbook wb=new HSSFWorkbook(fis);
				HSSFSheet sheet1=wb.getSheetAt(0);
				
				//Counting Number of Rows from Excel
				int rowcount=sheet1.getLastRowNum();
				System.out.println("Total number of Transactions to be Created : "+rowcount);
				
				//Processing each row of the Excel
				
				for(int j=1;j<=rowcount;j++)
				{
						
					try {
						driver.findElement(By.id("Menu_Admin")).click();
						driver.findElement(By.id("Menu_Admin_UserManagement")).click();
						HSSFRow row = sheet1.getRow(j);
						//int i=0;
									
						HSSFCell UID=row.getCell(5);

				
						System.out.println("Updating User ID "+UID);

						String UID1 = UID.getRichStringCellValue().getString();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElement(By.id("LoginId")).sendKeys(UID1);
						driver.findElement(By.id("SearchUser")).click();
						
						//driver.findElement(By.id("UserInfo.EmailAddr")).clear();
						//driver.findElement(By.id("UserInfo.EmailAddr")).sendKeys("FLUSAA@USAA.com");
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.findElement(By.id("UserInfoWorkAddr.addrVerifyImg")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("ChangePassword")).sendKeys("NewYear@2023");
						driver.findElement(By.id("ConfirmPassword")).sendKeys("NewYear@2023");
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						//driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						
						
						
						driver.findElement(By.xpath("//*[@id=\"Save\"]")).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						WebDriverWait wait = new WebDriverWait(driver, 90);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='Return']")));
						driver.findElement(By.xpath("//a[@id='Return']")).click();

					
						FileOutputStream fws=new FileOutputStream(new File("C:\\Users\\SRajendran\\git\\spin-rpa1\\ClaimProcess_Data\\Results.xls"));

						HSSFCell resultcell=sheet1.getRow(j).createCell(2); 
						HSSFCell timecell=sheet1.getRow(j).createCell(3);
					    resultcell.setCellValue("Success");
					    LocalDateTime timestamp = LocalDateTime.now();
					    timecell.setCellValue(String.valueOf(timestamp));
						wb.write(fws);
						
						
						System.out.println(UID1+" Updated Task Group");
						System.out.println("Remaining Agents to be created :"+(rowcount-j));
						
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='Return']")));
						driver.findElement(By.xpath("//a[@id='Return']")).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
								
					} catch (FileNotFoundException e) {
						System.out.println(" File not available");
						//String result1="Excel file not available";
						continue;
						
					} catch (IOException e) {
						System.out.println("Pending Transaction");
						//String result1="Pending Transaction";
						continue;
						
					} catch (NoSuchElementException exception ) {
						System.out.println("Element not found exception");
						//String result1="Pending Transaction";
						continue;
					} catch(UnhandledAlertException e) {
						System.out.println("unhandled alert");
						
						WebDriverWait wait = new WebDriverWait(driver, 90);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='Return']")));
						driver.findElement(By.xpath("//a[@id='Return']")).click();
						Alert alert = driver.switchTo().alert();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						alert.accept();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						continue;}	
					}
				driver.close();
	}
	//*[@id="Return"]

}




public class PasswordReset extends CommonMethods {

	@When("I enter given all users product selection information to reset user password")
	public void i_given_all_users_details_reset_password() {
		
		
	}
}