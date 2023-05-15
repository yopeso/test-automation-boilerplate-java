package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import skynet.interactions.Elements;
import skynet.interactions.Navigate;
import skynet.utils.AHCustomAsserts;
import skynet.utils.Logger;

public class BrowserLoginSteps {
    @When("user navigates to {string}")
    public void navigateTo(String url) throws Exception {
        Navigate.visit(url, null);
    }

    @And("user enter username {string}")
    public void enterUsername(String username) throws Exception {
        Logger.info("enter username");
        WebElement el = Elements.findElement(By.id("user-name"));
        el.sendKeys(username);
    }

    @And("user enter password {string}")
    public void enterPassword(String password) throws Exception {
        Logger.info("enter password");
        WebElement el = Elements.findElement(By.id("password"));
        el.sendKeys(password);
    }

    @When("user tap on login Button")
    public void tapOnLoginButton() throws Exception {
        Logger.info("tap On Login Button");
        WebElement el = Elements.findElement(By.id("login-button"));
        el.click();
    }

    @Then("user should see page title as {string}")
    public void shouldSeeCorrectPageTitleAs(String expectedTitle) throws Exception {
        Logger.info("should see correct page title");
        String actualTitle = Elements.findElement(By.className("app_logo")).getText();
        AHCustomAsserts.VerifyEqual(actualTitle, expectedTitle, "The heading page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    @Then("user should see error message displayed as {string}")
    public void shouldSeeAnErrorMessageDisplayed(String expectedMessage) throws Exception {
        Logger.info("should see correct error message");
        WebElement el = Elements.findElement(By.className("error-message-container"));
        el.findElement(By.xpath("//*[@data-test=\"error\"]"));
        String actualMessage = el.getText();
        System.out.println("actualMessage" + actualMessage);
        AHCustomAsserts.VerifyEqual(actualMessage, expectedMessage, "The error should displayed with the correct message", "Displayed an incorrect error message", true);
    }
}
