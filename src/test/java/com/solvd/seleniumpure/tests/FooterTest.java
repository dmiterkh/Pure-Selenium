package com.solvd.seleniumpure.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }
    
    @Test()
    
    //testcase018 Verify that the user Is Being Redirected to the relevant page after clicking on any link in footer 
    public void testUserRedirectedToRelevantPageClickingOnLinkInFooter() {
        
    	System.setProperty("webdriver.chrome.driver", "/Applications/tools/selenium/chromedriver93mac");  
		driver = new ChromeDriver();
    	driver.get("https://www.onliner.by/");
    	
		System.out.println("0");
		System.out.println("1");
        HomePage homePage = new HomePage(driver);
        
        System.out.println("1.5");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement homeLinkWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Для бизнеса')]")));

        homePage.clickOnOnlinerLogo();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
		System.out.println("2");
        VacancyPage vacancyPage = homePage.openVacancyPage();
        
		System.out.println("3");
        homePage = vacancyPage.openHomePage();
               
		System.out.println("4");
        ContactsPage contactsPage = homePage.openContactsPage();
        
		System.out.println("5");
        homePage = contactsPage.openHomePage();
        
		System.out.println("6");
        vacancyPage = homePage.openVacancyPage();
        
		System.out.println("7");
        contactsPage = vacancyPage.openContactsPage();
        
		System.out.println("8");
        vacancyPage = contactsPage.openVacancyPage();

        System.out.println("9");
        
    }    

}
