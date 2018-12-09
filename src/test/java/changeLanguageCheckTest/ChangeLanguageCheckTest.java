package changeLanguageCheckTest;

import org.junit.Test;
import pages.BlogPage;
import parentTest.ParentTest;

public class ChangeLanguageCheckTest extends ParentTest {

    @Test
    public void chnangingLanguagesOnBlogPage(){
        logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");
        myAccountPage.goToBlogPage();
        blogPage.getCurrentUrl();
        blogPage.changeLanguageToUkr();
        blogPage.checkIfUkranianIsApplied();
        blogPage.changeLanguageToRus();

        checkExpectedResult("It is not Russian Language", blogPage.checkIfRussianIsApplied());

    }
}
