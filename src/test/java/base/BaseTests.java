package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
    @AfterTest
    public void tearDown(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.quit();
    }
}
