package login;

import org.junit.Test;
import parentTest.ParentTest;

public class Login_to_site extends ParentTest {


    @Test
    public void validLogin(){
    logInPage.loginInWithCredentials("4spysar@gmail.com","WSXcde123$");

    }

}
