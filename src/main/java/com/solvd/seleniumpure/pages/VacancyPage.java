package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.SeleniumWebdriver;

public class VacancyPage {

	private final static Logger LOGGER = LoggerFactory.getLogger(VacancyPage.class);
	
	private WebDriver driver;
	
    private WebElement contactsLink;
        
    private WebElement homeLink;
	
	public VacancyPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements() {
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='onliner_logo']/..")));

	    contactsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://people.onliner.by/contacts']")));
				
	}

	public ContactsPage openContactsPage() {
		contactsLink.click();
		return new ContactsPage(driver);
	}
	
	public HomePage openHomePage() {
		homeLink.click();
		return new HomePage(driver);
	}
	
}
