package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends  ParentPage{
    public SearchPage(WebDriver webDriver) {
        super(webDriver, "/search/");
    }




    public void clickOnGameTile(String gameName) {
        WebElement neededGameName = webDriver.findElement(By.xpath(".//a[contains(text(),'" + gameName + "')]"));
        actionsWithOurElements.clickOnElement(neededGameName);
    }
}
