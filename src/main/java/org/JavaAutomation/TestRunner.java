package org.JavaAutomation;

import org.JavaAutomation.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver =DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        String theNameOfTheFirstTab = driver.getWindowHandle();


        // Deschiderea unei noi ferestre

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md");
        Thread.sleep(50000);

        // inchiderea tabului curent

        driver.close();


        // intoarcerea la primul tab
        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.stiri.md/");
        Thread.sleep(50000);
        driver.quit();


        //DriverManager.getInstance().getDriver().get("https://google.com/");
       // Thread.sleep(50000);
       // DriverManager.getInstance().getDriver().quit();

    }
}