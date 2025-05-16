package org.example.pageobjects;

import org.example.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    private WebElement firstNameInput;

    @FindBy()
    private WebElement lastNameInput;

    @FindBy()
    private WebElement emailInput;

    @FindBy()
    private WebElement passwordInput;

    @FindBy()
    private WebElement confirmToggle;

    @FindBy()
    private WebElement registerButton;

    public void completeRegisterForm(String firstname,  String lastname, String email, String password) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void enableToggle(){
        ScrollManager.scrollToElement(confirmToggle);
        confirmToggle.click();
        System.out.println("The Toggle is enabled");
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
