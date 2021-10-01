package com.solvd.seleniumpure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
//import com.solvd.savich.gui.Resource;
//import com.solvd.savich.gui.Util;

import com.solvd.seleniumpure.pages.AuthorizedPage;

public class ShoppingCartPage {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartPage.class);
    
    private WebDriver driver;
    
	@FindBy(xpath = "//a[@href='https://www.onliner.by']")
    private WebElement autorizedHomePageLink;
	
	@FindBy(xpath = "//input[@type='text' and  @maxlength='2']")
	private WebElement numberOfItemWindowLink;
	
	@FindBy(xpath = "//div[@class='cart-form__offers-part cart-form__offers-part_action']//div//div//div//div//a[contains(@class,'cart-form__button_increment')]")
    private WebElement incrementButtonLink;
	
	@FindBy(xpath = "//div[@class='cart-form__offers-part cart-form__offers-part_action']//div//div//div//div//a[contains(@class,'cart-form__button_decrement')]")
    private WebElement decrementButtonLink;
		
	@FindBy(xpath = "//div[@class='cart-form__offers-part cart-form__offers-part_action']//div//div//div//a[contains(@class,'cart-form__button_remove')]")
    private WebElement removeButtonLink;	
	
	
	
    public ShoppingCartPage(WebDriver driver) {
    	this.driver = driver;
    }    
    
    
    
    public AuthorizedPage openAutorizedPage() {
    	autorizedHomePageLink.click();
        return new AuthorizedPage(driver);
    }
      
    public void typeInNumberOfItemWindowLink() {
    	numberOfItemWindowLink.click();
    	numberOfItemWindowLink.clear();
    	numberOfItemWindowLink.sendKeys("23");
    }
    
    public void clickOnIncrementButtonLink() {
    	numberOfItemWindowLink.click();
    	incrementButtonLink.click();
    }
    
    public void clickOnDecrementButtonLink() {
    	numberOfItemWindowLink.click();
    	decrementButtonLink.click();
    }
    
    public void clickOnRemoveButtonLink() {
    	numberOfItemWindowLink.click();
    	removeButtonLink.click();
    }
    
    public void showShoppingCartOperations() {
    	typeInNumberOfItemWindowLink();
    	clickOnIncrementButtonLink();
    	clickOnDecrementButtonLink();
    	clickOnRemoveButtonLink();
    }

}