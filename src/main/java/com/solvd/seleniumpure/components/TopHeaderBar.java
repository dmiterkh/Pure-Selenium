package com.solvd.seleniumpure.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.pages.*;

public class TopHeaderBar {

	private WebDriver driver;
	
	@FindBy(xpath ="//div[contains(@class,'auth-bar__item--text')]")
	private WebElement authLink;
	
	@FindBy(xpath = "//input[@class='fast-search__input']")
	private WebElement fastSearchFieldLink;

    @FindBy(xpath = "//div[text()='на барахолке']")
    private WebElement usedGoodsButtonLink;
    
    @FindBy(xpath = "//li[@class='search__result']")
    private List<WebElement> foundItemListLink;
    
    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/']")
    private WebElement catalogLink;

    @FindBy(xpath = "//li[contains(@class,'b-main-navigation__item')]//a[contains(@href,'https://ab.onliner.by') and contains(@class, 'b-main-navigation__link')]")
    private WebElement automobileLink;
        
    @FindBy(xpath = "//a[@href='https://r.onliner.by/pk']")
    private WebElement realEstateLink;
    
    @FindBy(xpath = "//div[@id='cart-desktop']//a[@href='https://cart.onliner.by']")
    private WebElement shoppingCartLink; 
        
    @FindBy(xpath = "//img[@class='onliner_logo']")
    private WebElement homeLink;
    

    
    
    public TopHeaderBar(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    
    public WebElement getAuthLink() {
        return authLink;
    }

    public LoginPage clickOnAuthLink() {
        authLink.click();
        return new LoginPage(driver);
    }
    
    public void typeInFastSearchField(String queryArg) {
        fastSearchFieldLink.click();
        fastSearchFieldLink.sendKeys(queryArg);
    }
    
    public WebElement getFastSearchFieldLink() {
        return fastSearchFieldLink;
    }
    
    public void clickOnUsedGoodsButton() {
    	usedGoodsButtonLink.click();
    }
    
    public void getFirstFoundUsedItem(String queryArg) {
        fastSearchFieldLink.click();
        fastSearchFieldLink.sendKeys(queryArg);

        WebElement element;
    	element = driver.switchTo().frame(0).findElement(By.xpath("//html//body//div//div//div//div//div//div[text()='на барахолке']"));
    	element.click();
    }
    
    public WebElement getCatalogPageLink() {
        return catalogLink;
    }
    
    public CatalogPage openCatalogPage() {
        catalogLink.click();
        return new CatalogPage(driver);
    }

    public ShoppingCartPage clickOnShoppingCartLink() {
    	shoppingCartLink.click();
        return new ShoppingCartPage(driver);
    }

    
}