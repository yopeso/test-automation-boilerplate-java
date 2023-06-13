package cucumberRunner;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import skynet.hooks.TestNG.TestNGHooks;

@CucumberOptions(
        features = {"./src/test/java/features"},
//        tags = "@Regression",
        glue = {"steps"},
        plugin = {"skynet.hooks.TestNG.ExtentReportListener"})

@Test
public class CucumberTestRunner extends TestNGHooks {
}
