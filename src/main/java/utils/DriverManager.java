 package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class DriverManager {

    public static WebDriver driver;

    @BeforeMethod
    public static void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    // Get the browser instance
    public static WebDriver getDriver() {
        return driver;
    }

    // Close the browser
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
