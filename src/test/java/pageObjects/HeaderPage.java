package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static utils.DriverManager.getDriver;

public class HeaderPage {

	public WebDriver driver;
	public Actions actions;

	// Constructor - initialize variables
	public HeaderPage() {
		this.driver = getDriver();
		this.actions = new Actions(driver);
	}

	// Locator for the dropdown link - navbarDropdown id
	By navbarDropdown = By.xpath("//a[@id='navbarDropdown']");
	By dropdownMenuLinks = By.xpath("//ul[@class='dropdown-menu']//a");

	// Hover over the dropdown element
	public void hoverOverNavbarDropdown() {
		WebElement element = driver.findElement(navbarDropdown);
		actions.moveToElement(element).perform();
	}

	// Check if dropdown element is displayed
	public boolean isNavbarDropdownVisible() {
		return driver.findElement(navbarDropdown).isDisplayed();
	}

	// Get all dropdown menu links
	public List<WebElement> getDropdownMenuLinks() {
		return driver.findElements(dropdownMenuLinks);
	}

	// Get all links with id navbarDropdown (though likely single element)
	public List<WebElement> getNavbarDropdownLinks() {
		return driver.findElements(navbarDropdown);
	}
}
