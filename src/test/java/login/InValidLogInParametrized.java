package login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class InValidLogInParametrized extends ParentTest {

    String login;
    String password;

    public InValidLogInParametrized(String login, String password ) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"1234@com.com", "WSXcde123$"},
                {"", " "},
                {"4spysar@gmail.com", "wxsCDE123$"}

        });
    }

    @Test
    public void inValidLogin(){
        logInPage.loginInWithCredentials(login, password);

        Assert.assertTrue("You have logged in with invalid credentials!", logInPage.isAccessAlertPresent());
    }

}
