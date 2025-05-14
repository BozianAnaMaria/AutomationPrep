package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    private WebElement logOutBtn;

    public void logOutFromAccount() {
        logOutBtn.click();
        System.out.println("Logged out from account");
    }
}
