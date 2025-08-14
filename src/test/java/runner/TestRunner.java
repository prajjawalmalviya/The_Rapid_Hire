package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions
			(features = "src/test/java/resources/features", 
			 glue = "stepDefinitions",
			 plugin = { "pretty", "html:target/cucumber-report.html","json:target/cucumber.json" },
			 monochrome = true,
			 tags = "@HomePage or @HeaderNavigation or @HeaderLinkClick or @OfflineLogoBehaviour"
			 		
																										)
public class TestRunner extends AbstractTestNGCucumberTests {
}
