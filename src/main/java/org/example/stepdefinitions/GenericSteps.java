package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    private WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} is accessed")
    public void thePageIsAccessed(String webAddress) {
        driver.get(webAddress);
        System.out.println("The " + webAddress+ " is accessed");
    }

    @And("the following list of error messages is displayed")
    public void theFollowingListOfErrorMessages(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(500);
        errorMessagesList.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath("")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The ["+ errorMessage +"] is displayed");
        });
    }
}
