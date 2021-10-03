package com.solvd.seleniumpure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.pages.*;
import com.solvd.seleniumpure.components.*;

public class AuthorizedPage {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizedPage.class);

	private WebDriver driver;

    @FindBy(xpath = "//a[@href='https://blog.onliner.by/vacancy']")
    private WebElement vacanciesLink;
    
    @FindBy(xpath = "//img[@class='onliner_logo']")
    private WebElement homeLink;    
    
    @FindBy(xpath = "//div[@id='cart-desktop']//a[@href='https://cart.onliner.by']")
    private WebElement shoppingCartLink; 	
    
    @FindBy(xpath = "//header[@class='g-top']")
    private TopHeaderBar topHeaderBarLink;
    
    @FindBy(xpath = "//a[contains(@href,'https://profile.onliner.by') and contains(@class,'b-top-profile__preview')]")
    private  WebElement profileLink;
    
    @FindBy(xpath = "//a[@class='b-top-profile__link b-top-profile__link_secondary']")
    private WebElement popupProfileExitLink;
    
    
    

	
    public AuthorizedPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    } 
    
    public TopHeaderBar getTopHeaderBar() {
        return topHeaderBarLink;
    }
    
    public ItemPage openFirstItemPage(String stringArg) {
    	return getTopHeaderBar().openCatalogPage().getLaptopPage().openFirstItemPage(stringArg);
    }
    
    public HomePage openHomePageOnliner() {
    	profileLink.click();
        popupProfileExitLink.click();
        homeLink.click();
        return new HomePage(driver);
    }

}
