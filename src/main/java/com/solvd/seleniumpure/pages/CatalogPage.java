package com.solvd.seleniumpure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.solvd.seleniumpure.pages.*;

public class CatalogPage {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);	

	private WebDriver driver;
    
    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'Компьютеры и')]//parent::span//parent::li")
    private WebElement computerTechnicsLink;
        
    @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Ноутбуки, компьютеры, мониторы')]//parent::div")
    private WebElement computersLink;
      
    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/notebook']")
    private WebElement laptopLink;
    
    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]//parent::span//parent::li")
    private WebElement categoryFormatLink;
        
    @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'%s')]//parent::div")
    private WebElement subCategoryFormatLink;
      
    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/microvawe']")
    private WebElement microvaweLink;

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/saw_blades']")
    private WebElement sawbladesLink;
    
    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/linendryer']")
    private WebElement linendryerLink;
    
    

    public CatalogPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void clickOnComputerTechnicsLink() {
    	computerTechnicsLink.click();
    }
           
    public void clickOnComputersLink() {
    	computersLink.click();
    }
    
    public LaptopPage openLaptopPage() {
    	laptopLink.click();
        return new LaptopPage(driver);
    } 

    public LaptopPage getLaptopPage() {
    	computerTechnicsLink.click();
    	computersLink.click();
    	laptopLink.click();
        return new LaptopPage(driver);
    } 


}
