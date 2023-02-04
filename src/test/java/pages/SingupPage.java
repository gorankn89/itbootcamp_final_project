package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SingupPage extends BasePage{
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
    @FindBy (xpath = "//div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']")
    private WebElement singupPopupMessage;


    public SingupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    // Methods of SingUp Page
    public boolean checkInputTypes(){
      if (  emailInput.getAttribute("type").equals("email") && passwordInput.getAttribute("type").equals("password")&&  confirmPasswordInput.getAttribute("type").equals("password")){
          return true;
      }
      return false;
    }

    public void setDataInInputFields(String name, String email, String password, String confirmPassword) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        signupButton.click();
    }

    public String checkErrorUsserExists() {
        System.out.println(errorMessageText.getText());
        return errorMessageText.getText();
    }

    public String getSingupMessageText() {
        System.out.println(singupPopupMessage.getText());
        return singupPopupMessage.getText();
    }

    public WebElement getSignupButton() {
        return signupButton;
    }
}
