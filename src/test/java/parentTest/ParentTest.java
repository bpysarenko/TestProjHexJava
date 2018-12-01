package parentTest;

import pages.LogInPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyAccountPage;
import pages.SearchPage;
import pages.SelectedGamePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LogInPage logInPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected SelectedGamePage selectedGamePage;

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
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }


}
