package org.JavaAutomation.stepdefinitions;

import io.cucumber.java.en.Then;
import org.JavaAutomation.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("user URL contains the following keyword {string}")
        public void userURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains:" + collectKeyword);

    }
}