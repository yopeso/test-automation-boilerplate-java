package steps;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.PageFactory;
import skynet.runner.WebDriverManager;

public class BasePage extends PageObject {
    public BasePage(Class<?> repo) {
        PageFactory.initElements(WebDriverManager.getWebDriver(), repo);
    }
}
