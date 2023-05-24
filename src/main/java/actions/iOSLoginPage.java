package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import skynet.interactions.Clicks;
import skynet.interactions.Elements;
import skynet.interactions.Type;
import skynet.interactions.Wait;
import skynet.utils.AHCustomAsserts;
import skynet.utils.Logger;

public class iOSLoginPage {
    public static void tapOnboardingLoginButton() throws Exception {
        Clicks.click(Elements.findElement(By.id("OnBoardingLoginButton")));
    }

    public static void clickOnDropDown() throws Exception {
        Clicks.click(Elements.findElement(By.id("Deutschland")));
    }

    public static void enterUsernameAs(String username) throws Exception {
        keyInEmail(username);
    }

    public static void enterPasswordAs(String password) throws Exception {
        keyInPassword(password);
    }

    private static void keyInEmail(String email) throws Exception {
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTextView"));
        Type.text(el, email);
    }

    private static void keyInPassword(String password) throws Exception {
        WebElement el = Elements.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField"));
        Type.text(el, password);
    }

    public static void tapLoginButton() throws Exception {
        WebElement el = Elements.findElement(By.id("LoginButton"));
        Clicks.click(el);
    }

    public static void tapSkipAndAllowButtons() throws Exception {
        Logger.info("Click skip and allow buttons");
        WebElement skipButton = Elements.findElement(By.id("überspringen"));
        Wait.waitForVisible(skipButton);
        Clicks.click(skipButton);
        WebElement allowButton = Elements.findElement(By.id("Allow"));
        Wait.waitForVisible(allowButton);
        Clicks.click(allowButton);
        Clicks.click(allowButton);
    }

    public static void shouldSeeThePageTitleAs(String expectedTitle) throws Exception {
        WebElement el = Elements.findElements(By.className("android.widget.TextView")).get(0);
        String actualTitle = el.getText();
        AHCustomAsserts.VerifyEqual(actualTitle, expectedTitle, "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    public static void shouldSeeAlertMessagePopupAs(String message) throws Exception {
        WebElement alertEl = Elements.findElement(By.xpath("//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
        Wait.waitForVisible(alertEl);
        String actualText = Elements.getText(By.xpath("//XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText"));
        AHCustomAsserts.VerifyEqual(actualText, message, "The popup should be displayed with the correct alert message", "Displayed on incorrect message", true);
    }

    public static void tapOkButton() throws Exception {
        WebElement el = Elements.findElement(By.id("OK"));
        Clicks.click(el);
    }
}
