package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import pages.LoginPage;

import utils.User;

public class LoginActions extends UIInteractionSteps {
    LoginPage loginPage;

    @Step("Log in as {0}")
    public void as (User user) throws Exception {
        loginPage.waitForLoad(10);

        // Login as a standard user
        loginPage.login(user);
    }
}
