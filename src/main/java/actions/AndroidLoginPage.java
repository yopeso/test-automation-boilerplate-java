package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import skynet.interactions.Clicks;
import skynet.interactions.Elements;
import skynet.interactions.Type;
import skynet.interactions.Wait;
import skynet.utils.AHCustomAsserts;

public class AndroidLoginPage {
    public static void tapOnLoginButton() throws Exception {
        Clicks.click(Elements.findElement(By.id("textViewLogin")));
    }

    public static void selectAndTapOnDropDown() throws Exception {
        Clicks.click(Elements.findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")));
    }

    public static void userEnterUsername(String email) throws Exception {
        Type.text(Elements.findElement(By.id("editTextEmail")), email, true);
    }

    public static void userEnterPassword(String password) throws Exception {
        Type.text(Elements.findElement(By.id("editTextPassword")), password);
    }

    public static void tapOnLoginTextButton() throws Exception {
        Clicks.click(Elements.findElement(By.id("textViewLogin")));
    }

    public static void tapOnSkipButton() throws Exception {
        Clicks.click(Elements.findElement(By.id("skip")));
    }

    public static void tapOnAddLaterButton() throws Exception {
        Clicks.click(Elements.findElement(By.id("add_later_button")));
    }

    public static void shouldSeeTheScreenTitleAs(String title) throws Exception {
        WebElement el = Elements.findElements(By.className("android.widget.TextView")).get(0);
        String actualTitle = el.getText();
        Wait.waitForVisible(el, 5000);
        AHCustomAsserts.VerifyEqual(actualTitle, title, "The page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    public static void shouldSeeInvalidCredentialsMessageDisplayed() throws Exception {
        String actualText = Elements.getText(By.id("de.limango.shop.beta:id/snackbar_text"));
        AHCustomAsserts.VerifyEqual(actualText, "Ungültige Anmeldedaten", "The login page should be displayed with the correct message", "Displayed on incorrect text", true);
    }
}
