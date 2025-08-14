package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.DriverManager.getDriver;

public class HomePage {

	public WebDriver driver;

	// Constructor to initialize driver
	public HomePage() {
		this.driver = getDriver();
	}

	// Locators
	 By cookieAcceptBtn = By.className("readoncookie");
	 By firstAnchorTag = By.tagName("a");

	// Navigate to given URL
	public void navigateTo(String url) {
		driver.get(url);
	}

	// Accept cookies by clicking the cookie accept button
	public void acceptCookies() {
		WebElement cookie = driver.findElement(cookieAcceptBtn);
		if (cookie.isDisplayed()) {
			cookie.click();
		}
	}

	// Get current page URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Get title of the page
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Check if <a> tag link is visible (you can parameterize for specific link
	// text/tag if needed)
	public boolean isLinkVisible() {
		WebElement link = driver.findElement(firstAnchorTag);
		return link.isDisplayed();
	}
}
