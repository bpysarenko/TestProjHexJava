package parentTest;

import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");


    protected LogInPage logInPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected SelectedGamePage selectedGamePage;
    protected WishListPage wishListPage;
    protected KorzinaPage korzinaPage;
    protected BlogPage blogPage;

    @Before
    public void setUp() {
        if("chrome".equals(browser) || browser == null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser)){
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        } else {
            Assert.fail("Wrong browser name!");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        searchPage = new SearchPage(webDriver);
        selectedGamePage = new SelectedGamePage(webDriver);
        wishListPage = new WishListPage(webDriver);
        korzinaPage = new KorzinaPage(webDriver);
        blogPage = new BlogPage(webDriver);
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
