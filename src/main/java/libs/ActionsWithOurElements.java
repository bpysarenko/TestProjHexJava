package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    public ActionsWithOurElements (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoElement(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input in element " + element);

        } catch (Exception e){
            logger.error("Can't work with element" + e);
            Assert.fail("Can't work with element" + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked");
        } catch(Exception e){
            logger.info("Can't work with element" + e);
            Assert.fail("Can't work with element" + e);
        }

    }

    public boolean isElementDisplayed(WebElement element){
        try{
            return  element.isDisplayed();
        } catch (Exception e){
            return  false;
        }
    }


}
