package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;

public class AdminCitiesTest extends BaseTest{
    private String city;
    @BeforeClass
    public void beforeClass(){
        super.beforeClass();
        city = faker.address().city();
    }
    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        loginPage.goToLoginPage();
        loginPage.logMeIn(realUser, realPassword);
        adminCitiesPage.goToCitiesPage();

    }
    //Test #1: Visits the admin cities page and list cities
    @Test
    public void verifyCitiesPage(){
        Assert.assertTrue(adminCitiesPage.urlCompare("/admin/cities", true));
        Assert.assertTrue(loginPage.verifyLogOutButton());
    }
    //Test #2: Create new city
    @Test
    public void createAndVerifyNewCity(){
        adminCitiesPage.clickAddNewItemBtnAndAddACity(city);
        Assert.assertEquals(adminCitiesPage.getSaveStatus(), "Saved successfully");
    }
    //Test #3: Edit city
    @Test(dependsOnMethods = {"createAndVerifyNewCity"})
    public void editCity() {
    city = adminCitiesPage.EditFirstCityName();
        System.out.println("ISPIS SAVE STATUSA ZA NESTO ");
        Assert.assertTrue(adminCitiesPage.verifyEditedMessageSucces());
    }

    //Test #4: Search city
    @Test (dependsOnMethods = {"editCity"})
    public void searchCity() {
      Assert.assertTrue(adminCitiesPage.searchCity(city));

    }
    //Test #5: Delete city
    @Test (dependsOnMethods = {"searchCity"})
    public void deleteCity(){
        Assert.assertTrue(adminCitiesPage.searchCity(city));
        adminCitiesPage.deleteFirstCity();
        Assert.assertTrue(adminCitiesPage.confirmDeleteMessage());



    }


}
