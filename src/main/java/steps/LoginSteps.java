package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import actions.LoginPage;
import utils.User;

@DefaultUrl("google.com")
public class LoginSteps extends UIInteractionSteps {
    LoginPage loginPage;

    @Step ("Login as {0}")
    public void as(User user) throws Exception {
        loginPage.waitForLoad(10);

        // Login as a standard user
        loginPage.login(user);
    }
}
