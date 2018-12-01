package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    String baseUrl = "https://bghex.com.ua";
    String expectedUrl;

    public ParentPage (WebDriver webDriver, String relativeUrl){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedUrl = baseUrl + relativeUrl;

    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkUrl(){
        try{
            Assert.assertEquals("URL is not that expected", expectedUrl, getCurrentUrl());
        } catch (Exception e){
            logger.error("Can't work with URL");
            Assert.fail("Can't work with URL");
        }
    }

}
