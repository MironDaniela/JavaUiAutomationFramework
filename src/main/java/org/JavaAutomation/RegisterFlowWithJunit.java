package org.JavaAutomation;

import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.managers.RandomDataManager;
import org.JavaAutomation.pageobjects.AccountPage;
import org.JavaAutomation.pageobjects.HomePage;
import org.JavaAutomation.pageobjects.LoginPage;
import org.JavaAutomation.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;


@BeforeAll
public static void beforeAllTheTest(){

    System.out.println("This methods is run before all the tests from this class");
}
@BeforeEach
public void beforeEachTest(){
    driver= DriverManager.getInstance().getDriver();
    driver.get("https://tekwillacademy-opencart.online");

    homePage = new HomePage(driver);
    homePage.navigateToRegisterPage();
    registerPage= new RegisterPage(driver);

}

    @Test

    @DisplayName("User is redirected to Account page when registering with valid data")
    public void registerFlowWithValidDateRedirectsTheUserToAccountPage() throws InterruptedException {

            // Generate random data

            String firstName = RandomDataManager.getRandomFirstName();
            String lastName = RandomDataManager.getRandomLastName();
            String email = RandomDataManager.getRandomEmail();
            String password = RandomDataManager.getRandomPassword();

            // Action on the Register page

            registerPage.completeTheRegisterForm(firstName, lastName, email, password);
            registerPage.enableTheToggleBar();
            registerPage.clickOnTheContinueButton();

            Thread.sleep(5000);

            boolean urlContainSuccessKeyword =driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword,"The URL of the page contain the Success keyword");

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


    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting the terms and conditions")

    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules () throws InterruptedException {


        // Generate random data

        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        // Action on the Register page

        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        // registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueButton();

        Assertions.assertTrue(driver.getCurrentUrl().contains ("register"),"The page url has the keyword register ");

        Thread.sleep(5000);

    }

    @Test
    @DisplayName("Navigate to Login page from Register Page")
    public void navigateToLoginPageFromRegisterPage() {
    registerPage.navigateToLoginPage();
    Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @AfterEach
    public void afterEachTest(){
    DriverManager.getInstance().quitTheDriver();
    }
    @AfterAll
    public static void afterAllTheTests(){

        System.out.println("This methods is executed after all the tests");
    }
}
