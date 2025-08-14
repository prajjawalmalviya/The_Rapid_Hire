
package stepDefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.HeaderPage;

import static utils.DriverManager.getDriver;

public class HeaderLinksSteps {

	HeaderPage headerPage = new HeaderPage();

	@When("Links should be visible")
	public void links_should_be_visible() {
		// a[@id='navbarDropdown']
		WebElement ele = getDriver().findElement(By.xpath("//a[@id='navbarDropdown']"));
		Actions ac = new Actions(getDriver());
		ac.moveToElement(ele).perform();
		System.out.println(ele.isDisplayed());
//		for (WebElement link : getDriver().findElements(By.id("navbarDropdown"))) {
//			System.out.println((link.isDisplayed() ? "Visible: " : "Not visible: ") + link.getText());
//		}
	}

	@Then("click on links one by one")
	public void click_on_links_one_by_one() throws InterruptedException {
		List<WebElement> links = getDriver().findElements(By.xpath("//a[@id='navbarDropdown']"));
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			if (href != null && !href.trim().isEmpty() && !href.equals("#")) {
				System.out.println("Opening: " + href);
				getDriver().get(href);
				Thread.sleep(2000);
				getDriver().navigate().back();
				Thread.sleep(1000);
				links = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
			}
		}
	}

	@When("click on {string}")
	public void click_on(String string) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebElement a = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[@class='nav-link'][normalize-space()='Services']")));
	}

	@Then("url should be changed")
	public void url_should_be_changed() throws InterruptedException {
		System.out.println("Current: " + getDriver().getCurrentUrl());
		Thread.sleep(2000);
		getDriver().navigate().to("https://therapidhire.com/technology");
		System.out.println("After: " + getDriver().getCurrentUrl());
	}

	@When("click on2 {string}")
	public void click_on2(String string) {
		getDriver().findElement(By.partialLinkText("Blog")).click();
	}

	@Then("varify by the h2 text")
	public void varify_by_the_h2_text() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector(".page-title")).isDisplayed());
	}
}