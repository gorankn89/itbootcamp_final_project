package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {
    //Test #1: Forbids visits to home url if not authenticated
    @Test
    public void homeUrlTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(loginPage.urlCompare("/login", true));
    }

    //Test #2: Forbids visits to profile url if not authenticated
    @Test
    public void profileUrlTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(loginPage.urlCompare("/login", true));
    }

    //Test #3: Forbids visits to admin cities url if not authenticated
    @Test
    public void adminCitiesUrlTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        Assert.assertTrue(loginPage.urlCompare("/login", true));
    }

    //Test #4: Forbids visits to admin users url if not authenticated
    @Test
    public void adminUsersUrlTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        Assert.assertTrue(loginPage.urlCompare("/login", true));
    }
}
