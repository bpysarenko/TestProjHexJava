package addNewBookmark;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)


public class AddNewGameToBookmark extends ParentTest {
    String gameName;

    public AddNewGameToBookmark(String gameName) {
        this.gameName = gameName;
    }
    @Parameterized.Parameters (name = "Parameters are {0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Ghost Stories"},
                {"XCOM"},


        });
    }


    @Test
    public void addGameToBookmarks(){
        logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");
        myAccountPage.searchForGame(gameName);
        myAccountPage.clickOnSearch();
        searchPage.clickOnGameTile(gameName);
        selectedGamePage.addGameToBookmarks();

        Assert.assertEquals("Game wasn't addded to Bookmarks",true, wishListPage.isGameDispalyedInAddedToWhishlist(gameName));



    }
//TODO Complete deleting section(metod is created, but empty)
//    @After
//    public void removeGameFromWishlist(){
//        wishListPage.removeAddedGameFromWishlist(gameName);
//
//    }
}
