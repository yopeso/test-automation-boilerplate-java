package steps;

import actions.InventoryPage;
import actions.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import skynet.utils.Logger;

public class BrowserLoginSteps {
    @When("user navigates to {string}")
    public void navigateTo(String url) throws Exception {
        LoginPage.navigateTo(url);
    }

    @And("user enter username {string}")
    public void enterUsername(String username) throws Exception {
        Logger.info("enter username");
        LoginPage.enterUsernameAs(username);
    }

    @And("user enter password {string}")
    public void enterPassword(String password) throws Exception {
        Logger.info("enter password");
        LoginPage.enterPasswordAs(password);
    }

    @When("user click on login Button")
    public void clickOnLoginButton() throws Exception {
        Logger.info("tap On Login Button");
        LoginPage.clickOnLoginButton();
    }

    @Then("user should see page title as {string}")
    public void shouldSeeCorrectPageTitleAs(String expectedTitle) throws Exception {
        Logger.info("should see correct page title");
        InventoryPage.shouldSeePageTitleAs(expectedTitle);
    }

    @Then("user should see error message displayed as {string}")
    public void shouldSeeAnErrorMessageDisplayed(String expectedMessage) throws Exception {
        Logger.info("should see correct error message");
        LoginPage.shouldSeeAnErrorMessageDisplayed(expectedMessage);
    }
}
