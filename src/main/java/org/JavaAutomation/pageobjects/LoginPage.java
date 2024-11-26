package org.JavaAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="#input-email")
    private WebElement emailInput;

    @FindBy(css= "#input-password")
    private WebElement passwordInput;

    @FindBy(css="button[type='submit']")
    private WebElement loginButton;

    public void completeLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);


    }
    public void clickTheLoginButton(){
        loginButton.click();
    }

}
