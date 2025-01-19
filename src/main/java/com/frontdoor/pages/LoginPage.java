package com.frontdoor.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameField = By.id("loginId");
    private By passwordField = By.id("password");

    private By loginButton = By.id("login-btn");

    private By errorMessage = By.xpath("//*[@id=\"auth-error\"]");


    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public WelcomePage clickLoginButton() {
        click(loginButton);
        return new WelcomePage();
    }

    public WelcomePage logIntoApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
