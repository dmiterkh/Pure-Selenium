package com.solvd.seleniumpure.tests;

import org.testng.Assert;
import org.testng.asserts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.Test;

import com.solvd.seleniumpure.pages.HomePage;
import com.solvd.seleniumpure.pages.ContactsPage;
import com.solvd.seleniumpure.pages.VacancyPage;

public class FooterTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FooterTest.class);
	
	WebDriver driver;

	
    @Test()
    public void testA() {
    	System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver93mac");  
		driver = new ChromeDriver();
    	driver.get("https://www.onliner.by/");
    	driver.close();
    }
    
    @Test()
    
    //testcase018 Verify that the user Is Being Redirected to the relevant page after clicking on any link in footer 
    public void testUserRedirectedToRelevantPageClickingOnLinkInFooter() {
        
    	System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver93mac");  
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.get("https://www.onliner.by/");
    	
        HomePage homePage = new HomePage(driver);
        
        homePage.clickOnOnlinerLogo();
        homePage = new HomePage(driver);        
        Assert.assertTrue(homePage.isOnlinerLogoClicked(), "Home page is not opened");
        homePage = new HomePage(driver);

        VacancyPage vacancyPage = homePage.openVacancyPage();
        homePage = new HomePage(driver, "string");
        Assert.assertTrue(homePage.isVacancyLinkClicked(), "Vacancy page is not opened");
        vacancyPage = new VacancyPage(driver);
        
        homePage = vacancyPage.openHomePage();

        ContactsPage contactsPage = homePage.openContactsPage();
        homePage = new HomePage(driver, "string");
        Assert.assertTrue(homePage.isContactsLinkClicked(), "Contacts page is not opened");
        contactsPage = new ContactsPage(driver);

        homePage = contactsPage.openHomePage();
        
        vacancyPage = homePage.openVacancyPage();
        
        contactsPage = vacancyPage.openContactsPage();

        vacancyPage = contactsPage.openVacancyPage();

    	driver.close();
        
    }    

}
