package aii.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import aii.utils.ConfigsReader;
import aii.utils.Constants;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Scenario scenario;

	/**
	 * This method will create the driver
	 */
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
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
			driver = new EdgeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported!!!");
		}

		String environment = ConfigsReader.getProperty("environment").toLowerCase();
		System.out.println("Environment: " + environment);

		switch (environment) {

		case "model":
			System.out.println("Opening Model environment...");
			driver.get(ConfigsReader.getProperty("urlmodel"));
			break;

		case "model2":
			System.out.println("Opening Model2 environment...");
			driver.get(ConfigsReader.getProperty("urlmodel2"));
			break;

		case "qa1":
			System.out.println("Opening QA1 environment...");
			driver.get(ConfigsReader.getProperty("urlqa1"));
			break;

		case "qa2":
			System.out.println("Opening QA2 environment...");
			driver.get(ConfigsReader.getProperty("urlqa2"));
			break;

		case "qa3":
			System.out.println("Opening QA3 environment...");
			driver.get(ConfigsReader.getProperty("urlqa3"));
			break;

		case "qa4":
			System.out.println("Opening QA4 environment...");
			driver.get(ConfigsReader.getProperty("urlqa4"));
			break;

		case "qa5":
			System.out.println("Opening QA5 environment...");
			driver.get(ConfigsReader.getProperty("urlqa5"));
			break;

		case "qa6":
			System.out.println("Opening QA6 environment...");
			driver.get(ConfigsReader.getProperty("urlqa6"));
			break;

		case "qa7":
			System.out.println("Opening QA7 environment...");
			driver.get(ConfigsReader.getProperty("urlqa7"));
			break;
			
		case "production":
			System.out.println("Opening Production Environment");
			driver.get(ConfigsReader.getProperty("production"));
			break;
			
		case "uat":
			System.out.println("Opening UAT Environment");
			driver.get(ConfigsReader.getProperty("uat"));
			break;
			
		default:
			throw new RuntimeException("Environment has not been found!!! Environment: " + environment);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
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
