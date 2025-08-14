
package stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.Navigation;

import static utils.DriverManager.getDriver;

public class NavigationSteps {

	Navigation navigation = new Navigation();

	@Then("Website logo should be visible")
	public void website_logo_should_be_visible() {
		Assert.assertTrue(getDriver().findElement(By.xpath("//img[@alt='therapidhire']")).isDisplayed(),
				"Logo is not visible");
	}

	@When("Website logo should be clickable")
	public void website_logo_should_be_clickable() {
		WebElement logoLink = getDriver().findElement(By.cssSelector("a.navbar-brand"));
		Assert.assertTrue(logoLink.isDisplayed());
		logoLink.click();
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://therapidhire.com/");
	}

	@Then("The following menu items should be visible")
	public void the_following_menu_items_should_be_visible(DataTable datatable) throws InterruptedException {
		List<String> expectedItems = datatable.asList();
		for (String item : expectedItems) {
			Assert.assertTrue(getDriver().findElement(By.linkText(item)).isDisplayed());
		}
		Actions ac = new Actions(getDriver());
		ac.moveToElement(getDriver().findElement(By.id("navbarDropdown"))).perform();
		Thread.sleep(1000);
		for (WebElement item : getDriver().findElements(By.className("dropdown-menu"))) {
			System.out.println(item.getText());
		}
	}
}
