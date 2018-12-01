package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedGamePage extends ParentPage {
    public SelectedGamePage(WebDriver webDriver) {
        super(webDriver, "desktops/");
    }
    @FindBy (xpath = ".//button[@class='btn btn-default' and @data-original-title='В закладки']")
    WebElement buttonAddToBppkmark;



    public void addGameToBookmarks() {
        actionsWithOurElements.clickOnElement(buttonAddToBppkmark);
    }
}
