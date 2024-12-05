package org.JavaAutomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.managers.RandomDataManager;
import org.JavaAutomation.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);
    @And("the register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
// Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();
        // Action on the Register page
        registerPage.completeTheRegisterForm( firstName, lastName, email, password);
    }
    @And("the privacy toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        registerPage.enableTheToggleBar();
    }
    @When("the continue Button is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnTheContinueButton();
    }
}

