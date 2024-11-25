package org.JavaAutomation;

import org.JavaAutomation.managers.DriverManager;
import org.JavaAutomation.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver =DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("the driver is on page:" + driver.getCurrentUrl());

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Deschiderea unei noi ferestre


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online");
        Thread.sleep(5000);
        System.out.println("the driver is on page:" + driver.getCurrentUrl());

        WebElement myAccountDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDownIcon.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();
        Thread.sleep(5000);

        // Deschiderea pagenii de inregistrare
        System.out.println("The driver is on page:" + driver.getCurrentUrl());


        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());
        String firstName = RandomDataManager.getRandomFirstName();
        System.out.println("FirstName:"+ firstName);
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());
        String lastName = RandomDataManager.getRandomLastName();
        System.out.println("LastName:" + lastName);
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email:" + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword(3,21,true,true);
        System.out.println("Password:" + passwordData );
        passwordInput.sendKeys(passwordData);


        WebElement privacyToggleBar = driver.findElement(By.name("agree"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyToggleBar);
        Thread.sleep(5000);

        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        Thread.sleep(5000);






        // inchiderea tabului curent


        driver.close();

        /* intoarcerea la primul tab
        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.stiri.md/");
        Thread.sleep(5000);
        System.out.println("the driver is on page:" + driver.getCurrentUrl());*/

        driver.quit();


        //DriverManager.getInstance().getDriver().get("https://google.com/");
       // Thread.sleep(50000);
       // DriverManager.getInstance().getDriver().quit();

    }
}