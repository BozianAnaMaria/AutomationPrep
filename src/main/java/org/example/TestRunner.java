package org.example;

import org.example.managers.DriverManager;
import org.example.managers.RandomDataManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com");
        System.out.println("the driver is on page" + driver.getCurrentUrl());

        String FirstTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://moodle.usm.md/");
        System.out.println("the driver is on page" + driver.getCurrentUrl());

        WebElement ConnectToAccountButton = driver.findElement(By.xpath("(//a[normalize-space()='Conectare'])[1]"));
        ConnectToAccountButton.click();

        WebElement firstNameInput = driver.findElement(By.id("username"));
        String firstName = RandomDataManager.getRandomFirstName();
        System.out.println("Name: " + firstName);
        firstNameInput.sendKeys(firstName);

        WebElement passwordInput = driver.findElement(By.id("password"));
        String passwordData = RandomDataManager.getRandomPassword();
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement confirmToggle = driver.findElement(By.name("confirmToggle"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmToggle);

        WebElement connectButton = driver.findElement(By.id("loginbtn"));
        connectButton.click();

        Thread.sleep(3000);

        driver.close();

        driver.switchTo().window(FirstTabName);
        System.out.println("the driver is on page" + driver.getCurrentUrl());
        driver.quit();

    }
}