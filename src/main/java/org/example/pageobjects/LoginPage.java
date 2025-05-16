package org.example.pageobjects;

import org.example.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy() // by xpath
    private WebElement loginButton;

    public void completeLoginForm(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        System.out.println("Login form completed");
    }

    public void clickLoginButton() {
        ScrollManager.scrollToElement(loginButton);
        loginButton.click();
        System.out.println("Login button clicked");
    }
}
