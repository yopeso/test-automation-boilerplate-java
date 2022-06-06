package repos;

import skynet.extensions.StringExtensions;
import skynet.interfaces.GenericEnumRepositoryInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginPageRepo {
    public Map<String, ArrayList<String>> getAll () {
        Map<String, ArrayList<String>> assoc = new HashMap<>();
        for (RepositoryEnum ele : RepositoryEnum.values()) {
            assoc.put(ele.name(), ele.valuesOf());
        }

        return assoc;
    }

    public enum RepositoryEnum implements GenericEnumRepositoryInterface {
        EmailField("css", "[data-test='username']"),
        NoEmailField("css", "[data-test='usernames']"),
        PasswordField("css", "[data-test='password']"),
        LoginButton("css", "[data-test='login-button']");

        private final String by;
        private final String selector;
        private final ArrayList<String> elementValues = new ArrayList<>();

        RepositoryEnum (String by, String selector) {
            this.by = by;
            this.selector = selector;
        }

        public static String get (String name) {
            return Arrays.stream(RepositoryEnum.values()).filter(val -> val.name().equalsIgnoreCase(StringExtensions.removeWhiteSpaces(name))).findFirst().get().name();
        }

        public String by () {
            return by;
        }

        public String selector () {
            return selector;
        }

        public ArrayList<String> valuesOf () {
            elementValues.add(by());
            elementValues.add(selector());
            return elementValues;
        }
    }
}