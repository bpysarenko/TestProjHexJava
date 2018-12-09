package parentTest;

import org.junit.Assert;
import pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LogInPage logInPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected SelectedGamePage selectedGamePage;
    protected WishListPage wishListPage;
    protected KorzinaPage korzinaPage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        searchPage = new SearchPage(webDriver);
        selectedGamePage = new SelectedGamePage(webDriver);
        wishListPage = new WishListPage(webDriver);
        korzinaPage = new KorzinaPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void checkExpectedResult(String messageIfNotGood, boolean actualResult, boolean expectedResult){
        Assert.assertEquals(messageIfNotGood, expectedResult, actualResult);
    }

    public void checkExpectedResult (String messageIfNotGood, boolean actualResult){
        checkExpectedResult(messageIfNotGood,actualResult,true);
    }


}
