package authentication.mobile.android;

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

@ExtendWith(JUnitHooks.class)
@DisplayName("My test suite")
public class LoginTestAndroidNative {

    @Test
    @DisplayName("Login Limango App - Android - passed")
    public void userCanSeeThePageTitle() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")).click();
        Thread.sleep(2000);
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextEmail")).sendKeys("limangotesting@gmail.com");
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextPassword")).sendKeys("testnomarketplace");
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        Thread.sleep(3000);
        WebDriverManager.getAppiumDriver().findElement(By.id("skip")).click();
        Thread.sleep(2000);
        Assertions.assertEquals("Aktuell", WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Login Limango App - Android - failed")
    public void userCannotSeeThePageTitle() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")).click();
        Thread.sleep(2000);
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextEmail")).sendKeys("limangotesting@gmail.com");
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextPassword")).sendKeys("testnomarketplace");
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        Thread.sleep(3000);
        WebDriverManager.getAppiumDriver().findElement(By.id("skip")).click();
        Thread.sleep(2000);
        Assertions.assertEquals("Aktuelll", WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
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
