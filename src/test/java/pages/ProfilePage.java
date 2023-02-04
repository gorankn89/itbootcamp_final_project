package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ProfilePage extends BasePage {
    //Elements on Profile Page
    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button")
    private WebElement closeButtonAfterLogin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement myProflieBtn;


    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "urlTwitter")
    private WebElement urlTwitterField;
    @FindBy(id = "urlGitHub")
    private WebElement urlGitHubField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement saveMessageProfile;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void goToProfilePage() {
        myProflieBtn.click();
    }

    public void clickCloseButtonAfterLogin() {
        driverWait.until(ExpectedConditions.elementToBeClickable(closeButtonAfterLogin));
        closeButtonAfterLogin.click();
    }

    public String getMessageDisplayedAfterSavingProfile() {
        System.out.println("PORUKA NAKON SACUVANOG PROFILA");
        System.out.println(saveMessageProfile.getText());
        System.out.println(saveMessageProfile.getText().substring(0, saveMessageProfile.getText().indexOf("\n")));
        return saveMessageProfile.getText().substring(0, saveMessageProfile.getText().indexOf("\n"));
    }

    public void fillTheDataInInputFields(String name, String phone, String city, String country) {


        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        cityField.sendKeys(city);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cityField.sendKeys(Keys.RETURN);
        countryField.sendKeys(country);
        ArrayList<String> urls = makemeUrlListString(name);
        urlTwitterField.sendKeys(urls.get(0));
        urlGitHubField.sendKeys(urls.get(1));
        saveButton.submit();

    }

    public ArrayList<String> makemeUrlListString(String name) {
        ArrayList<String> urls = new ArrayList<>();
        String linkName = name.replace(" ", "");
        urls.add("https://twitter.com/" + linkName.toLowerCase());
        urls.add("https://github.com/" + linkName.toLowerCase());
        return urls;
    }


    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getUrlTwitterField() {
        return urlTwitterField;
    }

    public WebElement getUrlGitHubField() {
        return urlGitHubField;
    }
}
