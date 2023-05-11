package serenityswag.authentication;


import actions.InventoryPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import com.skynet.testrail.hooks.TestrailPublisher;
import steps.LoginSteps;

import static utils.User.STANDARD_USER;

/**
 Whenever your intention is to run the tests and publish the results in Testrail either add:

 @ TestrailPublisher annotation before your class declaration OR add TestRailPublisherExtension.class to @ExtendWith annotation */

@TestrailPublisher
@ExtendWith (SerenityJUnit5Extension.class)
@DisplayName ("My test suite")
public class WhenLoggingOnTest {

    //    @Managed(driver = "appium")
    @Managed
    WebDriver driver;
    @Steps
    LoginSteps login;
    InventoryPage inventoryPage;


    @Test
    @DisplayName ("1562447 - This is my first test")
    public void usersCanLogOnViaTheHomePage() throws Exception {
        login.as(STANDARD_USER);

        inventoryPage.waitForIncorrectLoad(10);
        inventoryPage.validatePageTitle();
    }

    @Test
    @DisplayName ("1562448 - This is my first test")
    public void usersCanSeeProductPage() throws Exception {
        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.validatePageTitle();
    }

    @Test
    @DisplayName ("1564437 - This is my first test")
    public void usersCanFailTests() throws Exception {
        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.failValidatePageTitle();
    }

    @Test
    @DisplayName ("1564436 - This is my first test")
    public void usersCanSeeProductPageDuplicate() throws Exception {
        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.validatePageTitle();
    }
}