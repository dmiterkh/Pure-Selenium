package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VideoPage {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoPage.class);
    
	private WebDriver driver;
	
	private By youtubeVideoLinkBy = By.xpath("//iframe[@title='YouTube video player']");
	
	private By homeLinkBy = By.xpath("//img[@class='onliner_logo']");
	
	private WebElement homeLink;
			
	private WebElement youtubeVideoLink;
    
    public VideoPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
    
	private void initElements() {
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		homeLink = wait.until(ExpectedConditions.elementToBeClickable(homeLinkBy));
		
		youtubeVideoLink = wait.until(ExpectedConditions.elementToBeClickable(youtubeVideoLinkBy));
		
	}
    
    public void showVideoPageOperations() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	youtubeVideoLink = wait.until(ExpectedConditions.elementToBeClickable(youtubeVideoLinkBy));
//    	youtubeVideoLink = driver.findElement(youtubeVideoLinkBy);	
    	youtubeVideoLink.click();
    	
    	String videoPageWindow = driver.getWindowHandle();
    	driver.switchTo().frame(youtubeVideoLink);
    	String youtubeFrameWindow = driver.getWindowHandle();
    	LOGGER.info("0");
    	
    	WebElement element; 
    	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ytp-play-button') and contains(@aria-label,'(k)')]")));	
    	element.click();    	
    	LOGGER.info("1");

    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-play-button') and contains(@aria-label,'(k)')]"));
    	element.click();
     	LOGGER.info("2");
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-mute-button') and contains(@aria-label,'(m)')]"));
    	element.click();
    	LOGGER.info("3");
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-mute-button') and contains(@aria-label,'(m)')]"));
    	element.click();
    	LOGGER.info("4");    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-fullscreen-button') and contains(@title,'(f)')]"));
    	element.click();
    	LOGGER.info("5");
//    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-fullscreen-button') and contains(@title,'(f)')]"));
//    	element.click();
//    	LOGGER.info("6");
//    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-settings-button')]"));
//    	element.click();
//    	LOGGER.info("7");
    	
//    	element = driver.findElement(By.xpath("//a[contains(@class,'ytp-youtube-button')]"));
//    	wait = new WebDriverWait(driver, 3);
//      wait.until(ExpectedConditions.elementToBeClickable(element));
//    	element.click();
    	LOGGER.info("8");
    	LOGGER.info("9");
    	driver.switchTo().window(videoPageWindow);
 
    	
    }

    public WebElement getHomePageLink() {
    	return homeLink;
	}
    
    public HomePage returnToHomePage() {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	homeLink = wait.until(ExpectedConditions.elementToBeClickable(homeLinkBy));
    	homeLink.click();
    	return new HomePage(driver);
	}
    
    public WebElement getYoutubeVideoLink() {
    	return youtubeVideoLink;
	}
    
//    public boolean checkYoutubeVideoLink() {
//    	return youtubeVideoLink;	
//    } 
    
}