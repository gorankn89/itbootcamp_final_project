package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTest extends BaseTest {
    private LocalePage localePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver,driverWait);
    }
    //Test #1: Set locale to ES
   @Test
   public void setLocaleToES(){
        Assert.assertEquals(localePage.setLocale(1), "Página de aterrizaje");

   }
   //Test #2: Set locale to EN
    @Test
    public void setLocaleToEn(){
        Assert.assertEquals(localePage.setLocale(0), "Landing");

    }
    //Test #3: Set locale to FR
    @Test
    public void setLocaleToFR(){
        Assert.assertEquals(localePage.setLocale(2), "Page d'atterrissage");
    }



}
