package actions;

import skynet.interactions.*;
import skynet.interfaces.IWebPage;
import repos.LoginPageRepo;
import skynet.utils.AHCustomAsserts;
import steps.BasePage;
import utils.User;

public class LoginPage extends BasePage implements IWebPage {
    public LoginPage () throws Exception {
        this(10000);
    }

    public LoginPage (int timeout) throws Exception {
        super(LoginPageRepo.class);
        open();
    }

    private void enterUsername (String username) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.EmailField, username);
    }

    private void enterPassword (String password) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.PasswordField, password);
    }

    private void clickLogin () throws Exception {
        Clicks.click(LoginPageRepo.RepositoryEnum.LoginButton);
    }

    public void login (User user) throws Exception {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLogin();
    }

    @Override
    public void waitForLoad (int pageLoadTimeout) throws Exception {
        Wait.waitForExists(LoginPageRepo.RepositoryEnum.EmailField, 10, false);
    }

    public static void navigateTo(String url) throws Exception {
        Navigate.visit(url, null);
    }

    public static void enterUsernameAs(String username) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.EmailField, username);
    }

    public static void enterPasswordAs(String password) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.PasswordField, password);
    }

    public static void clickOnLoginButton() throws Exception {
        Clicks.click(LoginPageRepo.RepositoryEnum.LoginButton);
    }

    public static void shouldSeeAnErrorMessageDisplayed(String expectedMessage) throws Exception {
        Wait.waitForExists(LoginPageRepo.RepositoryEnum.ErrorMessageContainer, 10, false);
        String actualMessage = Elements.getText(LoginPageRepo.RepositoryEnum.ErrorAlert);
        AHCustomAsserts.VerifyEqual(actualMessage, expectedMessage, "The error should displayed with the correct message", "Displayed an incorrect error message", true);
    }
}
