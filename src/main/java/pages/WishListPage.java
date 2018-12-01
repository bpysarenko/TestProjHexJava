package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends ParentPage {
    public WishListPage(WebDriver webDriver) {
        super(webDriver, "wishlist/");
    }

    public boolean isGameDispalyedInAddedToWhishlist(String gameName){
        WebElement neededWebElement = webDriver.findElement(By.xpath(".//a[contains(text(), '" + gameName+ "')]"));
        return actionsWithOurElements.isElementDisplayed(neededWebElement);

    }

    public void removeAddedGameFromWishlist(String gameName) { //TODO complete it!!!

    }
}
