package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.SeleniumWebdriver;

public class ContactsPage {

	private final static Logger LOGGER = LoggerFactory.getLogger(ContactsPage.class);
	
	private WebDriver driver;
	
    private WebElement vacanciesLink = driver.findElement(By.xpath("//a[@href='https://blog.onliner.by/vacancy']"));
        
    private WebElement homeLink = driver.findElement(By.xpath("//img[@class='onliner_logo']"));
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public VacancyPage openVacancyPage() {
		vacanciesLink.click();
		return new VacancyPage(driver);
	}
	
	public HomePage openHomePage() {
		homeLink.click();
		return new HomePage(driver);
	}
	
}
