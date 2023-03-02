package aii.cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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
import org.openqa.selenium.chrome.ChromeOptions;

public class LNStatUtils {
	protected static String webDriverPath = "C:\\Users\\SRajendran\\git\\spin-rpa\\Driver\\chromedriver.exe";
	protected static String fnolFilePath = "C:\\Users\\SRajendran\\git\\spin-rpa\\ClaimProcess_Data\\FNOL_Inputs.xls";
	protected static String resultOutputFilePath ="C:\\Users\\SRajendran\\git\\spin-rpa\\ClaimProcess_Data\\";
	//protected static String fnolFilePath = "C:\\Users\\SRajendran\\Desktop\\ClaimProcess\\FNOL_Inputs.xls";
	//protected static String resultOutputFilePath ="C:\\Users\\SRajendran\\Desktop\\ClaimProcess\\Results.xls";
	protected static String networkServerPath ="http://ai1qacosa03.aiig.local:8190";
	protected String networkPath="http://ai1qacosa03.aiig.local:8190";
	protected static int successCount=0;
	protected static int failureCount=0;
	protected static int priorSuccessCount=0;
	protected static boolean portalRun = false;
	
	LNStatUtils(){
		LocalDateTime now = LocalDateTime.now();  
		String fileName="LNtoCL_Process_Results-"+now.getYear()+"-"+now.getMonth()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+now.getMinute()+"-"+now.getSecond()+".xls";
		String resultOutput =resultOutputFilePath+fileName;
		LNStatUtils.resultOutputFilePath=resultOutput;
	}
	
	public static  String getWebDriverPath() {
		return webDriverPath;
	}
	public static void setWebDriverPath(String webDriverPath) {
		LNStatUtils.webDriverPath = webDriverPath;
	}
	public static String getFnolFilePath() {
		return fnolFilePath;
	}
	public static void setFnolFilePath(String fnolFilePath) {
		LNStatUtils.fnolFilePath = fnolFilePath;
	}
	public static String getResultOutputFilePath() {
		return resultOutputFilePath;
	}
	public static void setResultOutputFilePath(String resultOutputFilePath) {
		LNStatUtils.resultOutputFilePath = resultOutputFilePath;
	}
	public String getNetworkServerPath() {
		return networkServerPath;
	}
	public void setNetworkServerPath(String networkServerPath) {
		LNStatUtils.networkServerPath = networkServerPath;
	}
	public static int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		LNStatUtils.successCount = successCount;
	}
	public static int getFailureCount() {
		return failureCount;
	}
	public void setFailureCount(int failureCount) {
		LNStatUtils.failureCount = failureCount;
	}
	public static int getPriorSuccessCount() {
		return priorSuccessCount;
	}
	public void setPriorSuccessCount(int priorSuccessCount) {
		LNStatUtils.priorSuccessCount = priorSuccessCount;
	}

	public static void successCountAddOne() {
		successCount++;
	}
	public static void failureCountAddOne() {
		failureCount++;
	}
	public static void priorSuccessCountAddOne() {
		priorSuccessCount++;
	}
	
	public String getNetworkPath() {
		return networkPath;
	}
	public void setNetworkPath(String networkPath) {
		this.networkPath = networkPath;
	}
	
	public static boolean isPortalRun() {
		return portalRun;
	}

	public static void setPortalRun(boolean portalRun) {
		LNStatUtils.portalRun = portalRun;
	}

	public static void printToFile(String message, HSSFSheet sheet1,HSSFWorkbook wb,int row,String claimString, String reportedTo) throws IOException {
		FileOutputStream fws = new FileOutputStream(new File(getResultOutputFilePath()));

		HSSFCell claimno1=sheet1.getRow(row).createCell(3);
		HSSFCell resultcell=sheet1.getRow(row).createCell(4);
		
		HSSFCell timecell=sheet1.getRow(row).createCell(5);
		claimno1.setCellValue(claimString);
	    resultcell.setCellValue(message);
	  
	    LocalDateTime timestamp = LocalDateTime.now();
	    timecell.setCellValue(String.valueOf(timestamp));

		HSSFCell reportedCell2=sheet1.getRow(row).createCell(6);
		reportedCell2.setCellValue(reportedTo);	
		
		//LNs completed through the current automation process

		HSSFCell successCountCell2=	sheet1.getRow(1).createCell(7);
		successCountCell2.setCellValue(getSuccessCount());
		
		//Previously Completed LNs that went through successfully
		HSSFCell previouslyRanCell=sheet1.getRow(0).createCell(8);
		previouslyRanCell.setCellValue("Previously Completed");
		HSSFCell previouslyRanCell2=sheet1.getRow(1).createCell(8);
		previouslyRanCell2.setCellValue(getPriorSuccessCount());
		
		//LN process failure count
		HSSFCell failureCell2=sheet1.getRow(1).createCell(9);
		failureCell2.setCellValue(getFailureCount());
		wb.write(fws);
		
	}
	
	public static void processOnNetwork()  throws Exception{
		//Setup Chrome Driver Path
		Instant start = Instant.now();
		
		System.setProperty("webdriver.chrome.driver", getWebDriverPath());
		
		//Create Chrome Browser Driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		LocalDateTime Starttime = LocalDateTime.now();
		System.out.println(Starttime);
		
		//Login in to Prod Environment
		
		driver.get("https://ai.iscs.com/innovation");
		
		//driver.get("https://model-ai.iscs.com/innovation");
				
		
		driver.findElement(By.id("j_username")).sendKeys("gallopadmin");
		driver.findElement(By.id("j_password")).sendKeys("AiiG@2070");
		
//		driver.findElement(By.id("j_username")).sendKeys("srajendran");
//		driver.findElement(By.id("j_password")).sendKeys("Password@1143");
		
		driver.findElement(By.id("SignIn")).click();
		System.out.println("Chrome Browser Instantiated..");
		
		//driver.findElement(By.id("Menu_Admin")).click();
		//driver.findElement(By.id("Menu_Admin_UserManagement")).click();
		
		//Reading Input from an Excel document
		
		FileInputStream fis=new FileInputStream(new File(getFnolFilePath()));
		File outputFile = new File(getResultOutputFilePath());
		outputFile.canWrite();
		outputFile.canRead();
		
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet1=wb.getSheetAt(0);
		sheet1.setColumnWidth(0, 5000);
		sheet1.setColumnWidth(1, 5000);
		sheet1.setColumnWidth(2, 5000);
		sheet1.setColumnWidth(3, 5000);
		sheet1.setColumnWidth(4, 10000);
		sheet1.setColumnWidth(5, 10000);
		sheet1.setColumnWidth(6, 10000);
		sheet1.setColumnWidth(7, 5000);
		sheet1.setColumnWidth(8, 10000);
		HSSFCell reportedCell=sheet1.getRow(0).createCell(6);
		reportedCell.setCellValue("ReportedBy");
		HSSFCell successCountCell=sheet1.getRow(0).createCell(7);
		successCountCell.setCellValue("Successes");
		HSSFCell failureCell=sheet1.getRow(0).createCell(9);
		failureCell.setCellValue("Failures");
		//Counting Number of Rows from Excel
		int rowcount=sheet1.getLastRowNum();
		//System.out.println("Total number of Transactions to be Created : "+rowcount);
		
		//Processing each row of the Excel
		
		for(int j=1;j<=rowcount;j++)
		{
				
			try {
				if(sheet1.getRow(j) ==null) break;
				HSSFRow row = sheet1.getRow(j);
				
				HSSFCell UID=row.getCell(0);
				if(UID == null) break;
				String UID1 = UID.getRichStringCellValue().getString();	
				if(UID1 == null||UID == null||UID1.equals("")) break;
				LossNoticeCheck lnc = new LossNoticeCheck();
			//
				System.out.println("Processing FNOL No : "+UID1+". Row#:"+j+".");
				if(lnc.confirmLN(UID1)) {
					String result="Failure";
					
					if( !lnc.getCancelledPolicy().equals("")) {
						result="failure - Policy Cancelation";
						failureCountAddOne();
					}else if(!lnc.getLnNotfound().equals("")) {
						result="failure - Loss Notice Not Found";
						failureCountAddOne();
					}else if(!lnc.getLossBeforeInception().equals("")) {
						result="failure - LN is prior to inception date";
						failureCountAddOne();
					}else if(!lnc.getMissingFields().equals("")) {
						result="failure -LN Missing Required fields";
						failureCountAddOne();
					}else if(!lnc.getPreviouslyCompleted().equals("")) {
						result="previous success - LN previously processed successfully";
						priorSuccessCountAddOne();
					}
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				    try {
						printToFile(result,sheet1,wb,j,"",lnc.getReportedTo());
					}catch(Exception e3) {
						e3.printStackTrace();
					}
					System.out.println(result);
					
					continue;
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.id("ToolbarSearchText")).clear();
				driver.findElement(By.id("ToolbarSearchText")).sendKeys(UID1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
				
				driver.findElement(By.name("ToolbarSearch")).click();				
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

					
					driver.findElement(By.id("TakeOwnership")).click();
					
					
					driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
					Alert alert = driver.switchTo().alert();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					alert.accept();
					
					driver.findElement(By.id("Complete")).click();
					driver.findElement(By.id("StartClaim")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Wizard_Detail")).click();
					if(lnc.getReportedTo() != null) {
						if(!lnc.getReportedTo().equals("")) {
							Alert alert1 = driver.switchTo().alert();
							  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							  alert1.accept();
						}
					}
					
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.id("ClaimantActionsMenu_1")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("AdjustReserve_1")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Save")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Closeout")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Process")).click();
					Thread.sleep(2000);	
					driver.findElement(By.id("GoToCustomer")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					String claimno = driver.findElement(By.id("claimLink0")).getText();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					successCountAddOne();
				
					try {
						printToFile("Success",sheet1,wb,j,claimno,lnc.getReportedTo());
					}catch(Exception e3) {
						e3.printStackTrace();
						
					}
					System.out.println(UID1+" Claim Processed Successfully");
					
					//System.out.println("Remaining FNOL's To be processed :"+(rowcount-j));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
														
			} catch (FileNotFoundException e) {
				System.out.println(" File not available - process fail");
				//String result1="Excel file not available";
				failureCountAddOne();
				try {
					printToFile("Unspecified Failure",sheet1,wb,j,"","");
				}catch(Exception e3) {
					e3.printStackTrace();
					
				}
				continue;
				
			} catch (IOException e) {
				System.out.println("Pending Transaction - process fail");
				//String result1="Pending Transaction";
				failureCountAddOne();

				try {
					printToFile("Unspecified Failure",sheet1,wb,j,"","");
				}catch(Exception e3) {
					e3.printStackTrace();
					
				}

				continue;
				
			} catch (NoSuchElementException exception ) {
				System.out.println("Element not found exception - process fail");
				//String result1="Pending Transaction";
				failureCountAddOne();
				try {
					printToFile("Unspecified Failure",sheet1,wb,j,"","");
				}catch(Exception e3) {
					e3.printStackTrace();
					
				}
				continue;
			} catch(UnhandledAlertException e) {
				System.out.println("unhandled alert");
				Alert alert = driver.switchTo().alert();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				alert.accept();
				driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				alert.accept();
				failureCountAddOne();
				try {
					printToFile("Unspecified Failure",sheet1,wb,j,"","");
				}catch(Exception e3) {
					e3.printStackTrace();
					
				}
				continue;}	
			}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		String duration =String.format("%02d min, %02d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(timeElapsed),
			    TimeUnit.MILLISECONDS.toSeconds(timeElapsed) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeElapsed))
			);
		System.out.println("LN to CLaim  process has finished with a duration of "+duration+" Processed:"+getSuccessCount()+". Failures:"+getFailureCount()+". Previously Completed:"+getPriorSuccessCount()+".");
		driver.close();
	}
	
	public static void processOffNetwork() throws Exception{
		//Setup Chrome Driver Path
		System.setProperty("webdriver.chrome.driver", getWebDriverPath());
		
		//Create Chrome Browser Driver
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		LocalDateTime Starttime = LocalDateTime.now();
		System.out.println(Starttime);
		
		//Login in to Prod Environment
		
		driver.get("https://ai.iscs.com/innovation");
		
		//driver.get("https://model-ai.iscs.com/innovation");
				
		
		driver.findElement(By.id("j_username")).sendKeys("gallopadmin");
		driver.findElement(By.id("j_password")).sendKeys("AIIG@2468");
		
//		driver.findElement(By.id("j_username")).sendKeys("srajendran");
//		driver.findElement(By.id("j_password")).sendKeys("Password@1143");
		
		driver.findElement(By.id("SignIn")).click();
		System.out.println("Chrome Browser Instantiated..");
		
		//driver.findElement(By.id("Menu_Admin")).click();
		//driver.findElement(By.id("Menu_Admin_UserManagement")).click();
		
		//Reading Input from an Excel document
		
		
		FileInputStream fis=new FileInputStream(new File(getFnolFilePath()));
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet1=wb.getSheetAt(0);
		sheet1.setColumnWidth(0, 5000);
		sheet1.setColumnWidth(1, 5000);
		sheet1.setColumnWidth(2, 5000);
		sheet1.setColumnWidth(3, 5000);
		sheet1.setColumnWidth(4, 10000);
		sheet1.setColumnWidth(5, 10000);
		sheet1.setColumnWidth(6, 10000);
		sheet1.setColumnWidth(7, 5000);
		sheet1.setColumnWidth(8, 10000);
		HSSFCell reportedCell=sheet1.getRow(0).createCell(6);
		reportedCell.setCellValue("ReportedBy");
		HSSFCell successCountCell=sheet1.getRow(0).createCell(7);
		successCountCell.setCellValue("Successes");
		HSSFCell failureCell=sheet1.getRow(0).createCell(9);
		failureCell.setCellValue("Failures");
		//Counting Number of Rows from Excel
		int rowcount=sheet1.getLastRowNum();
		//System.out.println("Total number of Transactions to be Created : "+rowcount);
		
		//Processing each row of the Excel
		
		for(int j=1;j<=rowcount;j++)
		{
				
			try {
			
				HSSFRow row = sheet1.getRow(j);
				HSSFCell UID=row.getCell(0);
				String UID1 = UID.getRichStringCellValue().getString();	
				System.out.println("Processing FNOL No : "+UID1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.id("ToolbarSearchText")).clear();
				driver.findElement(By.id("ToolbarSearchText")).sendKeys(UID1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
				
				driver.findElement(By.name("ToolbarSearch")).click();				
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
					
					driver.findElement(By.id("TakeOwnership")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Alert alert = driver.switchTo().alert();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					alert.accept();
					driver.findElement(By.id("Complete")).click();
					driver.findElement(By.id("StartClaim")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Wizard_Detail")).click();
					if(portalRun) {
						Alert alert1 = driver.switchTo().alert();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						alert1.accept();
					}
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("ClaimantActionsMenu_1")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("AdjustReserve_1")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Save")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Closeout")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.findElement(By.id("Process")).click();
					Thread.sleep(2000);	
					driver.findElement(By.id("GoToCustomer")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					try {
						printToFile("Unspecified Failure",sheet1,wb,j,"","");
					}catch(Exception e3) {
						e3.printStackTrace();
					}
					System.out.println(UID1+" Claim Processed Successfully");
					
					System.out.println("Remaining FNOL's To be processed :"+(rowcount-j));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
					successCountAddOne();		
				} catch (NoSuchElementException exception ) {
					System.out.println("Element not found exception");
					failureCountAddOne();
					try {
						printToFile("Unspecified Failure",sheet1,wb,j,"","");
					}catch(Exception e3) {
						e3.printStackTrace();
					}
					continue;
				} catch(UnhandledAlertException e) {
					System.out.println("unhandled alert - process fail");
					Alert alert = driver.switchTo().alert();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					alert.accept();
					driver.findElement(By.xpath("//*[@id=\"Return\"]")).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					alert.accept();
					failureCountAddOne();
					try {
						printToFile("Unspecified Failure",sheet1,wb,j,"","");	
					}catch(Exception e2) {
						e2.printStackTrace();
					}
					continue;
				}	
			}
		
		System.out.println("LN to Claim job processed Succesfully");
		driver.close();
	
	}
}
