package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

public class LogInPage extends ParentPage{
    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = ".//input[@class='btn btn-primary' and @value = 'Войти']")
    WebElement voitiButton;

    @FindBy (id = "input-email")
    WebElement emailField;

    @FindBy (id = "input-password")
    WebElement passwordField;

    public void openLoginPage(){
        try{
            webDriver.get("https://bghex.com.ua/login/");
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Can't open Login Page");
            Assert.fail("Can not open Login Page!");


        }
    }

    public void enterEmail (String email){
        actionsWithOurElements.enterTextIntoElement(emailField, email);
    }

    public void enterPassword(String password){
        actionsWithOurElements.enterTextIntoElement(passwordField, password);
    }
    public void clickOnVoitiButton (){
        actionsWithOurElements.clickOnElement(voitiButton);
    }

    public void loginInWithCredentials(String userProvideEmail, String userProvidePassword){
        openLoginPage();
        enterEmail(userProvideEmail);
        enterPassword(userProvidePassword);
        clickOnVoitiButton();
    }


}
