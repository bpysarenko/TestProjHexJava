package addNewGameToKorzina;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewGameToKorzina extends ParentTest {

    String gameName = "Пандемия";

    @Test
    public void addGameToKorzina(){
        logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");
        myAccountPage.checkUrl();
        myAccountPage.checkAndEmptyKorzina(gameName);
        myAccountPage.searchForGame(gameName);
        myAccountPage.clickOnSearch();
        searchPage.clickOnAddToKorzinaButton(gameName);
//        searchPage.checkGameIsAddedToKorzina(gameName); - don't need it;

        checkExpectedResult("Game wasn't added to Korzina!", searchPage.isGameAddedToKorzinaDD(gameName));
    }
}
