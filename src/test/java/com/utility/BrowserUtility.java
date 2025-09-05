package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable driver!!
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.info("Invalid browser name... Please select Chrome or Edge browser");
			System.err.println("Invalid browser name... Please select Chrome or Edge browser");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-gpu"); // helps on Windows
				options.addArguments("--no-sandbox"); // required in some environments
				options.addArguments("--disable-dev-shm-usage"); // prevents shared memory issues
				options.addArguments("--remote-allow-origins=*");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}

		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement signInLinkWebElement = driver.get().findElement(locator);
		logger.info("Element found now performing click ");
		signInLinkWebElement.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement emailTextBoxWebElement = driver.get().findElement(locator);
		logger.info("Element found now performing enter text " + textToEnter);
		emailTextBoxWebElement.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found now returning the visible text " + element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
