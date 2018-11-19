package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends ParentPage {
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isVyhodButtonPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@class='list-group-item' and @href='https://bghex.com.ua/logout/']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
