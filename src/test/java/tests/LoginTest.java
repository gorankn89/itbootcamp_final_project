package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Test #1: Visits the login page
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.goToLoginPage();
    }

    @Test
    public void goToLoginPage() {
        boolean respond = loginPage.isOnLoginPage();
        Assert.assertTrue(respond);
    }

    //Test #2: Checks input types
    @Test
    public void checkInputTypes() {
        boolean loginTypeRespond = loginPage.checkInputTypes();
        Assert.assertTrue(loginTypeRespond);
    }

    //Test #3: Displays errors when user does not exist
    @Test
    public void checkErrorWhenUserDoesNotExists() {
        loginPage.logMeIn(fakerEmail, fakerPassword);
        Assert.assertTrue(loginPage.checkErrorWhenUserDoesNotExists("User does not exists"));
        Assert.assertTrue(loginPage.isOnLoginPage());
    }

    //Test #4: Displays errors when password is wrong
    @Test
    public void checkErrorWhenPasswordIncorrect() {
        loginPage.logMeIn(realUser, fakerPassword);
        Assert.assertTrue(loginPage.checkErrorWhenPasswordIncorrect());
        Assert.assertTrue(loginPage.isOnLoginPage());
    }

    //Test #5: Login
    @Test
    public void logMeIn() {
        loginPage.logMeIn(realUser, realPassword);
        Assert.assertTrue(loginPage.checkIsUrlContainsHome());
    }

    //Test #6: Logout
    @Test
    public void logMeOut() {
        loginPage.logMeIn(realUser, realPassword);
        Assert.assertTrue(loginPage.verifyLogOutButton());
        loginPage.logOutIfNecessary();
        Assert.assertTrue(loginPage.isOnLoginPage());
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(loginPage.isOnLoginPage());


    }

    @AfterMethod
    public void afterMethod() {
    }


}
