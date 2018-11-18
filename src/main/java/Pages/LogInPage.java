package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
