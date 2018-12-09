package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends ParentPage {

    @FindBy (xpath = ".//button[@class ='btn btn-link dropdown-toggle']")
    private WebElement languageSelectorDD;

    @FindBy (xpath = ".//form[@id='language']//a[@href='ua']")
    private WebElement ukranianLanguageButtonInDD;

    @FindBy(xpath = ".//form[@id='language']//button//span[text()='Мова']")
    private WebElement ukranianLanguageIndicator;

    @FindBy (xpath = ".//form[@id='language']//a[@href='ru']")
    private WebElement russianLanguageButtonInDD;

    @FindBy (xpath = ".//form[@id='language']//button//span[text()='Язык']")
    private WebElement russianLanguageIndicator;

    public BlogPage(WebDriver webDriver) {
        super(webDriver, "/klub-geks.html");
    }


    public void changeLanguageToUkr() {
        actionsWithOurElements.clickOnElement(languageSelectorDD);
        actionsWithOurElements.clickOnElement(ukranianLanguageButtonInDD);
    }

    public boolean checkIfUkranianIsApplied() {
        try{
            logger.info("Language was changed to Ukranian!!!");
            return actionsWithOurElements.isElementDisplayed(ukranianLanguageIndicator);


    }
    catch (Exception e){
            logger.error("Language is not Ukranian!");
        Assert.fail("Language is not Ukranian!");
        return false;

       }
    }

    public void changeLanguageToRus() {
        actionsWithOurElements.clickOnElement(languageSelectorDD);
        actionsWithOurElements.clickOnElement(russianLanguageButtonInDD);
    }

    public boolean checkIfRussianIsApplied() {
        try{
            logger.info("Language was changed to Russian!!!");
            return actionsWithOurElements.isElementDisplayed(russianLanguageIndicator);
        }catch (Exception e){

        }
        return true;
    }
}
