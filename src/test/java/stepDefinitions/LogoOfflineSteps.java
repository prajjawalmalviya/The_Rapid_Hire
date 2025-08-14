
package stepDefinitions;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.Logo;

import java.io.File;
import java.io.IOException;

import static utils.DriverManager.getDriver;

public class LogoOfflineSteps {

	Logo logo = new Logo();

	@Given("The User Refresh The Page")
	public void the_user_refresh_the_page() {
		getDriver().navigate().to("https://therapidhire.com/");
		getDriver().navigate().refresh();
	}

	@When("User disables internet connection")
	public void user_disables_internet_connection() {
		// Simulated by proxy flag, not actual disconnection
		System.setProperty("webdriver.chrome.args", "--proxy-server=http://0.0.0.0:0000");
	}

	@When("User clicks on the website logo")
	public void user_clicks_on_the_website_logo() throws InterruptedException {
		WebElement logo = getDriver().findElement(By.xpath("//img[@alt='therapidhire']"));
		logo.click();
		Thread.sleep(2000);
	}

	@Then("The page should not refresh")
	public void the_page_should_not_refresh() throws IOException {
		WebElement logo = getDriver().findElement(By.xpath("//img[@alt='therapidhire']"));
		Assert.assertTrue(logo.isDisplayed());
		TakesScreenshot sc = (TakesScreenshot) getDriver();
		File get = sc.getScreenshotAs(OutputType.FILE);
		File destination = new File("D://TheRapidHire/HomePage.png");
		FileUtils.copyFile(get, destination);
	}
}