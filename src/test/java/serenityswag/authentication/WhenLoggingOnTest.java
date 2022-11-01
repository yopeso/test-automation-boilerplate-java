package serenityswag.authentication;


import actions.LoginActions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.InventoryPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import skynet.hooks.JUnit5.TestrailPublisher;
import skynet.mobile.AppiumServer;
import skynet.mobile.PlatformCheck;


import static utils.User.STANDARD_USER;

/**
 Whenever your intention is to run the tests and publish the results in Testrail either add:

 @ TestrailPublisher annotation before your class declaration OR add TestRailPublisherExtension.class to @ExtendWith annotation */

//@TestrailPublisher
@ExtendWith (SerenityJUnit5Extension.class)
@DisplayName ("My test suite")
public class WhenLoggingOnTest {

    @BeforeAll
    public static void before(){
        PlatformCheck.initDriver();
    }

    @Managed//    @Managed(driver = "chrome")
    WebDriver driver;
    @Steps
    LoginActions login;
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
    @DisplayName ("1562449 - This is my first test")
    public void usersCanFailTests() throws Exception {

        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.failValidatePageTitle();
    }

    @AfterAll
    public static void after(){
        AppiumServer.stopAppiumServer();
    }

}