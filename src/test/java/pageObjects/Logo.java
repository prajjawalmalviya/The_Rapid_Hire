package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static utils.DriverManager.getDriver;

public class Logo {

	public WebDriver driver;

	// Constructor
	public Logo() {
		this.driver = getDriver();
	}

	// Locator for the logo image
	By logoImage = By.xpath("//img[@alt='therapidhire']");

	// Navigate to homepage URL
	public void navigateToHomePage() {
		driver.navigate().to("https://therapidhire.com/");
	}

	// Refresh the current page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Click on the website logo
	public void clickLogo() {
		WebElement logo = driver.findElement(logoImage);
		logo.click();
	}

	// Check if logo is displayed
	public boolean isLogoDisplayed() {
		return driver.findElement(logoImage).isDisplayed();
	}

	// Take screenshot and save to given path
	public void takeScreenshot(String filePath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(filePath));
	}

	// Simulate disable internet connection by setting a proxy (not a real
	// disconnection)
	public void disableInternetConnection() {
		System.setProperty("webdriver.chrome.args", "--proxy-server=http://0.0.0.0:0000");
	}
}
