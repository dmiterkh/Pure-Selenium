package com.solvd.seleniumpure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.solvd.seleniumpure.SeleniumWebdriver;

public class ContactsPage {

	private final static Logger LOGGER = LoggerFactory.getLogger(ContactsPage.class);
	
	private WebDriver driver;
	
    private WebElement vacanciesLink;
        
    private WebElement homeLink;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements() {
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='onliner_logo']/..")));
		
	    vacanciesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://blog.onliner.by/vacancy']")));
		
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
