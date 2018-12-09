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

    @FindBy (xpath = ".//div//table[@class = 'table table-bordered']")
    WebElement itogovayaStoimostTableIfGamesInKorzina;


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

    @Deprecated
    public void checkAndEmptyKorzina() {
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
        if (actionsWithOurElements.isElementDisplayed(goToKorzinaIndicatorOfGamesInKorzina)){
            int counter = 0;
            while (itogovayaStoimostTableIfGamesInKorzina.isDisplayed()) {
//                for (WebElement record : listOfGamesInKorzinaDropdown) {
//                    WebElement cellWithGameNameInKorzinaDD = record.findElement(By.xpath("//td[@class='text-left']/a"));
                WebElement discardGameFromKorzinaDDButton = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//tr[1]//button[@class='btn btn-danger btn-xs']"));
//                    WebElement discardGameFromKorzinaDDButton = record.findElement(By.xpath("//button[@class='btn btn-danger btn-xs']"));
//                    if (cellWithGameNameInKorzinaDD.getText().equals(gameName)){
                    actionsWithOurElements.clickOnElement(discardGameFromKorzinaDDButton);
//                    }
//                }
                counter++;
            }
                if(counter > 10){
                    Assert.fail("Something went wrong, Games still are in Korzina DD!");
                }


            }

        }

        public boolean isCertainGameDisplayedInKorzinaDD(String gameName){
        try {
            WebElement checkedGameNameInKorzinaTableDD = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//a[contains(text(),'" + gameName + "')]"));
            return (itogovayaStoimostTableIfGamesInKorzina.isDisplayed() && checkedGameNameInKorzinaTableDD.isDisplayed());
        } catch (Exception e){
            logger.info("There is no such game in The list!");
            return false;
        }
        }

        public void makingSureThatGameIsNotInKorzinaAlready(String gameName){
            actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);

//            if( itogovayaStoimostTableIfGamesInKorzina.isDisplayed()){
                try{
//    NOT NEEDED!                WebElement checkedGameNameInKorzinaTableDD = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//a[contains(text(),'" + gameName + "')]"));
                    WebElement removeButtonForSearchedGameInKorzinaDD = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//tr[.//a[contains(text(),'" + gameName + "')]]//button[@class= 'btn btn-danger btn-xs']"));
                    actionsWithOurElements.clickOnElement(removeButtonForSearchedGameInKorzinaDD);
                    logger.info("Certain game was removed from Korzina List!");
                } catch (Exception e){
                    logger.info("There is no such game in List!");
                    actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
                }
//            }
//            else {
//                actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
//            }

            if (isCertainGameDisplayedInKorzinaDD(gameName) == true){
                Assert.fail("Searched game still can be found in Korzina, even after attempt to remove it!");
                logger.error("Searched game still can be found in Korzina, even after attempt to remove it!");
            }

        }

    }

