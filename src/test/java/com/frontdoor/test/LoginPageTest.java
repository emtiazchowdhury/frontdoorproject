package com.frontdoor.test;

import com.frontdoor.base.BaseTest;
import com.frontdoor.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Utility;


public class LoginPageTest extends BaseTest {
    protected LoginPage loginPage;
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        return Utility.readExcelData("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void testLoginErrorMessage(String username, String password) {
        loginPage = new LoginPage();
        loginPage.logIntoApplication(username,password);
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,"Error: Invalid login credentials.");
    }




}
