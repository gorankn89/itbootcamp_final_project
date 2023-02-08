package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTest extends BaseTest {
    private LocalePage localePage;
    private final int ES = 1;
    private final int EN = 0;
    private final int FR = 2;
    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver, driverWait);
    }

    //Test #1: Set locale to ES
    @Test
    public void setLocaleToES() {
        Assert.assertEquals(localePage.setLocale(ES), "Página de aterrizaje");

    }

    //Test #2: Set locale to EN
    @Test
    public void setLocaleToEn() {
        Assert.assertEquals(localePage.setLocale(EN), "Landing");

    }

    //Test #3: Set locale to FR
    @Test
    public void setLocaleToFR() {
        Assert.assertEquals(localePage.setLocale(FR), "Page d'atterrissage");
    }


}
