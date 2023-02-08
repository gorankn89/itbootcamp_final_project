package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Condition;
import pages.Util;

public class SingupTest extends BaseTest {
    // Local Variables for testing
    private String name = "Test Test";
    private String email = "admin@admin.com";
    private String password = "123654";
    private String confirmPassword = "123654";

    @BeforeMethod
    public void beforeMethod() {
        singupPage.goToSignupPage();
    }

    //Test #1: Visits the signup page
    @Test
    public void verifyUrlSignupPage() {

        singupPage.goToSignupPage();
        Assert.assertTrue(singupPage.urlCompare("/signup", false));
    }

    //Test #2: Checks input types
    @Test
    public void checkInputTypes() {
        Assert.assertTrue(singupPage.checkInputTypes());
    }

    //Test #3: Displays errors when user already exists
    @Test
    public void checkIfErrorDisplayedForExistingUser() {
        singupPage.setDataInInputFields(name, email, password, confirmPassword);
        Assert.assertEquals(singupPage.checkErrorUserExists(), "E-mail already exists");
        Assert.assertTrue(singupPage.urlCompare("/signup", true));
    }

    // Test #4: Signup (New Usser)
    @Test
    public void signUpNewUser() {
        String name = "Goran Knezevic";
        String email = fakerEmail;
        String password = "najjacaSifra";
        String confirmPassword = "najjacaSifra";
        singupPage.setDataInInputFields(name, email, password, confirmPassword);
        Assert.assertEquals(singupPage.getSignupMessageText(), "IMPORTANT: Verify your account");
        Util.wait(singupPage.getCloseButtonAfterLogin(), Condition.CLICKABLE, driverWait);
        singupPage.getCloseButtonAfterLogin().click();
        loginPage.logOutIfNecessary();

    }

}
