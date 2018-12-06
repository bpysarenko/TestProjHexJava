package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends ParentPage {

    @FindBy (xpath =".//a[@class='list-group-item' and @href='https://bghex.com.ua/logout/']" )
    WebElement vyhodButton;

    @FindBy (xpath = ".//input[@class='form-control input-lg' and @type='text']")
    WebElement searchInputField;

    @FindBy (xpath = ".//button[@class='btn btn-default btn-lg' and @type='button']")
    WebElement searchButton;

    @FindBy (xpath = ".//div[@id='cart']/button")
    WebElement korzinaShowDropdownElement;

    @FindBy (xpath = ".//ul/li/div//p//a[@href = 'http://bghex.com.ua/index.php?route=checkout/buy']")
    WebElement goToKorzinaIndicatorOfGamesInKorzina;

    @FindBy (xpath = ".//li/table[@class='table table-striped']")
    List<WebElement> listOfGamesInKorzinaDropdown;


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

    public void checkAndEmptyKorzina(String gameName) {
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
        if (actionsWithOurElements.isElementDisplayed(goToKorzinaIndicatorOfGamesInKorzina)){
            int counter = 0;
            while (goToKorzinaIndicatorOfGamesInKorzina.isDisplayed()){
                for (WebElement record : listOfGamesInKorzinaDropdown){
                    WebElement cellWithGameNameInKorzinaDD = record.findElement(By.xpath("//td[@class='text-left']/a"));
                    WebElement discardGameFromKorzinaDDButton = record.findElement(By.xpath("//button[@class='btn btn-danger btn-xs']"));
//                    if (cellWithGameNameInKorzinaDD.getText().equals(gameName)){
                        actionsWithOurElements.clickOnElement(discardGameFromKorzinaDDButton);
//                    }
                }
                counter++;
                if(counter > 10){
                    Assert.fail("Something went wrong, Games still are in Korzina DD!");
                }


            }

        }

    }
}
