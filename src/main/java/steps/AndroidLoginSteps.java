package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import skynet.runner.WebDriverManager;
import skynet.utils.Logger;

public class AndroidLoginSteps {
    @When("user tap on the Login text button")
    public void tapOnLoginButton() throws Exception {
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        Logger.info("should see correct Login text button");
    }

    @And("user select and tap on Germany")
    public void selectAndTapOnDropDown() throws Exception {
        Logger.info("click on the drop-down button");
        WebDriverManager.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Germany')]")).click();
        Thread.sleep(2000);
    }

    @And("user enter the username {string}")
    public void userEnterUsername(String email) {
        Logger.info("enter username");
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextEmail")).sendKeys(email);
    }

    @And("user enter the password {string}")
    public void userEnterPassword(String password) {
        Logger.info("enter password");
        WebDriverManager.getAppiumDriver().findElement(By.id("editTextPassword")).sendKeys(password);
    }

    @And("user tap on login text button")
    public void tapOnLoginTextButton() throws InterruptedException {
        Logger.info("tap login text button");
        WebDriverManager.getAppiumDriver().findElement(By.id("textViewLogin")).click();
        Thread.sleep(3000);
    }

    @And("user tap on skip button")
    public void tapOnSkipButton() throws InterruptedException {
        Logger.info("tap skip button");
        WebDriverManager.getAppiumDriver().findElement(By.id("skip")).click();
        Thread.sleep(2000);
    }

    @Then("user should see the screen title as {string}")
    public void shouldSeeTheScreenTitleAs(String title) throws Exception {
        Logger.info("should see correct screen title");
        Assertions.assertEquals(title, WebDriverManager.getAppiumDriver().findElements(By.className("android.widget.TextView")).get(0).getText());
    }
}
