package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Type.text(Elements.findElement(By.id("user-name")), username);
    }

    public static void enterPasswordAs(String password) throws Exception {
        Type.text(Elements.findElement(By.id("password")), password);
    }

    public static void clickOnLoginButton() throws Exception {
        Clicks.click(LoginPageRepo.RepositoryEnum.LoginButton);
    }

    public static void shouldSeeAnErrorMessageDisplayed(String expectedMessage) throws Exception {
        WebElement el = Elements.findElement(By.className("error-message-container"));
        el.findElement(By.xpath("//*[@data-test=\"error\"]"));
        AHCustomAsserts.VerifyEqual(el.getText(), expectedMessage, "The error should displayed with the correct message", "Displayed an incorrect error message", true);
    }
}
