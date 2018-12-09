package addNewGameToKorzina;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class AddNewGameToKorzina extends ParentTest {

    String gameName;

    public AddNewGameToKorzina(String gameName) {
        this.gameName = gameName;
    }


    @Parameterized.Parameters (name = "Parameters are {0}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"Пандемия"},
                {"Crossfire"},
        });
    }

    @Test
    public void addGameToKorzina() {
        logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");
        myAccountPage.checkUrl();
        myAccountPage.makingSureThatGameIsNotInKorzinaAlready(gameName);
        myAccountPage.searchForGame(gameName);
        myAccountPage.clickOnSearch();
        searchPage.clickOnAddToKorzinaButton(gameName);
////        searchPage.checkGameIsAddedToKorzina(gameName); - don't need it;
//
//        searchPage.clickOnGoToKorzinaPageButtonOnMainPanel();

        checkExpectedResult("Game wasn't added to Korzina!", searchPage.isGameAddedToKorzinaDD(gameName));
        searchPage.clickOnKorzinaCartForOpenAndClose();
    }

    @After
    public void cleaningAfterTest(){
        searchPage.makingSureThatGameIsNotInKorzinaAlready(gameName);
    }
}
