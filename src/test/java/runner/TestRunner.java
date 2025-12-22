package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions
			(features = "src/test/java/resources/features", 
			 glue = "stepDefinitions",
			 plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
			 monochrome = true,
			 tags = "@HomePage or @HeaderNavigation or @HeaderLinkClick or @OfflineLogoBehaviour"
			 		
																										)
public class TestRunner extends AbstractTestNGCucumberTests {
}
