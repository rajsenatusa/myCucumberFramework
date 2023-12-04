package aii.utils;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
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
	 * This method allows us to call implicit wait for any amount of seconds
	 * specified.
	 * 
	 * @param seconds
	 */
	public static void waitImp(int seconds) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
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

		} catch (UnexpectedTagNameException e) {
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
	 * This method close unnecessary tabs.
	 * 
	 */
	public static void closeUnnecessaryTabs() {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (int i = tabs.size() - 1; i > 0; i--) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}

		// Switch back to the main page
		driver.switchTo().window(tabs.get(0));
		wait(3);
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

		if (element.isDisplayed()) {
			visible = true;
		}
		return visible;
	}

	/**
	 * This method waits for an element to be clickable and then clicks TAB button
	 * on it.
	 * 
	 * @param element
	 */
	public static void clickTab(WebElement element) {
		waitForClickability(element);
		element.sendKeys(Keys.TAB);
	}

	/**
	 * This method waits for an element to be clickable and then clicks button on it
	 * and clears written text.
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
	 * 
	 */
	public static void moveToElement(WebElement element) {
		Actions move = new Actions(driver);
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

		// get the screenshot as a byte[] and return it

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
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			while (itr.hasNext()) {
				String childWindow = itr.next();

				if (!mainWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
				}
			}
		} catch (Exception e) {
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
			Iterator<String> windowIterator = driver.getWindowHandles().iterator();
			while (windowIterator.hasNext()) {
				String windowHandle = windowIterator.next();
				popup = driver.switchTo().window(windowHandle);
				String title = popup.getCurrentUrl();
				if (title.contains(text)) {
					break;
				}
			}
		} catch (Exception e) {
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
	 * This method checks the default value of a dropdown element based on visible
	 * text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void verifyAnyDropdownDefaultValue(String coverage, String element, String expectedValue) {
		String value = null;

		try {

			Select select = new Select(driver.findElement(By.id("" + element + "")));
			value = select.getFirstSelectedOption().getText().toString();
			Hooks.scenario.log(coverage + " " + element + " defaulted with " + value);

			if (value.equals(expectedValue)) {
				Hooks.scenario.log(coverage + " " + "Actual defaulted value : " + value + " Expected value : "
						+ expectedValue + " are matching");
			} else {
				Hooks.scenario.log(coverage + " " + "Actual defaulted value : " + value + " Expected value : "
						+ expectedValue + " are not matching");
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	public static void clickNewCustomer(WebDriver driver) throws Exception {

		try {
			List<WebElement> oCheckBox = driver.findElements(By.name("QuoteCustomerClearingRef"));
			int size = oCheckBox.size();

			for (int i = 0; i < size; i++) {
				String value = oCheckBox.get(i).getAttribute("value");

				if (value.equalsIgnoreCase("New")) {
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
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return policyNum.toString();

	}
	
	public static String getQuoteNumber(WebDriver driver) throws Exception {

		String QuoteNum = null;
		try {
			QuoteNum = driver.findElement(By.id("QuoteAppSummary_QuoteAppNumber")).getText().toString();
			Hooks.scenario.log("Quote Number: " + QuoteNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return QuoteNum.toString();

	}
	
	public static void verifyQuoteMade (WebDriver driver) throws Exception {
		driver.findElement(By.id("Tab_Policy")).isDisplayed(); 
				
	}
	public static String getInForcePremium(WebDriver driver) throws Exception {
		String PremiumNoFees = null;

		click(historyChevron.btnsummaryTab);
		try {
			PremiumNoFees = driver.findElement(By.id("Full_PolicySummary_Premium")).getText().toString();
			Hooks.scenario.log("Policy Premium is: " + PremiumNoFees);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return PremiumNoFees.toString();
		
	}
	public static String getQuotePremium(WebDriver driver) throws Exception {
		String QuotePremium = null;
		try {
			 
			QuotePremium = driver.findElement(By.id("QuoteAppSummary_PremWithTaxesFeesAmt")).getText().toString();
			Hooks.scenario.log("Quote premium is: " + QuotePremium);
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return QuotePremium.toString();
		
		
		
	}

	public static String getInForcePremiumFees(WebDriver driver) throws Exception {
		String PremiumFees = null;

		try {
			PremiumFees = driver.findElement(By.id("Full_PolicySummary_PremWithTaxesFeesAmt")).getText().toString();
			Hooks.scenario.log("Policy Premium is: " + PremiumFees);
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
			Hooks.scenario.log("Policy Number: " + txNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txNum.toString();

	}

	public static String getApplicationNumber(WebDriver driver) throws Exception {

		String appNum = null;
		try {
			appNum = driver.findElement(By.id("ClaimSummary_ClaimTransactionNumber")).getText().toString();
			Hooks.scenario.log("Policy Number: " + appNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appNum.toString();

	}

	public static String changeDate(String days) {

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

	public static String changeDateToDesiredEffDate(String effDate) {

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

		// HO3 Underwriting Questions Chevron was filled here
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

		// SC HO3 Underwriting Questions Chevron was filled here
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

		// DP3 Underwriting Questions Chevron was filled here

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

		// DP1 Underwriting Questions Chevron was filled here

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

		// HO6 Underwriting Questions Chevron was filled here

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

		// HO4 Underwriting Questions Chevron was filled here

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

		// GOC Underwriting Questions Chevron was filled here

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

		// Boat Underwriting Questions Chevron was filled here

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

		// UMB Underwriting Questions Chevron was filled here

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

		// MHO Underwriting Questions Chevron was filled here

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

		// AIB Underwriting Questions Chevron was filled here

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

	public static void makeCCPayment() {
		click(closeoutChevron.btnEnterCCDetails);
		wait(2);
		check_CCDisclosure();
		driver.switchTo().frame("iframeAuthorizeNet");
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		wait(2);
		click(driver.findElement(By.id("SubmitPayment")));
		wait(3);
		click(driver.findElement(By.id("dialogOK")));
		wait(1);
	}

	public static void submitForApprovalWithDialog() {
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		Hooks.scenario.log("SubmitForApproval was clicked");
		click(specialChevron.btnDialogOk);
		wait(2);
		Hooks.scenario.log("Submission Confirmation OK was clicked");
	}

	public static void submitForApproval() {
		wait(2);
		click(closeoutChevron.btnSubmitApproval);
		Hooks.scenario.log("SubmitForApproval was clicked");
	}

	public static String getNextActionDate() throws Exception {
		String num = null;
		try {
			String action = driver.findElement(By.id("Description_text")).getText().toString();
			num = action.substring(action.indexOf("on") + 3, action.length()).toString();
			wait(4);
			Hooks.scenario.log(action + " next action Date : " + num);
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

			WebElement ele = driver.findElement(By.id("" + elementName + ""));

			if (ele.isEnabled()) {
				Hooks.scenario.log(elementName + "  is Enabled");
			} else if (!(ele.isEnabled())) {
				Hooks.scenario.log(elementName + "  is Disabled");
			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}
		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(3);
		}
	}

	/**
	 * This method checks desired element is enabled or not in the DOM.
	 * 
	 */
	public static void verifyAnyElement_Enabled(WebDriver driver, String elementName) throws Exception {

		try {

			WebElement ele = driver.findElement(By.id("" + elementName + ""));

			if (ele.isEnabled()) {
				Hooks.scenario.log(elementName + "  is Enabled");
			} else if (!(ele.isEnabled())) {
				Hooks.scenario.log(elementName + "  is Disabled");
			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}
		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(3);
		}
	}

	/**
	 * This method compares particular dropdown value with desired text
	 * 
	 */

	public static String verifyAnyDropdownDefaultedValue(WebDriver driver, String element, String expectedValue)
			throws Exception {
		String value = null;
		try {
			Select entityType = new Select(driver.findElement(By.id("" + element + "")));
			value = entityType.getFirstSelectedOption().getText().toString();
			Hooks.scenario.log(element + " defaulted with " + value);

			if (value.equals(expectedValue)) {
				Hooks.scenario.log(
						"Actual defaulted value : " + value + " Expected value : " + expectedValue + " are matching");
			} else {
				Hooks.scenario.log("Actual defaulted value : " + value + " Expected value : " + expectedValue
						+ " are not matching");
			}
		} catch (Exception e) {
			Hooks.scenario.log(element + " not defaulted with " + expectedValue);
			wait(5);
		}
		return value.toString();
	}

	/**
	 * This method compares any dropdown value with desired text
	 * 
	 */
	public static void verifyAnyDropDownOptions(WebDriver driver, String[] dropdownvalue, String fieldname)
			throws Exception {
		try {
			List<String> expList = new ArrayList<String>();

			for (int i = 0; i < dropdownvalue.length; i++) {
				expList.add(dropdownvalue[i]);
			}

			List<String> actList = new ArrayList<String>();
			Select se = new Select(driver.findElement(By.id("" + fieldname + "")));

			List<WebElement> options = se.getOptions();

			for (WebElement dd : options) {
				actList.add(dd.getText());
			}

			// sorts both lists
			// first compares the size of both list, if true then compares each item in
			// order,if false skips and display both are not same
			if (expList.size() == actList.size()) {
				for (int i = 0; i < expList.size(); i++) {
					// comparing each item in order
					if (expList.get(i).equals(actList.get(i))) {
						Hooks.scenario.log(actList.get(i) + " option Matched");
					} else {
						Hooks.scenario.log(actList.get(i) + " option not Matched");
					}
				}
			} else {
				Hooks.scenario.log(fieldname + " Drop down options are not Matched");
			}

		} catch (Exception e) {
			Hooks.scenario.log(fieldname + "Options:");
			wait(5);
		}
	}

	/**
	 * This method checks any desired value is disabled or not
	 * 
	 */
	public static boolean verifyAnyDisabledFieldsValue(WebDriver driver, String fieldName, String expectedResults)
			throws Exception {

		WebElement ele = driver.findElement(By.id("" + fieldName + ""));

		try {
			if (ele.getText().contentEquals(expectedResults)) {
				Hooks.scenario.log(fieldName + " : " + ele.getText().toString());
				return true;

			} else {
				Hooks.scenario.log(fieldName + " : " + ele.getText().toString());
				return true;
			}
		} catch (Exception e) {
			Hooks.scenario.log(fieldName + " : " + ele.getText().toString());
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
			if (driver.findElement(By.xpath("//td[contains(text(), '" + text + "')]")).isDisplayed()) {
				Hooks.scenario.log("Is visible: " + text);
				attachScreenShot(driver);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Is NOT visible: " + text);
			wait(5);
			return false;
		}

	}

	/**
	 * This method checks any desired text box value with expected value
	 * 
	 */
	public static boolean verifyAnyTextboxAttributeValue(WebDriver driver, String fieldName, String expectedResults)
			throws Exception {

		WebElement ele = driver.findElement(By.id("" + fieldName + ""));

		try {
			if (ele.getAttribute("value").contentEquals(expectedResults)) {
				Hooks.scenario.log(fieldName + " : " + ele.getAttribute("value").toString());
				Hooks.scenario.log("Expected value = " + expectedResults);
				return true;

			} else {
				Hooks.scenario.log(fieldName + " : " + ele.getAttribute("value").toString());
				Hooks.scenario.log("Expected value = " + expectedResults);
				return true;
			}
		} catch (Exception e) {
			Hooks.scenario.log(fieldName + " : " + ele.getAttribute("value").toString());
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
			if (driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).isDisplayed()) {
				Hooks.scenario.log("Is visible: " + text);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Is NOT visible: " + text);
			wait(5);
			return false;
		}

	}

	/**
	 * This method checks any desired text value is not visible
	 * 
	 */
	public static boolean verify_AnyText_NotVisible(WebDriver driver, String text) throws Exception {

		try {
			if (driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).isDisplayed()) {
				Hooks.scenario.log("Not visible: " + text);
				return false;
			}
			return false;
		} catch (Exception e) {
			Hooks.scenario.log("Not visible: " + text);
			return true;
		}
	}

	/**
	 * This method gets tasks referring user status on tasks tab
	 * 
	 */
	public static String getTaskReferrringUserStatus(WebDriver driver, String task) throws Exception {
		String status = null;
		try {
			status = driver.findElement(By.xpath("(//*[contains(text(),'" + task + "')])[1]//following::*[1]"))
					.getText().toString();
			Hooks.scenario.log(task + " referring to : " + status);
		} catch (Exception e) {
			Hooks.scenario.log(task + " referring to : " + status);
			wait(5);
		}
		return status.toString();
	}

	/**
	 * This method compares expected value with found value
	 * 
	 */
	public static boolean expectedValue_foundValue(WebDriver driver, String expectedValue, String foundValue)
			throws Exception {

		try {
			if (foundValue.contains(expectedValue)) {
				Hooks.scenario.log("Expected Value: " + expectedValue);
				Hooks.scenario.log("Found Value: " + foundValue);
				return true;
			}

			else if (!foundValue.contains(expectedValue)) {
				Hooks.scenario.log("Expected Value: " + expectedValue);
				Hooks.scenario.log("Found Value: " + foundValue);
				return false;
			}

			return true;
		} catch (Exception e) {
			Hooks.scenario.log("Expected Value: " + expectedValue);
			Hooks.scenario.log("Found Value: " + foundValue);
			wait(5);

			return false;
		}
	}

	/**
	 * This method gets task status on tasks tab
	 * 
	 */
	public static String getTaskStatus(WebDriver driver, String task) throws Exception {
		String status = null;
		try {
			status = driver.findElement(By.xpath("(//*[contains(text(),'" + task + "')])[1]//following-sibling::*[5]"))
					.getText().toString();
			Hooks.scenario.log("Status: " + status);
		} catch (Exception e) {
			Hooks.scenario.log("Status: " + status);
			wait(5);
		}
		return status.toString();
	}

	/**
	 * This method gets work date on tasks tab
	 * 
	 */
	public static String getTaskWorkDate(WebDriver driver, String task) throws Exception {
		String workDate = null;
		try {
			workDate = driver
					.findElement(By.xpath("(//*[contains(text(),'" + task + "')])[1]//following-sibling::*[6]"))
					.getText().toString();
			Hooks.scenario.log("Work Date: " + workDate);
		} catch (Exception e) {
			Hooks.scenario.log("Work Date: " + workDate);
			wait(5);
		}
		return workDate.toString();
	}

	/**
	 * This method changes system date with desired date
	 * 
	 */
	public static void ChangeAdminDate_NotInbox(WebDriver driver, String date) throws Exception {

		click(dashboard.btnAdmin);
		click(dashboard.btnChangeDate);
		wait(3);
		sendText(dashboard.txtNewDate, date);
		click(dashboard.btnChangeNewDate);
		wait(3);
		sendText(dashboard.txtNewBookDate, date);
		click(dashboard.btnChangeBookDate);
		wait(3);

	}

	public static void ChangeDate_Admin(WebDriver driver, String date) throws Exception {

		clickAdminTab(driver);
		clickAdminTab(driver);
		selectChangeDate(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

		setNewDate(driver, date);
		clickChangeDtBtn(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

		setBookDate(driver, date);
		clickChangeBookDtBtn(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

		returnInbox(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	}

	public static void clickAdminTab(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Menu_Admin")).click();
			wait(4);
			Hooks.scenario.log("Admin tab was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Admin tab was not selected");
			wait(5);
		}
	}

	public static void selectChangeDate(WebDriver driver) throws InterruptedException {

		try {
			Thread.sleep(250);
			driver.findElement(By.id("Menu_Admin_ChangeDate")).click();
			wait(4);
			Hooks.scenario.log("Change date was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Change date was not selected");
		}
	}

	public static void setNewDate(WebDriver driver, String newDt) throws Exception {
		try {
			if (driver.findElement(By.id("NewDate")).isDisplayed()) {
				driver.findElement(By.id("NewDate")).clear();
				driver.findElement(By.id("NewDate")).sendKeys(newDt.toString());
			} else {
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.id("NewDate")).sendKeys(dt.format(new Date()));
			}
			Hooks.scenario.log("New Date: " + newDt);
		} catch (Exception e) {
			Hooks.scenario.log("New Date: " + newDt);
			wait(4);
		}
	}

	public static void clickChangeDtBtn(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("ChangeDate")).click();
			wait(4);
			Hooks.scenario.log("Change date was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Change date was not selected");
			wait(4);
		}
	}

	public static void clickChangeBookDtBtn(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("ChangeBookDate")).click();
			wait(4);
			Hooks.scenario.log("Change book date was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Change book date was not selected");
			wait(4);
		}
	}

	public static void setBookDate(WebDriver driver, String newBookDt) throws Exception {
		try {
			if (driver.findElement(By.id("NewBookDate")).isDisplayed()) {
				driver.findElement(By.id("NewBookDate")).clear();
				driver.findElement(By.id("NewBookDate")).sendKeys(newBookDt.toString());
			} else {
				SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.id("NewBookDate")).sendKeys(dt.format(new Date()));
			}
			Hooks.scenario.log("New Book Date: " + newBookDt);
		} catch (Exception e) {
			Hooks.scenario.log("New Book Date: " + newBookDt);
			wait(5);
		}
	}

	public static void returnInbox(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Return")).click();
			Thread.sleep(500);
			wait(4);
			Hooks.scenario.log("Return to Inbox was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Return to Inbox was not selected");
			wait(5);
		}
	}

	public static void clickUserManagementTab(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Menu_Admin_UserManagement")).click();
			wait(4);
			Hooks.scenario.log("Menu_Admin_UserManagement was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Menu_Admin_UserManagement was not selected");
			wait(5);
		}
	}

	/**
	 * This method sets start date on task dashboard
	 * 
	 */
	public static void setStartDt(WebDriver driver, String StartDt) throws Exception {
		try {
			driver.findElement(By.id("StartDt")).clear();
			driver.findElement(By.id("StartDt")).sendKeys(StartDt.toString());
			Hooks.scenario.log("StartDt: " + StartDt);

		} catch (Exception e) {
			Hooks.scenario.log("StartDt: " + StartDt);
			wait(5);
		}
	}

	/**
	 * This method sets end date on task dashboard
	 * 
	 */
	public static void setEndDt(WebDriver driver, String EndDt) throws Exception {
		try {
			driver.findElement(By.id("EndDt")).clear();
			driver.findElement(By.id("EndDt")).sendKeys(EndDt.toString());
			Hooks.scenario.log("EndDt: " + EndDt);

		} catch (Exception e) {
			Hooks.scenario.log("EndDt: " + EndDt);
			wait(5);
		}
	}

	/**
	 * This method selects task type on task dashboard lookup screen
	 * 
	 */
	public static void selectTask(WebDriver driver, String ReportType) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.id("ReportType")));
			entityType.selectByVisibleText(ReportType.toString());
			Hooks.scenario.log("ReportType: " + ReportType);
		} catch (Exception e) {
			Hooks.scenario.log("ReportType: " + ReportType);
			wait(5);
		}
	}

	/**
	 * This method clicks run report button on task dashboard lookup screen
	 * 
	 */
	public static void clickRunReportBtn(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("RunReport")).click();
			wait(5);
			Hooks.scenario.log("RunReport was selected");
		} catch (Exception e) {
			Hooks.scenario.log("RunReport was not selected");
			wait(5);
		}
	}

	/**
	 * This method clicks on any desired link
	 * 
	 */
	public static void clickOnAnyLink(WebDriver driver, String link) throws Exception {
		try {
			driver.findElement(By.partialLinkText(link)).click();
			wait(5);
			Hooks.scenario.log(link + " was selected");
		} catch (Exception e) {
			Hooks.scenario.log(link + " was not selected");
			wait(5);
		}
	}

	/**
	 * This method selects multi elements from dropdown
	 * 
	 */
	public static void selectMultiSelectDropDown(WebDriver driver, String policy, String task) throws Exception {

		try {
			Select entityType = new Select(
					driver.findElement(By.xpath("(//*[contains(text(),'" + policy + "')])[1]//following::*[2]")));
			entityType.selectByVisibleText(task.toString());
			Hooks.scenario.log("Selected: " + task);
		} catch (Exception e) {
			Hooks.scenario.log("Selected: " + task);
			wait(5);
		}
	}

	/**
	 * This method click arrow to work on multi select task
	 * 
	 */
	public static void clickArrowToWorkonMultiSelectTask(WebDriver driver, String policy, String task)
			throws Exception {

		try {
			driver.findElement(By.xpath("(//*[contains(text(),'" + policy + "')])[1]//following::*[8]")).click();
			;
			Hooks.scenario.log("Clicked on right Arrow to work on " + task);
		} catch (Exception e) {
			Hooks.scenario.log("Clicked on right Arrow to work on " + task);
			wait(5);
		}
	}

	/**
	 * This method sets suspend date
	 * 
	 */
	public static void setSuspendDt(WebDriver driver, String SuspendUntil) throws Exception {
		try {
			driver.findElement(By.id("SuspendUntil")).clear();
			driver.findElement(By.id("SuspendUntil")).sendKeys(SuspendUntil.toString());
			Hooks.scenario.log("SuspendUntil: " + SuspendUntil);

		} catch (Exception e) {
			Hooks.scenario.log("SuspendUntil: " + SuspendUntil);
			wait(5);
		}
	}

	/**
	 * This method sets suspend comments
	 * 
	 */
	public static void setSuspendComments(WebDriver driver, String SuspendComments) throws Exception {
		try {
			driver.findElement(By.id("SuspendComments")).clear();
			driver.findElement(By.id("SuspendComments")).sendKeys(SuspendComments.toString());
			Hooks.scenario.log("SuspendComments: " + SuspendComments);

		} catch (Exception e) {
			Hooks.scenario.log("SuspendComments: " + SuspendComments);
			wait(5);
		}
	}

	/**
	 * This method clicks suspend
	 * 
	 */
	public static void clickSuspend(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Suspend")).click();
			Hooks.scenario.log("Clicked on Suspend button");

		} catch (Exception e) {
			Hooks.scenario.log("Clicked on Suspend button");
			wait(5);
		}
	}

	/**
	 * This method clicks task edit link
	 * 
	 */
	public static void clickGeneratedTaskEditLink(WebDriver driver, String task) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[contains(text(),'" + task + "')])[1]//following::*[2]")).click();
			;
			Hooks.scenario.log("Click on " + task + " task edit link");
		} catch (Exception e) {
			Hooks.scenario.log("Click on " + task + " task edit link");
			wait(5);
		}
	}

	/**
	 * This method checks any checkbox is enabled and not been selected
	 * 
	 */
	public static void verifyAnyCoverageCheckbox_EnabledAndNotSelected(WebDriver driver, String elementName)
			throws Exception {

		try {
			WebElement elePolicyDist = driver.findElement(By.id("Building." + elementName + "Ind"));

			if (elePolicyDist.isEnabled() && !(elePolicyDist.isSelected())) {
				Hooks.scenario.log(elementName + "  is Editable and not selected");

			} else if (!(elePolicyDist.isEnabled()) && (elePolicyDist.isSelected())) {
				Hooks.scenario.log(elementName + "  is Not Editable and selected");
			} else if (!(elePolicyDist.isEnabled()) && !(elePolicyDist.isSelected())) {
				Hooks.scenario.log(elementName + "  is neither Editable nor selected");
			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}

		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(5);
		}
	}

	/**
	 * This method runs auto renewal on desired term for a desired policy with batch
	 * jobs
	 * 
	 */
	public static String runAutoRenewPolicy(WebDriver driver, String PolicyNumber, String currentTerm, String newTerm)
			throws Exception {

//			Example format: RunBatchJobs.runAutoRenewPolicy(driver, policyNum, "01", "02", logger);--First renewal
//							RunBatchJobs.runAutoRenewPolicy(driver, policyNum, "02", "03", logger);--Second renewal

		// search and verify for policy
		searchForPolicy(driver, PolicyNumber);

		// Perform auto-renewal
		selectTaskTab(driver);
		selectShowAll(driver);
		checkShowSysTask(driver);
		String preAutoDt = getPreAutoRenewDate(driver).toString();
		String autoRenewDt = getAutoRenewDate(driver).toString();

		// Auto-renewal
		runAutoRenewalOnSinglePolicy(driver, PolicyNumber, preAutoDt, autoRenewDt);
		String temp = replaceMethod(PolicyNumber, "-" + currentTerm, "");
		String RenewalTerm = temp + "-" + newTerm;
		Thread.sleep(12000);
		driver.findElement(By.id("Menu_Workflow")).click();// *[@id="Menu_Workflow"]
		wait(15);
		Thread.sleep(15000);
		setPolicyNumSearch(driver, RenewalTerm);
		clickSearchBtn(driver);
		Thread.sleep(500);
		clickApplicationTab(driver);
		wait(4);

		return RenewalTerm;
	}

	public static void clickApplicationTab(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Tab_Policy")).click();
			Hooks.scenario.log("Policy Tab was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Tab was not checked");
			wait(5);
		}
	}

	/**
	 * This method runs batch jobs for a desired policy
	 * 
	 */
	public static void runBatchJobs(WebDriver driver, String PolicyNumber) throws Exception {
		/*
		 * ADMIN: run batch jobs for PreAutoRenewal ONLY AR Cycle Action, Task System
		 * Action and Process ACH Requests
		 */
		Thread.sleep(250);
		click(batchjobs.btnOperationsTab);
		click(batchjobs.btnSelectBatch);
		wait(5);

		click(batchjobs.btnSelectDailyJob);
		wait(5);

		setPolicyDisplayNum(driver, PolicyNumber);
		setAcctDisplayNum(driver, PolicyNumber);
		Thread.sleep(250);

		click(batchjobs.btnProcessAchExceptions);
		click(batchjobs.btnAutomatedBatchReceiptsPost);
		click(batchjobs.btnScheduledAutomatedBatchReceiptPost);
		click(batchjobs.btnActionClaimScheduledPayment);
		click(batchjobs.btnReleaseAllTheStandardACHPAymentRequest_ClaimsPersonalACH);
		click(batchjobs.btnReleaseAllTheStandardACHRefundRequest_AccountBill);
		click(batchjobs.btnPostingDateRollForwardAction);
		click(batchjobs.btnDailyWrittenToReceivables);
		click(batchjobs.btnDailyWrittenToReceivablesVerifyAction);
		click(batchjobs.btnGLDailyGeneralLedger);
		click(batchjobs.btnIncrementalDatamartExport);
		click(batchjobs.btnUpdateIncrementalLastRunDate);
		click(batchjobs.btnCompleteIndemnityPaymentReminderTask);
		click(batchjobs.btnInitiateStatsJob);
		click(batchjobs.btnInitiateDailyTaskAndBatchPrintJobs);
//			BatchJobs.clickFormatDailyIvansFile(driver, logger);		
		click(batchjobs.btnDMIFileImportAction);
		click(batchjobs.btnCapacityToolPolicyCountUpdate);
		click(batchjobs.btnDailyCycleCompleteionEmailNotifications);
		click(batchjobs.btnQuoteExpirationAction);
		click(batchjobs.btnProcessPolicyMortgageeFIRST266FileImport);
		click(batchjobs.btnProcessPolicyMortgageeInformationUpdate);
		click(batchjobs.btnDailyEmailNotificationOfJobsWithErrors);

		wait(5);
		Thread.sleep(555);
		setPolicyDisplayNum(driver, PolicyNumber);
		setAcctDisplayNum(driver, PolicyNumber);

		click(batchjobs.btnStartJob);
		wait(5);
		Thread.sleep(4000);
		selectAutoRefresh30sec(driver);
		// BatchJobs.selectAutoRefresh10sec(driver, logger);
		Thread.sleep(2000);
		wait(5);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		if (driver.findElement(By.id("Job_0_Name")).isDisplayed()) {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), " + "'Completed')]")));
		}

		Thread.sleep(10000);

	}

	public static void runBatchJobs2(WebDriver driver, String PolicyNumber) throws Exception {
		/*
		 * ADMIN: run batch jobs for PreAutoRenewal ONLY AR Cycle Action and Task System
		 * Action
		 */
		Thread.sleep(250);
		click(batchjobs.btnOperationsTab);
		click(batchjobs.btnSelectBatch);
		wait(5);
		click(batchjobs.btnSelectDailyJob);
		wait(5);
		setPolicyDisplayNum(driver, PolicyNumber);
		setAcctDisplayNum(driver, PolicyNumber);
		Thread.sleep(250);
		click(batchjobs.btnProcessAchExceptions);
		click(batchjobs.btnAutomatedBatchReceiptsPost);
		click(batchjobs.btnScheduledAutomatedBatchReceiptPost);
		click(batchjobs.btnActionClaimScheduledPayment);
		click(batchjobs.btnReleaseAllTheStandardACHPAymentRequest_ClaimsPersonalACH);
		click(batchjobs.btnReleaseAllTheStandardACHRefundRequest_AccountBill);
		click(batchjobs.btnProcessACHRequest);
		click(batchjobs.btnPostingDateRollForwardAction);
		click(batchjobs.btnDailyWrittenToReceivables);
		click(batchjobs.btnDailyWrittenToReceivablesVerifyAction);
		click(batchjobs.btnGLDailyGeneralLedger);
		click(batchjobs.btnIncrementalDatamartExport);
		click(batchjobs.btnUpdateIncrementalLastRunDate);
		click(batchjobs.btnInitiateStatsJob);
		click(batchjobs.btnInitiateDailyTaskAndBatchPrintJobs);
//			BatchJobs.clickFormatDailyIvansFile(driver, logger);
		click(batchjobs.btnDMIFileImportAction);
		click(batchjobs.btnCapacityToolPolicyCountUpdate);
		click(batchjobs.btnDailyCycleCompleteionEmailNotifications);
		click(batchjobs.btnQuoteExpirationAction);
		click(batchjobs.btnProcessPolicyMortgageeFIRST266FileImport);
		click(batchjobs.btnProcessPolicyMortgageeInformationUpdate);
		click(batchjobs.btnDailyEmailNotificationOfJobsWithErrors);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));

		setPolicyDisplayNum(driver, PolicyNumber);
		Thread.sleep(250);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));

		click(batchjobs.btnStartJob);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));

		selectAutoRefresh30sec(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		if (driver.findElement(By.id("Job_0_Name")).isDisplayed()) {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), " + "'Completed')]")));
		}

		Thread.sleep(10000);

	}

	public static void runDailyJobOnDate(WebDriver driver, String PolicyNumber, String preAutoDt) throws Exception {

		/*
		 * ADMIN: run batch jobs for Mentioned Date ONLY AR Cycle Action and Task System
		 * Action
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		Thread.sleep(200);

		ChangeDate_Admin(driver, preAutoDt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		Thread.sleep(1200);

		runBatchJobs2(driver, PolicyNumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		Thread.sleep(1200);

	}

	public static void setPolicyDisplayNum(WebDriver driver, String policyNum) throws Exception {
		try {
			driver.findElement(By.id("Question_PolicyNumber")).clear();
			driver.findElement(By.id("Question_PolicyNumber")).sendKeys(policyNum.toString());
			Hooks.scenario.log("Policy number was entered");
		} catch (Exception e) {
			Hooks.scenario.log("Policy Number was not entered");
			wait(5);
		}
	}

	public static void setAcctDisplayNum(WebDriver driver, String policyNum) throws Exception {
		try {
			driver.findElement(By.id("Question_AccountNumber")).clear();
			driver.findElement(By.id("Question_AccountNumber")).sendKeys(policyNum.toString());
			Hooks.scenario.log("Account number was entered");
		} catch (Exception e) {
			Hooks.scenario.log("Account Number was not entered");
			wait(5);
		}
	}

	public static void selectAutoRefresh30sec(WebDriver driver) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.name("RefreshInterval")));
			entityType.selectByVisibleText("Every 30 seconds".toString());
			Hooks.scenario.log("Filter Task: Every 30 seconds");
		} catch (Exception e) {
			Hooks.scenario.log("Filter Task: Every 30 seconds");
			wait(5);
		}
	}

	public static void runAutoRenewalOnSinglePolicy(WebDriver driver, String PolicyNumber, String preAutoDt,
			String autoRenewDt) throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		Thread.sleep(200);

		ChangeDate_Admin(driver, preAutoDt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		Thread.sleep(1500);

		runBatchJobs(driver, PolicyNumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		Thread.sleep(1500);

		ChangeDate_Admin(driver, autoRenewDt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		Thread.sleep(1500);

		runBatchJobs(driver, PolicyNumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		Thread.sleep(1500);

	}

	/**
	 * This method searches desired policy on dashboard
	 * 
	 */
	public static void searchForPolicy(WebDriver driver, String policyNum) throws Exception {

		wait(4);

		setPolicyNumSearch(driver, policyNum);
		clickSearchBtn(driver);
		wait(4);

		Thread.sleep(500);
		driver.navigate().refresh();

		setPolicyNumSearch(driver, policyNum);
		Thread.sleep(100);
		clickSearchBtn(driver);
		wait(4);
	}

	/**
	 * This method clicks Search button
	 * 
	 */
	public static void clickSearchBtn(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("ToolbarSearch")).click();
			wait(3);
			Hooks.scenario.log("Search button was clicked ");
		} catch (Exception e) {
			Hooks.scenario.log("Search button was not clicked");
			wait(4);
		}
		Thread.sleep(500);
	}

	/**
	 * This method searches desired policy
	 * 
	 */
	public static void setPolicyNumSearch(WebDriver driver, String policyNum) throws Exception {
		try {
			driver.findElement(By.id("ToolbarSearchText")).clear();
			driver.findElement(By.id("ToolbarSearchText")).sendKeys(policyNum.toString());
			Hooks.scenario.log("Policy Number: " + policyNum);
		} catch (Exception e) {
			Hooks.scenario.log("Policy Number: " + policyNum);
			wait(5);
		}
	}

	/**
	 * This method selects tasks tab
	 * 
	 */
	public static void selectTaskTab(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Tab_Tasks")).click();
			wait(5);
			Hooks.scenario.log("Task tab was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Task tab was not selected");
			wait(5);
		}
	}

	/**
	 * This method selects show all
	 * 
	 */

	public static void selectShowAll(WebDriver driver) throws Exception {
		try {

			driver.findElement(By.id("ShowAll")).click();
			wait(5);
			Hooks.scenario.log("ShowAll was selected");
		} catch (Exception e) {
			Hooks.scenario.log("ShowAll was selected");
			wait(5);
		}
	}

	/**
	 * This method selects show system task
	 * 
	 */
	public static void checkShowSysTask(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("SystemTaskInd")).click();
			wait(5);
			Hooks.scenario.log("Show system task was selected");
			Thread.sleep(500);
		} catch (Exception e) {
			Hooks.scenario.log("Show system task was not selected");
			wait(5);
		}
	}

	/**
	 * This method gets preAuto Renewal Date for policy
	 * 
	 */
	public static Object getPreAutoRenewDate(WebDriver driver) throws Exception {
		String preAutoRenewDt = null;
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'System')]"));
			preAutoRenewDt = driver.findElement(By.xpath(
					"(//*[contains(text(),'Pre-Automated Renewal Validation for Policy')])[1]//following-sibling::*[6]"))
					.getText().toString();
			Hooks.scenario.log("PreAutomatic Renewal Date: " + preAutoRenewDt);
		} catch (Exception e) {
			Hooks.scenario.log("PreAutomatic Renewal Date: " + preAutoRenewDt);
			wait(5);
		}
		return preAutoRenewDt.toString();
	}

	/**
	 * This method gets Automated Renewal Date for policy
	 * 
	 */
	public static Object getAutoRenewDate(WebDriver driver) throws Exception {
		String AutoRenewDt = null;
		try {
			driver.findElement(By.xpath("//*[contains(text(), 'System')]"));
			AutoRenewDt = driver
					.findElement(By.xpath(
							"(//*[contains(text(),'Automated Renewal for Policy')])[1]//following-sibling::*[6]"))
					.getText().toString();
			Hooks.scenario.log("Automatic Renewal Date: " + AutoRenewDt);
		} catch (Exception e) {
			Hooks.scenario.log("Automatic Renewal Date: " + AutoRenewDt);
			wait(5);
		}

		return AutoRenewDt.toString();
	}

	/**
	 * This method gets Scheduled Task Description on Tasks Chevron
	 * 
	 */
	public static Object getScheduledTaskDescription(WebDriver driver, String taskName) throws Exception {

		String taskDescription = null;

		try {
			taskDescription = driver.findElement(By.xpath("(//*[contains(text(), '" + taskName + "')])[1]")).getText()
					.toString();
			Hooks.scenario.log(taskName + " task description: " + taskDescription);
		} catch (Exception e) {
			Hooks.scenario.log(taskName + " task description: " + taskDescription);
			wait(5);
		}
		return taskDescription.toString();
	}

	public static boolean verify_AnyText_IsVisibleMultipletimes(WebDriver driver, String text, String index)
			throws Exception {

		try {
			if (driver.findElement(By.xpath("(//*[contains(text(), '" + text + "')])[" + index + "]")).isDisplayed()) {
				Hooks.scenario.log("Is visible: " + text);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Is visible: " + text);
			wait(5);
			return false;
		}
	}

	public static void verifyAnyCoverageCheckbox_NotEnabledSelected(WebDriver driver, String elementName)
			throws Exception {
		try {

			WebElement elePolicyDist = driver.findElement(By.name("" + elementName + ""));

			if (!(elePolicyDist.isEnabled()) && (elePolicyDist.isSelected())) {
				Hooks.scenario.log(elementName + "  is not Editable and selected");

			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}

		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(5);
		}
	}

	public static void verifyAnyCoverageCheckbox_EnabledSelected(WebDriver driver, String elementName)
			throws Exception {
		try {

			WebElement elePolicyDist = driver.findElement(By.name("" + elementName + ""));
			if ((elePolicyDist.isEnabled()) && (elePolicyDist.isSelected())) {
				Hooks.scenario.log(elementName + "  is editable and selected");
			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}

		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(5);
		}
	}

	public static boolean verify_AnyButton_IsVisible(WebDriver driver, String text) throws Exception {
		Thread.sleep(2000);

		try {
			if (driver.findElement(By.xpath("//*[@id='" + text + "']")).isDisplayed()) {
				Hooks.scenario.log("Is visible: " + text);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Is visible: " + text);
			wait(5);
			return false;
		}

	}

	public static String getNextActionDate(WebDriver driver) throws Exception {
		String num = null;
		try {
			String action = driver.findElement(By.id("Description_text")).getText().toString();
			num = action.substring(action.indexOf("on") + 3, action.length()).toString();
			wait(4);
			Hooks.scenario.log(action + " next action Date : " + num);
		} catch (Exception e) {
			Hooks.scenario.log(num + " next action Date : ");

		}
		return num;
	}

	public static void verifyInstallmentInvoiceForm(WebDriver driver, String invoiceName) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[contains(text(), '" + invoiceName + "')])[2]"));
			Hooks.scenario.log(invoiceName + " is visible");
		} catch (Exception e) {
			Hooks.scenario.log(invoiceName + " is visible");
			wait(5);
		}
	}

	public static void clickOnAnyPolicyFileTabForm(WebDriver driver, String invoiceName) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[contains(text(), '" + invoiceName + "')])[2]")).click();
			Hooks.scenario.log(invoiceName + " clicked");
		} catch (Exception e) {
			Hooks.scenario.log(invoiceName + " clicked");
			wait(5);
		}
	}

	public static boolean verifyChangePayPlanNotVisible(WebDriver driver) throws Exception {

		try {
			if (driver.findElement(By.id("_ChangePayplan_Link")).isDisplayed()) {
				Hooks.scenario.log("ChangePayplan_Link is visible");
				return false;
			}
			return false;
		} catch (Exception e) {
			Hooks.scenario.log("ChangePayplan_Link not visible");
			return true;
		}
	}

	public static boolean verifyPayPlanTypeIsDisabled(WebDriver driver) throws Exception {

		try {
			Boolean isEnabled = driver.findElement(By.id("BasicPolicy.PayPlanFilterTypeCd")).isEnabled();
			if (isEnabled == true) {
				Hooks.scenario.log("verifyPayPlanTypeIsEnabled");
				return true;
			} else if (isEnabled == false) {
				Hooks.scenario.log("verifyPayPlanTypeIsDisabled");
				return false;
			}
		} catch (Exception e) {
			Hooks.scenario.log("verifyPayPlanTypeIsDisabled");
			return false;
		}
		return false;
	}

	public static void scrollToAnyField(WebDriver driver, String fieldName) throws Exception {
		try {
			WebElement e = driver.findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);

		} catch (Exception e) {
			Hooks.scenario.log("Scrolling not performed");
			wait(5);
		}
	}

	public static void startTransaction(WebDriver driver) throws Exception {
		try {
			try {
				driver.findElement(By.id("MoreActionsDropdownButton")).click();
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
				Hooks.scenario.log("More button was selected");
			} catch (Exception e) {
				Hooks.scenario.log("More button was not selected");
			}

			driver.findElement(By.id("Transaction")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		} catch (Exception e) {
			Hooks.scenario.log("START TRANSACTION was not selected");
		}
	}

	public static void clickSummaryChevron(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Wizard_Summary")).click();
			Hooks.scenario.log("Summary chevron selected");
		} catch (Exception e) {
			Hooks.scenario.log("Summary chevron selected");
			wait(5);
		}
	}

	public static boolean verify_AnyfirstText_IsDisplayed(WebDriver driver, String text) throws Exception {
		try {
			if (driver.findElement(By.xpath("(//*[text()='" + text + "'])[1]")).isDisplayed()) {
				Hooks.scenario.log("Is visible: " + text);
				attachScreenShot(driver);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Is visible: " + text);
			wait(5);
			attachScreenShot(driver);
			return false;
		}
	}

	public static void getAnyDropDownOptions(WebDriver driver, String field) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.id("" + field + "")));
			WebElement story_field = driver.findElement(By.id("" + field + ""));
			story_field.click();
			List<WebElement> options = entityType.getOptions();

			Hooks.scenario.log(field + " options are:");
			for (WebElement item : options) {
				Hooks.scenario.log(item.getText());
			}
		} catch (Exception e) {
			Hooks.scenario.log(field + "Options:");
			wait(5);
		}
	}

	public static String getTextOfElement(WebDriver driver, String element) throws Exception {
		String num = null;

		try {
			num = driver.findElement(By.id(element)).getText().toString();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Hooks.scenario.log(element + " text : " + num);
		} catch (Exception e) {
			Hooks.scenario.log(element + " text : ");
		}
		return num;
	}

	public static void clickOnAnyText(WebDriver driver, String policy) throws Exception {
		try {

			driver.findElement(By.xpath("//*[contains(text(),'" + policy + "')]")).click();
			Hooks.scenario.log("Policy selected: " + policy);

		} catch (Exception e) {
			Hooks.scenario.log("Policy not selected: " + policy);
			wait(5);
		}
	}

	public static void clickMagnifierIcon(WebDriver driver, String order) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[@id='ProducerLookup'])[" + order + "]")).click();
			Hooks.scenario.log("MagnifierGlass Icon was clicked");
		} catch (Exception e) {
			Hooks.scenario.log("MagnifierGlass Icon was not clicked");
			wait(5);
		}
	}

	public static void verifyClaimsTaskStatus(WebDriver driver, String task, String text) throws Exception {

		String compare = driver
				.findElement(By.xpath("(//*[contains(text(),'" + task + "')])[1]//following-sibling::td[5]")).getText()
				.toString();

		try {
			if (compare.contentEquals(text)) {
				Hooks.scenario.log(task + " Status matched " + "Actual " + compare + " Expected " + text);
			} else {
				Hooks.scenario.log(task + " Status mismatch " + "Actual " + compare + ", Expected " + text);
			}
		} catch (Exception e) {
			Hooks.scenario.log(task + " Status mismatch");
			wait(5);
		}
	}

	public static void setSubReason(WebDriver driver, String cancelSubReason) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.name("SubReasonCd")));
			entityType.selectByVisibleText(cancelSubReason);
			Hooks.scenario.log("Cancellation Sub-Reason: " + cancelSubReason);
		} catch (Exception e) {
			Hooks.scenario.log("Cancellation Sub-Reason: " + cancelSubReason);
			wait(5);
		}
	}

	public static void clickonAnyButton(WebDriver driver, String button) throws Exception {
		try {
			driver.findElement(By.id("" + button + "")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
			Hooks.scenario.log(button + " button was clicked");
		} catch (Exception e) {
			Hooks.scenario.log(button + " button was not clicked");
			wait(5);
		}
	}

	public static String getTransactionEffDate(WebDriver driver) throws Exception {

		String termeff = null;

		try {
			clickSummary(driver);

			driver.findElement(By.id("Full_PolicySummary_TransactionEffectiveDt")).getText().toString();
			termeff = driver.findElement(By.id("Full_PolicySummary_TransactionEffectiveDt")).getText().toString();
			Hooks.scenario.log("Transaction effective Date is: " + termeff);

			clickSummary(driver);
		} catch (Exception e) {
			Hooks.scenario.log("Transaction effective Date is: " + termeff);
			wait(5);
		}
		return termeff.toString();
	}

	public static void clickSummary(WebDriver driver) throws Exception {

		try {
			Thread.sleep(1000);
			driver.findElement(By.id("FullSummaryHolder")).click();
			Thread.sleep(1000);
			Hooks.scenario.log("Summary tab clicked ");

		} catch (Exception e) {
			Hooks.scenario.log("Summary not clicked ");
			wait(5);
		}
	}

	public static void setDataToAnyTextboxField(WebDriver driver, String field, String element, String value)
			throws Exception {
		try {
			WebElement toClear = driver.findElement(By.id("" + element + ""));
			toClear.click();
			toClear.sendKeys(Keys.CONTROL + "a");
			toClear.sendKeys(Keys.DELETE);
			Thread.sleep(500);
			toClear.sendKeys(value.toString());
			Hooks.scenario.log(field + " set to : " + value);
		} catch (Exception e) {
			Hooks.scenario.log(field + " set to : " + value);
			wait(5);
		}
	}

	public static String getNextAction_Text(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.id("Description_text")).click();
			Hooks.scenario.log("Next Action: " + driver.findElement(By.id("Description_text")).getText().toString());
		} catch (Exception e) {
			Hooks.scenario.log("Next Action: " + driver.findElement(By.id("Description_text")).getText().toString());
			wait(5);
		}
		return driver.findElement(By.id("Description_text")).getText();
	}

	public static void setReason(WebDriver driver, String cancelReason) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.name("ReasonCd")));
			entityType.selectByVisibleText(cancelReason);
			Hooks.scenario.log("Cancellation Reason: " + cancelReason);
		} catch (Exception e) {
			Hooks.scenario.log("Cancellation Reason: " + cancelReason);
			wait(5);
		}
	}

	public static void makePaymentCCPayment_Amount(WebDriver driver, String AmountPaid) throws Exception {

		click(closeoutChevron.btnEnterCCDetails);
		clickonAnyButton(driver, "CreditCardPrompCheckBox");
		Thread.sleep(1000);
		clickonAnyButton(driver, "CreditCardPromptDivOk");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Hooks.scenario.log("Switched to credit card details frame");
		sendText(makePayment.txtCardNumber, "5424000000000015");
		sendText(makePayment.txtExpiryDate, "1224");
		sendText(makePayment.txtCVV, "123");
		sendText(makePayment.txtFirstName, "First Name");
		sendText(makePayment.txtLastName, "Last Name");
		sendText(makePayment.txtZip, "123456");
		sendText(makePayment.txtAddress, "1234 Street");
		sendText(makePayment.txtCity, "City");
		sendText(makePayment.txtState, "State");
		sendText(makePayment.txtPhoneNumber, "123-456-7895");
		sendText(makePayment.txtCompanyNameID, "Company");
		wait(3);
		click(makePayment.btnSaveButton);
		driver.switchTo().defaultContent();
		wait(2);

		sendText(driver.findElement(By.id("ReceiptAmt")), AmountPaid);
		Thread.sleep(3000);
		click(driver.findElement(By.id("SubmitPayment")));
		wait(3);
		acceptAlert();
		click(driver.findElement(By.id("dialogOK")));
		wait(1);
		Thread.sleep(2000);

		Set<String> DriverFocus2 = driver.getWindowHandles();
		Iterator<String> IteratorDriverFocus2 = DriverFocus2.iterator();
		String ParentWindow2 = IteratorDriverFocus2.next();

		driver.switchTo().window(ParentWindow2);
		Thread.sleep(200);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	}

	public static void addSamplePDF(WebDriver driver) throws Exception {
		try {
			Thread.sleep(12000);
			StringSelection ss = new StringSelection(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestingPDF.pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(15000);
			click(attachmentsChevron.btnAddAttachment);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			;
		} catch (Exception e) {
			Hooks.scenario.log("AddAttachment was not clicked");
			wait(5);
		}
	}

	public static boolean verify_AnyLink_IsVisible(WebDriver driver, String text) throws Exception {
		Thread.sleep(2000);

		try {
			if (driver.findElement(By.xpath("//a[contains(text(), '" + text + "')]")).isDisplayed()) {
				Hooks.scenario.log("Link is visible: " + text);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Link is NOT visible: " + text);
			wait(5);
			return false;
		}
	}

	public static void clickonAnyExpandButton(WebDriver driver, String ImageText) throws Exception {
		try {

			driver.findElement(By.xpath("//*[contains(text(),'" + ImageText + "')]//preceding-sibling::*/i")).click();

			wait(1);
			Hooks.scenario.log(" Expand button was clicked");
		} catch (Exception e) {
			Hooks.scenario.log(" Expand button was not clicked");
			wait(5);
		}
	}

	public static String getArbitrationTaskStatus(WebDriver driver, String task) throws Exception {
		String status = null;
		try {

			status = driver.findElement(By.xpath("//*[contains(text(),'" + task + "')]//following::*[5]")).getText()
					.toString();
			Hooks.scenario.log("Status: " + status);
		} catch (Exception e) {
			Hooks.scenario.log("Status: " + status);
			wait(5);
		}
		return status.toString();
	}

	public static String getArbitrationTaskWorkDate(WebDriver driver, String task) throws Exception {
		String workDate = null;
		try {
			workDate = driver.findElement(By.xpath("//*[contains(text(),'" + task + "')]//following::*[6]")).getText()
					.toString();
			Hooks.scenario.log("Work Date: " + workDate);
		} catch (Exception e) {
			Hooks.scenario.log("Work Date: " + workDate);
			wait(5);
		}
		return workDate.toString();
	}

	public static String editDescriptionTask(WebDriver driver, String description) throws Exception {

		try {
			driver.findElement(By.id("Attachment.Description")).clear();
			driver.findElement(By.id("Attachment.Description")).sendKeys(description);
			Hooks.scenario.log(description + " is added added in Description field");
		} catch (Exception e) {
			Hooks.scenario.log(description + " was not added in description field");
			wait(4);
		}
		return driver.findElement(By.id("Attachment.Description")).getAttribute("value").toString();
	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws Exception {
		String time = new SimpleDateFormat("hh_mm_ss a").format(new Date());
		String monthYearName = new SimpleDateFormat("MMM yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Tests Screenshots/" + "/" + monthYearName + "/"
				+ screenshotName + time + ".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}

	/**
	 * This method taking screenshot and attaching to the step
	 * 
	 */
	public static void attachScreenShot(WebDriver driver) throws Exception {
		String screenShotPath = getScreenShot(driver, "Screenshot - ");

		// Read the image file as a byte array
		byte[] fileContent = FileUtils.readFileToByteArray(new File(screenShotPath));

		// Encode the byte array to base64
		String base64Encoded = Base64.encodeBase64String(fileContent);

		// Embed the base64 encoded image using HTML or Markdown syntax
		String embedHtml = "<img src='data:image/png;base64," + base64Encoded + "'/>";

		// Log the message with the screenshot path and embedded image
		Hooks.scenario.log("Snapshot: " + screenShotPath + "\n" + embedHtml);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
	}

	public static void verifyAnyTextbox_EnabledDisabled(WebDriver driver, String elementName) throws Exception {
		attachScreenShot(driver);

		try {

			WebElement ele = driver.findElement(By.id("" + elementName + ""));

			if (ele.isEnabled()) {
				Hooks.scenario.log(elementName + "  is Editable");
			} else if (!(ele.isEnabled())) {
				Hooks.scenario.log(elementName + "  is Disabled");
			} else {
				Hooks.scenario.log(elementName + "  is not able to validate");
			}
		} catch (Exception e) {
			Hooks.scenario.log(elementName + " not able to validate");
			wait(5);
		}
	}

	public static boolean verifyAnyLossCauseClaimStatus(WebDriver driver, String losscause, String expectedResults)
			throws Exception {
		// losscause as 'Water Damage' or Theft or Liability BI - Pollution or any loss

		WebElement ele = driver
				.findElement(By.xpath("(//*[contains(text(),'" + losscause + "')]//following::*[3])[2]"));
		String actual = ele.getText().toString();

		try {
			if (actual.contentEquals(expectedResults)) {
				Hooks.scenario.log(losscause + " claim status is : " + ele.getText().toString());
				return true;

			} else {
				Hooks.scenario.log(losscause + " claim status is : " + ele.getText().toString());
				return true;
			}
		} catch (Exception e) {
			Hooks.scenario.log(losscause + " claim status is : " + ele.getText().toString());
			wait(5);
			return false;
		}
	}

	public static void setProducerCode(WebDriver driver, String producer) throws Exception {
		try {

			WebElement inputBox = driver.findElement(By.id("ProviderNumber"));
			String checkIfEmpty = inputBox.getAttribute("value");

			if (checkIfEmpty.isEmpty()) {
				driver.findElement(By.id("ProviderNumber")).sendKeys(producer.toString());
				Hooks.scenario.log("Producer Code: " + producer);
			}

			else if (!checkIfEmpty.isEmpty()) {
				driver.findElement(By.id("ProviderNumber")).getText().toString();
				Hooks.scenario
						.log("Producer Code: " + driver.findElement(By.id("ProviderNumber")).getText().toString());
			}

		} catch (Exception e) {
			Hooks.scenario.log("Producer Code: " + producer);
			wait(5);
		}
	}

	/**
	 * This method simulates pressing the "Tab" key.
	 * 
	 * @param element The WebElement where the "Tab" key should be sent.
	 */
	public static void pressTabKey(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getAnyDropdownPopulatedValue(WebDriver driver, String element) throws Exception {
		String value = null;
		try {
			Select entityType = new Select(driver.findElement(By.id("" + element + "")));
			value = entityType.getFirstSelectedOption().getText();
			Hooks.scenario.log(element + " populated with " + value);
		} catch (Exception e) {
			Hooks.scenario.log(element + " not populated with " + value);
			wait(5);
		}
		return value.toString();
	}

	public static void clickAnyMagnifierIcon(WebDriver driver, String Icon) throws Exception {
		try {
			driver.findElement(By.xpath("//*[contains(@onclick,'" + Icon + "')]")).click();
			;
			Hooks.scenario.log("Magnifier Icon clicked");
		} catch (Exception e) {
			Hooks.scenario.log("Magnifier Icon clicked");
			wait(5);
		}
	}

	public static void clickAdjustReserves(WebDriver driver) {
		wait(1);

		WebElement userManagement = new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.elementToBeClickable(By.id("AdjustReserve_1")));
		new Actions(driver).moveToElement(userManagement).perform();
		userManagement.click();
	}

	public static void setClaimNumSearch(WebDriver driver, String claimNum) throws Exception {
		try {

			driver.findElement(By.id("AdvancedSearchClaims")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ClaimNumber")).clear();
			driver.findElement(By.id("ClaimNumber")).sendKeys(claimNum.toString());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			driver.findElement(By.id("SearchClaim")).click();
			Hooks.scenario.log("Claim Number: " + claimNum);
		} catch (Exception e) {
			Hooks.scenario.log("Claim Number: " + claimNum);
			wait(5);
		}
	}

	public static void verifyClaimReopenStatus_CovA(WebDriver driver) throws Exception {
		String closed = driver.findElement(By.id("Reserve_1_CovA_COVASUB_Indemnity_StatusCd")).getText();

		try {
			if (closed.contentEquals("Reopen")) {
				Hooks.scenario.log("Status is Reopen");
			} else {
				Hooks.scenario.log("Status is Reopen");
			}
		} catch (Exception e) {
			Hooks.scenario.log("Status is Closed");
			wait(5);
		}
	}

	public static void setFloodCoverage_ADwelling(WebDriver driver, String FloodCovALimit) throws Exception {
		try {
			WebElement toClear = driver.findElement(By.id("Building.FloodCovALimit"));
			toClear.click();
			toClear.sendKeys(Keys.CONTROL + "a");
			toClear.sendKeys(Keys.DELETE);
			Thread.sleep(500);
			driver.findElement(By.id("Building.FloodCovALimit")).sendKeys(FloodCovALimit.toString());
			Hooks.scenario.log("FloodCovALimit: " + FloodCovALimit);
		} catch (Exception e) {
			Hooks.scenario.log("FloodCovALimit: " + FloodCovALimit);
			wait(5);
		}
	}

	public static int getCountOfText(WebDriver driver, String text) throws Exception {
		int count = 0;
		try {
			List<WebElement> ele = driver.findElements(By.xpath("//*[text()='" + text + "']"));
			waitImp(3);
			count = ele.size();
			Hooks.scenario.log("Chargeabel '" + text + "' appeared count is " + ele.size());

		} catch (Exception e) {
			Hooks.scenario.log("Chargeable");
			waitImp(3);
		}
		return count;
	}

	public static void VerifyAnyDropdownIsNotSelected(WebDriver driver, String element) throws Exception {

		try {
			WebElement ele = (WebElement) new Select(driver.findElement(By.id("" + element + "")));

			if (ele.isSelected()) {

				Hooks.scenario.log(element + " is selected");
			}
		} catch (Exception e) {
			Hooks.scenario.log(element + " is not selected");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		}

	}

	public static void getInsuranceScore(WebDriver driver, String InsuranceScoreEstimate) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.id("Insured.InsuranceScoreEstimate")));
			entityType.selectByVisibleText(InsuranceScoreEstimate.toString());
			Hooks.scenario.log("Insurance Score: " + InsuranceScoreEstimate);
		} catch (Exception e) {
			Hooks.scenario.log("Insurance Score: NOT SELECTED" + InsuranceScoreEstimate);
			wait(4);
		}
	}

	public static void verifyLetterForm(WebDriver driver, String formName) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[contains(text(), '" + formName + "')])[1]"));
			Hooks.scenario.log(formName + " is visible");
		} catch (Exception e) {
			Hooks.scenario.log(formName + " is NOT visible");
			wait(5);
		}
	}

	public static void addSampleFile(WebDriver driver) throws Exception {
		try {
			Thread.sleep(12000);

			StringSelection ss = new StringSelection(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestingONLY.xlsx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(15000);
			click(attachmentsChevron.btnAddAttachment);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			;
			attachScreenShot(driver);
		} catch (Exception e) {
			Hooks.scenario.log("AddAttachment was not clicked");
			wait(5);
		}
	}

	public static boolean verify_JointLabels_IsDisplayed(WebDriver driver, String text) throws Exception {
		try {
			if (driver.findElement(By.xpath("(//*[text()='" + text + "'])[2]")).isDisplayed()) {
				Hooks.scenario.log("Joint label visible: " + text);
				return true;
			}
			return true;

		} catch (Exception e) {
			Hooks.scenario.log("Joint label: " + text);
			wait(5);
			return false;
		}
	}

	public static String getLossTypePopulatedValue(WebDriver driver) throws Exception {
		String value = null;
		try {
			Select entityType = new Select(driver.findElement(By.id("ClaimLossTemplateIdRef")));
			value = entityType.getFirstSelectedOption().getText();
			Hooks.scenario.log("Loss Type populated with " + value);

		} catch (Exception e) {
			Hooks.scenario.log("Loss type not populated with " + value);
			wait(5);
		}
		return value.toString();
	}

	public static void getAnyDropDownOptionsOnLossNotice(WebDriver driver, String field) throws Exception {
		try {
			Select entityType = new Select(driver.findElement(By.id("Claim." + field + "")));
			WebElement story_field = driver.findElement(By.id("Claim." + field + ""));
			story_field.click();
			List<WebElement> options = entityType.getOptions();

			Hooks.scenario.log(field + " options are:");
			for (WebElement item : options) {
				Hooks.scenario.log(item.getText());
			}
		} catch (Exception e) {
			Hooks.scenario.log(field + "Options:");
			wait(5);
		}
	}

	public static String getanyDropDownPopulatedValueOnLossNotice(WebDriver driver, String element) throws Exception {
		String value = null;
		try {
			Select entityType = new Select(driver.findElement(By.id("Claim." + element + "")));
			value = entityType.getFirstSelectedOption().getText();
			Hooks.scenario.log(element + " populated with " + value);
		} catch (Exception e) {
			Hooks.scenario.log(element + " not populated with " + value);
			wait(5);
		}
		return value.toString();
	}

	public static void expandTransaction(WebDriver driver, String history) throws Exception {
		try {
			driver.findElement(By.name("History_" + history + "_Expand"));
			driver.findElement(By.name("History_" + history + "_Expand")).click();
			wait(1);
			Hooks.scenario.log("Expanded transaction history " + history);
		} catch (Exception e) {
			Hooks.scenario.log("Not Expanded transaction history " + history);
			wait(5);
		}
	}

	public static void clickProcess(WebDriver driver) throws Exception {
		attachScreenShot(driver);

		try {
			driver.findElement(By.id("Process")).click();
			wait(3);
			Hooks.scenario.log("Process was selected");
		} catch (Exception e) {
			Hooks.scenario.log("Process was not selected");
			wait(5);
		}
	}

	public static void setAddress(WebDriver driver, String num, String street, String zip) throws Exception {
		try {
			driver.findElement(By.id("InsuredResidentAddr.PrimaryNumber")).clear();
			driver.findElement(By.id("InsuredResidentAddr.PrimaryNumber")).sendKeys(num.toString());

			driver.findElement(By.id("InsuredResidentAddr.StreetName")).clear();
			driver.findElement(By.id("InsuredResidentAddr.StreetName")).sendKeys(street.toString());

			// driver.findElement(By.id("InsuredResidentAddr.City")).clear();
			// driver.findElement(By.id("InsuredResidentAddr.City")).sendKeys(city.toString());

			// driver.findElement(By.id("InsuredResidentAddr.County")).clear();
			// driver.findElement(By.id("InsuredResidentAddr.County")).sendKeys(county.toString());

			// Select entityType = new Select
			// (driver.findElement(By.id("InsuredResidentAddr.StateProvCd")));
			// entityType.selectByVisibleText(state.toString());

			driver.findElement(By.id("InsuredResidentAddr.PostalCode")).clear();
			driver.findElement(By.id("InsuredResidentAddr.PostalCode")).sendKeys(zip.toString());

			Hooks.scenario.log("Address: " + num + " " + street + " " + zip);
		} catch (Exception e) {
			Hooks.scenario.log("Address: FAILED" + num + " " + street + " " + " " + zip);
			wait(5);
		}
	}

	public static void clickInsuranceDialog(WebDriver driver, String policy) throws Exception {
		try {

			driver.findElement(By.xpath("(//*[text()='" + policy + "'])[3]")).click();
			Hooks.scenario.log("Text selected: " + policy);

		} catch (Exception e) {
			Hooks.scenario.log("Text not selected: " + policy);
			wait(5);
		}
	}

	public static void clickOKDailogButton(WebDriver driver) throws Exception {
		try {

			driver.findElement(By.id("dialogOK")).click();
			wait(2);
			Hooks.scenario.log("dialogOK selected");
		} catch (Exception e) {
			Hooks.scenario.log("dialogOK not selected");
			wait(5);
		}
	}

	public static boolean verify_AnyText_NotVisibleTwice(WebDriver driver, String text) throws Exception {

		try {
			if (driver.findElement(By.xpath("(//*[contains(text(), '" + text + "')])[2]")).isDisplayed()) {
				Hooks.scenario.log("Not visible: " + text);

				return false;
			}
			return false;
		} catch (Exception e) {
			Hooks.scenario.log("Not visible: " + text);
			attachScreenShot(driver);
			return true;
		}
	}

	public static boolean verifyResults_ForAnyCoverageDiscountPropertyDesc(WebDriver driver, String coverage,
			String element, String expectedResults) throws Exception {

		String target = "//*[contains(@id,'" + element + "')]/td[2]";
		Boolean results = null;

		if (driver.findElement(By.xpath(target)).getText().contains(expectedResults)) {
			Hooks.scenario.log(coverage + "_" + element + "_description: "
					+ driver.findElement(By.xpath(target)).getText().toString());
			results = true;

		} else {
			Hooks.scenario.log(coverage + "_" + element + "_description: "
					+ driver.findElement(By.xpath(target)).getText().toString());
			results = false;
		}
		return results;

	}

	public static boolean verifyResults_ForAnyCoverageDiscountPropertyRate(WebDriver driver, String coverage,
			String element, String expectedResults) throws Exception {

		String target = "//*[contains(@id,'" + element + "')]/td[4]";
		Boolean results = null;

		if (driver.findElement(By.xpath(target)).getText().contentEquals(expectedResults)) {
			Hooks.scenario.log(
					coverage + "_" + element + "_rate: " + driver.findElement(By.xpath(target)).getText().toString());
			results = true;

		} else {
			Hooks.scenario.log(
					coverage + "_" + element + "_rate: " + driver.findElement(By.xpath(target)).getText().toString());
			results = false;
		}
		return results;
	}

	public static void expandAnyDiscountProperty(WebDriver driver, String coverage, String element) throws Exception {
		try {
			driver.findElement(By.xpath("(//*[contains(@id,'" + element + "')])"));
			driver.findElement(By.xpath("(//*[contains(@id,'" + element + "')])")).click();
			Hooks.scenario.log(coverage + " " + element + " clicked");
		} catch (Exception e) {
			Hooks.scenario.log(coverage + " " + element + " clicked");
			wait(5);
		}
	}

	public static boolean expectedReults_ExpectedValueFoundXpath(WebDriver driver, String string, String xpath)
			throws Exception {
		attachScreenShot(driver);

		try {
			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
				if (driver.findElement(By.xpath(xpath)).getText().toString().contentEquals(string)) {
					Hooks.scenario.log("Expected Value Found: " + string);
					return true;
				} else if (!driver.findElement(By.xpath(xpath)).getText().toString().contentEquals(string)) {
					Hooks.scenario.log("Expected Value Not Found: " + string);
					return false;
				}
			}

			else if (!driver.findElement(By.xpath(xpath)).isDisplayed()) {
				Hooks.scenario.log("Expected Value Not Found: " + string);
				wait(4);
				return false;
			}
			return true;
		} catch (Exception e) {
			Hooks.scenario.log("Expected Value Not Found: " + string);
			attachScreenShot(driver);
			e.printStackTrace();

			return false;
		}
	}
}
