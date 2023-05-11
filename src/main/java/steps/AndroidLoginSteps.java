package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import skynet.utils.AHCustomAsserts;
import skynet.utils.Logger;
import skynet.interactions.Elements;
import static skynet.interactions.Wait.waitForVisible;

public class AndroidLoginSteps {
    @When("user tap on the Login text button")
    public void tapOnLoginButton() throws Exception {
        Logger.info("tap Login text button");
        WebElement el = Elements.findElement(By.id("textViewLogin"));
        el.click();
//        WebDriverManager.getWebDriver().findElement(By.id("textViewLogin")).click();
    }

    @And("user select and tap on Germany")
    public void selectAndTapOnDropDown() throws Exception {
        Logger.info("click drop-down button");
        WebElement el = Elements.findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]"));
        el.click();
        //WebDriverManager.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")).click();
//        wait(2000);
    }

    @And("user enter the username {string}")
    public void userEnterUsername(String email) throws Exception {
        Logger.info("enter username");
        WebElement el = Elements.findElement(By.id("editTextEmail"));
        el.sendKeys(email);
        //WebDriverManager.getAppiumDriver().findElement(By.id("editTextEmail")).sendKeys(email);
    }

    @And("user enter the password {string}")
    public void userEnterPassword(String password) throws Exception {
        Logger.info("enter password");
        WebElement el = Elements.findElement(By.id("editTextPassword"));
        el.sendKeys(password);
        //WebDriverManager.getAppiumDriver().findElement(By.id("editTextPassword")).sendKeys(password);
    }

    @And("user tap on login text button")
    public void tapOnLoginTextButton() throws Exception {
        Logger.info("tap login text button");
        WebElement el = Elements.findElement(By.id("textViewLogin"));
        el.click();
        Thread.sleep(5000);
//        waitForNotVisible(Elements.findElement(By.id("de.limango.shop.beta:id/dialog_title")), 5000, true);
//        waitForNotVisible(Elements.findElement(By.id("de.limango.shop.beta:id/dialog_title")));
        //WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
    }

    @And("user tap on skip button")
    public void tapOnSkipButton() throws Exception {
        Logger.info("tap skip button");
        WebElement el = Elements.findElement(By.id("skip"));
        el.click();
//        WebDriverManager.getAppiumDriver().findElement(By.id("skip")).click();
//        wait(2000);
    }

    @And("user tap on add later button")
    public void tapOnAddLaterButton() throws Exception {
        Logger.info("tap skip button");
        WebElement el = Elements.findElement(By.id("de.limango.shop.beta:id/add_later_button"));
        el.click();
//        WebDriverManager.getAppiumDriver().findElement(By.id("skip")).click();
//        wait(2000);
    }

    @Then("user should see the screen title as {string}")
    public void shouldSeeTheScreenTitleAs(String title) throws Exception {
        Logger.info("should see correct screen title");
        WebElement el = Elements.findElements(By.className("android.widget.TextView")).get(0);
        String actualTitle = el.getText();
        waitForVisible(el, 5000);
        AHCustomAsserts.VerifyEqual(actualTitle, title, "The page should be displayed with the correct title", "Landed on incorrect page", true);
//        Assertions.assertEquals(title, WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
    }

    @Then("user should see invalid credentials message displayed")
    public void shouldSeeInvalidCredentialsMessageDisplayed() throws Exception {
        Logger.info("Should see invalid credentials message displayed page title");
        WebElement el = Elements.findElement(By.id("de.limango.shop.beta:id/snackbar_text"));
//        waitForVisible(el, 10000);
        waitForVisible(el);
        String actualText = el.getText();
        AHCustomAsserts.VerifyEqual(actualText, "Ungültige Anmeldedaten", "The login page should be displayed with the correct message", "Displayed on incorrect text", true);
        //Assertions.assertEquals(title, WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
    }
}
