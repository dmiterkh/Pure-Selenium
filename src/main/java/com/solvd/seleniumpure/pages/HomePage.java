package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.SeleniumWebdriver;

public class HomePage {

	private final static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
	
	private WebDriver driver;
	
    private WebElement homeLink = driver.findElement(By.xpath("//img[@class='onliner_logo']"));

    private WebElement contactsLink = driver.findElement(By.xpath("//a[@href='https://people.onliner.by/contacts']"));
	
    private WebElement vacanciesLink = driver.findElement(By.xpath("//a[@href='https://blog.onliner.by/vacancy']"));
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public VacancyPage openVacancyPage() {
		vacanciesLink.click();
		return new VacancyPage(driver);
	}
	
	public ContactsPage openContactsPage() {
		contactsLink.click();
		return new ContactsPage(driver);
	}
	
	public void clickOnOnlinerLogo() {
		homeLink.click();
	}
	
}
