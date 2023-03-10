package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(this.driver, this);

    }

    public boolean urlCompare(String what, boolean end) {
        driverWait.until(ExpectedConditions.urlContains(what));

        if (end) {
            return driver.getCurrentUrl().endsWith(what);
        }
        return driver.getCurrentUrl().contains(what);
    }

}
