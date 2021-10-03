package com.solvd.seleniumpure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.pages.*;


public class LoginPage {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
	

	private WebDriver driver;
    
    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private WebElement loginFieldLink;
        
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordFieldLink;
    //input[@type='password']
    
    @FindBy(xpath = "//button[contains(@class,'auth-button')]")
    private WebElement authButtonLink;
    
    // Additional link
    @FindBy(xpath = "//div[contains(@class,'auth-input__helper')]")
    private WebElement passwordViewLink;
    
    
        
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    
    public AuthorizedPage clickOnAuthButton() {
    	authButtonLink.click();
        return new AuthorizedPage(driver);
    }
    
    public WebElement getLoginFieldLink() {
    	return loginFieldLink;
    }
    
    public WebElement getPasswordFieldLink() {
    	return passwordFieldLink;
    }
    
//    public boolean isLoginFieldClickable() {
//    	return loginFieldLink.isClickable();
//    }
//    
//    public boolean isPasswordFieldClickable() {
//    	return passwordFieldLink.isClickable();
//    }
    
    public void typeInLoginField(String loginArg) {
    	loginFieldLink.click();
    	loginFieldLink.sendKeys(loginArg);
    }
    
    public void typeInPasswordField(String passwordArg) {
    	passwordFieldLink.click();
    	passwordFieldLink.sendKeys(passwordArg);
    }
    
    // Additional method
    public void showPasswordInPasswordField() {
        passwordViewLink.click();
        passwordViewLink.click();
   }
    
    public AuthorizedPage getAuthorizedPage(String loginArg, String passwordArg) {
    	typeInLoginField(loginArg);
    	typeInPasswordField(passwordArg);
    	showPasswordInPasswordField();
        authButtonLink.click();
        return new AuthorizedPage(driver);
    }
    
    public LoginPage getNotAuthorizedLoginPage(String loginArg, String passwordArg) {
    	typeInLoginField(loginArg);
    	typeInPasswordField(passwordArg);
    	showPasswordInPasswordField();
        authButtonLink.click();
        return new LoginPage(driver);
    }
    
    
}