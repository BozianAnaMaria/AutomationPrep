package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.managers.DriverManager;
import org.example.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    private WebDriver driver = DriverManager.getInstance().getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @And("the following set of credentials is entered into the login form")
    public void theFollowingSetOfCredentialsIsEnteredIntoTheLoginForm(List<String> credentialsList) {
        loginPage.completeLoginForm(credentialsList.get(0), credentialsList.get(1));
    }

    @When("login button is clicked")
    public void loginButtonIsClicked() {
        loginPage.clickLoginButton();
    }
}
