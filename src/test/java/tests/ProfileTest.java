package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfileTest extends BaseTest{
    private ProfilePage profilePage;
    private String fakerPhoneNumber;
    private String city;
    private String fakerCountry;
    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver,driverWait);
        fakerPhoneNumber = faker.phoneNumber().cellPhone();
        city = "San Francisco";
        fakerCountry = faker.country().name();
    }

    public void loginNewUser(){
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.logMeIn(fakerEmail, fakerPassword);
        profilePage.clickCloseButtonAfterLogin();
    }
    public void createNewUser(){
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
        singupPage.setDataInInputFields(fakerName, fakerEmail, fakerPassword, fakerPassword);
        System.out.println(fakerEmail);
        System.out.println(fakerPassword);

    }
    public void createAndLogin(){
        createNewUser();
        loginNewUser();

    }
    @Test
    public void verifyWriteProfile(){
        createAndLogin();
        profilePage.goToProfilePage();
        profilePage.fillTheDataInInputFields(fakerName, fakerPhoneNumber, city, fakerCountry);
        //Testing Message After Save
        Assert.assertEquals(profilePage.getMessageDisplayedAfterSavingProfile(), "Profile saved successfuly");
        ArrayList<String> urls = profilePage.makemeUrlListString(fakerName);
        //Testing input fields
        Assert.assertEquals(profilePage.getNameField().getAttribute("value"), fakerName);
        Assert.assertEquals(profilePage.getPhoneField().getAttribute("value"), fakerPhoneNumber);
        Assert.assertEquals(profilePage.getCityField().getAttribute("value"), city);
        Assert.assertEquals(profilePage.getCountryField().getAttribute("value"), fakerCountry);
        Assert.assertEquals(profilePage.getUrlTwitterField().getAttribute("value"), urls.get(0));
        Assert.assertEquals(profilePage.getUrlGitHubField().getAttribute("value"), urls.get(1));


    }


}
