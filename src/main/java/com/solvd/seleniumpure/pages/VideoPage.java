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
		
		WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(homeLinkBy));
		
		WebElement youtubeVideoLink = wait.until(ExpectedConditions.elementToBeClickable(youtubeVideoLinkBy));
		
	}
    
    public void showVideoPageOperations() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 3);
    	WebElement youtubeVideoLink = wait.until(ExpectedConditions.elementToBeClickable(youtubeVideoLinkBy));
    	youtubeVideoLink.click();

    	
    	driver.switchTo().frame(0);
    	WebElement element;
    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-play-button') and contains(@aria-label,'(k)')]"));
    	element.click();

    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-play-button') and contains(@aria-label,'(k)')]"));
    	element.click();
 
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-mute-button') and contains(@aria-label,'(m)')]"));
    	element.click();
    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-mute-button') and contains(@aria-label,'(m)')]"));
    	element.click();

    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-fullscreen-button') and contains(@title,'(f)')]"));
    	element.click();
    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-fullscreen-button') and contains(@title,'(f)')]"));
    	element.click();
    	
    	element = driver.findElement(By.xpath("//button[contains(@class,'ytp-settings-button')]"));
    	element.click();
    	
    	String videoPageWindow = driver.getWindowHandle();
    	element = driver.findElement(By.xpath("//a[contains(@class,'ytp-youtube-button')]"));
    	WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    	element.click();	
    	driver.switchTo().window(videoPageWindow);
 
    	
    }

    public WebElement getHomePageLink() {
    	return homeLink;
	}
    
    public HomePage returnToHomePage() {
    	while (!(getHomePageLink().isDisplayed())){
  		    driver.navigate().refresh(); 
  		};
  		
    	homeLink.click();
    	return new HomePage(driver);
	}
    
    public WebElement getYoutubeVideoLink() {
    	return youtubeVideoLink;
	}
    
//    public boolean checkYoutubeVideoLink() {
//    	return youtubeVideoLink;	
//    } 
    
    WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(homeLinkBy));
}