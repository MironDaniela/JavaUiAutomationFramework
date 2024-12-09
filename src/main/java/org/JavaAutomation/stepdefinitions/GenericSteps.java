package org.JavaAutomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.JavaAutomation.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("user URL contains the following keyword {string}")
        public void userURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains:" + collectKeyword);

    }

    @Given("The {string} is accessed")
    public void theIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        System.out.println("The accessed link is:" + collectedLink);
    }

    @And("a thread sleep of {int} seconds is executed")
    public void aThreadSleepOfSecondsIsExecuted(int timeToBeSlept) {
        try {
            Thread.sleep(timeToBeSlept*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the following list of error message is displayed:")
    public void theFollowingListOfErrorMessageIsDisplayed(List<String> listOfErrors) throws InterruptedException {
        Thread.sleep(1000);
        listOfErrors.forEach(errorMessage-> {
            boolean messageIsDisplayed = driver.findElements(By.xpath(".//*[contains(text(), ' " +
                    errorMessage + "')]")).isEmpty();
            Assertions.assertTrue(messageIsDisplayed, "The error message is displayed");
        });


    }
}