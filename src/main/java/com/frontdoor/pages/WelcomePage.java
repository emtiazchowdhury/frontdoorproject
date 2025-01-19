package com.frontdoor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private By productsHeader = By.xpath("//span[text()='Message']");

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }

}
