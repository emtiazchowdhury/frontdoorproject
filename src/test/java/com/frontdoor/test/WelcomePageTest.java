package com.frontdoor.test;

import com.frontdoor.base.BaseTest;
import com.frontdoor.pages.LoginPage;
import com.frontdoor.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Utility;

public class WelcomePageTest extends BaseTest {
    protected LoginPage loginPage;
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        return Utility.readExcelData("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelData", enabled = false)
    public void testProductsHeaderIsDisplayed(String username, String password) {
        loginPage = new LoginPage();
        WelcomePage productsPage = loginPage.logIntoApplication(username,password);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Welcome User!");
    }
}
