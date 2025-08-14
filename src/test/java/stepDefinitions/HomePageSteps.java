package stepDefinitions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.HomePage;

import static utils.DriverManager.getDriver;

public class HomePageSteps {

	HomePage homePage = new HomePage();

	@Given("User Lunch Broweser")
	public void user_lunch_broweser() {
		// Write code here that turns the phrase above into concrete actions
		getDriver();

	}

	@When("User navigates to {string}")
	public void user_navigates_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		getDriver().get("https://therapidhire.com");
	}

	@Then("Accept All The Cookies")
	public void accept_all_the_cookies() {
		WebElement cookie = getDriver().findElement(By.className("readoncookie"));
		cookie.click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("therapidhire.com"), "HomePage not loaded correctly");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String title = getDriver().getTitle();
		Assert.assertEquals(title, expectedTitle);
	}

	@Then("{string} link should be visible")
	public void link_should_be_visible(String tagName) {
		WebElement link = getDriver().findElement(By.tagName("a"));
		Assert.assertTrue(link.isDisplayed());
	}
}