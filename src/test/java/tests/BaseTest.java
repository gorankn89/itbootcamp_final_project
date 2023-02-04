package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AdminCitiesPage;
import pages.LoginPage;
import pages.SingupPage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    // Pages in Parrent Class
    protected LoginPage loginPage;
    protected SingupPage singupPage;

    protected AdminCitiesPage adminCitiesPage;


    //Variables for Test Available for all Tests
    protected Faker faker;
    protected String realPassword = "12345";
    protected String passwordFake = "123456";
    protected String realUser = "admin@admin.com";
    protected String lockedOutUser = "adminn@admin.com";
    protected String fakerEmail;
    protected String fakerPassword;
    protected String fakerName;



    // Before Class / Method - After Class Methods available to all Tests

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver, driverWait);
        this.singupPage = new SingupPage(driver,driverWait);
        this.adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        faker = new Faker();
        fakerEmail = faker.internet().emailAddress();
        fakerPassword = faker.internet().password();
        fakerName = faker.name().fullName();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        loginPage.logOutIfNecesary();

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
        driver.quit();
    }
}
