package com.solvd.seleniumpure.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.pages.*;

public class ItemPage {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemPage.class);

	private WebDriver driver;
	
    @FindBy(xpath = "//a[contains(@class,'product-aside__item-button') and contains(text(),'В корзину')]")
    private List<WebElement> addToShoppingCartListLink;
    
    @FindBy(xpath = "//a[contains(@class,'product-aside__item-button') and contains(text(),'В корзине')]")
    private WebElement addedToShoppingCartLink;
    	    
    @FindBy(xpath = "//div[@id='cart-desktop']//a[@href='https://cart.onliner.by']")
    private WebElement shoppingCartLink; 
    
    
    
    public ItemPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void addToShoppingCart(){
//    	if (!(addedToShoppingCartLink.isElementPresent())) {	    	
    	addToShoppingCartListLink.get(0).click();
//    	}
    }
    
    public ShoppingCartPage openShoppingCartPage() {
    	shoppingCartLink.click();
        return new ShoppingCartPage(driver);
    }
	    
	    
}
