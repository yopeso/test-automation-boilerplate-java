package steps;

import com.skynet.testrail.testrail.Testrail;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import skynet.runner.WebDriverManager;
import skynet.utils.Logger;
import org.testng.Assert;

public class HomeSteps {

    @When("user navigates to {string}")
    public void navigateTo(String url) {
        WebDriverManager.getWebDriver().navigate().to(url);
    }

    @When("user enter username {string}")
    public void enterUsername(String username) {
        Logger.info("enter username");
        WebDriverManager.getWebDriver().findElement(By.id("user-name")).sendKeys(username);
    }

    @When("user enter password {string}")
    public void enterPassword(String password) {
        Logger.info("enter password");
        WebDriverManager.getWebDriver().findElement(By.id("password")).sendKeys(password);
    }

    @When("user tap on Login Button")
    public void tapOnLoginButton() {
        Logger.info("tap On Login Button");
        WebDriverManager.getWebDriver().findElement(By.id("login-button")).click();
    }

    @Then("user should see page title as {string}")
    public void shouldSeeCorrectPageTitleAs(String expectedTitle) {
        Logger.info("should see correct page title");
        Assert.assertEquals(WebDriverManager.getWebDriver().getTitle(), expectedTitle);
    }

    @When("user click on the Login text button")
    public void clickOnLoginButton() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        Logger.info("should see correct Login text button");
    }

    @Then("user click on the drop-down button")
    public void clickOnDropDown() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")).click();
        Logger.info("should see correct Login text button");
    }

    @Then("user enter the username {string}")
    public void user_enter_the_username(String email) {
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextEmail")).sendKeys(email);
        Logger.info("enter username");
    }

    @Then("user enter the password {string}")
    public void user_enter_the_password(String password) {
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextPassword")).sendKeys(password);
        Logger.info("enter password");
    }
}
