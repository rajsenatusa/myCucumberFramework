package aii.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import aii.utils.ConfigsReader;
import aii.utils.Constants;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public  Scenario scenario;

	/**
	 * This method will create the driver
	 */
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);	
		
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;		
		case "edgedriver":
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
			break;		
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			throw new RuntimeException("Browser is not supported!!!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize();
	}

	/**
	 * This method will quit the browser
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	

}
