package com.frontdoor.test;

import com.frontdoor.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Utility;

public class WelcomePageTest extends com.saucedemo.base.BaseTest {
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        return Utility.readExcelData("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelData", enabled = false)
    public void testProductsHeaderIsDisplayed(String username, String password) {
        WelcomePage productsPage = loginPage.logIntoApplication(username,password);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Welcome User!");
    }
}
