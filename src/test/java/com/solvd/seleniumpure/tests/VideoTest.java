package com.solvd.seleniumpure.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;


import org.testng.annotations.Test;

import com.solvd.seleniumpure.pages.HomePage;
import com.solvd.seleniumpure.pages.VideoPage;



/**
 * @author Dmitry Kharevich
 */

public class VideoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoTest.class); 
	
	WebDriver driver;
	
    @Test()
    //testcase017 Verify that the user Gets correct work of youtube video in any article with youtube video
    public void testUserGetsCorrectWorkOfYoutubeVideo() {
    	
    	
    	System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver93mac");  
		driver = new ChromeDriver();
    	driver.get("https://www.onliner.by/");
    	
        HomePage homePage = new HomePage(driver);
        
        homePage.clickOnOnlinerLogo();
        homePage = new HomePage(driver);
        // Open Video page 
        
    
		VideoPage videoPage = homePage.openVideoPage();
		videoPage.showVideoPageOperations();
		videoPage.returnToHomePage();

        
    }

}