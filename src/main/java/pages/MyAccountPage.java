package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage {

    @FindBy (xpath =".//a[@class='list-group-item' and @href='https://bghex.com.ua/logout/']" )
    WebElement vyhodButton;

    @FindBy (xpath = ".//input[@class='form-control input-lg' and @type='text']")
    WebElement searchInputField;

    @FindBy (xpath = ".//button[@class='btn btn-default btn-lg' and @type='button']")
    WebElement searchButton;


    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, "/my-account/");
    }

    public boolean isVyhodButtonPresent() {
//        try {
//            return webDriver.findElement(By.xpath(".//a[@class='list-group-item' and @href='https://bghex.com.ua/logout/']"))
//                    .isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
        return actionsWithOurElements.isElementDisplayed(vyhodButton);
    }

    public void searchForGame(String gameName) {
        actionsWithOurElements.enterTextIntoElement(searchInputField,gameName);
    }

    public void clickOnSearch() {
        actionsWithOurElements.clickOnElement(searchButton);
    }
}
