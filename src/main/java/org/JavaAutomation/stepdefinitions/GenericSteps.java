package org.JavaAutomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.JavaAutomation.managers.ConfigReaderManager;
import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.managers.ScrollManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("user URL contains the following keyword {string}")
        public void userURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains:" + collectKeyword);

    }

    @Given("The {string} endpoint is accessed")
    public void theIsAccessed(String endpoint) {
        String fullLink = ConfigReaderManager.getProperty("baseUrl")+ endpoint;
        driver.get(fullLink);
        System.out.println("The accessed link is:" + fullLink);
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
            Assertions.assertTrue(messageIsDisplayed, "The error message is displayed");});
    }

    @When("the {string} from {string} is clicked")
    public void theFromIsClicked(String clickableElement, String pageName) throws Exception {
        Class classInstance =Class.forName("org.JavaAutomation.pageobjects."+ pageName);
        Field webClickableElementField = classInstance.getDeclaredField(clickableElement);
        webClickableElementField.setAccessible(true);
        WebElement webClickableElement = (WebElement) webClickableElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
        ScrollManager.scrollToElement(webClickableElement);
      webClickableElement.click();


    }
}