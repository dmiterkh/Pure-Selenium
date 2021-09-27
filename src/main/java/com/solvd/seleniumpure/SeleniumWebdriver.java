package com.solvd.seleniumpure;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebdriver {

	private final static Logger LOGGER = LoggerFactory.getLogger(SeleniumWebdriver.class);
	
	public void showSeleniumDriverChrome() {
		
		System.out.println("0");
		System.out.println("Chrome driver has been launched successfully");
		//Windows
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\bin\\chromedriver94.exe"); //Version94
		//MAC
		//System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver93mac");  
		System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver94mac");  
		
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.get("http://google.com");
		
		WebElement GmailButton = driverChrome.findElement(By.xpath("//a[text()='Gmail']"));
		GmailButton.click();
	

		WebDriverWait wait = new WebDriverWait(driverChrome, 3);
		WebElement businessButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Для бизнеса')]")));
		try {
		Thread.sleep(3000);
		} catch(InterruptedException e) {
			
		}
		
		WebElement newBusinessButton = driverChrome.findElement(By.xpath("//a[contains(text(),'Для бизнеса')]"));
		newBusinessButton.click();

		WebElement adminConsoleButton = driverChrome.findElement(By.xpath("//a[@class='h-c-header__cta-li-link' and text()='Admin console']"));
		adminConsoleButton.click();
		
		driverChrome.close();
	}
	
	
	public void showSeleniumDriverFirefox() {
		
		System.out.println("Firefox driver has been launched successfully");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\bin\\geckodriver.exe");		
		WebDriver driverFi = new FirefoxDriver();
		driverFi.get("https://google.com");
		
		WebElement elem = driverFi.findElement(By.xpath("//a[text()='English']"));
		elem.click();
		
		WebElement elem1 = driverFi.findElement(By.xpath("//a[text()='Gmail']"));
		elem1.click();
		
		System.out.println("Firefox driver has been finished successfully");
	}
}
