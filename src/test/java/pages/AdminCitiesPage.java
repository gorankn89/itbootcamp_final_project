package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {
    @FindBy(css = ".btnAdmin")
    private WebElement btnAdmin;
    @FindBy(css = ".btnAdminCities")
    private WebElement btnCities;
    @FindBy(css = ".btnNewItem")
    private WebElement newItemBtn;
    @FindBy(id = "name")
    private WebElement inputCityField;
    @FindBy(css = ".btnSave ")
    private WebElement saveBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement saveStatus;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement firstCityInTable;
    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editFirstCityBtn;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement editFirstCityField;

    @FindBy(css = ".btnSave")
    private WebElement btnSaveAfterEdit;

    @FindBy(css = ".v-snack--active")
    private WebElement messageAfterSave;

    @FindBy(id = "search")
    private WebElement searchFieldInput;
    @FindBy(css = "button#delete")
    private WebElement firstElementDeleteBtn;
    @FindBy(xpath = "/html/body/div/div[5]/div/div/div[2]/button[2]")
    private WebElement confirmDeleteBtn;
    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement deleteSuccessMessage;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void goToCitiesPage() {
        btnAdmin.click();
        btnCities.click();
    }

    public void clickAddNewItemBtnAndAddACity(String city) {
        newItemBtn.click();
        inputCityField.sendKeys(city);
        saveBtn.click();
    }

    public String getSaveStatus() {
        Util.wait(saveStatus, Condition.VISIBLE,driverWait);
        return Util.extractFirstLine(saveStatus.getText());

    }


    public String EditFirstCityName() {
        String editedCity = " - " + firstCityInTable.getText() + " edited";
        editFirstCityBtn.click();
        editFirstCityField.sendKeys(editedCity);
        btnSaveAfterEdit.click();
        return firstCityInTable.getText();
    }

    public boolean verifyEditedMessageSucces() {
        Util.wait(messageAfterSave, Condition.VISIBLE, driverWait);
        messageAfterSave.getText();
        return Util.extractFirstLine(messageAfterSave.getText()).equals("Saved successfully");
    }

    public boolean searchCity(String city) {
        searchFieldInput.sendKeys(city);
        city = city.toLowerCase();
        Util.wait("//table/tbody/tr", 1, driverWait);
        return firstCityInTable.getText().toLowerCase().contains(city);
    }

    public void deleteFirstCity() {
        firstElementDeleteBtn.click();
        Util.wait(firstElementDeleteBtn, Condition.VISIBLE, driverWait);
        confirmDeleteBtn.click();
    }

    public boolean confirmDeleteMessage() {
        Util.wait(deleteSuccessMessage, Condition.VISIBLE, driverWait);
        return Util.extractFirstLine(deleteSuccessMessage.getText()).equals("Deleted successfully");
    }
}
