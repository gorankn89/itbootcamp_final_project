package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    // Pages in Parrent Class



    //Variables for Test Available for all Tests
    protected String passwordReal = "secret_sauce";
    protected String passwordFake = "Secret_Sauce";
    protected String standardUser = "standard_user";
    protected String lockedOutUser = "locked_out_user";

    // Before Class / Method - After Class Methods available to all Tests

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
        driver.quit();
    }
}
