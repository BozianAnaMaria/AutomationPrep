package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.managers.DriverManager;
import org.example.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The Home Page is displayed")
    public void theHomePageIsDisplayed() {
        driver.get("http://localhost:8080/");
    }

    @And("Register Page is accessed from the Home Page button")
    public void registerPageIsAccessedFromTheHomePageButton() {
        homePage.navigateToRegisterPage();
    }
}
