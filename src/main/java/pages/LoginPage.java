package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import skynet.Statics;
import skynet.interactions.Clicks;
import skynet.interactions.Type;
import skynet.interactions.Wait;
import skynet.interfaces.IWebPage;

import repos.LoginPageRepo;

import utils.User;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject implements IWebPage {
    public LoginPage () throws Exception {
        this(10000);
    }

    public LoginPage (int timeout) throws Exception {
        open();
    }

    private void enterUsername (String username) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.EmailField.name(), username);
    }

    private void enterPassword (String password) throws Exception {
        Type.text(LoginPageRepo.RepositoryEnum.PasswordField.name(), password);
    }

    private void clickLogin () throws Exception {
        Clicks.click(LoginPageRepo.RepositoryEnum.LoginButton.name());
    }

    public void login (User user) throws Exception {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLogin();
    }

    @Override
    public void waitForLoad (int pageLoadTimeout) throws Exception {
        Statics.setRepoName(LoginPageRepo.class.getName());
        Wait.waitForExists(LoginPageRepo.RepositoryEnum.EmailField.name(), 10, false);
    }
}
