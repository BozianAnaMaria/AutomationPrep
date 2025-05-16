package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.managers.RandomDataManager;
import org.example.pageobjects.AccountPage;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.example.managers.DriverManager;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("http://google.com/");

        HomePage homePage = new HomePage(driver);
        // homePage has to navigate to register page
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = RandomDataManager.getRandomEmail();
        registerPage.completeRegisterForm("Ana", "Bozian", email, "12345!");
        registerPage.enableToggle();
        registerPage.clickRegisterButton();


        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOutFromAccount();


        driver.quit();
    }
}
