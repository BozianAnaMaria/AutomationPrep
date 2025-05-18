package org.example;

import org.example.managers.DriverManager;
import org.example.managers.RandomDataManager;
import org.example.pageobjects.AccountPage;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.RegisterPage;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowJUnit {
    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTests() {
        System.out.println("Before All Tests");
    }

    public void beforeEachTest() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("http://google.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("User is redirected to account page when registering with valid data")
    public void registerFlowWithValidData() {
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToRegisterPage();

        String email = RandomDataManager.getRandomEmail();
        String lastname = RandomDataManager.getRandomLastName();
        registerPage.completeRegisterForm("Ana", lastname, email, "12345!");
        registerPage.enableToggle();
        registerPage.clickRegisterButton();

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URl of the page contain success keyword");

        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOutFromAccount();

        driver.quit();
    }

    @Test
    @DisplayName("The user remains on the register page without accepting privacy rules")
    public void registerFlowWithoutPrivacyRules() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToRegisterPage();

        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.enableToggle();
        registerPage.clickRegisterButton();

        Thread.sleep(5000);
        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertFalse(urlContainSuccessKeyword, "The URl of the page contain success keyword");
    }

    @AfterEach
    public void afterEachTest() {
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("Test case is terminated");
    }

    @AfterAll
    public static void afterAllTheTests() {
        System.out.println("Execution terminated");
    }
}
