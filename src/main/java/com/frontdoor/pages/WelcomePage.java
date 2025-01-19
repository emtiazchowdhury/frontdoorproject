package com.frontdoor.pages;

import org.openqa.selenium.By;

public class WelcomePage extends BasePage {

    private By productsHeader = By.xpath("//span[text()='Message']");

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }

}
