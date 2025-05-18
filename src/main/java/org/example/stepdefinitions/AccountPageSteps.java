package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContains(String string) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsString = driver.getCurrentUrl().contains(string);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsString, "The" + string + "is present in the page");
    }
}
