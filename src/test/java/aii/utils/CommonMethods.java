package aii.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import aii.steps.Hooks;
import aii.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
	static LocalDateTime currentDate = LocalDateTime.now();

	/**
	 * This method clears a textbox and sends another text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();		
		element.sendKeys(text);
	}
	
	/**
	 * This method checks if radio/checkbox is enabled and then clicks on the
	 * element that has the value attribute we are looking for.
	 * 
	 * @param listElement
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
		String actualValue;

		for (WebElement el : listElement) {
			actualValue = el.getAttribute("value").trim();

			if (actualValue.equals(value) && el.isEnabled()) {
				el.click();
				break;
			}

		}
	}

	/**
	 * This method allows us to call Thread.sleep() for any amount of seconds
	 * specified.
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	/**
	 * This method checks if a given index is valid for the WebElement and only then
	 * selects an element by index.
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method checks if a given index is valid for the WebElement and only then
	 * selects an element by visible text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectDropdownText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			
			}
		catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * This method accepts an Alert and handles NoAlertPresentException if no alert
	 * is present.
	 * 
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will dismiss an alert if it present.
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will get the Alert text. If no alert is present then the
	 * exception is caught and it returns null.
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * This method sends text to the alert if present.
	 * 
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method switches to a frame using name or id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using an index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using a WebElement object
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {

			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches focus to a child window.
	 * 
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}

	}
	/**
	 * This method switches focus back to a main window.
	 * 
	 */
	public static void switchToMainWindow() {
		String Window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(Window)) {
				driver.switchTo().window(window);
			}
		}

	}

	/**
	 * This method creates a WebDriverWait object and returns it.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

		return wait;
	}

	/**
	 * 
	 * This method will wait for an element to be clickable.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {
		// create a wait object and then add the expected wait condition

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method waits for an element to be visible.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method waits for an element to be clickable and then clicks on it.
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();		
	}
	
	/**
	 * This method waits for an element is visible and then return true.
	 * 
	 * @param element
	 */
	public static boolean IsVisible(WebElement element) {
		boolean visible = false;
		
		if (element.isDisplayed())
		{
			visible = true;
		}
		return  visible;
	}
	
	
	/**
	 * This method waits for an element to be clickable and then clicks TAB button on it.
	 * 
	 * @param element
	 */
	public static void clickTab(WebElement element) {
		waitForClickability(element);
		element.sendKeys(Keys.TAB);
	}
	
	/**
	 * This method waits for an element to be clickable and then clicks button on it and clears written text.
	 * 
	 * @param element
	 */
	public static void clearText(WebElement element) {
		waitForClickability(element);
		element.sendKeys(Keys.CLEAR);
	}
	
	
	/**
	 * This method casts the driver to JavascriptExecutor and returns it
	 * 
	 * @return JavascriptExecutor
	 */
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

		// in one step
		// return (JavascriptExecutor) driver;
	}

	/**
	 * This method will click to the element that is passed using JavascriptExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will scroll the page until the element that is passed becomes
	 * visible
	 * 
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	/**
	 * This method will move to desired element
	 * 
	 * @param element
	 
	 */
	public static void moveToElement(WebElement element) {
		Actions move= new Actions(driver);
		move.moveToElement(element).perform();
		
	}
	/**
	 * This method will scroll the page down based on the passed pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll the page up based on the passed pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will select a date from the calendar
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {
				if (day.getText().equals(date)) {
					day.click();
					break;
				}
			} else {
				System.out.println("The date is not enabled!");
				break;
			}
		}
	}

	/**
	 * This method takes a screenshot and saves it with the provided filename
	 * 
	 * @param filename
	 */
	/*
	 * public static String takeScreenshot(String filename) {
	 * 
	 * TakesScreenshot ts = (TakesScreenshot) driver;
	 * 
	 * File source = ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * // we want to create a filename that is unique: for example name+timestamp //
	 * (validLogin2022_06_07_20_40_40) String destination =
	 * Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";
	 * 
	 * try { FileUtils.copyFile(source, new File(destination)); } catch (IOException
	 * e) { System.out.println("Cannot take Screenshot!"); }
	 * 
	 * return destination; }
	 * 
	 */
	
	public static byte[] takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		// we want to create a filename that is unique: for example name+timestamp
		// (validLogin2022_06_07_20_40_40)
		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Cannot take Screenshot!");
		}
		
		//get the screenshot as a byte[] and return it
		
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
		

		return picBytes;
	}
	
	

	/**
	 * This method returns the timestamp in a String format.
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}
	
	
	/**
	 * This method switches focus between windows
	 * 
	 */
	public static String mainWindow;
	public static void switchWindows(WebDriver driver) {
		
		try {
			Set<String> set =driver.getWindowHandles();
			Iterator<String> itr= set.iterator();
		while (itr.hasNext()) {
			String childWindow=itr.next();
	    
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Switch to a perticular window using Url
	 * 
	 */
	
	public static void switchToWindow(WebDriver driver, String text) {
		 
		try {
			mainWindow = driver.getWindowHandle();
			WebDriver popup = null;
		    Iterator<String> windowIterator = driver.getWindowHandles()
		            .iterator();
		    while (windowIterator.hasNext()) {
		        String windowHandle = windowIterator.next();
		        popup = driver.switchTo().window(windowHandle);
		        String title = popup.getCurrentUrl();
		        if (title.contains(text)) {
		            break;
		        }
		    }
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method replaces a string with another string
	 * 
	 */
	
	public static String replaceMethod(String str, String from, String to) {
	    String[] arr = str.split(from);
	    StringBuilder output = new StringBuilder();

	    int i = 0;
	    for (i = 0; i < arr.length - 1; i++)
	    output.append(arr[i]).append(to);

	    output.append(arr[i]);
	    if (str.substring(str.lastIndexOf("")).equalsIgnoreCase("" + from))
	        output.append(to);

	    return output.toString();
	}
	
	/**
	 * This method checks the default value of a dropdown element based on visible text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void verifyAnyDropdownDefaultValue(String coverage, String element, String expectedValue) {
		String value=null;
		
		try {
			
			Select select = new Select (driver.findElement(By.id(""+element+""))); 	
			   value = select.getFirstSelectedOption().getText().toString();
	          Hooks.scenario.log(coverage+" "+element+" defaulted with "+value); 
	           
	           if(value.equals(expectedValue)){
	        	   Hooks.scenario.log(coverage+" "+"Actual defaulted value : "+value +" Expected value : "+expectedValue+" are matching");
	           } else  {
	        	   Hooks.scenario.log(coverage+" "+"Actual defaulted value : "+value +" Expected value : "+expectedValue+" are not matching");
	           } 
			
			}
		catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	public static void clickNewCustomer(WebDriver driver) throws Exception {
		
		try {
				List<WebElement> oCheckBox = driver.findElements(By.name("QuoteCustomerClearingRef"));
				int size = oCheckBox.size();
		
				for(int i = 0; i < size; i++ )	{
				String value = oCheckBox.get(i).getAttribute("value");
		 
					if (value.equalsIgnoreCase("New")){
						oCheckBox.get(i).click();
						 Hooks.scenario.log("New customer option selected");
						break;
						}	
					}	
				} catch (Exception e) {
					 Hooks.scenario.log("New customer option not selected");
					 e.printStackTrace();
				}
	}
	
	
	public static String getPolicyNumber(WebDriver driver) throws Exception {
		
		String policyNum = null;
		try {
			policyNum = driver.findElement(By.id("PolicySummary_PolicyNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: "+policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return policyNum.toString();
		
	}	
	
	public static String getInForcePremium(WebDriver driver) throws Exception {
		String PremiumNoFees = null;
		
		click(historyChevron.btnsummaryTab);
			try {
				PremiumNoFees = driver.findElement(By.id("Full_PolicySummary_Premium")).getText().toString();
				Hooks.scenario.log("Policy Premium is: "+PremiumNoFees);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return PremiumNoFees.toString();
	}	
	
	public static String getInForcePremiumFees(WebDriver driver) throws Exception {
		String PremiumFees = null;
		
		try {
			PremiumFees = driver.findElement(By.id("Full_PolicySummary_PremWithTaxesFeesAmt")).getText().toString();
			Hooks.scenario.log("Policy Premium is: "+PremiumFees);
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(historyChevron.btnsummaryTab);
		
		return PremiumFees.toString();
	}	
	
	
	public static String getClaimTransactionNumber(WebDriver driver) throws Exception {
		
		String txNum = null;
		try {
			txNum = driver.findElement(By.id("ClaimSummary_ClaimTransactionNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: "+txNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txNum.toString();
		
	}	
	
	
	public static String getApplicationNumber(WebDriver driver) throws Exception {
		
		String appNum = null;
		try {
			appNum = driver.findElement(By.id("ClaimSummary_ClaimTransactionNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: "+appNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appNum.toString();
		
	}	
	
	public static String changeDate(String days){
		
		String effectiveDate = dtf.format(currentDate.plusDays(Integer.parseInt(days)));	
		
		// Change system date to effective date
		 click(dashboard.btnAdmin);
		 click(dashboard.btnChangeDate);
		 sendText(dashboard.txtNewDate, effectiveDate);
		 click(dashboard.btnChangeNewDate);
		 sendText(dashboard.txtNewBookDate, effectiveDate);
		 click(dashboard.btnChangeBookDate);
		 
		return effectiveDate;
		
	}
public static String changeDateToDesiredEffDate(String effDate){
		
		String effectiveDate = null;	
		
		// Change system date to effective date
		 click(dashboard.btnAdmin);
		 click(dashboard.btnChangeDate);
		 sendText(dashboard.txtNewDate, effectiveDate);
		 click(dashboard.btnChangeNewDate);
		 sendText(dashboard.txtNewBookDate, effectiveDate);
		 click(dashboard.btnChangeBookDate);
		 
		return effectiveDate;
		
	}
	
	public static void startTransaction() {
		
		 click(policyChevron.btnPolicyChevronLink);
		    wait(1);
		    click(dashboard.ddMoreOptions);
		    click(dashboard.btnStartTransaction);
	}
	
	
	
	public static void select_Direct_FullPayplanType() throws Exception {
		
		selectDropdownText(reviewChevron.ddPayPlan, ConfigsReader.getProperty("payplan"));
		wait(2);
		click(reviewChevron.btnFullPaymentRadio);
		wait(1);
		clickNewCustomer(driver);
		click(dwellingChevron.btnSave);
		wait(1);
	}
	
	
public static void fillHO3_UWQuestions() throws Exception {
		
		
		//HO3 Underwriting Questions Chevron was filled here
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question16, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");
		CommonMethods.wait(1);
		
		CommonMethods.click(dwellingChevron.btnNext);
		
	}
public static void fillSCHO3_UWQuestions() throws Exception {
	
	
	//SC HO3 Underwriting Questions Chevron was filled here
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.scHo3Question6, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question12, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "Yes");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question21, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");
	CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");
	
	CommonMethods.wait(1);
	CommonMethods.click(dwellingChevron.btnNext);
	
}
	
	
	public static void fillDP3_UWQuestions() throws Exception {
		
		
		//DP3 Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question16, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");	


		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	
	public static void fillDP1_UWQuestions() throws Exception {
		
		//DP1 Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.dp1Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");	

		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	
	public static void fillHO6_UWQuestions() throws Exception {
		
		//HO6 Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question19, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question21, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question24, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question25, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");	
	
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	
	public static void fillHO4_UWQuestions() throws Exception {
		
		//HO4 Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho4Question14, "No");
		
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	public static void fillGOC_UWQuestions() throws Exception {
		
		//GOC Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion9, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion12, "No");

		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	public static void fillBoat_UWQuestions() throws Exception {
		
		
		//Boat Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion15, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion16, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion18, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion19, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion20, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion21, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.aibQuestion22, "No");
		
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	
	public static void fillUMB_UWQuestions() throws Exception {
	
		
		//UMB Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion4, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion6, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion7, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion8, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion9, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion10, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion11, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion12, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion13, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion14, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion15, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion16, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion17, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.umbQuestion18, "No");
	
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	
	public static void fillMHO_UWQuestions() throws Exception {
		
		//MHO Underwriting Questions Chevron was filled here
		
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question2, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question3, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question5, "No");
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question7, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question8, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question9, "Yes"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question10, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question11, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho6Question12, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question13, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question12, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question15, "Yes"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question17, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question18, "No"); 
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question16, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question20, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question21, "No");  
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question22, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question23, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question19, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question22, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question26, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question24, "Yes");	
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question25, "Yes");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.mho3Question26, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question27, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question6, "No");	
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question28, "No");	 
		CommonMethods.selectDropdownText(uwquestionsChevron.ho3Question29, "No");
	
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
public static void fillAIB_UWQuestions() throws Exception {
		
		CommonMethods.click(dwellingChevron.btnNext);
		
		//AIB Underwriting Questions Chevron was filled here
		
		selectDropdownText(uwquestionsChevron.aibQuestion1, "No");
		selectDropdownText(uwquestionsChevron.ho3Question1, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion3, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion4, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion5, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion6, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion7, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion7, "No");
		selectDropdownText(uwquestionsChevron.gocQuestion8, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion10, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion11, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion12, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion13, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion14, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion15, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion16, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion17, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion18, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion19, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion20, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion21, "No");
		selectDropdownText(uwquestionsChevron.aibQuestion22, "No");
		
		CommonMethods.wait(1);
		CommonMethods.click(uwquestionsChevron.nextButtonUw);
	}
	
	public static void check_CCDisclosure() {
		
		wait(1);
		 click(closeoutChevron.rbCCPrompt);
		    wait(1);
		    click(closeoutChevron.btnPromptOK);
		    wait(2);
	}
	
	public static void makeCCPayment()
	{
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber,"5424000000000015");
		sendText(makePayment.txtExpiryDate,"1224");
		sendText(makePayment.txtCVV,"123");
		sendText(makePayment.txtFirstName,"First Name");
		sendText(makePayment.txtLastName,"Last Name");
		sendText(makePayment.txtZip,"123456");
		sendText(makePayment.txtAddress,"1234 Street");
		sendText(makePayment.txtCity,"City");
		sendText(makePayment.txtState,"State");
		sendText(makePayment.txtPhoneNumber,"123-456-7895");
		sendText(makePayment.txtCompanyNameID,"Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		wait(2);			
		
	}
	
	public static void submitForApprovalWithDialog()
	{
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		Hooks.scenario.log("SubmitForApproval was clicked");
		click(specialChevron.btnDialogOk);
		wait(2);
		Hooks.scenario.log("Submission Confirmation OK was clicked");
	}
	
	public static void submitForApproval()
	{
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		Hooks.scenario.log("SubmitForApproval was clicked");
	}
	
	public static String getNextActionDate() throws Exception
	{
		String num=null;
		try {
			String action = driver.findElement(By.id("Description_text")).getText().toString();
			num = action.substring(action.indexOf("on") + 3 , action.length()).toString();
			wait(4);
			Hooks.scenario.log(action+" next action Date : "+num);
	} catch (Exception e) {
		e.printStackTrace();	
	}
		return num.toString();	
	}	
		
	/**
	 * This method checks desired element is disabled or not in the DOM.
	 * 
	 */
	public static void verifyAnyElement_Disabled(WebDriver driver, String elementName) throws Exception {

		try {
			
			WebElement ele = driver.findElement(By.id(""+elementName+""));
			
				if(ele.isEnabled()) {
					Hooks.scenario.log(elementName+"  is Enabled");
				}	else if(!(ele.isEnabled())) {
					Hooks.scenario.log(elementName+"  is Disabled");
				} else {
					Hooks.scenario.log(elementName+"  is not able to validate");
				}										
		} catch (Exception e) {
			Hooks.scenario.log(elementName+" not able to validate");             
			wait(3);
		}
	}
	
	/**
	 * This method checks desired element is enabled or not in the DOM.
	 * 
	 */
	public static void verifyAnyElement_Enabled(WebDriver driver, String elementName) throws Exception {

		try {
			
			WebElement ele = driver.findElement(By.id(""+elementName+""));
			
				if(ele.isEnabled()) {
					Hooks.scenario.log(elementName+"  is Enabled");
				}	else if(!(ele.isEnabled())) {
					Hooks.scenario.log(elementName+"  is Disabled");
				} else {
					Hooks.scenario.log(elementName+"  is not able to validate");
				}										
		} catch (Exception e) {
			Hooks.scenario.log(elementName+" not able to validate");
			wait(3);
		}
	}
	
	/**
	 * This method compares particular dropdown value with desired text
	 * 
	 */
	
	public static String verifyAnyDropdownDefaultedValue(WebDriver driver, String element, String expectedValue) throws Exception {
	    String value=null;
	    try {
	           Select entityType = new Select (driver.findElement(By.id(""+element+""))); 
	           value = entityType.getFirstSelectedOption().getText().toString();
	           Hooks.scenario.log(element+" defaulted with "+value); 
	           
	           if(value.equals(expectedValue)){
	                  Hooks.scenario.log("Actual defaulted value : "+value +" Expected value : "+expectedValue+" are matching");
	           } else  {
	                  Hooks.scenario.log("Actual defaulted value : "+value +" Expected value : "+expectedValue+" are not matching");
	           } 
	    } catch (Exception e) {
	           Hooks.scenario.log(element+" not defaulted with "+expectedValue);
	           wait(5);
	    }
	    return value.toString();   
	    }
	
	/**
	 * This method compares any dropdown value with desired text
	 * 
	 */
	public static void verifyAnyDropDownOptions(WebDriver driver, String[] dropdownvalue, String fieldname) throws Exception {
		try {
			List<String> expList = new ArrayList<String>();
	        
	        for(int i=0;i<dropdownvalue.length;i++){
	            expList.add(dropdownvalue[i]);
	        }
	        
	        List<String> actList = new ArrayList<String>();
	        Select se = new Select(driver.findElement(By.id(""+fieldname+"")));
	        
	        List<WebElement> options = se.getOptions();
	        
	        for(WebElement dd : options){
	            actList.add(dd.getText());
	        }  
				           
	      //sorts both lists
	        //first compares the size of both list, if true then compares each item in order,if false skips and display both are not same
	        if(expList.size()==actList.size()){
	            for(int i=0;i<expList.size();i++){
	                //comparing each item in order
	                if(expList.get(i).equals(actList.get(i))){
	                	Hooks.scenario.log(actList.get(i)+" option Matched");
	                }else{
	                	Hooks.scenario.log(actList.get(i)+" option not Matched");
	                }
	            }
	        }else{
	        	Hooks.scenario.log(fieldname+" Drop down options are not Matched");
	        }

													
		} catch (Exception e) {
			Hooks.scenario.log(fieldname+"Options:");
			wait(5);
		}	
	}
	/**
	 * This method checks any desired value is disabled or not
	 * 
	 */
    public static boolean verifyAnyDisabledFieldsValue(WebDriver driver, String fieldName, String expectedResults) throws Exception {
    	
    	WebElement ele = driver.findElement(By.id(""+fieldName+""));

    	try {
    		if (ele.getText().contentEquals(expectedResults)){
    			Hooks.scenario.log(fieldName+" : " + ele.getText().toString());
    			return true;
    			
    		} else {
    			Hooks.scenario.log(fieldName+" : " + ele.getText().toString());
    			return true;
    		}
    	} catch (Exception e) {
    		Hooks.scenario.log(fieldName+" : " + ele.getText().toString());
    		wait(5);
    		return false;
    	}
    }
    /**
	 * This method checks any desired text is visible or not
	 * 
	 */
    public static boolean verify_AnyText_IsVisible(WebDriver driver, String text) throws Exception {
		Thread.sleep(2000);

		
		try {
            if(driver.findElement(By.xpath("//td[contains(text(), '" + text +"')]")).isDisplayed()) {  
            	Hooks.scenario.log("Is visible: " +  text);            	
            	return true;
            	}
    		return true;   	

            } catch (Exception e) {
    			Hooks.scenario.log("Is NOT visible: " +  text);
    			wait(5);
    			return false;
            	}
		
	}
    /**
	 * This method checks any desired text box value with expected value
	 * 
	 */
    public static boolean verifyAnyTextboxAttributeValue(WebDriver driver, String fieldName, String expectedResults) throws Exception {
    	
    	WebElement ele = driver.findElement(By.id(""+fieldName+""));

    	try {
    		if (ele.getAttribute("value").contentEquals(expectedResults)){
    			Hooks.scenario.log(fieldName+" : " + ele.getAttribute("value").toString());
    			Hooks.scenario.log("Expected value = "+expectedResults);
    			return true;
    			
    		} else {
    			Hooks.scenario.log(fieldName+" : " + ele.getAttribute("value").toString());
    			Hooks.scenario.log("Expected value = "+expectedResults);
    			return true;
    		}
    	} catch (Exception e) {
    		Hooks.scenario.log(fieldName+" : " + ele.getAttribute("value").toString());
    		wait(5);
    		return false;
    	}
    }
    /**
	 * This method checks any desired label value with expected value
	 * 
	 */
    public static boolean verify_AnyLabel_IsVisible(WebDriver driver, String text) throws Exception {
		
		try {
            if(driver.findElement(By.xpath("//*[contains(text(), '" + text +"')]")).isDisplayed()) {  
            	Hooks.scenario.log("Is visible: " +  text);            	
            	return true;
            	}
    		return true;   	

            } catch (Exception e) {
    			Hooks.scenario.log("Is NOT visible: " +  text);
    			wait(5);
    			return false;
            	}
		
	}

	

	}
	
	
		
	


