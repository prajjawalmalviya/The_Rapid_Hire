package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static utils.DriverManager.getDriver;

public class Navigation {

	public WebDriver driver;
	public Actions actions;

	// Locators
	By logoImage = By.xpath("//img[@alt='therapidhire']");
	By logoLink = By.cssSelector("a.navbar-brand");
	By navbarDropdown = By.id("navbarDropdown");
	By dropdownMenus = By.className("dropdown-menu");

	public Navigation() {
		this.driver = getDriver();
		this.actions = new Actions(driver);
	}

	// Check if logo image is visible
	public boolean isLogoVisible() {
		return driver.findElement(logoImage).isDisplayed();
	}

	// Click the logo link and verify navigation
	public void clickLogoAndVerify() {
		WebElement logoAnchor = driver.findElement(logoLink);
		if (logoAnchor.isDisplayed()) {
			logoAnchor.click();
		}
	}

	// Get current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Verify each expected menu item by link text is visible
	public boolean areMenuItemsVisible(List<String> menuItems) {
		for (String item : menuItems) {
			WebElement menuItem = driver.findElement(By.linkText(item));
			if (!menuItem.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	// Hover over navbarDropdown menu
	public void hoverOverNavbarDropdown() {
		WebElement dropdown = driver.findElement(navbarDropdown);
		actions.moveToElement(dropdown).perform();
	}

	// Get texts of dropdown menu(s)
	public String getDropdownMenusText() {
		List<WebElement> dropdownElements = driver.findElements(dropdownMenus);
		StringBuilder allTexts = new StringBuilder();
		for (WebElement elem : dropdownElements) {
			allTexts.append(elem.getText()).append("\n");
		}
		return allTexts.toString();
	}
}
