package org.JavaAutomation.stepdefinitions;

import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.managers.RandomDataManager;
import org.JavaAutomation.pageobjects.AccountPage;
import org.JavaAutomation.pageobjects.HomePage;
import org.JavaAutomation.pageobjects.LoginPage;
import org.JavaAutomation.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online");

        HomePage homePage = new HomePage(driver);
                homePage.navigateToRegisterPage();

// Generate random data

                String firstName =RandomDataManager.getRandomFirstName();
                String lastName = RandomDataManager.getRandomLastName();
                String email = RandomDataManager.getRandomEmail();
                String password = RandomDataManager.getRandomPassword();

                // Action on the Register page

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueButton();

        Thread.sleep(5000);

        //Account related actions

        AccountPage accountPage =new AccountPage(driver);
        accountPage.logOutFromTheAccount();
        homePage.navigateToLoginPage();
        Thread.sleep(5000);

        //Login page related actions

        LoginPage loginPage =new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginButton();
        Thread.sleep(5000);

        driver.quit();


    }
}
