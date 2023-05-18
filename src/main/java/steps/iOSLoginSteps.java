package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import skynet.interactions.Elements;
import skynet.interactions.Wait;
import skynet.utils.AHCustomAsserts;
import skynet.utils.Logger;

public class iOSLoginSteps {
    String username = "limangotesting@gmail.com";
    String password = "testnomarketplace";

    @When("user tap onboarding login button")
    public void tapOnboardingLoginButton() throws Exception {
        Logger.info("tap onboarding login button");
        WebElement el = Elements.findElement(By.id("OnBoardingLoginButton"));
        el.click();
    }

    @And("user select and tap Deutschland")
    public void clickOnDropDown() throws Exception {
        Logger.info("Select and tap Deutschland");
        WebElement el = Elements.findElement(By.id("Deutschland"));
        Wait.waitForClickable(el, 2000, false);
        el.click();
    }

    @And("user enter valid credentials")
    public void enterValidCredential() throws Exception {
        keyInEmail(username);
        keyInPassword(password);
    }

    @And("user enter username as {string}")
    public void enterUsernameAs(String username) throws Exception {
        keyInEmail(username);
    }

    @And("user enter password as {string}")
    public void enterPasswordAs(String password) throws Exception {
        keyInPassword(password);
    }

    public void keyInEmail(String email) throws Exception {
        Logger.info("Enter username");
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView"));
        el.click();
        el.sendKeys(email);
    }

    public void keyInPassword(String password) throws Exception {
        Logger.info("Enter password");
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField"));
        el.click();
        el.sendKeys(password);
    }

    @And("user tap login button")
    public void tapLoginButton() throws Exception {
        Logger.info("Click login button");
        WebElement el = Elements.findElement(By.id("LoginButton"));
        el.click();
    }

    @And("user tap skip and allow buttons")
    public void tapSkipAndAllowButtons() throws Exception {
        Logger.info("Click skip and allow buttons");
        WebElement skipButton = Elements.findElement(By.id("überspringen"));
        Wait.waitForVisible(skipButton);
        skipButton.click();
        WebElement allowButton = Elements.findElement(By.id("Allow"));
        Wait.waitForVisible(allowButton);
        allowButton.click();
        allowButton.click();
    }

    @Then("user should see the page title as {string}")
    public void shouldSeeThePageTitleAs(String expectedTitle) throws Exception {
        Logger.info("Should see correct page title");
        WebElement el = Elements.findElements(By.className("android.widget.TextView")).get(0);
        String actualTitle = el.getText();
        AHCustomAsserts.VerifyEqual(actualTitle, expectedTitle, "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
    }

//    @Then("user should see login not successful message pop up")
//    public void shouldSeeLoginNotSuccessfulPopup() throws Exception {
//        Logger.info("Should see login not successful message pop up");
//        WebElement alertEl = Elements.findElement(By.id("Login nicht erfolgreich. Bitte prüfe E-Mailadresse und Passwort."));
//        Wait.waitForVisible(alertEl);
//        String alertMsg = "Login nicht erfolgreich. Bitte prüfe E-Mailadresse und Passwort.";
//        AHCustomAsserts.VerifyEqual(alertEl.getText(), alertMsg, "The popup should be displayed with the correct alert message", "Displayed on incorrect message", true);
//    }

    @Then("user should see alert message pop up as {string}")
    public void shouldSeeAlertMessagePopupAs(String message) throws Exception {
        Logger.info("Should see login not successful message pop up");
        WebElement alertEl = Elements.findElement(By.xpath("//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
        Wait.waitForVisible(alertEl);
        String actualText = alertEl.findElement(By.xpath("//XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText")).getText();
        AHCustomAsserts.VerifyEqual(actualText, message, "The popup should be displayed with the correct alert message", "Displayed on incorrect message", true);
    }

    @And("user tap Ok button")
    public void tapOkButton() throws Exception {
        Logger.info("tap ok button");
        WebElement el = Elements.findElement(By.id("OK"));
        el.click();
    }
}
