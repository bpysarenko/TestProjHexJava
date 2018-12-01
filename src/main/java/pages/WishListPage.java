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

    private WebElement getCertainRowWithProvidedGameName(String gameName){
        return webDriver.findElement(By.xpath(".//tr[.//td[2]//a[contains(text(),'" + gameName + "')]]//td[6]//a[@class='btn btn-danger']"));
    }

    public void removeAddedGameFromWishlist(String gameName) {
        actionsWithOurElements.clickOnElement(getCertainRowWithProvidedGameName(gameName));


//        .//tr[.//td[2]//a[contains(text()='Ghost Stories')]]//td[6]//a[@class='btn btn-danger'] - Locator for removal
    }
}
