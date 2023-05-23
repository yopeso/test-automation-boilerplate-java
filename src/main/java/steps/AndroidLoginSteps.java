package steps;

import actions.AndroidLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import skynet.utils.Logger;

public class AndroidLoginSteps {
    @When("user tap on the Login text button")
    public void tapOnLoginButton() throws Exception {
        Logger.info("tap Login text button");
        AndroidLoginPage.tapOnLoginButton();
        Thread.sleep(5000);
    }

    @And("user select and tap on Germany")
    public void selectAndTapOnDropDown() throws Exception {
        Logger.info("click drop-down button");
        AndroidLoginPage.selectAndTapOnDropDown();
    }

    @And("user enter the username {string}")
    public void userEnterUsername(String email) throws Exception {
        Logger.info("enter username");
        AndroidLoginPage.userEnterUsername(email);
    }

    @And("user enter the password {string}")
    public void userEnterPassword(String password) throws Exception {
        Logger.info("enter password");
        AndroidLoginPage.userEnterPassword(password);
    }

    @And("user tap on login text button")
    public void tapOnLoginTextButton() throws Exception {
        Logger.info("tap login text button");
        AndroidLoginPage.tapOnLoginTextButton();
    }

    @And("user tap on skip button")
    public void tapOnSkipButton() throws Exception {
        Logger.info("tap skip button");
        AndroidLoginPage.tapOnSkipButton();
    }

    @And("user tap on add later button")
    public void tapOnAddLaterButton() throws Exception {
        Logger.info("tap skip button");
        AndroidLoginPage.tapOnAddLaterButton();
    }

    @Then("user should see the screen title as {string}")
    public void shouldSeeTheScreenTitleAs(String title) throws Exception {
        Logger.info("should see correct screen title");
        AndroidLoginPage.shouldSeeTheScreenTitleAs(title);
    }

    @Then("user should see invalid credentials message displayed")
    public void shouldSeeInvalidCredentialsMessageDisplayed() throws Exception {
        Logger.info("Should see invalid credentials message displayed page title");
        AndroidLoginPage.shouldSeeInvalidCredentialsMessageDisplayed();
    }
}
