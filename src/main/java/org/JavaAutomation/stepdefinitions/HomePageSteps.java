
package org.JavaAutomation.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver =DriverManager.getInstance().getDriver();
    HomePage homePage= new HomePage(driver);
    @Given("The Home Page is displayed")
    public void theHomePageIsDisplayed() {
        driver.get("https://tekwillacademy-opencart.online/");
}
    @And("Register page is accessed from the Home Page Buttons")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        homePage.navigateToRegisterPage();
    }
}
