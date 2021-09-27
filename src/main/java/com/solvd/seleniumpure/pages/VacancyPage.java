package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.SeleniumWebdriver;

public class VacancyPage {

	private final static Logger LOGGER = LoggerFactory.getLogger(VacancyPage.class);
	
	private WebDriver driver;
	
    private WebElement contactsLink = driver.findElement(By.xpath("//a[@href='https://people.onliner.by/contacts']"));
        
    private WebElement homeLink = driver.findElement(By.xpath("//img[@class='onliner_logo']"));
	
	public VacancyPage(WebDriver driver) {
		this.driver = driver;
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
