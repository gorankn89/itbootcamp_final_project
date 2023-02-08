package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Util {

    public static String extractFirstLine(String input) {
        return input.substring(0, input.indexOf("\n"));
    }
    public static void wait(WebElement element, Condition condition, WebDriverWait driverWait){
        switch (condition) {
            case CLICKABLE:
                driverWait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case VISIBLE:
                driverWait.until(ExpectedConditions.visibilityOf(element));
                break;
            default:
                throw new IllegalArgumentException("Invalid condition provided");
        }

    }
    public static void wait (String xpath, int numberOfElements, WebDriverWait driverWait){
        driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), numberOfElements));
    }

}
