package com.frontdoor.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Utility;


public class LoginPageTest extends com.saucedemo.base.BaseTest {

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        return Utility.readExcelData("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void testLoginErrorMessage(String username, String password) {
        loginPage.logIntoApplication(username,password);
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,"Error: Invalid login credentials.");
    }




}
