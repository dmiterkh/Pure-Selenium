package com.solvd.seleniumpure.tests;



	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.solvd.seleniumpure.pages.AuthorizedPage;
import com.solvd.seleniumpure.pages.HomePage;
import com.solvd.seleniumpure.pages.ItemPage;
import com.solvd.seleniumpure.pages.ShoppingCartPage;

	

/**
 * @author Dmitry Kharevich
 */

public class ShoppingCartTest  {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartTest.class);
	
	private WebDriver driver;
	
	private HomePage homePage;
	
	@BeforeSuite
    public void beforeSuiteShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-BeforeSuite-Child");
    }

	@BeforeTest
	public void beforeTestShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-BeforeTest-Child");
	}

	@BeforeClass
	public void beforeClassShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-BeforeClass-Child");
	}

	@BeforeMethod
	public void beforeMethodShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-BeforeMethod-Child");
		
        // Open Home page
        homePage = new HomePage(driver);
//        homePage.open();
        
        // Authorization Link is present
//        homePage.refreshPageIfAuthLinkIsNotPresent();

	}

    @Test()
 	//testcase019 Verify that the user Gets correct work of Shopping Cart in Catalog section
    public void testUserGetsCorrectWorkOfShoppingCartInCatalogShort() {
        
        // Enter to personal account
        AuthorizedPage authorizedPage = homePage.openAuthorizedPage("dmiterkh@mail.ru", "3909091");

        // Get Item (List of items)
        ItemPage itemPage = authorizedPage.openFirstItemPage("1000");
        itemPage.addToShoppingCart();
        
        // Go to Shopping cart
        ShoppingCartPage shoppingCartPage = itemPage.openShoppingCartPage();
        shoppingCartPage.showShoppingCartOperations();
        
        authorizedPage = shoppingCartPage.openAutorizedPage();
            
    }
    
    
    
	@AfterMethod
	public void afterMethodShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-AfterMethod-Child");
	}
	
	@AfterClass
	public void afterClassShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-AfterClass-Child");
	}

	@AfterTest
	public void afterTestShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-AfterTest-Child");
	}

	@AfterSuite
    public void afterSuiteShoppingCartTestChild() {
		LOGGER.info("@ShoppingCartTest-AfterSuite-Child");
    }



} 
