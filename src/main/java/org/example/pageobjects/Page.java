package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[normalize-space()='Conectare'])[1]")
    protected WebElement myAccountIcon;

    protected WebElement registerLink;

    protected WebElement loginLink;

    protected WebElement navigateToRegisterPage(){
        myAccountIcon.click();
        registerLink.click();
    }
}
