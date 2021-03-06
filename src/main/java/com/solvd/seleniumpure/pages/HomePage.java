package com.solvd.seleniumpure.pages;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.seleniumpure.components.*;

public class HomePage {

	private final static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
	
	private WebDriver driver;
	
    private WebElement homeLink;

    private WebElement contactsLink;
	
    private WebElement vacanciesLink;
        
    private List<WebElement> videoPageLinkList;

    private WebElement videoPageLink;
    
    private WebElement topHeaderBarLink;
    
    
	public HomePage(WebDriver driver) {
		this.driver = driver;
		initElements();
		initVideoElements();
	}
	
	public HomePage(WebDriver driver, String stringArg) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='onliner_logo']/..")));

	    contactsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://people.onliner.by/contacts']")));
		
	    vacanciesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://blog.onliner.by/vacancy']")));
	    
	    topHeaderBarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@class='g-top']")));
		
	}

	private void initVideoElements() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    videoPageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='b-icon-3']//parent::span[@class='complementary-item video']//parent::span[@class='complementary-group']//parent::div//parent::figure//a")));		
	    videoPageLinkList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//i[@class='b-icon-3']//parent::span[@class='complementary-item video']//parent::span[@class='complementary-group']//parent::div//parent::figure//a")));		

	}
	
	public VacancyPage openVacancyPage() {
		vacanciesLink.click();
		return new VacancyPage(driver);
	}
	
	public ContactsPage openContactsPage() {
		contactsLink.click();
		return new ContactsPage(driver);
	}
	
	public void clickOnOnlinerLogo() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='onliner_logo']/..")));

		homeLink.click();
	}
	
	public boolean isOnlinerLogoClicked() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        wait.until(ExpectedConditions.elementToBeClickable(homeLink));
	        homeLink.click();
	        return true;
	    } catch(Exception e){
	        return false;
	    }
	}
	
	public boolean isVacancyLinkClicked() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        wait.until(ExpectedConditions.elementToBeClickable(vacanciesLink));
	        vacanciesLink.click();
	        return true;
	    } catch(Exception e){
	        return false;
	    }
	}
	
	public boolean isContactsLinkClicked() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
	        contactsLink.click();
	        return true;
	    } catch(Exception e){
	        return false;
	    }
	}
	
	   public WebElement getVideoPageLink() {
	        return videoPageLink;
	    }
	    
	    public VideoPage openVideoPage() {
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        wait.until(ExpectedConditions.elementToBeClickable(videoPageLink));
	        videoPageLink.click();
	        return new VideoPage(driver);
	    }
	    
//	    public List<ExtendedWebElement> getVideoPageListLink() {
//	        return videoPageListLink;
//	    }
//	    
//	    public VideoPage openVideoPage(ExtendedWebElement videoPageLinkArg) {
//	        videoPageLinkArg.click();
//	        return new VideoPage(driver);
//	    }
//	    
//	    public VideoPage openVideoPageUsualFor() {
//	    	if (videoPageLink.isDisplayed()) {
//	    		int k=0;
//		    	if (getVideoPageLink() != null) {
//					int j = 1;
//					for (int i=0; i < j; i++) {
//				  		while(k < 1) {
//
//				  			if(openVideoPage(getVideoPageLink())) {
//				  				k++;
//				  			} 
//				  		}
//					}
//			    	return new VideoPage(driver);
//		    	}
//	    	} else {
//	    		LOGGER.info("Required Element is not found on the Home Page");
//	    	}	
//	    	return new VideoPage(driver);	    	
//	    }
	   
	    
	    public TopHeaderBar getTopHeaderBar() {
	        return topHeaderBarLink;
	    }
	    
	    public LoginPage openLoginPage() {
	        getTopHeaderBar().getAuthLink().click();
	        return new LoginPage(driver);
	    }
	    
	    public CatalogPage openCatalogPage() {
	    	getTopHeaderBar().getCatalogPageLink().click();
	        return new CatalogPage(driver);
	    }
	    
	    public AuthorizedPage openAuthorizedPage(String loginArg, String passwordArg) {
	    	getTopHeaderBar().getAuthLink().click();
	        return new AuthorizedPage(driver);
	    }
	    
	    public LoginPage openNotAuthorizedLoginPage(String loginArg, String passwordArg) {
	    	return getTopHeaderBar().clickOnAuthLink().getNotAuthorizedLoginPage(loginArg, passwordArg);
	    }
	    
	    public AuthorizedPage openAuthorizedLoginPage(String loginArg, String passwordArg) {
	    	return getTopHeaderBar().clickOnAuthLink().getAuthorizedPage(loginArg, passwordArg);
	    }

	}
}
