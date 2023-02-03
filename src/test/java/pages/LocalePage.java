package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LocalePage extends BasePage{
    //Elements on LocalePage
    @FindBy (xpath = "/html/body/div/div[1]/div/header/div/div[3]/button/span")
    private WebElement localeLanguageBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div")
    private List<WebElement> localeSelectionList;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;

    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    //Methods on LocalePage



    public String setLocale(int elementIndex) {
        localeLanguageBtn.click();
        localeSelectionList.get(elementIndex).click();
        System.out.println("HEADER TEXT JE ");
        System.out.println(header.getText());
        return header.getText();
    }

}
