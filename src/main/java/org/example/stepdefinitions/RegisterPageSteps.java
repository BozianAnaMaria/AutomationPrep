package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.managers.DriverManager;
import org.example.managers.RandomDataManager;
import org.example.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        registerPage.completeRegisterForm(firstName, lastName, email, password);
    }

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() {
        try {
            registerPage.enableToggle();
        } finally {
            System.out.println("Privacy Toggle is disabled");
        }
    }

    @And("continueButton is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickRegisterButton();
    }
}
