package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import skynet.interactions.Elements;
import skynet.runner.WebDriverManager;
import skynet.utils.AHCustomAsserts;
import skynet.utils.Logger;

import javax.swing.text.Element;

public class iOSLoginSteps {
    String username = "limangotesting@gmail.com";
    String password = "testnomarketplace";

    @When("user click onboarding login button")
    public void clickOnboardingLoginButton() throws Exception {
        Logger.info("click onboarding login button");
        WebElement el = Elements.findElement(By.id("OnBoardingLoginButton"));
        el.click();
//        WebDriverManager.getAppiumDriver().findElement(By.id("OnBoardingLoginButton")).click();
    }

    @And("user select and click Deutschland")
    public void clickOnDropDown() throws Exception {
        Logger.info("Select and click Deutschland");
        WebElement el = Elements.findElement(By.id("Deutschland"));
        el.click();
//        WebDriverManager.getAppiumDriver().findElement(By.id("Deutschland")).click();
    }

    @And("user enter valid credentials")
    public void enterValidCredential() throws Exception {
        keyInEmail(username);
        keyInPassword(password);
    }

    public void keyInEmail(String email) throws Exception {
        Logger.info("Enter username");
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView"));
        el.sendKeys(email);
//        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView")).sendKeys(email);
    }

    public void keyInPassword(String password) throws Exception {
        Logger.info("Enter password");
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField"));
        el.sendKeys(password);
//        WebDriverManager.getAppiumDriver().findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField")).sendKeys(password);
    }

    @And("user click login button")
    public void clickLoginButton() throws Exception {
        Logger.info("Click login button");
        WebElement el = Elements.findElement(By.id("LoginButton"));
        el.click();
//        WebDriverManager.getAppiumDriver().findElement(By.id("LoginButton")).click();
    }

    @And("user click skip and allow buttons")
    public void clickSkipAndAllowButtons() throws Exception {
        Logger.info("Click skip and allow buttons");
        wait(2000);
        WebElement skipButton = Elements.findElement(By.id("überspringen"));
        skipButton.click();
        //WebDriverManager.getAppiumDriver().findElement(By.id("überspringen")).click();
        wait(1000);
        WebElement allowButton = Elements.findElement(By.id("Allow"));
        allowButton.click();
        //WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        wait(1000);
        //WebDriverManager.getAppiumDriver().findElement(By.id("Allow")).click();
        allowButton.click();
    }

    @Then("user should see the page title as {string}")
    public void shouldSeeThePageTitleAs(String expectedTitle) throws Exception {
        Logger.info("Should see correct page title");
        WebElement el = Elements.findElements(By.className("android.widget.TextView")).get(0);
        String actualTitle = el.getText();
        AHCustomAsserts.VerifyEqual(actualTitle, expectedTitle, "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
        //Assertions.assertEquals(title, WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
    }
}
