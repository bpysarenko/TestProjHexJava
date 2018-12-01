package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends  ParentPage{
    public SearchPage(WebDriver webDriver) {
        super(webDriver, "/search/");
    }




    public void clickOnGameTile(String gameName) {
        try {
            WebElement neededGameName = webDriver.findElement(By.xpath(".//a[contains(text(),'" + gameName + "')]"));
            actionsWithOurElements.clickOnElement(neededGameName);
        } catch (Exception e) {
            logger.error("Such game can't be found, check name!");
            Assert.fail("Such game can't be found, check name!");
        }
    }
}
