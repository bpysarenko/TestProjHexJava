package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends  ParentPage{

    public SearchPage(WebDriver webDriver) {
        super(webDriver, "/search/");
    }

    @FindBy (xpath = ".//div[@id='cart']/button")
    WebElement korzinaShowDropdownElement;

    @FindBy (xpath = ".//ul/li/div//p//a[@href = 'http://bghex.com.ua/index.php?route=checkout/buy']")
    WebElement goToKorzinaIndicatorOfGamesInKorzina;

    @FindBy (xpath = ".//div[@id='top-links']//a[@href = 'http://bghex.com.ua/index.php?route=checkout/buy']")
    WebElement openKorzinaPageFromMainPanelButton;





    public void clickOnGameTile(String gameName) {
        try {
            WebElement neededGameName = webDriver.findElement(By.xpath(".//a[contains(text(),'" + gameName + "')]"));
            actionsWithOurElements.clickOnElement(neededGameName);
        } catch (Exception e) {
            logger.error("Such game can't be found, check name!");
            Assert.fail("Such game can't be found, check name!");
        }
    }

    public void clickOnAddToKorzinaButton(String gameName) {
        WebElement gameTitleOnSearchPage = webDriver.findElement(By.xpath(".//div[@class ='caption']//a[contains(text(), '" + gameName + "')]"));
        WebElement addGameToKorzinaOnTileButton = webDriver.findElement(By.xpath(".//div[@class='product-thumb'][.//div[@class ='caption']//a[contains(text(),'" + gameName + "')]]/div/button[1]/span"));
        try {
            actionsWithOurElements.clickOnElement(addGameToKorzinaOnTileButton);
//            Thread.sleep(2000);
        } catch (Exception e){
            logger.error("Tile with searched game wasn't found correctly");
            Assert.fail("Tile with searched game wasn't found correctly");
        }
    }
    @Deprecated
    //Don't know, is it neccessary;
    public void checkGameIsAddedToKorzina(String gameName) {
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
        WebElement addedGameNameTitleInTable = webDriver.findElement(By.xpath(".//table[@class='table table-striped']//a[contains(text(), '" + gameName +"')]"));
        if (goToKorzinaIndicatorOfGamesInKorzina.isDisplayed()){



        } else{
            logger.error("Korzina doesn't contain any goods!");
            Assert.fail("Korzina doesn't contain any goods!");

        }

    }

    public boolean isGameAddedToKorzinaDD(String gameName){
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
        try {
//            Thread.sleep(2000);

            WebElement addedGameNameTitleInTable = webDriver.findElement(By.xpath(".//table[@class='table table-striped']//a[contains(text(), '" + gameName + "')]"));

            return actionsWithOurElements.isElementDisplayed(addedGameNameTitleInTable);

        } catch (Exception e){
            logger.info("Certain Game can't be found in Korzina!");
            return  false;
        }

    }

    public void clickOnGoToKorzinaPageButtonOnMainPanel(){
        actionsWithOurElements.clickOnElement(openKorzinaPageFromMainPanelButton);
    }

    public void makingSureThatGameIsNotInKorzinaAlready(String gameName){
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);

        try{
//    NOT NEEDED!                WebElement checkedGameNameInKorzinaTableDD = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//a[contains(text(),'" + gameName + "')]"));
            WebElement removeButtonForSearchedGameInKorzinaDD = webDriver.findElement(By.xpath(".//li/table[@class='table table-striped']//tr[.//a[contains(text(),'" + gameName + "')]]//button[@class= 'btn btn-danger btn-xs']"));
            actionsWithOurElements.clickOnElement(removeButtonForSearchedGameInKorzinaDD);
            logger.info("Certain game was removed from Korzina List!");
        } catch (Exception e){
            logger.info("There is no such game in List!");
            actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
        }

    }

    public void clickOnKorzinaCartForOpenAndClose(){
        actionsWithOurElements.clickOnElement(korzinaShowDropdownElement);
    }
}
