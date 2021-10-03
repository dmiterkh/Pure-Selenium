package com.solvd.seleniumpure.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.pages.*;


public class LaptopPage {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LaptopPage.class);

	private WebDriver driver;
    
    @FindBy(xpath = "//input[@type='checkbox' and @value='lenovo']//parent::span//parent::label")
    private List<WebElement> producerCheckboxListLink;
        
    //@FindBy(xpath = "//input[@type='text' and @placeholder='до']")
    @FindBy(xpath = "//input[contains(@class,'schema-filter-control__item') and @placeholder='до']")    
    private WebElement upperBoundPriceFieldLink;
   
    @FindBy(xpath = "//a[@data-bind='attr: {href: product.html_url}']")
    private List<WebElement> itemListLink;
   
    
    
    public LaptopPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
         
    
   
    public void clickOnProducerCheckboxLink() {
    	producerCheckboxListLink.get(0).click();
    }
    
    public void typeInUpperBoundPriceField(String upperBoundPriceArg) {
    	upperBoundPriceFieldLink.click();
    	upperBoundPriceFieldLink.sendKeys(upperBoundPriceArg);
    }
    
    public ItemPage openFirstItemPage() {
    	itemListLink.get(0).click();
        return new ItemPage(driver);
    }
    
    public ItemPage openFirstItemPage(String upperBoundPriceArg) {
    	producerCheckboxListLink.get(0).click();
    	upperBoundPriceFieldLink.click();
    	upperBoundPriceFieldLink.sendKeys(upperBoundPriceArg);
    	itemListLink.get(0).click();
        return new ItemPage(driver);
    }
}