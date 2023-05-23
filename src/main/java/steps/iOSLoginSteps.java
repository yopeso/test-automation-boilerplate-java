package steps;

import actions.iOSLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import skynet.utils.Logger;

public class iOSLoginSteps {
    @When("user tap onboarding login button")
    public void tapOnboardingLoginButton() throws Exception {
        Logger.info("tap onboarding login button");
        iOSLoginPage.tapOnboardingLoginButton();
    }

    @And("user select and tap Deutschland")
    public void clickOnDropDown() throws Exception {
        Logger.info("Select and tap Deutschland");
        iOSLoginPage.clickOnDropDown();
    }

    @And("user enter username as {string}")
    public void enterUsernameAs(String username) throws Exception {
        iOSLoginPage.enterUsernameAs(username);
    }

    @And("user enter password as {string}")
    public void enterPasswordAs(String password) throws Exception {
        iOSLoginPage.enterPasswordAs(password);
    }

    @And("user tap login button")
    public void tapLoginButton() throws Exception {
        Logger.info("Click login button");
        iOSLoginPage.tapLoginButton();
    }

    @And("user tap skip and allow buttons")
    public void tapSkipAndAllowButtons() throws Exception {
        Logger.info("Click skip and allow buttons");
        iOSLoginPage.tapSkipAndAllowButtons();
    }

    @Then("user should see the page title as {string}")
    public void shouldSeeThePageTitleAs(String expectedTitle) throws Exception {
        Logger.info("Should see correct page title");
        iOSLoginPage.shouldSeeThePageTitleAs(expectedTitle);
    }

    @Then("user should see alert message pop up as {string}")
    public void shouldSeeAlertMessagePopupAs(String message) throws Exception {
        Logger.info("Should see login not successful message pop up");
        iOSLoginPage.shouldSeeAlertMessagePopupAs(message);
    }

    @And("user tap Ok button")
    public void tapOkButton() throws Exception {
        Logger.info("tap ok button");
        iOSLoginPage.tapOkButton();
    }
}
