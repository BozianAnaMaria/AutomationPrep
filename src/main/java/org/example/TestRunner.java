package org.example;

import org.example.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com");

        String FirstTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://moodle.usm.md/");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(FirstTabName);
        driver.get("https://github.com/");
        Thread.sleep(2000);
        driver.quit();

    }
}