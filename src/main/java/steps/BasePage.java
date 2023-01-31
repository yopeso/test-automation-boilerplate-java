package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {
    public BasePage(Class<?> repo) {
        PageFactory.initElements(Serenity.getDriver(), repo);
    }
}
