package swag.authentication.browser;

import com.skynet.testrail.hooks.TestrailPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import skynet.hooks.JUnit5.JUnitHooks;
import skynet.runner.WebDriverManager;

@TestrailPublisher
@ExtendWith(JUnitHooks.class)
@DisplayName("My test suite")
public class LoginTestBrowser {

    @Test
    @DisplayName("1564436 - This is my first test - passed")
    public void userCanSeeThePageTitle() throws Exception {
        WebDriverManager.getWebDriver().navigate().to("https://www.saucedemo.com/");
        WebDriverManager.getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        WebDriverManager.getWebDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        WebDriverManager.getWebDriver().findElement(By.id("login-button")).click();
        Assertions.assertEquals("Swag Labs", WebDriverManager.getWebDriver().getTitle());
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("1564437 - This is my second test - failed")
    public void userCannotSeeThePageTitle() throws Exception {
        WebDriverManager.getWebDriver().get("https://www.saucedemo.com/");
        WebDriverManager.getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        WebDriverManager.getWebDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        WebDriverManager.getWebDriver().findElement(By.id("login-button")).click();
        Assertions.assertEquals("Swag", WebDriverManager.getWebDriver().getTitle());
        Thread.sleep(2000);
    }

    /**
     * A Test Watcher is needed to be able to get the results of a Test so that it can be sent to Sauce Labs.
     * Note that the name is never actually used
     */
    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    /**
     * Custom TestWatcher for Sauce Labs projects.
     */
    public class SauceTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(ExtensionContext context) {
            ((JavascriptExecutor) WebDriverManager.getWebDriver()).executeScript("sauce:job-result=passed");
            WebDriverManager.getWebDriver().quit();        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            ((JavascriptExecutor) WebDriverManager.getWebDriver()).executeScript("sauce:job-result=failed");
            WebDriverManager.getWebDriver().quit();
        }
    }
}
