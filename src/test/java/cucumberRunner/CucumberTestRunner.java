package cucumberRunner;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import skynet.hooks.TestNG.TestNGHooks;

@CucumberOptions(
        features = {"./src/test/java/features"},
        tags = "@Regression",
        glue = {"steps"},
        plugin = {"json:target/cucumber.json", "html:target/cucumber-reports.html"})

@Test
public class CucumberTestRunner extends TestNGHooks {
}
