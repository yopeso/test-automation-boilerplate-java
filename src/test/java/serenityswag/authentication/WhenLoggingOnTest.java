package serenityswag.authentication;

import actions.LoginActions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import skynet.Statics;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenLoggingOnTest {

    @Managed//    @Managed(driver = "chrome")
    WebDriver driver;
    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage () throws Exception {

        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        // Should see product catalog
        inventoryPage.validatePageTitle();
    }
}
