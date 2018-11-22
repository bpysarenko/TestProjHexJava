package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class Login_to_site extends ParentTest {


    @Test
    public void validLogin(){
    logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");

        Assert.assertTrue("There is no Vyhod button, you are not logged in", myAccountPage.isVyhodButtonPresent());
        myAccountPage.checkUrl();



    }

}
