package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {
    //Elements on LoginPage
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(className = "btnLogout")
    private List<WebElement> logOutButtonList;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMesageForUsser;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    // Methods of Login Page
    public void logMeIn(String email, String password) {
        inputEmail.clear();
        inputPassword.clear();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        loginButton.submit();
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }

    public void goToLoginPage() {
        loginLink.click();
    }


    public boolean checkInputTypes() {
        boolean isEmail = inputEmail.getAttribute("type").equals("email");
        boolean isPassword = inputPassword.getAttribute("type").equals("password");
        if (isEmail && isPassword) {
            return true;
        }
        return false;
    }

    public void logOutIfNecessary() {
        if (!logOutButtonList.isEmpty()) {
            logOutButtonList.get(0).click();
        }
    }

    public boolean checkErrorWhenUserDoesNotExists(String message) {

        return errorMesageForUsser.getText().equals(message);
    }

    public boolean checkErrorWhenPasswordIncorrect() {
        return checkErrorWhenUserDoesNotExists("Wrong password");
    }

    public boolean checkIsUrlContainsHome() {
        return super.urlCompare("/home", true);
    }


    public boolean verifyLogOutButton() {
        return !logOutButtonList.isEmpty();
    }
}
