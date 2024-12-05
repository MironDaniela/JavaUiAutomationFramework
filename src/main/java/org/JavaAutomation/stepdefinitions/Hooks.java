package org.JavaAutomation.stepdefinitions;

import io.cucumber.java.*;
import org.JavaAutomation.managers.DriverManager;
public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("The execution of the test suite started");
    }
    @Before
    public void executedBeforeEachTest() {
        System.out.println("Test started");
    }
    @After
    public void executeAfterEachTest() {
        System.out.println("The test is completed");
        DriverManager.getInstance().quitTheDriver();
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("The tests execution finished");
    }
}
