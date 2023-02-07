package tests;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SingupPage;

public class SingupTest extends BaseTest {
    // Local Variables for testing
    private String name = "Test Test";
    private String email = "admin@admin.com";
    private String password = "123654";
    private String confirmPassword = "123654";

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
        loginPage.logOutIfNecesary();
    }

    //Test #1: Visits the signup page
    @Test
    public void VerifyUrlSingupPage() {
        Assert.assertTrue(singupPage.urlCompare("/signup", true));
    }

    //Test #2: Checks input types
    @Test
    public void checkInputTypes() {
        Assert.assertTrue(singupPage.checkInputTypes());
    }

    //Test #3: Displays errors when user already exists
    @Test
    public void checkIfErrorDisplayedForExistingUsser() {
        singupPage.setDataInInputFields(name, email, password, confirmPassword);
        Assert.assertEquals(singupPage.checkErrorUsserExists(), "E-mail already exists");
        Assert.assertTrue(singupPage.urlCompare("/signup", true));
    }

    // Test #4: Signup (New Usser)
    @Test
    public void signUpNewUser() {
        String name = "Goran Knezevic";
        String email = "mail4@mail.com";
        String password = "najjacaSifra";
        String confirmPassword = "najjacaSifra";
        singupPage.setDataInInputFields(name, email, password, confirmPassword);
        Assert.assertEquals(singupPage.getSingupMessageText(), "IMPORTANT: Verify your account");
    }

}
