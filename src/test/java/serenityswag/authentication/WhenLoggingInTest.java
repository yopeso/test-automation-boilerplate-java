package serenityswag.authentication;


import steps.LoginSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import actions.InventoryPage;
import com.skynet.testrail.hooks.TestrailPublisherExtension;

import static utils.User.STANDARD_USER;

/**
 Whenever your intention is to run the tests and publish the results in Testrail either add:

 @ TestrailPublisher annotation before your class declaration OR add TestRailPublisherExtension.class to @ExtendWith annotation */

@ExtendWith ({ SerenityJUnit5Extension.class, TestrailPublisherExtension.class })
@DisplayName ("My test suite")
public class WhenLoggingInTest {

//    @Managed(driver = "appium")
    @Managed
    WebDriver driver;
    @Steps
    LoginSteps login;
    InventoryPage inventoryPage;


    @Test
    @DisplayName ("1563818 - This is my first test")
    public void usersCanLogOnViaTheHomePage() throws Exception {

        login.as(STANDARD_USER);

        inventoryPage.waitForIncorrectLoad(10);
        inventoryPage.validatePageTitle();
    }

    @Test
    @DisplayName ("1563819 - This is my first test")
    public void usersCanSeeProductPage() throws Exception {

        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.validatePageTitle();
    }

    @Test
    @DisplayName ("1563820 - This is my first test")
    public void usersCanFailTests() throws Exception {

        login.as(STANDARD_USER);

        inventoryPage.waitForLoad(10);
        inventoryPage.failValidatePageTitle();
    }
}