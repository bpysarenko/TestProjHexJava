package testsuits;

import addNewBookmark.AddNewGameToBookmark;
import addNewGameToKorzina.AddNewGameToKorzina;
import changeLanguageCheckTest.ChangeLanguageCheckTest;
import login.InValidLogInParametrized;
import login.Login_to_site;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InValidLogInParametrized.class,
        Login_to_site.class,
        AddNewGameToBookmark.class,
        AddNewGameToKorzina.class,
        ChangeLanguageCheckTest.class


})

public class SmokeTestSuit {
}
