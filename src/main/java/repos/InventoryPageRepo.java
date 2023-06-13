package repos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skynet.extensions.StringExtensions;
import skynet.interfaces.GenericEnumRepositoryInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InventoryPageRepo {
    @FindBy (how = How.CLASS_NAME, using = "title")
    public static WebElement PageTitle;

    @FindBy (how = How.CLASS_NAME, using = "titl")
    public static WebElement IncorrectPageTitle;

    public enum RepositoryEnum implements GenericEnumRepositoryInterface {
        PageTitle("className", "title");

        private final String by;
        private final String selector;
        private final ArrayList<String> elementValues = new ArrayList<>();

        RepositoryEnum (String by, String selector) {
            this.by = by;
            this.selector = selector;
        }

        @Override
        public String by () {
            return by;
        }

        @Override
        public String selector() {
            return selector;
        }

        @Override
        public ArrayList<String> valuesOf() {
            elementValues.add(by());
            elementValues.add(selector());
            return elementValues;
        }
    }

    public Map<String, ArrayList<String>> getAll () {
        Map<String, ArrayList<String>> assoc = new HashMap<>();
        for (InventoryPageRepo.RepositoryEnum ele : InventoryPageRepo.RepositoryEnum.values()) {
            assoc.put(ele.name(), ele.valuesOf());
        }
        return assoc;
    }

    public static String get (String name) {
        return Arrays.stream(InventoryPageRepo.RepositoryEnum.values()).filter(val -> val.name().equalsIgnoreCase(StringExtensions.removeWhiteSpaces(name))).findFirst().get().name();
    }
}
