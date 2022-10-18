package repos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPageRepo {
    @FindBy (how = How.CLASS_NAME, using = "title")
    public static WebElement PageTitle;

    @FindBy (how = How.CLASS_NAME, using = "titl")
    public static WebElement IncorrectPageTitle;
}
