package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SingupPage extends BasePage {
    //Elements of SingupPage
    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement signupButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMessageText;
    @FindBy(xpath = "//div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']")
    private WebElement singupPopupMessage;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button")
    private WebElement closeButtonAfterLogin;

    public WebElement getCloseButtonAfterLogin() {
        return closeButtonAfterLogin;
    }

    public SingupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    // Methods of SingUp Page
    public boolean checkInputTypes() {
        return emailInput.getAttribute("type").equals("email") && passwordInput.getAttribute("type").equals("password") && confirmPasswordInput.getAttribute("type").equals("password");
    }

    public void setDataInInputFields(String name, String email, String password, String confirmPassword) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        signupButton.click();
    }

    public String checkErrorUserExists() {
        Util.wait(errorMessageText, Condition.VISIBLE, driverWait);
        return errorMessageText.getText();
    }

    public String getSignupMessageText() {
        Util.wait(singupPopupMessage, Condition.VISIBLE, driverWait);
        return singupPopupMessage.getText();
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public void goToSignupPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }
}
