package org.JavaAutomation;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/org/JavaAutomation/features",
        glue = "org.JavaAutomation.stepdefinitions",
        tags= "@run"
)
public class CucumberTestRunner {
}
