package authentication.mobile.iOS;

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
public class LoginTestiOSNative {

    @Test
    @DisplayName("Login Limango App - iOS - failed")
    public void testiOS() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("OnBoardingLoginButton")).click();
        WebDriverManager.getAppiumDriver().findElement(By.id("Deutschland")).click();
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys("limangotesting@gmail.com");
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField")).sendKeys("testnomarketplace");
        WebDriverManager.getAppiumDriver().findElement(By.id("LoginButton")).click();
        Thread.sleep(3000);
        WebDriverManager.getAppiumDriver().findElement(By.id("überspringen")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        Assertions.assertEquals("Aktuell1", WebDriverManager.getAppiumDriver().findElement(By.id("Aktuell")).getText());
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Login Limango App - iOS - passed")
    public void testiOS1() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("OnBoardingLoginButton")).click();
        WebDriverManager.getAppiumDriver().findElement(By.id("Deutschland")).click();
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys("limangotesting@gmail.com");
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField")).sendKeys("testnomarketplace");
        WebDriverManager.getAppiumDriver().findElement(By.id("LoginButton")).click();
        Thread.sleep(2000);
        WebDriverManager.getAppiumDriver().findElement(By.id("überspringen")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        Assertions.assertEquals("Aktuell", WebDriverManager.getAppiumDriver().findElement(By.id("Aktuell")).getText());
        Thread.sleep(5000);
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
