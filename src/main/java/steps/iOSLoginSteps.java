package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import skynet.runner.WebDriverManager;
import skynet.utils.Logger;

public class iOSLoginSteps {
    String username = "limangotesting@gmail.com";
    String password = "testnomarketplace";

    @When("user click onboarding login button")
    public void clickOnboardingLoginButton() throws Exception {
        Logger.info("click onboarding login button");
        WebDriverManager.getAppiumDriver().findElement(By.id("OnBoardingLoginButton")).click();
    }

    @And("user select and click Deutschland")
    public void clickOnDropDown() throws Exception {
        Logger.info("Select and click Deutschland");
        WebDriverManager.getAppiumDriver().findElement(By.id("Deutschland")).click();
    }

    @And("user enter valid credentials")
    public void enterValidCredential() {
        keyInEmail(username);
        keyInPassword(password);
    }

    public void keyInEmail(String email) {
        Logger.info("Enter username");
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys(email);
    }

    public void keyInPassword(String password) {
        Logger.info("Enter password");
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField")).sendKeys(password);
    }

    @And("user click login button")
    public void clickLoginButton() {
        Logger.info("Click login button");
        WebDriverManager.getAppiumDriver().findElement(By.id("LoginButton")).click();
    }

    @And("user click skip and allow buttons")
    public void clickSkipAndAllowButtons() throws InterruptedException {
        Logger.info("Click skip and allow buttons");
        Thread.sleep(2000);
        WebDriverManager.getAppiumDriver().findElement(By.id("überspringen")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        Thread.sleep(1000);
        WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
    }

    @Then("user should see the page title as {string}")
    public void shouldSeeThePageTitleAs(String title) throws Exception {
        Logger.info("Should see correct page title");
        Assertions.assertEquals(title, WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
    }
}
