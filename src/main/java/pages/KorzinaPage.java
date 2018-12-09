package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class KorzinaPage extends ParentPage {
    public KorzinaPage(WebDriver webDriver) {
        super(webDriver, "/index.php?route=checkout/buy");
    }

    @FindBy (xpath = ".//div[@id='cart']/button")
    WebElement korzinaShowDropdownElement;

    @FindBy (xpath = ".//div//table[@class = 'table table-bordered']")
    WebElement itogovayaStoimostTableIfGamesInKorzina;

    public boolean isGameDisplayedOnKorzinaPage(String gameName){
        try{
            WebElement searchedGameOnKorzinaPage = webDriver.findElement(By.xpath(".//div[@class = 'table-responsive']//a[contains(text(), '" + gameName +"')]"));
            return  actionsWithOurElements.isElementDisplayed(searchedGameOnKorzinaPage);

        }catch (Exception e){
            logger.info("Searched game can't be found on page!");
            return false;
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
